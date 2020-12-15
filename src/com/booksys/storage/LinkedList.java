/** 
* @File LinkedList.java
* @Author Aurora_JC
* @Time 2020��12��14�� ����10:55:31 
* @Version 1.0
* <p>Description:</p>
*/

package com.booksys.storage; 

public class LinkedList {
	private Node head;
	
	public void addNode(Node n) {
		if (head == null) {
			head = n;
			return ;
		}
		
		Node tmp = head;
		while(tmp.getNextNode() != null) {
			tmp = tmp.getNextNode();
		}
		tmp.setNextNode(n);	
	}
	
	public boolean deleteNode(int index) {
		if (index < 1 || index > this.getListLength()) {
			System.out.println("Wrong Index");
			return false;
		}
		
		int len = 1;
		Node tmp = head;
		if (index == len) {
			head = head.getNextNode();
			return true;
		}
		
		if (index == this.getListLength()) {
			while (tmp != null) {
				if (index - 1 == len++) {
					tmp.setNextNode(null);
					return true;
				}
			}
		}
		
		while (tmp != null) {
			if (index - 1 == len++) {
				tmp.setNextNode(tmp.getNextNode().getNextNode());
				return true;
			}
			tmp = tmp.getNextNode();
		}

		return false;
	}
	
	public int searchNodeIndex(String s) {
		Node tmp = head;
		int index = 1;
		while (tmp != null) {
			if (s.equals(tmp.getBookData().getBookNo())) {
				return index;
			}
			index++;
			tmp = tmp.getNextNode();
		}
		return -1;
	}
	
	public int searchNodeIndex(long id) {
		Node tmp = head;
		int index = 1;
		while (tmp != null) {
			if (tmp.getReaderData().getReaderId() == id) {
				return index;
			}
			index++;
			tmp = tmp.getNextNode();
		}
		return -1;
	}
	
	public int searchNodeIndex(String s, long id) {
		Node tmp = head;
		int index = 1;
		while (tmp != null) {
			if (s.equals(tmp.getBookNo()) && tmp.getReaderNo() == id) {
				return index;
			}
			index++;
			tmp = tmp.getNextNode();
		}
		return -1;
	}
	
	public Node searchNode(String s) {
		Node tmp = head;
		while (tmp != null) {
			if (s.equals(tmp.getBookData().getBookNo())) {
				return tmp;
			}
			tmp = tmp.getNextNode();
		}
		return null;
	}
	
	public Node searchNode(long id) {
		Node tmp = head;
		while (tmp != null) {
			if (tmp.getReaderData().getReaderId() == id) {
				return tmp;
			}
			tmp = tmp.getNextNode();
		}
		return null;
	}
	
	public Node searchNode(String s, long id) {
		Node tmp = head;
		while (tmp != null) {
			if (s.equals(tmp.getBookNo()) && tmp.getReaderNo() == id) {
				return tmp;
			}
			tmp = tmp.getNextNode();
		}
		return null;
	}
	
	public int getListLength() {
		int length = 1;
		Node tmp = head;
		while (tmp.getNextNode() != null) {
			length++;
			tmp = tmp.getNextNode();
		}
		
		return length;
	}
	
	public Node getHeadNode() {
		return head;
	}
	
	public void destroyList() {
		this.head = null;
	}
}
