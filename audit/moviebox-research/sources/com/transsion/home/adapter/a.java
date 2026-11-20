package com.transsion.home.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.f0;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.CornerTextView;
import com.tn.lib.widget.R$color;
import com.transsion.ad.bidding.nativead.c;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.bean.LayoutStyle;
import com.transsion.home.bean.MovieItem;
import com.transsion.home.p003enum.LayoutStyleEnum;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a extends BaseQuickAdapter<MovieItem, BaseViewHolder> implements j {
    public final nt.b H;
    public LayoutStyle I;
    public final int J;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(List<MovieItem> dataList, nt.b bVar, LayoutStyle layoutStyle, int i11) {
        super(R$layout.home_adapter_movie, dataList);
        Intrinsics.g(dataList, "dataList");
        this.H = bVar;
        this.I = layoutStyle;
        this.J = i11;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x015b  */
    /* JADX WARN: Code duplicated, block: B:52:0x016b  */
    /* JADX WARN: Code duplicated, block: B:53:0x016f  */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, MovieItem item) {
        int i11;
        String thumbnail;
        String url;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        int iA = f0.a(107.0f);
        int iA2 = f0.a(149.0f);
        int iA3 = f0.a(((this.J - 1) * 8.0f) + 24.0f);
        int iE = d0.e();
        int i12 = this.J;
        int i13 = (iE - iA3) / i12;
        int i14 = (int) (i13 * ((iA2 * 1.0f) / iA));
        int iA4 = f0.a(((i12 - 1) * 8.0f) + 24.0f);
        f0.a(109.0f);
        f0.a(109.0f);
        int i15 = iE - iA4;
        int i16 = i15 / this.J;
        int iA5 = f0.a(164.0f);
        int iA6 = f0.a(92.0f);
        int i17 = i15 / this.J;
        int i18 = (int) (i17 * ((iA6 * 1.0f) / iA5));
        if (item.getNonAdDelegate() != null) {
            d00.b bVar = d00.b.f62855a;
            Context context = getContext();
            c nonAdDelegate = item.getNonAdDelegate();
            zq.b bVarA = bVar.a(context, nonAdDelegate != null ? nonAdDelegate.Q() : null);
            NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) holder.getViewOrNull(R$id.nativeView);
            if (nativeWrapperAdView != null) {
                nativeWrapperAdView.bindNativeView(item.getNonAdDelegate(), bVarA);
            }
            ((FrameLayout) holder.getView(R$id.nativeView)).setVisibility(0);
            ((Group) holder.getView(R$id.group)).setVisibility(8);
            return;
        }
        ((FrameLayout) holder.getView(R$id.nativeView)).setVisibility(8);
        ((Group) holder.getView(R$id.group)).setVisibility(0);
        ShapeableImageView shapeableImageView = (ShapeableImageView) holder.getView(R$id.iv_cover);
        LayoutStyle layoutStyle = this.I;
        if (layoutStyle == null) {
            Integer subjectType = item.getSubjectType();
            SubjectType subjectType2 = SubjectType.AUDIO;
            int value = subjectType2.getValue();
            if (subjectType == null || subjectType.intValue() != value) {
                Integer subjectType3 = item.getSubjectType();
                int value2 = SubjectType.MOVIE.getValue();
                if (subjectType3 == null || subjectType3.intValue() != value2) {
                    Integer subjectType4 = item.getSubjectType();
                    int value3 = SubjectType.VSHOW.getValue();
                    if (subjectType4 == null || subjectType4.intValue() != value3) {
                        Integer subjectType5 = item.getSubjectType();
                        int value4 = SubjectType.TV.getValue();
                        if (subjectType5 == null || subjectType5.intValue() != value4) {
                            Integer subjectType6 = item.getSubjectType();
                            int value5 = SubjectType.SHORT_TV.getValue();
                            if (subjectType6 == null || subjectType6.intValue() != value5) {
                                i14 = i18;
                                i11 = i17;
                            }
                        }
                    }
                }
            }
            Integer subjectType7 = item.getSubjectType();
            int value6 = subjectType2.getValue();
            if (subjectType7 != null && subjectType7.intValue() == value6) {
                i14 = i16;
                i11 = i14;
            } else {
                i11 = i13;
            }
        } else {
            String shape = layoutStyle != null ? layoutStyle.getShape() : null;
            if (Intrinsics.b(shape, LayoutStyleEnum.Horizontal.getValue())) {
                i14 = i18;
                i11 = i17;
            } else if (Intrinsics.b(shape, LayoutStyleEnum.Square.getValue())) {
                i14 = i16;
                i11 = i14;
            } else {
                i11 = i13;
            }
        }
        ViewGroup.LayoutParams layoutParams = shapeableImageView.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar2).height = i14;
        shapeableImageView.setLayoutParams(bVar2);
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context context2 = getContext();
        Cover cover = item.getCover();
        String str = (cover == null || (url = cover.getUrl()) == null) ? "" : url;
        int i19 = R$color.cl37;
        Cover cover2 = item.getCover();
        companion.o(context2, shapeableImageView, str, (32704 & 8) != 0 ? R$color.skeleton : i19, (32704 & 16) != 0 ? companion.d() : i11, (32704 & 32) != 0 ? companion.c() : i14, (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) ? "" : thumbnail, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
        holder.setText(R$id.tv_title, item.getTitle());
        holder.setText(R$id.tv_tabs, item.getGenre() + "•" + item.getCountryName());
        holder.setText(R$id.tv_score, item.getImdbRatingValue());
        ((CornerTextView) holder.getView(R$id.tv_tips)).setTextWithType(item.getCorner(), item.getSubjectType());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.onViewRecycled(holder);
        ShapeableImageView shapeableImageView = (ShapeableImageView) holder.getViewOrNull(R$id.iv_cover);
        if (shapeableImageView == null || shapeableImageView.getContext() == null) {
            return;
        }
        Context context = shapeableImageView.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null || !activity.isDestroyed()) {
            Context context2 = shapeableImageView.getContext();
            Activity activity2 = context2 instanceof Activity ? (Activity) context2 : null;
            if (activity2 == null || !activity2.isFinishing()) {
                Glide.with(shapeableImageView.getContext()).clear(shapeableImageView);
            }
        }
    }

    public final void I0(LayoutStyle layoutStyle) {
        this.I = layoutStyle;
    }

    @Override // h9.j
    public /* synthetic */ f a(BaseQuickAdapter baseQuickAdapter) {
        return i.a(this, baseQuickAdapter);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: i0 */
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.onViewAttachedToWindow(holder);
        int bindingAdapterPosition = holder.getBindingAdapterPosition();
        nt.b bVar = this.H;
        if (bVar != null) {
            RecyclerView.m layoutManager = W().getLayoutManager();
            Intrinsics.e(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            bVar.h((GridLayoutManager) layoutManager, bindingAdapterPosition, true);
        }
    }
}
