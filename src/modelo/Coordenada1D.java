package modelo;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenada1DIncorrecta;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

/**
 * Clase Coordenada que implementa la encapsulacion del objeto Coordenada de 1 Dimension
 * @author Faag1 48643667R Francisco Azorin Gil
 *
 */
public class Coordenada1D extends Coordenada{


	/**
	 * Posicion X (Columnas)
	 */
	private int x;

	
	/**
	 * Constructor con columna(x) que crea un objeto Coordenada
	 * @param x (columna)
	 * @throws ExcepcionCoordenadaIncorrecta 
	 */
	public Coordenada1D(int x) throws ExcepcionCoordenadaIncorrecta {
		
		if(x<0) throw new ExcepcionCoordenada1DIncorrecta(x);
		else {
			this.x = x;
		}

	}
	
	/**
	 * Constructor de Coordenada a traves de los datos de otro objeto coordenada
	 * @param c Coordenada
	 * @throws ExcepcionArgumentosIncorrectos
	 */
	public Coordenada1D(Coordenada1D c) throws ExcepcionArgumentosIncorrectos{
		
		if(c == null) throw new ExcepcionArgumentosIncorrectos();
		else{
			this.x = c.x;
		}
		
	}
	
	
	/**
	 * Getter X
	 * @return x
	 */
	public int getX(){ 
		return x; 
	}
	
	
	/**
	 * Transforma las coordenadas en cadena de caracteres
	 * @return Cadena de Caracteres de la Coordenada
	 */
	@Override
	public String toString() {
		return "(" + x + ")";
	}
	
	/**
	 * Metodo HashCode
	 * @return result
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		return result;
	}

	/**
	 * Metodo que compara dos Objetos de tipo Coordenadas
	 * @param obj Coordenada
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada1D other = (Coordenada1D) obj;
		if (x != other.x)
			return false;
		return true;
	}
	

	/**
	 * Suma Coordenadas
	 * @param c Coordenada
	 * @return sumada 
	 * @throws ExcepcionCoordenadaIncorrecta, ExcepcionArgumentosIncorrectos 
	 */
	@Override
	public Coordenada suma(Coordenada c) throws ExcepcionCoordenadaIncorrecta, ExcepcionArgumentosIncorrectos {
		
		if(c == null) throw new ExcepcionArgumentosIncorrectos();
		else {
			Coordenada1D otra = (Coordenada1D)c;
			Coordenada1D sumada = new Coordenada1D(this.x + otra.x);
			return sumada;
		}

	}




};
