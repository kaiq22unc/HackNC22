import javax.swing.*;
import java.io.IOException;

public class PerfectCandidate {
  public static void main(String[] args) throws IOException {
    Ballot ballot = null;

    do {
      FileSelector inputSelector =
          new FileSelector(null, "Select Input File", "Path to input file", true);

      inputSelector.setVisible(true);

      String inputFilename = inputSelector.getSelectedFile();

      if (inputFilename == null) {
        return;
      }

      try {
        ballot = BallotReader.readBallot(inputFilename);
      } catch (IOException e) {
        JOptionPane.showMessageDialog(
            null, "Could not open and read input file", "Input Error", JOptionPane.ERROR_MESSAGE);
      }
    } while (ballot == null);

    AddDialog ad = new AddDialog(null, ballot);
    ad.setVisible(true);

    BallotDialog bf = new BallotDialog(null, ballot);
    bf.setVisible(true);

    ResDialog.write(ballot);

    FileSelector outputSelector =
        new FileSelector(null, "Save as file?", "Path to output file", false);

    outputSelector.setVisible(true);

    String outputFilename = outputSelector.getSelectedFile();

    if (outputFilename == null) {
      return;
    }

    try {
      ResultWriter.writeResults(outputFilename, ballot);
    } catch (IOException e) {
      JOptionPane.showMessageDialog(
          null,
          "Could not write results to output file",
          "Output Error",
          JOptionPane.ERROR_MESSAGE);
    }
  }
}
