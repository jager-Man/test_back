package test;

import java.awt.event.ItemEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class read_csv {
	
	


	
	public  ArrayList<int[]> toReade_data(String name) {
		// ʹ��ArrayList���洢ÿ�ж�ȡ�����ַ���
		ArrayList<int[]> arrayList = new ArrayList<>();
		
		try {
			
			FileReader fr = new FileReader(name);
			
			BufferedReader bf = new BufferedReader(fr,999999999);
			
			
//			File f=new File("E:/data/data_1.txt");
//			FileInputStream bf=new FileInputStream(fr);

			String str;
			
			// ���ж�ȡ�ַ���
			while ((str = bf.readLine()) != null) {
				System.out.println(str);
				char[] sp = new char[]{32};
				String strings[] = str.split(new String(sp));
				int num[] = new int[strings.length];
				for (int i = 0; i < strings.length; i++) {
					//System.out.println(strings[i]);
					int a = Integer.parseInt(strings[i]);
					num[i]=a;
				}
				arrayList.add(num);
			}
			bf.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ��ArrayList�д洢���ַ������д���
//		int length = arrayList.size();
//		int[] array = new int[length];
//		for (int i = 0; i < length; i++) {
//			String s = arrayList.get(i);
//			array[i] = Integer.parseInt(s);
//		}
		// ��������
		return arrayList;

	}
	
	
	
	public byte[] initdata(ArrayList<int[]> arrayList){
		
		byte[] data = null;
		int size=arrayList.size();
		int intsize=arrayList.get(0).length;	
		for(int i=0;i<1;i++){
			int[] intdata=arrayList.get(i);
			for(int j=0;j<intsize;j++ ){
			System.out.println(intdata[j]);
			}
		}
		
			
		return data;
	}
	
	
	public static void main(String[] args) {    
		read_csv r= new read_csv();
		ArrayList<int[]> arrayList=r.toReade_data("E:/data/data_1.txt");
		r.initdata(arrayList);
				
		
	}		
}