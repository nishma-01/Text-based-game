package com.company;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MainGame {

 /*
        Author: Joe Yuen, for CS3IOS Project 2021-2022
        block
            0(PenvilleHigh)             1(Downtown)             2(MagicShop)
            3(ClubMed)                 4(CityHall)            5(Cemetery)
            6(Church)                   7(ThePortal)           8(Library)
    */
    /*
        solvePuzzle()                               :A function will be called when player uses the key at the exit gate.  The function returns true if player has solved the puzzle, false otherwise.

        block_0(String action, string noun)         :A function will be called when player enters the particular block and issue a command.  The function returns "undefined" if the action is invalid
        :                                               each function represents one block in the game world.  The arrangement is listed above. Starts by default from ID 4
        block_8(String action, string noun)             block_0: means the block with ID 0

        getNextBlock(int currentBlock, String dir)  :get the ID of the block next to the current block in "dir" direction.  currentBlock=ID of currentBlock, dir={north|west|east|south}

        getBlockName(int i)                         :return the name of the block with give an ID (i)

        printBag(String bag[])                      :print out the content of player's bag

        printMap(int playerLocation)                :Given the player's location (in term of block ID), print the map around the player

        start()                                     :The main game loop.  The main component is a while loop that keep reading "action" and "noun" from user input until "exit" is entered

        main()                                      :The main method which create the MainGame object and call the method start to start the game.

    */
        boolean puzzleSolved = false;

        boolean solvePuzzle(){
            Scanner in = new Scanner(System.in);
            int token=3;                                                                                                // token is the number of times the player can guess the answer correctly

            System.out.println("Congratulations, you reached the final challenge...");
          //  System.out.println("But try and answer this: What runs but never walks?");
                while (token>0){
                    int randomNumber = ThreadLocalRandom.current().nextInt(1, 6);

                    System.out.println("I'm thinking of a number between 1 and 5. Try and guess it.");
                    System.out.println("Your guess: ");
                    int guess = in.nextInt();

                    if (guess == randomNumber) {
                        System.out.println("Correct! Aren't you lucky.");
                        System.out.println("You are a smart slayer! You may seal the portal gate... if you have what you need to do it hahaha!");
                        return true;
                    } else {
                        token -= 1;                                                                                         // this is token counter. TOKEN COUNT DECREASES BY 1 IF THE PLAYER TAKES A TURN AT ANSWERING THE RIDDLE BUT FAILS.
                        if (token>0)
                            System.out.println("Sorry, it is incorrect.  You can try "+token+" more time");
                            System.out.println("Guess again: ");
                        if (guess == randomNumber) {
                            return true;
                        }
                    }
                    }


            return false; }


        String block0(String action, String noun) {                                                                      //function called when particular command is issued by the player, in the specific block.
            if (action.equals("check") && noun.equals("block")) {
                return "PenvilleHigh";
            } else if (action.equals("examine")) {
                if (noun.equals("all")) {
                    System.out.println("1. torch");
                    System.out.println("2. crossbow");
                    System.out.println("3. stake");

                } else if (noun.equals("torch")) {                                                                      //can change these to change the puzzle. nothing comes up for examine toolboxes
                    System.out.println("torch: A light in the dark");
                } else if (noun.equals("crossbow")) {
                    System.out.println("crossbow: Take a shot");
                } else if (noun.equals("stake")) {
                    System.out.println("Take a stab at a vampire");

                } else {
                    System.out.println("Item not found");
                    return "Item not found";
                }
                return "ok";

            } else if (action.equals("take")) {
                if (noun.equals("torch")) {
                    return "torch";
                } else if (noun.equals("crossbow")) {
                    return "crossbow";
                } else if (noun.equals("stake")) {
                    return "stake";
                } else {
                    return "undefined";
                }
            }
            return "undefined";
        }

        String block1(String action, String noun) {
            if (action.equals("check") && noun.equals("block")) {
                return "Downtown";
            } else if (action.equals("examine")) {
                if (noun.equals("all")) {
                    System.out.println("1. slayerguide");

                } else if (noun.equals("slayerguide")) {
                    System.out.println("slayerguide: a guide to being a slayer");
                } else {
                    System.out.println("Item not found");
                    return "Item not found";
                }
                return "ok";

            } else if (action.equals("take")) {
                if (noun.equals("slayerguide")) {
                    return "slayerguide";
                } else {
                    return "undefined";
                }
            }
            return "undefined";
        }

        String block2(String action, String noun) {
            if (action.equals("check") && noun.equals("block")) {
                return "MagicShop";
            } else if (action.equals("examine")) {
                if (noun.equals("all")) {
                    System.out.println("1. spellbook");
                    System.out.println("2. crystal");
                    System.out.println("3. sage");

                } else if (noun.equals("spellbook")) {
                    System.out.println("spellbook: find a spell");
                } else if (noun.equals("crystal")) {
                    System.out.println("crystal: use to close the portal");
                } else if (noun.equals("sage")) {
                    System.out.println("sage: purifying herb");
                } else {
                    System.out.println("Item not found");
                    return "Item not found";
                }
                return "ok";

            } else if (action.equals("take")) {
                if (noun.equals("spellbook")) {
                    return "spellbook";
                } else if (noun.equals("crystal")) {
                    return "crystal";
                } else if (noun.equals("sage")) {
                    return "sage";
                } else {
                    return "undefined";
                }
            }
                return "undefined";
            }

    String block3(String action, String noun){
            if (action.equals("check") && noun.equals("block")){
                return "ClubMed";
            }
            return "undefined";
        }
        String block4(String action, String noun){
            if (action.equals("check") && noun.equals("block")){
                return "CityHall";
            }
            return "undefined";
        }
        String block5(String action, String noun){
            if (action.equals("check") && noun.equals("block")){
                return "Cemetery";
            }
            return "undefined";
        }
        String block6(String action, String noun){
            if (action.equals("check") && noun.equals("block")){
                return "Church";
            }
            return "undefined";
        }
        String block7(String action, String noun){

            if (action.equals("check") && noun.equals("block")){
                return "ThePortal";
            }else if (action.equals("examine")) {
                if (noun.equals("all")) {
                    System.out.println("1. portalgate");
                    System.out.println("2. demon");

                } else if (noun.equals("portalgate")) {
                    System.out.println("The portal is still open, you must close it to protect Penville!");
                } else if (noun.equals("demon")) {
                    if (puzzleSolved){
                        System.out.println("You already solved the puzzle");
                    }else if (solvePuzzle()){
                        puzzleSolved=true;
                    }else{
                        System.out.println("Please try again if you know the answer");
                    }
                }else{
                    System.out.println("Item not found");
                }
            }else if (action.equals("take")){

                return "undefined";

            }else if (action.equals("use")){
                //The start method should check if the player has the item to be used first
                if (noun.equals("crystal")){
                    if (puzzleSolved){

                        return "GameCompleted";
                    }else{
                        System.out.println("Speak to the demon first");
                        return "invalid";
                    }
                }else{
                    System.out.println(noun+" cannot be used here");
                }
            }
            return "undefined";
        }
        String block8(String action, String noun){
            if (action.equals("check") && noun.equals("block")){
                return "Library";
            }
            return "undefined";
        }


        int getNextBlock (int currentBlock, String dir) {                                                               //method for getting next block value, parameter input is current block and direction
            int nextBlock = -1;                                                                                         //variable nextBlock is set at -1 as default as this gives error message since not valid map number

            if (dir.equals("north")) {
                nextBlock = currentBlock -3;                                                                            //this counts backwards by 3 which results in the block above as the new value for the nextBlock
                if (nextBlock < 0)                                                                                      //invalid as off the map so reverts to default variable value -1 which is invalid
                    nextBlock = -1;
            } else if (dir.equals("east")) {
                nextBlock = currentBlock +1;                                                                            //this adds 1 to the current block which moves the player one to the right(east)
                if (nextBlock == 3||nextBlock == 6||nextBlock == 9)                                                     //invalid block numbers since its going off the map and then back on so in that case, next block is default -1 aka invalid
                    nextBlock = -1;
            } else if (dir.equals("south")) {
                nextBlock = currentBlock +3;                                                                            //this adds 3 to the current block id so results in the block below (south)
                if (nextBlock > 8)                                                                                      //invalid as off the map so reverts to default variable value -1 which is invalid
                    nextBlock = -1;
            } else if (dir.equals("west")) {
                nextBlock = currentBlock -1;                                                                            //count back by 1 moves player left (west) on map
                if (nextBlock == 2 || nextBlock == 5)                                                                   //invalid as off the map so reverts to default variable value -1 which is invalid. Don't include -1 for id 0 since -1 is already defined as default variable value
                    nextBlock = -1;
            }

            if (nextBlock != -1){                                                                                       //if the next block is not = -1:
                if (nextBlock==0 && block0("check","block")!="n/a")
                    return nextBlock;
                if (nextBlock==1 && block1("check","block")!="n/a")
                    return nextBlock;
                if (nextBlock==2 && block2("check","block")!="n/a")
                    return nextBlock;
                if (nextBlock==3 && block3("check","block")!="n/a")
                    return nextBlock;
                if (nextBlock==4 && block4("check","block")!="n/a")
                    return nextBlock;
                if (nextBlock==5 && block5("check","block")!="n/a")
                    return nextBlock;
                if (nextBlock==6 && block6("check","block")!="n/a")
                    return nextBlock;
                if (nextBlock==7 && block7("check","block")!="n/a")
                    return nextBlock;
                if (nextBlock==8 && block8("check","block")!="n/a")
                    return nextBlock;
                nextBlock=-1;                                                                                           // why is this here?
            }
            return nextBlock;                                                                                           //why is this here?
        }
        String getBlockName(int id){                                                                                    //method for getting the block name from the id number
            String name="Error";                                                                                        //default string name if the id is invalid
            if (id==0){
                name= block0("check","block");                                                             //if id==0 then function passes strings "check" "block" into parameters for the function block0 which then returns "townhall"
            }else if (id==1){
                name= block1("check","block");
            }else if (id==2){
                name= block2("check","block");
            }else if (id==3){
                name= block3("check","block");
            }else if (id==4){
                name= block4("check","block");
            }else if (id==5){
                name= block5("check","block");
            }else if (id==6){
                name= block6("check","block");
            }else if (id==7){
                name= block7("check","block");
            }else if (id==8) {
                name = block8("check", "block");
            }
            return name;
        }

    ArrayList <String> guessLetter = new ArrayList<String>();
                                                                                    //array variable declared outside method so that it is accessible for all methods, so it is a global variable rather than local
    void guessCrystal (ArrayList <String> guessLetter) {
        guessLetter.add ("o");
        guessLetter.add ("n");
        guessLetter.add ("y");
        guessLetter.add ("x");

        for (String l : guessLetter) ;                                                                               // for each loop - same as  for (int i = 0; i < bag.length; i++ ) { b is the variable that holds the array element
        {
            System.out.println(guessLetter);
        }
    }


        ArrayList <String> bagContents = new ArrayList<String>(5);                                               //array variable declared outside method so that it is accessible for all methods, so it is a global variable rather than local

        void printBag(ArrayList <String> bagContents) {
            for (String b : bagContents) ;                                                                               // for each loop - same as  for (int i = 0; i < bag.length; i++ ) { b is the variable that holds the array element
            {
                System.out.println(bagContents);
            }
        }

        void printMap(int playerLocation) {                                                                              //local variable, accesible within package. need to pass data into the playerLocation variable
            int north = getNextBlock(playerLocation, "north");
            String goNorth = " | North: " + getBlockName(north) + " |";

            int south = getNextBlock(playerLocation, "south");
            String goSouth = "| South: " + getBlockName(south) + " |";

            int west = getNextBlock(playerLocation, "west");
            String goWest = "| West: " + getBlockName(west) + " | <- ";

            int east = getNextBlock(playerLocation, "east");
            String goEast = " -> | East: " + getBlockName(east) + " |";

            String current = "| Current: " + getBlockName(playerLocation) + " |";

              String spaceNorth = " ".repeat(((current.length() - goNorth.length())/2)+ goWest.length());
              String spaceSouth = " ".repeat(((current.length() - goSouth.length())/2) + goWest.length());
              String spaceArrow = " ".repeat(((current.length())/2) + goWest.length());

                 System.out.println(spaceNorth + goNorth);
                 System.out.println(spaceArrow + "^ \n" + spaceArrow + "|");
                 System.out.println(goWest + current + goEast);
                 System.out.println(spaceArrow + "| \n" + spaceArrow + "v");
                 System.out.println(spaceSouth + goSouth);
          }

    void start () {
        Scanner in = new Scanner(System.in);

        String action = "";
        String noun = "";
        int currentBlock = 4;                                                                                      //starting current block is 4 by default
        System.out.println("================================================================================================ \n Welcome to Penville, home to the portal gate which leads to the underwold...\n================================================================================================");
        System.out.println("The portal makes Penville a breeding ground for evil, especially vampires and demons...\n================================================================================================");
        System.out.println("The vampire slayer is out of town and the people of Penville need your help!\n================================================================================================");
        System.out.println("You must get to the portal and seal the portal gate to the underworld to stop the evil creatures escaping into Penville\n================================================================================================");
        System.out.println("| Game started, type 'exit' to quit. | use commands 'go|examine|take|drop|use|show|check|exit' |\n================================================================================================");

        while (!action.equals("exit")) {
            String[] words = in.nextLine().split(" ");
            //action = in.next();
            action = words[0];
            if (words.length > 1)
                noun = words[1];
            if (!action.equals("go") && !action.equals("examine") && !action.equals("take") && !action.equals("drop") && !action.equals("use") && !action.equals("exit") && !action.equals("show") && !action.equals("check")) {
                System.out.println("Invalid command, please use go|examine|take|drop|use|show|check|exit");
            } else if (words.length > 2) {
                System.out.println("Invalid command, please use \"action noun\"");
            } else {
                if (action.equals("exit")) {
                    System.out.println("You have quit the game successfully");
                    System.exit(0);
                }

                if (action.equals("go")) {
                    //check whether the destination is a  valid move
                    int n;
                    if (noun.equals("north") || noun.equals("east") || noun.equals("south") || noun.equals("west")) {
                        n = getNextBlock(currentBlock, noun);
                        if (n != -1) {
                            currentBlock = n;
                            System.out.println("Player moves to " + getBlockName(currentBlock));
                            printMap(currentBlock);
                        } else {
                            System.out.println("You can't move to there");
                        }
                    } else {
                        System.out.println("Invalid direction, please use north|east|south|west");
                    }

                } else if (action.equals("drop")) {
                    if (noun.equals("torch") || noun.equals("crossbow") || noun.equals("stake") || noun.equals("downtown") || noun.equals("slayerguide") || noun.equals("spellbook") || noun.equals("crystal") || noun.equals("sage")) {
                        if (bagContents.contains(noun)) {
                            bagContents.remove(noun);
                            System.out.println("The " + noun + " has been removed from your bag.");
                        } else if (!bagContents.contains(noun)) {
                            System.out.println("You do not have the " + noun + " in your bag.");
                        }
                    } else {
                        System.out.println("Invalid.");
                    }

                } else if (action.equals("take")) {
                    if (noun.equals("torch") || noun.equals("crossbow") || noun.equals("stake")) {
                        if (currentBlock == 0) {
                            if (bagContents.size() < 5 && !bagContents.contains(noun)) {
                                bagContents.add(noun);
                                System.out.println("The " + noun + " has been added to your bag.");
                            } else if (bagContents.contains(noun)) {
                                System.out.println("You already have the " + noun + " in your bag. Choose something else.");
                            }
                            else if (bagContents.size() == 5) {
                                System.out.println("You already have the maximum number of items in your bag. To take a new item, you must drop one first.");
                            }
                        } else {
                            System.out.println("Sorry, " + noun + " is unavailable at this location.");
                        }
                    }

                    if (noun.equals("slayerguide")) {
                        if (currentBlock == 1) {
                            if (bagContents.size() < 5 && !bagContents.contains(noun)) {
                                bagContents.add(noun);
                                System.out.println("The " + noun + " has been added to your bag.");
                            } else if (bagContents.contains(noun)) {
                                System.out.println("You already have the " + noun + " in your bag. Choose something else.");
                            }
                            else if (bagContents.size() == 5) {
                                System.out.println("You already have the maximum number of items in your bag. To take a new item, you must drop one first.");
                            }
                        } else {
                            System.out.println("Sorry, " + noun + " is unavailable at this location.");
                        }
                    }

                    if (noun.equals("spellbook") || noun.equals("crystal") || noun.equals("sage")) {
                        if (currentBlock == 2) {
                            if (bagContents.size() < 5 && !bagContents.contains(noun)) {
                                bagContents.add(noun);
                                System.out.println("The " + noun + " has been added to your bag.");
                            } else if (bagContents.contains(noun)) {
                                System.out.println("You already have the " + noun + " in your bag. Choose something else.");
                            }
                            else if (bagContents.size() == 5) {
                                System.out.println("You already have the maximum number of items in your bag. To take a new item, you must drop one first.");
                            }
                        } else {
                            System.out.println("Sorry, " + noun + " is unavailable at this location.");
                        }
                    }
                }

                else if (action.equals("show")) {
                    //action = show, noun is stored in the variable "noun", which should be map
                    if (noun.equals("map")) {
                        printMap(currentBlock);
                    }
                    else if (noun.equals("bag")) {
                        printBag(bagContents);
                    }
                    else {
                        System.out.println("Invalid noun, please use \"show map\" or \"show bag\"");
                    }

                } else if (action.equals("check")) {
                    //action = check, noun is stored in the variable "noun", which should be "block"
                    if (noun.equals("block")) {
                        System.out.println(getBlockName(currentBlock));
                    } else {
                        System.out.println("Invalid noun, please use \"check block\"");
                    }
                }

                else if (action.equals("use")) {
                    if (currentBlock == 5) {
                        if (noun.equals("torch") && bagContents.contains("torch")) {
                            System.out.println("Now you can see clearer, can you see that vampire behind the tombstone?! You must kill it using something sharp...");
                        } else if (noun.equals("stake") && bagContents.contains("stake")) {
                            System.out.println("Excellent you killed a vampire!");
                        } else {
                            System.out.println("You can't use " + noun + " here, try something else. Hint: use something to help you see in the dark...");
                        }
                    } else if (currentBlock != 5) {
                        if ((noun.equals("torch") && bagContents.contains("torch")) || (noun.equals("stake") && bagContents.contains("stake"))) {
                            System.out.println("You can't use " + noun + " here! Hint: use it somewhere dark where ghosts dwell...");
                        }
                    }
                }
                    //else if (currentBlock == 7){
                      //  if (noun.equals("crossbow") && bagContents.contains("crossbow") && puzzleSolved) {
                        //    System.out.println("Congratulations! You have finished this game! \nYou sealed the portal gate, and the town of Penville is safe once again :)");

                 //       }

                 else {
                    // Let the current block handle the command first
                    // The result of a given action will be stored in "result"
                    String result = "";
                    if (currentBlock == 0) {
                        result = block0(action, noun);
                    } else if (currentBlock == 1) {
                        result = block1(action, noun);
                    } else if (currentBlock == 2) {
                        result = block2(action, noun);
                    } else if (currentBlock == 3) {
                        result = block3(action, noun);
                    } else if (currentBlock == 4) {
                        result = block4(action, noun);
                    } else if (currentBlock == 5) {
                        result = block5(action, noun);
                    } else if (currentBlock == 6) {
                        result = block6(action, noun);
                    } else if (currentBlock == 7) {
                        result = block7(action, noun);
                    } else if (currentBlock == 8) {
                        result = block8(action, noun);
                    }
                    //Handle the result
                    //

                    if (action.equals("use") && noun.equals("crystal") && bagContents.contains("crystal") && (result.equals("GameCompleted"))){
                     System.out.println("Congratulations! You have finished this game! \nYou sealed the portal gate, and the town of Penville is safe once again :)");
                     break;
                    }}}
                }
        }//end while


    public static void main (String[]args){
        MainGame m = new MainGame();
        m.start();

    }
}


