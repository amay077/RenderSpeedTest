/**
 *
 */
package jp.co.cosmoroot.android.samples;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author h_okuyama
 *
 */
public class CustomView extends View {

	private Paint linePaint = null;
	private Paint textPaint = null;
	private int count = 1;

	public CustomView(Context context) {
		super(context);

		setFocusable(true);
		setFocusableInTouchMode(true);

		linePaint = new Paint();
		linePaint.setColor(Color.WHITE);
		textPaint = new Paint();
		textPaint.setColor(Color.YELLOW);
		textPaint.setTextSize(20f);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		int x1, x2, y1, y2;
		int height = getHeight();
		int width = getWidth();

		long start = System.currentTimeMillis();

		for (int i = 0; i < count; i++) {
			x1 = (int)(Math.random() * width);
			x2 = (int)(Math.random() * width);
			y1 = (int)(Math.random() * height);
			y2 = (int)(Math.random() * height);

			linePaint.setColor(Color.rgb((int)(Math.random() * 255),
					(int)(Math.random() * 255),
					(int)(Math.random() * 255)));
			canvas.drawLine(x1, x2, y1, y2, linePaint);
		}

		long end = System.currentTimeMillis();

		StringBuilder builder = new StringBuilder();
		builder.append("cnt=");
		builder.append(count);
		builder.append(", spd=");
		builder.append(end - start);
		builder.append("ms.");

		((Activity)getContext()).setTitle(builder.toString());
	}

	/**
	 * @return count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count セットする count
	 */
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			count = count + 1000;
			invalidate();
			break;

		default:
			break;
		}

		return super.onTouchEvent(event);
	}

}
