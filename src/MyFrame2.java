import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class MyFrame2 extends JFrame implements ActionListener{
	static Random rn = new Random();
	int answer = rn.nextInt(8)+1;
	int answer2 = rn.nextInt(8)+1;
	int answer3 = rn.nextInt(8)+1;
	int answer4 = rn.nextInt(8)+1;
	int answer5 = rn.nextInt(8)+1;
	int answer6 = rn.nextInt(8)+1;
	int points = 0;
	
	boolean easydone = false;
	boolean middledone = false;
	boolean harddone = false;
	
	MyPanel panel;
	JLabel label1;
	JLabel label2;
	JLabel labele;
	JLabel me;
	JLabel he;
	
	JButton button1;
	JButton easy;
	JButton middle;
	JButton hard;
	JButton another;
	JButton part2;
	
	JRadioButton seceneka;
	JRadioButton secenekb;
	JRadioButton secenekc;
	JRadioButton secenekd;
	JRadioButton ma;
	JRadioButton mb;
	JRadioButton mc;
	JRadioButton md;
	JRadioButton ha;
	JRadioButton hb;
	JRadioButton hc;
	JRadioButton hd;
	
	MyFrame2(){
		panel = new MyPanel();
		label1 = new JLabel("WELCOME TO GENERAL TURKISH CULTURE TEST");
		label1.setBounds(10, 0, 650, 100);
		label1.setBackground(Color.white);
		label1.setFont(new Font("New Times", Font.PLAIN,25));
		
		label2 = new JLabel();
		label2.setText("Please choose a difficulty for your questions");
		label2.setForeground(Color.DARK_GRAY);
		label2.setFont(new Font("New Times", Font.BOLD,25));
		label2.setVisible(false);
		label2.setBounds(50, 0, 550, 150);
		
		button1 = new JButton("START");
		button1.setBounds(250, 90, 100, 40);
		button1.addActionListener(this);
		
		panel.setBounds(65, 150, 500, 500);
		this.add(panel);
		
		easy = new JButton("Easy Questions");
		middle = new JButton("Moderate Questions");
		hard = new JButton("Difficult Questions");
		easy.setBounds(220, 150, 150, 50);
		easy.setVisible(false);
		middle.setBounds(220, 250, 150, 50);
		middle.setVisible(false);
		hard.setBounds(220, 350, 150, 50);
		hard.setVisible(false);
		easy.addActionListener(this);
		middle.addActionListener(this);
		hard.addActionListener(this);
		
		labele = new JLabel();
		labele.setText(easyones[answer].questiontext);
		labele.setFont(new Font("New Times1", Font.BOLD,15));
		labele.setBounds(30, 50, 470, 50);
		labele.setVisible(false);
		
		seceneka = new JRadioButton();
		secenekb = new JRadioButton();
		secenekc = new JRadioButton();
		secenekd = new JRadioButton();
		seceneka.setText(easyones[answer].optiona);
		secenekb.setText(easyones[answer].optionb);
		secenekc.setText(easyones[answer].optionc);
		secenekd.setText(easyones[answer].optiond);
		seceneka.setBounds(30, 100, 470, 50);
		secenekb.setBounds(30, 150, 470, 50);
		secenekc.setBounds(30, 200, 470, 50);
		secenekd.setBounds(30, 250, 470, 50);
		ButtonGroup group = new ButtonGroup();
		group.add(seceneka);
		group.add(secenekb);
		group.add(secenekc);
		group.add(secenekd);
		seceneka.setVisible(false);
		secenekb.setVisible(false);
		secenekc.setVisible(false);
		secenekd.setVisible(false);
		seceneka.addActionListener(this);
		secenekb.addActionListener(this);
		secenekc.addActionListener(this);
		secenekd.addActionListener(this);
		
		another = new JButton("Another Question");
		another.setFont(new Font("New Times",Font.BOLD,15));
		another.setBounds(420,500, 170, 50);
		another.setVisible(false);
		another.addActionListener(this);
		
		me = new JLabel();
		me.setText(middleones[answer3].questiontext);
		me.setFont(new Font("New Times1", Font.BOLD,15));
		me.setBounds(30, 50, 470, 50);
		me.setVisible(false);
		
		ma = new JRadioButton();
		mb = new JRadioButton();
		mc = new JRadioButton();
		md = new JRadioButton();
		ma.setText(middleones[answer3].optiona);
		mb.setText(middleones[answer3].optionb);
		mc.setText(middleones[answer3].optionc);
		md.setText(middleones[answer3].optiond);
		ma.setBounds(30, 100, 470, 50);
		mb.setBounds(30, 150, 470, 50);
		mc.setBounds(30, 200, 470, 50);
		md.setBounds(30, 250, 470, 50);
		ButtonGroup group2 = new ButtonGroup();
		group2.add(ma);
		group2.add(mb);
		group2.add(mc);
		group2.add(md);
		ma.setVisible(false);
		mb.setVisible(false);
		mc.setVisible(false);
		md.setVisible(false);
		ma.addActionListener(this);
		mb.addActionListener(this);
		mc.addActionListener(this);
		md.addActionListener(this);
		
		he = new JLabel();
		he.setText(hardones[answer5].questiontext);
		he.setFont(new Font("New Times1", Font.BOLD,15));
		he.setBounds(30, 50, 570, 50);
		he.setVisible(false);
		
		ha = new JRadioButton();
		hb = new JRadioButton();
		hc = new JRadioButton();
		hd = new JRadioButton();
		ha.setText(hardones[answer5].optiona);
		hb.setText(hardones[answer5].optionb);
		hc.setText(hardones[answer5].optionc);
		hd.setText(hardones[answer5].optiond);
		ha.setBounds(30, 100, 470, 50);
		hb.setBounds(30, 150, 470, 50);
		hc.setBounds(30, 200, 470, 50);
		hd.setBounds(30, 250, 470, 50);
		ButtonGroup group3 = new ButtonGroup();
		group3.add(ha);
		group3.add(hb);
		group3.add(hc);
		group3.add(hd);
		ha.setVisible(false);
		hb.setVisible(false);
		hc.setVisible(false);
		hd.setVisible(false);
		ha.addActionListener(this);
		hb.addActionListener(this);
		hc.addActionListener(this);
		hd.addActionListener(this);
		
		part2 = new JButton();
		part2.setText("Part 2");
		part2.setBounds(510, 20, 80, 45);
		part2.setFont(new Font("New Times",Font.BOLD,15));
		part2.setVisible(false);
		part2.addActionListener(this);
		
		this.setBackground(Color.white);
		this.setLayout(null);
		this.add(label1);
		this.add(button1);
		this.add(label2);
		this.add(easy);
		this.add(middle);
		this.add(hard);
		this.add(labele);
		this.add(seceneka);
		this.add(secenekb);
		this.add(secenekc);
		this.add(secenekd);
		this.add(another);
		this.add(ma);
		this.add(mc);
		this.add(mb);
		this.add(md);
		this.add(me);
		this.add(ha);
		this.add(hc);
		this.add(hb);
		this.add(hd);
		this.add(he);
		this.add(part2);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(650,650);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1) {
			label1.setVisible(false);
			button1.setVisible(false);
			panel.setVisible(false);
			
			label2.setVisible(true);
			easy.setVisible(true);
			middle.setVisible(true);
			hard.setVisible(true);
		}else if(e.getSource() == easy) {
			label2.setVisible(false);
			easy.setVisible(false);
			middle.setVisible(false);
			hard.setVisible(false);
			
			part2.setVisible(true);
			another.setVisible(true);
			labele.setVisible(true);
			seceneka.setVisible(true);
			secenekb.setVisible(true);
			secenekc.setVisible(true);
			secenekd.setVisible(true);
			
			easydone = true;
		}else if(e.getSource()== seceneka){
			checkAnswer(seceneka);
        }else if (e.getSource() == secenekb) {
            checkAnswer(secenekb);
        }else if (e.getSource() == secenekc) {
            checkAnswer(secenekc);
        }else if (e.getSource() == secenekd) {
            checkAnswer(secenekd);
		}else if(e.getSource() == another && easydone == true) {
			answer2 = rn.nextInt(8) + 1;
	        labele.setText(easyones[answer2].questiontext);
	        seceneka.setText(easyones[answer2].optiona);
	        secenekb.setText(easyones[answer2].optionb);
	        secenekc.setText(easyones[answer2].optionc);
	        secenekd.setText(easyones[answer2].optiond);
		}else if(e.getSource() == middle) {
			label2.setVisible(false);
			easy.setVisible(false);
			middle.setVisible(false);
			hard.setVisible(false);
			labele.setVisible(false);
			seceneka.setVisible(false);
			secenekb.setVisible(false);
			secenekc.setVisible(false);
			secenekd.setVisible(false);
			
			part2.setVisible(true);
			another.setVisible(true);
			middledone = true;
			me.setVisible(true);
			ma.setVisible(true);
			mb.setVisible(true);
			mc.setVisible(true);
			md.setVisible(true);
		}else if(e.getSource()== ma){
			checkAnswer(ma);
        }else if (e.getSource() == mb) {
            checkAnswer2(mb);
        }else if (e.getSource() == mc) {
            checkAnswer2(mc);
        }else if (e.getSource() == md) {
            checkAnswer2(md);
		}else if(e.getSource() == another && middledone == true) {
			answer4 = rn.nextInt(8) + 1;
	        me.setText(middleones[answer4].questiontext);
	        ma.setText(middleones[answer4].optiona);
	        mb.setText(middleones[answer4].optionb);
	        mc.setText(middleones[answer4].optionc);
	        md.setText(middleones[answer4].optiond);
		}else if(e.getSource() == hard) {
			label2.setVisible(false);
			easy.setVisible(false);
			middle.setVisible(false);
			hard.setVisible(false);
			
			part2.setVisible(true);
			another.setVisible(true);
			harddone = true;
			he.setVisible(true);
			ha.setVisible(true);
			hb.setVisible(true);
			hc.setVisible(true);
			hd.setVisible(true);
		}else if(e.getSource()== ha){
			checkAnswer3(ha);
        }else if (e.getSource() == hb) {
            checkAnswer3(hb);
        }else if (e.getSource() == hc) {
            checkAnswer3(hc);
        }else if (e.getSource() == hd) {
            checkAnswer3(hd);
		}else if(e.getSource() == another && harddone == true) {
			answer6 = rn.nextInt(8) + 1;
	        he.setText(hardones[answer6].questiontext);
	        ha.setText(hardones[answer6].optiona);
	        hb.setText(hardones[answer6].optionb);
	        hc.setText(hardones[answer6].optionc);
	        hd.setText(hardones[answer6].optiond);
		}
	}
	static Questions1 q1 = new Questions1(1,"Easy", "What is the capital city of the Turkey?", "İstanbul", "Ankara", "İzmir", "Bursa", "Ankara" );
	static Questions1 q2 = new Questions1(2,"Easy", "Which river runs through the city of Istanbul?", "Tigria", "Euphrates", "Nile", "Bosphorus", "Bosphorus" );
	static Questions1 q3 = new Questions1(3,"Easy", "In Turkish culture what is the \"\"kahvaltı\"\" ?", "Dinner", "Lunch", "Breakfast", "Snack", "Breakfast" );
	static Questions1 q4 = new Questions1(4,"Easy", "How many cities are there in Turkey?", "90", "80", "62", "81", "81" );
	static Questions1 q5 = new Questions1(5,"Easy", "Which famous Turkish dish consists of stuffed grape leaves?", "Dolma", "Kısır", "Mantı", "Humus", "Dolma" );
	static Questions1 q6 = new Questions1(6,"Easy", "What is the biggest city of the Turkey?", "Ordu", "Antalya", "İzmir", "İstanbul", "İstanbul" );
	static Questions1 q7 = new Questions1(7,"Easy", "How many faculties in Ted University?", "6", "4", "5", "7", "5" );
	static Questions1 q8 = new Questions1(8,"Easy", "Where is the Ted University?", "Osmaniye", "Ankara", "Sinop", "Diyarbakır", "Ankara" );
	
	static Questions1 qm1 = new Questions1(1,"Moderete", "In which historical city is located in the Cappadocia region?", "Ephesus", "Hierapolis", "Göbeklitepe", "Nevşehir","Nevşehir");
	static Questions1 qm2 = new Questions1(2, "Moderete", " In Turkish cuisine, which dish is a soup made with red lentils?", "Iskender", "Ezogelin","Mantı","Kısır","Ezogelin");
	static Questions1 qm3 = new Questions1(3,"Moderete","Which city is known as the capital of the Ottoman Empire","Istanbul","Ankara","Bursa","Edirne","Istanbul");
	static Questions1 qm4 = new Questions1(4,"Moderete","What is the other name for Mount Ararat, the highest mountain in Turkey", "Cilo mountain","Süphan mountain", "Erciyes mountain","Uludağ", "Erciyes mountain");
	static Questions1 qm5 = new Questions1(5,"Moderete","What is the famous work of Osman Hamdi Bey, one of the pioneers of Turkish painting?", "Storks","Village Institutes","The Tortise Trainer", "Mevlit","The Tortise Trainer");
	static Questions1 qm6 = new Questions1(6,"Modereet","What is the nickname of Neşet Ertaş, a famous artist in Turkish folk music","The Reed of the Steppe", "Bean","Çiçek Abbas","Mount Ağrı","The Reed of the Steppe");
	static Questions1 qm7 = new Questions1(7,"Moderete","What is the largest lake in Turkey", "Lake Van","Lake Beyşehir","Salt Lake", "Lake İznik", "Lake Van"); 
	static Questions1 qm8 = new Questions1(8,"Moderete","In which historical period did the Hittite Empire rule in Anatolia?","Ancient Greece","Roman Empire","Ottoman Empire","Iron Age","Iron Age");
	
	static Questions1 qh1 = new Questions1(1,"Hard","Which Turkish ruler first used the title \"Gazi\"?", "Alp Arslan", "Osman Gazi", "Ertuğrul Bey", "Fatih Sultan Mehmet","Alp Arslan");
	static Questions1 qh2 = new Questions1(2,"Hard","In Turkish mythology, who is known as the sky god?", "Gök Han","Tengri","Oğuz Kağan","Ulgen","Tengri");
	static Questions1 qh3 = new Questions1(3,"Hard","Which Turkish author is the writer of the work \"Kürk Mantolu Madonna\"?","Yaşar Kemal","Halit Ziya Uşaklıgil","Ahmet Hamdi Tanpınar","Sabahattin Ali","Ahmet Hamdi Tanpınar");
	static Questions1 qh4 = new Questions1(4,"Hard","What is the famous work of Turkish painter İbrahim Çallı?", "İkindi Üstü","Çıkrıkçılar Yokuşu", "Akıncılar","İstanbul Boğazı'nda Sabah", "Çıkrıkçılar Yokuşu");
	static Questions1 qh5 = new Questions1(5,"Hard","In which province is Göbeklitepe, one of the oldest settlements in Turkey, located?","Ankara","Mardin","Şanlıurfa", "Gaziantep","Şanlıurfa");
	static Questions1 qh6 = new Questions1(6,"Hard","In Turkey, which ancient city is located on the Lycian Way?"," Ephesus", "Perge"," Xanthos","Troy","Xanthos");
	static Questions1 qh7 = new Questions1(7,"Hard","The famous Turkish composer Ahmed Adnan Saygun composed works in which genre?", "Classical Music","Turkish Folk Music","Jazz","Pop", "Classical Music"); 
	static Questions1 qh8 = new Questions1(8,"Hard","Which Turkish statesman declared the \"National Pact\" to determine Turkey's borders?","İsmet İnönü","Mustafa Kemal Atatürk","Celal Bayar","Adnan Menderes","Mustafa Kemal Atatürk");
	
	static Questions1[] easyones = {q1, q2, q3,q4,q5,q6,q7,q8};
	static Questions1[] middleones = {qm1, qm2, qm3, qm4, qm5, qm6, qm7, qm8};
	static Questions1[] hardones = {qh1,qh2,qh3,qh4,qh5,qh6,qh7,qh8};	
	
	private void checkAnswer(JRadioButton b) {
        if (b.getText().equals(easyones[answer].cerrectchoice)) {
            
            points += 10; // Puanı 10 artır
            JOptionPane.showMessageDialog(this, "Correct! Points: " + points);
        } else {
            // Yanlış cevap
            JOptionPane.showMessageDialog(this, "Wrong! Points: " + points);
        }if (b.getText().equals(easyones[answer2].cerrectchoice)) {
            
            points += 10; // Puanı 10 artır
            JOptionPane.showMessageDialog(this, "Correct! Points: " + points);
        } else {
            // Yanlış cevap
            JOptionPane.showMessageDialog(this, "Wrong! Points: " + points);
        }
  
    }
	
	private void checkAnswer2(JRadioButton b) {
	    if (b.getText().equals(middleones[answer3].cerrectchoice) || b.getText().equals(middleones[answer4].cerrectchoice)) {
	        points += 30; // Add 10 points for each correct answer
	        JOptionPane.showMessageDialog(this, "Correct! Points: " + points);
	    } else {
	        JOptionPane.showMessageDialog(this, "Wrong! Points: " + points);
	    }
	}
	
	private void checkAnswer3(JRadioButton b) {
	    if (b.getText().equals(hardones[answer5].cerrectchoice) || b.getText().equals(hardones[answer6].cerrectchoice)) {
	        points += 50; // Add 10 points for each correct answer
	        JOptionPane.showMessageDialog(this, "Correct! Points: " + points);
	    } else {
	        JOptionPane.showMessageDialog(this, "Wrong! Points: " + points);
	    }
	}
}
