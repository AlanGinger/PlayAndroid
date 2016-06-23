package alanyuan.playandroid;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by alanyuan on 16/6/20.
 */
public abstract class BaseMvpActivity<V, T extends BasePresenter<V>> extends Activity {

    public T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attach((V) this);
    }

    @Override
    protected void onDestroy() {
        presenter.dettach();
        super.onDestroy();
    }

    // 实例化presenter
    public abstract T initPresenter();

}