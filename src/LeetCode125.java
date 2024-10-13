public class LeetCode125 {
    public boolean isPalindrome1(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for(int i=0;i<length;i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                sgood.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer sogood_rev = new StringBuffer(sgood).reverse();
        return sgood.toString().equals(sogood_rev.toString());
    }

    public boolean isPalindrome2(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for(int i=0;i<length;i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                sgood.append(Character.toLowerCase(ch));
            }
        }
        int n=sgood.length();
        int left=0, right=n;
        while(left<right){
            if(sgood.charAt(left) != sgood.charAt(right-1)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome3(String s) {
        int n = s.length();
        int left=0,right=n;
        while (left<right) {
            while (left<right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left<right && !Character.isLetterOrDigit(s.charAt(right-1))) {
                right--;
            }
            if(left<right){
                if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right-1))){
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
