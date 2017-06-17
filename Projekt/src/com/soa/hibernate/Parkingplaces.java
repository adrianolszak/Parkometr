package com.soa.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parkingplaces")
public class Parkingplaces {
	long id_miejsca;
	int nr_miejsca;
	String strefa;
	String ulica;
	String przyjazd;
	
	@Id
	@Column(name = "id_miejsca")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId_miejsca() {
		return id_miejsca;
	}
	public void setId_miejsca(long id_miejsca) {
		this.id_miejsca = id_miejsca;
	}
	public int getNr_miejsca() {
		return nr_miejsca;
	}
	public void setNr_miejsca(int nr_miejsca) {
		this.nr_miejsca = nr_miejsca;
	}
	public String getStrefa() {
		return strefa;
	}
	public void setStrefa(String strefa) {
		this.strefa = strefa;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public String getPrzyjazd() {
		return przyjazd;
	}
	public void setPrzyjazd(String przyjazd) {
		this.przyjazd = przyjazd;
	}
}
