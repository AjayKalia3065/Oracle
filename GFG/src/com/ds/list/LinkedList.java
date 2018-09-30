package com.ds.list;
import com.ds.node.ListNode;


public class LinkedList<T> {
	ListNode<T> head = null;
	
	public void add(T s) {
		ListNode<T> temp = new ListNode<T>();
		temp.setNext(head);
		temp.setInfo(s);
		head = temp;
		
	}
	
	public T delete(int idx)
	{
		if(head == null)
		{
			return null;
		}
		ListNode<T> temp = head;
		if(idx == 1)
		{
			temp = head;
			head = head.getNext();
		}
		while(idx > 0 && temp.getNext() != null)
		{
			temp = temp.getNext();
			idx--;
		}
		if(idx == 0 )
			temp.setNext( temp.getNext());
		return null;
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer str= new StringBuffer();
		str.append("[");
		ListNode<T> temp = head;
		while(temp != null)
		{
			str.append(" ");
			str.append( temp.getInfo());
			str.append(" ");
			temp = temp.getNext();
			if(null != temp)
				str.append(",");
			else
				break;
		}
		str.append("]");
		return str.toString();
	}

	public LinkedList<T> reverse(){
		reverse(head,null);	
		return this;
	}

	private void reverse( ListNode<T> node, ListNode<T> last) {
		// TODO Auto-generated method stub
		if(null == node)
		{
			head = last;
			return ;
		}
		reverse(node.getNext(),node);
		node.setNext(last);
		
	}
	public LinkedList<? extends T> reverse(int k_pair){
		
		head = reverse(head,k_pair);
		
		return this;
	}

	private ListNode<T> reverse(ListNode<T> head2, int k_pair) {
		ListNode<T> curr,next,prev,first;
		curr = head;
		prev=null;
		next=null;
		boolean headset= false;
		while( curr!= null )
		{
			///if(headset)
				
			
			int i = 0;
			first= curr;
			for(;i<k_pair && null != curr ;i++)
			{
				next= curr.getNext();
				curr.setNext(prev);
				prev= curr;
				curr=next;
				
			}
			if(!headset)
				head=prev;
			else
			{
				first.setNext();
			}
			/*if(i==k_pair)
				head=curr;*/
		}
		
	}
}
