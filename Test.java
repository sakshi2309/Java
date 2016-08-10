import java.math.BigInteger;
 public class Test{
 	 public boolean testPrime(BigInteger n)  {

 	 	        int certainty = 20;
 	 	            boolean t=(n.isProbablePrime(certainty) ? true :false );
 	 	            return t;
 	 	            	}
 	 	            	public boolean comparePnG(BigInteger p,BigInteger gre)
 	 	            	{
 	 	            		if(gre.compareTo(p)>=0)
 	 	            			return false;
 	 	            			else
 	 	            				return true;
 	 	            	}
 	 	            	}
