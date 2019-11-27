package com.face.controller;

import java.util.Scanner;

import com.face.dao.PlayerDAO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		int choice;
		
	  do {
		  System.out.println("MEnu");
		  System.out.println("1:List All Player\n2:Add New Player\n3:Search Player\n");
		  Scanner sc = new Scanner(System.in);
		  choice=sc.nextInt();
		  sc.nextLine();
		  switch(choice)
		  {
		  case 1:
			  PlayerDAO pd=new PlayerDAO();
			  pd.getAllPlayerDetails();
			  break;
		  case 2:
				Player p=new Player();
				
			  break;
			  
			  
		  }
	  }while(choice!=3);
		

	}

}
