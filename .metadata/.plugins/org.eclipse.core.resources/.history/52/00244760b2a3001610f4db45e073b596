import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

public interface InterfazSensor extends Remote {
	public String GetVolumen() throws RemoteException; //Entre 0 y 100
	public String GetFechaActual() throws RemoteException; //fecha y hora interna del sistema
	public String GetFechaUltimoCambio() throws RemoteException;
	public String GetLED() throws RemoteException;
	public void SetLED(String valor, String s) throws RemoteException;
	public String leerSensor(String s) throws RemoteException;
	public String GetId() throws RemoteException;
}
