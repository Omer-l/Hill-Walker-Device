import java.util.Scanner;

public class ApplicationRunner 
{
    public static boolean exitTime;
    public static WristDevice wristDevice = new WristDevice();
    public static Scanner input = new Scanner(System.in);
    public static String userInS = "";
    public static int userIn = 0;

    //create objects in main
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        timePrompt();
        
    }
    
    //isDigit userIn
    public static boolean isInputDigit()
    {
        return Character.isDigit(userInS.charAt(0));
    }

    //pause time for 1 second
    public static void pause1second()
    {
        try
        {
            Thread.sleep(1000);
        } catch(InterruptedException ie)
        {
            System.out.println("INTERRUPTED EXCEPTION");
        }
    }

    public static void timeSet()
    {
        //While user input is not 3.
        do {
            wristDevice.timeDisplay();
            if(userIn == 1)
            {
                System.out.print("\n1 SET/ADD, 2 MODE/CHANGE: ");
                String setInS = input.next();
                if(Character.isDigit(setInS.charAt(0)))
                {
                    int setIn = Integer.parseInt(setInS.charAt(0) + "");

                if(setIn == 1)
                {
                    wristDevice.setTime(1,0);
                }
                else if(setIn == 2)
                {
                    timeSetMinute();
                }
                else
                {
                    System.out.println("\nPRESS THE RIGHT BUTTON");
                    pause1second();
                    timeSet();

                }
                }
                else
                {
                   System.out.println("\nYOU MUST ENTER A DIGIT");
                   pause1second();
                   timeSet();
                }
            } 
        }while(userIn != 3);
    }
    
    //prompt to change minute
    public static void timeSetMinute()
    {
        //While user input is not 3.
        do {
            wristDevice.timeDisplay();
            if(userIn == 1)
            {
                System.out.print("\n1 SET/ADD, 2 MODE/CHANGE: ");
                String setInS = input.next();
                if(Character.isDigit(setInS.charAt(0)))
                {
                    int setIn = Integer.parseInt(setInS.charAt(0) + "");

                if(setIn == 1)
                {
                    wristDevice.setTime(0,1);
                }
                else if(setIn == 2)
                {
                    timePrompt();
                }
                else
                {
                    System.out.println("\nPRESS THE RIGHT BUTTON");
                    pause1second();
                    timeSetMinute();
                }
                }
                else
                {
                   System.out.println("\nYOU MUST ENTER A DIGIT");
                   pause1second();
                   timeSetMinute();
                }
            } 
        }while(userIn != 3);


    }

    //prompt for time
    public static void timePrompt()
    {
        wristDevice.getTime();
        wristDevice.timeDisplay();

        System.out.print("\n1 SET/ADD, 2 MODE/CHANGE: ");
        userInS = input.next();

        //if input is a digit
        if(isInputDigit()) 
        {
            userIn = Integer.parseInt(userInS.charAt(0) + "");
            if(userIn == 1)
            {
                timeSet();
            }
            else if(userIn == 2)
            {
                altimeterPrompt();
            }
            else
            {
                System.out.println("\nPRESS THE RIGHT BUTTON");
                pause1second();
                timePrompt();
            }
        }
        else
        {
            System.out.println("\nYOU MUST ENTER A DIGIT");
            pause1second();
            timePrompt();
        }
    }

    //prompt for altimeter
    public static void altimeterPrompt()
    {
        wristDevice.altimeterDisplay();
        System.out.print("\n1 SET/ADD, 2 MODE/CHANGE: ");
        userInS = input.next();

        //if input is a digit
        if(isInputDigit()) 
        {
            userIn = Integer.parseInt(userInS.charAt(0) + "");

        if(userIn == 1)
        {
            altimeterPrompt();
        }
        else if(userIn == 2)
        {
            timePrompt();
        }
        else
        {
            System.out.println("\nPRESS THE RIGHT BUTTON");
            altimeterPrompt(); 
            pause1second();
        }
        }
        else
        {
            System.out.println("\nYOU MUST ENTER A DIGIT");
            altimeterPrompt();
            pause1second();
        }

    }

    //set altimeter ***********EXTRA,I DID NOT HAVE TO DO THIS************
    public static void altimeterSet()
    {
        wristDevice.altimeterDisplay();
        System.out.print("\nEnter the altitude: ");
        String setInS = input.next();

        try
        {
        {
            int setIn = Integer.parseInt(setInS);
            if(setIn <= 8848 && setIn >= 414)
            {
                wristDevice.altimeter = setIn;
                altimeterPrompt();
            }
            else
            {
                System.out.println("\nTHE WORLD'S HIGHEST/LOWEST ALTITUDE ISN'T EVEN THAN THAT!");
                pause1second();
                altimeterSet();
            }
        }
        } catch(NumberFormatException nfe)
        {
            System.out.println("\nYOU MUST ENTER A DIGIT");
            pause1second();
            altimeterSet();
        }
    }
}
