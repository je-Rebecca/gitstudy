package com.koreait.spring;
import java.util.Iterator;	import java.util.Set;
public class SetHandler {
//Field(property) 
	private Set<String> mySet;
//Constructor 
	public SetHandler() {}
//Method 
	public void setInfo() {
		Iterator<String> itr = mySet.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	public Set<String> getMySet() {
		return mySet;
	}
	public void setMySet(Set<String> mySet) {
		this.mySet = mySet;
	}

}
