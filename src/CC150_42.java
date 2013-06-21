/**
 * Given a directed graph, design an algorithm to find out whether there is a 
 * route between two nodes
 * @author Xiaomin Wei
 *
 */
public class Problem_42 {
	public enum State {
		Unvisited, Visited, Visiting;
	}
	
	public static boolean search(Graph g, Node start, Node end) {
		LinkedList<Node> q = new LinkedList<Node>();

		for (Node u : g.getNodes()) {
			u.state = State.Unvisited;
		}
		start.state = State.Visiting;
		q.add(start);	// enque

		Node u;
		while (!q.isEmpty()) {
			u = q.removeFirst();	// deque
			if (u != null) {
				for (Node v : u.getAdjacent()) {
					if (v.state == State.Unvisited) {
						if (v == end) {
							return true;
						} else {
							v.state = State.Visiting;
							q.add(v);
						}
					}
				}
				u.state = State.Visited;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
