package homestudy;

import java.util.Scanner;

public class Arraystudy {

	public static int main(String[] args) {
	
		
		int array[] = new int[10]; // 10�� ������� ����
		
		
	
		
		Scanner kb = new Scanner(System.in); // �ִ��ּҹ��� kb
		
		System.out.println("�ִ밪 �ּҰ��� ���� ���� 10���� �Է�"); 
		
		for(int i=0; i<array.length; i++) { // 10�� �ݺ���
			array[i] = kb.nextInt(); // 10������ �����Է�
			
		}
		
		System.out.println(minmethod(array)); // �ּҰ� �޼ҵ���� 
		System.out.println(maxmethod(array)); // �ִ� �޼ҵ���� 

	
	
		
		
		 static int minmethod (int[] array) { // �ּ�
			int min = array[0]; // ���ذ� 0��° ������ ��Ƶ�
		
			for(int i=0; i<array.length; i++) { // 10������
				if(min>array[i]) { // 0��°���� i�� 0,1,2,~10 ���� �ݺ��ϸ鼭 0��°���� ��ũ�� ?? 
					min=array[i];
				}
			}
			return min; // ���� min=array[i]���Ͻ�Ŵ
		}
		
		static int maxmethod (int[] array) {
			int max = array[0];
		
			for(int i=0; i<array.length; i++) {
			
				if(max<array[i]) { // 0��°���� �Ȱ��� 10���ݺ��ϸ鼭 i�� ��ũ�� max�� i�����ιٱ���
					max=array[i];
		}	
		}
			return max;
		}	
		}//����Ŭ������


