package test01;

import java.util.ArrayList;
import java.util.List;

public class Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list=new ArrayList<>();
		list.add(7);
		list.add(3);
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(13);
		list.add(8);
		System.out.println(list);
		List<Integer> sorted=new ArrayList<>();
		while(list.size()>0) {
			int smallest=0;
			for(int i=1;i<list.size();i++) {
				if(list.get(i)<list.get(smallest)) {
					smallest=i;
				}
			}
			sorted.add(list.get(smallest));
			list.remove(smallest);
		}
		System.out.println(sorted);
	}

}
