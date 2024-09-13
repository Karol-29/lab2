import java.util.TreeMap;

/** Relational Calculator
 * 
 * @author CIS 2024-02
 */
    
public class RelationalCalculator{
    
    private TreeMap<String, Relation> variables;
    
    public RelationalCalculator(){
    }


    //Assign a empty relation to a variable
    public void assign(String name, String attributes[] ){
    }    
    
    //Assigns the result of an operation to a variable (unary operations)
    // a := unary tuple
    // The unary operators are: i (nsert), d (elete)
    //If this is not possible, the variable a does not change
    public void update(String a, char unary, String[] tuple){
    }    
    
    
    //Assigns the result of an operation to a variable
    // a := b operator c
    //The operators are: p(roject), s(elect), m(ultiply)
    //To project, the relation b is projected with the attributes of the relation c. 
    //To select, the tuples of relation b are selected using as condition the expression that corresponds to matching the attributes of c with the values of his first tuple
    //To multiply, the relation a is multiplied with the relation b. 
    //If this is not possible, the variable a does not change
    public void assign(String a, String b, char operator, String c){
    }   
    
    //Consult the variables of a calculator
    public String[] variables(){
        return null;
    }    
           
    //Returns the string represention of a relation. Columns must be aligned.
    public String toString(String variable){
        return null;
    }
    
    //If the last operation was successful
    public boolean ok(){
        return false;
    }
}
    



