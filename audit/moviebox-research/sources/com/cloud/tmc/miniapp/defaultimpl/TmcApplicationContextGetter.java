package com.cloud.tmc.miniapp.defaultimpl;

import android.app.Application;
import android.content.Context;
import com.cloud.tmc.kernel.proxy.env.IApplicationContextGetter;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniutils.util.e0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class TmcApplicationContextGetter implements IApplicationContextGetter {
    @Override // com.cloud.tmc.kernel.proxy.env.IApplicationContextGetter
    public Application getApplication() {
        Application application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk();
        if (application$com_cloud_tmc_miniapp_sdk != null) {
            return application$com_cloud_tmc_miniapp_sdk;
        }
        Application applicationA = e0.a();
        Intrinsics.f(applicationA, "getApp()");
        return applicationA;
    }

    @Override // com.cloud.tmc.kernel.proxy.env.IApplicationContextGetter
    public Context getApplicationContext() {
        Context applicationContext = getApplication().getApplicationContext();
        Intrinsics.f(applicationContext, "application.applicationContext");
        return applicationContext;
    }
}
