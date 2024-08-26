/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package CHKB_DESIGN;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class ThongBao extends javax.swing.JDialog {

    private final JFrame fram;
    private Animator animator;
    private Glass glass;
    private boolean show;
    private MessageType messageType = MessageType.CANCEL;
    
    public ThongBao(JFrame fram) {
        super(fram, true);
        this.fram = fram;
        initComponents();
        init();
    }
    
    private void init() {
        setBackground(new Color(0, 0, 0, 0));
        StyledDocument doc = txt_one.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        txt_one.setOpaque(false);
        txt_one.setBackground(new Color(0, 0, 0, 0));
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeMessage();
            }
        });
        animator = new Animator(350, new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                float f = show ? fraction : 1f - fraction;
                glass.setAlpha(f - f * 0.3f);
                setOpacity(f);
            }

            @Override
            public void end() {
                if (show == false) {
                    dispose();
                    glass.setVisible(false);
                }
            }
        });
        animator.setResolution(0);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
        setOpacity(0f);
        glass = new Glass();
    }

    private void startAnimator(boolean show) {
        if (animator.isRunning()) {
            float f = animator.getTimingFraction();
            animator.stop();
            animator.setStartFraction(1f - f);
        } else {
            animator.setStartFraction(0f);
        }
        this.show = show;
        animator.start();
    }

    public void showMessage(String tieuDe, String noiDung) {
        fram.setGlassPane(glass);
        glass.setVisible(true);
        lbTitle_one.setText(tieuDe);
        txt_one.setText(noiDung);
        setLocationRelativeTo(fram);
        startAnimator(true);
        setVisible(true);
    }
    
    public void showMessage(String tieuDe, String noiDung, String noiDungNut) {
        fram.setGlassPane(glass);
        glass.setVisible(true);
        lbTitle_one.setText(tieuDe);
        txt_one.setText(noiDung);
        btn_dongY_one.setText(noiDungNut);
        setLocationRelativeTo(fram);
        startAnimator(true);
        setVisible(true);
    }
    
    public void showMessageSetIcon(String tieuDe, String noiDung, String duongDanAnh) {
        fram.setGlassPane(glass);
        glass.setVisible(true);
        lbTitle_one.setText(tieuDe);
        txt_one.setText(noiDung);
        lbIcon_one.setIcon(new ImageIcon(getClass().getResource(duongDanAnh)));
        setLocationRelativeTo(fram);
        startAnimator(true);
        setVisible(true);
    }
    
      public void showMessage(String tieuDe, String noiDung, String noiDungNut, String duongDanAnh) {
        fram.setGlassPane(glass);
        glass.setVisible(true);
        lbTitle_one.setText(tieuDe);
        txt_one.setText(noiDung);
        btn_dongY_one.setText(noiDungNut);
        lbIcon_one.setIcon(new ImageIcon(getClass().getResource(duongDanAnh)));
        setLocationRelativeTo(fram);
        startAnimator(true);
        setVisible(true);
    }

    public void closeMessage() {
        startAnimator(false);
    }

    public MessageType getMessageType() {
        return messageType;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundDialogRound = new CHKB_DESIGN.BackgroundDialogRound();
        lbTitle_one = new javax.swing.JLabel();
        txt_one = new javax.swing.JTextPane();
        lbIcon_one = new javax.swing.JLabel();
        btn_dongY_one = new CHKB_DESIGN.ButtonGradientRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        backgroundDialogRound.setBackground(new java.awt.Color(255, 255, 255));
        backgroundDialogRound.setRound(20);

        lbTitle_one.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTitle_one.setForeground(new java.awt.Color(255, 0, 0));
        lbTitle_one.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle_one.setText("Message Title");

        txt_one.setEditable(false);
        txt_one.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txt_one.setForeground(new java.awt.Color(76, 76, 76));
        txt_one.setText("Message Text\nSimple");
        txt_one.setFocusable(false);

        lbIcon_one.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcon_one.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CHKB_IMAGE/question_icon_55.png"))); // NOI18N

        btn_dongY_one.setText("Đồng ý");
        btn_dongY_one.setBoGoc(50);
        btn_dongY_one.setColor1(new java.awt.Color(0, 255, 255));
        btn_dongY_one.setColor2(new java.awt.Color(51, 255, 51));
        btn_dongY_one.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_dongY_one.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dongY_oneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundDialogRoundLayout = new javax.swing.GroupLayout(backgroundDialogRound);
        backgroundDialogRound.setLayout(backgroundDialogRoundLayout);
        backgroundDialogRoundLayout.setHorizontalGroup(
            backgroundDialogRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbIcon_one, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbTitle_one, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
            .addComponent(txt_one)
            .addGroup(backgroundDialogRoundLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(btn_dongY_one, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backgroundDialogRoundLayout.setVerticalGroup(
            backgroundDialogRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundDialogRoundLayout.createSequentialGroup()
                .addComponent(lbIcon_one, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lbTitle_one)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_one, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_dongY_one, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundDialogRound, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundDialogRound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_dongY_oneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dongY_oneActionPerformed
        messageType = MessageType.OK;
        closeMessage();
    }//GEN-LAST:event_btn_dongY_oneActionPerformed

    public static enum MessageType {
        CANCEL, OK
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CHKB_DESIGN.BackgroundDialogRound backgroundDialogRound;
    private CHKB_DESIGN.ButtonGradientRound btn_dongY_one;
    private javax.swing.JLabel lbIcon_one;
    private javax.swing.JLabel lbTitle_one;
    private javax.swing.JTextPane txt_one;
    // End of variables declaration//GEN-END:variables
}
