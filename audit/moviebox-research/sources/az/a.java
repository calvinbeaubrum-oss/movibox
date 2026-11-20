package az;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
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
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Reference<T> f13846a;

    public final void a(T t11) {
        this.f13846a = new WeakReference(t11);
    }

    public void b() {
        Reference<T> reference = this.f13846a;
        if (reference != null) {
            Intrinsics.d(reference);
            reference.clear();
            this.f13846a = null;
        }
    }

    public final T c() {
        Reference<T> reference = this.f13846a;
        if (reference == null) {
            return null;
        }
        Intrinsics.d(reference);
        return reference.get();
    }

    public final boolean d() {
        Reference<T> reference = this.f13846a;
        if (reference != null) {
            Intrinsics.d(reference);
            if (reference.get() != null) {
                return true;
            }
        }
        return false;
    }
}
