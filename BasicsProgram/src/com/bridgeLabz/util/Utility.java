package com.bridgeLabz.util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

import com.bridgeLabz.programs.Stack;


/**
 * THis class provides some utilities methods
 * @author bridgeit
 *
 */
public class Utility 
{
	Stack st;
	Scanner sc = new Scanner(System.in);
	private long startTime;
	private long stopTime;
	private boolean running;
	private Node start;
	private Node last;
	public int size;
	private TreeNode root;
	
	//Variable for balance String
	String output="";
	//Default constructor
	public Utility() 
	{
		root=null;
	}
	public Utility(String in) 
	{
		st = new Stack(in.length());
	}
	
	/**
	 * This method return random number.
	 * @return - random number
	 */
	public int randomInput() 
	{
		Random random = new Random();
		return random.nextInt(100);
	}
	
	/**
	 * It read the file from disk
	 * @return
	 * @throws IOException 
	 */
	public String readFile() throws Exception 
	{
		String file="";
		System.out.println("enter path where your file present..");
		String path = inputString();
		BufferedReader br = null;
		try {
		    br = new BufferedReader(new InputStreamReader
		    								(new FileInputStream(path)));
		    String temp="";
			while ((temp = br.readLine()) != null)
		    {
		    	file+=temp;
		    }
		} catch (IOException e) {
		   // System.out.println("ERROR: unable to read file " + path);
		   e.printStackTrace();
		   Exception e1 = new Exception("Unable to read file");
		   
		   throw e1;
		}
		finally{
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {}
			}
		}
		return file;
	}
	//binarySearch for String
	public int binarySearch(String [] a) 
	{
		 System.out.println("enter a word to be search");
		 String search=inputString();
		 int first = 0;
		 int last  = a.length;
		 while (first < last) 
		 {
			 int mid = (first + last) / 2;
		     if (search.compareTo(a[mid]) < 0) 
		         last = mid;
		     else if (search.compareTo(a[mid]) > 0) 
		    	 first = mid + 1;
		     else 
		         return mid;
		 }
		    return -1;
	}
	//binarySearch for integer
	public int binarySearchInt(int [] a)
	{
		System.out.println("Enter number to be search..");
		int find=inputInteger();
		int first = 0;
		int last = a.length;
		while(first<last)
		{
			int mid = (first+last)/2;
			if(find==mid)
				return mid;
			else if(find>a[mid])
				first=mid+1;
			else if(find<a[mid])
				last = mid;
		}
		return -1;
	}
	//Invoking String
	public String inputString()
	{
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			return br.readLine();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			/*if( br != null ){
				try 
				{
					br.close();
				} catch (IOException e) {e.printStackTrace();}
			}*/
		}
		return null;
	}
	//@returning double value
	public double inputDouble() 
	{
		Scanner sca = new Scanner(System.in);
		double value = sca.nextDouble();
		
		//sca.close();
		
		return value;
	}
	//Insertion sort for String
	public void insertionSort(String[] str) 
	{
		for (int i = 1; i < str.length; i++) 
		{
			String temp = str[i];
			int j = i-1;
			while(j>-1 && str[j].compareToIgnoreCase(temp)>0)
			{
				str[j+1]=str[j];
				j--;
			}
			str[j+1]=temp;
		}
	}
	//Insertion sort for integer
	public void insertionSortInt(int [] a)
	{
		for (int i = 1; i < a.length; i++) 
		{
			int key =a[i];
			int j = i-1;
			while(j>-1 && a[j]>key)
			{
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=key;
		}
	}
	public int inputInteger() 
	{
		//int temp = 
		return sc.nextInt(); //temp;
	}
	//Bubble sort for String
	public void bubbleSort(String[] str) 
	{
		for (int i = 0; i < str.length-1; i++) 
		{
			for (int j = 0; j < str.length-1-i; j++) 
			{
				if(str[j].compareToIgnoreCase(str[j+1])>0)
				{
					String temp = str[j];
					str[j]=str[j+1];
					str[j+1]=temp;
				}
			}
		}
	}
	//Bubble sort for integer
	public void bubbleSortInt(int[] arr) 
	{
		for (int i = 0; i < arr.length-1; i++) 
		{
			for (int j = 0; j < arr.length-1-i; j++) 
			{
				if(arr[j]>arr[j+1])
				{
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
	//starting watch
	public void startTime() 
	{
	    this.startTime = System.currentTimeMillis();
	    this.running = true;
	}
	//Elapse time in milliseconds
	public long getElapseTime()
	{
		long elapsed;
		if(running)
			elapsed = System.currentTimeMillis()-startTime;
		else
			elapsed = stopTime-startTime;
		return elapsed;
	}
	//elapse time in seconds
	public long getElapseTimeSec()
	{
		long elapsed;
		if(running)
			elapsed=(System.currentTimeMillis()-startTime)/1000;
		else
			elapsed = (stopTime-startTime)/1000;
		return elapsed;
	}
	//Stopping watch
	public void stopTime() 
	{
		this.stopTime = System.currentTimeMillis();
		this.running = false;
		
	}
	//providing delay time for StopWatch
	public void delay()
	{
		System.out.println("give delay time....in seconds");
		long time= sc.nextLong()*1000;
		try {Thread.sleep(time);} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public String[] split(String f, String s) 
	{
		char [] c = f.toCharArray();
		//count spaces
		int space=0;
		for (int i = 0; i < c.length; i++) 
		{
			if(c[i]==' ')
				space++;
		}
		//creating String array
		String [] str = new String[space+1];
		int j=0;
		str[j]="";
		for (int i = 0; i < c.length; i++) 
		{
			if(c[i]!=' ')
				str[j]+=c[i];
			else{
				j++;
				str[j]="";
			}
		}
		return str;
	}
	//returning size linked list
	public int size()
	{
		return size;
	}
	//check is empty linked list
	public boolean isEmpty()
	{
		return start==null;
	}
	//Linked list add
	public void add(Object ele)
	{
		size++;
		if(start==null)
		{
			start = new Node(ele);
			last = start;
			return;
		}
		last.next=new Node(ele);
		last=last.next;
	}
	//get object of linkedlist type
	public Object getObject(int index)
	{
		if(index>=size)
			throw new IndexOutOfBoundsException();
		Node p = start;
		for (int i = 1; i <=index; i++) {
			p=p.next;
		}
		return p.ele;
	}
	//remove object from linked list
	public void removeObj(int i)
	{
		
		if(i<0 && i>=size())
			throw new IndexOutOfBoundsException("remove not posible");
		Node d  = start;
	
		for(int j =1;j<i;j++)
		{
			d=d.next;
		}
		Node temp=d.next;
		if(d.next!=null) 
		{
			d.next=null;
			d=temp;
		}else{
			last=d.next;
			d.next=null;
		}
	}
	//display for linked list
	public void display()
	{
		for (int i = 0; i < size; i++) 
		{
			System.out.println(getObject(i));
		}
	}
	//Inner class for Linked Node Type
	private class Node
	{
		Object ele;
		Node next;
		//constructor
		Node(Object ele)
		{
			this.ele=ele;
		}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next2) 
	{
		next=next2;
	} 
		
	}
	private class TreeNode
	{
		int key;
		TreeNode left,right;
		 TreeNode(int key)
		{
			this.key=key;
			left=right=null;
		}
	}
	public boolean remove(int index) {	 
	// if the index is out of range, exit
		if (index < 1 || index > size())
			return false;
 
		Node temp = start;
		if (start != null) {
			for (int i = 1; i < index; i++) {
				if (temp.getNext() == null)
					return false;
 
				temp = temp.getNext();
			}
			temp.setNext(temp.getNext().getNext());
 
			// decrement the number of elements variable
			size--;
			return true;
		}
		return false;
	}
	//Data inserting return to text file
	public void writefile(String s)
	{
		BufferedWriter writer = null;
		try
		{
		    writer = new BufferedWriter( new FileWriter("/home/bridgeit/Desktop/myfile.text"));
		    writer.write(s);
		}
		catch ( IOException e){
			e.printStackTrace();
		}
		finally
		{
		    try
		    {
		        if ( writer != null)
		        writer.close( );
		    }
		    catch ( IOException e)   {}
		}
	}
	//converting BalanceParenthesis
	public String doTrans(String s) 
	{
		for (int i = 0; i < s.length(); i++) 
		{
			char c = s.charAt(i);
			switch (c) 
			{
			case '+':
			case '-':
				gotOper(c,1);
				break;
			case '*':
			case '/':
				gotOper(c,2);
				break;
			case '(':
				st.pushItem(c);
				break;
			case ')':
				gotParen(c);
				break;
			default:
				output=output+c;
				break;
			}
		}
		while(!st.isEmpty())
		{
			output=output+st.popItem();
		}
		return output;
	}
	//BalanceParenthesis 
	public void gotParen(char c)
	{
		while(!st.isEmpty())
		{
			char ch=(char) st.popItem();
			if(ch=='(')
				break;
			else
				output = output+ch;
		}
	}
	//BalanceParenthesis operator
	public void gotOper(char c, int i) 
	{
		while(!st.isEmpty())
		{
			char onTop = (char)st.popItem();
			if(onTop=='(')
			{
				st.pushItem(onTop);
				break;
			}else{
				int perc ;
				if(onTop=='+'||onTop
						=='-')
					perc = 1;
				else
					perc=2;
				if(perc<i)
				{
					st.pushItem(onTop);
					break;
				}else
					output+=onTop;
			}
		}
		st.pushItem(c);
	}
	public void getBankInfo() 
	{
		System.out.println("Welcome to bank please come in queue..."
				+ "\ncash couter no 1\nrefreshment leave 1pm to 2pm");
	}
	//this method calls insertRec()
	public void insertTree(int key)
	{
		root=insertRec(root,key);
	}
	//this method data inserted for binarytree
	private TreeNode insertRec(TreeNode root, int key)
	{
		if(root == null)
		{
			root = new TreeNode(key);
			return root;
		}
		if(key<root.key)
			root.left = insertRec(root.left,key);
		else if(key>root.key)
			root.right = insertRec(root.right, key);
		return root;
	}
	//this method calls inOrder()
	public void inOrder() 
	{
		inOrderRec(root);
	}
	//A utility function TODO inorder traversal of Depth-first search
	private void inOrderRec(TreeNode root) 
	{
		if(root!=null)
		{
			inOrderRec(root.left);
			System.out.print(root.key+" ");
			inOrderRec(root.right);
		}
	}
	//this method calls postOrder()
	public void postOrder() 
	{
		postOrderRec(root);
	}
	//A utility function TODO postorder traversal of Depth-first search
	private void postOrderRec(TreeNode root) 
	{
		if(root!=null)
		{
			postOrderRec(root.left);
			postOrderRec(root.right);
			System.out.print(root.key+" ");
		}
	}
	//this method calls preOrder()
	public void preOrder() 
	{
		preOrderRec(root);
	}
	//A utility function TODO preorder traversal of Depth-first search
	private void preOrderRec(TreeNode root) 
	{
		if(root!=null)
		{
			System.out.print(root.key+" ");
			preOrderRec(root.left);
			preOrderRec(root.right);
		}
	}
	//this method calls bSTRecOrder()
	public void breadthFirstSearch() 
	{
		bSTRec(root);
	}
	//A utility function TODO  traversal of Breadth-first search
	private void bSTRec(TreeNode root) 
	{
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while(!q.isEmpty())
		{
			TreeNode temp = q.poll();
			System.out.print(temp.key+" ");
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
		}
	}
	// A recursive function to find nth catalan number for Binary Tree
    public int catalan(int n) {
        int res = 0;
        // Base case
        if (n <= 1) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            res += catalan(i) * catalan(n - i - 1);
        }
        return res;
    }
    //this function checks if a binary tree is full or not
	public void isFullTree()
	{
		System.out.println(isFullTree(root));
	}
	
	private boolean isFullTree(TreeNode root)
	{
		// if empty tree
	    if(root == null)
	    	return true;
	    // if leaf node
	    if(root.left == null && root.right == null )
	    	return true;
	    // if both left and right subtrees are not null
	    // the are full
	    if((root.left!=null) && (root.right!=null))
	    	return (isFullTree(root.left) && isFullTree(root.right));
	    // if none work
	        return false;
	 }
	// This method mainly calls deleteRec()
	public void deleteKey(int key)
    {
        root = deleteRec(root, key);
        System.out.println("key deleted");
    }
    // A recursive function to insert a new key in BST 
    private TreeNode deleteRec(TreeNode root, int key)
    {
        // Base Case: If the tree is empty 
        if (root == null)  return root;
 
        // Otherwise, recur down the tree 
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
 
        // if key is same as root's key, then This is the node
        // to be deleted
        else
        {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.key = minValue(root.right);
            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }
    
   
    /**
     * This method return minimum value for tree root
     * @param root-TreeNoot 
     * @return Minimum value
     */
    private int minValue(TreeNode root)
    {
        int minv = root.key;
        while (root.left != null)
        {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
	/**
	 * This method count the minimum number on notes.  
	 * @param n - List of notes (Notes can be Rs.100 Rs 500 ....) 
	 * @param c - Change value
	 * @return Number of notes.
	 */
	public int countNote(int [] n, int c) 
	{
		int [] no = new int [n.length];
		int count = 0;
		int temp ;
		System.out.println("Note Summary");
		for (int i = 0; i < n.length; i++) 
		{
			if(c/n[i]!=0){
				no[i]=c/n[i];
				c=c%n[i];
				count+=no[i];
				System.out.println(n[i]+" x "+no[i]+" = "+n[i]*no[i]);
			}
		}
		return count;
	}
}
