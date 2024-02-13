package main;

import java.io.IOException;
import java.util.ArrayList;

import dijkstra.GraphInterface;
import dijkstra.PreviousInterface;
import dijkstra.VertexInterface;
import dijkstra.Dijkstra;
import maze.Maze;
import maze.MazeException;
import maze.MazeIOException;
import maze.MazeReadingException;
import maze.MazeStructureException;
import maze.MBox;

/**
 * Main used to test the algorithms surrounding the Dijkstra methods. Does not serve for the actual application.
 * @author Hugo Queniat
 *
 */
public class MainTest {
	
	/**
	 * Constructor for MainTest.
	 * @param args
	 * @throws MazeException
	 * @throws MazeReadingException
	 * @throws MazeIOException
	 * @throws IOException
	 * @throws MazeStructureException
	 */
	public static void main(String[] args) throws MazeException, MazeReadingException, MazeIOException, IOException, MazeStructureException {
		// TODO Auto-generated method stub
		Maze labyrintheTest = new Maze(0,0);
		GraphInterface maze = (GraphInterface) labyrintheTest;
		labyrintheTest.initFromTextFile("data/labyrinthe3.txt");
		ArrayList<VertexInterface> boxes = labyrintheTest.getAllVertices();
		int i = 0;
		boolean flag1 = true;
		boolean flag2 = true;
		VertexInterface start = null;
		VertexInterface arrival = null;
		while (flag1 || flag2) {
			if (boxes.get(i).getLabel().equals("D")) {
				start = boxes.get(i);
				flag1 = false;
			}
			if (boxes.get(i).getLabel().equals("A")) {
				arrival = boxes.get(i);
				flag2 = false;
			}
			i++;
		}
		PreviousInterface previous = Dijkstra.dijkstra(maze, start);
		boolean[][] map = new boolean[labyrintheTest.getWidth()][labyrintheTest.getLength()];
		VertexInterface currentVertex = null;
		currentVertex = arrival;
		if (previous.getFather(currentVertex)==null) {
			throw new MazeException("Il n'existe pas de chemin entre D et A dans le labyrinthe");
		}
		while (!(previous.getFather(currentVertex).getLabel().equals("D"))) {
			MBox father = (MBox) previous.getFather(currentVertex);
			map[father.getX()][father.getY()]= true;
			currentVertex = previous.getFather(currentVertex);
			if (currentVertex==null) {
				throw new MazeException("Il n'existe pas de chemin entre D et A dans le labyrinthe");
			}
		}
		labyrintheTest.saveToTextFile("data/labyrinthe4.txt", map); 
	}

}
