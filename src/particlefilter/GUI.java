package particlefilter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael, Nick
 */
public class GUI extends javax.swing.JFrame {

    ParticleFilter filter;
    Particle robot;
    final Point[] landmarks = new Point[]{new Point(5, 20f), new Point(225, 40f),
                                          new Point(225f, 400f), new Point(5f, 80f),
                                          new Point(700 - 10f, 40f), new Point(17f, 92f)};
    final int NUM_PARTICLES = 10000;
    final int WORLD_WIDTH = 700, WORLD_HEIGHT = 500;
    private Image image;
    private Graphics2D graphics;

    private void setUp() {
        image = new BufferedImage(WORLD_WIDTH, WORLD_HEIGHT, BufferedImage.BITMASK);

        graphics = (Graphics2D) image.getGraphics();
        filter = new ParticleFilter(NUM_PARTICLES, landmarks, WORLD_WIDTH, WORLD_HEIGHT);
        filter.setNoise(0.05f, 0.05f, 5f);
        robot = new Particle(landmarks, WORLD_WIDTH, WORLD_HEIGHT);
        graphics.drawRect(0, 0, WORLD_WIDTH - 1, WORLD_HEIGHT - 1);
    }

    public GUI() {
        setUp();
        initComponents();
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        /* Draw simulation environment ****************************************/
        graphics.clearRect(0, 0, WORLD_WIDTH, WORLD_HEIGHT);
        graphics.setPaint(Color.white);
        graphics.drawRect(0, 0, WORLD_WIDTH - 1, WORLD_HEIGHT - 1);
        /* Draw all particles *************************************************/
        graphics.setPaint(Color.PINK);
        for (Particle p : filter.particles) {
            graphics.drawRect((int) p.x, (int) p.y, 1, 1);
        }
        /* Draw all landmarks *************************************************/
        graphics.setPaint(Color.RED);
        for (Point p : landmarks) {
            graphics.fillOval((int) p.x - 10, (int) p.y - 10, 20, 20);
        }
        /* Draw the robot *****************************************************/
        graphics.setPaint(Color.YELLOW);
        graphics.fillOval((int) robot.x - 2, (int) robot.y - 2, 4, 4);
        /* Show the best particle *********************************************/
        Particle p = filter.getBestParticle();
        graphics.setPaint(Color.BLUE);
        graphics.fillOval((int) p.x - 5, (int) p.y - 5, 10, 10);
        /* Show the average particle ******************************************/
        p = filter.getAverageParticle();
        graphics.setPaint(Color.GREEN);
        graphics.fillOval((int) p.x - 5, (int) p.y - 5, 10, 10);

        g.drawImage(image, 10, 40, rootPane);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jButton1.setText("Reset");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setText("0");

        jTextField2.setText("0");

        jLabel1.setText("Distance:");

        jLabel2.setText("Turn(deg):");

        jButton2.setText("Move");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(715, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(16, 16, 16)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(385, 385, 385)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    }//GEN-LAST:event_formWindowOpened

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        int x = evt.getX() - 10;
        int y = evt.getY() - 40;
        try {
            robot.set(x, y, 0, 0);
            float[] Z = robot.sense();
            String s = "[";
            for (float f : Z) {
                s += f + ", ";
            }
            s += "]";
            System.out.println(s);
            filter.resample(robot.sense());
        } catch (Exception ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.repaint();
        System.out.println(x + ", " + y);
    }//GEN-LAST:event_formMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setUp();
        this.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        float move = Float.parseFloat(jTextField1.getText());
        float turn = (float) Math.toRadians(Float.parseFloat(jTextField2.getText()));
        try {
            robot.move(turn, move);
            filter.move(turn, move);
            filter.resample(robot.sense());
        } catch (Exception ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
