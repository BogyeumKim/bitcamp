package homestudy;

public class Maxvla {


	
	public static int maxmethod (int array[i]) {
		int max = array[0];
	
		for(int i=0; i<array.length; i++) {
		
			if(max<array[i]) { // 0��°���� �Ȱ��� 10���ݺ��ϸ鼭 i�� ��ũ�� max�� i�����ιٱ���
				max=array[i];
	}	
	}
		return max;
	}	
	}//����Ŭ������

	
}
