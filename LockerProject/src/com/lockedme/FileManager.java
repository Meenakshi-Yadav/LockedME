package com.lockedme;
import java.io.File;
import java.io.FileWriter;
import java.util.*;
import java.util.stream.Collectors;

public class FileManager 
{
	/**
	 * This method will return the file names from the folder
	 * @param folderpath
	 * @return List<String>
	 */
	public static List<String> getAllFiles(String folderpath)
	{
		//Creating File Object
		File fl= new File(folderpath);
		
		//Getting all the files into FileArray
		File[] listOfFiles=fl.listFiles();
		
		//Getting a list to store file names
		List<String> fileNames = new ArrayList<String>();
		
		for(File f:listOfFiles)
			fileNames.add(f.getName());
			
		//return the list in sorted order
		List<String> sortedList = fileNames.stream().sorted().collect(Collectors.toList());   
		return sortedList;
	}
	
	/**
	 * This method will create or append the content into the specified file
	 * @param folderpath
	 * @param fileName
	 * @param content
	 * @return boolean
	 */
	public static boolean createFiles(String folderpath, String fileName, List<String> content)
	{
		try
		{
			File fl= new File(folderpath, fileName);
			FileWriter fw= new FileWriter(fl);
			
			for(String s:content)
			{
				fw.write(s+"\n");
			}
			fw.close();
			return true;
		}
		catch(Exception Ex)
		{
			return false;
		}
		
	}
	
	/**
	 * This method will delete the specified file
	 * @param folderpath
	 * @param fileName
	 * @return boolean
	 */
	
	public static boolean deleteFile(String folderpath, String fileName)
	{
		//adding folderpath with file name
		File file=new File(folderpath+"\\"+fileName);
		 try
		 {
			 if(file.delete())
				 return true;
			 else
				 return false;
		 }
		 catch(Exception Ex)
		 {
			 return false;
		 }
	}
	
	/**
	 * this method will search the file specified by the user
	 * @param folderpath
	 * @param fileName
	 * @return boolean
	 */
	public static boolean searchFile(String folderpath,String fileName)
	{
		//adding folderpath with file name and creating file object
		File file=new File(folderpath+"\\"+fileName);
		 try
		 {
			 if(file.exists())
				 return true;
			 else
				 return false;
		 }
		 catch(Exception Ex)
		 {
			 return false;
		 }
	}

}
