package androidx.compose.runtime;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

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
public final class j0 implements Iterator<w1.b>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j2 f3448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3451d;

    public j0(j2 j2Var, int i11, int i12) {
        this.f3448a = j2Var;
        this.f3449b = i12;
        this.f3450c = i11;
        this.f3451d = j2Var.A();
        if (j2Var.B()) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public w1.b next() {
        c();
        int i11 = this.f3450c;
        this.f3450c = l2.I(this.f3448a.v(), i11) + i11;
        return new k2(this.f3448a, i11, this.f3451d);
    }

    public final void c() {
        if (this.f3448a.A() != this.f3451d) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f3450c < this.f3449b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
