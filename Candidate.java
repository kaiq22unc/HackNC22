public class Candidate {

  private String name;
  private String affiliation;
  private int votes = 0;

  public Candidate(String name, String affiliation) {
    this.name = name;
    this.affiliation = affiliation;
  }

  public String getName() {
    return name;
  }

  public String getAffiliation() {
    return affiliation;
  }

  public int getVoteCount() {
    return votes;
  }

  public void tallyVote() {
    votes++;
  }

  public String toString() {
    return (this.name + " - " + this.affiliation);
  }
}
