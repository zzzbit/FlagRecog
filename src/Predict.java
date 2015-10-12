import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import javax.imageio.ImageIO;

class MyCompare implements Comparator // 实现Comparator，定义自己的比较方法
{
	public int compare(Object o1, Object o2) {
		MyClass e1 = (MyClass) o1;
		MyClass e2 = (MyClass) o2;

		if (e1.distance < e2.distance)// 这样比较是降序,如果把-1改成1就是升序.
		{
			return -1;
		} else if (e1.distance > e2.distance) {
			return 1;
		} else {
			return 0;
		}
	}
}

public class Predict {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			Vector<MyClass> featureSet = new Vector<>();
			int minNo = 0;
			double minDistance = 1e20;
			int k = 50;
			
			BufferedImage im = ImageIO.read(new File("C:\\Users\\zhangzhizhi\\Pictures\\国旗_高清\\阿曼.png"));
			HistImage imh = new HistImage(im,k);

			String s = null;
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream("C:\\Users\\zhangzhizhi\\Pictures\\国旗\\feature.txt")));
			s = br.readLine();
			while ((s = br.readLine()) != null) {
				String[] ssplit= s.split(" ");
				MyClass myclass = new MyClass();
				myclass.name = ssplit[0];
				for (int i = 1; i < ssplit.length; i++){
					myclass.data.add(Double.parseDouble(ssplit[i]));
				}
				featureSet.add(myclass);
			}
			br.close();
					
			MyClass myclass = new MyClass();
//			for (int j = 1; j <= 7; j++) {
//				myclass.data.add(imh.huJu[j]);
//			}
//			myclass.data.add(imh.colorJuH[1]);
//			myclass.data.add(imh.colorJuH[2]);
//			myclass.data.add(imh.colorJuS[1]);
//			myclass.data.add(imh.colorJuS[3]);
//			myclass.data.add(imh.colorJuV[2]);
//			myclass.data.add(imh.colorJuV[3]);
			for (int j = 0; j < k; j++){
				myclass.data.add(imh.colorHist[j]);
			}
			for (int i = 0; i < featureSet.size(); i++) {
				double sum = 0;
				for (int j = 0; j < myclass.data.size(); j++) {
					sum += Math.abs(myclass.data.get(j) - featureSet.get(i).data.get(j));
				}
				featureSet.get(i).distance = sum;
			}
			
			Collections.sort(featureSet,new MyCompare());
			
			for (int j = 0; j < myclass.data.size(); j++) {
				System.out.print(myclass.data.get(j)+" ");
			}
			System.out.println();
			for (int i = 0; i < 10; i ++){
				for (int j = 0; j < featureSet.get(i).data.size(); j++) {
					System.out.print(featureSet.get(i).data.get(j)+" ");
				}
				System.out.println(featureSet.get(i).name);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
