package javagroupproject;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author lingyanjiang
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        leftPanel = new javax.swing.JPanel();
        dashButton = new javax.swing.JButton();
        statReportButton = new javax.swing.JButton();
        otherReportButton = new javax.swing.JButton();
        customizeButton = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        dashScrollPane = new javax.swing.JScrollPane(dashPane);
        dashPane = new javax.swing.JPanel();
        updatePanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pathLabel = new javax.swing.JLabel();
        graphPanel = new javax.swing.JPanel();
        selectYearPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        yearComboBox = new javax.swing.JComboBox();
        yearButton = new javax.swing.JButton();
        jchartScrollPane = new javax.swing.JScrollPane();
        graphPanelByYear = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 700));
        getContentPane().setLayout(new javax.swing.OverlayLayout(getContentPane()));

        bgPanel.setPreferredSize(new java.awt.Dimension(1000, 700));
        bgPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        topPanel.setLayout(new javax.swing.OverlayLayout(topPanel));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/top.jpg"))); // NOI18N
        topPanel.add(jLabel1);

        bgPanel.add(topPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 80));

        leftPanel.setBackground(new java.awt.Color(38, 42, 51));
        leftPanel.setPreferredSize(new java.awt.Dimension(177, 800));
        leftPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dashButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button_1.png")));
        dashButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button_1p.png")));
        dashButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashButtonActionPerformed(evt);
            }
        });
        leftPanel.add(dashButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 150, 60));

        statReportButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button_2.png")));
        statReportButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button_2p.png")));
        statReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statReportButtonActionPerformed(evt);
            }
        });
        leftPanel.add(statReportButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 150, 60));

        otherReportButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button_3.png")));
        otherReportButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button_3p.png")));
        leftPanel.add(otherReportButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 150, 60));

        customizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button_4.png")));
        customizeButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button_4p.png")));
        customizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customizeButtonActionPerformed(evt);
            }
        });
        leftPanel.add(customizeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 150, 60));

        bgPanel.add(leftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        mainPanel.setBackground(new java.awt.Color(235, 236, 238));
        mainPanel.setLayout(new java.awt.CardLayout());
        CardLayout c = (CardLayout)mainPanel.getLayout();

        dashScrollPane.setBackground(new java.awt.Color(235, 236, 238));
        dashScrollPane.setBorder(null);
        dashScrollPane.setBounds(new java.awt.Rectangle(0, 0, 827, 621));
        dashScrollPane.setPreferredSize(new java.awt.Dimension(827, 620));

        dashPane.setBackground(new java.awt.Color(235, 236, 238));
        dashPane.setPreferredSize(new java.awt.Dimension(800, 300));
        dashPane.setSize(new java.awt.Dimension(800, 300));
        dashPane.setPreferredSize(new java.awt.Dimension(20, 20));
        dashScrollPane.setViewportView(dashPane);

        //dashScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        mainPanel.add(dashScrollPane, "maincard");
        //dashScrollPane.getViewport().add(dashPane);

        updatePanel.setBackground(new java.awt.Color(235, 236, 238));

        jLabel3.setText("Choose file:");

        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Upload");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        pathLabel.setText("Path:");

        javax.swing.GroupLayout updatePanelLayout = new javax.swing.GroupLayout(updatePanel);
        updatePanel.setLayout(updatePanelLayout);
        updatePanelLayout.setHorizontalGroup(
            updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatePanelLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathLabel)
                .addContainerGap(516, Short.MAX_VALUE))
        );
        updatePanelLayout.setVerticalGroup(
            updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatePanelLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButton1)
                    .addComponent(pathLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        mainPanel.add(updatePanel, "update");

        graphPanel.setBackground(new java.awt.Color(235, 236, 238));

        selectYearPanel.setBackground(new java.awt.Color(235, 236, 238));

        jLabel2.setText("Select year: ");

        yearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Click here to choose", "2011", "2012", "2013", "2014" }));
        yearComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                yearComboBoxItemStateChanged(evt);
            }
        });
        yearComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearComboBoxActionPerformed(evt);
            }
        });

        yearButton.setText("See result");
        yearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout selectYearPanelLayout = new javax.swing.GroupLayout(selectYearPanel);
        selectYearPanel.setLayout(selectYearPanelLayout);
        selectYearPanelLayout.setHorizontalGroup(
            selectYearPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectYearPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(yearButton)
                .addContainerGap())
        );
        selectYearPanelLayout.setVerticalGroup(
            selectYearPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectYearPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2)
                .addComponent(yearButton))
        );

        jchartScrollPane.setBackground(new java.awt.Color(235, 236, 238));
        jchartScrollPane.setBorder(null);

        graphPanelByYear.setBackground(new java.awt.Color(235, 236, 238));
        jchartScrollPane.setViewportView(graphPanelByYear);

        javax.swing.GroupLayout graphPanelLayout = new javax.swing.GroupLayout(graphPanel);
        graphPanel.setLayout(graphPanelLayout);
        graphPanelLayout.setHorizontalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(graphPanelLayout.createSequentialGroup()
                .addComponent(selectYearPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(graphPanelLayout.createSequentialGroup()
                .addComponent(jchartScrollPane)
                .addContainerGap())
        );
        graphPanelLayout.setVerticalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(graphPanelLayout.createSequentialGroup()
                .addComponent(selectYearPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jchartScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
        );

        mainPanel.add(graphPanel, "graphPanel");

        bgPanel.add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 820, 620));

        getContentPane().add(bgPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dashButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashButtonActionPerformed
        CardLayout c = (CardLayout)mainPanel.getLayout(); 
        c.show(mainPanel, "maincard");
        generalReport();
    }//GEN-LAST:event_dashButtonActionPerformed

