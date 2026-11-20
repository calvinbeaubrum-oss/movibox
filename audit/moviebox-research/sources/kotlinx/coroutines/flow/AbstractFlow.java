package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.internal.SafeCollector;

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
public abstract class AbstractFlow<T> implements a<T> {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.a
    public final Object a(b<? super T> bVar, Continuation<? super Unit> continuation) throws Throwable {
        AbstractFlow$collect$1 abstractFlow$collect$1;
        Throwable th2;
        SafeCollector safeCollector;
        if (continuation instanceof AbstractFlow$collect$1) {
            abstractFlow$collect$1 = (AbstractFlow$collect$1) continuation;
            int i11 = abstractFlow$collect$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                abstractFlow$collect$1.label = i11 - Integer.MIN_VALUE;
            } else {
                abstractFlow$collect$1 = new AbstractFlow$collect$1(this, continuation);
            }
        } else {
            abstractFlow$collect$1 = new AbstractFlow$collect$1(this, continuation);
        }
        Object obj = abstractFlow$collect$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = abstractFlow$collect$1.label;
        if (i12 != 0) {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            safeCollector = (SafeCollector) abstractFlow$collect$1.L$0;
            try {
                ResultKt.b(obj);
                safeCollector.releaseIntercepted();
                return Unit.f68710a;
            } catch (Throwable th3) {
                th2 = th3;
                safeCollector.releaseIntercepted();
                throw th2;
            }
        }
        ResultKt.b(obj);
        SafeCollector safeCollector2 = new SafeCollector(bVar, abstractFlow$collect$1.getContext());
        try {
            abstractFlow$collect$1.L$0 = safeCollector2;
            abstractFlow$collect$1.label = 1;
            if (g(safeCollector2, abstractFlow$collect$1) == objE) {
                return objE;
            }
            safeCollector = safeCollector2;
            safeCollector.releaseIntercepted();
            return Unit.f68710a;
        } catch (Throwable th4) {
            th2 = th4;
            safeCollector = safeCollector2;
            safeCollector.releaseIntercepted();
            throw th2;
        }
    }

    public abstract Object g(b<? super T> bVar, Continuation<? super Unit> continuation);
}
