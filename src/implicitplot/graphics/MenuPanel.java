//Author - Philip Xu 2014
package implicitplot.graphics;

import java.awt.*;
import javax.swing.*;

public class MenuPanel extends JPanel{
	private Dimension size;
	JMenuBar menuBar;
	JMenu file, preferences;
	JMenuItem file_open,file_save,file_add,file_etc;
	JMenuItem preferences_options, preferences_colors;

	public MenuPanel(Dimension d){
		super();
		this.size = d;
		menuBarSetup();
		panelSetup();
	}

	public Dimension getPreferredSize(){
        return this.size;
    }

	public void panelSetup(){
		this.setLayout(null);
		this.add(menuBar);
	}

	public void menuBarSetup(){
		menuBar = new JMenuBar();
		fileMenuSetup();
		preferencesMenuSetup();
		menuBar.add(file);
		menuBar.add(preferences);
		menuBar.setBounds(0,0,menuBar.getPreferredSize().width,menuBar.getPreferredSize().height);
	}

	public void fileMenuSetup(){
		file = new JMenu("Files");
		file_open = new JMenuItem("Open");
		file_save = new JMenuItem("Save");
		file_add = new JMenuItem("Add");
		file_etc = new JMenuItem("Etc.");

		file.add(file_open);
		file.add(file_save);
		file.addSeparator();
		file.add(file_open);
		file.addSeparator();
		file.add(file_etc);
	}

	public void preferencesMenuSetup(){
		preferences = new JMenu("Preferences");
		preferences_options = new JMenuItem("Options");
		preferences_colors = new JMenuItem("Colors");
		preferences.add(preferences_colors);
		preferences.addSeparator();
		preferences.add(preferences_options);
	}

}