import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UnionAndIntersection {
	File input;
	Scanner scan;
	ArrayList<Integer> a = new ArrayList<Integer>();
	ArrayList<Integer> b = new ArrayList<Integer>();
	ArrayList<Integer> union = new ArrayList<Integer>();
	ArrayList<Integer> intersection = new ArrayList<Integer>();

	public UnionAndIntersection(String fileName) {
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
	}

	public String findUnion() {
		for (int i : a) {
			if (union.indexOf(i) == -1) {
				union.add(i);
			}
		}

		for (int i : b) {
			if (union.indexOf(i) == -1) {
				union.add(i);
			}
		}

		String res = "";
		res += union.size() + "\n";
		for (int i : union) {
			res += i + " ";
		}

		return res;
	}

	public String findIntersection() {
		for (int i : a) {
			if (b.indexOf(i) != -1) {
				intersection.add(i);
			}
		}

		String res = "";
		res += intersection.size() + "\n";
		for (int i : intersection) {
			res += i + " ";
		}

		return res;
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
			UnionAndIntersection uai = new UnionAndIntersection(inputF);
			out.write(uai.findUnion() + "\n\n" + uai.findIntersection());
			out.close();
		} catch (IOException e) {
			System.out.println("Could not create or open output file, please try again");
			System.exit(0);
		}

		scan.close();
	}
}
