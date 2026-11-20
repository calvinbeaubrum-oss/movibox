package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.l0;

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
public final class ChannelFlowTransformLatest<T, R> extends ChannelFlowOperator<T, R> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function3<kotlinx.coroutines.flow.b<? super R>, T, Continuation<? super Unit>, Object> f69395f;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowTransformLatest(Function3<? super kotlinx.coroutines.flow.b<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3, kotlinx.coroutines.flow.a<? extends T> aVar, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        super(aVar, coroutineContext, i11, bufferOverflow);
        this.f69395f = function3;
    }

    public /* synthetic */ ChannelFlowTransformLatest(Function3 function3, kotlinx.coroutines.flow.a aVar, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(function3, aVar, (i12 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i12 & 8) != 0 ? -2 : i11, (i12 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ChannelFlow<R> j(CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        return new ChannelFlowTransformLatest(this.f69395f, this.f69394d, coroutineContext, i11, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    public Object r(kotlinx.coroutines.flow.b<? super R> bVar, Continuation<? super Unit> continuation) {
        Object objE = l0.e(new ChannelFlowTransformLatest$flowCollect$3(this, bVar, null), continuation);
        return objE == kotlin.coroutines.intrinsics.a.e() ? objE : Unit.f68710a;
    }
}
