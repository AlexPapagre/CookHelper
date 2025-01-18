package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ListIterator;

public class MainMenuView extends JFrame {
    private MainMenuModel model;

    public MainMenuView(MainMenuModel model) {

        // Create main frame
        super("Cook Helper");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.model = model;

        // Create JList and add files
        DefaultListModel<String> listModel = new DefaultListModel<>();
        ListIterator<String> fileIterator = model.filesIterator();
        while (fileIterator.hasNext()) {
            listModel.addElement(fileIterator.next());
        }
        JList<String> fileList = new JList<>(listModel);
        fileList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(fileList);
        this.add(scrollPane, BorderLayout.CENTER);

        // Add 'Select Files' button
        SelectFilesButton selectFilesButton = new SelectFilesButton(this, listModel);
        this.add(selectFilesButton, BorderLayout.NORTH);

        // Add 'Buttons' panel
        MainMenuButtonPanel mainMenuButtonPanel = new MainMenuButtonPanel(this, fileList);
        this.add(mainMenuButtonPanel, BorderLayout.EAST);

        // Make main menu visible
        this.setVisible(true);
    }
}
