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

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public ConversorDeMonedas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
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
