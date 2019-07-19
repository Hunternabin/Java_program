package Calculator;

import java.awt.Color;
import java.math.*;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Calc {
	
	JFrame frame ;
	JButton one,two,three,four,five,six,seven,eight,nine,zero,add,sub,mul,div,equal,clear,CA;
	JTextField result;
	JTextArea textarea;
	
	
	double firstnum;
	double secondnum;
	double rslt ;
	String operations;
	String answer;
	
	
	
	public Calc() {
//	public static void main(String[] args) {
		
	
	
		
		frame = new JFrame("calculator");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setLocation(300,300);
	
		
		Container c =frame.getContentPane();
		c.setLayout(null);
		
		result =new JTextField();
		one = new JButton("1");
		two =new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
		zero = new JButton("0");
		
		
		add = new JButton("+");
		sub = new JButton("-");
		mul = new JButton("*");
		div = new JButton("/");
		equal = new JButton("=");
		clear = new JButton("c");
		CA = new JButton("CA");
		
		JButton dot = new JButton(".");
		JButton percent = new JButton("%");
		JButton loge = new JButton("log");
		JButton sine = new JButton("sin()");
		JButton cose = new JButton("cos()");
		JButton tane = new JButton("tan()");
		
		JButton square = new JButton("squarert");
		
		
		result.setBounds(50,30,230,30);
		seven.setBounds(50,70,50,20);
		eight.setBounds(110,70,50,20);
		nine.setBounds(170,70,50,20);
		
		four.setBounds(50,100,50,20);
		five.setBounds(110,100,50,20);
		six.setBounds(170,100,50,20);
		
		
		one.setBounds(50,130,50,20);
		two.setBounds(110,130,50,20);
		three.setBounds(170,130,50,20);
		
		
		div.setBounds(230,70,50,20);
		mul.setBounds(230,100,50,20);
		add.setBounds(230,130,50,20);
		sub.setBounds(230,160,50,20);
//		zero.setBounds(10,160,50,20);
		zero.setBounds(50,160,50,20);
		clear.setBounds(110,160,55,20);
		CA.setBounds(170,160,70,20);
		equal.setBounds(290,160,70,20);
		
		
		dot.setBounds(290,70,70,20);
		percent.setBounds(290,100,70,20);
		loge.setBounds(290,130,70,20);
		sine.setBounds(50,190,70,20);
		cose.setBounds(110,190,70,20);
		tane.setBounds(170,190,70,20);
		
		square.setBounds(250,190,100,20);
		
		c.add(result);
		
		c.add(seven);
		c.add(eight);
		c.add(nine);
		
		c.add(four);
		c.add(five);
		c.add(six);
		
		c.add(one);
		c.add(two);
		c.add(three);
		
		c.add(div);
		c.add(mul);
		c.add(add);
		c.add(sub);
		
		
		c.add(zero);
		c.add(clear);
		c.add(CA);
		c.add(equal);
		
		c.add(loge);
		c.add(percent);
		c.add(cose);
		c.add(sine);
		c.add(tane);
		c.add(dot);
		
		c.add(square);
		
		
		/*
		seven.addActionListener((ActionListener) this);
		eight.addActionListener((ActionListener) this);
		nine.addActionListener((ActionListener) this);
		five.addActionListener((ActionListener) this);
		six.addActionListener((ActionListener) this);
		seven.addActionListener((ActionListener) this);
		one.addActionListener((ActionListener) this);
		two.addActionListener((ActionListener) this);
		three.addActionListener((ActionListener) this);
		zero.addActionListener((ActionListener) this);
		div.addActionListener((ActionListener) this);
		mul.addActionListener((ActionListener) this);
		add.addActionListener((ActionListener) this);
		sub.addActionListener((ActionListener) this);
		clear.addActionListener((ActionListener) this);
		equal.addActionListener((ActionListener) this);
		CA.addActionListener((ActionListener) this);
	*/
		
		
		// clear operation
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String backspc = null;
				if(result.getText().length()>0) {//result is text on the top of the text
				StringBuilder strb = new StringBuilder(result.getText());
				strb.deleteCharAt(result.getText().length()-1);
				backspc = strb.toString();
				result.setText(backspc);
				}
			}
			
		});
		
		
		//clearall opearation
		
