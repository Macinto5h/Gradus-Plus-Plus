/**
  * Main object used to hold course and its information.
  *
  * @author Macallan Camara (Macinto5h)
  * @version 0.0.1, 12/21/18
  */

import java.util.ArrayList;

public class Course{

  /*-----Fields-----*/
  private ArrayList<Assignment> assignments;
  private ArrayList<AssignmentType> assignTypes;
  private String name;
  private double totalGrade;

  /*-----Constructors-----*/
  /**
    * Default constructor, takes no input parameters.
    */
  public Course(){
    this.assignments = new ArrayList<Assignment>();
    this.assignTypes = new ArrayList<AssignmentType>();
    this.name = "Unnamed Class";
    this.totalGrade = 0;
  }

  /**
    * Constructor takes the name as the only input.
    *
    * @param name, the title of the course.
    */
  public Course(String name){
    this.assignments = new ArrayList<Assignment>();
    this.assignTypes = new ArrayList<AssignmentType>();
    this.name = name;
    this.totalGrade = 0;
  }

  /*-----Adders-----*/
  /** Adds assignment to the Course assignment arraylist.
    *
    * @param a, new assignment.
    */
  public void addAssignment(Assignment a){
    this.assignments.add(a);
  }

  /** Adds assignment type to the course arraylist.
    *
    * @param at, new assignment type.
    */
  public void addAssignmentType(AssignmentType at){
    this.assignTypes.add(at);
  }

  /*-----Getters-----*/
  /** Retrieves an AssignmentType for the course.
    *
    * @param index.
    * @return AssignmentType
    */
  public AssignmentType getAssignmentType(int index){
    return this.assignTypes.get(index);
  }

  public Assignment getAssignment(int index){
    return this.assignments.get(index);
  }

  /**
    * Retrieves the Total Grade of the course.
    * @return double totalGrade, calculated from Assignments in course.
    */
  public double getTotalGrade(){
    return totalGrade;
  }

  /*-----Size of Methods-----*/
  /** Returns the number of elements in the AssignmentType list.
    *
    * @return int, total elements in Arraylist of AssignmentTypes
    */
  public int sizeOfAssignTypes(){
    return this.assignTypes.size();
  }

  public int sizeOfAssignments(){
    return this.assignments.size();
  }

  /** Removes all Assignments from the course.
    *
    */
  public void clearAssignments(){
    assignments.clear();
  }

  /**Calculates the total grade based off values stored in field arrays.
    *
    */
  public void calculateTotalGrade(){
    totalGrade = 0;
    for (int i = 0; i < sizeOfAssignTypes(); i++){
      double totalWeight = 0;
      double sumRawGrade = 0;
      String assignName = getAssignmentType(i).getTypeName();
      double typeWeight = (double)getAssignmentType(i).getTypeWeight();
      for (int j = 0; j < sizeOfAssignments(); j++){
        String jAssignName = getAssignment(j).getAssignType().getTypeName();
        if (assignName.equals(jAssignName)){
          double pointsEarned = (double)getAssignment(j).getPointsEarned();
          double totalPoints = (double)getAssignment(j).getTotalPoints();
          double assignWeight = (double)getAssignment(j).getWeight();
          totalWeight += assignWeight;
          sumRawGrade += ((pointsEarned/totalPoints)*assignWeight);
        }
      }

      if(totalWeight != 0){
        totalGrade += ((sumRawGrade/totalWeight)*typeWeight);
      }
    }
  }
  /**
    * @return A String value containing information from all fields of this class.
    */
  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("Name: " + name + "\n");
    sb.append("TotalGrade: " + totalGrade + "\n");
    for (Assignment a : assignments){
      sb.append(a.toString() + "\n");
    }
    for (AssignmentType at : assignTypes){
      sb.append(at.toString() + "\n");
    }
    return sb.toString();
  }
}
