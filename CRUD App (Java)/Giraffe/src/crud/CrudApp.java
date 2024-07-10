package crud;
import java.util.List;
import java.util.Scanner;

public class CrudApp {

			public static void main(String[] args) {
			UserCrud myUserCrud = new UserCrud();
	        Scanner keyboardInput = new Scanner(System.in);
	        int choice;

	        do {
	            System.out.println("PLease Choose the Below Operations:-\n");
	            System.out.println("Type 1 : To Add a User");
	            System.out.println("Type 2 : To View a Users");
	            System.out.println("Type 3 : To Update a User");
	            System.out.println("Type 4 : To Delete a User");
	            System.out.println("Type 5 : To Exit");
	            choice = keyboardInput.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.print("Please Enter a Name: ");
	                    String name = keyboardInput.next();
	                    System.out.print("Please Enter a Email: ");
	                    String email = keyboardInput.next();
	                    System.out.print("Please Enter a Country: ");
	                    String country = keyboardInput.next();
	                    myUserCrud .addUser(name, email, country);
	                    break;
	                case 2:
	                    List<InfoUser> users = myUserCrud .getUsers();
	                    for (InfoUser user : users) {
	                        System.out.println("ID: " + user.getId() + ", Name: " + user.getName() +
	                                ", Email: " + user.getEmail() + ", Country: " + user.getCountry());
	                    }
	                    break;
	                case 3:
	                    System.out.print("Please Enter a User ID to Update: ");
	                    int idToUpdate = keyboardInput.nextInt();
	                    System.out.print("Please Enter a Name: ");
	                    String newName = keyboardInput.next();
	                    System.out.print("Please Enter a Email: ");
	                    String newEmail = keyboardInput.next();
	                    System.out.print("Please Enter a Country: ");
	                    String newCountry = keyboardInput.next();
	                    myUserCrud .updateUser(idToUpdate, newName, newEmail, newCountry);
	                    break;
	                case 4:
	                    System.out.print("Please Enter a User ID to Delete: ");
	                    int idToDelete = keyboardInput.nextInt();
	                    myUserCrud .deleteUser(idToDelete);
	                    break;
	                case 5:
	                    System.out.println("Exiting.....(Thankyou For Your Time!)");
	                    break;
	                default:
	                    System.out.println("Invalid Choice. PLease Try Again.");
	            }
	        } while (choice != 5);

	        keyboardInput.close();
	    }
	}
	

