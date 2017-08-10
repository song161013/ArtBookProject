package com.sf.art._3view_event;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.sf.art.R;

/**
 * Created by Finltop on 2017/8/10.
 */

public class _3viewEvetActivity extends Activity {
    private static final int DELAYED_TIME = 33;
    private static final int FRAME_COUNT = 30;// frame
    private final int MESSAGE_SCROLL_TO = 1;
    int count = 0;
    Button btn1;
    private int mCount = 0;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MESSAGE_SCROLL_TO: {
//                    if (count <33) {
//                        int scrollX = 33 / 200;
//                        count++;
//                        btn1.scrollBy(scrollX, 0);
//                        mHandler.sendEmptyMessageDelayed(MSG_SCROLL_TO,60);
//                    }
                    mCount++;
                    if (mCount <= FRAME_COUNT) {
                        float fraction = mCount / (float) FRAME_COUNT;
                        int scrollX = (int) (fraction * 100);
                        btn1.scrollTo(scrollX, 0);
                        mHandler.sendEmptyMessageDelayed(MESSAGE_SCROLL_TO, DELAYED_TIME);
                    }
                    break;
                }
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_3activity);
        btn1 = (Button) findViewById(R.id._3view_base_btn);
    }

    public void _3ViewBaseBtn(View view) {
        //ObjectAnimator 动画实现滑动
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(btn1, "translationX", 200, 0);
//        objectAnimator.setDuration(2000);
//        objectAnimator.start();


         /*handler延迟实现滑动*/
        mHandler.sendEmptyMessageDelayed(MESSAGE_SCROLL_TO, 60);
    }
}
