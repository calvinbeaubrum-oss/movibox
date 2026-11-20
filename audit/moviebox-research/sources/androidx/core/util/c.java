package androidx.core.util;

import android.util.LongSparseArray;
import kotlin.Metadata;
import kotlin.collections.LongIterator;
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
public final class c {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends LongIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LongSparseArray<T> f7888b;

        public a(LongSparseArray<T> longSparseArray) {
            this.f7888b = longSparseArray;
        }

        @Override // kotlin.collections.LongIterator
        public long a() {
            LongSparseArray<T> longSparseArray = this.f7888b;
            int i11 = this.f7887a;
            this.f7887a = i11 + 1;
            return longSparseArray.keyAt(i11);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f7887a < this.f7888b.size();
        }
    }

    public static final <T> LongIterator a(LongSparseArray<T> longSparseArray) {
        return new a(longSparseArray);
    }
}
