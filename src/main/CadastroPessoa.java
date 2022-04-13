package main;

import java.awt.Font;
import java.net.URL;
import java.text.ParseException;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import classe.Pessoa;

@SuppressWarnings("serial")
public class CadastroPessoa extends JFrame {
	
	private Pessoa pessoa;
	public int pessoaId = 0;
	
	private JPanel contentPane;
	private JTextField textNomePessoa;
	private JTextField textEmailPessoa;
	private JFormattedTextField textTelefonePessoa;
	private JFormattedTextField textNascimentoPessoa;
	private JFormattedTextField textCpfPessoa;
	private JFormattedTextField textCepPessoa;
	private JTextField textUfPessoa;
	private JTextField textLogradouroPessoa;
	private JTextField textBairroPessoa;
	private JTextField textNumeroPessoa;
	private JTextField textCidadePessoa;
	private JTextField textPaisPessoa;
	private JButton btnCancelar;
	private JButton btnSalvar;
	private JButton btnBuscaCep;
	
	public int getIdPessoa() {
		return this.pessoa.getId();
	}

	public JTextField getTextNomePessoa() {
		return textNomePessoa;
	}

	public JTextField getTextEmailPessoa() {
		return textEmailPessoa;
	}

	public JFormattedTextField getTextTelefonePessoa() {
		return textTelefonePessoa;
	}

	public JFormattedTextField getTextNascimentoPessoa() {
		return textNascimentoPessoa;
	}

	public JFormattedTextField getTextCpfPessoa() {
		return textCpfPessoa;
	}


	public JFormattedTextField getTextCepPessoa() {
		return textCepPessoa;
	}

	public JTextField getTextUfPessoa() {
		return textUfPessoa;
	}

	public JTextField getTextLogradouroPessoa() {
		return textLogradouroPessoa;
	}

	public JTextField getTextBairroPessoa() {
		return textBairroPessoa;
	}

	public JTextField getTextNumeroPessoa() {
		return textNumeroPessoa;
	}

	public JTextField getTextCidadePessoa() {
		return textCidadePessoa;
	}

