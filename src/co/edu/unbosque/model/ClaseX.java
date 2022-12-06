package co.edu.unbosque.model;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

/**

 * Esta clase muestra la cantidad de calorias que se pueden consumir segun unos platos registrados previamente

 * @author: Sergio A Sanabria Garcia, Santiago Cortes Motoa, Juñlian Santiago Cortes Gomez

 * @version: 5/12/2022

 */

public class ClaseX {

	public static int I = 0;
	
	/**

     * Metodo que encuentra el valor minimo entre dos numeros

     * @param a El parámetro a un numero a comparar
     
     * @param b El parámetro b un numero a comparar
     
     * @return El número de menor entre a y b

     */
	static int Min(int a, int b) {
		return (b < a) ? b : a;
	}

	/**

     * Metodo que calcula y genera todas las posibilidades de platos y añade las posibilidades en una matriz

     * @param lista El parámetro lista es la lista de platos con sus calorias correspondientes
     
     * @param N El parámetro N es el tamaño de la lista
     * 
     * @param C El parámetro C es la cantidad de calorias 
     
     * @return La matriz de las posibles soluciones para llegar a las calorias deseadas

     */
	public static int[][] Calcular(int[] lista, int N, int C) {
		
		int MaxElem = N + 1;
		int MaxCant = C + 1;
		
		//establece el tamaño de la matriz 
		int[][] tabla = new int[MaxElem][MaxCant];

		//llena la matriz inicial
		for (int i = 0; i < MaxElem; i++) {
			tabla[i][0] = 0;
		}
		for (int i = 1; i < MaxCant; i++) {
			tabla[0][i] = I;
		}

		
		
		int a, b;
		for (int i = 1; i < MaxElem; i++) {
			for (int j = 1; j < MaxCant; j++) {
				a = tabla[i - 1][j];
				if (lista[i - 1] <= j) {
					b = tabla[i - 1][j - lista[i - 1]];
					if (b < I)
						b += lista[i - 1];
				} else {
					b = lista[i - 1];
				}
				if (b >= j) {
					tabla[i][j] = Min(a, b);
				} else {
					tabla[i][j] = I;
				}
			}
		}
		return tabla;
	}

	/**

     * Metodo que organiza que platos son los adecuados para la solucion del problema

     * @param t El parámetro t es la matriz con las posibles soluciones del plato
     
     * @param l El parámetro l es la array con los platos y sus calorias
     * 
     * @param N El parámetro N es el tamaño o la cantidad de platos
     * 
     * @param C El parámetro C es la cantidad de calorias 
     
     * @return La array de objetos con los platos que satisfacen la problematica

     */
	private static Object[] Resultado(int[][] t, int[] l, int N, int C) {
		List<Integer> r = new ArrayList<Integer>();
		int i = N;
		int j = C;

		while (i > 0 && j > 0) {
			if (t[i][j] == t[i - 1][j]) {
				i--;
			} else {
				r.add(i - 1);
				j -= l[i - 1];
				i--;
			}
		}
		System.out.println("Contenido de resultado");
		for(int p = 0; p<r.size();p++) {
		  System.out.println(r.get(p));
		}
		return r.toArray();
	}

	/**

     * Metodo que resuelve e imprime la cantidad de platos que se necesitan y la cantidad de calorias que se consumen

     * @param lista El parámetro lista es la lista de platos con sus calorias correspondientes
     
     * @param C El parámetro C es el tamaño de la lista

     */
	
	public static void Resolver(int[] lista, int C) {
		
		int[][] tabla = Calcular(lista, lista.length, C);

		for (int i = 0; i < tabla.length; ++i) {
			for (int j = 0; j < tabla[0].length; ++j) {
				System.out.print("[" + tabla[i][j] + "]");
			}
			System.out.println();
		}
		Object[] r = Resultado(tabla, lista, lista.length, C);

		System.out.println("Lista :");
		for (int i : lista) {
			System.out.print("[" + i + "]");
		}

		System.out.println();

		Formatter f = new Formatter();
		f.format("Total a consumir: %s calorías", C);
		System.out.println(f.toString());

		int suma = 0;

		for (Object n : r) {
			int valor = (Integer) n;
			suma += lista[valor];
			Formatter f1 = new Formatter();
			f1.format("Plato %s = %s calorías", valor + 1, lista[valor]);
			System.out.println(f1.toString());
		}
		Formatter f2 = new Formatter();
		f2.format("Total consumido:  %s calorías", suma);
		System.out.println(f2.toString());

	}

	/**
     * Devuelve la cantidad de calorias totales 
     * @return calorias totales
     */
	
	public static int getI() {
		return I;
	}

	 /**
     * Modifica la cantidad totales de calorias
     * @param I
     */
	
	public static void setI(int i) {
		I = i;
	}
	
	
	
}
