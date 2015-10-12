import java.awt.image.BufferedImage;

public class HistImage {

	public BufferedImage	imh;
	public int 				height;
	public int 				width;
	public Point[][]		points;
	public double[]			colorHist;

	public void setColorHist(int k){
		colorHist =	new double[k];
		for (int i = 0; i < k; i++){
			colorHist[i] = 0;
		}
		for (int i = 0; i < width; i++){
			for (int j = 0; j < height; j++){
				int no = (int)(points[i][j].getGray()*k);
				if (no >= k){
					no = k-1;
				}
				colorHist[no] = colorHist[no]+1;
			}
		}
		for (int i = 0; i < k; i++){
			colorHist[i] = colorHist[i]*100/(width*height);
		}
	}
	public HistImage( BufferedImage imh, int k){
		this.imh	=	imh;
		this.height	=	imh.getHeight(null);
		this.width	=	imh.getWidth(null);
		this.points	=	new Point[width][height];

		int	i,j;
		for( i = 0 ; i < this.width ; i++ ){
			for( j = 0 ; j < this.height ; j++ ){
				this.points[i][j]	=	new Point();
				this.points[i][j].setRGB( imh.getRGB(i, j) );
				this.points[i][j].toRed();
				this.points[i][j].toGreen();
				this.points[i][j].toBlue();
				this.points[i][j].toGray();
				this.points[i][j].gray /= 255;
			}
		}
		this.setColorHist(k);
	}
}

