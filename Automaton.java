import java.util.Arrays;

/**
 * Model a 1D elementary cellular automaton.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version  2016.02.29 - version 1
 */
public class Automaton
{
    // The number of cells.
    private final int numberOfCells;
    // The state of the cells.
    private int[] state;
    
    /**
     * Create a 1D automaton consisting of the given number of cells.
     * @param numberOfCells The number of cells in the automaton.
     */
    public Automaton(int numberOfCells) {
    this.numberOfCells = numberOfCells;
    state = new int[numberOfCells];

    // Set more than one cell to '1', for example, set the middle 3 cells
    int start = numberOfCells / 2 - 1;  // Start from the cell before the middle
    int end = start + 3;  // Set 3 cells to '1'

    for (int i = start; i < end; i++) {
        state[i] = 1;
    }
    }
    
    /**
     * Print the current state of the automaton.
     */
    public void print()
    {
        for(int cellValue : state) {
            if(cellValue == 1) {
                System.out.print("*");
            }
            else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }   
    
    /**
     * Q28
     * Q29
     * Q31
     */
    public void update() {
    int[] nextState = new int[state.length];
    
    int left = 0;
    int center = state[0];
    for (int i = 0; i < state.length; i++) {
        int right = (i + 1 < state.length) ? state[i + 1] : 0;
        nextState[i] = (left + center + right) % 2;
        
        left = center;
        center = right;
    }
    
    state = nextState;
    }
    
    /**
     * Q32
     */
    public int calculateNextState(int left, int center, int right) {
    return (left + center + right) % 2;
    }
    
    /**
     * Reset the automaton.
     */
    public void reset()
    {
        Arrays.fill(state, 0);
        state[numberOfCells / 2] = 1;   
    }
}
