package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
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
public final class GeneratorSequence<T> implements Sequence<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<T> f69024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<T, T> f69025b;

    /* JADX INFO: renamed from: kotlin.sequences.GeneratorSequence$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class AnonymousClass1 implements Iterator<T>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public T f69026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f69027b = -2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ GeneratorSequence<T> f69028c;

        public AnonymousClass1(GeneratorSequence<T> generatorSequence) {
            this.f69028c = generatorSequence;
        }

        private final void a() {
            T t11;
            if (this.f69027b == -2) {
                t11 = (T) this.f69028c.f69024a.invoke();
            } else {
                Function1 function1 = this.f69028c.f69025b;
                T t12 = this.f69026a;
                Intrinsics.d(t12);
                t11 = (T) function1.invoke(t12);
            }
            this.f69026a = t11;
            this.f69027b = t11 == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f69027b < 0) {
                a();
            }
            return this.f69027b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f69027b < 0) {
                a();
            }
            if (this.f69027b == 0) {
                throw new NoSuchElementException();
            }
            T t11 = this.f69026a;
            Intrinsics.e(t11, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.f69027b = -1;
            return t11;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GeneratorSequence(Function0<? extends T> getInitialValue, Function1<? super T, ? extends T> getNextValue) {
        Intrinsics.g(getInitialValue, "getInitialValue");
        Intrinsics.g(getNextValue, "getNextValue");
        this.f69024a = getInitialValue;
        this.f69025b = getNextValue;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new AnonymousClass1(this);
    }
}
