
/* ��ת�ַ���
1.�����ַ���������chas��������˳������
2.�����ַ�����chas��һ������size������СΪseize��������Ƶ��Ұ���

 ����˼·��1.�Ƚ�chase������������� ' ' �ҵ�ÿһ�����ʣ��ٽ�ÿ����������
          2.�Ƚ�chase[0..seize-1]�����ٽ�chase[size..N-1]���������������
   
*/
package nowcoder;
public class RotateString {

	public static void rotateWord(char[] chas) {
		if (chas == null || chas.length == 0) {
			return;
		}
		reverse(chas, 0, chas.length - 1);
		int l = -1;
		int r = -1;
		for (int i = 0; i < chas.length; i++) {
			if (chas[i] != ' ') {
				l = i == 0 || chas[i - 1] == ' ' ? i : l;
				r = i == chas.length - 1 || chas[i + 1] == ' ' ? i : r;
			}
			if (l != -1 && r != -1) {
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


	public static void exchange(char[] chas, int start, int end, int size) {
		int i = end - size + 1;
		char tmp = 0;
		while (size-- != 0) {
			tmp = chas[start];
			chas[start] = chas[i];
			chas[i] = tmp;
			start++;
			i++;
		}
	}

	public static void main(String[] args) {
		char[] chas1 = { 'd', 'o', 'g', ' ', 'l', 'o', 'v', 'e', 's', ' ', 'p',
				'i', 'g' };
		System.out.println(String.valueOf(chas1));
		rotateWord(chas1);
		System.out.println(String.valueOf(chas1));

		char[] chas2 = { '1', '2', '3', '4', '5', 'A', 'B', 'C' };
		System.out.println(String.valueOf(chas2));
		rotate(chas2, 5);
		System.out.println(String.valueOf(chas2));
	
	}

}