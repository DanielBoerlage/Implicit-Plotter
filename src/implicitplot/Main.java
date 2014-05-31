package implicitplot;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import implicitplot.equations.*;

public class Main {

	public static void main(String[] args) {
		/*
		//Components
		JFrame login = new JFrame();
		JPanel panel = new JPanel();
		JLabel w = new JLabel("Enter Width Here:");
		JLabel h = new JLabel("Enter Height Here:");
		JTextField width = new JTextField(6);
		JTextField height = new JTextField(6);
		JButton start = new JButton("Start");

		//Frame setup
		login.add(panel);
		login.setVisible(true);
        login.setBounds(100, 100, 365, 170);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setLocationRelativeTo(null);
        login.setTitle("Implicit Plotter");

        //Panel and component positioning code.
        panel.setLayout(null);
        Insets insets = panel.getInsets();
        Dimension size1 = width.getPreferredSize();
        Dimension size2 = w.getPreferredSize();
        Dimension size3 = h.getPreferredSize();
        panel.add(w);
        panel.add(width);
        panel.add(h);
        panel.add(height);
        panel.add(start);
        width.setBounds(150 + insets.left, 30 + insets.top,size1.width, size1.height);
        height.setBounds(150 + insets.left, 80 + insets.top,size1.width, size1.height);
        w.setBounds(25 + insets.left, 30 + insets.top,size2.width, size2.height);
        h.setBounds(25 + insets.left, 80 + insets.top,size3.width, size3.height);
        start.setBounds(250,30,70,70);

        //Button Listener
        start.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
            	int x = Integer.parseInt(width.getText());
            	int y = Integer.parseInt(height.getText());
                implicitplot.graphics.Client.guiInit(x,y);
            }
        });*/
		eqnTest();
	}

	public static void eqnTest() {
		//this example string would be  x^2 - 1   or   minus(mult(x,x),1)
		/*ParseTree tree = new Function(Function.Type.MINUS);
		tree.children = new ParseTree[2];
		tree.children[0] = new Function(Function.Type.MULT);
		tree.children[0].children = new ParseTree[2];
		tree.children[0].children[0] = new Variable(Variable.Type.X);
		tree.children[0].children[1] = new Variable(Variable.Type.X);
		tree.children[1] = new Constant(1d);*/

		//ParseTree tree = new Variable(Variable.Type.X);

		/*ParseTree tree = new Function(Function.Type.MINUS);
		tree.addChild(new Function(Function.Type.MULT));
		tree.addChild(new Constant(1d));
		tree.children[0].addChild(new Variable(Variable.Type.X));
		tree.children[0].addChild(new Variable(Variable.Type.X));*/

		ParseTree tree = new Function(Function.Type.MINUS);
		tree.addChild(new Function(Function.Type.MULT));
		tree.addChild(new Constant(1d));
		tree.children[0].addChild(new Variable(Variable.Type.X));
		tree.children[0].addChild(new Variable(Variable.Type.X));

		long startTime = System.currentTimeMillis();
		double var = 0;
		for(int i = 0; i < 100001; i++)
			var = tree.evaluate(var, 0);
		System.out.println("result: " + var + "  computed in " + (System.currentTimeMillis() - startTime) + " ms");
	}
}