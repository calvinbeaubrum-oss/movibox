package com.transsion.postdetail.shorttv.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.transsion.postdetail.R$color;
import com.transsion.postdetail.R$drawable;
import com.transsion.postdetail.R$mipmap;
import com.transsion.postdetail.R$string;
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
public final class ShortTvEpisodeItemView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f55501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f55502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f55503c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvEpisodeItemView(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        TextView textView = new TextView(getContext());
        this.f55501a = textView;
        ImageView imageView = new ImageView(getContext());
        this.f55502b = imageView;
        ImageView imageView2 = new ImageView(getContext());
        this.f55503c = imageView2;
        textView.setBackgroundResource(R$drawable.post_detail_short_tv_episode_bg);
        ConstraintLayout.b bVar = new ConstraintLayout.b(-1, 0);
        bVar.I = "h,1:1";
        bVar.f7293i = 0;
        addView(textView, bVar);
        textView.setTextSize(16.0f);
        textView.setTextColor(z2.a.getColorStateList(getContext(), R$color.post_detail_short_tv_episode_tv_color));
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setGravity(17);
        imageView.setImageResource(R$drawable.post_detail_short_tv_lock);
        ConstraintLayout.b bVar2 = new ConstraintLayout.b(-2, -2);
        bVar2.f7293i = 0;
        bVar2.f7319v = 0;
        addView(imageView, bVar2);
        int iE = com.blankj.utilcode.util.i.e(16.0f);
        int iE2 = com.blankj.utilcode.util.i.e(4.0f);
        ConstraintLayout.b bVar3 = new ConstraintLayout.b(iE, iE);
        bVar3.f7299l = 0;
        bVar3.f7315t = 0;
        bVar3.setMargins(iE2, iE2, iE2, iE2);
        imageView2.setColorFilter(z2.a.getColor(getContext(), com.tn.lib.widget.R$color.color_07B84E));
        addView(imageView2, bVar3);
        setPadding(iE2, 0, iE2, iE2 * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvEpisodeItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        TextView textView = new TextView(getContext());
        this.f55501a = textView;
        ImageView imageView = new ImageView(getContext());
        this.f55502b = imageView;
        ImageView imageView2 = new ImageView(getContext());
        this.f55503c = imageView2;
        textView.setBackgroundResource(R$drawable.post_detail_short_tv_episode_bg);
        ConstraintLayout.b bVar = new ConstraintLayout.b(-1, 0);
        bVar.I = "h,1:1";
        bVar.f7293i = 0;
        addView(textView, bVar);
        textView.setTextSize(16.0f);
        textView.setTextColor(z2.a.getColorStateList(getContext(), R$color.post_detail_short_tv_episode_tv_color));
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setGravity(17);
        imageView.setImageResource(R$drawable.post_detail_short_tv_lock);
        ConstraintLayout.b bVar2 = new ConstraintLayout.b(-2, -2);
        bVar2.f7293i = 0;
        bVar2.f7319v = 0;
        addView(imageView, bVar2);
        int iE = com.blankj.utilcode.util.i.e(16.0f);
        int iE2 = com.blankj.utilcode.util.i.e(4.0f);
        ConstraintLayout.b bVar3 = new ConstraintLayout.b(iE, iE);
        bVar3.f7299l = 0;
        bVar3.f7315t = 0;
        bVar3.setMargins(iE2, iE2, iE2, iE2);
        imageView2.setColorFilter(z2.a.getColor(getContext(), com.tn.lib.widget.R$color.color_07B84E));
        addView(imageView2, bVar3);
        setPadding(iE2, 0, iE2, iE2 * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvEpisodeItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        TextView textView = new TextView(getContext());
        this.f55501a = textView;
        ImageView imageView = new ImageView(getContext());
        this.f55502b = imageView;
        ImageView imageView2 = new ImageView(getContext());
        this.f55503c = imageView2;
        textView.setBackgroundResource(R$drawable.post_detail_short_tv_episode_bg);
        ConstraintLayout.b bVar = new ConstraintLayout.b(-1, 0);
        bVar.I = "h,1:1";
        bVar.f7293i = 0;
        addView(textView, bVar);
        textView.setTextSize(16.0f);
        textView.setTextColor(z2.a.getColorStateList(getContext(), R$color.post_detail_short_tv_episode_tv_color));
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setGravity(17);
        imageView.setImageResource(R$drawable.post_detail_short_tv_lock);
        ConstraintLayout.b bVar2 = new ConstraintLayout.b(-2, -2);
        bVar2.f7293i = 0;
        bVar2.f7319v = 0;
        addView(imageView, bVar2);
        int iE = com.blankj.utilcode.util.i.e(16.0f);
        int iE2 = com.blankj.utilcode.util.i.e(4.0f);
        ConstraintLayout.b bVar3 = new ConstraintLayout.b(iE, iE);
        bVar3.f7299l = 0;
        bVar3.f7315t = 0;
        bVar3.setMargins(iE2, iE2, iE2, iE2);
        imageView2.setColorFilter(z2.a.getColor(getContext(), com.tn.lib.widget.R$color.color_07B84E));
        addView(imageView2, bVar3);
        setPadding(iE2, 0, iE2, iE2 * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvEpisodeItemView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        Intrinsics.g(context, "context");
        TextView textView = new TextView(getContext());
        this.f55501a = textView;
        ImageView imageView = new ImageView(getContext());
        this.f55502b = imageView;
        ImageView imageView2 = new ImageView(getContext());
        this.f55503c = imageView2;
        textView.setBackgroundResource(R$drawable.post_detail_short_tv_episode_bg);
        ConstraintLayout.b bVar = new ConstraintLayout.b(-1, 0);
        bVar.I = "h,1:1";
        bVar.f7293i = 0;
        addView(textView, bVar);
        textView.setTextSize(16.0f);
        textView.setTextColor(z2.a.getColorStateList(getContext(), R$color.post_detail_short_tv_episode_tv_color));
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setGravity(17);
        imageView.setImageResource(R$drawable.post_detail_short_tv_lock);
        ConstraintLayout.b bVar2 = new ConstraintLayout.b(-2, -2);
        bVar2.f7293i = 0;
        bVar2.f7319v = 0;
        addView(imageView, bVar2);
        int iE = com.blankj.utilcode.util.i.e(16.0f);
        int iE2 = com.blankj.utilcode.util.i.e(4.0f);
        ConstraintLayout.b bVar3 = new ConstraintLayout.b(iE, iE);
        bVar3.f7299l = 0;
        bVar3.f7315t = 0;
        bVar3.setMargins(iE2, iE2, iE2, iE2);
        imageView2.setColorFilter(z2.a.getColor(getContext(), com.tn.lib.widget.R$color.color_07B84E));
        addView(imageView2, bVar3);
        setPadding(iE2, 0, iE2, iE2 * 2);
    }

    public final void showDownloadStatus(boolean z11) {
        this.f55502b.setImageResource(R$mipmap.post_detail_short_tv_downloaded);
        this.f55502b.setVisibility(z11 ? 0 : 8);
    }

    public final void showIndex(int i11) {
        if (i11 == 0) {
            this.f55501a.setText(getContext().getString(R$string.short_tv_trailer));
        } else {
            this.f55501a.setText(String.valueOf(i11));
        }
    }

    public final void showLockImg(boolean z11) {
        this.f55502b.setImageResource(R$drawable.post_detail_short_tv_lock);
        this.f55502b.setVisibility(z11 ? 0 : 8);
    }

    public final void showPlayingImg(boolean z11) {
        if (z11) {
            if (this.f55503c.getTag() == null) {
                this.f55503c.setTag("playing");
                Glide.with(this.f55503c).load(Integer.valueOf(R$drawable.post_detail_short_tv_playing)).into(this.f55503c);
            }
            so.c.k(this.f55503c);
        } else {
            so.c.g(this.f55503c);
        }
        this.f55501a.setSelected(z11);
    }
}
