package com.transsnet.downloader.adapter;

import android.text.TextUtils;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baselib.db.download.DownloadBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
@DebugMetadata(c = "com.transsnet.downloader.adapter.DownloadExpandAdapter$upDateAudioName$1", f = "DownloadExpandAdapter.kt", l = {226, 237}, m = "invokeSuspend")
public final class DownloadExpandAdapter$upDateAudioName$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ e9.a $item;
    int label;
    final /* synthetic */ DownloadExpandAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadExpandAdapter$upDateAudioName$1(e9.a aVar, DownloadExpandAdapter downloadExpandAdapter, Continuation<? super DownloadExpandAdapter$upDateAudioName$1> continuation) {
        super(2, continuation);
        this.$item = aVar;
        this.this$0 = downloadExpandAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadExpandAdapter$upDateAudioName$1(this.$item, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadExpandAdapter$upDateAudioName$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x004b  */
    /* JADX WARN: Code duplicated, block: B:23:0x00da  */
    /* JADX WARN: Code duplicated, block: B:25:0x00e2 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AudioBean audioBean;
        Object objC;
        rr.a aVarO0;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            String url = ((DownloadBean) this.$item).getUrl();
            if (!TextUtils.isEmpty(url)) {
                rr.a aVarO1 = this.this$0.O0();
                if (aVarO1 != null) {
                    this.label = 1;
                    objC = aVarO1.c(url, this);
                    if (objC == objE) {
                        return objE;
                    }
                    audioBean = (AudioBean) objC;
                } else {
                    audioBean = null;
                }
                if (audioBean == null) {
                    audioBean = new AudioBean(((DownloadBean) this.$item).getUrl(), ((DownloadBean) this.$item).getCover(), Boxing.e(0L), ((DownloadBean) this.$item).getSize(), ((DownloadBean) this.$item).getPath(), ((DownloadBean) this.$item).getName(), null, null, null, null, null, null, null, null, null, null, 0, null, 0, 0, 1048512, null);
                    audioBean.setPostId(((DownloadBean) this.$item).getPostId());
                    audioBean.setResourceId(((DownloadBean) this.$item).getResourceId());
                    audioBean.setSubjectId(((DownloadBean) this.$item).getSubjectId());
                    audioBean.setGroupId(((DownloadBean) this.$item).getGroupId());
                }
                audioBean.setTitle(((DownloadBean) this.$item).getName());
                aVarO0 = this.this$0.O0();
                if (aVarO0 != null) {
                    this.label = 2;
                    if (aVarO0.f(audioBean, this) == objE) {
                        return objE;
                    }
                }
            }
        } else if (i11 == 1) {
            ResultKt.b(obj);
            objC = obj;
            audioBean = (AudioBean) objC;
            if (audioBean == null) {
                audioBean = new AudioBean(((DownloadBean) this.$item).getUrl(), ((DownloadBean) this.$item).getCover(), Boxing.e(0L), ((DownloadBean) this.$item).getSize(), ((DownloadBean) this.$item).getPath(), ((DownloadBean) this.$item).getName(), null, null, null, null, null, null, null, null, null, null, 0, null, 0, 0, 1048512, null);
                audioBean.setPostId(((DownloadBean) this.$item).getPostId());
                audioBean.setResourceId(((DownloadBean) this.$item).getResourceId());
                audioBean.setSubjectId(((DownloadBean) this.$item).getSubjectId());
                audioBean.setGroupId(((DownloadBean) this.$item).getGroupId());
            }
            audioBean.setTitle(((DownloadBean) this.$item).getName());
            aVarO0 = this.this$0.O0();
            if (aVarO0 != null) {
                this.label = 2;
                if (aVarO0.f(audioBean, this) == objE) {
                    return objE;
                }
            }
        } else {
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }
}
