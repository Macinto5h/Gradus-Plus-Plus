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
  private int totalGrade;

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
    * @param String name, the title of the course.
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
    * @param Assignment a, new assignment.
    */
  public void addAssignment(Assignment a){
    this.assignments.add(a);
  }

  /** Adds assignment type to the course arraylist.
    *
    * @param AssignmentType at, new assignment type.
    */
  public void addAssignmentType(AssignmentType at){
    this.assignTypes.add(at);
  }

  /*-----Getters-----*/
  /** Retrieves an AssignmentType for the course.
    *
    * @param int index.
    * @return AssignmentType
    */
  public AssignmentType getAssignmentType(int index){
    return this.assignTypes.get(index);
  }

  public Assignment getAssignment(int index){
    return this.assignments.get(index);
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
}
