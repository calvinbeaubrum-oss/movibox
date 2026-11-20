package com.transsion.audio.fragment;

import com.transsion.audio.player.AudioPlayer;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.room.api.IAudioApi;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.audio.fragment.SubjectListFragment$initView$1$3$onPlayItem$1", f = "SubjectListFragment.kt", l = {147}, m = "invokeSuspend")
@SourceDebugExtension
public final class SubjectListFragment$initView$1$3$onPlayItem$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadItem $download;
    int label;
    final /* synthetic */ SubjectListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubjectListFragment$initView$1$3$onPlayItem$1(DownloadItem downloadItem, SubjectListFragment subjectListFragment, Continuation<? super SubjectListFragment$initView$1$3$onPlayItem$1> continuation) {
        super(2, continuation);
        this.$download = downloadItem;
        this.this$0 = subjectListFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubjectListFragment$initView$1$3$onPlayItem$1(this.$download, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((SubjectListFragment$initView$1$3$onPlayItem$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0043  */
    /* JADX WARN: Code duplicated, block: B:20:0x004f  */
    /* JADX WARN: Code duplicated, block: B:22:0x0055  */
    /* JADX WARN: Code duplicated, block: B:23:0x007a  */
    /* JADX WARN: Code duplicated, block: B:24:0x009e  */
    /* JADX WARN: Code duplicated, block: B:26:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:27:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:30:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:31:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:35:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:41:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:43:0x00fb  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AudioBean audioBean;
        rr.a aVarF0;
        Object objC;
        String url;
        Long readProcess;
        long jLongValue;
        Long duration;
        long jLongValue2;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            String url2 = this.$download.getUrl();
            audioBean = null;
            if (url2 != null && (aVarF0 = this.this$0.F0()) != null) {
                this.label = 1;
                objC = aVarF0.c(url2, this);
                if (objC == objE) {
                    return objE;
                }
            }
            if (audioBean != null) {
                url = this.$download.getUrl();
                if (url == null) {
                    url = "";
                }
                audioBean = new AudioBean(url, this.this$0.f50806a, Boxing.e(0L), this.$download.getSize(), this.$download.getUrl(), this.$download.getName(), "", Boxing.d(0), null, null, null, "", this.$download.getResourceId(), this.$download.getPostId(), this.this$0.f50808c, this.this$0.f50809d, 0, this.this$0.f50810f, this.$download.getSe(), this.$download.getEp(), 67328, null);
                this.$download.setStatus(Boxing.d(3));
                ((IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class)).s0(audioBean, false);
            } else if (AudioPlayer.f50830i.a().w(audioBean)) {
                readProcess = audioBean.getReadProcess();
                if (readProcess != null) {
                    jLongValue = readProcess.longValue();
                } else {
                    jLongValue = 0;
                }
                duration = audioBean.getDuration();
                if (duration != null) {
                    jLongValue2 = duration.longValue();
                } else {
                    jLongValue2 = -500;
                }
                boolean z11 = jLongValue >= jLongValue2;
                if (audioBean.getStatus() != 6 || z11) {
                    audioBean.setReadProcess(Boxing.e(0L));
                }
                this.this$0.f50821q.set(false);
                audioBean.setStatus(3);
                this.$download.setStatus(Boxing.d(3));
                ((IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class)).s0(audioBean, false);
            } else if (audioBean.getStatus() == 3) {
                this.this$0.f50821q.set(true);
                audioBean.setStatus(4);
                this.$download.setStatus(Boxing.d(4));
                ((IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class)).stop();
            } else {
                this.this$0.f50821q.set(false);
                audioBean.setStatus(3);
                this.$download.setStatus(Boxing.d(3));
                ((IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class)).prepare();
            }
            this.this$0.Q0(this.$download, audioBean);
            return Unit.f68710a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        objC = obj;
        audioBean = (AudioBean) objC;
        if (audioBean != null) {
            url = this.$download.getUrl();
            if (url == null) {
                url = "";
            }
            audioBean = new AudioBean(url, this.this$0.f50806a, Boxing.e(0L), this.$download.getSize(), this.$download.getUrl(), this.$download.getName(), "", Boxing.d(0), null, null, null, "", this.$download.getResourceId(), this.$download.getPostId(), this.this$0.f50808c, this.this$0.f50809d, 0, this.this$0.f50810f, this.$download.getSe(), this.$download.getEp(), 67328, null);
            this.$download.setStatus(Boxing.d(3));
            ((IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class)).s0(audioBean, false);
        } else if (AudioPlayer.f50830i.a().w(audioBean)) {
            readProcess = audioBean.getReadProcess();
            if (readProcess != null) {
                jLongValue = readProcess.longValue();
            } else {
                jLongValue = 0;
            }
            duration = audioBean.getDuration();
            if (duration != null) {
                jLongValue2 = duration.longValue();
            } else {
                jLongValue2 = -500;
            }
            if (jLongValue >= jLongValue2) {
            }
            if (audioBean.getStatus() != 6) {
                audioBean.setReadProcess(Boxing.e(0L));
            } else {
                audioBean.setReadProcess(Boxing.e(0L));
            }
            this.this$0.f50821q.set(false);
            audioBean.setStatus(3);
            this.$download.setStatus(Boxing.d(3));
            ((IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class)).s0(audioBean, false);
        } else if (audioBean.getStatus() == 3) {
            this.this$0.f50821q.set(true);
            audioBean.setStatus(4);
            this.$download.setStatus(Boxing.d(4));
            ((IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class)).stop();
        } else {
            this.this$0.f50821q.set(false);
            audioBean.setStatus(3);
            this.$download.setStatus(Boxing.d(3));
            ((IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class)).prepare();
        }
        this.this$0.Q0(this.$download, audioBean);
        return Unit.f68710a;
    }
}
