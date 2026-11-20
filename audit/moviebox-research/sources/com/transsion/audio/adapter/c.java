package com.transsion.audio.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.audio.R$drawable;
import com.transsion.audio.R$id;
import com.transsion.audio.R$layout;
import com.transsion.audio.R$string;
import com.transsion.baselib.db.audio.AudioBean;
import h9.f;
import h9.i;
import h9.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class c extends BaseQuickAdapter<AudioBean, BaseViewHolder> implements j {
    public a H;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {
        void a(AudioBean audioBean);

        void b(AudioBean audioBean);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(List<AudioBean> dataList) {
        super(R$layout.adapter_item_bottom_dialog, dataList);
        Intrinsics.g(dataList, "dataList");
    }

    public static final void L0(AudioBean item, ImageView playStatus, c this$0, View view) {
        Intrinsics.g(item, "$item");
        Intrinsics.g(playStatus, "$playStatus");
        Intrinsics.g(this$0, "this$0");
        if (item.getStatus() == 3) {
            playStatus.setImageResource(R$drawable.play_progress_bg);
        } else {
            playStatus.setImageResource(R$drawable.playing_progress_bg);
        }
        a aVar = this$0.H;
        if (aVar != null) {
            aVar.b(item);
        }
    }

    public static final void O0(c this$0, AudioBean item, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(item, "$item");
        a aVar = this$0.H;
        if (aVar != null) {
            aVar.a(item);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, AudioBean item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        N0(holder, item);
        K0(holder, item);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
    public void y(BaseViewHolder holder, AudioBean item, List<? extends Object> payloads) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        Intrinsics.g(payloads, "payloads");
        super.y(holder, item, payloads);
        K0(holder, item);
    }

    public final void K0(BaseViewHolder baseViewHolder, final AudioBean audioBean) {
        TextView textView = (TextView) baseViewHolder.getView(R$id.tv_process);
        Long readProcess = audioBean.getReadProcess();
        long jLongValue = readProcess != null ? readProcess.longValue() : 0L;
        Long duration = audioBean.getDuration();
        long jLongValue2 = duration != null ? duration.longValue() : 1L;
        int i11 = (int) (((jLongValue * 1.0f) / (jLongValue2 > 0 ? jLongValue2 : 1L)) * 100);
        if (i11 >= 0 && i11 < 101) {
            textView.setText(i11 + getContext().getString(R$string.listened));
        }
        ProgressBar progressBar = (ProgressBar) baseViewHolder.getView(R$id.pb_subject);
        final ImageView imageView = (ImageView) baseViewHolder.getView(R$id.iv_subject);
        imageView.setVisibility(0);
        progressBar.setVisibility(8);
        imageView.setImageResource(R$drawable.play_progress_bg);
        int status = audioBean.getStatus();
        if (status == 1) {
            String string = getContext().getString(R$string.not_open);
            Intrinsics.f(string, "context.getString(R.string.not_open)");
            textView.setText(string);
            progressBar.setVisibility(8);
            imageView.setVisibility(0);
        } else if (status == 6) {
            String string2 = getContext().getString(R$string.finished);
            Intrinsics.f(string2, "context.getString(R.string.finished)");
            textView.setText(string2);
            progressBar.setVisibility(8);
            imageView.setVisibility(0);
        } else if (status != 7) {
            progressBar.setVisibility(0);
            if (audioBean.getStatus() == 3) {
                imageView.setImageResource(R$drawable.playing_progress_bg);
            } else {
                imageView.setImageResource(R$drawable.play_progress_bg);
            }
            progressBar.setProgress(i11);
        } else {
            String string3 = getContext().getString(R$string.error);
            Intrinsics.f(string3, "context.getString(R.string.error)");
            textView.setText(string3);
            progressBar.setVisibility(8);
            imageView.setVisibility(0);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.audio.adapter.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.L0(audioBean, imageView, this, view);
            }
        });
    }

    public final void M0(a listener) {
        Intrinsics.g(listener, "listener");
        this.H = listener;
    }

    public final void N0(BaseViewHolder baseViewHolder, final AudioBean audioBean) {
        String title = audioBean.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = audioBean.getDesc();
        }
        baseViewHolder.setText(R$id.tv_name, title);
        int i11 = R$id.tv_size;
        Long size = audioBean.getSize();
        baseViewHolder.setText(i11, size != null ? tp.a.a(size.longValue(), 1) : null);
        baseViewHolder.getView(R$id.iv_del).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.audio.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.O0(this.f50762a, audioBean, view);
            }
        });
    }

    @Override // h9.j
    public /* synthetic */ f a(BaseQuickAdapter baseQuickAdapter) {
        return i.a(this, baseQuickAdapter);
    }
}
