/**
 * @author bridgeit Satyendra Singh 
 * Desc -> A palindrome is a string that reads the same forward and backward, for example, radar, toot, and madam. We would like to construct an algorithm to input a string of characters and check whether it is a palindrome.
 * I/P -> Take a String as an Input 
 * Logic -> The solution to this problem will use a deque to store the characters of the string. We will process the string from left to right and add each character to the rear of the deque. 
 * O/P -> True or False to Show if the String is Palindrome or not using linkedlist.
 */
package com.bridgeLabz.programs;
import com.bridgeLabz.util.DoublylinkedList;
import com.bridgeLabz.util.Utility;

public class PalindromeChecker 
{
	public static void main(String[] args) 
	{
		Utility u = new Utility();
		DoublylinkedList ls =new DoublylinkedList();
		System.out.println("Enter a string to be check");
		String word = u.inputString();
		String res ="";
		for (int i = 0; i < word.length(); i++)
		{
			char c = word.charAt(i);
			ls.addFront(c);
			
		}
		for(int i = 0;i<ls.size();i++)
		{
			res=res+(char)ls.removeLast();
		}
		if(res.equalsIgnoreCase(word))
			System.out.println("true");
		else
			System.out.println("false");
	}
}
