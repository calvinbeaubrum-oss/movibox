package com.transsion.postdetail.layer.local;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.tn.lib.view.SecondariesSeekBar;
import com.transsion.baselib.helper.LocalVideoPlayerConfigMmkv;
import com.transsion.postdetail.layer.listener.LayerFlag;
import com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment;
import com.transsion.postdetail.ui.view.ImmSpeedView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.m0;

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
public final class c0 extends BaseLocalVideoLayer {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final Fragment f55235c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public tv.a0 f55236d0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(Fragment fragment) {
        super(fragment);
        Intrinsics.g(fragment, "fragment");
        this.f55235c0 = fragment;
    }

    private final void Q2() {
        E(LayerFlag.LOCAL_UI_CHANGED, LocalUiType.MIDDLE);
    }

    public static final void R2(c0 this$0) {
        Intrinsics.g(this$0, "this$0");
        uo.b.a aVar = uo.b.f78622a;
        String TAG = this$0.X0();
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "portrait onBackPressed", false, 4, null);
        this$0.Q2();
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View A0() {
        tv.a0 a0Var = this.f55236d0;
        if (a0Var != null) {
            return a0Var.f77680r;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView A2() {
        tv.a0 a0Var = this.f55236d0;
        if (a0Var != null) {
            return a0Var.f77679q;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public void B1() {
        Q2();
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public Group B2() {
        tv.a0 a0Var = this.f55236d0;
        if (a0Var != null) {
            return a0Var.f77687y;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public LocalUiType C2() {
        return LocalUiType.PORTRAIT;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public void E1() {
        E(LayerFlag.LOCAL_UI_CHANGED, LocalUiType.MIDDLE);
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView J2() {
        tv.a0 a0Var = this.f55236d0;
        if (a0Var != null) {
            return a0Var.C;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ImageView L1() {
        tv.a0 a0Var = this.f55236d0;
        if (a0Var != null) {
            return a0Var.f77688z;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public FrameLayout L2() {
        tv.a0 a0Var = this.f55236d0;
        if (a0Var != null) {
            return a0Var.E;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ViewGroup M1() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView M2() {
        tv.a0 a0Var = this.f55236d0;
        if (a0Var != null) {
            return a0Var.D;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView N1() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ViewStub N2() {
        tv.a0 a0Var = this.f55236d0;
        if (a0Var != null) {
            return a0Var.F;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View O1() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ViewStub O2() {
        tv.a0 a0Var = this.f55236d0;
        if (a0Var != null) {
            return a0Var.G;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View Q1() {
        tv.a0 a0Var = this.f55236d0;
        if (a0Var != null) {
            return a0Var.f77676n;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ConstraintLayout T1() {
        tv.a0 a0Var = this.f55236d0;
        if (a0Var != null) {
            return a0Var.f77672j;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View U0() {
        tv.a0 a0Var = this.f55236d0;
        if (a0Var != null) {
            return a0Var.f77677o;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View V1() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public SecondariesSeekBar W1() {
        tv.a0 a0Var = this.f55236d0;
        if (a0Var != null) {
            return a0Var.A;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, wv.d
    public void a(LocalUiType uiType) {
        Intrinsics.g(uiType, "uiType");
        LocalUiType localUiType = LocalUiType.PORTRAIT;
        if (uiType == localUiType) {
            m0();
        }
        A1(uiType == localUiType);
        super.a(uiType);
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View b1() {
        tv.a0 a0Var = this.f55236d0;
        if (a0Var != null) {
            return a0Var.f77669g;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View c1() {
        tv.a0 a0Var = this.f55236d0;
        if (a0Var != null) {
            return a0Var.f77668f;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, wv.d
    public void m(LocalUiType newConfig) {
        Intrinsics.g(newConfig, "newConfig");
        super.m(newConfig);
        if (newConfig == LocalUiType.LAND) {
            E1();
        }
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View n0() {
        tv.a0 a0Var = this.f55236d0;
        if (a0Var != null) {
            return a0Var.f77684v;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, wv.d
    public void o(float f11) {
        ImmSpeedView immSpeedView;
        super.o(f11);
        tv.a0 a0Var = this.f55236d0;
        if (a0Var == null || (immSpeedView = a0Var.f77675m) == null) {
            return;
        }
        ImmSpeedView.updateSpeed$default(immSpeedView, f11, false, 2, null);
    }

    @Override // wv.d
    public void onBackPressed() {
        ConstraintLayout constraintLayout;
        tv.a0 a0Var = this.f55236d0;
        if (a0Var == null || (constraintLayout = a0Var.f77672j) == null) {
            return;
        }
        constraintLayout.postDelayed(new Runnable() { // from class: com.transsion.postdetail.layer.local.b0
            @Override // java.lang.Runnable
            public final void run() {
                c0.R2(this.f55233a);
            }
        }, 30L);
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, wv.d
    public void p(String resourceId, String subjectId, String postId, boolean z11, boolean z12) {
        String strF;
        ImmSpeedView immSpeedView;
        Intrinsics.g(resourceId, "resourceId");
        Intrinsics.g(subjectId, "subjectId");
        Intrinsics.g(postId, "postId");
        super.p(resourceId, subjectId, postId, z11, z12);
        Fragment fragment = this.f55235c0;
        Intrinsics.e(fragment, "null cannot be cast to non-null type com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment");
        com.transsion.baselib.report.h logViewConfig = ((LocalVideoDetailFragment) fragment).getLogViewConfig();
        if (logViewConfig == null || (strF = logViewConfig.f()) == null) {
            strF = "";
        }
        tv.a0 a0Var = this.f55236d0;
        if (a0Var == null || (immSpeedView = a0Var.f77675m) == null) {
            return;
        }
        immSpeedView.setPageParams(strF, subjectId);
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public boolean p0() {
        return false;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ViewGroup p2() {
        tv.a0 a0Var = this.f55236d0;
        if (a0Var != null) {
            return a0Var.f77665b;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ViewGroup q0() {
        tv.a0 a0Var = this.f55236d0;
        if (a0Var != null) {
            return a0Var.f77685w;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ImageView q2() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, wv.d
    @SuppressLint({"ClickableViewAccessibility"})
    public void r(View rootView, LocalUiType uiType) {
        String strF;
        ImmSpeedView immSpeedView;
        ConstraintLayout root;
        Intrinsics.g(rootView, "rootView");
        Intrinsics.g(uiType, "uiType");
        if (uiType != LocalUiType.PORTRAIT) {
            return;
        }
        tv.a0 a0VarA = tv.a0.a(rootView);
        this.f55236d0 = a0VarA;
        ViewGroup.LayoutParams layoutParams = (a0VarA == null || (root = a0VarA.getRoot()) == null) ? null : root.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).topMargin = com.blankj.utilcode.util.d.c();
        super.r(rootView, uiType);
        Fragment fragment = this.f55235c0;
        Intrinsics.e(fragment, "null cannot be cast to non-null type com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment");
        com.transsion.baselib.report.h logViewConfig = ((LocalVideoDetailFragment) fragment).getLogViewConfig();
        if (logViewConfig == null || (strF = logViewConfig.f()) == null) {
            strF = "";
        }
        tv.a0 a0Var = this.f55236d0;
        if (a0Var == null || (immSpeedView = a0Var.f77675m) == null) {
            return;
        }
        immSpeedView.setPageParams(strF, V0());
        ImmSpeedView.updateSpeed$default(immSpeedView, LocalVideoPlayerConfigMmkv.f51172a.c(), false, 2, null);
        immSpeedView.setPortrait(true);
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ViewGroup r0() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ProgressBar r2() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View s0() {
        m0 m0Var;
        tv.a0 a0Var = this.f55236d0;
        if (a0Var == null || (m0Var = a0Var.f77683u) == null) {
            return null;
        }
        return m0Var.f77860d;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView s2() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView t0() {
        m0 m0Var;
        tv.a0 a0Var = this.f55236d0;
        if (a0Var == null || (m0Var = a0Var.f77683u) == null) {
            return null;
        }
        return m0Var.f77859c;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView t2() {
        tv.a0 a0Var = this.f55236d0;
        if (a0Var != null) {
            return a0Var.f77674l;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView u0() {
        m0 m0Var;
        tv.a0 a0Var = this.f55236d0;
        if (a0Var == null || (m0Var = a0Var.f77683u) == null) {
            return null;
        }
        return m0Var.f77858b;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public SimpleSubtitleView u2() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView v0() {
        tv.a0 a0Var = this.f55236d0;
        if (a0Var != null) {
            return a0Var.f77686x;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public SimpleSubtitleView v2() {
        tv.a0 a0Var = this.f55236d0;
        if (a0Var != null) {
            return a0Var.f77681s;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ViewGroup w2() {
        tv.a0 a0Var = this.f55236d0;
        if (a0Var != null) {
            return a0Var.f77665b;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View x1() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public SimpleSubtitleView x2() {
        tv.a0 a0Var = this.f55236d0;
        if (a0Var != null) {
            return a0Var.f77682t;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView y2() {
        tv.a0 a0Var = this.f55236d0;
        if (a0Var != null) {
            return a0Var.B;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ImageView z0() {
        tv.a0 a0Var = this.f55236d0;
        if (a0Var != null) {
            return a0Var.f77667d;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView z2() {
        tv.a0 a0Var = this.f55236d0;
        if (a0Var != null) {
            return a0Var.f77678p;
        }
        return null;
    }
}
