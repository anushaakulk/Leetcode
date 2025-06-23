Optimised code: 

class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        int[] target = new int[128];
        for (char c : t.toCharArray()) {
            target[c]++;
        }

        int left = 0, right = 0, start = 0, minLen = Integer.MAX_VALUE, count = t.length();

        while (right < s.length()) {
            char rChar = s.charAt(right);
            if (target[rChar] > 0) {
                count--;
            }
            target[rChar]--;
            right++;

            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char lChar = s.charAt(left);
                target[lChar]++;
                if (target[lChar] > 0) {
                    count++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}





Redefined code: TLE

class Solution {
    public String minWindow(String s, String t) {
        int prevStart = 0;
        int res = Integer.MAX_VALUE;
        String result = "";
        if (t.length() > s.length()) return "";

        for (int start = 0; start <= s.length() - t.length(); start++) {
            StringBuilder sb = new StringBuilder();
            int[] freq = new int[128]; // ASCII char count
            for (char c : t.toCharArray()) {
                freq[c]++;
            }

            int count = t.length();
            for (int end = start; end < s.length(); end++) {
                char c = s.charAt(end);
                sb.append(c);

                if (freq[c] > 0) count--;
                freq[c]--;

                if (count == 0) {
                    if (end - start + 1 < res) {
                        res = end - start + 1;
                        result = s.substring(start, end + 1); // Extract from original string
                        prevStart = start; // ✅ now prevStart actually tracks window start
                    }
                    break; // No need to expand window further
                }
            }
        }

        return result;
    }
}





Previous code: To check if all the characters in t are in s, I was doing it the wrong way

class Solution {
    public String minWindow(String s, String t) {
        int prevStart = 0;
        int nextStart = 0;
        int res = Integer.MAX_VALUE;
        String result = "";
        StringBuilder sb = new StringBuilder();
        if(t.length()>s.length()) return "";
        for(int i=0;i<s.length()-t.length();i++){
            sb.append(s.charAt(i));
            StringBuilder temp = new StringBuilder(sb);
            boolean isContains = true;
            for(int j=0;j<t.length();j++){
                if(temp.indexOf(""+t.charAt(j))==-1){
                    isContains = false;
                    break;
                }
                else{
                    if(j==1) {
                        prevStart = nextStart;
                        System.out.println(sb.toString());
                        nextStart = sb.indexOf(""+t.charAt(j));
                        System.out.println(prevStart+""+nextStart);
                    }
                    temp.deleteCharAt(temp.indexOf(""+t.charAt(j)));
                }
            }
            if(isContains){
                if(res>i-prevStart+1){
                    res = i-prevStart+1;
                    result = s.substring(prevStart,i+1);
                }
                // System.out.println(prevStart+""+nextStart);
                sb.delete(prevStart,nextStart);
                // System.out.println(sb.toString());
            }
        }
        return result;
    }
}
