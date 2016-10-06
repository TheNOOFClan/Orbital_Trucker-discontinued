package obj;

import java.io.IOException;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Ship
{
    private static final int MAX_MOVE_TIMEOUT = 0;
    private static final int MAX_TURN_TIMEOUT = 30;

    private Texture[] textures = new Texture[8];

    private float x;
    private float y;

    private int move_timeout;
    private int turn_timeout;

    public static int scale;

    private int dir;

    public Ship(String texture_dir)
    {
        try
        {
            for (int i = 0; i < 8; i++)
            {
                textures[i] = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/" + texture_dir + Integer.toString(i) + ".png"));
            }
        } catch (IOException e)
        {
            e.printStackTrace();
            Display.destroy();
            System.exit(1);
        }

        x = 0;
        y = 0;
        dir = 0;
        move_timeout = 0;
        turn_timeout = 0;
    }

    public void render()
    {
        Color.white.bind();
        textures[dir].bind(); // or GL11.glBind(texture.getTextureID());

        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex2f((int) (x * scale), (int) (y * scale));
        GL11.glTexCoord2f(1, 0);
        GL11.glVertex2f((int) ((x + textures[dir].getTextureWidth()) * scale), (int) (y * scale));
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex2f((int) ((x + textures[dir].getTextureWidth()) * scale), (int) ((y + textures[dir].getTextureHeight()) * scale));
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex2f((int) (x * scale), (int) ((y + textures[dir].getTextureHeight()) * scale));
        GL11.glEnd();
    }

    public void update()
    {

        if (move_timeout > 0)
            move_timeout--;

        if (turn_timeout > 0)
            turn_timeout--;
        if (Keyboard.isKeyDown(Keyboard.KEY_LEFT) && turn_timeout == 0)
        {
            dir = (dir + 7) % 8;
            turn_timeout = MAX_TURN_TIMEOUT;
        } else
            if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT) && turn_timeout == 0)
            {
                dir = (dir + 1) % 8;
                turn_timeout = MAX_TURN_TIMEOUT;
            }
        if (Keyboard.isKeyDown(Keyboard.KEY_UP) && move_timeout == 0)
        {
            x += Math.cos(dir * Math.PI / 4);
            y += Math.sin(dir * Math.PI / 4);
            move_timeout = MAX_MOVE_TIMEOUT;
        }

    }

}
