package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlow;
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
@SourceDebugExtension
public final /* synthetic */ class FlowKt__ShareKt {
    public static final <T> z0<T> a(u0<T> u0Var) {
        return new w0(u0Var, null);
    }

    public static final <T> f1<T> b(v0<T> v0Var) {
        return new x0(v0Var, null);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002f  */
    public static final <T> c1<T> c(a<? extends T> aVar, int i11) {
        ChannelFlow channelFlow;
        a<T> aVarK;
        int iD = kotlin.ranges.a.d(i11, kotlinx.coroutines.channels.a.f69249k8.a()) - i11;
        if (!(aVar instanceof ChannelFlow) || (aVarK = (channelFlow = (ChannelFlow) aVar).k()) == null) {
            return new c1<>(aVar, iD, BufferOverflow.SUSPEND, EmptyCoroutineContext.INSTANCE);
        }
        int i12 = channelFlow.f69392b;
        if (i12 != -3 && i12 != -2 && i12 != 0) {
            iD = i12;
        } else if (channelFlow.f69393c == BufferOverflow.SUSPEND) {
            if (i12 == 0) {
                iD = 0;
            }
        } else if (i11 == 0) {
            iD = 1;
        } else {
            iD = 0;
        }
        return new c1<>(aVarK, iD, channelFlow.f69393c, channelFlow.f69391a);
    }

    public static final <T> q1 d(kotlinx.coroutines.k0 k0Var, CoroutineContext coroutineContext, a<? extends T> aVar, u0<T> u0Var, d1 d1Var, T t11) {
        return kotlinx.coroutines.h.c(k0Var, coroutineContext, Intrinsics.b(d1Var, d1.f69383a.c()) ? CoroutineStart.DEFAULT : CoroutineStart.UNDISPATCHED, new FlowKt__ShareKt$launchSharing$1(d1Var, aVar, u0Var, t11, null));
    }

    public static final <T> f1<T> e(a<? extends T> aVar, kotlinx.coroutines.k0 k0Var, d1 d1Var, T t11) {
        c1 c1VarC = c(aVar, 1);
        v0 v0VarA = g1.a(t11);
        return new x0(v0VarA, d(k0Var, c1VarC.f69382d, c1VarC.f69379a, v0VarA, d1Var, t11));
    }
}
