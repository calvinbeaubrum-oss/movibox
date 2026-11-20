package com.transsion.postdetail.ui.adapter.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.f0;
import com.blankj.utilcode.util.h0;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.R$mipmap;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.ninegridview.video.NineGridVideoView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsnet.downloader.widget.DownloadView;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
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
public abstract class d extends BaseItemProvider<PostSubjectItem> {
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_provider_recommend_base_layout;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, PostSubjectItem item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        v(helper, item);
        z(helper, item);
    }

    public final void v(BaseViewHolder baseViewHolder, PostSubjectItem postSubjectItem) {
        ResourceDetectors resourceDetector;
        String url;
        String thumbnail;
        Cover cover;
        Cover cover2;
        if (TextUtils.isEmpty(postSubjectItem.getTitle())) {
            baseViewHolder.setText(R$id.tvTitle, postSubjectItem.getContent());
        } else {
            baseViewHolder.setText(R$id.tvTitle, postSubjectItem.getTitle());
        }
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
            downloadView.setPageFrom("TODO pageFrom");
            Subject subject11 = postSubjectItem.getSubject();
            if (subject11 == null || !Intrinsics.b(subject11.getHasResource(), Boolean.TRUE)) {
                so.c.g(downloadView);
            } else {
                so.c.k(downloadView);
            }
        }
    }

    public abstract void w(AppCompatImageView appCompatImageView, PostSubjectItem postSubjectItem);

    public abstract void x(NineGridVideoView nineGridVideoView, PostSubjectItem postSubjectItem);

    public abstract void y(AppCompatTextView appCompatTextView, PostSubjectItem postSubjectItem);

    public final void z(BaseViewHolder baseViewHolder, PostSubjectItem postSubjectItem) {
        x((NineGridVideoView) baseViewHolder.getView(R$id.nine_grid), postSubjectItem);
        w((AppCompatImageView) baseViewHolder.getView(R$id.ivCenterIcon), postSubjectItem);
        y((AppCompatTextView) baseViewHolder.getView(R$id.tvTime), postSubjectItem);
    }
}
