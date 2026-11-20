package com.transsion.startup.work;

import android.content.Context;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.WorkManager;
import androidx.work.b;
import androidx.work.m;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;

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
@SourceDebugExtension
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f57979a = new a();

    public final void a(Context context) {
        String value;
        Boolean boolY0;
        Intrinsics.g(context, "context");
        ConfigBean configBeanC = ConfigManager.c(ConfigManager.f53111c.a(), "key_report_request_off", false, 2, null);
        if (configBeanC == null || (value = configBeanC.getValue()) == null || (boolY0 = StringsKt__StringsKt.Y0(value)) == null || !boolY0.booleanValue()) {
            b bVarA = new b.a().b(NetworkType.CONNECTED).a();
            TimeUnit timeUnit = TimeUnit.HOURS;
            WorkManager.g(context).f("NetworkDataSourceWorker", ExistingPeriodicWorkPolicy.REPLACE, new m.a(NetworkDataSourceWorker.class, 1L, timeUnit).i(bVarA).a("NetworkDataSourceWorker").k(1L, timeUnit).b());
        }
    }
}
