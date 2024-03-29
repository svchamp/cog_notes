import java.io.*;
public class HelloWorld {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		String[][] arr=new String[5][2];
		arr[0][0]="user1";
		arr[0][1]="pass1";
		arr[1][0]="user2";
		arr[1][1]="pass2";
		arr[2][0]="user3";
		arr[2][1]="pass3";
		arr[3][0]="user4";
		arr[3][1]="pass4";
		arr[4][0]="user5";
		arr[4][1]="pass5";
		String s=solve(arr,7,"user1","pass1");
		System.out.println(s);
	}
	static String solve(String[][] arr,int n,String user,String pass) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i][0].equals(user)) {
				if(arr[i][1].equals(pass)) {
					int res=pallin(n);
					return "Welcome "+user+" and the generated token is:token-"+res;
				}
			}
		}
		return "UserId or password is not valid,pls try again";
	}
	static int pallin(int n) {
		if(n==0)
				return 0;
		if(n==1)
			return 0;
		if(n==2)
			return 11;
		else {
			int x=1;
			for(int i=1;i<n-1;i++) {
				x=x*10;
			}
			String s=String.valueOf(x);
			s=s+"1";
			return Integer.parseInt(s);
		}
	}

}
