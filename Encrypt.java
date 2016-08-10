//package elgamelextension;
import java.math.BigInteger;
import java.security.*;
import java.util.Vector;
import java.util.*;
import java.io.*;
import javax.swing.*;
class Encrypt
{



	public BigInteger en(BigInteger p,BigInteger g,int users,BigInteger k,Vector u,int mg,Vector temp_c2) throws IOException,ClassCastException,ArithmeticException
	{
		//int users=u.size();
		BigInteger ans;
			Vector c22=new Vector();
	//	javax.swing.JOptionPane.showMessageDialog(null,"the message is in Encrypt "+mg);        // TODO add your handling code here:
	BigInteger msg=BigInteger.valueOf(mg);

			BigInteger bc22,cc22,dc22,ec22,dc22_1,dc22_2;

			for(int i=0;i<users;i++)
			{
				BigInteger mw=(BigInteger)temp_c2.get(i);
				bc22=mw.multiply(msg);
				dc22=bc22.mod(p);
				c22.add(dc22);

			}

		BigInteger c=BigInteger.valueOf(1);
		BigInteger d=BigInteger.valueOf(1);
		for(int i=0;i<users;i++)
		{
			if(i%2==0)
			{

				c=c.multiply((BigInteger)c22.get(i));
			}
			else
			{
				d=d.multiply((BigInteger)c22.get(i));
			}
		}


	   BigInteger x=d.modInverse(p);
 	   BigInteger t=c.mod(p) ;

 	   BigInteger ans1=t.multiply(x);
 	   ans=ans1.mod(p);
	//	javax.swing.JOptionPane.showMessageDialog(null,"the ans in Encrypt is  "+ans);        // TODO add your handling code here:
 	   return ans;



	}



}