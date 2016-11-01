import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ObjetoRegistrador extends UnicastRemoteObject implements InterfazRegistrador {
	private final Registry registro;
	public ObjetoRegistrador(Registry registro) throws RemoteException {
		super();
		this.registro = registro;
	}

	public void registrarSensor(InterfazSensor objetoSensor) throws RemoteException {
		String URLRegistro = "";
		//Habria que hacer un InterfazSensor sensor=null y despues hacer un lookup, pero no se puyede hacer lookup porque esto es para registrar
		try {
			URLRegistro = "/ObjetoSensor" + objetoSensor.GetId();
			System.out.println("El sensor se registra como " + URLRegistro);
			registro.rebind(URLRegistro, objetoSensor);
			System.out.println("Servidor de objeto preparado");
		} catch(Exception e) {
			System.out.println("Error al intentar registrar el sensor" + e.toString());
		}
	}
}
