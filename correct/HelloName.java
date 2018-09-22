package correct;

/**
 * @date unknown
 * @author Willem Mouwen <w.mouwen@student.tue.nl>
 */

import java.util.Scanner ;

public class HelloName {

    Scanner scanner ;
    String[] name ;

    public void doSomething() {
        scanner = new Scanner(System.in) ;

        name = new String[scanner.nextInt()] ;

        for (int n = 0 ; n < name.length ; n++) {
            name[n] = scanner.next() ;
        }

        for (int n = 0 ; n < name.length ; n++) {
            System.out.println("Hello " + name[n] + "!") ;
        }
    }

    public static void main(String[] args) {
        new HelloName().doSomething() ;
    }

}
