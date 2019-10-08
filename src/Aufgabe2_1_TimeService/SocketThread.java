package Aufgabe2_1_TimeService;

public class SocketThread extends Thread{

    TimeService timeService;

    public SocketThread(TimeService timeService) {
        this.timeService = timeService;
    }

    public void run(){

        timeService.timeServiceAPI();
    }
}
