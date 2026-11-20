package com.transsion.baselib.config;

import android.app.Application;
import android.util.Log;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class CrashHandler implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f51014c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<CrashHandler> f51015d = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<CrashHandler>() { // from class: com.transsion.baselib.config.CrashHandler$Companion$INSTANCE$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CrashHandler invoke() {
            return new CrashHandler(null);
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f51016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Application f51017b;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CrashHandler a() {
            return (CrashHandler) CrashHandler.f51015d.getValue();
        }
    }

    public CrashHandler() {
    }

    public /* synthetic */ CrashHandler(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void c(Throwable th2) {
        j.d(l0.a(w0.b()), null, null, new CrashHandler$dumpExceptionsToSDCard$1(this, th2, null), 3, null);
    }

    public final void d(Application application) {
        this.f51017b = application;
        this.f51016a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable ex2) {
        String message;
        Intrinsics.g(thread, "thread");
        Intrinsics.g(ex2, "ex");
        c(ex2);
        if ((!(ex2 instanceof IOException) && !(ex2 instanceof ExecutionException)) || (message = ex2.getMessage()) == null || !StringsKt__StringsKt.Q(message, "Exception in CronetUrlRequest", false, 2, null)) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f51016a;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, ex2);
                return;
            }
            return;
        }
        Log.e("CrashHandler", "error uncaughtException --- " + ex2.getMessage());
    }
}
