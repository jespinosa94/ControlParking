import java.rmi.RemoteException;
import java.rmi.Remote;

public interface InterfazRegistrador extends Remote {
	public void registrarSensor(InterfazSensor sensor) throws RemoteException;
}
