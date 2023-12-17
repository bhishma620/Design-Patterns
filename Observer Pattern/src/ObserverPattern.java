import java.util.ArrayList;

interface  Observer{
    void update(float temparature);
}

interface Subject {
    void register(Observer ob);
    void unregister(Observer ob);
    void notifyAllObserver();
}



class WeatherStation implements  Subject{
private ArrayList allObserver;
private  float temparature;

WeatherStation(){
    allObserver=new ArrayList();
}

    @Override
    public void register(Observer ob) {
      allObserver.add(ob);
    }

    @Override
    public void unregister(Observer ob) {
      allObserver.remove(ob);
    }

    @Override
    public void notifyAllObserver( ) {
           for(int i=0;i<allObserver.size();i++){
                   Observer obs=(Observer)allObserver.get(i);
                   obs.update(temparature);
                }
    }

 void updateChanged(){
    notifyAllObserver();
 }

 void setTemparature(float temparature){
    this.temparature=temparature;
     updateChanged();
 }

}

class PhoneDisplay implements Observer{
    private float temparature;
    private Subject station;
    PhoneDisplay(Subject station){
      this.station=station;
      station.register(this);
    }

    public  void update(float temparature){
       this.temparature=temparature;
       display();
    }
void display(){
    System.out.println("IN PHONE DISPLAY TEMPARATURE: " + this.temparature);
}

}



class  WindowDisplay implements  Observer{
    private Subject station;
    private float temparature;
    WindowDisplay(Subject station){
        this.station=station;
        station.register(this);
    }

    public  void update(float temparature){
        this.temparature=temparature;
        display();
    }
    void display(){
        System.out.println("IN WINDOW DISPLAY TEMPARATURE: " + this.temparature);
    }
}


public class ObserverPattern {
    public static void main(String[] args) {

        WeatherStation station=new WeatherStation();

        PhoneDisplay ph1=new PhoneDisplay(station);
        WindowDisplay wd=new WindowDisplay(station);
        station.setTemparature(36.7f);

        //unregister the PhoneDisplay1
        station.unregister(ph1);

        System.out.println("\nAfter removing Phone Display:\n");

        //calling updated display
        station.updateChanged();

        //update temparature
        station.setTemparature(43.3f);


    }
}
