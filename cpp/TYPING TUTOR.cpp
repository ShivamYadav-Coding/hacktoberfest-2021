#include<iostream>

#include<fstream>

#include<iomanip>

#include<conio.h>

#include<Windows.h>

using namespace std;

void keyboardselectionmenu();
void mainmenu();
void rapidtyping();

int total_characters_typed = 0;
int theemeoption = 3;
char keyboardchoice;
string name;

void setclr(int y) {
  SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), y);
}

class practicelessons {
  public:

    //Practice lessons...
    void practicelesson() {
      system("cls");
      cout << "\t\t\t\tWelcome!\n\t\t\tSelect Any Course TO begin";
      setclr(12);
      cout << "\n\n\n\t\t\t[1] HOME ROW" <<
        "\n\n\t\t\t[2] UPPER QWERTY ROW" <<
        "\n\n\t\t\t[3] LOWER ZXCVB ROW" <<
        "\n\n\t\t\t[4] NUMPAD PRACTICE" <<
        "\n\n\t\t\t[5] INSTRICTIONS" <<
        "\n\n\t\t\t[6] MAIN MENU";

      setclr(11);
      cout << "\n\n\t\t\tPLEASE MAKE A SELECTION :";

      switch (getch()) {
      case '1': {
        setclr(9);
        char c;
        cout << "\n\n\t\t\tHome Row Selected!\n\n\t\t\t Press anykey to continue";
        getch();
        int homemistakes = 0;
        float totalchars = 0;
        char home[] = {
          'a',
          's',
          'd',
          'f',
          'g',
          'h',
          'j',
          'k',
          'l'
        };

        while (c != '\r') {
          int r = rand() % 9;
          system("cls");
          cout << "\n\n\t\tPress:  " << home[r];
          cout << "\n\n\t\t--> ";
          c = getche();
          Sleep(50);
          ++totalchars;
          ++total_characters_typed;

          if (c == home[r])
            continue;
          else {
            ++homemistakes;
            cout << "\a";
            Sleep(500);
          }

        }

        totalchars -= 1;
        //Subtracted 1 as last enter was also counted;

        float correct = totalchars + 1 - homemistakes;
        //Added 1 as last enterd character 'enter' is always correct'

        cout << "\n\n\t\t\t Total Characters Practiced :" << totalchars;

        setclr(10);
        cout << "\n\t\t\t   Correct : " << correct; //

        setclr(12);
        cout << "\n\t\t\t   Mistakes : " << homemistakes - 1;

        float accuracy = (correct / totalchars) * 100;

        setclr(13);
        cout << "\n\t\t\t   Accuracy : ";

        if (accuracy >= 90) {
          setclr(10);
          cout << accuracy << "%\n\t\t\t   WELLDONE!!";
        } else if (accuracy >= 80 && accuracy <= 89) {
          setclr(6);
          cout << accuracy << "%\n\t\t\t   GOOOD!!";
        } else {
          setclr(4);
          cout << accuracy << "%\n\t\t\t   MORE PRACTICE NEEDED!!";
        }

        setclr(9);
        cout << "\n\n\n\t\t\t [1] Go to Lessons Menu" <<
          "\n\n\t\t\t [2] Go to Next Lesson " <<
          "\n\n\t\t\t [ANY] Go to Main Menu" <<
          "\n\n\t\t\t Make your Choice & Press Enter: ";

        char l;
        cin >> l;

        switch (l) {
        case '1':
          practicelesson();

        case '2':
          goto lesson2;

        default:
          mainmenu();
        }

      }

      case '2': {
        lesson2:
          setclr(9);
        char c;
        cout << "\n\n\t\t\tUPPER Row Selected!\n\n\t\t\t Press anykey to continue";
        getch();
        int uppermistakes = 0;
        float totalchars = 0;
        char upper[] = {
          'q',
          'w',
          'e',
          'r',
          't',
          'y',
          'u',
          'i',
          'o',
          'p',
          '['
        };

        while (c != '\r') {
          int r = rand() % 11;
          system("cls");
          cout << "\n\n\t\tPress:  " << upper[r];
          cout << "\n\n\t\t--> ";
          c = getche();
          Sleep(50);
          ++totalchars;
          ++total_characters_typed;

          if (c == upper[r])
            continue;
          else {
            ++uppermistakes;
            cout << "\a";
            Sleep(500);
          }

        }

        totalchars -= 1;
        //Subtracted 1 as last enter was also counted;

        float correct = totalchars + 1 - uppermistakes;
        //Added 1 as last enterd character 'enter' is always correct'

        cout << "\n\n\t\t\t Total Characters Practiced :" << totalchars;

        setclr(10);
        cout << "\n\t\t\t   Correct : " << correct; //

        setclr(12);
        cout << "\n\t\t\t   Mistakes : " << uppermistakes - 1;

        float accuracy = (correct / totalchars) * 100;

        setclr(13);
        cout << "\n\t\t\t   Accuracy : ";

        if (accuracy >= 90) {
          setclr(10);
          cout << accuracy << "%\n\t\t\t   WELLDONE!!";
        } else if (accuracy >= 80 && accuracy <= 89) {
          setclr(6);
          cout << accuracy << "%\n\t\t\t   GOOOD!!";
        } else {
          setclr(4);
          cout << accuracy << "%\n\t\t\t   MORE PRACTICE NEEDED!!";
        }

        setclr(9);
        cout << "\n\n\n\t\t\t [1] Go to Lessons Menu" <<
          "\n\n\t\t\t [2] Go to Next Lesson " <<
          "\n\n\t\t\t [ANY] Go to Main Menu" <<
          "\n\n\t\t\t Make your Choice & Press Enter: ";

        char l;
        cin >> l;

        switch (l) {
        case '1':
          practicelesson();
          break;

        case '2':
          goto lesson3;
          break;

        default:
          mainmenu();
        }

      }

      case '3': {
        lesson3:
          setclr(9);
        char c;
        cout << "\n\n\t\t\tLOWER Row Selected!\n\n\t\t\t Press anykey to continue";
        getch();
        int lowermistakes = 0;
        float totalchars = 0;
        char lower[] = {
          'z',
          'x',
          'c',
          'v',
          'b',
          'n',
          'm',
          ',',
          '.',
          '/'
        };

        while (c != '\r') {
          int r = rand() % 10;
          system("cls");
          cout << "\n\n\t\tPress:  " << lower[r];
          cout << "\n\n\t\t--> ";
          c = getche();
          Sleep(50);
          ++totalchars;
          ++total_characters_typed;

          if (c == lower[r])
            continue;
          else {
            ++lowermistakes;
            cout << "\a";
            Sleep(500);
          }

        }

        totalchars -= 1;
        //Subtracted 1 as last enter was also counted;

        float correct = totalchars + 1 - lowermistakes;
        //Added 1 as last enterd character 'enter' is always correct'

        cout << "\n\n\t\t\t Total Characters Practiced :" << totalchars;

        setclr(10);
        cout << "\n\t\t\t   Correct : " << correct; //

        setclr(12);
        cout << "\n\t\t\t   Mistakes : " << lowermistakes - 1;

        float accuracy = (correct / totalchars) * 100;

        setclr(13);
        cout << "\n\t\t\t   Accuracy : ";

        if (accuracy >= 90) {
          setclr(10);
          cout << accuracy << "%\n\t\t\t   WELLDONE!!";
        } else if (accuracy >= 80 && accuracy <= 89) {
          setclr(6);
          cout << accuracy << "%\n\t\t\t   GOOOD!!";
        } else {
          setclr(4);
          cout << accuracy << "%\n\t\t\t   MORE PRACTICE NEEDED!!";
        }

        setclr(9);
        cout << "\n\n\n\t\t\t [1] Go to Lessons Menu" <<
          "\n\n\t\t\t [2] Go to Next Lesson " <<
          "\n\n\t\t\t [ANY] Go to Main Menu" <<
          "\n\n\t\t\t Make your Choice & Press Enter: ";

        char l;
        cin >> l;

        switch (l) {
        case '1':
          practicelesson();

        case '2':
          goto lesson4;

        default:
          mainmenu();
        }

      }

      case '4': {
        if (keyboardchoice == '1') {
          cout << "\n\n\n\t\t\tUnsupported Keyboard Type!\n\n\t\t\tPress Enter To Go Back\n\n" <<
            "\t\t\tPress Tab To select Default Keyboard !";
          if (getch() == '\r')
            mainmenu();

          else
            keyboardselectionmenu();

        }
        lesson4:
          setclr(9);
        char c;
        cout << "\n\n\t\t\tNUMBER PAD Selected!\n\n\t\t\t Press anykey to continue";
        getch();
        int npadmistakes = 0;
        float totalchars = 0;
        char npad[] = {
          '1',
          '2',
          '3',
          '4',
          '5',
          '6',
          '7',
          '8',
          '9',
          '0'
        };

        while (c != '\r') {
          int r = rand() % 10;
          system("cls");
          cout << "\n\n\t\tPress:  " << npad[r];
          cout << "\n\n\t\t--> ";
          c = getche();
          Sleep(50);
          ++totalchars;
          ++total_characters_typed;

          if (c == npad[r])
            continue;
          else {
            ++npadmistakes;
            cout << "\a";
            Sleep(500);
          }
        }

        totalchars -= 1;
        //Subtracted 1 as last enter was also counted;

        float correct = totalchars + 1 - npadmistakes;
        //Added 1 as last enterd character 'enter' is always correct'

        cout << "\n\n\t\t\t Total Characters Practiced :" << totalchars;

        setclr(10);
        cout << "\n\t\t\t   Correct : " << correct; //

        setclr(12);
        cout << "\n\t\t\t   Mistakes : " << npadmistakes - 1;

        float accuracy = (correct / totalchars) * 100;

        setclr(13);
        cout << "\n\t\t\t   Accuracy : ";

        if (accuracy >= 90) {
          setclr(10);
          cout << accuracy << "%\n\t\t\t   WELLDONE!!";
        } else if (accuracy >= 80 && accuracy <= 89) {
          setclr(6);
          cout << accuracy << "%\n\t\t\t   GOOOD!!";
        } else {
          setclr(4);
          cout << accuracy << "%\n\t\t\t   MORE PRACTICE NEEDED!!";
        }

        setclr(9);
        cout << "\n\n\n\t\t\t [1] Go to Lessons Menu" <<
          "\n\n\t\t\t [2] END Practice " <<
          "\n\n\t\t\t [ANY] Go to Main Menu" <<
          "\n\n\t\t\t Make your Choice & Press Enter: ";

        char l;
        cin >> l;

        switch (l) {
        case '1':
          practicelesson();

        case '2':
          cout << "\t\t\tPractice Ended!\n\t\t\tPress any key to go to Main Menu";
          getch();
          mainmenu();

        default:
          mainmenu();
        }

      }

      case '5': {
        system("cls");
        cout << "\n\t\t\tINSTRUCTIONS:\n\n" <<
          "*In the practice lessons mode you can iprove your typing skills" <<
          "\n*The required character will be displayed on upper left corner" <<
          "\n*You will have to press that button on your keyboard" <<
          "\n*Your character count will be increasing as you type more characters" <<
          "\n*In the end you will be provided with reoprt..." <<
          "\n\n Press Any key to go back!";
        getch();
        practicelessons();
      }

      case '6':
        mainmenu();

      default:
        cout << "Invalid choice!";
        Sleep(1000);
        practicelesson();
      }
    }

};

