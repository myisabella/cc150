import java.awt.Rectangle;

public class NameInBox
{
	public static void main(String[] args)
	{
       //TODO add code to do the printing described above.
        String str = "Udacity";
        int len = str.length();
        
        StringBuilder sb = new StringBuilder();
        sb.append('+');
        
        for (int i = 0; i < len; i++) {
            sb.append('-');
        }
        
        sb.append('+');
        
        System.out.println(sb.toString());
        System.out.println('|' + str + '|');
        System.out.println(sb.toString());
        
        Rectangle box = new Rectangle(50, 100, 20, 30);
        Rectangle box2 = box;
        box2.translate(15, 25);
        System.out.println(box.getY());
        System.out.println(box2.getY());
        
        
        
        
	}
}