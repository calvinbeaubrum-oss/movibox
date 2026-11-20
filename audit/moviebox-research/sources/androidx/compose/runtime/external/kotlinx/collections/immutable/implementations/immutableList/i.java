package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.NoSuchElementException;
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
public final class i<E> extends a<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object[] f3400d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3401f;

    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v3 */
    public i(Object[] objArr, int i11, int i12, int i13) {
        super(i11, i12);
        this.f3399c = i13;
        Object[] objArr2 = new Object[i13];
        this.f3400d = objArr2;
        ?? r11 = i11 == i12 ? 1 : 0;
        this.f3401f = r11;
        objArr2[0] = objArr;
        k(i11 - r11, 1);
    }

    public final E j() {
        int iD = d() & 31;
        Object obj = this.f3400d[this.f3399c - 1];
        Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.Array<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.TrieIterator>");
        return (E) ((Object[]) obj)[iD];
    }

    public final void k(int i11, int i12) {
        int i13 = (this.f3399c - i12) * 5;
        while (i12 < this.f3399c) {
            Object[] objArr = this.f3400d;
            Object obj = objArr[i12 - 1];
            Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr[i12] = ((Object[]) obj)[j.a(i11, i13)];
            i13 -= 5;
            i12++;
        }
    }

    public final void l(int i11) {
        int i12 = 0;
        while (j.a(d(), i12) == i11) {
            i12 += 5;
        }
        if (i12 > 0) {
            k(d(), ((this.f3399c - 1) - (i12 / 5)) + 1);
        }
    }

    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    public final void m(Object[] objArr, int i11, int i12, int i13) {
        g(i11);
        i(i12);
        this.f3399c = i13;
        if (this.f3400d.length < i13) {
            this.f3400d = new Object[i13];
        }
        this.f3400d[0] = objArr;
        ?? r11 = i11 == i12 ? 1 : 0;
        this.f3401f = r11;
        k(i11 - r11, 1);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        E eJ = j();
        g(d() + 1);
        if (d() == f()) {
            this.f3401f = true;
            return eJ;
        }
        l(0);
        return eJ;
    }

    @Override // java.util.ListIterator
    public E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        g(d() - 1);
        if (this.f3401f) {
            this.f3401f = false;
            return j();
        }
        l(31);
        return j();
    }
}
