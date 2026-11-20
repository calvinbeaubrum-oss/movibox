package com.cloud.hisavana.sdk;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
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
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y0 f30225a = new y0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicLong f30226b = new AtomicLong(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<Long, r3> f30227c = new ConcurrentHashMap<>();

    public final long a() {
        return f30226b.incrementAndGet();
    }

    public final long b(r3 observer) {
        Intrinsics.g(observer, "observer");
        long jA = a();
        if (z.b()) {
            z.a().d("Rewarded", "registerObserver " + jA);
        }
        f30227c.put(Long.valueOf(jA), observer);
        return jA;
    }

    public final void c(long j11) {
        if (z.b()) {
            z.a().d("Rewarded", "unregisterObserver " + j11);
        }
        try {
            f30227c.remove(Long.valueOf(j11));
        } catch (Exception e11) {
            z.a().w("Rewarded", "Failed to unregister observer: " + e11.getMessage(), e11);
        }
    }

    public final void d(long j11, String event, Object obj) {
        Intrinsics.g(event, "event");
        if (z.b()) {
            z.a().d("Rewarded", "broadcast " + j11 + ", " + event);
        }
        try {
            r3 r3Var = f30227c.get(Long.valueOf(j11));
            if (r3Var != null) {
                r3Var.a(j11, event, obj);
            }
        } catch (Exception e11) {
            z.a().e("Rewarded", "Error in observer.onEvent: " + e11.getMessage());
        }
    }
}
