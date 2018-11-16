import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    static public void guess(String word, int life){

        char[] filler= new char[word.length()];
        int i =0;
        while (i<word.length() ){
            filler[i]='-';
            if(word.charAt(i)==' '){
                filler[i]=' ';
            }
            i++;
        }
        System.out.print(filler);
        System.out.println("     Life remaining=" + life);
        ArrayList<Character> l = new ArrayList<Character>();


        Scanner s=new Scanner(System.in); // de scanner leest de letters die worden ingetypt om te kijken of het past bij het woord

        while(life>0){



            char x=s.next().charAt(0); // letter input door gebruiker

            if(l.contains(x)){
                System.out.println("in use");//wanneer de speler een letter invoert dat al in gebruikt is, kunt hij/zij het niet weer invullen.
                continue; //terwijl loop bezig is
            }

            l.add(x);

            if(word.contains(x+"")){
                for(int y=0;y<word.length();y++) { //deze loop checkt voor indexes van de letter
                    if(word.charAt(y)==x){         // en zal er een '-' er voor in de plaats doen
                        filler[y]=x;                 //het letter
                    }
                }
            }
            else{
                life--; //leven gaat af als het de verkeerde letter is
            }
            if(word.equals(String.valueOf(filler))) { //controleert of de filler hetzelfde is als als woord
                System.out.print(filler);
                System.out.println("! - Way to go!");
                break;
            }

            System.out.print(filler);
            System.out.println("     Life remaining =" + life);
        }
        if(life==0){
            System.out.println("Bummer!");
        }



    }


    public static void main (String[] args) {
        System.out.println("Welcome to hangman!\n The goal of the game is to guess the word.\n You've only got a few lives so good luck! To quit out, press exit.");
        //Spel uitleg wordt weergegeven wanneer het spel word opgestart.

        String word ="programming"; // het woord die geraden moet worden!
        int life=5;
        guess(word,life);










    }
}


