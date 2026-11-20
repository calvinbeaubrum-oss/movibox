package com.transsnet.downloader.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.f0;
import com.noober.background.drawable.DrawableCreator;
import com.noober.background.view.BLTextView;
import com.tn.lib.widget.R$color;
import com.transsnet.downloader.R$drawable;
import com.transsnet.downloader.R$mipmap;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class DownloadShortTvEpItemView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BLTextView f61336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f61337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f61338c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadShortTvEpItemView(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        BLTextView bLTextView = new BLTextView(getContext());
        this.f61336a = bLTextView;
        ImageView imageView = new ImageView(getContext());
        this.f61337b = imageView;
        ImageView imageView2 = new ImageView(getContext());
        this.f61338c = imageView2;
        int iA = f0.a(4.0f);
        int iA2 = f0.a(6.0f);
        bLTextView.setBackground(new DrawableCreator.Builder().setCornersRadius(iA).setSolidColor(getContext().getResources().getColor(R$color.white_10)).build());
        ConstraintLayout.b bVar = new ConstraintLayout.b(-1, 0);
        bVar.I = "h,1:1";
        bVar.f7293i = 0;
        addView(bLTextView, bVar);
        bLTextView.setTextSize(16.0f);
        bLTextView.setTextColor(z2.a.getColorStateList(getContext(), com.transsnet.downloader.R$color.selector_download_short_tv_ep_text));
        bLTextView.setTypeface(Typeface.DEFAULT_BOLD);
        bLTextView.setGravity(17);
        imageView.setImageResource(R$mipmap.ic_short_tv_lock);
        ConstraintLayout.b bVar2 = new ConstraintLayout.b(-2, -2);
        bVar2.f7293i = 0;
        bVar2.f7319v = 0;
        addView(imageView, bVar2);
        imageView2.setImageDrawable(z2.a.getDrawable(getContext(), R$drawable.selector_download_group_check));
        int i11 = iA2 * 2;
        ConstraintLayout.b bVar3 = new ConstraintLayout.b(i11, i11);
        bVar3.f7319v = 0;
        bVar3.f7299l = 0;
        bVar3.setMarginEnd(iA2);
        ((ViewGroup.MarginLayoutParams) bVar3).bottomMargin = iA2;
        addView(imageView2, bVar3);
        setPadding(iA, 0, iA, iA * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadShortTvEpItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        BLTextView bLTextView = new BLTextView(getContext());
        this.f61336a = bLTextView;
        ImageView imageView = new ImageView(getContext());
        this.f61337b = imageView;
        ImageView imageView2 = new ImageView(getContext());
        this.f61338c = imageView2;
        int iA = f0.a(4.0f);
        int iA2 = f0.a(6.0f);
        bLTextView.setBackground(new DrawableCreator.Builder().setCornersRadius(iA).setSolidColor(getContext().getResources().getColor(R$color.white_10)).build());
        ConstraintLayout.b bVar = new ConstraintLayout.b(-1, 0);
        bVar.I = "h,1:1";
        bVar.f7293i = 0;
        addView(bLTextView, bVar);
        bLTextView.setTextSize(16.0f);
        bLTextView.setTextColor(z2.a.getColorStateList(getContext(), com.transsnet.downloader.R$color.selector_download_short_tv_ep_text));
        bLTextView.setTypeface(Typeface.DEFAULT_BOLD);
        bLTextView.setGravity(17);
        imageView.setImageResource(R$mipmap.ic_short_tv_lock);
        ConstraintLayout.b bVar2 = new ConstraintLayout.b(-2, -2);
        bVar2.f7293i = 0;
        bVar2.f7319v = 0;
        addView(imageView, bVar2);
        imageView2.setImageDrawable(z2.a.getDrawable(getContext(), R$drawable.selector_download_group_check));
        int i11 = iA2 * 2;
        ConstraintLayout.b bVar3 = new ConstraintLayout.b(i11, i11);
        bVar3.f7319v = 0;
        bVar3.f7299l = 0;
        bVar3.setMarginEnd(iA2);
        ((ViewGroup.MarginLayoutParams) bVar3).bottomMargin = iA2;
        addView(imageView2, bVar3);
        setPadding(iA, 0, iA, iA * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadShortTvEpItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        BLTextView bLTextView = new BLTextView(getContext());
        this.f61336a = bLTextView;
        ImageView imageView = new ImageView(getContext());
        this.f61337b = imageView;
        ImageView imageView2 = new ImageView(getContext());
        this.f61338c = imageView2;
        int iA = f0.a(4.0f);
        int iA2 = f0.a(6.0f);
        bLTextView.setBackground(new DrawableCreator.Builder().setCornersRadius(iA).setSolidColor(getContext().getResources().getColor(R$color.white_10)).build());
        ConstraintLayout.b bVar = new ConstraintLayout.b(-1, 0);
        bVar.I = "h,1:1";
        bVar.f7293i = 0;
        addView(bLTextView, bVar);
        bLTextView.setTextSize(16.0f);
        bLTextView.setTextColor(z2.a.getColorStateList(getContext(), com.transsnet.downloader.R$color.selector_download_short_tv_ep_text));
        bLTextView.setTypeface(Typeface.DEFAULT_BOLD);
        bLTextView.setGravity(17);
        imageView.setImageResource(R$mipmap.ic_short_tv_lock);
        ConstraintLayout.b bVar2 = new ConstraintLayout.b(-2, -2);
        bVar2.f7293i = 0;
        bVar2.f7319v = 0;
        addView(imageView, bVar2);
        imageView2.setImageDrawable(z2.a.getDrawable(getContext(), R$drawable.selector_download_group_check));
        int i12 = iA2 * 2;
        ConstraintLayout.b bVar3 = new ConstraintLayout.b(i12, i12);
        bVar3.f7319v = 0;
        bVar3.f7299l = 0;
        bVar3.setMarginEnd(iA2);
        ((ViewGroup.MarginLayoutParams) bVar3).bottomMargin = iA2;
        addView(imageView2, bVar3);
        setPadding(iA, 0, iA, iA * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadShortTvEpItemView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        Intrinsics.g(context, "context");
        BLTextView bLTextView = new BLTextView(getContext());
        this.f61336a = bLTextView;
        ImageView imageView = new ImageView(getContext());
        this.f61337b = imageView;
        ImageView imageView2 = new ImageView(getContext());
        this.f61338c = imageView2;
        int iA = f0.a(4.0f);
        int iA2 = f0.a(6.0f);
        bLTextView.setBackground(new DrawableCreator.Builder().setCornersRadius(iA).setSolidColor(getContext().getResources().getColor(R$color.white_10)).build());
        ConstraintLayout.b bVar = new ConstraintLayout.b(-1, 0);
        bVar.I = "h,1:1";
        bVar.f7293i = 0;
        addView(bLTextView, bVar);
        bLTextView.setTextSize(16.0f);
        bLTextView.setTextColor(z2.a.getColorStateList(getContext(), com.transsnet.downloader.R$color.selector_download_short_tv_ep_text));
        bLTextView.setTypeface(Typeface.DEFAULT_BOLD);
        bLTextView.setGravity(17);
        imageView.setImageResource(R$mipmap.ic_short_tv_lock);
        ConstraintLayout.b bVar2 = new ConstraintLayout.b(-2, -2);
        bVar2.f7293i = 0;
        bVar2.f7319v = 0;
        addView(imageView, bVar2);
        imageView2.setImageDrawable(z2.a.getDrawable(getContext(), R$drawable.selector_download_group_check));
        int i13 = iA2 * 2;
        ConstraintLayout.b bVar3 = new ConstraintLayout.b(i13, i13);
        bVar3.f7319v = 0;
        bVar3.f7299l = 0;
        bVar3.setMarginEnd(iA2);
        ((ViewGroup.MarginLayoutParams) bVar3).bottomMargin = iA2;
        addView(imageView2, bVar3);
        setPadding(iA, 0, iA, iA * 2);
    }

    public final void setSelect(boolean z11) {
        this.f61338c.setSelected(z11);
    }

    public final void showDownloadImg(boolean z11) {
        if (z11) {
            so.c.g(this.f61338c);
            this.f61337b.setImageResource(R$mipmap.ic_short_tv_download_sub);
        }
        this.f61337b.setVisibility(z11 ? 0 : 8);
    }

    public final void showIndex(int i11) {
        this.f61336a.setText(String.valueOf(i11));
    }

    public final void showLockImg(boolean z11) {
        if (z11) {
            so.c.g(this.f61338c);
            this.f61337b.setImageResource(R$mipmap.ic_short_tv_lock);
        } else {
            so.c.k(this.f61338c);
        }
        this.f61337b.setVisibility(z11 ? 0 : 8);
    }
}
