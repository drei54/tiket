package com.tiket.test.basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SoalB {
	private static String input = "Saya sedang Belajar Bahasa PemOgraman JAVA.";
	private static String input2 = "Saya sedang Belajar Bahasa PemOgraman JAVA.";
	private static String input3 = "Developer PT. Global Tiket Network";
	private static String input4 = "Since 1995, Java has changed our world . . . and our expectations.. Today, with technology such a part of our daily lives, we take it for granted that we can be connected and access applications and content anywhere, anytime. Because of Java, we expect digital devices to be smarter, more functional, and way more entertaining. In the early 90s, extending the power of network computing to the activities of everyday life was a radical vision. In 1991, a small group of Sun engineers called the Green Team believed that the next wave in computing was the union of digital consumer devices and computers. Led by James Gosling, the team worked around the clock and created the programming language that would revolutionize our world – Java. The Green Team demonstrated their new language with an interactive, handheld home-entertainment controller that was originally targeted at the digital cable television industry. Unfortunately, the concept was much too advanced for the them at the time. But it was just right for the Internet, which was just starting to take off. In 1995, the team announced that the Netscape Navigator Internet browser would incorporate Java technology. Today, Java not only permeates the Internet, but also is the invisible force behind many of the applications and devices that power our day-to-day lives. From mobile phones to handheld devices, games and navigation systems to e-business solutions, Java is everywhere!";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lowerToUpperAndUpperToLower();
		removeVocalChars();
		uniqueString();
		statistik();
	}
	
	private static void lowerToUpperAndUpperToLower(){
		System.out.println("Input data: "+ input);
		StringBuffer sb = new StringBuffer(input);
		
		for (int i=0; i<sb.length(); i++){ 
			Character c = input.charAt(i); 
			if (Character.isLowerCase(c)) 
				sb.replace(i, i+1, Character.toUpperCase(c)+""); 
			else
				sb.replace(i, i+1, Character.toLowerCase(c)+"");
		}
		System.out.println("Output: "+ sb.toString());
    }
	
	private static void removeVocalChars() {
		System.out.println("\nInput data: "+input2);
		String output = input2.replaceAll("[AEIOUaeiou]", "");
		System.out.println("Output: "+ output);
	}
	
	private static void uniqueString() {
		System.out.println("\nInput data: "+ input3);
		input3 = input3.replace(" ", "");
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		for (int i=0; i<input3.length(); i++){ 
			Character c = input3.charAt(i); 
			Integer val = map.get(c.toString());
			val = (val == null) ? 1 : val + 1; 
			map.put(c.toString(), val);
		}

		System.out.print("Output: ");
		for (Entry<String, Integer> entry : map.entrySet()) {
			String cnt = (entry.getValue() > 1) ? entry.getValue()+"" : "";
		    System.out.print(entry.getKey()+cnt);
		}
	    System.out.println();
	}
	
	private static void statistik() {
		System.out.println("\nInput data: "+input4);
		System.out.println("Jumlah kata: "+Arrays.stream(input4.split(" ")).count());
		
		Map<String, Integer> words = Arrays.stream(input4.split(" ")).collect(Collectors.toConcurrentMap(w -> w, w -> 1, Integer::sum));
	    System.out.println("Jumlah kemunculan tiap kata: "+words);
	    
	    System.out.print("Jumlah kata yang hanya muncuil 1 kali: ");
	    words.entrySet().stream()
				.filter(o -> o.getValue() == 1)
				.forEach(m -> System.out.print(m.getKey()+", "));
	    
	    Integer max = words.values().stream().max(Comparator.naturalOrder()).get();
	    System.out.print("\nJumlah kata yang paling banyak muncul: ("+max+") ");
	    words.entrySet().stream()
				.filter(o -> o.getValue() == max)
				.forEach(m -> System.out.print(m.getKey()+" "));
	    
	    Integer min = words.values().stream().min(Comparator.naturalOrder()).get();
	    System.out.print("\nJumlah kata yang paling sedikit muncul: ("+min+") ");
	    words.entrySet().stream()
				.filter(o -> o.getValue() == min)
				.forEach(m -> System.out.print(m.getKey()+", "));

	    
	}
}
