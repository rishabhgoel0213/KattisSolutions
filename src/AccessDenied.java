import java.util.Scanner;

public class AccessDenied
{
    public static String randString(int len)
    {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < len; i++)
        {
            s.append('0');
        }
        return s.toString();
    }

    public static String changeChar(String pwd, int i)
    {
        int increment = 1;
        if(pwd.charAt(i) == '9'){increment = 8;}
        else if(pwd.charAt(i) == 'Z'){increment = 7;}
        return pwd.substring(0, i) + (char)((int)pwd.charAt(i) + increment) + pwd.substring(i + 1);
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String pwd = "A";
        System.out.println(pwd);
        String line = in.nextLine();

        //5 if len is incorrect

        //otherwise
        //4 to check len
        //1 per for + 1 per i update + 3 per bounds check + 1 per if + 3 per equality check = 9 per loop
        //10 for last loop (includes return)

        //(t - 14)/9 should equal num correct letters
        while(!line.equals("ACCESS GRANTED"))
        {
            int br1 = line.indexOf("(");
            int br2 = line.indexOf(")");
            String timeStr = line.substring(br1 + 1, br2);
            int time = Integer.parseInt(timeStr.substring(0, timeStr.indexOf(" ")));

            if(time == 5)
            {
                pwd = randString(pwd.length() + 1);
            }
            else
            {
                int incorrectIndex = (time - 14)/9;
                pwd = changeChar(pwd, incorrectIndex);
            }
            System.out.println(pwd);
            line = in.nextLine();

        }
    }
}
