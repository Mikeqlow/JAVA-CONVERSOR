import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ConversorDeMonedas {

	private JFrame frame;
	private JTextField texto;
	private JButton btn;
	private JComboBox cmb;
	private JLabel lbl;
	
	public enum Moneda {
		soles_dolar,
		soles_dolarCanadiense,
		soles_euros,
		soles_librasEsterlinas,
		soles_yenJapones,
		soles_wonSurCoreano,
		dolar_soles,
		dolarCanadiense_soles,
		euros_soles,
		librasEsterlinas_soles,
		yenJapones_soles,
		wonSurCoreano_soles,
		
	}
	
	public double dolar = 3.70;
	public double dolarCanadiense = 2.72;
	public double euros = 4.00;
	public double librasEsterlinas = 4.66;
	public double yenJapones = 0.025;
	public double wonSurCoreano = 0.0028;
	
	public double valorInput = 0.00;
	
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorDeMonedas window = new ConversorDeMonedas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ConversorDeMonedas() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		texto = new JTextField();
		texto.setBounds(10, 10, 96, 19);
		frame.getContentPane().add(texto);
		texto.setColumns(10);
		
		cmb = new JComboBox();
		cmb.setBounds(10, 61, 96, 21);
		frame.getContentPane().add(cmb);
		
		btn = new JButton("Convertir");
		btn.setBounds(116, 61, 85, 21);
		frame.getContentPane().add(btn);
		
		lbl = new JLabel("00.00");
		lbl.setBounds(116, 10, 85, 19);
		frame.getContentPane().add(lbl);
	}
}
