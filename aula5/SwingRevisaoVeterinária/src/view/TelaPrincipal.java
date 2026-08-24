package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.AnimalController;
import controller.ConsultaController;
import controller.DonoController;
import java.awt.FlowLayout;

public class TelaPrincipal extends JFrame {
	//declaração dos controladores
	private DonoController tutorController;
	private AnimalController animalController;
	private ConsultaController consultaController;
	
	public TelaPrincipal(DonoController tutorController,AnimalController animalController,ConsultaController consultaController) {
		
		this.tutorController = tutorController;
		this.animalController = animalController;
		this.consultaController = consultaController;
		
		configurarJanela();
		criarComponentes();
	}
	
	private void configurarJanela() {
		//configuração do nome da janela
		setTitle("Clínica Veterinária");
		// tamanho da janela na inicialização
		setSize(600, 400);
		//aplicação encerra ao fechar a tela principal
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//declara a posição inicial da tela(caso não exista vai para o canto superior esquerdo)
		setLocationRelativeTo(null);
	}
	
	private void criarComponentes() {
		// texto do canto superior
		JLabel titulo = new JLabel("Sistema da Clínica Veterinária");
		// botões do header
		
		JButton btnDonos =new JButton("Donos");
		
		JButton btnAnimais =new JButton("Animais");
		
		JButton btnConsultas = new JButton("Consultas");
		//criando painel e declarando o layout dele como sendo do flow
		// o flow layout pões os itens um do lado do outro enquanto tiver espaço
		// bom para headers
		JPanel painel =new JPanel();
		painel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		//o .Center declara que ele centraliza os compopnentes dentro dele
		//os inteiros são a borda entre os componentes
		
		//adição dos botões ao painel criado
		painel.add(btnDonos);
		painel.add(btnAnimais);
		painel.add(btnConsultas);
		
		//adição de funcionalidade aos botões
		btnDonos.addActionListener(e-> abrirTelaDonos());
		btnAnimais.addActionListener(e-> abrirTelaAnimais());
		//btnConsultas.addActionListener(e-> abrirTelaConsultas());
		
		//adicionando os paineis a tela principal
		getContentPane().add(titulo, BorderLayout.NORTH);
		getContentPane().add(painel, BorderLayout.CENTER);
	}
	
	
	private void abrirTelaDonos() {
		TelaDonos tela = new TelaDonos(tutorController);
		
		tela.setVisible(true);
	}
	
	private void abrirTelaAnimais() {
		TelaAnimal tela = new TelaAnimal(animalController);
		
		tela.setVisible(true);
	}
}
