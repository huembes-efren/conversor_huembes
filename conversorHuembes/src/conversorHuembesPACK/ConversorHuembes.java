package conversorHuembesPACK;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.TextField;
import java.awt.BorderLayout;
import java.awt.List;
import java.awt.RenderingHints.Key;
import java.awt.Choice;
import java.awt.Scrollbar;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.rmi.UnexpectedException;
import java.text.DecimalFormat;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class ConversorHuembes {

	private JFrame frame;
	private JButton btm;
	private JComboBox cmb;
	private TextField txt;
	private JLabel lbl;
	
	public enum Moneda{
		CR_Dolar,
		CR_Euro,
		CR_LibrasEsterlinas,
		CR_YenJaponés,
		CR_WonSulcoreano,
		Dolar_CR,
		Euro_CR,
		LibrasEsterlinas_CR,
		YenJaponés_CR,
		WonSulcoreano_CR,
	}
	
	public double Dolar = 539.22;
	public double Euro = 595.23;
	public double LibrasEsterlinas = 694.70;
	public double YenJaponés = 3.83;
	public double WonSulcoreano = 0.42;
	
	public double valorInput = 0.00;
	private JLabel lblonversorHuembe;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPanel panel;
	private JLabel lblCopyrightCr;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorHuembes window = new ConversorHuembes();
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
	public ConversorHuembes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(154, 205, 50));
		frame.setBounds(100, 100, 1513, 790);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txt = new TextField();
		txt.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 18));
		txt.setBackground(new Color(240, 248, 255));
		txt.setBounds(1083, 344, 310, 34);
		frame.getContentPane().add(txt);
		
		cmb = new JComboBox<Moneda>();
		cmb.setFont(new Font("Arial", Font.BOLD, 25));
		cmb.setForeground(new Color(248, 248, 255));
		cmb.setBackground(new Color(0, 0, 128));
		cmb.setModel(new DefaultComboBoxModel<>(Moneda.values()));
		cmb.setBounds(923, 425, 310, 65);
		frame.getContentPane().add(cmb);
		
		
		//evento boton
		btm = new JButton("Convertir");
		btm.setForeground(new Color(0, 0, 0));
		btm.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		btm.setBackground(new Color(154, 205, 50));
		btm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Convertir();
			}
		});
		btm.setBounds(1279, 426, 166, 65);
		frame.getContentPane().add(btm);
		
		lbl = new JLabel("00.00");
		lbl.setFont(new Font("Tahoma", Font.ITALIC, 35));
		lbl.setForeground(new Color(255, 255, 255));
		lbl.setBackground(new Color(0, 255, 255));
		lbl.setBounds(998, 593, 447, 41);
		frame.getContentPane().add(lbl);
		
		JLabel lblNewLabel = new JLabel("Ingrese la cantidad a convertir:");
		lblNewLabel.setBounds(1075, 308, 338, 25);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		
		lblonversorHuembe = new JLabel("₡onversor Huembe$");
		lblonversorHuembe.setForeground(new Color(0, 0, 128));
		lblonversorHuembe.setFont(new Font("Arial", Font.BOLD, 70));
		lblonversorHuembe.setBounds(90, 31, 695, 99);
		frame.getContentPane().add(lblonversorHuembe);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\50688\\Desktop\\PROYECTOS JAVA\\conversorHuembes\\aluraoracle.png"));
		lblNewLabel_1.setBounds(938, -16, 561, 131);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\50688\\Desktop\\PROYECTOS JAVA\\conversorHuembes\\Currency_Conversion_icon-icons.com_56682.png"));
		lblNewLabel_2.setBounds(53, 143, 546, 526);
		frame.getContentPane().add(lblNewLabel_2);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(-34, 140, 1750, 590);
		frame.getContentPane().add(panel);
		
		lblCopyrightCr = new JLabel("© Copyright CR property of efrén huembes-2023");
		lblCopyrightCr.setForeground(new Color(0, 0, 128));
		lblCopyrightCr.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCopyrightCr.setBounds(584, 740, 721, 25);
		frame.getContentPane().add(lblCopyrightCr);
	}
	
	public void Convertir() {
		if(Validar(txt.getText())) {
			
			Moneda moneda = (Moneda)cmb.getSelectedItem();
			
			switch (moneda) {
			
			case CR_Dolar:
				CRAMoneda(Dolar);
				break;
			case CR_Euro:
				CRAMoneda(Euro);
				break;
			case CR_LibrasEsterlinas:
				CRAMoneda(LibrasEsterlinas);
				break;
			case CR_YenJaponés:
				CRAMoneda(YenJaponés);
				break;
			case CR_WonSulcoreano:
				CRAMoneda(WonSulcoreano);
				break;
			
			case Dolar_CR:
				MonedaACR(Dolar);
				break;
			case Euro_CR:
				MonedaACR(Euro);
				break;
			case LibrasEsterlinas_CR:
				MonedaACR(LibrasEsterlinas);
				break;
			case YenJaponés_CR:
				MonedaACR(YenJaponés);
				break;
			case WonSulcoreano_CR:
				MonedaACR(WonSulcoreano);
				break;
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + moneda);
		}

		}
	}
	
	public void CRAMoneda(double moneda) {
		double resultado = valorInput/ moneda;
		lbl.setText(Redondear(resultado));
		
		
	}
	public void MonedaACR(double moneda) {
	double resultado = valorInput/ moneda;
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
			if (x > 0);
			valorInput =  x;
			return true;
			
		
		} catch (NumberFormatException e) {
			lbl.setText("Solamente Números");
			return false;
		}
		
}
}
