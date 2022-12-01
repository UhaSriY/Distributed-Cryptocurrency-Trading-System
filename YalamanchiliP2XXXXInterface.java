import java.rmi.Remote;
import java.rmi.RemoteException;

public interface YalamanchiliP2XXXXInterface extends Remote
{
	void addCoin(String coinDatan) throws RemoteException;
	void modifyCoin(String cName,String totalString) throws RemoteException;
	void removeCoin(String removeCoin, String totalString) throws RemoteException;
	void displayCoins() throws RemoteException;
	void buyCoin(String cName,double cVolume) throws RemoteException;
	void sellCoin(String cName,double cVolume) throws RemoteException;
	String authentication(String username,String password)  throws RemoteException;
}
