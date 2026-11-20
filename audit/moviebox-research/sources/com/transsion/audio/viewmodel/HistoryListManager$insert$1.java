package com.transsion.audio.viewmodel;

import com.transsion.baselib.db.audio.AudioBean;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import f00.d;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k0;
import uo.b;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.audio.viewmodel.HistoryListManager$insert$1", f = "HistoryListManager.kt", l = {118, 119}, m = "invokeSuspend")
@SourceDebugExtension
public final class HistoryListManager$insert$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ AudioBean $audioBean;
    int label;
    final /* synthetic */ HistoryListManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoryListManager$insert$1(AudioBean audioBean, HistoryListManager historyListManager, Continuation<? super HistoryListManager$insert$1> continuation) {
        super(2, continuation);
        this.$audioBean = audioBean;
        this.this$0 = historyListManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HistoryListManager$insert$1(this.$audioBean, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((HistoryListManager$insert$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 == 1) {
                ResultKt.b(obj);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            b.a.g(b.f78622a, "audio insert ok", false, 2, null);
            d dVar = new d(true, false);
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = d.class.getName();
            Intrinsics.f(name, "T::class.java.name");
            flowEventBus.postEvent(name, dVar, 0L);
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        this.$audioBean.setUpdateTimeStamp(Boxing.e(System.currentTimeMillis()));
        rr.a aVarJ = this.this$0.j();
        if (aVarJ != null) {
            AudioBean audioBean = this.$audioBean;
            this.label = 1;
            if (aVarJ.h(audioBean, this) == objE) {
                return objE;
            }
        }
        DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
        String resourceId = this.$audioBean.getResourceId();
        if (resourceId == null) {
            resourceId = this.$audioBean.getAudioUrl();
        }
        Long readProcess = this.$audioBean.getReadProcess();
        long jLongValue = readProcess != null ? readProcess.longValue() : 0L;
        this.label = 2;
        if (downloadEsHelperA.S(resourceId, jLongValue, this) == objE) {
            return objE;
        }
        b.a.g(b.f78622a, "audio insert ok", false, 2, null);
        d dVar2 = new d(true, false);
        FlowEventBus flowEventBus2 = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = d.class.getName();
        Intrinsics.f(name2, "T::class.java.name");
        flowEventBus2.postEvent(name2, dVar2, 0L);
        return Unit.f68710a;
    }
}
