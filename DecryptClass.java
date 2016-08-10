
import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.Vector;

public class DecryptClass {

public void decryptMethod(BigInteger p,BigInteger gre,String decryptedFileName,String encryptFile,Vector vr) throws IOException,ClassCastException
{

		int parts;
		BigInteger dec;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try
		{
			FileOutputStream fos = new FileOutputStream(decryptedFileName);
			OutputStreamWriter osw =new OutputStreamWriter(fos);
        PrintWriter pw = new PrintWriter(osw);
	//Writer out = new OutputStreamWriter(fos, "UTF8");

		/*FileOutputStream deout=new FileOutputStream(decryptedFileName);
        PrintStream deprin=new PrintStream(deout);*/
			File fi=new File(encryptFile);
			Scanner sc = new Scanner(fi);
			BigInteger decpt_c1=sc.nextBigInteger();
			//System.out.println("decpt_c1 is "+decpt_c1);
			int size1=vr.size();

	int i;
	BigInteger c1_even,c1_odd,c1_combined,c1_final;
	BigInteger decrypt_mult2=BigInteger.valueOf(1);
	BigInteger decrypt_mult1=BigInteger.valueOf(1);
	BigInteger check1=BigInteger.valueOf(1);
	BigInteger check2=BigInteger.valueOf(1);
	for(i=0;i<size1;i++)
	{

		if(i%2==0)
		{
			decrypt_mult2=decpt_c1.modPow((BigInteger)vr.get(i),p);
			check1=check1.multiply(decrypt_mult2);
			check1=check1.mod(p);
			//System.out.println("for i= "+i+" the decrypt_mult2 is "+decrypt_mult2+" and check1 is "+check1);


		}
		else
		{
			decrypt_mult1=decpt_c1.modPow((BigInteger)vr.get(i),p);
			check2=check2.multiply(decrypt_mult1);
			check2=check2.mod(p);
			//System.out.println("for i= "+i+" the decrypt_mult1 is "+decrypt_mult1+" and check2 is "+check2);

		}

	}
	c1_odd=check1.modInverse(p);
	//System.out.println("c1_odd is "+c1_odd);
	c1_even=check2.mod(p);
	//System.out.println("c1_even is "+c1_even);
	c1_combined=c1_even.multiply(c1_odd);
	//System.out.println("c1_combined is "+c1_combined);
	c1_final=c1_combined.mod(p);
	//System.out.println("c1_final is "+c1_final);
			Decpt de=new Decpt();
			int we=0;
			while (sc.hasNextBigInteger())
				{

          BigInteger decpt_c2 = sc.nextBigInteger();
      //    System.out.println("decpt_c2 is "+decpt_c2);
          if(we%2==0)
          {

          dec= de.decr(vr,c1_final,p,decpt_c2,gre);
          //System.out.println("the value returned after decryption is "+dec);
          int dec_i=dec.intValue();
        //  System.out.println("dec_i is "+dec_i);
		char dec_c=(char)dec_i;
		//System.out.println("dec_c is "+dec_c);
				pw.print(dec_c);
          }
          we++;
			}


        //System.out.println("decrypt_file.txt is written")	;
			pw.close();
		}
		catch(Exception e)
		{
		//	System.err.println ("Error writing to file");
javax.swing.JOptionPane.showMessageDialog(null,"error writing to file");        // TODO add your handling code here:
		}
}


}