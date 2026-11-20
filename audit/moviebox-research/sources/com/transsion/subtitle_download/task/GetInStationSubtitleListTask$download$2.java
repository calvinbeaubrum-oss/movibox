package com.transsion.subtitle_download.task;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.subtitle_download.db.SubtitleDownloadDatabase;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.subtitle_download.task.GetInStationSubtitleListTask$download$2", f = "GetInStationSubtitleListTask.kt", l = {105}, m = "invokeSuspend")
public final class GetInStationSubtitleListTask$download$2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ SubtitleDownloadTable $dbBean;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetInStationSubtitleListTask$download$2(SubtitleDownloadTable subtitleDownloadTable, Continuation<? super GetInStationSubtitleListTask$download$2> continuation) {
        super(2, continuation);
        this.$dbBean = subtitleDownloadTable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GetInStationSubtitleListTask$download$2(this.$dbBean, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((GetInStationSubtitleListTask$download$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        SubtitleDownloadTable subtitleDownloadTableC;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            SubtitleDownloadDatabase.b bVar = SubtitleDownloadDatabase.f58352p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            subtitleDownloadTableC = bVar.b(applicationA).J().c(this.$dbBean.getId(), this.$dbBean.getResourceStreamType());
            if (subtitleDownloadTableC == null) {
                Application applicationA2 = Utils.a();
                Intrinsics.f(applicationA2, "getApp()");
                dy.a aVarJ = bVar.b(applicationA2).J();
                SubtitleDownloadTable subtitleDownloadTable = this.$dbBean;
                this.label = 1;
                if (aVarJ.e(subtitleDownloadTable, this) == objE) {
                    return objE;
                }
            } else {
                subtitleDownloadTableC.setSetImmediately(this.$dbBean.isSetImmediately());
            }
            SubtitleDownloadTaskManager.f58369a.b(subtitleDownloadTableC, true);
            return Unit.f68710a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        subtitleDownloadTableC = this.$dbBean;
        SubtitleDownloadTaskManager.f58369a.b(subtitleDownloadTableC, true);
        return Unit.f68710a;
    }
}
