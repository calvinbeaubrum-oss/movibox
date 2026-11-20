package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.collections.BooleanIterator;
import kotlin.collections.ByteIterator;
import kotlin.collections.CharIterator;
import kotlin.collections.DoubleIterator;
import kotlin.collections.FloatIterator;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.collections.ShortIterator;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ArrayIteratorsKt {
    public static final BooleanIterator a(boolean[] array) {
        Intrinsics.g(array, "array");
        return new a(array);
    }

    public static final ByteIterator b(byte[] array) {
        Intrinsics.g(array, "array");
        return new b(array);
    }

    public static final CharIterator c(char[] array) {
        Intrinsics.g(array, "array");
        return new c(array);
    }

    public static final DoubleIterator d(double[] array) {
        Intrinsics.g(array, "array");
        return new d(array);
    }

    public static final FloatIterator e(float[] array) {
        Intrinsics.g(array, "array");
        return new e(array);
    }

    public static final IntIterator f(int[] array) {
        Intrinsics.g(array, "array");
        return new f(array);
    }

    public static final LongIterator g(long[] array) {
        Intrinsics.g(array, "array");
        return new h(array);
    }

    public static final ShortIterator h(short[] array) {
        Intrinsics.g(array, "array");
        return new i(array);
    }
}
