package com.transsion.usercenter.me.adapter;

import android.content.Context;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baseui.R$mipmap;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsnet.downloader.adapter.DownloadedHolderKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

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
public final class c extends BaseQuickAdapter<VideoDetailPlayBean, BaseViewHolder> {
    public c() {
        super(R$layout.adapter_mine_historical_record_layout, null, 2, null);
    }

    private final int I0(Long l11, Long l12) {
        try {
            Result.Companion companion = Result.Companion;
            if (l11 != null && l12 != null) {
                return (int) ((l11.longValue() * ((long) 100)) / l12.longValue());
            }
            Result.m163constructorimpl(Unit.f68710a);
            return 0;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
            return 0;
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, VideoDetailPlayBean videoDetailPlayBean) {
        Intrinsics.g(holder, "holder");
        if (videoDetailPlayBean == null) {
            return;
        }
        H0(videoDetailPlayBean, holder);
    }

    public final void H0(VideoDetailPlayBean videoDetailPlayBean, BaseViewHolder baseViewHolder) {
        if (videoDetailPlayBean.getSubjectId().length() == 0) {
            ShapeableImageView shapeableImageView = (ShapeableImageView) baseViewHolder.getView(R$id.ivCore);
            com.transsnet.downloader.viewmodel.c cVar = com.transsnet.downloader.viewmodel.c.f61276a;
            String coverUrl = videoDetailPlayBean.getCoverUrl();
            shapeableImageView.setImageBitmap(cVar.e(coverUrl != null ? coverUrl : ""));
        } else {
            Context context = getContext();
            ImageView imageView = (ImageView) baseViewHolder.getView(R$id.ivCore);
            String coverUrl2 = videoDetailPlayBean.getCoverUrl();
            DownloadedHolderKt.a(context, imageView, coverUrl2 != null ? coverUrl2 : "", videoDetailPlayBean.getThumbnail());
        }
        ((AppCompatTextView) baseViewHolder.getView(R$id.tvTitle)).setMaxLines(1);
        Integer subjectType = videoDetailPlayBean.getSubjectType();
        int value = SubjectType.TV.getValue();
        if (subjectType != null && subjectType.intValue() == value) {
            baseViewHolder.setImageResource(R$id.ivCornerMark, R$mipmap.home_ic_tv_white);
        } else {
            baseViewHolder.setImageResource(R$id.ivCornerMark, R$mipmap.home_ic_movie_white);
        }
        baseViewHolder.setText(R$id.tvTitle, videoDetailPlayBean.getTitle());
        ((ProgressBar) baseViewHolder.getView(R$id.progressBar)).setProgress(I0(Long.valueOf(videoDetailPlayBean.getProgress()), videoDetailPlayBean.getTotalDuration()));
        ((ViewStub) baseViewHolder.getView(R$id.viewStub)).setVisibility(8);
    }
}
