import java.rmi.Naming;
import java.util.Scanner;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class YalamanchiliP2Client 
{
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args)
	{
		System.out.println("Enter username and password ");
		Scanner sc=new Scanner(System.in);
		String username=sc.nextLine();
		String password=sc.nextLine();
		
		try 
		{
			Registry registry = LocateRegistry.getRegistry();
			YalamanchiliP2XXXXInterface remObj=(YalamanchiliP2XXXXInterface) registry.lookup("Testing2");
			int option;
			String res=remObj.authentication(username,password);
			System.out.println("User details:");
			String flag;
			if(res!=null)
			{
				do
				{
					System.out.println("Enter the Choice\n1. Buy\n2. Sell\n3. View  \n");
					System.out.println("Enter from the above option");
					option=sc.nextInt();
					switch(option)
					{
						case 1:
							System.out.println("Enter crypto name to Buy:");
							String cName = sc.next();
                					System.out.println("Enter number of coins you wish to purchase:");
							double cVolume = sc.nextDouble();
							remObj.buyCoin(cName,cVolume);
							break;
						case 2:
							System.out.println("Enter crypto name to Sell:");
							String cName1 = sc.next();
               						System.out.println("Enter number of coins you wish to Sell:");
							double cVolume1 = sc.nextDouble();
							remObj.sellCoin(cName1,cVolume1);
							break;
						case 3:
							remObj.displayCoins();
							break;
						default:
							System.out.println("Select from the given options only");
							break;
					}
					System.out.println("Do you wish to continue: Yes  or  No");
					flag=sc.next();
				}while(flag.equals("Yes"));
			}
			else
			{
				System.out.println("Please enter valid user information");
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
	}

}
