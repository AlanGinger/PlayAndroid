package alanyuan.playandroid;

/**
 * Created by alanyuan on 16/6/20.
 */
public abstract class BasePresenter<T> {

    public T mView;

    public void attach(T mView) {
        this.mView = mView;
    }

    public void dettach() {
        mView = null;
    }
}
