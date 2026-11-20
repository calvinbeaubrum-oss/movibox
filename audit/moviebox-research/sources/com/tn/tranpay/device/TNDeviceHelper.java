package com.tn.tranpay.device;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.tencent.mmkv.MMKV;
import eq.b;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class TNDeviceHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TNDeviceHelper f50078a = new TNDeviceHelper();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f50079b = LazyKt__LazyJVMKt.b(new Function0<MMKV>() { // from class: com.tn.tranpay.device.TNDeviceHelper$tranMmkv$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MMKV invoke() {
            return MMKV.z("tran_v_show");
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f50080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f50081d;

    public final void a(Context context) {
        Intrinsics.g(context, "context");
        if (!(context instanceof Application)) {
            System.out.println((Object) "please pass in application to avoid Service not registered exception ");
            return;
        }
        String string = c().getString("sdk_ga_id", "");
        if (TextUtils.isEmpty(string)) {
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            b.f64343c.a(context, intent);
        } else {
            System.out.println((Object) ("gid has get gid " + string));
        }
    }

    public final String b() {
        if (TextUtils.isEmpty(f50081d)) {
            MMKV mmkvC = c();
            f50081d = mmkvC != null ? mmkvC.getString("sdk_device_id", "") : null;
        }
        String strValueOf = String.valueOf(f50081d);
        if (TextUtils.isEmpty(f50080c)) {
            MMKV mmkvC2 = c();
            f50080c = mmkvC2 != null ? mmkvC2.getString("sdk_android_id", "") : null;
        }
        String strValueOf2 = String.valueOf(f50080c);
        if (!TextUtils.isEmpty(strValueOf)) {
            return strValueOf;
        }
        if (!TextUtils.isEmpty(strValueOf2)) {
            String strA = a.f50082a.a(strValueOf2);
            e(strA);
            return strA;
        }
        Application applicationA = Utils.a();
        String string = Settings.System.getString(applicationA != null ? applicationA.getContentResolver() : null, "android_id");
        Intrinsics.f(string, "getString(\n            U…cure.ANDROID_ID\n        )");
        if (!TextUtils.isEmpty(string) && !Intrinsics.b(string, "9774d56d682e549c")) {
            String strA2 = a.f50082a.a(string);
            e(strA2);
            d(string);
            return strA2;
        }
        String string2 = UUID.randomUUID().toString();
        Intrinsics.f(string2, "randomUUID().toString()");
        String strA3 = a.f50082a.a(string2);
        e(strA3);
        return strA3;
    }

    public final MMKV c() {
        Object value = f50079b.getValue();
        Intrinsics.f(value, "<get-tranMmkv>(...)");
        return (MMKV) value;
    }

    public final void d(String androidId) {
        Intrinsics.g(androidId, "androidId");
        c().putString("sdk_android_id", androidId);
    }

    public final void e(String deviceId) {
        Intrinsics.g(deviceId, "deviceId");
        MMKV mmkvC = c();
        if (mmkvC != null) {
            mmkvC.putString("sdk_device_id", deviceId);
        }
    }

    public final void f(String gid) {
        Intrinsics.g(gid, "gid");
        c().putString("sdk_ga_id", gid);
    }
}
