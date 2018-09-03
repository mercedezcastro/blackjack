/*
	Proj 1.java - Mercedez Castro

Construct new Scanner object tied to keyboard, store as keyboard
Set boolean programRunning to true
While programRunning
	Construct new Deck object, store as myDeck
	Shuffle myDeck
	Construct new Hand object, store as playerHand
	Construct new Hand object, store as dealerHand
	Construct new Card object, store as card, call nextCard from myDeck
	Add card to playerHand
	Construct new Card object, store as card1, call nextCard from myDeck
	Add card1 to dealerHand
	Get card, call nextCard from myDeck
	Add card to playerHand
	Construct new Card object, store as card2, call nextCard from myDeck
	Add card2 to dealerHand	
	Print "BLACKJACK \n"
	Print "------------------------------- \n"
	Print "Your hand: " + playerHand
	Get hand value from playerHand, store as playerValue of type int
	Get hand value from dealerHand, store as dealerValue of type int
	Print "Your hand value: " + playerValue + "\n"
	Print "Dealer is showing: " + card1 + "\n"	
	Set boolean dealerPlaying to true
	Set boolean playerPlaying to true
	Set boolean playerBust to false
	Set boolean dealerBust to false
	If playerValue == 21
		Print "Blackjack! You win"
		Set playerPlaying to False
		Set dealerPlaying to False
	While playerPlaying
		Ask user to enter (h/s) to hit or stand, store as choice
			Trim choice

		Ask user to enter (y\n) to continue, store as response
		Trim response 
		If response equals "n" ignoring case
			Set programRunning to false
*/
import java.util.Scanner;
class Proj1 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		boolean programRunning = true;
		while (programRunning) {
			Deck myDeck = new Deck();
			myDeck.shuffle();
			Hand playerHand = new Hand();
			Hand dealerHand = new Hand();
			Card card = myDeck.nextCard();
			playerHand.add(card);
			Card card1 = myDeck.nextCard();
			dealerHand.add(card1);
			card = myDeck.nextCard();
			playerHand.add(card);
			Card card2 = myDeck.nextCard();
			dealerHand.add(card2);
			System.out.println("BLACKJACK \n");
			System.out.println("------------------------------- \n");
			System.out.println("Your hand: " + playerHand);
			int playerValue = playerHand.getHandValue();
			int dealerValue = dealerHand.getHandValue();
			System.out.println("Your hand value: " + playerValue + "\n");
			System.out.println("Dealer is showing: " + card1 + "\n");
			boolean playerPlaying = true;
			boolean dealerPlaying = true;
			boolean playerBust = false;
			boolean dealerBust = false;
			if (playerValue == 21) {
				System.out.println("Blackjack! You win");
				playerPlaying = false;
				dealerPlaying = false;
			}
			while (playerPlaying) {
				System.out.print("Do you wish to hit or stand (h/s): ");
				String choice = keyboard.nextLine().trim();
				if (choice.equalsIgnoreCase("s")) {
					playerPlaying = false;
					playerBust = false;
					System.out.println("Dealer opening hand: " + dealerHand);
				}	
				else {
					card = myDeck.nextCard();
					playerHand.add(card);
					playerValue = playerHand.getHandValue();
					System.out.println("Your card: " + card);
					System.out.println("Your hand after drawing card: ");
					System.out.println(playerHand);
					System.out.println("Your hand value: " + playerValue + "\n");
					if (playerValue > 21) {
						System.out.println("Sorry, you busted :( \n");
						playerBust = true;
						playerPlaying = false;
						dealerPlaying = false;
					}
				}
			} // END WHILE PLAYERPLAYING
			while (dealerPlaying) {
				dealerValue = dealerHand.getHandValue();			   
				if (dealerValue >= 17) {
					dealerPlaying = false;
					dealerBust = false;
				}
				else if (dealerValue < 17) {
					card = myDeck.nextCard();
					dealerHand.add(card);
					System.out.println("Dealer hits, he delt: " + card);
					System.out.println("Dealer hand: " + dealerHand);
					System.out.println("Dealer hand value : " + dealerValue + "\n");
					if (dealerValue > 21) {
						System.out.println("Dealer bust. You win. \n");
						dealerBust = true;
						dealerPlaying = false;	
					}			
				}				
			} // END WHILE DEALERPLAYING	
			if (!dealerBust && !playerBust) {
				if (playerValue > dealerValue) {
					System.out.println("You win! \n");
					System.out.println("------------------------------- \n");
				}
				else if (dealerValue > playerValue) {
					System.out.println("Dealer wins. \n");
					System.out.println("------------------------------- \n");
				}
				else if (dealerValue == playerValue) {
					System.out.println("Tie. \n");
					System.out.println("------------------------------- \n");
				}
			} // END IF BUST
			System.out.print("Do you want to play again? (y/n): ");
			String response = keyboard.nextLine().trim();
			if (response.equalsIgnoreCase("n")) {
				programRunning = false;
			}
		} // END WHILE PROGRAMRUNNING
	} // END OF MAIN
}	// END OF CLASS
