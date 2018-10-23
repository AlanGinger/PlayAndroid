package alanyuan.playandroid;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AnimationActivity extends AppCompatActivity {
    private TextView mBtnAnimation;
    private LinearLayout mLayoutAnimation;
    private boolean isGone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_animation);
        mBtnAnimation = (TextView) findViewById(R.id.btn_animation);
        mLayoutAnimation = (LinearLayout) findViewById(R.id.layout_animation);
        setListener();
    }

    private void setListener() {
        mBtnAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isGone) {
                    mLayoutAnimation.animate()
                            .translationY(0);
                    isGone = false;
                } else {
                    isGone = true;
                    mLayoutAnimation.animate()
                            .translationY(-mLayoutAnimation.getHeight()*2)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
//                                    mLayoutAnimation.setVisibility(View.INVISIBLE);
                                }
                            });
                }
            }
        });
    }

}
