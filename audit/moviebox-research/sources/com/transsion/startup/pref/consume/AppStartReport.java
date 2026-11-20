package com.transsion.startup.pref.consume;

import android.app.ActivityManager;
import android.app.Application;
import android.util.Log;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.miniapp.bridge.BluetoothBridge;
import com.tn.lib.util.device.TNDeviceHelper;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baselib.report.o;
import com.transsnet.downloader.util.DownloadSDCardUtil;
import f00.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class AppStartReport {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f57975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f57976c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppStartReport f57974a = new AppStartReport();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, AppStartDotState> f57977d = new HashMap();

    public final void d(AppStartDotState dot) {
        Intrinsics.g(dot, "dot");
        if (f57975b) {
            return;
        }
        Map<String, AppStartDotState> map = f57977d;
        if (map.containsKey(dot.getState())) {
            return;
        }
        map.put(dot.getState(), dot);
        if (Intrinsics.b(dot.getState(), AppStartDotState.MAIN_CREATE)) {
            RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
            f57976c = roomAppMMKV.a().getBoolean("first_open", true);
            roomAppMMKV.a().putBoolean("first_open", false);
        } else if (Intrinsics.b(dot.getState(), AppStartDotState.TRENDING_END)) {
            g();
        }
    }

    public final Map<String, String> e() {
        long timestamp;
        long timestamp2;
        long timestamp3;
        try {
            Result.Companion companion = Result.Companion;
            HashMap map = new HashMap();
            Map<String, AppStartDotState> map2 = f57977d;
            AppStartDotState appStartDotState = map2.get(AppStartDotState.APP_START);
            AppStartDotState appStartDotState2 = map2.get(AppStartDotState.APP_END);
            AppStartDotState appStartDotState3 = map2.get(AppStartDotState.MAIN_CREATE);
            AppStartDotState appStartDotState4 = map2.get(AppStartDotState.TRENDING_END);
            if (appStartDotState3 != null) {
                timestamp = appStartDotState3.getTimestamp() - (appStartDotState2 != null ? appStartDotState2.getTimestamp() : appStartDotState3.getTimestamp());
            } else {
                timestamp = 0;
            }
            Object obj = ((appStartDotState2 != null ? appStartDotState2.getTimestamp() : 0L) <= 0 || timestamp > 10000 || timestamp <= 0) ? "warm" : "cold";
            if (Intrinsics.b(obj, "warm")) {
                if (appStartDotState4 != null) {
                    timestamp3 = appStartDotState4.getTimestamp() - (appStartDotState3 != null ? appStartDotState3.getTimestamp() : appStartDotState4.getTimestamp());
                } else {
                    timestamp3 = 0;
                }
                map.put("act_app_gap", "0");
            } else {
                if (appStartDotState4 != null) {
                    timestamp2 = appStartDotState4.getTimestamp() - (appStartDotState != null ? appStartDotState.getTimestamp() : appStartDotState4.getTimestamp());
                } else {
                    timestamp2 = 0;
                }
                map.put("act_app_gap", String.valueOf(timestamp));
                timestamp3 = timestamp2;
            }
            if (timestamp3 <= 0) {
                return null;
            }
            map.put("total_time", String.valueOf(timestamp3));
            map.put("type", o.f51281a.c());
            map.put("model", obj);
            TNDeviceHelper tNDeviceHelper = TNDeviceHelper.f49455a;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            ActivityManager.MemoryInfo memoryInfoJ = tNDeviceHelper.j(applicationA);
            map.put("mem_size", String.valueOf(memoryInfoJ.totalMem));
            map.put("low_memory", String.valueOf(memoryInfoJ.lowMemory));
            Iterator<T> it = DownloadSDCardUtil.f61130a.b().iterator();
            long jA = 0;
            while (it.hasNext()) {
                jA += ((e) it.next()).a();
            }
            map.put(BluetoothBridge.EXTEA_AVALIABLE, String.valueOf(jA));
            map.put("cpu_size", String.valueOf(Runtime.getRuntime().availableProcessors()));
            boolean z11 = f57976c;
            if (z11) {
                map.put("first_open", String.valueOf(z11));
            }
            AppStartReport$getResult$1$getTime$1 appStartReport$getResult$1$getTime$1 = new Function1<String, Long>() { // from class: com.transsion.startup.pref.consume.AppStartReport$getResult$1$getTime$1
                @Override // kotlin.jvm.functions.Function1
                public final Long invoke(String dot) {
                    Intrinsics.g(dot, "dot");
                    AppStartDotState appStartDotState5 = (AppStartDotState) AppStartReport.f57977d.get(dot);
                    return Long.valueOf(appStartDotState5 != null ? appStartDotState5.getTimestamp() : 0L);
                }
            };
            long timestamp4 = appStartDotState != null ? appStartDotState.getTimestamp() : 0L;
            map.put(AppStartDotState.APP_START, "0");
            map.put(AppStartDotState.APP_END, String.valueOf(appStartReport$getResult$1$getTime$1.invoke(AppStartDotState.APP_END).longValue() - timestamp4));
            map.put(AppStartDotState.SPLASH_START, String.valueOf(appStartReport$getResult$1$getTime$1.invoke(AppStartDotState.SPLASH_START).longValue() - timestamp4));
            map.put(AppStartDotState.SPLASH_RESUME, String.valueOf(appStartReport$getResult$1$getTime$1.invoke(AppStartDotState.SPLASH_RESUME).longValue() - timestamp4));
            map.put(AppStartDotState.AD_LOADING, String.valueOf(appStartReport$getResult$1$getTime$1.invoke(AppStartDotState.AD_LOADING).longValue() - timestamp4));
            map.put(AppStartDotState.AD_END, String.valueOf(appStartReport$getResult$1$getTime$1.invoke(AppStartDotState.AD_END).longValue() - timestamp4));
            map.put(AppStartDotState.AD_RENDERING, String.valueOf(appStartReport$getResult$1$getTime$1.invoke(AppStartDotState.AD_RENDERING).longValue() - timestamp4));
            map.put(AppStartDotState.MAIN_CREATE, String.valueOf(appStartReport$getResult$1$getTime$1.invoke(AppStartDotState.MAIN_CREATE).longValue() - timestamp4));
            map.put(AppStartDotState.TRENDING_CREATE, String.valueOf(appStartReport$getResult$1$getTime$1.invoke(AppStartDotState.TRENDING_CREATE).longValue() - timestamp4));
            map.put(AppStartDotState.TRENDING_RENDER, String.valueOf(appStartReport$getResult$1$getTime$1.invoke(AppStartDotState.TRENDING_RENDER).longValue() - timestamp4));
            map.put(AppStartDotState.TRENDING_END, String.valueOf(appStartReport$getResult$1$getTime$1.invoke(AppStartDotState.TRENDING_END).longValue() - timestamp4));
            return map;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            if (Result.m166exceptionOrNullimpl(Result.m163constructorimpl(ResultKt.a(th2))) == null) {
                throw new KotlinNothingValueException();
            }
            f57974a.f("error error error --- failed to obtain device information");
            return null;
        }
    }

    public final void f(String str) {
        Log.w("zxb_log_dot", str);
    }

    public final void g() {
        if (f57975b) {
            return;
        }
        j.d(l0.a(w0.b()), null, null, new AppStartReport$report$1(null), 3, null);
    }

    public final void h() {
        f57975b = false;
    }
}
