package com.transsion.postdetail.ui.adapter.provider;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.f0;
import com.blankj.utilcode.util.h0;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.R$mipmap;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.baseui.image.blurhash.BlurHashHelper;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.moviedetailapi.bean.Audio;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsnet.downloader.widget.DownloadView;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class PostRecommendAudioProvider extends BaseItemProvider<PostSubjectItem> {
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return MediaType.AUDIO.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_provider_recommend_audio_layout;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, PostSubjectItem item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        v(helper, item);
        w(helper, item);
    }

    public final void v(BaseViewHolder baseViewHolder, PostSubjectItem postSubjectItem) {
        List<Audio> audio;
        Cover cover;
        Subject subject = postSubjectItem.getSubject();
        Unit unit = null;
        String url = (subject == null || (cover = subject.getCover()) == null) ? null : cover.getUrl();
        ShapeableImageView shapeableImageView = (ShapeableImageView) baseViewHolder.getView(R$id.iv_audio_cover_small);
        if (TextUtils.isEmpty(url)) {
            so.c.g(shapeableImageView);
        } else {
            so.c.k(shapeableImageView);
            if (url != null) {
                int iA = f0.a(24.0f);
                Glide.with(g()).load2(url + "?x-oss-process=image/resize,w_" + iA + ",h_" + iA + ",m_lfit").into(shapeableImageView);
            }
        }
        final ShapeableImageView shapeableImageView2 = (ShapeableImageView) baseViewHolder.getView(R$id.iv_cover);
        String coverUrl = postSubjectItem.getCoverUrl(true);
        if (TextUtils.isEmpty(coverUrl)) {
            shapeableImageView2.setImageResource(R$mipmap.ic_audio_default_bg_light);
            return;
        }
        BlurHashHelper.b(BlurHashHelper.f51391a, coverUrl, 0, 0, new Function1<BitmapDrawable, Unit>() { // from class: com.transsion.postdetail.ui.adapter.provider.PostRecommendAudioProvider$showAudio$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BitmapDrawable bitmapDrawable) {
                invoke2(bitmapDrawable);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BitmapDrawable drawable) {
                Intrinsics.g(drawable, "drawable");
                shapeableImageView2.setImageDrawable(drawable);
            }
        }, 6, null);
        baseViewHolder.setText(R$id.tvAudioTitle, postSubjectItem.getTitle());
        AppCompatTextView appCompatTextView = (AppCompatTextView) baseViewHolder.getView(R$id.tvTime);
        Media media = postSubjectItem.getMedia();
        if (media != null && (audio = media.getAudio()) != null) {
            if (!audio.isEmpty()) {
                Long duration = audio.get(0).getDuration();
                appCompatTextView.setText(TimeUtilKt.j(duration != null ? duration.longValue() : 0L));
            }
            unit = Unit.f68710a;
        }
        if (unit == null) {
            appCompatTextView.setVisibility(8);
        }
    }

    public final void w(BaseViewHolder baseViewHolder, PostSubjectItem postSubjectItem) {
        ResourceDetectors resourceDetector;
        String url;
        String thumbnail;
        Cover cover;
        Cover cover2;
        if (postSubjectItem.getSubject() != null) {
            Subject subject = postSubjectItem.getSubject();
            Date dateK = h0.k(subject != null ? subject.getReleaseDate() : null, "yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateK);
            AppCompatTextView appCompatTextView = (AppCompatTextView) baseViewHolder.getViewOrNull(R$id.tvSubjectYear);
            if (appCompatTextView != null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) String.valueOf(calendar.get(1)));
                Subject subject2 = postSubjectItem.getSubject();
                if (!TextUtils.isEmpty(subject2 != null ? subject2.getCountryName() : null)) {
                    SpannableStringBuilder spannableStringBuilderAppend = spannableStringBuilder.append((CharSequence) " • ");
                    Subject subject3 = postSubjectItem.getSubject();
                    spannableStringBuilderAppend.append((CharSequence) (subject3 != null ? subject3.getCountryName() : null));
                }
                appCompatTextView.setText(spannableStringBuilder.toString());
                Subject subject4 = postSubjectItem.getSubject();
                Drawable drawable = z2.a.getDrawable(appCompatTextView.getContext(), com.transsion.moviedetailapi.a.a(subject4 != null ? subject4.getSubjectType() : null));
                if (drawable != null) {
                    drawable.setTint(z2.a.getColor(appCompatTextView.getContext(), R$color.gray_40));
                }
                appCompatTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            int i11 = R$id.tvSubject;
            Subject subject5 = postSubjectItem.getSubject();
            baseViewHolder.setText(i11, subject5 != null ? subject5.getTitle() : null);
            ShapeableImageView shapeableImageView = (ShapeableImageView) baseViewHolder.getViewOrNull(R$id.ivSubjectCover);
            if (shapeableImageView != null) {
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = shapeableImageView.getContext();
                Intrinsics.f(context, "context");
                Subject subject6 = postSubjectItem.getSubject();
                if (subject6 == null || (cover2 = subject6.getCover()) == null || (url = cover2.getUrl()) == null) {
                    url = "";
                }
                int i12 = R$mipmap.home_ic_default_res;
                int iA = f0.a(42.0f);
                int iA2 = f0.a(56.0f);
                Subject subject7 = postSubjectItem.getSubject();
                if (subject7 == null || (cover = subject7.getCover()) == null || (thumbnail = cover.getThumbnail()) == null) {
                    thumbnail = "";
                }
                companion.o(context, shapeableImageView, url, (32704 & 8) != 0 ? R$color.skeleton : i12, (32704 & 16) != 0 ? companion.d() : iA, (32704 & 32) != 0 ? companion.c() : iA2, (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : thumbnail, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
            }
        }
        DownloadView downloadView = (DownloadView) baseViewHolder.getViewOrNull(R$id.llDownload);
        if (downloadView != null) {
            Subject subject8 = postSubjectItem.getSubject();
            String subjectId = subject8 != null ? subject8.getSubjectId() : null;
            Subject subject9 = postSubjectItem.getSubject();
            String resourceId = (subject9 == null || (resourceDetector = subject9.getResourceDetector()) == null) ? null : resourceDetector.getResourceId();
            Subject subject10 = postSubjectItem.getSubject();
            DownloadView.setShowType$default(downloadView, subjectId, resourceId, subject10 != null ? Boolean.valueOf(subject10.isSeries()) : null, false, 0, 24, null);
        }
        if (downloadView != null) {
            downloadView.setPageFrom("post_detail_recommend");
            Subject subject11 = postSubjectItem.getSubject();
            if (subject11 == null || !Intrinsics.b(subject11.getHasResource(), Boolean.TRUE)) {
                so.c.g(downloadView);
            } else {
                so.c.k(downloadView);
            }
        }
    }
}
