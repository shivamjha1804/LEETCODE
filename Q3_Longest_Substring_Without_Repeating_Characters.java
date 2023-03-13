import java.util.*;

public class Q3_Longest_Substring_Without_Repeating_Characters 
{
    //Brute Force
    public static Boolean areDistincting(String s, int left, int right)
    {
        boolean[] seen = new boolean[26];
    
        for(int i = left; i <= right; i++)
        {
            if (seen[s.charAt(i) - 'a'] == true)
            {
                return false;
            }
            seen[s.charAt(i) - 'a'] = true;
        }
        return true;
    }

    public int lengthOfLongestSubstring(String s) 
    {
        
        int max = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            for(int j = i; j < s.length(); j++)
            {
                if (areDistincting(s.length(), i, j))
                {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
                    
        return max;
    }    

    //Optimize 
    public int lengthOfLongestSubstring(String s)
    {
        int left = 0, right = 0;
        Set <Character> st = new HashSet<>();
        int max = 0;

        while(right < s.length())
        {
            char c = s.charAt(right);
            if(st.add(c))
            {
                max = Math.max(max, right - left + 1);
                right++;
            }

            else
            {
                while (s.charAt(left) != c) 
                {
                    st.remove(s.charAt(left));
                    left++;    
                }
            }

            st.remove(c);
            left++;
        }
    }
    return max;
}