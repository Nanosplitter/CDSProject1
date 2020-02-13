import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Goldbach {
	int start;
	int end;

	public Goldbach(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}

		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

	public int[] getNums(int i) {

		for (int num1 = i; num1 > 2; num1--) {
			for (int num2 = 0; num2 < i; num2++) {
				if (isPrime(num1) && isPrime(num2) && num1 + num2 == i) {
					return new int[] { num1, num2 };
				}
			}
		}

		return new int[] { -1, -1 };

	}

	public String genSolutions() {
		String res = "";

		for (int i = start; i < end + 1; i++) {
			if (i % 2 == 0) {
				int[] nums = getNums(i);
				res += i + ": " + nums[0] + " + " + nums[1] + "\n";
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Goldbach gb;

		System.out.println("Enter the starting number:");
		int start = scan.nextInt();
		System.out.println("Enter the ending number:");
		int end = scan.nextInt();
		System.out.println("Enter the output file name:");
		String outFile = scan.next();
		File fout = new File(outFile);
		try {
			FileWriter out = new FileWriter(fout);
			gb = new Goldbach(start, end);
			out.write(gb.genSolutions());
			out.close();
		} catch (IOException e) {
			System.out.println("Could not create or open output file, please try again");
			System.exit(0);
		}

		scan.close();

	}
}
