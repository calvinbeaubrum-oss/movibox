package kotlin.collections;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.collections.builders.SetBuilder;
import kotlin.jvm.internal.Intrinsics;

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
public class v {
    @SinceKotlin
    @PublishedApi
    public static <E> Set<E> a(Set<E> builder) {
        Intrinsics.g(builder, "builder");
        return ((SetBuilder) builder).build();
    }

    @SinceKotlin
    @PublishedApi
    public static <E> Set<E> b() {
        return new SetBuilder();
    }

    @SinceKotlin
    @PublishedApi
    public static <E> Set<E> c(int i11) {
        return new SetBuilder(i11);
    }

    public static <T> Set<T> d(T t11) {
        Set<T> setSingleton = Collections.singleton(t11);
        Intrinsics.f(setSingleton, "singleton(...)");
        return setSingleton;
    }

    public static <T> TreeSet<T> e(T... elements) {
        Intrinsics.g(elements, "elements");
        return (TreeSet) d.x0(elements, new TreeSet());
    }
}
