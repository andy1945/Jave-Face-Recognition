package recog;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

import com.googlecode.javacv.*;
import com.googlecode.javacv.cpp.*;
import com.googlecode.javacpp.Loader;
import views.ClientEditor;
import views.UserDetails;


public class FaceRecognizer extends JFrame 
{
  // GUI components
  private FaceRecogPanel facePanel;
  private JButton recogBut;
  private JTextField nameField;   // where the name (and distance info) appears


  public FaceRecognizer()
  {
    super("Face Recognizer");

    Container c = getContentPane();
    c.setLayout( new BorderLayout() );   

    // Preload the opencv_objdetect module to work around a known bug.
   // Loader.load(opencv_objdetect.class);

    facePanel = new FaceRecogPanel(this); // the sequence of pictures appear here
    c.add( facePanel, BorderLayout.CENTER);


    // button for recognizing a highlighted face
    recogBut = new JButton("Recognize Face");
    recogBut.addActionListener( new ActionListener() {
       public void actionPerformed(ActionEvent e)
       { nameField.setText("");
         recogBut.setEnabled(false);
         facePanel.setRecog();
       }
    });

    nameField = new JTextField(20);   // for the name of the recognized face
    nameField.setEditable(false);

    JPanel p = new JPanel();
    p.add(recogBut);
    p.add( new JLabel("Name: "));
    p.add( nameField);
    c.add(p, BorderLayout.SOUTH);


    addWindowListener( new WindowAdapter() {
      public void windowClosing(WindowEvent e)
      { 
          dispose();
          facePanel.closeDown();    // stop snapping pics
       // System.exit(0);
      }
    });
 //getContentPane().setPreferredSize( Toolkit.getDefaultToolkit().getScreenSize());
    pack();  
    setResizable(false);
    setVisible(true);
    SwingUtilities.invokeLater(new Runnable() {
      public void run()
      {
        Point p = new Point(0, 0);
        SwingUtilities.convertPointToScreen(p, getContentPane());
        Point l = getLocation();
        l.x -= p.x;
        l.y -= p.y;
        setLocation(l);
      }
    });
       
  } // end of FaceRecognizer()



  public void setRecogName(final String faceName, final String dist,double matchDist)
  // update face name and its distance in the nameField; called from panel
  { 
    SwingUtilities.invokeLater(new Runnable() {
      public void run() 
      {  
          System.out.println("name===="+faceName);
          System.out.println("matchDist===="+matchDist);
          if(Double.valueOf(dist)<0.6){
          nameField.setText( faceName + " (" + dist + ")");  
         recogBut.setEnabled(true);
         String [] namiii = faceName.split("\\/");
         JPanel main = new JPanel();
         
           String [] Names = namiii[2].split("_");
           System.out.println("aneme==="+namiii[2]);
            System.out.println("disp 1==="+Names[1]);
            System.out.println("disp 0 ==="+Names[0]);
            JLabel custIdLabel = new JLabel("Name: "+Names[1]+" "+Names[2]);
             
            JLabel companyLabel = new JLabel();
            companyLabel.setIcon(new javax.swing.ImageIcon(FaceRecognizer.class.getResource("/trainingImages/"+namiii[2]+"2.png")));
            main.add(custIdLabel);
            main.add(companyLabel);
            add(main);
            JFrame frame = new JFrame("Success");
        int input = JOptionPane.showConfirmDialog(frame, main, "Staff member:"
                        ,JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (input == 0) {
            System.out.println("==pay==call==");
            dispose();
            new UserDetails(Integer.parseInt(Names[0])).setVisible(true);
            //JOptionPane.showMessageDialog(frame,"Here we procceed to pay him");
        } else {
            // Cancel
            JOptionPane.showMessageDialog(frame, "Okay retry");
        }
      }else{
              nameField.setText( "No much found");  
              recogBut.setText("Retry");
         recogBut.setEnabled(true);
          }
      }
    });
  }  // end of setRecogName()


  // -------------------------------------------------------

//  public static void main( String args[] )
//  {  new FaceRecognizer();  }

} // end of FaceRecognizer class
