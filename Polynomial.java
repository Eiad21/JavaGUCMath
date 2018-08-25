import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
/*This class can server as a replacement for the Vector class,
 * because Polynomials are a type of vector, the improvement here is that Arrays
 * are used instead of 3 Integers to allow for more or less components. The toString method
 * in this class could then be renamed to toPoly
 * thus making a the Polynomial aspect a sub-feature
 */
public class Polynomial {
	public int[] coef;
	int i = 0;
	//initialize a Polynomial using a particular Array of integers
	public Polynomial(int[] c) {
		coef = c;
		i=c.length;
	}
	//initialize a Polynomial using only its length
	public Polynomial(int n) {
		coef = new int[n];
	}
	/*this method is to add coefficients to the polynomial
	 *  in case the second constructor is used */
	public void addCo(int n) {
		if(i<coef.length)
			coef[i++] = n;
	}
	//add two Polynomials
	public static Polynomial polyAdd(Polynomial a,Polynomial b) {
		int maxLength = Math.max(a.coef.length, b.coef.length);
		int minLength = Math.min(a.coef.length, b.coef.length);
		Polynomial c = new Polynomial(maxLength);
		int i;
		for(i = 0;i<minLength;i++)
			c.coef[i] = a.coef[i]+b.coef[i];
		for(int m = i;m<a.coef.length;m++)
			c.coef[m] = a.coef[m];
		for(int m = i;m<b.coef.length;m++)
			c.coef[m] = b.coef[m];
		return c;
			
	}
	//subtract two Polynomials
	public static Polynomial polySub(Polynomial a,Polynomial b) {
		int maxLength = Math.max(a.coef.length, b.coef.length);
		int minLength = Math.min(a.coef.length, b.coef.length);
		Polynomial c = new Polynomial(maxLength);
		int i;
		for(i = 0;i<minLength;i++)
			c.coef[i] = a.coef[i]-b.coef[i];
		for(int m = i;m<a.coef.length;m++)
			c.coef[m] = a.coef[m];
		for(int m = i;m<b.coef.length;m++)
			c.coef[m] = -b.coef[m];
		return c;
			
	}
	//multiply a Polynomial by a scalar
	public Polynomial scalarMult(double n) {
		Polynomial res = new Polynomial(this.coef.length);
		for(int i=0;i<this.coef.length;i++)
			res.coef[i] = (int) (this.coef[i]*n);
		return res;
	}
	public String toString() {
		String output = "";
		int b = 0;
		//add the first coefficient (which doesn't need a plus)
		for(b = 0;b<coef.length;b++) {
			if(coef[b]!=0) {
				//taking care of when the powers should show
				if(b==0)
					output+=coef[b];
				else if(b==1)
					output+=coef[b]+"x";
				else
					output+=coef[b]+ "x^"+b;
				b++;
				break;
			}
		}
		//Remove unnecessary 1 coefficient
		if(output.length()>1&&output.charAt(0)=='1'&&output.charAt(1)=='x')
			output = output.substring(1);
		//add the rest of the coefficients (which need plus signs)
		for(int i = b;i<coef.length;i++) {
			//if the power is 1 we won't show the power
			if(coef[i]!=0&&i!=1)
				output = coef[i]+ "x^"+i+"+"+output;
			if(coef[i]!=0&&i==1)
				output = coef[i]+ "x"+"+"+output;
			//Remove unnecessary 1 coefficient
			if(output.length()>1&&output.charAt(0)=='1'&&output.charAt(1)=='x')
				output = output.substring(1);
		}
		return output;
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int nA = sc.nextInt();
		Polynomial p1 = new Polynomial(nA);
		for(int i = 0;i<nA;i++)
			p1.addCo(sc.nextInt());
		int nB = sc.nextInt();
		Polynomial p2 = new Polynomial(nB);
		for(int i = 0;i<nB;i++)
			p2.addCo(sc.nextInt());
		Polynomial p3 = polySub(p1, p2);
		System.out.println(p3);
	}
}
