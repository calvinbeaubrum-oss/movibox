package com.transsion.ad.ps;

import android.os.SystemClock;
import com.transsion.ad.db.plan.MbAdDbPlans;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PsAdPlanRetryManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PsAdPlanRetryManager f50551a = new PsAdPlanRetryManager();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f50552b;

    public final String a() {
        String simpleName = PsAdPlanRetryManager.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final void b(MbAdDbPlans mbAdDbPlans) {
        if (SystemClock.elapsedRealtime() - f50552b < wq.b.f79582a.e()) {
            return;
        }
        f50552b = SystemClock.elapsedRealtime();
        com.transsion.ad.a.d(com.transsion.ad.a.f50276a, a() + " --> retry() --> PS 直投的虚拟计划 --> 无商单重试 --> 请求PS商单接口", false, 2, null);
        j.d(l0.a(w0.b()), null, null, new PsAdPlanRetryManager$retry$1(mbAdDbPlans, null), 3, null);
    }
}
