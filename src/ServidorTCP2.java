import java.net.*;
import java.io.*;

public class ServidorTCP2 {

	public static void main (String[] args) throws Exception {

		int numPort = 60000;
		ServerSocket servidor = new ServerSocket(numPort);
		String cadena = "";
		// Declarem la variable numClients per a indicar 
		// el max de clients que rebra el servidor
		
		int numClients = 3;

		// Determinem les vegades que es conectaran els clients
		for (int i = 0; i < numClients; i++) {

			Socket clientConnectat = null;
			PrintWriter fsortida = null;
			BufferedReader fentrada = null;
			
			System.out.println("Esperant connexi�... ");
			clientConnectat = servidor.accept();
			System.out.println("Client " + (i+1) + " connectat... ");

			//FLUX DE SORTIDA AL CLIENT
			fsortida = new PrintWriter(clientConnectat.getOutputStream(), true);


			//FLUX D'ENTRADA DEL CLIENT
			fentrada = new BufferedReader(new InputStreamReader(clientConnectat.getInputStream()));
		
			while ((cadena = fentrada.readLine()) != null) {

				fsortida.println(cadena);
				System.out.println("Rebent: "+cadena);
				if (cadena.equals("*")) break;

			}
			fentrada.close();
			fsortida.close();
			clientConnectat.close();
		}


		//TANCAR STREAMS I SOCKETS
		System.out.println("Tancant connexi�... ");
//		fentrada.close();
//		fsortida.close();
//		clientConnectat.close();
		servidor.close();

	}

}