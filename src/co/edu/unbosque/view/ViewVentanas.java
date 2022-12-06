package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class ViewVentanas {
	
	public ViewVentanas() {
		
	}
	
	public int leerEntero(String mensaje) {
		String aux = JOptionPane.showInputDialog(mensaje);
		int dato = Integer.parseInt(aux);
		return dato;
	}
	public double leerDouble(String mensaje) {
		String aux = JOptionPane.showInputDialog(mensaje);
		double dato = Integer.parseInt(aux);
		return dato;
	}
	public String leerString(String mensaje) {
		String aux = JOptionPane.showInputDialog(mensaje);
		return aux;
	}
	
	public void mostrarInformacion(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	public void mostrarInformacion(StringBuilder mensaje) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, mensaje);
	}

}