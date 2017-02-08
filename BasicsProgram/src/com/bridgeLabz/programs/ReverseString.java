package com.bridgeLabz.programs;

import java.util.Arrays;

import com.bridgeLabz.util.Utility;

public class ReverseString {

	public static void main(String[] args) 
	{
		Utility u = new Utility();
		System.out.println("Enter a String..");
		String sample = u.inputString();
		String [] str = sample.split(" ");
		String s ="";
		for (int i = 0; i < str.length; i++) 
		{
			if(i%2==0 && i!=0)
			{
				String st="";
				for (int j = str[i].length()-1; j >=0 ; j--) {
					st+=str[i].charAt(j);
				}
				str[i]=st;
			}
		}
		
		System.out.println(Arrays.toString(str));
	}

}
