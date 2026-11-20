package com.tn.tranpay;

import android.app.Application;
import com.tencent.mmkv.MMKV;
import com.tn.tranpay.logger.LogLevel;
import com.tn.tranpay.logger.LoggerPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class TranPay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TranPay f50043a = new TranPay();

    public final void a(LoggerPlugin plugin) {
        Intrinsics.g(plugin, "plugin");
        fq.a.f65215a.a(plugin);
    }

    public final void b(Application application, String cpId, String appKey, String channel, LogLevel level, boolean z11, boolean z12, String str, e theme) {
        Intrinsics.g(application, "application");
        Intrinsics.g(cpId, "cpId");
        Intrinsics.g(appKey, "appKey");
        Intrinsics.g(channel, "channel");
        Intrinsics.g(level, "level");
        Intrinsics.g(theme, "theme");
        MMKV.t(application);
        TranPayConfiguration tranPayConfiguration = TranPayConfiguration.f50046a;
        tranPayConfiguration.t(cpId);
        tranPayConfiguration.r(appKey);
        tranPayConfiguration.s(channel);
        tranPayConfiguration.x(str);
        tranPayConfiguration.u(z11);
        tranPayConfiguration.w(z12);
        e.f50084c.a(theme);
        fq.a aVar = fq.a.f65215a;
        aVar.h(level, z11);
        com.tn.tranpay.event.a.f50094a.b(application);
        j.d(l0.a(w0.b()), null, null, new TranPay$configure$1(application, z11, str, null), 3, null);
        fq.a.g(aVar, "TranPay init succeed " + cpId + ", " + level + ", " + z11 + ", " + str, null, 2, null);
        tranPayConfiguration.v(true);
    }

    public final String d() {
        return "1.0.3";
    }
}
