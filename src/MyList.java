import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class MyList implements BasicList {
	public static int [] list;
	public static int [] list1;
	public static int [] list2;

	public int[] bindedLists;
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyList li = new MyList();
		li.listA();
		li.listB();
		
		//prints out listA squared
		int [] squared = li.square(list);
		System.out.println("The squared values of listA are: ");
		for(int i = 0; i < squared.length; i++)
		{
			System.out.println(squared[i]);
		}
		
		//prints out listA and listB binded
		int [] binded = li.bind(list1, list2);
		System.out.println("binded lists");
		for (int j = 0; j < binded.length; j++)
		{
			System.out.println(binded[j]);
		}
		
		//prints out both list binded and sorted
		li.sort(list);
		
		
		
		//prints out both list merged, squared, and sorted in ascending order
		li.squareMerge(list1, list2);

	}
	
	/**
	 * 
	 * @return
	 */
	public int [] listA()
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
		list1 = new int[stringList.length];
		for(int x = 0; x < stringList.length; x++)
		{
			
			try
			{
			list1[x] = Integer.parseInt(stringList[x]);
			}catch(NumberFormatException e)
			{
				System.out.println("you entered an invalid input or an extra space at index " + x);
				System.exit(0);
			}
			System.out.println(list1[x]);
			//JOptionPane.showMessageDialog(null, list[x]);
		}
		
		return list1;
	}
	
	/**
	 * 
	 * @return
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
	 * 
	 * @param list
	 * @return
	 */
	public int [] square(int [] list)
	{
		list = new int[list1.length];
		for(int i = 0; i < list.length; i++)
		{
			list[i] = list1[i] * list1[i];
		}

		
		return list;
		
	}
	
	/**
	 * 
	 * @param listA
	 * @param listB
	 * @return
	 */
	public int[] bind(int [] listA, int [] listB)
	{

		bindedLists = new int[list1.length + list2.length];
		
		for(int i = 0; i < list1.length; i++)
		{
			bindedLists[i] = list1[i];
		}
		
		
		for(int x = list1.length; x < bindedLists.length; x++)
		{

			for(int y = 0; y < list2.length; y++)
			{
					bindedLists[x] = list2[y];
					x++;
			}

		}
		return bindedLists;
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	public int[] sort(int [] list)
	{
		list = new int[bindedLists.length];
		int currentValue;
		
		Arrays.sort(bindedLists);

		System.out.println("sorted list");
		for(int i = 0; i < bindedLists.length; i++)
		{
			System.out.println(bindedLists[i]);
			
		}
		
		return list;
		
	}
	
	/**
	 * 
	 * @param listA
	 * @param listB
	 * @return
	 */
	public int[] squareMerge(int[] listA, int[] listB)
	{
		list = new int[bindedLists.length];
		for(int i = 0; i < bindedLists.length; i++)
		{
			list[i] = bindedLists[i] * bindedLists[i];
		}
		Arrays.sort(list);
		
		System.out.println("The squared, marged, and binded values are: ");
		for(int i = 0; i < bindedLists.length; i++)
		{
			System.out.println(list[i]);
		}
		
		return bindedLists;
	}

}
