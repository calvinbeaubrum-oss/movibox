package com.transsion.postdetail.layer.local;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.hisavana.common.bean.TAdErrorCode;
import com.tn.lib.view.SecondariesSeekBar;
import com.tn.lib.widget.R$mipmap;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.R$string;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.play.detail.PlayDetailBottomRecHelper;
import com.transsion.player.MediaSource;
import com.transsion.player.p006enum.ScaleMode;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.ui.fragment.LocalVideoMiddleSeriesListFragment;
import com.transsion.postdetail.ui.view.LocalVideoMiddleHeaderView;
import com.transsion.publish.view.PublishStateView;
import com.transsion.videofloat.bean.FloatActionType;
import com.transsnet.downloader.manager.DownloadEsHelper;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import net.lucode.hackware.magicindicator.MagicIndicator;

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
@SourceDebugExtension
public final class LocalVideoMiddleLayer extends BaseLocalVideoLayer {

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final a f55214m0 = new a(null);

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final Fragment f55215c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public tv.y f55216d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public LocalVideoMiddleForwardViewControl f55217e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public long f55218f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public LocalVideoMiddleSeriesListFragment f55219g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public PlayDetailBottomRecHelper f55220h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public boolean f55221i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f55222j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public com.transsion.ad.bidding.interstitial.a f55223k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final b f55224l0;

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
    public static final class b extends jq.a {
        public b() {
        }

        public static final void o(LocalVideoMiddleLayer this$0) {
            Intrinsics.g(this$0, "this$0");
            LocalVideoMiddleLayer.f3(this$0, false, 1, null);
        }

        @Override // jq.a
        public void g(TAdErrorCode tAdErrorCode) {
            super.g(tAdErrorCode);
            LocalVideoMiddleLayer.f3(LocalVideoMiddleLayer.this, false, 1, null);
        }

        @Override // jq.a
        public void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            com.transsion.ad.bidding.interstitial.a aVar;
            super.h(biddingIntermediateMaterialBean);
            FragmentActivity activity = LocalVideoMiddleLayer.this.Z2().getActivity();
            if (activity == null || (aVar = LocalVideoMiddleLayer.this.f55223k0) == null) {
                return;
            }
            aVar.n0(activity);
        }

