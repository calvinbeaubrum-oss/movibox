package com.transsion.transfer.wifi.util;

import android.annotation.SuppressLint;
import android.net.wifi.WifiManager;
import android.os.PowerManager;
import com.blankj.utilcode.util.Utils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f59249a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WifiManager.WifiLock f59250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static PowerManager.WakeLock f59251c;

    @SuppressLint({"InvalidWakeLockTag"})
    public final void a() {
        PowerManager.WakeLock wakeLock;
        WifiManager.WifiLock wifiLock;
        try {
            if (f59250b == null) {
                Object systemService = Utils.a().getApplicationContext().getSystemService("wifi");
                Intrinsics.e(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
                f59250b = ((WifiManager) systemService).createWifiLock(3, "MB:Wifi-Connect");
            }
            if (f59251c == null) {
                Object systemService2 = Utils.a().getSystemService("power");
                Intrinsics.e(systemService2, "null cannot be cast to non-null type android.os.PowerManager");
                f59251c = ((PowerManager) systemService2).newWakeLock(1, "MB:Wifi-Connect");
            }
            WifiManager.WifiLock wifiLock2 = f59250b;
            if (wifiLock2 != null && !wifiLock2.isHeld() && (wifiLock = f59250b) != null) {
                wifiLock.acquire();
            }
            PowerManager.WakeLock wakeLock2 = f59251c;
            if (wakeLock2 == null || wakeLock2.isHeld() || (wakeLock = f59251c) == null) {
                return;
            }
            wakeLock.acquire(TTAdConstant.AD_MAX_EVENT_TIME);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final String b() {
        String simpleName = f.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final void c() {
        WifiManager.WifiLock wifiLock = f59250b;
        if (wifiLock != null && wifiLock.isHeld()) {
            WifiManager.WifiLock wifiLock2 = f59250b;
            if (wifiLock2 != null) {
                wifiLock2.release();
            }
            f59250b = null;
            g.b(g.f59252a, b() + " --> release() --> mWifiLock?.release() --> success", false, 2, null);
        }
        PowerManager.WakeLock wakeLock = f59251c;
        if (wakeLock == null || !wakeLock.isHeld()) {
            return;
        }
        PowerManager.WakeLock wakeLock2 = f59251c;
        if (wakeLock2 != null) {
            wakeLock2.release();
        }
        f59251c = null;
        g.b(g.f59252a, b() + " --> release() --> mWakeLock?.release() --> success", false, 2, null);
    }
}
