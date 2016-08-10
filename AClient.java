import java.io.*;
import java.net.*;
public class AClient
{       ServerSocket ss=null;
	Socket requestSocket;
	ObjectOutputStream out;
 	ObjectInputStream in;
 	String ip="";

	public void run1()
	{   
			try{
            	//int confirm = JOptionPane.showConfirmDialog(null,"press YES to transfer encrypted data \n\nto this system NO or CANCEL to transfer \n\n it to the other system","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
            	ip=javax.swing.JOptionPane.showInputDialog("","enter the ip address of destination");
                        
                        /*if( confirm == JOptionPane.YES_OPTION )
                        {
                        	requestSocket = new Socket("10.11.3.244", 6000);
                        }
                        else
                        {
                        	requestSocket = new Socket("10.11.2.74", 6000);
                        }*/
                        requestSocket = new Socket(ip,6000);
		javax.swing.JOptionPane.showMessageDialog(null,"connected to the destination");
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(requestSocket.getInputStream());
   	        }
		catch(UnknownHostException unknownHost){
                    javax.swing.JOptionPane.showMessageDialog(null,"You are trying to connect to an unknown host!");
                    
		  }
		catch(IOException ioException){
		    javax.swing.JOptionPane.showMessageDialog(null,"Warning!, Enter correct IP");
                    
		}
               
                        
               		
	}
	void sendMessage(String msg)
	{
		try{
			out.writeObject(msg);
			out.flush();
			System.out.println("client>" + msg);
		}
		catch(IOException ioException){
			javax.swing.JOptionPane.showMessageDialog(null," enter correctly..");
		}
    }
	
}
