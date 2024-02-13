package gui;


import java.util.ArrayList;

import javax.swing.*;

import dijkstra.VertexInterface;
import maze.Maze;

import java.awt.*;

/**
 * Displaying panel supposed to draw the maze.
 * @author Hugo Queniat
 *
 */
public class MazeDisplayPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * MazeDisplayApp which is the app of origin.
	 */
	private final MazeDisplayApp mazeDisplayApp;
	
	/**
	 * MazeDisplayPanelMouseListener which is the mouse listener that listens to this panel.
	 */
	private final MazeDisplayPanelMouseListener mazeDisplayPanelMouseListener;
	
	/**
	 * Constructor for MazeDisplayPanel.
	 * @param mazeDisplayApp corresponding to the attribute mazeDisplayApp.
	 */
	public MazeDisplayPanel(MazeDisplayApp mazeDisplayApp) {
		this.mazeDisplayApp = mazeDisplayApp;
		mazeDisplayPanelMouseListener = new MazeDisplayPanelMouseListener(mazeDisplayApp);
		//The panel has to follow the action made by the user with his mouse, to have the maze edited accordingly.
		addMouseListener(mazeDisplayPanelMouseListener);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1440,750));
		notifyForUpdate();
	}
	
	/**
	 * Paints the picture in the panel.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		MazeDisplayAppModel model = mazeDisplayApp.getMazeDisplayAppModel();
		Maze maze = model.getMaze();
		int width = maze.getWidth();
		int length = maze.getLength();
		if (width*length!=0) {
			paintMaze(g, width, length, maze.getAllVertices());
			if (model.getDisplayingAuthorization()) {
				paintRoute(g, model.getMap(), width, length);
			}
		}
	}
	
	/**
	 * Divides the panel in sectors which the represents the maze's boxes and paints them according to their type (wall, open, arrival, departure).
	 * @param g Graphics holds all the info about the image drawn in the panel.
	 * @param width Int number of columns of the maze.
	 * @param length Int number of row of the maze.
	 * @param mazeBoxes ArrayList<VertexInterface> Maze's all vertices.
	 */
	private void paintMaze(Graphics g, int width, int length, ArrayList<VertexInterface> mazeBoxes) {
		int rectLength = 750/(length);
		int rectWidth = 1440/(width);
		setPreferredSize(new Dimension(rectWidth*(width), rectLength*(length)));
		mazeDisplayApp.setSize(new Dimension(rectWidth*(width)+17, rectLength*(length)+63));
		for (int j=0; j < length; j++) {
			for (int i=0; i < width; i++) {
					paintMBox(g, j, i, rectWidth, rectLength, mazeBoxes.get(i+j*width).getLabel());
				}
			}
	}
	
	/**
	 * Paints the required boxes that are on the shortest route from departure to arrival.
	 * @param g Graphics holds all the info about the image drawn in the panel.
	 * @param map Boolean[][] specifies if each box at coordinates (i,j) should or should not be painted (on the route or not).
	 * @param width Int number of columns of the maze.
	 * @param length Int number of row of the maze.
	 */
	private void paintRoute(Graphics g, boolean[][] map, int width, int length) {
		int rectLength = 750/(length);
		int rectWidth = 1440/(width);
		for (int j=0; j < length; j++) {
			for (int i=0; i < width; i++) {
					if (map[i][j]) {
						paintRouteBox(g, j, i, rectWidth, rectLength);
					}
			}
		}
	}
	
	/**
	 * Paints a specific box within the panel.
	 * @param g Graphics holds all the info about the image drawn in the panel.
	 * @param j Int longitudinal coordinate of the box.
	 * @param i Int lateral coordinate of the box.
	 * @param rectWidth Int width of the rectangle to be painted.
	 * @param rectLength Int length of the rectangle to be painted.
	 * @param label String type of the box to be painted.
	 */
	private void paintMBox(Graphics g, int j, int i, int rectWidth, int rectLength, String label) {
		if (label=="E") {
			g.setColor(Color.decode("#FAF7F5"));
			g.fillRect(i*rectWidth, j*rectLength, rectWidth, rectLength);
		}
		if (label=="W") {
			g.setColor(Color.decode("#6E6D6B"));
			g.fillRect(i*rectWidth, j*rectLength, rectWidth, rectLength);
		}
		if (label=="A") {
			g.setColor(Color.decode("#B83737"));
			g.fillRect(i*rectWidth, j*rectLength, rectWidth, rectLength);
		}
		if (label=="D") {
			g.setColor(Color.decode("#00C104"));
			g.fillRect(i*rectWidth, j*rectLength, rectWidth, rectLength);
		}
		g.setColor(Color.BLACK);
		g.drawRect(i*rectWidth, j*rectLength, rectWidth, rectLength);
	}
	
	/**
	 * Paints a box that is on the shortest route.
	 * @param g Graphics holds all the info about the image drawn in the panel.
	 * @param j Int longitudinal coordinate of the box.
	 * @param i Int lateral coordinate of the box.
	 * @param rectWidth Int width of the rectangle to be painted.
	 * @param rectLength Int length of the rectangle to be painted.
	 */
	private void paintRouteBox(Graphics g, int j, int i, int rectWidth, int rectLength) {
		g.setColor(Color.decode("#F6D81F"));
		g.fillRect(i*rectWidth, j*rectLength, rectWidth, rectLength);
		g.setColor(Color.BLACK);
		g.drawRect(i*rectWidth, j*rectLength, rectWidth, rectLength);
	}
	
	/**
	 * Reiterates the painting of the panel.
	 */
	public void notifyForUpdate() {
		// TODO Auto-generated method stub
		repaint();
	}

}
