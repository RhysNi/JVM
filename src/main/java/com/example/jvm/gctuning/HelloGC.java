
import java.util.LinkedList;
import java.util.List;

/**
 * @author Rhys.Ni
 * @version 1.0
 * @date 2021/10/20 12:48 上午
 * @Description
 */
public class HelloGC {
     public static void main(String[] args) {
        System.out.println("HelloGC!");
        List list = new LinkedList();
        for(;;) {
            byte[] b = new byte[1024*1024];
            list.add(b);
        }
    }
}
