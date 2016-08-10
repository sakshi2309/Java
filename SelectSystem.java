import java.awt.event.*;
import javax.swing.*;

public class SelectSystem extends javax.swing.JFrame {
	private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;


    public SelectSystem() {
        initComponents();
    }
    private void initComponents() {
		setResizable(false);
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();


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

        jButton1.setText("Run on one system");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Run on different systems");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

		setLayout(null);
		add(jButton1);
		add(jButton2);

        setSize(500,500);
        jButton1.setBounds(150,150,200,25);
        jButton2.setBounds(150,210,200,25);

    }// </editor-fold>

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		OtherSystemOptions oso=new OtherSystemOptions();
        	this.setVisible(false);
        	oso.setVisible(true);


    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        FirstPage fp=new FirstPage();
        fp.setVisible(true);
        this.setVisible(false);
    }


}
