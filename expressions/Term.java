package expressions;

/*
 *  Term class that represents an algebraic expression.
 */

public class Term {
    
    //Term class has two fields.
    private int coefficient;
    private int exponent;
    
    /* 
     *  Constructor that creates a Term object. 
     *  @param coefficient   the coefficient of the Term object to be created
     *  @param exponent      the exponent of the Term object to be created
     */
    public Term(int coefficient, int exponent){
        this.coefficient = coefficient;
        this.exponent = exponent;
    }
    
    
    /* 
     *  Getter method for coefficient of the Term object. 
     *  @return coefficient      the coefficient of the Term object
     */
    public int getCoefficient(){
        return coefficient;
    }
    
    /* 
     *  Getter method for exponent of the Term object. 
     *  @return exponent   the exponent of the Term object
     */
    public int getExponent(){
        return exponent;
    }
    
    //
    //
    /* 
     *  Method to return the Term object in string format appropriately.
     *  Assuming coefficient is never 0. 
     *  @return     the concatenated string of coefficient, 'x^' and exponent of Term object
     */
    public String toString(){
    	
    	//Term with degree 0
        if (exponent == 0){
            return Integer.toString(coefficient);
        }
    
        //Term with degree 1
        else if (exponent == 1){
            if (coefficient == 1) {
                return "x";
            }
            else {
                return Integer.toString(coefficient) + "x";
            }
        }
        
        //Term with degree greater than 1 
        else {
        	if (coefficient == 1) {
        		return "x^" + Integer.toString(exponent);	
        	}
        	else {
                
        		return Integer.toString(coefficient) + "x^" + Integer.toString(exponent);
        	}
        }
            
    }

}