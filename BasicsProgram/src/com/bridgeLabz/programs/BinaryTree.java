package com.bridgeLabz.programs;
import com.bridgeLabz.util.TreeUtility;
import com.bridgeLabz.util.Utility;

public class BinaryTree {

	public static void main(String[] args) 
	{
		TreeUtility u = new TreeUtility();
		Utility ut = new Utility();
		//Inserting item in tree
		for (int i = 1; i <=5; i++) 
		{
			int num= ut.randomInput();
			u.insertTree(i);
		}
		System.out.println("data inserted");
		System.out.println("Data  traversal in inorder");
		u.inOrder();
		System.out.println("\nData  traversal in postorder");
		u.postOrder();
		System.out.println("\nData  traversal in preorder");
		u.preOrder();
		System.out.println("\nData  traversal in Breadth-first search");
		u.breadthFirstSearch();
		System.out.println("\nfind the number of different binary search trees "
				+ "					that can be created using these nodes.");
		for (int i = 0; i < 10; i++) 
		{
			System.out.print(u.catalan(i) + " ");
	    }
		System.out.println("\nChecking isFull");
		u.isFullTree();
		u.deleteKey(6);
		u.inOrder();
	}

}