public void generalReport()
{
        CardLayout c = (CardLayout)mainPanel.getLayout(); 
        c.show(mainPanel, "maincard");
        ChartPanel p1 = null;
        ChartPanel p2 = null;
        ChartPanel p3 = null;
        try {
            p1 = Handler.getChart("Number of students by gender","categoryy", "SELECT gender,count(1) FROM studentinfor.student group by gender;");
            p2 = Handler.getChart("Number of studets by gender","pie", "SELECT gender,count(1) FROM studentinfor.student group by gender;");
            p3 = Handler.getChart("Average GPA by year","line", "SELECT Year,AVG(GPA) as 'GPA' FROM studentinfor.student group by Year;");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        addChart(p1,dashPane);
        addChart(p2,dashPane);
        addChart(p3,dashPane);    
}
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser jf = new JFileChooser(); 
        jf.showDialog(null,null); 
        File fi = jf.getSelectedFile(); 
        String file = fi.getAbsolutePath(); 
        pathLabel.setText(file);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void customizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customizeButtonActionPerformed
        CardLayout c = (CardLayout)mainPanel.getLayout();
        c.show(mainPanel, "update");
    }//GEN-LAST:event_customizeButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Dbconnection.connectDatabase(pathLabel.getText());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void statReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statReportButtonActionPerformed
        
        CardLayout c = (CardLayout)mainPanel.getLayout();
        c.show(mainPanel, "graphPanel");
    }//GEN-LAST:event_statReportButtonActionPerformed

    private void yearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearComboBoxActionPerformed

    private void yearComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_yearComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_yearComboBoxItemStateChanged

    private void yearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearButtonActionPerformed
        int index = yearComboBox.getSelectedIndex();
        switch(index) {
            case 1:
                graphPanelByYear.removeAll();
                addChart(DbImplement.genderByYear("2011"),graphPanelByYear);
                addChart(DbImplement.citizenshipByYear("2011"),graphPanelByYear);
                addChart(DbImplement.courseByYear("2011"), graphPanelByYear);
                break;
            case 2:
                graphPanelByYear.removeAll();
                addChart(DbImplement.genderByYear("2012"),graphPanelByYear);
                addChart(DbImplement.citizenshipByYear("2012"),graphPanelByYear);
                addChart(DbImplement.courseByYear("2012"), graphPanelByYear);
                break;
            case 3:
                graphPanelByYear.removeAll();
                addChart(DbImplement.genderByYear("2013"),graphPanelByYear);
                addChart(DbImplement.citizenshipByYear("2013"),graphPanelByYear);
                addChart(DbImplement.courseByYear("2013"), graphPanelByYear);
                break;
            case 4:
                graphPanelByYear.removeAll();
                addChart(DbImplement.genderByYear("2014"),graphPanelByYear);
                addChart(DbImplement.citizenshipByYear("2014"),graphPanelByYear);
                addChart(DbImplement.courseByYear("2014"), graphPanelByYear);
                break;
        }
    }//GEN-LAST:event_yearButtonActionPerformed

    /**
     * This method add chart to the main panel
     * @param chart 
     */
    public void addChart(ChartPanel chart,JPanel panel) {
        panel.add(chart,BorderLayout.CENTER);
        panel.validate();
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgPanel;
    private javax.swing.JButton customizeButton;
    private javax.swing.JButton dashButton;
    private javax.swing.JPanel dashPane;
    private javax.swing.JScrollPane dashScrollPane;
    private javax.swing.JPanel graphPanel;
    private javax.swing.JPanel graphPanelByYear;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jchartScrollPane;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton otherReportButton;
    private javax.swing.JLabel pathLabel;
    private javax.swing.JPanel selectYearPanel;
    private javax.swing.JButton statReportButton;
    private javax.swing.JPanel topPanel;
    private javax.swing.JPanel updatePanel;
    private javax.swing.JButton yearButton;
    private javax.swing.JComboBox yearComboBox;
    // End of variables declaration//GEN-END:variables
}
