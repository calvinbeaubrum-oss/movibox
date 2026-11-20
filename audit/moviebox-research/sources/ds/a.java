package ds;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class a<E> implements Queue<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f63532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinkedList<E> f63533b;

    public a(int i11) {
        this.f63532a = i11;
        this.f63533b = new LinkedList<>();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(Queue<E> newQueue) {
        this(newQueue.size());
        Intrinsics.g(newQueue, "newQueue");
        this.f63533b = new LinkedList<>(newQueue);
    }

    public int a() {
        return this.f63533b.size();
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(E e11) {
        return this.f63533b.add(e11);
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.g(elements, "elements");
        return this.f63533b.addAll(elements);
    }

    @Override // java.util.Collection
    public void clear() {
        this.f63533b.clear();
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return this.f63533b.contains(obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.g(elements, "elements");
        return this.f63533b.containsAll(elements);
    }

    @Override // java.util.Queue
    public E element() {
        return this.f63533b.element();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f63533b.size() == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        Iterator<E> it = this.f63533b.iterator();
        Intrinsics.f(it, "queue.iterator()");
        return it;
    }

    @Override // java.util.Queue
    public boolean offer(E e11) {
        if (this.f63533b.size() >= this.f63532a) {
            this.f63533b.poll();
        }
        return this.f63533b.offer(e11);
    }

    @Override // java.util.Queue
    public E peek() {
        return this.f63533b.peek();
    }

    @Override // java.util.Queue
    public E poll() {
        return this.f63533b.poll();
    }

    @Override // java.util.Queue
    public E remove() {
        return this.f63533b.remove();
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        return this.f63533b.remove(obj);
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.g(elements, "elements");
        return this.f63533b.removeAll(CollectionsKt___CollectionsKt.O0(elements));
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.g(elements, "elements");
        return this.f63533b.retainAll(CollectionsKt___CollectionsKt.O0(elements));
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        Object[] array = this.f63533b.toArray();
        Intrinsics.f(array, "queue.toArray()");
        return array;
    }

    @Override // java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        T[] tArr2 = (T[]) this.f63533b.toArray(tArr);
        Intrinsics.f(tArr2, "queue.toArray(a)");
        return tArr2;
    }
}
