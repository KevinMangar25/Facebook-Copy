package proj5sp24;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project5 {
	public static void main(String[] args) {
		File file = new File("fbData.txt");
		SFacebook fBook = new SFacebook();

		//All of the code for the "A" letter
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) {
				String[] temp = scanner.nextLine().split(" ");
				if (temp[0].equals("A"))
					fBook.addToFacebook(temp[1]);
			}
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
		System.out.println(fBook.toString());

		//All of the code for the "F" letter
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) {
				String[] temp = scanner.nextLine().split(" ");
				if (temp[0].equals("F")) {
					try {
					fBook.makeFriends(temp[1], temp[2]);
					}
					catch(FriendNotFoundException e) {
						System.out.println(e.getMessage() + ": " + temp[1] + ", " + temp[2]);
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.getMessage();
		}		
		System.out.println(fBook.toString());

		//All of the code for the "U" letter
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) {
				String[] temp = scanner.nextLine().split(" ");
				if (temp[0].equals("U")) {
					try {
					fBook.breakFriendShip(temp[1], temp[2]);
					}
					catch(FriendNotFoundException e) {
						System.out.println(e.getMessage() + ": " + temp[1] + ", " + temp[2]);
					}
						
				}
			}
		} catch (FileNotFoundException e) {
			e.getMessage();
		}		
		
		System.out.println(fBook.toString());

		//All of the code for the "L" letter
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) {
				String[] temp = scanner.nextLine().split(" ");
				
				if (temp[0].equals("L")) {
					System.out.println(temp[1] + "'s friends: " + fBook.getFriends(temp[1])); 
				}
			}
		} catch (FileNotFoundException e) {
			e.getMessage();
		}	
		
		System.out.println();
		
		//All of the code for the "Q" letter
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) {
				String[] temp = scanner.nextLine().split(" ");
				
				if (temp[0].equals("Q")) {
					try {
					if(fBook.getFriendsStatus(temp[1], temp[2])) 
						System.out.println(temp[1] + " and " + temp[2] + " are friends.\n");
					else
						System.out.println(temp[1] + " and " + temp[2] + " are not friends.\n");
					}
					catch(FriendNotFoundException e) {
						System.out.println(e.getMessage() + ": "  + temp[1] + ", " + temp[2]);
					}

				}
			}
		} catch (FileNotFoundException e) {
			e.getMessage();
		}	
		
		
	}

}
