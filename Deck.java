import java.util.Random; 
import java.util.ArrayList; 
public class Deck 
{ 
   private ArrayList<Card> deck; 
   private static Random random;
   private int count; 
   
   static { 
      random = new Random(System.currentTimeMillis()); 
   } 
   public Deck() 
   { 
      count = 0;
      deck = new ArrayList<Card>(); 
      for (Card.Suit suit : Card.Suit.values()) { 
         for (int val = 1; val <= 13; val++) { 
            deck.add(new Card(suit,val)); 
         } 
      } 
   }
   public Card nextCard() {
      Card myCard = deck.get(count);
      count++;
      return myCard;
   } 
   public void shuffle() 
   { 
      for (int i = 0; i < 52; i++) { 
         int r = i + random.nextInt(52-i); 
         Card temp = deck.get(i); 
         deck.set(i,deck.get(r)); 
         deck.set(r,temp); 
      } 
   } 
   public String toString() 
   { 
      String temp = ""; 
      for (Card c : deck) { 

         temp += c + "\n"; 
      } 
      return temp; 
   } 
}
