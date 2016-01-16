import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_highgui.*;
import static com.googlecode.javacv.cpp.opencv_core.cvCreateImage;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;
 
import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.ImageTransformer;
import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
 
public class edgedetection {
	
	
	/**
	 * @param args
	 * @author akkaash
	 * 
	 */
	public static void main(String[] args) {
		
		//load image
		IplImage image = cvLoadImage("demo.jpg");
		
		//create grayscale IplImage of the same dimensions, 8-bit and 1 channel
        IplImage imageGray = cvCreateImage(cvSize(image.width(), image.height()), IPL_DEPTH_8U, 1);
        
        //convert image to grayscale
        cvCvtColor(image, imageGray, CV_BGR2GRAY );
         
        //create canvas frame named 'Demo'
        CanvasFrame canvas = new CanvasFrame("RGB");
        CanvasFrame canvas2 = new CanvasFrame("Gray"); 
        //Show image in canvas frame
        canvas.showImage(image);
        canvas2.showImage(imageGray);
		
        IplImage gray = new IplImage(imageGray);
        
        
        IplImage edge = cvCreateImage(cvSize(gray.width(), gray.height()), IPL_DEPTH_8U, 1);
        
        //run Canny edge detection..
        cvCanny(gray, edge, 140, 240, 7);
        new CanvasFrame("Edge").showImage(edge);        
        
	}
 
}
