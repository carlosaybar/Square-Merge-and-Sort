/*
 Carlos Aybar
 Intro to Java
 03/18/20
 This programs accepst two lists of integers, each integer separated by a space
 then it sepparates each integer and stores it in an array
 then the square method squares listA or listB
 the bind method appends listA and ListB and stores them in a new array]
 then the square merge sort, sorts the lists, squares them, and marges them.
 */

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class MyList implements BasicList {
	public static int [] list;
	public static int [] list1;
	public static int [] list2;
	public static int[] bindedLists;
	
	/**
	 * the main method calls all the other methods
	 * here we print the result from each called method
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyList li = new MyList(); //makes an instance of MyList so that we can call the non-static methods
		li.listA();
		li.listB();
		
		//prints out listA squared
		int [] squared = li.square(list);
		System.out.println("The squared values of the list you chose are: ");
		for(int i = 0; i < squared.length; i++)
		{
			System.out.println(squared[i]);
		}
		
		//prints out listA and listB binded
		int [] binded = li.bind(list1, list2);
		System.out.println("Binded lists");
		for (int j = 0; j < binded.length; j++)
		{
			System.out.println(binded[j]);
		}
		
		//prints out both list binded and sorted
		li.sort(list);
		System.out.println("Sorted list");
		for(int i = 0; i < bindedLists.length; i++)
		{
			System.out.println(bindedLists[i]);
			//JOptionPane.showInputDialog(message , bindedLists[i]);
			
		}
		
		
		
		//prints out both list merged, squared, and sorted in ascending order
		li.squareMerge(list1, list2);
		System.out.println("The squared, marged, and binded values are: ");
		for(int i = 0; i < bindedLists.length; i++)
		{
			System.out.println(list[i]);
		}
		

	}
	
	/**
	 * this method accepts a list of numbers, each separated by a space
	 * then it splits the numbers and stores them in a string array
	 * it converts all the values from the string array into integers 
	 * and stores them in a new array called list1.
	 * @return listA
	 */
	public int [] listA()
	{
		Scanner input = new Scanner(System.in);
		String number;
		System.out.println("please enter four numbers, each separated by space: ");
		number = input.nextLine();
		
		String [] stringList = {" "};
		for(int i = 0; i < number.length(); i++)
		{
			stringList = number.split(" "); //splits the values of the string number and stores them in a string array

		}
		list1 = new int[stringList.length];
		for(int x = 0; x < stringList.length; x++)
		{
			/*
			 * this try statement goes through the string array
			 * tries to parse every value into an int array.
			 * if the values cannot be parse, it tells the user that the input contains 
			 * a non numeric value and exits the program.
			 */
			try
			{
			list1[x] = Integer.parseInt(stringList[x]);
			}catch(NumberFormatException e)
			{
				System.out.println( "you entered an invalid input or an extra space at index " + x);
				System.exit(0);
			}
			System.out.println(list1[x]);
			//JOptionPane.showMessageDialog(null, list[x]);
		}
		
		return list1;
	}
	
	/**
	 * this method accepts a list of numbers, each separated by a space
	 * then it splits the numbers and stores them in a string array
	 * it converts all the values from the string array into integers 
	 * and stores them in a new array called list2.
	 * @return list2
	 */
	public int [] listB()
	{
		Scanner input = new Scanner(System.in);
		String number;
		System.out.println("please enter four numbers, each separated by space: ");
		//JOptionPane.showInputDialog("please enter four numbers, each separated by space: ");
		number = input.nextLine();
		
		String [] stringList = {" "};
		for(int i = 0; i < number.length(); i++)
		{
			stringList = number.split(" ");

		}
		list2 = new int[stringList.length];
		for(int x = 0; x < stringList.length; x++)
		{
			try
			{
			list2[x] = Integer.parseInt(stringList[x]);
			}catch(NumberFormatException e)
			{
				System.out.println("you entered an invalid input or an extra space at index " + x);
				System.exit(0);
			}
			System.out.println(list2[x]);
			//JOptionPane.showMessageDialog(null, list[x]);
		}
		
		return list2;
	}
	
	
	
	/**
	 * the square method accepts the values from either list1 or list2 and squares all the values
	 * then the values are stored on a tempList
	 * @param list 
	 * @return the squared list
	 */
	public int [] square(int [] list)
	{
		Scanner input = new Scanner(System.in);

		int [] tempList = {0};
		int option;
		System.out.println("enter 1 to square the values of list1 or 2 to square the values of list2: ");
		option = input.nextInt();
		switch(option) {
		case 1: //squares the values of list1(listA)
			//fill  list with list A
			list = new int[list1.length];
			for(int i = 0; i < list1.length; i++)
			{
				list[i] = list1[i];
			}
			
			//fill in the stored list in tempList
			tempList =  new int[list.length];
			for(int i = 0; i < list.length; i++)
			{
				tempList[i] = list[i] * list[i];
			}
			break;
		case 2: //squares the values of listB(list2)
			//fill  list with list A
			list = new int[list2.length];
			for(int i = 0; i < list2.length; i++)
			{
				list[i] = list2[i];
			}
			
			//fill in the stored list in tempList
			tempList =  new int[list.length];
			for(int i = 0; i < list.length; i++)
			{
				tempList[i] = list[i] * list[i]; //squares the value of the list and stores it in the tempList array
			}
			break;
			
		}
		return tempList;
		
	}
	
	/**
	 * the bind takes the two lists and stores both of them in a single array of integers
	 * @param listA the first list, in this case list1
	 * @param listB the second list, the same as list2
	 * @return bindedLists
	 */
	public int[] bind(int [] listA, int [] listB)
	{

		//sets the size of bindedLists to the sum of the lengths of both list1 and list2
		bindedLists = new int[list1.length + list2.length];
	
		//iterates through every index of bindedLists in order to pupulate it with the values from list1 and list2
		for(int i = 0; i < bindedLists.length; i++)
		{
			if(i < list1.length)
			{
				bindedLists[i] = list1[i];
			}
			else //when the index of bindedLists becomes greater then the length of list1, the program will move to list2
			{
				bindedLists[i] = list2[i - list1.length];
			}

		}
		
		return bindedLists;
	}
	
	/**
	 * the sort method accesses the Array library and calls 
	 * Arrays.sort in order to sort the values of the bindedLists in
	 * ascending order
	 * @param list 
	 * @return the sorted list
	 */
	public int[] sort(int [] list)
	{
		list = new int[bindedLists.length];
		int currentValue;
		
		//sorts the array and stores in the original array 
		Arrays.sort(bindedLists);
		
		return bindedLists;
		
	}
	
	/**
	 * this method squares and sorts the already merge list
	 * since the list were merged in the previous method, 
	 * all we need to do here is square them and then sort the values
	 * @param listA
	 * @param listB
	 * @return returns the merged, squared, and sorted lists
	 */
	public int[] squareMerge(int[] listA, int[] listB)
	{
		list = new int[bindedLists.length];
		for(int i = 0; i < bindedLists.length; i++)
		{
			list[i] = bindedLists[i] * bindedLists[i]; //squares the values of the bindedLists
		}
		Arrays.sort(list); //sorts the bindedLists in ascending order
		
		return list;
	}

}
