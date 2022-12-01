import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YalamanchiliP2XXXXService implements YalamanchiliP2XXXXInterface
{
	Scanner sc=new Scanner(System.in);

	YalamanchiliP2XXXXService() throws RemoteException 
	{
		super();
	}

	
	public void addCoin(String coinData) 
	{
		File fileToBeModified = new File("CoinList.txt");
		String oldContent = "";
        	BufferedReader reader = null;
        	FileWriter writer = null;
		try
        	{
            		reader = new BufferedReader(new FileReader(fileToBeModified));
            		String line = reader.readLine();
			while (line != null) 
            		{
				oldContent = oldContent + line + System.lineSeparator();
				line = reader.readLine();
            		}
			oldContent = oldContent + coinData;
			writer = new FileWriter(fileToBeModified);
            		writer.write(oldContent);
            		reader.close();
            		writer.close();
        	}
		catch(Exception e)
		{						
			System.out.print(e.getLocalizedMessage());		
		}
	}
	
	public void modifyCoin(String name,String totalString)
	{
		File fileToBeModified = new File("CoinList.txt");
		String oldContent = "";
        	BufferedReader reader = null;
       		FileWriter writer = null;
		String coin;
		try
        	{
            		reader = new BufferedReader(new FileReader(fileToBeModified));
            		String line = reader.readLine();
			while (line != null) 
            		{
				String[] strArray = line.split("\\s+");
				if(strArray[0].equals(name))
				{
					line=totalString;
				}
				oldContent = oldContent + line + System.lineSeparator();
				line = reader.readLine();
            		}
			writer = new FileWriter(fileToBeModified);
            		writer.write(oldContent);
            		reader.close();
            		writer.close();
        	}
		catch(Exception e)
		{							
			System.out.print(e.getLocalizedMessage());	
		}
	}
	
	public void displayCoins()
	{
		try 
		{
			FileInputStream fis=new FileInputStream("CoinList.txt");
			Scanner sc=new Scanner(fis);
			while(sc.hasNextLine())  
			{  
			  		String str=sc.nextLine();
			  		System.out.println(str);
			}
			fis.close();
		} 
		catch (Exception e) 	
		{	
			e.printStackTrace();		
		}
	}
	
	public void removeCoin(String removeCoin, String totalString) 
	{
		File fileToBeModified = new File("CoinList.txt");
		String oldContent = "";
        	BufferedReader reader = null;
        	FileWriter writer = null;
		String coin;
		try
        	{
            		reader = new BufferedReader(new FileReader(fileToBeModified));
            		String line = reader.readLine();
			while (line != null) 
            		{
				String[] strArray = line.split("\\s+");
				if(strArray[0].equals(removeCoin)&&totalString.equals("remove"))
				{
					line="";
				}
				oldContent = oldContent + line + System.lineSeparator();
				line = reader.readLine();		
            		}
			writer = new FileWriter(fileToBeModified);
            		writer.write(oldContent);
            		reader.close();
            		writer.close();
		}
		catch(Exception e)
		{							
			System.out.print(e.getLocalizedMessage());	
		}
			
	}

	public void buyCoin(String cName,double cVolume) 
	{
		File fileToBeModified = new File("CoinList.txt");
		String oldContent = "";
        	BufferedReader reader = null;
		double result;
       		FileWriter writer = null;
		String coin;
		try
        	{
            		reader = new BufferedReader(new FileReader(fileToBeModified));
            		String line = reader.readLine();
			while (line != null) 
            		{
				String[] strArray = line.split("\\s+");
				if(strArray[0].equals(cName)&&Double.parseDouble(strArray[4])>0)
				{
					result=Double.parseDouble(strArray[5])*cVolume;
					double remainingVolume=Double.parseDouble(strArray[4])-cVolume;
					System.out.println("You have successfully purchased "+cName+" of $"+result);
					//strArray[4]=String.valueOf(remainingVolume);
				}
				oldContent = oldContent + line + System.lineSeparator();
				//oldContent = strArray[4] + line + System.lineSeparator();
				line = reader.readLine();
				
            		}
			writer = new FileWriter(fileToBeModified);
            		writer.write(oldContent);
            		reader.close();
            		writer.close();
        	}
		catch(Exception e)
		{							
			System.out.print(e.getLocalizedMessage());	
		}
	}

	
	public void sellCoin(String cName,double cVolume) 
	{
		
		File fileToBeModified = new File("CoinList.txt");
		String oldContent = "";
        	BufferedReader reader = null;
		double result;
       		FileWriter writer = null;
		String coin;
		try
        	{
            		reader = new BufferedReader(new FileReader(fileToBeModified));
            		String line = reader.readLine();
			while (line != null) 
            		{
				String[] strArray = line.split("\\s+");
				if(strArray[0].equals(cName)&&Double.parseDouble(strArray[4])>0)
				{
					result=Double.parseDouble(strArray[5])*cVolume;
					double remainingVolume=Double.parseDouble(strArray[4])+cVolume;
					System.out.println("You have successfully sold"+cName+" of $"+result);
					//strArray[4]=String.valueOf(remainingVolume);
				}
				oldContent = oldContent + line + System.lineSeparator();
				//oldContent = strArray[4] + line + System.lineSeparator();
				line = reader.readLine();
				
            		}
			writer = new FileWriter(fileToBeModified);
            		writer.write(oldContent);
            		reader.close();
            		writer.close();
        	}
		catch(Exception e)
		{							
			System.out.print(e.getLocalizedMessage());	
		}
	}

	public String authentication(String username, String password) throws RemoteException 
	{
		String resultString = null;
		try 
		{
			FileInputStream fis=new FileInputStream("clientInfo.txt");   
			sc=new Scanner(fis);
			while(sc.hasNextLine())  
			{  			
				String str=sc.nextLine();
			  	String[] strArray = str.split("\\s+");
			 	if(strArray[0].equals(username)&&strArray[1].equals(password))
			  	{
			  		resultString=str;
			  		System.out.println("result string = "+resultString);
				}
			}
			fis.close();
		}
		catch (FileNotFoundException e) 
		{		
			e.printStackTrace(); 		
		} 
		catch (IOException e) 	
		{			
			e.printStackTrace();
		}
		resultString=resultString.replaceFirst(password, "********");
		return resultString;
	}

}
