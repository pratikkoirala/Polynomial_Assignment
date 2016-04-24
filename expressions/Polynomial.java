package expressions;

import java.util.ArrayList;

public class Polynomial {
	
	private ArrayList<Term> myPolynomial;
    
	//Constructor that instantiates a Polynomial object with an empty ArrayList
	public Polynomial() {
		myPolynomial = new ArrayList<Term>();
	}
	
	//Insert method that adds new terms to the polynomial ArrayList in sorted order
	//Since the ArrayList is always almost sorted, time complexity is O(N)
    public void insertTerm(int coefficient, int exponent){
    	Term newTerm = new Term(coefficient, exponent);
    	myPolynomial.add(newTerm);
    	for(int i = 0; i < myPolynomial.size() - 1; i++){
    		int swap = 0;
    	    for(int j = 0; j < myPolynomial.size() - i - 1; j++){
    	    	if (myPolynomial.get(j).getExponent() < myPolynomial.get(j+1).getExponent()){
    	    		swap = 1;
    	    		Term tempObject = myPolynomial.get(j);
    	    		myPolynomial.set(j, myPolynomial.get(j+1));
    	    		myPolynomial.set(j+1, tempObject);
    	    	}
    	    }
    	    
    	    if (swap == 0){
    	    	return;
    	    }	
    	}
    }
    
    //Method to return all the terms in the polynomial in string format
    public String getPolynomial(){
    	String result = myPolynomial.get(0).toString() + " ";
    	for(int i = 1; i < myPolynomial.size(); i++){
    		if (myPolynomial.get(i).getCoefficient() > 0){
    			result += "+" + myPolynomial.get(i).toString() + " ";
    		}
    		else{
        	 result += myPolynomial.get(i).toString() + " ";
    		}  
    	}
    	return result;
    }
    
    //Method to delete a term from the polynomial
    public void deleteTerm(int coefficient, int exponent){
    	int index = -1;
    	for (int i = 0; i < myPolynomial.size(); i++){
    		if (myPolynomial.get(i).getExponent() == exponent && myPolynomial.get(i).getCoefficient() == coefficient){
    			index = i;
    		}
    	}
    	if (index == -1){
    		System.out.println("The term you tried to delete doesn't exist in the polynomial!");
    	}
    	else {
    		myPolynomial.remove(index);
    	}
    	
    }
    
    public String reversePolynomial(){
    	int last_index = myPolynomial.size() - 1;
    	String result = myPolynomial.get(last_index).toString() + " ";
    	for(int i = last_index - 1; i >= 0; i--){
    		if (myPolynomial.get(i).getCoefficient() > 0){
    			result += "+" + myPolynomial.get(i).toString() + " ";
    		}
    		
    		else{
        	 result += myPolynomial.get(i).toString() + " ";
    		}  
    	}
    	return result;
    }
    
    
    
    
    
    
}
