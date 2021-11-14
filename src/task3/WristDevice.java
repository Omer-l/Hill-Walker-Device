import java.util.Scanner;

public class WristDevice
{
    String time;
    public int altimeter = 1500;
    public long currentSecond;
    public long currentMinute;
    public long currentHour;

    //to add to currentTime
    public long setMinute = 0;
    public long setHour = 0;

    //get time
    public void getTime()
    {
            long totalMilliseconds = System.currentTimeMillis();

            long totalSeconds = totalMilliseconds / 1000;
            currentSecond = totalSeconds % 60;

            long totalMinutes = totalSeconds / 60;
            currentMinute = totalMinutes % 60;
            
            //add in loop, if minutes go past 60
            for(int i = 1; i <= setMinute; i++)
            {
                currentMinute += 1;
                if(currentMinute > 59)
                {
                    currentMinute = 0;
                }
            }

            long totalHours = totalMinutes / 60;
            currentHour = totalHours % 24;
                //reset to 0 then add on the extra hours
                for(int i = 1; i <= setHour; i++)
                {
                    currentHour += 1;
                    if(currentHour > 23)
                    {
                        currentHour = 0;
                    }
                }
    }

    public void setTime(int hour, int minute) 
    {
        //if user wants to change hour, then hour = 1, if minute, then minute = 1 the ones not to change = 0.
        if(hour == 1)
        {
            setHour++;
        }
        else if(minute == 1)
        {
            setMinute++;
        }
    }
    public void getAltimeter()
    {
        System.out.println(altimeter + "\n");
    }
    public void timeDisplay()
    {
        getTime();
        //conditional statements in printf to make time look cleaner
        System.out.printf("TIME ==== %2s : %2s : %2s ==== TIME", (currentHour < 10) ? "0" + currentHour : currentHour, (currentMinute < 10) ? "0" + currentMinute : currentMinute, (currentSecond < 10) ? "0" + currentSecond : currentSecond);
    }

    //display altimeter
    public void altimeterDisplay()
    {
        System.out.print("ALTI ====     " + altimeter + "     ==== ALTI");
    }
    
}
