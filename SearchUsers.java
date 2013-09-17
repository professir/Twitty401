
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Query;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.User;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author BuckYoung
 */
public class SearchUsers extends javax.swing.JPanel {

    static String userName;
    static int pageNumber;

    /**
     * Creates new form SearchUsers
     */
    public SearchUsers() {
        initComponents();
        pageNumber = 1;
    }

    public SearchUsers(String text) {
        initComponents();
        peopleText.setText(text);
        pageNumber = 1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        peopleSearch = new javax.swing.JButton();
        peopleText = new javax.swing.JTextField();

        setBackground(new java.awt.Color(160, 200, 240));
        setMaximumSize(new java.awt.Dimension(350, 100));
        setMinimumSize(new java.awt.Dimension(350, 100));
        setPreferredSize(new java.awt.Dimension(350, 100));
        setSize(new java.awt.Dimension(350, 100));

        jPanel2.setBackground(new java.awt.Color(200, 240, 250));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Search People", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(0, 0, 204))); // NOI18N
        jPanel2.setMaximumSize(new java.awt.Dimension(330, 130));
        jPanel2.setPreferredSize(new java.awt.Dimension(330, 130));
        jPanel2.setSize(new java.awt.Dimension(330, 130));

        peopleSearch.setText("Search");
        peopleSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peopleSearchActionPerformed(evt);
            }
        });

        peopleText.setToolTipText("@friendsAndStrangers!");
        peopleText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peopleTextActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(peopleSearch)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(peopleText, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(14, 14, 14)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(peopleSearch)
                    .add(peopleText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void peopleSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peopleSearchActionPerformed
        search();
    }//GEN-LAST:event_peopleSearchActionPerformed

    private void peopleTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peopleTextActionPerformed
        search();
    }//GEN-LAST:event_peopleTextActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton peopleSearch;
    private javax.swing.JTextField peopleText;
    // End of variables declaration//GEN-END:variables

    /*
     * Adds in a search panel without calling mainReset or Repaint
     * FOR USE: inserting at top of tweet's when loading a search result or trend result
     */
    public static void addSearchUsersPanel(Query query) {
        SearchUsers searchUsers = new SearchUsers(query.getQuery());
        MainGUI.addToMainPanel(searchUsers);
    }


    /*
     * Search and create list
     */
    public static void populateSearch() throws TwitterException {
        //get a userlist
        ResponseList<User> userList = Twitty401.twitter.searchUsers(SearchUsers.getUserName(), SearchUsers.getPageNumber());
        //add founduser items to the list
        UserList.createUserList(userList);
        //repaint main
        MainGUI.repaintMainPanel();
        //add loadmore button!
        LoadMore.addLoadMore(LoadMore.PanelType.SEARCHUSER);
    }

    /*
     * Access
     */
    private static void setUserName(String userName) {
        SearchUsers.userName = userName;
    }

    private static String getUserName() {
        return userName;
    }

    private static int getPageNumber() {
        return pageNumber;
    }

    private static void setPageNumber(int num) {
        SearchUsers.pageNumber = num;
    }

    /*
     * increments page and populates search
     * 
     */
    public static void loadMore() {
        SearchUsers.setPageNumber(SearchUsers.getPageNumber() + 1);

        try {
            populateSearch();
        } catch (TwitterException ex) {
            LoadMore.showNoMore();
        }
    }

    /*
     * when the button is action'd in this panel
     */
    private void search() {
        if (peopleText != null) {
            SearchUsers.setUserName(peopleText.getText());
            SearchUsers.setPageNumber(1);
            MainGUI.resetMainPanel();
            addSearchUsersPanel(new Query(getUserName()));
            MainGUI.setWaiting();
            try {
                SearchUsers.populateSearch();
            } catch (TwitterException ex) {
                Logger.getLogger(SearchUsers.class.getName()).log(Level.SEVERE, null, ex);
            }
            MainGUI.setDoneWaiting();

        }
    }
}
