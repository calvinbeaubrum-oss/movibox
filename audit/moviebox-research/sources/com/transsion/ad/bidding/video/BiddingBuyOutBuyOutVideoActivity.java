package com.transsion.ad.bidding.video;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.ad.R$id;
import com.transsion.ad.R$mipmap;
import com.transsion.ad.bidding.base.AbsBiddingActivity;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
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
@Metadata
public final class BiddingBuyOutBuyOutVideoActivity extends AbsBiddingActivity {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f50371m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public pq.d f50372n;

    public static final void D0(BiddingBuyOutBuyOutVideoActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.Q();
    }

    public static final void E0(BiddingBuyOutBuyOutVideoActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.f50371m) {
            this$0.G0();
            return;
        }
        com.transsion.ad.a.F(com.transsion.ad.a.f50276a, BiddingBuyOutBuyOutVideoActivity.class.getSimpleName() + " --> setOnClickListener() --> 只有在最后10秒的时候才能点击", false, 2, null);
    }

    public static final void F0(BiddingBuyOutBuyOutVideoActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.V();
    }

    @Override // com.transsion.ad.bidding.base.n
    public String A() {
        return "t_ad_sdk_i";
    }

    public final void C0() {
        ShapeableImageView shapeableImageView;
        ShapeableImageView shapeableImageView2;
        try {
            Result.Companion companion = Result.Companion;
            pq.d dVar = this.f50372n;
            if (dVar != null && (shapeableImageView2 = dVar.f74003o) != null) {
                AdPlans adPlansY = Y();
                if (TextUtils.isEmpty(adPlansY != null ? adPlansY.getAdvertiserAvatarPath() : null)) {
                    RequestManager requestManagerWith = Glide.with((FragmentActivity) this);
                    AdPlans adPlansY2 = Y();
                    requestManagerWith.load(adPlansY2 != null ? adPlansY2.getAdvertiserAvatar() : null).into(shapeableImageView2);
                } else {
                    RequestManager requestManagerWith2 = Glide.with((FragmentActivity) this);
                    AdPlans adPlansY3 = Y();
                    requestManagerWith2.load(adPlansY3 != null ? adPlansY3.getAdvertiserAvatarPath() : null).into(shapeableImageView2);
                }
            }
            pq.d dVar2 = this.f50372n;
            AppCompatTextView appCompatTextView = dVar2 != null ? dVar2.f74007s : null;
            if (appCompatTextView != null) {
                AdMaterialList adMaterialListX = X();
                appCompatTextView.setText(adMaterialListX != null ? adMaterialListX.getTitle() : null);
            }
            pq.d dVar3 = this.f50372n;
            AppCompatTextView appCompatTextView2 = dVar3 != null ? dVar3.f74006r : null;
            if (appCompatTextView2 != null) {
                AdMaterialList adMaterialListX2 = X();
                appCompatTextView2.setText(adMaterialListX2 != null ? adMaterialListX2.getDesc() : null);
            }
            pq.d dVar4 = this.f50372n;
            AppCompatTextView appCompatTextView3 = dVar4 != null ? dVar4.f74004p : null;
            if (appCompatTextView3 != null) {
                AdMaterialList adMaterialListX3 = X();
                appCompatTextView3.setText(adMaterialListX3 != null ? adMaterialListX3.getButtonText() : null);
            }
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        try {
            pq.d dVar5 = this.f50372n;
            if (dVar5 != null && (shapeableImageView = dVar5.f73999k) != null) {
                AdPlans adPlansY4 = Y();
                if (TextUtils.isEmpty(adPlansY4 != null ? adPlansY4.getAdvertiserAvatarPath() : null)) {
                    RequestManager requestManagerWith3 = Glide.with((FragmentActivity) this);
                    AdPlans adPlansY5 = Y();
                    requestManagerWith3.load(adPlansY5 != null ? adPlansY5.getAdvertiserAvatar() : null).into(shapeableImageView);
                } else {
                    RequestManager requestManagerWith4 = Glide.with((FragmentActivity) this);
                    AdPlans adPlansY6 = Y();
                    requestManagerWith4.load(adPlansY6 != null ? adPlansY6.getAdvertiserAvatarPath() : null).into(shapeableImageView);
                }
            }
            pq.d dVar6 = this.f50372n;
            AppCompatTextView appCompatTextView4 = dVar6 != null ? dVar6.f74002n : null;
            if (appCompatTextView4 != null) {
                AdMaterialList adMaterialListX4 = X();
                appCompatTextView4.setText(adMaterialListX4 != null ? adMaterialListX4.getTitle() : null);
            }
            pq.d dVar7 = this.f50372n;
            AppCompatTextView appCompatTextView5 = dVar7 != null ? dVar7.f74001m : null;
            if (appCompatTextView5 != null) {
                AdMaterialList adMaterialListX5 = X();
                appCompatTextView5.setText(adMaterialListX5 != null ? adMaterialListX5.getDesc() : null);
            }
            pq.d dVar8 = this.f50372n;
            AppCompatTextView appCompatTextView6 = dVar8 != null ? dVar8.f74000l : null;
            if (appCompatTextView6 != null) {
                AdMaterialList adMaterialListX6 = X();
                appCompatTextView6.setText(adMaterialListX6 != null ? adMaterialListX6.getButtonText() : null);
            }
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th3) {
            Result.Companion companion3 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th3));
        }
    }

    public void G0() {
        if (this.f50371m) {
            r0(true);
            new BiddingCloseAdDialog().l0(new Function0<Unit>() { // from class: com.transsion.ad.bidding.video.BiddingBuyOutBuyOutVideoActivity$showCloseAdDialog$1
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
                    this.this$0.V();
                }
            }, new Function0<Unit>() { // from class: com.transsion.ad.bidding.video.BiddingBuyOutBuyOutVideoActivity$showCloseAdDialog$2
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
                    this.this$0.r0(false);
                }
            }).m0(this, "CloseAdDialog");
            return;
        }
        com.transsion.ad.a.F(com.transsion.ad.a.f50276a, getClassTag() + " --> showCloseAdDialog() --> 只有在最后10秒的时候才能展示", false, 2, null);
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public View W() {
        return findViewById(R$id.adIcon);
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public int a0() {
        return wq.b.f79582a.g();
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public FrameLayout c0() {
        pq.d dVar = this.f50372n;
        if (dVar != null) {
            return dVar.f73994f;
        }
        return null;
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public View g0() {
        pq.d dVarC = pq.d.c(getLayoutInflater());
        this.f50372n = dVarC;
        if (dVarC != null) {
            return dVarC.getRoot();
        }
        return null;
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public FrameLayout h0() {
        pq.d dVar = this.f50372n;
        if (dVar != null) {
            return dVar.f73995g;
        }
        return null;
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public void j0() {
        pq.d dVar = this.f50372n;
        ConstraintLayout constraintLayout = dVar != null ? dVar.f73992c : null;
        if (constraintLayout == null) {
            return;
        }
        constraintLayout.setVisibility(0);
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    @SuppressLint({"StringFormatMatches"})
    public void o0(int i11) {
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        if (i11 <= 10) {
            this.f50371m = true;
            pq.d dVar = this.f50372n;
            if (dVar != null && (appCompatImageView2 = dVar.f73997i) != null) {
                appCompatImageView2.setImageResource(R$mipmap.ad_video_01);
            }
        } else {
            pq.d dVar2 = this.f50372n;
            if (dVar2 != null && (appCompatImageView = dVar2.f73997i) != null) {
                appCompatImageView.setImageResource(R$mipmap.ad_video_03);
            }
        }
        if (i11 == a0()) {
            pq.d dVar3 = this.f50372n;
            AppCompatTextView appCompatTextView = dVar3 != null ? dVar3.f74005q : null;
            if (appCompatTextView != null) {
                appCompatTextView.setVisibility(0);
            }
        }
        String str = "Reward in " + i11 + "s";
        pq.d dVar4 = this.f50372n;
        AppCompatTextView appCompatTextView2 = dVar4 != null ? dVar4.f74005q : null;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(str);
        }
        if (i11 == 0) {
            pq.d dVar5 = this.f50372n;
            AppCompatTextView appCompatTextView3 = dVar5 != null ? dVar5.f74005q : null;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setVisibility(8);
            }
            S();
        }
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingActivity
    public void s0() {
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        C0();
        l.f80683a.a(new View[]{findViewById(R$id.textureView), findViewById(R$id.clAdEndLayout)}, new View.OnClickListener() { // from class: com.transsion.ad.bidding.video.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiddingBuyOutBuyOutVideoActivity.D0(this.f50380a, view);
            }
        });
        pq.d dVar = this.f50372n;
        if (dVar != null && (appCompatImageView2 = dVar.f73997i) != null) {
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.bidding.video.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BiddingBuyOutBuyOutVideoActivity.E0(this.f50381a, view);
                }
            });
        }
        pq.d dVar2 = this.f50372n;
        if (dVar2 == null || (appCompatImageView = dVar2.f73996h) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ad.bidding.video.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BiddingBuyOutBuyOutVideoActivity.F0(this.f50382a, view);
            }
        });
    }
}