CA.addActionListener(new ActionListener() {
			
	
			@Override
			public void actionPerformed(ActionEvent e) {
				result.setText(null);
				
			}
		});

		

		//seven buttton getText();
		seven.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//result.setText(seven.getText());				
				
				String str = result.getText()+seven.getText();
				result.setText(str);
			}
		});
		eight.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//result.setText(eight.getText());
				String str = result.getText()+eight.getText();
				result.setText(str);
				
			}
		});
		nine.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				result.setText(nine.getText());
				String str = result.getText()+nine.getText();
				result.setText(str);
				
			}
		});
	
		
		five.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = result.getText()+five.getText();
				result.setText(str);
				
			}
		});
		
		six.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = result.getText()+six.getText();
				result.setText(str);
				
			}
		});
		
		
		four.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = result.getText()+four.getText();
				result.setText(str);
				
			}
		});
		
		one.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = result.getText()+one.getText();
				result.setText(str);
				
			}
		});
		
		two.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = result.getText()+two.getText();
				result.setText(str);
				
			}
		});
		three.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = result.getText()+three.getText();
				result.setText(str);
				
			}
		});
		zero.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = result.getText()+zero.getText();
				result.setText(str);
				
			}
		});
		div.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				firstnum = 	Double.parseDouble(result.getText());
				result.setText(" ");
				operations = "/";				
			}
		});
		
		mul.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				firstnum = 	Double.parseDouble(result.getText());
				result.setText("");
				operations = "*";
				
			}
		});
		
		sub.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				firstnum = 	Double.parseDouble(result.getText());
				result.setText("");
				operations = "-";
				
			}
		});
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				firstnum = 	Double.parseDouble(result.getText());
				result.setText("");
				operations = "+";
				
			}
		});
		
	dot.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = result.getText()+dot.getText();
				result.setText(str);
				
			}
		});
//		dot.setBackground(Color.RED);
	
	
	percent.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			firstnum = Double.parseDouble(result.getText());
			result.setText("");
			operations = "%";
			
		}
	});
	
	
	loge.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			double num = Double.parseDouble(result.getText());
			System.out.println(num);
			num = Math.log10(num);
			
			rslt = Double.parseDouble(String.format("%.2f", num));
			result.setText(Double.toString(rslt));
			
			
		}
	});
	
	sine.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		
			
			double num=Double.parseDouble(result.getText());
			System.out.println(Double.toString(num)); //cosole output
			num=Math.sin(num);
			rslt = Double.parseDouble(String.format("%.2f", num));
		result.setText(Double.toString(rslt));
			
		}
	});
//	
	cose.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			double num = Double.parseDouble(result.getText());
			System.out.println(num);
			num  = Math.cos(num);
			rslt = Double.parseDouble(String.format("%.2f", num));
			result.setText(Double.toString(rslt));
			
		}
	});
	
	tane.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			double num =Double.parseDouble( result.getText());
			System.out.println(num);
			num = Math.tan(num);
			rslt = Double.parseDouble(String.format("%.2f", num));
			result.setText(Double.toString(rslt));
		}
	});
	

	square.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			double num =Double.parseDouble( result.getText());
			System.out.println(num);
			num = Math.sqrt(num);
			rslt = Double.parseDouble(String.format("%.2f", num));
			result.setText(Double.toString(rslt));
			
		}
	});
	
	
	
	
		
		
		equal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				secondnum = Double.parseDouble(result.getText());
				if(operations == "+") {
					
					rslt = firstnum + secondnum;
					answer = String.format( "%.2f",rslt);
					result.setText(answer);
				}
				else if(operations == "-") {
					rslt = firstnum-secondnum;
					answer = String.format("%.2f", rslt);
					result.setText(answer);
				}
				else if(operations =="*") {
					rslt = firstnum * secondnum;
					answer = String.format("%.2f", rslt);
					result.setText(answer);
				}
				
				else if(operations =="/") {
					rslt = firstnum / secondnum;
					answer= String.format("%.2f",rslt);
					result.setText(answer);
				}
				else if(operations =="%") {
					rslt = firstnum % secondnum;
					answer = String.format("%.2f", rslt);
					result.setText(answer);
				}
				
				
				
//				else if(operations =="sin()") {
//					System.out.println("ASD");
//					result.setText("sin("+Double.toString(firstnum)+")");
//					
//					
//				}
				
			}
		});
		
	
	
		
		
		
		
		
	}
	
	/*
	public void actionPerformed(ActionEvent e) {
		
		double num1 , num2,result1 ;
		int addition = 0,subtraction = 0,multiplication = 0,division =0;
		
		if(e.getSource()== seven) {
			result.setText(seven.getText());
			
		}
		
	}
	*/
	public static void main(String[] args) {
		new Calc();
	}
}







