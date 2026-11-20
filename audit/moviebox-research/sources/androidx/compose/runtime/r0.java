package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

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
public final class r0 implements b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> f3557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kotlinx.coroutines.k0 f3558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public kotlinx.coroutines.q1 f3559c;

    /* JADX WARN: Multi-variable type inference failed */
    public r0(CoroutineContext coroutineContext, Function2<? super kotlinx.coroutines.k0, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.f3557a = function2;
        this.f3558b = kotlinx.coroutines.l0.a(coroutineContext);
    }

    @Override // androidx.compose.runtime.b2
    public void onAbandoned() {
        kotlinx.coroutines.q1 q1Var = this.f3559c;
        if (q1Var != null) {
            q1Var.cancel(new LeftCompositionCancellationException());
        }
        this.f3559c = null;
    }

    @Override // androidx.compose.runtime.b2
    public void onForgotten() {
        kotlinx.coroutines.q1 q1Var = this.f3559c;
        if (q1Var != null) {
            q1Var.cancel(new LeftCompositionCancellationException());
        }
        this.f3559c = null;
    }

    @Override // androidx.compose.runtime.b2
    public void onRemembered() {
        kotlinx.coroutines.q1 q1Var = this.f3559c;
        if (q1Var != null) {
            kotlinx.coroutines.v1.f(q1Var, "Old job was still running!", null, 2, null);
        }
        this.f3559c = kotlinx.coroutines.j.d(this.f3558b, null, null, this.f3557a, 3, null);
    }
}
