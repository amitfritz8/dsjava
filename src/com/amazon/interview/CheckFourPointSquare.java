package com.amazon.interview;

import java.awt.Point;

public class CheckFourPointSquare {

	public static void main(String[] args) {
		
		System.out.println(Math.sqrt(2));
		
		Point p1 =  new Point(10,20);
		Point p2 =  new Point(20,20);
		Point p3 =  new Point(10,10);
		Point p4 =  new Point(20,10);
		
		if(isFourPointSquare(p1,p2,p3,p4)) {
			System.out.println("The four points:- " + p1 + p2 + p3 + p4 + " are square");
		}else {
			System.out.println("The four points:- " + p1 + p2 + p3 + p4 + " are not square");
		}
	
	}
	
	static boolean isFourPointSquare(Point p1, Point p2, Point p3, Point p4) {
		
		
	int p1p2d=	(int)Math.sqrt(Math.pow(Math.abs(p2.getX()-p1.getX()),2) 
			+ Math.pow(Math.abs(p2.getY()-p1.getY()),2));
		
	int p1p3d=	(int)Math.sqrt(Math.pow(Math.abs(p3.getX()-p1.getX()),2) 
			+ Math.pow(Math.abs(p3.getY()-p1.getY()),2));
		
	
	int p1p4d=	(int)Math.sqrt(Math.pow(Math.abs(p4.getX()-p1.getX()),2) 
			+ Math.pow(Math.abs(p4.getY()-p1.getY()),2));
	
	
	int p2p3d =	(int)Math.sqrt(Math.pow(Math.abs(p3.getX()-p2.getX()),2) 
			+ Math.pow(Math.abs(p3.getY()-p2.getY()),2));
	
	
	int p2p4d=	(int)Math.sqrt(Math.pow(Math.abs(p4.getX()-p2.getX()),2) 
			+ Math.pow(Math.abs(p4.getY()-p2.getY()),2));
	
	int p3p4d =	(int)Math.sqrt(Math.pow(Math.abs(p4.getX()-p3.getX()),2) 
			+ Math.pow(Math.abs(p4.getY()-p3.getY()),2));
	

	
	if(p1p2d==p1p3d) {
		if(p1p4d==((int)(Math.sqrt(2)*p1p2d)) && p2p4d==p3p4d) {
			return true;
		}else {
			return false;
		}
	}
	
	if(p1p2d==p1p4d) {
		if(p2p3d==p3p4d) {
			return true;
		}else {
			return false;
		}
	}
	
	if(p1p3d==p1p4d) {
		if(p2p3d==p2p4d) {
			return true;
		}else {
			return false;
		}
	}
	
		return false;
	}
	
}
