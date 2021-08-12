package com.lockedme;
import java.util.*;
import java.util.List;

public class LockedMeProject 
{
	static final String folderpath="C:\\Users\\Lenovo\\Desktop\\SimplilearnDocs\\Phase1Project\\LockedMeFiles";
	public static void main(String[] args) 
	{
		int proceed=1;
		do
		{
			displayMenu();
			//Variable declaration
			Scanner obj= new Scanner(System.in);
			int ch;
			
			System.out.println("Enter your choice: ");
			ch=Integer.parseInt(obj.nextLine());
			switch(ch){
			case(1):
				getAllFiles();
				break;
			case(2):
				createFile();
				break;
			case(3):
				deleteFile();
				break;
			case(4):
				searchFile();
				break;
			case(5):
				System.exit(0);
				break;
			default:
				System.out.println("Invalid option");
				break;
				
			}
		}while(proceed>0);
	}
	
	public static void displayMenu()
	{
		System.out.println("**************************************************");
		System.out.println("\tWelcome to LockedME.com");
		System.out.println("**************************************************");
		System.out.println("1.Display all files");
		System.out.println("2.Add new file");
		System.out.println("3.Delete a file");
		System.out.println("4.Search a file");
		System.out.println("5.Exit");
		System.out.println("**************************************************");
		
	}
	
	public static void getAllFiles()
	{
		//get file names
		List<String> fileNames=FileManager.getAllFiles(folderpath);
		
		for(String f:fileNames)
		{
			System.out.println(f);
		}
	}
	public static void createFile()
	{
		//variable declaration
		Scanner obj = new Scanner(System.in);
		String fileName;
		int linesCount;
		List<String> content= new ArrayList<String>();
		
		//Read file name from user
		System.out.println("Enter file name: ");
		fileName=obj.nextLine();
		
		//read number of lines from user
		System.out.println("Enter how many lines in the file: ");
		linesCount= Integer.parseInt(obj.nextLine());
		
		//Read line from user
		for(int i=1;i<=linesCount;i++)
		{
			System.out.println("Enter line"+i+":");
			content.add(obj.nextLine());
		}
		
		//save the content in the file
		boolean isSaved = FileManager.createFiles(folderpath, fileName, content);
		
		if(isSaved)
			System.out.println("File and data saved successfully");
		else
			System.out.println("Some error occured. Please contact the admin.");
	}
	public static void deleteFile()
	{
		//code for deleting a file
		String fileName;
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter file name to be deleted: ");
		fileName=obj.nextLine();
		
		boolean isDeleted=FileManager.deleteFile(folderpath, fileName);
		if(isDeleted)
			System.out.println("File deleted successfully");
		else
			System.out.println("Either file not present or some access issue");
	}
	public static void searchFile()
	{
		String fileName;
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter file name to be searched: ");
		fileName=obj.nextLine();
		
		boolean isFound=FileManager.searchFile(folderpath, fileName);
		if(isFound)
			System.out.println("File is present");
		else
			System.out.println("File is not present");
		
	}

}
