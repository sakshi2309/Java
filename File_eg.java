import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.util.Vector;
import java.util.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;
class File_eg
{
   public  void f_read(String filename,BigInteger p,BigInteger gre,Vector u,Vector temp_c2,BigInteger k,String encryptedFileName,BigInteger c1) throws java.io.IOException
  {
  	int s;
  	int decimal;
  	BigInteger c2;
  	 Encrypt et=new Encrypt();
  	 //Vector vector_c2=new Vector();

  		FileOutputStream out=new FileOutputStream(encryptedFileName);
        PrintStream prin= new PrintStream( out );
    	//FileReader fr=new FileReader(filename);
    	FileInputStream fis=new FileInputStream(filename);
    	s=fis.read();
		 	//s=fr.read();
		 	//javax.swing.JOptionPane.showMessageDialog(null,"the message is "+s);        // TODO add your handling code here:
		 	while(s!=(-1))
		 	{
		 		//javax.swing.JOptionPane.showMessageDialog(null,"the message is "+s);        // TODO add your handling code here:
		 	//	s=fr.read()	;
		 	c2=new BigInteger("1");
			c2=	et.en(p,gre,u.size(),k,u,s,temp_c2);


			//fr.flush();

        prin.print (c1+" "+c2+" ");
        s=fis.read();
			//vector_c2.add(c2);
		//	c2=BigInteger.valueOf(1);

		 	}


			prin.close();
//    return vector_c2;
  }


  }
