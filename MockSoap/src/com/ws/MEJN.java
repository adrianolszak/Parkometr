package com.ws;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

import com.ws.ParkingI;

//Endpoint publisher
public class MEJN{

	public static void main(String[] args) throws MalformedURLException {

		URL url = new URL("http://localhost:8080/Projekt/Parking?wsdl");

        QName qname = new QName("http://ws.com/", "ParkingService");

        Service service = Service.create(url, qname);

        ParkingI hello = service.getPort(ParkingI.class);    
        int metoda,miejsce;
        Scanner odczyt = new Scanner(System.in); 	
        while(true){
        	System.out.println("Jaka metode chcesz uzyc: 1 zajmij miejsce, 2 zwolnij miejsce");
		      System.out.println("Wprowadz numer metody ktorej chcesz uzyc");
		      metoda = Integer.parseInt(odczyt.nextLine());
        	switch (metoda) {
            case 1:  
            System.out.println("Wprowadz numer miejsca ktore chcesz zajac");
            miejsce = Integer.parseInt(odczyt.nextLine());
            hello.zajmijMiejsce(miejsce);
                     break;
            case 2: 
                System.out.println("Wprowadz numer miejsca ktore chcesz zwolnic");
                miejsce = Integer.parseInt(odczyt.nextLine());
            	hello.zwolnijMiejsce(miejsce);
                     break;}
        }
    }
}