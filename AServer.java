import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
public class AServer{
    static String encryptedFileName,s=" ";
	ServerSocket providerSocket=null;
            Socket connection = null;

    static ObjectOutputStream out;
    static ObjectInputStream in;
   static String msg;
   static String decrptedhashcode;
   static String hashcodeofrecievefile;
      static  String filename;
        int hashcode;
	
void run()
	{   		try{
			providerSocket = new ServerSocket(6000, 10);
			javax.swing.JOptionPane.showMessageDialog(null,"waiting for connection");
			connection = providerSocket.accept();
			javax.swing.JOptionPane.showMessageDialog(null,"Connection received" + connection.getInetAddress().getHostName());
			//javax.swing.JOptionPane.showMessageDialog(null,"Connection received from rashmi");
			out = new ObjectOutputStream(connection.getOutputStream());
			out.flush();
			in = new ObjectInputStream(connection.getInputStream());
			javax.swing.JOptionPane.showMessageDialog(null,"select the file where you want the data to be stored");
			JFileChooser savemyFile = new JFileChooser();
			FileFilter filter = new FileNameExtensionFilter(" files", "txt");
			savemyFile.addChoosableFileFilter(filter);
			int ret=savemyFile.showSaveDialog(null);
			File outputFile = savemyFile.getSelectedFile();
			encryptedFileName=String.valueOf(outputFile);
			FileOutputStream out=new FileOutputStream(encryptedFileName);
        	PrintStream prin= new PrintStream( out );
			try{
                do{
					msg = (String)in.readObject();
					if(msg.equals("bye"))
					{
						in.close();
						out.close();
						providerSocket.close();
						connection.close();
						break;
					}
        	prin.print (msg);
        	prin.print(s);
        	       }while(!msg.equals("bye"));
        	javax.swing.JOptionPane.showMessageDialog(null,"file saved at the server side");
            int response = JOptionPane.showConfirmDialog(null, "Do you want to wait for some more files or exit?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(response==JOptionPane.NO_OPTION || response==JOptionPane.CANCEL_OPTION)
            {
            	System.exit(0);
            }
            	}
			catch(ClassNotFoundException classnot)
				{
					System.err.println("Data received in unknown format");
				}
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}


		finally{
			//4: Closing connection
			try{
			//	int response = JOptionPane.showConfirmDialog(null, "Do you want to close the connection?", "Confirm",
            //JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            //if(response==JOptionPane.YES_OPTION)
            //{

				in.close();
				out.close();
				providerSocket.close();
				connection.close();
            //}
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}
	}




	}

