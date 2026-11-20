package com.cloud.tmc.miniapp.defaultimpl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.cloud.tmc.integration.proxy.StartActivityProxy;
import com.cloud.tmc.miniapp.NewTaskManager;
import com.cloud.tmc.miniapp.ui.MiniSchemaFilterActivity;
import com.cloud.tmc.miniapp.ui.WebViewActivity;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class DefaultLauncherMiniActivityProxy implements StartActivityProxy {
    @Override // com.cloud.tmc.integration.proxy.StartActivityProxy
    public Boolean checkFeedBackApp(String str) {
        return Boolean.valueOf(NewTaskManager.f31301b.getInstance().j(str));
    }

    @Override // com.cloud.tmc.integration.proxy.StartActivityProxy
    public Boolean checkOpenMutipleTask(String str) {
        return Boolean.valueOf(NewTaskManager.f31301b.getInstance().h(str));
    }

    @Override // com.cloud.tmc.integration.proxy.StartActivityProxy
    public Class<?> getLauncherShortCutActivity() {
        return MiniSchemaFilterActivity.class;
    }

    @Override // com.cloud.tmc.integration.proxy.StartActivityProxy
    public Class<?> getWebViewActivity() {
        return WebViewActivity.class;
    }

    @Override // com.cloud.tmc.integration.proxy.StartActivityProxy
    public void launchMiniApp(Context context, String url) {
        Intrinsics.g(context, "context");
        Intrinsics.g(url, "url");
        MiniAppLaunch.c0(MiniAppLaunch.f31784a, context, url, null, 4, null);
    }

    @Override // com.cloud.tmc.integration.proxy.StartActivityProxy
    public void launchMiniAppForId(Context context, String appId) {
        Intrinsics.g(context, "context");
        Intrinsics.g(appId, "appId");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.f(applicationContext, "context.applicationContext");
        MiniAppLaunch.d0(applicationContext, appId, new Bundle());
    }

    @Override // com.cloud.tmc.integration.proxy.StartActivityProxy
    public void removeMiniAppTask(String str, Activity activity) {
        NewTaskManager.Companion companion = NewTaskManager.f31301b;
        if (!companion.getInstance().h(str)) {
            if (activity != null) {
                activity.finishAndRemoveTask();
            }
        } else if (str != null) {
            companion.getInstance().H(str, true);
            if (!companion.getInstance().f(str) || activity == null) {
                return;
            }
            activity.finish();
        }
    }

    @Override // com.cloud.tmc.integration.proxy.StartActivityProxy
    public void removeMiniAppTaskByRecent(String str) {
        try {
            NewTaskManager.Companion companion = NewTaskManager.f31301b;
            if (!companion.getInstance().h(str) || str == null) {
                return;
            }
            companion.getInstance().E(str);
        } catch (Throwable unused) {
        }
    }

    @Override // com.cloud.tmc.integration.proxy.StartActivityProxy
    public void updateTaskRootId(String str) {
        if (str != null) {
            NewTaskManager.f31301b.getInstance().K(str);
        }
    }
}
