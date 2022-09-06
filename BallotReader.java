
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class BallotReader
{

	public static Ballot readBallot(String filename)
	throws IOException
	{
		// ***Replace this with the correct implementation; for now, it's
		//    always returning a hard-coded ballot with three candidates
		Scanner scanner = new Scanner(new FileReader(filename));
		String officeName = scanner.nextLine();
		Ballot ballot = new Ballot(officeName);
		int CandidateCount = Integer.parseInt(scanner.nextLine());

		for (int i = 0;i < CandidateCount;i++){
			String Cann = scanner.nextLine();
			String[] Buff = Cann.split(";");
			String name = Buff[0];
			String affiliation = Buff[1];

			Candidate c = new Candidate(name, affiliation);
			ballot.addCandidate(c);

		}


		return ballot;
	}
}
