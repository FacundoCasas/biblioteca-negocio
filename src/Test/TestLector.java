package Test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import biblioteca.Autor;
import biblioteca.Biblioteca;
import biblioteca.Lector;
import biblioteca.Libro;
import biblioteca.Multa;
import biblioteca.Prestamo;
import biblioteca.tipoLibro;
import excepciones.NoPuedePedir;
import excepciones.NoTieneLaCopia;
import excepciones.PrestamoNoVencido;

public class TestLector {
	
	private Biblioteca bib;
	private Lector lectorB;
	private Date hoy = new Date();
	private Date ayer = new Date(hoy.getTime() - Long.valueOf(86400000));
	private Libro principito;
	private Libro hp;
	private Libro lk;
	private Libro novel;
	
	@Before
	public void setUp() throws Exception {
		this.bib = new Biblioteca();		
		this.lectorB = new Lector(25,"Lucas","485523364","Js olivos");
		Autor autor1 = new Autor("Lovekraft","Ingles",new Date());
		principito = new Libro("Principito", tipoLibro.NOVELA, "Cabka", 1997, autor1.getNombre());
		hp = new Libro("HP", tipoLibro.NOVELA, "Cabka", 1997, autor1.getNombre());
		lk = new Libro("LK", tipoLibro.NOVELA, "Cabka", 1997, autor1.getNombre());
		novel = new Libro("Novel", tipoLibro.NOVELA, "Cabka", 1997, autor1.getNombre());
		
		bib.anadirLibro(principito);
		bib.anadirLibro(principito);
		bib.anadirLibro(hp);
		bib.anadirLibro(lk);
		bib.anadirLibro(novel);		
	}
	
	
	//Multamos a el lectorA multiples veces vencemos sus multas y vemos si al pedir lo desmulta
	@Test
	public void DesmultarMultiple() throws NoTieneLaCopia, PrestamoNoVencido {
		try {
			bib.prestarLibro(principito, lectorB);
			bib.prestarLibro(hp, lectorB);
			lectorB.getPrestamos().get(0).setFin(ayer);
			lectorB.getPrestamos().get(1).setFin(ayer);
			lectorB.listarPrestamos();
			
			System.out.println();
			
			//devolvemos los libros para crear las multas 
			
			bib.recibirLibro(lectorB.getPrestamos().get(0), lectorB);
			bib.recibirLibro(lectorB.getPrestamos().get(0), lectorB);
			lectorB.listarMultas();
			
			System.out.println();
			//vencemos las multas
			
			System.out.println();
			
			lectorB.getMultas().get(0).setfFin(ayer);
			lectorB.getMultas().get(1).setfFin(ayer);
			bib.prestarLibro(lk, lectorB);
			
			System.out.println();
			
			lectorB.listarMultas();											
			lectorB.listarPrestamos();
		} catch (NoPuedePedir e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NoTieneLaCopia a) {
			// TODO Auto-generated catch block
			a.printStackTrace();
		}
				
	}

	@Test
	public void NoPuedePedirMas3() throws NoPuedePedir, PrestamoNoVencido {
		try {
			lectorB.getPrestamos().add(new Prestamo(hoy, lectorB, bib.getCopiasStock().get(0)));
			lectorB.getPrestamos().add(new Prestamo(hoy, lectorB, bib.getCopiasStock().get(1)));
			lectorB.getPrestamos().add(new Prestamo(hoy, lectorB, bib.getCopiasStock().get(2)));
			lectorB.NoPuedePedir();
		} catch (excepciones.NoPuedePedir e) {
			e.getMessage();
		}
	}

	@Test
	public void NoPuedePedirPorMulta() throws NoPuedePedir, PrestamoNoVencido {
		try {
			lectorB.getPrestamos().add(new Prestamo(hoy, lectorB, bib.getCopiasStock().get(0)));
			lectorB.getPrestamos().get(0).setFin(ayer);
			lectorB.getMultas().add(new Multa(lectorB, lectorB.getPrestamos().get(0)));
			lectorB.listarMultas();
			lectorB.NoPuedePedir();
		} catch (excepciones.NoPuedePedir e) {
			e.getMessage();
		}
	}

	@Test
	public void CreaUnaMultaConUnPrestamoNoVencido() throws NoPuedePedir, PrestamoNoVencido {
		try {
			lectorB.getPrestamos().add(new Prestamo(hoy, lectorB, bib.getCopiasStock().get(0)));
			lectorB.getMultas().add(new Multa(lectorB, lectorB.getPrestamos().get(0)));
			lectorB.listarMultas();
			lectorB.NoPuedePedir();
		} catch (excepciones.NoPuedePedir e) {
			e.getMessage();
		} catch (PrestamoNoVencido a) {
			a.getMessage();
		}
	}

	@Test
	public void DesmultarMultasActivas() throws PrestamoNoVencido, NoTieneLaCopia {
		try {
			lectorB.getPrestamos().add(new Prestamo(hoy, lectorB, bib.getCopiasStock().get(0)));
			lectorB.getPrestamos().add(new Prestamo(hoy, lectorB, bib.getCopiasStock().get(0)));
			lectorB.getPrestamos().add(new Prestamo(hoy, lectorB, bib.getCopiasStock().get(0)));
			lectorB.getPrestamos().get(0).setFin(ayer);
			lectorB.getPrestamos().get(1).setFin(ayer);
			lectorB.getPrestamos().get(2).setFin(ayer);
			bib.recibirLibro(lectorB.getPrestamos().get(0), lectorB);
			bib.recibirLibro(lectorB.getPrestamos().get(0), lectorB);
			bib.recibirLibro(lectorB.getPrestamos().get(0), lectorB);
			lectorB.getMultas().get(0).setfFin(ayer);
			lectorB.getMultas().get(1).setfFin(ayer);
			lectorB.getMultas().get(2).setfFin(ayer);
			lectorB.listarMultas();
			lectorB.NoPuedePedir();
		} catch (excepciones.NoPuedePedir e) {
			e.getMessage();
		}
	}


}
