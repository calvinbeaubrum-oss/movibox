package androidx.core.util;

import android.util.SparseArray;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class k {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends IntIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SparseArray<T> f7895b;

        public a(SparseArray<T> sparseArray) {
            this.f7895b = sparseArray;
        }

        @Override // kotlin.collections.IntIterator
        public int a() {
            SparseArray<T> sparseArray = this.f7895b;
            int i11 = this.f7894a;
            this.f7894a = i11 + 1;
            return sparseArray.keyAt(i11);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f7894a < this.f7895b.size();
        }
    }

    public static final <T> IntIterator a(SparseArray<T> sparseArray) {
        return new a(sparseArray);
    }
}
