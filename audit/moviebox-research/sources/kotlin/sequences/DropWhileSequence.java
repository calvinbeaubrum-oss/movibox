package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DropWhileSequence<T> implements Sequence<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Sequence<T> f69005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<T, Boolean> f69006b;

    /* JADX INFO: renamed from: kotlin.sequences.DropWhileSequence$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class AnonymousClass1 implements Iterator<T>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<T> f69007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f69008b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public T f69009c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ DropWhileSequence<T> f69010d;

        public AnonymousClass1(DropWhileSequence<T> dropWhileSequence) {
            this.f69010d = dropWhileSequence;
            this.f69007a = dropWhileSequence.f69005a.iterator();
        }

        private final void a() {
            while (this.f69007a.hasNext()) {
                T next = this.f69007a.next();
                if (!((Boolean) this.f69010d.f69006b.invoke(next)).booleanValue()) {
                    this.f69009c = next;
                    this.f69008b = 1;
                    return;
                }
            }
            this.f69008b = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f69008b == -1) {
                a();
            }
            return this.f69008b == 1 || this.f69007a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f69008b == -1) {
                a();
            }
            if (this.f69008b != 1) {
                return this.f69007a.next();
            }
            T t11 = this.f69009c;
            this.f69009c = null;
            this.f69008b = 0;
            return t11;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new AnonymousClass1(this);
    }
}
