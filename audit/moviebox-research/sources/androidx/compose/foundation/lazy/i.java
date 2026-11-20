package androidx.compose.foundation.lazy;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

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
public final class i implements androidx.compose.foundation.lazy.layout.j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Integer, Object> f2593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Integer, Object> f2594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function4<b, Integer, androidx.compose.runtime.i, Integer, Unit> f2595c;

    /* JADX WARN: Multi-variable type inference failed */
    public i(Function1<? super Integer, ? extends Object> function1, Function1<? super Integer, ? extends Object> function2, Function4<? super b, ? super Integer, ? super androidx.compose.runtime.i, ? super Integer, Unit> function4) {
        this.f2593a = function1;
        this.f2594b = function2;
        this.f2595c = function4;
    }

    public final Function4<b, Integer, androidx.compose.runtime.i, Integer, Unit> a() {
        return this.f2595c;
    }

    @Override // androidx.compose.foundation.lazy.layout.j.a
    public Function1<Integer, Object> getKey() {
        return this.f2593a;
    }

    @Override // androidx.compose.foundation.lazy.layout.j.a
    public Function1<Integer, Object> getType() {
        return this.f2594b;
    }
}
