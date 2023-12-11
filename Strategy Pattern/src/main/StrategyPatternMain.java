package main;

import main.fly_behaviour.*;

import main.quack_behaviour.*;


class  Duck{

   private FlyBehaviour flyBehaviour;
    private QuackBehaviour quackBehaviour;

    public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
        this.flyBehaviour = flyBehaviour;
    }

    public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
        this.quackBehaviour = quackBehaviour;
    }



   void makeQuack(){
        quackBehaviour.quack();
    }

void makefly(){
        flyBehaviour.fly();
    }
}


class VillageDuck extends Duck{
    VillageDuck(){
    setFlyBehaviour(new FlyWithWings());
    setQuackBehaviour(new SimpleQuack());
    }

}

class WildDucks extends Duck{
    WildDucks(){
        setFlyBehaviour(new FlyWithWings());
        setQuackBehaviour(new DoubleQuack());
    }
}

class RoboDucks extends Duck{
    RoboDucks(){
        setFlyBehaviour(new FlywithJet());
        setQuackBehaviour(new Silence());
    }
}


public class StrategyPatternMain {

    public static void main(String[] args) {

        Duck village=new VillageDuck();
        village.makeQuack();
        village.makefly();

//we can change the behaviour later
        village.setFlyBehaviour(new FlyNoWays());
        village.setQuackBehaviour(new Silence());
        village.makeQuack();
        village.makefly();

        WildDucks wild=new WildDucks();
        wild.makeQuack();
        wild.makefly();


        RoboDucks robo=new RoboDucks();
        robo.makefly();
        robo.makeQuack();


    }
}
