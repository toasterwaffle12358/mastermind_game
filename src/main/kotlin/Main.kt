//imports
import kotlin.random.Random

fun main() {
    //variable to keep main game loop running
    var whileloopcount: Int = 0

    //setting up colors
    // Everything after this is in red
    val colorpurple = "\u001b[38;5;165m"
    // Resets previous color codes
    val colorreset = "\u001b[0m"

    //creating the solution colors and order as a list, will be used to compare against user inputs to see if user is correct
    val solutionlist = listOf(Random.nextInt(1,7), Random.nextInt(1,7), Random.nextInt(1,7), Random.nextInt(1,7))


    println("welcome!")
    println("type \"help\" for the game rules")

    //main game loop
    while (whileloopcount < 10) {

        //taking user input
        println("guess 4 numbers from 1 to 6 seperated by only commas. eg: 4,6,5,1")
        println("type \"i give up\" to get the solution")

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
                        "makes a series of pattern guesses - after each guess the code-maker gives feedback in the form of 2 numbers, the \n" +
                        "number of numbers that are of the right number and in the correct position, and the number of numbers that are of the \n" +
                        "correct number but not in the correct position \n")
                continue
            }
        }

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


        //what to do if the user gets all numbers correct
        if (correctcounter == 4) {
            println("wowie holy cow no way you did it so cool omg")
            break
        }

        //printing results of user input list compared to solution list
        println("you got " + colorpurple +correctcounter + colorreset + " correct number(s) in the right spot!")
        println("you got " + colorpurple +correctbutwrongspotcounter + colorreset + " number(s) correct but in the wrong spot")
        println("you have " + colorpurple + (10 - whileloopcount) + colorreset + " guesses left")
        if (whileloopcount == 10) {
            println("you lost, no guesses left :(")
            println("solution is: $solutionlist")
        }

    }

}