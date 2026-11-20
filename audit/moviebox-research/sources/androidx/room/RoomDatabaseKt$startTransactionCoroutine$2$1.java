package androidx.room;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class RoomDatabaseKt$startTransactionCoroutine$2$1 implements Runnable {
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ kotlinx.coroutines.n<Object> $continuation;
    final /* synthetic */ RoomDatabase $this_startTransactionCoroutine;
    final /* synthetic */ Function2<k0, Continuation<Object>, Object> $transactionBlock;

    /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$startTransactionCoroutine$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "androidx.room.RoomDatabaseKt$startTransactionCoroutine$2$1$1", f = "RoomDatabaseExt.kt", l = {97}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ kotlinx.coroutines.n<Object> $continuation;
        final /* synthetic */ RoomDatabase $this_startTransactionCoroutine;
        final /* synthetic */ Function2<k0, Continuation<Object>, Object> $transactionBlock;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(RoomDatabase roomDatabase, kotlinx.coroutines.n<Object> nVar, Function2<? super k0, ? super Continuation<Object>, ? extends Object> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_startTransactionCoroutine = roomDatabase;
            this.$continuation = nVar;
            this.$transactionBlock = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_startTransactionCoroutine, this.$continuation, this.$transactionBlock, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Continuation continuation;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                CoroutineContext.Element element = ((k0) this.L$0).getCoroutineContext().get(ContinuationInterceptor.f68810h8);
                Intrinsics.d(element);
                CoroutineContext coroutineContextB = s.b(this.$this_startTransactionCoroutine, (ContinuationInterceptor) element);
                kotlinx.coroutines.n<Object> nVar = this.$continuation;
                Function2<k0, Continuation<Object>, Object> function2 = this.$transactionBlock;
                this.L$0 = nVar;
                this.label = 1;
                obj = kotlinx.coroutines.h.g(coroutineContextB, function2, this);
                if (obj == objE) {
                    return objE;
                }
                continuation = nVar;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                continuation = (Continuation) this.L$0;
                ResultKt.b(obj);
            }
            continuation.resumeWith(Result.m163constructorimpl(obj));
            return Unit.f68710a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RoomDatabaseKt$startTransactionCoroutine$2$1(CoroutineContext coroutineContext, kotlinx.coroutines.n<Object> nVar, RoomDatabase roomDatabase, Function2<? super k0, ? super Continuation<Object>, ? extends Object> function2) {
        this.$context = coroutineContext;
        this.$continuation = nVar;
        this.$this_startTransactionCoroutine = roomDatabase;
        this.$transactionBlock = function2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            kotlinx.coroutines.h.e(this.$context.minusKey(ContinuationInterceptor.f68810h8), new AnonymousClass1(this.$this_startTransactionCoroutine, this.$continuation, this.$transactionBlock, null));
        } catch (Throwable th2) {
            this.$continuation.cancel(th2);
        }
    }
}
