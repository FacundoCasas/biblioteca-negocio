package biblioteca;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
@WebService 
public class AutorService {
	
	@WebMethod(operationName="agregarAutor")
	public boolean agregarAutor(@WebParam(name="Autor")Autor autor) {
		AutorDAO dao = new AutorDAO();
		try {
			dao.agregarAutor(autor);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
