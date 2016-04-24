
package expressions;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;


public class Test{
    public static void main(String[] args){
        Term testObject1 = new Term(2,3);
        Term testObject2 = new Term(1,7);
        Term testObject3 = new Term(-4,1);
        Term testObject4 = new Term(2,0);
        Term testObject5 = new Term(9,1);
        
        
        System.out.println("Term objects:");    
        System.out.println(testObject1.toString());
        System.out.println(testObject2.toString());
        System.out.println(testObject3.toString());
        System.out.println(testObject4.toString());
        System.out.println(testObject5.toString()); 
        System.out.println("");
        
        //ArrayList to store the polynomials read from the input file
        ArrayList<Polynomial> polynomialArray = new ArrayList<Polynomial>();
        
        
        
        //Read the input file containing polynomials line by line
        try{
        	  FileInputStream fstream = new FileInputStream("resources/polynomialInput.txt");
        	  
        	  DataInputStream in = new DataInputStream(fstream);
        	  BufferedReader br = new BufferedReader(new InputStreamReader(in));
        	  String strLine;
        	  
        	  while ((strLine = br.readLine()) != null){
        		  
        		  //ArrayList extracted by parsing the input file using the split method
        	      ArrayList<String> extArray = new ArrayList<String>(Arrays.asList(strLine.split(";")));
        	      Polynomial tempPolynomial = new Polynomial();
        	      
        	      //Convert each string elements to integer elements to store as terms of polynomial with coefficient and exponent
        	      for (int i = 1; i < extArray.size() - 1; i = i + 2){
        	        	int coefficient = Integer.parseInt(extArray.get(i));
        	        	int exponent = Integer.parseInt(extArray.get(i+1));
        	        	tempPolynomial.insertTerm(coefficient, exponent);
        	      }
        	       
        	      //Insert the polynomial in an ArrayList
        	      polynomialArray.add(tempPolynomial);
        	      System.out.println("Polynomial added to the arraylist!");
        	  }
    
        	  in.close();
              
        }
        catch (Exception e){
        	          System.err.println("Error: " + e.getMessage());
        }
        
        
        
        
       //Test cases and operations on each polynomial from the input file 
       for (Polynomial testPolynomial: polynomialArray){     
 
        
	        System.out.println("");
	        System.out.println("Polynomial from the input file:");
	        System.out.println(testPolynomial.getPolynomial());
	        System.out.println("");
	        
	        System.out.println("Deleting 5x^10");
	        testPolynomial.deleteTerm(5,10);
	        System.out.println("Polynomial after Deletion:");
	        System.out.println(testPolynomial.getPolynomial());
	        System.out.println("");
	        
	        System.out.println("Deleting -4");
	        testPolynomial.deleteTerm(-4,0);
	        System.out.println("Polynomial after Deletion:");
	        System.out.println(testPolynomial.getPolynomial());
	        System.out.println("");
	        
	        System.out.println("Polynomial in reverse order:");
	        System.out.println(testPolynomial.reversePolynomial()); 
	        
       }   
       
    }
    
    
}
