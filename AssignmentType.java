/**
  * Datatype used to define an Assignment's specific weight contribution to course
  *
  * @author Macallan Camara (Macinto5h)
  * @version 0.0.1, 12/18/2018
  */

public class AssignmentType{
  /*-----Fields-----*/
  private int typeWeight;
  private String typeName;

  /*-----Constructors-----*/
  /**
    * Default constructor for the AssignmentType class. Takes no parameters.
    */
  public AssignmentType (){
    this.setTypeWeight(0);
    this.setTypeName("Unnamed Type");
  }

  /**
    * Constructor that defines the class fields using its input. Takes two
    * parameters: typeWeight and typeName.
    *
    * @param int typeWeight, sets the AssignmentType weight for the overall course.
    * @param String typeName, name associated with the assignment type, ex. Quizzes.
    */
  public AssignmentType(String typeName, int typeWeight){
    this.setTypeName(typeName);
    this.setTypeWeight(typeWeight);
  }

  /*-----Class Methods-----*/
  /**
    * Get method for the field typeName.
    *
    * @return String this.typeName.
    */
  public String getTypeName(){
    return this.typeName;
  }

  /**
    * Get method for the field typeWeight.
    *
    * @return int this.typeWeight.
    */
  public int getTypeWeight(){
    return this.typeWeight;
  }

  /**
    * Set method for the field typeName.
    *
    * @param String typeName, new value for the typeName field.
    */
  public void setTypeName(String typeName){
    this.typeName = typeName;
  }

  /**
    * Set method for the field typeWeight.
    *
    * @param int typeWeight, new value for the typeWeight field.
    */
  public void setTypeWeight(int typeWeight){
    this.typeWeight = typeWeight;
  }

  /*-----Object Inherited Methods-----*/
  /**
    * Prints the values held by the class, overrides Object class.
    *
    * @return A string featuring the typeName and typeWeight.
    */
  public String toString(){
    return "An AssignmentType object with values typeName = " +
    this.getTypeName() + " typeWeight = " + this.getTypeWeight();
  }

  /**
    * Main method used to test functionality of the class defined methods.
    *
    * @param String args[]
    */
  public static void main(String args[]){
    System.out.println("Testing AssignmentType class");
    System.out.println("Test 1: Default Constructor");
    AssignmentType a = new AssignmentType();
    System.out.print("Result: ");
    System.out.println(a);
    System.out.println("Test 2: Specific value constructor");
    AssignmentType b = new AssignmentType("Exams",35);
    System.out.print("Result: ");
    System.out.println(b);
  }

}
