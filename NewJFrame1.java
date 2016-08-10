/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.event.*;
import java.math.BigInteger;
import java.util.Vector;
import javax.swing.*;
public class NewJFrame1 extends javax.swing.JFrame {
	private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
	    private javax.swing.JTextField jTextField1;
	BigInteger p,gre;
    int users;
    Vector v=new Vector();
    Vector u=new Vector();
    int choice=1;
    int keyLength;
    /** Creates new form NewJFrame */
    public NewJFrame1() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

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


        jLabel1.setText("  Parts In Which You Want To Divide The Private Key");

        jButton1.setText("Press To Get The Random Number");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Press To Get The Prime Number");
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

        jButton4.setText("OK");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
		setLayout(null);
		add(jLabel1);
		add(jButton1);
		add(jButton2);
		add(jButton3);
		add(jTextField1);
		add(jButton4);
		add(jButton5);


        setSize(500,500);
        jButton2.setBounds(100,60,300,20);
        jButton1.setBounds(100,120,300,20);
        jLabel1.setBounds(100,180,400,20);
        jTextField1.setBounds(200,240,100,20);
        jButton4.setBounds(200,300,100,20);
        jButton3.setBounds(200,360,100,20);
         jButton5.setBounds(200,420,100,20);

        //jButton2.setBounds(200,200);
        /*jButton1.setBounds(100,100,200,200);
        jButton1.setBounds(100,300,200,200);*/
    }// </editor-fold>

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(choice==1)

		//keylength=Integer.parseInt(javax.swing.JOptionPane.showInputDialog("enter the key size you want to use ",""));
        {
        CalcPnG cpg=new CalcPnG();
        keyLength=cpg.getkeyLength();
        p=cpg.calcP(keyLength);
        javax.swing.JOptionPane.showMessageDialog(null,"the prime number chosen is "+p);
        choice=2;
        }
        else
        	javax.swing.JOptionPane.showMessageDialog(null,"wrong button pressed");

    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.setVisible(false);
        KeyGenTransfer kg=new KeyGenTransfer();
        kg.setVisible(true);

    }
/*
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
*/
    private int jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {

		int textfield_users=Integer.parseInt(jTextField1.getText());
		return textfield_users;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(choice==2)
        {

        CalcPnG cpg=new CalcPnG();
        gre=cpg.calcGRE(p,keyLength);
        javax.swing.JOptionPane.showMessageDialog(null,"the random number chosen is "+gre);
        choice=3;
        }
        else
        	javax.swing.JOptionPane.showMessageDialog(null,"wrong button pressed");

    }

   /* private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }*/

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(choice==3)
    	{

    	users=jTextField1ActionPerformed(evt);        // TODO add your handling code here:
    	if(users%2==0)
    	{

    		javax.swing.JOptionPane.showMessageDialog(null,"you can enter only odd number");
    		jTextField1.setText("");
    	}

    		else
    		{


    	/*CalcPnG cpg=new CalcPnG();
    	v=cpg.calcPrivateKey(users);*/
    	CalcPnG cpg=new CalcPnG();
    	try
    	{
    		v=cpg.calcPrivateKey(p,users);
    	}
    	catch(Exception e)
    	{
    	}
    	u=cpg.calcPublicKey(v,p,gre);
    	for(int i=0;i<u.size();i++)
    	{
    		javax.swing.JOptionPane.showMessageDialog(null,"the public key for the part "+(i+1)+" is "+u.get(i));        // TODO add your handling code here:

    	}
    	choice=4;
    	}
    	}
    	else
    		javax.swing.JOptionPane.showMessageDialog(null,"wrong button pressed");


    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
                if(choice==4)
			{

			this.setVisible(false);
			EncryptionStartTransfer es=new EncryptionStartTransfer(p,gre,u,v);
			es.setVisible(true);
			}
			else
				javax.swing.JOptionPane.showMessageDialog(null,"wrong button pressed");

    }

    /**
    * @param args the command line arguments
    */
    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify

    // End of variables declaration

}
