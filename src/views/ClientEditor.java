
package views;

import entities.Users;
import javafx.scene.paint.Color;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

/**
 * Form that allows editing of information about one client.
 *
 * @author Jiri Vagner, Jan Stola
 */
public class ClientEditor extends javax.swing.JFrame {
  Users usersDetails;
  static int DBuserid;
  EntityManager entityManager;

    public ClientEditor(int id) {
        this.DBuserid = id;
        initComponents();
       // this.DBuserid = USERID;
        panaldetails.setBorder(new LineBorder(java.awt.Color.DARK_GRAY, 2, true));
        panalimage.setBorder(new LineBorder(null, 5, true));
        error_label.setVisible(false);
        
        paydetails_panal.setBorder(new LineBorder(java.awt.Color.DARK_GRAY, 2, true));
        pay_image_panal.setBorder(new LineBorder(null, 5, true));
        
        System.out.println("====userid==="+DBuserid);
        entityManager = Persistence.createEntityManagerFactory("FaceRecogPU").createEntityManager();
          usersDetails = ((Users)entityManager.createNamedQuery("Users.findById")
                  .setParameter("id", DBuserid).getSingleResult());
          System.out.println("mobile==="+usersDetails.getMobile());
          entityManager.getTransaction().begin();
          
          name.setText(usersDetails.getName());
          mobile.setText(usersDetails.getMobile());
          userid.setText(usersDetails.getStatus());
          gender.setText(usersDetails.getSex());
          String img =DBuserid+"_"+usersDetails.getName().replace(" ", "_");
          details_image.setIcon(new javax.swing.ImageIcon(Register.class.getResource("/trainingImages/"+img+"2.png")));
          pay_image.setIcon(new javax.swing.ImageIcon(Register.class.getResource("/trainingImages/"+img+"2.png")));
          if(usersDetails.getPaid()!=null && usersDetails.getPaid()){
             error_label.setText("User already received payments");
            error_label.setVisible(true);
            amount_edit.setFocusable(false);
            amount_edit.setText(usersDetails.getAmount().toString());
            
          }
          
          PlainDocument doc = (PlainDocument) amount_edit.getDocument();
      doc.setDocumentFilter(new MyIntFilter());
    
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        sexButtonGroup = new javax.swing.ButtonGroup();
        jMenu1 = new javax.swing.JMenu();
        clientInfoPane = new javax.swing.JTabbedPane();
        personalPanel = new javax.swing.JPanel();
        panalimage = new javax.swing.JPanel();
        details_image = new javax.swing.JLabel();
        panaldetails = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mobile = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        userid = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        gender = new javax.swing.JLabel();
        contactPanel = new javax.swing.JPanel();
        pay_image_panal = new javax.swing.JPanel();
        pay_image = new javax.swing.JLabel();
        paydetails_panal = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        amount_edit = new javax.swing.JTextField();
        error_label = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        usernameLabel = new javax.swing.JLabel();
        clientInfoLabel = new javax.swing.JLabel();
        validationMsgLabel = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        personalPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        panalimage.setBackground(new java.awt.Color(190, 190, 190));

        org.jdesktop.layout.GroupLayout panalimageLayout = new org.jdesktop.layout.GroupLayout(panalimage);
        panalimage.setLayout(panalimageLayout);
        panalimageLayout.setHorizontalGroup(
            panalimageLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panalimageLayout.createSequentialGroup()
                .addContainerGap()
                .add(details_image, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
        );
        panalimageLayout.setVerticalGroup(
            panalimageLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, details_image, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panaldetails.setBackground(new java.awt.Color(190, 190, 190));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jLabel1.setText("Name");

        name.setText("jLabel3");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jLabel4.setText("Mobile");

        mobile.setText("jLabel5");

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jLabel6.setText("User ID");

        userid.setText("jLabel10");

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jLabel11.setText("Gender");

        gender.setText("jLabel12");

        org.jdesktop.layout.GroupLayout panaldetailsLayout = new org.jdesktop.layout.GroupLayout(panaldetails);
        panaldetails.setLayout(panaldetailsLayout);
        panaldetailsLayout.setHorizontalGroup(
            panaldetailsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panaldetailsLayout.createSequentialGroup()
                .add(39, 39, 39)
                .add(panaldetailsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel4)
                    .add(jLabel1)
                    .add(jLabel6)
                    .add(jLabel11))
                .add(50, 50, 50)
                .add(panaldetailsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(gender)
                    .add(mobile)
                    .add(name)
                    .add(userid))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        panaldetailsLayout.setVerticalGroup(
            panaldetailsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panaldetailsLayout.createSequentialGroup()
                .add(26, 26, 26)
                .add(panaldetailsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(name))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(panaldetailsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(mobile))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(panaldetailsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(userid))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panaldetailsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel11)
                    .add(gender))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout personalPanelLayout = new org.jdesktop.layout.GroupLayout(personalPanel);
        personalPanel.setLayout(personalPanelLayout);
        personalPanelLayout.setHorizontalGroup(
            personalPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(personalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(panalimage, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(36, 36, 36)
                .add(panaldetails, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        personalPanelLayout.setVerticalGroup(
            personalPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(personalPanelLayout.createSequentialGroup()
                .add(44, 44, 44)
                .add(personalPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(panalimage, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(panaldetails, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        clientInfoPane.addTab("User details", personalPanel);

        contactPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pay_image_panal.setBackground(new java.awt.Color(190, 190, 190));

        org.jdesktop.layout.GroupLayout pay_image_panalLayout = new org.jdesktop.layout.GroupLayout(pay_image_panal);
        pay_image_panal.setLayout(pay_image_panalLayout);
        pay_image_panalLayout.setHorizontalGroup(
            pay_image_panalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pay_image_panalLayout.createSequentialGroup()
                .add(20, 20, 20)
                .add(pay_image, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 154, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pay_image_panalLayout.setVerticalGroup(
            pay_image_panalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pay_image_panalLayout.createSequentialGroup()
                .add(21, 21, 21)
                .add(pay_image, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(25, 25, 25))
        );

        paydetails_panal.setBackground(new java.awt.Color(190, 190, 190));

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel8.setText("Amount ");

        error_label.setBackground(new java.awt.Color(242, 240, 240));
        error_label.setFont(new java.awt.Font("UnGungseo", 2, 12)); // NOI18N
        error_label.setForeground(java.awt.Color.red);
        error_label.setText("User already been paid");

        jButton4.setText("Pay");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout paydetails_panalLayout = new org.jdesktop.layout.GroupLayout(paydetails_panal);
        paydetails_panal.setLayout(paydetails_panalLayout);
        paydetails_panalLayout.setHorizontalGroup(
            paydetails_panalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(paydetails_panalLayout.createSequentialGroup()
                .add(23, 23, 23)
                .add(jLabel8)
                .add(paydetails_panalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(paydetails_panalLayout.createSequentialGroup()
                        .add(50, 50, 50)
                        .add(paydetails_panalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(error_label)
                            .add(jButton4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 105, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(paydetails_panalLayout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(amount_edit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 223, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paydetails_panalLayout.setVerticalGroup(
            paydetails_panalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(paydetails_panalLayout.createSequentialGroup()
                .add(28, 28, 28)
                .add(paydetails_panalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel8)
                    .add(amount_edit, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(error_label)
                .add(32, 32, 32)
                .add(jButton4)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout contactPanelLayout = new org.jdesktop.layout.GroupLayout(contactPanel);
        contactPanel.setLayout(contactPanelLayout);
        contactPanelLayout.setHorizontalGroup(
            contactPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(contactPanelLayout.createSequentialGroup()
                .add(pay_image_panal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(28, 28, 28)
                .add(paydetails_panal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contactPanelLayout.setVerticalGroup(
            contactPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(contactPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(contactPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(pay_image_panal, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(paydetails_panal, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        clientInfoPane.addTab("Pay User", contactPanel);

        usernameLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${client.firstName} ${client.surname}"), usernameLabel, org.jdesktop.beansbinding.BeanProperty.create("text"), "displayNameTitle");
        bindingGroup.addBinding(binding);

        clientInfoLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        clientInfoLabel.setText("Face Recongition:"); // NOI18N

        validationMsgLabel.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        validationMsgLabel.setForeground(new java.awt.Color(255, 0, 0));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(clientInfoLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(usernameLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(clientInfoPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 617, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(49, 49, 49)
                        .add(validationMsgLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(clientInfoLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(usernameLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 7, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, validationMsgLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, clientInfoPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 315, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(usersDetails.getPaid()!=null && usersDetails.getPaid()){
            error_label.setText("User already received payments");
            error_label.setVisible(true);
            amount_edit.setFocusable(false);
            
             JFrame frame = new JFrame("Error");
              JOptionPane.showMessageDialog(frame,
                usersDetails.getName()+" has already been paid",
                    "Payment Error",
                        JOptionPane.ERROR_MESSAGE);
          
            
          }else{
            if(amount_edit.getText().toString().length()<2){   
             error_label.setText("Add some money to pay");   
              error_label.setVisible(true);
              
            }else{
               error_label.setVisible(false); 
               //entityManager.getTransaction().begin();
               usersDetails.setPaid(Boolean.TRUE);
               usersDetails.setAmount(Double.valueOf(amount_edit.getText().toString()));
               usersDetails.setTime(Double.valueOf(System.currentTimeMillis()));
                entityManager.persist(usersDetails);
            entityManager.getTransaction().commit(); 
           if (entityManager.contains(usersDetails)) {
             JFrame frame = new JFrame("Success");
              JOptionPane.showMessageDialog(frame,
                usersDetails.getName()+" has been paid",
                    "Payment Success",
                        JOptionPane.INFORMATION_MESSAGE);   
           }
               
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
        try {
            javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels=javax.swing.UIManager.getInstalledLookAndFeels();
            for (int idx=0; idx<installedLookAndFeels.length; idx++)
                if ("Nimbus".equals(installedLookAndFeels[idx].getName())) {
                    javax.swing.UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
                    break;
                }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                javax.swing.JFrame frame = new javax.swing.JFrame("Verification System");
                frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                frame.getContentPane().add(new ClientEditor(DBuserid));
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount_edit;
    private javax.swing.JLabel clientInfoLabel;
    private javax.swing.JTabbedPane clientInfoPane;
    private javax.swing.JPanel contactPanel;
    private javax.swing.JLabel details_image;
    private javax.swing.JLabel error_label;
    private javax.swing.JLabel gender;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JLabel mobile;
    private javax.swing.JLabel name;
    private javax.swing.JPanel panaldetails;
    private javax.swing.JPanel panalimage;
    private javax.swing.JLabel pay_image;
    private javax.swing.JPanel pay_image_panal;
    private javax.swing.JPanel paydetails_panal;
    private javax.swing.JPanel personalPanel;
    private javax.swing.ButtonGroup sexButtonGroup;
    private javax.swing.JLabel userid;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel validationMsgLabel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    

class MyIntFilter extends DocumentFilter {
   @Override
   public void insertString(FilterBypass fb, int offset, String string,
         AttributeSet attr) throws BadLocationException {

      Document doc = fb.getDocument();
      StringBuilder sb = new StringBuilder();
      sb.append(doc.getText(0, doc.getLength()));
      sb.insert(offset, string);

      if (test(sb.toString())) {
         super.insertString(fb, offset, string, attr);
      } else {
         // warn the user and don't allow the insert
      }
   }

   private boolean test(String text) {
      try {
         Integer.parseInt(text);
         return true;
      } catch (NumberFormatException e) {
         return false;
      }
   }

   @Override
   public void replace(FilterBypass fb, int offset, int length, String text,
         AttributeSet attrs) throws BadLocationException {

      Document doc = fb.getDocument();
      StringBuilder sb = new StringBuilder();
      sb.append(doc.getText(0, doc.getLength()));
      sb.replace(offset, offset + length, text);

      if (test(sb.toString())) {
         super.replace(fb, offset, length, text, attrs);
      } else {
         // warn the user and don't allow the insert
      }

   }

   @Override
   public void remove(FilterBypass fb, int offset, int length)
         throws BadLocationException {
      Document doc = fb.getDocument();
      StringBuilder sb = new StringBuilder();
      sb.append(doc.getText(0, doc.getLength()));
      sb.delete(offset, offset + length);

      if (test(sb.toString())) {
         super.remove(fb, offset, length);
      } else {
         // warn the user and don't allow the insert
      }

   }
}

}

