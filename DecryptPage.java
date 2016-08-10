  import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
 import java.io.File;
 import java.math.BigInteger;
import java.security.*;
import javax.swing.*;
import java.util.Vector;
import java.util.*;
import java.io.*;
public class DecryptPage extends javax.swing.JFrame {


private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    String encryptedFileName,decryptedFileName;
    int choice=0;
    File fileencryptedFileName=null,filedecryptedFileName=null;
    /** Creates new form DecryptPage */
    public DecryptPage() {
        initComponents();
    }
    private void initComponents() {
		setResizable(false);
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jTextField1.setEditable(false);
        jTextField2.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        setTitle("ELGAMAL ENCRYPTION SYSTEM");
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


        jButton1.setText("Encrypted File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Decrypted File");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Next");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });


        setLayout(null);
        add(jButton1);
        add(jButton2);
        add(jButton3);
        add(jButton4);
        add(jTextField1);
        add(jTextField2);
        setSize(500,500);
        jButton1.setBounds(20,130,150,20);
        jButton2.setBounds(20,190,150,20);
        jTextField1.setBounds(200,130,280,20);
        jTextField2.setBounds(200,190,280,20);
        jButton3.setBounds(150,250,150,22);
        jButton4.setBounds(150,310,150,22);
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	FileChooserDialog fcd=new FileChooserDialog();
    	fileencryptedFileName=fcd.fileSelect();
    	encryptedFileName=String.valueOf(fileencryptedFileName);
    	jTextField1.setText(encryptedFileName);

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        SaveFile sf=new SaveFile();
	    filedecryptedFileName=sf.selectEncrypted();
        decryptedFileName=String.valueOf(filedecryptedFileName);
        jTextField2.setText(decryptedFileName);

    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
    }
     private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.setVisible(false);
        FirstPage fp=new FirstPage();
        fp.setVisible(true);

    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
    	if(fileencryptedFileName==null || filedecryptedFileName==null)
        {

        javax.swing.JOptionPane.showMessageDialog(null,"Either the decrypted file or encrypted file is not selected");        // TODO add your handling code here:
        jTextField1.setText("");
        jTextField2.setText("");
        }
        else if(!encryptedFileName.endsWith(".txt"))
         {
         	        	javax.swing.JOptionPane.showMessageDialog(null,"Either the encrypted file or decrypted file is not a txt file");        // TODO add your handling code here:
         	        	jTextField1.setText("");
         	        	jTextField2.setText("");
         }
        else if(!fileencryptedFileName.exists())
        {

        	javax.swing.JOptionPane.showMessageDialog(null,"The encrypted file does not exist");
        		jTextField1.setText("");       // TODO add your handling code here:
        }


         else if(encryptedFileName.equals(decryptedFileName))
        {
        	javax.swing.JOptionPane.showMessageDialog(null,"the encrypted file and decrypted file can not be the same");        // TODO add your handling code here:
        	jTextField1.setText("");
        	jTextField2.setText("");
        	encryptedFileName="";
        	decryptedFileName="";
        	fileencryptedFileName=null;
        	filedecryptedFileName=null;

        }
        else if(!decryptedFileName.endsWith(".txt"))
        {

        	javax.swing.JOptionPane.showMessageDialog(null,"Either the encrypted file or decrypted file is not a txt file");        // TODO add your handling code here:
        	jTextField2.setText("");
        	jTextField1.setText("");
        }

        else
        {
        	if(filedecryptedFileName.exists())
        	{
        		int response = JOptionPane.showConfirmDialog(null, "The decrypted file already exists.\n\nDo you want to overwrite the existing file", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	         if(response==JOptionPane.NO_OPTION || response==JOptionPane.CANCEL_OPTION )
	         {
	         	jTextField2.setText("");
	         }
	         else
        	{

			DecryptNext dn=new DecryptNext(decryptedFileName,encryptedFileName);
        dn.setVisible(true);
        this.setVisible(false);
        	}
        	}
        	else
        	{
        		DecryptNext dn=new DecryptNext(decryptedFileName,encryptedFileName);
        dn.setVisible(true);
        this.setVisible(false);
        	}

        }
    }



}
