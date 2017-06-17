package com.soa.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "bilets")
@Entity
@Table(name = "bilet")
public class Bilet {
	long id_biletu;
	int nr_parkometru;
	String godzina;
	String stan;
	public Bilet(){}
	public Bilet(	long id_biletu,int nr_parkometru,String godzina,String stan){
		this.id_biletu = id_biletu;
		this.nr_parkometru = nr_parkometru;
		this.godzina = godzina;
		this.stan = stan;
		}

@Id
@Column(name = "id_biletu")
@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId_biletu() {
		return id_biletu;
	}
@XmlElement
	public void setId_biletu(long id_biletu) {
		this.id_biletu = id_biletu;
	}
	public int getNr_parkometru() {
		return nr_parkometru;
	}
	@XmlElement
	public void setNr_parkometru(int nr_parkometru) {
		this.nr_parkometru = nr_parkometru;
	}
	public String getGodzina() {
		return godzina;
	}
	@XmlElement
	public void setGodzina(String godzina) {
		this.godzina = godzina;
	}
	public String getStan() {
		return stan;
	}
	@XmlElement
	public void setStan(String stan) {
		this.stan = stan;
	}

}
