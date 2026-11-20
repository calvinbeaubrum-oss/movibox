package com.transsnet.downloader.config;

import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsnet.downloader.core.thread.DownloadExecutor;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.text.k;

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
public final class Config {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f60425a = "GET";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f60426b = 60000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f60427c = 60000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f60428d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f60429e = ((DownloadExecutor.f60487a.a() / 2) + 2) / this.f60428d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f60430f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f60431g = 5;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f60432h = LazyKt__LazyJVMKt.b(new Function0<Long>() { // from class: com.transsnet.downloader.config.Config$rangeSize$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Long invoke() {
            Long lN;
            ConfigBean configBeanB = ConfigManager.f53111c.a().b("downloadRangeSize", true);
            String value = configBeanB != null ? configBeanB.getValue() : null;
            long jLongValue = 5242880;
            if (value != null && value.length() != 0 && (lN = k.n(value)) != null) {
                jLongValue = lN.longValue();
            }
            return Long.valueOf(jLongValue);
        }
    });

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f60433i = -1;

    public final int a() {
        return this.f60428d;
    }

    public final int b() {
        return this.f60429e;
    }

    public final long c() {
        return ((Number) this.f60432h.getValue()).longValue();
    }

    public final int d() {
        return this.f60433i;
    }

    public final int e() {
        return this.f60431g;
    }

    public final int f() {
        return this.f60430f;
    }

    public final void g(int i11) {
        this.f60428d = i11;
    }
}
