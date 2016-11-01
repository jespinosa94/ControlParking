import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Registrador {
	
	public static void main(String[] args) throws Exception {
		final Registry registro = LocateRegistry.getRegistry(1099);
		ObjetoRegistrador Objetoregistrador = new ObjetoRegistrador(registro);
		registro.rebind("/ObjetoRegistrador", Objetoregistrador);
		System.out.println("Registrador esperando a registrar...");
		Registrador registrador = new Registrador();
		synchronized(registrador) {
			try {
				registrador.wait();
			} catch(Exception e) {
				System.out.println("Error en la espera a registrar: " + e.toString());
			}
		}
	}
}
