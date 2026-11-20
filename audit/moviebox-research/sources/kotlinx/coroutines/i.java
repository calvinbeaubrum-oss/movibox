package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
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
public final /* synthetic */ class i {
    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    public static final <T> T a(CoroutineContext coroutineContext, Function2<? super k0, ? super Continuation<? super T>, ? extends Object> function2) throws InterruptedException {
        c1 c1VarA;
        CoroutineContext coroutineContextE;
        Thread threadCurrentThread = Thread.currentThread();
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.f68810h8);
        if (continuationInterceptor == null) {
            c1VarA = o2.f69509a.b();
            coroutineContextE = CoroutineContextKt.e(j1.f69500a, coroutineContext.plus(c1VarA));
        } else {
            c1 c1Var = continuationInterceptor instanceof c1 ? (c1) continuationInterceptor : null;
            if (c1Var == null) {
                c1VarA = o2.f69509a.a();
            } else {
                c1 c1Var2 = c1Var.shouldBeProcessedFromContext() ? c1Var : null;
                if (c1Var2 == null) {
                    c1VarA = o2.f69509a.a();
                } else {
                    c1VarA = c1Var2;
                }
            }
            coroutineContextE = CoroutineContextKt.e(j1.f69500a, coroutineContext);
        }
        f fVar = new f(coroutineContextE, threadCurrentThread, c1VarA);
        fVar.start(CoroutineStart.DEFAULT, fVar, function2);
        return (T) fVar.s();
    }

    public static /* synthetic */ Object b(CoroutineContext coroutineContext, Function2 function2, int i11, Object obj) throws InterruptedException {
        if ((i11 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return h.e(coroutineContext, function2);
    }
}
