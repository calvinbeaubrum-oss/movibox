package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.q1;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: Add missing generic type declarations: [R] */
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.animation.core.MutatorMutex$mutate$2", f = "InternalMutatorMutex.kt", l = {178, WebSocketProtocol.PAYLOAD_SHORT}, m = "invokeSuspend")
@SourceDebugExtension
public final class MutatorMutex$mutate$2<R> extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super R>, Object> {
    final /* synthetic */ Function1<Continuation<? super R>, Object> $block;
    final /* synthetic */ MutatePriority $priority;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ MutatorMutex this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MutatorMutex$mutate$2(MutatePriority mutatePriority, MutatorMutex mutatorMutex, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super MutatorMutex$mutate$2> continuation) {
        super(2, continuation);
        this.$priority = mutatePriority;
        this.this$0 = mutatorMutex;
        this.$block = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MutatorMutex$mutate$2 mutatorMutex$mutate$2 = new MutatorMutex$mutate$2(this.$priority, this.this$0, this.$block, continuation);
        mutatorMutex$mutate$2.L$0 = obj;
        return mutatorMutex$mutate$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super R> continuation) {
        return ((MutatorMutex$mutate$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [int, kotlinx.coroutines.sync.a] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlinx.coroutines.sync.a aVar;
        Function1<Continuation<? super R>, Object> function1;
        MutatorMutex.a aVar2;
        MutatorMutex mutatorMutex;
        MutatorMutex.a aVar3;
        Throwable th2;
        MutatorMutex mutatorMutex2;
        kotlinx.coroutines.sync.a aVar4;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        ?? r11 = this.label;
        try {
            try {
                if (r11 == 0) {
                    ResultKt.b(obj);
                    kotlinx.coroutines.k0 k0Var = (kotlinx.coroutines.k0) this.L$0;
                    MutatePriority mutatePriority = this.$priority;
                    CoroutineContext.Element element = k0Var.getCoroutineContext().get(q1.f69514j8);
                    Intrinsics.d(element);
                    MutatorMutex.a aVar5 = new MutatorMutex.a(mutatePriority, (q1) element);
                    this.this$0.f(aVar5);
                    aVar = this.this$0.f2028b;
                    Function1<Continuation<? super R>, Object> function2 = this.$block;
                    MutatorMutex mutatorMutex3 = this.this$0;
                    this.L$0 = aVar5;
                    this.L$1 = aVar;
                    this.L$2 = function2;
                    this.L$3 = mutatorMutex3;
                    this.label = 1;
                    if (aVar.a(null, this) == objE) {
                        return objE;
                    }
                    function1 = function2;
                    aVar2 = aVar5;
                    mutatorMutex = mutatorMutex3;
                } else {
                    if (r11 != 1) {
                        if (r11 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        mutatorMutex2 = (MutatorMutex) this.L$2;
                        aVar4 = (kotlinx.coroutines.sync.a) this.L$1;
                        aVar3 = (MutatorMutex.a) this.L$0;
                        try {
                            ResultKt.b(obj);
                            j0.a(mutatorMutex2.f2027a, aVar3, null);
                            aVar4.unlock(null);
                            return obj;
                        } catch (Throwable th3) {
                            th2 = th3;
                            j0.a(mutatorMutex2.f2027a, aVar3, null);
                            throw th2;
                        }
                    }
                    mutatorMutex = (MutatorMutex) this.L$3;
                    function1 = (Function1) this.L$2;
                    kotlinx.coroutines.sync.a aVar6 = (kotlinx.coroutines.sync.a) this.L$1;
                    aVar2 = (MutatorMutex.a) this.L$0;
                    ResultKt.b(obj);
                    aVar = aVar6;
                }
                this.L$0 = aVar2;
                this.L$1 = aVar;
                this.L$2 = mutatorMutex;
                this.L$3 = null;
                this.label = 2;
                Object objInvoke = function1.invoke(this);
                if (objInvoke == objE) {
                    return objE;
                }
                mutatorMutex2 = mutatorMutex;
                aVar4 = aVar;
                obj = objInvoke;
                aVar3 = aVar2;
                j0.a(mutatorMutex2.f2027a, aVar3, null);
                aVar4.unlock(null);
                return obj;
            } catch (Throwable th4) {
                aVar3 = aVar2;
                th2 = th4;
                mutatorMutex2 = mutatorMutex;
                j0.a(mutatorMutex2.f2027a, aVar3, null);
                throw th2;
            }
        } catch (Throwable th5) {
            r11.unlock(null);
            throw th5;
        }
    }
}
