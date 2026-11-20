package r6;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class k extends BroadcastReceiverConstraintTracker<p6.b> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConnectivityManager f75158g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Context context, t6.c taskExecutor) {
        super(context, taskExecutor);
        Intrinsics.g(context, "context");
        Intrinsics.g(taskExecutor, "taskExecutor");
        Object systemService = d().getSystemService("connectivity");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.f75158g = (ConnectivityManager) systemService;
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public IntentFilter j() {
        return new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public void k(Intent intent) {
        Intrinsics.g(intent, "intent");
        if (Intrinsics.b(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
            androidx.work.j.e().a(j.f75157a, "Network broadcast received");
            g(j.c(this.f75158g));
        }
    }

    @Override // r6.g
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public p6.b e() {
        return j.c(this.f75158g);
    }
}
