package com.transsion.search.speech;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.hisavana.common.tracking.TrackingKey;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.collections.s;
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
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f57684a = new m();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f57685b;

    public final void a() {
        com.transsion.baselib.helper.a.f51183a.b("sr_dialog_cancel_btn", s.h());
    }

    public final void b() {
        com.transsion.baselib.helper.a.f51183a.b("sr_mic_btn", s.h());
    }

    public final void c(String msg, int i11) {
        Intrinsics.g(msg, "msg");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "fail");
        linkedHashMap.put(NotificationCompat.CATEGORY_MESSAGE, msg);
        linkedHashMap.put(TrackingKey.CODE, String.valueOf(i11));
        linkedHashMap.put(TrackingKey.TRIGGER_ID, String.valueOf(f57685b));
        com.transsion.baselib.helper.a.f51183a.a("sr_dialog_sr", linkedHashMap);
        f57685b = null;
    }

    public final void d() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "trigger");
        String strA = b.f57671a.a(10);
        f57685b = strA;
        linkedHashMap.put(TrackingKey.TRIGGER_ID, String.valueOf(strA));
        com.transsion.baselib.helper.a.f51183a.a("sr_dialog_sr", linkedHashMap);
    }

    public final void e() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "success");
        linkedHashMap.put(TrackingKey.TRIGGER_ID, String.valueOf(f57685b));
        com.transsion.baselib.helper.a.f51183a.a("sr_dialog_sr", linkedHashMap);
        f57685b = null;
    }

    public final void f() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "strategy");
        linkedHashMap.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, "two");
        String strA = com.blankj.utilcode.util.j.a();
        Intrinsics.f(strA, "getModel()");
        linkedHashMap.put("model", strA);
        com.transsion.baselib.helper.a.f51183a.b("sr_dialog_sr", s.h());
    }
}
