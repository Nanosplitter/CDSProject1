import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SumAndProductMatrix {
	File input;
	Scanner scan;
	int size;
	int[][] matrix;
	int[][] sum;
	int[][] product;

	public SumAndProductMatrix(String fileName) {
		input = new File(fileName);
		scan = new Scanner(System.in);
		try {
			scan = new Scanner(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		size = scan.nextInt();
		matrix = new int[size][size];
		sum = new int[size][size];
		product = new int[size][size];

		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				matrix[y][x] = scan.nextInt();
			}
		}
	}

	public String sum() {
		String res = "";

		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				res += matrix[y][x] * 2 + " ";
			}
			res += "\n";
		}

		return res;
	}

	public String product() {
		String res = "";
		int sum = 0;
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				sum = 0;
				for (int k = 0; k < size; k++) {
					sum += matrix[y][k] * matrix[k][x];
				}
				product[y][x] = sum;
			}
		}

		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				res += product[y][x] + " ";
			}
			res += "\n";
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
			SumAndProductMatrix spm = new SumAndProductMatrix(inputF);
			out.write(spm.size + "\n" + spm.sum() + "\n\n" + spm.size + "\n" + spm.product());
			out.close();
		} catch (IOException e) {
			System.out.println("Could not create or open output file, please try again");
			System.exit(0);
		}

		scan.close();
	}

}
