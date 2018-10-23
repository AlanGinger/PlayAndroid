package alanyuan.playandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getName();
    private ImageButton mBtnLike;
    private TextView mTvMain;
    private Animation mBtnLikeAnim, mBtnLikeAnim2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setListener();
    }

    private void findViews() {
        mBtnLike = (ImageButton) findViewById(R.id.btn_like);
        mTvMain = (TextView) findViewById(R.id.tv_main);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM-dd", Locale.PRC);
        mTvMain.setText(dateFormat.format(new Date()));
//        mTvMain.setText("XXXXXXX");
    }

    private void setListener() {
        mBtnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadAnimation();
                mBtnLike.setImageResource(R.mipmap.icon_liked);
                mBtnLike.startAnimation(mBtnLikeAnim);
                checkTinkerUpdate();
            }
        });
    }

    private void loadAnimation() {
        mBtnLikeAnim = AnimationUtils.loadAnimation(this, R.anim.btn_like);
        mBtnLikeAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
//                mBtnLike.startAnimation(mBtnLikeAnim2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    /**
     * 检查Tinker有没有补丁更新
     */
    private void checkTinkerUpdate(){
        Log.d(TAG,"checkTinkerUpdate");
    }

    /**
     * 加载补丁
     */
    private void loadPatch() {
    }
}
