package com.transsnet.downloader;

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
@DebugMetadata(c = "com.transsnet.downloader.DownloadManagerApi$opnAudio$1", f = "DownloadManagerApi.kt", l = {957, 957}, m = "invokeSuspend")
public final class DownloadManagerApi$opnAudio$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    Object L$0;
    int label;
    final /* synthetic */ DownloadManagerApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadManagerApi$opnAudio$1(DownloadManagerApi downloadManagerApi, Context context, Continuation<? super DownloadManagerApi$opnAudio$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadManagerApi;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadManagerApi$opnAudio$1(this.this$0, this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadManagerApi$opnAudio$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:38:0x0119  */
    /* JADX WARN: Code duplicated, block: B:39:0x0120  */
    /* JADX WARN: Code duplicated, block: B:42:0x012a  */
    /* JADX WARN: Code duplicated, block: B:43:0x0131  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AppCompatActivity appCompatActivity;
        Object objD;
        AudioBean audioBean;
        Object objC;
        AppCompatActivity appCompatActivity2;
        DownloadBean downloadBean;
        int se2;
        DownloadBean downloadBean2;
        int ep2;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 == 1) {
                appCompatActivity = (AppCompatActivity) this.L$0;
                ResultKt.b(obj);
                objD = obj;
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                appCompatActivity2 = (AppCompatActivity) this.L$0;
                ResultKt.b(obj);
                objC = obj;
            }
            audioBean = (AudioBean) objC;
            appCompatActivity = appCompatActivity2;
            if (audioBean == null) {
                DownloadBean downloadBean3 = this.this$0.f60280e;
                Intrinsics.d(downloadBean3);
                String url = downloadBean3.getUrl();
                DownloadBean downloadBean4 = this.this$0.f60280e;
                Intrinsics.d(downloadBean4);
                String cover = downloadBean4.getCover();
                Long lE = Boxing.e(0L);
                DownloadBean downloadBean5 = this.this$0.f60280e;
                Intrinsics.d(downloadBean5);
                Long size = downloadBean5.getSize();
                DownloadBean downloadBean6 = this.this$0.f60280e;
                Intrinsics.d(downloadBean6);
                String url2 = downloadBean6.getUrl();
                DownloadBean downloadBean7 = this.this$0.f60280e;
                Intrinsics.d(downloadBean7);
                String name = downloadBean7.getName();
                downloadBean = this.this$0.f60280e;
                if (downloadBean != null) {
                    se2 = downloadBean.getSe();
                } else {
                    se2 = 0;
                }
                downloadBean2 = this.this$0.f60280e;
                if (downloadBean2 != null) {
                    ep2 = downloadBean2.getEp();
                } else {
                    ep2 = 0;
                }
                audioBean = new AudioBean(url, cover, lE, size, url2, name, null, null, null, null, null, null, null, null, null, null, 0, null, se2, ep2, 262080, null);
                DownloadBean downloadBean8 = this.this$0.f60280e;
                Intrinsics.d(downloadBean8);
                audioBean.setPostId(downloadBean8.getPostId());
                DownloadBean downloadBean9 = this.this$0.f60280e;
                Intrinsics.d(downloadBean9);
                audioBean.setResourceId(downloadBean9.getResourceId());
                DownloadBean downloadBean10 = this.this$0.f60280e;
                Intrinsics.d(downloadBean10);
                audioBean.setSubjectId(downloadBean10.getSubjectId());
                DownloadBean downloadBean11 = this.this$0.f60280e;
                Intrinsics.d(downloadBean11);
                audioBean.setGroupId(downloadBean11.getGroupId());
            }
            this.this$0.h2().y(new WeakReference<>(appCompatActivity), audioBean);
            IAudioApi.a.a(this.this$0.g2(), audioBean, false, 2, null);
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        if (this.this$0.f60280e == null) {
            return Unit.f68710a;
        }
        Context context = this.$context;
        appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity == null) {
            return Unit.f68710a;
        }
        com.transsnet.downloader.manager.a aVarF2 = this.this$0.f2();
        DownloadBean downloadBean12 = this.this$0.f60280e;
        Intrinsics.d(downloadBean12);
        aVarF2.j(downloadBean12);
        rr.a aVarE2 = this.this$0.e2();
        DownloadBean downloadBean13 = this.this$0.f60280e;
        Intrinsics.d(downloadBean13);
        String resourceId = downloadBean13.getResourceId();
        if (resourceId == null) {
            DownloadBean downloadBean14 = this.this$0.f60280e;
            Intrinsics.d(downloadBean14);
            resourceId = downloadBean14.getUrl();
        }
        this.L$0 = appCompatActivity;
        this.label = 1;
        objD = aVarE2.d(resourceId, this);
        if (objD == objE) {
            return objE;
        }
        audioBean = (AudioBean) objD;
        if (audioBean == null) {
            rr.a aVarE3 = this.this$0.e2();
            DownloadBean downloadBean15 = this.this$0.f60280e;
            Intrinsics.d(downloadBean15);
            String url3 = downloadBean15.getUrl();
            this.L$0 = appCompatActivity;
            this.label = 2;
            objC = aVarE3.c(url3, this);
            if (objC == objE) {
                return objE;
            }
            appCompatActivity2 = appCompatActivity;
            audioBean = (AudioBean) objC;
            appCompatActivity = appCompatActivity2;
        }
        if (audioBean == null) {
            DownloadBean downloadBean16 = this.this$0.f60280e;
            Intrinsics.d(downloadBean16);
            String url4 = downloadBean16.getUrl();
            DownloadBean downloadBean17 = this.this$0.f60280e;
            Intrinsics.d(downloadBean17);
            String cover2 = downloadBean17.getCover();
            Long lE2 = Boxing.e(0L);
            DownloadBean downloadBean18 = this.this$0.f60280e;
            Intrinsics.d(downloadBean18);
            Long size2 = downloadBean18.getSize();
            DownloadBean downloadBean19 = this.this$0.f60280e;
            Intrinsics.d(downloadBean19);
            String url5 = downloadBean19.getUrl();
            DownloadBean downloadBean20 = this.this$0.f60280e;
            Intrinsics.d(downloadBean20);
            String name2 = downloadBean20.getName();
            downloadBean = this.this$0.f60280e;
            if (downloadBean != null) {
                se2 = downloadBean.getSe();
            } else {
                se2 = 0;
            }
            downloadBean2 = this.this$0.f60280e;
            if (downloadBean2 != null) {
                ep2 = downloadBean2.getEp();
            } else {
                ep2 = 0;
            }
            audioBean = new AudioBean(url4, cover2, lE2, size2, url5, name2, null, null, null, null, null, null, null, null, null, null, 0, null, se2, ep2, 262080, null);
            DownloadBean downloadBean21 = this.this$0.f60280e;
            Intrinsics.d(downloadBean21);
            audioBean.setPostId(downloadBean21.getPostId());
            DownloadBean downloadBean22 = this.this$0.f60280e;
            Intrinsics.d(downloadBean22);
            audioBean.setResourceId(downloadBean22.getResourceId());
            DownloadBean downloadBean110 = this.this$0.f60280e;
            Intrinsics.d(downloadBean110);
            audioBean.setSubjectId(downloadBean110.getSubjectId());
            DownloadBean downloadBean111 = this.this$0.f60280e;
            Intrinsics.d(downloadBean111);
            audioBean.setGroupId(downloadBean111.getGroupId());
        }
        this.this$0.h2().y(new WeakReference<>(appCompatActivity), audioBean);
        IAudioApi.a.a(this.this$0.g2(), audioBean, false, 2, null);
        return Unit.f68710a;
    }
}
