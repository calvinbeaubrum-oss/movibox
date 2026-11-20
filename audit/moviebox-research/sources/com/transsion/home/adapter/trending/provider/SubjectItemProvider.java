package com.transsion.home.adapter.trending.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.f0;
import com.blankj.utilcode.util.h0;
import com.bumptech.glide.Priority;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Trailer;
import com.transsnet.downloader.widget.DownloadView;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
public final class SubjectItemProvider extends b<OperateItem> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f52272f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f52273g = Math.min(d0.e(), d0.c());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f52274h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BaseViewHolder f52275i;

    public SubjectItemProvider(boolean z11) {
        this.f52272f = z11;
        this.f52274h = f0.a(z11 ? 146.40001f : 122.0f);
    }

    public final View A() {
        BaseViewHolder baseViewHolder = this.f52275i;
        if (baseViewHolder != null) {
            return (DownloadView) baseViewHolder.getViewOrNull(R$id.ll_download);
        }
        return null;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return PostItemType.SUBJECT.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.post_list_item_subject;
    }

    /* JADX WARN: Code duplicated, block: B:135:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:137:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:143:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:53:0x0112 A[PHI: r5
  0x0112: PHI (r5v20 com.transsion.moviedetailapi.bean.Cover) = (r5v19 com.transsion.moviedetailapi.bean.Cover), (r5v22 com.transsion.moviedetailapi.bean.Cover) binds: [B:56:0x011d, B:52:0x0110] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:54:0x0117  */
    /* JADX WARN: Code duplicated, block: B:78:0x0157 A[PHI: r5
  0x0157: PHI (r5v26 com.transsion.moviedetailapi.bean.Cover) = (r5v25 com.transsion.moviedetailapi.bean.Cover), (r5v28 com.transsion.moviedetailapi.bean.Cover) binds: [B:81:0x0162, B:77:0x0155] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:79:0x015c  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r13v10, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12, types: [T] */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v29 */
    /* JADX WARN: Type inference failed for: r13v3, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r13v30 */
    /* JADX WARN: Type inference failed for: r13v31 */
    /* JADX WARN: Type inference failed for: r13v32 */
    /* JADX WARN: Type inference failed for: r13v33 */
    /* JADX WARN: Type inference failed for: r13v34 */
    /* JADX WARN: Type inference failed for: r13v35 */
    /* JADX WARN: Type inference failed for: r13v36 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7, types: [T] */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r3v10, types: [android.graphics.drawable.Drawable, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v10, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView] */
    /* JADX WARN: Type inference failed for: r5v12, types: [android.text.SpannableStringBuilder] */
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, OperateItem item) {
        String subjectId;
        ?? r11;
        ResourceDetectors resourceDetector;
        ?? r13;
        Cover cover;
        ?? url;
        String url2;
        ?? r14;
        ?? r15;
        Cover cover2;
        ?? thumbnail;
        String thumbnail2;
        Cover cover3;
        String thumbnail3;
        Cover cover4;
        String url3;
        String thumbnail4;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        final Subject feedsSubject = item.getFeedsSubject();
        if (feedsSubject == null || (subjectId = feedsSubject.getSubjectId()) == null || subjectId.length() == 0) {
            return;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) helper.getViewOrNull(R$id.cl_cover);
        if (constraintLayout != null) {
            ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
            int i11 = this.f52274h;
            layoutParams.height = i11;
            layoutParams.width = (i11 / 4) * 3;
            constraintLayout.setLayoutParams(layoutParams);
        }
        ShapeableImageView shapeableImageView = (ShapeableImageView) helper.getViewOrNull(R$id.iv_cover);
        if (shapeableImageView == null) {
            r11 = 0;
        } else if (feedsSubject.getBuiltIn()) {
            kotlinx.coroutines.j.d(l0.a(w0.c()), null, null, new SubjectItemProvider$convert$2$1(feedsSubject, shapeableImageView, null), 3, null);
            r11 = 0;
        } else {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = shapeableImageView.getContext();
            Intrinsics.f(context, "context");
            Cover cover5 = feedsSubject.getCover();
            if (cover5 == null || (url3 = cover5.getUrl()) == null) {
                url3 = "";
            }
            int i12 = R$color.skeleton;
            int i13 = this.f52273g;
            Cover cover6 = feedsSubject.getCover();
            r11 = 0;
            companion.p(context, shapeableImageView, url3, (65480 & 8) != 0 ? R$color.skeleton : i12, (65480 & 16) != 0 ? companion.d() : i13, (65480 & 32) != 0 ? companion.c() : 0, (65480 & 64) != 0 ? 0 : 0, (65480 & 128) != 0, (65480 & 256) != 0 ? "" : (cover6 == null || (thumbnail4 = cover6.getThumbnail()) == null) ? "" : thumbnail4, (65480 & 512) != 0, (65480 & 1024) != 0, (65480 & 2048) != 0 ? false : false, (65480 & 4096) != 0 ? false : false, (65480 & 8192) != 0 ? false : false, (65480 & 16384) != 0 ? 25 : 0, (32768 & 65480) != 0 ? Priority.NORMAL : null, (65480 & 65536) != 0 ? null : new Function3<Boolean, Boolean, Long, Unit>() { // from class: com.transsion.home.adapter.trending.provider.SubjectItemProvider$convert$2$2
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2, Long l11) {
                    invoke(bool.booleanValue(), bool2.booleanValue(), l11.longValue());
                    return Unit.f68710a;
                }

                public final void invoke(boolean z11, boolean z12, long j11) {
                    feedsSubject.setLoadCoverSuccess(z11);
                    feedsSubject.setCoverCache(z12);
                    feedsSubject.setLoadCoverDuration(j11);
                }
            });
        }
        ShapeableImageView shapeableImageView2 = (ShapeableImageView) helper.getViewOrNull(R$id.iv_stills);
        if (shapeableImageView2 != null) {
            ViewGroup.LayoutParams layoutParams2 = shapeableImageView2.getLayoutParams();
            layoutParams2.height = this.f52274h;
            shapeableImageView2.setLayoutParams(layoutParams2);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Trailer trailer = feedsSubject.getTrailer();
            ?? url4 = (trailer == null || (cover4 = trailer.getCover()) == null) ? r11 : cover4.getUrl();
            objectRef.element = url4;
            CharSequence charSequence = (CharSequence) url4;
            if (charSequence == null || charSequence.length() == 0) {
                Cover stills = feedsSubject.getStills();
                if (stills != null) {
                    url2 = stills.getUrl();
                } else {
                    r13 = r11;
                }
                if (r13 == 0 || r13.length() == 0) {
                    r13 = url2;
                    r13 = url2;
                    cover = feedsSubject.getCover();
                    if (cover != null) {
                        r13 = url2;
                        url = cover.getUrl();
                    } else {
                        r13 = url2;
                        url = r11;
                    }
                } else {
                    cover = feedsSubject.getStills();
                    if (cover != null) {
                        r13 = url2;
                        url = cover.getUrl();
                    } else {
                        r13 = url2;
                        url = r11;
                    }
                }
                objectRef.element = url;
            }
            Trailer trailer2 = feedsSubject.getTrailer();
            if (trailer2 == null || (cover3 = trailer2.getCover()) == null) {
                r14 = r11;
            } else {
                thumbnail3 = cover3.getThumbnail();
            }
            if (r14 == 0 || r14.length() == 0) {
                r14 = thumbnail3;
                thumbnail = r14;
                r14 = thumbnail3;
                Cover stills2 = feedsSubject.getStills();
                if (stills2 != null) {
                    thumbnail2 = stills2.getThumbnail();
                } else {
                    r15 = r11;
                }
                if (r15 == 0 || r15.length() == 0) {
                    r15 = thumbnail2;
                    r15 = thumbnail2;
                    cover2 = feedsSubject.getCover();
                    if (cover2 != null) {
                        r15 = thumbnail2;
                        thumbnail = cover2.getThumbnail();
                    } else {
                        r15 = thumbnail2;
                        thumbnail = r11;
                    }
                } else {
                    cover2 = feedsSubject.getStills();
                    if (cover2 != null) {
                        r15 = thumbnail2;
                        thumbnail = cover2.getThumbnail();
                    } else {
                        r15 = thumbnail2;
                        thumbnail = r11;
                    }
                }
            }
            r14 = thumbnail3;
            thumbnail = r14;
            if (feedsSubject.getBuiltIn()) {
                kotlinx.coroutines.j.d(l0.a(w0.c()), null, null, new SubjectItemProvider$convert$3$1(objectRef, shapeableImageView2, r11), 3, null);
            } else {
                ImageHelper.Companion companion2 = ImageHelper.f51371a;
                Context context2 = shapeableImageView2.getContext();
                Intrinsics.f(context2, "context");
                String str = (String) objectRef.element;
                companion2.q(context2, shapeableImageView2, str == null ? "" : str, (8120 & 8) != 0 ? companion2.d() : R$color.skeleton, (8120 & 16) != 0 ? companion2.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : thumbnail == 0 ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
            }
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) helper.getViewOrNull(R$id.ic_player);
        if (appCompatImageView != null) {
            if (feedsSubject.getTrailer() == null) {
                so.c.g(appCompatImageView);
            } else {
                so.c.k(appCompatImageView);
            }
        }
        helper.setText(R$id.tv_subject, feedsSubject.getTitle());
        Date dateK = h0.k(feedsSubject.getReleaseDate(), "yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateK);
        ?? r12 = (AppCompatTextView) helper.getViewOrNull(R$id.tv_subject_year);
        if (r12 != 0) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) String.valueOf(calendar.get(1)));
            String countryName = feedsSubject.getCountryName();
            if (countryName != null && countryName.length() != 0) {
                spannableStringBuilder.append((CharSequence) " • ").append((CharSequence) feedsSubject.getCountryName());
            }
            String genre = feedsSubject.getGenre();
            if (genre != null && genre.length() != 0) {
                ?? Append = spannableStringBuilder.append((CharSequence) " • ");
                String genre2 = feedsSubject.getGenre();
                Append.append(genre2 != null ? kotlin.text.l.F(genre2, "，", " • ", false, 4, null) : r11);
            }
            r12.setText(spannableStringBuilder.toString());
            Drawable drawable = z2.a.getDrawable(r12.getContext(), com.transsion.moviedetailapi.a.a(feedsSubject.getSubjectType()));
            if (drawable != null) {
                drawable.setTint(z2.a.getColor(r12.getContext(), R$color.gray_40));
            }
            r12.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, r11, r11, r11);
        }
        helper.setText(com.transsion.baseui.R$id.tv_subject, feedsSubject.getTitle());
        if (Intrinsics.b(feedsSubject.getHasResource(), Boolean.TRUE)) {
            DownloadView downloadView = (DownloadView) helper.getViewOrNull(R$id.ll_download);
            if (downloadView != null) {
                so.c.k(downloadView);
                if (com.transsion.baselib.utils.m.f51320a.b()) {
                    Integer subjectType = feedsSubject.getSubjectType();
                    int value = SubjectType.SHORT_TV.getValue();
                    if (subjectType != null && subjectType.intValue() == value) {
                        resourceDetector = feedsSubject.getResourceDetector();
                        if (resourceDetector != null) {
                            String subjectId2 = feedsSubject.getSubjectId();
                            String resourceId = resourceDetector.getResourceId();
                            Integer type = resourceDetector.getType();
                            DownloadView.setShowType$default(downloadView, subjectId2, resourceId, Boolean.valueOf(type == null && type.intValue() == 1), false, 0, 24, null);
                        }
                    } else {
                        downloadView.setShowPlayType();
                    }
                } else {
                    resourceDetector = feedsSubject.getResourceDetector();
                    if (resourceDetector != null) {
                        String subjectId3 = feedsSubject.getSubjectId();
                        String resourceId2 = resourceDetector.getResourceId();
                        Integer type2 = resourceDetector.getType();
                        DownloadView.setShowType$default(downloadView, subjectId3, resourceId2, Boolean.valueOf(type2 == null && type2.intValue() == 1), false, 0, 24, null);
                    }
                }
            }
        } else {
            helper.setGone(R$id.ll_download, true);
        }
        this.f52275i = helper;
        w(helper, feedsSubject);
    }
}
