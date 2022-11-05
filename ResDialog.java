import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class ResDialog {

  public static void write(Ballot ballot) throws IOException {

    JTextArea textArea = new JTextArea(100, 100);
    textArea.setAlignmentX(TextArea.LEFT_ALIGNMENT);
    PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
    System.setOut(printStream);
    Font font = new Font(Font.MONOSPACED, Font.BOLD, 15);
    textArea.setFont(font);

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
      int width = 70 - tag.length();

      System.out.printf("%s" + "%" + width + "d" + "%n", tag, vote);
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

    JOptionPane.showMessageDialog(null, textArea, "Results", JOptionPane.INFORMATION_MESSAGE);
  }
}
