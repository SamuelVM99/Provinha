package main;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import classe.Pedido;
import classe.Pessoa;

@SuppressWarnings({"serial", "rawtypes", "unchecked"})
public class LancaPedido extends JFrame {
	
	private DefaultComboBoxModel modeloLista = new DefaultComboBoxModel();
	private JComboBox listaPessoa;
	private JPanel contentPane;
	private JFormattedTextField textDataPedido;
	private JFormattedTextField textValorPedido;
	private JTextArea textDescricaoPedido;
	private JButton btnCancelar;
	private JButton btnSalvar;
	
	public void atualizaLista(String pessoa) {
		this.modeloLista.addElement(pessoa);
	}
	
	public int getIndexPessoa() {
		return this.modeloLista.getIndexOf(this.modeloLista.getSelectedItem());
	}
	
	public JFormattedTextField getTextDataPedido() {
		return textDataPedido;
	}

	public JFormattedTextField getTextValorPedido() {
		return textValorPedido;
	}

	public JTextArea getTextDescricaoPedido() {
		return textDescricaoPedido;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}
	
	public void limpaCampos() {
		this.getTextDataPedido().setText("");
		this.getTextValorPedido().setText("");
		this.getTextDescricaoPedido().setText("");
	}
	
	public void salvaPedido(Pessoa pessoa) {
		pessoa.setPedido(new Pedido(
						this.modeloLista.getIndexOf(this.modeloLista.getSelectedItem()),
						this.getTextDataPedido().getText(),
						this.getTextValorPedido().getText(),
						this.getTextDescricaoPedido().getText()
						));
	}
	
//Cria os componentes visuais da tela e define seus valores iniciais
	public LancaPedido() {
		
		setTitle("Lançar Pedido");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 540, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		try {
			
			JLabel labelListaPessoa = new JLabel("Pessoa:");
			labelListaPessoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
			labelListaPessoa.setBounds(10, 11, 69, 19);
			contentPane.add(labelListaPessoa);
			
			listaPessoa = new JComboBox(modeloLista);
			listaPessoa.setEditable(true);
			listaPessoa.setBounds(10, 34, 266, 22);
			contentPane.add(listaPessoa);
			
			JLabel labelDataPedido = new JLabel("Data:");
			labelDataPedido.setFont(new Font("Tahoma", Font.PLAIN, 15));
			labelDataPedido.setBounds(10, 67, 69, 19);
			contentPane.add(labelDataPedido);
			
			textDataPedido = new JFormattedTextField(new MaskFormatter("##/##/####"));
			textDataPedido.setHorizontalAlignment(SwingConstants.CENTER);
			textDataPedido.setBounds(10, 91, 105, 22);
			contentPane.add(textDataPedido);
			
			JLabel labelValorPedido = new JLabel("Valor Pedido:");
			labelValorPedido.setFont(new Font("Tahoma", Font.PLAIN, 15));
			labelValorPedido.setBounds(125, 67, 105, 19);
			contentPane.add(labelValorPedido);
			
			textValorPedido = new JFormattedTextField(new MaskFormatter("#####,##"));
			textValorPedido.setHorizontalAlignment(SwingConstants.CENTER);
			textValorPedido.setBounds(125, 91, 105, 22);
			contentPane.add(textValorPedido);
			
			JLabel labelDescricaoPedido = new JLabel("Descricao:");
			labelDescricaoPedido.setFont(new Font("Tahoma", Font.PLAIN, 15));
			labelDescricaoPedido.setBounds(10, 124, 69, 19);
			contentPane.add(labelDescricaoPedido);
			
			textDescricaoPedido = new JTextArea();
			textDescricaoPedido.setLineWrap(true);
			textDescricaoPedido.setBounds(10, 154, 504, 74);
			contentPane.add(textDescricaoPedido);
			
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(10, 306, 132, 42);
			contentPane.add(btnCancelar);
			
			btnSalvar = new JButton("Salvar");
			btnSalvar.setBounds(382, 306, 132, 42);
			contentPane.add(btnSalvar);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
