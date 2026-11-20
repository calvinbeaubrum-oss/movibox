package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.channels.BufferOverflow;

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
public abstract class ChannelFlowOperator<S, T> extends ChannelFlow<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public final kotlinx.coroutines.flow.a<S> f69394d;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowOperator(kotlinx.coroutines.flow.a<? extends S> aVar, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        super(coroutineContext, i11, bufferOverflow);
        this.f69394d = aVar;
    }

    public static /* synthetic */ <S, T> Object o(ChannelFlowOperator<S, T> channelFlowOperator, kotlinx.coroutines.flow.b<? super T> bVar, Continuation<? super Unit> continuation) {
        if (channelFlowOperator.f69392b == -3) {
            CoroutineContext context = continuation.getContext();
            CoroutineContext coroutineContextD = CoroutineContextKt.d(context, channelFlowOperator.f69391a);
            if (Intrinsics.b(coroutineContextD, context)) {
                Object objR = channelFlowOperator.r(bVar, continuation);
                return objR == kotlin.coroutines.intrinsics.a.e() ? objR : Unit.f68710a;
            }
            ContinuationInterceptor.Key key = ContinuationInterceptor.f68810h8;
            if (Intrinsics.b(coroutineContextD.get(key), context.get(key))) {
                Object objQ = channelFlowOperator.q(bVar, coroutineContextD, continuation);
                return objQ == kotlin.coroutines.intrinsics.a.e() ? objQ : Unit.f68710a;
            }
        }
        Object objA = super.a(bVar, continuation);
        return objA == kotlin.coroutines.intrinsics.a.e() ? objA : Unit.f68710a;
    }

    public static /* synthetic */ <S, T> Object p(ChannelFlowOperator<S, T> channelFlowOperator, kotlinx.coroutines.channels.m<? super T> mVar, Continuation<? super Unit> continuation) {
        Object objR = channelFlowOperator.r(new o(mVar), continuation);
        return objR == kotlin.coroutines.intrinsics.a.e() ? objR : Unit.f68710a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.a
    public Object a(kotlinx.coroutines.flow.b<? super T> bVar, Continuation<? super Unit> continuation) {
        return o(this, bVar, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object i(kotlinx.coroutines.channels.m<? super T> mVar, Continuation<? super Unit> continuation) {
        return p(this, mVar, continuation);
    }

    public final Object q(kotlinx.coroutines.flow.b<? super T> bVar, CoroutineContext coroutineContext, Continuation<? super Unit> continuation) {
        return d.c(coroutineContext, d.d(bVar, continuation.getContext()), null, new ChannelFlowOperator$collectWithContextUndispatched$2(this, null), continuation, 4, null);
    }

    public abstract Object r(kotlinx.coroutines.flow.b<? super T> bVar, Continuation<? super Unit> continuation);

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public String toString() {
        return this.f69394d + " -> " + super.toString();
    }
}
