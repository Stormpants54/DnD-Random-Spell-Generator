import java.io.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class FileMaker {
    public static int findLevel(String[] twoWord) throws FileNotFoundException,IllegalStateException{
        if(twoWord[1].equals("cantrip")){
            return 0;
        }
        else{
            return Integer.parseInt(twoWord[0].substring(0,1));
        }

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean on = true;

        try{
            while(on){
                System.out.println("Select a range of spell you want to randomize!(Format like this:{Smaller spell Lvl}:{Bigger spell Lvl})");
                String userInput = input.nextLine();
                //Formats the user's input to be used in the for loop
                String[] userList= userInput.split(":");
                int firstSpell = Integer.parseInt(userList[0]);
                int secondSpell = Integer.parseInt(userList[1]);

                //Lists for all spells made
                ArrayList<String> spellStringList = new ArrayList<>();

                //Reads the files of the coresponding spell lvl
                for(int i = firstSpell; i <= secondSpell; i ++){
                    String temp = "";
                    String fileSpell = "";
                    //This switch updates tge fule read
                    switch (i) {
                        case 0:
                            fileSpell = "cantrips.txt";
                            break;
                        case 1:
                            fileSpell = "firstLvl.txt";
                            break;
                        case 2:
                            fileSpell = "secondLvl.txt";
                            break;
                        case 3:
                            fileSpell = "thirdLvl.txt";
                            break;
                        case 4:
                            fileSpell = "forthLvl.txt";
                            break;
                        case 5:
                            fileSpell = "fifthLvl.txt";
                            break;
                        case 6:
                            fileSpell = "sixthLvl.txt";
                            break;
                        case 7:
                            fileSpell = "seventhLvl.txt";
                            break;
                        case 8:
                            fileSpell = "eighthLvl.txt";
                            break;
                        case 9:
                            fileSpell = "ninthLvl.txt";
                            break;

                    }
                    //On each pass it checks a diffent file
                    File hi = new File(fileSpell);
                    Scanner spellRead = new Scanner(hi);
                    String spellCurrentWrite = "";

                    int z = 0;
                    //Reads each line and saves each String to the spellStringList
                    while (spellRead.hasNextLine()) {
                        temp = spellRead.nextLine();
                        z++;
                        if (z == 8) {
                            //spellCurrentWrite += temp;
                            spellStringList.add(spellCurrentWrite);
                            spellCurrentWrite = "";
                            z = 0;
                        } else if (z == 7) {
                            spellCurrentWrite += temp;
                        } else {
                            spellCurrentWrite += temp + "/";
                        }
                    }
                    spellRead.close();
                }
                //List of Random Spells that are pickable
                ArrayList<Spells> listOfSpells = new ArrayList<>();
                for (int j = 0; j < spellStringList.size(); j++) {
                    String[] tempSpellHold = spellStringList.get(j).split("/");
                    String[] rangeFinder = tempSpellHold[3].split(" ");
                    String range = rangeFinder[1];
                    String[] levelFinder = tempSpellHold[1].split(" ");
                    int level = findLevel(levelFinder);
                    if (level == 0) {
                        Spells newSpell = new Spells(tempSpellHold[0], levelFinder[0], level, tempSpellHold[2], range, tempSpellHold[4], tempSpellHold[5], tempSpellHold[6]);
                        listOfSpells.add(newSpell);
                    } else {
                        Spells newSpell = new Spells(tempSpellHold[0], levelFinder[1], level, tempSpellHold[2], range, tempSpellHold[4], tempSpellHold[5], tempSpellHold[6]);
                        listOfSpells.add(newSpell);
                    }
                }
                int indexOfSpell = (int) (Math.random() * listOfSpells.size());
                System.out.println("The Spell You Got Is:\n"+listOfSpells.get(indexOfSpell).toStringWrite()+"\nDo You Want to Try Again? Type 1 for Yes and anything else for no");
                String again = input.nextLine();
                if(again.length()>1){
                    on = false;
                } else if (Integer.parseInt(again) != 1){
                    on = false;
                }  {

                }
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("Error file not found " + e.getMessage()+"\nCreating Files");
            try {
                ArrayList<String> spellStringList = new ArrayList<>();
                ArrayList<Spells> listOfSpells = new ArrayList<>();

                Scanner fileReader = new Scanner(new File("TestSpells.txt"));
                String temp = "";
                String currentWrite = "";
                int i = 0;
                while (fileReader.hasNextLine()) {
                    temp = fileReader.nextLine();
                    i++;
                    if (i == 7) {
                        currentWrite += temp;
                        spellStringList.add(currentWrite);
                        currentWrite = "";
                        i = 0;
                    } else {
                        currentWrite += temp + "/";
                    }
                }
                fileReader.close();
                //Formats files to be easy to read/access and change later
                for (int j = 0; j < spellStringList.size(); j++) {
                    String[] tempSpellHold = spellStringList.get(j).split("/");
                    String[] rangeFinder = tempSpellHold[3].split(" ");
                    String range = rangeFinder[1];
                    String[] levelFinder = tempSpellHold[1].split(" ");
                    int level = findLevel(levelFinder);
                    if (level == 0) {
                        Spells newSpell = new Spells(tempSpellHold[0], levelFinder[0], level, tempSpellHold[2], range, tempSpellHold[4], tempSpellHold[5], tempSpellHold[6]);
                        listOfSpells.add(newSpell);
                    } else {
                        Spells newSpell = new Spells(tempSpellHold[0], levelFinder[1], level, tempSpellHold[2], range, tempSpellHold[4], tempSpellHold[5], tempSpellHold[6]);
                        listOfSpells.add(newSpell);
                    }

                }
                //I mean idk if there is a better way than this tbh
                PrintWriter cantrips = new PrintWriter(new FileWriter("cantrips.txt"));
                PrintWriter firstLevel = new PrintWriter(new FileWriter("firstLvl.txt"));
                PrintWriter secondLevel = new PrintWriter(new FileWriter("secondLvl.txt"));
                PrintWriter thirdLevel = new PrintWriter(new FileWriter("thirdLvl.txt"));
                PrintWriter fourthLevel = new PrintWriter(new FileWriter("forthLvl.txt"));
                PrintWriter fifthLevel = new PrintWriter(new FileWriter("fifthLvl.txt"));
                PrintWriter sixthLevel = new PrintWriter(new FileWriter("sixthLvl.txt"));
                PrintWriter seventhLevel = new PrintWriter(new FileWriter("seventhLvl.txt"));
                PrintWriter eighthLevel = new PrintWriter(new FileWriter("eighthLvl.txt"));
                PrintWriter ninthLevel = new PrintWriter(new FileWriter("ninthLvl.txt"));

                for (int k = 0; k < listOfSpells.size(); k++) {
                    if (listOfSpells.get(k).getLevel() == 0) {
                        cantrips.println(listOfSpells.get(k) +
                                "\n=======================");
                    }
                    if (listOfSpells.get(k).getLevel() == 1) {
                        firstLevel.println(listOfSpells.get(k) +
                                "\n=======================");
                    }
                    if (listOfSpells.get(k).getLevel() == 2) {
                        secondLevel.println(listOfSpells.get(k) +
                                "\n=======================");
                    }
                    if (listOfSpells.get(k).getLevel() == 3) {
                        thirdLevel.println(listOfSpells.get(k) +
                                "\n=======================");
                    }
                    if (listOfSpells.get(k).getLevel() == 4) {
                        fourthLevel.println(listOfSpells.get(k) +
                                "\n=======================");
                    }
                    if (listOfSpells.get(k).getLevel() == 5) {
                        fifthLevel.println(listOfSpells.get(k) +
                                "\n=======================");
                    }
                    if (listOfSpells.get(k).getLevel() == 6) {
                        sixthLevel.println(listOfSpells.get(k) +
                                "\n=======================");
                    }
                    if (listOfSpells.get(k).getLevel() == 7) {
                        seventhLevel.println(listOfSpells.get(k) +
                                "\n=======================");
                    }
                    if (listOfSpells.get(k).getLevel() == 8) {
                        eighthLevel.println(listOfSpells.get(k) +
                                "\n=======================");
                    }
                    if (listOfSpells.get(k).getLevel() == 9) {
                        ninthLevel.println(listOfSpells.get(k) +
                                "\n=======================");
                    }
                }
                cantrips.close();
                firstLevel.close();
                secondLevel.close();
                thirdLevel.close();
                fourthLevel.close();
                fifthLevel.close();
                sixthLevel.close();
                seventhLevel.close();
                eighthLevel.close();
                ninthLevel.close();

            } catch (Exception f) {
                System.out.println("Error " + f.getMessage());
            }

        }
    }
}
