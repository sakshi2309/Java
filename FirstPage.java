import java.awt.event.*;
import javax.swing.*;

public class FirstPage extends javax.swing.JFrame {
	private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;


    public FirstPage() {
        initComponents();
    }
    private void initComponents() {
		setResizable(false);
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        jButton1.setText("ENCRYPTION");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });


        jButton2.setText("DECRYPTION");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton3.setText("BACK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

		setLayout(null);
		add(jButton1);
		add(jButton2);
		add(jButton3);
        setSize(500,500);
        jButton1.setBounds(150,150,150,25);
        jButton2.setBounds(150,210,150,25);
        jButton3.setBounds(150,270,150,25);

    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        	KeyGen kg=new KeyGen();
    	kg.setVisible(true);
    	this.setVisible(false);


    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        DecryptPage dp=new DecryptPage();
        dp.setVisible(true);
        this.setVisible(false);
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        SelectSystem ss=new SelectSystem();
        ss.setVisible(true);
        this.setVisible(false);
    }


}
