package alanyuan.playandroid.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.support.multidex.MultiDex;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.app.TinkerServerManager;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.DefaultApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;

import alanyuan.playandroid.BuildConfig;
import alanyuan.playandroid.MyLogImp;
import alanyuan.playandroid.util.TinkerManager;


/**
 * Created by alanyuan on 2016/12/21.
 */
@SuppressWarnings("unused")
@DefaultLifeCycle(
        application = "alanyuan.playandroid.PlayApplication", //application name to generate
        flags = ShareConstants.TINKER_ENABLE_ALL)
public class PlayApplicationLike extends DefaultApplicationLike {
    private static final String TAG = "PlayApplicationLike";

    public PlayApplicationLike(
            Application application,
            int tinkerFlags,
            boolean tinkerLoadVerifyFlag,
            long applicationStartElapsedTime,
            long applicationStartMillisTime,
            Intent tinkerResultIntent,
            Resources[] resources,
            ClassLoader[] classLoader,
            AssetManager[] assetManager
    ) {
        super(
                application,
                tinkerFlags,
                tinkerLoadVerifyFlag,
                applicationStartElapsedTime,
                applicationStartMillisTime,
                tinkerResultIntent,
                resources,
                classLoader,
                assetManager
        );
    }

    /**
     * install multiDex before install tinker
     * so we don't need to put the tinker lib classes in the main dex
     */
    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        MultiDex.install(base);
        PlayApplicationContext.context = getApplication();
        TinkerManager.setTinkerApplicationLike(this);
        TinkerManager.initFastCrashProtect();
        //should set before tinker is installed
        TinkerManager.setUpgradeRetryEnable(true);

        //optional set logIml, or you can use default debug log
        TinkerInstaller.setLogIml(new MyLogImp());

        //installTinker after load multiDex
        //or you can put com.tencent.tinker.** to main dex
        TinkerManager.installTinker(this);

        //初始化TinkerPatch SDK
        TinkerServerManager.installTinkerServer(
                getApplication(), Tinker.with(getApplication()), 3,
                BuildConfig.APP_KEY, BuildConfig.APP_VERSION, "default"
        );
        //开始检查是否有补丁，这里配置的是每隔访问3小时服务器是否有更新。
        TinkerServerManager.checkTinkerUpdate(false);
        //其他初始化，请避免这样的调用getApplication().getApplicationContext()
    }
}
