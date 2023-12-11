package main.quack_behaviour;

public class SimpleQuack implements QuackBehaviour {

    @Override
    public void quack() {
        System.out.println("Simple Quack");
    }
}
