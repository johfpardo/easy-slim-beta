package easy_slim_beta.swipe;

import android.view.MotionEvent;
import android.view.GestureDetector.SimpleOnGestureListener;

public class SwipeGestureDetector extends SimpleOnGestureListener {
	// Swipe properties, you can change it to make the swipe 
	// longer or shorter and speed
	private static final int SWIPE_MIN_DISTANCE = 120;
	private static final int SWIPE_MAX_OFF_PATH = 200;
	private static final int SWIPE_THRESHOLD_VELOCITY = 200;
	
	private Swipeable activity;
	
	public SwipeGestureDetector(Swipeable activity) { this.activity=activity; }

    @Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
    	try {
    		float diffAbs = Math.abs(e1.getY() - e2.getY());
    		float diff = e1.getX() - e2.getX();
    		
    		if (diffAbs > SWIPE_MAX_OFF_PATH) return false;
    		
    		// Right swipe
    		if (diff > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
    			activity.onRightSwipe(null);
    		// Left swipe
    		else if (-diff > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
    			activity.onLeftSwipe(null);
    		
    	} catch (Exception e) { }
    	return false;
	}
}