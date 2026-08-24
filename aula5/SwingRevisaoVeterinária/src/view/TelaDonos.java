package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.DonoController;
import model.Dono;


public class TelaDonos extends JFrame {
	//controladora dos donos para permitir cadastro
    private DonoController donoController;

    //declaração dos componentes
    private JTextField txtNome;
    private JTextField txtTelefone;

    private JButton btnCadastrar;

    //declaração da tabela e o modelo que ela segue
    private JTable tabela;
    private DefaultTableModel modelo;

    public TelaDonos(DonoController donoController) {

        this.donoController = donoController;

        configurarJanela();
        criarComponentes();
    }

    private void configurarJanela() {

        setTitle("Cadastro de Tutores");

        setSize(600, 400);
        
        //encerra o processo da tela ao fechar mas não derruba a aplicação
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);
    }

    private void criarComponentes() {

    		//painel do formulário de cadastro
        JPanel painelFormulario = new JPanel();

        painelFormulario.setLayout(new GridLayout(2, 2, 10, 10));
        //layout de grid, os dois primeiros argumentos representam as dimensões da matriz de compopnentes
        //os dois ultimos o espaçamento entre os componentes
        
        //campos para o preenchimento de dados
        JLabel lblNome =new JLabel("Nome:");
        txtNome =new JTextField();

        JLabel lblTelefone =new JLabel("Telefone:");
        txtTelefone =new JTextField();

        painelFormulario.add(lblNome);
        painelFormulario.add(txtNome);

        painelFormulario.add(lblTelefone);
        painelFormulario.add(txtTelefone);

        // botão de cadaastro e seu action listener
        btnCadastrar =new JButton("Cadastrar");
        btnCadastrar.addActionListener(e -> cadastrarTutor());
        
        //Modelo que serve de base para a criação da tabela
        String[] colunas = {"ID","Nome","Telefone"};
        modelo =new DefaultTableModel(colunas,0);

        // Tabela e o Scollpane, que permite que ela possa ser scollada conforme seu tamanho
        tabela =new JTable(modelo);
        JScrollPane scroll =new JScrollPane(tabela);

        //Adição dos componentes na tela
        add(painelFormulario, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(btnCadastrar, BorderLayout.SOUTH);
    }

    private void cadastrarTutor() {

        String nome =txtNome.getText();
        String telefone = txtTelefone.getText();

        // Cadastra através do Controller e retorna o objeto do dono cadastrado
        Dono dono = donoController.cadastrar(nome,telefone);
        // Adiciona o tutor na tabela
        modelo.addRow(new Object[] {dono.getId(),dono.getNome(),dono.getTelefone()});

        //pop-up de confirmação de sucesso
        JOptionPane.showMessageDialog( this,"Dono cadastrado com sucesso!");

        // Limpa os campos após operação
        txtNome.setText("");
        txtTelefone.setText("");

        //Seleciona o campo de nome para já inserir novos dados
        txtNome.requestFocus();
    }
}