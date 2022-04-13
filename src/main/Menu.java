package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.MaskFormatter;

import classe.*;
import dao.*;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings({ "serial", "rawtypes", "unchecked" })
public class Menu extends JFrame {

//Questão 1
	DecimalFormat doubleFormatado = new DecimalFormat("##.00");
	private JButton btnCalculaMedia;
	private JTextField textValorUm;
	private JTextField textValorDois;
	private JTextField textValorTres;
	private JTextField textValorMediaUm;
	private JTextField textValorQuatro;
	private JTextField textValorCinco;
	private JTextField textValorSeis;
	private JTextField textValorMediaDois;
	private JTextField textSomaMedia;
	private JTextField textMediaDaMedia;
//Questão 2
	private SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
	private TimeUnit dias = TimeUnit.DAYS;
	private JFormattedTextField textValorMonetario;
	private JFormattedTextField textDataPagamento;
	private JFormattedTextField textDataVencimento;
	private JFormattedTextField textIndiceJuros;
	private JFormattedTextField textIndiceDesconto;
	private JFormattedTextField textValorMonetarioOriginal;
	private JFormattedTextField textValorJuros;
	private JFormattedTextField textValorDesconto;
	private JFormattedTextField textValorFinal;
//Questão 3
	private static PessoaDao pessoaDao = new PessoaDao();
	private static EnderecoDao enderecoDao = new EnderecoDao();
	private static PedidoDao pedidoDao = new PedidoDao();
	private static List<Pessoa> pessoas = new ArrayList<Pessoa>();

	private DefaultComboBoxModel modeloLista = new DefaultComboBoxModel();
	private JComboBox listaPessoa;
	private JPanel MainProvinha;
	private JButton btnCadastroPessoa;
	private JButton btnLancarPedido;
	private JButton btnCalcular;
	private JFormattedTextField textCpfPessoa;
	private JFormattedTextField textTelefonePessoa;
	private JFormattedTextField textNascimentoPessoa;
	private JFormattedTextField textCepPessoa;
	private JTextField textEmailPessoa;
	private JTextField textLogradouroPessoa;
	private JTextField textNumeroPessoa;
	private JTextField textBairroPessoa;
	private JTextField textCidadePessoa;
	private JTextField textUfPessoa;
	private JTextField textPaisPessoa;
	private static JTable tabelaPedidos;
	private JTextField tabelaNomePedido;
	private JTextField tabelaDataPedido;
	private JTextField tabelaValorPedido;
	private JTextField tabelaDescricaoPedido;
	private JTextField tabelaEmailPedido;

	private static CadastroPessoa cadastroPessoa = new CadastroPessoa();
	private static LancaPedido lancaPedido = new LancaPedido();

	public DefaultComboBoxModel getModeloLista() {
		return this.modeloLista;
	}
	
	public List getPessoas() {
		return pessoas;
	}
	
	public JTextField getTextValorUm() {
		return textValorUm;
	}

	public JTextField getTextValorDois() {
		return textValorDois;
	}

	public JTextField getTextValorTres() {
		return textValorTres;
	}

	public JTextField getTextValorQuatro() {
		return textValorQuatro;
	}

	public JTextField getTextValorCinco() {
		return textValorCinco;
	}

	public JTextField getTextValorSeis() {
		return textValorSeis;
	}

	public JTextField getTextValorMediaUm() {
		return textValorMediaUm;
	}

	public JTextField getTextValorMediaDois() {
		return textValorMediaDois;
	}

	public JTextField getTextSomaMedia() {
		return textSomaMedia;
	}

	public JTextField getTextMediaDaMedia() {
		return textMediaDaMedia;
	}

	public JTextField getTextValorMedia() {
		return textValorMediaUm;
	}

	public JFormattedTextField getTextValorMonetario() {
		return textValorMonetario;
	}

	public JFormattedTextField getTextIndiceJuros() {
		return textIndiceJuros;
	}

	public JFormattedTextField getTextIndiceDesconto() {
		return textIndiceDesconto;
	}

	public JFormattedTextField getTextValorMonetarioOriginal() {
		return textValorMonetarioOriginal;
	}

	public JFormattedTextField getTextValorJuros() {
		return textValorJuros;
	}

	public JFormattedTextField getTextValorDesconto() {
		return textValorDesconto;
	}

	public JFormattedTextField getTextValorFinal() {
		return textValorFinal;
	}

//Area de produção da aplicação
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
					frame.mediaOnInit();

