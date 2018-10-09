package modelo;

import java.util.ArrayList;
import java.util.Collection;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionCoordenadaIncorrecta;
import modelo.excepciones.ExcepcionEjecucion;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * Clase TableroCeldasCuadradas
 */
public class TableroCeldasCuadradas extends Tablero2D {

	/**
	 * Constructor de TableroCeldasCuadradas
	 * @param ancho Ancho del Tablero
	 * @param alto Alto del Tablero
	 * @throws ExcepcionArgumentosIncorrectos
	 * @throws ExcepcionCoordenadaIncorrecta
	 */
	public TableroCeldasCuadradas(int ancho,int alto) throws ExcepcionArgumentosIncorrectos, ExcepcionCoordenadaIncorrecta {
		super(ancho,alto);
	}
	
	/**
	 * Devuelve un vector de posiciones en orden anti-horario de las celdas 
	 * vecinas a la especificada en el parámetro posición. 
	 * @param posicion Coordenada Posicion
	 * @return vecinas ArrayList con las Posicion Vecinas en Sentido AntiHorario
	 * @throws ExcepcionPosicionFueraTablero 
	 */
	@Override	
	public ArrayList<Coordenada> getPosicionesVecinasCCW(Coordenada posicion) throws ExcepcionPosicionFueraTablero {

		ArrayList<Coordenada> vecinas = new ArrayList<Coordenada>();
		
		if(posicion == null) throw new ExcepcionArgumentosIncorrectos();
		else {
			
			Coordenada2D pos = (Coordenada2D) posicion;
			Coordenada2D dim = (Coordenada2D) dimensiones;
			
			int x = pos.getX();
			int y = pos.getY();
			
			if(contiene(posicion))
			{
				try {
				
					if(x==0 && y==0) {
						//(0,0)
						vecinas.add(new Coordenada2D(x,y+1));
						vecinas.add(new Coordenada2D(x+1,y+1));
						vecinas.add(new Coordenada2D(x+1,y));
						
					}else if(x == dim.getX()-1 && y == dim.getY()-1){
						//(max,max)
						vecinas.add(new Coordenada2D(x-1,y-1));
						vecinas.add(new Coordenada2D(x-1,y));
						vecinas.add(new Coordenada2D(x,y-1));	
						
					}else if(x==0 && y == dim.getY()-1) {
						//(0,max)
						vecinas.add(new Coordenada2D(x+1,y));
						vecinas.add(new Coordenada2D(x+1,y-1));
						vecinas.add(new Coordenada2D(x,y-1));
					}else if(y==0 && x == dim.getX()-1) { 
						//(max,0)
						vecinas.add(new Coordenada2D(x-1,y));
						vecinas.add(new Coordenada2D(x-1,y+1));
						vecinas.add(new Coordenada2D(x,y+1));
					}else if(x==0){
						//(0,x)
						vecinas.add(new Coordenada2D(x,y+1));
						vecinas.add(new Coordenada2D(x+1,y+1));
						vecinas.add(new Coordenada2D(x+1,y));
						vecinas.add(new Coordenada2D(x+1,y-1));
						vecinas.add(new Coordenada2D(x,y-1));
						
					}else if(y==0) {
						//(x,0)
						vecinas.add(new Coordenada2D(x-1,y));
						vecinas.add(new Coordenada2D(x-1,y+1));
						vecinas.add(new Coordenada2D(x,y+1));
						vecinas.add(new Coordenada2D(x+1,y+1));
						vecinas.add(new Coordenada2D(x+1,y));				
					}else if(x == dim.getX()-1) {
						//(max,x)
						vecinas.add(new Coordenada2D(x-1,y-1));
						vecinas.add(new Coordenada2D(x-1,y));
						vecinas.add(new Coordenada2D(x-1,y+1));
						vecinas.add(new Coordenada2D(x,y+1));
						vecinas.add(new Coordenada2D(x,y-1));				
					}else if(y == dim.getY()-1) {
						//(x,max)
						vecinas.add(new Coordenada2D(x-1,y-1));
						vecinas.add(new Coordenada2D(x-1,y));
						vecinas.add(new Coordenada2D(x+1,y));
						vecinas.add(new Coordenada2D(x+1,y-1));
						vecinas.add(new Coordenada2D(x,y-1));				
					}else {
						//LAS DE EN MEDIO DEL TABLERO
						vecinas.add(new Coordenada2D(x-1,y-1));
						vecinas.add(new Coordenada2D(x-1,y));
						vecinas.add(new Coordenada2D(x-1,y+1));
						vecinas.add(new Coordenada2D(x,y+1));
						vecinas.add(new Coordenada2D(x+1,y+1));
						vecinas.add(new Coordenada2D(x+1,y));
						vecinas.add(new Coordenada2D(x+1,y-1));
						vecinas.add(new Coordenada2D(x,y-1));
					}
				
					return vecinas;
				
				}catch (ExcepcionCoordenadaIncorrecta e) {
					  throw new ExcepcionEjecucion(e); 
				} 
			
			}else {
				throw new ExcepcionPosicionFueraTablero(dimensiones, posicion);
			}
			
		}

	}
	
	/** 
	 * Devuelve una cadena con una representación del tablero como la mostrada en la Figura 2. 
	 * Las celdas vivas se mostrarán con un asterisco y las muertas con un espacio en blanco. 
	 * Los límites se representarán con los caracteres '+', '-' y '|'. 
	 * 
	 * @return String Muestra el Mapa
	 * 
	 **/
	@Override
	public String toString() {
		
		String representacion = new String();
		Collection<Coordenada> pos = getPosiciones();
		
		Coordenada2D dim = (Coordenada2D) dimensiones;
		
		int maxX = dim.getX() +1;
		int maxY = dim.getY() +1;
		EstadoCelda estado = EstadoCelda.MUERTA;
		
		
		for(int i = 0; i <= maxY; i++) {
			
			if(i == 0 || i == maxY) { 
				
				for(int j = 0; j <= maxX; j++) {
					
					if(j == 0) {
						representacion = representacion + ("+");
					}else if (j == maxX) {
						representacion = representacion + ("+\n");
					}else {
						representacion = representacion + ("-");
					}
				}
				
			}else {
				
				for(int j = 0; j <= maxX; j++) {
					
					if(j == 0) {
						representacion = representacion + ("|");
					}else if (j == maxX && i != 0) {
						representacion = representacion + ("|\n");
					}else if (j == maxX && i == 0) {
						representacion = representacion + ("|\n");
					}else {

						representacion = representacion + ("*");
						//EstadoCelda estado = getCelda(pos.iterator().next());

					}
				}
			}

		}
		
		
		for(Coordenada celda:pos) {
			
			try {
				estado = getCelda(celda);
				
			} catch (ExcepcionPosicionFueraTablero e) {
				throw new ExcepcionEjecucion();
			}
			
			Coordenada2D c = (Coordenada2D) celda;
			int x = c.getX();
			int y = c.getY();
		
			
			//COLUMNA * FILA + POS
			int anterior = ((y+1)*(maxX+2)) + (x+1);
			int posterior = ((y+1)*(maxX+2)) + (x+2);


			String delante = representacion.substring(0,anterior);
			String detras = representacion.substring(posterior,representacion.length());
			

			switch(estado) {
				case MUERTA: representacion = delante +' '+ detras;break;
				case VIVA: representacion = delante +'*'+ detras; break;
			}
			
			//System.out.println(representacion);
		}
		
		
		return representacion;
	}
}
