package register;


// FaceTracker.java
// Andrew Davison, July 2013, ad@fivedots.psu.ac.th

/* Show a sequence of images snapped from a webcam in a picture panel (FacePanel). 
   A face is highlighted with a yellow rectangle, which is updated as the face
   moves. The highlighted part of the image can be saved by the user pressing
   the "Save Face" button.

   Usage:
      > java FaceTracker
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

import com.googlecode.javacv.*;
import com.googlecode.javacv.cpp.*;
import com.googlecode.javacpp.Loader;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import org.opencv.core.Core;
import views.Register;


public class FaceTracker extends JFrame 
{
  // GUI components
  private FacePanel facePanel;
    static javax.swing.JLabel imagefield ;
    static javax.swing.JLabel imagefield2 ;
    static javax.swing.JLabel imagefield3;
    final javax.swing.JLabel images;
    JButton nextbt = new JButton("NEXT");
    static boolean oknow =false;

  public FaceTracker(String name, javax.swing.JLabel image)
  {
    super("Face Tracker");
    facePanel.FACE_FNM=name;
    Container c = getContentPane();
    c.setLayout( new BorderLayout() );   
    images = image;

    // Preload the opencv_objdetect module to work around a known bug.
    Loader.load(opencv_objdetect.class);

    facePanel = new FacePanel(); // the sequence of pictures appear here
    c.add( facePanel, BorderLayout.CENTER);

    // button for saving a highlighted face
    JButton saveBut = new JButton("Save Face");
    saveBut.addActionListener( new ActionListener() {
       public void actionPerformed(ActionEvent e)
       { 
           
           facePanel.saveFace(); 
       }
    });
    JPanel pmng = new JPanel();
    pmng.setLayout(new BoxLayout(pmng, BoxLayout.Y_AXIS));
    pmng.setBorder(new EmptyBorder(10, 10, 10, 10));
    imagefield = new javax.swing.JLabel();
    imagefield2 = new javax.swing.JLabel();
    imagefield3 = new javax.swing.JLabel();
     
    imagefield.setBackground(new java.awt.Color(196, 196, 196));
    imagefield.setBorder(new LineBorder(Color.BLACK));
    imagefield.setPreferredSize(new Dimension(150, 150));
    imagefield.setIcon(new javax.swing.ImageIcon(FaceTracker.class.getResource("/facerego.png")));
    imagefield.setBorder(new EmptyBorder(2, 2, 2, 2));
    
    imagefield2.setBackground(new java.awt.Color(196, 196, 196));
    imagefield2.setBorder(new LineBorder(Color.BLACK));
    imagefield2.setPreferredSize(new Dimension(150, 150));
    imagefield2.setIcon(new javax.swing.ImageIcon(FaceTracker.class.getResource("/facerego.png")));
    imagefield2.setBorder(new EmptyBorder(2, 2, 2, 2));
     
    imagefield3.setBackground(new java.awt.Color(196, 196, 196));
    imagefield3.setBorder(new LineBorder(Color.BLACK));
    imagefield3.setPreferredSize(new Dimension(150, 150));
    imagefield3.setIcon(new javax.swing.ImageIcon(FaceTracker.class.getResource("/facerego.png")));
    imagefield3.setBorder(new EmptyBorder(2, 2, 2, 2));
    
    pmng.add(imagefield);
    pmng.add(imagefield2);
    pmng.add(imagefield3);
     
    JPanel p = new JPanel();
    p.add(saveBut);
    p.add(nextbt,BorderLayout.EAST);
    c.add(p, BorderLayout.SOUTH);
    c.add(pmng,BorderLayout.EAST);

    nextbt.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(oknow){
               new Register().updateimage(facePanel.FACE_FNM,images);
               facePanel.closeDown();
               dispose();
            }else {
                 JFrame panal = new JFrame("Error");
                 JOptionPane.showConfirmDialog(panal, "Please capture all three images"
                         ,"Error",JOptionPane.ERROR_MESSAGE);
     
            }
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    });
    addWindowListener( new WindowAdapter() {
      public void windowClosing(WindowEvent e)
      { facePanel.closeDown();    // stop snapping pics
      dispose();
     // System.exit(0);
      }
    });

    setResizable(false);
    pack();  
    setLocationRelativeTo(null);
    setVisible(true);
  } // end of FaceTracker()

    public static void updateUi(int number,BufferedImage image) {
        System.out.println("okay save==="+number);
      //  System.out.println("file location======"+file);
        ImageIcon imageIcon = new ImageIcon(image);
      
                   if(number==0){
          //  imagefield.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("/trainingImages/KUTS0.png")));
          //imagefield.setIcon(imageIcon);   
        }else if(number==1){
           imagefield.setIcon(imageIcon); 
        }else if(number ==2){
          imagefield2.setIcon(imageIcon);  
        }else {
         imagefield3.setIcon(imageIcon);
         Register.savenow=true;
         oknow=true;
        }
               
    }
  // -------------------------------------------------------

//  public static void main( String args[] )
//  { 
//      System.out.println("------Loaading------");
//    //  new FaceTracker(""); 
//  }

} // end of FaceTracker class
