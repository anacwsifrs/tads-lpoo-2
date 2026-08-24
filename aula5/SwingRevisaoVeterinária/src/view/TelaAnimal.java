package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class TelaAnimal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painelFormulario;
	private JTextField txtNome;
	private JTextField txtEspecie;
	private JTextField txtRaca;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAnimal frame = new TelaAnimal();
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
	public TelaAnimal() {
		setTitle("Cadastro de Animais");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		painelFormulario = new JPanel();
		painelFormulario.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelFormulario);
		
		JLabel lblNome = new JLabel("Nome: ");
		painelFormulario.add(lblNome);
		
		txtNome = new JTextField();
		painelFormulario.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblEspecie = new JLabel("Espécie: ");
		painelFormulario.add(lblEspecie);
		
		txtEspecie = new JTextField();
		painelFormulario.add(txtEspecie);
		txtEspecie.setColumns(10);
		
		JLabel lblRaca = new JLabel("Raça: ");
		painelFormulario.add(lblRaca);
		
		txtRaca = new JTextField();
		painelFormulario.add(txtRaca);
		txtRaca.setColumns(10);
		
		JScrollPane scroll = new JScrollPane();
		painelFormulario.add(scroll);
		
		table = new JTable();
		painelFormulario.add(table);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		painelFormulario.add(btnCadastrar);

	}
}