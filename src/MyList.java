import java.util.Scanner;

import javax.swing.JOptionPane;

public class MyList {
	public static int [] list;
	public static int [] list1;
	public static int [] list2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyList li = new MyList();
		li.listA();
		li.listB();
		li.square(list);
		li.bind(list1, list2);

	}
	
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
			}
			System.out.println(list2[x]);
			//JOptionPane.showMessageDialog(null, list[x]);
		}
		
		return list2;
	}
	
	
	
	
	public int [] square(int [] list)
	{
		list = new int[list1.length];
		for(int i = 0; i < list.length; i++)
		{
			list[i] = list1[i] * list1[i];
		}
		
		System.out.println("The squared values of listA are: ");
		for(int i = 0; i < list.length; i++)
		{
			System.out.println(list[i]);
		}
		
		return list;
		
	}
	
	
	public int[] bind(int [] listA, int [] listB)
	{
		int[] bindedLists;
		bindedLists = new int[list1.length + list2.length];
		for(int i = 0; i < list1.length; i++)
		{
			bindedLists[i] = list1[i];
		}
		
		System.out.println(list1.length);
		
		for(int x = list1.length; x < bindedLists.length; x++)
		{

			for(int y = 0; y < list2.length; y++)
			{
					bindedLists[x] = list2[y];
					//y++;
			}


		}
		System.out.println("binded lists");
		for (int j = 0; j < bindedLists.length; j++)
		{
			System.out.println(bindedLists[j]);
		}
		return bindedLists;
	}
	
	
	public int[] sort(int [] list)
	{
		
	}

}
