import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddDialog extends JDialog{

        private JList<Object> choiceList;


        public AddDialog(Frame owner, Ballot ballot)
        {
            super(owner, "More Candidates?", true);

            setSize(300, 500);

            buildUI(ballot);

            final AddDialog bf = this;

            addWindowListener(
                    new WindowAdapter()
                    {
                        public void windowClosing(WindowEvent e)
                        {
                            int result = JOptionPane.showConfirmDialog(bf,
                                    "Are you done adding candidates?",
                                    "Confirm",
                                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                            if (result == JOptionPane.YES_OPTION)
                            {
                                dispose();
                            }
                        }
                    });

            setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        }

        JTextField txtInput = new JTextField("");

        private void buildUI(Ballot ballot)
        {
            getContentPane().removeAll();

            GridBagLayout contentLayout = new GridBagLayout();
            setLayout(contentLayout);


            JButton addB = new JButton("Add Candidate?");
            addB.addActionListener(
                    new ActionListener()
                    {
                        public void actionPerformed(ActionEvent e)
                        {
                            String name = javax.swing.JOptionPane.showInputDialog("What is the candidate's name?");
                            String office = javax.swing.JOptionPane.showInputDialog("What is candidate's office?");
                            addButton(name, office, ballot);
                        }
                    });
            add(addB);
            contentLayout.setConstraints(
                    addB,
                    new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                            GridBagConstraints.EAST, GridBagConstraints.NONE,
                            new Insets(5, 5, 5, 5), 0, 0));





    }

    private void addButton(String name, String office, Ballot ballot) {


        Candidate c = new Candidate(name, office)   ;

        int result = JOptionPane.showConfirmDialog(this,
                "You added a new candidate:\n   " + c.getName()
                        + " - " + c.getAffiliation() + "\nAre you sure?",
                "Confirm",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (result == JOptionPane.OK_OPTION)
        {
            ballot.addCandidate(c);


            JOptionPane.showMessageDialog(this,
                    "Candidate added",
                    "Done",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
