package androidx.compose.ui.layout;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface t0 {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Collection<Object>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<Object> f4891a;

        public a(Set<Object> set) {
            this.f4891a = set;
        }

        public /* synthetic */ a(Set set, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? new LinkedHashSet() : set);
        }

        @Override // java.util.Collection
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final boolean add(Object obj) {
            return this.f4891a.add(obj);
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Collection
        public final void clear() {
            this.f4891a.clear();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return this.f4891a.contains(obj);
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<? extends Object> collection) {
            return this.f4891a.containsAll(collection);
        }

        public int e() {
            return this.f4891a.size();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.f4891a.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<Object> iterator() {
            return this.f4891a.iterator();
        }

        @Override // java.util.Collection
        public final boolean remove(Object obj) {
            return this.f4891a.remove(obj);
        }

        @Override // java.util.Collection
        public final boolean removeAll(Collection<? extends Object> collection) {
            return this.f4891a.remove(collection);
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super Object> predicate) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection<? extends Object> collection) {
            return this.f4891a.retainAll(collection);
        }

        @Override // java.util.Collection
        public final /* bridge */ int size() {
            return e();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.a(this);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) CollectionToArray.b(this, tArr);
        }
    }

    void a(a aVar);

    boolean b(Object obj, Object obj2);
}
