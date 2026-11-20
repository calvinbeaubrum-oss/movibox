package com.cloud.sdk.commonutil.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f30292a = new i();

    public static final void d(Function0 runnable, Function1 callback) {
        Intrinsics.g(runnable, "$runnable");
        Intrinsics.g(callback, "$callback");
        try {
            callback.invoke(new g.b(runnable.invoke()));
        } catch (Throwable th2) {
            callback.invoke(new g.a(th2));
        }
    }

    public final void b(Runnable runnable) {
        Intrinsics.g(runnable, "runnable");
        d.a().b(runnable);
    }

    public final <T> void c(final Function0<? extends T> runnable, final Function1<? super g<? extends T>, Unit> callback) {
        Intrinsics.g(runnable, "runnable");
        Intrinsics.g(callback, "callback");
        d.a().b(new Runnable() { // from class: com.cloud.sdk.commonutil.util.h
            @Override // java.lang.Runnable
            public final void run() {
                i.d(runnable, callback);
            }
        });
    }

    public final void e(Runnable runnable) {
        Intrinsics.g(runnable, "runnable");
        t.a().b(runnable);
    }

    public final void f(Runnable runnable, long j11) {
        Intrinsics.g(runnable, "runnable");
        t.a().c(runnable, j11);
    }
}
