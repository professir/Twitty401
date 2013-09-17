
import javax.swing.Box;
import twitter4j.Query;

//TODO: CLEAN THIS UP IT IS REAL BAD
//TODO: Parse Text field for @-sign at beginning -- if so call a seperate method for userSearch

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author BuckYoung
 */
public class SearchPanel extends javax.swing.JPanel {
    /**
     * Creates new form SearchPanel
     */
    public SearchPanel() {
        initComponents();
    }

    public SearchPanel(String text) {
        initComponents();
        searchTextField.setText(text);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        jButton1.setText("jButton1");

        setBackground(new java.awt.Color(160, 200, 240));
        setMaximumSize(new java.awt.Dimension(350, 100));
        setMinimumSize(new java.awt.Dimension(350, 100));
        setPreferredSize(new java.awt.Dimension(350, 100));

        jPanel1.setBackground(new java.awt.Color(200, 240, 250));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Search Tweets", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(0, 0, 204))); // NOI18N
        jPanel1.setMaximumSize(new java.awt.Dimension(350, 130));
        jPanel1.setPreferredSize(new java.awt.Dimension(330, 130));
        jPanel1.setSize(new java.awt.Dimension(330, 130));

        searchTextField.setToolTipText("#trendsAndTweets!");
        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });
        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyReleased(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(searchTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(searchButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(14, 14, 14)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(searchTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(searchButton))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
        if (searchTextField != null) {
            SearchPanel.search(searchTextField.getText());
        }
    }//GEN-LAST:event_searchTextFieldActionPerformed

    /*
     * Internal Search
     */
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        if (searchTextField != null) {
            SearchPanel.search(searchTextField.getText());
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyReleased
    }//GEN-LAST:event_searchTextFieldKeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    // End of variables declaration//GEN-END:variables

    /*
     * External search for Global trends
     * Also creates timeline
     */
    public static void search(String search) {
        MainGUI.setWaiting();
        Query query = new Query();
        query.setCount(20);
        query.setQuery(search);
        Timeline.createTimeline(Timeline.Type.SEARCH, null, query);
        MainGUI.setDoneWaiting();
    }

    /*
     * creates a search panel from Home
     */
    public static void createSearchPanel() {
        SearchPanel searchPanel = new SearchPanel();
        SearchUsers searchUser = new SearchUsers();
        MainGUI.resetMainPanel();
        MainGUI.addToMainPanel(searchPanel);
        MainGUI.addToMainPanel(searchUser);
        MainGUI.addToMainPanel(Box.createVerticalGlue());
        MainGUI.repaintMainPanel();
    }

    /*
     * Adds in a search panel without calling mainReset or Repaint
     * FOR USE: inserting at top of tweet's when loading a search result or trend result
     */
    public static void addSearchPanel(Query query) {
        SearchPanel searchPanel = new SearchPanel(query.getQuery());
        MainGUI.addToMainPanel(searchPanel);
    }
}