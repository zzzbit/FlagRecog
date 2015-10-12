import java.awt.image.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Vector;
import javax.imageio.ImageIO;

public class Train {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Vector<MyClass> featureSet = new Vector<>();
			String imagePath;
			File[] files;
			int k = 50;
			files = new File("C:\\Users\\zhangzhizhi\\Pictures\\¹úÆì")
					.listFiles();

			for (int i = 0; i < files.length; i++) {
				imagePath = files[i].getAbsolutePath();
				if (imagePath.substring(imagePath.lastIndexOf('.')).equals(".txt")){
					continue;
				}
				BufferedImage im = ImageIO.read(new File(imagePath));
				HistImage imh = new HistImage(im,k);
				MyClass myclass = new MyClass();
//				for (int j = 1; j <= 7; j++) {
//					myclass.data.add(imh.huJu[j]);
//				}
//				myclass.data.add(imh.colorJuH[1]);
//				myclass.data.add(imh.colorJuH[2]);
//				myclass.data.add(imh.colorJuS[1]);
//				myclass.data.add(imh.colorJuS[3]);
//				myclass.data.add(imh.colorJuV[2]);
//				myclass.data.add(imh.colorJuV[3]);
				for (int j = 0; j < k; j++){
					myclass.data.add(imh.colorHist[j]);
				}
				myclass.name = files[i].getName().substring(0, files[i].getName().lastIndexOf('.'));
				featureSet.add(myclass);
			}

			BufferedWriter w = new BufferedWriter(new FileWriter(
					"C:\\Users\\zhangzhizhi\\Pictures\\¹úÆì\\feature.txt"));
			w.write(featureSet.size() + " " + featureSet.get(0).data.size()+"\n");
			for (int i = 0; i < featureSet.size(); i++) {
				w.write(featureSet.get(i).name+" ");
				for (int j = 0; j < featureSet.get(i).data.size() - 1; j++) {
					w.write(featureSet.get(i).data.get(j) + " ");
				}
				w.write(featureSet.get(i).data.get(featureSet.get(i).data
						.size() - 1) + "\n");
			}
			w.flush();
			w.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}