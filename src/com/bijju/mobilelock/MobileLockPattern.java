package com.bijju.mobilelock;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * 
 * @author Raghavendra Reddy Bijjula
 *	Assumptions - 
 */

public class MobileLockPattern {
	private static Logger logger = Logger.getLogger(MobileLockPattern.class);
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
	
	private String constructEdge(int firstPoint, int secondPoint)
	{
		return firstPoint+""+secondPoint;
	}
	
	/*
	 * TODO: How to validate these are correct?
	 * 
	 * 
	 */
	private boolean validateConditions(int num, StringBuilder str, HashMap<String, Integer> edgeFrequency)
	{
		boolean check = true;
		boolean isAnyEdgeTwice = false;
		boolean isEdgeExists = false;
		String edge = "";
		String reverseEdge = "";
		
		if(str.indexOf(String.valueOf(num))>=0)
		{
			int lastDigit = Character.getNumericValue(str.charAt(str.length()-1));
			edge = constructEdge(num,lastDigit);
			reverseEdge = constructEdge(lastDigit, num);
			
			StringBuilder mapLog = new StringBuilder();
			for(Map.Entry<String, Integer> entry : edgeFrequency.entrySet())
			{
				String key = entry.getKey();
			    Integer value = entry.getValue();
			    
				if(value>1)
					isAnyEdgeTwice = true;
				
				if(key.equals(edge) || key.equals(reverseEdge))
				{
					isEdgeExists = true;
				}
				mapLog.append(key+"-"+value+"~");
			}
			
			if(isEdgeExists)
			{
				if(isAnyEdgeTwice)
				{
					check = false;
				}
				else
				{
					check = true;
					//edgeFrequency.put(edge, edgeFrequency.getOrDefault(edge, 0) + 1);
					if(edgeFrequency.get(edge)!=null)
					{
						edgeFrequency.put(edge, edgeFrequency.get(edge) + 1);
					}
					else
					{
						if(edgeFrequency.get(reverseEdge)!=null)
							edgeFrequency.put(reverseEdge, edgeFrequency.get(reverseEdge) + 1);
						else
							edgeFrequency.put(edge, 1);
					}
				}
			}
			else
			{
				check = true;
				edgeFrequency.put(edge, 1);
			}
			//logger.debug("num:"+num+" append:"+check+" Map values before adding-\n "+mapLog.toString());
		}
		else
		{
			check = true;
			if(str.length() > 0)
			{
				int lastDigit = Character.getNumericValue(str.charAt(str.length()-1));
				edge = constructEdge(num,lastDigit);
				edgeFrequency.put(edge, 1);
			}
		}
		
		return check; 
	}
	
	private void generateGraph(int node, StringBuilder graph, HashMap<String,Integer> edgeFrequency)
	{
		boolean addNode = true;
		
		if(graph.length()>0)
		{
			if(!validateConditions(node, graph, edgeFrequency))
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
				//System.out.println(graph.toString()); // Print those patterns which has length > 4
				logger.debug("GRAPH--------------------"+graph);
				totalCount = totalCount +1;
			}
			
			for(int i=0;i < nodes[node].length;i++)
				generateGraph(nodes[node][i], graph, edgeFrequency);
		}
	}
	
	public static void main(String args[])
	{
		MobileLockPattern mlp = new MobileLockPattern();
		
		for(int i=1;i<nodes.length;i++)
		//for(int i=1;i<2;i++)
		{
			logger.debug("-----------------------------Iteration "+i+" started");
			mlp.generateGraph(i, new StringBuilder(), new HashMap<String, Integer>());
			logger.debug("-----------------------------Iteration "+i+" ended");
			logger.debug("-----------------------------Count after one iteration "+totalCount);
		}
		logger.debug("Total Count Dude: "+totalCount);
	}
}
