package com.transsnet.downloader.fragment;

import android.content.Context;
import android.view.View;
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
@DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadingListFragment$openAudio$1", f = "DownloadingListFragment.kt", l = {273, 273}, m = "invokeSuspend")
public final class DownloadingListFragment$openAudio$1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadBean $item;
    Object L$0;
    int label;
    final /* synthetic */ DownloadingListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadingListFragment$openAudio$1(DownloadingListFragment downloadingListFragment, DownloadBean downloadBean, Continuation<? super DownloadingListFragment$openAudio$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadingListFragment;
        this.$item = downloadBean;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadingListFragment$openAudio$1(this.this$0, this.$item, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadingListFragment$openAudio$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0097  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AppCompatActivity appCompatActivity;
        Object objD;
        AudioBean audioBean;
        Object objC;
        AppCompatActivity appCompatActivity2;
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
                String url = this.$item.getUrl();
                String cover = this.$item.getCover();
                Long size = this.$item.getSize();
                String url2 = this.$item.getUrl();
                String name = this.$item.getName();
                String subjectId = this.$item.getSubjectId();
                audioBean = new AudioBean(url, cover, Boxing.e(0L), size, url2, name, null, null, null, null, null, null, null, this.$item.getPostId(), subjectId, null, 0, this.$item.getSubjectName(), this.$item.getSe(), this.$item.getEp(), 106432, null);
                audioBean.setPostId(this.$item.getPostId());
                audioBean.setResourceId(this.$item.getResourceId());
                audioBean.setSubjectId(this.$item.getSubjectId());
                audioBean.setGroupId(this.$item.getGroupId());
            }
            if (this.this$0.r1().p1() || !this.this$0.r1().D(audioBean)) {
                IAudioApi.a.a(this.this$0.r1(), audioBean, false, 2, null);
            } else {
                this.this$0.r1().pause();
            }
            this.this$0.s1().y(new WeakReference<>(appCompatActivity), audioBean);
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        View view = this.this$0.getView();
        Context context = view != null ? view.getContext() : null;
        appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity == null) {
            return Unit.f68710a;
        }
        this.this$0.q1().j(this.$item);
        rr.a aVarP1 = this.this$0.p1();
        String resourceId = this.$item.getResourceId();
        if (resourceId == null) {
            resourceId = this.$item.getUrl();
        }
        this.L$0 = appCompatActivity;
        this.label = 1;
        objD = aVarP1.d(resourceId, this);
        if (objD == objE) {
            return objE;
        }
        audioBean = (AudioBean) objD;
        if (audioBean == null) {
            rr.a aVarP2 = this.this$0.p1();
            String url3 = this.$item.getUrl();
            this.L$0 = appCompatActivity;
            this.label = 2;
            objC = aVarP2.c(url3, this);
            if (objC == objE) {
                return objE;
            }
            appCompatActivity2 = appCompatActivity;
            audioBean = (AudioBean) objC;
            appCompatActivity = appCompatActivity2;
        }
        if (audioBean == null) {
            String url4 = this.$item.getUrl();
            String cover2 = this.$item.getCover();
            Long size2 = this.$item.getSize();
            String url5 = this.$item.getUrl();
            String name2 = this.$item.getName();
            String subjectId2 = this.$item.getSubjectId();
            audioBean = new AudioBean(url4, cover2, Boxing.e(0L), size2, url5, name2, null, null, null, null, null, null, null, this.$item.getPostId(), subjectId2, null, 0, this.$item.getSubjectName(), this.$item.getSe(), this.$item.getEp(), 106432, null);
            audioBean.setPostId(this.$item.getPostId());
            audioBean.setResourceId(this.$item.getResourceId());
            audioBean.setSubjectId(this.$item.getSubjectId());
            audioBean.setGroupId(this.$item.getGroupId());
        }
        if (this.this$0.r1().p1()) {
            IAudioApi.a.a(this.this$0.r1(), audioBean, false, 2, null);
        } else {
            IAudioApi.a.a(this.this$0.r1(), audioBean, false, 2, null);
        }
        this.this$0.s1().y(new WeakReference<>(appCompatActivity), audioBean);
        return Unit.f68710a;
    }
}
