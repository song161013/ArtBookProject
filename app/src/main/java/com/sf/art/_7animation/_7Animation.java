/**
 * @author: songfei
 * @Title:_7Animation.java
 * @Description:
 * @DATE: 2017-8-9上午10:59:23
 */
package com.sf.art._7animation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sf.art.R;

public class _7Animation extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_7activity);

    }

    public void _7ViewAnimationBtn(View view) {
        Intent i = new Intent(this, _7ViewAnimation.class);
        startActivity(i);
    }

    public void _7LayoutAnimationBtn(View view) {
        Intent i = new Intent(this, _7ViewAnimation.class);
        i.putExtra("layout_animation",true);
        startActivity(i);
    }
}
