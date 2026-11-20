package androidx.compose.ui.platform;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

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
public final class x2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.compose.runtime.collection.b<Reference<T>> f5559a = new androidx.compose.runtime.collection.b<>(new Reference[16], 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReferenceQueue<T> f5560b = new ReferenceQueue<>();

    public final void a() {
        Reference<? extends T> referencePoll;
        do {
            referencePoll = this.f5560b.poll();
            if (referencePoll != null) {
                this.f5559a.x(referencePoll);
            }
        } while (referencePoll != null);
    }

    public final T b() {
        a();
        while (this.f5559a.u()) {
            androidx.compose.runtime.collection.b<Reference<T>> bVar = this.f5559a;
            T t11 = bVar.z(bVar.r() - 1).get();
            if (t11 != null) {
                return t11;
            }
        }
        return null;
    }

    public final void c(T t11) {
        a();
        this.f5559a.b(new WeakReference(t11, this.f5560b));
    }
}
