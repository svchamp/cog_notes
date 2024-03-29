package test02;

public class UserMainCode {

	static int countWords(String a,String b) {
		int count=0;
		String[] x=a.split(" ");
		for(String y:x) {
			if(y.equals(b))
				count++;
		}
		return count;
	}

}
