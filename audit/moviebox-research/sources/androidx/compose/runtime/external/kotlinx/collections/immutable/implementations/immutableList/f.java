package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.ConcurrentModificationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableListIterator;

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
public final class f<T> extends a<T> implements KMutableListIterator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PersistentVectorBuilder<T> f3390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3391d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public i<? extends T> f3392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3393g;

    public f(PersistentVectorBuilder<T> persistentVectorBuilder, int i11) {
        super(i11, persistentVectorBuilder.size());
        this.f3390c = persistentVectorBuilder;
        this.f3391d = persistentVectorBuilder.f();
        this.f3393g = -1;
        m();
    }

    private final void l() {
        i(this.f3390c.size());
        this.f3391d = this.f3390c.f();
        this.f3393g = -1;
        m();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.a, java.util.ListIterator
    public void add(T t11) {
        j();
        this.f3390c.add(d(), t11);
        g(d() + 1);
        l();
    }

    public final void j() {
        if (this.f3391d != this.f3390c.f()) {
            throw new ConcurrentModificationException();
        }
    }

    public final void k() {
        if (this.f3393g == -1) {
            throw new IllegalStateException();
        }
    }

    public final void m() {
        Object[] objArrG = this.f3390c.g();
        if (objArrG == null) {
            this.f3392f = null;
            return;
        }
        int iD = j.d(this.f3390c.size());
        int iG = kotlin.ranges.a.g(d(), iD);
        int i11 = (this.f3390c.i() / 5) + 1;
        i<? extends T> iVar = this.f3392f;
        if (iVar == null) {
            this.f3392f = new i<>(objArrG, iG, iD, i11);
        } else {
            Intrinsics.d(iVar);
            iVar.m(objArrG, iG, iD, i11);
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public T next() {
        j();
        a();
        this.f3393g = d();
        i<? extends T> iVar = this.f3392f;
        if (iVar == null) {
            Object[] objArrJ = this.f3390c.j();
            int iD = d();
            g(iD + 1);
            return (T) objArrJ[iD];
        }
        if (iVar.hasNext()) {
            g(d() + 1);
            return iVar.next();
        }
        Object[] objArrJ2 = this.f3390c.j();
        int iD2 = d();
        g(iD2 + 1);
        return (T) objArrJ2[iD2 - iVar.f()];
    }

    @Override // java.util.ListIterator
    public T previous() {
        j();
        c();
        this.f3393g = d() - 1;
        i<? extends T> iVar = this.f3392f;
        if (iVar == null) {
            Object[] objArrJ = this.f3390c.j();
            g(d() - 1);
            return (T) objArrJ[d()];
        }
        if (d() <= iVar.f()) {
            g(d() - 1);
            return iVar.previous();
        }
        Object[] objArrJ2 = this.f3390c.j();
        g(d() - 1);
        return (T) objArrJ2[d() - iVar.f()];
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.a, java.util.ListIterator, java.util.Iterator
    public void remove() {
        j();
        k();
        this.f3390c.remove(this.f3393g);
        if (this.f3393g < d()) {
            g(this.f3393g);
        }
        l();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.a, java.util.ListIterator
    public void set(T t11) {
        j();
        k();
        this.f3390c.set(this.f3393g, t11);
        this.f3391d = this.f3390c.f();
        m();
    }
}