// Welcome Screen....
void welcomescreen() {

  setclr(11);
  cout << endl << endl <<
    " \t\t  ****************************************" << endl <<
    " \t\t  ****************************************" << endl <<
    " \t\t  ****************************************" << endl <<
    " \t\t  ** ";
  setclr(249);
  cout << setfill(' ') << left << setw(30) << "Welcome to Typing Tutor BY Rashid!";
  setclr(11);
  cout << " **" << endl <<
    "\t\t  ****************************************" << endl <<
    "\t\t  ****************************************" << endl <<
    "\t\t  ****************************************" << endl;
  setclr(12);
  cout << "\t\t\t\t LOADING...\n\t\t  ";
  Sleep(500);

  for (int i = 1; i < 41; i++) {
    setclr(12);
    //setclr(1+rand()%14);
    cout << char(219);
    Sleep(rand() % 250);
  }

  setclr(12);
  cout << "\n\n\t\t  ->Enter Your Name : ";
  setclr(15);
  getline(cin, name);

  system("cls");
  cout << "\a";
  cout << "\t                ";
  for (int i = 0; i < name.length() + 17; i++) {
    setclr(1 + rand() % 14);
    cout << "*";
    Sleep(10);
  }

  setclr(14);
  cout << "\n\t                 **Welcome " << name << "**\n";

  cout << "\t                ";
  for (int i = 0; i < name.length() + 17; i++) {
    setclr(1 + rand() % 7);
    cout << "*";
    Sleep(10);
  }

  setclr(6);
  cout << "\n\n\t\t            _.-'''''-._ \n" <<
    "\t\t          .'  _     _  '. \n" <<
    "\t\t         /   (o)   (o)   \\ \n" <<
    "\t\t       ^|                 |^ \n" <<
    "\t\t       *|  \\           /  |* \n" <<
    "\t\t         \\  '.       .'  / \n" <<
    "\t\t          '.  `'---'`  .' \n" <<
    "\t\t            '-._____.-' ";

  cout << "\n\n";
  Sleep(1000);
  setclr(10);
  cout << "\n\t\t\t   PRESS ANY KEY";
  getch();

  keyboardselectionmenu();

}

