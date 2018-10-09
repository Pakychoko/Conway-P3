package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * Clase Tablero
 * @author Faag1-48643667
 * @date 25/09/2017
 *
 */
public abstract class Tablero {

		/**
		 * Variable miembro con las Dimensiones del Tablero
		 */
		protected Coordenada dimensiones;
		/**
		 * Variable miembro con un HashMap que contiene todas las celdas del Tablero
		 */
		protected HashMap<Coordenada,EstadoCelda> celdas;
		
		
		/**
		 * Guarda las dimensiones del tablero. 
		 * @param dimensiones Coordenadas de las Dimensiones del Tablero
		 */
		public Tablero(Coordenada dimensiones) throws ExcepcionArgumentosIncorrectos{
			
			if(dimensiones == null) throw new ExcepcionArgumentosIncorrectos();
			else {
				this.dimensiones = dimensiones;
			}
	
		
		}
		
		//METODOS GETTER y SETTER
		/**
		 * Retorna las dimensiones.
		 * @return dimensiones
		 */
		public Coordenada getDimensiones(){
			return this.dimensiones;
		}
		
		/**
		 * Retorna el conjunto de posiciones del tablero.
		 * @return posiciones
		 */
		public Collection<Coordenada> getPosiciones(){
			return celdas.keySet();
		}
		
		/**
		 * Devuelve el estado de la celda indicada por la posición. 
		 * @param posicion Coordenada Posicion
		 * @return EstadoCelda
		 * @throws ExcepcionPosicionFueraTablero 
		 */
		public EstadoCelda getCelda(Coordenada posicion) throws ExcepcionPosicionFueraTablero{
			
			if(posicion == null) throw new ExcepcionArgumentosIncorrectos();
			else {
				EstadoCelda estado = celdas.get(posicion);
				
				if(contiene(posicion)) {
					return estado;
				}else {
					throw new ExcepcionPosicionFueraTablero(dimensiones, posicion);
				}
			}

		
		}
		
		/**
		 * Asigna a la celda 'posicion' el estado de celda 'e', sobreescribiendo el valor si había ya alguno para ésta. 
		 * 
		 * @param posicion Coordenada Posicion
		 * @param e EstadoCelda
		 * @throws ExcepcionPosicionFueraTablero 
		 */
		public void setCelda(Coordenada posicion, EstadoCelda e) throws ExcepcionPosicionFueraTablero{
			
			if(posicion == null || e == null) throw new ExcepcionArgumentosIncorrectos();
			else {
				if(contiene(posicion)) {
					this.celdas.put(posicion, e);
				}else {
					throw new ExcepcionPosicionFueraTablero(dimensiones, posicion);
				}
			}

			
		}
		
		
		/**
		 * Metodo Abstracto de Posiciones Vecinas
		 * @param posicion
		 */
		public abstract ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion) throws ExcepcionPosicionFueraTablero;


		
		/**
		 * Carga un patron en el tablero
		 * @param patron Patron
		 * @param inicial Coordenada
		 * @return true/false Dependiendo si el patron cabe en el tablero o no.
		 * @throws ExcepcionPosicionFueraTablero 
		 * @throws ExcepcionCoordenadaIncorrecta 
		 * @throws ExcepcionArgumentosIncorrectos 
		 */
		public void cargaPatron(Patron patron,Coordenada inicial) throws ExcepcionPosicionFueraTablero, ExcepcionArgumentosIncorrectos, ExcepcionCoordenadaIncorrecta{
			
			if(patron == null || inicial == null) throw new ExcepcionArgumentosIncorrectos();
			else {
				Collection<Coordenada> pos = patron.getPosiciones();
				EstadoCelda estado;
				boolean cabePatron = true;
				
				//COMPRUEBO QUE NINGUNA COORDENADA DEL PATRON SE SALGA DEL TABLERO

				for (Coordenada comprobacion:pos) {
				
					if(!contiene(comprobacion.suma(inicial))) {

						cabePatron = false;
						throw new ExcepcionPosicionFueraTablero(dimensiones, comprobacion);
					}
				}
				
				
				//SI CONTIENE EJECUTO
				if(cabePatron) {
		
					for (Coordenada modificacion:pos) {
						
						estado = patron.getCelda(modificacion);
						setCelda(modificacion, estado);
							
					}
				}
			}
			
			
		}
		
		/**
		 * Devuelve cierto sólo si la posición está entre las celdas inicializadas del tablero.
		 * @param c Coordenada
		 * @return true/false 
		 */
		public boolean contiene(Coordenada c){
			
			if(c == null) throw new ExcepcionArgumentosIncorrectos();
			else {
				
				if(c instanceof Coordenada1D) {
					
					Coordenada1D c1 = (Coordenada1D) c;
					Coordenada1D d1 = (Coordenada1D) dimensiones;
					
					if(c1.getX() < d1.getX() && c1.getX() >= 0 ) {			
						return true;		
					}else {
						return false;
					}
					
				} else if(c instanceof Coordenada2D) {
					
					Coordenada2D c2 = (Coordenada2D) c;
					Coordenada2D d2 = (Coordenada2D) dimensiones;
					
					if(c2.getX() < d2.getX() && c2.getX() >= 0 && c2.getY() < d2.getY() && c2.getY() >= 0) {			
						return true;
					}else {
						return false;
					}
					
				}else {
					return false;
				}
			}
			
			

		}
		
		
}
		
		

