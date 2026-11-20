package com.cloud.tmc.integration.performance.innerworker;

import android.content.Context;
import com.cloud.tmc.integration.point.WarmupPoint;
import com.cloud.tmc.integration.structure.WarmupNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import lb.f;

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
public final class InnerWorkerWarmupManager {
    public final void a(Context context, int i11) {
        Intrinsics.g(context, "context");
        ((WarmupPoint) ib.a.b(WarmupPoint.class).d()).start(context, i11);
    }

    public final void b(gd.b worker, f fVar, nb.a warmUpCallback, a aVar) {
        Intrinsics.g(worker, "worker");
        Intrinsics.g(warmUpCallback, "warmUpCallback");
        worker.setFrameworkVersion(fVar != null ? fVar.a() : null);
        WarmupNode warmupNode = (WarmupNode) tc.a.a(WarmupNode.class);
        String workerId = worker.getWorkerId();
        Intrinsics.f(workerId, "worker.workerId");
        j.d(l0.a(w0.b()), null, null, new InnerWorkerWarmupManager$warmup$1(worker, warmupNode.getNode(workerId), aVar, warmUpCallback, null), 3, null);
    }
}
