package com.cloud.tupdate.net.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
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
public final class ThreadPoolUtil {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f32218b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ExecutorService f32219a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ThreadPoolUtil a() {
            return ThreadPoolUtilsHolder.f32220a.a();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class ThreadPoolUtilsHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ThreadPoolUtilsHolder f32220a = new ThreadPoolUtilsHolder();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final ThreadPoolUtil f32221b = new ThreadPoolUtil(null);

        private ThreadPoolUtilsHolder() {
        }

        public final ThreadPoolUtil a() {
            return f32221b;
        }
    }

    private ThreadPoolUtil() {
        b();
    }

    public /* synthetic */ ThreadPoolUtil(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void a(Runnable runnable) {
        ExecutorService executorService;
        try {
            ExecutorService executorService2 = this.f32219a;
            Boolean boolValueOf = executorService2 == null ? null : Boolean.valueOf(executorService2.isShutdown());
            Intrinsics.d(boolValueOf);
            if (!boolValueOf.booleanValue() && (executorService = this.f32219a) != null) {
                executorService.execute(runnable);
            }
        } catch (RejectedExecutionException e11) {
            LogUtil.f32213a.d(e11);
        }
    }

    public final void b() {
        if (this.f32219a == null) {
            this.f32219a = Executors.newCachedThreadPool();
        }
    }
}
