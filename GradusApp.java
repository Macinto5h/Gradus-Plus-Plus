/**
  * GUI interface and main class for Gradus++
  *
  * @author Macallan Camara (Macinto5h)
  * @version 0.0.1, 12/23/18
  */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class GradusApp implements ActionListener{
  /*-----Fields-----*/
  private Course course;
  private JLabel jlab;
  private JTable jtab0, jtab1; //0 is primary table, 1 is for assignment types
  private DefaultTableModel dModel0, dModel1;
  private JScrollPane jsp0, jsp1;
  private JFrame jfrm;
  private JMenuItem jmiNew, jmiOpen, jmiClose, jmiSave, jmiExit, jmiAddCol;
  private JMenuItem jmiEntAT, jmiAddModify, jmiEnterAssign, jmiCalcGrade;

  /**
    * Constructor for the class. Builds the application gui.
    */
  public GradusApp(){
    //Create a new JFrame Container
    jfrm = new JFrame("Gradus++ v0.0.1");

    Image icon = Toolkit.getDefaultToolkit().getImage("g++.gif");
    jfrm.setIconImage(icon);


    //Specify FlowLayout for the layout manager.
    jfrm.setLayout(new FlowLayout());

    //Give the frame an initial size.
    jfrm.setSize(300,400);

    //Terminate the program when the user closes the application.
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Create a label that will display the menu selection.
    this.jlab = new JLabel();

    //Create the menu bar
    JMenuBar jmb = new JMenuBar();

    //Create the File Menu.
    JMenu jmFile = new JMenu("File");
    jmiNew = new JMenuItem("New");
    jmiOpen = new JMenuItem("Open");
    jmiClose = new JMenuItem("Close");
    jmiSave = new JMenuItem("Save");
    jmiExit = new JMenuItem("Exit");
    jmFile.add(jmiNew);
    jmFile.add(jmiOpen);
    jmFile.add(jmiClose);
    jmFile.add(jmiSave);
    jmFile.addSeparator();
    jmFile.add(jmiExit);

    jmiNew.setEnabled(true);
    jmiOpen.setEnabled(true);
    jmiClose.setEnabled(false);
    jmiSave.setEnabled(false);
    jmiExit.setEnabled(true);

    jmb.add(jmFile);

    //Create the Edit Menu.
    JMenu jmEdit = new JMenu("Edit");
    jmiAddCol = new JMenuItem("Add Column");
    jmiEntAT = new JMenuItem("Enter Assignment Types");
    jmiAddModify = new JMenuItem("Add/Modify Assignment Types");
    jmiEnterAssign = new JMenuItem("Enter Assignments");
    jmiCalcGrade = new JMenuItem("Calculate Total Grade");
    jmiAddCol.setEnabled(false);
    jmiEntAT.setEnabled(false);
    jmiAddModify.setEnabled(true);
    jmiEnterAssign.setEnabled(false);
    jmiCalcGrade.setEnabled(false);
    jmEdit.add(jmiAddCol);
    jmEdit.addSeparator();
    jmEdit.add(jmiAddModify);
    jmEdit.add(jmiEntAT);
    jmEdit.addSeparator();
    jmEdit.add(jmiEnterAssign);
    jmEdit.add(jmiCalcGrade);
    jmb.add(jmEdit);

    //Add action listeners for the menu items.
    jmiNew.addActionListener(this);
    jmiOpen.addActionListener(this);
    jmiClose.addActionListener(this);
    jmiSave.addActionListener(this);
    jmiExit.addActionListener(this);
    jmiAddCol.addActionListener(this);
    jmiEntAT.addActionListener(this);
    jmiAddModify.addActionListener(this);
    jmiEnterAssign.addActionListener(this);
    jmiCalcGrade.addActionListener(this);

    //Add the label to the content pane
    jfrm.add(jlab);

    //Add the menu bar to the frame
    jfrm.setJMenuBar(jmb);

    //Code used for the JTable jtab...
    //DefaultTableModel allows dynamic removal of rows and columns
    this.dModel0 = new DefaultTableModel();
    this.jtab0 = new JTable(this.dModel0);

    this.dModel0.addColumn("Name");
    this.dModel0.addColumn("Points Earned");
    this.dModel0.addColumn("Total Points");
    this.dModel0.addColumn("Drop");
    this.dModel0.addColumn("Weight");
    this.dModel0.addColumn("Assignment Type");

    //Add it to JScrollPane
    this.jsp0 = new JScrollPane(this.jtab0);
    this.jsp0.setVisible(false);
    jfrm.add(this.jsp0);

    //Create JTable for AssignmentTypes
    this.dModel1 = new DefaultTableModel();
    this.jtab1 = new JTable(this.dModel1);

    this.dModel1.addColumn("Type");
    this.dModel1.addColumn("Percentage");

    this.jsp1 = new JScrollPane(this.jtab1);
    this.jsp1.setVisible(false);
    jfrm.add(this.jsp1);

    //Display the frame
    jfrm.setVisible(true);
    this.course = new Course();
  }

  //Handle menu item action events.
  public void actionPerformed(ActionEvent ae){
    //Get the action command from the menu selection
    String comStr = ae.getActionCommand();

    //If user chooses exit, then exit the program.
    if (comStr.equals("Exit")){
      System.exit(0);
    //Adds new column
    }else if(comStr.equals("Add Column")){
      if (jsp0.isVisible()){
        this.dModel0.addRow(new Object[]{"","","","","",""});
      } else {
        this.dModel1.addRow(new Object[]{"",""});
      }
    }else if(comStr.equals("New")){
      loadAssignmentTypeTable();
    }else if(comStr.equals("Enter Assignment Types")){
      addAssignTypes();
    }else if(comStr.equals("Add/Modify Assignment Types")){
      loadAssignmentTypeTable();
    }else if(comStr.equals("Enter Assignments")){
      addAssignments();
    }else if(comStr.equals("Calculate Total Grade")){
      course.calculateTotalGrade();
      jlab.setText("Total Grade: " + course.getTotalGrade()); //Make getTotalGrade Method.
      System.out.println(course);
    }else{
      jlab.setText(comStr + " Selected");
    }
  }

  /** Function used to add and modify Assignment Types for the course.
    *
    */
  private void loadAssignmentTypeTable(){
    //System.out.println("loadAssignmentTypeTable method called!");
    jsp0.setVisible(false);
    jsp1.setVisible(true);
    jmiNew.setEnabled(true);
    jmiOpen.setEnabled(true);
    jmiSave.setEnabled(false);
    jmiClose.setEnabled(false);
    jmiExit.setEnabled(true);
    jmiAddCol.setEnabled(true);
    jmiEntAT.setEnabled(true);

    jfrm.validate();
  }

  /** Function used to take values from AssignType Table and apply into course object.
    *
    */
  private void addAssignTypes(){
    int totalRows = dModel1.getRowCount();
    if (totalRows <= 0){
      //Have a message print error no types were entered.
    }else{
      for(int j = 0; j < totalRows + 0; j++){
        String name = (String) dModel1.getValueAt(j,0);
        int weight = Integer.parseInt((String)dModel1.getValueAt(j,1));
        course.addAssignmentType(new AssignmentType(name,weight));
      }
      jsp0.setVisible(true);
      jsp1.setVisible(false);
      jmiNew.setEnabled(true);
      jmiOpen.setEnabled(true);
      jmiSave.setEnabled(true);
      jmiClose.setEnabled(true);
      jmiExit.setEnabled(true);
      jmiAddCol.setEnabled(true);
      jmiEntAT.setEnabled(false);
      jmiEnterAssign.setEnabled(true);

      jfrm.validate();
    }

  }

  /**Function has the same concept as addAssignTables but using the other table.
    *
    */
  private void addAssignments(){
    course.clearAssignments();
    int totalRows = dModel0.getRowCount();
    if (totalRows <= 0){
      //Have a message print error no types were entered.
    }else{
      for (int i = 0; i < totalRows; i++){
        String name = (String) dModel0.getValueAt(i,0);
        int pointsEarned = Integer.parseInt((String)dModel0.getValueAt(i,1));
        int totalPoints = Integer.parseInt((String)dModel0.getValueAt(i,2));
        boolean drop = Boolean.parseBoolean((String)dModel0.getValueAt(i,3));
        int weight = Integer.parseInt((String)dModel0.getValueAt(i,4));
        String assignTypeName = (String) dModel0.getValueAt(i,5);
        AssignmentType assignType = new AssignmentType();
        boolean assignTypeRec = false;
        for (int j = 0; j < course.sizeOfAssignTypes(); j++){
          //System.out.println("addAssignment Compare 1:" + course.getAssignmentType(j).getTypeName());
          //System.out.println("addAssignment Compare 2" + assignTypeName);
          if (course.getAssignmentType(j).getTypeName().equals(assignTypeName)){
            assignType = course.getAssignmentType(j);
            assignTypeRec = true;
            break;
          }
        }

        if (assignTypeRec){
          course.addAssignment(new Assignment(name,pointsEarned,totalPoints,drop,weight,assignType));
        }

        //System.out.println(name);
      }
      jmiCalcGrade.setEnabled(true);
    }
  }

  public static void main(String args[]){
    //Create the fram on the event dispatching thread.
    SwingUtilities.invokeLater(new Runnable(){
      public void run(){
        new GradusApp();
      }
    });
  }
}
