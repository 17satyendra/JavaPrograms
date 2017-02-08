/**
 * Desc -> Create a Program which creates Banking Cash Counter where people come in to deposit Cash and withdraw Cash. Have an input panel to add people to Queue to either deposit or withdraw money and dequeue the people. Maintain the Cash Balance.
 *I/P -> Panel to add People to Queue to Deposit or Withdraw Money and dequeue 
 *Logic -> Write a Queue Class to enqueue and dequeue people to either deposit or withdraw money and maintain the cash balance
 *O/P -> True or False to Show Arithmetic Expression is balanced or not.
 */
package com.bridgeLabz.programs;
import com.bridgeLabz.util.ArrayQueue;
import com.bridgeLabz.util.Utility;
public class BankingCashCounter {

	public static void main(String[] args) 
	{
		Utility u = new Utility();
		u.getBankInfo();
		System.out.println("How much u you have a intial cash");
		double intCash = u.inputDouble();
		String name=null;
		ArrayQueue aq = new ArrayQueue();
		for(int i =1; i<=1;i++)
		{
			System.out.println("enter customer name");
			name = u.inputString();
			System.out.print(name+"Added in queue");
			aq.enqueue(new Customer(name));
			
			System.out.print("\nFor Amount Deposite enter 1:"
							+"\nFor Amount withDraw enter 2: :");
			int option = new Double(u.inputDouble()).intValue();
			switch(option)
			{
				case 1:
					System.out.print("enter amount to be Deposite\n");
					int depAmt=u.inputInteger();
					intCash+=depAmt;
					System.out.print("Amount deposited...\nThankyou!!!");
					aq.dequeue();
					System.out.println(name+"removed from in queue after "+depAmt+"rs deposite "
							+ "/nthankyou");
					break;
				case 2:
					System.out.print("\n\"enter amount to be WithDraw");
					int withAmt=u.inputInteger();
					intCash-=withAmt;
					System.out.print("\n\"...\nThankyou!!!");
					aq.dequeue();
					System.out.println(name+"removed from in queue after Withdrawn with"+" "+withAmt+"rs."
							+ "\nthankyou");
					break;
				default :
					System.out.println("invalid option..!!!");
					break;
			}
		}
		System.out.println("cash counter remaining balance "+intCash);
	}

}