// Keyboard Selection menu...
void keyboardselectionmenu() {
  void keyboardselectionmenu();

  system("cls");
  cout << "\n\t\t\tPLEASE SELECT KEYBOARD LAYOUT \n\n";

  setclr(11);
  cout << "[1] Normal Keyboard :\n";
  cout << "\t     ,---,---,---,---,---,---,---,---,---,---,---,---,---,-------,\n" <<
    "\t     | ~ | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 0 | [ | ] | <-    |\n" <<
    "\t     |---'-,-'-,-'-,-'-,-'-,-'-,-'-,-'-,-'-,-'-,-'-,-'-,-'-,-----|\n" <<
    "\t     | ->| | ' | , | . | P | Y | F | G | C | R | L | / | = |  \\  |\n" <<
    "\t     |-----',--',--',--',--',--',--',--',--',--',--',--',--'-----|\n" <<
    "\t     | Caps | A | O | E | U | I | D | H | T | N | S | - |  Enter |\n" <<
    "\t     |------'-,-'-,-'-,-'-,-'-,-'-,-'-,-'-,-'-,-'-,-'-,-'--------|\n" <<
    "\t     |        | ; | Q | J | K | X | B | M | W | V | Z |          |\n" <<
    "\t     |------,-',--'--,'---'---'---'---'---'---'-,-'---',--,------|\n" <<
    "\t     | ctrl |  | alt |                          | alt  |  | ctrl |\n" <<
    "\t     '------'  '-----'--------------------------'------'  '------'\n\n";

  setclr(13);
  cout << "[2] Keyboard With NumberPad :\n";

  cout << "\t. -------------------------------------------------------------------.\n" <<
    "\t| [Esc] [F1][F2][F3][F4][F5][F6][F7][F8][F9][F0][F10][F11][F12] o o o|   \n" <<
    "\t|                                                                    |   \n" <<
    "\t| [`][1][2][3][4][5][6][7][8][9][0][-][=][_<_] [I][H][U] [N][/][*][-]|   \n" <<
    "\t| [|-][Q][W][E][R][T][Y][U][I][O][P][{][}] | | [D][E][D] [7][8][9]|+||   \n" <<
    "\t| [CAP][A][S][D][F][G][H][J][K][L][;]['][#]|_|           [4][5][6]|_||   \n" <<
    "\t| [^][\\][Z][X][C][V][B][N][M][,][.][/] [__^__]    [^]    [1][2][3]| ||   \n" <<
    "\t| [c]   [a][________________________][a]   [c] [<][V][>] [ 0  ][.]|_||   \n" <<
    "\t`--------------------------------------------------------------------'   \n";

  setclr(15);
  cout << "ENTER YOUR CHOICE: ";
  keyboardchoice = getch();

  system("cls");

  if (keyboardchoice == '1') {
    setclr(10);
    cout << "\n\n\n\t\t\tNormal Keyboard Selected!\n\n\t\t\t\tPress any key to continue!";
    getch();
  } else if (keyboardchoice == '2') {
    setclr(10);
    cout << "\n\n\n\t\t\tKeyboard With NumberPad Selected!\n\n\t\t\tPress any key to continue!";
    getch();
  } else {
    setclr(12);
    cout << "\n\tInvalid Keyboard Selection!\n\t Press any key to go back!";
    getch();
    keyboardselectionmenu();
  }

}

