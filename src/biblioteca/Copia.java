package biblioteca;


public class Copia extends Libro {

	private long id;
	
	private estadoCopia estado;
	
	private Libro libro;
	
	public Copia() {
		super();
	}
	
	public Copia(Libro libro) {
		super(libro.getTitulo(), libro.getTipo(), libro.getEditioral(), libro.getAnio(), libro.getNombreAutor());
		this.libro = libro;
		this.estado = estadoCopia.BIBLIOTECA;
	}		

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public estadoCopia getEstado() {
		return estado;
	}

	public void setEstado(estadoCopia estado) {
		this.estado = estado;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((libro == null) ? 0 : libro.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Copia other = (Copia) obj;
		if (libro == null) {
			if (other.libro != null)
				return false;
		} else if (!libro.equals(other.libro))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Copia [id=" + id + ", estado=" + estado + ", libroId=" + libro.getId() + " libro:" + libro.toString() + "]";
				
	}


	

}
