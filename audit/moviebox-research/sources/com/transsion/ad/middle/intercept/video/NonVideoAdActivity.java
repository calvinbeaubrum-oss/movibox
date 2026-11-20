package com.transsion.ad.middle.intercept.video;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;
import com.transsion.ad.R$mipmap;
import com.transsion.ad.middle.intercept.BaseInterceptMbAdActivity;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import xq.l;

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
@Deprecated
@Metadata
public final class NonVideoAdActivity extends BaseInterceptMbAdActivity {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public AppCompatTextView f50462o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AppCompatImageView f50463p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public AppCompatImageView f50464q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ShapeableImageView f50465r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public AppCompatTextView f50466s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public AppCompatTextView f50467t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AppCompatTextView f50468u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f50469v;

    public static final void A0(NonVideoAdActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.f50469v) {
            this$0.getOnBackPressedDispatcher().l();
            return;
        }
        com.transsion.ad.a.F(com.transsion.ad.a.f50276a, NonVideoAdActivity.class.getSimpleName() + " --> setOnClickListener() --> 只有在最后10秒的时候才能点击", false, 2, null);
    }

    public static final void B0(NonVideoAdActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.o0()) {
            AppCompatImageView appCompatImageView = this$0.f50463p;
            if (appCompatImageView != null) {
                appCompatImageView.setImageResource(R$mipmap.ad_video_04);
                return;
            }
            return;
        }
        AppCompatImageView appCompatImageView2 = this$0.f50463p;
        if (appCompatImageView2 != null) {
            appCompatImageView2.setImageResource(R$mipmap.ad_video_02);
        }
    }

    private final void C0() {
        Intent intent = new Intent("com.transsion.wrapperad.middle.intercept.BaseInterceptAdActivity.Action.onRewarded.Video");
        intent.putExtra("key", AppMeasurementSdk.ConditionalUserProperty.VALUE);
        u3.a.b(this).d(intent);
    }

    public static final void D0(NonVideoAdActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.S();
    }

    public static final void z0(NonVideoAdActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.U();
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptMbAdActivity
    public void T(boolean z11) {
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptMbAdActivity
    public Intent W() {
        return new Intent("com.transsion.wrapperad.middle.intercept.BaseInterceptAdActivity.Action.onDestroy.Video");
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptMbAdActivity
    public ImageView X() {
        return null;
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptMbAdActivity
    public Intent Y() {
        return new Intent("com.transsion.wrapperad.middle.intercept.BaseInterceptAdActivity.Action.onShow.Video");
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptMbAdActivity
    public TextureView Z() {
        View viewFindViewById = findViewById(R$id.textureView);
        Intrinsics.f(viewFindViewById, "findViewById(R.id.textureView)");
        return (TextureView) viewFindViewById;
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptMbAdActivity
    public int a0() {
        return 3;
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptMbAdActivity
    public int b0() {
        return wq.b.f79582a.g();
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptMbAdActivity
    public void e0() {
        ((ConstraintLayout) findViewById(R$id.clAdEndLayout)).setVisibility(0);
        ShapeableImageView shapeableImageView = (ShapeableImageView) findViewById(R$id.tvAdAvatar);
        ((AppCompatImageView) findViewById(R$id.ivAdClose)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.middle.intercept.video.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NonVideoAdActivity.z0(this.f50475a, view);
            }
        });
        AppCompatTextView appCompatTextView = (AppCompatTextView) findViewById(R$id.tvAdTitle);
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) findViewById(R$id.tvAdDesc);
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) findViewById(R$id.tvAdBtn);
        AdMaterialList adMaterialListC0 = c0();
        if (TextUtils.isEmpty(adMaterialListC0 != null ? adMaterialListC0.getButtonText() : null)) {
            appCompatTextView3.setVisibility(8);
        }
        try {
            Result.Companion companion = Result.Companion;
            if (shapeableImageView != null) {
                AdPlans adPlansD0 = d0();
                if (TextUtils.isEmpty(adPlansD0 != null ? adPlansD0.getAdvertiserAvatarPath() : null)) {
                    RequestManager requestManagerWith = Glide.with((FragmentActivity) this);
                    AdPlans adPlansD1 = d0();
                    requestManagerWith.load(adPlansD1 != null ? adPlansD1.getAdvertiserAvatar() : null).into(shapeableImageView);
                } else {
                    RequestManager requestManagerWith2 = Glide.with((FragmentActivity) this);
                    AdPlans adPlansD2 = d0();
                    requestManagerWith2.load(adPlansD2 != null ? adPlansD2.getAdvertiserAvatarPath() : null).into(shapeableImageView);
                }
            }
            if (appCompatTextView != null) {
                AdMaterialList adMaterialListC1 = c0();
                appCompatTextView.setText(adMaterialListC1 != null ? adMaterialListC1.getTitle() : null);
            }
            if (appCompatTextView2 != null) {
                AdMaterialList adMaterialListC2 = c0();
                appCompatTextView2.setText(adMaterialListC2 != null ? adMaterialListC2.getDesc() : null);
            }
            if (appCompatTextView3 != null) {
                AdMaterialList adMaterialListC3 = c0();
                appCompatTextView3.setText(adMaterialListC3 != null ? adMaterialListC3.getButtonText() : null);
            }
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    @Override // com.transsion.ad.strategy.MeasureManager.a
    public View getVisibilityView() {
        return (ConstraintLayout) findViewById(R$id.rlRoot);
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptMbAdActivity
    public void k0(int i11) {
        AppCompatTextView appCompatTextView;
        com.transsion.ad.a.F(com.transsion.ad.a.f50276a, NonVideoAdActivity.class.getSimpleName() + " --> refreshCountDownView() --> i = " + i11 + " -- getCountDownTimes() = " + b0(), false, 2, null);
        if (i11 <= 10) {
            this.f50469v = true;
            AppCompatImageView appCompatImageView = this.f50464q;
            if (appCompatImageView != null) {
                appCompatImageView.setImageResource(R$mipmap.ad_video_01);
            }
        } else {
            AppCompatImageView appCompatImageView2 = this.f50464q;
            if (appCompatImageView2 != null) {
                appCompatImageView2.setImageResource(R$mipmap.ad_video_03);
            }
        }
        if (i11 == b0() && (appCompatTextView = this.f50462o) != null) {
            appCompatTextView.setVisibility(0);
        }
        String str = "Reward in " + i11 + "s";
        AppCompatTextView appCompatTextView2 = this.f50462o;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(str);
        }
        if (i11 == 0) {
            AppCompatTextView appCompatTextView3 = this.f50462o;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setVisibility(8);
            }
            AppCompatImageView appCompatImageView3 = this.f50463p;
            if (appCompatImageView3 != null) {
                appCompatImageView3.setVisibility(8);
            }
            C0();
        }
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptMbAdActivity
    public void m0() {
        l.f80683a.a(new View[]{findViewById(R$id.textureView), findViewById(R$id.clAdEndLayout)}, new View.OnClickListener() { // from class: com.transsion.ad.middle.intercept.video.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NonVideoAdActivity.D0(this.f50474a, view);
            }
        });
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptMbAdActivity
    public int n0() {
        return R$layout.activity_non_video_ad;
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptMbAdActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f50462o = (AppCompatTextView) findViewById(R$id.tvCd);
        AppCompatImageView appCompatImageView = (AppCompatImageView) findViewById(R$id.ivClose);
        this.f50464q = appCompatImageView;
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.middle.intercept.video.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NonVideoAdActivity.A0(this.f50472a, view);
                }
            });
        }
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) findViewById(R$id.ivVolume);
        this.f50463p = appCompatImageView2;
        if (appCompatImageView2 != null) {
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.middle.intercept.video.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NonVideoAdActivity.B0(this.f50473a, view);
                }
            });
        }
        y0();
    }

    @Override // com.transsion.ad.middle.intercept.BaseInterceptMbAdActivity
    public void r0() {
        if (this.f50469v) {
            p0(true);
            f0();
            new CloseAdDialog().l0(new Function0<Unit>() { // from class: com.transsion.ad.middle.intercept.video.NonVideoAdActivity$showCloseAdDialog$1
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
                    this.this$0.U();
                }
            }, new Function0<Unit>() { // from class: com.transsion.ad.middle.intercept.video.NonVideoAdActivity$showCloseAdDialog$2
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
                    this.this$0.p0(false);
                    this.this$0.h0();
                }
            }).m0(this, "CloseAdDialog");
        } else {
            com.transsion.ad.a.F(com.transsion.ad.a.f50276a, NonVideoAdActivity.class.getSimpleName() + " --> showCloseAdDialog() --> 只有在最后10秒的时候才能展示", false, 2, null);
        }
    }

    public final void y0() {
        this.f50465r = (ShapeableImageView) findViewById(R$id.tvAvatar);
        this.f50466s = (AppCompatTextView) findViewById(R$id.tvTitle);
        this.f50467t = (AppCompatTextView) findViewById(R$id.tvDesc);
        this.f50468u = (AppCompatTextView) findViewById(R$id.tvBtn);
        try {
            Result.Companion companion = Result.Companion;
            ShapeableImageView shapeableImageView = this.f50465r;
            if (shapeableImageView != null) {
                AdPlans adPlansD0 = d0();
                if (TextUtils.isEmpty(adPlansD0 != null ? adPlansD0.getAdvertiserAvatarPath() : null)) {
                    RequestManager requestManagerWith = Glide.with((FragmentActivity) this);
                    AdPlans adPlansD1 = d0();
                    requestManagerWith.load(adPlansD1 != null ? adPlansD1.getAdvertiserAvatar() : null).into(shapeableImageView);
                } else {
                    RequestManager requestManagerWith2 = Glide.with((FragmentActivity) this);
                    AdPlans adPlansD2 = d0();
                    requestManagerWith2.load(adPlansD2 != null ? adPlansD2.getAdvertiserAvatarPath() : null).into(shapeableImageView);
                }
            }
            AppCompatTextView appCompatTextView = this.f50466s;
            if (appCompatTextView != null) {
                AdMaterialList adMaterialListC0 = c0();
                appCompatTextView.setText(adMaterialListC0 != null ? adMaterialListC0.getTitle() : null);
            }
            AppCompatTextView appCompatTextView2 = this.f50467t;
            if (appCompatTextView2 != null) {
                AdMaterialList adMaterialListC1 = c0();
                appCompatTextView2.setText(adMaterialListC1 != null ? adMaterialListC1.getDesc() : null);
            }
            AppCompatTextView appCompatTextView3 = this.f50468u;
            if (appCompatTextView3 != null) {
                AdMaterialList adMaterialListC2 = c0();
                appCompatTextView3.setText(adMaterialListC2 != null ? adMaterialListC2.getButtonText() : null);
            }
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }
}
