package principle.inversion;

/**
 * 依赖倒转原则
 *
 * @author Chenyang
 * @create 2021-07-14-16:43
 */
public class DependencyInversion {
    public static void main(String[] args) {
        Function reporter = new Reporter();
        Function publisher = new Publisher();
        reporter.receive(new Email());
        publisher.receive(new MSN());
    }
}

interface Function {
    void receive(IReceiver receiver);
}

class Reporter implements Function {
    @Override
    public void receive(IReceiver receiver) {
        System.out.println(receiver.getInfo());
    }
}

class Publisher implements Function {
    @Override
    public void receive(IReceiver receiver) {
        System.out.println(receiver.getInfo());
    }
}

interface IReceiver {
    String getInfo();
}

class Email implements IReceiver {
    @Override
    public String getInfo() {
        return "email message: hello world";
    }
}

class MSN implements IReceiver {
    @Override
    public String getInfo() {
        return "MSN message: hello world";
    }
}