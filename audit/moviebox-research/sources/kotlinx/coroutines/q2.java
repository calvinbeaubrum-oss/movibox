package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.ThreadContextKt;

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
public final class q2<T> extends kotlinx.coroutines.internal.y<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadLocal<Pair<CoroutineContext, Object>> f69516a;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    public q2(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        r2 r2Var = r2.f69518a;
        super(coroutineContext.get(r2Var) == null ? coroutineContext.plus(r2Var) : coroutineContext, continuation);
        this.f69516a = new ThreadLocal<>();
        if (continuation.getContext().get(ContinuationInterceptor.f68810h8) instanceof CoroutineDispatcher) {
            return;
        }
        Object objC = ThreadContextKt.c(coroutineContext, null);
        ThreadContextKt.a(coroutineContext, objC);
        t(coroutineContext, objC);
    }

    @Override // kotlinx.coroutines.internal.y, kotlinx.coroutines.a
    public void afterResume(Object obj) {
        if (this.threadLocalIsSet) {
            Pair<CoroutineContext, Object> pair = this.f69516a.get();
            if (pair != null) {
                ThreadContextKt.a(pair.component1(), pair.component2());
            }
            this.f69516a.remove();
        }
        Object objA = e0.a(obj, this.uCont);
        Continuation<T> continuation = this.uCont;
        CoroutineContext context = continuation.getContext();
        Object objC = ThreadContextKt.c(context, null);
        q2<?> q2VarG = objC != ThreadContextKt.f69447a ? CoroutineContextKt.g(continuation, context, objC) : null;
        try {
            this.uCont.resumeWith(objA);
            Unit unit = Unit.f68710a;
        } finally {
            if (q2VarG == null || q2VarG.s()) {
                ThreadContextKt.a(context, objC);
            }
        }
    }

    public final boolean s() {
        boolean z11 = this.threadLocalIsSet && this.f69516a.get() == null;
        this.f69516a.remove();
        return !z11;
    }

    public final void t(CoroutineContext coroutineContext, Object obj) {
        this.threadLocalIsSet = true;
        this.f69516a.set(TuplesKt.a(coroutineContext, obj));
    }
}
