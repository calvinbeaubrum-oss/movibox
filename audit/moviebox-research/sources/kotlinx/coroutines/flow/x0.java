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
public final class x0<T> implements f1<T>, a, kotlinx.coroutines.flow.internal.j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q1 f69425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f1<T> f69426b;

    /* JADX WARN: Multi-variable type inference failed */
    public x0(f1<? extends T> f1Var, q1 q1Var) {
        this.f69425a = q1Var;
        this.f69426b = f1Var;
    }

    @Override // kotlinx.coroutines.flow.z0, kotlinx.coroutines.flow.a
    public Object a(b<? super T> bVar, Continuation<?> continuation) {
        return this.f69426b.a(bVar, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.j
    public a<T> d(CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        return g1.d(this, coroutineContext, i11, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.f1
    public T getValue() {
        return this.f69426b.getValue();
    }
}
