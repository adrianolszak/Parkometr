package com.soa.ejb;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

import com.soa.hibernate.ParkingService;

@Singleton
@Local
@Startup
public class TimerServiceDemo {

    @Resource
    private TimerService timerService;
	ParkingService parkingService = new ParkingService();
	Timer timer;
	
    @Lock(LockType.WRITE)
    public boolean zajmijMiejsce(int nr_miejsca,String przyjazd) {     	
        //timer = timerService.createSingleActionTimer(2000, new TimerConfig());      
        return parkingService.update(nr_miejsca, przyjazd);
    }
    
    @Timeout
    public void brakBiletu(Timer timer) {
        timer.cancel();
    }
    
    @Lock(LockType.WRITE)
    public String checkTimerStatus() {
        Timer timer = null;
        Collection<Timer> timers = timerService.getTimers();
        Iterator<Timer> iterator = timers.iterator();
        while (iterator.hasNext()) {
            timer = iterator.next();
            return ("Timer will expire after " + 
                timer.getTimeRemaining() + " milliseconds.");
        }
        return ("No timer found");
    }
    public void stopAll() {
    for(Object obj : timerService.getTimers()) {
        Timer t = (Timer)obj;
        t.cancel();
    }
}

}