package com.transsnet.downloader.adapter;

import android.text.TextUtils;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.room.api.IAudioApi;
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
@DebugMetadata(c = "com.transsnet.downloader.adapter.DownloadedHolder$initData$7", f = "DownloadedHolder.kt", l = {279}, m = "invokeSuspend")
public final class DownloadedHolder$initData$7 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ e9.a $item;
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ DownloadedHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadedHolder$initData$7(e9.a aVar, DownloadedHolder downloadedHolder, int i11, Continuation<? super DownloadedHolder$initData$7> continuation) {
        super(2, continuation);
        this.$item = aVar;
        this.this$0 = downloadedHolder;
        this.$position = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadedHolder$initData$7(this.$item, this.this$0, this.$position, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadedHolder$initData$7) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0043  */
    /* JADX WARN: Code duplicated, block: B:28:0x0136  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AudioBean audioBean;
        Object objC;
        IAudioApi iAudioApiR;
        IAudioApi iAudioApiR2;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            String url = ((DownloadBean) this.$item).getUrl();
            if (!TextUtils.isEmpty(url)) {
                rr.a aVarQ = this.this$0.q();
                if (aVarQ != null) {
                    this.label = 1;
                    objC = aVarQ.c(url, this);
                    if (objC == objE) {
                        return objE;
                    }
                } else {
                    audioBean = null;
                }
                if (audioBean == null) {
                    audioBean = new AudioBean(((DownloadBean) this.$item).getUrl(), ((DownloadBean) this.$item).getCover(), Boxing.e(0L), ((DownloadBean) this.$item).getSize(), ((DownloadBean) this.$item).getPath(), ((DownloadBean) this.$item).getName(), null, null, null, null, null, null, null, null, null, null, 0, ((DownloadBean) this.$item).getSubjectName(), 0, 0, 917440, null);
                    audioBean.setPostId(((DownloadBean) this.$item).getPostId());
                    audioBean.setResourceId(((DownloadBean) this.$item).getResourceId());
                    audioBean.setSubjectId(((DownloadBean) this.$item).getSubjectId());
                    audioBean.setGroupId(((DownloadBean) this.$item).getGroupId());
                }
                uo.b.a.f(uo.b.f78622a, "audioPlay", "registerAudioListener,adapterPosition = " + this.$position + ", name = " + ((DownloadBean) this.$item).getName() + ", audioStatus = " + ((DownloadBean) this.$item).getAudioStatus() + ", status = " + audioBean.getStatus(), false, 4, null);
                iAudioApiR = this.this$0.r();
                if (iAudioApiR == null && iAudioApiR.D(audioBean) && (iAudioApiR2 = this.this$0.r()) != null && iAudioApiR2.p1()) {
                    audioBean.setStatus(3);
                    ((DownloadBean) this.$item).setAudioStatus(3);
                } else {
                    audioBean.setStatus(4);
                    ((DownloadBean) this.$item).setAudioStatus(4);
                }
                this.this$0.C((DownloadBean) this.$item, audioBean);
                this.this$0.B(audioBean.getReadProcess(), audioBean.getDuration(), audioBean.getStatus(), 1);
            }
            return Unit.f68710a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        objC = obj;
        audioBean = (AudioBean) objC;
        if (audioBean == null) {
            audioBean = new AudioBean(((DownloadBean) this.$item).getUrl(), ((DownloadBean) this.$item).getCover(), Boxing.e(0L), ((DownloadBean) this.$item).getSize(), ((DownloadBean) this.$item).getPath(), ((DownloadBean) this.$item).getName(), null, null, null, null, null, null, null, null, null, null, 0, ((DownloadBean) this.$item).getSubjectName(), 0, 0, 917440, null);
            audioBean.setPostId(((DownloadBean) this.$item).getPostId());
            audioBean.setResourceId(((DownloadBean) this.$item).getResourceId());
            audioBean.setSubjectId(((DownloadBean) this.$item).getSubjectId());
            audioBean.setGroupId(((DownloadBean) this.$item).getGroupId());
        }
        uo.b.a.f(uo.b.f78622a, "audioPlay", "registerAudioListener,adapterPosition = " + this.$position + ", name = " + ((DownloadBean) this.$item).getName() + ", audioStatus = " + ((DownloadBean) this.$item).getAudioStatus() + ", status = " + audioBean.getStatus(), false, 4, null);
        iAudioApiR = this.this$0.r();
        if (iAudioApiR == null) {
            audioBean.setStatus(4);
            ((DownloadBean) this.$item).setAudioStatus(4);
        } else {
            audioBean.setStatus(4);
            ((DownloadBean) this.$item).setAudioStatus(4);
        }
        this.this$0.C((DownloadBean) this.$item, audioBean);
        this.this$0.B(audioBean.getReadProcess(), audioBean.getDuration(), audioBean.getStatus(), 1);
        return Unit.f68710a;
    }
}
