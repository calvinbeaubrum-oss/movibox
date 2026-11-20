package com.transsion.postdetail.shorttv.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.blankj.utilcode.util.f0;
import com.transsion.moviedetailapi.bean.PlayListDeepLink;
import com.transsion.postdetail.R$layout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.e0;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ShortTvCategoryView extends LinearLayoutCompat {
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final e0 f55499q;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ShortTvCategoryView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int iMax = Math.max(ShortTvCategoryView.this.f55499q.f77728b.getWidth(), f0.a(48.0f));
            uo.b.a aVar = uo.b.f78622a;
            uo.b.a.f(aVar, "ShortTVDiscoverCategoryView", "渲染结束获取的宽度为 " + iMax + ", 原始宽度为 " + ShortTvCategoryView.this.f55499q.f77728b.getWidth(), false, 4, null);
            int iF = (((com.transsion.core.utils.e.f() - f0.a(32.0f)) - iMax) - f0.a(16.0f)) / 2;
            uo.b.a.f(aVar, "ShortTVDiscoverCategoryView", "计算得出, ivAll.width = " + iMax + ", viewWidth = " + iF, false, 4, null);
            AppCompatTextView appCompatTextView = ShortTvCategoryView.this.f55499q.f77730d;
            ViewGroup.LayoutParams layoutParams = appCompatTextView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = iF;
            }
            appCompatTextView.setLayoutParams(layoutParams);
            AppCompatTextView appCompatTextView2 = ShortTvCategoryView.this.f55499q.f77729c;
            ViewGroup.LayoutParams layoutParams2 = appCompatTextView2.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = iF;
            }
            appCompatTextView2.setLayoutParams(layoutParams2);
            AppCompatTextView appCompatTextView3 = ShortTvCategoryView.this.f55499q.f77728b;
            ViewGroup.LayoutParams layoutParams3 = appCompatTextView3.getLayoutParams();
            if (layoutParams3 != null) {
                layoutParams3.width = iMax;
            }
            appCompatTextView3.setLayoutParams(layoutParams3);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTvCategoryView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTvCategoryView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvCategoryView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        View.inflate(context, R$layout.layout_short_tv_category, this);
        e0 e0VarA = e0.a(this);
        Intrinsics.f(e0VarA, "bind(this)");
        this.f55499q = e0VarA;
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(View view) {
        uo.b.a.f(uo.b.f78622a, "ShortTVDiscoverCategoryView", "click All", false, 4, null);
        com.alibaba.android.arouter.launcher.a.d().b("/home/movieFilter").withInt("tabId", 7).withString("tabCode", "ShortTV").withBoolean("showViewPager", false).navigation();
    }

    private final void x() {
        getViewTreeObserver().addOnGlobalLayoutListener(new b());
        this.f55499q.f77730d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.shorttv.widget.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortTvCategoryView.y(view);
            }
        });
        this.f55499q.f77729c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.shorttv.widget.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortTvCategoryView.z(view);
            }
        });
        this.f55499q.f77728b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.shorttv.widget.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortTvCategoryView.A(view);
            }
        });
    }

    public static final void y(View view) {
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.f(aVar, "ShortTVDiscoverCategoryView", "click Latest", false, 4, null);
        PlayListDeepLink playListDeepLinkA = PlayListDeepLink.Companion.a("oneroom://com.community.oneroom?type=/home/playlist&category=TVSHOW&recType=OPT&label=fresh-releases-list");
        if (playListDeepLinkA != null) {
            com.alibaba.android.arouter.launcher.a.d().b("/home/playlist").withString("label", playListDeepLinkA.getLabel()).withString("category", playListDeepLinkA.getCategory()).withString("recType", playListDeepLinkA.getRecType()).withString("topIds", null).navigation();
        } else {
            uo.b.a.k(aVar, "Invalid deeplink for oneroom://com.community.oneroom?type=/home/playlist&category=TVSHOW&recType=OPT&label=fresh-releases-list", false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(View view) {
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.f(aVar, "ShortTVDiscoverCategoryView", "click Hottest", false, 4, null);
        PlayListDeepLink playListDeepLinkA = PlayListDeepLink.Companion.a("oneroom://com.community.oneroom?type=/home/playlist&category=TVSHOW&recType=OPT&label=must-watch-list");
        if (playListDeepLinkA != null) {
            com.alibaba.android.arouter.launcher.a.d().b("/home/playlist").withString("label", playListDeepLinkA.getLabel()).withString("category", playListDeepLinkA.getCategory()).withString("recType", playListDeepLinkA.getRecType()).withString("topIds", null).navigation();
        } else {
            uo.b.a.k(aVar, "Invalid deeplink for oneroom://com.community.oneroom?type=/home/playlist&category=TVSHOW&recType=OPT&label=must-watch-list", false, 2, null);
        }
    }
}
