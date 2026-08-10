package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField labelPeso;
	private JTextField labelAltura;
	private JTextField labelResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnCalcularImc = new JButton("Calcular Imc");
		btnCalcularImc.setBounds(60, 157, 91, 23);
		btnCalcularImc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Insira o seu peso e altura para calcular o seu IMC.");
		lblNewLabel.setBounds(10, 14, 241, 14);
		contentPane.add(lblNewLabel);
		contentPane.add(btnCalcularImc);
		
		JLabel lblNewLabel_1 = new JLabel("Peso (em kgs):");
		lblNewLabel_1.setBounds(10, 68, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		labelPeso = new JTextField();
		labelPeso.setBounds(82, 65, 86, 20);
		contentPane.add(labelPeso);
		labelPeso.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Altura (em metro):");
		lblNewLabel_2.setBounds(10, 112, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		labelAltura = new JTextField();
		labelAltura.setBounds(82, 109, 86, 20);
		contentPane.add(labelAltura);
		labelAltura.setColumns(10);
		
		labelResultado = new JTextField();
		labelResultado.setBounds(82, 229, 86, 20);
		contentPane.add(labelResultado);
		labelResultado.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Resultado: ");
		lblNewLabel_3.setBounds(10, 232, 97, 14);
		contentPane.add(lblNewLabel_3);
		
		btnCalcularImc.addActionListener(e -> {
		    try {
		        double peso = Double.parseDouble(labelPeso.getText().replace(",", "."));
		        double altura = Double.parseDouble(labelAltura.getText().replace(",", "."));
		        double imc = peso / (altura * altura);
		        
		        labelResultado.setText(String.format("IMC: %.2f", imc));
		    } catch (NumberFormatException ex) {
		    	labelResultado.setText("Por favor, digite números válidos.");
		    }
		});

	}
}
