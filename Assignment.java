/**
  * Datatype used to hold grade information of assignment's for a course.
  *
  * @author Macallan Camara (Macinto5h)
  * @version 0.0.1, 12/19/2018
  */
public class Assignment{

  /*-----Fields-----*/
  private String name;
  private int pointsEarned;
  private int totalPoints;
  private boolean drop;
  private int weight;
  private AssignmentType assignType;

  /*-----Constructors-----*/
  /**
    * Default constructor takes no input parameters.
    */
  public Assignment(){
    this.setName("Unnamed Assignment");
    this.setPointsEarned(0);
    this.setTotalPoints(0);
    this.setDrop(true);
    this.setWeight(0);
    this.setAssignType(new AssignmentType()); //default constructor
  }

  /**
    * Constructor with all required parameters.
    *
    * @param name, the title for the assignment.
    * @param pointsEarned, total credit earned from assignment.
    * @param totalPoints, total possible points that can be earned for the assignment.
    * @param drop, decides if the assignment will count towards course grade.
    * @param weight, local influence the assignment has on the course grade.
    * @param assignType, used for classifaction and weight balancing.
    */
  public Assignment(String name, int pointsEarned, int totalPoints, boolean drop, int weight, AssignmentType assignType){
    this.setName(name);
    this.setPointsEarned(pointsEarned);
    this.setTotalPoints(totalPoints);
    this.setDrop(drop);
    this.setWeight(weight);
    this.setAssignType(assignType);
  }

  /*-----Class Methods-----*/
  /**
    * Get method for assignType.
    *
    * @return AssignmentType assignType.
    */
  public AssignmentType getAssignType(){
    return this.assignType;
  }

  /**
    * Get method for drop.
    *
    * @return boolean drop.
    */
  public boolean getDrop(){
    return this.drop;
  }

  /**
    * Get method for name.
    *
    * @return String name.
    */
  public String getName(){
    return this.name;
  }

  /**
    * Get method for pointsEarned.
    *
    * @return int pointsEarned.
    */
  public int getPointsEarned(){
    return this.pointsEarned;
  }

  /**
    * Get method for totalPoints.
    *
    * @return int totalPoints.
    */
  public int getTotalPoints(){
    return this.totalPoints;
  }

  /**
    * Get method for weight.
    *
    * @return int weight.
    */
  public int getWeight(){
    return this.weight;
  }

  /**
    * Set method for assignType.
    *
    * @param assignType.
    */
  public void setAssignType(AssignmentType assignType){
    this.assignType = assignType;
  }

  /**
    * Set method for drop.
    *
    * @param drop.
    */
  public void setDrop(boolean drop){
    this.drop = drop;
  }

  /**
    * Set method for name.
    *
    * @param name.
    */
  public void setName(String name){
    this.name = name;
  }

  /**
    * Set method for pointsEarned.
    *
    * @param pointsEarned.
    */
  public void setPointsEarned(int pointsEarned){
    this.pointsEarned = pointsEarned;
  }

  /**
    * Set method for totalPoints.
    *
    * @param totalPoints.
    */
  public void setTotalPoints(int totalPoints){
    this.totalPoints = totalPoints;
  }

  /**
    * Set method for weight.
    *
    * @param weight.
    */
  public void setWeight(int weight){
    this.weight = weight;
  }

  /*-----Object Inherited Methods-----*/
  /**
    * Prints the values held by the class, overrides Object class.
    *
    * @return A string featuring all private fields.
    */
  public String toString(){
    return "Assignment={" + this.getName() +", " + this.getPointsEarned() + ", "
    + this.getTotalPoints() + ", " + this.getDrop() + ", " + this.getWeight() +
    ", " + this.getAssignType().getTypeName() + "}";
  }

  /**
    * Main method used to test functionality of the class defined methods.
    *
    * @param args[]
    */
  public static void main(String args[]){
    System.out.println("Testing Assignment class");
    System.out.println("Test 1: Default Constructor");
    Assignment a = new Assignment();
    System.out.print("Result: ");
    System.out.println(a);
    System.out.println("Test 2: Specific value constructor");
    AssignmentType b = new AssignmentType("Exams",35);
    Assignment c = new Assignment("Homework 1",10,10,false,10,b);
    System.out.print("Result: ");
    System.out.println(c);
  }
}
