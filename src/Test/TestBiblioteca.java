package Test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import biblioteca.Autor;
import biblioteca.Biblioteca;
import biblioteca.Copia;
import biblioteca.Lector;
import biblioteca.Libro;
import biblioteca.tipoLibro;
import excepciones.NoPuedePedir;
import excepciones.NoTieneLaCopia;
import excepciones.PrestamoNoVencido;

public class TestBiblioteca {
	
	private Biblioteca bib;
	private Lector lectorA;
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
		this.lectorA = new Lector(15,"Jorge","485523364","Js olivos");
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

	// Que pasa si pido mas de 3 libros
	@Test
	public void testPrestarMasDe3() throws PrestamoNoVencido, NoTieneLaCopia {
		try {
			for (Libro libro : this.bib.getLibrosTotales()) {
				System.out.println(bib.prestarLibro(libro, this.lectorA));
				lectorA.listarPrestamos();
			}
		} catch (NoPuedePedir e) {
			e.getMessage();
		}
	}

	// Pedir 3, devolver 1 y pedir 1 de nuevo
	@Test

	public void testPedirYDevolver() {
		try {
			bib.prestarLibro(principito, lectorA);
			bib.prestarLibro(hp, lectorA);
			bib.prestarLibro(lk, lectorA);
			bib.recibirLibro(lectorA.getPrestamos().get(2), lectorA);
			bib.prestarLibro(novel, lectorA);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// la multa no tiene fecha por eso tira error o analizar el por que y generearla
	// desde un prestamo

	@Test

	public void pedirConMulta() {
		try {
			bib.prestarLibro(principito, lectorB);
			lectorB.getPrestamos().get(0).setFin(ayer);
			bib.prestarLibro(principito, lectorB);
			lectorB.listarPrestamos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}

	//puedo mandar una copia inexistente en el sistema y me va a buscar una que este en el mismo
	@Test

	public void buscadorCopiaEnBib() {
		try {
			Copia copiaBuscada = bib.getCopiasStock().get(0);
			Copia NuevaCopia = new Copia(principito);
			NuevaCopia.setId(6);
			assertTrue(copiaBuscada == bib.buscadorCopiaEnBib(NuevaCopia));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//le paso una copia que fue prestada y devuelve una igual pero de distinto id y que esta en la biblioteca 
	@Test 
	
	public void buscadorCopiaDisponible() throws NoPuedePedir, PrestamoNoVencido, NoTieneLaCopia {
		Copia copiaRespuestaDeseada = bib.getCopiasStock().get(1);
		Copia copiaMandadaPorParametro = bib.getCopiasStock().get(0);
		bib.prestarLibro(principito, lectorB);
		Copia buscadaEnLaBiblioteca = bib.buscadorCopiaDisponible(copiaMandadaPorParametro);	
		System.out.println("copiaRespuestaDeseada: " + copiaRespuestaDeseada.toString());
		System.out.println("copiaMandadaPorParametro: " + copiaMandadaPorParametro.toString());
		System.out.println("buscadaEnLaBiblioteca: " + buscadaEnLaBiblioteca.toString());
		assertTrue(copiaRespuestaDeseada == buscadaEnLaBiblioteca);
	}
}
