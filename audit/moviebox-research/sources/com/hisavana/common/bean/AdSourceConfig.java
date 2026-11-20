package com.hisavana.common.bean;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class AdSourceConfig {
    public static Handler handler = null;
    public static boolean isUseMediaView = true;
    public int appIconId;
    public String appId;
    public int defaultMaterialMaxSize;
    public long defaultVersion;
    public boolean isDebug;
    public boolean isInitAlliance;
    public boolean isLite;
    public boolean testDevice;
    public boolean isInitAdMob = false;
    public String vidAppId = "";
    public boolean shouldOptimizeImageLoading = false;

    public void createHandler() {
        if (handler != null) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("loadad_handler_thread");
        handlerThread.start();
        handler = new Handler(handlerThread.getLooper());
    }
}
