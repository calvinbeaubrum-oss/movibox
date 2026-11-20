package com.cloud.tmc.miniapp.defaultimpl;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.proxy.AnimtionProxy;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.miniapp.widget.LogoAnimationConfig;
import com.cloud.tmc.miniutils.util.e0;
import com.cloud.tmc.miniutils.util.k;
import hd.j;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import tc.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class AnimtionProxyImpl implements AnimtionProxy {
    public final String OooO00o = "AnimtionProxyImpl";
    public final Lazy OooO0O0 = LazyKt__LazyJVMKt.b(new OooO00o());

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o extends Lambda implements Function0<Integer> {
        public OooO00o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Integer invoke() {
            AnimtionProxyImpl animtionProxyImpl = AnimtionProxyImpl.this;
            Application applicationA = e0.a();
            Intrinsics.f(applicationA, "getApp()");
            return Integer.valueOf(AnimtionProxyImpl.access$getMemoryInfo(animtionProxyImpl, applicationA));
        }
    }

    public static final int access$getMemoryInfo(AnimtionProxyImpl animtionProxyImpl, Context context) {
        animtionProxyImpl.getClass();
        try {
            Object systemService = context.getSystemService("activity");
            Intrinsics.e(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
            float f11 = memoryInfo.totalMem / 1.0737418E9f;
            TmcLogger.c(animtionProxyImpl.OooO00o, "Current device memory size : " + f11 + " GB");
            return (int) Math.ceil(f11);
        } catch (Throwable th2) {
            TmcLogger.h(animtionProxyImpl.OooO00o, th2);
            return 0;
        }
    }

    public final int OooO00o() {
        return ((Number) this.OooO0O0.getValue()).intValue();
    }

    @Override // com.cloud.tmc.integration.proxy.AnimtionProxy
    public boolean enableAnimation() {
        return !isLowClient();
    }

    @Override // com.cloud.tmc.integration.proxy.AnimtionProxy
    public boolean enableLoadingAnimation() {
        try {
            LogoAnimationConfig logoAnimationConfig = (LogoAnimationConfig) k.f().fromJson(MiniAppConfigHelper.f30370a.e("miniLogoAnimateConfig", "{\"miniAnimateEnable\":true,\"loadingAnimMemorySize\":2}"), LogoAnimationConfig.class);
            return Intrinsics.b(logoAnimationConfig.getMiniAnimateEnable(), Boolean.TRUE) && OooO00o() >= logoAnimationConfig.getLoadingAnimMemorySize();
        } catch (Throwable th2) {
            TmcLogger.h(this.OooO00o, th2);
            return false;
        }
    }

    public final String getTAG() {
        return this.OooO00o;
    }

    @Override // com.cloud.tmc.integration.proxy.AnimtionProxy
    public boolean isLowClient() {
        int configInt = ((ConfigService) a.a(ConfigService.class)).getConfigInt("enableAnimMemorySize", 4);
        String str = this.OooO00o;
        StringBuilder sbA = j.a("Current device memory size format: ");
        sbA.append(OooO00o());
        sbA.append(" GB");
        TmcLogger.c(str, sbA.toString());
        return OooO00o() <= configInt;
    }
}
