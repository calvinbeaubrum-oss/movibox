package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.t1;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class SafeCollector<T> extends ContinuationImpl implements kotlinx.coroutines.flow.b<T> {

    @JvmField
    public final CoroutineContext collectContext;

    @JvmField
    public final int collectContextSize;

    @JvmField
    public final kotlinx.coroutines.flow.b<T> collector;
    private Continuation<? super Unit> completion_;
    private CoroutineContext lastEmissionContext;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector(kotlinx.coroutines.flow.b<? super T> bVar, CoroutineContext coroutineContext) {
        super(k.f69413a, EmptyCoroutineContext.INSTANCE);
        this.collector = bVar;
        this.collectContext = coroutineContext;
        this.collectContextSize = ((Number) coroutineContext.fold(0, new Function2<Integer, CoroutineContext.Element, Integer>() { // from class: kotlinx.coroutines.flow.internal.SafeCollector$collectContextSize$1
            public final Integer invoke(int i11, CoroutineContext.Element element) {
                return Integer.valueOf(i11 + 1);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(Integer num, CoroutineContext.Element element) {
                return invoke(num.intValue(), element);
            }
        })).intValue();
    }

    private final void checkContext(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, T t11) {
        if (coroutineContext2 instanceof f) {
            exceptionTransparencyViolated((f) coroutineContext2, t11);
        }
        SafeCollector_commonKt.a(this, coroutineContext);
    }

    private final Object emit(Continuation<? super Unit> continuation, T t11) {
        CoroutineContext context = continuation.getContext();
        t1.j(context);
        CoroutineContext coroutineContext = this.lastEmissionContext;
        if (coroutineContext != context) {
            checkContext(context, coroutineContext, t11);
            this.lastEmissionContext = context;
        }
        this.completion_ = continuation;
        Function3 function3 = SafeCollectorKt.f69402a;
        kotlinx.coroutines.flow.b<T> bVar = this.collector;
        Intrinsics.e(bVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        Intrinsics.e(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object objInvoke = function3.invoke(bVar, t11, this);
        if (!Intrinsics.b(objInvoke, kotlin.coroutines.intrinsics.a.e())) {
            this.completion_ = null;
        }
        return objInvoke;
    }

    private final void exceptionTransparencyViolated(f fVar, Object obj) {
        throw new IllegalStateException(StringsKt__IndentKt.f("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + fVar.f69411a + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    @Override // kotlinx.coroutines.flow.b
    public Object emit(T t11, Continuation<? super Unit> continuation) {
        try {
            Object objEmit = emit(continuation, t11);
            if (objEmit == kotlin.coroutines.intrinsics.a.e()) {
                DebugProbesKt.c(continuation);
            }
            return objEmit == kotlin.coroutines.intrinsics.a.e() ? objEmit : Unit.f68710a;
        } catch (Throwable th2) {
            this.lastEmissionContext = new f(th2, continuation.getContext());
            throw th2;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<? super Unit> continuation = this.completion_;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this.lastEmissionContext;
        return coroutineContext == null ? EmptyCoroutineContext.INSTANCE : coroutineContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public Object invokeSuspend(Object obj) {
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(obj);
        if (thM166exceptionOrNullimpl != null) {
            this.lastEmissionContext = new f(thM166exceptionOrNullimpl, getContext());
        }
        Continuation<? super Unit> continuation = this.completion_;
        if (continuation != null) {
            continuation.resumeWith(obj);
        }
        return kotlin.coroutines.intrinsics.a.e();
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
