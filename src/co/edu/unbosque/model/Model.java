package co.edu.unbosque.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


/**

 * Esta clase determina la cantidad minima de saltos que son necesarios para llegar al objetivo

 *@author: Sergio A Sanabria Garcia, Santiago Cortes Motoa, Julian Santiago
 *          Cortes Gomez, Cristias Santiago Cruz

 * @version: 12/05/2022/


 */
public class Model {
	 /**

     * Método que devuelve el número minimo de saltos que se necesitan

     * @return El número de saltos

     */

	public int saltos(int m, int n, int p, int d, int q) {

		char[][] tablero = new char[m][n];
		inicializarArreglo(m, n, p, d, q, tablero);

		QueueItem inicio = new QueueItem(0, 0, 0);

		// posicion donde esta ubicada la liebre
		inicio.fila = 0;
		inicio.columna = 0;

		Queue<QueueItem> queue = new LinkedList<>();
		queue.add(new QueueItem(inicio.fila, inicio.columna, 0));

		// Arreglo para llevar un recuento de las casillas que ya se han visitado
		boolean[][] visitado = new boolean[tablero.length][tablero[0].length];

		// Se marca como visitado la posicion inicial
		visitado[0][0] = true;
		while (queue.isEmpty() == false) {

			QueueItem item = queue.remove();
			//Cuando se encuentra el objetivo, se devuelve la cantidad de saltos
			if (tablero[item.fila][item.columna] == 'd') {
				return item.distancia;
			}
			//Se mueve una posicion hacia arriba
			if (valido(item.fila - 1, item.columna, tablero, visitado)) {
				queue.add(new QueueItem(item.fila - 1, item.columna, item.distancia + 1));
				visitado[item.fila - 1][item.columna] = true;
			}
			//Se mueve una posicion hacia abajo
			if (valido(item.fila + 1, item.columna, tablero, visitado)) {
				queue.add(new QueueItem(item.fila + 1, item.columna, item.distancia + 1));
				visitado[item.fila + 1][item.columna] = true;
			}
			//Se mueve una posicion hacia la izquierda 
			if (valido(item.fila, item.columna - 1, tablero, visitado)) {
				queue.add(new QueueItem(item.fila, item.columna - 1, item.distancia + 1));
				visitado[item.fila][item.columna - 1] = true;
			}
			//Se mueve una posicion hacia la derecha
			if (valido(item.fila, item.columna + 1, tablero, visitado)) {
				queue.add(new QueueItem(item.fila, item.columna + 1, item.distancia + 1));
				visitado[item.fila][item.columna + 1] = true;
			}

		}
		return -1;

	} //Cierre del método
	
	
	/**

     * Método que asigna los valores a la matriz


     */

	public void inicializarArreglo(int n, int m, int p, int d, int q, char tablero[][]) {

		if (d == 1) {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (i == q && j == p) {
						tablero[i][j] = 'd';
					} else {
						tablero[i][j] = '*';
					}

				}
			}
		} else {

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (i == p && j == q) {
						tablero[i][j] = 'd';
					} else {
						tablero[i][j] = '*';
					}

				}
			}
		}

	} //Cierre del método
	
	 /**

     * Método que devuelve si la posicion a la cual se desea mover es valida o no

     * @return true or false

     */
	

	public boolean valido(int x, int y, char tablero[][], boolean[][] visitado) {

		if (x >= 0 && y >= 0 && x < tablero.length && y < tablero[0].length && tablero[x][y] != '0'
				&& visitado[x][y] == false) {
			return true;
		}
		return false;

	} //Cierre del método

}//Cierre de la clase
