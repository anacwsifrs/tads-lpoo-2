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
import controller.ConsultaController;
import model.Animal;
import model.Consulta;
import model.Veterinario;

public class TelaConsulta extends JFrame {
    private ConsultaController consultaController;
    private AnimalController animalController;
    private JComboBox<Animal> cbAnimal;
    private JTextField txtData;
    private JTextField txtVetNome;
    private JTextField txtDescricao;
    private JButton btnCadastrar;
    private JTable tabela;
    private DefaultTableModel modelo;

    public TelaConsulta(ConsultaController consultaController, AnimalController animalController) {
        this.consultaController = consultaController;
        this.animalController = animalController;
        configurarJanela();
        criarComponentes();
    }

    private void configurarJanela() {
        setTitle("Cadastro de Consultas");
        setSize(650, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void criarComponentes() {
        JPanel painelFormulario = new JPanel();
        painelFormulario.setLayout(new GridLayout(4, 2, 10, 10));
        JLabel lblAnimal = new JLabel("Animal:");
        cbAnimal = new JComboBox<>();
        JLabel lblData = new JLabel("Data:");
        txtData = new JTextField();
        JLabel lblVet = new JLabel("Veterinário:");
        txtVetNome = new JTextField();
        JLabel lblDescricao = new JLabel("Descrição:");
        txtDescricao = new JTextField();
        carregarAnimais();

        painelFormulario.add(lblAnimal);
        painelFormulario.add(cbAnimal);
        painelFormulario.add(lblData);
        painelFormulario.add(txtData);
        painelFormulario.add(lblVet);
        painelFormulario.add(txtVetNome);
        painelFormulario.add(lblDescricao);
        painelFormulario.add(txtDescricao);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(e -> cadastrarConsulta());

        String[] colunas = {"ID", "Animal", "Data", "Veterinário", "Descrição"};
        modelo = new DefaultTableModel(colunas, 0);

        tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);

        add(painelFormulario, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(btnCadastrar, BorderLayout.SOUTH);
    }

    private void carregarAnimais() {
        cbAnimal.removeAllItems();
        for (Animal animal : animalController.listar()) {
            cbAnimal.addItem(animal);
        }
    }

    private void cadastrarConsulta() {

        Animal animalSelecionado = (Animal) cbAnimal.getSelectedItem();
        String data = txtData.getText();
        String vetNome = txtVetNome.getText();
        String descricao = txtDescricao.getText();

        if (animalSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Cadastre um animal antes de agendar a consulta!");
            return;
        }

        Veterinario vet = new Veterinario(1, vetNome, "");
        Consulta consulta = consultaController.cadastrar(animalSelecionado, data, vet, descricao);

        modelo.addRow(new Object[] {
            consulta.getId(),
            consulta.getAnimal().getNome(),
            consulta.getData(),
            consulta.getVeterinario().getNome(),
            consulta.getDescricao()
        });

        JOptionPane.showMessageDialog(this, "Consulta cadastrada com sucesso!");
        txtData.setText("");
        txtVetNome.setText("");
        txtDescricao.setText("");
    }
}