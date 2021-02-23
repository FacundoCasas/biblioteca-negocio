package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Libro {
	
	private long id;
	

	private String titulo;
	

	private tipoLibro tipo;
	

	private String editioral;
	

	private int anio;
	

	private String nombreAutor;
	
	private List<Copia> copias;
	
	private Biblioteca biblioteca;
	
	public Libro(String titulo, tipoLibro tipo, String editioral, int anio,String nombreAutor) {
		this.titulo = titulo;
		this.tipo = tipo;
		this.editioral = editioral;
		this.anio = anio;
		this.nombreAutor = nombreAutor;
		copias = new ArrayList<Copia>();
	}


	public Libro() {
		
	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public tipoLibro getTipo() {
		return tipo;
	}

	public void setTipo(tipoLibro tipo) {
		this.tipo = tipo;
	}

	public String getEditioral() {
		return editioral;
	}

	public void setEditioral(String editioral) {
		this.editioral = editioral;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getNombreAutor() {
		return nombreAutor;
	}


	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}


	public List<Copia> getCopias() {
		return copias;
	}

	public void setCopias(List<Copia> copias) {
		this.copias = copias;
	}	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Biblioteca getBiblioteca() {
		return biblioteca;
	}


	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anio;
		result = prime * result + ((editioral == null) ? 0 : editioral.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (anio != other.anio)
			return false;
		if (editioral == null) {
			if (other.editioral != null)
				return false;
		} else if (!editioral.equals(other.editioral))
			return false;
		if (tipo != other.tipo)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", tipo=" + tipo + ", editioral=" + editioral + ", anio=" + anio
				+ ", id=" + id +"]";
	}
	
	
}
