package view;

import model.Aluno;
import model.Curso;
import service.AlunoService;
import service.CursoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TelaPrincipal extends JFrame {

    private AlunoService alunoService;
    private CursoService cursoService;

    private JTable tabelaAlunos;
    private DefaultTableModel modeloAlunos;
    private JTextField txtIdAluno, txtNomeAluno, txtIdadeAluno;

    private JTable tabelaCursos;
    private DefaultTableModel modeloCursos;
    private JTextField txtIdCurso, txtNomeCurso, txtCargaHorariaCurso;

    public TelaPrincipal() {
        alunoService = new AlunoService();
        cursoService = new CursoService();

        setTitle("Sistema Acadêmico");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane abas = new JTabbedPane();
        abas.addTab("Alunos", criarPainelAlunos());
        abas.addTab("Cursos", criarPainelCursos());

        add(abas);
        carregarTabelaAlunos();
        carregarTabelaCursos();
    }

    private JPanel criarPainelAlunos() {
        JPanel painel = new JPanel(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(3, 2, 5, 5));
        form.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        txtIdAluno = new JTextField();
        txtIdAluno.setEnabled(false);
        txtNomeAluno = new JTextField();
        txtIdadeAluno = new JTextField();

        form.add(new JLabel("ID:"));
        form.add(txtIdAluno);
        form.add(new JLabel("Nome:"));
        form.add(txtNomeAluno);
        form.add(new JLabel("Idade:"));
        form.add(txtIdadeAluno);

        JPanel botoes = new JPanel();
        JButton btnSalvar = new JButton("Salvar");
        JButton btnAtualizar = new JButton("Atualizar");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnLimpar = new JButton("Limpar");

        botoes.add(btnSalvar);
        botoes.add(btnAtualizar);
        botoes.add(btnExcluir);
        botoes.add(btnLimpar);

        modeloAlunos = new DefaultTableModel(new String[]{"ID", "Nome", "Idade"}, 0);
        tabelaAlunos = new JTable(modeloAlunos);
        
        tabelaAlunos.getSelectionModel().addListSelectionListener(e -> {
            int linha = tabelaAlunos.getSelectedRow();
            if (linha >= 0) {
                txtIdAluno.setText(modeloAlunos.getValueAt(linha, 0).toString());
                txtNomeAluno.setText(modeloAlunos.getValueAt(linha, 1).toString());
                txtIdadeAluno.setText(modeloAlunos.getValueAt(linha, 2).toString());
            }
        });

        btnSalvar.addActionListener(e -> {
            try {
                Aluno aluno = new Aluno(txtNomeAluno.getText(), Integer.parseInt(txtIdadeAluno.getText()));
                alunoService.matricular(aluno);
                carregarTabelaAlunos();
                limparFormAluno();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        });

        btnAtualizar.addActionListener(e -> {
            try {
                Aluno aluno = new Aluno(Integer.parseInt(txtIdAluno.getText()), txtNomeAluno.getText(), Integer.parseInt(txtIdadeAluno.getText()));
                alunoService.atualizar(aluno);
                carregarTabelaAlunos();
                limparFormAluno();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        });

        btnExcluir.addActionListener(e -> {
            try {
                alunoService.excluir(Integer.parseInt(txtIdAluno.getText()));
                carregarTabelaAlunos();
                limparFormAluno();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Selecione um aluno para excluir.");
            }
        });

        btnLimpar.addActionListener(e -> limparFormAluno());

        JPanel topo = new JPanel(new BorderLayout());
        topo.add(form, BorderLayout.CENTER);
        topo.add(botoes, BorderLayout.SOUTH);

        painel.add(topo, BorderLayout.NORTH);
        painel.add(new JScrollPane(tabelaAlunos), BorderLayout.CENTER);

        return painel;
    }

    private JPanel criarPainelCursos() {
        JPanel painel = new JPanel(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(3, 2, 5, 5));
        form.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        txtIdCurso = new JTextField();
        txtIdCurso.setEnabled(false);
        txtNomeCurso = new JTextField();
        txtCargaHorariaCurso = new JTextField();

        form.add(new JLabel("ID:"));
        form.add(txtIdCurso);
        form.add(new JLabel("Nome:"));
        form.add(txtNomeCurso);
        form.add(new JLabel("Carga Horária:"));
        form.add(txtCargaHorariaCurso);

        JPanel botoes = new JPanel();
        JButton btnSalvar = new JButton("Salvar");
        JButton btnAtualizar = new JButton("Atualizar");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnLimpar = new JButton("Limpar");

        botoes.add(btnSalvar);
        botoes.add(btnAtualizar);
        botoes.add(btnExcluir);
        botoes.add(btnLimpar);

        modeloCursos = new DefaultTableModel(new String[]{"ID", "Nome", "Carga Horária"}, 0);
        tabelaCursos = new JTable(modeloCursos);

        tabelaCursos.getSelectionModel().addListSelectionListener(e -> {
            int linha = tabelaCursos.getSelectedRow();
            if (linha >= 0) {
                txtIdCurso.setText(modeloCursos.getValueAt(linha, 0).toString());
                txtNomeCurso.setText(modeloCursos.getValueAt(linha, 1).toString());
                txtCargaHorariaCurso.setText(modeloCursos.getValueAt(linha, 2).toString());
            }
        });

        btnSalvar.addActionListener(e -> {
            try {
                Curso curso = new Curso(txtNomeCurso.getText(), Integer.parseInt(txtCargaHorariaCurso.getText()));
                cursoService.cadastrar(curso);
                carregarTabelaCursos();
                limparFormCurso();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        });

        btnAtualizar.addActionListener(e -> {
            try {
                Curso curso = new Curso(Integer.parseInt(txtIdCurso.getText()), txtNomeCurso.getText(), Integer.parseInt(txtCargaHorariaCurso.getText()));
                cursoService.atualizar(curso);
                carregarTabelaCursos();
                limparFormCurso();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        });

        btnExcluir.addActionListener(e -> {
            try {
                cursoService.excluir(Integer.parseInt(txtIdCurso.getText()));
                carregarTabelaCursos();
                limparFormCurso();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Selecione um curso para excluir.");
            }
        });

        btnLimpar.addActionListener(e -> limparFormCurso());

        JPanel topo = new JPanel(new BorderLayout());
        topo.add(form, BorderLayout.CENTER);
        topo.add(botoes, BorderLayout.SOUTH);

        painel.add(topo, BorderLayout.NORTH);
        painel.add(new JScrollPane(tabelaCursos), BorderLayout.CENTER);

        return painel;
    }

    private void carregarTabelaAlunos() {
        modeloAlunos.setRowCount(0);
        List<Aluno> alunos = alunoService.listarTodos();
        for (Aluno aluno : alunos) {
            modeloAlunos.addRow(new Object[]{aluno.getId(), aluno.getNome(), aluno.getIdade()});
        }
    }

    private void carregarTabelaCursos() {
        modeloCursos.setRowCount(0);
        List<Curso> cursos = cursoService.listarTodos();
        for (Curso curso : cursos) {
            modeloCursos.addRow(new Object[]{curso.getId(), curso.getNome(), curso.getCargaHoraria()});
        }
    }

    private void limparFormAluno() {
        txtIdAluno.setText("");
        txtNomeAluno.setText("");
        txtIdadeAluno.setText("");
        tabelaAlunos.clearSelection();
    }

    private void limparFormCurso() {
        txtIdCurso.setText("");
        txtNomeCurso.setText("");
        txtCargaHorariaCurso.setText("");
        tabelaCursos.clearSelection();
    }
}