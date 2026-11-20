package com.cloud.tmc.offline.download.thread;

import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class DownloadThreadFactory implements ThreadFactory {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f32063d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f32064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f32065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f32066c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DownloadThreadFactory(String name, boolean z11) {
        Intrinsics.g(name, "name");
        this.f32064a = name;
        this.f32065b = z11;
        this.f32066c = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<AtomicInteger>() { // from class: com.cloud.tmc.offline.download.thread.DownloadThreadFactory$atomicInteger$2
            @Override // kotlin.jvm.functions.Function0
            public final AtomicInteger invoke() {
                return new AtomicInteger();
            }
        });
    }

    public static final void c(Runnable runnable) {
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Exception e11) {
                if (AppDynamicBuildConfig.v()) {
                    TmcLogger.g("TmcOfflineDownload: DownLoadThreadFactory", "线程池中的某个线程发生了问题，请查看控制台或者日志文件！。", e11);
                }
            }
        }
    }

    public final AtomicInteger b() {
        return (AtomicInteger) this.f32066c.getValue();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        Thread thread = new Thread(new Runnable() { // from class: com.cloud.tmc.offline.download.thread.d
            @Override // java.lang.Runnable
            public final void run() {
                DownloadThreadFactory.c(runnable);
            }
        }, this.f32064a + '-' + b().getAndIncrement());
        thread.setDaemon(this.f32065b);
        return thread;
    }
}