        @Override // jq.a
        public void j(int i11) {
            ConstraintLayout root;
            super.j(i11);
            RoomAppMMKV.f51271a.a().putLong("show_LocalVideoBackInterstitialV2Scene_timestamp", System.currentTimeMillis());
            com.transsion.ad.bidding.interstitial.a aVar = LocalVideoMiddleLayer.this.f55223k0;
            if (aVar != null) {
                aVar.F();
            }
            tv.y yVar = LocalVideoMiddleLayer.this.f55216d0;
            if (yVar == null || (root = yVar.getRoot()) == null) {
                return;
            }
            final LocalVideoMiddleLayer localVideoMiddleLayer = LocalVideoMiddleLayer.this;
            root.postDelayed(new Runnable() { // from class: com.transsion.postdetail.layer.local.a0
                @Override // java.lang.Runnable
                public final void run() {
                    LocalVideoMiddleLayer.b.o(localVideoMiddleLayer);
                }
            }, 200L);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements androidx.lifecycle.f {
        public c() {
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onCreate(androidx.lifecycle.u uVar) {
            androidx.lifecycle.e.a(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public void onDestroy(androidx.lifecycle.u owner) {
            LocalVideoMiddleHeaderView localVideoMiddleHeaderView;
            Intrinsics.g(owner, "owner");
            androidx.lifecycle.e.b(this, owner);
            com.transsion.ad.bidding.interstitial.a aVar = LocalVideoMiddleLayer.this.f55223k0;
            if (aVar != null) {
                aVar.F();
            }
            tv.y yVar = LocalVideoMiddleLayer.this.f55216d0;
            if (yVar == null || (localVideoMiddleHeaderView = yVar.f78032v) == null) {
                return;
            }
            localVideoMiddleHeaderView.destroy();
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onPause(androidx.lifecycle.u uVar) {
            androidx.lifecycle.e.c(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onResume(androidx.lifecycle.u uVar) {
            androidx.lifecycle.e.d(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onStart(androidx.lifecycle.u uVar) {
            androidx.lifecycle.e.e(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onStop(androidx.lifecycle.u uVar) {
            androidx.lifecycle.e.f(this, uVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalVideoMiddleLayer(Fragment fragment) {
        super(fragment);
        Intrinsics.g(fragment, "fragment");
        this.f55215c0 = fragment;
        this.f55224l0 = new b();
    }

    private final void X2(boolean z11, boolean z12) {
        LocalVideoMiddleForwardViewControl localVideoMiddleForwardViewControlA3;
        if (z12 && (localVideoMiddleForwardViewControlA3 = a3()) != null) {
            localVideoMiddleForwardViewControlA3.b(z11);
        }
        long jH = z11 ? kotlin.ranges.a.h(this.f55218f0 + ((long) 10000), Y0()) : kotlin.ranges.a.e(this.f55218f0 - ((long) 10000), 0L);
        this.f55218f0 = jH;
        com.transsion.player.orplayer.f fVarG = G();
        if (fVarG != null) {
            fVarG.seekTo(jH);
        }
    }

    public static /* synthetic */ void Y2(LocalVideoMiddleLayer localVideoMiddleLayer, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z12 = true;
        }
        localVideoMiddleLayer.X2(z11, z12);
    }

    public static final void c3(LocalVideoMiddleLayer this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (view.isSelected()) {
            view.setSelected(false);
            this$0.i3(false);
            DownloadBean downloadBeanC0 = this$0.C0();
            if (downloadBeanC0 != null) {
                this$0.D0().F(downloadBeanC0);
                return;
            }
            return;
        }
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            com.tn.lib.widget.toast.core.h.f50034a.k(R$string.base_network_fail);
            return;
        }
        view.setSelected(true);
        this$0.i3(true);
        DownloadBean downloadBeanC1 = this$0.C0();
        if (downloadBeanC1 != null) {
            this$0.D0().j(downloadBeanC1);
        }
    }

    public static /* synthetic */ void f3(LocalVideoMiddleLayer localVideoMiddleLayer, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        localVideoMiddleLayer.e3(z11);
    }

    private final void g3() {
        com.transsion.ad.bidding.interstitial.a.f50342m.a("LocalVideoBackInterstitialV2Scene");
    }

    private final void j3() {
        tv.y yVar;
        PublishStateView publishStateView;
        DownloadBean downloadBeanC0 = C0();
        if (downloadBeanC0 == null || (yVar = this.f55216d0) == null || (publishStateView = yVar.f78023m) == null) {
            return;
        }
        String groupId = downloadBeanC0.getGroupId();
        String str = groupId == null ? "" : groupId;
        String cover = downloadBeanC0.getCover();
        String str2 = cover == null ? "" : cover;
        String name = downloadBeanC0.getName();
        publishStateView.publishSource(4, (30 & 2) != 0 ? "" : null, (30 & 4) != 0 ? "" : null, (30 & 8) != 0 ? "" : null, (30 & 16) != 0 ? "" : null, (30 & 32) != 0 ? "" : str, (30 & 64) != 0 ? "" : name == null ? "" : name, (30 & 128) == 0 ? str2 : "", (30 & 256) != 0 ? false : true);
    }

    public static final void l3(LocalVideoMiddleLayer this$0) {
        Intrinsics.g(this$0, "this$0");
        f3(this$0, false, 1, null);
    }

    private final void n3() {
        kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this.f55215c0), null, null, new LocalVideoMiddleLayer$showInterstitialAd$1(this, null), 3, null);
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View A0() {
        tv.y yVar = this.f55216d0;
        if (yVar != null) {
            return yVar.G;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView A2() {
        tv.y yVar = this.f55216d0;
        if (yVar != null) {
            return yVar.F;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public void B1() {
        k3("onBackClick");
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public Group B2() {
        tv.y yVar = this.f55216d0;
        if (yVar != null) {
            return yVar.M;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public LocalUiType C2() {
        return LocalUiType.MIDDLE;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, wv.d
    public void D(DownloadBean bean) {
        tv.y yVar;
        TextView textView;
        tv.y yVar2;
        FrameLayout frameLayout;
        Intrinsics.g(bean, "bean");
        super.D(bean);
        int status = bean.getStatus();
        if (status != 1 && status != 2 && status != 3) {
            if (status != 5) {
                return;
            }
            uo.b.a aVar = uo.b.f78622a;
            String TAG = X0();
            Intrinsics.f(TAG, "TAG");
            String resourceId = bean.getResourceId();
            DownloadBean downloadBeanC0 = C0();
            uo.b.a.s(aVar, TAG, "onDownloadCallback, success  resourceId = " + resourceId + ", cur resourceId = " + (downloadBeanC0 != null ? downloadBeanC0.getResourceId() : null), false, 4, null);
            String resourceId2 = bean.getResourceId();
            DownloadBean downloadBeanC1 = C0();
            if (!Intrinsics.b(resourceId2, downloadBeanC1 != null ? downloadBeanC1.getResourceId() : null) || (yVar2 = this.f55216d0) == null || (frameLayout = yVar2.f78016f) == null) {
                return;
            }
            so.c.g(frameLayout);
            return;
        }
        if (!this.f55222j0) {
            DownloadBean downloadBeanC2 = C0();
            if (Intrinsics.b(downloadBeanC2 != null ? downloadBeanC2.getSubjectId() : null, bean.getSubjectId())) {
                uo.b.a aVar2 = uo.b.f78622a;
                String TAG2 = X0();
                Intrinsics.f(TAG2, "TAG");
                uo.b.a.s(aVar2, TAG2, "onDownloadCallback, refresh  epse = " + bean.getEpse(), false, 4, null);
                this.f55222j0 = true;
                Z0().g(C0());
            }
        }
        String resourceId3 = bean.getResourceId();
        DownloadBean downloadBeanC3 = C0();
        if (!Intrinsics.b(resourceId3, downloadBeanC3 != null ? downloadBeanC3.getResourceId() : null) || (yVar = this.f55216d0) == null || (textView = yVar.f78035y) == null || textView.isSelected()) {
            return;
        }
        tv.y yVar3 = this.f55216d0;
        TextView textView2 = yVar3 != null ? yVar3.f78035y : null;
        if (textView2 != null) {
            textView2.setSelected(true);
        }
        i3(true);
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView J2() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ImageView L1() {
        tv.y yVar = this.f55216d0;
        if (yVar != null) {
            return yVar.N;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public FrameLayout L2() {
        tv.y yVar = this.f55216d0;
        if (yVar != null) {
            return yVar.S;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ViewGroup M1() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView M2() {
        tv.y yVar = this.f55216d0;
        if (yVar != null) {
            return yVar.R;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView N1() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ViewStub N2() {
        tv.y yVar = this.f55216d0;
        if (yVar != null) {
            return yVar.U;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View O1() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ViewStub O2() {
        tv.y yVar = this.f55216d0;
        if (yVar != null) {
            return yVar.V;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View Q1() {
        tv.y yVar = this.f55216d0;
        if (yVar != null) {
            return yVar.C;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ConstraintLayout T1() {
        tv.y yVar = this.f55216d0;
        if (yVar != null) {
            return yVar.f78029s;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View U0() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View V1() {
        tv.y yVar = this.f55216d0;
        if (yVar != null) {
            return yVar.O;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public SecondariesSeekBar W1() {
        tv.y yVar = this.f55216d0;
        if (yVar != null) {
            return yVar.P;
        }
        return null;
    }

    public final Fragment Z2() {
        return this.f55215c0;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, wv.d
    public void a(LocalUiType uiType) {
        Window window;
        Intrinsics.g(uiType, "uiType");
        PlayDetailBottomRecHelper playDetailBottomRecHelper = this.f55220h0;
        if (playDetailBottomRecHelper != null) {
            playDetailBottomRecHelper.u(uiType != LocalUiType.MIDDLE);
        }
        LocalUiType localUiType = LocalUiType.MIDDLE;
        if (uiType == localUiType) {
            uo.b.a aVar = uo.b.f78622a;
            String TAG = X0();
            Intrinsics.f(TAG, "TAG");
            uo.b.a.f(aVar, TAG, "onLocalUiChanged 2 middle", false, 4, null);
            com.transsion.player.orplayer.f fVarG = G();
            if (fVarG != null) {
                fVarG.setScaleMode(ScaleMode.SCALE_ASPECT_FIT);
            }
            FragmentActivity activity = this.f55215c0.getActivity();
            if (activity != null && (window = activity.getWindow()) != null) {
                WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(window, window.getDecorView());
                Intrinsics.f(insetsController, "getInsetsController(it, it.decorView)");
                insetsController.show(WindowInsetsCompat.Type.navigationBars());
            }
            m0();
        }
        uo.b.f78622a.c("long_video_play", "middle, onLocalUiChanged uiType = " + uiType, true);
        A1(uiType == localUiType);
        super.a(uiType);
    }

    public final LocalVideoMiddleForwardViewControl a3() {
        tv.y yVar;
        ViewStub viewStub;
        View viewInflate;
        if (this.f55217e0 == null && (yVar = this.f55216d0) != null && (viewStub = yVar.T) != null && (viewInflate = viewStub.inflate()) != null) {
            tv.x xVarA = tv.x.a(viewInflate);
            Intrinsics.f(xVarA, "bind(it)");
            this.f55217e0 = new LocalVideoMiddleForwardViewControl(xVarA);
        }
        return this.f55217e0;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View b1() {
        tv.y yVar = this.f55216d0;
        if (yVar != null) {
            return yVar.f78025o;
        }
        return null;
    }

    public final void b3() {
        TextView textView;
        tv.y yVar = this.f55216d0;
        if (yVar == null || (textView = yVar.f78035y) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LocalVideoMiddleLayer.c3(this.f55304a, view);
            }
        });
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, wv.d
    public void c() {
        super.c();
        e3(false);
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View c1() {
        tv.y yVar = this.f55216d0;
        if (yVar != null) {
            return yVar.f78024n;
        }
        return null;
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
            Y2(this, false, false, 2, null);
        } else if (rawX > iE * 2) {
            Y2(this, true, false, 2, null);
        } else {
            super.d1(motionEvent, false);
        }
    }

    public final void d3() {
        Fragment fragmentFindFragmentByTag = this.f55215c0.getChildFragmentManager().findFragmentByTag("LocalVideoMiddleSeriesList");
        if (fragmentFindFragmentByTag instanceof LocalVideoMiddleSeriesListFragment) {
            ((LocalVideoMiddleSeriesListFragment) fragmentFindFragmentByTag).t0(true);
        }
    }

    public final void e3(boolean z11) {
        LocalVideoMiddleHeaderView localVideoMiddleHeaderView;
        FragmentActivity activity;
        try {
            Result.Companion companion = Result.Companion;
            this.f55215c0.getLifecycle().a(new c());
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (z11) {
            if (f(FloatActionType.BACK) || (activity = this.f55215c0.getActivity()) == null) {
                return;
            }
            activity.finish();
            return;
        }
        tv.y yVar = this.f55216d0;
        if (yVar == null || (localVideoMiddleHeaderView = yVar.f78032v) == null) {
            return;
        }
        localVideoMiddleHeaderView.destroy();
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, wv.d
    public void g(boolean z11, String requestKey) {
        Intrinsics.g(requestKey, "requestKey");
    }

    public final void h3(DownloadBean downloadBean) {
        if (downloadBean == null) {
            return;
        }
        DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean.getUrl();
        }
        DownloadBean downloadBeanL = downloadEsHelperA.l(resourceId);
        if (downloadBeanL != null) {
            downloadBean = downloadBeanL;
        }
        X1(downloadBean, true);
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, wv.d
    public void i(String subjectId, String resourceId) {
        Intrinsics.g(subjectId, "subjectId");
        Intrinsics.g(resourceId, "resourceId");
        super.i(subjectId, resourceId);
        uo.b.a aVar = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        uo.b.a.s(aVar, TAG, "initSeries", false, 4, null);
        Z0().g(C0());
    }

    public final void i3(boolean z11) {
        TextView textView;
        if (z11) {
            tv.y yVar = this.f55216d0;
            TextView textView2 = yVar != null ? yVar.f78036z : null;
            if (textView2 != null) {
                textView2.setText(this.f55215c0.getString(com.transsion.postdetail.R$string.download_playing_downloading_tips));
            }
            tv.y yVar2 = this.f55216d0;
            textView = yVar2 != null ? yVar2.f78035y : null;
            if (textView == null) {
                return;
            }
            textView.setText(this.f55215c0.getString(com.transsion.postdetail.R$string.download_playing_pause));
            return;
        }
        tv.y yVar3 = this.f55216d0;
        TextView textView3 = yVar3 != null ? yVar3.f78036z : null;
        if (textView3 != null) {
            textView3.setText(this.f55215c0.getString(com.transsion.postdetail.R$string.download_playing_pause_tips));
        }
        tv.y yVar4 = this.f55216d0;
        textView = yVar4 != null ? yVar4.f78035y : null;
        if (textView == null) {
            return;
        }
        textView.setText(this.f55215c0.getString(com.transsion.postdetail.R$string.download_playing_resume));
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, wv.d
    public boolean isVisible() {
        ConstraintLayout constraintLayout;
        tv.y yVar = this.f55216d0;
        return (yVar == null || (constraintLayout = yVar.f78029s) == null || constraintLayout.getVisibility() != 0) ? false : true;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, wv.d
    public void k(DownloadBean downloadBean, String pageFrom, boolean z11) {
        FrameLayout frameLayout;
        tv.y yVar;
        LocalVideoMiddleHeaderView localVideoMiddleHeaderView;
        LocalVideoMiddleHeaderView localVideoMiddleHeaderView2;
        String path;
        FrameLayout frameLayout2;
        Intrinsics.g(pageFrom, "pageFrom");
        super.k(downloadBean, pageFrom, z11);
        if ((downloadBean == null || downloadBean.getStatus() != 5) && downloadBean != null && downloadBean.isInnerRes()) {
            tv.y yVar2 = this.f55216d0;
            if (yVar2 != null && (frameLayout = yVar2.f78016f) != null) {
                so.c.k(frameLayout);
            }
            boolean z12 = D0().z(downloadBean);
            tv.y yVar3 = this.f55216d0;
            TextView textView = yVar3 != null ? yVar3.f78035y : null;
            if (textView != null) {
                textView.setSelected(z12);
            }
            i3(z12);
        } else {
            tv.y yVar4 = this.f55216d0;
            if (yVar4 != null && (frameLayout2 = yVar4.f78016f) != null) {
                so.c.g(frameLayout2);
            }
        }
        if (downloadBean != null && downloadBean.getType() == 6 && (path = downloadBean.getPath()) != null && StringsKt__StringsKt.Q(path, ".mp3", false, 2, null)) {
            Y1(downloadBean.getCover());
        }
        j3();
        tv.y yVar5 = this.f55216d0;
        if (yVar5 != null && (localVideoMiddleHeaderView2 = yVar5.f78032v) != null) {
            localVideoMiddleHeaderView2.updateDownloadBean(downloadBean);
        }
        Z0().c(downloadBean != null ? downloadBean.getSubjectId() : null);
        if (!z11 || (yVar = this.f55216d0) == null || (localVideoMiddleHeaderView = yVar.f78032v) == null) {
            return;
        }
        localVideoMiddleHeaderView.init(downloadBean, yVar != null ? yVar.f78030t : null);
        localVideoMiddleHeaderView.setItemClickCallback(new Function1<DownloadBean, Unit>() { // from class: com.transsion.postdetail.layer.local.LocalVideoMiddleLayer$updateInfo$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DownloadBean downloadBean2) {
                invoke2(downloadBean2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadBean downloadBean2) {
                this.this$0.h3(downloadBean2);
            }
        });
        localVideoMiddleHeaderView.setAllListClickCallback(new Function0<Unit>() { // from class: com.transsion.postdetail.layer.local.LocalVideoMiddleLayer$updateInfo$1$2
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
                this.this$0.o3();
            }
        });
    }

    public final void k3(String str) {
        ConstraintLayout root;
        com.transsion.ad.a aVar = com.transsion.ad.a.f50276a;
        com.transsion.ad.a.h(aVar, "LocalVideoMiddleLayer --> showAd(from = " + str + ")", false, 2, null);
        int iC = wq.a.f79581a.c("LocalVideoBackInterstitialV2Scene");
        long j11 = RoomAppMMKV.f51271a.a().getLong("show_LocalVideoBackInterstitialV2Scene_timestamp", 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - j11 >= 60000 * iC) {
            n3();
            return;
        }
        com.transsion.ad.a.h(aVar, "LocalVideoMiddleLayer --> 间隔时间还没有到 --> interval = " + iC + " --> timestamp = " + j11 + " --> currentTimeMillis = " + jCurrentTimeMillis, false, 2, null);
        tv.y yVar = this.f55216d0;
        if (yVar == null || (root = yVar.getRoot()) == null) {
            return;
        }
        root.postDelayed(new Runnable() { // from class: com.transsion.postdetail.layer.local.z
            @Override // java.lang.Runnable
            public final void run() {
                LocalVideoMiddleLayer.l3(this.f55305a);
            }
        }, 200L);
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, wv.d
    public void m(LocalUiType newConfig) {
        Intrinsics.g(newConfig, "newConfig");
        super.m(newConfig);
        if (newConfig == LocalUiType.LAND) {
            E1();
        }
    }

    public final void m3(boolean z11) {
        tv.y yVar = this.f55216d0;
        FrameLayout frameLayout = yVar != null ? yVar.f78015d : null;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(z11 ? 0 : 8);
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View n0() {
        tv.y yVar = this.f55216d0;
        if (yVar != null) {
            return yVar.L;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public void o0(Subject subject) {
        super.o0(subject);
        if (this.f55221i0) {
            return;
        }
        this.f55221i0 = true;
        if (subject != null) {
            kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new LocalVideoMiddleLayer$bindMovieDetail$1(this, subject, null), 3, null);
        }
        if (subject == null) {
            subject = gv.a.a(C0());
        }
        uo.b.a aVar = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        DownloadBean downloadBeanC0 = C0();
        uo.b.a.f(aVar, TAG, "bindMovieDetail, isInnerVideo:" + (downloadBeanC0 != null ? Boolean.valueOf(downloadBeanC0.isInnerSubjectRes()) : null), false, 4, null);
        Fragment fragment = this.f55215c0;
        tv.y yVar = this.f55216d0;
        MagicIndicator magicIndicator = yVar != null ? yVar.f78028r : null;
        ViewPager2 viewPager2 = yVar != null ? yVar.f78031u : null;
        String str = "local_video_detail";
        boolean z11 = true;
        DownloadBean downloadBeanC1 = C0();
        this.f55220h0 = new PlayDetailBottomRecHelper(fragment, subject, magicIndicator, viewPager2, str, z11, !(downloadBeanC1 != null ? downloadBeanC1.isInnerSubjectRes() : true), null, 128, null);
        Fragment fragment2 = this.f55215c0;
        int i11 = R$id.subjectDetailLayout;
        DownloadBean downloadBeanC2 = C0();
        new com.transsion.play.detail.b(fragment2, i11, subject, "local_video_detail", "download_subject", true, !(downloadBeanC2 != null ? downloadBeanC2.isInnerSubjectRes() : true));
        m3(false);
    }

    public final void o3() {
        LocalVideoMiddleSeriesListFragment localVideoMiddleSeriesListFragmentA = LocalVideoMiddleSeriesListFragment.f55711j.a();
        localVideoMiddleSeriesListFragmentA.x0(C0(), P0());
        localVideoMiddleSeriesListFragmentA.y0(new Function2<DownloadBean, Integer, Unit>() { // from class: com.transsion.postdetail.layer.local.LocalVideoMiddleLayer$showSeriesList$1$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(DownloadBean downloadBean, Integer num) {
                invoke(downloadBean, num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(DownloadBean bean, int i11) {
                Intrinsics.g(bean, "bean");
                this.this$0.h3(bean);
            }
        });
        localVideoMiddleSeriesListFragmentA.z0(this.f55215c0, R$id.fl_series_list_container);
        this.f55219g0 = localVideoMiddleSeriesListFragmentA;
    }

    @Override // wv.d
    public void onBackPressed() {
        uo.b.a aVar = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "middle onBackPressed", false, 4, null);
        LocalVideoMiddleSeriesListFragment localVideoMiddleSeriesListFragment = this.f55219g0;
        if (localVideoMiddleSeriesListFragment == null || localVideoMiddleSeriesListFragment.s0()) {
            k3("onBackPressed");
            return;
        }
        LocalVideoMiddleSeriesListFragment localVideoMiddleSeriesListFragment2 = this.f55219g0;
        if (localVideoMiddleSeriesListFragment2 != null) {
            LocalVideoMiddleSeriesListFragment.u0(localVideoMiddleSeriesListFragment2, false, 1, null);
        }
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, com.transsion.player.orplayer.e
    public void onProgress(long j11, MediaSource mediaSource) {
        super.onProgress(j11, mediaSource);
        if (isVisible()) {
            this.f55218f0 = j11;
            LocalVideoLandAdControl.C.a().v(j11, Y0());
        }
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public boolean p0() {
        return false;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ViewGroup p2() {
        tv.y yVar = this.f55216d0;
        if (yVar != null) {
            return yVar.f78017g;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ViewGroup q0() {
        tv.y yVar = this.f55216d0;
        if (yVar != null) {
            return yVar.J;
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
        PublishStateView publishStateView;
        View view;
        Intrinsics.g(rootView, "rootView");
        Intrinsics.g(uiType, "uiType");
        if (uiType != LocalUiType.MIDDLE) {
            return;
        }
        this.f55216d0 = tv.y.a(rootView);
        super.r(rootView, uiType);
        tv.y yVar = this.f55216d0;
        ViewGroup.LayoutParams layoutParams = (yVar == null || (view = yVar.f78020j) == null) ? null : view.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) layoutParams)).topMargin = com.blankj.utilcode.util.d.c();
        m3(true);
        b3();
        d3();
        g3();
        tv.y yVar2 = this.f55216d0;
        if (yVar2 != null && (publishStateView = yVar2.f78023m) != null) {
            publishStateView.setImageResource(R$mipmap.libui_ic_base_whit_publish);
        }
        D2(false);
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
        tv.y yVar = this.f55216d0;
        if (yVar != null) {
            return yVar.Q;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView s2() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView t0() {
        tv.y yVar = this.f55216d0;
        if (yVar != null) {
            return yVar.D;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView t2() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, wv.d
    public void u(String subjectId, String resourceId) {
        LocalVideoMiddleHeaderView localVideoMiddleHeaderView;
        DownloadBean downloadBean;
        Intrinsics.g(subjectId, "subjectId");
        Intrinsics.g(resourceId, "resourceId");
        tv.y yVar = this.f55216d0;
        if (yVar == null || (localVideoMiddleHeaderView = yVar.f78032v) == null || (downloadBean = localVideoMiddleHeaderView.getDownloadBean(resourceId)) == null) {
            return;
        }
        X1(downloadBean, true);
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView u0() {
        tv.y yVar = this.f55216d0;
        if (yVar != null) {
            return yVar.B;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public SimpleSubtitleView u2() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer, wv.d
    public void v(boolean z11) {
        super.v(z11);
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView v0() {
        tv.y yVar = this.f55216d0;
        if (yVar != null) {
            return yVar.K;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public SimpleSubtitleView v2() {
        tv.y yVar = this.f55216d0;
        if (yVar != null) {
            return yVar.H;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ViewGroup w2() {
        tv.y yVar = this.f55216d0;
        if (yVar != null) {
            return yVar.f78019i;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public View x1() {
        tv.y yVar = this.f55216d0;
        if (yVar != null) {
            return yVar.f78022l;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public SimpleSubtitleView x2() {
        tv.y yVar = this.f55216d0;
        if (yVar != null) {
            return yVar.I;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView y2() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public ImageView z0() {
        tv.y yVar = this.f55216d0;
        if (yVar != null) {
            return yVar.f78021k;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.BaseLocalVideoLayer
    public TextView z2() {
        tv.y yVar = this.f55216d0;
        if (yVar != null) {
            return yVar.E;
        }
        return null;
    }
}
