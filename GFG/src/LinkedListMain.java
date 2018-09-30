import com.ds.list.LinkedList;


public class LinkedListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list= new LinkedList<>();
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println(list);
		list.reverse(2);
		System.out.println(list);
		

	}

}
