package maze;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import dijkstra.GraphInterface;
import dijkstra.VertexInterface;

/**
 * A certain type of graph : a maze which is formed by boxes and where all edges are either weighed 1 or 0 (1 if the boxes are  and not walls and 0 otherwise).
 * @author Hugo Queniat
 *
 */
public class Maze implements GraphInterface {
	
	/**
	 * Int which is the number of columns of the maze.
	 */
	private int Width;

	/**
	 * Int which is the number of rows of the maze.
	 */
	private int Length;
	
	/**
	 * ArrayList<VertexInterface> which is the set of boxes that are in the maze.
	 */
	private ArrayList<VertexInterface> boxes;
	
	public ArrayList<VertexInterface> getAllVertices() {
		return boxes;
	}
	
	/**
	 * Getter for Width.
	 * @return Width
	 */
	public int getWidth() {
		return Width;
	}
	
	/**
	 * Getter for Length.
	 * @return Length
	 */
	public int getLength() {
		return Length;
	}
	
	/**
	 * Constructor for the Maze.
	 * @param width Int number of columns of the future maze.
	 * @param length Int number of rows of the future maze.
	 */
	public Maze(int width, int length) {
		this.Width = width;
		this.Length = length;
		boxes = new ArrayList<VertexInterface>(0);
		for (int j = 0; j < length; j++) {
			for (int i = 0; i < width; i++) {
				boxes.add(new EBox(i,j,this));
			}
		}
	}
	
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {
		ArrayList<VertexInterface> result = new ArrayList<VertexInterface>();
		MBox box = (MBox) vertex;
		int X = box.getX();
		int Y = box.getY();
		if ((X-1) >=0) {addPotentialSuccessor(result, getSpecificBox(X-1,Y));}
		if ((Y-1) >=0) {addPotentialSuccessor(result, getSpecificBox(X,Y-1));}
		if ((X+1)<(Width)){addPotentialSuccessor(result, getSpecificBox(X+1,Y));}
		if ((Y+1)<(Length)) {addPotentialSuccessor(result, getSpecificBox(X,Y+1));}
		return result;
	}
	
	/**
	 * Adds the vertex issued to the successors if he is in fact accessible (not a wall.
	 * @param tab ArrayList<VertexInterface> that holds the neighbors.
	 * @param potentialSuccessor VertexInterface to be tested. 
	 */
	private void addPotentialSuccessor(ArrayList<VertexInterface> tab, VertexInterface potentialSuccessor) {
		if (!(potentialSuccessor.getLabel()=="W")) {
			tab.add(potentialSuccessor);
		}
	}
	
	public int getWeight(VertexInterface src, VertexInterface dst) {
		if (this.getSuccessors(src).contains(dst)) {
			return 1;
		}
		else {
			return boxes.size();
		}
	}
	
	/**
	 * Changes the maze so that it reflects the one pointed by fileName.
	 * @param fileName String which is the file's address of the wanted maze.
	 * @throws MazeReadingException Exception thrown if an incoherent number of characters or unknown characters are encountered or a char is not recognized.
	 * @throws MazeIOException Exception thrown if there is issue handling the file pointed by the address fileName.
	 * @throws MazeStructureException Exception thrown if the issued file doesn't meet the requirements in terms of dimensions.
	 */
	public final void initFromTextFile(String fileName) throws MazeReadingException, MazeIOException, MazeStructureException {
		FileReader in = null;
		BufferedReader br = null;
		try {
			in = new FileReader(fileName);
			br = new BufferedReader(in);
			String line = br.readLine();
			boxes.clear();
			Width = line.length();
			if (Width>100) {throw new MazeStructureException("Maze's number of columns is too big.");}
			int compteur = 0;
			while (line != null) {
				if (line.length()!=Width ) {throw new MazeReadingException(compteur, "incoherent number of characters in regard of the reference established while reading line 0.");}
				for (int k=0; k < Width; k++) {addNewBox(line.charAt(k), k, compteur);}
				line = br.readLine();
				compteur++;
				if (compteur > 100) {throw new MazeStructureException("Maze's number of rows is too big.");}
				if (compteur*Width > 100) {throw new MazeStructureException("Maze's total number of boxes is too big.");}
			}
			Length = compteur;	
		} catch (IOException e) {throw new MazeIOException("Issue with the stream while reading the file");} 
		finally {
			try { in.close() ; } catch (IOException e) {throw new MazeIOException("Issue while closing the file with FileReader.");};
			try { br.close() ; } catch (IOException e) {throw new MazeIOException("Issue while closing the file with BufferedReader.");};
		}
	}
	
