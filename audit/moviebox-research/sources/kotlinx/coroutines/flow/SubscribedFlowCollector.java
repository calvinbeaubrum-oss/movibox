package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension
public final class SubscribedFlowCollector<T> implements b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b<T> f69374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<b<? super T>, Continuation<? super Unit>, Object> f69375b;

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.flow.internal.SafeCollector] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    public final Object a(Continuation<? super Unit> continuation) throws Throwable {
        SubscribedFlowCollector$onSubscription$1 subscribedFlowCollector$onSubscription$1;
        SafeCollector safeCollector;
        SubscribedFlowCollector<T> subscribedFlowCollector;
        if (continuation instanceof SubscribedFlowCollector$onSubscription$1) {
            subscribedFlowCollector$onSubscription$1 = (SubscribedFlowCollector$onSubscription$1) continuation;
            int i11 = subscribedFlowCollector$onSubscription$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                subscribedFlowCollector$onSubscription$1.label = i11 - Integer.MIN_VALUE;
            } else {
                subscribedFlowCollector$onSubscription$1 = new SubscribedFlowCollector$onSubscription$1(this, continuation);
            }
        } else {
            subscribedFlowCollector$onSubscription$1 = new SubscribedFlowCollector$onSubscription$1(this, continuation);
        }
        Object obj = subscribedFlowCollector$onSubscription$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        ?? r11 = subscribedFlowCollector$onSubscription$1.label;
        try {
            if (r11 != 0) {
                if (r11 == 1) {
                    safeCollector = (SafeCollector) subscribedFlowCollector$onSubscription$1.L$1;
                    subscribedFlowCollector = (SubscribedFlowCollector) subscribedFlowCollector$onSubscription$1.L$0;
                    ResultKt.b(obj);
                } else {
                    if (r11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            safeCollector = new SafeCollector(this.f69374a, subscribedFlowCollector$onSubscription$1.getContext());
            Function2<b<? super T>, Continuation<? super Unit>, Object> function2 = this.f69375b;
            subscribedFlowCollector$onSubscription$1.L$0 = this;
            subscribedFlowCollector$onSubscription$1.L$1 = safeCollector;
            subscribedFlowCollector$onSubscription$1.label = 1;
            if (function2.invoke(safeCollector, subscribedFlowCollector$onSubscription$1) == objE) {
                return objE;
            }
            subscribedFlowCollector = this;
            safeCollector.releaseIntercepted();
            b<T> bVar = subscribedFlowCollector.f69374a;
            r11 = bVar instanceof SubscribedFlowCollector;
            if (r11 == 0) {
                return Unit.f68710a;
            }
            subscribedFlowCollector$onSubscription$1.L$0 = null;
            subscribedFlowCollector$onSubscription$1.L$1 = null;
            subscribedFlowCollector$onSubscription$1.label = 2;
            if (((SubscribedFlowCollector) bVar).a(subscribedFlowCollector$onSubscription$1) == objE) {
                return objE;
            }
            return Unit.f68710a;
        } catch (Throwable th2) {
            r11.releaseIntercepted();
            throw th2;
        }
    }

    @Override // kotlinx.coroutines.flow.b
    public Object emit(T t11, Continuation<? super Unit> continuation) {
        return this.f69374a.emit(t11, continuation);
    }
}
