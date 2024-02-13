package gui;

import java.util.ArrayList;

import javax.swing.event.*;

import dijkstra.*;
import maze.*;

/**
 * Models the maze that is displayed in a panel.
 * @author Hugo Queniat
 *
 */
public class MazeDisplayAppModel {
	
	/**
	 * Maze which the maze modeled.
	 */
	private Maze maze;
	
	/**
	 * Boolean which represents if the maze modeled has been saved.
	 */
	private boolean modifiedStatus = false;
	
	/**
	 * Boolean[][] that holds the information if a vertex (i,j) belongs to the route between departure and arrival through the maze.
	 */
	private boolean[][] map = new boolean[0][0];
	
	/**
	 * String describing what box should be the next box modified.
	 */
	private String boxSelected = null;
	
	/**
	 * Boolean which is the authorization to edit the maze.
	 */
	private boolean editingAuthorization = true;
	
	/**
	 * Boolean which is the authorization to dispklay the shortest route.
	 */
	private boolean displayingAuthorization = false;
	
	/**
	 * ArrayList<ChangeListener> which is a set of the objects supposed to be notified when the model changes.
	 */
	private ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>();
	
	/**
	 * MazeDisplayApp which is the app of origin.
	 */
	private MazeDisplayApp mazeDisplayApp;
	
	/**
	 * Getter for the attribute modifiedStatus.
	 * @return modifiedStatus boolean
	 */
	public boolean isModified() {
		return modifiedStatus;
	}
	
	/**
	 * Setter for the attribute modifiedStatus.
	 * @param bool Boolean that'll be the new modifiedStatus.
	 */
	public void setModifiedStatus(boolean bool) {
		modifiedStatus = bool;
	}
	
	/**
	 * Asks the model to save the associated maze to the address specified.
	 * @param address String which is the address where the maze should be saved.
	 * @throws MazeIOException Exception thrown if an exception occurs while handling the streams associated with the file to be saved at the issued address.
	 */
	public void saveToFile(String address) throws MazeIOException {
		maze.saveToTextFile(address);
		modifiedStatus =false;
	}
	
	/**
	 * Setter for boxSelected.
	 * @param label String which will be the future state of boxSelected.
	 */
	public void setBoxSelected(String label) {
		boxSelected = label;
	}
	
	/**
	 * Adds the listener to the ArrayList listeners.
	 * @param listener ChangeListener to be added to listeners.
	 */
	public void addObserver(ChangeListener listener) {
		listeners.add(listener);
	}
	
	/**
	 * Informs every listener that changes have been made, allowing them to adjust.
	 */
	public void stateChanges() {
		ChangeEvent evt = new ChangeEvent(this);
		for (ChangeListener listener : listeners) {
			listener.stateChanged(evt);
		}
	}
	
	/**
	 * Constructor of a MazeDisplayAppModel.
	 * @param width Int which will be the width of the associated maze.
	 * @param length Int which will be the length of the associated maze.
	 * @param mazeDisplayApp Original app.
	 */
	public MazeDisplayAppModel(int width, int length, MazeDisplayApp mazeDisplayApp) {
		maze = new Maze(width, length);
		this.mazeDisplayApp = mazeDisplayApp;
		stateChanges();
		modifiedStatus = (width*length!=0);	
	}
	
	/**
	 * Modifies the Model by opting for a new maze with new dimensions. Therefore, automatically changes the view to editing.
	 * @param width Int which will be the width of the associated maze.
	 * @param length Int which will be the length of the associated maze
	 */
	public void setMazeDisplayAppModel(int width, int length) {
		maze = new Maze(width, length);
		editingAuthorization = true;
		displayingAuthorization = false;
		mazeDisplayApp.getMazeDisplayMenuBar().getMazeMenu().getEditingMenuItem().setState(true);
		mazeDisplayApp.getMazeDisplayMenuBar().getMazeMenu().getSolveMenuItem().setState(false);
		stateChanges();
		modifiedStatus = true;
	}
	
