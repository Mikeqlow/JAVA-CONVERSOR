import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class ConversorDeMonedas {

	private JFrame frmConversor;
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
					window.frmConversor.setVisible(true);
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
		frmConversor = new JFrame();
		frmConversor.getContentPane().setBackground(new Color(64, 128, 128));
		frmConversor.setTitle("Conversor de Monedas");
		frmConversor.setBounds(100, 100, 450, 300);
		frmConversor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConversor.getContentPane().setLayout(null);
		
		texto = new JTextField();
		texto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		texto.setBounds(117, 87, 96, 19);
		frmConversor.getContentPane().add(texto);
		texto.setColumns(10);
		
		cmb = new JComboBox<Moneda>();
		cmb.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		cmb.setModel(new DefaultComboBoxModel<>(Moneda.values()));
		cmb.setBounds(57, 150, 178, 21);
		frmConversor.getContentPane().add(cmb);
		
		//Acción con el botón.
		btn = new JButton("Convertir");
		btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Convertir();
			}
		});
		btn.setBounds(245, 150, 125, 21);
		frmConversor.getContentPane().add(btn);
		
		lbl = new JLabel("00.00");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl.setBounds(223, 87, 85, 19);
		frmConversor.getContentPane().add(lbl);
	}
	
	public void Convertir() {
		if(Validar(texto.getText())) {
			Moneda moneda = (Moneda)cmb.getSelectedItem();
			switch (moneda) {
			case soles_dolar: 
				solesAMoneda(dolar);
				break;
			case soles_dolarCanadiense: 
				solesAMoneda(dolarCanadiense);
				break;
			case soles_euros: 
				solesAMoneda(euros);
				break;
			case soles_librasEsterlinas: 
				solesAMoneda(librasEsterlinas);
				break;
			case soles_wonSurCoreano: 
				solesAMoneda(wonSurCoreano);
				break;
			case soles_yenJapones: 
				solesAMoneda(yenJapones);
				break;
			//Ahora en viceversa
			case dolar_soles: 
				monedaASoles(dolar);
				break;
			case dolarCanadiense_soles: 
				monedaASoles(dolarCanadiense);
				break;
			case euros_soles: 
				monedaASoles(euros);
				break;
			case librasEsterlinas_soles: 
				monedaASoles(librasEsterlinas);
				break;
			case wonSurCoreano_soles: 
				monedaASoles(wonSurCoreano);
				break;
			case yenJapones_soles: 
				monedaASoles(yenJapones);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + moneda);
			
			}
		
		
		}
	}
	
	public void solesAMoneda (double moneda) {
		double resultado = valorInput / moneda;
		lbl.setText(Redondear(resultado));
	}
	
	public void monedaASoles (double moneda) {
		double resultado = valorInput * moneda;
		lbl.setText(Redondear(resultado));
	}
	
	public String Redondear(double valor) {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(valor);
	}
	
	public boolean Validar(String texto) {
		try {
			double x = Double.parseDouble(texto);
			if(x > 0);
			valorInput = x;
			return true;
		}catch(NumberFormatException e) {
			lbl.setText("Solo ingresar números");
			return false;
		}
		
	}
}
