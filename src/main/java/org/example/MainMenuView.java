package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ListIterator;

public class MainMenuView extends JFrame {

    public MainMenuView(MainMenuFiles files) {

        // Create main frame
        super("Cook Helper");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());

        // Create JList and add files
        DefaultListModel<String> listModel = new DefaultListModel<>();
        ListIterator<String> fileIterator = files.filesIterator();
        while (fileIterator.hasNext()) {
            listModel.addElement(fileIterator.next());
        }
        JList<String> fileList = new JList<>(listModel);
        fileList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane(fileList);
        this.add(scrollPane, BorderLayout.CENTER);

        // Add 'Select Files' button
        SelectFilesButton selectFilesButton = new SelectFilesButton(this, listModel);
        this.add(selectFilesButton, BorderLayout.NORTH);

        // Add main menu button panel
        MainMenuButtonPanel mainMenuButtonPanel = new MainMenuButtonPanel(this, listModel, fileList);
        this.add(mainMenuButtonPanel, BorderLayout.EAST);
    }

    public void display() {

        // Make main menu visible
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
