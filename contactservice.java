package Contact;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class contactservice {
	
	private static List<contact> contacts = new ArrayList<contact>();
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter("\n");
		
		boolean stop = false;
		
		while(!stop) {
			
			System.out.println("Choose Option\n1. Add\n2. Delete\n3. Update\n4. Quit");
			char option = scan.next().charAt(0);
			
			if(Character.compare(option, '4') == 0) {
				stop = !stop;
			}
			
			else if(Character.compare(option, '1') == 0) {
				
				System.out.print("Enter contact id: ");
				String contactId = scan.next();
				
				System.out.print("Enter First Name: ");
				String firstName = scan.next();
				
				System.out.print("Enter Last Name: ");
				String lastName = scan.next();			

				System.out.print("Enter Phone: ");
				String phone = scan.next();
				
				System.out.print("Enter Address: ");
				String address = scan.next();
				
				try {contact contact = new contact(contactId, firstName, lastName, phone, address);
					contact.add(contact);
				}
				
				catch(RuntimeException e) {
					System.out.println(e.getMessage());
				}
				
			}
			
			else if(Character.compare(option, 'd') ==0 || Character.compare(option, 'D')==0) {
				
				System.out.print("Enter contact id: ");
				String contactId = scan.next();
				
				contact contact = findByID(contactId);
				
				if(contact!=null)
					contact.remove(contact);
				else
					System.out.println("Contact with ID "+contactId+" not present.");
				
			}else if(Character.compare(option, 'u') ==0 || Character.compare(option, 'U')==0) {


				System.out.print("Enter contact id: ");
				String contactId = scan.next();
				
				contact contact = findByID(contactId);
				
				try {
					
					System.out.print("Enter First Name: ");
					String firstName = scan.next();
					
					contact.setFirstName(firstName);


					System.out.print("Enter Last Name: ");
					String lastName = scan.next();
					
					contact.setLastName(lastName);


					System.out.print("Enter Phone: ");
					String phone = scan.next();
					
					contact.setPhone(phone);
					
					System.out.print("Enter Address: ");
					String address = scan.next();
					
					contact.setAddress(address);
					
				}catch(RuntimeException e) {
					System.out.println(e.getMessage());
				}
				
			}
			
		}

	}

	public static contact findByID(String contactId) {
		
		for(contact contact : contacts)
			if(contact.getContactId().equals(contactId))
				return contact;
		
		return null;
		
	}

}
