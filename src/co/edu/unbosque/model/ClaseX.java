package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class ClaseX {

	public static int I = Integer.MAX_VALUE;

	static int Min(int a, int b) {
		return (b < a) ? b : a;
	}

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
		return r.toArray();
	}

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

	public static int getI() {
		return I;
	}

	public static void setI(int i) {
		I = i;
	}
	
	

				
//				int[] lista = { 7, 8, 9, 4, 5, 6 };
//				Resolver(lista, 10);
//				Resolver(lista, 37);
//				
//				int[] lista2 = { 11, 9, 5, 3 };
//				Resolver(lista2, 18);
//				Resolver(lista2, 15);
//
//				int[] lista3 = { 8, 16, 24, 32 };
//				Resolver(lista3, 27);
//				Resolver(lista3, 42);

	
}
