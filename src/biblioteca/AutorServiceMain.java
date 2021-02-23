package biblioteca;

import jakarta.xml.ws.Endpoint;

public class AutorServiceMain {

	public static void main(String[] args) {				
		
		Endpoint endPoint = Endpoint.publish("http://localhost:8030/Autor", new AutorService());

	}

}

