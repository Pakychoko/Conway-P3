package modelo;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenada2DIncorrecta;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;

/**
 * Clase Coordenada que implementa la encapsulacion del objeto Coordenada de 2 Dimensiones
 * @author Faag1 48643667R Francisco Azorin Gil
 *
 */
public class Coordenada2D extends Coordenada{

	/**
	 * Posicion X (Columnas)
	 */
	private int x;
	/**
	 * Posicion Y (Filas)
	 */
	private int y;
	
	/**
	 * Constructor con columna(x) y fila(y) que crea un objeto Coordenada
	 * @param x (columna)
	 * @param y (fila)
	 * @throws ExcepcionCoordenadaIncorrecta 
	 */
	public Coordenada2D(int x, int y) throws ExcepcionCoordenadaIncorrecta {
		
		if(x<0 || y<0) throw new ExcepcionCoordenada2DIncorrecta(x,y);
		else {
			this.x = x;
			this.y = y;
		}
	
	}
	
	/**
	 * Constructor de Coordenada a traves de los datos de otro objeto coordenada
	 * @param c Coordenada
	 */
	public Coordenada2D(Coordenada2D c) throws ExcepcionArgumentosIncorrectos{
		
		if(c == null) throw new ExcepcionArgumentosIncorrectos();
		else {
			this.x = c.x;
			this.y = c.y;
		}

	}
	
	/**
	 * Constructor de Coordenada a traves de los datos de otro objeto coordenada
	 * @param c Coordenada
	 */
	public Coordenada2D(Coordenada d) throws ExcepcionArgumentosIncorrectos{
		
		Coordenada2D c = (Coordenada2D)d;
		
		if(c == null) throw new ExcepcionArgumentosIncorrectos();
		else {
			this.x = c.x;
			this.y = c.y;
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
	 * Getter Y
	 * @return y
	 */
	public int getY() { 
		return y; 
	}
	

	
	/**
	 * Transforma las coordenadas en cadena de caracteres
	 * @return Cadena de Caracteres de la Coordenada
	 */
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
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
		result = prime * result + y;
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
		Coordenada2D other = (Coordenada2D) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	

	/**
	 * Suma Coordenadas
	 * @param c Coordenada
	 * @return sumada 
	 */
	@Override
	public Coordenada suma(Coordenada c) throws ExcepcionCoordenadaIncorrecta, ExcepcionArgumentosIncorrectos{
		
		if(c == null) throw new ExcepcionArgumentosIncorrectos();
		else {
			Coordenada2D otra = (Coordenada2D)c;
			Coordenada2D sumada = new Coordenada2D(this.x + otra.x,this.y + otra.y );
			return sumada;
		}


	}


};
