#********GAME OF TIC TAC TOE**********

#*********global Variables***********

  #This thing will hold our game on the board
board = ["-", "-", "-",
         "-", "-", "-",
         "-", "-", "-"]

#let us know if game is over yet
game_still_going = True

#tell us who the winner is
winner = None

#Tell's about the current player 'X' will be the first
current_player = "X"


#***********FUNCTIONS********
def play_game():
    
      #Display the initial board
    print_board()

      #Loop until we find the winner or tie
    while game_still_going:
        
        #Handle a turn
        handle_turn(current_player)

        #check if game is ended
        check_if_game_over()
        
        #flip to other player
        flip_player()

    #Since game is 0ver print the winner or tie
    if winner  == 'X' or winner == "0":
        print(winner + " won")
    elif winner == None:
        print("Tie.")


# Display the board on Screen
def print_board():
    print("\n")
    print(board[0] + " | " , board[1] + " | " + board[2] + "   1 | 2 | 3")
    print(board[3] + " | " , board[4] + " | " + board[5] + "   4 | 5 | 6")
    print(board[6] + " | " , board[7] + " | " + board[8] + "   7 | 8 | 9")
    print("\n")
    
# Handle a turn for player        
def handle_turn(player):

        #Get position from player
        print(player + "'s Turn")
        move = input("Enter your move from 1-9 ")

        # Make sure the user enter's valid input
        valid = False
        while not valid:

            #Make sure input is valid
            while move not in ["1", "2", "3", "4", "5", "6", "7", "8", "9"]:
                move = input("Enter input from 1-9 ")
             # Get correct index in board list
            move = int(move) - 1

            #Also make sure spot is available on board
            if board[move] == "-":
                valid = True
            else:
                print("You can't go there, Go again. ")

        # Put the game piece on the board
        board[move] = player

        # Show the game board
        print_board()
            

#Check if game is over
def check_if_game_over():
    check_for_winner() 
    check_for_tie()

 #Check to see if someone has won
def check_for_winner():
    # Check global variable
    global winner
    
    #check if there is winner anywhere
    row_winner = check_rows()
    col_winner = check_columns()
    diag_winner = check_diagonals()

    #Get the winner
    if row_winner:
        winner = row_winner
    elif col_winner:
        winner = col_winner
        #that's also a win
    elif diag_winner:
        winner = diag_winner
        #that's also a win
    else:
        winner = None

#Check rows for winner
def check_rows():
    #Set global varible
    global game_still_going

    #Check if any of the rows have same values
    row_1 = board[0] == board[1] == board[2] != "-"
    row_2 = board[3] == board[4] == board[5] != "-"
    row_3 = board[6] == board[7] == board[8] != "-"

     #Check if any rows have all same values
    if row_1 or row_2 or row_3:
        game_still_going = False
    #Return the winner    
    if row_1:
        board[0]
    elif row_2:
        board[3]
    elif row_3:
        board[6]
    else:
        return None


#Check colums for a win
def check_columns():
    # Set up a global variable
    global game_still_going
    # Check if any of the columns have same values
    col_1 = board[0] == board[3] == board[6] != "-"
    col_2 = board[1] == board[4] == board[7] != "-"
    col_3 = board[2] == board[5] == board[8] != "-"

    #if any coloum does have a match then there's a win
    if col_1 or col_2 or col_3:
        game_still_going = False
    #return the winner (X or 0)   
    if col_1:
        board[0]
    elif col_2:
        board[1]
    elif col_3:
        board[2]
    else:
        return None

#Check diagonals for winner
def check_diagonals():
     #setting up global variable
    global game_still_going

     #check if any of the values have same values
    diag_1 = board[0] == board[4] == board[8] != "-"
    diag_2 = board[2] == board[4] == board[6] != "-"

    #check if any diagonal have a match then there's a win
    if diag_1 or diag_2:
        game_still_going = False
     #Return the winner (X or 0)   
    if diag_1:
        board[0]
    elif diag_2:
        board[2]
        
        #Or return None if there's none
    else:
        return None

#Check if there is a tie
def check_for_tie():
    #Set global variable
    global game_still_going

    #If board is full
    if "-" not in board:
        game_still_going = False
        return True
    else:
        return False

 #if current player was 'X' change it to 'O'
def flip_player():
    global current_player
    
    if current_player == 'X':
        current_player = "0"
        
    elif current_player == "0":
        current_player = "X"




   #**********START EXECUTION********* 
play_game()

     