//THEEME MENU...
void theememenu() {
  cout << "\a";
  int colorselect;
  system("cls");
  cout << "\t\t\t-----------THEEME SELECTION MENU------------" <<
    "\n\n\n\t\t\t->[1] Select Theeme from MENU" <<
    "\n\n\t\t\t->[2] Revert Changes" <<
    "\n\n\t\t\t->[3] Apply Default Theeme" <<
    "\n\n\t\t\t->[4] Return to Main Menu" <<
    "\n\n\t\t\tIMPORTANT\n\t\t\t|\n"
  "\t\t\t--> Theeme changes can be observed on Main Menu!!" <<
  "\n\n\t\t\t->Enter your Choice & press Enter: ";
  switch (getch()) {
  case '1': {
    cout << "\a";
    system("cls");
    for (int i = 1; i < 250; i++) {
      setclr(i);
      cout << "Theeme NO : " << setw(3) << i << endl;
    }
    cout << "Enter a Number & press Enter :";
    cin >> colorselect;

    theemeoption += colorselect - 3;
    system("cls");
    cout << "\nTheeme Updated!\n\nPress Any Key to continue...";
    getch();
    theememenu();
  }

  case '2': {
    cout << "\a";
    theemeoption = theemeoption - colorselect;
    system("cls");
    setclr(theemeoption);
    cout << "\n\nChanges Reverted Successfully! \n\nPress any key to continue...";
    getch();
    theememenu();
  }

  case '3': {
    cout << "\a";
    theemeoption = 3;
    system("cls");
    cout << "\n\nDefault Theeme Applied! \n\nPress any key to continue...";
    getch();
    theememenu();
  }
  case '4': {
    cout << "\a";
    mainmenu();
  }

  default:
    cout << "PLEASE MAKE A VALID CHOICE!";
    getch();
    theememenu();
  }

}

