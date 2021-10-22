public class Rational {
    // instance variables: every Rational object will have its own copy
    // of these variables
    public int numerator;
    public int denominator;
    
    /**
     * Constructor: the special method that will actually create a new Rational
     * object
     * Constructors are always public
     * Constructors have the same name as the class
     * Constructors have no return type
     */
    public Rational(int a, int b) {
        numerator = a;
        denominator = b;
    }
    
    // This method takes two Rationals, add them up,
    // and returns a Rational equal to the sum
    // You will need to:
    // 1) Calculate the value of the new numerator
    // 2) Calculate the value of the new denominator
    // 3) Create a new Rational variable with the two above values
    // 4) Return your new Rational variable
    // (When you write the simplify method later on, you should
    // also call it in this method to return the simplified result)
    public static Rational add(Rational r, Rational s) {
        int a = r.numerator;
        int b = r.denominator;
        int x = s.numerator;
        int y = s.denominator;

        int newNumerator = (a*y) + (x*b);
        int newDenominator = b*y;

        Rational newRational = new Rational(newNumerator, newDenominator);
        return simplify(newRational);
    }

    // This method takes two Rationals, subtracts thems up, 
    // and returns a Rational equal to the difference
    public static Rational subtract(Rational r, Rational s) {
        int a = r.numerator;
        int b = r.denominator;
        int x = s.numerator;
        int y = s.denominator;

        int newNumerator = (a*y) - (x*b);
        int newDenominator = b*y;

        Rational newRational = new Rational(newNumerator, newDenominator);
        return simplify(newRational);
    }
    
    public static Rational multiply(Rational r, Rational s) {
        int a = r.numerator;
        int b = r.denominator;
        int x = s.numerator;
        int y = s.denominator;

        int newNumerator = a*x;
        int newDenominator = b*y;

        Rational newRational = new Rational(newNumerator, newDenominator);
        return simplify(newRational);
    }
    
    public static Rational divide(Rational r, Rational s) {
        int a = r.numerator;
        int b = r.denominator;
        int x = s.numerator;
        int y = s.denominator;

        int newNumerator = a*y;
        int newDenominator = b*x;

        Rational newRational = new Rational(newNumerator, newDenominator);
        return simplify(newRational);
    }

    // Finds the greatest common factor between a and b
    // To find the greatest common factor, find the largest number x
    // such that a and b are both multiples of x
    public static int greatestCommonFactor(int numerator, int denominator)
    {
        while (numerator != 0 && denominator != 0){
            if (numerator >= denominator){
                numerator -= denominator;
            }else{
                denominator -= numerator;
            }
        }
        if (numerator == 0){
            return denominator;
        }else{
            return numerator;
            }
        }

    public static void main(String[] args) {
        System.out.println(greatestCommonFactor(30,132));
    }

    // This method is given a rational, and returns a simplified version
    // of the input rational
    // Use the greatestCommonFactor method here
    // e.g. simplify(2/4) => 1/2
    //      simplify(1/2) => 1/2
    public static Rational simplify(Rational r) {
        int a = r.numerator;
        int b = r.denominator;
        int newNumerator = a/(greatestCommonFactor(a,b));
        int newDenominator = b/(greatestCommonFactor(a,b));

        Rational newRational = new Rational(newNumerator, newDenominator);
        return newRational;
    }

    // This following method is NOT static, we'll talk about it next class!
    // This returns a string representation of a Rational (e.g. "1/2")
    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }
}













