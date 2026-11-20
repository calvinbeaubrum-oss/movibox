package com.transsion.home.adapter.trending.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.h0;
import com.bumptech.glide.Priority;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.CornerTextView;
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
import com.transsnet.downloader.widget.DownloadView;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
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
public final class SubjectSingleImgItemProvider extends b<OperateItem> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f52278f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f52279g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final double f52280h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BaseViewHolder f52281i;

    public SubjectSingleImgItemProvider(boolean z11) {
        this.f52278f = z11;
        int iMin = Math.min(d0.e(), d0.c());
        this.f52279g = iMin;
        this.f52280h = ((double) iMin) * 0.5d;
    }

    private final String A(int i11) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
        String str = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i11 / 3600), Integer.valueOf((i11 % 3600) / 60), Integer.valueOf(i11 % 60)}, 3));
        Intrinsics.f(str, "format(...)");
        return str;
    }

    public final View B() {
        BaseViewHolder baseViewHolder = this.f52281i;
        if (baseViewHolder != null) {
            return (DownloadView) baseViewHolder.getViewOrNull(R$id.ll_download);
        }
        return null;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return PostItemType.SINGLE_SUBJECT.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.post_list_item_subject_single_img;
    }

    /* JADX WARN: Code duplicated, block: B:53:0x0123  */
    /* JADX WARN: Code duplicated, block: B:55:0x013d  */
    /* JADX WARN: Code duplicated, block: B:56:0x0142  */
    /* JADX WARN: Code duplicated, block: B:92:0x022c  */
    /* JADX WARN: Code duplicated, block: B:94:0x0232  */
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, OperateItem item) {
        String subjectId;
        ResourceDetectors resourceDetector;
        Integer type;
        Integer durationSeconds;
        int iIntValue;
        String url;
        String thumbnail;
        ConstraintLayout constraintLayout;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        final Subject feedsSubject = item.getFeedsSubject();
        if (feedsSubject == null || (subjectId = feedsSubject.getSubjectId()) == null || subjectId.length() == 0) {
            return;
        }
        if (this.f52278f && (constraintLayout = (ConstraintLayout) helper.getViewOrNull(R$id.cl_cover)) != null) {
            ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
            layoutParams.height = gs.a.a(122);
            layoutParams.width = ((int) this.f52280h) - gs.a.a(36);
            constraintLayout.setLayoutParams(layoutParams);
        }
        ShapeableImageView shapeableImageView = (ShapeableImageView) helper.getViewOrNull(R$id.iv_cover);
        if (shapeableImageView != null) {
            if (feedsSubject.getBuiltIn()) {
                kotlinx.coroutines.j.d(l0.a(w0.c()), null, null, new SubjectSingleImgItemProvider$convert$2$1(feedsSubject, shapeableImageView, null), 3, null);
            } else {
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = shapeableImageView.getContext();
                Intrinsics.f(context, "context");
                Cover cover = feedsSubject.getCover();
                if (cover == null || (url = cover.getUrl()) == null) {
                    url = "";
                }
                int i11 = R$color.skeleton;
                int i12 = this.f52279g;
                Cover cover2 = feedsSubject.getCover();
                companion.p(context, shapeableImageView, url, (65480 & 8) != 0 ? R$color.skeleton : i11, (65480 & 16) != 0 ? companion.d() : i12, (65480 & 32) != 0 ? companion.c() : 0, (65480 & 64) != 0 ? 0 : 0, (65480 & 128) != 0, (65480 & 256) != 0 ? "" : (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) ? "" : thumbnail, (65480 & 512) != 0, (65480 & 1024) != 0, (65480 & 2048) != 0 ? false : false, (65480 & 4096) != 0 ? false : false, (65480 & 8192) != 0 ? false : false, (65480 & 16384) != 0 ? 25 : 0, (32768 & 65480) != 0 ? Priority.NORMAL : null, (65480 & 65536) != 0 ? null : new Function3<Boolean, Boolean, Long, Unit>() { // from class: com.transsion.home.adapter.trending.provider.SubjectSingleImgItemProvider$convert$2$2
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
        Integer subjectType = feedsSubject.getSubjectType();
        int value = SubjectType.MUSIC.getValue();
        boolean z11 = false;
        if (subjectType != null && subjectType.intValue() == value) {
            so.c.h(helper.getView(R$id.tv_score));
            TextView textView = (TextView) helper.getView(R$id.tv_duration);
            so.c.k(textView);
            durationSeconds = feedsSubject.getDurationSeconds();
            if (durationSeconds != null) {
                iIntValue = durationSeconds.intValue();
            } else {
                iIntValue = 0;
            }
            textView.setText(A(iIntValue));
        } else {
            Integer subjectType2 = feedsSubject.getSubjectType();
            int value2 = SubjectType.AUDIO.getValue();
            if (subjectType2 != null && subjectType2.intValue() == value2) {
                so.c.h(helper.getView(R$id.tv_score));
                TextView textView2 = (TextView) helper.getView(R$id.tv_duration);
                so.c.k(textView2);
                durationSeconds = feedsSubject.getDurationSeconds();
                if (durationSeconds != null) {
                    iIntValue = durationSeconds.intValue();
                } else {
                    iIntValue = 0;
                }
                textView2.setText(A(iIntValue));
            } else {
                Integer subjectType3 = feedsSubject.getSubjectType();
                int value3 = SubjectType.EDUCATION.getValue();
                if (subjectType3 != null && subjectType3.intValue() == value3) {
                    so.c.h(helper.getView(R$id.tv_score));
                    TextView textView3 = (TextView) helper.getView(R$id.tv_duration);
                    so.c.k(textView3);
                    durationSeconds = feedsSubject.getDurationSeconds();
                    if (durationSeconds != null) {
                        iIntValue = durationSeconds.intValue();
                    } else {
                        iIntValue = 0;
                    }
                    textView3.setText(A(iIntValue));
                }
            }
        }
        ((CornerTextView) helper.getView(R$id.tv_tips)).setTextWithType(feedsSubject.getCorner(), feedsSubject.getSubjectType());
        Date dateK = h0.k(feedsSubject.getReleaseDate(), "yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateK);
        AppCompatTextView appCompatTextView = (AppCompatTextView) helper.getViewOrNull(R$id.tv_subject_year);
        if (appCompatTextView != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) String.valueOf(calendar.get(1)));
            String countryName = feedsSubject.getCountryName();
            if (countryName != null && countryName.length() != 0) {
                spannableStringBuilder.append((CharSequence) " • ").append((CharSequence) feedsSubject.getCountryName());
            }
            String genre = feedsSubject.getGenre();
            if (genre != null && genre.length() != 0) {
                SpannableStringBuilder spannableStringBuilderAppend = spannableStringBuilder.append((CharSequence) " • ");
                String genre2 = feedsSubject.getGenre();
                spannableStringBuilderAppend.append((CharSequence) (genre2 != null ? kotlin.text.l.F(genre2, "，", " • ", false, 4, null) : null));
            }
            appCompatTextView.setText(spannableStringBuilder.toString());
            Drawable drawable = z2.a.getDrawable(appCompatTextView.getContext(), com.transsion.moviedetailapi.a.a(feedsSubject.getSubjectType()));
            if (drawable != null) {
                drawable.setTint(z2.a.getColor(appCompatTextView.getContext(), R$color.gray_40));
            }
            appCompatTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (Intrinsics.b(feedsSubject.getHasResource(), Boolean.TRUE)) {
            DownloadView downloadView = (DownloadView) helper.getViewOrNull(R$id.ll_download);
            if (downloadView != null) {
                so.c.k(downloadView);
                if (com.transsion.baselib.utils.m.f51320a.b()) {
                    Integer subjectType4 = feedsSubject.getSubjectType();
                    int value4 = SubjectType.SHORT_TV.getValue();
                    if (subjectType4 != null && subjectType4.intValue() == value4) {
                        resourceDetector = feedsSubject.getResourceDetector();
                        if (resourceDetector != null) {
                            String subjectId2 = feedsSubject.getSubjectId();
                            String resourceId = resourceDetector.getResourceId();
                            type = resourceDetector.getType();
                            if (type != null && type.intValue() == 1) {
                                z11 = true;
                            }
                            DownloadView.setShowType$default(downloadView, subjectId2, resourceId, Boolean.valueOf(z11), false, 0, 24, null);
                        }
                    } else {
                        downloadView.setShowPlayType();
                    }
                } else {
                    resourceDetector = feedsSubject.getResourceDetector();
                    if (resourceDetector != null) {
                        String subjectId3 = feedsSubject.getSubjectId();
                        String resourceId2 = resourceDetector.getResourceId();
                        type = resourceDetector.getType();
                        if (type != null) {
                            z11 = true;
                        }
                        DownloadView.setShowType$default(downloadView, subjectId3, resourceId2, Boolean.valueOf(z11), false, 0, 24, null);
                    }
                }
            }
        } else {
            helper.setGone(R$id.ll_download, true);
        }
        this.f52281i = helper;
        w(helper, feedsSubject);
    }
}
