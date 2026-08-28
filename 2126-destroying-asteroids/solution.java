class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long count=mass;
        for(int i =0;i<asteroids.length;i++)
        {
            if(count<asteroids[i])
            {
                return false;
            }
            count=count+asteroids[i];
        }
        return true;
        
    }
}