package model;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Game {
	public JLabel createDisplayImage(String fileNameRelativeToClassFile) {
		JLabel retVal = new JLabel();
		java.net.URL imgURL = this.getClass().getResource(fileNameRelativeToClassFile);
		if (imgURL == null) {
			throw new IllegalArgumentException("Couldn't find file " + fileNameRelativeToClassFile);
		}
		System.out.println(imgURL.toString());
		ImageIcon cardImage = new ImageIcon(imgURL);
		retVal.setIcon(cardImage);
		Dimension d = new Dimension(cardImage.getIconWidth() + 10, cardImage.getIconHeight() + 10);
		retVal.setSize(d);
		retVal.setPreferredSize(d);

		System.out.println("here");
		retVal.setMaximumSize(d);
		retVal.setMinimumSize(d);
		return retVal;
	}
}
