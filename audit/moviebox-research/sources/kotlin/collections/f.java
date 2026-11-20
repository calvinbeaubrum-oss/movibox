package kotlin.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.collections.builders.ListBuilder;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public class f {
    @SinceKotlin
    @PublishedApi
    public static <E> List<E> a(List<E> builder) {
        Intrinsics.g(builder, "builder");
        return ((ListBuilder) builder).build();
    }

    public static final <T> Object[] b(T[] tArr, boolean z11) {
        Intrinsics.g(tArr, "<this>");
        if (z11 && Intrinsics.b(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        Intrinsics.f(objArrCopyOf, "copyOf(...)");
        return objArrCopyOf;
    }

    @SinceKotlin
    @PublishedApi
    public static <E> List<E> c() {
        return new ListBuilder();
    }

    @SinceKotlin
    @PublishedApi
    public static <E> List<E> d(int i11) {
        return new ListBuilder(i11);
    }

    public static <T> List<T> e(T t11) {
        List<T> listSingletonList = Collections.singletonList(t11);
        Intrinsics.f(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    @SinceKotlin
    public static <T> List<T> f(Iterable<? extends T> iterable) {
        Intrinsics.g(iterable, "<this>");
        List<T> listL0 = CollectionsKt___CollectionsKt.L0(iterable);
        Collections.shuffle(listL0);
        return listL0;
    }

    public static <T> T[] g(int i11, T[] array) {
        Intrinsics.g(array, "array");
        if (i11 < array.length) {
            array[i11] = null;
        }
        return array;
    }
}
