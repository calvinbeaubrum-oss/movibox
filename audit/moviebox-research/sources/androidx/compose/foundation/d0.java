package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
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
public final class d0 implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f2264a = new d0();

    @Override // androidx.compose.foundation.f0
    public boolean a() {
        return false;
    }

    @Override // androidx.compose.foundation.f0
    public androidx.compose.ui.f b() {
        return androidx.compose.ui.f.f3863a;
    }

    @Override // androidx.compose.foundation.f0
    public long c(long j11, int i11, Function1<? super y1.g, y1.g> function1) {
        return function1.invoke(y1.g.d(j11)).v();
    }

    @Override // androidx.compose.foundation.f0
    public Object d(long j11, Function2<? super q2.z, ? super Continuation<? super q2.z>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objInvoke = function2.invoke(q2.z.b(j11), continuation);
        return objInvoke == kotlin.coroutines.intrinsics.a.e() ? objInvoke : Unit.f68710a;
    }
}
