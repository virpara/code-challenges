package diag2code.nodes;

public class XmlToGraphConverter {

    static Node case1() {
        // case 1
        Start s = new Start();

        Action a1 = new Action("Log1");
        s.next = a1;

        Action a2 = new Action("false condition");
        a1.next = a2;

        Action a3 = new Action("common");
        a2.next = a3;

        End e = new End();
        a3.next = e;

        return s;
    }

    static Node case2() {
        Start s = new Start();

        Action a = new Action("Log1");
        s.next = a;

        Condition c = new Condition("Condition1");
        a.next = c;

        Action f1 = new Action("false condition");
        c.falseNode = f1;

        Action f2 = new Action("false condition2");
        f1.next = f2;

        Action t1 = new Action("true condition");
        c.trueNode = t1;

        Action tf = new Action("common");

        t1.next = tf;
        f2.next = tf;

        End e = new End();
        tf.next = e;

        return s;
    }

    static Node case3() {
        Start s = new Start();

        Action a = new Action("Log1");
        s.next = a;

        Condition c = new Condition("Condition1");
        a.next = c;

        Action f1 = new Action("false condition1");
        c.falseNode = f1;

        Action t1 = new Action("true condition1");
        c.trueNode = t1;

        Condition c2 = new Condition("Condition2");

        t1.next = c2;

        Action f2 = new Action("false condition2");
        Action t2 = new Action("true condition2");

        c2.trueNode = t2;
        c2.falseNode = f2;

        Action mergeNode = new Action("all common");

        f1.next = t2.next = f2.next = mergeNode;

        Condition c3 = new Condition("condition3");
        mergeNode.next = c3;

        Action f3 = new Action("false condition3");
        Action t3 = new Action("true condition3");

        c3.falseNode = f3;
        c3.trueNode = t3;

        End e = new End();
        f3.next = e;
        t3.next = e;

        return s;
    }
}