	public JTextField getTextPaisPessoa() {
		return textPaisPessoa;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public JButton getBtnBuscaCep() {
		return btnBuscaCep;
	}
	
	public void limpaCampos() {
		this.getTextNomePessoa().setText("");
		this.getTextEmailPessoa().setText("");
		this.getTextTelefonePessoa().setText("");
		this.getTextNascimentoPessoa().setText("");
		this.getTextCpfPessoa().setText("");
		this.getTextCepPessoa().setText("");
		this.getTextUfPessoa().setText("");
		this.getTextLogradouroPessoa().setText("");
		this.getTextBairroPessoa().setText("");
		this.getTextNumeroPessoa().setText("");
		this.getTextCidadePessoa().setText("");
		this.getTextPaisPessoa().setText("");
	}

	// Acessa o URL da WebService, lê o XML, busca as tags do endereço e atribui os valores aos seus respectivos campos
	public void buscaCep() {
		try {
			// Acessa o XML do WebService baseado no cep informado
			URL url = new URL("https://viacep.com.br/ws/" + this.textCepPessoa.getText() + "/xml/");
			// Lê o XML acessado acima
			SAXReader reader = new SAXReader();
			Document document = reader.read(url);
			Element root = document.getRootElement();
			// Acessa cada uma das tags dentro do XML e atribui o valor delas aos seus respectivos campos
			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				if (element.getQualifiedName().equals("uf")) {
					this.textUfPessoa.setText(element.getText());
				}
				if (element.getQualifiedName().equals("logradouro")) {
					this.textLogradouroPessoa.setText(element.getText());
				}
				if (element.getQualifiedName().equals("bairro")) {
					this.textBairroPessoa.setText(element.getText());
				}
				if (element.getQualifiedName().equals("localidade")) {
					this.textCidadePessoa.setText(element.getText());
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public Pessoa cadastraPessoa() {
		return new Pessoa(this.textNomePessoa.getText(), 
				this.textEmailPessoa.getText(), 
				this.textTelefonePessoa.getText(), 
				this.textNascimentoPessoa.getText(),
				this.textCpfPessoa.getText(),
				this.textCepPessoa.getText(),
				this.textLogradouroPessoa.getText(),
				this.textNumeroPessoa.getText(),
				this.textBairroPessoa.getText(), 
				this.textCidadePessoa.getText(), 
				this.textUfPessoa.getText(),
				this.textPaisPessoa.getText(), 
				this.pessoaId);
	}

// Cria os componentes visuais da tela e define seus valores iniciais
	public CadastroPessoa() {
		
		setTitle("Cadastro de Pessoa");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 545, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		try {

			JLabel labelNomePessoa = new JLabel("Nome:");
			labelNomePessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
			labelNomePessoa.setBounds(10, 11, 46, 14);
			contentPane.add(labelNomePessoa);

			textNomePessoa = new JTextField();
			textNomePessoa.setColumns(10);
			textNomePessoa.setBounds(10, 30, 246, 20);
			contentPane.add(textNomePessoa);

			JLabel labelEmailPessoa = new JLabel("Email:");
			labelEmailPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
			labelEmailPessoa.setBounds(266, 11, 46, 14);
			contentPane.add(labelEmailPessoa);

			textEmailPessoa = new JTextField();
			textEmailPessoa.setColumns(10);
			textEmailPessoa.setBounds(266, 30, 253, 20);
			contentPane.add(textEmailPessoa);

			JLabel labelTelefonePessoa = new JLabel("Telefone:");
			labelTelefonePessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
			labelTelefonePessoa.setBounds(10, 61, 71, 14);
			contentPane.add(labelTelefonePessoa);

			textTelefonePessoa = new JFormattedTextField(new MaskFormatter("(##) # ####-####"));
			textTelefonePessoa.setHorizontalAlignment(SwingConstants.CENTER);
			textTelefonePessoa.setBounds(10, 82, 118, 20);
			contentPane.add(textTelefonePessoa);

			JLabel labelNascimentoPessoa = new JLabel("Data Nascimento:");
			labelNascimentoPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
			labelNascimentoPessoa.setBounds(138, 61, 96, 14);
			contentPane.add(labelNascimentoPessoa);

			textNascimentoPessoa = new JFormattedTextField(new MaskFormatter("##/##/####"));
			textNascimentoPessoa.setHorizontalAlignment(SwingConstants.CENTER);
			textNascimentoPessoa.setBounds(138, 82, 96, 20);
			contentPane.add(textNascimentoPessoa);

			JLabel labelCpfPessoa = new JLabel("CPF:");
			labelCpfPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
			labelCpfPessoa.setBounds(244, 61, 71, 14);
			contentPane.add(labelCpfPessoa);

			textCpfPessoa = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			textCpfPessoa.setHorizontalAlignment(SwingConstants.CENTER);
			textCpfPessoa.setBounds(244, 82, 96, 20);
			contentPane.add(textCpfPessoa);

			JLabel labelCepPessoa = new JLabel("CEP:");
			labelCepPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
			labelCepPessoa.setBounds(350, 61, 71, 14);
			contentPane.add(labelCepPessoa);

			JLabel labelUfPessoa = new JLabel("UF:");
			labelUfPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
			labelUfPessoa.setBounds(450, 63, 33, 14);
			contentPane.add(labelUfPessoa);

			textUfPessoa = new JTextField();
			textUfPessoa.setHorizontalAlignment(SwingConstants.CENTER);
			textUfPessoa.setColumns(10);
			textUfPessoa.setBounds(450, 82, 33, 20);
			contentPane.add(textUfPessoa);

			textCepPessoa = new JFormattedTextField(new MaskFormatter("########"));
			textCepPessoa.setHorizontalAlignment(SwingConstants.CENTER);
			textCepPessoa.setBounds(350, 82, 71, 20);
			contentPane.add(textCepPessoa);
			
			btnBuscaCep = new JButton("?");
			btnBuscaCep.setBounds(419, 82, 21, 19);
			contentPane.add(btnBuscaCep);

			JLabel labelLogradouroPessoa = new JLabel("Logradouro:");
			labelLogradouroPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
			labelLogradouroPessoa.setBounds(10, 113, 106, 14);
			contentPane.add(labelLogradouroPessoa);

			textLogradouroPessoa = new JTextField();
			textLogradouroPessoa.setColumns(10);
			textLogradouroPessoa.setBounds(10, 132, 246, 20);
			contentPane.add(textLogradouroPessoa);

			JLabel labelBairroPessoa = new JLabel("Bairro:");
			labelBairroPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
			labelBairroPessoa.setBounds(266, 113, 84, 14);
			contentPane.add(labelBairroPessoa);

			textBairroPessoa = new JTextField();
			textBairroPessoa.setColumns(10);
			textBairroPessoa.setBounds(266, 132, 253, 20);
			contentPane.add(textBairroPessoa);

			JLabel labelNumeroPessoa = new JLabel("Número:");
			labelNumeroPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
			labelNumeroPessoa.setBounds(10, 163, 71, 14);
			contentPane.add(labelNumeroPessoa);

			textNumeroPessoa = new JTextField();
			textNumeroPessoa.setColumns(10);
			textNumeroPessoa.setBounds(10, 182, 46, 20);
			contentPane.add(textNumeroPessoa);

			JLabel labelCidadePessoa = new JLabel("Cidade:");
			labelCidadePessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
			labelCidadePessoa.setBounds(66, 163, 84, 14);
			contentPane.add(labelCidadePessoa);

			textCidadePessoa = new JTextField();
			textCidadePessoa.setColumns(10);
			textCidadePessoa.setBounds(66, 182, 190, 20);
			contentPane.add(textCidadePessoa);

			JLabel labelPaisPessoa = new JLabel("País:");
			labelPaisPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
			labelPaisPessoa.setBounds(268, 163, 46, 14);
			contentPane.add(labelPaisPessoa);

			textPaisPessoa = new JTextField();
			textPaisPessoa.setColumns(10);
			textPaisPessoa.setBounds(268, 182, 251, 20);
			contentPane.add(textPaisPessoa);

			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(10, 310, 140, 40);
			contentPane.add(btnCancelar);

			btnSalvar = new JButton("Salvar");
			btnSalvar.setBounds(379, 310, 140, 40);
			contentPane.add(btnSalvar);

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
