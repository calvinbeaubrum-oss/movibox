package com.tn.lib.util.device;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mmkv.MMKV;
import com.tn.lib.util.a;
import java.util.Locale;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.c;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.l;
import uo.b;

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
public final class TNDeviceHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TNDeviceHelper f49455a = new TNDeviceHelper();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f49456b = LazyKt__LazyJVMKt.b(new Function0<MMKV>() { // from class: com.tn.lib.util.device.TNDeviceHelper$netMmkv$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MMKV invoke() {
            return MMKV.z("vshow");
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f49457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f49458d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f49459e;

    public final void a(Context context) {
        Intrinsics.g(context, "context");
        if (!(context instanceof Application)) {
            b.a.f(b.f78622a, "DeviceHelper", "please pass in application to avoid Service not registered exception ", false, 4, null);
            return;
        }
        MMKV mmkvL = l();
        String string = mmkvL != null ? mmkvL.getString("apkgaid", "") : null;
        if (TextUtils.isEmpty(string)) {
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            op.b.f72507c.a(context, intent);
        } else {
            b.a.f(b.f78622a, "DeviceHelper", "gid has get gid " + string, false, 4, null);
        }
    }

    public final String b() {
        if (TextUtils.isEmpty(f49457c)) {
            MMKV mmkvL = l();
            f49457c = mmkvL != null ? mmkvL.getString("apkandroidid", "") : null;
        }
        String string = f49457c;
        if (TextUtils.isEmpty(string)) {
            Application applicationA = a.f49452a.a();
            string = Settings.System.getString(applicationA != null ? applicationA.getContentResolver() : null, "android_id");
        }
        return string == null ? "" : string;
    }

    public final String c() {
        String BRAND = Build.BRAND;
        Intrinsics.f(BRAND, "BRAND");
        return BRAND;
    }

    public final String d() {
        return l.F(l.F(c.c(Build.SUPPORTED_ABIS), "[", "", false, 4, null), "]", "", false, 4, null);
    }

    public final String e() {
        String country = Locale.getDefault().getCountry();
        Intrinsics.f(country, "currentLocale.country");
        return country;
    }

    public final String f() {
        Application applicationA = a.f49452a.a();
        Object systemService = applicationA != null ? applicationA.getSystemService("phone") : null;
        TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
        String simCountryIso = telephonyManager != null ? telephonyManager.getSimCountryIso() : null;
        if (simCountryIso == null || simCountryIso.length() == 0) {
            if (telephonyManager != null) {
                return telephonyManager.getNetworkCountryIso();
            }
            return null;
        }
        if (telephonyManager != null) {
            return telephonyManager.getSimCountryIso();
        }
        return null;
    }

    public final String g() {
        if (TextUtils.isEmpty(f49459e)) {
            MMKV mmkvL = l();
            f49459e = mmkvL != null ? mmkvL.getString("apkdeviceid", "") : null;
        }
        String strValueOf = String.valueOf(f49459e);
        if (TextUtils.isEmpty(f49457c)) {
            MMKV mmkvL2 = l();
            f49457c = mmkvL2 != null ? mmkvL2.getString("apkandroidid", "") : null;
        }
        String strValueOf2 = String.valueOf(f49457c);
        if (!TextUtils.isEmpty(strValueOf)) {
            return strValueOf;
        }
        if (!TextUtils.isEmpty(strValueOf2)) {
            String strD = qp.a.f74869a.d(strValueOf2);
            p(strD);
            return strD;
        }
        Application applicationA = a.f49452a.a();
        String string = Settings.System.getString(applicationA != null ? applicationA.getContentResolver() : null, "android_id");
        Intrinsics.f(string, "getString(\n            U…cure.ANDROID_ID\n        )");
        if (!TextUtils.isEmpty(string) && !Intrinsics.b(string, "9774d56d682e549c")) {
            String strD2 = qp.a.f74869a.d(string);
            p(strD2);
            o(string);
            return strD2;
        }
        String string2 = UUID.randomUUID().toString();
        Intrinsics.f(string2, "randomUUID().toString()");
        String strD3 = qp.a.f74869a.d(string2);
        p(strD3);
        return strD3;
    }

    public final String h() {
        if (TextUtils.isEmpty(f49458d)) {
            MMKV mmkvL = l();
            f49458d = mmkvL != null ? mmkvL.getString("apkgaid", "") : null;
        }
        String strValueOf = String.valueOf(f49458d);
        if (!TextUtils.isEmpty(strValueOf)) {
            return strValueOf;
        }
        String strB = b();
        if (!TextUtils.isEmpty(strB)) {
            return strB;
        }
        String string = UUID.randomUUID().toString();
        Intrinsics.f(string, "randomUUID().toString()");
        return string;
    }

    public final String i() {
        String currentLanguage = Locale.getDefault().getLanguage();
        Intrinsics.f(currentLanguage, "currentLanguage");
        return currentLanguage;
    }

    public final ActivityManager.MemoryInfo j(Context context) {
        Intrinsics.g(context, "context");
        Object systemService = context.getSystemService("activity");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    public final String k() {
        String MODEL = Build.MODEL;
        Intrinsics.f(MODEL, "MODEL");
        return MODEL;
    }

    public final MMKV l() {
        return (MMKV) f49456b.getValue();
    }

    public final String m() {
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.f(RELEASE, "RELEASE");
        return RELEASE;
    }

    public final String n() {
        Application applicationA = a.f49452a.a();
        Object systemService = applicationA != null ? applicationA.getSystemService("phone") : null;
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        String simOperator = ((TelephonyManager) systemService).getSimOperator();
        Intrinsics.f(simOperator, "tm.simOperator");
        return simOperator;
    }

    public final void o(String androidId) {
        Intrinsics.g(androidId, "androidId");
        MMKV mmkvL = l();
        if (mmkvL != null) {
            mmkvL.putString("apkandroidid", androidId);
        }
    }

    public final void p(String deviceId) {
        Intrinsics.g(deviceId, "deviceId");
        MMKV mmkvL = l();
        if (mmkvL != null) {
            mmkvL.putString("apkdeviceid", deviceId);
        }
    }

    public final void q(String gid) {
        Intrinsics.g(gid, "gid");
        MMKV mmkvL = l();
        if (mmkvL != null) {
            mmkvL.putString("apkgaid", gid);
        }
    }
}
