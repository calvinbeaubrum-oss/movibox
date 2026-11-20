package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r6.e;
import r6.g;
import t6.c;

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
public abstract class BroadcastReceiverConstraintTracker<T> extends g<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BroadcastReceiver f13415f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BroadcastReceiverConstraintTracker(Context context, c taskExecutor) {
        super(context, taskExecutor);
        Intrinsics.g(context, "context");
        Intrinsics.g(taskExecutor, "taskExecutor");
        this.f13415f = new BroadcastReceiver(this) { // from class: androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker$broadcastReceiver$1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ BroadcastReceiverConstraintTracker<T> f13416a;

            {
                this.f13416a = this;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Intrinsics.g(context2, "context");
                Intrinsics.g(intent, "intent");
                this.f13416a.k(intent);
            }
        };
    }

    @Override // r6.g
    public void h() {
        j.e().a(e.f75145a, getClass().getSimpleName() + ": registering receiver");
        d().registerReceiver(this.f13415f, j());
    }

    @Override // r6.g
    public void i() {
        j.e().a(e.f75145a, getClass().getSimpleName() + ": unregistering receiver");
        d().unregisterReceiver(this.f13415f);
    }

    public abstract IntentFilter j();

    public abstract void k(Intent intent);
}
