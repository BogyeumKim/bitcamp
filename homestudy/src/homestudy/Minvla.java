package homestudy;

public class Minvla {

	
	public static int minmethod (int array[i]) { // �ּ�
		int min = array[0]; // ���ذ� 0��° ������ ��Ƶ�
	
		for(int i=0; i<array.length; i++) { // 10������
			if(min>array[i]) { // 0��°���� i�� 0,1,2,~10 ���� �ݺ��ϸ鼭 0��°���� ��ũ�� ?? 
				min=array[i];
			}
		}
		return min; // ���� min=array[i]���Ͻ�Ŵ
	}
	
}
