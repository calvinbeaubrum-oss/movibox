package com.transsion.home.fragment.tab;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.tn.lib.widget.R$color;
import com.transsion.home.bean.HomeTabItem;
import com.transsion.home.bean.NameImage;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
public final class CustomTabAdView extends FrameLayout implements h20.b {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppCompatImageView f52478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AppCompatTextView f52479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f52480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f52481d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f52482f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f52483g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomTabAdView(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f52480c = z2.a.getColor(context, R$color.text_01);
        this.f52481d = z2.a.getColor(context, R$color.text_02);
        this.f52482f = LazyKt__LazyJVMKt.b(new Function0<Integer>() { // from class: com.transsion.home.fragment.tab.CustomTabAdView$mLeftPadding$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(com.blankj.utilcode.util.f0.a(12.0f));
            }
        });
        this.f52483g = LazyKt__LazyJVMKt.b(new Function0<Integer>() { // from class: com.transsion.home.fragment.tab.CustomTabAdView$mRightPadding$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(com.blankj.utilcode.util.f0.a(10.0f));
            }
        });
    }

    private final int getMLeftPadding() {
        return ((Number) this.f52482f.getValue()).intValue();
    }

    private final int getMRightPadding() {
        return ((Number) this.f52483g.getValue()).intValue();
    }

    public final void a(HomeTabItem homeTabItem, AppCompatImageView appCompatImageView) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, com.blankj.utilcode.util.f0.a(22.0f));
        layoutParams.gravity = 17;
        layoutParams.bottomMargin = 20;
        layoutParams.topMargin = 20;
        appCompatImageView.setPadding(getMLeftPadding(), 0, getMRightPadding(), 0);
        removeAllViews();
        xq.l.f80683a.b(appCompatImageView);
        addView(appCompatImageView, layoutParams);
    }

    public final void b(HomeTabItem homeTabItem) {
        removeAllViews();
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f52479b = appCompatTextView;
        appCompatTextView.setText(homeTabItem != null ? homeTabItem.getName() : null);
        appCompatTextView.setTextSize(14.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        appCompatTextView.setPadding(getMLeftPadding(), 0, getMRightPadding(), 0);
        appCompatTextView.setGravity(17);
        layoutParams.gravity = 17;
        addView(appCompatTextView, layoutParams);
    }

    public final void changeTextColor(int i11, int i12) {
        this.f52481d = i11;
        this.f52480c = i12;
    }

    @Override // h20.b
    public int getContentBottom() {
        return 0;
    }

    @Override // h20.b
    public int getContentLeft() {
        return 0;
    }

    @Override // h20.b
    public int getContentRight() {
        return 0;
    }

    @Override // h20.b
    public int getContentTop() {
        return 0;
    }

    @Override // h20.d
    public void onDeselected(int i11, int i12) {
        TextPaint paint;
        AppCompatTextView appCompatTextView = this.f52479b;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(this.f52481d);
        }
        AppCompatTextView appCompatTextView2 = this.f52479b;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setTextSize(14.0f);
        }
        AppCompatTextView appCompatTextView3 = this.f52479b;
        if (appCompatTextView3 != null && (paint = appCompatTextView3.getPaint()) != null) {
            paint.setFakeBoldText(false);
            Context context = getContext();
            Intrinsics.f(context, "context");
            paint.setTypeface(so.a.d(context));
        }
        AppCompatTextView appCompatTextView4 = this.f52479b;
        if (appCompatTextView4 != null) {
            appCompatTextView4.setPadding(getMLeftPadding(), 0, getMRightPadding(), 0);
        }
    }

    @Override // h20.d
    public void onEnter(int i11, int i12, float f11, boolean z11) {
        TextPaint paint;
        AppCompatTextView appCompatTextView = this.f52479b;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(this.f52480c);
        }
        AppCompatTextView appCompatTextView2 = this.f52479b;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setTextSize(16.0f);
        }
        AppCompatTextView appCompatTextView3 = this.f52479b;
        if (appCompatTextView3 == null || (paint = appCompatTextView3.getPaint()) == null) {
            return;
        }
        paint.setFakeBoldText(true);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
    }

    @Override // h20.d
    public void onLeave(int i11, int i12, float f11, boolean z11) {
        TextPaint paint;
        AppCompatTextView appCompatTextView = this.f52479b;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(this.f52481d);
        }
        AppCompatTextView appCompatTextView2 = this.f52479b;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setTextSize(16.0f);
        }
        AppCompatTextView appCompatTextView3 = this.f52479b;
        if (appCompatTextView3 == null || (paint = appCompatTextView3.getPaint()) == null) {
            return;
        }
        paint.setFakeBoldText(false);
        paint.setTypeface(Typeface.DEFAULT);
    }

    @Override // h20.d
    public void onSelected(int i11, int i12) {
        TextPaint paint;
        AppCompatTextView appCompatTextView = this.f52479b;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(this.f52480c);
        }
        AppCompatTextView appCompatTextView2 = this.f52479b;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setTextSize(16.0f);
        }
        AppCompatTextView appCompatTextView3 = this.f52479b;
        if (appCompatTextView3 != null && (paint = appCompatTextView3.getPaint()) != null) {
            paint.setFakeBoldText(true);
            Context context = getContext();
            Intrinsics.f(context, "context");
            paint.setTypeface(so.a.a(context));
        }
        AppCompatTextView appCompatTextView4 = this.f52479b;
        if (appCompatTextView4 != null) {
            appCompatTextView4.setPadding(getMLeftPadding() - 2, 0, getMRightPadding() - 2, 0);
        }
    }

    public final void setTextColor(int i11) {
        AppCompatTextView appCompatTextView = this.f52479b;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(i11);
        }
    }

    public final void showData(final HomeTabItem homeTabItem) {
        NameImage nameImage;
        NameImage nameImage2;
        String url;
        NameImage nameImage3;
        String url2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CustomTabAdView --> showData() --> homeTabItem = ");
        sb2.append(homeTabItem);
        sb2.append(" ");
        String url3 = null;
        if ((homeTabItem != null && (nameImage3 = homeTabItem.getNameImage()) != null && (url2 = nameImage3.getUrl()) != null && kotlin.text.l.u(url2, ".gif", false, 2, null)) || (homeTabItem != null && (nameImage2 = homeTabItem.getNameImage()) != null && (url = nameImage2.getUrl()) != null && kotlin.text.l.u(url, ".GIF", false, 2, null))) {
            xq.h hVar = xq.h.f80675a;
            Context context = getContext();
            Intrinsics.f(context, "context");
            NameImage nameImage4 = homeTabItem.getNameImage();
            hVar.a(context, nameImage4 != null ? nameImage4.getUrl() : null, new Function0<Unit>() { // from class: com.transsion.home.fragment.tab.CustomTabAdView.showData.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    CustomTabAdView.this.b(homeTabItem);
                }
            }, new Function1<GifDrawable, Unit>() { // from class: com.transsion.home.fragment.tab.CustomTabAdView.showData.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GifDrawable gifDrawable) {
                    invoke2(gifDrawable);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(GifDrawable gifDrawable) {
                    CustomTabAdView.this.f52478a = new AppCompatImageView(CustomTabAdView.this.getContext());
                    AppCompatImageView appCompatImageView = CustomTabAdView.this.f52478a;
                    if (appCompatImageView != null) {
                        CustomTabAdView customTabAdView = CustomTabAdView.this;
                        HomeTabItem homeTabItem2 = homeTabItem;
                        Glide.with(appCompatImageView.getContext()).load2((Drawable) gifDrawable).into(appCompatImageView);
                        customTabAdView.a(homeTabItem2, appCompatImageView);
                    }
                }
            });
            return;
        }
        xq.h hVar2 = xq.h.f80675a;
        Context context2 = getContext();
        Intrinsics.f(context2, "context");
        if (homeTabItem != null && (nameImage = homeTabItem.getNameImage()) != null) {
            url3 = nameImage.getUrl();
        }
        hVar2.b(context2, url3, new Function0<Unit>() { // from class: com.transsion.home.fragment.tab.CustomTabAdView.showData.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CustomTabAdView.this.b(homeTabItem);
            }
        }, new Function1<Bitmap, Unit>() { // from class: com.transsion.home.fragment.tab.CustomTabAdView.showData.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                invoke2(bitmap);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Bitmap bitmap) {
                CustomTabAdView.this.f52478a = new AppCompatImageView(CustomTabAdView.this.getContext());
                AppCompatImageView appCompatImageView = CustomTabAdView.this.f52478a;
                if (appCompatImageView != null) {
                    CustomTabAdView customTabAdView = CustomTabAdView.this;
                    HomeTabItem homeTabItem2 = homeTabItem;
                    Glide.with(appCompatImageView.getContext()).load2(bitmap).into(appCompatImageView);
                    customTabAdView.a(homeTabItem2, appCompatImageView);
                }
            }
        });
    }
}
