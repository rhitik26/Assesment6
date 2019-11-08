package com.main;

import java.util.List;
import java.util.Scanner;

import com.dao.ProductsDao;
import com.model.Products;

public class Main {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	ProductsDao pd=new ProductsDao();
	 System.out.println("------------------------------------------------------------------------------------------------------------------------------");
	 System.out.printf("%70s\n","Welcome to the Inventory");
	 System.out.println("------------------------------------------------------------------------------------------------------------------------------");
	while(true) {
		int ch;
		  System.out.println("\n\n Select from the following options.....\n");
    	  System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("1) Add new Product");
		System.out.println("2)View Inventory");
		System.out.println("3) Update the Product");
		System.out.println("4) Delete the Product");
		System.out.println("5) Exit");
//		System.out.println("Enter your Choice:");
		ch=sc.nextInt();
		switch (ch) {
		case 1:
			System.out.println("Enter Product Name:");
			String name=sc.next();
			System.out.println("Enter Description: ");
			String desc=sc.next();
			System.out.println("Enter Price: ");
			int price=sc.nextInt();
			System.out.println("Enter Quantity: ");
			int quantity=sc.nextInt();
			Products p=new Products(name,desc,price,quantity);
			pd.create(p);
			System.out.println("Product Added Succesfully");
			break;
		case 2:
			List<Products> products=pd.findAll();
			for(Products pr:products) {
			System.out.println(pr.getId()+"  "+pr.getName()+"  "+pr.getDesc()+"  "+pr.getPrice()+"  "+pr.getQuantity());	
			}
			break;
		case 3: 
			System.out.println("Enter id");
			int id=sc.nextInt();
			System.out.println("Enter new name");
			String uname=sc.next();
			System.out.println("Enter new Price");
			int uprice=sc.nextInt();
			System.out.println("Enter new quantity");
			int uquantity=sc.nextInt();
			System.out.println("Enter Description");
			String udesc=sc.next();
			Products ps=pd.update(id, uname, uprice, uquantity,udesc); 
			break;
		case 4:
			System.out.println("Enter id");
			int iid=sc.nextInt();
			pd.delete(iid);
			break;
		  case 5:
			  ch=-1;
			  System.out.println("------------------------------------------------------------------------------------------------------------------------------");
			  System.out.printf("%70s\n","Exiting the Inventory Manager");
			  System.out.println("------------------------------------------------------------------------------------------------------------------------------");
			  break;
			  
		 
			  
		  default:
			  System.out.println("Enter a Valid Choice");
		}
	}
}
}