					frame.btnCadastroPessoa.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							cadastroPessoa.setVisible(true);
						}
					});
					frame.btnLancarPedido.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							lancaPedido.setVisible(true);
						}
					});
					frame.listaPessoa.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							frame.exibeDadosPessoa();
							frame.exibePedidos();
						}
					});
					frame.btnCalculaMedia.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							int valorUm = frame.valorUmParaInt();
							int valorDois = frame.valorDoisParaInt();
							int valorTres = frame.valorTresParaInt();
							int valorQuatro = frame.valorQuatroParaInt();
							int valorCinco = frame.valorCincoParaInt();
							int valorSeis = frame.valorSeisParaInt();
							double mediaUm = frame.calcMediaUm(valorUm, valorDois, valorTres);
							double mediaDois = frame.calcMediaDois(valorQuatro, valorCinco, valorSeis);
							double somaMedia = frame.calcSomaMedias(mediaUm, mediaDois);
							double mediaMedia = frame.calcMediaMedia(somaMedia);
							
							frame.exibeMediaUm(frame.mediaUmStr(mediaUm));
							frame.exibeMediaDois(frame.mediaDoisStr(mediaDois));
							frame.exibeSomaMedia(frame.somaMediaStr(somaMedia));
							frame.exibeMediaMedia(frame.mediaMediaStr(mediaMedia));
						}
					});
					frame.btnCalcular.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							double valor = frame.converteValorMonetario();
							double juros = frame.converteIndiceJuros();
							double desconto = frame.converteIndiceDesconto();
							long diasAtraso = frame.diasAtraso();
							
							double valorDesconto = frame.calcValorDesconto(valor, desconto);
							double valorFinalDesconto = frame.calcValorFinalDesconto(valor, valorDesconto);
							String valorDescontoStr = frame.descontoParaStr(valorDesconto);
							String valorFinalDescontoStr = frame.valorFinalParaStr(valorFinalDesconto);
							
							double valorJuros = frame.calcValorJuros(valor, juros);
							double valorFinalJuros = frame.calcValorFinalJuros(valor, valorJuros);
							String valorJurosStr = frame.jurosParaStr(valorJuros);
							String valorFinalJurosStr = frame.valorFinalParaStr(valorFinalJuros);
							
							if(diasAtraso <= 0) {
								frame.exibeValorDesconto(valorDescontoStr);
								frame.exibeValorFinal(valorFinalDescontoStr);
							}
							if(diasAtraso > 0) {
								frame.exibeValorJuros(valorJurosStr);
								frame.exibeValorFinal(valorFinalJurosStr);
							}
							
							frame.textValorMonetarioOriginal.setText(frame.getTextValorMonetario().getText());	
						}
					});
					cadastroPessoa.getBtnBuscaCep().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							cadastroPessoa.buscaCep();
							cadastroPessoa.getTextPaisPessoa().setText("Brasil");
							cadastroPessoa.getTextNumeroPessoa().requestFocus();
						}
					});
					cadastroPessoa.getBtnCancelar().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							cadastroPessoa.limpaCampos();
							cadastroPessoa.setVisible(false);
						}
					});
					cadastroPessoa.getBtnSalvar().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							pessoas.add(cadastroPessoa.cadastraPessoa());
							frame.modeloLista.addElement(pessoas.get(pessoas.size() - 1).getNome());
							lancaPedido.atualizaLista(pessoas.get(pessoas.size() - 1).getNome());
							pessoaDao.inserir(pessoas.get(pessoas.size() - 1));
							enderecoDao.inserir(pessoas.get(pessoas.size() - 1).getEndereco());
							cadastroPessoa.limpaCampos();
						}
					});
					lancaPedido.getBtnCancelar().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							lancaPedido.limpaCampos();
							lancaPedido.setVisible(false);
						}
					});
					lancaPedido.getBtnSalvar().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							lancaPedido.salvaPedido(pessoas.get(lancaPedido.getIndexPessoa()));
							pedidoDao.inserir(pessoas.get(lancaPedido.getIndexPessoa()).getPedido(pessoas.get(lancaPedido.getIndexPessoa()).getPedidos().size() - 1));
							lancaPedido.limpaCampos();
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//Fim área de produção da aplicação

//Questão 01
	public int valorUmParaInt() {
		return Integer.parseInt(this.getTextValorUm().getText());
	}
	public int valorDoisParaInt() {
		return Integer.parseInt(this.getTextValorDois().getText());
	}
	public int valorTresParaInt() {
		return Integer.parseInt(this.getTextValorTres().getText());
	}
	public int valorQuatroParaInt() {
		return Integer.parseInt(this.getTextValorQuatro().getText());
	}
	public int valorCincoParaInt() {
		return Integer.parseInt(this.getTextValorCinco().getText());
	}
	public int valorSeisParaInt() {
		return Integer.parseInt(this.getTextValorSeis().getText());
	}
	public double calcMediaUm(int valorUm, int valorDois, int valorTres) {
		return (valorUm + valorDois + valorTres) / 3;
	}
	public double calcMediaDois(int valorQuatro, int valorCinco, int valorSeis) {
		return (valorQuatro + valorCinco + valorSeis) / 3;
	}
	public double calcSomaMedias(double mediaUm, double mediaDois) {
		return mediaUm + mediaDois;
	}
	public double calcMediaMedia(double somaMedia) {
		return somaMedia / 2;
	}
	public String mediaUmStr(double mediaUm) { 										
		return this.doubleFormatado.format(mediaUm);
	}
	public String mediaDoisStr(double mediaDois) {
		return this.doubleFormatado.format(mediaDois);
	}
	public String somaMediaStr (double somaMedia) {
		return doubleFormatado.format(somaMedia);
	}
	public String mediaMediaStr(double mediaMedia) {
		return doubleFormatado.format(mediaMedia);
	}
	public void exibeMediaUm(String mediaUmStr) {
		this.getTextValorMediaUm().setText(mediaUmStr);
	}
	public void exibeMediaDois(String mediaDoisStr) {
		this.getTextValorMediaDois().setText(mediaDoisStr);
	}
	public void exibeSomaMedia(String somaMediaStr) {
		this.getTextSomaMedia().setText(somaMediaStr);
	}
	public void exibeMediaMedia(String mediaMediaStr) {
		this.getTextMediaDaMedia().setText(mediaMediaStr);
	}
	public void mediaOnInit() {
		int valorUm = this.valorUmParaInt();
		int valorDois = this.valorDoisParaInt();
		int valorTres = this.valorTresParaInt();
		int valorQuatro = this.valorQuatroParaInt();
		int valorCinco = this.valorCincoParaInt();
		int valorSeis = this.valorSeisParaInt();
		double mediaUm = this.calcMediaUm(valorUm, valorDois, valorTres);
		double mediaDois = this.calcMediaDois(valorQuatro, valorCinco, valorSeis);
		double somaMedia = this.calcSomaMedias(mediaUm, mediaDois);
		double mediaMedia = this.calcMediaMedia(somaMedia);
		
		this.exibeMediaUm(this.mediaUmStr(mediaUm));
		this.exibeMediaDois(this.mediaDoisStr(mediaDois));
		this.exibeSomaMedia(this.somaMediaStr(somaMedia));
		this.exibeMediaMedia(this.mediaMediaStr(mediaMedia));
	}
	
