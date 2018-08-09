
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2018
 *    Level 1
 */

import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class MediaPalace {

	public JLabel loadImageFromTheInternet(String imageURL) throws MalformedURLException {
		URL url = new URL(imageURL);
		Icon icon = new ImageIcon(url);
		return new JLabel(icon);
	}

	/*
	 * To use this method, the image must be placed in your Eclipse project in the
	 * same package as this class.
	 */
	public JLabel loadImageFromWithinProject(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

	/*
	 * To use this method, pass in the full path of the image.
	 */
	public JLabel loadImageFromHardDrive(String filePath) {
		Icon icon = new ImageIcon(filePath);
		return new JLabel(icon);
	}

	/*
	 * To use this method, you must first download JLayer:
	 * http://www.javazoom.net/javalayer/javalayer.html, and add the jar to project.
	 * Then uncomment this method.
	 */
	// private void playMp3FromComputer(String fileName) throws JavaLayerException {
	// FileInputStream songStream = new FileInputStream(fileName);
	//
	// final Player playMp3 = new Player(songStream);
	//
	// Thread t = new Thread() {
	// public void run() {
	// try {
	// playMp3.play();
	// } catch (JavaLayerException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// };
	// t.start();
	// }

	/* This method will use your default mp3 player to play the song */
	public void playMusicOnComputer(String fileName) {
		File fileToPlay = new File(fileName);
		try {
			java.awt.Desktop.getDesktop().open(fileToPlay);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/*
	 * If you want to use an mp3, you must first convert it to a .wav file on
	 * http://media.io
	 */
	public AudioClip loadSound(String fileName) {
		return JApplet.newAudioClip(getClass().getResource(fileName));
	}

	public void playSoundFromInternet(String soundURL) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new URL(soundURL));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			Thread.sleep(500);
		} catch (Exception ex) {
			System.out.println("Problem playing sound: " + soundURL);
			ex.printStackTrace();
		}
	}

	void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

public class MagicBox extends JPanel implements Runnable, MouseListener {

	/*
	 * Work together as a TEAM of 2 or 3 to make this project. We are going to hide
	 * secrets within the magic box. When the user clicks on a secret place, stuff
	 * will happen.
	 * 
	 * 1. Make the frame respond to mouse clicks.
	 * 
	 * 2. When the mouse is clicked, use the Media Palace (bit.ly/media-palace) to
	 * play sounds, show images or speak.
	 * 
	 * 3. backgroundImage.getRGB(keyEvent.getX(), keyEvent.getY()) will give you the
	 * color of the current pixel.
	 */
	JFrame frame;

	BufferedImage backgroundImage;

	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeLater(new MagicBox());

	}

	@Override
	public void run() {
		try {
			loadBackgroundImage();
			createUI();
		} catch (Exception w) {
			System.err.println(w.getMessage());
		}
	}

	private void createUI() {
		frame = new JFrame("The Magic Box contains many secrets...");
		frame.add(this);
		setPreferredSize(new Dimension(backgroundImage.getWidth(), backgroundImage.getHeight()));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addMouseListener(this);
	}

	private void loadBackgroundImage() throws Exception {
		String imageFile = "src/magic-box.jpg";
		try {
			backgroundImage = ImageIO.read(new File(imageFile));
		} catch (IOException e) {
			throw new Exception("Could not load image: " + imageFile);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(backgroundImage, 0, 0, null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JFrame f = (JFrame) e.getSource();
		if (f.equals(frame)) {

		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
