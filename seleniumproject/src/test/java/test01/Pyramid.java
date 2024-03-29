package test01;

import java.util.Scanner;

public class Pyramid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		sc.close();
		char c='a';
		if( !(n>0 && n<=26) ) {
			System.out.println("Wrong input. Please try again");
			return;
			
		}
		
		int count=0;
		for(int i=n-1;i>=0;i--) {
			//leave space before using count
			for(int t=0;t<count;t++) {
				System.out.print("\t");
			}
			//Print characters
			for(int j=0;j<i;j++) {
				char x=(char) (c+j);
				System.out.print("\t"+x+"\t");
			}
			//leave space after leaving count- Not necessary
			for(int t=0;t<count;t++) {
				System.out.print("\t");
			}
			//new line
			System.out.println();
			count++;
		}
	}

}
