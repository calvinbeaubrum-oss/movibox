package com.transsnet.downloader.manager;

import com.blankj.utilcode.util.n;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.bean.StartRequestBean;
import com.transsnet.downloader.bean.StartlDownloadBean;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;
import okhttp3.RequestBody;

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
@DebugMetadata(c = "com.transsnet.downloader.manager.FinishDownloadHelper$onDownloadSuccess$1", f = "FinishDownloadHelper.kt", l = {36}, m = "invokeSuspend")
public final class FinishDownloadHelper$onDownloadSuccess$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadBean $bean;
    int label;
    final /* synthetic */ FinishDownloadHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FinishDownloadHelper$onDownloadSuccess$1(DownloadBean downloadBean, FinishDownloadHelper finishDownloadHelper, Continuation<? super FinishDownloadHelper$onDownloadSuccess$1> continuation) {
        super(2, continuation);
        this.$bean = downloadBean;
        this.this$0 = finishDownloadHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FinishDownloadHelper$onDownloadSuccess$1(this.$bean, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((FinishDownloadHelper$onDownloadSuccess$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                List listSingletonList = Collections.singletonList(new StartlDownloadBean(this.$bean.getSubjectId(), this.$bean.getResourceId(), Boxing.d(this.$bean.getEpse())));
                uo.b.a.f(uo.b.f78622a, this.this$0.f61056a, "onDownloadSuccess, name =  " + this.$bean.getName() + ", subjectId = " + this.$bean.getSubjectId() + ",resourceId = " + this.$bean.getResourceId() + ",episode = " + this.$bean.getEpse(), false, 4, null);
                i00.a aVarK = this.this$0.k();
                ip.b.a aVar = ip.b.f67591a;
                String strJ = n.j(new StartRequestBean(listSingletonList));
                Intrinsics.f(strJ, "toJson(StartRequestBean(newList))");
                RequestBody requestBodyA = aVar.a(strJ);
                this.label = 1;
                obj = i00.a.C0703a.b(aVarK, null, requestBodyA, this, 1, null);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return Unit.f68710a;
    }
}
