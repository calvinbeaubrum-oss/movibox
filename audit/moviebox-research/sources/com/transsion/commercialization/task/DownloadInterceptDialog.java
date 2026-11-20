package com.transsion.commercialization.task;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.RotateAnimation;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.f0;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hisavana.common.bean.TAdNativeInfo;
import com.tn.lib.widget.R$string;
import com.tn.lib.widget.R$style;
import com.transsion.ad.middle.WrapperAdListener;
import com.transsion.ad.middle.icon.WrapperIconAdManager;
import com.transsion.ad.middle.icon.WrapperIconBean;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.baseui.util.m;
import com.transsion.commercialization.R$layout;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberSource;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class DownloadInterceptDialog extends BaseDialog {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final a f51736y = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WrapperIconAdManager f51737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<WrapperIconBean> f51738d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public os.e f51739f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super Integer, Unit> f51740g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f51741h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h f51742i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f51743j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f51744k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f51745l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f51746m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f51747n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f51748o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f51749p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f51750q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f51751r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f51752s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public com.transsion.ad.bidding.video.f f51753t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public com.transsion.ad.bidding.interstitial.a f51754u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f51755v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final WrapperAdListener f51756w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final DownloadInterceptDialog$rewardInterceptListener$1 f51757x;

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
    public static final class b extends RecyclerView.l {
        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.x state) {
            Intrinsics.g(outRect, "outRect");
            Intrinsics.g(view, "view");
            Intrinsics.g(parent, "parent");
            Intrinsics.g(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = parent.getAdapter();
            if (adapter != null) {
                if (adapter.getItemCount() == 1) {
                    outRect.top = f0.a(8.0f);
                    return;
                }
                if (childAdapterPosition == 0) {
                    outRect.top = f0.a(8.0f);
                    outRect.bottom = f0.a(12.0f);
                } else if (childAdapterPosition == adapter.getItemCount() - 1) {
                    outRect.bottom = f0.a(4.0f);
                } else {
                    outRect.bottom = f0.a(12.0f);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements su.b {
        public c() {
        }

        @Override // su.b
        public void a() {
            com.transsion.commercialization.pslink.a.f51724a.a(DownloadInterceptDialog.this.g0() + " --> startMemberPage() --> onFailed() --> 开通会员失败");
        }

        @Override // su.b
        public void onSuccess() {
            com.transsion.commercialization.pslink.a.f51724a.a(DownloadInterceptDialog.this.g0() + " --> startMemberPage() --> onSuccess() --> 开通会员成功，直接下载不需要做任务了");
            DownloadInterceptDialog.this.f51741h = 2;
            DownloadInterceptDialog.this.dismissAllowingStateLoss();
        }
    }

    public DownloadInterceptDialog() {
        super(R$layout.dialog_download_intercept_v2_layout);
        this.f51737c = new WrapperIconAdManager();
        this.f51738d = new ArrayList();
        this.f51741h = 1;
        this.f51745l = LazyKt__LazyJVMKt.b(new Function0<Integer>() { // from class: com.transsion.commercialization.task.DownloadInterceptDialog$iconFetchCount$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(this.this$0.Z0());
            }
        });
        this.f51747n = true;
        this.f51749p = LazyKt__LazyJVMKt.b(new Function0<Integer>() { // from class: com.transsion.commercialization.task.DownloadInterceptDialog$maxShowErrorTimes$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(this.this$0.c1());
            }
        });
        this.f51750q = LazyKt__LazyJVMKt.b(new Function0<Boolean>() { // from class: com.transsion.commercialization.task.DownloadInterceptDialog$isRewardedOff$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(wq.c.f79583a.d("DownloadInterceptRewarded").length() > 0);
            }
        });
        this.f51751r = LazyKt__LazyJVMKt.b(new Function0<Boolean>() { // from class: com.transsion.commercialization.task.DownloadInterceptDialog$isRewardInterstitialOff$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(wq.c.f79583a.d("DownloadInterceptInterstitial").length() > 0);
            }
        });
        this.f51752s = "";
        this.f51756w = new WrapperAdListener() { // from class: com.transsion.commercialization.task.DownloadInterceptDialog$listener$1
            @Override // com.transsion.ad.middle.WrapperAdListener, com.hisavana.common.interfacz.TAdListener
            public void onClicked(int i11) {
                com.transsion.ad.a.B(com.transsion.ad.a.f50276a, this.this$0.g0() + " --> onClicked() --> 点击广告", false, 2, null);
                this.this$0.k1();
            }

            @Override // com.transsion.ad.middle.WrapperAdListener
            public void onWrapperIconReady(List<WrapperIconBean> list) {
                super.onWrapperIconReady(list);
                this.this$0.f51738d.clear();
                if (list != null && (!list.isEmpty())) {
                    this.this$0.f51738d.addAll(list);
                }
                com.transsion.ad.a.B(com.transsion.ad.a.f50276a, this.this$0.g0() + " --> onWrapperIconReady() --> 获取到数据 : " + this.this$0.f51738d + "--> 展示数据", false, 2, null);
                this.this$0.v1();
            }
        };
        this.f51757x = new DownloadInterceptDialog$rewardInterceptListener$1(this);
    }

    private final void V0() {
        AppCompatImageView appCompatImageView;
        os.e eVar = this.f51739f;
        if (eVar == null || (appCompatImageView = eVar.f73392h) == null) {
            return;
        }
        appCompatImageView.clearAnimation();
    }

    private final void d1() {
        RecyclerView recyclerView;
        os.e eVar = this.f51739f;
        if (eVar == null || (recyclerView = eVar.f73396l) == null) {
            return;
        }
        h hVar = new h(this.f51737c);
        this.f51742i = hVar;
        recyclerView.setAdapter(hVar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new b());
    }

    private final void e1(View view) {
        os.f fVar;
        Window window;
        Window window2;
        Dialog dialog = getDialog();
        if (dialog != null && (window2 = dialog.getWindow()) != null) {
            window2.setLayout(-1, -2);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null && (window = dialog2.getWindow()) != null) {
            window.setGravity(17);
        }
        Dialog dialog3 = getDialog();
        if (dialog3 != null) {
            dialog3.setCancelable(false);
        }
        this.f51739f = os.e.a(view);
        ConstraintLayout constraintLayout = null;
        if (!((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).e1() || this.f51744k) {
            os.e eVar = this.f51739f;
            ConstraintLayout constraintLayout2 = eVar != null ? eVar.f73388c : null;
            if (constraintLayout2 != null) {
                constraintLayout2.setVisibility(8);
            }
            os.e eVar2 = this.f51739f;
            LinearLayoutCompat linearLayoutCompat = eVar2 != null ? eVar2.f73394j : null;
            if (linearLayoutCompat != null) {
                linearLayoutCompat.setVisibility(8);
            }
        }
        os.e eVar3 = this.f51739f;
        if (eVar3 != null && (fVar = eVar3.f73395k) != null) {
            constraintLayout = fVar.f73404c;
        }
        if (constraintLayout == null) {
            return;
        }
        constraintLayout.setVisibility(g1() ? 8 : 0);
    }

    private final void h1() {
        this.f51743j = true;
        A1();
        com.transsion.ad.a.B(com.transsion.ad.a.f50276a, g0() + " --> loadDefaultData() --> 开始加载数据", false, 2, null);
        kotlinx.coroutines.j.d(v.a(this), null, null, new DownloadInterceptDialog$loadData$1(this, null), 3, null);
    }

    private final void i1() {
        Context context;
        if (f1() || (context = getContext()) == null) {
            return;
        }
        this.f51752s = "DownloadInterceptInterstitial";
        kotlinx.coroutines.j.d(v.a(this), null, null, new DownloadInterceptDialog$loadInterstitialAd$1$1(this, context, null), 3, null);
    }

    private final void p1() {
        os.f fVar;
        ConstraintLayout constraintLayout;
        ConstraintLayout constraintLayout2;
        AppCompatImageView appCompatImageView;
        os.e eVar = this.f51739f;
        if (eVar != null && (appCompatImageView = eVar.f73389d) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.commercialization.task.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadInterceptDialog.q1(this.f51772a, view);
                }
            });
        }
        os.e eVar2 = this.f51739f;
        if (eVar2 != null && (constraintLayout2 = eVar2.f73388c) != null) {
            constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.commercialization.task.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadInterceptDialog.r1(this.f51773a, view);
                }
            });
        }
        m mVar = m.f51477a;
        View[] viewArr = new View[2];
        os.e eVar3 = this.f51739f;
        viewArr[0] = eVar3 != null ? eVar3.f73401q : null;
        viewArr[1] = eVar3 != null ? eVar3.f73392h : null;
        mVar.a(viewArr, new View.OnClickListener() { // from class: com.transsion.commercialization.task.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadInterceptDialog.s1(this.f51774a, view);
            }
        });
        os.e eVar4 = this.f51739f;
        if (eVar4 == null || (fVar = eVar4.f73395k) == null || (constraintLayout = fVar.f73404c) == null) {
            return;
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.commercialization.task.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadInterceptDialog.t1(this.f51775a, view);
            }
        });
    }

    public static final void q1(DownloadInterceptDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    public static final void r1(DownloadInterceptDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        com.transsion.commercialization.pslink.f.f51726a.d();
        Object objH = com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class);
        Intrinsics.f(objH, "getInstance().navigation(IMemberApi::class.java)");
        IMemberApi.a.c((IMemberApi) objH, this$0.getActivity(), MemberSource.SOURCE_DOWNLOAD_DIALOG, this$0.new c(), false, 8, null);
    }

    public static final void s1(DownloadInterceptDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.f51743j) {
            return;
        }
        com.transsion.commercialization.pslink.f.f51726a.f();
        if (!this$0.f51738d.isEmpty()) {
            this$0.v1();
        } else {
            this$0.h1();
        }
    }

    public static final void t1(DownloadInterceptDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.x1();
        com.transsion.commercialization.pslink.f.f51726a.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v1() {
        os.f fVar;
        ConstraintLayout constraintLayout;
        Context context;
        ConstraintLayout constraintLayout2;
        if (isDetached() || getActivity() == null) {
            return;
        }
        com.transsion.commercialization.pslink.a aVar = com.transsion.commercialization.pslink.a.f51724a;
        aVar.b(g0() + " --> show() --> 组装数据 .....");
        ArrayList arrayList = new ArrayList();
        if (!this.f51738d.isEmpty()) {
            arrayList.add(this.f51738d.get(0));
            this.f51738d.remove(0);
        }
        if (!arrayList.isEmpty()) {
            n1();
            h hVar = this.f51742i;
            if (hVar != null) {
                hVar.w0(arrayList);
            }
        } else if (this.f51747n) {
            os.e eVar = this.f51739f;
            if (eVar != null && (constraintLayout2 = eVar.f73387b) != null) {
                so.c.g(constraintLayout2);
            }
            if (g1()) {
                Y0();
            }
        } else {
            zp.b.a aVar2 = zp.b.f82110a;
            os.e eVar2 = this.f51739f;
            aVar2.e((eVar2 == null || (fVar = eVar2.f73395k) == null || (constraintLayout = fVar.f73404c) == null || (context = constraintLayout.getContext()) == null) ? null : context.getString(R$string.no_more_ad_tips));
        }
        this.f51747n = false;
        this.f51743j = false;
        V0();
        aVar.b(g0() + " --> show() --> 组装数据 ..... --> excessiveList.size = " + arrayList.size() + " 一次数据加载结束 -- isLoading = false");
    }

    public final void A1() {
        AppCompatImageView appCompatImageView;
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000L);
        rotateAnimation.setRepeatCount(-1);
        os.e eVar = this.f51739f;
        if (eVar == null || (appCompatImageView = eVar.f73392h) == null) {
            return;
        }
        appCompatImageView.startAnimation(rotateAnimation);
    }

    public final void W0() {
        com.transsion.ad.bidding.interstitial.a aVar = this.f51754u;
        if (aVar != null) {
            aVar.F();
        }
        this.f51754u = null;
    }

    public final void X0() {
        com.transsion.ad.bidding.video.f fVar = this.f51753t;
        if (fVar != null) {
            fVar.F();
        }
        this.f51753t = null;
    }

    public final void Y0() {
        this.f51741h = 3;
        dismissAllowingStateLoss();
    }

    public final int Z0() {
        JsonElement jsonElement;
        JsonObject jsonObjectB = wq.d.f79584a.b("DownloadInterceptRewarded");
        if (jsonObjectB == null || (jsonElement = jsonObjectB.get("iconFetchCount")) == null) {
            return 10;
        }
        return jsonElement.getAsInt();
    }

    public final int a1() {
        return ((Number) this.f51745l.getValue()).intValue();
    }

    public final int b1() {
        return ((Number) this.f51749p.getValue()).intValue();
    }

    public final int c1() {
        JsonElement jsonElement;
        JsonObject jsonObjectB = wq.d.f79584a.b("DownloadInterceptRewarded");
        if (jsonObjectB == null || (jsonElement = jsonObjectB.get("maxShowErrorTimes")) == null) {
            return 3;
        }
        return jsonElement.getAsInt();
    }

    public final boolean f1() {
        return ((Boolean) this.f51751r.getValue()).booleanValue();
    }

    public final boolean g1() {
        return ((Boolean) this.f51750q.getValue()).booleanValue();
    }

    public final void j1() {
        Context context;
        if (g1() || (context = getContext()) == null) {
            return;
        }
        this.f51752s = "DownloadInterceptRewarded";
        kotlinx.coroutines.j.d(v.a(this), null, null, new DownloadInterceptDialog$loadRewardedAd$1$1(this, context, null), 3, null);
    }

    public final void k1() {
        com.transsion.ad.a.B(com.transsion.ad.a.f50276a, g0() + " --> onItemClick()", false, 2, null);
        this.f51741h = 2;
        dismissAllowingStateLoss();
        w1();
    }

    public final void l1() {
        if (f1()) {
            return;
        }
        this.f51752s = "DownloadInterceptInterstitial";
        com.transsion.ad.bidding.interstitial.a.f50342m.a("DownloadInterceptInterstitial");
    }

    public final void m1() {
        if (g1()) {
            return;
        }
        this.f51752s = "DownloadInterceptRewarded";
        com.transsion.ad.bidding.video.f.f50385m.a("DownloadInterceptRewarded");
    }

    public final void n1() {
        List<WrapperIconBean> listD;
        TAdNativeInfo nativeInfo;
        h hVar = this.f51742i;
        if (hVar == null || (listD = hVar.D()) == null) {
            return;
        }
        for (WrapperIconBean wrapperIconBean : listD) {
            if (wrapperIconBean.getType() == 2 && (nativeInfo = wrapperIconBean.getNativeInfo()) != null) {
                nativeInfo.release();
            }
        }
    }

    public final DownloadInterceptDialog o1(Function1<? super Integer, Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f51740g = callback;
        return this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.center_DialogStyle);
        com.transsion.commercialization.pslink.a.f51724a.a(g0() + " --> onCreate() --> 下载应用弹窗");
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        n1();
        this.f51737c.destroy();
        com.transsion.commercialization.pslink.a.f51724a.a(g0() + " --> onDestroy() -> " + this.f51746m);
        if (this.f51746m) {
            return;
        }
        X0();
        W0();
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Function1<? super Integer, Unit> function1;
        Intrinsics.g(dialog, "dialog");
        super.onDismiss(dialog);
        com.transsion.commercialization.pslink.a.f51724a.a(g0() + " --> onDismiss() --> " + this.f51746m);
        if (this.f51746m || (function1 = this.f51740g) == null) {
            return;
        }
        function1.invoke(Integer.valueOf(this.f51741h));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        m1();
        com.transsion.commercialization.pslink.f.f51726a.g();
        e1(view);
        d1();
        p1();
        h1();
    }

    public final DownloadInterceptDialog u1(boolean z11) {
        this.f51744k = z11;
        return this;
    }

    public final void w1() {
        if (this.f51744k) {
            return;
        }
        zp.b.f82110a.g(R$layout.download_toast_layout, "+1 download granted", (8 & 4) != 0 ? 0 : 80, (8 & 8) != 0 ? 0 : 0, (8 & 16) != 0 ? 0 : f0.a(66.0f));
    }

    public final void x1() {
        String str = this.f51752s;
        if (Intrinsics.b(str, "DownloadInterceptRewarded")) {
            j1();
        } else if (Intrinsics.b(str, "DownloadInterceptInterstitial")) {
            i1();
        }
    }

    public final void y1() {
        Context context = getContext();
        if (context != null) {
            this.f51752s = "DownloadInterceptInterstitial";
            kotlinx.coroutines.j.d(v.a(this), null, null, new DownloadInterceptDialog$showInterstitialAd$1$1(this, context, null), 3, null);
        }
    }

    public final void z1() {
        Context context = getContext();
        if (context != null) {
            this.f51752s = "DownloadInterceptRewarded";
            kotlinx.coroutines.j.d(v.a(this), null, null, new DownloadInterceptDialog$showRewardedAd$1$1(this, context, null), 3, null);
        }
    }
}
