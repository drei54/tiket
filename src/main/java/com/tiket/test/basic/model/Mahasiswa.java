package com.tiket.test.basic.model;

import java.io.Serializable;

public class Mahasiswa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nama;
	private String nim;
	private Float midtest;
	private Float uas;
	private Float kehadiran;
	private Float nilaiAkhir;
	private String grade;
	
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getNim() {
		return nim;
	}
	public void setNim(String nim) {
		this.nim = nim;
	}
	public Float getMidtest() {
		return midtest;
	}
	public void setMidtest(Float midtest) {
		this.midtest = midtest;
	}
	public Float getUas() {
		return uas;
	}
	public void setUas(Float uas) {
		this.uas = uas;
	}
	public Float getKehadiran() {
		return kehadiran;
	}
	public void setKehadiran(Float kehadiran) {
		this.kehadiran = kehadiran;
	}
	public Float getNilaiAkhir() {
		return nilaiAkhir;
	}
	public void setNilaiAkhir(Float nilaiAkhir) {
		this.nilaiAkhir = nilaiAkhir;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Mahasiswa [nama=" + nama + ", nim=" + nim + ", midtest=" + midtest + ", uas=" + uas + ", kehadiran="
				+ kehadiran + ", nilaiAkhir=" + nilaiAkhir + ", grade=" + grade + "]";
	}
	
	public String printNilaiAkhir(int no) {
		return no+". "+nim+" "+nama+" "+nilaiAkhir+" "+grade;
	}
	
	
}
