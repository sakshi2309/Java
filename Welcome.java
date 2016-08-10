import java.awt.event.*;
import javax.swing.*;
public class Welcome extends javax.swing.JFrame {
    public Welcome() {

        initComponents();
    }
    private void initComponents() {
    	jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setTitle("ELGAMAL ENCRYPTION SYSTEM");
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent evt)
            {
            int response = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(response==JOptionPane.YES_OPTION)
            {
            	System.exit(0);
            }
            else
            {
 				setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
            }
            }
        });
        jLabel1.setText("WELCOME TO ELGAMAL ENCRYPTION SOFTWARE");
        jButton1.setText("ENTER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton2.setText("EXIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
			add(jButton1);
			add(jButton2);
			add(jLabel1);
			setLayout(null);
        setSize(500,500);
        jButton1.setBounds(150,150,150,25);
        jButton2.setBounds(150,210,150,25);
        jLabel1.setBounds(100,50,350,50);
        }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        SelectSystem ss=new SelectSystem();
        ss.setVisible(true);
        this.setVisible(false);
            }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
              System.exit(0);
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Welcome().setVisible(true);
            }
        });
    }
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    }
