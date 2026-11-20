package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.q1;

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
public final class w0<T> implements z0<T>, a, kotlinx.coroutines.flow.internal.j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q1 f69423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z0<T> f69424b;

    /* JADX WARN: Multi-variable type inference failed */
    public w0(z0<? extends T> z0Var, q1 q1Var) {
        this.f69423a = q1Var;
        this.f69424b = z0Var;
    }

    @Override // kotlinx.coroutines.flow.z0, kotlinx.coroutines.flow.a
    public Object a(b<? super T> bVar, Continuation<?> continuation) {
        return this.f69424b.a(bVar, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.j
    public a<T> d(CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        return a1.e(this, coroutineContext, i11, bufferOverflow);
    }
}
