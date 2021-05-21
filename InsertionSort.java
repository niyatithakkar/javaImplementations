package chapter3;

import chapter3.Position.PositionalList;

public class InsertionSort {
	public static void InsertionSort(PositionalList<Integer> list) {
		Position<Integer> marker = list.first();
		while(marker!=list.last()) {
			Position<Integer> pivot = list.after(pivot);
			int value = pivot.getElement();
			if(value>marker.getElement()) marker =pivot;
			else {
				Position<Integer> walk = marker;
				while(walk!=list.first() && list.before(walk).getElement()>value) {
					walk=list.before(walk);
				}
				list.remove(pivot);
				list.addBefore(walk, value);
			}
		}
	}
	public static void main(String[] args) {
		PositionalList<Integer> list =  new LinkedPositionalList<>();	
		list.addFirst(23);
		list.addFirst(2);
		list.addFirst(3);
		list.addFirst(16);
		list.addFirst(67);
		list.addFirst(93);
		list.addFirst(51);
		list.addFirst(90);
		list.addFirst(41);
		list.addFirst(89);
		list.addFirst(72);
		InsertionSort(list);
		for(Position<Integer> a: list) {
			System.out.println(a.getElement()+" ");
		}
	}
}
