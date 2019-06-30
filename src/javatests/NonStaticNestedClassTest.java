package javatests;

public class NonStaticNestedClassTest {

    public static void main(String[] args) {

        class LocalClass {
            public void myMethod() {
                System.out.println("LocalClass.myMethod");
            }

            private void privateMethod() {
                System.out.println("LocalClass.privateMethod");
            }
        }

        LocalClass l = new LocalClass();
        l.myMethod();

        // private method of a local class can be called using object
        l.privateMethod();

        // call to static method of nested static class
        StaticClass.methodStatic();

        StaticClass s = new StaticClass();
        s.method();

        NonStaticNestedClassTest test = new NonStaticNestedClassTest();
        NonStaticClass c = test.getNonStaticClassObj();
        c.method();

        c = test.new NonStaticClass();
        c.method();

    }

    class NonStaticClass {
        public void method() {
            System.out.println("NonStaticClass.method");
        }

//        Not allowed in non-static nested class
//        public static void methodStatic() {
//            System.out.println("NonStaticClass.methodStatic");
//        }
    }

    public NonStaticClass getNonStaticClassObj() {
        System.out.println("NonStaticNestedClassTest.getNonStaticClassObj");
        return new NonStaticClass();
    }

    static class StaticClass {
        public void method() {
            System.out.println("StaticClass.method");
        }

        public static void methodStatic() {
            System.out.println("StaticClass.methodStatic");
        }
    }
}
