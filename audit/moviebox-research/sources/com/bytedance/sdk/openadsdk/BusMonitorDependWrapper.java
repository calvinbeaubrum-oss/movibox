package com.bytedance.sdk.openadsdk;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.sdk.openadsdk.dE.pFF;
import com.bytedance.sdk.openadsdk.dE.pFF.sc;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class BusMonitorDependWrapper implements pFF {
    private Handler pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private pFF f27063sc;

    public BusMonitorDependWrapper(pFF pff) {
        this.f27063sc = pff;
    }

    public static Context getReflectContext() {
        try {
            Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, new Object[0]);
            return (Application) objInvoke.getClass().getMethod("getApplication", new Class[0]).invoke(objInvoke, new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.dE.pFF
    public Context getContext() {
        pFF pff = this.f27063sc;
        return (pff == null || pff.getContext() == null) ? getReflectContext() : this.f27063sc.getContext();
    }

    @Override // com.bytedance.sdk.openadsdk.dE.pFF
    public Handler getHandler() {
        pFF pff = this.f27063sc;
        if (pff != null && pff.getHandler() != null) {
            return this.f27063sc.getHandler();
        }
        if (this.pFF == null) {
            HandlerThread handlerThread = new HandlerThread("pag_monitor");
            handlerThread.start();
            this.pFF = new Handler(handlerThread.getLooper());
        }
        return this.pFF;
    }

    @Override // com.bytedance.sdk.openadsdk.dE.pFF
    public int getOnceLogCount() {
        pFF pff = this.f27063sc;
        if (pff != null) {
            return pff.getOnceLogCount();
        }
        return 20;
    }

    @Override // com.bytedance.sdk.openadsdk.dE.pFF
    public int getOnceLogInterval() {
        pFF pff = this.f27063sc;
        if (pff != null) {
            return pff.getOnceLogInterval();
        }
        return 1000;
    }

    @Override // com.bytedance.sdk.openadsdk.dE.pFF
    public int getUploadIntervalTime() {
        int uploadIntervalTime;
        pFF pff = this.f27063sc;
        if (pff == null || (uploadIntervalTime = pff.getUploadIntervalTime()) < 1800000) {
            return 1800000;
        }
        return uploadIntervalTime;
    }

    @Override // com.bytedance.sdk.openadsdk.dE.pFF
    public boolean isMonitorOpen() {
        pFF pff = this.f27063sc;
        if (pff != null) {
            return pff.isMonitorOpen();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.dE.pFF
    public void onMonitorUpload(List<sc> list) {
        pFF pff = this.f27063sc;
        if (pff != null) {
            pff.onMonitorUpload(list);
        }
    }
}
