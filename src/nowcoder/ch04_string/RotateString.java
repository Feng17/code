package nowcoder.ch04_string;

/**
 *  翻转字符串
 * 1.给定字符类型数组chas，将单词顺序逆序
 * 2.给定字符数组chas和一个整数size，将大小为seize的左半区移到右半区
 * 思路：1.先将chas整体逆序遍历按 ' ' 找到每一个单词，再将每个单词逆序
 *       2.先将chase[0..seize-1]逆序，再将chase[size..N-1]逆序，最后整体逆序
 *
*/
public class RotateString {

    public static void rotateWord(char[] chas) {
        if (chas == null || chas.length == 0) {
            return;
        }
        reverse(chas, 0, chas.length - 1); //整体逆序
        int l = -1;
        int r = -1;
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] != ' ') {
                l = i == 0 || chas[i - 1] == ' ' ? i : l; //记录每个单词开始字符的数组下标
                r = i == chas.length - 1 || chas[i + 1] == ' ' ? i : r;//记录每个单词开始字符的数组下标
            }
            if (l != -1 && r != -1) { //将单词逆序
                reverse(chas, l, r);
                l = -1;
                r = -1;
            }
        }
    }

    public static void reverse(char[] chas, int start, int end) {
        char tmp = 0;
        while (start < end) {
            tmp = chas[start];
            chas[start] = chas[end];
            chas[end] = tmp;
            start++;
            end--;
        }
    }

    public static void rotate(char[] chas, int size) {
        if (chas == null || size <= 0 || size >= chas.length) {
            return;
        }
        reverse(chas, 0, size - 1);
        reverse(chas, size, chas.length - 1);
        reverse(chas, 0, chas.length - 1);
    }



    public static void main(String[] args) {
        char[] chas1 = { 'd', 'o', 'g', ' ', 'l', 'o', 'v', 'e', 's', ' ', 'p',
                'i', 'g',' ','a','n','d',' ','c','a','t' };
        System.out.println(String.valueOf(chas1)); //dog loves pig and cat
        rotateWord(chas1);   //cat and pig loves dog
        System.out.println(String.valueOf(chas1));

        char[] chas2 = { '1', '2', '3', '4', '5', 'A', 'B', 'C' };
        System.out.println(String.valueOf(chas2));//12345ABC
        rotate(chas2, 5);
        System.out.println(String.valueOf(chas2));//ABC12345

    }

}
