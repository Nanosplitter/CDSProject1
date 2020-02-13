import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class OneToOneOntoBijective {
	File input;
	Scanner scan;
	ArrayList<Integer> a = new ArrayList<Integer>();
	ArrayList<Integer> b = new ArrayList<Integer>();
	ArrayList<Integer> domain = new ArrayList<Integer>();
	ArrayList<Integer> range = new ArrayList<Integer>();

	public OneToOneOntoBijective(String fileName) {
		input = new File(fileName);
		scan = new Scanner(System.in);
		try {
			scan = new Scanner(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int aSize = scan.nextInt();
		for (int i = 0; i < aSize; i++) {
			a.add(scan.nextInt());
		}

		int bSize = scan.nextInt();
		for (int i = 0; i < bSize; i++) {
			b.add(scan.nextInt());
		}

		int funcSize = scan.nextInt();
		for (int i = 0; i < funcSize; i++) {
			domain.add(scan.nextInt());
			range.add(scan.nextInt());
		}
	}

	public String oneToOne() {
		boolean oneToOne = true;
		for (Integer i : range) {
			if (Collections.frequency(range, i) > 1) {
				oneToOne = false;
			}
		}

		if (oneToOne) {
			return "one to one";
		}

		return "not one to one";
	}

	public String onto() {
		boolean onto = true;
		for (Integer i : b) {
			if (Collections.frequency(range, i) == 0) {
				onto = false;
			}
		}

		if (onto) {
			return "onto";
		}

		return "not onto";
	}

	public String bijective() {
		if (oneToOne().equals("one to one") && onto().equals("onto")) {
			return "bijective";
		}

		return "not bijective";
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the input file name");
		String inputF = scan.nextLine();
		System.out.println("Enter the output file name");
		String outFile = scan.nextLine();
		File fout = new File(outFile);
		try {
			FileWriter out = new FileWriter(fout);
			OneToOneOntoBijective oob = new OneToOneOntoBijective(inputF);
			out.write(oob.oneToOne() + "\n" + oob.onto() + "\n" + oob.bijective());
			out.close();
		} catch (IOException e) {
			System.out.println("Could not create or open output file, please try again");
			System.exit(0);
		}

		scan.close();
	}
}
