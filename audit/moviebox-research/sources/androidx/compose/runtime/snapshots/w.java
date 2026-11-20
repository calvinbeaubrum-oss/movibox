package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension
public final class w<T> implements ListIterator<T>, KMutableListIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SnapshotStateList<T> f3709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3711c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3712d;

    public w(SnapshotStateList<T> snapshotStateList, int i11) {
        this.f3709a = snapshotStateList;
        this.f3710b = i11 - 1;
        this.f3712d = snapshotStateList.f();
    }

    private final void a() {
        if (this.f3709a.f() != this.f3712d) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator
    public void add(T t11) {
        a();
        this.f3709a.add(this.f3710b + 1, t11);
        this.f3711c = -1;
        this.f3710b++;
        this.f3712d = this.f3709a.f();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.f3710b < this.f3709a.size() - 1;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.f3710b >= 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public T next() {
        a();
        int i11 = this.f3710b + 1;
        this.f3711c = i11;
        s.g(i11, this.f3709a.size());
        T t11 = this.f3709a.get(i11);
        this.f3710b = i11;
        return t11;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.f3710b + 1;
    }

    @Override // java.util.ListIterator
    public T previous() {
        a();
        s.g(this.f3710b, this.f3709a.size());
        int i11 = this.f3710b;
        this.f3711c = i11;
        T t11 = this.f3709a.get(i11);
        this.f3710b--;
        return t11;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.f3710b;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        a();
        this.f3709a.remove(this.f3710b);
        this.f3710b--;
        this.f3711c = -1;
        this.f3712d = this.f3709a.f();
    }

    @Override // java.util.ListIterator
    public void set(T t11) {
        a();
        int i11 = this.f3711c;
        if (i11 < 0) {
            s.e();
            throw new KotlinNothingValueException();
        }
        this.f3709a.set(i11, t11);
        this.f3712d = this.f3709a.f();
    }
}
