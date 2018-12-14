package flight_Assignment;

import java.util.Scanner;

public class AirportManager {

	Airport[] airports;
	Airport myLocation;

	public AirportManager() {
		airports = new Airport[15];

		Airport bangkok = new Airport("Bangkok");
		Airport india = new Airport("India");
		Airport beijing = new Airport("Beijing");
		Airport newYork = new Airport("New York");
		Airport madrid = new Airport("Madrid");
		Airport moscow = new Airport("Moscow");
		Airport tokyo = new Airport("Tokyo");
		Airport kualaLumpur = new Airport("Kuala Lumpur");
		Airport hongKong = new Airport("Hong Kong");
		Airport seoul = new Airport("Seoul");
		
		
		
		airports[0] = bangkok;
		airports[1] = india;
		airports[2] = beijing;
		airports[3] = newYork;
		airports[4] = madrid;
		airports[5] = tokyo;
		airports[6] = kualaLumpur;
		airports[7] = hongKong;
		airports[8] = seoul;
		
		
		bangkok.addFlight(india, "Bangkok Airways", "PG4847", "10:10", "15:50", 9721.72, "19/04/2019");
		bangkok.addFlight(beijing, "Bangkok Airways", "PG7243", "1:30", "7:00", 9287.65, "19/04/2019");
		bangkok.addFlight(newYork, "Etihad Airways", "EY101", "6:05", "3:55", 22019.58, "19/04/2019");
		
		india.addFlight(bangkok, "Thai airways", "AI332", "13:45", "19:20", 13400.00, "19/04/2019");
		india.addFlight(madrid, "Bangkok Airways", "PG7243", "1:30", "7:00", 9287.65, "19/04/2019");
		india.addFlight(newYork, "Etihad Airways", "EY101", "6:05", "3:55", 22019.58, "19/04/2019");

		beijing.addFlight(india, "Bangkok Airways", "PG4847", "10:10", "15:50", 9721.72, "19/04/2019");
		beijing.addFlight(bangkok, "Bangkok Airways", "PG7243", "1:30", "7:00", 9287.65, "19/04/2019");
		beijing.addFlight(kualaLumpur, "Etihad Airways", "EY101", "6:05", "3:55", 22019.58, "19/04/2019");

		moscow.addFlight(india, "Bangkok Airways", "PG4847", "10:10", "15:50", 9721.72, "19/04/2019");
		moscow.addFlight(bangkok, "Bangkok Airways", "PG7243", "1:30", "7:00", 9287.65, "19/04/2019");
		moscow.addFlight(madrid, "Etihad Airways", "EY101", "6:05", "3:55", 22019.58, "19/04/2019");

		hongKong.addFlight(india, "Bangkok Airways", "PG4847", "10:10", "15:50", 9721.72, "19/04/2019");
		hongKong.addFlight(bangkok, "Bangkok Airways", "PG7243", "1:30", "7:00", 9287.65, "19/04/2019");
		hongKong.addFlight(newYork, "Etihad Airways", "EY101", "6:05", "3:55", 22019.58, "19/04/2019");

		seoul.addFlight(madrid, "Bangkok Airways", "PG4847", "10:10", "15:50", 9721.72, "19/04/2019");
		seoul.addFlight(kualaLumpur, "Bangkok Airways", "PG7243", "1:30", "7:00", 9287.65, "19/04/2019");
		seoul.addFlight(newYork, "Etihad Airways", "EY101", "6:05", "3:55", 22019.58, "19/04/2019");
		
		tokyo.addFlight(bangkok, "Thai airways", "AI332", "13:45", "19:20", 13400.00, "19/04/2019");
		tokyo.addFlight(beijing, "Bangkok Airways", "PG7243", "1:30", "7:00", 9287.65, "19/04/2019");
		tokyo.addFlight(newYork, "Etihad Airways", "EY101", "6:05", "3:55", 22019.58, "19/04/2019");

		kualaLumpur.addFlight(india, "Bangkok Airways", "PG4847", "10:10", "15:50", 9721.72, "19/04/2019");
		kualaLumpur.addFlight(bangkok, "Bangkok Airways", "PG7243", "1:30", "7:00", 9287.65, "19/04/2019");
		kualaLumpur.addFlight(newYork, "Etihad Airways", "EY101", "6:05", "3:55", 22019.58, "19/04/2019");

		madrid.addFlight(india, "Bangkok Airways", "PG4847", "10:10", "15:50", 9721.72, "19/04/2019");
		madrid.addFlight(beijing, "Bangkok Airways", "PG7243", "1:30", "7:00", 9287.65, "19/04/2019");
		madrid.addFlight(newYork, "Etihad Airways", "EY101", "6:05", "3:55", 22019.58, "19/04/2019");
		
		newYork.addFlight(india, "Bangkok Airways", "PG4847", "10:10", "15:50", 9721.72, "19/04/2019");
		newYork.addFlight(beijing, "Bangkok Airways", "PG7243", "1:30", "7:00", 9287.65, "19/04/2019");
		newYork.addFlight(hongKong, "Etihad Airways", "EY101", "6:05", "3:55", 22019.58, "19/04/2019");
		
	}

	public Airport getMyLocation() {
		return myLocation;
	}

	public void setLocation(String location) {

		for (int i = 0; i < airports.length; i++) {
			if (airports[i].name.equalsIgnoreCase(location)) {
				this.myLocation = airports[i];
				break;
			}
		}

	}

	public void printto(String to) {

		myLocation.flightsTo(to);

	}

	public void book(Scanner scan) {
		System.out.print("TO: ");
		String to = scan.nextLine();
		this.printto(to);

		System.out.print("Enter the number to choose the flight : ");
		String temo = scan.nextLine();
		int choise = Integer.parseInt(temo) - 1;
			
		System.out.print("Full Name: ");
		String name = scan.nextLine();
		System.out.print("Enter your National id or Passport Number ");
		String id = scan.nextLine();
		System.out.print("Enter your Date of Birth(D/M/Y): ");
		String dob = scan.nextLine();
		Passenger n = new Passenger(name, dob, id);

		if (myLocation.flights[choise].book(n)) {
			System.out.println("Your Flight has successfully been booked have a nice day.");
		} else {
			System.out.print("Sorry no more seats left on the flight");
		}
	}

	
	public void checkFlight(Scanner scan) {
		System.out.print("Please enter your Full name: ");
		String name = scan.nextLine();
		
		Flight[] flights = this.myLocation.flights;

		for (int i = 0; i < this.myLocation.flightCount(); i++) {
			if(flights[i].findPassenger(name)) {
				System.out.println(flights[i].toString());
			}
		}
	}

}
