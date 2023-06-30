public class Excitement
{
    public int calcExcitement(int skill1, int skill2)
    {
        String bin1 = Integer.toBinaryString(skill1);
        String bin2 = Integer.toBinaryString(skill2);

        boolean[] excitement = new boolean[bin1.length()];
        if(bin2.length() > bin1.length())
        {
            excitement = new boolean[bin2.length()];
        }
        for(int i = 0; i < bin1.length() || i < bin2.length(); i++)
        {
            if(i > bin1.length())
            {
                excitement[i] = Boolean.parseBoolean(bin2.substring(i, i + 1));
            }
            else if(i > bin2.length())
            {
                excitement[i] = Boolean.parseBoolean(bin1.substring(i, i + 1));
            }
            else
            {
                excitement[i] = Boolean.parseBoolean(bin1.substring(i, i + 1)) ^ Boolean.parseBoolean(bin2.substring(i, i + 1));
            }
        }
        return 0;
    }

    public static void main(String[] args)
    {

    }
}
