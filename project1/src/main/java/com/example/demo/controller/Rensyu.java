package com.example.demo.controller;

public class Rensyu {
	public static void main(String[] args) {
		String str =" １行目\n２行目\n３行目gdfgd fdgfdg"
				+ "dfgdfg fg df"
				+ "gd f"
				+ "fgdfgdfgdf";
		String replaced1 = str.replaceAll("\r\n", "<br   />");
		System.out.println(replaced1); // → Txx xxxxx xxxxx xxx xxxxx xxxx xxx xxxx xxx. 1234567890
	}
}
