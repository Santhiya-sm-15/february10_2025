class Solution {
    public String clearDigits(String s) {
        int i,j;
        StringBuilder sb=new StringBuilder(s);
        for(i=0;i<sb.length();)
        {
            if(sb.charAt(i)>='0' && sb.charAt(i)<='9')
            {
                j=i-1;
                while(j>=0 && sb.charAt(j)>='0' && sb.charAt(j)<='9')
                    j--;
                sb.deleteCharAt(j);
                i--;
                sb.deleteCharAt(i);
            }
            else
                i++;
        }
        return sb.toString();
    }
}