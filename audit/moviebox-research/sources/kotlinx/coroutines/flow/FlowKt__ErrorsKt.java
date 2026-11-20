package kotlinx.coroutines.flow;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
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
public final /* synthetic */ class FlowKt__ErrorsKt {
    public static final <T> a<T> a(a<? extends T> aVar, Function3<? super b<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(aVar, function3);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object b(a<? extends T> aVar, b<? super T> bVar, Continuation<? super Throwable> continuation) throws Throwable {
        FlowKt__ErrorsKt$catchImpl$1 flowKt__ErrorsKt$catchImpl$1;
        Ref.ObjectRef objectRef;
        if (continuation instanceof FlowKt__ErrorsKt$catchImpl$1) {
            flowKt__ErrorsKt$catchImpl$1 = (FlowKt__ErrorsKt$catchImpl$1) continuation;
            int i11 = flowKt__ErrorsKt$catchImpl$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                flowKt__ErrorsKt$catchImpl$1.label = i11 - Integer.MIN_VALUE;
            } else {
                flowKt__ErrorsKt$catchImpl$1 = new FlowKt__ErrorsKt$catchImpl$1(continuation);
            }
        } else {
            flowKt__ErrorsKt$catchImpl$1 = new FlowKt__ErrorsKt$catchImpl$1(continuation);
        }
        Object obj = flowKt__ErrorsKt$catchImpl$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = flowKt__ErrorsKt$catchImpl$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            try {
                b<? super Object> flowKt__ErrorsKt$catchImpl$2 = new FlowKt__ErrorsKt$catchImpl$2<>(bVar, objectRef2);
                flowKt__ErrorsKt$catchImpl$1.L$0 = objectRef2;
                flowKt__ErrorsKt$catchImpl$1.label = 1;
                if (aVar.a(flowKt__ErrorsKt$catchImpl$2, flowKt__ErrorsKt$catchImpl$1) == objE) {
                    return objE;
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                objectRef = objectRef2;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) flowKt__ErrorsKt$catchImpl$1.L$0;
            try {
                ResultKt.b(obj);
                return null;
            } catch (Throwable th3) {
                th = th3;
            }
        }
        Throwable th4 = (Throwable) objectRef.element;
        if (d(th, th4) || c(th, flowKt__ErrorsKt$catchImpl$1.getContext())) {
            throw th;
        }
        if (th4 == null) {
            return th;
        }
        if (th instanceof CancellationException) {
            v10.b.a(th4, th);
            throw th4;
        }
        v10.b.a(th, th4);
        throw th;
    }

    public static final boolean c(Throwable th2, CoroutineContext coroutineContext) {
        q1 q1Var = (q1) coroutineContext.get(q1.f69514j8);
        if (q1Var == null || !q1Var.isCancelled()) {
            return false;
        }
        return d(th2, q1Var.getCancellationException());
    }

    public static final boolean d(Throwable th2, Throwable th3) {
        return th3 != null && Intrinsics.b(th3, th2);
    }

    public static final <T> a<T> e(a<? extends T> aVar, long j11, Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        if (j11 > 0) {
            return c.x(aVar, new FlowKt__ErrorsKt$retry$3(j11, function2, null));
        }
        throw new IllegalArgumentException(("Expected positive amount of retries, but had " + j11).toString());
    }

    public static /* synthetic */ a f(a aVar, long j11, Function2 function2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = Long.MAX_VALUE;
        }
        if ((i11 & 2) != 0) {
            function2 = new FlowKt__ErrorsKt$retry$1(null);
        }
        return c.v(aVar, j11, function2);
    }

    public static final <T> a<T> g(a<? extends T> aVar, Function4<? super b<? super T>, ? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> function4) {
        return new FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(aVar, function4);
    }
}
