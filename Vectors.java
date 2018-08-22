import java.util.Arrays;

public class Vectors  {
	//Dimenisons of a vector
	double x;
	double y;
	double z;
	Vectors zeroVector = new Vectors(0,0,0);
	
 public Vectors(double x, double y, double z) {
	 this.x = x;
	 this.y = y;
	 this.z = z;
	 
 }
 //Add Vectors
 public static Vectors AddVectors(Vectors v1,Vectors v2) {
	 double newx = v1.x + v2.x;
	 double newy = v1.y + v2.y;
	 double newz = v1.z +v2.z;
	 Vectors newVector = new Vectors(newx,newy,newz);
	 return  newVector;
 }
 
 //Substract Vectors
 public static Vectors SubtractVectors(Vectors v1, Vectors v2) {
	 double newx = v1.x - v2.x;
	 double newy = v1.y - v2.y;
	 double newz = v1.z - v2.z;
	 Vectors newVector = new Vectors(newx,newy,newz);
	 return  newVector;
	 
 }
 // Dot Product
 public static double DotProduct(Vectors v1, Vectors v2) {
	 return v1.x*v2.x + v1.y*v2.y + v1.z*v2.z ; 
	 
 }
 
 //Angle Between Vectors 
 
 public static void  AngleBetween(Vectors v1, Vectors v2) {
	 if(v1.iszeroVector() || v2.iszeroVector()) {
		 System.out.print("0 degress");
	 }
	 else {
		 double degree = Math.acos((DotProduct(v1,v2))/(v1.getMagnitude()*v2.getMagnitude()));
		 System.out.println("The degree between two vectors is" + degree);
		 
	 }
 }
 //Scalar Multiplication
 
 
 public Vectors ScalarMultiply(double n) {
	 Vectors newvec = new Vectors(n*this.x, n*this.y, n*this.z);
	 return newvec; 
 }
 
 //Get Magnitude
 public double getMagnitude() {
	 double magnitude = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z,2));
	 return magnitude;
 }
 
 //Get Direction
private boolean iszeroVector() {
	
	if(this.x ==0 && this.y ==0 && this.z == 0) {
		return true;
	}
	else {
		return false;
	}
}


    //Normalization
public Vectors getDirection() {
	if(!this.iszeroVector()) {
		double mag = 1/this.getMagnitude();
		return this.ScalarMultiply(mag);
		
	}
	else {
		return zeroVector;
	}
	 
}


private boolean isScalarProduct() {
	if()
	return true;
}
public boolean isParallel(Vectors v1) {
	if
}

 
 

 
 //@Overriding of toStringMehtod
public String toString() {
String x = "X component is: " + this.x + "   Y component is : " + this.y + "   Z component is : " + this.z;
	return x;
}
 
 public static void main(String[] args) {
	 Vectors v1 = new Vectors(2,1,3);
	 Vectors v2 = new Vectors(1,1,1);
	 
 }
	
	
}
