package com.transsion.audio.viewmodel;

import com.transsion.baselib.db.audio.AudioBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.h;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.w0;
import rr.a;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.audio.viewmodel.HistoryListManager$addToList$1", f = "HistoryListManager.kt", l = {102}, m = "invokeSuspend")
public final class HistoryListManager$addToList$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ AudioBean $audioBean;
    int label;
    final /* synthetic */ HistoryListManager this$0;

    /* JADX INFO: renamed from: com.transsion.audio.viewmodel.HistoryListManager$addToList$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.audio.viewmodel.HistoryListManager$addToList$1$1", f = "HistoryListManager.kt", l = {104, 106, 108}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ AudioBean $audioBean;
        int label;
        final /* synthetic */ HistoryListManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AudioBean audioBean, HistoryListManager historyListManager, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$audioBean = audioBean;
            this.this$0 = historyListManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$audioBean, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        /* JADX WARN: Code duplicated, block: B:31:0x0082 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            List list;
            a aVarJ;
            AudioBean audioBean;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 != 0) {
                if (i11 == 1) {
                    ResultKt.b(obj);
                } else if (i11 == 2) {
                    ResultKt.b(obj);
                    list = (List) obj;
                    if (list != null && list.size() > 30 && (aVarJ = this.this$0.j()) != null) {
                        audioBean = (AudioBean) list.get(list.size() - 1);
                        this.label = 3;
                        if (aVarJ.b(audioBean, this) == objE) {
                            return objE;
                        }
                    }
                } else {
                    if (i11 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            this.$audioBean.setUpdateTimeStamp(Boxing.e(System.currentTimeMillis()));
            a aVarJ2 = this.this$0.j();
            if (aVarJ2 != null) {
                AudioBean audioBean2 = this.$audioBean;
                this.label = 1;
                if (aVarJ2.h(audioBean2, this) == objE) {
                    return objE;
                }
            }
            a aVarJ3 = this.this$0.j();
            if (aVarJ3 != null) {
                this.label = 2;
                obj = aVarJ3.e(this);
                if (obj == objE) {
                    return objE;
                }
                list = (List) obj;
            } else {
                list = null;
            }
            if (list != null) {
                audioBean = (AudioBean) list.get(list.size() - 1);
                this.label = 3;
                if (aVarJ.b(audioBean, this) == objE) {
                    return objE;
                }
            }
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoryListManager$addToList$1(AudioBean audioBean, HistoryListManager historyListManager, Continuation<? super HistoryListManager$addToList$1> continuation) {
        super(2, continuation);
        this.$audioBean = audioBean;
        this.this$0 = historyListManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HistoryListManager$addToList$1(this.$audioBean, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((HistoryListManager$addToList$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            CoroutineDispatcher coroutineDispatcherB = w0.b();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$audioBean, this.this$0, null);
            this.label = 1;
            if (h.g(coroutineDispatcherB, anonymousClass1, this) == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }
}