	/**
	 * Adds a new box to the maze.
	 * @param newBox Char that holds the label of the future box.
	 * @param x Int which will be the lateral coordinate of the future box.
	 * @param y Int which will be the longiditudinal coordinate of the box added.
	 * @throws MazeReadingException Exception thrown if the label is not recognized.
	 */
	private void addNewBox(char newBox, int x, int y) throws MazeReadingException {
		if (newBox=='E') {boxes.add(new EBox(x,y, this));}
		else if (newBox=='A') {boxes.add(new ABox(x,y, this));}
		else if (newBox=='D') {boxes.add(new DBox(x,y, this));}
		else if (newBox=='W') {boxes.add(new WBox(x,y, this));}
		else {throw new MazeReadingException(x, "undetermined character neither 'E', 'A', 'D' or 'W'.");}
	}
	
	/**
	 * Saves the maze with its solved route to the file pointed by the issued String.
	 * @param fileName String that is the address where the maze should be saved.
	 * @param map Boolean[][] holds the info for each box (recognizable with its coordinates) on whether it is on the route or not.
	 * @throws MazeIOException Exception thrown if there is an issue handling the file pointed to by fileName.
	 */
	public final void saveToTextFile(String fileName, boolean[][] map) throws MazeIOException {		
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream(fileName));
			for (int k = 0; k < (Width*Length); k++) {
				MBox newBox = (MBox) boxes.get(k);
				writeLabel(newBox.getLabel(), pw, map[newBox.getX()][newBox.getY()], (k%Width==((Width)-1)));
			} 
		} catch (IOException e) {throw new MazeIOException("Error while writing on the output file");
		} finally {
			pw.close() ;;
		}
	}
	
	/**
	 * Writes on the OutputStream the issued String or a '.' if it's on the rote.
	 * @param label String to be written on the OutputStream if it's not on the route.
	 * @param pw PrintWriter outputstream where the string should be written.
	 * @param route Boolean that signifies if the string should be for a route or for a box.
	 * @param endOfLine Boolean that signifies if we should go back to the beginning of the line for the next line.
	 */
	private final void writeLabel(String label,PrintWriter pw, boolean route, boolean endOfLine) {
		if (endOfLine) {
			if (route) {pw.println(".");}
			else {pw.println(label);}
		}
		else {
			if (route) {pw.print(".");}
			else {pw.print(label);}
		}
	}
	
	/**
	 * Saves the maze to the file pointed by the issued String.
	 * @param fileName String that is the address where the maze should be saved.
	 * @throws MazeIOException Exception thrown if there is an issue handling the file pointed to by fileName.
	 */
	public final void saveToTextFile(String fileName) throws MazeIOException {			
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream(fileName));
			for (int k = 0; k < (this.Width*this.Length); k++) {
				writeLabel(boxes.get(k).getLabel(), pw, false, (k%Width==((Width)-1)));
			}
		} catch (IOException e) {throw new MazeIOException("Error while writing on the output file");
		} finally {
			pw.close() ;;
		}
	}
	
	/**
	 * Checks if it has one and only one arrival.
	 * @return Boolean which is the answer of the above question.
	 */
	public boolean hasOneArrival() {
		int count = 0;
		for (VertexInterface box : boxes) {
			if (box.getLabel().equals("A")) {
				count++;
			}
			if (count>1) {
				break;
			}
		}
		return (count==1);
	}
	
	/**
	 * Checks if it has one and only one departure.
	 * @return Boolean which is the answer of the above question.
	 */
	public boolean hasOneDeparture() {
		int count = 0;
		for (VertexInterface box : boxes) {
			if (box.getLabel().equals("D")) {
				count++;
			}
			if (count>1) {
				break;
			}
		}
		return (count==1);
	}
	
	/**
	 * Makes the box (x,y) a EBox
	 * @param x Int which is the lateral coordinate of the box to be changed.
	 * @param y Int which is the longitudinal coordinate of the box to be changed.
	 */
	public void modifySpecifiedMBoxIntoEBox(int x, int y) {
		boxes.set(y*Width+x, new EBox(x,y,this));
	}
	
	/**
	 * Makes the box (x,y) a WBox
	 * @param x Int which is the lateral coordinate of the box to be changed.
	 * @param y Int which is the longitudinal coordinate of the box to be changed.
	 */
	public void modifySpecifiedMBoxIntoWBox(int x, int y) {
		boxes.set(y*Width+x, new WBox(x,y,this));
	}
	
	/**
	 * Makes the box (x,y) a ABox and makes sure it remains the only one.
	 * @param x Int which is the lateral coordinate of the box to be changed.
	 * @param y Int which is the longitudinal coordinate of the box to be changed.
	 */
	public void modifySpecifiedMBoxIntoABox(int x, int y) {
		for(int k =0; k< Width*Length; k++) {
			if (boxes.get(k).getLabel()=="A") {
				MBox boxToChange = (MBox) boxes.get(k);
				boxes.set(k, new EBox(boxToChange.getX(),boxToChange.getY(),this));	
			}
		}
		boxes.set(y*Width+x, new ABox(x,y,this));
	}
	
	/**
	 * Makes the box (x,y) a DBox and makes sure it remains the only one.
	 * @param x Int which is the lateral coordinate of the box to be changed.
	 * @param y Int which is the longitudinal coordinate of the box to be changed.
	 */
	public void modifySpecifiedMBoxIntoDBox(int x, int y) {
		for(int k =0; k< Width*Length; k++) {
			if (boxes.get(k).getLabel()=="D") {
				MBox boxToChange = (MBox) boxes.get(k);
				boxes.set(k, new EBox(boxToChange.getX(),boxToChange.getY(),this));	
			}
		}
		boxes.set(y*Width+x, new DBox(x,y,this));
	}
	
	/**
	 * Gets the departure box.
	 * @return VertexInterface that is the departure box.
	 * @throws MazeException Exception thrown if there is no or several departure box.
	 */
	public VertexInterface getDeparture() throws MazeException {
		if (!(hasOneDeparture())) {
			throw new MazeException("Your maze is supposed to have one and only one departure Box.");
		}
		for(VertexInterface box : boxes) {
			if (box.getLabel()=="D") {
				return box;
			}
		}
		return null;
	}
	
	/**
	 * Gets the arrival box.
	 * @return VertexInetrface that is the arrival box.
	 * @throws MazeException Exception thrown if there is no or several arrival box
	 */
	public VertexInterface getArrival() throws MazeException {
		if (!(hasOneArrival())) {
			throw new MazeException("Your maze is supposed to have one and only one arrival Box.");
		}
		for(VertexInterface box : boxes) {
			if (box.getLabel()=="A") {
				return box;
			}
		}
		return null;
	}
	
	/**
	 * Returns the box that corresponds to the issued coordinates.
	 * @param x Int which is the lateral coordinate of the wanted box.
	 * @param y Int which is the longitudinal coordinate of the wanted box.
	 * @return VertexInterface located at (x,y), or null if there is no such box.
	 */
	private VertexInterface getSpecificBox(int x, int y) {
		for (VertexInterface box : boxes) {
			MBox potential = (MBox) box;
			if (potential.getX()==x && potential.getY()==y) {
				return box;
			}
		}
		return null;
	}
	

}
