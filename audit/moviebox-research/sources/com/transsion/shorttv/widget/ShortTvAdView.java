package com.transsion.shorttv.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.f0;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baselib.report.m;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Link;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.shorttv.R$drawable;
import com.transsion.shorttv.R$layout;
import java.util.LinkedHashMap;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ShortTvAdView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f57896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public nx.d f57897b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTvAdView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTvAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvAdView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f57897b = nx.d.a(LayoutInflater.from(getContext()).inflate(R$layout.view_ad_short_tv_layout, this));
        setBackgroundResource(R$drawable.view_ad_short_tv_bg);
        setVisibility(8);
    }

    public static final void b(ShortTVItem shortTVItem, View view) {
        m.f51277a.m("short_tv_ad_btn", "click", new LinkedHashMap());
        com.transsion.ad.strategy.a aVar = com.transsion.ad.strategy.a.f50582a;
        Link link = shortTVItem.getLink();
        String deeplink = link != null ? link.getDeeplink() : null;
        Link link2 = shortTVItem.getLink();
        aVar.a(deeplink, link2 != null ? link2.getUrl() : null, null);
    }

    public final void hide() {
        setVisibility(8);
    }

    public final void setData(final ShortTVItem shortTVItem) {
        ShapeableImageView shapeableImageView;
        String icon;
        AppCompatTextView appCompatTextView;
        uo.b.f78622a.c("ShortTvAdView", "ShortTvAdView --> setData() --> link = " + (shortTVItem != null ? shortTVItem.getLink() : null), false);
        if ((shortTVItem != null ? shortTVItem.getLink() : null) == null) {
            this.f57896a = false;
            setVisibility(8);
            return;
        }
        this.f57896a = true;
        setVisibility(0);
        nx.d dVar = this.f57897b;
        AppCompatTextView appCompatTextView2 = dVar != null ? dVar.f72206d : null;
        if (appCompatTextView2 != null) {
            Link link = shortTVItem.getLink();
            appCompatTextView2.setText(link != null ? link.getTitle() : null);
        }
        nx.d dVar2 = this.f57897b;
        AppCompatTextView appCompatTextView3 = dVar2 != null ? dVar2.f72205c : null;
        if (appCompatTextView3 != null) {
            Link link2 = shortTVItem.getLink();
            appCompatTextView3.setText(link2 != null ? link2.getBtn() : null);
        }
        nx.d dVar3 = this.f57897b;
        if (dVar3 != null && (appCompatTextView = dVar3.f72205c) != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv.widget.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShortTvAdView.b(shortTVItem, view);
                }
            });
        }
        nx.d dVar4 = this.f57897b;
        if (dVar4 == null || (shapeableImageView = dVar4.f72204b) == null) {
            return;
        }
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context context = getContext();
        Intrinsics.f(context, "context");
        Link link3 = shortTVItem.getLink();
        if (link3 == null || (icon = link3.getIcon()) == null) {
            icon = "";
        }
        companion.r(context, shapeableImageView, icon, (4088 & 8) != 0 ? companion.d() : f0.a(28.0f), (4088 & 16) != 0 ? companion.c() : f0.a(28.0f), (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
    }

    public final void show() {
        if (this.f57896a) {
            setVisibility(0);
        }
    }
}
