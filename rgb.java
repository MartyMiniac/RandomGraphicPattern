import java.io.*;
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO; 
  
public class rgb
{ 
    int width = 1920;
    int height = 1080; 
    BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 
    File f = null; 
    int rgbval[][] = new int[width][height];
    public void process() 
    { 
        int r=(int)(Math.random()*256),g=(int)(Math.random()*256),b=(int)(Math.random()*256);
        int sing[][] = new int[width][3];
        int ri=1, bi=1, gi=1;
        for (int x = 0; x < width; x++) 
        { 
            int rand=(int)(Math.random()*3);
            if(r>=254)
            {
                ri=-1;
            }
            else if(r<=1)
            {
                ri=1;
            }
            if(g>=254)
            {
                gi=-1;
            }
            else if(g<=1)
            {
                gi=1;
            }
            if(b>=254)
            {
                bi=-1;
            }
            else if(b<=1)
            {
                bi=1;
            }
            switch(rand)
            {
                case 0:
                r=r+ri;
                break;
                case 1:
                b=b+bi;
                break;
                case 2:
                g=g+gi;
                break;
            }
            sing[x][0]=r;
            sing[x][1]=g;
            sing[x][2]=b;
            rgbval[x][0]=getrgb(r,g,b);
        } 
        ri=1;
        bi=1;
        gi=1;
        for (int x = 1; x < width; x++) 
        { 
            r=sing[x][0];
            g=sing[x][1];
            b=sing[x][2];
            for (int y = 0; y < height; y++) 
            {
                int rand=(int)(Math.random()*3);
                if(r>=254)
                {
                    ri=-1;
                }
                else if(r<=1)
                {
                    ri=1;
                }
                if(g>=254)
                {
                    gi=-1;
                }
                else if(g<=1)
                {
                    gi=1;
                }
                if(b>=254)
                {
                    bi=-1;
                }
                else if(b<=1)
                {
                    bi=1;
                }
                switch(rand)
                {
                    case 0:
                    r=r+ri;
                    break;
                    case 1:
                    b=b+bi;
                    break;
                    case 2:
                    g=g+gi;
                    break;
                }
                rgbval[x][y]=getrgb(r,g,b);
            } 
        }
    }
    public int getrgb(int r, int b, int g)
    {
        int p = (0<<24) | (r<<16) | (g<<8) | b; 
        return p;
    }
    public void convert()
    {
        for (int y = 0; y < height; y++) 
        { 
            for (int x = 0; x < width; x++) 
            { 
                int p = rgbval[x][y];
                img.setRGB(x, y, p); 
            } 
        }
    }
    public void writeout()
    {
        try
        { 
            f = new File("D:\\Out.png"); 
            ImageIO.write(img, "png", f); 
        } 
        catch(IOException e) 
        { 
            System.out.println(e); 
        } 
    }
    public static void main(String[] arsg)
    {
        rgb ob = new rgb();
        ob.process();
        ob.convert();
        ob.writeout();
    }
} 
