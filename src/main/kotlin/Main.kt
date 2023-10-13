

fun main(args: Array<String>) {

    //setting up colors
    // Everything after this is in red
    val colorred = "\u001b[38;5;197m"
    // Everything after this is in yellow
    val coloryellow = "\u001b[38;5;226m"
    // Resets previous color codes
    val colorreset = "\u001b[0m"

    //will be true until game is won or quit, used to keep game while loop running
    var playing = true

    //shows the active player, true if the current player is player1 (yellow) false if player 2 (red) (what color piece will be placed on this turn)
    var isCurrentPlayerOne = true
    //used for editing board
    var playerNumber = 0

    //setting up board
    var boardLineOne = mutableListOf(0,0,0,0,0,0,0)
    var boardLineTwo = mutableListOf(0,0,0,0,0,0,0)
    var boardLineThree = mutableListOf(0,0,0,0,0,0,0)
    var boardLineFour = mutableListOf(0,0,0,0,0,0,0)
    var boardLineFive = mutableListOf(0,0,0,0,0,0,0)
    var boardLineSix = mutableListOf(0,0,0,0,0,0,0)
    var board = mutableListOf(boardLineOne, boardLineTwo, boardLineThree, boardLineFour, boardLineFive, boardLineSix)

    //setting up map for board
    //val boardMap: Map<Int, String> = mapOf(0 to "0", 1 to coloryellow + "●" + colorreset, 2 to colorred + "●" + colorreset)


    println("Welcome to connect four!")

    while (playing) {


        when (isCurrentPlayerOne) {
            true ->  playerNumber = 1
            false -> playerNumber = 2
        }


        for (row in board) {
            for (item in row) {
                when (item) {
                    0 -> print("O ")
                    1 -> print(coloryellow + "● " + colorreset)
                    2 -> print(colorred + "● " + colorreset)
                }
            }
            println("")
            //println(row)
        }
        when (isCurrentPlayerOne) {
            true -> println("player " + coloryellow + "one's " + colorreset + "turn")
            false -> println("player " + colorred + "two's " + colorreset + "turn")
        }
        println("type the number of the row you want to place in (1-7)")
        val input = readln()
        val inputInt = input.toIntOrNull()
        if (inputInt == null) {
            println("incorrect syntax, make sure input is a number from 1 to 7")
            continue
        }

        when {
            boardLineSix[inputInt - 1] == 0 -> boardLineSix[inputInt - 1] = playerNumber
            boardLineFive[inputInt - 1] == 0 -> boardLineFive[inputInt - 1] = playerNumber
            boardLineFour[inputInt - 1] == 0 -> boardLineFour[inputInt - 1] = playerNumber
            boardLineThree[inputInt - 1] == 0 -> boardLineThree[inputInt - 1] = playerNumber
            boardLineTwo[inputInt - 1] == 0 -> boardLineTwo[inputInt - 1] = playerNumber
            boardLineOne[inputInt - 1] == 0 -> boardLineOne[inputInt - 1] = playerNumber
        }


        //switching player
        isCurrentPlayerOne = !isCurrentPlayerOne
    }

}