package androidx.compose.ui.semantics;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Float> f5658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Float> f5659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f5660c;

    public j(Function0<Float> function0, Function0<Float> function1, boolean z11) {
        this.f5658a = function0;
        this.f5659b = function1;
        this.f5660c = z11;
    }

    public final Function0<Float> a() {
        return this.f5659b;
    }

    public final boolean b() {
        return this.f5660c;
    }

    public final Function0<Float> c() {
        return this.f5658a;
    }

    public String toString() {
        return "ScrollAxisRange(value=" + this.f5658a.invoke().floatValue() + ", maxValue=" + this.f5659b.invoke().floatValue() + ", reverseScrolling=" + this.f5660c + ')';
    }
}
