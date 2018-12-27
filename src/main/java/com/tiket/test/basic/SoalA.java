package com.tiket.test.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tiket.test.basic.model.InputType;
import com.tiket.test.basic.model.Mahasiswa;

public class SoalA {
	private static Integer jumlahMahasiswa;
	private static List<Mahasiswa> listMahasiswa = new ArrayList<Mahasiswa>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		inputJumlahMahasiswa();
		inputMahasiswa();
		kalkulasi();
	}

	/**
	 * Input Jumlah mahasiswa
	 */
	private static void inputJumlahMahasiswa() {
		jumlahMahasiswa = (Integer)inputValue("Jumlah Mahasiswa", InputType.INTEGER);
	}
	
	/**
	 * Input mahasiswa & kalkulasi
	 */
	private static void inputMahasiswa() {
		for(int i=1; i<=jumlahMahasiswa; i++) {
			System.out.println("\nMahasiswa "+i+":");
			System.out.println("---------------------------------");
			Mahasiswa mhs =  new Mahasiswa();
			mhs.setNim((String)inputValue("Masukan NIM", InputType.STRING));
			mhs.setNama((String)inputValue("Masukan Nama", InputType.STRING));
			mhs.setKehadiran((Float)inputValue("Masukan Nilai Kehadiran", InputType.FLOAT));
			mhs.setMidtest((Float)inputValue("Masukan Nilai MidTest", InputType.FLOAT));
			mhs.setUas((Float)inputValue("Masukan Nilai UAS", InputType.FLOAT));
			listMahasiswa.add(mhs);	
		}
	}
	
	private static void kalkulasi() {
		System.out.println("\nNo. NIM Nama Nilai Akhir Grade ");
		System.out.println("===========================================");
		int no = 1;
		int lulus = 0;
		for(Mahasiswa mhs: listMahasiswa) {
			float nilaiAkhir = (float) ((0.2 * mhs.getKehadiran()) + (0.4 * mhs.getMidtest()) + (0.4 * mhs.getUas()));
			String grade = "E";
			if(nilaiAkhir >= 85) {grade = "A";}
			else if(nilaiAkhir >= 76 && nilaiAkhir <= 84) { grade = "B";}
			else if(nilaiAkhir >= 61 && nilaiAkhir <= 75) { grade = "C";}
			else if(nilaiAkhir >= 46 && nilaiAkhir <= 60) { grade = "D";}
			else if(nilaiAkhir >= 0 && nilaiAkhir <= 45) { grade = "E";}
			
			if(grade.equals("A") || grade.equals("B") || grade.equals("C")){
				lulus++;
			}

			mhs.setGrade(grade);
			mhs.setNilaiAkhir(nilaiAkhir);
			System.out.println(mhs.printNilaiAkhir(no));
			no++;
		}
		System.out.println("===========================================");
		System.out.println("Jumlah Mahasiswa : "+listMahasiswa.size()+" (berdasarkan hasil kalkulasi) ");
		System.out.println("Jumlah Mahasiswa yg Lulus : "+lulus+" (berdasarkan hasil kalkulasi) ");
		System.out.println("Jumlah Mahasiswa yg Tidak Lulus : "+(listMahasiswa.size() - lulus)+" (berdasarkan hasil kalkulasi)");
		System.out.println("===========================================");
	}
	
	/**
	 * @param title
	 * @param inputType
	 * @return
	 */
	private static Object inputValue(String title, InputType inputType) {
		System.out.print(title+": ");
		String input = new Scanner(System.in).nextLine();
		switch(inputType){
			case STRING:
				if(input != null && input.length() > 0) {return input;}
				break;
			case FLOAT:
				try {
					Float val = Float.parseFloat(input);
					if(val > -1 && val <= 100) {return val;}
					else {System.out.println("[ERROR] nilai harus >= 0 dan <=100");}
				}catch (Exception e){
					System.out.println("[ERROR] "+title+" harus angka!");
				}
				
				break;
			case INTEGER:
				try {
					return Integer.parseInt(input);
				}catch (Exception e){
					System.out.println("[ERROR] "+title+" harus angka!");
				}
				break;
		}
		
		return inputValue(title, inputType);
	}

}
