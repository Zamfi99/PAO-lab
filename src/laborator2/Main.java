package laborator2;

/**
 * Main class
 */
public class Main
{
    /**
     * main function
     */
    public static void main(String[] args)
    {
//         Problema 1
//        System.out.println(Problema1.run());

//        Problema 2
        Person p1 = new Person("ana", "are", 53285202, "mere", 18);
        Person p2 = new Person("ion", "are", 53231245, "pere", 19);
//        System.out.println(p1.showInfo());
//        System.out.println(p2.showInfo());
//        Problema3
        Room r1 = new Room("12A", "normal", 3);
        Room r2 = new Room("12B", "tech", 7);
//        System.out.println(r1.showInfo());
//        System.out.println(r2.showInfo());

//        Problema4
        Subject s1 = new Subject(r1, 10, p1);
        Subject s2 = new Subject(r2, 20, p2);
        System.out.println(s1.showInfo());
        System.out.println(s2.showInfo());

    }
}
