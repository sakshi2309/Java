import java.awt.event.*;
import java.io.File;
import javax.swing.*;
public class TransferFile extends javax.swing.JFrame
{
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	    private javax.swing.JTextField jTextField1;
	File fileencryptedFileName=null;
    String encryptedFileName;
	public TransferFile()
	{
		initComponents();
	}
	private void initComponents()
	{
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jTextField1 = new javax.swing.JTextField();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		jTextField1.setEditable(false);
		jTextField1.setBackground(new java.awt.Color(255, 255, 255));
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
        jButton1.setText("File to be transfered");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

		jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        setLayout(null);
        add(jTextField1);
		add(jButton1);
		add(jButton2);
		add(jButton3);

        setSize(500,500);
        jButton1.setBounds(70,150,150,25);
        jButton2.setBounds(150,210,150,25);
        jButton3.setBounds(150,270,150,25);
        jTextField1.setBounds(250,150,150,25);



	}
	 private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {

    }
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        FileChooserDialog fcd=new FileChooserDialog();
        fileencryptedFileName=fcd.fileSelect();
        encryptedFileName=String.valueOf(fileencryptedFileName);
                	jTextField1.setText(encryptedFileName);
        	jTextField1ActionPerformed(evt);
        	//javax.swing.JOptionPane.showMessageDialog(null,"the file to be encrypted is "+filename);        // TODO add your handling code here:
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    	if(fileencryptedFileName==null)
    	{
    		javax.swing.JOptionPane.showMessageDialog(null,"No file selected");        // TODO add your handling code here:
    	}
    	else
    	{
    		FileTransfer ft=new FileTransfer();
                    ft.transfer(encryptedFileName);
        }
    
        }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		OtherSystemOptions oso=new OtherSystemOptions();
		oso.setVisible(true);
		this.setVisible(false);
    }
}