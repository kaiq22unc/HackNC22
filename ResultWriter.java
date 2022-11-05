import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class ResultWriter {

  public static void writeResults(String filename, Ballot ballot) throws IOException {

    File file = new File(filename); // Your file
    FileOutputStream fos = new FileOutputStream(file);
    PrintStream ps = new PrintStream(fos);
    System.setOut(ps);

    String name = ballot.getOfficeName();
    System.out.println("RESULTS - " + name);
    System.out.print("----------");
    for (int i = 0; i <= name.length(); i++) {
      System.out.print('-');
    }
    System.out.printf("%n");

    ArrayList<Candidate> arr = ballot.getCandidates();
    boolean tie = false;
    Candidate winner = arr.get(0);

    for (int i = 0; i < arr.size(); i++) {
      Candidate c = arr.get(i);
      String tag = c.toString();
      int vote = c.getVoteCount();
      System.out.printf("%-50s %d %n", tag, vote);
      if (c.getVoteCount() > winner.getVoteCount()) {
        winner = c;
        tie = false;
      } else if (c.getVoteCount() == winner.getVoteCount()) {
        tie = true;
      }
    }
    System.out.printf("%n");
    if (!tie) {
      System.out.println("WINNER: " + winner.toString());
    } else {
      System.out.println("NO WINNER");
    }
  }
}
