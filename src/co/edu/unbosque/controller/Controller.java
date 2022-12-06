package co.edu.unbosque.controller;

import java.util.Scanner;

import co.edu.unbosque.model.ClaseX;
import co.edu.unbosque.model.Model;
import co.edu.unbosque.view.ViewVentanas;

public class Controller {

	
	Scanner sc = new Scanner(System.in);
	private ClaseX m;
	private ViewVentanas view;
	private Model model;

	/**

     * Metodo que permite ejecutar el programa

     */
	
	public Controller() {

		view = new ViewVentanas();
		model = new Model();
		inicializar();
		
	}
	
	/**

     * Metodo que realiza la recoleccion de informacion para los diferentes problemas

     */

	public void inicializar() {

		boolean done = false;

		do {
			System.out.println("Digite el punto que desea visualizar");
			System.out.println("1. Programación Dinámica");
			System.out.println("2. Backtracking");
			System.out.println("3. Rama y Poda");
			System.out.println("4. Salir");

			int dato = sc.nextInt();

			switch (dato) {
			case 1:
				int num = 0;
				System.out.println("¿Cuantos platos desea ingresar?");
				int numplatos = sc.nextInt();
				int platos[] = new int[numplatos];
				for(int i=0;i<numplatos;i++) {
					System.out.println("Digite las calorias del plato numero "+ (i+1));
					int valor =sc.nextInt();
					platos[i]=valor;	
					num +=valor;
				}
				System.out.println("Maximas calorias posibles "+ num);
				System.out.println("Cuantas calorias desea consumir ");
				int calorias = sc.nextInt();
				if(num<calorias) {
					System.out.println("insuficientes calorias en los platos para llegar a la meta");
				}else {
				m.setI(num+1);
				m.Resolver(platos, calorias);
				}
				break;
			case 2:

				System.out.println("Proximamente");

				break;
				
			case 3:
				
				System.out.println();
				System.out.println("Ingrese el tamano de la matriz M x N \n" + "Ingrese el valor de M");
				int m = sc.nextInt();
				System.out.println("Ingrese el valor de N");
				int n = sc.nextInt();
				System.out.println("Ingrese cantidad de casillas que se desea mover");
				int p = sc.nextInt();
				System.out.println(
						"Ingrese la direccion en la que quiere hacer ese movimiento \n" + "1.horizontal \n" + "2.vertical");
				int d = sc.nextInt();
				System.out.println("Ingrese un segundo movimiento de casillas el cual sera en direccion perpendicular al anteriormente seleccionado");
				int q = sc.nextInt();
				System.out.println(model.saltos(m, n, p, d, q));
				break;

			case 4:
				
				System.out.println("Gracias, vuelva pronto...");
				done = true;
				
				break;
				
			default:
				System.out.println("Inválido. Ingrese una opción entre (1-3).");
			}

		} while (!done);
	}
}
