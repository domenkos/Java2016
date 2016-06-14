
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableDisplay {
    JTable table;
    int startYY, stopYY;
    public JTableDisplay(Object[][] show, int st) {
        
        this.startYY = -2;
        this.stopYY = -2;
        
        JFrame frame = new JFrame("Izris");
        String[] names = new String[st];
        for (int i = 0; i < st; i++) {
            names[i] = "null";
        }
//        show[1][0] = "start";
//        show[4][4] = "stop";
//        JButton g1 = new JButton();
//        g1.setVisible(true);
//        g1.setSize(10,10);
//        g1.setText("Gumb");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        this.table = new JTable(show,names);
        this.table.setTableHeader(null);

        JScrollPane tableContainer = new JScrollPane(this.table);
        panel.add(tableContainer, BorderLayout.CENTER);
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);
        
    }
    public Object getValueAt(int i, int j){
        return this.table.getValueAt(i, j);
    }
    public void setValueAt(int i, int j, Object val){
        this.table.setValueAt(val, i, j);
    }
    
    public boolean[][] getWallsFromTable(int width, int height){
        boolean[][] res = new boolean[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if(String.valueOf(this.table.getValueAt(i,j)).toLowerCase().equals("X".toLowerCase())){
                    res[i][j] = true;
                }
                else if(String.valueOf(this.table.getValueAt(i,j)).toLowerCase().equals("O".toLowerCase())){
                    res[i][j] = false;
                }
                else if(String.valueOf(this.table.getValueAt(i,j)).toLowerCase().equals("start".toLowerCase())){
                    if(i == 0)
                        this.startYY = -1; // je i
                    else
                        this.startYY = i;
                    res[i][j] = false;
                }
                else if(String.valueOf(this.table.getValueAt(i,j)).toLowerCase().equals("stop".toLowerCase())){
                    if(i == 0)
                        this.stopYY = -1; // je i
                    else
                        this.stopYY = i;
                    res[i][j] = false;
                }
                else
                    res[i][j] = false;
            }
        }
        return res;
    }
 
//    public static void main(String[] args) {
//        String[] columnNames = {"First Name",
//                        "Last Name",
//                        "Sport",
//                        "# of Years",
//                        "Vegetarian"};
//        Object[][] data = {
//                        {"Kathy", "Smith",
//                         "Snowboarding", new Integer(5), new Boolean(false)},
//                        {"John", "Doe",
//                         "Rowing", new Integer(3), new Boolean(true)},
//                        {"Sue", "Black",
//                         "Knitting", new Integer(2), new Boolean(false)},
//                        {"Jane", "White",
//                         "Speed reading", new Integer(20), new Boolean(true)},
//                        {"Joe", "Brown",
//                         "Pool", new Integer(10), new Boolean(false)}
//                    };
//        JTableDisplay d1 = new JTableDisplay(data,5);
//        d1.startYY = 2;
//        d1.stopYY = 2;
//        System.out.println(d1.getValueAt((0), 0));
//    }

}