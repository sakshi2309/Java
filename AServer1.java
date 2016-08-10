import java.io.*; 
import java.net.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
public class AServer1
{
   public static void main(String ab[])
	{    String receivedFileName,s=" ";
	                 
            ServerSocket providerSocket = null;
            Socket connection = null ;
             BufferedReader br;
             FileOutputStream os = null;
             FileInputStream in;
		try{
			providerSocket = new ServerSocket(9092);
			connection = providerSocket.accept();			
			//javax.swing.JOptionPane.showMessageDialog(null,"Connection established " + connection.getInetAddress().getHostName());
			
                }catch(Exception e)
                {  System.out.println(e.getMessage());
                }
                
		  try{
                        javax.swing.JOptionPane.showMessageDialog(null,"select the file where you want  to save a file...");
			JFileChooser savemyFile = new JFileChooser();
			FileFilter filter = new FileNameExtensionFilter(" files", "txt");
			savemyFile.addChoosableFileFilter(filter);
			int ret=savemyFile.showSaveDialog(null);
			File outputFile = savemyFile.getSelectedFile();
			receivedFileName=String.valueOf(outputFile);
			os =new FileOutputStream(receivedFileName+".txt");
                  }catch(Exception d){
                      System.out.println(d.getMessage());
                  }
                  try {  char t; 
                        
                        br=new BufferedReader(new InputStreamReader(connection.getInputStream()));
                              
					do
					 {    t=(char)br.read();
						os.write(t);
			 		 }while(t!='/');
				os.close();
                                 
                        }
			catch(Exception c)
				{       System.out.println(c.getMessage());
					System.out.println("Data received in unknown format");
				}
                    

	}




	}

