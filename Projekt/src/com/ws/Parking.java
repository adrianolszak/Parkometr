package com.ws;

import java.lang.*;
import javax.jws.WebService;

import com.soa.hibernate.ParkingService;
import com.ws.ParkingI;
import com.soa.ejb.*;

@WebService(endpointInterface = "com.ws.ParkingI")
public class Parking implements ParkingI{
	TimerServiceDemo timerServiceDemo = new TimerServiceDemo();
	
	public boolean zajmijMiejsce (int miejsce){
		long przyjazd = System.currentTimeMillis();		
		int seconds = (int) (przyjazd / 1000) % 60 ;
		int minutes = (int) ((przyjazd / (1000*60)) % 60);
		int hours   = (int) ((przyjazd / (1000*60*60)) % 24);
		return timerServiceDemo.zajmijMiejsce(miejsce,hours + ":" + minutes + ":" + seconds);
	}
	

	public boolean zwolnijMiejsce (int miejsce){
		ParkingService service = new ParkingService();
		return service.update(miejsce,null);
	}
}