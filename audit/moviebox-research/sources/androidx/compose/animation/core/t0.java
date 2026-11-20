package androidx.compose.animation.core;

import androidx.compose.animation.core.o;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class t0<T, V extends o> implements s0<T, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<T, V> f2136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<V, T> f2137b;

    /* JADX WARN: Multi-variable type inference failed */
    public t0(Function1<? super T, ? extends V> function1, Function1<? super V, ? extends T> function2) {
        this.f2136a = function1;
        this.f2137b = function2;
    }

    @Override // androidx.compose.animation.core.s0
    public Function1<T, V> a() {
        return this.f2136a;
    }

    @Override // androidx.compose.animation.core.s0
    public Function1<V, T> b() {
        return this.f2137b;
    }
}
