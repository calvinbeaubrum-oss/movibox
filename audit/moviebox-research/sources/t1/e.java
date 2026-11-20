package t1;

import java.util.Iterator;
import java.util.NoSuchElementException;
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
public abstract class e<K, V, T> implements Iterator<T>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u<K, V, T>[] f76676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f76677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f76678c = true;

    public e(t<K, V> tVar, u<K, V, T>[] uVarArr) {
        this.f76676a = uVarArr;
        uVarArr[0].l(tVar.p(), tVar.m() * 2);
        this.f76677b = 0;
        d();
    }

    private final void a() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }

    public final K c() {
        a();
        return this.f76676a[this.f76677b].a();
    }

    public final void d() {
        if (this.f76676a[this.f76677b].g()) {
            return;
        }
        for (int i11 = this.f76677b; -1 < i11; i11--) {
            int iG = g(i11);
            if (iG == -1 && this.f76676a[i11].i()) {
                this.f76676a[i11].k();
                iG = g(i11);
            }
            if (iG != -1) {
                this.f76677b = iG;
                return;
            }
            if (i11 > 0) {
                this.f76676a[i11 - 1].k();
            }
            this.f76676a[i11].l(t.f76696e.a().p(), 0);
        }
        this.f76678c = false;
    }

    public final u<K, V, T>[] f() {
        return this.f76676a;
    }

    public final int g(int i11) {
        if (this.f76676a[i11].g()) {
            return i11;
        }
        if (!this.f76676a[i11].i()) {
            return -1;
        }
        t<? extends K, ? extends V> tVarC = this.f76676a[i11].c();
        if (i11 == 6) {
            this.f76676a[i11 + 1].l(tVarC.p(), tVarC.p().length);
        } else {
            this.f76676a[i11 + 1].l(tVarC.p(), tVarC.m() * 2);
        }
        return g(i11 + 1);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f76678c;
    }

    public final void i(int i11) {
        this.f76677b = i11;
    }

    @Override // java.util.Iterator
    public T next() {
        a();
        T next = this.f76676a[this.f76677b].next();
        d();
        return next;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
