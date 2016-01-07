package com.bijju.mobilelock;

import java.util.Random;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author I050232
 *	Assumptions - 
 */

public class MobileLockPattern {
	private static int totalCount = 0;
	private static int nodes[][] = {
			{},
			{2,5,4}, 
			{1,3,4,5,6}, 
			{2,5,6}, 
			{1,2,5,7,8}, 
			{1,2,3,4,6,7,8,9}, 
			{2,3,5,8,9}, 
			{4,5,8}, 
			{4,5,6,7,9}, 
			{5,6,8}};
	/*private static int nodes[][] = {
	{},
	{2,3,4}, 
	{1,3,4}, 
	{1,2,4},
	{1,2,3}
	};*/
	
	private int generateRandomKey(int min, int max)
	{
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
	
	private String constructEdge(int firstPoint, int secondPoint)
	{
		return firstPoint+""+secondPoint;
	}
	
	/*
	 * TODO: Conditions need to be improved to validate, 'Only one edge reuse is allowed'
	 * As of now, we check no edge can repeat more than twice.
	 * 
	 */
	private boolean validateConditions(int num, StringBuilder str)
	{
		boolean check = true;
		int edgeCount = 0;
		int reverseEdgeCount = 0;
		String edge = "";
		String reverseEdge = "";
		
		if(str.indexOf(String.valueOf(num))>=0)
		{
			int lastDigit = Character.getNumericValue(str.charAt(str.length()-1));
			edge = constructEdge(num,lastDigit);
			reverseEdge = constructEdge(lastDigit, num);
			edgeCount = StringUtils.countMatches(str, edge);
			reverseEdgeCount = StringUtils.countMatches(str, reverseEdge);
			if((edgeCount+reverseEdgeCount)>1)
				check = false;
		}
		
		return check; 
	}
	
	private void generateGraph(int node, StringBuilder graph)
	{
		boolean addNode = true;
		
		if(graph.length()>0)
		{
			if(!validateConditions(node,graph))
			{
				addNode = false;
				//if(graph.length()>3)
				//	System.out.println(graph.toString()); // Print when pattern ends its route
				return;
			}
		}
		
		if(addNode)
		{
			graph.append(node);
			if(graph.length()>3)
			{
				System.out.println(graph.toString()); // Print those patterns which has length > 4
				totalCount = totalCount +1;
			}
			
			for(int i=0;i < nodes[node].length;i++)
				generateGraph(nodes[node][i], graph);
		}
	}
	
	public static void main(String args[])
	{
		MobileLockPattern mlp = new MobileLockPattern();
		
		//mlp.generatePermutations();
		for(int i=1;i<nodes.length;i++)
		{
			mlp.generateGraph(i, new StringBuilder());
		}
		System.out.println("Total Count Dude: "+totalCount);
	}
}
