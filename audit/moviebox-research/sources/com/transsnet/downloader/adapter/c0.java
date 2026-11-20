package com.transsnet.downloader.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.moviedetailapi.SubjectType;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$mipmap;
import com.transsnet.downloader.bean.HistoricalPlayRecordBean;
import com.transsnet.downloader.bean.HistoricalPlayRecordMultipleEntity;
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
public final class c0 extends BaseQuickAdapter<HistoricalPlayRecordMultipleEntity, BaseViewHolder> {
    public c0() {
        super(R$layout.adapter_historical_play_record_layout, null, 2, null);
    }

    private final void H0(HistoricalPlayRecordBean historicalPlayRecordBean, BaseViewHolder baseViewHolder) {
        String cover;
        String title;
        String subjectTitle;
        Long duration;
        Long duration2;
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context context = getContext();
        ImageView imageView = (ImageView) baseViewHolder.getView(R$id.ivCore);
        AudioBean audio = historicalPlayRecordBean.getAudio();
        if (audio == null || (cover = audio.getCover()) == null) {
            cover = "";
        }
        companion.r(context, imageView, cover, (4088 & 8) != 0 ? companion.d() : 0, (4088 & 16) != 0 ? companion.c() : 0, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
        baseViewHolder.setImageResource(R$id.ivCornerMark, R$mipmap.ic_audio_download_historical);
        AudioBean audio2 = historicalPlayRecordBean.getAudio();
        long jLongValue = 0;
        if (((audio2 == null || (duration2 = audio2.getDuration()) == null) ? 0L : duration2.longValue()) > 0) {
            int i11 = R$id.tvTime;
            AudioBean audio3 = historicalPlayRecordBean.getAudio();
            if (audio3 != null && (duration = audio3.getDuration()) != null) {
                jLongValue = duration.longValue();
            }
            baseViewHolder.setText(i11, TimeUtilKt.i(jLongValue));
        }
        ProgressBar progressBar = (ProgressBar) baseViewHolder.getView(R$id.progressBar);
        AudioBean audio4 = historicalPlayRecordBean.getAudio();
        Long readProcess = audio4 != null ? audio4.getReadProcess() : null;
        AudioBean audio5 = historicalPlayRecordBean.getAudio();
        progressBar.setProgress(J0(readProcess, audio5 != null ? audio5.getDuration() : null));
        AudioBean audio6 = historicalPlayRecordBean.getAudio();
        int se2 = audio6 != null ? audio6.getSe() : 0;
        AudioBean audio7 = historicalPlayRecordBean.getAudio();
        int ep2 = audio7 != null ? audio7.getEp() : 0;
        if (se2 == 0 && ep2 == 0) {
            baseViewHolder.setGone(R$id.tvEpisode, true);
        } else {
            baseViewHolder.setGone(R$id.tvEpisode, false);
            baseViewHolder.setText(R$id.tvEpisode, com.transsion.baselib.utils.h.b(ep2, se2, Integer.valueOf(SubjectType.AUDIO.getValue())));
        }
        AudioBean audio8 = historicalPlayRecordBean.getAudio();
        if (TextUtils.isEmpty(audio8 != null ? audio8.getSubjectTitle() : null)) {
            int i12 = R$id.tvTitle;
            AudioBean audio9 = historicalPlayRecordBean.getAudio();
            if (audio9 == null || (title = audio9.getTitle()) == null) {
                title = "";
            }
            baseViewHolder.setText(i12, title);
            return;
        }
        int i13 = R$id.tvTitle;
        AudioBean audio10 = historicalPlayRecordBean.getAudio();
        if (audio10 == null || (subjectTitle = audio10.getSubjectTitle()) == null) {
            subjectTitle = "";
        }
        baseViewHolder.setText(i13, subjectTitle);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x008e  */
    private final void I0(HistoricalPlayRecordBean historicalPlayRecordBean, BaseViewHolder baseViewHolder) {
        String coverUrl;
        Long totalDuration;
        Long totalDuration2;
        String coverUrl2;
        VideoDetailPlayBean streamVideo = historicalPlayRecordBean.getStreamVideo();
        String subjectId = streamVideo != null ? streamVideo.getSubjectId() : null;
        String str = "";
        if (subjectId == null || subjectId.length() == 0) {
            ShapeableImageView shapeableImageView = (ShapeableImageView) baseViewHolder.getView(R$id.ivCore);
            com.transsnet.downloader.viewmodel.c cVar = com.transsnet.downloader.viewmodel.c.f61276a;
            VideoDetailPlayBean streamVideo2 = historicalPlayRecordBean.getStreamVideo();
            if (streamVideo2 != null && (coverUrl = streamVideo2.getCoverUrl()) != null) {
                str = coverUrl;
            }
            shapeableImageView.setImageBitmap(cVar.e(str));
        } else {
            Context context = getContext();
            ImageView imageView = (ImageView) baseViewHolder.getView(R$id.ivCore);
            VideoDetailPlayBean streamVideo3 = historicalPlayRecordBean.getStreamVideo();
            if (streamVideo3 != null && (coverUrl2 = streamVideo3.getCoverUrl()) != null) {
                str = coverUrl2;
            }
            VideoDetailPlayBean streamVideo4 = historicalPlayRecordBean.getStreamVideo();
            DownloadedHolderKt.a(context, imageView, str, streamVideo4 != null ? streamVideo4.getThumbnail() : null);
        }
        ((AppCompatTextView) baseViewHolder.getView(R$id.tvTitle)).setMaxLines(1);
        VideoDetailPlayBean streamVideo5 = historicalPlayRecordBean.getStreamVideo();
        if (streamVideo5 != null) {
            Integer subjectType = streamVideo5.getSubjectType();
            int value = SubjectType.TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                baseViewHolder.setImageResource(R$id.ivCornerMark, com.transsion.baseui.R$mipmap.home_ic_tv_white);
            } else {
                baseViewHolder.setImageResource(R$id.ivCornerMark, com.transsion.baseui.R$mipmap.home_ic_movie_white);
            }
        } else {
            baseViewHolder.setImageResource(R$id.ivCornerMark, com.transsion.baseui.R$mipmap.home_ic_movie_white);
        }
        int i11 = R$id.tvTitle;
        VideoDetailPlayBean streamVideo6 = historicalPlayRecordBean.getStreamVideo();
        baseViewHolder.setText(i11, streamVideo6 != null ? streamVideo6.getTitle() : null);
        VideoDetailPlayBean streamVideo7 = historicalPlayRecordBean.getStreamVideo();
        if (streamVideo7 == null || streamVideo7.getEp() <= 0) {
            baseViewHolder.setGone(R$id.tvEpisode, true);
        } else {
            baseViewHolder.setGone(R$id.tvEpisode, false);
            int i12 = R$id.tvEpisode;
            VideoDetailPlayBean streamVideo8 = historicalPlayRecordBean.getStreamVideo();
            int ep2 = streamVideo8 != null ? streamVideo8.getEp() : 0;
            VideoDetailPlayBean streamVideo9 = historicalPlayRecordBean.getStreamVideo();
            int se2 = streamVideo9 != null ? streamVideo9.getSe() : 0;
            VideoDetailPlayBean streamVideo10 = historicalPlayRecordBean.getStreamVideo();
            baseViewHolder.setText(i12, com.transsion.baselib.utils.h.b(ep2, se2, streamVideo10 != null ? streamVideo10.getSubjectType() : null));
        }
        VideoDetailPlayBean streamVideo11 = historicalPlayRecordBean.getStreamVideo();
        long jLongValue = 0;
        if (((streamVideo11 == null || (totalDuration2 = streamVideo11.getTotalDuration()) == null) ? 0L : totalDuration2.longValue()) > 0) {
            int i13 = R$id.tvTime;
            VideoDetailPlayBean streamVideo12 = historicalPlayRecordBean.getStreamVideo();
            if (streamVideo12 != null && (totalDuration = streamVideo12.getTotalDuration()) != null) {
                jLongValue = totalDuration.longValue();
            }
            baseViewHolder.setText(i13, TimeUtilKt.i(jLongValue));
        }
        ProgressBar progressBar = (ProgressBar) baseViewHolder.getView(R$id.progressBar);
        VideoDetailPlayBean streamVideo13 = historicalPlayRecordBean.getStreamVideo();
        Long lValueOf = streamVideo13 != null ? Long.valueOf(streamVideo13.getProgress()) : null;
        VideoDetailPlayBean streamVideo14 = historicalPlayRecordBean.getStreamVideo();
        progressBar.setProgress(J0(lValueOf, streamVideo14 != null ? streamVideo14.getTotalDuration() : null));
        ((ViewStub) baseViewHolder.getView(R$id.viewStub)).setVisibility(8);
    }

    private final int J0(Long l11, Long l12) {
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
    public void x(BaseViewHolder holder, HistoricalPlayRecordMultipleEntity item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        HistoricalPlayRecordBean historical = item.getHistorical();
        if (historical != null) {
            if (historical.getType() == 1) {
                H0(historical, holder);
            } else if (historical.getStreamVideo() != null) {
                I0(historical, holder);
            }
        }
    }
}
