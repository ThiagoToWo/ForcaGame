package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Visual {	

	//Constr�i e inicializa o frame.
	JFrame frame = new JFrame("Jogo da Forca");
	//Constr�i e inicializa o campo de texto p/ letras.
	JTextField letra = new JTextField(2);
	JTextField letraDaPalavra = new JTextField(2);	
	//Constr�i e inicializa o arraylist para os campos de texto da palavra.
	ArrayList<JTextField> arrayDeEntradas = new ArrayList<JTextField>();	
	//Constr�i e inicializa a �rea de mensagens e inclui a mensagem inicial.
	JTextArea areaDeMensagens = new JTextArea("Vamos ver como vai se sair... \n",10,40);	
	//Constr�i e inicializa a matrizes com as imagens e imageIcon.
	String[] nomeDeImagens = {"forca0.jpg", "forca1.jpg", "forca2.jpg", "forca3.jpg", "forca4.jpg", 
			                  "forca5.jpg", "forca6.jpg"};	
	ImageIcon[] listaDeImagens = { new ImageIcon(getClass().getResource(nomeDeImagens[0])),
			                       new ImageIcon(getClass().getResource(nomeDeImagens[1])),
			                       new ImageIcon(getClass().getResource(nomeDeImagens[2])),
			                       new ImageIcon(getClass().getResource(nomeDeImagens[3])),
			                       new ImageIcon(getClass().getResource(nomeDeImagens[4])),
			                       new ImageIcon(getClass().getResource(nomeDeImagens[5])),
			                       new ImageIcon(getClass().getResource(nomeDeImagens[6]))};
	int posi��oDaLetraNaPalavra;
	int erros = 0;
	//Constr�i e inicializa o fundo label para as imagens.
	JLabel localDasImagens = new JLabel(listaDeImagens[0]);	
	//Conjuntos de palavras e frases do jogo.		
	String[] palavras = {"tem na cidade/carro", "esporte/bola", "tem na cidade/rua","matem�tica/matriz", "f�sica/singularidade",
			             "tem na cidade/restaurante","animal/borboleta","banheiro/esponja", "cor/azul", "f�sica/eletricidade",
			             "tem na cidade/concreto", "esporte/cesta", "tempo/nublado", "tempo/domingo", "escola/livros",
			             "escola/biblioteca", "escola/recreio", "m�sica/samba", "sentimento/alegre", "Geografia/mapa", 
			             "animal/aranha", "animal/barata", "animal/cachorro", "animal/ornintorrinco","animal/flamingo", 
			             "animal/besouro", "animal/paca", "animal/jabuti", "animal/salamandra", "matem�tica/conjuntos", 
			             "animal/mara", "animal/dugongo", "animal/babirusa", "animal/fossa", "animal/molusco", "f�sica/luz", 
			             "cor/amarelo", "cor/vermelho", "cor/alaranjado", "cor/magenta","cor/preto", "cor/verde", 
			             "cor/anil", "cor/violeta", "cor/branco", "escola/aluno", "cor/falu", "matem�tica/sistema",
			             "cor/gingerline", "cor/incarnadine", "escola/aumoxarifado", "tempo/chuvendo", "tempo/temmpestade",
			             "tempo/neve", "tempo/chuvisco", "tempo/ensolarado", "matem�tica/soma", "matem�tica/dividir",
			             "matem�tica/multiplicar", "matem�tica/derivada", "matem�tica/trigonometria", "matem�tica/arranjo",
			             "matem�tica/fibonacci", "f�sica/movimento", "f�sica/calorimetria", "f�sica/vetores", "f�sica/incerteza",
			             "m�sica/punck", "m�sica/pagode", "m�sica/saxofone", "m�sica/bombardino", "m�sica/samba",
			             "personagens de contos/fada", "personagens de contos/bruxa", "personagens de contos/feiticeira",
			             "personagens de contos/princesa", "personagens de contos/rainha", "personagens de contos/elfo",
			             "vestu�rio/camisa", "vestu�rio/camiseta", "vestu�rio/vestido", "vestu�rio/saia", "vestu�rio/bermuda",
			             "vestu�rio/terno", "vestu�rio/cueca", "vestu�rio/jardineira", "cor/branco", "comida/leite", 
			             "comida/biscoito", "comida/cenoura", "comida/carne", "comida/verdura", "comida/arroz",
			             "comida/sorvete", "comida/strogonoff", "comida/ensopado", "comida/hamburger", "animal/arara",
			             "animal/andorinha", "animal/gaivota", "animal/pardal", "pa�s/dinamarca", "pa�s/djibouti",
			             "pa�s/uganda", "pa�s/brasil", "pa�s/alemanha", "pa�s/china", "pa�s/portugal", "pa�s/argentina",
			             "pa�s/uruguai", "pa�s/holanda", "fruta/abacate", "fruta/abacaxi", "fruta/acerola", "fruta/banana",
			             "fruta/caju", "fruta/cereja", "fruta/figo", "fruta/framboesa", "fruta/goiaba", "fruta/kiwi", 
			             "fruta/laranja", "fruta/tangerina", "fruta/abil", "fruta/araticum", "esporte/futebol",
			             "nome de pessoa/juliano", "nome de pessoa/amanda", "nome de pessoa/sara", "nome de pessoa/ana",
			             "nome de pessoa/soares", "nome de pessoa/tiago", "nome de pessoa/alessandro", 
			             "nome de pessoa/roger", "nome de pessoa/adriano", "nome de pessoa/adriana", "nome de pessoa/julia",
			             "nome de pessoa/ester", "nome de pessoa/rute", "nome de pessoa/olavo", "nome de pessoa/silvano",
			             "nome de pessoa/roberta", "tempo/inverno", "tempo/outono", "profiss�o/lavrador", "profiss�o/professor",
			             "profiss�o/programador", "profiss�o/esteticista", "profiss�o/eletricista", "profiss�o/encanador",
			             "profiss�o/taxista", "profiss�o/metrologista", "profiss�o/policial", "profiss�o/bombeiro",
			             "profiss�o/pintor", "medicina/geriatria", "medicina/psiquiatria", "medicina/cardiologista",
			             "medicina/endocrilologista", "medicina/neurologia", "medicina/geriatra", "medicina/cirurgia",
			             "esporte/boxe", "esporte/esgrima", "esporte/basquetebol", "esporte/corrida", 
			             "esporte/taekwondo", "esporte/pista", "escola/zelador", "escola/professor","pa�s/paraguai",
			             "pa�s/peru", "pa�s/congo", "pa�s/noruega", "pa�s/espanha", "matem�tica/probabilidade",
			             "matem�tica/bernoulli", "matem�tica/radical", "matem�tica/expoente", "matem�tica/logaritmando",
			             "matem�tica/base", "matem�tica/geometria", "matem�tica/elipse", "matem�tica/dividendo",
			             "matem�tica/paralelogramo", "matem�tica/icosaedro", "bebida/cerveja", "bebida/vinho",
			             "bebida/suco", "bebida/leite", "bebida/sangria", "bebida/champanhe", "bebida/conhaque",
			             "bebida/shake", "doce/cocada", "doce/brigadeiro", "doce/beijinho", "doce/pudim",
			             "doce/bananada", "doce/suspiro", "doce/sonho" };
	String palavra;	
	String palavraDica;
	String palavraPerguntada;
	JTextField palavraChute;
	String palavraNova;
	String[] mensagensDeAcerto = {"Acertou.", "Vamos para a pr�xima?", "Muito bem!", "�timo!", "Muito bem. Voc� acertou."};
	String[] mensagensDeErro = {"... Errou.", "... Tente acertar na pr�xima.", "... N�o foi dessa vez.", 
			                    "... tente outra.", "... Tente de novo."};	
	//Constr�i o frame.
	public void construirGui() {	
		// Constr�i a barra de menu e adiciona seus itens.
		JMenuBar barraDeMenu = new JMenuBar();
		JMenu menuNovoJogo = new JMenu("Novo jogo");
		JMenuItem itemNovoJogo = new JMenuItem("Nova palavra");
		itemNovoJogo.addActionListener(new NovoJogoListener());
		JMenu menuSobre = new JMenu("Sobre");
		JMenuItem itemAutor = new JMenuItem("Autor");
		itemAutor.addActionListener(new InfoAutorListener());
		JMenuItem itemVers�o = new JMenuItem("Vers�o");
		itemVers�o.addActionListener(new InfoVers�oListener());
		menuNovoJogo.add(itemNovoJogo);
		menuSobre.add(itemAutor);
		menuSobre.add(itemVers�o);
		barraDeMenu.add(menuNovoJogo);
		barraDeMenu.add(menuSobre);
		frame.setJMenuBar(barraDeMenu);
		
		/* O painel sul � onde se encontra a entrada do jogador para o palpite das letras.
		 * Criamos e configuramos este painel.
		 */
		JPanel painelSul = new JPanel();
		Font fonteMelhor = new Font("verdana", Font.ROMAN_BASELINE, 16);
		JLabel rotuloLetra = new JLabel("Escolha uma letra.");
		rotuloLetra.setFont(fonteMelhor);
		JButton bot�oDeConfirmar = new JButton("Confirmar");
		bot�oDeConfirmar.addActionListener(new AnalizarListener());
		letra.setFont(fonteMelhor);
		letra.addActionListener(new AnalizarListener());
		JLabel rotuloDoChute = new JLabel("   Chutar a palavra.");
		rotuloDoChute.setFont(fonteMelhor);	
		palavraChute = new JTextField(20);
		palavraChute.setFont(fonteMelhor);
		palavraChute.addActionListener(new AnalizarChuteListener());
		JButton botaoDoChute = new JButton("Confirmar");
		botaoDoChute.addActionListener(new AnalizarChuteListener());		
		painelSul.setBackground(Color.green);
		painelSul.add(rotuloLetra);
		painelSul.add(letra);		
		painelSul.add(bot�oDeConfirmar);
		painelSul.add(rotuloDoChute);
		painelSul.add(palavraChute);		
		painelSul.add(botaoDoChute);
		frame.getContentPane().add(BorderLayout.SOUTH, painelSul);		
		
		// Encaixa a imagem inicial no frame.		
		frame.getContentPane().add(BorderLayout.CENTER, localDasImagens);
		
		// Cria e configura o painel das mensagens para o jogador.
		JPanel painelDasMensagens = new JPanel();		
		painelDasMensagens.setLayout(new BoxLayout(painelDasMensagens, BoxLayout.Y_AXIS));		
		areaDeMensagens.setLineWrap(true);
		areaDeMensagens.setFont(fonteMelhor);
		areaDeMensagens.setEditable(false);
		JScrollPane barraDeRolagem = new JScrollPane(areaDeMensagens);
		barraDeRolagem.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		barraDeRolagem.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		painelDasMensagens.add(barraDeRolagem);
		frame.getContentPane().add(BorderLayout.EAST, painelDasMensagens);		
		
		/*Neste painel ficar� as palavras sorteadas para serem descobertas.
		 * A quantidade de campos de texto est� de acordo com a quantidade 
		 * de letras da palavra sorteada.
		 */		
		JPanel painelDaPalavra = new JPanel();		
		JLabel rotuloPalavra = new JLabel("Descubra a palavra");
		painelDaPalavra.setBackground(Color.cyan);
		rotuloPalavra.setFont(fonteMelhor);
		painelDaPalavra.add(rotuloPalavra);		
		escolherPalavraEDica();		
		for (int i = 0; i < palavraPerguntada.length(); i++) {
			JTextField letraDaPalavra = new JTextField(2);
			letraDaPalavra.setFont(fonteMelhor);			
			painelDaPalavra.add(letraDaPalavra);			
			arrayDeEntradas.add(letraDaPalavra);			
		}
		JLabel rotuloDeDica = new JLabel("         Dica: ");
		rotuloDeDica.setFont(fonteMelhor);
		painelDaPalavra.add(rotuloDeDica);
		JLabel dica = new JLabel(palavraDica);
		dica.setFont(fonteMelhor);		
		painelDaPalavra.add(dica);
		
		frame.getContentPane().add(BorderLayout.NORTH, painelDaPalavra);		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.pack();
		frame.setLocation(300, 100);
		letra.requestFocus();
		frame.setVisible(true);		
	}	
	//M�todos �teis na l�gica do jogo.	
	public void escolherPalavraEDica() {		
		int random = (int) (Math.random() * palavras.length);			
		palavra = palavras[random];	
		String[] resultado = palavra.split("/");
		palavraDica = resultado[0];
		palavraPerguntada = resultado[1];		
	}	
	
	public String escolherMensagemDeAcerto() {
		int random = (int) (Math.random() * mensagensDeAcerto.length);			
		String mensagemDeAcerto = mensagensDeAcerto[random];	
		return mensagemDeAcerto;
	}
	
	public String escolherMensagemDeErro() {
		int random = (int) (Math.random() * mensagensDeErro.length);			
		String ofensa = mensagensDeErro[random];	
		return ofensa;
	}	
	
	private void escreverLetraDaPalavra(int posi��oDaLetraNaPalavra, String palavraPerguntada, ArrayList<JTextField> arrayDeEntradas) {	
		/* Acha a primeira posi��o da letra e a inclui na palavra.
		 * A partir dela a palavra � varrida e a letra inclu�da em todos os locais
		 * onde existe ela. 
		 */		
		arrayDeEntradas.get(posi��oDaLetraNaPalavra).setText(letra.getText().toUpperCase());		
		for (int i = 1; i < palavraPerguntada.length() - 1; i++) {		 
			posi��oDaLetraNaPalavra = palavraPerguntada.indexOf(letra.getText(), i);
			if (posi��oDaLetraNaPalavra == -1) {
				break;
			} else {
				arrayDeEntradas.get(posi��oDaLetraNaPalavra).setText(letra.getText().toUpperCase());				
			}						
		}
					
	}	
	
	public void administrarErros() {
		/* � feita uma contagem de erros e crescentado uma parte do corpo � imagem.
		 * Se houverem 6 erros, o jogo termina com uma mensagem.
		 */
		erros++;
		localDasImagens.setIcon(listaDeImagens[erros]);						
		if (erros == 6) {
			areaDeMensagens.append("\n Voc� perdeu! \n A palavra era '" + palavraPerguntada.toUpperCase() + "'.");					
			letra.setText("");
			letra.setEnabled(false);					
		}
	}
	
	// M�todo ainda n�o utilizado.
	public void avisarQueRepetiuLetra() {
		for (JTextField campo : arrayDeEntradas) {
			if (campo.getText().equals(letra.getText())) {
				areaDeMensagens.append("... Mas voc� j� falou");
			}						
		}
	}
	
	//Classes internas com os comandos dos bot�es e itens da barra de menu.
	public class AnalizarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Identifica a primeira ocorr�ncia da letra na palavra.
			posi��oDaLetraNaPalavra = palavraPerguntada.indexOf(letra.getText());	
			//Se tiver a letra, ercrave ela em todas as posi��es em que ele ocorre e manda uma mensagem de acerto.
			if (letra.getText().isBlank()) {
				areaDeMensagens.setText(areaDeMensagens.getText() + "\n" + 
			                            "Voc� tentou confirmar uma letra sem digitar nenhuma. \n");
			} else {
				if (posi��oDaLetraNaPalavra != -1) {				
					escreverLetraDaPalavra(posi��oDaLetraNaPalavra, palavraPerguntada, arrayDeEntradas);
					letra.setText("");
					letra.requestFocus();
					areaDeMensagens.append("\n" + escolherMensagemDeAcerto() + "\n");
				//Caso contr�rio, manda uma mensagem de e administra o erro.	
				} else {
					areaDeMensagens.setText( areaDeMensagens.getText() + "\n" + "N�o temos a letra " + 
				                            letra.getText().toUpperCase() + escolherMensagemDeErro() + "\n");
					letra.setText("");
					letra.requestFocus();
					administrarErros();
				}
			
			}			
						
		}		

	}
	
	public class AnalizarChuteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (palavraChute.getText().equals(palavraPerguntada)) {
				for (int i = 0; i < palavraPerguntada.length(); i++) {					
					arrayDeEntradas.get(i).setText(palavraPerguntada.substring(i, i + 1).toUpperCase());					
				}
				areaDeMensagens.setText( areaDeMensagens.getText() + "\n Parab�ns! Voc� acertou a palavra.");
			} else {
				if (palavraChute.getText().isBlank()) {
					areaDeMensagens.setText( areaDeMensagens.getText() + "\n" + 
				                            "Voc� tentou confirmar um chute sem digitar nenhuma palavra. \n");
				}else {
					localDasImagens.setIcon(listaDeImagens[6]);
					areaDeMensagens.append("\n Voc� perdeu! \n A palavra era '" + palavraPerguntada.toUpperCase() + "'.");					
					letra.setText("");
					letra.setEnabled(false);
				}
				
			}

		}

	}
	
	public class NovoJogoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			new Visual().construirGui();
			frame.dispose();
		}
			
	}
	
	public class InfoVers�oListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Vers�o: 1.1 - 07/06/2020 \n Mudan�as: - inserir letra e chute com Enter."
					+ " \n - centraliza��o na tela.", "Vers�o",JOptionPane.INFORMATION_MESSAGE);
		}

	}

	public class InfoAutorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Thiago de Oliveira Alves \n towo497@gmail.com", "Autor",
                    JOptionPane.INFORMATION_MESSAGE);			

		}

	}

}
