package com.cloud.config.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@JvmName
public final class ExecutorUtils {
    private static final int CPU_CORE = Runtime.getRuntime().availableProcessors();
    private static AtomicInteger ioA = new AtomicInteger();
    private static final Lazy ioE$delegate = LazyKt__LazyJVMKt.b(ExecutorUtils$ioE$2.INSTANCE);
    private static AtomicInteger computationA = new AtomicInteger();
    private static final Lazy computationE$delegate = LazyKt__LazyJVMKt.b(ExecutorUtils$computationE$2.INSTANCE);
    private static AtomicInteger newA = new AtomicInteger();
    private static final Lazy newE$delegate = LazyKt__LazyJVMKt.b(ExecutorUtils$newE$2.INSTANCE);
    private static final Lazy singleE$delegate = LazyKt__LazyJVMKt.b(ExecutorUtils$singleE$2.INSTANCE);
    private static AtomicInteger scheduledA = new AtomicInteger();
    private static final Lazy scheduledE$delegate = LazyKt__LazyJVMKt.b(ExecutorUtils$scheduledE$2.INSTANCE);
    private static final Lazy mainE$delegate = LazyKt__LazyJVMKt.b(new Function0<ExecutorUtils$mainE$2.AnonymousClass1>() { // from class: com.cloud.config.utils.ExecutorUtils$mainE$2
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.cloud.config.utils.ExecutorUtils$mainE$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            return new AbstractExecutorService() { // from class: com.cloud.config.utils.ExecutorUtils$mainE$2.1
                private final Handler handler = new Handler(Looper.getMainLooper());

                @Override // java.util.concurrent.ExecutorService
                public boolean awaitTermination(long j11, TimeUnit unit) {
                    Intrinsics.g(unit, "unit");
                    return false;
                }

                @Override // java.util.concurrent.Executor
                public void execute(Runnable command) {
                    Intrinsics.g(command, "command");
                    this.handler.post(command);
                }

                public final Handler getHandler() {
                    return this.handler;
                }

                @Override // java.util.concurrent.ExecutorService
                public boolean isShutdown() {
                    return false;
                }

                @Override // java.util.concurrent.ExecutorService
                public boolean isTerminated() {
                    return false;
                }

                @Override // java.util.concurrent.ExecutorService
                public Void shutdown() throws UnsupportedOperationException {
                    throw new UnsupportedOperationException();
                }

                @Override // java.util.concurrent.ExecutorService
                public /* bridge */ /* synthetic */ void shutdown() {
                    shutdown();
                    throw new KotlinNothingValueException();
                }

                @Override // java.util.concurrent.ExecutorService
                public List<Runnable> shutdownNow() throws UnsupportedOperationException {
                    throw new UnsupportedOperationException();
                }
            };
        }
    });

    public static final ExecutorService computation() {
        return getComputationE();
    }

    private static final ExecutorService getComputationE() {
        return (ExecutorService) computationE$delegate.getValue();
    }

    private static final ExecutorService getIoE() {
        return (ExecutorService) ioE$delegate.getValue();
    }

    private static final ExecutorService getMainE() {
        return (ExecutorService) mainE$delegate.getValue();
    }

    private static final ExecutorService getNewE() {
        return (ExecutorService) newE$delegate.getValue();
    }

    private static final ScheduledExecutorService getScheduledE() {
        return (ScheduledExecutorService) scheduledE$delegate.getValue();
    }

    private static final ExecutorService getSingleE() {
        return (ExecutorService) singleE$delegate.getValue();
    }

    public static final ExecutorService io() {
        return getIoE();
    }

    public static final ExecutorService main() {
        return getMainE();
    }

    /* JADX INFO: renamed from: new, reason: not valid java name */
    public static final ExecutorService m106new() {
        return getNewE();
    }

    public static final ScheduledExecutorService scheduled() {
        return getScheduledE();
    }

    public static final ExecutorService single() {
        return getSingleE();
    }
}
