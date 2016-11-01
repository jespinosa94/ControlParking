import java.rmi.RMISecurityManager;
import java.rmi.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RegistradorSensor {
	public static void main(String args[]) throws RemoteException {
		final String ipRegistrador = args[1];
		final String idSensor = args[0];
		final String URLRegistro = "";
		final Registry registro = LocateRegistry.getRegistry(ipRegistrador, 1099); //Devuelve el objeto remoto Registry del host indicado (rmiregistry lanzado en terminal en este caso)
		
		if(args.length == 2) {
			try {
				System.setSecurityManager(new RMISecurityManager());
				ObjetoSensor objetoSensor = new ObjetoSensor(idSensor);
				
				System.out.println("Sensor" + idSensor + " creado");
				System.out.println("Registrando " + idSensor + " a través del Registrador");
				final InterfazRegistrador objetoRegistrador = (InterfazRegistrador) registro.lookup("/ObjetoRegistrador"); //busca en el rmiregistry el objeto registrador y llama al metodo registrar para que este pueda registrar el ObjetoSensor en local
				objetoRegistrador.registrarSensor(objetoSensor);
				System.out.println("Sensor" + idSensor + " registrado");
			} catch (Exception e) {
				System.out.println("Error registrando el objeto: " + e);
			}
		} else {
			System.out.println("Error de sintaxis: [idSensor] [ipRegistrador]");
			System.exit(1);
		}
	}
}
