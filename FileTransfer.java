

import java.io.*;
import java.net.*;

public class FileTransfer {
    
    	Socket requestSocket;
	OutputStreamWriter os;
 	BufferedWriter bw;
        PrintWriter pp;
      //  FileOutputStream out;
	FileInputStream in;
       // String ip;

public void transfer(String encryptFileName)
{
	                  	
  
	try{ 
              	//int confirm = JOptionPane.showConfirmDialog(null,"press YES to transfer encrypted data \n\nto this system NO or CANCEL to transfer \n\n it to the other system","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
            		InetAddress ip = InetAddress.getLocalHost();
                        ServerSocket s=new ServerSocket();
                        javax.swing.JOptionPane.showMessageDialog(null,ip.toString());  
                        requestSocket = new Socket(ip,9092);
		  // javax.swing.JOptionPane.showMessageDialog(null,"2");
                    //javax.swing.JOptionPane.showMessageDialog(null,"connected to the destination");
			os = new OutputStreamWriter(requestSocket.getOutputStream());
			 //javax.swing.JOptionPane.showMessageDialog(null,"3");
                        bw = new BufferedWriter(os);
                        // javax.swing.JOptionPane.showMessageDialog(null,"4");
                        pp=new PrintWriter(bw,true);
                        javax.swing.JOptionPane.showMessageDialog(null,"connection established.");
        }catch(Exception d){
            javax.swing.JOptionPane.showMessageDialog(null,d.getMessage());
           // System.out.println(d.getMessage());
        }
        char t=0;
        try{
                 in=new FileInputStream(encryptFileName);
                    do{   
                        t=(char) in.read();
                         pp.print(t);
                       
                      }while(t!='\0');
                       
                        javax.swing.JOptionPane.showMessageDialog(null," the file has been transfered");
                        in.close(); 
                        OtherSystemOptions op = new OtherSystemOptions();
                            op.setVisible(true);
                           System.exit(0); 
                   
   	        }
		catch(Exception e){ javax.swing.JOptionPane.showMessageDialog(null,"save the file");
                }
                                     

        }
}