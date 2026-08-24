package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField labelPeso;
	private JTextField labelAltura;
	private JTable tabela;
	private DefaultTableModel modelo;

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
		setBounds(100, 100, 788, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Insira os dados para calcular o IMC:");
		lblNewLabel.setBounds(10, 14, 250, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Peso (em kgs):");
		lblNewLabel_1.setBounds(10, 48, 100, 14);
		contentPane.add(lblNewLabel_1);

		labelPeso = new JTextField();
		labelPeso.setBounds(120, 45, 86, 20);
		contentPane.add(labelPeso);
		labelPeso.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Altura (em metro):");
		lblNewLabel_2.setBounds(10, 82, 110, 14);
		contentPane.add(lblNewLabel_2);

		labelAltura = new JTextField();
		labelAltura.setBounds(120, 79, 86, 20);
		contentPane.add(labelAltura);
		labelAltura.setColumns(10);

		JLabel lblAtividade = new JLabel("Nível de Atividade:");
		lblAtividade.setBounds(220, 48, 120, 14);
		contentPane.add(lblAtividade);

		JComboBox<String> jcbAtividade = new JComboBox<>();
		jcbAtividade.addItem("Sedentário");
		jcbAtividade.addItem("Moderado");
		jcbAtividade.addItem("Intenso");
		jcbAtividade.setBounds(340, 45, 110, 20);
		contentPane.add(jcbAtividade);

		JCheckBox chkAtivo = new JCheckBox("Atleta Profissional");
		chkAtivo.setBounds(220, 78, 160, 23);
		contentPane.add(chkAtivo);

		String[] colunas = {"Peso (kg)", "Altura (m)", "Nível", "Atleta", "IMC"};
		modelo = new DefaultTableModel(colunas, 0);
		tabela = new JTable(modelo);

		JScrollPane scroll = new JScrollPane(tabela);
		scroll.setBounds(10, 160, 752, 230);
		contentPane.add(scroll);

		JButton btnCalcularImc = new JButton("Calcular e Adicionar");
		btnCalcularImc.setBounds(10, 120, 180, 23);
		contentPane.add(btnCalcularImc);

		btnCalcularImc.addActionListener(e -> {
			try {
				double peso = Double.parseDouble(labelPeso.getText().replace(",", "."));
				double altura = Double.parseDouble(labelAltura.getText().replace(",", "."));
				double imc = peso / (altura * altura);

				String nivel = (String) jcbAtividade.getSelectedItem();
				String atleta = chkAtivo.isSelected() ? "Sim" : "Não";
				String imcFormatado = String.format("%.2f", imc);

				modelo.addRow(new Object[] { peso, altura, nivel, atleta, imcFormatado });

				labelPeso.setText("");
				labelAltura.setText("");
			} catch (NumberFormatException ex) {
			}
		});
	}
}