/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BuckYoung
 */
public class LoadMore extends javax.swing.JPanel {

    /**
     * Creates new form LoadMore
     */
    public enum PanelType { TIMELINE, SEARCHUSER, FOLLOW };
    private static LoadMore loadMorePanel = new LoadMore();
    private static PanelType type;
    
    private LoadMore() {
        initComponents();
        jButton1.setText("     Load More     ");
    }
    
    /*
     * ensures single loadmore button
     */
    public static void addLoadMore(PanelType type){
        hideNoMore();
        MainGUI.addToMainPanel(loadMorePanel);
        LoadMore.type = type;
    }

    public static void showNoMore(){
         loadMorePanel.jButton1.setVisible(false);
        loadMorePanel.noMore.setVisible(true);
    }
    public static void hideNoMore(){
        loadMorePanel.noMore.setVisible(false);
        loadMorePanel.jButton1.setVisible(true);
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
        noMore = new javax.swing.JLabel();

        setBackground(new java.awt.Color(160, 200, 240));
        setMaximumSize(new java.awt.Dimension(350, 30));
        setMinimumSize(new java.awt.Dimension(350, 30));
        setPreferredSize(new java.awt.Dimension(350, 30));
        setSize(new java.awt.Dimension(350, 30));

        jButton1.setText("Load More Tweets!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        noMore.setForeground(new java.awt.Color(250, 50, 50));
        noMore.setText("No More!");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(93, 93, 93)
                        .add(jButton1))
                    .add(layout.createSequentialGroup()
                        .add(140, 140, 140)
                        .add(noMore)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(noMore)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MainGUI.setWaiting();
        if (LoadMore.type == LoadMore.PanelType.TIMELINE){
            Timeline.loadMore();
        } else if (LoadMore.type == LoadMore.PanelType.SEARCHUSER){
            SearchUsers.loadMore();
        } else if (LoadMore.type == LoadMore.PanelType.FOLLOW){
            FollowPanel.loadMore();
        }
        MainGUI.setDoneWaiting();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel noMore;
    // End of variables declaration//GEN-END:variables
}
