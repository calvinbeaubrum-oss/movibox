package com.cloud.tmc.miniapp.defaultimpl;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import com.cloud.tmc.kernel.service.EnvironmentService;
import com.cloud.tmc.kernel.utils.l;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniutils.util.a;
import com.cloud.tmc.miniutils.util.b;
import com.cloud.tmc.miniutils.util.q;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class EnvironmentServiceImpl implements EnvironmentService {
    @Override // com.cloud.tmc.kernel.service.EnvironmentService
    public String defaultPlatform() {
        return "TMC";
    }

    @Override // com.cloud.tmc.kernel.service.EnvironmentService
    public String getAppLanguage() {
        return q.a().getLanguage();
    }

    @Override // com.cloud.tmc.kernel.service.EnvironmentService
    public String getAppName() {
        String strA = b.a();
        Intrinsics.f(strA, "getAppName()");
        return strA;
    }

    @Override // com.cloud.tmc.kernel.service.EnvironmentService
    public Application getApplicationContext() {
        return ByteAppManager.getSApplication();
    }

    @Override // com.cloud.tmc.kernel.service.EnvironmentService
    public int getLpid() {
        return l.b();
    }

    @Override // com.cloud.tmc.kernel.service.EnvironmentService
    public String getProductVersion() {
        String strC = b.c();
        Intrinsics.f(strC, "getAppVersionName()");
        return strC;
    }

    @Override // com.cloud.tmc.kernel.service.EnvironmentService
    public Resources getResources() {
        Resources resources = getApplicationContext().getResources();
        Intrinsics.f(resources, "applicationContext.resources");
        return resources;
    }

    @Override // com.cloud.tmc.kernel.service.EnvironmentService
    public WeakReference<Activity> getTopActivity() {
        return new WeakReference<>(a.c());
    }
}
