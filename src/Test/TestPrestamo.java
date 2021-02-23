package Test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import biblioteca.Copia;
import biblioteca.Lector;
import biblioteca.Libro;
import biblioteca.Prestamo;
import biblioteca.tipoLibro;
import excepciones.PrestamoNoVencido;

public class TestPrestamo {

	private Prestamo prestamoNoVencido;
	private Prestamo prestamoVencido;
	private Date hoy = new Date();
	private Date ayer = new Date(hoy.getTime() - Long.valueOf(86400000));
	private Lector lectorB;
	private Copia copia;
	@Before
	public void setUp() throws Exception {
		lectorB = new Lector(25,"Lucas","485523364","Js olivos");
		copia = new Copia(new Libro("Principito", tipoLibro.NOVELA, "Cabka", 1997, "LV"));
		prestamoNoVencido = new Prestamo(hoy,lectorB,copia);
		prestamoVencido = new Prestamo(hoy,lectorB,copia);
		prestamoVencido.setFin(ayer);
	}

	@Test
	public void milisegundosSinVencer() throws PrestamoNoVencido {
		try {
			prestamoNoVencido.milisegundosVencidos();
		} catch (PrestamoNoVencido e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	
	@Test
	public void milisegundosVencidos() throws PrestamoNoVencido {
		System.out.println(prestamoVencido.milisegundosVencidos());
	}
	
}
