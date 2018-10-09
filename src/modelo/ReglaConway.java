/**
 * 
 */
package modelo;

import java.util.ArrayList;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * Clase ReglaConway
 * @author Faag1-48643667
 *
 */
public class ReglaConway extends Regla{
	
	/**
	 * Constructor de la Regla Conway
	 */
	public ReglaConway() {
		
	}

	/**
	 * Metodo que calcula el siguiente estado de la celda. Reglas:
	 * - Una celda viva con dos o tres vecinas vivas seguira viviendo, en caso contrario morira.
	 * - Una celda muerta con exactamente tres vecinas vivas pasara a estar viva, si no seguira estando muerta.
	 * @param tablero Tablero
	 * @param posicion Coordenada
	 * @return EstadoCelda
	 * @throws ExcepcionPosicionFueraTablero 
	 */
	public EstadoCelda calculaSiguienteEstadoCelda(Tablero tablero, Coordenada posicion) throws ExcepcionPosicionFueraTablero {
		
		if(tablero == null || posicion == null) throw new ExcepcionArgumentosIncorrectos();
		else {
			
			EstadoCelda estado = tablero.getCelda(posicion);
			ArrayList<Coordenada> vecinas = tablero.getPosicionesVecinasCCW(posicion);
			EstadoCelda estadoVecina;
			
			
			//SI LA CELDA ESTA VIVA
			if(estado == EstadoCelda.VIVA) {
				
				int vivas = 0;
				
				for(Coordenada vecina:vecinas) {
						
					estadoVecina = tablero.getCelda(vecina);
						
					if(estadoVecina == EstadoCelda.VIVA) {
						vivas++;
					}
				}
					

				if(vivas >= 2 && vivas <= 3) {
					return estado;
				}else {
					return EstadoCelda.MUERTA;
				}
				
			//SI LA CELDA ESTA MUERTA
			}else if(estado == EstadoCelda.MUERTA) {
				
				int vivas = 0;
				
				for(Coordenada vecina:vecinas) {
					
					estadoVecina = tablero.getCelda(vecina);
					
					if(estadoVecina == EstadoCelda.VIVA) {
						vivas++;
					}				
				}

				
				if(vivas == 3) {
					return EstadoCelda.VIVA;
				}else {
					return estado;
				}
				
			}else {
				return estado;
			}
			
			
		}
		
		
		
		

	}
}
