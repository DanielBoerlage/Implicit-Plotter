//Open-Sourced
//Author - Philip Xu 2014
package implicitplot.graphics;

import java.awt.*;
import javax.swing.*;

public class MenuPanel extends JPanel{
	JMenuBar menuBar;
	JMenu file, preferences;
	JMenuItem file_open,file_save,file_add,file_etc;
	JMenuItem preferences_options, preferences_colors;

	public MenuPanel(){
		super();
		this.setLayout(null);

		menuBar = new JMenuBar();
		
		file = new JMenu("Files");
		preferences = new JMenu("Preferences");
		
		file_open = new JMenuItem("Open");
		file_save = new JMenuItem("Save");
		file_add = new JMenuItem("Add");
		file_etc = new JMenuItem("Etc.");

		preferences_options = new JMenuItem("Options");
		preferences_colors = new JMenuItem("Colors");
		
		file.add(file_open);
		file.add(file_save);
		file.addSeparator();
		file.add(file_open);
		file.addSeparator();
		file.add(file_etc);

		preferences.add(preferences_colors);
		preferences.addSeparator();
		preferences.add(preferences_options);

		menuBar.add(file);
		menuBar.add(preferences);

		menuBar.setBounds(0,0,menuBar.getPreferredSize().width,menuBar.getPreferredSize().height);
		this.add(menuBar);
	}


}