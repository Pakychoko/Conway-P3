package modelo.excepciones;

/**
 * Clase que recoge las excepciones de las coordenadas de 2D incorrectas
 * @author fran
 *
 */
public class ExcepcionCoordenada2DIncorrecta extends ExcepcionCoordenadaIncorrecta {

	/**
	 * Variable Miembro Coordenada X Erronea
	 */
	private int x;
	/**
	 * Variable Miembro Coordenada Y Erronea
	 */
	private int y;
	
	
	/**
	 * Constructor: Crea la excepcion dando el valor X e Y recibido
	 * @param x
	 * @param y
	 */
	public ExcepcionCoordenada2DIncorrecta(int x, int y) {
		
		this.x = x;
		this.y = y;
	}

	/**
	 * Metodo GET que devuelve la Coordenada X
	 * @return Coordenada x
	 */
	public int getX() {
		return x;
	}
	/**
	 * Metodo GET que devuelve la Coordenada Y
	 * @return Coordenada y
	 */
	public int getY() {
		return y;
	}


	/**
	 * Metodo que devuelve un mensaje de error
	 * @return Mensaje de Error
	 */	
	public String getMessage() {
		return "Error: Coordenada de 2D Incorrecta";
	}
}