//Rapid typing instructions...
void rapidtypinginstr() {
  system("cls");

  setclr(theemeoption + 11);
  cout << "\t\t\tYou Have Selected Rapid type GAME!\n\n";
  cout << "      \t\t\t          Instructions\n\n";

  setclr(theemeoption);

  cout << "\n\t\t\t*In this game, you have to type the required character." <<
    "\n\n\t\t\t*Each Typed Character carries 1 point.\n\n" <<
    "\t\t\t*The game has 5 difficulty levels." <<
    "\n\n\t\t\t*Press ENTER key to end GAME" <<
    "\n\n\t\t\t*Score Will be displayed in the end";

  setclr(12);
  cout << "\n\n\t\t\t*Three Chances ";
  setclr(theemeoption);
  cout << "are given in game" <<
    "\n\n\t\t\t*Press Any key to continue :";
  getch();

  rapidtyping();

}

//Rapid Typing Structure...
void rapidtyping() {
  int difflevel;
  system("cls");
  setclr(theemeoption + 10);

  cout << "\n\t\t\tSet Difficulty Level :" <<
    "\n\n\n\t\t\t[1] Very Easy" <<
    "\n\n\t\t\t[2] Easy" <<
    "\n\n\t\t\t[3] Moderate" <<
    "\n\n\t\t\t[4] Hard" <<
    "\n\n\t\t\t[5] Very Hard" <<
    "\n\n\t\t\t[6] Main Menu\n";

  switch (getch()) {
  case '1': {
    setclr(10);
    cout << "\n\t\t\tVery Easy Level Selected...";
    difflevel = 750;
    Sleep(1000);
    break;
  }

  case '2': {
    setclr(2);
    cout << "\n\t\t\t Easy Level Selected...";
    difflevel = 500;
    Sleep(1000);
    break;
  }

  case '3': {
    setclr(6);
    cout << "\n\t\t\t Moderate Level Selected...";
    difflevel = 400;
    Sleep(1000);
    break;
  }

  case '4': {
    setclr(12);
    cout << "\n\t\t\t Hard Level Selected...";
    difflevel = 150;
    Sleep(1000);
    break;
  }

  case '5': {
    setclr(4);
    cout << "\n\t\t\t Very Hard Level Selected...";
    difflevel = 0;
    Sleep(1000);
    break;
  }

  }

  int score = 0;
  int lives = 3;

  char c;
  system("cls");

  char alphabet[36] = {
    'a',
    'b',
    'c',
    'd',
    'e',
    'f',
    'g',
    'h',
    'i',
    'j',
    'k',
    'l',
    'm',
    'n',
    'o',
    'p',
    'q',
    'r',
    's',
    't',
    'u',
    'v',
    'w',
    'x',
    'y',
    'z',
    '0',
    '1',
    '2',
    '3',
    '4',
    '5',
    '6',
    '7',
    '8',
    '9'
  };

  while (c != '\r') {
    int r;

    if (keyboardchoice == '2') {
      r = rand() % 35;
    } else {
      r = rand() % 25;
    }

    system("cls");
    setclr(theemeoption + 9);
    cout << "\n\t\t\t-->LIVES : " << lives << "<--";
    cout << "\n\t\t\t-->SCORE : " << score << "<--";
    setclr(theemeoption);
    cout << "\n\n\t\tPress:  " << alphabet[r];
    cout << "\n\n\t\t---->   ";

    c = getche();
    Sleep(difflevel);

    if (c == alphabet[r]) {
      ++score;
    } else {
      --lives;
      cout << "\a";
      Sleep(750);
    }

    if (lives == 0) {
      Sleep(1000);
      setclr(theemeoption + 7);

      cout << "\n\n\n\t\t\tYour SCORE IS : " << score;
      cout << "\a";
      cout << "\n\n\t\t\tPRESS Enter for Main Menu..." <<
        "\n\t\t\tOR press any other key to play again...";

      if (getch() == '\r')
        mainmenu();
      else
        rapidtyping();

    }

  }
}
//Random Words Practice...
void wordlesson() {
  system("cls");
  setclr(theemeoption + 9);
  cout << "\n\t\t\t\tWelcome!\n\n" <<
    "\t\t->  You have selected WORD TYPING mode :" <<
    "\n\n\t\t  -> Simply Type the WORDS displayed on screen." <<
    "\n\n\t\t  -> Press Enter after every ENTERED WORD." <<
    "\n\n\t\t  -> TYPE 'exiit' to QUIT anytime you want." <<
    "\n\n\t\t  -> You can Try Editing word.txt file" <<
    "\n\n\t\t\t -> Press any key to Start...";
  getch();

  ifstream infile("word.txt");
  int wordscount = 0;
  int mistakes = 0;
  string actualword;
  string inputword;

  while (inputword != "exiit") {
    infile >> actualword;

    system("cls");

    setclr(theemeoption);
    cout << "\n\n\t\t\t TYPE: " << actualword << "\n\n\t\t\tINPUT: ";
    cin >> inputword;

    ++wordscount;

    if (inputword == actualword) {
      continue;
    } else {
      ++mistakes;
      cout << "\a";
      Sleep(1000);

    }
  }

  --wordscount; // as last word was exiit;

  system("cls");

  float correct = wordscount + 1 - mistakes;
  //Added 1 as last enterd character 'enter' is always correct'

  cout << "\n\n\t\t\t Total WORDS Practiced :" << wordscount;

  setclr(10);
  cout << "\n\t\t\t   Correct : " << correct; //

  setclr(12);
  cout << "\n\t\t\t   Mistakes : " << mistakes - 1;

  float accuracy = (correct / wordscount) * 100;

  setclr(13);
  cout << "\n\t\t\t   Accuracy : ";

  if (accuracy >= 90) {
    setclr(10);
    cout << accuracy << "%\n\t\t\t   WELLDONE!!";
  } else if (accuracy >= 80 && accuracy <= 89) {
    setclr(6);
    cout << accuracy << "%\n\t\t\t   GOOOD!!";
  } else {
    setclr(4);
    cout << accuracy << "%\n\t\t\t   MORE PRACTICE NEEDED!!";
  }

  setclr(14);
  cout << "\n\n\n\t\tPress Enter to Continue...\n\n\t\tAny other key for Main Menu...";

  if (getch() == '\r') {
    wordlesson();
  } else {
    mainmenu();
  }

}

