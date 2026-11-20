package com.cloud.tupdate.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f32222a = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static AtomicInteger f32223b = new AtomicInteger();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f32224c = LazyKt__LazyJVMKt.b(ExecutorUtils$ioE$2.INSTANCE);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static AtomicInteger f32225d = new AtomicInteger();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f32226e = LazyKt__LazyJVMKt.b(ExecutorUtils$computationE$2.INSTANCE);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static AtomicInteger f32227f = new AtomicInteger();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f32228g = LazyKt__LazyJVMKt.b(ExecutorUtils$newE$2.INSTANCE);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f32229h = LazyKt__LazyJVMKt.b(ExecutorUtils$singleE$2.INSTANCE);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static AtomicInteger f32230i = new AtomicInteger();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f32231j = LazyKt__LazyJVMKt.b(ExecutorUtils$scheduledE$2.INSTANCE);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy f32232k = LazyKt__LazyJVMKt.b(new Function0<ExecutorUtils$mainE$2.a>() { // from class: com.cloud.tupdate.utils.ExecutorUtils$mainE$2

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a extends AbstractExecutorService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Handler f32233a = new Handler(Looper.getMainLooper());

            public Void a() throws UnsupportedOperationException {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.concurrent.ExecutorService
            public boolean awaitTermination(long j11, TimeUnit unit) {
                Intrinsics.g(unit, "unit");
                return false;
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable command) {
                Intrinsics.g(command, "command");
                this.f32233a.post(command);
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
            public /* bridge */ /* synthetic */ void shutdown() {
                a();
                throw new KotlinNothingValueException();
            }

            @Override // java.util.concurrent.ExecutorService
            public List<Runnable> shutdownNow() throws UnsupportedOperationException {
                throw new UnsupportedOperationException();
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return new a();
        }
    });

    public static final ExecutorService f() {
        return (ExecutorService) f32224c.getValue();
    }

    public static final ExecutorService g() {
        return (ExecutorService) f32232k.getValue();
    }

    public static final ExecutorService h() {
        return f();
    }

    public static final ExecutorService i() {
        return g();
    }
}
