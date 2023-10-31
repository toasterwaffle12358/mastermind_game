//imports
import kotlin.system.exitProcess

fun main() {

    //setting up colors
    val colorRed = "\u001b[38;5;197m"
    val colorYellow = "\u001b[38;5;226m"
    val colorBlue = "\u001B[38;5;39m"
    val colorReset = "\u001b[0m"


    //function to check lines to see if there's a 4 in a row in them, will be run on the row/column/diagonals of the last placed piece
    fun winCheck(item: Int, playerNumber: Int, piecesInARowCounter: Int, board: MutableList<MutableList<Int>>): Int {
        var piecesInARowCounterMutable = piecesInARowCounter
        if (item == playerNumber) {
            piecesInARowCounterMutable++
            if (piecesInARowCounterMutable >= 4) {

                for (row in board) {
                    print("$colorBlue╌─┼═╪╬╢ $colorReset")
                    for (spot in row) {
                        when (spot) {
                            0 -> print("▢ ")
                            1 -> print(colorYellow + "◉ " + colorReset)
                            2 -> print(colorRed + "◈ " + colorReset)
                        }
                    }
                    println("$colorBlue╟╬╪═┼─╌$colorReset")
                    //println(row)
                }

                when (playerNumber) {
                    1 -> println("omg player\u001B[38;5;226m one ◉,\u001B[0m you won! no way omg!!!")
                    2 -> println("omg player\u001B[38;5;197m two ◈,\u001B[0m you won! no way omg!!!")
                }
                exitProcess(0)
            }
        } else {
            piecesInARowCounterMutable = 0
        }
        return piecesInARowCounterMutable
    }

    //shows the active player, true if the current player is player1 (yellow) false if player 2 (red) (what color piece will be placed on this turn)
    var isCurrentPlayerOne = true
    //used for editing board
    var playerNumber = 0
    //has the coordinates of where the last piece was placed (used for checking if there is a win, that way I don't have to check every possible location)
    var lastPiecePlacedCoordinate = mutableListOf(0,0)

    //counter that will show the current number of the same type of piece in a row
    var piecesInARowCounter = 0
    var piecesInAColumnCounter = 0

    //setting up board
    val boardLineOne = mutableListOf(0,0,0,0,0,0,0)
    val boardLineTwo = mutableListOf(0,0,0,0,0,0,0)
    val boardLineThree = mutableListOf(0,0,0,0,0,0,0)
    val boardLineFour = mutableListOf(0,0,0,0,0,0,0)
    val boardLineFive = mutableListOf(0,0,0,0,0,0,0)
    val boardLineSix = mutableListOf(0,0,0,0,0,0,0)
    val board = mutableListOf(boardLineOne, boardLineTwo, boardLineThree, boardLineFour, boardLineFive, boardLineSix)

    //setting up rows and columns
    var boardColumnOne = mutableListOf(boardLineOne[0], boardLineTwo[0], boardLineThree[0], boardLineFour[0], boardLineFive[0], boardLineSix[0])
    var boardColumnTwo = mutableListOf(boardLineOne[1], boardLineTwo[1], boardLineThree[1], boardLineFour[1], boardLineFive[1], boardLineSix[1])
    var boardColumnThree = mutableListOf(boardLineOne[2], boardLineTwo[2], boardLineThree[2], boardLineFour[2], boardLineFive[2], boardLineSix[2])
    var boardColumnFour = mutableListOf(boardLineOne[3], boardLineTwo[3], boardLineThree[3], boardLineFour[3], boardLineFive[3], boardLineSix[3])
    var boardColumnFive = mutableListOf(boardLineOne[4], boardLineTwo[4], boardLineThree[4], boardLineFour[4], boardLineFive[4], boardLineSix[4])
    var boardColumnSix = mutableListOf(boardLineOne[5], boardLineTwo[5], boardLineThree[5], boardLineFour[5], boardLineFive[5], boardLineSix[5])
    var boardColumnSeven = mutableListOf(boardLineOne[6], boardLineTwo[6], boardLineThree[6], boardLineFour[6], boardLineFive[6], boardLineSix[6])
    var boardLeftDiagonalOne = mutableListOf(boardLineThree[0], boardLineFour[1], boardLineFive[2], boardLineSix[3])
    var boardLeftDiagonalTwo = mutableListOf(boardLineTwo[0], boardLineThree[1], boardLineFour[2], boardLineFive[3], boardLineSix[4])
    var boardLeftDiagonalThree = mutableListOf(boardLineOne[0], boardLineTwo[1], boardLineThree[2], boardLineFour[3], boardLineFive[4], boardLineSix[5])
    var boardLeftDiagonalFour = mutableListOf(boardLineOne[1], boardLineTwo[2], boardLineThree[3], boardLineFour[4], boardLineFive[5], boardLineSix[6])
    var boardLeftDiagonalFive = mutableListOf(boardLineOne[2], boardLineTwo[3], boardLineThree[4], boardLineFour[5], boardLineFive[6])
    var boardLeftDiagonalSix = mutableListOf(boardLineOne[3], boardLineTwo[4], boardLineThree[5], boardLineFour[6])
    var boardRightDiagonalOne = mutableListOf(boardLineFour[0], boardLineThree[1], boardLineTwo[2], boardLineOne[3])
    var boardRightDiagonalTwo = mutableListOf(boardLineFive[0], boardLineFour[1], boardLineThree[2], boardLineTwo[3], boardLineOne[4])
    var boardRightDiagonalThree = mutableListOf(boardLineSix[0], boardLineFive[1], boardLineFour[2], boardLineThree[3], boardLineTwo[4], boardLineOne[5])
    var boardRightDiagonalFour = mutableListOf(boardLineSix[1], boardLineFive[2], boardLineFour[3], boardLineThree[4], boardLineTwo[5], boardLineOne[6])
    var boardRightDiagonalFive = mutableListOf(boardLineSix[2], boardLineFive[3], boardLineFour[4], boardLineThree[5], boardLineTwo[6])
    var boardRightDiagonalSix = mutableListOf(boardLineSix[3], boardLineFive[4], boardLineFour[5], boardLineThree[6])




    println("Welcome to connect four!")

    while (true) {


        //clearing terminal
        print("\u001b[H"+"\u001b[2J")

        //setting up the playerNumber variable, it will be used later to place the pieces so each player places a different int.
        playerNumber = if (isCurrentPlayerOne) {
            1
        } else {
            2
        }

        //printing the board
        for (row in board) {
            print("$colorBlue╠╢$colorReset ")
            for (item in row) {
                when (item) {
                    0 -> print("▢ ")
                    1 -> print(colorYellow + "◉ " + colorReset)
                    2 -> print(colorRed + "◈ " + colorReset)
                }
            }
            println("$colorBlue╟╣$colorReset")
            //println(row)
        }
        println("$colorBlue╠╢$colorReset 1 2 3 4 5 6 7 $colorBlue╟╣$colorReset")

        //printing the current player
        when (isCurrentPlayerOne) {
            true -> println("player " + colorYellow +"one's ◉ " + colorReset + "turn")
            false -> println("player " + colorRed + "two's ◈ " + colorReset + "turn")
        }
        println("type the number of the row you want to place in (1-7)")

        //getting player input for the column they want to place in, then turning it into an int and checking if it is an allowed input
        val input = readln()
        val inputInt = input.toIntOrNull()
        if (inputInt == null || inputInt >= 8 || inputInt <= 0) {
            println("incorrect syntax, make sure input is a number from 1 to 7")
            continue
        }

        //placing piece, testing all rows from top to bottom to see if there's a piece there. updating the coordinate of the last placed piece
        when {
            boardLineSix[inputInt - 1] == 0 -> {
                boardLineSix[inputInt - 1] = playerNumber
                lastPiecePlacedCoordinate = mutableListOf(inputInt,6)
            }
            boardLineFive[inputInt - 1] == 0 -> {
                boardLineFive[inputInt - 1] = playerNumber
                lastPiecePlacedCoordinate = mutableListOf(inputInt,5)
            }
            boardLineFour[inputInt - 1] == 0 -> {
                boardLineFour[inputInt - 1] = playerNumber
                lastPiecePlacedCoordinate = mutableListOf(inputInt,4)
            }
            boardLineThree[inputInt - 1] == 0 -> {
                boardLineThree[inputInt - 1] = playerNumber
                lastPiecePlacedCoordinate = mutableListOf(inputInt,3)
            }
            boardLineTwo[inputInt - 1] == 0 -> {
                boardLineTwo[inputInt - 1] = playerNumber
                lastPiecePlacedCoordinate = mutableListOf(inputInt,2)
            }
            boardLineOne[inputInt - 1] == 0 -> {
                boardLineOne[inputInt - 1] = playerNumber
                lastPiecePlacedCoordinate = mutableListOf(inputInt,1)
            }
            else -> {
                println("\n \n \n")
                println("sorry, you cant place in this spot anymore, try again")
                continue
            }
        }

        //adding space for new board
        println("\n \n \n")

        //updating columns and diagonals list, will be used to check if a user has won, will be iterated through to see if there are 4 in a row in any of the lists
        boardColumnOne = mutableListOf(boardLineOne[0], boardLineTwo[0], boardLineThree[0], boardLineFour[0], boardLineFive[0], boardLineSix[0])
        boardColumnTwo = mutableListOf(boardLineOne[1], boardLineTwo[1], boardLineThree[1], boardLineFour[1], boardLineFive[1], boardLineSix[1])
        boardColumnThree = mutableListOf(boardLineOne[2], boardLineTwo[2], boardLineThree[2], boardLineFour[2], boardLineFive[2], boardLineSix[2])
        boardColumnFour = mutableListOf(boardLineOne[3], boardLineTwo[3], boardLineThree[3], boardLineFour[3], boardLineFive[3], boardLineSix[3])
        boardColumnFive = mutableListOf(boardLineOne[4], boardLineTwo[4], boardLineThree[4], boardLineFour[4], boardLineFive[4], boardLineSix[4])
        boardColumnSix = mutableListOf(boardLineOne[5], boardLineTwo[5], boardLineThree[5], boardLineFour[5], boardLineFive[5], boardLineSix[5])
        boardColumnSeven = mutableListOf(boardLineOne[6], boardLineTwo[6], boardLineThree[6], boardLineFour[6], boardLineFive[6], boardLineSix[6])
        boardLeftDiagonalOne = mutableListOf(boardLineThree[0], boardLineFour[1], boardLineFive[2], boardLineSix[3])
        boardLeftDiagonalTwo = mutableListOf(boardLineTwo[0], boardLineThree[1], boardLineFour[2], boardLineFive[3], boardLineSix[4])
        boardLeftDiagonalThree = mutableListOf(boardLineOne[0], boardLineTwo[1], boardLineThree[2], boardLineFour[3], boardLineFive[4], boardLineSix[5])
        boardLeftDiagonalFour = mutableListOf(boardLineOne[1], boardLineTwo[2], boardLineThree[3], boardLineFour[4], boardLineFive[5], boardLineSix[6])
        boardLeftDiagonalFive = mutableListOf(boardLineOne[2], boardLineTwo[3], boardLineThree[4], boardLineFour[5], boardLineFive[6])
        boardLeftDiagonalSix = mutableListOf(boardLineOne[3], boardLineTwo[4], boardLineThree[5], boardLineFour[6])
        boardRightDiagonalOne = mutableListOf(boardLineFour[0], boardLineThree[1], boardLineTwo[2], boardLineOne[3])
        boardRightDiagonalTwo = mutableListOf(boardLineFive[0], boardLineFour[1], boardLineThree[2], boardLineTwo[3], boardLineOne[4])
        boardRightDiagonalThree = mutableListOf(boardLineSix[0], boardLineFive[1], boardLineFour[2], boardLineThree[3], boardLineTwo[4], boardLineOne[5])
        boardRightDiagonalFour = mutableListOf(boardLineSix[1], boardLineFive[2], boardLineFour[3], boardLineThree[4], boardLineTwo[5], boardLineOne[6])
        boardRightDiagonalFive = mutableListOf(boardLineSix[2], boardLineFive[3], boardLineFour[4], boardLineThree[5], boardLineTwo[6])
        boardRightDiagonalSix = mutableListOf(boardLineSix[3], boardLineFive[4], boardLineFour[5], boardLineThree[6])

        //testing to see if user won
        //testing rows
        piecesInARowCounter = 0
        when (lastPiecePlacedCoordinate[1]) {
            6 -> for (item in boardLineSix){
                piecesInARowCounter = winCheck(item, playerNumber, piecesInARowCounter, board)
            }
            5 -> for (item in boardLineFive){
                piecesInARowCounter = winCheck(item, playerNumber, piecesInARowCounter, board)
            }
            4 -> for (item in boardLineFour){
                piecesInARowCounter = winCheck(item, playerNumber, piecesInARowCounter, board)
            }
            3 -> for (item in boardLineThree){
                piecesInARowCounter = winCheck(item, playerNumber, piecesInARowCounter, board)
            }
            2 -> for (item in boardLineTwo){
                piecesInARowCounter = winCheck(item, playerNumber, piecesInARowCounter, board)
            }
            1 -> for (item in boardLineOne){
                piecesInARowCounter = winCheck(item, playerNumber, piecesInARowCounter, board)
            }

        }
        //testing columns
        piecesInAColumnCounter = 0
        when (lastPiecePlacedCoordinate[0]) {
            1 -> for (item in boardColumnOne){
                piecesInAColumnCounter = winCheck(item, playerNumber, piecesInAColumnCounter, board)
            }
            2 -> for (item in boardColumnTwo){
                piecesInAColumnCounter = winCheck(item, playerNumber, piecesInAColumnCounter, board)
            }
            3 -> for (item in boardColumnThree){
                piecesInAColumnCounter = winCheck(item, playerNumber, piecesInAColumnCounter, board)
            }
            4 -> for (item in boardColumnFour){
                piecesInAColumnCounter = winCheck(item, playerNumber, piecesInAColumnCounter, board)
            }
            5 -> for (item in boardColumnFive){
                piecesInAColumnCounter = winCheck(item, playerNumber, piecesInAColumnCounter, board)
            }
            6 -> for (item in boardColumnSix){
                piecesInAColumnCounter = winCheck(item, playerNumber, piecesInAColumnCounter, board)
            }
            7 -> for (item in boardColumnSeven){
                piecesInAColumnCounter = winCheck(item, playerNumber, piecesInAColumnCounter, board)
            }

        }
        piecesInAColumnCounter = 0
        when (lastPiecePlacedCoordinate[1]-lastPiecePlacedCoordinate[0]) {
            2 -> for (item in boardLeftDiagonalOne){
                piecesInAColumnCounter = winCheck(item, playerNumber, piecesInAColumnCounter, board)
            }
            1 -> for (item in boardLeftDiagonalTwo) {
                piecesInAColumnCounter = winCheck(item, playerNumber, piecesInAColumnCounter, board)
            }
            0 -> for (item in boardLeftDiagonalThree) {
                piecesInAColumnCounter = winCheck(item, playerNumber, piecesInAColumnCounter, board)
            }
            -1 -> for (item in boardLeftDiagonalFour) {
                piecesInAColumnCounter = winCheck(item, playerNumber, piecesInAColumnCounter, board)
            }
            -2 -> for (item in boardLeftDiagonalFive) {
                piecesInAColumnCounter = winCheck(item, playerNumber, piecesInAColumnCounter, board)
            }
            -3 -> for (item in boardLeftDiagonalSix) {
                piecesInAColumnCounter = winCheck(item, playerNumber, piecesInAColumnCounter, board)
            }

        }
        piecesInAColumnCounter = 0
        when (lastPiecePlacedCoordinate[1] + lastPiecePlacedCoordinate[0]) {
            5 -> for (item in boardRightDiagonalOne){
                piecesInAColumnCounter = winCheck(item, playerNumber, piecesInAColumnCounter, board)
            }
            6 -> for (item in boardRightDiagonalTwo) {
                piecesInAColumnCounter = winCheck(item, playerNumber, piecesInAColumnCounter, board)
            }
            7 -> for (item in boardRightDiagonalThree) {
                piecesInAColumnCounter = winCheck(item, playerNumber, piecesInAColumnCounter, board)
            }
            8 -> for (item in boardRightDiagonalFour) {
                piecesInAColumnCounter = winCheck(item, playerNumber, piecesInAColumnCounter, board)
            }
            9 -> for (item in boardRightDiagonalFive) {
                piecesInAColumnCounter = winCheck(item, playerNumber, piecesInAColumnCounter, board)
            }
            0 -> for (item in boardRightDiagonalSix) {
                piecesInAColumnCounter = winCheck(item, playerNumber, piecesInAColumnCounter, board)
            }

        }

        if (boardLineOne.filter { it == 1 || it == 2 }.size >= 7 ) {
            for (row in board) {
                print("$colorBlue╠╢$colorReset ")
                for (item in row) {
                    when (item) {
                        0 -> print("▢ ")
                        1 -> print(colorYellow + "◉ " + colorReset)
                        2 -> print(colorRed + "◈ " + colorReset)
                    }
                }
                println("$colorBlue╟╣$colorReset")
                //println(row)
            }
            println("$colorBlue╠╢$colorReset 1 2 3 4 5 6 7 $colorBlue╟╣$colorReset")
            println("uh oh, no more spots left. nobody wins :(")
            exitProcess(0)
        }


        //switching player
        isCurrentPlayerOne = !isCurrentPlayerOne
    }

}