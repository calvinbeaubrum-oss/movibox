package androidx.compose.runtime;

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
public final class b0 implements b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<d0, c0> f3349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c0 f3350b;

    /* JADX WARN: Multi-variable type inference failed */
    public b0(Function1<? super d0, ? extends c0> function1) {
        this.f3349a = function1;
    }

    @Override // androidx.compose.runtime.b2
    public void onAbandoned() {
    }

    @Override // androidx.compose.runtime.b2
    public void onForgotten() {
        c0 c0Var = this.f3350b;
        if (c0Var != null) {
            c0Var.dispose();
        }
        this.f3350b = null;
    }

    @Override // androidx.compose.runtime.b2
    public void onRemembered() {
        this.f3350b = this.f3349a.invoke(g0.f3410a);
    }
}
