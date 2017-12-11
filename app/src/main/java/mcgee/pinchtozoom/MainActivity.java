package mcgee.pinchtozoom;

import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

public class MainActivity extends AppCompatActivity {

    private ImageView image;
    private ScaleGestureDetector mScaleGestureDetector;
    private Matrix matrix = new Matrix();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.image);

        mScaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());
    }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            mScaleGestureDetector.onTouchEvent(event);

            return true;
        }

        private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {

            @Override
            public boolean onScale(ScaleGestureDetector detector) {
                float scaleFactor = detector.getScaleFactor();
                scaleFactor = Math.max(0.1f, Math.min(scaleFactor, 5.0f));
                matrix.setScale(scaleFactor, scaleFactor);
                image.setImageMatrix(matrix);

                return true;
        }
    }
}
