//imports
import kotlin.random.Random

fun main() {
    //variable to keep main game loop running
    var whileloopcount: Int = 0

    //setting up colors
    val colorRed = "\u001B[38;5;202m"
    val colorOrange = "\u001B[38;5;215m"
    val colorYellow = "\u001B[38;5;226m"
    val colorGreen = "\u001B[38;5;118m"
    val colorLightBlue = "\u001B[38;5;159m"
    val colorDarkBlue = "\u001B[38;5;27m"
    val colorpurple = "\u001b[38;5;165m"
    // Resets previous color codes
    val colorreset = "\u001b[0m"

    //setting up symbols
    var symbolOne = "⓵"
    var symbolTwo = "⓶"
    var symbolThree = "⓷"
    var symbolFour = "⓸"
    var symbolFive = "⓹"
    var symbolSix = "⓺"
    var symbolFullCorrect = "▣"
    var symbolPartialCorrect = "◻"

    //creating the solution colors and order as a list, will be used to compare against user inputs to see if user is correct
    val solutionlist = listOf(Random.nextInt(1,7), Random.nextInt(1,7), Random.nextInt(1,7), Random.nextInt(1,7))

    //creating list of previous guesses in order to display for each turn
    val guesseslist: MutableList<List<Int>> = mutableListOf()

    //list of privious "correct and in right spot" and "correct but in wrong spot" answers, will be used when displaying previous scores
    val feedbackListFull: MutableList<Int> = mutableListOf()
    val feedbackListPartial: MutableList<Int> = mutableListOf()

    //clearing screen
    println("\u001b[H\u001b[2J")

    println("                      __                       __          __ \n" +
            ".--------.---.-.-----|  |_.-----.----.--------|__.-----.--|  |\n" +
            "|        |  _  |__ --|   _|  -__|   _|        |  |     |  _  |\n" +
            "|__|__|__|___._|_____|____|_____|__| |__|__|__|__|__|__|_____|")
    println("type \"help\" for the game rules")
    println("type \"compatibility\" if characters aren't displaying properly (if any of these show up improperly: ⓵ ▣ ◻ )")

    //main game loop
    while (whileloopcount < 10) {


        //taking user input
        println("guess 4 numbers from 1 to 6 seperated by only commas. eg: 4,6,5,1 or, type \"i give up\" to get the solution")

        //getting user input
        val guessinput = readln()


        //testing user input for help and giving up
        when (guessinput) {
            "i give up" -> {
                println("solution is: $solutionlist")
                break
            }
            "help" -> {
                println("The idea of the game is for the player (the code-breaker) to guess the secret code chosen by the computer \n" +
                        "(the code-maker). The code is a sequence of 4 numbers chosen from 1 to 6. The code-breaker  \n" +
                        "makes a series of pattern guesses - after each guess the code-maker gives feedback in the form of 2 symbols \n" +
                        "filled in squares represent correct numbers in the right spot, and empty squares represent correct numbers, but \n" +
                        "in the wrong spot \n")
                continue
            }
            "compatibility" -> {
                println("compatibility mode enabled")
                symbolOne = "(1)"
                symbolTwo = "(2)"
                symbolThree = "(3)"
                symbolFour = "(4)"
                symbolFive = "(5)"
                symbolSix = "(6)"
                symbolFullCorrect = "[#]"
                symbolPartialCorrect = "[ ]"
                continue
            }
        }

        //spacing
        println("\n \n \n")
        println("\u001b[H\u001b[2J")

        //turning user input into list from string so that it can be compared to the solution list
        val guessstrings = guessinput.split(",")

        //testing user input to make sure its formatted properly and won't break the map function
        // also to make sure that user is only inputting 4 numbers from  1 to 6
        if (guessstrings.count() != 4) {
            println("input syntax wrong, try again.")
            continue
        }
        if (guessstrings.filterNot { s -> (s == "1") || (s == "2") || (s == "3") || (s == "4") || (s == "5") || (s == "6") }.isNotEmpty()) {
            println("input syntax wrong, try again.")
            continue
        }
        whileloopcount++

        //turning user input into proper formatting (formatted as a list of integers, just like the solution list)
        var guess = guessstrings.map { it.toInt() }

        guesseslist.add(guess)

        //setting up counters that will be used to display how the user scored for each input.
        // formatted as just counters as to not give away any info on positioning.
        var correctcounter = 0
        var correctbutwrongspotcounter = 0
        var onlistitem = 0
        var solutionlistavailible = solutionlist.toMutableList()
        var guesslistavailible = guess.toMutableList()

        //calculating numbers correct in right and wrong spot
        for (item in guess) {
            if (item == solutionlist[onlistitem]) {
                correctcounter++
                solutionlistavailible[onlistitem] = 10
                guesslistavailible[onlistitem] = 11
            }
            onlistitem++
        }
        for (item in guesslistavailible) {
            if (solutionlistavailible.contains(item) == true) {
                correctbutwrongspotcounter++
                solutionlistavailible[solutionlistavailible.indexOf(item)] = 12
            }
        }



        //adding feedback to feedback lists
        feedbackListFull.add(correctcounter)
        feedbackListPartial.add(correctbutwrongspotcounter)

        //printing previous guesses
        for ((index, item) in guesseslist.withIndex()) {
            for (number in item) {
                when (number) {
                    1 -> print("$colorRed$symbolOne $colorreset")
                    2 -> print("$colorOrange$symbolTwo $colorreset")
                    3 -> print("$colorYellow$symbolThree $colorreset")
                    4 -> print("$colorGreen$symbolFour $colorreset")
                    5 -> print("$colorLightBlue$symbolFive $colorreset")
                    6 -> print("$colorDarkBlue$symbolSix $colorreset")
                }
            }
            print("|")
            for (i in 1..feedbackListFull[index]) {
                print(" $symbolFullCorrect")
            }
            for (i in 1..feedbackListPartial[index]) {
                print(" $symbolPartialCorrect")
            }
            println(" ")
        }

        //what to do if the user gets all numbers correct
        if (correctcounter == 4) {
            println("wowie holy cow no way you did it so cool omg")
            println("game won in $whileloopcount guesses")
            break
        }

        //printing losing screen
        println("you have " + colorpurple + (10 - whileloopcount) + colorreset + " guesses left")
        if (whileloopcount == 10) {
            println("you lost, no guesses left :(")
            println("solution is: $solutionlist")
        }

    }

}