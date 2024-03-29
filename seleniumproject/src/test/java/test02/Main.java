package test02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String sentence=sc.nextLine();
		String word=sc.nextLine();
		System.out.println(UserMainCode.countWords(sentence, word));
	}

}
