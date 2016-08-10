import java.awt.event.*;
import java.io.*;
import java.math.BigInteger;
import java.util.Vector;
import javax.swing.*;
public class EncryptionStart extends javax.swing.JFrame {
	private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    int choice=0;
    File filefilename=null,fileencryptedFileName=null;
    String filename,encryptedFileName,decryptedFileName;
    BigInteger k;
    BigInteger p,gre;
    Vector u=new Vector();
    Vector v=new Vector();
    public EncryptionStart(BigInteger p,BigInteger gre,Vector u,Vector v) {
    	this.p=p;
			this.gre=gre;
			this.u=u;
			this.v=v;
        initComponents();
    }
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ELGAMAL ENCRYPTION SYSTEM");
        jTextField1.setEditable(false);
        jTextField2.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new WindowAdapter(){
        	public void windowClosing(WindowEvent evt){//System.exit(0);
            int response = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Confirm",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(response==JOptionPane.YES_OPTION)
            {
            	System.exit(0);
            }
            else //if(response==JOptionPane.NO_OPTION)
            {

				setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
            }
            }
        });


        jButton1.setText("Plaintext File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton2.setText("Encrypted File");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton3.setText("Start Encryption");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        setLayout(null);
        setSize(500,500);
        add(jButton1);
        add(jButton2);
        add(jButton3);
        //add(jButton4);
        add(jButton5);
        add(jTextField1);
        add(jTextField2);
        //add(jLabel1);
        jButton1.setBounds(20,100,150,20);
        jButton2.setBounds(20,160,150,20);
        jButton3.setBounds(150,240,150,22);
        //jLabel1.setBounds(150,240,150,30);
        //jButton4.setBounds(50,300,150,20);
        jButton5.setBounds(150,300,150,20);
        jTextField1.setBounds(200,100,250,20);
        jTextField2.setBounds(200,160,250,20);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        FileChooserDialog fcd=new FileChooserDialog();
        filefilename=fcd.fileSelect();
        filename=String.valueOf(filefilename);
                	jTextField1.setText(filename);
        	jTextField1ActionPerformed(evt);
        //	javax.swing.JOptionPane.showMessageDialog(null,"the file to be encrypted is "+filename);        // TODO add your handling code here:
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        SaveFile sf=new SaveFile();
        fileencryptedFileName=sf.selectEncrypted();
        encryptedFileName=String.valueOf(fileencryptedFileName);
        jTextField2.setText(encryptedFileName);
       // javax.swing.JOptionPane.showMessageDialog(null,"the file to be encrypted is "+encryptedFileName);        // TODO add your handling code here:
        jTextField2ActionPerformed(evt);

    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

    }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
    	int check=0;

    	 try
         {


			FileInputStream fis=new FileInputStream(filename);
    		int s=fis.read();
    		while(s!=-1)
    		{

    		if(s>127)
    		{
    			check=1;
    			//javax.swing.JOptionPane.showMessageDialog(null,"Can select only txt files \n \n with characters having ASCII value \n \n less than or equal to 127");        // TODO add your handling code here:
    			break;
    		}
    		else
    			s=fis.read();
    		}
         }catch(Exception e){
         }

       if(filefilename==null || fileencryptedFileName==null)
       {
       		javax.swing.JOptionPane.showMessageDialog(null,"either the plaintex file or encrypted file is not selected");
       			     // TODO add your handling code here:

       }
       else if(!filefilename.exists() )
       {
       	javax.swing.JOptionPane.showMessageDialog(null,"plaintext file does not exist");        // TODO add your handling code here:
       	jTextField1.setText("");
       }
       else if(!filename.endsWith(".txt") )
       {
       	javax.swing.JOptionPane.showMessageDialog(null,"either the plaintext file or encrypted file is not a text file");        // TODO add your handling code here:
       	jTextField1.setText("");
       	jTextField2.setText("");
       }
       else if(!encryptedFileName.endsWith(".txt"))
       {
       	javax.swing.JOptionPane.showMessageDialog(null,"either the plaintext file or the encrypted file is not a text file");        // TODO add your handling code here:
       	jTextField1.setText("");
       	jTextField2.setText("");
       }
       else if(filename.equals(encryptedFileName) )
       {
       		javax.swing.JOptionPane.showMessageDialog(null,"the encrypted file and plaintext file can not be the same");
       			       // TODO add your handling code here:
       			       filename="";
       			       encryptedFileName="";
       			       filefilename=null;
       			       fileencryptedFileName=null;

       		jTextField1.setText("");
       		jTextField2.setText("");
       }
       else if(check==1)
       {
       		javax.swing.JOptionPane.showMessageDialog(null,"the plaintext file contains characters with \n\n ASCII value greater than 127 \n\nHence it can not be encrypted");
       		jTextField1.setText("");
       }
       else
       {
       	if(fileencryptedFileName.exists())
       	{
       		int response = JOptionPane.showConfirmDialog(null, "the encrypted file already exists.\n\n Do you want to overwrite the existing file", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	         if(response==JOptionPane.YES_OPTION)
	         {
	    			int check_k1=0,check_k2=0,check_k3=0;     // TODO add your handling code here:
        	String string_k;
        do
        {
        	check_k1=0;
        	check_k2=0;
        	check_k3=0;
        	string_k="";
        do
        {
        	check_k1=0;
        	check_k2=0;
        	check_k3=0;
        	string_k="";
        	do
        	{
        	check_k1=0;
        	check_k2=0;
        	check_k3=0;
        	string_k="";

        string_k=javax.swing.JOptionPane.showInputDialog("the secret key k used for encryption is(it should be less than the prime number"+p+" ) ","");

        if(string_k==null || string_k.length()==0)
        {
        	check_k2=1;
        	javax.swing.JOptionPane.showMessageDialog(null,"can not leave the field blank");
        }
        }while(check_k2==1);

        int len=string_k.length();
        for(int i=0;i<len;i++)
        {
        	if((int)string_k.charAt(i)<=47 || (int)string_k.charAt(i)>=58)
        	{
        		check_k3=1;
        		javax.swing.JOptionPane.showMessageDialog(null,"can enter only integer values");
        		break;
        	}
        }
        }while(check_k3==1);
        k=new BigInteger(string_k);
        if(k.compareTo(p)>=0)
        {
        	check_k1=1;
        	javax.swing.JOptionPane.showMessageDialog(null,"k should be smaller than prime number"+p);
        }
        }while(check_k1==1);
        javax.swing.JOptionPane.showMessageDialog(null,"the file is being encrypted");
        EncryptFile ef=new EncryptFile();
        try
        	{       // TODO add your handling code here:
        ef.encryptMethod(filename,p,gre,u,k,encryptedFileName);
        //javax.swing.JOptionPane.showMessageDialog(null,"the encrypted file is ready in encyptionStart");        // TODO add your handling code here:
        	}
        	catch(Exception e)
        	{
        	}
        	javax.swing.JOptionPane.showMessageDialog(null,"the encrypted file is ready");

	         }
	         else
	         	jTextField2.setText("");
       	}
       	else
       	{
       				int check_k1=0,check_k2=0,check_k3=0;     // TODO add your handling code here:
        	String string_k;
        do
        {
        	check_k1=0;
        	check_k2=0;
        	check_k3=0;
        	string_k="";
        do
        {
        	check_k1=0;
        	check_k2=0;
        	check_k3=0;
        	string_k="";
        	do
        	{
        	check_k1=0;
        	check_k2=0;
        	check_k3=0;
        	string_k="";

        string_k=javax.swing.JOptionPane.showInputDialog("the secret key k used for encryption is(it should be less than prime number"+p+")","");

        if(string_k==null || string_k.length()==0)
        {
        	check_k2=1;
        	javax.swing.JOptionPane.showMessageDialog(null,"can not leave the field blank");
        }
        }while(check_k2==1);

        int len=string_k.length();
        for(int i=0;i<len;i++)
        {
        	if((int)string_k.charAt(i)<=47 || (int)string_k.charAt(i)>=58)
        	{
        		check_k3=1;
        		javax.swing.JOptionPane.showMessageDialog(null,"can enter only integer values");
        		break;
        	}
        }
        }while(check_k3==1);
        k=new BigInteger(string_k);
        if(k.compareTo(p)>=0)
        {
        	check_k1=1;
        	javax.swing.JOptionPane.showMessageDialog(null,"k should be smaller than prime number"+p);
        }
        }while(check_k1==1);
        javax.swing.JOptionPane.showMessageDialog(null,"the file is being encrypted");
        EncryptFile ef=new EncryptFile();
        try
        	{       // TODO add your handling code here:
        ef.encryptMethod(filename,p,gre,u,k,encryptedFileName);
        //javax.swing.JOptionPane.showMessageDialog(null,"the encrypted file is ready in encyptionStart");        // TODO add your handling code here:
        	}
        	catch(Exception e)
        	{
        	}
        	javax.swing.JOptionPane.showMessageDialog(null,"the encrypted file is ready");

       	}
       	}
       	}
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

KeyGen kg=new KeyGen();
kg.setVisible(true);
        this.setVisible(false);
    }



}
