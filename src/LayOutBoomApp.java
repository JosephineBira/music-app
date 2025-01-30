import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LayOutBoomApp{

    public LayOutBoomApp(){
         this.PrepareBorderFrame();

    }

    public JFrame PrepareBorderFrame(){
        JFrame MusicApp = new JFrame("MusicApp LayOut");

        MusicApp.setExtendedState(JFrame.MAXIMIZED_BOTH);
        MusicApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MusicApp.setLayout(new BorderLayout());

        JLabel north = new JLabel("My Music Catalogue", JLabel.CENTER);
        north.setFont(new Font("Arial", Font.BOLD,25));
        MusicApp.add(north, BorderLayout.NORTH);


        JPanel south = new JPanel();
        JButton SubmitButton = new JButton("Submit");
        JButton ExitButton = new JButton("Exit");
        south.add(SubmitButton);
        south.add(ExitButton);
        MusicApp.add(south, BorderLayout.SOUTH);

        String[] Genre = {"Rap","Soul music ","RnB","hip pop","Country"};
        JList<String> CategoryList = new JList<>(Genre);
        CategoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane CategoryScrollPane =  new JScrollPane(CategoryList);
        MusicApp.add(CategoryScrollPane, BorderLayout.WEST);

        JPanel centre = new JPanel(new GridLayout(5,3));
        centre.add(new JLabel("Artist Name:"));
        JTextField artistField = new JTextField();
        centre.add(artistField);

        centre.add(new JLabel("Recording Studio:"));
        JTextField studioField = new JTextField();
        centre.add(studioField);

        centre.add(new JLabel("PlayList:"));
        JTextField PlaylistField = new JTextField();
        centre.add(PlaylistField);

        centre.add(new JLabel("Albums:"));
        JTextField AlbumsField = new JTextField();
        centre.add(AlbumsField);

        centre.add(new JLabel("Category:"));JComboBox<String> categoryComboBox = new JComboBox<>(Genre);
        centre.add(categoryComboBox);

        centre.add(new JLabel("Available:"));
        JCheckBox availableCheckBox = new JCheckBox();
        centre.add(availableCheckBox);
        MusicApp.add(centre,BorderLayout.CENTER);


        MusicApp.setVisible(true);

        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String artist = artistField.getText();
                String studio = studioField.getText();
                String PlayList=PlaylistField.getText();
                String Albums=AlbumsField.getText();
                String category = (String) categoryComboBox.getSelectedItem();
                boolean available = availableCheckBox.isSelected();

                System.out.println("Artist: " + artist);
                System.out.println("Studio: " + studio);
                System.out.println("PlayList: " + PlayList);
                System.out.println("Albums: " + Albums);
                System.out.println("Category: "+ category);
                System.out.println("Available: "+ available);
            }
        });
        ExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
        }
     });
        return MusicApp;
    }

}