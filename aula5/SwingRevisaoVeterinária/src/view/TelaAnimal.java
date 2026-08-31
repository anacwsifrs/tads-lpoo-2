package view;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import controller.AnimalController;
import controller.DonoController;
import model.Animal;
import model.Dono;

public class TelaAnimal extends JFrame {
    private AnimalController animalController;
    private DonoController donoController;
    private JTextField txtNome;
    private JTextField txtEspecie;
    private JTextField txtRaca;
    private JComboBox<Dono> cbDono;
    private JButton btnCadastrar;
    private JTable tabela;
    private DefaultTableModel modelo;

    public TelaAnimal(AnimalController animalController, DonoController donoController) {
        this.animalController = animalController;
        this.donoController = donoController;
        configurarJanela();
        criarComponentes();
    }

    private void configurarJanela() {
        setTitle("Cadastro de Animais");
        setSize(650, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void criarComponentes() {
        JPanel painelFormulario = new JPanel();
        painelFormulario.setLayout(new GridLayout(4, 2, 10, 10));
        JLabel lblNome = new JLabel("Nome:");
        txtNome = new JTextField();
        JLabel lblEspecie = new JLabel("Espécie:");
        txtEspecie = new JTextField();
        JLabel lblRaca = new JLabel("Raça:");
        txtRaca = new JTextField();
        JLabel lblDono = new JLabel("Dono:");
        cbDono = new JComboBox<>();

        carregarDonos();

        painelFormulario.add(lblNome);
        painelFormulario.add(txtNome);
        painelFormulario.add(lblEspecie);
        painelFormulario.add(txtEspecie);
        painelFormulario.add(lblRaca);
        painelFormulario.add(txtRaca);
        painelFormulario.add(lblDono);
        painelFormulario.add(cbDono);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(e -> cadastrarAnimal());

        String[] colunas = {"ID", "Nome", "Espécie", "Raça", "Dono"};
        modelo = new DefaultTableModel(colunas, 0);
        tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);

        add(painelFormulario, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(btnCadastrar, BorderLayout.SOUTH);
    }

    private void carregarDonos() {
        cbDono.removeAllItems();
        for (Dono dono : donoController.listar()) {
            cbDono.addItem(dono);
        }
    }

    private void cadastrarAnimal() {
        String nome = txtNome.getText();
        String especie = txtEspecie.getText();
        String raca = txtRaca.getText();
        Dono donoSelecionado = (Dono) cbDono.getSelectedItem();

        if (donoSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Cadastre um dono antes de cadastrar o animal!");
            return;
        }

        Animal animal = animalController.cadastrar(nome, especie, raca, donoSelecionado);

        modelo.addRow(new Object[] {
            animal.getId(),
            animal.getNome(),
            animal.getEspecie(),
            animal.getRaca(),
            animal.getDono().getNome()
        });

        JOptionPane.showMessageDialog(this, "Animal cadastrado com sucesso!");
        txtNome.setText("");
        txtEspecie.setText("");
        txtRaca.setText("");
        txtNome.requestFocus();
    }
}