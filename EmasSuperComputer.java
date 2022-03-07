import java.util.*;

public class EmasSuperComputer {

  private static int[][] taken;

  // function for getting the max length of a plus
  private static int getPlus(int[][] taken, int i, int j) {
    int length = 0;
    int numRows = taken.length;
    int numCols = taken[0].length;

    // while loop will go until it encounters a bad/taken cell or a matrix edge
    while(i + length < numRows && i - length >= 0 && 
          j + length < numCols && j - length >= 0) {
            if(taken[i+length][j] == 0 && taken[i-length][j] == 0 && taken[i][j+length] == 0 && taken[i][j-length] == 0) {
              taken[i+length][j] = 1;
              taken[i-length][j] = 1; 
              taken[i][j+length] = 1; 
              taken[i][j-length] = 1;
              length++;
            } else {
              break;
            }
    }
    return length;
  }
  // function for resetting the taken list for further iterations
  private static void reset(int[][] taken, int i, int j, int length) {
    int reset = 0;
    int numRows = taken.length;
    int numCols = taken[0].length;
    while(i + reset < numRows && i - reset >= 0 && 
          j + reset < numCols && j - reset >= 0 && reset < length) {
      if(taken[i+reset][j] == 1 && taken[i-reset][j] == 1 && taken[i][j+reset] == 1 && taken[i][j-reset] == 1) {
        taken[i+reset][j] = 0;
        taken[i-reset][j] = 0; 
        taken[i][j+reset] = 0; 
        taken[i][j-reset] = 0;
        reset++;
      } else {
        break;
      }
    }
  }

  // initialize a separate matrix for keeping track of taken cells
  private static void initTaken(List<String> grid) {
    taken = new int[grid.size()][grid.get(0).length()];
    for(int i = 0; i < grid.size(); i++) {
      for(int j = 0; j < grid.get(i).length(); j++) {
        char currChar = grid.get(i).charAt(j);
        if(currChar == 'G') {
          taken[i][j] = 0;
        } else {
          taken[i][j] = 1;
        }
      }
    }
  }

  public static int twoPluses(List<String> grid) {
    int result = Integer.MIN_VALUE;
    initTaken(grid);

    for(int i = 0; i < grid.size(); i++) {
      for(int j = 0; j < grid.get(i).length(); j++) {
        if(grid.get(i).charAt(j) == 'G') {
          // get the first plus, mark any cells as "taken"
          int first = getPlus(taken, i, j);

          // iterate through the grid again and find a second plus
          for(int I = 0; I < grid.size(); I++) {
            for(int J = 0; J < grid.get(I).length(); J++) {
              if(grid.get(I).charAt(J) == 'G') {
                int second = getPlus(taken, I, J);
                // update results if needed
                result = Math.max(result, (4*(first-1)+1) * (4*(second-1)+1));
                // reset the taken to original state
                reset(taken, I, J, second);
              }
            }
          }
          reset(taken, i, j, first);
        }
      }
    }
    
    return result;
  }

