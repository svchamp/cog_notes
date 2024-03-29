package RishQuali;

import java.util.*;
import java.util.stream.*;
public class ElectricityBoardMain {
	private Map<String,String> electricityMap;
	public Map<String, String> getElectricityMap() {
		return electricityMap;
	}
	public void setElectricityMap(Map<String, String> electricityMap) {
		this.electricityMap = electricityMap;
	}
	public int findCountOfConnectionsBasedOnTheConnectionType(String connectionType) {
		int count=electricityMap.entrySet().stream()
											.filter(e->e.getValue().equalsIgnoreCase(connectionType))
											.map(x->1)
											.reduce(0,(res,e)->res+e);
		if(count==0)
			return -1;
		return count;
	}
	public List<String> findConnectionIdsBasedOnTheConnectionType(String connectionType){
		try {
			List<String> res=electricityMap.entrySet().stream()
													.filter(e->e.getValue().equalsIgnoreCase(connectionType))
													.map(x->x.getKey())
													.collect(Collectors.toList());
			return res;
		}catch(Exception e) {
			return null;
		}	
	}
}
