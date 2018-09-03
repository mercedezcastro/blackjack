public class Card {
   public static enum Suit {HEARTS, DIAMONDS, SPADES, CLUBS};
   private int value;
   private Suit suit;
    
   public Card(Suit s, int val) {
      suit = s;
      value = val;
   }
   public String toString() {
      String temp = "";
      if (value == 1) {
         temp += "Ace";
      }
      else if (value == 2) {
         temp += "Two";
      }
      else if (value == 3) {
         temp += "Three";
      }
      else if (value == 4) {
         temp += "Four";
      }
      else if (value == 5) {
         temp += "Five";
      }
      else if (value == 6) {
         temp += "Six";
      }
      else if (value == 7) {
         temp += "Seven";
      }
      else if (value == 8) {
         temp += "Eight";
      }
      else if (value == 9) {
         temp += "Nine";
      }
      else if (value == 10) {
         temp += "Ten";
      }
      else if (value == 11) {
         temp += "Jack";
      }
      else if (value == 12) {
         temp += "Queen";
      }
      else if (value == 13) {
         temp += "King";
      }
      temp += " of " + suit;
      return temp;
   }
   public int getValue() {
      return value;
   }
   public Suit getSuit() {
      return suit;
   }
}
