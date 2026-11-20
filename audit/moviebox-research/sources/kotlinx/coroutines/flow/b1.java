package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class b1 extends kotlinx.coroutines.flow.internal.c<SharedFlowImpl<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public long f69377a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public Continuation<? super Unit> f69378b;

    @Override // kotlinx.coroutines.flow.internal.c
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(SharedFlowImpl<?> sharedFlowImpl) {
        if (this.f69377a >= 0) {
            return false;
        }
        this.f69377a = sharedFlowImpl.Y();
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Continuation<Unit>[] b(SharedFlowImpl<?> sharedFlowImpl) {
        long j11 = this.f69377a;
        this.f69377a = -1L;
        this.f69378b = null;
        return sharedFlowImpl.X(j11);
    }
}