//Paragraph practice...
void paragraphpractice() {
  system("cls");

  setclr(theemeoption + 10);
  cout << "\n\t\t\t\tWelcome!\n\n" <<
    "\t\t->  You have selected PARAGRAPH TYPING mode :" <<
    "\n\n\t\t  -> Simply Type the SENTENCES displayed on screen." <<
    "\n\n\t\t  -> Press Enter after every ENTERED sentence." <<
    "\n\n\t\t  -> TYPE 'exiit' to QUIT anytime you want." <<
    "\n\n\t\t  -> You can Try Editing paragraph.txt file" <<
    "\n\n\t\t\t -> Press any key to Start...";
  getch();

  ifstream infile("paragraph.txt");
  string totaltyped = "";
  string actualparagraph = "";
  string actualword;
  string inputword;
  int mistakes = 0;

  while (inputword != "exiit") {
    infile >> actualword;

    system("cls");

    setclr(theemeoption);
    cout << "Paragraph Typed ---> " << totaltyped;
    cout << "\n\n\t\t\t TYPE: " << actualword << "\n\n\t\t\tINPUT: ";
    cin >> inputword;

    actualparagraph += actualword + " ";

    if (inputword == actualword) {
      totaltyped += inputword + " ";
    } else {
      ++mistakes;
      cout << "\a";
      Sleep(1000);
      totaltyped += inputword + " ";
    }
  }

  system("cls");

  setclr(12);
  cout << "\n\n\t\t\tMistakes : " << mistakes - 1 << endl;

  setclr(theemeoption);
  cout << "\n\n\t\t\tTYPED PARAGRAPH\n\n\t" << totaltyped;

  setclr(theemeoption + 7);
  cout << "\n\n\n\t\t\tACTUAL PARAGRAPH\n\n\t" << actualparagraph;

  setclr(14);
  cout << "\n\n\n\t\tPress Enter to Continue...\n\n\t\tAny other key for Main Menu...";

  if (getch() == '\r') {
    paragraphpractice();
  } else {
    mainmenu();
  }

}