	/**
	 * Modifies the Model via loading a previously created Maze that has been saved to a txt file.
	 * @param address String which is the address the maze should be loaded from.
	 * @throws MazeReadingException Exception that can happen if there is an unknown character in the file or the different lines have different lengths.
	 * @throws MazeIOException Exception that can happen if there is an issue while handling the file pointed by address
	 * @throws MazeStructureException Exception that can happen if the saved maze exceeds the limites dimensions.
	 */
	public void initFromFile(String address) throws MazeReadingException, MazeIOException, MazeStructureException {
		maze.initFromTextFile(address);
		editingAuthorization = true;
		displayingAuthorization = false;
		modifiedStatus = false;
		mazeDisplayApp.getMazeDisplayMenuBar().getMazeMenu().getEditingMenuItem().setState(true);
		mazeDisplayApp.getMazeDisplayMenuBar().getMazeMenu().getSolveMenuItem().setState(false);
		stateChanges();
	}
	
	/**
	 * Getter for the associated maze.
	 * @return Maze that corresponds to the one that is displayed.
	 */
	public Maze getMaze() {
		return maze;
	}
	
	/**
	 * Handles the event of a click occurring within the panel where the model is displayed.
	 * @param x Int which is the lateral coordinate where the click happened.
	 * @param y Int which is the longitudinal coordinate where the click happened.
	 */
	public void mouseClick(int x, int y) {
		int length = maze.getLength();
		int width = maze.getWidth();
		if (length*width!=0){
			int rectLength = 750/length;
			int rectWidth = 1440/width;
			if (editingAuthorization && boxSelected!=null && (x<=(width)*rectWidth) && (y<=((length)*rectLength))) {
				int xBox = (x/rectWidth);
				int yBox = (y/rectLength);
				if (boxSelected=="E") {maze.modifySpecifiedMBoxIntoEBox(xBox,yBox);}
				if (boxSelected=="A") {maze.modifySpecifiedMBoxIntoABox(xBox,yBox);}
				if (boxSelected=="D") {maze.modifySpecifiedMBoxIntoDBox(xBox,yBox);}
				if (boxSelected=="W") {maze.modifySpecifiedMBoxIntoWBox(xBox,yBox);}
				stateChanges();
				modifiedStatus = true;
			}
		}
	}
	
	/**
	 * Setter for the EditingAuthorisation.
	 * @param status Boolean which will be the future EditingAuthorisation.
	 */
	public void setEditingAuthorization(boolean status) {
		editingAuthorization = status;
	}
	
	/**
	 * Getter for map.
	 * @return map
	 */
	public boolean[][] getMap() {
		return map;
	}
	
	/**
	 * Determines the shortest route through the maze from departure to arrival by editing map.
	 * @throws MazeException
	 */
	public void displayShortestRoute() throws MazeException {
		MBox departure = (MBox) maze.getDeparture();
		VertexInterface currentVertex = maze.getArrival();
		PreviousInterface previous = Dijkstra.dijkstra(maze,departure);
		map = new boolean[maze.getWidth()][maze.getLength()];
		if ((previous.getFather(currentVertex)==null)) {
			throw new MazeException("There is no route through the maze from the departure box to the arrival box.");
		}
		while ((!(previous.getFather(currentVertex)==null)) && (!(previous.getFather(currentVertex).equals(departure)))){
			MBox father = (MBox) previous.getFather(currentVertex);
			map[father.getX()][father.getY()]= true;
			currentVertex = previous.getFather(currentVertex);
		}
		stateChanges();
	}
	
	/**
	 * Getter for DisplayingAuthorisation.
	 * @return displayingAuthorisation.
	 */
	public boolean getDisplayingAuthorization() {
		return displayingAuthorization;
	}
	
	/**
	 * Setter for DisplayingAuthorisation.
	 * @param status Boolean which will be the future DisplayingAuthorisation.
	 */
	public void setDisplayingAuthorisation(boolean status) {
		displayingAuthorization = status;
		stateChanges();
	}

}
