
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class MyFrame extends JFrame implements ActionListener{
	
	static Random rn = new Random();
	static int puan = 0;
	int answer = rn.nextInt(8);
	int answer2= rn.nextInt(8);
	int answer3 = rn.nextInt(8);
	int answer4 = rn.nextInt(8);
	
	JLabel label1;
	static JLabel label2;
	static JLabel labela;
	static JLabel labelb;
	static JLabel labelc;
	static JLabel labeld;
	static JLabel labele;
	
	static JButton buton1;
	static JButton easy;
	static JButton middle;
	static JButton hard;
	static JButton part2;
	static JButton secenek;
	static JButton tekrar;
	
	static JTextField text1;
	static JTextField text2;
	
	MyFrame(){
		
		label1 = new JLabel();
		label1.setBounds(30, 45, 500, 200);
		label1.setText("WELCOME TO THE GAME");
		label1.setFont(new Font("New Times", Font.BOLD, 35));
		label1.setVisible(true);
		
		buton1 = new JButton();
		buton1.setBounds(150, 230, 180, 50);
		buton1.setText("START");
		buton1.setFont(new Font("New Times", Font.PLAIN, 35));
		buton1.addActionListener(this);
		buton1.setVisible(true);
		
		text1 = new JTextField();
		text1.setBounds(150, 185, 180, 30);
		text1.setVisible(true);
		
		easy = new JButton("Easy Questions");
		middle = new JButton("Moderate Questions");
		hard = new JButton("Difficult Questions");
		easy.setBounds(165, 100, 150, 50);
		easy.setVisible(false);
		middle.setBounds(165, 200, 150, 50);
		middle.setVisible(false);
		hard.setBounds(165, 300, 150, 50);
		hard.setVisible(false);
		easy.addActionListener(this);
		middle.addActionListener(this);
		hard.addActionListener(this);
		
		part2 = new JButton("Part 2");
		part2.setBounds(380, 10, 100, 40);
		part2.setVisible(false);
		
		label2 = new JLabel(easyones[answer].questiontext);
		label2.setFont(new Font("New Times1", Font.BOLD,15));
		label2.setBounds(30, 50, 470, 50);
		label2.setVisible(false);
		
		labela = new JLabel("A." + easyones[answer].optiona);
		labela.setFont(new Font("New Times1", Font.BOLD,15));
		labela.setBounds(30, 100, 470, 50);
		labela.setVisible(false);
		
		labelb = new JLabel("B."+ easyones[answer].optionb);
		labelb.setFont(new Font("New Times1", Font.BOLD,15));
		labelb.setBounds(30, 150, 470, 50);
		labelb.setVisible(false);
		
		labelc = new JLabel("C."+ easyones[answer].optionc);
		labelc.setFont(new Font("New Times1", Font.BOLD,15));
		labelc.setBounds(30, 200, 470, 50);
		labelc.setVisible(false);
		
		labeld = new JLabel("D."+ easyones[answer].optiond);
		labeld.setFont(new Font("New Times1", Font.BOLD,15));
		labeld.setBounds(30, 250, 470, 50);
		labeld.setVisible(false);
		
		text2 = new JTextField();
		text2.setBounds(30, 300, 100, 30);
		text2.setVisible(false);
		
		secenek = new JButton();
		secenek.setBounds(150, 300, 150, 30);
		secenek.setText("CONTROL");
		secenek.setFont(new Font("New Times", Font.PLAIN, 15));
		secenek.addActionListener(this);
		secenek.setVisible(false);
		
		tekrar = new JButton();
		tekrar.setBounds(30, 350, 250, 30);
		tekrar.setText("Another Question");
		tekrar.setFont(new Font("New Times",Font.PLAIN,15));
		tekrar.addActionListener(this);
		tekrar.setVisible(false);
		
		labele = new JLabel("Your points " + puan);
		labele.setFont(new Font("New Times", Font.BOLD, 15));
		labele.setBounds(30, 0, 470, 50);
		labele.setVisible(false);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500,500);
		this.setVisible(true);
		
		this.add(tekrar);
		this.add(secenek);
		this.add(text2);
		this.add(labela);
		this.add(labelb);
		this.add(labelc);
		this.add(labeld);
		this.add(label2);
		this.add(text1);
		this.add(label1);
		this.add(buton1);
		this.add(easy);
		this.add(middle);
		this.add(hard);
		this.add(part2);
		this.add(labele);
		
	}

	
	boolean easydone = false;
	boolean middledone = false;
	boolean harddone = false;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == buton1) {
			 text1.getText();
		        label1.setVisible(false);
		        buton1.setVisible(false);
		        text1.setVisible(false);

		        easy.setVisible(true);
		        middle.setVisible(true);
		        hard.setVisible(true);
		 }
		 if(e.getSource()== easy) {
			 	label2.setVisible(true);
			 	labela.setVisible(true);
			 	labelb.setVisible(true);
			 	labelc.setVisible(true);
			 	labeld.setVisible(true);
			 	part2.setVisible(true);
			 	text2.setVisible(true);
			 	secenek.setVisible(true);
			 	tekrar.setVisible(true);
			 	labele.setVisible(true);
			 	
			 	easy.setVisible(false);
			 	middle.setVisible(false);
			 	hard.setVisible(false);
			 	
			 	easydone = true;
		 }
		 else if(e.getSource()== secenek && easydone == true) {
			 		if(text2.getText().equalsIgnoreCase(easyones[answer].getAnswer())) {
			 			puan += 10;
			 		}
			 	
	     }
		 else if(e.getSource()== tekrar && easydone == true) {
			 		answer2 = rn.nextInt(8);
			 		label2.setText(easyones[answer2].questiontext);
			 		labela.setText("A." + easyones[answer2].optiona);
			 		labelb.setText("B."+ easyones[answer2].optionb);
			 		labelc.setText("C."+ easyones[answer2].optionc);
			 		labeld.setText("D."+ easyones[answer2].optiond);
		 }
		 else if(e.getSource()== middle) {
			    label2.setText(middleones[answer].questiontext);
			    labela.setText("A." + middleones[answer].optiona);
			    labelb.setText("B."+ middleones[answer].optionb);
			    labelc.setText("C."+ middleones[answer].optionc);
			    labeld.setText("D."+ middleones[answer].optiond);
			    
			 	part2.setVisible(true);
			 	label2.setVisible(true);
			 	labela.setVisible(true);
			 	labelb.setVisible(true);
			 	labelc.setVisible(true);
			 	labeld.setVisible(true);
			 	text2.setVisible(true);
			 	secenek.setVisible(true);
			 	tekrar.setVisible(true);
			 	labele.setVisible(true);
			 	
			 	easy.setVisible(false);
			 	middle.setVisible(false);
			 	hard.setVisible(false);
			 	
			 	middledone = true;
		 }
		 else if(e.getSource()== secenek && middledone == true) {
		 		if(text2.getText().equalsIgnoreCase(middleones[answer].getAnswer())) {
		 			puan += 30;}
		 }
		 else if(e.getSource()== tekrar && middledone == true) {
			 		answer3 = rn.nextInt(8);
			 		label2.setText(middleones[answer3].questiontext);
			 		labela.setText("A." + middleones[answer3].optiona);
			 		labelb.setText("B."+ middleones[answer3].optionb);
			 		labelc.setText("C."+ middleones[answer3].optionc);
			 		labeld.setText("D."+ middleones[answer3].optiond);
		 }
		 else if(e.getSource()== hard) {
			    label2.setText(hardones[answer4].questiontext);
			    labela.setText("A." + hardones[answer4].optiona);
			    labelb.setText("B."+ hardones[answer4].optionb);
			    labelc.setText("C."+ hardones[answer4].optionc);
			    labeld.setText("D."+ hardones[answer4].optiond);
			    
				part2.setVisible(true);
				label2.setVisible(true);
			 	labela.setVisible(true);
			 	labelb.setVisible(true);
			 	labelc.setVisible(true);
			 	labeld.setVisible(true);
			 	part2.setVisible(true);
			 	text2.setVisible(true);
			 	secenek.setVisible(true);
			 	tekrar.setVisible(true);
			 	labele.setVisible(true);
				
				easy.setVisible(false);
				middle.setVisible(false);
				hard.setVisible(false);
				
				harddone = true;
		 }
		 else if(e.getSource()== secenek && harddone == true) {
		 		if(text2.getText().equalsIgnoreCase(hardones[answer].getAnswer())) {
		 			puan += 10;}
		 }
		 else if(e.getSource()== tekrar && harddone == true) {
			 		answer4 = rn.nextInt(8);
			 		label2.setText(hardones[answer4].questiontext);
			 		labela.setText("A." + hardones[answer4].optiona);
			 		labelb.setText("B."+ hardones[answer4].optionb);
			 		labelc.setText("C."+ hardones[answer4].optionc);
			 		labeld.setText("D."+ hardones[answer4].optiond);
		 }
		 else if(e.getSource()== part2) {
			 
		 }

	}
	
	
	static Questions1 q1 = new Questions1(1,"Easy", "What is the capital city of the Turkey?", "İstanbul", "Ankara", "İzmir", "Bursa", "b" );
	static Questions1 q2 = new Questions1(2,"Easy", "Which river runs through the city of Istanbul?", "Tigria", "Euphrates", "Nile", "Bosphorus", "d" );
	static Questions1 q3 = new Questions1(3,"Easy", "In Turkish culture what is the \"\"kahvaltı\"\" ?", "Dinner", "Lunch", "Breakfast", "Snack", "c" );
	static Questions1 q4 = new Questions1(4,"Easy", "How many cities are there in Turkey?", "90", "80", "62", "81", "d" );
	static Questions1 q5 = new Questions1(5,"Easy", "Which famous Turkish dish consists of stuffed grape leaves?", "Dolma", "Kısır", "Mantı", "Humus", "a" );
	static Questions1 q6 = new Questions1(6,"Easy", "What is the biggest city of the Turkey?", "Ordu", "Antalya", "İzmir", "İstanbul", "d" );
	static Questions1 q7 = new Questions1(7,"Easy", "How many faculties in Ted University?", "6", "4", "5", "7", "c" );
	static Questions1 q8 = new Questions1(8,"Easy", "Where is the Ted University?", "Osmaniye", "Ankara", "Sinop", "Diyarbakır", "b" );
	
	static Questions1 qm1 = new Questions1(1,"Moderete", "In which historical city is located in the Cappadocia region?", "Ephesus", "Hierapolis", "Göbeklitepe", "Nevşehir","d");
	static Questions1 qm2 = new Questions1(2, "Moderete", " In Turkish cuisine, which dish is a soup made with red lentils?", "Iskender", "Ezogelin","Mantı","Kısır","b");
	static Questions1 qm3 = new Questions1(3,"Moderete","Which city is known as the capital of the Ottoman Empire","Istanbul","Ankara","Bursa","Edirne","a");
	static Questions1 qm4 = new Questions1(4,"Moderete","What is the other name for Mount Ararat, the highest mountain in Turkey", "Cilo mountain","Süphan mountain", "Erciyes mountain","Uludağ", "c");
	static Questions1 qm5 = new Questions1(5,"Moderete","What is the famous work of Osman Hamdi Bey, one of the pioneers of Turkish painting?", "Storks","Village Institutes","The Tortise Trainer", "Mevlit","c");
	static Questions1 qm6 = new Questions1(6,"Modereet","What is the nickname of Neşet Ertaş, a famous artist in Turkish folk music","The Reed of the Steppe", "Bean","Çiçek Abbas","Mount Ağrı","a");
	static Questions1 qm7 = new Questions1(7,"Moderete","What is the largest lake in Turkey", "Lake Van","Lake Beyşehir","Salt Lake", "Lake İznik", "a"); 
	static Questions1 qm8 = new Questions1(8,"Moderete","In which historical period did the Hittite Empire rule in Anatolia?","Ancient Greece","Roman Empire","Ottoman Empire","Iron Age","d");
	
	static Questions1 qh1 = new Questions1(1,"Hard","Which Turkish ruler first used the title \"Gazi\"?", "Alp Arslan", "Osman Gazi", "Ertuğrul Bey", "Fatih Sultan Mehmet","a");
	static Questions1 qh2 = new Questions1(2,"Hard","In Turkish mythology, who is known as the sky god?", "Gök Han","Tengri","Oğuz Kağan","Ulgen","b");
	static Questions1 qh3 = new Questions1(3,"Hard","Which Turkish author is the writer of the work \"Kürk Mantolu Madonna\"?","Yaşar Kemal","Halit Ziya Uşaklıgil","Ahmet Hamdi Tanpınar","Sabahattin Ali","c");
	static Questions1 qh4 = new Questions1(4,"Hard","What is the famous work of Turkish painter İbrahim Çallı?", "İkindi Üstü","Çıkrıkçılar Yokuşu", "Akıncılar","İstanbul Boğazı'nda Sabah", "b");
	static Questions1 qh5 = new Questions1(5,"Hard","In which province is Göbeklitepe, one of the oldest settlements in Turkey, located?","Urfa","Mardin","Şanlıurfa", "Gaziantep","c");
	static Questions1 qh6 = new Questions1(6,"Hard","In Turkey, which ancient city is located on the Lycian Way?"," Ephesus", "Perge"," Xanthos","Troy","c");
	static Questions1 qh7 = new Questions1(7,"Hard","The famous Turkish composer Ahmed Adnan Saygun composed works in which genre?", "Classical Music","Turkish Folk Music","Jazz","Pop", "a"); 
	static Questions1 qh8 = new Questions1(8,"Hard","Which Turkish statesman declared the \"National Pact\" to determine Turkey's borders?","İsmet İnönü","Mustafa Kemal Atatürk","Celal Bayar","Adnan Menderes","b");
	
	static Questions1[] easyones = {q1, q2, q3,q4,q5,q6,q7,q8};
	static Questions1[] middleones = {qm1, qm2, qm3, qm4, qm5, qm6, qm7, qm8};
	static Questions1[] hardones = {qh1,qh2,qh3,qh4,qh5,qh6,qh7,qh8};
	
	
	
	public int getPoints() {
		return puan;
	}
	
	
	
}
