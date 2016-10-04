package exec;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Test
{

    public void start()
    {
        try
        {
            Display.setDisplayMode(new DisplayMode(160, 144));
            Display.create();
        } catch (LWJGLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }

        while (!Display.isCloseRequested())
        {
            Display.update();
        }

        Display.destroy();
    }

    public static void main(String[] args)
    {
        Test test = new Test();
        test.start();
    }

}
