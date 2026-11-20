package com.transsion.postdetail.ui.adapter.provider;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.ninegridview.video.NineGridVideoView;
import com.transsion.ninegridview.video.NineGridVideoViewAdapter;
import com.transsion.postdetail.R$drawable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class h extends d {
    public static final void B(NineGridVideoView this_apply) {
        Intrinsics.g(this_apply, "$this_apply");
        this_apply.loadImage();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return MediaType.VIDEO.ordinal();
    }

    @Override // com.transsion.postdetail.ui.adapter.provider.d
    public void w(AppCompatImageView ivCenterIcon, PostSubjectItem item) {
        Intrinsics.g(ivCenterIcon, "ivCenterIcon");
        Intrinsics.g(item, "item");
        ivCenterIcon.setImageResource(R$drawable.post_video_play);
    }

    @Override // com.transsion.postdetail.ui.adapter.provider.d
    public void x(final NineGridVideoView nineGridView, PostSubjectItem item) {
        Cover cover;
        Intrinsics.g(nineGridView, "nineGridView");
        Intrinsics.g(item, "item");
        ArrayList arrayList = new ArrayList();
        Media media = item.getMedia();
        if (media != null && (cover = media.getCover()) != null) {
            arrayList.add(new Image(cover.getHeight(), cover.getSize(), cover.getUrl(), cover.getWidth(), cover.getFormat(), cover.getThumbnail(), cover.getGifBean(), cover.getAverageHueLight(), cover.getAverageHueDark(), 0.0f, 0.0f, 0, 0, 0, 15872, null));
        }
        nineGridView.setAdapter(new NineGridVideoViewAdapter(arrayList));
        nineGridView.post(new Runnable() { // from class: com.transsion.postdetail.ui.adapter.provider.g
            @Override // java.lang.Runnable
            public final void run() {
                h.B(nineGridView);
            }
        });
    }

    @Override // com.transsion.postdetail.ui.adapter.provider.d
    public void y(AppCompatTextView tvTime, PostSubjectItem item) {
        Unit unit;
        List<Video> video;
        Intrinsics.g(tvTime, "tvTime");
        Intrinsics.g(item, "item");
        Media media = item.getMedia();
        if (media == null || (video = media.getVideo()) == null) {
            unit = null;
        } else {
            if (!video.isEmpty()) {
                Number duration = video.get(0).getDuration();
                if (duration == null) {
                    duration = 0L;
                }
                tvTime.setText(TimeUtilKt.j(duration.longValue()));
            }
            unit = Unit.f68710a;
        }
        if (unit == null) {
            tvTime.setVisibility(8);
        }
    }
}
