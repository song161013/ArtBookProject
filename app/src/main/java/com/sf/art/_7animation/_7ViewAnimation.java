/**
 * @author: songfei
 * @Title:_7ViewAnimation.java
 * @Description:
 * @DATE: 2017-8-9上午11:05:48
 */
package com.sf.art._7animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import android.widget.TextView;

import com.sf.art.R;

public class _7ViewAnimation extends Activity {
    TextView tv;
    ListView lv;
boolean layout_animation=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_7view_animation);
        tv = (TextView) findViewById(R.id._7tv);
        lv = (ListView) findViewById(R.id._7lv);
        layout_animation=getIntent().getBooleanExtra("layout_animation",false);
        initAnimation();
    }

    private void initAnimation() {
        if(!layout_animation){
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.view_animation);
            tv.startAnimation(animation);
        }else{

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        layout_animation=false;
    }
}
