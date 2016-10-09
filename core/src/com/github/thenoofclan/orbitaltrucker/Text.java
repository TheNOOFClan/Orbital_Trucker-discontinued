package com.github.thenoofclan.orbitaltrucker;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Text
{
    private Sprite[] sprites;

    private HashMap<Character, Texture> textures = new HashMap<Character, Texture>();

    public Text(int x, int y, String text, Color color)
    {
        init("font/");
        sprites = new Sprite[text.length()];
        String tmpText = text.toLowerCase();
        for (int i = 0; i < text.length(); i++)
        {
            char c = tmpText.charAt(i);
            Sprite s = new Sprite(textures.get(c), 8, 8);
            s.setX(x + 8 * i);
            s.setY(y);
            s.setColor(color);
            sprites[i] = s;
        }
    }

    public void render(SpriteBatch batch)
    {
        for (Sprite s : sprites)
        {
            s.draw(batch);
        }
    }

    public void init(String fontDir)
    {
        for (char c = '0'; c <= '9'; c++)
        {
            Texture tmp = new Texture(Gdx.files.internal(fontDir + c + ".png"));
            textures.put(c, tmp);
        }
        for (char c = 'a'; c <= 'z'; c++)
        {
            Texture tmp = new Texture(Gdx.files.internal(fontDir + c + ".png"));
            textures.put(c, tmp);
        }
        textures.put(' ', new Texture(Gdx.files.internal(fontDir + "space.png")));
        textures.put('$', new Texture(Gdx.files.internal(fontDir + "currency" + ".png")));
        textures.put(':', new Texture(Gdx.files.internal(fontDir + "colon" + ".png")));
        textures.put('.', new Texture(Gdx.files.internal(fontDir + "period" + ".png")));
        textures.put('-', new Texture(Gdx.files.internal(fontDir + "dash" + ".png")));
    }
}
