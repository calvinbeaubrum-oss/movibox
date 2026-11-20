package com.transsnet.downloader.view;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.room.api.IAudioApi;
import java.lang.ref.WeakReference;
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
@DebugMetadata(c = "com.transsnet.downloader.view.DownloadingTipsDialogFragment$opnAudio$1", f = "DownloadingTipsDialogFragment.kt", l = {295}, m = "invokeSuspend")
public final class DownloadingTipsDialogFragment$opnAudio$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ DownloadingTipsDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadingTipsDialogFragment$opnAudio$1(DownloadingTipsDialogFragment downloadingTipsDialogFragment, Continuation<? super DownloadingTipsDialogFragment$opnAudio$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadingTipsDialogFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadingTipsDialogFragment$opnAudio$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadingTipsDialogFragment$opnAudio$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objC;
        AppCompatActivity appCompatActivity;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            Context context = this.this$0.getContext();
            AppCompatActivity appCompatActivity2 = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
            if (appCompatActivity2 == null) {
                return Unit.f68710a;
            }
            com.transsnet.downloader.manager.a aVarZ0 = this.this$0.z0();
            DownloadBean downloadBean = this.this$0.f61180k;
            Intrinsics.d(downloadBean);
            aVarZ0.j(downloadBean);
            rr.a aVarY0 = this.this$0.y0();
            DownloadBean downloadBean2 = this.this$0.f61180k;
            Intrinsics.d(downloadBean2);
            String url = downloadBean2.getUrl();
            this.L$0 = appCompatActivity2;
            this.label = 1;
            objC = aVarY0.c(url, this);
            if (objC == objE) {
                return objE;
            }
            appCompatActivity = appCompatActivity2;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            appCompatActivity = (AppCompatActivity) this.L$0;
            ResultKt.b(obj);
            objC = obj;
        }
        AudioBean audioBean = (AudioBean) objC;
        if (audioBean == null) {
            DownloadBean downloadBean3 = this.this$0.f61180k;
            Intrinsics.d(downloadBean3);
            String url2 = downloadBean3.getUrl();
            DownloadBean downloadBean4 = this.this$0.f61180k;
            Intrinsics.d(downloadBean4);
            String cover = downloadBean4.getCover();
            DownloadBean downloadBean5 = this.this$0.f61180k;
            Intrinsics.d(downloadBean5);
            Long size = downloadBean5.getSize();
            DownloadBean downloadBean6 = this.this$0.f61180k;
            Intrinsics.d(downloadBean6);
            String url3 = downloadBean6.getUrl();
            DownloadBean downloadBean7 = this.this$0.f61180k;
            Intrinsics.d(downloadBean7);
            String name = downloadBean7.getName();
            DownloadBean downloadBean8 = this.this$0.f61180k;
            String subjectId = downloadBean8 != null ? downloadBean8.getSubjectId() : null;
            DownloadBean downloadBean9 = this.this$0.f61180k;
            String postId = downloadBean9 != null ? downloadBean9.getPostId() : null;
            DownloadBean downloadBean10 = this.this$0.f61180k;
            int se2 = downloadBean10 != null ? downloadBean10.getSe() : 0;
            DownloadBean downloadBean11 = this.this$0.f61180k;
            int ep2 = downloadBean11 != null ? downloadBean11.getEp() : 0;
            DownloadBean downloadBean12 = this.this$0.f61180k;
            audioBean = new AudioBean(url2, cover, Boxing.e(0L), size, url3, name, null, null, null, null, null, null, null, postId, subjectId, null, 0, downloadBean12 != null ? downloadBean12.getSubjectName() : null, se2, ep2, 106432, null);
            DownloadBean downloadBean13 = this.this$0.f61180k;
            Intrinsics.d(downloadBean13);
            audioBean.setPostId(downloadBean13.getPostId());
            DownloadBean downloadBean14 = this.this$0.f61180k;
            Intrinsics.d(downloadBean14);
            audioBean.setResourceId(downloadBean14.getResourceId());
            DownloadBean downloadBean15 = this.this$0.f61180k;
            Intrinsics.d(downloadBean15);
            audioBean.setSubjectId(downloadBean15.getSubjectId());
            DownloadBean downloadBean16 = this.this$0.f61180k;
            Intrinsics.d(downloadBean16);
            audioBean.setGroupId(downloadBean16.getGroupId());
        }
        this.this$0.B0().y(new WeakReference<>(appCompatActivity), audioBean);
        IAudioApi.a.a(this.this$0.A0(), audioBean, false, 2, null);
        return Unit.f68710a;
    }
}
