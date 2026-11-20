package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.q1;

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
@SourceDebugExtension
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lifecycle f8764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lifecycle.State f8765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f8766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r f8767d;

    public p(Lifecycle lifecycle, Lifecycle.State minState, i dispatchQueue, final q1 parentJob) {
        Intrinsics.g(lifecycle, "lifecycle");
        Intrinsics.g(minState, "minState");
        Intrinsics.g(dispatchQueue, "dispatchQueue");
        Intrinsics.g(parentJob, "parentJob");
        this.f8764a = lifecycle;
        this.f8765b = minState;
        this.f8766c = dispatchQueue;
        r rVar = new r() { // from class: androidx.lifecycle.o
            @Override // androidx.lifecycle.r
            public final void onStateChanged(u uVar, Lifecycle.Event event) {
                p.c(this.f8759a, parentJob, uVar, event);
            }
        };
        this.f8767d = rVar;
        if (lifecycle.b() != Lifecycle.State.DESTROYED) {
            lifecycle.a(rVar);
        } else {
            q1.a.b(parentJob, null, 1, null);
            b();
        }
    }

    public static final void c(p this$0, q1 parentJob, u source, Lifecycle.Event event) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(parentJob, "$parentJob");
        Intrinsics.g(source, "source");
        Intrinsics.g(event, "<anonymous parameter 1>");
        if (source.getLifecycle().b() == Lifecycle.State.DESTROYED) {
            q1.a.b(parentJob, null, 1, null);
            this$0.b();
        } else if (source.getLifecycle().b().compareTo(this$0.f8765b) < 0) {
            this$0.f8766c.h();
        } else {
            this$0.f8766c.i();
        }
    }

    public final void b() {
        this.f8764a.d(this.f8767d);
        this.f8766c.g();
    }
}
