package tiy.gui;

public class HelloWorldAnonymousClasses {

    interface HelloWorld {
        public void greet();
        public void greetSomeone(String someone);
    }

    public void sayHello() {

        class EnglishGreeting implements HelloWorld {
            String name = "world";
            public void greet() {
                greetSomeone("world");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hello " + name);
            }
        }

        HelloWorld englishGreeting = new EnglishGreeting();
//
//        HelloWorld jibberishGreeting = new HelloWorld() {         //Anonymous Class I added;
//            String name = "Clay";
//            public void greet() {
//                greetSomeone("Clay");
//            }
//            public void greetSomeone(String someone){
//                name = someone;
//                System.out.println("Heybuindan, " +  name);
//            }
//        };

        HelloWorld frenchGreeting = new HelloWorld() {    //frenchGreeting = anonymous class; can't be re-used;
            String name = "tout le monde";
            public void greet() {                   //Shorter way to do something once; when another class is needed
                greetSomeone("tout le monde");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        };                               //anonymous classes are expression; thus, end with end-bracket and semi-colon

        HelloWorld spanishGreeting = new HelloWorld() {
            String name = "mundo";
            public void greet() {
                greetSomeone("mundo");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hola, " + name);
            }
        };
        englishGreeting.greet();
        frenchGreeting.greetSomeone("Clay");
        spanishGreeting.greet();
//        jibberishGreeting.greet();
    }

    public static void main(String... args) {
        HelloWorldAnonymousClasses myApp =
                new HelloWorldAnonymousClasses();
        myApp.sayHello();
    }
}
