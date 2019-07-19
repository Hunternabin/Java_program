package JmenuBarMenuMenuItem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class JmenuEg1 {
	
	static JMenu swing, servelet, beans,jdbc,hybernate,cobra,i4;
	static JMenu network,eventhandle;
	
	
	
	 static JMenuItem i1,i2,i3,i5,oops,procedure;
	 static JMenuItem tcp,url,socket;
	 static JMenuItem actionevent,keyevent,mouseevent,windowevent;
	 
	 
	 static JLabel registration,fname,mname,lname,address,phone,college1,gender,email,password,reenterpass;
	 static JComboBox college;
	 static JTextField t1,t2,t3,t4,t5,t6,t7;
	 static JPasswordField pass,repass;
	 static JRadioButton male,female,both;
	 
	static JCheckBox agree;
	static JLabel condition;
	
	static JButton signup,login;static JLabel forget;
	 
	 public static void main(String[] args) {
		
	JFrame frame =new JFrame("menuitem example");
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setBounds(300,200,600,600);
	frame.setLayout(null);
//	Container c = frame.getContentPane();
	
	swing = new JMenu("Swing");
	servelet = new JMenu("Servelet");
	beans = new JMenu("Beans");
	jdbc = new JMenu("JDBC");
	hybernate = new JMenu("Hybernate");
	cobra = new JMenu("Cobra");
	
	oops =new JMenu("OOP");
	procedure = new JMenu("procedure");
	
//	JSeparator sp = new JSeparator();
//	swing.addSeparator();
	
	i1= new JMenuItem("JTable");
	i2 = new JMenuItem("JTist");
	i3 = new JMenuItem("JTextfield");
	i4 = new JMenu("JPasswordfield");
	i5 = new JMenuItem("JCombo");
	
	tcp = new JMenuItem("TCP");
	url = new JMenuItem("URL");
	socket = new JMenuItem("Socket");
	
	network = new JMenu("Network");
	eventhandle = new JMenu("EventHandle");
	
	keyevent = new JMenuItem("KeyEvent");
	actionevent = new JMenuItem("ActionEvent");
	windowevent = new JMenuItem("WindowEvent");
	mouseevent = new JMenuItem("MouseEvent");
	
	
	Font f3 =new Font("Times New Roman",Font.ITALIC,20);
	
	swing.setFont(f3);beans.setFont(f3);jdbc.setFont(f3);cobra.setFont(f3);hybernate.setFont(f3);
	network.setFont(f3);eventhandle.setFont(f3);
	
	i1.setFont(f3);i2.setFont(f3);i3.setFont(f3);i4.setFont(f3);i5.setFont(f3);
	oops.setFont(f3);procedure.setFont(f3); servelet.setFont(f3);
	tcp.setFont(f3);url.setFont(f3);socket.setFont(f3);
	keyevent.setFont(f3);mouseevent.setFont(f3);windowevent.setFont(f3);actionevent.setFont(f3);
	
	
	
	
	swing.add(i1);
	swing.add(i2);
	
	servelet.add(i3);servelet.add(i4);swing.add(i5);
	i4.add(oops); i4.add(procedure);
	swing.add(servelet);
	
	network.add(url);network.add(tcp);network.add(socket);
	eventhandle.add(actionevent);eventhandle.add(keyevent);eventhandle.add(mouseevent);eventhandle.add(windowevent);
	
	JMenuBar mb = new JMenuBar();
	mb.add(swing);
	mb.add(beans);
	mb.add(jdbc);
	mb.add(cobra);
	mb.add(hybernate);
	
	mb.add(network);
	mb.add(eventhandle);
	
	frame.setJMenuBar(mb);
	
	
	
	//form start
	
	registration = new JLabel("Student Registration Form");
	fname = new JLabel("firstName:");
	mname = new JLabel("middleName:");
	lname = new JLabel("lastName:");
	address = new JLabel("Address:");
	phone = new JLabel("Phone:");
	college1 = new JLabel("College:");
	String str[] = {"KBC","NCC","TC","KEC"};
	college = new JComboBox(str);
	
	gender = new JLabel("Gender:");
	
	agree = new JCheckBox("Agree the  follow the terms and conditon of college!");
//	condition = new JLabel("please follow the terms and conditon of college!");
	
	male = new JRadioButton("Male");
	female = new JRadioButton("Female");
//	both = new JRadioButton("both");
	
	signup = new JButton("SignUp");
	login = new JButton("Login");
	forget = new JLabel("Forget password ?");
	
	email = new JLabel("Email:");
	password = new JLabel("Password:");
	reenterpass= new JLabel("Re-Pass:");
	
	
	t1 = new JTextField();
	t2 = new JTextField();
	t3 = new JTextField();
	t4 = new JTextField();
	t5 = new JTextField();
	t6 = new JTextField();
	t7= new JTextField();
	
	pass = new JPasswordField();
	repass = new JPasswordField();
	
	
	JLabel img = new JLabel("");JButton upload = new JButton("Upload");
	img.setBorder(new LineBorder(Color.BLUE)); //label border blue
	
	JLabel imgname = new JLabel(" ");
	imgname.setBorder(new LineBorder(Color.GREEN));
	
	img.setBounds(500,100,200,150); upload.setBounds(550,260,100,20);
	imgname.setBounds(500,300,200,20);
	
	img.setIcon(new ImageIcon(new ImageIcon("pushkar.jpeg").getImage().getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_DEFAULT)));
	
	registration.setBounds(200,50,300,30);
	fname.setBounds(200,100,100,30); t1.setBounds(300,100,100,20);
	mname.setBounds(200,150,100,30); t2.setBounds(300,150,100,20);
	lname.setBounds(200,200,100,30); t3.setBounds(300,200,100,20);
	address.setBounds(200,250,100,30);t4.setBounds(300,250,100,20);
	phone.setBounds(200,300,100,30);t5.setBounds(300,300,100,20);
	college1.setBounds(200,350,100,30);college.setBounds(300,350,100,30);
	
	gender.setBounds(200,400,100,30);male.setBounds(250,400,80,30);female.setBounds(330,400,80,30);
	ButtonGroup bg = new ButtonGroup();
	bg.add(male);bg.add(female);
	
	email.setBounds(200,450,100,30);t7.setBounds(300,450,100,20);
	password.setBounds(200,500,100,30);pass.setBounds(300,500,100,20);
	reenterpass.setBounds(200,550,200,40);repass.setBounds(300,550,100,20);
	
	agree.setBounds(200,600,400,30);
//	condition.setBounds(300,450,100,30);
	
	signup.setBounds(200,650,100,30);login.setBounds(320,650,100,30);
	forget.setBounds(200,700,200,30);
	
	
	
	
	Font f1 =new Font("Times New Roman",Font.ITALIC,25);
	Font f2 =new Font("Times New Roman",Font.ITALIC,17);
	registration.setFont(f1);
	registration.setForeground(Color.RED);
	fname.setFont(f2);lname.setFont(f2);mname.setFont(f2);address.setFont(f2);phone.setFont(f2);
	college1.setFont(f2);gender.setFont(f2);college.setFont(f2);agree.setFont(f2);
	male.setFont(f2);female.setFont(f2);
	
	signup.setFont(f2);login.setFont(f2);
	email.setFont(f2);password.setFont(f2);reenterpass.setFont(f2);
	
//	signup.setBackground(Color.red);login.setBackground(Color.red);
	
	frame.add(img); frame.add(upload);frame.add(imgname);
	
	
	
	frame.add(registration);
	frame.add(fname);frame.add(mname);
	frame.add(lname); frame.add(address);
	frame.add(phone);frame.add(college); frame.add(college1);
	
	frame.add(t1);frame.add(t2); frame.add(t3);frame.add(t4);frame.add(t5);frame.add(t6);
	frame.add(gender);
	frame.add(male);frame.add(female);frame.add(agree);
//	frame.add(condition);
	frame.add(signup);frame.add(login);
	
	frame.add(email);frame.add(pass);frame.add(t1);frame.add(password);frame.add(t7);
	frame.add(reenterpass);frame.add(repass);
	frame.add(forget);
	
	
	upload.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//to set value in img label from harddrive
			JFileChooser jf = new JFileChooser();
			jf.showOpenDialog(null); //button clicked ->dialogbox open to select image
			
			File image = jf.getSelectedFile();
			
			
			//only select jpeg,jpg and png image
			String imgext = image.getName().split("\\.")[1];
			
			if(imgext.equalsIgnoreCase("jpg")||imgext.equalsIgnoreCase("png")||imgext.equalsIgnoreCase("jpeg")) {
			
			img.setIcon(new ImageIcon(new ImageIcon(image.getAbsolutePath()).getImage().getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_DEFAULT)));
			imgname.setText(image.getName());
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Invalide Image");
			}
			
			
			
			
		}
	});
	
	
	
	
	
	}

}
