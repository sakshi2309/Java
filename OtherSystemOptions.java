import java.awt.event.*;
import java.math.BigInteger;
import java.util.Vector;
import javax.swing.*;

public class OtherSystemOptions extends javax.swing.JFrame {
	// javax.swing.JButton jButton1;
        private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton5;
        
        BigInteger p,gre;
        
        Vector v=new Vector();
     Vector u=new Vector();
    
    public OtherSystemOptions() {
        initComponents();
    }
    private void initComponents() {
		setResizable(false);
       // jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
       	jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        
        
        jButton3.setText("Decrypt files");
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
        jButton6.setText("Transfer file");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jButton5.setText("Encrypt files");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

		setLayout(null);
		//add(jButton1);
		add(jButton5);
		add(jButton3);
		add(jButton6);
		add(jButton4);
        setSize(500,500);
       // jButton1.setBounds(150,80,150,25);
        jButton5.setBounds(150,140,150,25);
        jButton3.setBounds(150,200,150,25);
      
       jButton6.setBounds(150,260,150,25);
	jButton4.setBounds(150,380,150,25);
    }// </editor-fold>
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

                DecryptPageTransfer dp1=new DecryptPageTransfer();
                dp1.setVisible(true);
                this.setVisible(false);
		}
	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {

            SelectSystem ss=new SelectSystem();
            ss.setVisible(true);
               this.setVisible(false);
		}
	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {

            TransferFile tf=new TransferFile();
            tf.setVisible(true);
            this.setVisible(false);
		}
	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {

            KeyGenTransfer ekt=new KeyGenTransfer();
            ekt.setVisible(true);
            this.setVisible(false);
		}
        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

		NewJFrameTransfer njf1=new NewJFrameTransfer();
		njf1.setVisible(true);
		this.setVisible(false);
            }

        


}
