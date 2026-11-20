package com.transsnet.downloader.util;

import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f61157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f61158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f61159e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f61160f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f61155a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f61156b = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f61161g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Long> f61162h = new ConcurrentHashMap<>();

    public final Map<String, Long> a() {
        if (f61158d) {
            c(PrepareException.ERROR_NO_URL);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ConcurrentHashMap<String, Long> concurrentHashMap = f61162h;
        linkedHashMap.putAll(concurrentHashMap);
        concurrentHashMap.clear();
        f61159e = false;
        f61160f = false;
        return linkedHashMap;
    }

    public final void b(String step) {
        Intrinsics.g(step, "step");
        if (f61158d && !Intrinsics.b(f61161g, step)) {
            if (Intrinsics.b(step, "4")) {
                if (f61159e) {
                    return;
                } else {
                    f61159e = true;
                }
            }
            if (Intrinsics.b(step, "3")) {
                if (f61160f) {
                    return;
                } else {
                    f61160f = true;
                }
            }
            f61161g = step;
            uo.b.a.f(uo.b.f78622a, "DownloadProxyLog", "logPoint, step = " + step, false, 4, null);
            long jCurrentTimeMillis = System.currentTimeMillis();
            f61162h.put("delay_step_" + f61156b + "_" + step, Long.valueOf(jCurrentTimeMillis - f61157c));
            f61156b = step;
            f61157c = jCurrentTimeMillis;
        }
    }

    public final void c(String step) {
        Intrinsics.g(step, "step");
        uo.b.a.s(uo.b.f78622a, "DownloadProxyLog", "onFinish, step = " + step, false, 4, null);
        b(step);
        f61158d = false;
        f61157c = 0L;
    }

    public final void d(String step) {
        Intrinsics.g(step, "step");
        uo.b.a.s(uo.b.f78622a, "DownloadProxyLog", "onStart, step = " + step, false, 4, null);
        f61158d = true;
        f61156b = step;
        f61157c = System.currentTimeMillis();
        f61162h.clear();
    }
}
