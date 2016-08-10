//package elgamelextension;
import java.io.*;
import java.math.BigInteger;
import java.util.Vector;
public class Decpt
{
	public BigInteger decr(Vector v,BigInteger c1_final,BigInteger p,BigInteger v_c2,BigInteger g) throws IOException,ClassCastException
	{






	BigInteger c1_c2=c1_final.multiply(v_c2);
	System.out.println("c1_c2 is "+c1_c2);
	BigInteger c1_c2_final=c1_c2.mod(p);
	System.out.println("c1_c2_final is "+c1_c2_final);

	return c1_c2_final;


	}

}