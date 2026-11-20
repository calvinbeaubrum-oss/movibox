package com.cloud.tmc.integration;

import android.app.Application;
import android.os.Build;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniutils.util.e0;
import com.tencent.mmkv.MMKV;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f30661a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static MMKV f30662b;

    public final MMKV a() {
        if (f30662b == null) {
            try {
                Application applicationA = e0.a();
                MMKV mmkvC = MMKV.C("zeroscreen_sp_file_nametrue", 2, null, (Build.VERSION.SDK_INT >= 24 ? applicationA.createDeviceProtectedStorageContext() : applicationA).getFilesDir().getAbsolutePath() + "/files/mmkv/" + applicationA.getPackageName());
                Intrinsics.f(mmkvC, "mmkvWithID(\n            …dir\n                    )");
                f30662b = mmkvC;
            } catch (Throwable th2) {
                TmcLogger.h("getLauncherMultiMMKV error", th2);
            }
        }
        MMKV mmkv = f30662b;
        if (mmkv != null) {
            return mmkv;
        }
        Intrinsics.y("multiMMKV");
        return null;
    }

    public final boolean b() {
        try {
            return a().getBoolean("zs_key_card_news_options_pop_show", false);
        } catch (Throwable unused) {
            return false;
        }
    }

    public final String c() {
        try {
            return a().getString("user_select_language", "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public final void d(boolean z11) {
        try {
            a().putBoolean("zs_key_card_news_options_pop_show", z11);
        } catch (Throwable th2) {
            TmcLogger.h("putSelectLanguage", th2);
        }
    }

    public final void e(String selectLanguage) {
        Intrinsics.g(selectLanguage, "selectLanguage");
        try {
            a().putString("user_select_language", selectLanguage);
        } catch (Throwable th2) {
            TmcLogger.h("putSelectLanguage", th2);
        }
    }
}
