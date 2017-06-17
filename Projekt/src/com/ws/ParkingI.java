package com.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ParkingI {

	@WebMethod
	boolean zajmijMiejsce (int miejsce );
	@WebMethod
	boolean zwolnijMiejsce (int miejsce );
}
