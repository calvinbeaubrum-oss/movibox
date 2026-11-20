package com.transsion.audio.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.audio.R$drawable;
import com.transsion.audio.R$id;
import com.transsion.audio.R$string;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.moviedetailapi.DownloadItem;
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
@DebugMetadata(c = "com.transsion.audio.adapter.SubjectListAdapter$refresh$1", f = "SubjectListAdapter.kt", l = {76}, m = "invokeSuspend")
@SourceDebugExtension
public final class SubjectListAdapter$refresh$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadItem $download;
    final /* synthetic */ BaseViewHolder $holder;
    int label;
    final /* synthetic */ SubjectListAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubjectListAdapter$refresh$1(DownloadItem downloadItem, BaseViewHolder baseViewHolder, SubjectListAdapter subjectListAdapter, Continuation<? super SubjectListAdapter$refresh$1> continuation) {
        super(2, continuation);
        this.$download = downloadItem;
        this.$holder = baseViewHolder;
        this.this$0 = subjectListAdapter;
    }

    public static final void d(DownloadItem downloadItem, ImageView imageView, SubjectListAdapter subjectListAdapter, View view) {
        Integer status = downloadItem.getStatus();
        if (status != null && status.intValue() == 3) {
            imageView.setImageResource(R$drawable.play_progress_bg);
        } else {
            imageView.setImageResource(R$drawable.playing_progress_bg);
        }
        SubjectListAdapter.a aVarK0 = subjectListAdapter.K0();
        if (aVarK0 != null) {
            aVarK0.a(downloadItem);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubjectListAdapter$refresh$1(this.$download, this.$holder, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((SubjectListAdapter$refresh$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0061  */
    /* JADX WARN: Code duplicated, block: B:32:0x0067  */
    /* JADX WARN: Code duplicated, block: B:40:0x00c3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:53:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:58:0x0110  */
    /* JADX WARN: Code duplicated, block: B:64:0x0123  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AudioBean audioBean;
        rr.a aVarJ0;
        TextView textView;
        long jLongValue;
        long jLongValue2;
        int i11;
        ProgressBar progressBar;
        final ImageView imageView;
        Integer status;
        Long duration;
        Long readProcess;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = this.label;
        Integer numD = null;
        if (i12 == 0) {
            ResultKt.b(obj);
            String url = this.$download.getUrl();
            if (url == null || (aVarJ0 = this.this$0.J0()) == null) {
                audioBean = null;
            } else {
                this.label = 1;
                obj = aVarJ0.c(url, this);
                if (obj == objE) {
                    return objE;
                }
            }
            textView = (TextView) this.$holder.getView(R$id.tv_process);
            if (audioBean != null || (readProcess = audioBean.getReadProcess()) == null) {
                jLongValue = 0;
            } else {
                jLongValue = readProcess.longValue();
            }
            if (audioBean != null || (duration = audioBean.getDuration()) == null) {
                jLongValue2 = 1;
            } else {
                jLongValue2 = duration.longValue();
            }
            i11 = (int) (((jLongValue * 1.0f) / (jLongValue2 > 0 ? jLongValue2 : 1L)) * 100);
            if (i11 >= 0 && i11 < 101) {
                textView.setText(i11 + this.this$0.getContext().getString(R$string.listened));
            }
            progressBar = (ProgressBar) this.$holder.getView(R$id.pb_subject);
            imageView = (ImageView) this.$holder.getView(R$id.iv_subject);
            imageView.setVisibility(0);
            progressBar.setVisibility(8);
            imageView.setImageResource(R$drawable.play_progress_bg);
            status = this.$download.getStatus();
            if (status == null) {
                numD = status;
            } else if (audioBean != null) {
                numD = Boxing.d(audioBean.getStatus());
            }
            if (numD != null && numD.intValue() == 1) {
                textView.setText("Not open");
                progressBar.setVisibility(8);
                imageView.setVisibility(0);
            } else if (numD != null && numD.intValue() == 6) {
                textView.setText("Finished");
                progressBar.setVisibility(8);
                imageView.setVisibility(0);
            } else if (numD == null && numD.intValue() == 7) {
                textView.setText("ERROR");
                progressBar.setVisibility(8);
                imageView.setVisibility(0);
            } else {
                progressBar.setVisibility(0);
                if (numD == null && numD.intValue() == 3) {
                    imageView.setImageResource(R$drawable.playing_progress_bg);
                } else {
                    imageView.setImageResource(R$drawable.play_progress_bg);
                }
                progressBar.setProgress(i11);
            }
            final DownloadItem downloadItem = this.$download;
            final SubjectListAdapter subjectListAdapter = this.this$0;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.audio.adapter.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubjectListAdapter$refresh$1.d(downloadItem, imageView, subjectListAdapter, view);
                }
            });
            return Unit.f68710a;
        }
        if (i12 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        audioBean = (AudioBean) obj;
        textView = (TextView) this.$holder.getView(R$id.tv_process);
        if (audioBean != null) {
            jLongValue = 0;
        } else {
            jLongValue = 0;
        }
        if (audioBean != null) {
            jLongValue2 = 1;
        } else {
            jLongValue2 = 1;
        }
        i11 = (int) (((jLongValue * 1.0f) / (jLongValue2 > 0 ? jLongValue2 : 1L)) * 100);
        if (i11 >= 0) {
            textView.setText(i11 + this.this$0.getContext().getString(R$string.listened));
        }
        progressBar = (ProgressBar) this.$holder.getView(R$id.pb_subject);
        imageView = (ImageView) this.$holder.getView(R$id.iv_subject);
        imageView.setVisibility(0);
        progressBar.setVisibility(8);
        imageView.setImageResource(R$drawable.play_progress_bg);
        status = this.$download.getStatus();
        if (status == null) {
            numD = status;
        } else if (audioBean != null) {
            numD = Boxing.d(audioBean.getStatus());
        }
        if (numD != null) {
            textView.setText("Not open");
            progressBar.setVisibility(8);
            imageView.setVisibility(0);
        } else if (numD != null) {
            textView.setText("Finished");
            progressBar.setVisibility(8);
            imageView.setVisibility(0);
        } else if (numD == null) {
            progressBar.setVisibility(0);
            if (numD == null) {
                imageView.setImageResource(R$drawable.play_progress_bg);
            } else {
                imageView.setImageResource(R$drawable.playing_progress_bg);
            }
            progressBar.setProgress(i11);
        } else {
            textView.setText("ERROR");
            progressBar.setVisibility(8);
            imageView.setVisibility(0);
        }
        final DownloadItem downloadItem2 = this.$download;
        final SubjectListAdapter subjectListAdapter2 = this.this$0;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.audio.adapter.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubjectListAdapter$refresh$1.d(downloadItem2, imageView, subjectListAdapter2, view);
            }
        });
        return Unit.f68710a;
    }
}