//Add words....
void addwords() {
  char c;
  system("cls");
  cout << "\n\t\t\tPress Space to add different Word!\n\n\t";
  string word = "";
  ofstream file("word.txt", ios::app);
  cout << "-->";

  while ((c = getche()) != '\r') {
    if (c == ' ') {
      cout << "- ";
      word += c;
    } else {
      word += c;
    }
  }
  file << word << " ";
  cout << "\n\n\t\tWord(s) Added! Press any key for Main Menu! ";
  getch();
  mainmenu();

}

// Main Menu...
void mainmenu() {
  setclr(8);
  system("cls");
  cout << "\t\t\t\t\t\t\t\t\t\tDeveloped BY: Rashid Wassan";
  cout << "\n\t\t\t---------Main Menu---------";
  setclr(theemeoption);

  cout << "\n\n\t\t\t [1] Rapid Typing GAME!" <<
    "\n\n\t\t\t [2] Practice Lessons" <<
    "\n\n\t\t\t [3] Custom words typing" <<
    "\n\n\t\t\t [4] Add More Costum words" <<
    "\n\n\t\t\t [5] Theeme Select Menu" <<
    "\n\n\t\t\t [6] Paragraph Practice" <<
    "\n\n\t\t\t [7] Exit";

  setclr(theemeoption + 9);
  cout << "\n\n\n\t\t\t Total Characters Practiced in this session :" << total_characters_typed;

  setclr(8);
  cout << "\n\n\t\t\t ENTER YOUR CHOICE : ";

  switch (getch()) {
  case '1':
    rapidtypinginstr();

  case '2':
    practicelessons p;
    p.practicelesson();

  case '3':
    wordlesson();

  case '4':
    addwords();

  case '5':
    theememenu();

  case '6':
    paragraphpractice();

  case '7':
    cout << "\n\n\n\n\t\t\t\tTHANKS FOR USING THIS SOFTWARE !";
    cout << "\a";
    Sleep(2000);
    exit(0);

  default:
    cout << "Invalid Selection! Press any key!";
    getch();
    mainmenu();
  }

}
int main() {

  welcomescreen();
  mainmenu();
}