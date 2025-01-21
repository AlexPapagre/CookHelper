package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

import static org.example.Main.logger;

public class MainMenuView extends JFrame {

    public MainMenuView(MainMenuFiles files) {

        // Create main frame
        super("Cook Helper");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());

        // Create JList and add files
        DefaultListModel<String> listModel = new DefaultListModel<>();
        Iterator<String> fileIterator = files.filesIterator();
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

        logger.log("Opening GUI");
        if (files.filesIterator().hasNext()) {
            logger.log("Selected Files: " + Convertor.convertFileNames(files.filesIterator()));
        }

        // Make main menu visible
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
