package kotlin.collections;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

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
public class l extends k {
    @JvmName
    public static <T> List<T> Q(List<T> list) {
        Intrinsics.g(list, "<this>");
        return new ReversedList(list);
    }

    public static final int R(List<?> list, int i11) {
        if (new IntRange(0, g.n(list)).v(i11)) {
            return g.n(list) - i11;
        }
        throw new IndexOutOfBoundsException("Element index " + i11 + " must be in range [" + new IntRange(0, g.n(list)) + "].");
    }

    public static final int S(List<?> list, int i11) {
        return g.n(list) - i11;
    }

    public static final int T(List<?> list, int i11) {
        if (new IntRange(0, list.size()).v(i11)) {
            return list.size() - i11;
        }
        throw new IndexOutOfBoundsException("Position index " + i11 + " must be in range [" + new IntRange(0, list.size()) + "].");
    }
}
