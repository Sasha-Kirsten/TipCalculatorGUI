import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TipCalculator extends JFrame implements ActionListener {

	JLabel outTemp;
	JTextField entryTemp;
	JTextField entryTemp2;
	JTextField entryTemp3;

	TipCalculator(){
		this.setSize(300, 300);
		this.setTitle("Meal Splitter");
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel desc = new JLabel("Price of the meal: ");
		this.add(desc);

		entryTemp = new JTextField(5);
		entryTemp.addActionListener(this);
		this.add(entryTemp);


		JLabel desc2 = new JLabel("Tip(%) for the meal: ");
		this.add(desc2);

		entryTemp2 = new JTextField(5);
		entryTemp2.addActionListener(this);
		this.add(entryTemp2);


		JLabel desc3 = new JLabel("Number of people: ");
		this.add(desc3);

		entryTemp3 = new JTextField(5);
		entryTemp3.addActionListener(this);
		this.add(entryTemp3);


		JButton convert = new JButton("Calculate");
		this.add(convert);
		convert.addActionListener(this);

		outTemp = new JLabel("");
		this.add(outTemp);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new TipCalculator();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double f = 0.0;
		double f2 = 0.0;
		double f3 = 0.0;
		try {
			f = Double.parseDouble(entryTemp.getText());
			f2 = Double.parseDouble(entryTemp2.getText());
			f3 = Double.parseDouble(entryTemp3.getText());
		}catch (NumberFormatException numExcep){
			JOptionPane.showMessageDialog(null, "You must enter a valid number");
			entryTemp.setText("");
		}
		System.out.println(e.getActionCommand());
		if(e.getActionCommand().equals("Calculate")){
			outTemp.setText("Each Person should pay " + ((f*(f2/100+1))/f3));
		}
	}
}









// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// public class TipCalculator extends JFrame {

//     private JTextField billPriceField;
//     private JTextField tipPercentageField;
//     private JTextField peopleCountField;
//     private JButton calculateButton;
//     private JLabel resultLabel;

//     public TipCalculator() {
//         setTitle("Tip Calculator");
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLayout(new FlowLayout());

//         add(new JLabel("Bill Price:"));
//         billPriceField = new JTextField(10);
//         add(billPriceField);

//         add(new JLabel("Tip Percentage:"));
//         tipPercentageField = new JTextField(10);
//         add(tipPercentageField);

//         add(new JLabel("Number of People:"));
//         peopleCountField = new JTextField(10);
//         add(peopleCountField);

//         calculateButton = new JButton("Calculate");
//         calculateButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 try {
//                     double billPrice = Double.parseDouble(billPriceField.getText());
//                     double tipPercentage = Double.parseDouble(tipPercentageField.getText());
//                     int peopleCount = Integer.parseInt(peopleCountField.getText());

//                     if (billPrice < 0 || tipPercentage < 0 || peopleCount <= 0) {
//                         throw new IllegalArgumentException("Invalid input values.");
//                     }

//                     double totalBill = billPrice * (1 + tipPercentage / 100);
//                     double perPersonShare = totalBill / peopleCount;
//                     resultLabel.setText(String.format("Each person's share: %.2f", perPersonShare));
//                 } catch (NumberFormatException ex) {
//                     JOptionPane.showMessageDialog(null, "Please enter valid numeric values.");
//                 } catch (IllegalArgumentException ex) {
//                     JOptionPane.showMessageDialog(null, ex.getMessage());
//                 }
//             }
//         });
//         add(calculateButton);

//         resultLabel = new JLabel("Each person's share: 0.00");
//         add(resultLabel);

//         setSize(400, 200);
//         setVisible(true);
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(new Runnable() {
//             public void run() {
//                 new TipCalculator();
//             }
//         });
//     }
// }











