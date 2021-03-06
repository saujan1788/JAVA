/*
*	Student name:
*	Student number:
*/
/*
*   Assignment10_2017
*
*		County-Towns Problem
*
*  A data structure that encapsulates a list of counties and the names of towns is required
*  
*  Two classes called County and Town are given. In each case they encapsulate a String that 
*  represents the name of the county or the name of the town. Both of these classes are immutable. 
*  An outline of the class CountyTowns is also given. 
*  The data structure TreeMap<County,TreeSet<Town>> is used to model the relationship between 
*  counties and towns. We assume that a county does not have duplicate named towns but 
*  counties may have town names in common.
*  Your task is to complete the methods listed as part of the interface to this class. 
*  In each case the signature and semantics of the method are given.
*  You must also complete a simple test of these methods.
*  Marks are listed for each method. No marks are allocated for testing but you must show 
*  that you have tested the methods you completed.
*/

import java.util.*;
public class Assignment10_2017{
	public static void main(String args[]){
	  //Data Setup section ============================================================
		//===============================================================================
		ArrayList<TreeSet<Town>> towns = new ArrayList<TreeSet<Town>>();
		TreeSet<Town> cork = new TreeSet<>(Arrays.asList(
		  new Town("Bandon"),new Town("Blarney"),new Town("Fermoy"),new Town("Kanturk")
		));
		towns.add(cork);
		TreeSet<Town> limerick = new TreeSet<>(Arrays.asList(
		  new Town("Croom"),new Town("Foynes"),new Town("Ballingarry")
		));
		towns.add(limerick);
		TreeSet<Town> offaly = new TreeSet<>(Arrays.asList(
		  new Town("Rhode"),new Town("Tullamore"),new Town("Barna")
		));
		towns.add(offaly);
		TreeSet<Town> galway = new TreeSet<>(Arrays.asList(
		  new Town("Athenry"),new Town("Barna"),new Town("Tuam")
		));
		towns.add(galway);
		TreeSet<Town> dublin = new TreeSet<>(Arrays.asList(
		  new Town("Howth"),new Town("Rush"),new Town("Skerries"),new Town("Oldtown")
		));
		towns.add(dublin);
		TreeSet<Town> mayo = new TreeSet<>(Arrays.asList(
		  new Town("Ballina")
	  ));
		towns.add(mayo);
		TreeSet<Town> tipperary = new TreeSet<>(Arrays.asList(
		  new Town("Ballina"),new Town("Clonmel"),new Town("Ballingarry"),new Town("Fethard")
		));
		towns.add(tipperary);
		TreeSet<Town> kerry = new TreeSet<>(Arrays.asList(
		  new Town("Barna"),new Town("Tralee"),new Town("Listowel"),new Town("Oldtown")
		));
		towns.add(kerry);
		List<County> cnts = new ArrayList<>(Arrays.asList(
		 new County("Cork"),new County("Limerick"),new County("Offaly"),
		 new County("Galway"),new County("Dublin"),new County("Mayo"),
		 new County("Tipperary"),new County("Kerry")
		));
		// End data setup ===================================================================
		
		//Create Data Structure using data===================================================
	  CountyTowns data = new CountyTowns();
	  for(int j = 0; j < cnts.size();j++)
		  data.add(cnts.get(j),towns.get(j));
		System.out.println(data);
		
		//====================================================================================
		//Test methods section based on given data set =======================================
		
		
		//====================================================================================
	}
}
//Code for classes County and Town =======================================================
// Do not edit this section ==============================================================

final class County implements Comparable<County>{
 	private final String county;
 	County(String name){
 		assert name != null && name.length() > 0;
 		county = name;
 	}
 	String county(){return county;}
 	public String toString(){return county;}
 	public boolean equals(Object ob){
 		if(!(ob instanceof County)) return false;
 		County cty = (County)ob;
 		return county.equals(cty.county);
	}
	public int hashCode(){return county.hashCode();}
	public int compareTo(County cty){
		if(cty == null) return -1;
		return county.compareTo(cty.county);
	}
}
class Town implements Comparable<Town>{
 	private  String town;
 	Town(String name){
 		assert name != null && name.length() > 0;
 		town = name;
 	}
 	String town(){return town;}
 	public String toString(){return town;}
 	public boolean equals(Object ob){
 		if(!(ob instanceof Town)) return false;
 		Town tn = (Town)ob;
 		return town.equals(tn.town);
	}
	public int hashCode(){return town.hashCode();}
	public int compareTo(Town tn){
		if(tn == null) return -1;
		return town.compareTo(tn.town);
	}
}
//=========================================================================
// Data Structure CountyTowns =============================================

class CountyTowns{
	private TreeMap<County,TreeSet<Town>> data;
	CountyTowns(){
		data = new TreeMap<>();
	}
	void add(County cty, Town town){
	  //Add county and 1 town
		if(data.containsKey(cty))
		  data.get(cty).add(town);
		else{
		  TreeSet<Town> tmp = new TreeSet<>();
			tmp.add(town);
		  data.put(cty,tmp);
		}
	}
	void add(County cty, Set<Town> towns){ // 1 mark
		//Add county together with a list of towns
	}
	Set<Town> listTowns(County cty){// 1 mark
		//List towns in a given county
	}
  Set<County> counties(){// 1 mark
	  //list all counties
	}
  Set<Town> listAllTowns(){// 2 marks
	  //return list of all towns
	}
	public List<County> findCounty(Town tn){ // 1 mark
	  // find county or counties for a given town
	}
	public boolean containsTown(Town tn){ // 1 mark
	  //check if town recorded
	}
	public boolean containsCounty(County cty){ // 1 mark
	 //check if county recorded
	}
	public Map<Town,TreeSet<County>> mapTownToCounty(){ // 2 marks
	  //return a map that maps towns to counties
	} 
	Collection<TreeSet<Town>> listAllTownsA(){
	 return data.values();
	}
  public String toString(){return data.toString();}	
}
