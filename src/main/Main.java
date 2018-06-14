package main;

import dados.Controller;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        System.out.println(controller.execute("..P...O.....").equals("001234321000"));
        System.out.println(controller.execute(".P....").equals("012345"));
        System.out.println(controller.execute("...P.P...P..").equals("000122222345"));
        System.out.println(controller.execute("P..O..").equals("123210"));
        System.out.println(controller.execute("P..P...PO...").equals("123333343210"));
        System.out.println(controller.execute("P...O.O.P...P..").equals("123432344444555"));
        System.out.println(controller.execute("P.....P.P..P...").equals("123455433332100"));

//        controller.execute("..P...O.....").equals("001234321000");
//        controller.execute(".P....").equals("012345");
//        controller.execute("...P.P...P..").equals("000122222345");
//        controller.execute("P..O..").equals("123210");
//        controller.execute("P..P...PO...").equals("123333343210");
//        controller.execute("P...O.O.P...P..").equals("123432344444555");
//        controller.execute("P.....P.P..P...").equals("123455433332100");
    }
}
