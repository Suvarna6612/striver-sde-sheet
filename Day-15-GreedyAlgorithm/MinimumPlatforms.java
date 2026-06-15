import java.util.*;

class Solution {
    static int findPlatform(int arr[], int dep[]) {

        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 1;
        int j = 0;

        int platforms = 1;
        int maxPlatforms = 1;

        while(i < arr.length && j < dep.length) {

            if(arr[i] <= dep[j]) {
                platforms++;
                i++;
            } else {
                platforms--;
                j++;
            }

            maxPlatforms = Math.max(maxPlatforms, platforms);
        }

        return maxPlatforms;
    }
}