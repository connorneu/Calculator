package testing;
import java.util.Scanner;
import java.lang.Math; //----------> using this for the math.pow(x,y) = x^y

//Things working in this code
//1. Giving the right values of sine, cosecant and cosine functions.

//Problems in this code
//1. The Cosine function will execute values properly only upto certain loop iteration
//2. The value of Tangent will need to be done via the taylor/ mcclaurin series method or the value of sine and cosines will need to be mode more accurate
//3. The math.cos function is not giving the right value of cos for some reason
//4. The value of Secant function is incorrect for 90 degrees because it is infinity,
//   but it is giving a random value because the iterations is suppose to go for infinity (so maybe an "if" condition will solve the problem)
//5. Using the math.pow function for now, will need to implement the x^y function here instead.
public class TrigoFuncs {
	// ----------Converting Degrees to Radians----------
	
	public static double convert(double x){
		double radians;
		radians = (x*22)/(7*180);
		return radians;
	}
	
	//----------------Trigo Functions-------------------
	public static float SinFuncs(double x) {
		float sin=0.0f;
        long fact;
        for(int i=1; i<=10; i++){
            fact=1;
            for(int j=1; j<=2*i-1; j++){
                fact=fact*j;
            }
            if(i%2==1){
                sin=sin+(float)(Math.pow(x,2*i-1)/fact);
            }else{
                sin=sin-(float)(Math.pow(x,2*i-1)/fact);
            }
        }
        return sin;
		
	}
	
	
	
	public static float CosFuncs(double x) {
		float cos=1.0f;
        long fact;
        for(int i=1; i<=2; i++){  //---------------> if value of i is high(for more accurate value) like 10, the answer is incorrect
            fact=1;
            for(int j=1; j<=2*i; j++){
                fact=fact*j;
            }
            if(i%2==1){
                cos=cos-(float)(Math.pow(x,2*i)/fact);
            }else{
                cos=cos+(float)(Math.pow(x,2*i)/fact);
            }
        }
        return cos;
		
	}
	
	
	public static float TanFuncs(double x) {
		
        float numerator=SinFuncs(x);
        float denominator = CosFuncs(x);
        float tan = numerator/denominator;
        return tan;
		
	}
	
	public static float CoSecFuncs(double x) {

        float numerator=1;
        float denominator = SinFuncs(x);
        float CoSec = numerator/denominator;
        return CoSec;
		
	}
	public static float SecFuncs(double x) {
		float numerator=1;
        float denominator = CosFuncs(x);
        float CoSec = numerator/denominator;
        return CoSec;
		
	}
	
	public static float CotFuncs(double x) {
		float numerator=1;
        float denominator = TanFuncs(x);
        float Cot = numerator/denominator;
        return Cot;
				
	}
	
	//--------------------Main Function---------------------
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Angle :: ");
		
		double value= sc.nextDouble();
		
		sc.close();
		
		
		System.out.println("Value in Radians = " +convert(value));
		
		value=convert(value);
		
		System.out.println("Value of Sine = " + SinFuncs(value) + "  Value of Sine Using Math Functions =  " + Math.sin(1.57));
		
		System.out.println("Value of Cosine = " + CosFuncs(value) + "  Value of Cosine Using Math Functions =  " + Math.cosh(1.57));
		
		System.out.println("Value of Cosecant = " + CoSecFuncs(value) );
		
		/*
		System.out.println("Value of Tangent = " + TanFuncs(value) + "  Value of Tangent Using Math Functions =  " + Math.tan(1.57));
		*/
		
		
		//System.out.println("Value of Secant = " + SecFuncs(value) );
		//System.out.println("Value of Cot = " + CotFuncs(value));
		
	}
}
