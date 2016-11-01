import java.net.*;

public class ServidorController {
	public static void main(String[] args) {
		String puerto = "";
		
		try {
			if(args.length == 3) {
				puerto = args[0];
				ServerSocket skServidor = new ServerSocket(Integer.parseInt(puerto));
				
				System.out.println("Controller escucha en el puerto " + puerto);
				for(;;) {
					Socket skCliente = skServidor.accept();
					System.out.println("Controller sirve al cliente.");
					Thread t = new HiloController(skCliente, args[1], args[2]);
					t.start();
				}
			} else {
				System.out.println("Error en los argumentos del controlador, formato: [Puerto de escucha] [IP RMI] [PuertoRMI]");
			}
		} catch(Exception e) {
			System.out.println("Error procesando la petición (Hilo)" + e.toString());
		}
	}
}
