import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

public interface InterfazSensor extends Remote {
	public int GetVolumen() throws RemoteException; //Entre 0 y 100
	public LocalDate GetFechaActual() throws RemoteException; //fecha y hora interna del sistema
	public LocalDate GetFechaUltimoCambio() throws RemoteException;
	public int GetLED() throws RemoteException;
	public void SetLED(int valor, String s) throws RemoteException;
	public String leerSensor(String s) throws RemoteException;
	public String GetId() throws RemoteException;
}
