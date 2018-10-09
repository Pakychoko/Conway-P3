package modelo.excepciones;

/**
 * Clase que recoge las excepciones de las coordenadas de 1D incorrectas
 * @author fran
 *
 */
public class ExcepcionCoordenada1DIncorrecta extends ExcepcionCoordenadaIncorrecta {

	/**
	 * Variable Miembro Coordenada X
	 */
	private int x;
	
	/**
	 * Constructor: Crea la excepcion dando el valor X recibido
	 * @param x
	 */
	public ExcepcionCoordenada1DIncorrecta(int x) {
		this.x = x;
	}

	/**
	 * Metodo GET que devuelve la Coordenada
	 * @return Coordenada x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Metodo que devuelve un mensaje de error
	 * @return Mensaje de Error
	 */
	public String getMessage() {
		return "Error: Coordenada de 1D Incorrecta";
	}
}
