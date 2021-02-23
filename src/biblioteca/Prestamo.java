package biblioteca;

import java.util.Date;

import excepciones.PrestamoNoVencido;

public class Prestamo {

	private Date inicio;
	private Date fin;
	private Lector lector;
	private Copia copia;

	@SuppressWarnings("deprecation")
	public Prestamo(Date inicio, Lector lector, Copia copia) {
		this.inicio = inicio;
		this.fin = new Date(inicio.getYear(), inicio.getMonth() + 1, inicio.getDate());
		this.lector = lector;
		copia.setEstado(estadoCopia.PRESTADO);
		this.copia = copia;
	}

	public long milisegundosVencidos() throws PrestamoNoVencido {
		long milFinal = this.fin.getTime();
		long milHoy = new Date().getTime();
		if (milHoy < milFinal) {
			throw new PrestamoNoVencido("Aun no vencio el Prestamo");
		} else {
			return ((milHoy - milFinal) * 2) + milHoy;
		}
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public Lector getLector() {
		return lector;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
	}

	public Copia getCopia() {
		return copia;
	}

	public void setCopia(Copia copia) {
		copia.setEstado(estadoCopia.PRESTADO);
		this.copia = copia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((copia == null) ? 0 : copia.hashCode());
		result = prime * result + ((fin == null) ? 0 : fin.hashCode());
		result = prime * result + ((inicio == null) ? 0 : inicio.hashCode());
		result = prime * result + ((lector == null) ? 0 : lector.hashCode());
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
		Prestamo other = (Prestamo) obj;
		if (copia == null) {
			if (other.copia != null)
				return false;
		} else if (!copia.equals(other.copia))
			return false;
		if (fin == null) {
			if (other.fin != null)
				return false;
		} else if (!fin.equals(other.fin))
			return false;
		if (inicio == null) {
			if (other.inicio != null)
				return false;
		} else if (!inicio.equals(other.inicio))
			return false;
		if (lector == null) {
			if (other.lector != null)
				return false;
		} else if (!lector.equals(other.lector))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Prestamo [inicio=" + inicio + ", fin=" + fin + ", lector=" + lector.getNombre() + ", copia="
				+ copia.getTitulo() + "" + copia.getId() + "]";
	}

}