//Questão 02
	// Converte o texto do campo textValorMonetario em double
	public double converteValorMonetario() {
		double valorConvertido = Double.parseDouble(this.getTextValorMonetario().getText());
		return valorConvertido;
	}
	// Converte o texto do campo textIndiceJuros em double
	public double converteIndiceJuros() {
		double valorConvertido = Double.parseDouble(this.getTextIndiceJuros().getText());
		return valorConvertido;
	}
	// Converte o texto do campo textIndiceDesconto em double
	public double converteIndiceDesconto() {
		double valorConvertido = Double.parseDouble(this.getTextIndiceDesconto().getText());
		return valorConvertido;
	}
	public long diasAtraso() {
		try {
			Date dataPagamento = this.formatoData.parse(this.textDataPagamento.getText());
			Date dataVencimento = this.formatoData.parse(this.textDataVencimento.getText());
			long diferencaTempo = dataPagamento.getTime() - dataVencimento.getTime();
			long diasAtraso = dias.convert(diferencaTempo, TimeUnit.MILLISECONDS);
			return diasAtraso;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
	public double calcValorDesconto(double valor, double desconto) {
		desconto = desconto / 100;
		return valor * desconto;
	}
	public double calcValorJuros(double valor, double juros) {
		juros = (juros * this.diasAtraso()) / 100;
		return valor * juros;
	}
	public double calcValorFinalDesconto(double valor, double desconto) {
		double valorFinal = valor - this.calcValorDesconto(valor, desconto);
		return valorFinal;
	}
	public double calcValorFinalJuros(double valor, double juros) {
		double valorFinal = valor + this.calcValorJuros(valor, juros);
		return valorFinal;
	}
	public String descontoParaStr(double valorDesconto) {
		DecimalFormat doubleFormatado = new DecimalFormat("00000.00");
		return doubleFormatado.format(valorDesconto);
	}
	public String valorFinalParaStr(double valorFinal) {
		DecimalFormat doubleFormatado = new DecimalFormat("00000.00");
		return doubleFormatado.format(valorFinal);
	}
	public String jurosParaStr(double valorJuros) {
		DecimalFormat doubleFormatado = new DecimalFormat("00000.00");
		return doubleFormatado.format(valorJuros);
	}
	public void exibeValorDesconto(String descontoFormatado) {
		this.textValorDesconto.setText(descontoFormatado);
		this.textValorJuros.setText("00000,00");
	}
	public void exibeValorJuros(String jurosFormatado) {
		this.textValorJuros.setText(jurosFormatado);
		this.textValorDesconto.setText("00000,00");
	}
	public void exibeValorFinal(String finalFormatado) {
		this.textValorFinal.setText(finalFormatado);
	}
	
//Questão 3
	public String nomePedido() {
		return pessoas.get(this.modeloLista.getIndexOf(this.modeloLista.getSelectedItem())).getNome();
	}
	public String dataPedido(int index) {
		return pessoas.get(this.modeloLista.getIndexOf(this.modeloLista.getSelectedItem())).getPedido(index).getData();
	}
	public String valorPedido(int index) {
		return pessoas.get(this.modeloLista.getIndexOf(this.modeloLista.getSelectedItem())).getPedido(index).getValor();
	}
	public String descricaoPedido(int index) {
		return pessoas.get(this.modeloLista.getIndexOf(this.modeloLista.getSelectedItem())).getPedido(index).getDescricao();
	}
	public String emailPedido() {
		return pessoas.get(this.modeloLista.getIndexOf(this.modeloLista.getSelectedItem())).getEmail();
	}
	public void exibePedidos() {
		for(int r = 0; r <= pessoas.get(this.modeloLista.getIndexOf(this.modeloLista.getSelectedItem())).getPedidos().size() - 1; r++) {
			tabelaPedidos.setValueAt(this.nomePedido(), r, 0);
			tabelaPedidos.setValueAt(this.dataPedido(r), r, 1);
			tabelaPedidos.setValueAt(this.valorPedido(r), r, 2);
			tabelaPedidos.setValueAt(this.descricaoPedido(r), r, 3);
			tabelaPedidos.setValueAt(this.emailPedido(), r, 4);	
		}
	}
	public String cpfPessoaSelecionada() {
		return pessoas.get(this.modeloLista.getIndexOf(this.modeloLista.getSelectedItem())).getCpf();
	}
	public String telefonePessoaSelecionada() {
		return pessoas.get(this.modeloLista.getIndexOf(this.modeloLista.getSelectedItem())).getTelefone();
	}
	public String nascimentoPessoaSelecionada() {
		return pessoas.get(this.modeloLista.getIndexOf(this.modeloLista.getSelectedItem())).getNascimento();
	}
	public String emailPessoaSelecionada() {
		return pessoas.get(this.modeloLista.getIndexOf(this.modeloLista.getSelectedItem())).getEmail();
	}
	public String cepPessoaSelecionada() {
		return pessoas.get(this.modeloLista.getIndexOf(this.modeloLista.getSelectedItem())).getEndereco().getCep();
	}
	public String logradouroPessoaSelecionada() {
		return pessoas.get(this.modeloLista.getIndexOf(this.modeloLista.getSelectedItem())).getEndereco().getLogradouro();
	}
	public String numeroPessoaSelecionada() {
		return pessoas.get(this.modeloLista.getIndexOf(this.modeloLista.getSelectedItem())).getEndereco().getNumero();
	}
	public String bairroPessoaSelecionada() {
		return pessoas.get(this.modeloLista.getIndexOf(this.modeloLista.getSelectedItem())).getEndereco().getBairro();
	}
	public String cidadePessoaSelecionada() {
		return pessoas.get(this.modeloLista.getIndexOf(this.modeloLista.getSelectedItem())).getEndereco().getCidade();
	}
	public String ufPessoaSelecionada() {
		return pessoas.get(this.modeloLista.getIndexOf(this.modeloLista.getSelectedItem())).getEndereco().getUf();
	}
	public String paisPessoaSelecionada() {
		return pessoas.get(this.modeloLista.getIndexOf(this.modeloLista.getSelectedItem())).getEndereco().getPais();
	}
	public void exibeDadosPessoa() {
		this.textCpfPessoa.setText(this.cpfPessoaSelecionada());
		this.textTelefonePessoa.setText(this.telefonePessoaSelecionada());
		this.textNascimentoPessoa.setText(this.nascimentoPessoaSelecionada());
		this.textEmailPessoa.setText(this.emailPessoaSelecionada());
		this.textCepPessoa.setText(this.cepPessoaSelecionada());
		this.textLogradouroPessoa.setText(this.logradouroPessoaSelecionada());
		this.textNumeroPessoa.setText(this.numeroPessoaSelecionada());
		this.textBairroPessoa.setText(this.bairroPessoaSelecionada());
		this.textCidadePessoa.setText(this.cidadePessoaSelecionada());
		this.textUfPessoa.setText(this.ufPessoaSelecionada());
		this.textPaisPessoa.setText(this.paisPessoaSelecionada());
	}

//Fim métodos

//Cria os componentes visuais da tela e define seus valores iniciais
	public Menu() {

		setTitle("Provinha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1115, 700);
		MainProvinha = new JPanel();
		MainProvinha.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(MainProvinha);
		MainProvinha.setLayout(null);

		try {

			btnCadastroPessoa = new JButton("Cadastro de Pessoa");
			btnCadastroPessoa.setBounds(10, 11, 167, 35);
			MainProvinha.add(btnCadastroPessoa);

			btnLancarPedido = new JButton("Lan\u00E7ar Pedido");
			btnLancarPedido.setBounds(198, 11, 167, 35);
			MainProvinha.add(btnLancarPedido);

			JPanel painelPessoa = new JPanel();
			painelPessoa.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
			painelPessoa.setBackground(Color.LIGHT_GRAY);
			painelPessoa.setBounds(10, 57, 355, 314);
			MainProvinha.add(painelPessoa);
			painelPessoa.setLayout(null);

			JLabel labelListaPessoa = new JLabel("Pessoa:");
			labelListaPessoa.setBounds(10, 11, 69, 19);
			painelPessoa.add(labelListaPessoa);
			labelListaPessoa.setFont(new Font("Tahoma", Font.PLAIN, 15));

			listaPessoa = new JComboBox(modeloLista);
			listaPessoa.setBounds(10, 34, 207, 22);
			painelPessoa.add(listaPessoa);
			listaPessoa.setEditable(true);

			JLabel labelCpfPessoa = new JLabel("CPF:");
			labelCpfPessoa.setBounds(10, 67, 46, 14);
			painelPessoa.add(labelCpfPessoa);
			labelCpfPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));

			
			textCpfPessoa = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			textCpfPessoa.setBounds(10, 84, 102, 20);
			painelPessoa.add(textCpfPessoa);
			textCpfPessoa.setEditable(false);
			textCpfPessoa.setHorizontalAlignment(SwingConstants.CENTER);

			JLabel labelTelefonePessoa = new JLabel("Telefone:");
			labelTelefonePessoa.setBounds(122, 67, 122, 14);
			painelPessoa.add(labelTelefonePessoa);
			labelTelefonePessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));

			textTelefonePessoa = new JFormattedTextField(new MaskFormatter("(##) # ####-####"));
			textTelefonePessoa.setBounds(122, 84, 102, 20);
			painelPessoa.add(textTelefonePessoa);
			textTelefonePessoa.setEditable(false);
			textTelefonePessoa.setHorizontalAlignment(SwingConstants.CENTER);

			JLabel labelNascimentoPessoa = new JLabel("Data Nascimento:");
			labelNascimentoPessoa.setBounds(234, 67, 102, 14);
			painelPessoa.add(labelNascimentoPessoa);
			labelNascimentoPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));

			textNascimentoPessoa = new JFormattedTextField(new MaskFormatter("##/##/####"));
			textNascimentoPessoa.setBounds(234, 84, 106, 20);
			painelPessoa.add(textNascimentoPessoa);
			textNascimentoPessoa.setEditable(false);
			textNascimentoPessoa.setHorizontalAlignment(SwingConstants.CENTER);

			JLabel labelEmailPessoa = new JLabel("E-mail:");
			labelEmailPessoa.setBounds(10, 117, 46, 14);
			painelPessoa.add(labelEmailPessoa);
			labelEmailPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));

			textEmailPessoa = new JTextField();
			textEmailPessoa.setBounds(10, 134, 330, 20);
			painelPessoa.add(textEmailPessoa);
			textEmailPessoa.setEditable(false);
			textEmailPessoa.setColumns(10);

			JLabel labelCepPessoa = new JLabel("CEP:");
			labelCepPessoa.setBounds(10, 165, 46, 14);
			painelPessoa.add(labelCepPessoa);
			labelCepPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));

			textCepPessoa = new JFormattedTextField(new MaskFormatter("#####-###"));
			textCepPessoa.setBounds(10, 182, 77, 20);
			painelPessoa.add(textCepPessoa);
			textCepPessoa.setEditable(false);
			textCepPessoa.setHorizontalAlignment(SwingConstants.CENTER);

			JLabel labelLogradouroPessoa = new JLabel("Logradouro:");
			labelLogradouroPessoa.setBounds(97, 165, 120, 14);
			painelPessoa.add(labelLogradouroPessoa);
			labelLogradouroPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));

			textLogradouroPessoa = new JTextField();
			textLogradouroPessoa.setBounds(97, 182, 243, 20);
			painelPessoa.add(textLogradouroPessoa);
			textLogradouroPessoa.setEditable(false);
			textLogradouroPessoa.setColumns(10);

			JLabel labelNumeroPessoa = new JLabel("Número:");
			labelNumeroPessoa.setBounds(10, 213, 69, 14);
			painelPessoa.add(labelNumeroPessoa);
			labelNumeroPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));

			textNumeroPessoa = new JTextField();
			textNumeroPessoa.setBounds(10, 230, 46, 20);
			painelPessoa.add(textNumeroPessoa);
			textNumeroPessoa.setEditable(false);
			textNumeroPessoa.setHorizontalAlignment(SwingConstants.CENTER);
			textNumeroPessoa.setColumns(10);

			JLabel labelBairroPessoa = new JLabel("Bairro:");
			labelBairroPessoa.setBounds(66, 213, 46, 14);
			painelPessoa.add(labelBairroPessoa);
			labelBairroPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));

			textBairroPessoa = new JTextField();
			textBairroPessoa.setBounds(66, 230, 142, 20);
			painelPessoa.add(textBairroPessoa);
			textBairroPessoa.setEditable(false);
			textBairroPessoa.setColumns(10);

			JLabel labelCidadePessoa = new JLabel("Cidade:");
			labelCidadePessoa.setBounds(218, 213, 120, 14);
			painelPessoa.add(labelCidadePessoa);
			labelCidadePessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));

			textCidadePessoa = new JTextField();
			textCidadePessoa.setBounds(218, 230, 122, 20);
			painelPessoa.add(textCidadePessoa);
			textCidadePessoa.setEditable(false);
			textCidadePessoa.setColumns(10);

			JLabel labelUfPessoa = new JLabel("UF:");
			labelUfPessoa.setBounds(10, 261, 27, 14);
			painelPessoa.add(labelUfPessoa);
			labelUfPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));

			textUfPessoa = new JTextField();
			textUfPessoa.setBounds(10, 278, 27, 20);
			painelPessoa.add(textUfPessoa);
			textUfPessoa.setEditable(false);
			textUfPessoa.setHorizontalAlignment(SwingConstants.CENTER);
			textUfPessoa.setColumns(10);

			JLabel labelPaisPessoa = new JLabel("País:");
			labelPaisPessoa.setBounds(47, 261, 40, 14);
			painelPessoa.add(labelPaisPessoa);
			labelPaisPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));

			textPaisPessoa = new JTextField();
			textPaisPessoa.setBounds(47, 278, 119, 20);
			painelPessoa.add(textPaisPessoa);
			textPaisPessoa.setEditable(false);
			textPaisPessoa.setColumns(10);

			JPanel painelTabela = new JPanel();
			painelTabela.setBounds(375, 11, 712, 360);
			MainProvinha.add(painelTabela);
			painelTabela.setLayout(null);

			tabelaNomePedido = new JTextField();
			tabelaNomePedido.setText("NOME:");
			tabelaNomePedido.setHorizontalAlignment(SwingConstants.CENTER);
			tabelaNomePedido.setEditable(false);
			tabelaNomePedido.setColumns(10);
			tabelaNomePedido.setBounds(0, 0, 161, 20);
			painelTabela.add(tabelaNomePedido);

			tabelaDataPedido = new JTextField();
			tabelaDataPedido.setText("DATA:");
			tabelaDataPedido.setHorizontalAlignment(SwingConstants.CENTER);
			tabelaDataPedido.setEditable(false);
			tabelaDataPedido.setColumns(10);
			tabelaDataPedido.setBounds(160, 0, 94, 20);
			painelTabela.add(tabelaDataPedido);

			tabelaValorPedido = new JTextField();
			tabelaValorPedido.setText("VALOR:");
			tabelaValorPedido.setHorizontalAlignment(SwingConstants.CENTER);
			tabelaValorPedido.setEditable(false);
			tabelaValorPedido.setColumns(10);
			tabelaValorPedido.setBounds(253, 0, 90, 20);
			painelTabela.add(tabelaValorPedido);

			tabelaDescricaoPedido = new JTextField();
			tabelaDescricaoPedido.setText("DESCRIÇÃO:");
			tabelaDescricaoPedido.setHorizontalAlignment(SwingConstants.CENTER);
			tabelaDescricaoPedido.setEditable(false);
			tabelaDescricaoPedido.setColumns(10);
			tabelaDescricaoPedido.setBounds(342, 0, 193, 20);
			painelTabela.add(tabelaDescricaoPedido);

			tabelaEmailPedido = new JTextField();
			tabelaEmailPedido.setText("E-MAIL:");
			tabelaEmailPedido.setHorizontalAlignment(SwingConstants.CENTER);
			tabelaEmailPedido.setEditable(false);
			tabelaEmailPedido.setColumns(10);
			tabelaEmailPedido.setBounds(534, 0, 178, 20);
			painelTabela.add(tabelaEmailPedido);

			tabelaPedidos = new JTable();
			tabelaPedidos.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
				},
				new String[] {
					"NOME:", "DATA:", "VALOR:", "DESCRI\u00C7\u00C3O:", "E-MAIL:"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			tabelaPedidos.getColumnModel().getColumn(0).setPreferredWidth(135);
			tabelaPedidos.getColumnModel().getColumn(1).setPreferredWidth(66);
			tabelaPedidos.getColumnModel().getColumn(2).setPreferredWidth(64);
			tabelaPedidos.getColumnModel().getColumn(3).setPreferredWidth(166);
			tabelaPedidos.getColumnModel().getColumn(4).setPreferredWidth(154);
			tabelaPedidos.setColumnSelectionAllowed(true);
			tabelaPedidos.setCellSelectionEnabled(true);
			tabelaPedidos.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
			tabelaPedidos.setBackground(SystemColor.controlHighlight);
			tabelaPedidos.setBounds(0, 21, 712, 339);
			painelTabela.add(tabelaPedidos);

			JSeparator separator = new JSeparator();
			separator.setBackground(Color.DARK_GRAY);
			separator.setForeground(Color.DARK_GRAY);
			separator.setBounds(10, 382, 1079, 2);
			MainProvinha.add(separator);

			JSeparator separator_1 = new JSeparator();
			separator_1.setOrientation(SwingConstants.VERTICAL);
			separator_1.setForeground(Color.DARK_GRAY);
			separator_1.setBackground(Color.DARK_GRAY);
			separator_1.setBounds(385, 382, 2, 283);
			MainProvinha.add(separator_1);

			JLabel labelValorMonetario = new JLabel("Valor Monetario:");
			labelValorMonetario.setFont(new Font("Tahoma", Font.PLAIN, 12));
			labelValorMonetario.setBounds(397, 396, 95, 14);
			MainProvinha.add(labelValorMonetario);

			textValorMonetario = new JFormattedTextField(new MaskFormatter("#####.##"));
			textValorMonetario.setText("");
			textValorMonetario.setHorizontalAlignment(SwingConstants.CENTER);
			textValorMonetario.setBounds(423, 419, 64, 22);
			MainProvinha.add(textValorMonetario);

			JLabel labelDataPagamento = new JLabel("Data Pagamento:");
			labelDataPagamento.setFont(new Font("Tahoma", Font.PLAIN, 12));
			labelDataPagamento.setBounds(497, 397, 95, 14);
			MainProvinha.add(labelDataPagamento);

			textDataPagamento = new JFormattedTextField(new MaskFormatter("##/##/####"));
			textDataPagamento.setHorizontalAlignment(SwingConstants.CENTER);
			textDataPagamento.setBounds(497, 419, 95, 22);
			MainProvinha.add(textDataPagamento);

			JLabel labelDataVencimento = new JLabel("Data Vencimento:");
			labelDataVencimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
			labelDataVencimento.setBounds(602, 396, 126, 14);
			MainProvinha.add(labelDataVencimento);

			textDataVencimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
			textDataVencimento.setHorizontalAlignment(SwingConstants.CENTER);
			textDataVencimento.setBounds(602, 419, 95, 22);
			MainProvinha.add(textDataVencimento);

			JLabel labelIndiceJuros = new JLabel("Índice Juros:");
			labelIndiceJuros.setFont(new Font("Tahoma", Font.PLAIN, 12));
			labelIndiceJuros.setBounds(707, 395, 81, 14);
			MainProvinha.add(labelIndiceJuros);

			JFormattedTextField textIndiceDiario = new JFormattedTextField();
			textIndiceDiario.setEditable(false);
			textIndiceDiario.setHorizontalAlignment(SwingConstants.CENTER);
			textIndiceDiario.setText("% Diário");
			textIndiceDiario.setBounds(747, 419, 53, 22);
			MainProvinha.add(textIndiceDiario);

			textIndiceJuros = new JFormattedTextField(new MaskFormatter("##.##"));
			textIndiceJuros.setText("00.01");
			textIndiceJuros.setHorizontalAlignment(SwingConstants.CENTER);
			textIndiceJuros.setBounds(707, 419, 41, 22);
			MainProvinha.add(textIndiceJuros);

			JLabel labelDesconto = new JLabel("Desconto:");
			labelDesconto.setFont(new Font("Tahoma", Font.PLAIN, 12));
			labelDesconto.setBounds(810, 395, 81, 14);
			MainProvinha.add(labelDesconto);

			JFormattedTextField textDescontoPorcento = new JFormattedTextField();
			textDescontoPorcento.setText("%");
			textDescontoPorcento.setHorizontalAlignment(SwingConstants.CENTER);
			textDescontoPorcento.setEditable(false);
			textDescontoPorcento.setBounds(853, 419, 27, 22);
			MainProvinha.add(textDescontoPorcento);

			textIndiceDesconto = new JFormattedTextField(new MaskFormatter("###.##"));
			textIndiceDesconto.setText("010.00");
			textIndiceDesconto.setHorizontalAlignment(SwingConstants.CENTER);
			textIndiceDesconto.setBounds(810, 419, 46, 22);
			MainProvinha.add(textIndiceDesconto);

			JFormattedTextField textMoedaReal = new JFormattedTextField();
			textMoedaReal.setText("R$");
			textMoedaReal.setHorizontalAlignment(SwingConstants.CENTER);
			textMoedaReal.setEditable(false);
			textMoedaReal.setBounds(397, 419, 27, 22);
			MainProvinha.add(textMoedaReal);

			JLabel labelValorMonetarioOriginal = new JLabel("Valor Original:");
			labelValorMonetarioOriginal.setFont(new Font("Tahoma", Font.PLAIN, 12));
			labelValorMonetarioOriginal.setBounds(397, 511, 95, 14);
			MainProvinha.add(labelValorMonetarioOriginal);

			JFormattedTextField textMoedaReal_1 = new JFormattedTextField();
			textMoedaReal_1.setText("R$");
			textMoedaReal_1.setHorizontalAlignment(SwingConstants.CENTER);
			textMoedaReal_1.setEditable(false);
			textMoedaReal_1.setBounds(397, 534, 27, 22);
			MainProvinha.add(textMoedaReal_1);

			textValorMonetarioOriginal = new JFormattedTextField(new MaskFormatter("#####.##"));
			textValorMonetarioOriginal.setEditable(false);
			textValorMonetarioOriginal.setText("");
			textValorMonetarioOriginal.setHorizontalAlignment(SwingConstants.CENTER);
			textValorMonetarioOriginal.setBounds(423, 534, 64, 22);
			MainProvinha.add(textValorMonetarioOriginal);

			JLabel labelValorJuros = new JLabel("Valor Juros:");
			labelValorJuros.setFont(new Font("Tahoma", Font.PLAIN, 12));
			labelValorJuros.setBounds(497, 511, 95, 14);
			MainProvinha.add(labelValorJuros);

			JFormattedTextField textMoedaReal_2 = new JFormattedTextField();
			textMoedaReal_2.setText("R$");
			textMoedaReal_2.setHorizontalAlignment(SwingConstants.CENTER);
			textMoedaReal_2.setEditable(false);
			textMoedaReal_2.setBounds(497, 534, 27, 22);
			MainProvinha.add(textMoedaReal_2);

			textValorJuros = new JFormattedTextField(new MaskFormatter("#####,##"));
			textValorJuros.setEditable(false);
			textValorJuros.setText("");
			textValorJuros.setHorizontalAlignment(SwingConstants.CENTER);
			textValorJuros.setBounds(523, 534, 64, 22);
			MainProvinha.add(textValorJuros);

			JLabel labelValorDesconto = new JLabel("Valor Desconto:");
			labelValorDesconto.setFont(new Font("Tahoma", Font.PLAIN, 12));
			labelValorDesconto.setBounds(597, 511, 95, 14);
			MainProvinha.add(labelValorDesconto);

			JFormattedTextField textMoedaReal_3 = new JFormattedTextField();
			textMoedaReal_3.setText("R$");
			textMoedaReal_3.setHorizontalAlignment(SwingConstants.CENTER);
			textMoedaReal_3.setEditable(false);
			textMoedaReal_3.setBounds(597, 534, 27, 22);
			MainProvinha.add(textMoedaReal_3);

			textValorDesconto = new JFormattedTextField(new MaskFormatter("#####,##"));
			textValorDesconto.setEditable(false);
			textValorDesconto.setText("");
			textValorDesconto.setHorizontalAlignment(SwingConstants.CENTER);
			textValorDesconto.setBounds(623, 534, 64, 22);
			MainProvinha.add(textValorDesconto);

			JLabel labelValorMonetarioFinal = new JLabel("Valor Final:");
			labelValorMonetarioFinal.setFont(new Font("Tahoma", Font.PLAIN, 12));
			labelValorMonetarioFinal.setBounds(738, 511, 95, 14);
			MainProvinha.add(labelValorMonetarioFinal);

			JFormattedTextField textMoedaReal_4 = new JFormattedTextField();
			textMoedaReal_4.setText("R$");
			textMoedaReal_4.setHorizontalAlignment(SwingConstants.CENTER);
			textMoedaReal_4.setEditable(false);
			textMoedaReal_4.setBounds(738, 534, 27, 22);
			MainProvinha.add(textMoedaReal_4);

			textValorFinal = new JFormattedTextField(new MaskFormatter("#####,##"));
			textValorFinal.setEditable(false);
			textValorFinal.setText("");
			textValorFinal.setHorizontalAlignment(SwingConstants.CENTER);
			textValorFinal.setBounds(764, 534, 64, 22);
			MainProvinha.add(textValorFinal);

			JLabel labelIgual = new JLabel("=");
			labelIgual.setFont(new Font("Tahoma", Font.PLAIN, 15));
			labelIgual.setBounds(707, 536, 21, 14);
			MainProvinha.add(labelIgual);

			btnCalcular = new JButton("Calcular");
			btnCalcular.setBounds(397, 452, 127, 48);
			MainProvinha.add(btnCalcular);

			JPanel painelMedia = new JPanel();
			painelMedia.setBounds(11, 419, 176, 140);
			painelMedia.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
			painelMedia.setBackground(Color.LIGHT_GRAY);
			MainProvinha.add(painelMedia);
			painelMedia.setLayout(null);

			JLabel labelValor1 = new JLabel("Valor 1");
			labelValor1.setBounds(10, 43, 38, 20);
			painelMedia.add(labelValor1);
			labelValor1.setFont(new Font("Tahoma", Font.PLAIN, 12));

			textValorUm = new JTextField();
			textValorUm.setHorizontalAlignment(SwingConstants.CENTER);
			textValorUm.setBounds(10, 63, 38, 20);
			painelMedia.add(textValorUm);
			textValorUm.setText("8");
			textValorUm.setColumns(10);

			JLabel labelValor2 = new JLabel("Valor 2");
			labelValor2.setBounds(69, 43, 38, 20);
			painelMedia.add(labelValor2);
			labelValor2.setFont(new Font("Tahoma", Font.PLAIN, 12));

			textValorDois = new JTextField();
			textValorDois.setHorizontalAlignment(SwingConstants.CENTER);
			textValorDois.setBounds(69, 63, 38, 20);
			painelMedia.add(textValorDois);
			textValorDois.setText("9");
			textValorDois.setColumns(10);

			JLabel labelValor3 = new JLabel("Valor 3");
			labelValor3.setBounds(128, 43, 38, 20);
			painelMedia.add(labelValor3);
			labelValor3.setFont(new Font("Tahoma", Font.PLAIN, 12));

			textValorTres = new JTextField();
			textValorTres.setHorizontalAlignment(SwingConstants.CENTER);
			textValorTres.setBounds(128, 63, 38, 20);
			painelMedia.add(textValorTres);
			textValorTres.setText("7");
			textValorTres.setColumns(10);

			JLabel labelMedia1 = new JLabel("Media 1:");
			labelMedia1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			labelMedia1.setBounds(10, 11, 83, 21);
			painelMedia.add(labelMedia1);

			JLabel labelMedia = new JLabel("Media");
			labelMedia.setBounds(69, 89, 38, 20);
			painelMedia.add(labelMedia);
			labelMedia.setHorizontalAlignment(SwingConstants.CENTER);
			labelMedia.setFont(new Font("Tahoma", Font.PLAIN, 12));

			textValorMediaUm = new JTextField();
			textValorMediaUm.setHorizontalAlignment(SwingConstants.CENTER);
			textValorMediaUm.setBounds(69, 109, 38, 20);
			painelMedia.add(textValorMediaUm);
			textValorMediaUm.setEditable(false);
			textValorMediaUm.setColumns(10);

			JPanel painelMedia_1 = new JPanel();
			painelMedia_1.setLayout(null);
			painelMedia_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
			painelMedia_1.setBackground(Color.LIGHT_GRAY);
			painelMedia_1.setBounds(199, 419, 176, 140);
			MainProvinha.add(painelMedia_1);

			JLabel labelValor4 = new JLabel("Valor 4");
			labelValor4.setFont(new Font("Tahoma", Font.PLAIN, 12));
			labelValor4.setBounds(10, 43, 38, 20);
			painelMedia_1.add(labelValor4);

			textValorQuatro = new JTextField();
			textValorQuatro.setHorizontalAlignment(SwingConstants.CENTER);
			textValorQuatro.setText("4");
			textValorQuatro.setColumns(10);
			textValorQuatro.setBounds(10, 63, 38, 20);
			painelMedia_1.add(textValorQuatro);

			JLabel labelValor5 = new JLabel("Valor 5");
			labelValor5.setFont(new Font("Tahoma", Font.PLAIN, 12));
			labelValor5.setBounds(69, 43, 38, 20);
			painelMedia_1.add(labelValor5);

			textValorCinco = new JTextField();
			textValorCinco.setHorizontalAlignment(SwingConstants.CENTER);
			textValorCinco.setText("5");
			textValorCinco.setColumns(10);
			textValorCinco.setBounds(69, 63, 38, 20);
			painelMedia_1.add(textValorCinco);

			JLabel labelValor6 = new JLabel("Valor 6");
			labelValor6.setFont(new Font("Tahoma", Font.PLAIN, 12));
			labelValor6.setBounds(128, 43, 38, 20);
			painelMedia_1.add(labelValor6);

			textValorSeis = new JTextField();
			textValorSeis.setHorizontalAlignment(SwingConstants.CENTER);
			textValorSeis.setText("6");
			textValorSeis.setColumns(10);
			textValorSeis.setBounds(128, 63, 38, 20);
			painelMedia_1.add(textValorSeis);

			JLabel labelMedia2 = new JLabel("Media 2:");
			labelMedia2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			labelMedia2.setBounds(10, 11, 83, 21);
			painelMedia_1.add(labelMedia2);

			JLabel labelMedia_1 = new JLabel("Media");
			labelMedia_1.setBounds(69, 89, 38, 20);
			painelMedia_1.add(labelMedia_1);
			labelMedia_1.setHorizontalAlignment(SwingConstants.CENTER);
			labelMedia_1.setFont(new Font("Tahoma", Font.PLAIN, 12));

			textValorMediaDois = new JTextField();
			textValorMediaDois.setHorizontalAlignment(SwingConstants.CENTER);
			textValorMediaDois.setBounds(69, 109, 38, 20);
			painelMedia_1.add(textValorMediaDois);
			textValorMediaDois.setEditable(false);
			textValorMediaDois.setColumns(10);

			JSeparator separator_1_1_1_4 = new JSeparator();
			separator_1_1_1_4.setOrientation(SwingConstants.VERTICAL);
			separator_1_1_1_4.setForeground(Color.DARK_GRAY);
			separator_1_1_1_4.setBackground(Color.DARK_GRAY);
			separator_1_1_1_4.setBounds(97, 611, 2, 22);
			MainProvinha.add(separator_1_1_1_4);

			JSeparator separator_1_1_1_2 = new JSeparator();
			separator_1_1_1_2.setOrientation(SwingConstants.VERTICAL);
			separator_1_1_1_2.setForeground(Color.DARK_GRAY);
			separator_1_1_1_2.setBackground(Color.DARK_GRAY);
			separator_1_1_1_2.setBounds(286, 611, 2, 32);
			MainProvinha.add(separator_1_1_1_2);

			JSeparator separator_1_1_2_1_1 = new JSeparator();
			separator_1_1_2_1_1.setForeground(Color.DARK_GRAY);
			separator_1_1_2_1_1.setBackground(Color.DARK_GRAY);
			separator_1_1_2_1_1.setBounds(212, 600, 74, 2);
			MainProvinha.add(separator_1_1_2_1_1);

			JSeparator separator_1_1_2_1_1_1 = new JSeparator();
			separator_1_1_2_1_1_1.setForeground(Color.DARK_GRAY);
			separator_1_1_2_1_1_1.setBackground(Color.DARK_GRAY);
			separator_1_1_2_1_1_1.setBounds(213, 641, 73, 2);
			MainProvinha.add(separator_1_1_2_1_1_1);

			JSeparator separator_1_1_1_3 = new JSeparator();
			separator_1_1_1_3.setOrientation(SwingConstants.VERTICAL);
			separator_1_1_1_3.setForeground(Color.DARK_GRAY);
			separator_1_1_1_3.setBackground(Color.DARK_GRAY);
			separator_1_1_1_3.setBounds(97, 600, 2, 22);
			MainProvinha.add(separator_1_1_1_3);

			JSeparator separator_1_1_1_1 = new JSeparator();
			separator_1_1_1_1.setOrientation(SwingConstants.VERTICAL);
			separator_1_1_1_1.setForeground(Color.DARK_GRAY);
			separator_1_1_1_1.setBackground(Color.DARK_GRAY);
			separator_1_1_1_1.setBounds(286, 600, 2, 22);
			MainProvinha.add(separator_1_1_1_1);

			textMediaDaMedia = new JTextField();
			textMediaDaMedia.setHorizontalAlignment(SwingConstants.CENTER);
			textMediaDaMedia.setEditable(false);
			textMediaDaMedia.setColumns(10);
			textMediaDaMedia.setBounds(175, 632, 38, 20);
			MainProvinha.add(textMediaDaMedia);

			JSeparator separator_1_1_1 = new JSeparator();
			separator_1_1_1.setOrientation(SwingConstants.VERTICAL);
			separator_1_1_1.setForeground(Color.DARK_GRAY);
			separator_1_1_1.setBackground(Color.DARK_GRAY);
			separator_1_1_1.setBounds(286, 558, 2, 22);
			MainProvinha.add(separator_1_1_1);

			JSeparator separator_1_1_2 = new JSeparator();
			separator_1_1_2.setForeground(Color.DARK_GRAY);
			separator_1_1_2.setBackground(Color.DARK_GRAY);
			separator_1_1_2.setBounds(97, 578, 191, 2);
			MainProvinha.add(separator_1_1_2);

			textSomaMedia = new JTextField();
			textSomaMedia.setHorizontalAlignment(SwingConstants.CENTER);
			textSomaMedia.setEditable(false);
			textSomaMedia.setColumns(10);
			textSomaMedia.setBounds(175, 589, 38, 20);
			MainProvinha.add(textSomaMedia);

			JSeparator separator_1_1_1_2_1 = new JSeparator();
			separator_1_1_1_2_1.setOrientation(SwingConstants.VERTICAL);
			separator_1_1_1_2_1.setForeground(Color.DARK_GRAY);
			separator_1_1_1_2_1.setBackground(Color.DARK_GRAY);
			separator_1_1_1_2_1.setBounds(97, 620, 2, 22);
			MainProvinha.add(separator_1_1_1_2_1);

			JSeparator separator_1_1_2_1 = new JSeparator();
			separator_1_1_2_1.setForeground(Color.DARK_GRAY);
			separator_1_1_2_1.setBackground(Color.DARK_GRAY);
			separator_1_1_2_1.setBounds(97, 600, 81, 2);
			MainProvinha.add(separator_1_1_2_1);

			JSeparator separator_1_1_2_1_1_1_1 = new JSeparator();
			separator_1_1_2_1_1_1_1.setForeground(Color.DARK_GRAY);
			separator_1_1_2_1_1_1_1.setBackground(Color.DARK_GRAY);
			separator_1_1_2_1_1_1_1.setBounds(97, 641, 81, 2);
			MainProvinha.add(separator_1_1_2_1_1_1_1);

			JLabel labelSomaMedia = new JLabel("Soma das médias:");
			labelSomaMedia.setHorizontalAlignment(SwingConstants.CENTER);
			labelSomaMedia.setBounds(109, 562, 167, 14);
			MainProvinha.add(labelSomaMedia);

			JLabel labelMediaDaMedia = new JLabel("Média das médias:");
			labelMediaDaMedia.setHorizontalAlignment(SwingConstants.CENTER);
			labelMediaDaMedia.setBounds(109, 613, 167, 14);
			MainProvinha.add(labelMediaDaMedia);

			JSeparator separator_1_1_3 = new JSeparator();
			separator_1_1_3.setOrientation(SwingConstants.VERTICAL);
			separator_1_1_3.setForeground(Color.DARK_GRAY);
			separator_1_1_3.setBackground(Color.DARK_GRAY);
			separator_1_1_3.setBounds(193, 578, 2, 11);
			MainProvinha.add(separator_1_1_3);

			JSeparator separator_1_1 = new JSeparator();
			separator_1_1.setOrientation(SwingConstants.VERTICAL);
			separator_1_1.setForeground(Color.DARK_GRAY);
			separator_1_1.setBackground(Color.DARK_GRAY);
			separator_1_1.setBounds(97, 558, 2, 22);
			MainProvinha.add(separator_1_1);

			btnCalculaMedia = new JButton("Calcular Médias");
			btnCalculaMedia.setBounds(10, 393, 365, 22);
			MainProvinha.add(btnCalculaMedia);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
