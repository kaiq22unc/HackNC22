import java.util.ArrayList;

public class Ballot {
  private String officeName;
  private ArrayList<Candidate> Arr = new ArrayList<Candidate>();

  public Ballot(String officeName) {
    this.officeName = officeName;
  }

  public String getOfficeName() {
    return officeName;
  }

  public void addCandidate(Candidate c) {
    if (!Arr.contains(c)) {
      Arr.add(c);
    } else {
      System.out.println("Duplicate Candidate");
    }
  }

  public ArrayList<Candidate> getCandidates() {
    return Arr;
  }
}
