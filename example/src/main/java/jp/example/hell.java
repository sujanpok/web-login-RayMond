package jp.example;

/**
 * @author pokha
 *
 */
public class hell {
	public static void main(String[] arg) {
		String str = " 　list?item yuu can work　A,B\\tC-D ";

		String  finalReplaced = str.replaceAll("^[\\s　]", "xaok").replaceAll("[\\s　]+$", "xata").replaceAll("[,\t\\-]", ",");
		

		System.out.println(finalReplaced);
	}
}
