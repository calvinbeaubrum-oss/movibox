package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.m2;

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
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public final CoroutineContext f69474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f69475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m2<Object>[] f69476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f69477d;

    public l0(CoroutineContext coroutineContext, int i11) {
        this.f69474a = coroutineContext;
        this.f69475b = new Object[i11];
        this.f69476c = new m2[i11];
    }

    public final void a(m2<?> m2Var, Object obj) {
        Object[] objArr = this.f69475b;
        int i11 = this.f69477d;
        objArr[i11] = obj;
        m2<Object>[] m2VarArr = this.f69476c;
        this.f69477d = i11 + 1;
        Intrinsics.e(m2Var, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        m2VarArr[i11] = m2Var;
    }

    public final void b(CoroutineContext coroutineContext) {
        int length = this.f69476c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i11 = length - 1;
            m2<Object> m2Var = this.f69476c[length];
            Intrinsics.d(m2Var);
            m2Var.h(coroutineContext, this.f69475b[length]);
            if (i11 < 0) {
                return;
            } else {
                length = i11;
            }
        }
    }
}
