package o1;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.u0;

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
public final class j implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u0<f> f72255a = a1.b(0, 16, BufferOverflow.DROP_OLDEST, 1, null);

    @Override // o1.i
    public boolean a(f fVar) {
        return c().b(fVar);
    }

    @Override // o1.i
    public Object b(f fVar, Continuation<? super Unit> continuation) {
        Object objEmit = c().emit(fVar, continuation);
        return objEmit == kotlin.coroutines.intrinsics.a.e() ? objEmit : Unit.f68710a;
    }

    @Override // o1.g
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public u0<f> c() {
        return this.f72255a;
    }
}
