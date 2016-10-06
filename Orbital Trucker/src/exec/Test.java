package exec;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import obj.Ship;

public class Test
{

    private int scale = 1;

    private Ship ship;

    public void start()
    {
        initGL(160 * scale, 144 * scale);
        ship = new Ship("truck/");
        Ship.scale = scale;

        while (true)
        {
            ship.update();
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
            render();

            Display.update();
            Display.sync(60);

            if (Display.isCloseRequested())
            {
                Display.destroy();
                System.exit(0);
            }
        }
    }

    /**
     * Initialise the GL display
     * 
     * @param width
     *            The width of the display
     * @param height
     *            The height of the display
     */
    private void initGL(int width, int height)
    {
        try
        {
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.create();
            Display.setVSyncEnabled(true);
        } catch (LWJGLException e)
        {
            e.printStackTrace();
            System.exit(0);
        }

        GL11.glEnable(GL11.GL_TEXTURE_2D);

        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

        // enable alpha blending
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        GL11.glViewport(0, 0, width, height);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);

        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, width, height, 0, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
    }

    /**
     * draw a quad with the image on it
     */
    public void render()
    {
        ship.render();
    }

    /**
     * Main Class
     */
    public static void main(String[] argv)
    {
        Test textureExample = new Test();
        textureExample.start();

    }
}