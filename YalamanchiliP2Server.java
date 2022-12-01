import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class YalamanchiliP2Server
{	
	YalamanchiliP2Server() throws RemoteException 
	{
		super();
	}
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception 
	{
		try
		{
			char ch;
			Scanner sc=new Scanner(System.in);
			YalamanchiliP2XXXXService service=new YalamanchiliP2XXXXService();
			YalamanchiliP2XXXXInterface stub=(YalamanchiliP2XXXXInterface) UnicastRemoteObject.exportObject(service, 0);
			Registry registry = LocateRegistry.getRegistry(); 
			registry.bind("Testing2", service);
			do
			{
			System.out.println("Do you want to do any of the following operations on coins:\n1.Add Coin\n2.Edit Coin\n3.Remove Coin\n4.Display Coin\nEnter the option that you want to perform:");
			int input=sc.nextInt();
			switch(input)
			{
				case 1:	
					System.out.println("Enter coin name");
					String coinName=sc.next();
					coinName=coinName.toLowerCase();

					System.out.println("Enter coin abbreviation");
					String cAbbriviation=sc.next();
					cAbbriviation=cAbbriviation.toLowerCase();

					System.out.println("Enter coin Descripton");
					String cDescripton=sc.next();
					cDescripton=cDescripton.toLowerCase();

					System.out.println("Enter coin MarketCap");
					double cMarketCap=sc.nextDouble();

					System.out.println("Enter coin Volume");
					double cVolume=sc.nextDouble();

					System.out.println("Enter coin OpenPrice");
					double cOpenPrice=sc.nextDouble();	
	
					String coinData=coinName+"\t"+cAbbriviation+"\t"+cDescripton+"\t"+cMarketCap+"\t"+cVolume+"\t"+cOpenPrice;
					service.addCoin(coinData);
					break;
				case 2:
					System.out.println("Enter coin name to be modified");
					String mName=sc.next();
					mName=mName.toLowerCase();

					System.out.println("Enter coin abbreviation");
					String mAbbriviation=sc.next();
					mAbbriviation=mAbbriviation.toLowerCase();

					System.out.println("Enter coin Descripton");
					String mDescripton=sc.next();
					mDescripton=mDescripton.toLowerCase();

					System.out.println("Enter coin MarketCap");
					double mMarketCap=sc.nextDouble();

					System.out.println("Enter coin Volume");
					double mVolume=sc.nextDouble();

					System.out.println("Enter coin OpenPrice");
					double mOpenPrice=sc.nextDouble();	
	
					String result=mName+"\t"+mAbbriviation+"\t"+mDescripton+"\t"+mMarketCap+"\t"+mVolume+"\t"+mOpenPrice;

					service.modifyCoin(mName,result);
					break;
				case 3:
					System.out.println("Enter the coin to remove");
					String removeCoin=sc.next();
					service.removeCoin(removeCoin,"remove");
					break;
				case 4:
					service.displayCoins();
					break;
				default:
					System.out.println("Select from the given options only");
					break;
			}
			System.out.println("Do you want to perform any other operations:");
			ch=(char)System.in.read();
		}while(ch=='y');
		System.out.println("Waiting for client connection..........");
		}
		catch(Exception e)
		{
			System.err.println("Server exception: " + e.toString()); 
		}
		
	}
	
}
