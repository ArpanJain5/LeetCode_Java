class Solution {
    final int MOD = 1000000007;
    public int numberOfWays(String corridor) {
        long numWays = 1;
        int numSeats = 0, plants = 0;
        char ch;
        boolean evenPlants = true;
        for(int i = 0; i < corridor.length();i++)
        {
            ch = corridor.charAt(i);
            if(ch == 'S')
            {
                if(plants > 0 && numSeats >= 2 && evenPlants)
                {
                    plants++;
                    numWays=(numWays * plants)%MOD;
                    plants = 0;
                }
                evenPlants = !evenPlants;
                numSeats++;
            }
            else
            {
                if(evenPlants && numSeats >= 2)
                    plants++;
            }
        }
        if(!evenPlants || numSeats < 1)
            return 0;
        return (int)numWays%MOD;
    }
}