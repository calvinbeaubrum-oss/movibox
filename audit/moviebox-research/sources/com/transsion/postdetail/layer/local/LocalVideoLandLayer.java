package com.transsion.postdetail.layer.local;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.tn.lib.view.SecondariesSeekBar;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.SubtitleBean;
import com.transsion.baselib.helper.LocalVideoPlayerConfigMmkv;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.R$drawable;
import com.transsion.baseui.R$string;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.player.MediaSource;
import com.transsion.player.longvideo.ui.LongVodPlayerView;
import com.transsion.player.longvideo.ui.dialog.PlayerSettingDialog;
import com.transsion.player.p006enum.ScaleMode;
import com.transsion.postdetail.layer.SystemTimeManager;
import com.transsion.postdetail.layer.listener.LayerFlag;
import com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment;
import com.transsion.postdetail.ui.view.ImmScaleView;
import com.transsion.postdetail.ui.view.ImmSpeedView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
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
public final class LocalVideoLandLayer extends BaseLocalVideoLayer {
    public int A0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final Fragment f55187c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public tv.w f55188d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f55189e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f55190f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final int f55191g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final int f55192h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final int f55193i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f55194j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f55195k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public int f55196l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f55197m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f55198n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public float f55199o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f55200p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f55201q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public float f55202r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public boolean f55203s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public boolean f55204t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public boolean f55205u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public View f55206v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public long f55207w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public final Lazy f55208x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public LocalVideoLandForwardViewControl f55209y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public int f55210z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalVideoLandLayer(Fragment fragment) {
        super(fragment);
        Intrinsics.g(fragment, "fragment");
        this.f55187c0 = fragment;
        this.f55191g0 = com.blankj.utilcode.util.f0.a(24.0f);
        this.f55192h0 = com.blankj.utilcode.util.f0.a(16.0f);
        this.f55193i0 = com.blankj.utilcode.util.f0.a(20.0f);
        this.f55202r0 = 1.0f;
        this.f55205u0 = true;
        this.f55208x0 = LazyKt__LazyJVMKt.b(new Function0<Boolean>() { // from class: com.transsion.postdetail.layer.local.LocalVideoLandLayer$pkStyle$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                ConfigBean configBeanC = ConfigManager.c(ConfigManager.f53111c.a(), LongVodPlayerView.PK_NEW_PLAYER_UI_KEY, false, 2, null);
                String value = configBeanC != null ? configBeanC.getValue() : null;
                return Boolean.valueOf(value == null || value.length() == 0);
            }
        });
        this.f55210z0 = -1;
    }

    public static /* synthetic */ void b3(LocalVideoLandLayer localVideoLandLayer, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z12 = true;
        }
        localVideoLandLayer.a3(z11, z12);
    }

    private final boolean d3() {
        return ((Boolean) this.f55208x0.getValue()).booleanValue();
    }

    public static final void j3(LocalVideoLandLayer this$0, String pageName, LocalVideoDetailFragment localVideoDetailFragment, View it) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(pageName, "$pageName");
        Intrinsics.g(localVideoDetailFragment, "$localVideoDetailFragment");
        it.setSelected(!it.isSelected());
        if (it.isSelected()) {
            this$0.f1(true);
            Intrinsics.f(it, "it");
            so.c.k(it);
            Context context = it.getContext();
            Intrinsics.e(context, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) context).setRequestedOrientation(11);
        } else {
            Context context2 = it.getContext();
            Intrinsics.e(context2, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) context2).setRequestedOrientation(6);
            this$0.d2(true);
        }
        com.transsion.baselib.report.m mVar = com.transsion.baselib.report.m.f51277a;
        Pair[] pairArr = new Pair[3];
        pairArr[0] = new Pair("module_name", "lock");
        pairArr[1] = new Pair("subject_id", this$0.V0());
        pairArr[2] = new Pair("type", it.isSelected() ? "1" : "0");
        mVar.m(pageName, "click", kotlin.collections.s.l(pairArr));
        localVideoDetailFragment.k3(it.isSelected());
        this$0.G0().l(!it.isSelected());
        if (this$0.d3()) {
            tv.w wVar = this$0.f55188d0;
            AppCompatTextView appCompatTextView = wVar != null ? wVar.f77988i : null;
            if (appCompatTextView == null) {
                return;
            }
            appCompatTextView.setText(it.isSelected() ? this$0.f55187c0.getString(R$string.play_tap_unlock) : this$0.f55187c0.getString(R$string.play_tap_lock));
        }
    }

    public static final void k3(LocalVideoLandLayer this$0, View view) {
        ImmScaleView immScaleView;
        Intrinsics.g(this$0, "this$0");
        tv.w wVar = this$0.f55188d0;
        if (wVar == null || (immScaleView = wVar.f77989j) == null) {
            return;
        }
        immScaleView.performClick();
    }

    public static final void l3(LocalVideoLandLayer this$0, ScaleMode scaleMode, String name) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(scaleMode, "scaleMode");
        Intrinsics.g(name, "name");
        com.transsion.player.orplayer.f fVarG = this$0.G();
        if (fVarG != null) {
            fVarG.setScaleMode(scaleMode);
        }
        tv.w wVar = this$0.f55188d0;
        TextView textView = wVar != null ? wVar.f78002w : null;
        if (textView != null) {
            textView.setText(name);
        }
        BaseLocalVideoLayer.e2(this$0, false, 1, null);
        uo.b.a aVar = uo.b.f78622a;
        String TAG = this$0.X0();
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "scaleMode:" + scaleMode, false, 4, null);
    }

    public static final void m3(LocalVideoLandLayer this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        com.transsion.baselib.report.m.f51277a.m(this$0.P0(), "click", this$0.e3(ToolBar.FORWARD));
        this$0.f1(false);
        this$0.a3(true, false);
    }

    public static final void n3(LocalVideoLandLayer this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        com.transsion.baselib.report.m.f51277a.m(this$0.P0(), "click", this$0.e3(ToolBar.BACKWARD));
        this$0.f1(false);
        this$0.a3(false, false);
    }

    public static final void o3(String pageName, LocalVideoLandLayer this$0, View view) {
        Intrinsics.g(pageName, "$pageName");
        Intrinsics.g(this$0, "this$0");
        iv.c.f67718a.a(pageName, this$0.V0(), true);
        BaseLocalVideoLayer.K1(this$0, null, false, 3, null);
    }

    public static final void p3(LocalVideoLandLayer this$0, String pageName, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(pageName, "$pageName");
        new PlayerSettingDialog().k0(this$0.f55187c0, "PlayerSettingDialog");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        DownloadBean downloadBeanC0 = this$0.C0();
        linkedHashMap.put("subject_id", downloadBeanC0 != null ? downloadBeanC0.getSubjectId() : null);
        DownloadBean downloadBeanC1 = this$0.C0();
        linkedHashMap.put("subject_ops", downloadBeanC1 != null ? downloadBeanC1.getOps() : null);
        DownloadBean downloadBeanC2 = this$0.C0();
        linkedHashMap.put("subject_name", downloadBeanC2 != null ? downloadBeanC2.getSubjectName() : null);
        DownloadBean downloadBeanC3 = this$0.C0();
        linkedHashMap.put("title_name", downloadBeanC3 != null ? downloadBeanC3.getTitleName() : null);
        DownloadBean downloadBeanC4 = this$0.C0();
        linkedHashMap.put("subject_type", downloadBeanC4 != null ? Integer.valueOf(downloadBeanC4.getSubjectType()).toString() : null);
        linkedHashMap.put("module_name", "video_setting");
        com.transsion.baselib.report.m.f51277a.m(pageName, "click", linkedHashMap);
    }

    public static final void r3(LocalVideoLandLayer this$0) {
        Intrinsics.g(this$0, "this$0");
        uo.b.a aVar = uo.b.f78622a;
        String TAG = this$0.X0();
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "land onBackPressed", false, 4, null);
        this$0.X2();
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View A0() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            return wVar.D;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView A2() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            return wVar.C;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public void B1() {
        X2();
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public Group B2() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            return wVar.M;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, wv.d
    public void C(int i11) {
        super.C(i11);
        h3(i11);
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public void C1(boolean z11) {
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public LocalUiType C2() {
        return LocalUiType.LAND;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void E1() {
        B1();
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public void F1() {
        super.F1();
        this.f55204t0 = false;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public void G1(View view) {
        Intrinsics.g(view, "view");
        super.G1(view);
        View view2 = this.f55206v0;
        if (view2 != null) {
            so.c.g(view2);
        }
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView J2() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            return wVar.Q;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public void K2() {
        super.K2();
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ImageView L1() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            return wVar.N;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public FrameLayout L2() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            return wVar.S;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View M0() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            return wVar.f77988i;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ViewGroup M1() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView M2() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            return wVar.R;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView N1() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ViewStub N2() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            return wVar.V;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View O1() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            return wVar.f78001v;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ViewStub O2() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            return wVar.W;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View Q1() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            return wVar.f78004y;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ConstraintLayout T1() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            return wVar.f77992m;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View U0() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            return wVar.f78005z;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View V1() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public SecondariesSeekBar W1() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            return wVar.O;
        }
        return null;
    }

    public final void X2() {
        FragmentActivity activity = this.f55187c0.getActivity();
        if (activity != null) {
            ImmersionBar.with(activity).hideBar(BarHide.FLAG_SHOW_BAR).init();
            activity.setRequestedOrientation(7);
        }
        E(LayerFlag.LOCAL_UI_CHANGED, LocalUiType.MIDDLE);
    }

    public final void Y2() {
        DownloadBean downloadBeanC0 = C0();
        List<SubtitleBean> subtitleList = downloadBeanC0 != null ? downloadBeanC0.getSubtitleList() : null;
        if ((subtitleList == null || subtitleList.isEmpty()) && this.f55205u0) {
            RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
            if (roomAppMMKV.a().getBoolean("subtitle_is_search_downloaded", false)) {
                this.f55205u0 = false;
                roomAppMMKV.a().putBoolean("subtitle_land_guide", false);
            } else {
                this.f55205u0 = false;
                roomAppMMKV.a().putBoolean("subtitle_land_guide", false);
                d2(false);
            }
        }
    }

    public final void Z2(int i11, int i12) {
        if ((i11 <= 0 || a1() == i11) && (i12 <= 0 || I0() == i12)) {
            return;
        }
        c2(i11);
        Z1(i12);
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, wv.d
    public void a(LocalUiType uiType) {
        WindowManager windowManager;
        Display defaultDisplay;
        m0 m0Var;
        LinearLayout root;
        Intrinsics.g(uiType, "uiType");
        LocalUiType localUiType = LocalUiType.LAND;
        if (uiType == localUiType) {
            this.f55203s0 = true;
            com.transsion.player.orplayer.f fVarG = G();
            int videoWidth = fVarG != null ? fVarG.getVideoWidth() : 0;
            com.transsion.player.orplayer.f fVarG2 = G();
            Z2(videoWidth, fVarG2 != null ? fVarG2.getVideoHeight() : 0);
            uo.b.a aVar = uo.b.f78622a;
            String TAG = X0();
            Intrinsics.f(TAG, "TAG");
            uo.b.a.f(aVar, TAG, "onLocalUiChanged 2 land", false, 4, null);
            FragmentActivity activity = this.f55187c0.getActivity();
            if (activity != null) {
                ImmersionBar.with(activity).hideBar(BarHide.FLAG_HIDE_BAR).init();
            }
            m0();
            f1(false);
            SystemTimeManager systemTimeManagerW0 = W0();
            if (systemTimeManagerW0 != null) {
                systemTimeManagerW0.d();
            }
            tv.w wVar = this.f55188d0;
            if (wVar != null && (m0Var = wVar.I) != null && (root = m0Var.getRoot()) != null) {
                so.c.g(root);
            }
            Y2();
            FragmentActivity activity2 = this.f55187c0.getActivity();
            if (activity2 != null && (windowManager = activity2.getWindowManager()) != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
                C(defaultDisplay.getRotation());
            }
        } else if (this.f55204t0) {
            x0();
        }
        uo.b.f78622a.c("long_video_play", "land, onLocalUiChanged uiType = " + uiType, true);
        A1(uiType == localUiType);
        super.a(uiType);
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public void a2(boolean z11) {
        fs.d dVar;
        AppCompatImageView appCompatImageView;
        super.a2(z11);
        tv.w wVar = this.f55188d0;
        if (wVar == null || (dVar = wVar.f77982b) == null || (appCompatImageView = dVar.f65266d) == null) {
            return;
        }
        appCompatImageView.setImageResource(z11 ? R$drawable.ic_player_pause : R$drawable.ic_player_play);
    }

    public final void a3(boolean z11, boolean z12) {
        LocalVideoLandForwardViewControl localVideoLandForwardViewControlC3;
        if (z12 && (localVideoLandForwardViewControlC3 = c3()) != null) {
            localVideoLandForwardViewControlC3.b(z11);
        }
        long jH = z11 ? kotlin.ranges.a.h(this.f55207w0 + ((long) 10000), Y0()) : kotlin.ranges.a.e(this.f55207w0 - ((long) 10000), 0L);
        this.f55207w0 = jH;
        com.transsion.player.orplayer.f fVarG = G();
        if (fVarG != null) {
            fVarG.seekTo(jH);
        }
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View b1() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            return wVar.f77994o;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, wv.d
    public void c() {
        super.c();
        this.f55203s0 = false;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View c1() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            return wVar.f77993n;
        }
        return null;
    }

    public final LocalVideoLandForwardViewControl c3() {
        tv.w wVar;
        ViewStub viewStub;
        View viewInflate;
        if (this.f55209y0 == null && (wVar = this.f55188d0) != null && (viewStub = wVar.T) != null && (viewInflate = viewStub.inflate()) != null) {
            tv.x xVarA = tv.x.a(viewInflate);
            Intrinsics.f(xVarA, "bind(it)");
            this.f55209y0 = new LocalVideoLandForwardViewControl(xVarA);
        }
        return this.f55209y0;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public void d1(MotionEvent motionEvent, boolean z11) {
        if (!z11 || motionEvent == null) {
            super.d1(motionEvent, false);
            return;
        }
        int iE = com.blankj.utilcode.util.d0.e() / 3;
        int rawX = (int) motionEvent.getRawX();
        if (rawX >= 0 && rawX <= iE) {
            b3(this, false, false, 2, null);
        } else if (rawX > iE * 2) {
            b3(this, true, false, 2, null);
        } else {
            super.d1(motionEvent, false);
        }
    }

    public final Map<String, String> e3(String str) {
        return kotlin.collections.s.k(new Pair("module_name", str), new Pair("subject_id", V0()), new Pair("resource_id", T0()));
    }

    public final void f3() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            if (!d3()) {
                wVar.f77988i.setText((CharSequence) null);
                TextView textView = wVar.f78002w;
                Intrinsics.f(textView, "viewBinding.tvPlayScale");
                so.c.g(textView);
                wVar.f78000u.setText((CharSequence) null);
            }
            ImmSpeedView immSpeedView = wVar.f78003x;
            Intrinsics.f(immSpeedView, "viewBinding.tvPlaySpeed");
            ImmSpeedView.updateSpeed$default(immSpeedView, LocalVideoPlayerConfigMmkv.f51172a.c(), false, 2, null);
        }
    }

    public final void g3() {
        this.f55202r0 = 0.7222222f;
        int i11 = this.f55189e0;
        int i12 = (int) (i11 * 0.7222222f);
        this.f55195k0 = i12;
        this.f55194j0 = (i11 - i12) / 2;
        int i13 = this.f55191g0;
        int i14 = i12 + (i13 * 2);
        this.f55198n0 = i14;
        int i15 = (int) (((i14 * 9) * 1.0f) / 16);
        this.f55197m0 = i15;
        int i16 = this.f55190f0;
        int i17 = (int) (i16 * 0.7222222f);
        this.f55196l0 = i17;
        int i18 = (((i16 - i17) - (i13 / 3)) - i15) / 2;
        this.f55201q0 = i18;
        this.f55200p0 = (i13 / 3) + i15 + i18;
        this.f55199o0 = (((i16 - i17) * 1.0f) / 2) - i18;
        uo.b.a aVar = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "initAdHW ,playerStartSpace = " + this.f55201q0 + ", playerEndSpace = " + this.f55200p0, false, 4, null);
    }

    public final void h3(int i11) {
        View view;
        View view2;
        Log.e(X0(), "initSpace rotation:" + i11);
        if (this.f55210z0 == i11) {
            return;
        }
        this.f55210z0 = i11;
        if (this.A0 == 0) {
            this.A0 = com.blankj.utilcode.util.d.c();
        }
        tv.w wVar = this.f55188d0;
        ViewGroup.LayoutParams layoutParams = (wVar == null || (view2 = wVar.F) == null) ? null : view2.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ConstraintLayout.b(-2, -2);
        }
        layoutParams.width = i11 == 1 ? this.A0 : 0;
        tv.w wVar2 = this.f55188d0;
        View view3 = wVar2 != null ? wVar2.F : null;
        if (view3 != null) {
            view3.setLayoutParams(layoutParams);
        }
        tv.w wVar3 = this.f55188d0;
        ViewGroup.LayoutParams layoutParams2 = (wVar3 == null || (view = wVar3.E) == null) ? null : view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new ConstraintLayout.b(-2, -2);
        }
        layoutParams2.width = i11 == 3 ? this.A0 : 0;
        tv.w wVar4 = this.f55188d0;
        View view4 = wVar4 != null ? wVar4.E : null;
        if (view4 == null) {
            return;
        }
        view4.setLayoutParams(layoutParams2);
    }

    public final void i3(String str, boolean z11) {
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, com.transsion.player.orplayer.e
    public void initPlayer() {
        super.initPlayer();
        this.f55204t0 = false;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, wv.d
    public void k(DownloadBean downloadBean, String pageFrom, boolean z11) {
        String url;
        String path;
        Intrinsics.g(pageFrom, "pageFrom");
        super.k(downloadBean, pageFrom, z11);
        if (downloadBean == null || (url = downloadBean.getResourceId()) == null) {
            url = downloadBean != null ? downloadBean.getUrl() : "";
        }
        i3(url, downloadBean != null ? downloadBean.isSeries() : false);
        if (downloadBean == null || downloadBean.getType() != 6 || (path = downloadBean.getPath()) == null || !StringsKt__StringsKt.Q(path, ".mp3", false, 2, null)) {
            return;
        }
        Y1(downloadBean.getCover());
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public void l2(boolean z11) {
        fs.d dVar;
        super.l2(z11);
        tv.w wVar = this.f55188d0;
        AppCompatImageView appCompatImageView = (wVar == null || (dVar = wVar.f77982b) == null) ? null : dVar.f65266d;
        if (appCompatImageView == null) {
            return;
        }
        View viewS0 = s0();
        appCompatImageView.setVisibility((viewS0 == null || viewS0.getVisibility() != 0) ? 0 : 4);
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, wv.d
    public void m(LocalUiType newConfig) {
        Intrinsics.g(newConfig, "newConfig");
        super.m(newConfig);
        if (newConfig == LocalUiType.MIDDLE) {
            X2();
        }
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View n0() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            return wVar.L;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, wv.d
    public void o(float f11) {
        ImmSpeedView immSpeedView;
        super.o(f11);
        tv.w wVar = this.f55188d0;
        if (wVar == null || (immSpeedView = wVar.f78003x) == null) {
            return;
        }
        ImmSpeedView.updateSpeed$default(immSpeedView, f11, false, 2, null);
    }

    @Override // wv.d
    public void onBackPressed() {
        ConstraintLayout constraintLayout;
        tv.w wVar = this.f55188d0;
        if (wVar == null || (constraintLayout = wVar.f77992m) == null) {
            return;
        }
        constraintLayout.postDelayed(new Runnable() { // from class: com.transsion.postdetail.layer.local.q
            @Override // java.lang.Runnable
            public final void run() {
                LocalVideoLandLayer.r3(this.f55292a);
            }
        }, 30L);
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, com.transsion.player.orplayer.e
    public void onCompletion(MediaSource mediaSource) {
        super.onCompletion(mediaSource);
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, com.transsion.player.orplayer.e
    public void onProgress(long j11, MediaSource mediaSource) {
        super.onProgress(j11, mediaSource);
        if (isVisible()) {
            this.f55207w0 = j11;
        }
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, com.transsion.player.orplayer.e
    public void onVideoPause(MediaSource mediaSource) {
        super.onVideoPause(mediaSource);
        isVisible();
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i11, int i12) {
        Z2(i11, i12);
        super.onVideoSizeChanged(i11, i12);
        uo.b.a aVar = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        aVar.c(TAG, "onVideoSizeChanged, width = " + i11 + ", height = " + i12, true);
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, com.transsion.player.orplayer.e
    public void onVideoStart(MediaSource mediaSource) {
        super.onVideoStart(mediaSource);
        isVisible();
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, wv.d
    public void p(String resourceId, String subjectId, String postId, boolean z11, boolean z12) {
        String strF;
        ImmScaleView immScaleView;
        ImmSpeedView immSpeedView;
        Intrinsics.g(resourceId, "resourceId");
        Intrinsics.g(subjectId, "subjectId");
        Intrinsics.g(postId, "postId");
        super.p(resourceId, subjectId, postId, z11, z12);
        b2(subjectId);
        Fragment fragment = this.f55187c0;
        Intrinsics.e(fragment, "null cannot be cast to non-null type com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment");
        com.transsion.baselib.report.h logViewConfig = ((LocalVideoDetailFragment) fragment).getLogViewConfig();
        if (logViewConfig == null || (strF = logViewConfig.f()) == null) {
            strF = "";
        }
        tv.w wVar = this.f55188d0;
        if (wVar != null && (immSpeedView = wVar.f78003x) != null) {
            immSpeedView.setPageParams(strF, subjectId);
        }
        tv.w wVar2 = this.f55188d0;
        if (wVar2 != null && (immScaleView = wVar2.f77989j) != null) {
            immScaleView.setPageParams(strF, subjectId);
        }
        i3(resourceId, z12);
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public boolean p0() {
        return false;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ViewGroup p2() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            return wVar.f77984d;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, wv.d
    public void q(int i11, int i12) {
        super.q(i11, i12);
        uo.b.a aVar = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "addSurface, width = " + i11 + ", height = " + i12, false, 4, null);
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ViewGroup q0() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            return wVar.J;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ImageView q2() {
        return null;
    }

    public final void q3() {
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, wv.d
    @SuppressLint({"ClickableViewAccessibility"})
    public void r(View rootView, LocalUiType uiType) {
        final String strF;
        AppCompatTextView appCompatTextView;
        fs.d dVar;
        LinearLayout linearLayout;
        AppCompatTextView appCompatTextView2;
        ImmScaleView immScaleView;
        ImmSpeedView immSpeedView;
        Intrinsics.g(rootView, "rootView");
        Intrinsics.g(uiType, "uiType");
        if (uiType != LocalUiType.LAND) {
            return;
        }
        this.f55188d0 = tv.w.a(rootView);
        super.r(rootView, uiType);
        this.f55189e0 = com.blankj.utilcode.util.d0.c();
        int iE = com.blankj.utilcode.util.d0.e();
        this.f55190f0 = iE;
        int i11 = this.f55189e0;
        if (iE < i11) {
            this.f55190f0 = i11;
            this.f55189e0 = iE;
        }
        int iA = com.blankj.utilcode.util.d.a();
        if (iA > 10) {
            this.f55190f0 -= iA;
        }
        Fragment fragment = this.f55187c0;
        Intrinsics.e(fragment, "null cannot be cast to non-null type com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment");
        final LocalVideoDetailFragment localVideoDetailFragment = (LocalVideoDetailFragment) fragment;
        com.transsion.baselib.report.h logViewConfig = localVideoDetailFragment.getLogViewConfig();
        if (logViewConfig == null || (strF = logViewConfig.f()) == null) {
            strF = "";
        }
        tv.w wVar = this.f55188d0;
        if (wVar != null && (immSpeedView = wVar.f78003x) != null) {
            immSpeedView.setPageParams(strF, V0());
        }
        tv.w wVar2 = this.f55188d0;
        if (wVar2 != null && (immScaleView = wVar2.f77989j) != null) {
            immScaleView.setPageParams(strF, V0());
        }
        tv.w wVar3 = this.f55188d0;
        if (wVar3 != null && (appCompatTextView2 = wVar3.f77988i) != null) {
            appCompatTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LocalVideoLandLayer.j3(this.f55293a, strF, localVideoDetailFragment, view);
                }
            });
        }
        this.f55205u0 = RoomAppMMKV.f51271a.a().getBoolean("subtitle_land_guide", true);
        g3();
        q3();
        tv.w wVar4 = this.f55188d0;
        if (wVar4 != null && (linearLayout = wVar4.f77997r) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LocalVideoLandLayer.k3(this.f55296a, view);
                }
            });
        }
        tv.w wVar5 = this.f55188d0;
        ImmScaleView immScaleView2 = wVar5 != null ? wVar5.f77989j : null;
        if (immScaleView2 != null) {
            immScaleView2.setOnModelChangeListener(new ImmScaleView.a() { // from class: com.transsion.postdetail.layer.local.t
                @Override // com.transsion.postdetail.ui.view.ImmScaleView.a
                public final void a(ScaleMode scaleMode, String str) {
                    LocalVideoLandLayer.l3(this.f55297a, scaleMode, str);
                }
            });
        }
        tv.w wVar6 = this.f55188d0;
        if (wVar6 != null && (dVar = wVar6.f77982b) != null) {
            dVar.f65267f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LocalVideoLandLayer.m3(this.f55298a, view);
                }
            });
            dVar.f65265c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LocalVideoLandLayer.n3(this.f55299a, view);
                }
            });
            dVar.f65266d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LocalVideoLandLayer.o3(strF, this, view);
                }
            });
        }
        tv.w wVar7 = this.f55188d0;
        if (wVar7 != null && (appCompatTextView = wVar7.A) != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LocalVideoLandLayer.p3(this.f55302a, strF, view);
                }
            });
        }
        f3();
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ViewGroup r0() {
        fs.d dVar;
        tv.w wVar = this.f55188d0;
        if (wVar == null || (dVar = wVar.f77982b) == null) {
            return null;
        }
        return dVar.getRoot();
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ProgressBar r2() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View s0() {
        fs.d dVar;
        tv.w wVar = this.f55188d0;
        if (wVar == null || (dVar = wVar.f77982b) == null) {
            return null;
        }
        return dVar.f65268g;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView s2() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView t0() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView t2() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            return wVar.f78000u;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView u0() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public boolean u1() {
        return this.f55204t0;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public SimpleSubtitleView u2() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView v0() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            return wVar.K;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public SimpleSubtitleView v2() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            return wVar.G;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ViewGroup w2() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            return wVar.f77984d;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View x1() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public SimpleSubtitleView x2() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            return wVar.H;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView y2() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            return wVar.P;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ImageView z0() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            return wVar.f77987h;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView z2() {
        tv.w wVar = this.f55188d0;
        if (wVar != null) {
            return wVar.B;
        }
        return null;
    }
}
