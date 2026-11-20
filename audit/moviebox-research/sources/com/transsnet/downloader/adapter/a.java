package com.transsnet.downloader.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baselib.db.download.DownloadBean;
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
public final class a extends BaseMultiItemQuickAdapter<HistoricalPlayRecordMultipleEntity, BaseViewHolder> implements h9.j {
    public final boolean I;

    public a(boolean z11) {
        super(null, 1, null);
        this.I = z11;
        G0(1, R$layout.item_historical_section_header_layout);
        G0(2, R$layout.item_historical_section_body_layout);
        G0(3, R$layout.item_historical_section_ad_layout);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, HistoricalPlayRecordMultipleEntity item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        if (holder.getPosition() == getItemCount() - 1) {
            ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
            Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = gs.a.a(64);
        }
        int itemViewType = holder.getItemViewType();
        if (itemViewType == 1) {
            M0(holder, item);
        } else if (itemViewType == 2) {
            L0(holder, item);
        } else {
            if (itemViewType != 3) {
                return;
            }
            J0(holder, item);
        }
    }

    public final void J0(BaseViewHolder baseViewHolder, HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity) {
        d00.b bVar = d00.b.f62855a;
        Context context = getContext();
        com.transsion.ad.bidding.nativead.c nonAdDelegate = historicalPlayRecordMultipleEntity.getNonAdDelegate();
        zq.b bVarA = bVar.a(context, nonAdDelegate != null ? nonAdDelegate.Q() : null);
        NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) baseViewHolder.getViewOrNull(R$id.adRoot);
        if (nativeWrapperAdView != null) {
            nativeWrapperAdView.bindNativeView(historicalPlayRecordMultipleEntity.getNonAdDelegate(), bVarA);
        }
    }

    public final void K0(HistoricalPlayRecordBean historicalPlayRecordBean, BaseViewHolder baseViewHolder) {
        String cover;
        String str;
        Long readProcess;
        String subjectTitle;
        String subjectTitle2;
        String title;
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
        if (((audio2 == null || (duration2 = audio2.getDuration()) == null) ? 0L : duration2.longValue()) > 0) {
            int i11 = R$id.tvTime;
            AudioBean audio3 = historicalPlayRecordBean.getAudio();
            baseViewHolder.setText(i11, TimeUtilKt.i((audio3 == null || (duration = audio3.getDuration()) == null) ? 0L : duration.longValue()));
        }
        AudioBean audio4 = historicalPlayRecordBean.getAudio();
        Long readProcess2 = audio4 != null ? audio4.getReadProcess() : null;
        AudioBean audio5 = historicalPlayRecordBean.getAudio();
        int iP0 = P0(readProcess2, audio5 != null ? audio5.getDuration() : null);
        ((ProgressBar) baseViewHolder.getView(R$id.progressBar)).setProgress(iP0);
        if (iP0 == 0) {
            AudioBean audio6 = historicalPlayRecordBean.getAudio();
            if (((audio6 == null || (readProcess = audio6.getReadProcess()) == null) ? 0L : readProcess.longValue()) > 0) {
                str = historicalPlayRecordBean.getType() == 1 ? "1% listened" : "1% watched";
            } else {
                str = "Not open";
            }
            baseViewHolder.setText(R$id.tvProgress, str);
        } else if (iP0 != 100) {
            baseViewHolder.setText(R$id.tvProgress, iP0 + "% listened");
        } else {
            baseViewHolder.setText(R$id.tvProgress, "Finished");
        }
        AudioBean audio7 = historicalPlayRecordBean.getAudio();
        int se2 = audio7 != null ? audio7.getSe() : 0;
        AudioBean audio8 = historicalPlayRecordBean.getAudio();
        int ep2 = audio8 != null ? audio8.getEp() : 0;
        AudioBean audio9 = historicalPlayRecordBean.getAudio();
        if (audio9 == null || (subjectTitle = audio9.getSubjectTitle()) == null) {
            subjectTitle = "";
        }
        if (TextUtils.isEmpty(subjectTitle)) {
            baseViewHolder.setGone(R$id.tvEpisode, true);
            ((AppCompatTextView) baseViewHolder.getView(R$id.tvTitle)).setMaxLines(2);
            int i12 = R$id.tvTitle;
            AudioBean audio10 = historicalPlayRecordBean.getAudio();
            if (audio10 == null || (title = audio10.getTitle()) == null) {
                title = "";
            }
            baseViewHolder.setText(i12, title);
            return;
        }
        baseViewHolder.setGone(R$id.tvEpisode, false);
        baseViewHolder.setText(R$id.tvEpisode, com.transsion.baselib.utils.h.b(ep2, se2, Integer.valueOf(SubjectType.AUDIO.getValue())));
        ((AppCompatTextView) baseViewHolder.getView(R$id.tvTitle)).setMaxLines(1);
        int i13 = R$id.tvTitle;
        AudioBean audio11 = historicalPlayRecordBean.getAudio();
        if (audio11 == null || (subjectTitle2 = audio11.getSubjectTitle()) == null) {
            subjectTitle2 = "";
        }
        baseViewHolder.setText(i13, subjectTitle2);
    }

    public final void L0(BaseViewHolder baseViewHolder, HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity) {
        HistoricalPlayRecordBean historical = historicalPlayRecordMultipleEntity.getHistorical();
        if (historical != null) {
            if (historical.getType() == 1) {
                K0(historical, baseViewHolder);
            } else if (historical.getVideo() != null) {
                O0(historical, baseViewHolder);
            } else if (historical.getStreamVideo() != null) {
                N0(historical, baseViewHolder);
            }
        }
    }

    public final void M0(BaseViewHolder baseViewHolder, HistoricalPlayRecordMultipleEntity historicalPlayRecordMultipleEntity) {
        baseViewHolder.setText(R$id.tvHeaderTitle, historicalPlayRecordMultipleEntity.getTitle());
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00bc  */
    public final void N0(HistoricalPlayRecordBean historicalPlayRecordBean, BaseViewHolder baseViewHolder) {
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
        VideoDetailPlayBean streamVideo5 = historicalPlayRecordBean.getStreamVideo();
        Long totalDuration3 = streamVideo5 != null ? streamVideo5.getTotalDuration() : null;
        VideoDetailPlayBean streamVideo6 = historicalPlayRecordBean.getStreamVideo();
        baseViewHolder.setText(R$id.tvProgress, Q0(0L, totalDuration3, streamVideo6 != null ? Long.valueOf(streamVideo6.getProgress()) : null, historicalPlayRecordBean.getType()));
        ((AppCompatTextView) baseViewHolder.getView(R$id.tvTitle)).setMaxLines(1);
        VideoDetailPlayBean streamVideo7 = historicalPlayRecordBean.getStreamVideo();
        if (streamVideo7 != null) {
            Integer subjectType = streamVideo7.getSubjectType();
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
        VideoDetailPlayBean streamVideo8 = historicalPlayRecordBean.getStreamVideo();
        baseViewHolder.setText(i11, streamVideo8 != null ? streamVideo8.getTitle() : null);
        VideoDetailPlayBean streamVideo9 = historicalPlayRecordBean.getStreamVideo();
        if (streamVideo9 == null || streamVideo9.getEp() <= 0) {
            baseViewHolder.setGone(R$id.tvEpisode, true);
        } else {
            baseViewHolder.setGone(R$id.tvEpisode, false);
            int i12 = R$id.tvEpisode;
            VideoDetailPlayBean streamVideo10 = historicalPlayRecordBean.getStreamVideo();
            int ep2 = streamVideo10 != null ? streamVideo10.getEp() : 0;
            VideoDetailPlayBean streamVideo11 = historicalPlayRecordBean.getStreamVideo();
            int se2 = streamVideo11 != null ? streamVideo11.getSe() : 0;
            VideoDetailPlayBean streamVideo12 = historicalPlayRecordBean.getStreamVideo();
            baseViewHolder.setText(i12, com.transsion.baselib.utils.h.b(ep2, se2, streamVideo12 != null ? streamVideo12.getSubjectType() : null));
        }
        VideoDetailPlayBean streamVideo13 = historicalPlayRecordBean.getStreamVideo();
        long jLongValue = 0;
        if (((streamVideo13 == null || (totalDuration2 = streamVideo13.getTotalDuration()) == null) ? 0L : totalDuration2.longValue()) > 0) {
            int i13 = R$id.tvTime;
            VideoDetailPlayBean streamVideo14 = historicalPlayRecordBean.getStreamVideo();
            if (streamVideo14 != null && (totalDuration = streamVideo14.getTotalDuration()) != null) {
                jLongValue = totalDuration.longValue();
            }
            baseViewHolder.setText(i13, TimeUtilKt.i(jLongValue));
        }
        ProgressBar progressBar = (ProgressBar) baseViewHolder.getView(R$id.progressBar);
        VideoDetailPlayBean streamVideo15 = historicalPlayRecordBean.getStreamVideo();
        Long lValueOf = streamVideo15 != null ? Long.valueOf(streamVideo15.getProgress()) : null;
        VideoDetailPlayBean streamVideo16 = historicalPlayRecordBean.getStreamVideo();
        progressBar.setProgress(P0(lValueOf, streamVideo16 != null ? streamVideo16.getTotalDuration() : null));
        ((ViewStub) baseViewHolder.getView(R$id.viewStub)).setVisibility(8);
    }

    /* JADX WARN: Code duplicated, block: B:70:0x011b  */
    /* JADX WARN: Code duplicated, block: B:84:0x014b  */
    public final void O0(HistoricalPlayRecordBean historicalPlayRecordBean, BaseViewHolder baseViewHolder) {
        String cover;
        String path;
        String path2;
        String name;
        DownloadBean video;
        String subjectName;
        DownloadBean video2;
        DownloadBean video3;
        Long duration;
        Long duration2;
        DownloadBean video4;
        String subjectName2;
        String cover2;
        String path3;
        if (this.I) {
            baseViewHolder.setGone(R$id.ivCornerMark, true);
        }
        DownloadBean video5 = historicalPlayRecordBean.getVideo();
        long jLongValue = 0;
        String str = "";
        if (video5 == null || !video5.isInnerRes()) {
            ShapeableImageView shapeableImageView = (ShapeableImageView) baseViewHolder.getView(R$id.ivCore);
            com.transsnet.downloader.viewmodel.c cVar = com.transsnet.downloader.viewmodel.c.f61276a;
            DownloadBean video6 = historicalPlayRecordBean.getVideo();
            if (video6 == null || (cover = video6.getCover()) == null) {
                cover = "";
            }
            shapeableImageView.setImageBitmap(cVar.e(cover));
            DownloadBean video7 = historicalPlayRecordBean.getVideo();
            if (video7 == null || (path = video7.getPath()) == null) {
                path = "";
            }
            if (com.blankj.utilcode.util.m.k(path) > 0) {
                int i11 = R$id.tvProgress;
                DownloadBean video8 = historicalPlayRecordBean.getVideo();
                if (video8 != null && (path2 = video8.getPath()) != null) {
                    str = path2;
                }
                baseViewHolder.setText(i11, tp.a.a(com.blankj.utilcode.util.m.k(str), 1));
            } else {
                baseViewHolder.setText(R$id.tvProgress, "");
            }
            ((AppCompatTextView) baseViewHolder.getView(R$id.tvTitle)).setMaxLines(2);
        } else {
            Context context = getContext();
            ImageView imageView = (ImageView) baseViewHolder.getView(R$id.ivCore);
            DownloadBean video9 = historicalPlayRecordBean.getVideo();
            if (video9 == null || (cover2 = video9.getCover()) == null) {
                cover2 = "";
            }
            DownloadBean video10 = historicalPlayRecordBean.getVideo();
            DownloadedHolderKt.a(context, imageView, cover2, video10 != null ? video10.getThumbnail() : null);
            DownloadBean video11 = historicalPlayRecordBean.getVideo();
            if (video11 != null && (path3 = video11.getPath()) != null) {
                str = path3;
            }
            long jK = com.blankj.utilcode.util.m.k(str);
            DownloadBean video12 = historicalPlayRecordBean.getVideo();
            Long duration3 = video12 != null ? video12.getDuration() : null;
            DownloadBean video13 = historicalPlayRecordBean.getVideo();
            baseViewHolder.setText(R$id.tvProgress, Q0(jK, duration3, video13 != null ? Long.valueOf(video13.getReadProgress()) : null, historicalPlayRecordBean.getType()));
            ((AppCompatTextView) baseViewHolder.getView(R$id.tvTitle)).setMaxLines(1);
        }
        int type = historicalPlayRecordBean.getType();
        if (type == 2) {
            baseViewHolder.setImageResource(R$id.ivCornerMark, com.transsion.baseui.R$mipmap.home_ic_movie_white);
        } else if (type == 3) {
            int i12 = R$id.ivCornerMark;
            DownloadBean video14 = historicalPlayRecordBean.getVideo();
            baseViewHolder.setImageResource(i12, (video14 == null || !video14.isShotTV()) ? com.transsion.baseui.R$mipmap.home_ic_tv_white : com.transsion.baseui.R$mipmap.home_ic_short_tv_white);
        } else if (type == 5 || type == 6) {
            baseViewHolder.setImageResource(R$id.ivCornerMark, com.transsion.baseui.R$mipmap.home_ic_movie_white);
        } else {
            baseViewHolder.setImageResource(R$id.ivCornerMark, com.transsion.baseui.R$mipmap.home_ic_audio_white);
        }
        DownloadBean video15 = historicalPlayRecordBean.getVideo();
        if (video15 == null || !video15.isSeries() || (video4 = historicalPlayRecordBean.getVideo()) == null || (subjectName2 = video4.getSubjectName()) == null || subjectName2.length() <= 0) {
            DownloadBean video16 = historicalPlayRecordBean.getVideo();
            if (video16 == null || video16.getResolution() <= 0 || (video = historicalPlayRecordBean.getVideo()) == null || (subjectName = video.getSubjectName()) == null || subjectName.length() <= 0) {
                DownloadBean video17 = historicalPlayRecordBean.getVideo();
                if (video17 != null) {
                    name = video17.getName();
                } else {
                    name = null;
                }
            } else {
                DownloadBean video18 = historicalPlayRecordBean.getVideo();
                Integer numValueOf = video18 != null ? Integer.valueOf(video18.getResolution()) : null;
                DownloadBean video19 = historicalPlayRecordBean.getVideo();
                name = numValueOf + "P " + (video19 != null ? video19.getSubjectName() : null);
            }
        } else {
            DownloadBean video20 = historicalPlayRecordBean.getVideo();
            if (video20 != null) {
                name = video20.getSubjectName();
            } else {
                name = null;
            }
        }
        baseViewHolder.setText(R$id.tvTitle, name);
        DownloadBean video21 = historicalPlayRecordBean.getVideo();
        if (video21 == null || !video21.isSeries()) {
            baseViewHolder.setGone(R$id.tvEpisode, true);
        } else {
            baseViewHolder.setGone(R$id.tvEpisode, false);
            DownloadBean video22 = historicalPlayRecordBean.getVideo();
            if (video22 == null || video22.getEp() <= 0) {
                int i13 = R$id.tvEpisode;
                DownloadBean video23 = historicalPlayRecordBean.getVideo();
                baseViewHolder.setText(i13, com.transsion.baselib.utils.h.c(video23 != null ? video23.getEpse() : 0, true));
            } else {
                int i14 = R$id.tvEpisode;
                DownloadBean video24 = historicalPlayRecordBean.getVideo();
                int ep2 = video24 != null ? video24.getEp() : 0;
                DownloadBean video25 = historicalPlayRecordBean.getVideo();
                int se2 = video25 != null ? video25.getSe() : 0;
                DownloadBean video26 = historicalPlayRecordBean.getVideo();
                baseViewHolder.setText(i14, com.transsion.baselib.utils.h.b(ep2, se2, video26 != null ? Integer.valueOf(video26.getSubjectType()) : null));
            }
        }
        DownloadBean video27 = historicalPlayRecordBean.getVideo();
        if (((video27 == null || (duration2 = video27.getDuration()) == null) ? 0L : duration2.longValue()) > 0) {
            int i15 = R$id.tvTime;
            DownloadBean video28 = historicalPlayRecordBean.getVideo();
            if (video28 != null && (duration = video28.getDuration()) != null) {
                jLongValue = duration.longValue();
            }
            baseViewHolder.setText(i15, TimeUtilKt.i(jLongValue));
        }
        ProgressBar progressBar = (ProgressBar) baseViewHolder.getView(R$id.progressBar);
        DownloadBean video29 = historicalPlayRecordBean.getVideo();
        Long lValueOf = video29 != null ? Long.valueOf(video29.getReadProgress()) : null;
        DownloadBean video30 = historicalPlayRecordBean.getVideo();
        progressBar.setProgress(P0(lValueOf, video30 != null ? video30.getDuration() : null));
        if (Intrinsics.b(historicalPlayRecordBean.isLocalFileDelete(), Boolean.TRUE) || !((video2 = historicalPlayRecordBean.getVideo()) == null || video2.isFileExist() || (video3 = historicalPlayRecordBean.getVideo()) == null || !video3.isCompleted())) {
            ((ViewStub) baseViewHolder.getView(R$id.viewStub)).setVisibility(0);
        } else {
            ((ViewStub) baseViewHolder.getView(R$id.viewStub)).setVisibility(8);
        }
    }

    public final int P0(Long l11, Long l12) {
        try {
            Result.Companion companion = Result.Companion;
            long jLongValue = l11 != null ? l11.longValue() : 0L;
            long jLongValue2 = l12 != null ? l12.longValue() : 1L;
            return (int) (((jLongValue * 1.0f) / (jLongValue2 > 0 ? jLongValue2 : 1L)) * 100);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
            return 0;
        }
    }

    public final String Q0(long j11, Long l11, Long l12, int i11) {
        String str;
        int iP0 = P0(l12, l11);
        if (iP0 == 0) {
            if ((l12 != null ? l12.longValue() : 0L) > 0) {
                str = i11 == 1 ? "1% listened" : "1% watched";
            } else {
                str = "Not open";
            }
        } else if (iP0 != 100) {
            str = iP0 + "% watched";
        } else {
            str = "Finished";
        }
        if (this.I) {
            return j11 > 0 ? tp.a.a(j11, 1) : "";
        }
        if (j11 <= 0) {
            return str;
        }
        return tp.a.a(j11, 1) + " · " + str;
    }

    @Override // h9.j
    public /* synthetic */ h9.f a(BaseQuickAdapter baseQuickAdapter) {
        return h9.i.a(this, baseQuickAdapter);
    }
}
