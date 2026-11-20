package s1;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
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
public interface d<E> extends List<E>, b<E>, KMappedMarker {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a<E> extends AbstractList<E> implements d<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d<E> f75924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f75925b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f75926c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f75927d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(d<? extends E> dVar, int i11, int i12) {
            this.f75924a = dVar;
            this.f75925b = i11;
            this.f75926c = i12;
            v1.d.c(i11, i12, dVar.size());
            this.f75927d = i12 - i11;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public d<E> subList(int i11, int i12) {
            v1.d.c(i11, i12, this.f75927d);
            d<E> dVar = this.f75924a;
            int i13 = this.f75925b;
            return new a(dVar, i11 + i13, i13 + i12);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public E get(int i11) {
            v1.d.a(i11, this.f75927d);
            return this.f75924a.get(this.f75925b + i11);
        }

        @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.f75927d;
        }
    }
}