  private static void initInputs(List<List<String>> allInputs, List<String> input) {
    input.add("BGBBGB");
    input.add("GGGGGG");
    input.add("BGBBGB");
    input.add("GGGGGG");
    input.add("BGBBGB");
    input.add("BGBBGB");
    
    allInputs.add(input);
    input = new ArrayList<>();

    input.add("GGGGGG");
    input.add("GBBBGB");
    input.add("GGGGGG");
    input.add("GGBBGB");
    input.add("GGGGGG");

    allInputs.add(input);
    input = new ArrayList<>();

    input.add("GGGGGGGG");
    input.add("GBGBGGBG");
    input.add("GBGBGGBG");
    input.add("GGGGGGGG");
    input.add("GBGBGGBG");
    input.add("GGGGGGGG");
    input.add("GBGBGGBG");
    input.add("GGGGGGGG");

    allInputs.add(input);
    input = new ArrayList<>();
    
    input.add("GGGGGGGGG");
    input.add("GBBBGGBGG");
    input.add("GBBBGGBGG");
    input.add("GBBBGGBGG");
    input.add("GBBBGGBGG");
    input.add("GBBBGGBGG");
    input.add("GBBBGGBGG");
    input.add("GGGGGGGGG");

    allInputs.add(input);
    input = new ArrayList<>();
    
    input.add("BBGGBGGBBGGGB");
    input.add("BBGGBGGBBGGGB");
    input.add("BBGGBGGBBGGGB");
    input.add("BBGGBGGBBGGGB");
    input.add("GGGGGGGGGGGGG");
    input.add("BBGGBGGBBGGGB");
    input.add("GGGGGGGGGGGGG");
    input.add("BBGGBGGBBGGGB");
    input.add("BBGGBGGBBGGGB");
    input.add("GGGGGGGGGGGGG");
    input.add("GGGGGGGGGGGGG");
    input.add("GGGGGGGGGGGGG");
    input.add("BBGGBGGBBGGGB");
    input.add("GGGGGGGGGGGGG");
    
    allInputs.add(input);
    input = new ArrayList<>();
    
    input.add("GGGGGGGGGGGGGG");
    input.add("GGBBBBGBBBBBGG");
    input.add("GGBBBBGBBBBBGG");
    input.add("GGBBBBGBBBBBGG");
    input.add("GGGGGGGGGGGGGG");
    input.add("GGGGGGGGGGGGGG");
    input.add("GGGGGGGGGGGGGG");
    input.add("GGGGGGGGGGGGGG");
    input.add("GGBBBBGBBBBBGG");
    input.add("GGBBBBGBBBBBGG");
    input.add("GGGGGGGGGGGGGG");
    input.add("GGBBBBGBBBBBGG");
    input.add("GGBBBBGBBBBBGG");
    input.add("GGGGGGGGGGGGGG");

    allInputs.add(input);
    input = new ArrayList<>();

    input.add("GBBBBBBGGGBGGBB");
    input.add("GBBBBBBGGGBGGBB");
    input.add("GBBBBBBGGGBGGBB");
    input.add("GBBBBBBGGGBGGBB");
    input.add("GGGGGGGGGGGGGGG");
    input.add("GGGGGGGGGGGGGGG");
    input.add("GBBBBBBGGGBGGBB");
    input.add("GBBBBBBGGGBGGBB");
    input.add("GGGGGGGGGGGGGGG");
    input.add("GBBBBBBGGGBGGBB");
    input.add("GBBBBBBGGGBGGBB");
    input.add("GGGGGGGGGGGGGGG");
    input.add("GGGGGGGGGGGGGGG");
    input.add("GBBBBBBGGGBGGBB");

    allInputs.add(input);
    input = new ArrayList<>();

    input.add("BBGBGGGGGBBGGBB");
    input.add("BBGBGGGGGBBGGBB");
    input.add("GGGGGGGGGGGGGGG");
    input.add("GGGGGGGGGGGGGGG");
    input.add("BBGBGGGGGBBGGBB");
    input.add("BBGBGGGGGBBGGBB");
    input.add("BBGBGGGGGBBGGBB");
    input.add("GGGGGGGGGGGGGGG");
    input.add("BBGBGGGGGBBGGBB");
    input.add("BBGBGGGGGBBGGBB");
    input.add("BBGBGGGGGBBGGBB");
    input.add("BBGBGGGGGBBGGBB");
    input.add("BBGBGGGGGBBGGBB");
    input.add("BBGBGGGGGBBGGBB");
    input.add("GGGGGGGGGGGGGGG");

    allInputs.add(input);
    input = new ArrayList<>();
  }
  public static void main(String[] args) {
    List<List<String>> allInputs = new ArrayList<>();
    List<String> input = new ArrayList<>();

    initInputs(allInputs, input);

    for(int i = 0; i < allInputs.size(); i++) {
      System.out.println(EmasSuperComputer.twoPluses(allInputs.get(i)));
    }
  }
}
