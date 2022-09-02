import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MatrixRotation  {
	static final private List<String> image_names = List.of(
			"abe",
			"boy student",
			"calculator",
			"easter egg",
			"eiffel",
			"george",
			"girl student",
			"hula",
			"rip",
			"santa",
			"skeleton",
			"sundae",
			"tut",
			"werewolf",
			"white rabbit",
			"zombie",
			"zombie2",
			"zombie3",
			"zombie4"
	);

	/* Declare instance fields here */
	private char[][] img;

	public static void main(String[] args) {
		MatrixRotation lab = new MatrixRotation();
		while (lab.input()) 	// fill the matrix from a data file
		{
			System.out.println("Regular:");
			lab.regular();       // display the matrix
			System.out.println("Upside Down:");
			lab.upsideDown();     // display the matrix upside down
			System.out.println("Right 90:");
			lab.right90();        // Rotate the matrix right 90
			System.out.println("Left 90:");
			lab.left90();         // Rotate the matrix left 90�
			System.out.println("Mirror:");
			lab.mirror();         // flip the image as in a mirror
			System.out.println("Double Inverted:");
			lab.doubleInverted(); // Upside down and mirrored
		}
	}
	
    	private void pause() {
        	System.out.print("\nPress ENTER to continue...");
        	(new java.util.Scanner(System.in)).nextLine();
    	}

	private static void print_img(char[][] img) {
		for (char[] row: img) {
			for (char px : row)
				System.out.print(px);
			System.out.println();
		}
	}

	/* Write the input() method here */
	boolean input() {
		Scanner user_in = new Scanner(System.in);
		System.out.print("Enter image name: ");
		String image_name = user_in.nextLine();

		if (image_name.equalsIgnoreCase("quit"))
			return false;


		if (!image_names.contains(image_name)) {
			System.out.println("Invalid image name. Valid names include: " + image_names);
			return false;
		} else {
			try {
				String file_name = "labs/" + "01e_MatrixRotation/" + image_name + ".dat";
				Scanner file_in = new Scanner(new File(file_name));

				int rows = file_in.nextInt(),
					cols = file_in.nextInt();
				int current_row = 0;
				img = new char[rows][cols];

				file_in.nextLine();
				while (file_in.hasNextLine())
					img[current_row++] = file_in.nextLine().trim().toCharArray();

				return true;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	/* Write the regular() method here */
	void regular() {
		print_img(img);
	}

	/* Write the upsideDown() method here */
	void upsideDown() {
		for (int r = img.length-1; r >= 0; r--) {
			for (int c = 0; c < img[r].length; c++)
				System.out.print(img[r][c]);
			System.out.println();
		}
		System.out.println("\n\n");
	}

	/* Write the right90() method here */
	void right90() {
		char[][] rotation = new char[img[0].length][img.length];
		for (int r = 0; r < img.length; r++) {
			for (int c = 0; c < img[r].length; c++) {
				rotation[c][img.length - r - 1] = img[r][c];
			}
		}
		print_img(rotation);
	}

    /* Write the left90() method here */
	void left90() {
		char[][] rotation = new char[img[0].length][img.length];
		for (int r = 0; r < img.length; r++)
			for (int c = 0; c < img[r].length; c++)
				rotation[c][r] = img[r][img[r].length - c - 1];
		print_img(rotation);
	}
    
    /* Write the mirror() method here */
    void mirror() {
		for (char[] row: img)
			System.out.println(new StringBuilder(new String(row)).reverse());
	}
    
   	/* Write the doubleInverted() method here */
	void doubleInverted() {
		for (int r = img.length-1; r >= 0; r--)
			System.out.println(new StringBuilder(new String(img[r])).reverse());
	}
}
