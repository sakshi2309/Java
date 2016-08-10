
import java.math.BigInteger;
import java.security.*;
import java.util.Vector;
import java.util.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;


public class EncryptFile {

public void encryptMethod(String filename,BigInteger p,BigInteger gre,Vector u,BigInteger k,String encryptedFileName)throws IOException,ClassCastException
{
	Vector vector_c2=new Vector();
	BigInteger c1,c2;
	c1=gre.modPow(k,p);
        Vector temp_c2=new Vector();
        Encrypt et=new Encrypt();
        for(int j=0;j<u.size();j++)
        {
        	BigInteger zi=(BigInteger)u.get(j);
			BigInteger c2_temp=zi.modPow(k,p);
			temp_c2.add(c2_temp);
        }
	File_eg fe=new File_eg();

        //String string_message="";
        //int string_message=0;


       fe.f_read(filename,p,gre,u,temp_c2,k,encryptedFileName,c1);
        //int len=string_message.length();
        //for(int i=0;i<len;i++)
		//{


		//}

		/*int s=vector_c2.size();
        try
        {

        FileOutputStream out=new FileOutputStream(encryptedFileName);
        PrintStream prin= new PrintStream( out );
		for(int i=0;i<s;i++)
		{
			BigInteger vr=(BigInteger)vector_c2.get(i);
				prin.print (c1+" "+vr+" ");
                }
                //System.out.println("the encrypted file is ready");
                	//javax.swing.JOptionPane.showMessageDialog(null,"the encrypted file is ready");        // TODO add your handling code here:

		prin.close();
        }
        catch(Exception e)
        {
        	System.err.println ("An Error has occured while writing to file "+encryptedFileName);
        }*/
}


}