package com.cloud.tmc.component_api_ps.async;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ma.a;
import ma.b;

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
public final class MiniAppIpcAsyncManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MiniAppIpcAsyncManager f30347a = new MiniAppIpcAsyncManager();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f30348b = LazyKt__LazyJVMKt.b(new Function0<ThreadPoolExecutor>() { // from class: com.cloud.tmc.component_api_ps.async.MiniAppIpcAsyncManager$threadPoolExecutor$2
        @Override // kotlin.jvm.functions.Function0
        public final ThreadPoolExecutor invoke() {
            return new ThreadPoolExecutor(3, 5, 120L, a.f70937a.a(), new LinkedBlockingQueue(200), new ka.a(), new b());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f30349c = LazyKt__LazyJVMKt.b(new Function0<Handler>() { // from class: com.cloud.tmc.component_api_ps.async.MiniAppIpcAsyncManager$mainHandler$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    public final boolean a() {
        return Intrinsics.b(Looper.myLooper(), Looper.getMainLooper());
    }

    public final Handler b() {
        return (Handler) f30349c.getValue();
    }

    public final ThreadPoolExecutor c() {
        return (ThreadPoolExecutor) f30348b.getValue();
    }

    public final void d(Runnable runnable) {
        Intrinsics.g(runnable, "runnable");
        if (a()) {
            c().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public final void e(Runnable runnable) {
        Intrinsics.g(runnable, "runnable");
        if (a()) {
            runnable.run();
        } else {
            b().post(runnable);
        }
    }

    public final void f(Runnable runnable, long j11) {
        Intrinsics.g(runnable, "runnable");
        b().postDelayed(runnable, j11);
    }
}
