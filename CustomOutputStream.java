import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;

/**
 * This class extends from OutputStream to redirect output to a JTextArrea
 *
 * @author www.codejava.net
 */
public class CustomOutputStream extends OutputStream {
  private JTextArea textArea;

  public CustomOutputStream(JTextArea textArea) {
    this.textArea = textArea;
  }

  @Override
  public void write(int b) throws IOException {
    // redirects data to the text area
    textArea.setText(textArea.getText() + String.valueOf((char) b));
    // scrolls the text area to the end of data
    textArea.setCaretPosition(textArea.getDocument().getLength());
    textArea.update(textArea.getGraphics());
  }
}
