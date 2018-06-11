//Elizabeth Vasilia Evans
//eve9du
//Homework5


import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;






//Sources:https://docs.oracle.com/javase/7/docs/api/javax/swing/JList.html
//https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
//https://docs.oracle.com/javase/7/docs/api/javax/swing/JComboBox.html
//https://docs.oracle.com/javase/7/docs/api/javax/swing/JScrollPane.html






public class GPACalculator extends JFrame {


	DefaultListModel dm = new DefaultListModel();
	DefaultListModel dm2 = new DefaultListModel();
	DefaultListModel dm3 = new DefaultListModel();
	public double currGPA;
	double totalGradePoints = 0.0;
	double totalCreditHours = 0.0;
	int blankCreditHours = 0;
	JLabel courses;
	JLabel summary;
	JLabel grade;
	JLabel credits;
	JLabel courseName;
	JLabel current;
	JLabel past;
	JLabel anticipated;
	JButton addPast;
	JButton addCurrent;
	JButton addAnticipated;
	JComboBox<String> grades = new JComboBox<String>();
	ArrayList <String> courseList;
	JButton remove;
	JButton remove2;
	JButton remove3;
	JButton clear;
	JButton clear2;
	JButton clear3;
	JButton add15;
	JLabel currentGPA;
	JLabel targetGPA;
	JLabel requiredGPA;
	JTextArea enterCredits;
	JTextArea enterName;
	JTextArea enterTarget;
	JButton calculate;
	JLabel currentGPAResult;
	JLabel requiredGPAResult;
	JLabel errorMessage;
	HashMap<String, Double> values = new HashMap<String, Double>();
	JList jList1;
	JList jList2;
	JList jList3;
	private static final Pattern DEFAULT_VALUE_PATTERN = Pattern.compile("Grade: (.*?), Name of Class: ");
	private static final Pattern DEFAULT_VALUE_PATTERN2 = Pattern.compile("Credits: (.*?), Grade: ");




	public static void main(String[] args) {
		new GPACalculator();
	}

