package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class c0<T> implements b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.compose.runtime.collection.b<b.a<T>> f2697a = new androidx.compose.runtime.collection.b<>(new b.a[16], 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b.a<? extends T> f2699c;

    @Override // androidx.compose.foundation.lazy.layout.b
    public void a(int i11, int i12, Function1<? super b.a<? extends T>, Unit> function1) {
        c(i11);
        c(i12);
        if (i12 < i11) {
            throw new IllegalArgumentException(("toIndex (" + i12 + ") should be not smaller than fromIndex (" + i11 + ')').toString());
        }
        int iB = c.b(this.f2697a, i11);
        int iB2 = this.f2697a.q()[iB].b();
        while (iB2 <= i12) {
            b.a<T> aVar = this.f2697a.q()[iB];
            function1.invoke(aVar);
            iB2 += aVar.a();
            iB++;
        }
    }

    public final void b(int i11, T t11) {
        if (i11 < 0) {
            throw new IllegalArgumentException(("size should be >=0, but was " + i11).toString());
        }
        if (i11 == 0) {
            return;
        }
        b.a<T> aVar = new b.a<>(getSize(), i11, t11);
        this.f2698b = getSize() + i11;
        this.f2697a.b(aVar);
    }

    public final void c(int i11) {
        if (i11 < 0 || i11 >= getSize()) {
            throw new IndexOutOfBoundsException("Index " + i11 + ", size " + getSize());
        }
    }

    public final boolean d(b.a<? extends T> aVar, int i11) {
        return i11 < aVar.b() + aVar.a() && aVar.b() <= i11;
    }

    public final b.a<T> e(int i11) {
        b.a<? extends T> aVar = this.f2699c;
        if (aVar != null && d(aVar, i11)) {
            return aVar;
        }
        androidx.compose.runtime.collection.b<b.a<T>> bVar = this.f2697a;
        b.a aVar2 = (b.a<? extends T>) bVar.q()[c.b(bVar, i11)];
        this.f2699c = aVar2;
        return aVar2;
    }

    @Override // androidx.compose.foundation.lazy.layout.b
    public b.a<T> get(int i11) {
        c(i11);
        return e(i11);
    }

    @Override // androidx.compose.foundation.lazy.layout.b
    public int getSize() {
        return this.f2698b;
    }
}