	public GPACalculator()
	{
		///INITIALIZING VARIABLES

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		this.setSize(width, height);
		grades.addItem("--");
		grades.addItem("A");
		grades.addItem("A-");
		grades.addItem("B+");
		grades.addItem("B");
		grades.addItem("B-");
		grades.addItem("C+");
		grades.addItem("C");
		grades.addItem("C-");
		grades.addItem("D+");
		grades.addItem("D");
		grades.addItem("D-");
		grades.addItem("F");
		values.put("A", new Double(4.0));
		values.put("A-", new Double(3.7));
		values.put("B+", new Double(3.3));
		values.put("B", new Double(3.0));
		values.put("B-", new Double(2.7));
		values.put("C+", new Double(2.3));
		values.put("C", new Double(2.0));
		values.put("C-", new Double(1.7));
		values.put("D+", new Double(1.3));
		values.put("D", new Double(1.00));
		values.put("D-", new Double(0.7));
		values.put("F", new Double(0.0));
		courses = new JLabel("Courses");
		courses.setFont(new Font("Times", Font.BOLD, 40));
		summary = new JLabel("Summary");
		summary.setFont(new Font("Times", Font.BOLD, 40));
		current = new JLabel("Current Classes:");
		current.setFont(new Font("Times", Font.BOLD, 20));
		past = new JLabel("Past Classes:");
		past.setFont(new Font("Times", Font.BOLD, 20));
		anticipated = new JLabel("Anticipated Classes:");
		anticipated.setFont(new Font("Times", Font.BOLD, 20));
		courseList = new  ArrayList <String>();
		addPast = new JButton("Add Past Course");
		addCurrent = new JButton("Add Current Course");
		addAnticipated = new JButton("Add Anticipated Course");
		add15 = new JButton("Add 15 blank credits");
		remove = new JButton("Remove");
		errorMessage = new JLabel("");
		remove2 = new JButton("Remove");
		remove3 = new JButton("Remove");
		clear = new JButton("Clear");
		clear2 = new JButton("Clear");
		clear3 = new JButton("Clear");
		grade = new JLabel("Grade:");
		grade.setFont(new Font("Times", Font.BOLD, 20));
		credits = new JLabel("Credits:*");
		credits.setFont(new Font("Times", Font.BOLD, 20));
		courseName = new JLabel("Name of Course:");
		courseName.setFont(new Font("Times", Font.BOLD, 20));
		enterCredits = new JTextArea();
		enterName = new JTextArea();
		currentGPA = new JLabel("Current GPA:");
		currentGPA.setFont(new Font("Times", Font.BOLD, 20));
		targetGPA = new JLabel("Enter your target GPA below to see what GPA you need next semester to achieve it!");
		targetGPA.setFont(new Font("Times", Font.ITALIC, 18));
		requiredGPA =new JLabel("Required GPA:");
		requiredGPA.setFont(new Font("Times", Font.BOLD, 20));
		enterTarget = new JTextArea();
		calculate = new JButton("Calculate my required GPA");
		currentGPAResult = new JLabel("");
		currentGPAResult.setFont(new Font("Times", Font.BOLD, 20));
		requiredGPAResult = new JLabel("");
		requiredGPAResult.setFont(new Font("Times", Font.BOLD, 20));
		jList1 = new JList(courseList.toArray());
		jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scroll = new JScrollPane(jList1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setViewportView(jList1);
		jList2 = new JList(courseList.toArray());
		jList2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scroll2 = new JScrollPane(jList2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll2.setViewportView(jList2);
		jList3 = new JList(courseList.toArray());
		jList3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scroll3 = new JScrollPane(jList3,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll3.setViewportView(jList3);


		//SETTING SIZE

		grades.setSize(width/10, 30);
		errorMessage.setSize(width/10, 30);
		addPast.setSize(width/8, 40);
		addCurrent.setSize(width/8, 40);
		addAnticipated.setSize(width/8, 40);
		add15.setSize(width/10, 30);
		remove.setSize(width/15, 30);
		remove2.setSize(width/15, 30);
		remove3.setSize(width/15, 30);
		clear.setSize(width/15, 30);
		credits.setSize(width/10, 30);
		grade.setSize(width/10, 30);
		courseName.setSize(width/10, 30);
		enterCredits.setSize(width/10, 30);
		enterName.setSize(10*width/32, 30);
		courses.setSize(width/10, 30);
		summary.setSize(width/10, 45);
		currentGPA.setSize(width/10, 30);
		targetGPA.setSize(width/2, 45);
		requiredGPA.setSize(width/10, 30);
		enterTarget.setSize(width/10, 30);
		calculate.setSize(width/10, 30);
		currentGPAResult.setSize(width/10, 30);
		requiredGPAResult.setSize(width/2, 30);
		jList1.setSize(11*width/70, 100);
		scroll.setSize(11*width/70, 100);
		jList2.setSize(11*width/70, 100);
		scroll2.setSize(11*width/70, 100);
		jList3.setSize(11*width/70, 100);
		scroll3.setSize(11*width/70, 100);
		clear2.setSize(width/15, 30);
		clear3.setSize(width/15, 30);
		past.setSize(width/10, 30);
		current.setSize(width/10, 30);
		anticipated.setSize(width/8, 30);


		//SETTING LOCATION

		grades.setLocation(6*width/17, 12*height/30);
		addPast.setLocation(4*width/50, height/2);
		addCurrent.setLocation(12*width/50, height/2);
		addAnticipated.setLocation(20*width/50, height/2);
		add15.setLocation(11*width/50, 5*height/30);
		remove.setLocation(16*width/100, 40*height/50);
		remove2.setLocation(16*width/50, 40*height/50);
		remove3.setLocation(49*width/100, 40*height/50);
		clear.setLocation(8*width/100, 40*height/50);
		credits.setLocation(width/15,12*height/30);
		errorMessage.setLocation(width/15,13*height/30);
		grade.setLocation(5*width/17,12*height/30);
		courseName.setLocation(width/15,10*height/30);
		enterCredits.setLocation(2*width/15,12*height/30);
		enterName.setLocation(9*width/60,10*height/30);
		courses.setLocation(11*width/50,height/10);
		summary.setLocation(10*width/15,height/10);
		currentGPA.setLocation(18*width/30,10*height/30);
		targetGPA.setLocation(18*width/30,24*height/60);
		requiredGPA.setLocation(18*width/30,17*height/30);
		enterTarget.setLocation(18*width/30,28*height/60);
		calculate.setLocation(22*width/30,28*height/60);
		currentGPAResult.setLocation(22*width/30,10*height/30);
		requiredGPAResult.setLocation(22*width/30,17*height/30);
		jList1.setLocation(4*width/50,35*height/50);
		scroll.setLocation(4*width/50,35*height/50);
		jList2.setLocation(12*width/50,35*height/50);
		scroll2.setLocation(12*width/50,35*height/50);
		jList3.setLocation(20*width/50,35*height/50);
		scroll3.setLocation(20*width/50,35*height/50);
		clear2.setLocation(12*width/50, 40*height/50);
		clear3.setLocation(41*width/100, 40*height/50);
		past.setLocation(4*width/50, 20*height/30);
		current.setLocation(12*width/50, 20*height/30);
		anticipated.setLocation(20*width/50, 20*height/30);


		//ADDING ACTION LISTENERS TO BUTTONS

		addPast.addActionListener(new addButtonListener());
		addCurrent.addActionListener(new addButtonListener2());
		addAnticipated.addActionListener(new addButtonListener3());
		remove.addActionListener(new removeButtonListener());
		remove2.addActionListener(new removeButtonListener2());
		remove3.addActionListener(new removeButtonListener3());
		clear.addActionListener(new clearButtonListener());
		clear2.addActionListener(new clearButtonListener2());
		clear3.addActionListener(new clearButtonListener3());
		calculate.addActionListener(new calculateButtonListener());
		add15.addActionListener(new add15ButtonListener());


		//ADDING ITEMS TO OUR GUI

		this.add(grades);
		this.add(addPast);
		this.add(addCurrent);
		this.add(addAnticipated);
		this.add(add15);
		this.add(remove);
		this.add(remove2);
		this.add(remove3);
		this.add(clear);
		this.add(clear2);
		this.add(clear3);
		this.add(credits);
		this.add(grade);
		this.add(courseName);
		this.add(enterCredits);
		this.add(enterName);
		this.add(courses);
		this.add(summary);
		this.add(currentGPA);
		this.add(targetGPA);
		this.add(requiredGPA);
		this.add(enterTarget);
		this.add(calculate);
		this.add(currentGPAResult);
		this.add(requiredGPAResult);
		this.add(current);
		this.add(anticipated);
		this.add(past);
		this.add(errorMessage);
		this.add(scroll);
		this.add(scroll2);
		this.add(scroll3);
		this.add(new JLabel());
		this.setLocationRelativeTo(null);
		setVisible(true);
	}

	//ADD METHOS FOR OUR THREE LISTS

	private void add(String name) {
		jList1.setModel(dm);
		dm.addElement(name);
	}



	private void add2(String name) {
		jList2.setModel(dm2);
		dm2.addElement(name);
	}



	private void add3(String name) {
		jList3.setModel(dm3);
		dm3.addElement(name);
	}





	//ADD BUTTON LISTENERS FOR OUR THREE LISTS

	private class addButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String input = "Credits: "+ enterCredits.getText() + ", Grade: "+grades.getSelectedItem() +", Name of Class: " + enterName.getText();

			//MAKING SURE CREDITS IS AN INT VALUE

			try{
				errorMessage.setText("");
				Integer.parseInt(enterCredits.getText());
				add(input);
				enterCredits.setText("");
				enterName.setText("");
				grades.setSelectedItem("--");

			//CALCULATE GPA
				for(int i = 0; i< jList1.getModel().getSize();i++){
					if(i==0) {
						totalCreditHours =0;
						totalGradePoints =0;
					}
					String s = (String) jList1.getModel().getElementAt(i);
					String grade = extractDefaultValueFrom(s);
					int credit = Integer.parseInt(extractDefaultValueFrom2(s));
					if(grade!="") {
						totalCreditHours+= credit;
						totalGradePoints += values.get(grade)*credit;
						currGPA = totalGradePoints/ totalCreditHours;

						DecimalFormat numberFormat = new DecimalFormat("#.000");
						currentGPAResult.setText(numberFormat.format(currGPA));
					}
				}
			}catch (Exception ex) {
				enterCredits.setText("");
				enterName.setText("");
				grades.setSelectedItem("");
				errorMessage.setText("Please enter a valid integer");
			}
		}
	}
	private class addButtonListener2 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String input = "Credits: "+ enterCredits.getText() + ", Grade: "+grades.getSelectedItem() +", Name of Class: " + enterName.getText();
			try {
				Integer.parseInt(enterCredits.getText());
				add2(input);
				enterCredits.setText("");
				enterName.setText("");
				grades.setSelectedItem("");
			}catch (Exception ex){
				enterCredits.setText("");
				enterName.setText("");
				grades.setSelectedItem("");
				errorMessage.setText("Please enter a valid integer");
			}
		}
	}
	private class addButtonListener3 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String input = "Credits: "+ enterCredits.getText() + ", Grade: "+grades.getSelectedItem() +", Name of Class: " + enterName.getText();
			try {
				Integer.parseInt(enterCredits.getText());	
				add3(input);
				blankCreditHours +=1;
				enterCredits.setText("");
				enterName.setText("");
			}catch (Exception ex){
				enterCredits.setText("");
				enterName.setText("");
				grades.setSelectedItem("");
				errorMessage.setText("Please enter a valid integer");
			}
		}
	}





	//CLEAR BUTTON LISTENERS FOR OUR THREE LISTS

	private class clearButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			dm.clear();	
			jList1.setModel(dm);
			currentGPAResult.setText("");
			requiredGPAResult.setText("");
		}
	}
	private class clearButtonListener2 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			dm2.clear();	
			jList2.setModel(dm2);
		}
	}
	private class clearButtonListener3 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			dm3.clear();
			blankCreditHours=0;
			jList3.setModel(dm3);
		}
	}





	//REMOVE BUTTON LISTENERS FOR OUR THREE LISTS

	private class removeButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int index = jList1.getSelectedIndex();
			dm.removeElementAt(index);
		}
	}
	private class removeButtonListener2 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int index = jList2.getSelectedIndex();
			dm2.removeElementAt(index);
		}
	}
	private class removeButtonListener3 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int index = jList3.getSelectedIndex();
			dm3.removeElementAt(index);
			blankCreditHours-=1;
		}
	}





	//ADD 15 CREDITS BUTTON LISTENER

	private class add15ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			blankCreditHours += 15;
			String toAdd ="Credits: "+ 1 + ", Grade: "+"--" +", Name of Class: " + "--";
			for(int i=0;i<15;i++) {
				add3(toAdd);

			}
		}
	}





	//CALCULATE GPA NEEDED BUTTON LISTENER

	public class calculateButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			double target = Double.parseDouble(enterTarget.getText());
			double GPANeeded =( (target)*(totalCreditHours+blankCreditHours)-totalGradePoints)/blankCreditHours;
			DecimalFormat numberFormat = new DecimalFormat("#.000");
			if(jList3.getModel().getSize() == 0) {
				requiredGPAResult.setFont(new Font("Times", Font.ITALIC, 16));
				requiredGPAResult.setText("Please add some courses or add 15 blank credits!");
			}
			else if(GPANeeded > 4.0) {
				requiredGPAResult.setFont(new Font("Times", Font.ITALIC, 16));
				requiredGPAResult.setText("Result greater than 4.0!Try adding more credit hours and recalculate");
			}
			else if(GPANeeded <2.0) {
				requiredGPAResult.setFont(new Font("Times", Font.ITALIC, 16));
				requiredGPAResult.setText("Result less than 2.0! You can take less credit hours if you wish");
			}
			else {
				requiredGPAResult.setFont(new Font("Times", Font.BOLD, 20));
				requiredGPAResult.setText(numberFormat.format(GPANeeded));
			}
			enterTarget.setText("");
		}
	}






	//REGULAR EXPRESIONS METHODS TO FIND GRADE AND CREDITS FROM LIST

	public String extractDefaultValueFrom(String text) {
		Matcher matcher = DEFAULT_VALUE_PATTERN.matcher(text);
		if (!matcher.find()) {
			throw new RuntimeException();
		}
		return matcher.group(1);
	}



	public String extractDefaultValueFrom2(String text) {
		Matcher matcher = DEFAULT_VALUE_PATTERN2.matcher(text);
		if (!matcher.find()) {
			throw new RuntimeException();
		}
		return matcher.group(1);
	}




}


