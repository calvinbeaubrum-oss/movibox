package com.transsion.member;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.u;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.d0;
import androidx.lifecycle.m;
import androidx.lifecycle.v;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.f0;
import com.google.android.material.imageview.ShapeableImageView;
import com.gyf.immersionbar.ImmersionBar;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.baseui.dialog.BaseMemberLoadingDialog;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.baseui.widget.GradientBorderView;
import com.transsion.member.bean.RedeemResult;
import com.transsion.member.dialog.MemberPromoCodeDialog;
import com.transsion.member.widget.PointView;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberDetail;
import com.transsion.memberapi.MemberInfo;
import com.transsion.memberapi.MemberSource;
import com.transsion.memberapi.MemberTaskItem;
import com.transsion.memberapi.MemberTaskItemCheckInInfo;
import com.transsion.memberapi.MemberTaskItemInvite;
import com.transsion.memberapi.MemberTaskRewardInfo;
import com.transsion.memberapi.MemberTaskSubmitCheckInRes;
import com.transsion.memberapi.MembershipDetailType;
import com.transsion.memberapi.PointInfo;
import com.transsion.memberapi.SkuCategory;
import com.transsion.memberapi.SkuData;
import com.transsion.memberapi.SkuItem;
import com.transsion.payment.lib.PaymentManager;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
/* JADX INFO: loaded from: classes.dex */
@Route(path = "/member/MemberFragment")
@Metadata
@SourceDebugExtension
public final class MemberFragment extends PageStatusFragment<qu.i> implements View.OnClickListener, r00.a {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final a f53132y = new a(null);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f53133z = 8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public MemberSource f53134k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public UserInfo f53135l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public MemberDetail f53136m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public b1.b<Intent> f53138o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ou.g f53139p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ou.f f53140q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ou.d f53141r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f53143t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f53144u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f53145v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f53146w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f53147x;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f53137n = LazyKt__LazyJVMKt.b(new Function0<BaseMemberLoadingDialog>() { // from class: com.transsion.member.MemberFragment$mLoadingDialog$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BaseMemberLoadingDialog invoke() {
            return new BaseMemberLoadingDialog();
        }
    });

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f53142s = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.member.MemberFragment$mLoginApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ILoginApi invoke() {
            return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
        }
    });

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MemberFragment a(MemberSource memberSource) {
            MemberFragment memberFragment = new MemberFragment();
            memberFragment.M1(memberSource);
            return memberFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f53148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f53149b;

        static {
            int[] iArr = new int[MembershipDetailType.values().length];
            try {
                iArr[MembershipDetailType.TRIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MembershipDetailType.SUBSCRIPTION_MEMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MembershipDetailType.FINANCIAL_MEMBER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MembershipDetailType.EXPIRED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f53148a = iArr;
            int[] iArr2 = new int[MemberSource.values().length];
            try {
                iArr2[MemberSource.SOURCE_LANDSCAPE_PLAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[MemberSource.SOURCE_HDDL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[MemberSource.SOURCE_AD_DIALOG.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[MemberSource.SOURCE_DOWNLOAD_DIALOG.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[MemberSource.SOURCE_OTHER_DOWNLOAD_DIALOG.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[MemberSource.SOURCE_MULTI_DL.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            f53149b = iArr2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class c implements b1.a<ActivityResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f53150a = new c();

        @Override // b1.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final void a(ActivityResult activityResult) {
            if (activityResult.getResultCode() == -1) {
                uo.b.a.f(uo.b.f78622a, "loginStatus", "登录成功", false, 4, null);
            } else {
                uo.b.a.f(uo.b.f78622a, "loginStatus", "登录失败或者取消", false, 4, null);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class d implements Function0<Unit> {
        public d() {
        }

        public void a() {
            MemberFragment.this.E1();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class e implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f53152a;

        public e(Function1 function) {
            Intrinsics.g(function, "function");
            this.f53152a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f53152a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f53152a.invoke(obj);
        }
    }

    public MemberFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.member.MemberFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        this.f53143t = FragmentViewModelLazyKt.a(this, Reflection.b(MemberViewModel.class), new Function0<x0>() { // from class: com.transsion.member.MemberFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.f(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.member.MemberFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                Object objInvoke = function0.invoke();
                m mVar = objInvoke instanceof m ? (m) objInvoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.f(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.f53144u = true;
    }

    public static final void A1(qu.i this_apply, MemberFragment this$0, View view, int i11, int i12, int i13, int i14) {
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(this$0, "this$0");
        this$0.Q1(Math.abs(i12 * 1.0f) / (this_apply.f74972x.getMeasuredHeight() < 1 ? com.transsion.core.utils.e.a(48.0f) : this_apply.f74972x.getMeasuredHeight()));
    }

    public static final void o1(MemberFragment this$0) {
        NestedScrollView nestedScrollView;
        Intrinsics.g(this$0, "this$0");
        qu.i mViewBinding = this$0.getMViewBinding();
        if (mViewBinding == null || (nestedScrollView = mViewBinding.f74970v) == null) {
            return;
        }
        nestedScrollView.fullScroll(TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ILoginApi s1() {
        Object value = this.f53142s.getValue();
        Intrinsics.f(value, "<get-mLoginApi>(...)");
        return (ILoginApi) value;
    }

    public static final void w1(MemberFragment this$0, View view) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        Intrinsics.g(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null || (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) == null) {
            return;
        }
        onBackPressedDispatcher.l();
    }

    public static final void x1(View view) {
        com.alibaba.android.arouter.launcher.a.d().b("/member/point_history").navigation();
    }

    public static final void y1(View view) {
        com.alibaba.android.arouter.launcher.a.d().b("/member/point_history").navigation();
    }

    public static final void z1(MemberFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        MemberPromoCodeDialog memberPromoCodeDialogA = MemberPromoCodeDialog.f53284g.a(this$0.new d());
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.f(childFragmentManager, "childFragmentManager");
        memberPromoCodeDialogA.show(childFragmentManager, "MemberPromoCodeDialog");
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean A0() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void B0() {
        LinearLayoutCompat linearLayoutCompat;
        super.B0();
        try {
            Result.Companion companion = Result.Companion;
            if (((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).g()) {
                qu.i mViewBinding = getMViewBinding();
                RecyclerView recyclerView = mViewBinding != null ? mViewBinding.f74967s : null;
                if (recyclerView != null) {
                    recyclerView.setVisibility(0);
                }
                qu.i mViewBinding2 = getMViewBinding();
                linearLayoutCompat = mViewBinding2 != null ? mViewBinding2.f74959k : null;
                if (linearLayoutCompat != null) {
                    linearLayoutCompat.setVisibility(0);
                }
            } else {
                qu.i mViewBinding3 = getMViewBinding();
                RecyclerView recyclerView2 = mViewBinding3 != null ? mViewBinding3.f74967s : null;
                if (recyclerView2 != null) {
                    recyclerView2.setVisibility(8);
                }
                qu.i mViewBinding4 = getMViewBinding();
                linearLayoutCompat = mViewBinding4 != null ? mViewBinding4.f74959k : null;
                if (linearLayoutCompat != null) {
                    linearLayoutCompat.setVisibility(8);
                }
            }
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final boolean B1() {
        return this.f53147x;
    }

    public final void C1(boolean z11) {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        AppCompatTextView appCompatTextView4;
        int id2 = 0;
        if (z11) {
            qu.i mViewBinding = getMViewBinding();
            if (mViewBinding == null || (appCompatTextView3 = mViewBinding.f74962n) == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = appCompatTextView3.getLayoutParams();
            Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            bVar.f7315t = -1;
            qu.i mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (appCompatTextView4 = mViewBinding2.f74965q) != null) {
                id2 = appCompatTextView4.getId();
            }
            bVar.f7313s = id2;
            bVar.setMarginStart(f0.a(2.0f));
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = f0.a(18.5f);
            appCompatTextView3.setLayoutParams(bVar);
            return;
        }
        qu.i mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (appCompatTextView = mViewBinding3.f74962n) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = appCompatTextView.getLayoutParams();
        Intrinsics.e(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams2;
        bVar2.f7313s = -1;
        qu.i mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (appCompatTextView2 = mViewBinding4.f74965q) != null) {
            id2 = appCompatTextView2.getId();
        }
        bVar2.f7315t = id2;
        bVar2.setMarginStart(f0.a(0.0f));
        ((ViewGroup.MarginLayoutParams) bVar2).topMargin = f0.a(44.0f);
        appCompatTextView.setLayoutParams(bVar2);
    }

    public final void D1(SkuItem skuItem) {
        O1();
        t1().F(skuItem);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        Object objH = com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class);
        Intrinsics.f(objH, "getInstance().navigation(IMemberApi::class.java)");
        IMemberApi.a.a((IMemberApi) objH, null, 1, null);
    }

    public final void E1() {
        t1().o();
        t1().q();
        ou.g gVar = this.f53139p;
        if (gVar != null) {
            gVar.notifyDataSetChanged();
        }
        n1();
    }

    public final void F1() {
        if (this.f53145v) {
            v1();
            this.f53145v = false;
        }
    }

    public final void G1(List<SkuItem> list) {
        qu.i mViewBinding;
        RecyclerView recyclerView;
        PointInfo pointInfo;
        RecyclerView recyclerView2;
        qu.i mViewBinding2 = getMViewBinding();
        RecyclerView.Adapter adapter = null;
        if ((mViewBinding2 != null ? mViewBinding2.f74966r : null) != null) {
            qu.i mViewBinding3 = getMViewBinding();
            if (mViewBinding3 != null && (recyclerView2 = mViewBinding3.f74966r) != null) {
                adapter = recyclerView2.getAdapter();
            }
            if (adapter == null || (mViewBinding = getMViewBinding()) == null || (recyclerView = mViewBinding.f74966r) == null) {
                return;
            }
            MemberDetail memberDetail = this.f53136m;
            int point = (memberDetail == null || (pointInfo = memberDetail.getPointInfo()) == null) ? 0 : pointInfo.getPoint();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((SkuItem) it.next()).setUserPoints(Integer.valueOf(point));
            }
            if (recyclerView.getAdapter() != null) {
                RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
                Intrinsics.e(adapter2, "null cannot be cast to non-null type com.transsion.member.adapter.RedeemInfoAdapter");
                ((ou.d) adapter2).x0(CollectionsKt___CollectionsKt.M0(list));
            }
        }
    }

    public final void H1(String str, String str2) {
        String strF;
        HashMap map = new HashMap();
        map.put("opt_type", str);
        if (str2 != null) {
            map.put("skuId", str2);
        }
        com.transsion.baselib.report.m mVar = com.transsion.baselib.report.m.f51277a;
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (strF = logViewConfig.f()) == null) {
            strF = "";
        }
        mVar.m(strF, "click", map);
    }

    public final void I1(String str, Integer num, String str2) {
        String strF;
        HashMap map = new HashMap();
        map.put("opt_type", "pay_result");
        map.put("sku_id", str);
        map.put("fail_code", String.valueOf(num));
        String str3 = "";
        if (str2 == null) {
            str2 = "";
        }
        map.put("fail_message", str2);
        map.put("result_type", "result_fail");
        com.transsion.baselib.report.m mVar = com.transsion.baselib.report.m.f51277a;
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (strF = logViewConfig.f()) != null) {
            str3 = strF;
        }
        mVar.m(str3, "purchase", map);
    }

    public final void J1(String str) {
        String strF;
        HashMap map = new HashMap();
        map.put("opt_type", "pay_result");
        map.put("sku_id", str);
        map.put("result_type", "result_success");
        com.transsion.baselib.report.m mVar = com.transsion.baselib.report.m.f51277a;
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (strF = logViewConfig.f()) == null) {
            strF = "";
        }
        mVar.m(strF, "purchase", map);
    }

    public final void K1(MemberDetail memberDetail) {
        MemberInfo memberInfo;
        Integer daysLeft;
        MemberInfo memberInfo2;
        Integer daysLeft2;
        AppCompatTextView appCompatTextView;
        GradientBorderView gradientBorderView;
        AppCompatImageView appCompatImageView;
        GradientBorderView gradientBorderView2;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        MemberInfo memberInfo3;
        Integer daysLeft3;
        MemberInfo memberInfo4;
        Integer daysLeft4;
        MemberInfo memberInfo5;
        String nextRenewDate;
        String string;
        AppCompatTextView appCompatTextView4;
        GradientBorderView gradientBorderView3;
        AppCompatImageView appCompatImageView2;
        GradientBorderView gradientBorderView4;
        MemberInfo memberInfo6;
        Integer daysLeft5;
        MemberInfo memberInfo7;
        Integer daysLeft6;
        AppCompatTextView appCompatTextView5;
        GradientBorderView gradientBorderView5;
        AppCompatImageView appCompatImageView3;
        GradientBorderView gradientBorderView6;
        GradientBorderView gradientBorderView7;
        AppCompatImageView appCompatImageView4;
        GradientBorderView gradientBorderView8;
        GradientBorderView gradientBorderView9;
        AppCompatImageView appCompatImageView5;
        GradientBorderView gradientBorderView10;
        PointInfo pointInfo;
        String string2 = null;
        uo.b.a.g(uo.b.f78622a, "member detail is " + memberDetail, false, 2, null);
        int point = (memberDetail == null || (pointInfo = memberDetail.getPointInfo()) == null) ? 0 : pointInfo.getPoint();
        int i11 = b.f53148a[(memberDetail != null ? MembershipDetailType.Companion.a(memberDetail.getMemberInfo()) : MembershipDetailType.GUEST).ordinal()];
        if (i11 == 1) {
            qu.i mViewBinding = getMViewBinding();
            if (mViewBinding != null && (gradientBorderView2 = mViewBinding.f74961m) != null) {
                so.c.k(gradientBorderView2);
            }
            qu.i mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (appCompatImageView = mViewBinding2.f74963o) != null) {
                so.c.k(appCompatImageView);
            }
            qu.i mViewBinding3 = getMViewBinding();
            if (mViewBinding3 != null && (gradientBorderView = mViewBinding3.f74954f) != null) {
                so.c.g(gradientBorderView);
            }
            qu.i mViewBinding4 = getMViewBinding();
            AppCompatTextView appCompatTextView6 = mViewBinding4 != null ? mViewBinding4.f74965q : null;
            if (appCompatTextView6 != null) {
                Context context = getContext();
                appCompatTextView6.setText(context != null ? context.getString(R$string.member_free_trial) : null);
            }
            qu.i mViewBinding5 = getMViewBinding();
            if (mViewBinding5 != null && (appCompatTextView = mViewBinding5.f74958j) != null) {
                so.c.g(appCompatTextView);
            }
            qu.i mViewBinding6 = getMViewBinding();
            AppCompatTextView appCompatTextView7 = mViewBinding6 != null ? mViewBinding6.f74953d : null;
            if (appCompatTextView7 != null) {
                Context context2 = getContext();
                appCompatTextView7.setText(context2 != null ? context2.getString(R$string.member_extend_your_premium_benefits) : null);
            }
            qu.i mViewBinding7 = getMViewBinding();
            AppCompatTextView appCompatTextView8 = mViewBinding7 != null ? mViewBinding7.f74962n : null;
            if (appCompatTextView8 != null) {
                Context context3 = getContext();
                if (context3 != null) {
                    int i12 = (memberDetail == null || (memberInfo2 = memberDetail.getMemberInfo()) == null || (daysLeft2 = memberInfo2.getDaysLeft()) == null || daysLeft2.intValue() <= 1) ? R$string.member_day_left : R$string.member_days_left;
                    Object[] objArr = new Object[1];
                    objArr[0] = Integer.valueOf((memberDetail == null || (memberInfo = memberDetail.getMemberInfo()) == null || (daysLeft = memberInfo.getDaysLeft()) == null) ? 0 : daysLeft.intValue());
                    string2 = context3.getString(i12, objArr);
                }
                appCompatTextView8.setText(string2);
            }
            C1(false);
        } else if (i11 == 2) {
            qu.i mViewBinding8 = getMViewBinding();
            if (mViewBinding8 != null && (gradientBorderView4 = mViewBinding8.f74961m) != null) {
                so.c.k(gradientBorderView4);
            }
            qu.i mViewBinding9 = getMViewBinding();
            if (mViewBinding9 != null && (appCompatImageView2 = mViewBinding9.f74963o) != null) {
                so.c.k(appCompatImageView2);
            }
            qu.i mViewBinding10 = getMViewBinding();
            if (mViewBinding10 != null && (gradientBorderView3 = mViewBinding10.f74954f) != null) {
                so.c.g(gradientBorderView3);
            }
            qu.i mViewBinding11 = getMViewBinding();
            AppCompatTextView appCompatTextView9 = mViewBinding11 != null ? mViewBinding11.f74965q : null;
            if (appCompatTextView9 != null) {
                Context context4 = getContext();
                appCompatTextView9.setText(context4 != null ? context4.getString(R$string.member_premium_title) : null);
            }
            if (memberDetail == null || (memberInfo5 = memberDetail.getMemberInfo()) == null || (nextRenewDate = memberInfo5.getNextRenewDate()) == null || nextRenewDate.length() <= 0) {
                qu.i mViewBinding12 = getMViewBinding();
                if (mViewBinding12 != null && (appCompatTextView2 = mViewBinding12.f74958j) != null) {
                    so.c.g(appCompatTextView2);
                }
            } else {
                qu.i mViewBinding13 = getMViewBinding();
                if (mViewBinding13 != null && (appCompatTextView4 = mViewBinding13.f74958j) != null) {
                    so.c.k(appCompatTextView4);
                }
                qu.i mViewBinding14 = getMViewBinding();
                AppCompatTextView appCompatTextView10 = mViewBinding14 != null ? mViewBinding14.f74958j : null;
                if (appCompatTextView10 != null) {
                    Context context5 = getContext();
                    if (context5 != null) {
                        int i13 = R$string.member_next_billing_date;
                        Object[] objArr2 = new Object[1];
                        MemberInfo memberInfo8 = memberDetail.getMemberInfo();
                        objArr2[0] = memberInfo8 != null ? memberInfo8.getNextRenewDate() : null;
                        string = context5.getString(i13, objArr2);
                    } else {
                        string = null;
                    }
                    appCompatTextView10.setText(string);
                }
            }
            qu.i mViewBinding15 = getMViewBinding();
            AppCompatTextView appCompatTextView11 = mViewBinding15 != null ? mViewBinding15.f74953d : null;
            if (appCompatTextView11 != null) {
                Context context6 = getContext();
                appCompatTextView11.setText(context6 != null ? context6.getString(R$string.member_extend_your_premium_benefits) : null);
            }
            qu.i mViewBinding16 = getMViewBinding();
            AppCompatTextView appCompatTextView12 = mViewBinding16 != null ? mViewBinding16.f74962n : null;
            if (appCompatTextView12 != null) {
                Context context7 = getContext();
                if (context7 != null) {
                    int i14 = (memberDetail == null || (memberInfo4 = memberDetail.getMemberInfo()) == null || (daysLeft4 = memberInfo4.getDaysLeft()) == null || daysLeft4.intValue() <= 1) ? R$string.member_day_left : R$string.member_days_left;
                    Object[] objArr3 = new Object[1];
                    objArr3[0] = Integer.valueOf((memberDetail == null || (memberInfo3 = memberDetail.getMemberInfo()) == null || (daysLeft3 = memberInfo3.getDaysLeft()) == null) ? 0 : daysLeft3.intValue());
                    string2 = context7.getString(i14, objArr3);
                }
                appCompatTextView12.setText(string2);
            }
            qu.i mViewBinding17 = getMViewBinding();
            if (mViewBinding17 != null && (appCompatTextView3 = mViewBinding17.f74962n) != null) {
                appCompatTextView3.setCompoundDrawablesWithIntrinsicBounds(com.transsion.baseui.R$mipmap.ic_premium, 0, 0, 0);
            }
            C1(true);
        } else if (i11 == 3) {
            qu.i mViewBinding18 = getMViewBinding();
            if (mViewBinding18 != null && (gradientBorderView6 = mViewBinding18.f74961m) != null) {
                so.c.k(gradientBorderView6);
            }
            qu.i mViewBinding19 = getMViewBinding();
            if (mViewBinding19 != null && (appCompatImageView3 = mViewBinding19.f74963o) != null) {
                so.c.k(appCompatImageView3);
            }
            qu.i mViewBinding20 = getMViewBinding();
            if (mViewBinding20 != null && (gradientBorderView5 = mViewBinding20.f74954f) != null) {
                so.c.g(gradientBorderView5);
            }
            qu.i mViewBinding21 = getMViewBinding();
            AppCompatTextView appCompatTextView13 = mViewBinding21 != null ? mViewBinding21.f74965q : null;
            if (appCompatTextView13 != null) {
                Context context8 = getContext();
                appCompatTextView13.setText(context8 != null ? context8.getString(R$string.member_premium_title) : null);
            }
            qu.i mViewBinding22 = getMViewBinding();
            if (mViewBinding22 != null && (appCompatTextView5 = mViewBinding22.f74958j) != null) {
                so.c.g(appCompatTextView5);
            }
            qu.i mViewBinding23 = getMViewBinding();
            AppCompatTextView appCompatTextView14 = mViewBinding23 != null ? mViewBinding23.f74953d : null;
            if (appCompatTextView14 != null) {
                Context context9 = getContext();
                appCompatTextView14.setText(context9 != null ? context9.getString(R$string.member_extend_your_premium_benefits) : null);
            }
            qu.i mViewBinding24 = getMViewBinding();
            AppCompatTextView appCompatTextView15 = mViewBinding24 != null ? mViewBinding24.f74962n : null;
            if (appCompatTextView15 != null) {
                Context context10 = getContext();
                if (context10 != null) {
                    int i15 = (memberDetail == null || (memberInfo7 = memberDetail.getMemberInfo()) == null || (daysLeft6 = memberInfo7.getDaysLeft()) == null || daysLeft6.intValue() <= 1) ? R$string.member_day_left : R$string.member_days_left;
                    Object[] objArr4 = new Object[1];
                    objArr4[0] = Integer.valueOf((memberDetail == null || (memberInfo6 = memberDetail.getMemberInfo()) == null || (daysLeft5 = memberInfo6.getDaysLeft()) == null) ? 0 : daysLeft5.intValue());
                    string2 = context10.getString(i15, objArr4);
                }
                appCompatTextView15.setText(string2);
            }
            C1(false);
        } else if (i11 != 4) {
            qu.i mViewBinding25 = getMViewBinding();
            if (mViewBinding25 != null && (gradientBorderView10 = mViewBinding25.f74961m) != null) {
                so.c.g(gradientBorderView10);
            }
            qu.i mViewBinding26 = getMViewBinding();
            if (mViewBinding26 != null && (appCompatImageView5 = mViewBinding26.f74963o) != null) {
                so.c.g(appCompatImageView5);
            }
            qu.i mViewBinding27 = getMViewBinding();
            if (mViewBinding27 != null && (gradientBorderView9 = mViewBinding27.f74954f) != null) {
                so.c.k(gradientBorderView9);
            }
            qu.i mViewBinding28 = getMViewBinding();
            AppCompatTextView appCompatTextView16 = mViewBinding28 != null ? mViewBinding28.f74953d : null;
            if (appCompatTextView16 != null) {
                Context context11 = getContext();
                appCompatTextView16.setText(context11 != null ? context11.getString(R$string.member_your_premium_benefits) : null);
            }
        } else {
            qu.i mViewBinding29 = getMViewBinding();
            if (mViewBinding29 != null && (gradientBorderView8 = mViewBinding29.f74961m) != null) {
                so.c.g(gradientBorderView8);
            }
            qu.i mViewBinding30 = getMViewBinding();
            if (mViewBinding30 != null && (appCompatImageView4 = mViewBinding30.f74963o) != null) {
                so.c.g(appCompatImageView4);
            }
            qu.i mViewBinding31 = getMViewBinding();
            if (mViewBinding31 != null && (gradientBorderView7 = mViewBinding31.f74954f) != null) {
                so.c.k(gradientBorderView7);
            }
            qu.i mViewBinding32 = getMViewBinding();
            AppCompatTextView appCompatTextView17 = mViewBinding32 != null ? mViewBinding32.f74953d : null;
            if (appCompatTextView17 != null) {
                Context context12 = getContext();
                appCompatTextView17.setText(context12 != null ? context12.getString(R$string.member_your_premium_benefits) : null);
            }
        }
        N1(point);
        F1();
    }

    public final void L1(SkuData skuData) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        PointInfo pointInfo;
        List<SkuItem> skuList = skuData.getSkuList();
        List listF0 = skuList != null ? CollectionsKt___CollectionsKt.F0(skuList, 3) : null;
        if (listF0 == null) {
            listF0 = kotlin.collections.g.l();
        }
        List<SkuItem> skuPointList = skuData.getSkuPointList();
        List listF1 = skuPointList != null ? CollectionsKt___CollectionsKt.F0(skuPointList, 3) : null;
        if (listF1 == null) {
            listF1 = kotlin.collections.g.l();
        }
        List<SkuItem> list = listF0;
        ArrayList arrayList = new ArrayList(kotlin.collections.h.v(list, 10));
        for (SkuItem skuItem : list) {
            skuItem.setMemberDetail(this.f53136m);
            arrayList.add(skuItem);
        }
        MemberDetail memberDetail = this.f53136m;
        int point = (memberDetail == null || (pointInfo = memberDetail.getPointInfo()) == null) ? 0 : pointInfo.getPoint();
        List<SkuItem> list2 = listF1;
        ArrayList arrayList2 = new ArrayList(kotlin.collections.h.v(list2, 10));
        for (SkuItem skuItem2 : list2) {
            skuItem2.setUserPoints(Integer.valueOf(point));
            arrayList2.add(skuItem2);
        }
        ou.f fVar = this.f53140q;
        if (Intrinsics.b(fVar != null ? fVar.D() : null, CollectionsKt___CollectionsKt.M0(arrayList))) {
            ou.d dVar = this.f53141r;
            if (Intrinsics.b(dVar != null ? dVar.D() : null, CollectionsKt___CollectionsKt.M0(arrayList2))) {
                return;
            }
        }
        ou.f fVar2 = new ou.f(CollectionsKt___CollectionsKt.M0(arrayList));
        fVar2.i(R$id.item_root);
        fVar2.K0(new Function2<SkuItem, View, Unit>() { // from class: com.transsion.member.MemberFragment$setSkuListData$3$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(SkuItem skuItem3, View view) {
                invoke2(skuItem3, view);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SkuItem item, View view) {
                String str;
                Intrinsics.g(item, "item");
                Intrinsics.g(view, "view");
                if (com.transsion.baseui.util.c.f51452a.a(view.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
                    return;
                }
                uo.b.a.g(uo.b.f78622a, "The productId and coins: " + item.getSkuId() + ", " + item.getCoin(), false, 2, null);
                String category = item.getCategory();
                SkuCategory skuCategory = SkuCategory.AUTO_RENEW;
                if (Intrinsics.b(category, skuCategory.getValue())) {
                    str = item.getDuration() + "_subscription";
                } else {
                    str = item.getDuration() + "_purchased";
                }
                this.this$0.H1(str, item.getSkuId());
                if (this.this$0.s1().N()) {
                    this.this$0.P1(item.getSkuId(), Intrinsics.b(item.getCategory(), skuCategory.getValue()));
                    return;
                }
                this.this$0.s1().F(this.this$0);
                ILoginApi iLoginApiS1 = this.this$0.s1();
                Context contextRequireContext = this.this$0.requireContext();
                Intrinsics.f(contextRequireContext, "requireContext()");
                iLoginApiS1.w0(contextRequireContext);
            }
        });
        this.f53140q = fVar2;
        qu.i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView2 = mViewBinding.f74967s) != null) {
            recyclerView2.setLayoutManager(new NpaGridLayoutManager(recyclerView2.getContext(), 3));
            if (recyclerView2.getItemDecorationCount() <= 0) {
                recyclerView2.addItemDecoration(new ou.a(3, f0.a(8.0f)));
            }
            recyclerView2.setAdapter(this.f53140q);
        }
        ou.d dVar2 = new ou.d(CollectionsKt___CollectionsKt.M0(arrayList2));
        dVar2.i(R$id.item_root);
        dVar2.K0(new Function2<SkuItem, View, Unit>() { // from class: com.transsion.member.MemberFragment$setSkuListData$5$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(SkuItem skuItem3, View view) {
                invoke2(skuItem3, view);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SkuItem item, View view) {
                Intrinsics.g(item, "item");
                Intrinsics.g(view, "view");
                if (com.transsion.baseui.util.c.f51452a.a(view.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
                    return;
                }
                uo.b.a.g(uo.b.f78622a, "The productId and coins: " + item.getSkuId() + ", " + item.getCoin(), false, 2, null);
                String duration = item.getDuration();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(duration);
                sb2.append("_reward");
                this.this$0.H1(sb2.toString(), item.getSkuId());
                this.this$0.D1(item);
            }
        });
        this.f53141r = dVar2;
        qu.i mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (recyclerView = mViewBinding2.f74966r) == null) {
            return;
        }
        recyclerView.setLayoutManager(new NpaGridLayoutManager(recyclerView.getContext(), 3));
        if (recyclerView.getItemDecorationCount() <= 0) {
            recyclerView.addItemDecoration(new ou.a(3, f0.a(8.0f)));
        }
        recyclerView.setAdapter(this.f53141r);
    }

    public final void M1(MemberSource memberSource) {
        this.f53134k = memberSource;
    }

    public final void N1(int i11) {
        List<SkuItem> skuPointList;
        PointView pointView;
        PointView pointView2;
        MemberDetail memberDetail = this.f53136m;
        PointInfo pointInfo = memberDetail != null ? memberDetail.getPointInfo() : null;
        if (pointInfo != null) {
            pointInfo.setPoint(i11);
        }
        qu.i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (pointView2 = mViewBinding.f74964p) != null) {
            pointView2.setPoints(i11);
        }
        qu.i mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (pointView = mViewBinding2.f74955g) != null) {
            pointView.setPoints(i11);
        }
        SkuData skuDataX = t1().x();
        if (skuDataX == null || (skuPointList = skuDataX.getSkuPointList()) == null) {
            return;
        }
        G1(skuPointList);
    }

    public final void O1() {
        r1().k0(this, "LoadingDialog");
    }

    public final void P1(final String str, boolean z11) {
        MemberInfo memberInfo;
        MemberDetail memberDetail;
        MemberInfo memberInfo2;
        MemberDetail memberDetail2 = this.f53136m;
        boolean z12 = (memberDetail2 == null || (memberInfo = memberDetail2.getMemberInfo()) == null || !memberInfo.isActive() || (memberDetail = this.f53136m) == null || (memberInfo2 = memberDetail.getMemberInfo()) == null || memberInfo2.getMemberType() != 2) ? false : true;
        this.f53146w = z12;
        uo.b.a.g(uo.b.f78622a, "before pay isPremium: " + z12, false, 2, null);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        FragmentActivity activity = getActivity();
        AppCompatActivity appCompatActivity = activity instanceof AppCompatActivity ? (AppCompatActivity) activity : null;
        if (appCompatActivity != null) {
            PaymentManager.f54037b.a().b(appCompatActivity, str, null, z11, new com.transsion.payment.lib.b() { // from class: com.transsion.member.MemberFragment$startPay$1$1
                @Override // com.transsion.payment.lib.b
                public void a(Integer num, String str2, boolean z13, String str3) {
                    uo.b.a.k(uo.b.f78622a, "Payment failed " + str2 + ", " + num, false, 2, null);
                    if (num != null && num.intValue() == -30) {
                        Ref.BooleanRef booleanRef2 = booleanRef;
                        if (booleanRef2.element) {
                            return;
                        }
                        booleanRef2.element = true;
                        com.tn.lib.widget.toast.core.h hVar = com.tn.lib.widget.toast.core.h.f50034a;
                        Context context = this.f53154a.getContext();
                        hVar.l(context != null ? context.getString(R$string.member_pay_pending) : null);
                        return;
                    }
                    if (num != null && num.intValue() == 1003) {
                        this.f53154a.I1(str, num, str2);
                        com.tn.lib.widget.toast.core.h hVar2 = com.tn.lib.widget.toast.core.h.f50034a;
                        Context context2 = this.f53154a.getContext();
                        hVar2.l(context2 != null ? context2.getString(R$string.member_pay_processing) : null);
                        if (this.f53154a.getContext() != null) {
                            this.f53154a.p1();
                            return;
                        }
                        return;
                    }
                    this.f53154a.I1(str, num, str2);
                    com.tn.lib.widget.toast.core.h hVar3 = com.tn.lib.widget.toast.core.h.f50034a;
                    Context context3 = this.f53154a.getContext();
                    hVar3.l(context3 != null ? context3.getString(R$string.member_pay_failed) : null);
                    if (this.f53154a.getContext() != null) {
                        this.f53154a.p1();
                    }
                }

                @Override // com.transsion.payment.lib.b
                public void b(boolean z13) {
                    if (z13) {
                        this.f53154a.O1();
                    }
                }

                @Override // com.transsion.payment.lib.b
                public void c(int i11, String balance, String str2) {
                    MemberInfo memberInfo3;
                    MemberDetail memberDetail3;
                    MemberInfo memberInfo4;
                    Intrinsics.g(balance, "balance");
                    uo.b.a aVar = uo.b.f78622a;
                    uo.b.a.g(aVar, "Payment succeed " + str2, false, 2, null);
                    MemberDetail memberDetail4 = this.f53154a.f53136m;
                    uo.b.a.g(aVar, "after pay isPremium:  " + ((memberDetail4 == null || (memberInfo3 = memberDetail4.getMemberInfo()) == null || !memberInfo3.isActive() || (memberDetail3 = this.f53154a.f53136m) == null || (memberInfo4 = memberDetail3.getMemberInfo()) == null || memberInfo4.getMemberType() != 2) ? false : true), false, 2, null);
                    this.f53154a.f53145v = true;
                    uo.b.a.g(aVar, "Should refresh purchased info", false, 2, null);
                    this.f53154a.J1(str);
                    j.d(l0.a(w0.c()), null, null, new MemberFragment$startPay$1$1$success$1(this.f53154a, null), 3, null);
                    if (this.f53154a.getContext() != null) {
                        this.f53154a.p1();
                    }
                }
            });
        }
    }

    public final void Q1(float f11) {
        qu.i mViewBinding;
        ConstraintLayout constraintLayout;
        if (!isAdded() || (mViewBinding = getMViewBinding()) == null || (constraintLayout = mViewBinding.f74972x) == null) {
            return;
        }
        constraintLayout.setBackgroundColor(l1(z2.a.getColor(requireContext(), com.tn.lib.widget.R$color.gray_dark_00), kotlin.ranges.a.f(f11, 1.0f)));
    }

    public final void R1(UserInfo userInfo) {
        qu.i mViewBinding;
        if (userInfo == null || (mViewBinding = getMViewBinding()) == null) {
            return;
        }
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context context = mViewBinding.f74951b.getContext();
        Intrinsics.f(context, "ivAvatarPremium.context");
        ShapeableImageView ivAvatarPremium = mViewBinding.f74951b;
        Intrinsics.f(ivAvatarPremium, "ivAvatarPremium");
        companion.g(context, ivAvatarPremium, userInfo.getAvatar(), (112 & 8) != 0 ? com.tn.lib.widget.R$color.cl37 : com.tn.lib.widget.R$mipmap.profile_default_avatar, (112 & 16) != 0 ? 0 : 0, (112 & 32) != 0 ? -1 : 0, (112 & 64) != 0 ? -1 : 0);
        mViewBinding.f74957i.setText(androidx.core.text.a.c().k(userInfo.getNickname(), u.f7875a));
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        PointView pointView;
        PointView pointView2;
        AppCompatImageView appCompatImageView;
        qu.i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (appCompatImageView = mViewBinding.f74952c) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberFragment.w1(this.f53331a, view);
                }
            });
        }
        qu.i mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (pointView2 = mViewBinding2.f74955g) != null) {
            pointView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberFragment.x1(view);
                }
            });
        }
        qu.i mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (pointView = mViewBinding3.f74964p) == null) {
            return;
        }
        pointView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MemberFragment.y1(view);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        MemberViewModel memberViewModelT1 = t1();
        memberViewModelT1.t().j(getViewLifecycleOwner(), new e(new Function1<MemberDetail, Unit>() { // from class: com.transsion.member.MemberFragment$initViewModel$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MemberDetail memberDetail) {
                invoke2(memberDetail);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MemberDetail memberDetail) {
                if (memberDetail != null) {
                    MemberFragment memberFragment = this.this$0;
                    memberFragment.f53136m = memberDetail;
                    com.transsion.baselib.report.h logViewConfig = memberFragment.getLogViewConfig();
                    if (logViewConfig != null) {
                        logViewConfig.j(true);
                    }
                    memberFragment.K1(memberDetail);
                    memberFragment.R1(memberDetail.getUserInfo());
                }
                if (memberDetail == null) {
                    if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                        com.tn.lib.widget.toast.core.h.f50034a.k(com.tn.lib.widget.R$string.failed_toast);
                    } else {
                        zp.b.f82110a.d(com.tn.lib.widget.R$string.no_network_toast);
                    }
                }
                this.this$0.p1();
            }
        }));
        memberViewModelT1.y().j(getViewLifecycleOwner(), new e(new Function1<SkuData, Unit>() { // from class: com.transsion.member.MemberFragment$initViewModel$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SkuData skuData) {
                invoke2(skuData);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SkuData skuData) {
                if (skuData != null) {
                    this.this$0.L1(skuData);
                }
                this.this$0.p1();
            }
        }));
        memberViewModelT1.v().j(getViewLifecycleOwner(), new e(new Function1<RedeemResult, Unit>() { // from class: com.transsion.member.MemberFragment$initViewModel$1$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RedeemResult redeemResult) {
                invoke2(redeemResult);
                return Unit.f68710a;
            }

            /* JADX WARN: Code duplicated, block: B:9:0x001a  */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RedeemResult redeemResult) {
                String string;
                String str;
                if (redeemResult != null) {
                    int vipDurationDays = redeemResult.getVipDurationDays();
                    if (vipDurationDays == 1) {
                        Context context = this.this$0.getContext();
                        if (context != null) {
                            string = context.getString(R$string.member_claimed_succeed_1_day);
                            str = string;
                        } else {
                            str = null;
                        }
                    } else {
                        Context context2 = this.this$0.getContext();
                        if (context2 != null) {
                            string = context2.getString(R$string.member_claimed_succeed_days, Integer.valueOf(vipDurationDays));
                            str = string;
                        } else {
                            str = null;
                        }
                    }
                    if (str != null) {
                        zp.b.f82110a.g(R$layout.claim_succeed_layout, str, (8 & 4) != 0 ? 0 : 80, (8 & 8) != 0 ? 0 : 0, (8 & 16) != 0 ? 0 : f0.a(66.0f));
                    }
                    this.this$0.E1();
                    Object objH = com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class);
                    Intrinsics.f(objH, "getInstance().navigation(IMemberApi::class.java)");
                    IMemberApi.a.a((IMemberApi) objH, null, 1, null);
                } else {
                    com.tn.lib.widget.toast.core.h.f50034a.k(com.tn.lib.widget.R$string.failed_toast);
                }
                this.this$0.p1();
            }
        }));
        memberViewModelT1.B().j(getViewLifecycleOwner(), new e(new Function1<List<? extends MemberTaskItem>, Unit>() { // from class: com.transsion.member.MemberFragment$initViewModel$1$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MemberTaskItem> list) {
                invoke2((List<MemberTaskItem>) list);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<MemberTaskItem> list) {
                ou.g gVar = this.this$0.f53139p;
                if (gVar != null) {
                    gVar.w0(list);
                }
                this.this$0.n1();
            }
        }));
        memberViewModelT1.A().j(getViewLifecycleOwner(), new e(new Function1<su.d, Unit>() { // from class: com.transsion.member.MemberFragment$initViewModel$1$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(su.d dVar) {
                invoke2(dVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(su.d dVar) {
                List<MemberTaskItem> listD;
                Object obj;
                Object next;
                List<MemberTaskItemInvite> inviteList;
                this.this$0.E1();
                ou.g gVar = this.this$0.f53139p;
                if (gVar == null || (listD = gVar.D()) == null) {
                    return;
                }
                Iterator<T> it = listD.iterator();
                while (true) {
                    obj = null;
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    Integer taskSubType = ((MemberTaskItem) next).getTaskSubType();
                    if (taskSubType != null && taskSubType.intValue() == 2) {
                        break;
                    }
                }
                MemberTaskItem memberTaskItem = (MemberTaskItem) next;
                if (memberTaskItem != null) {
                    MemberFragment memberFragment = this.this$0;
                    int iA = dVar.a();
                    String strD = dVar.d();
                    MemberTaskRewardInfo memberTaskRewardInfoB = dVar.b();
                    if (memberTaskRewardInfoB != null) {
                        if (Intrinsics.b(strD, "0")) {
                            List<MemberTaskItemInvite> inviteList2 = memberTaskItem.getInviteList();
                            if (inviteList2 != null) {
                                for (MemberTaskItemInvite memberTaskItemInvite : inviteList2) {
                                    if (memberTaskItemInvite.getStatus() == 1) {
                                        memberTaskItemInvite.setStatus(2);
                                    }
                                }
                            }
                        } else if (iA >= 0 && (inviteList = memberTaskItem.getInviteList()) != null) {
                            for (Object obj2 : inviteList) {
                                if (Intrinsics.b(strD, ((MemberTaskItemInvite) obj2).getRewardId())) {
                                    obj = obj2;
                                    break;
                                }
                            }
                            MemberTaskItemInvite memberTaskItemInvite2 = (MemberTaskItemInvite) obj;
                            if (memberTaskItemInvite2 != null) {
                                memberTaskItemInvite2.setStatus(2);
                            }
                        }
                        memberTaskItem.setRewardInfo(memberTaskRewardInfoB);
                    }
                    ou.g gVar2 = memberFragment.f53139p;
                    if (gVar2 != null) {
                        gVar2.notifyDataSetChanged();
                    }
                }
            }
        }));
        memberViewModelT1.z().j(getViewLifecycleOwner(), new e(new Function1<Pair<? extends Integer, ? extends MemberTaskSubmitCheckInRes>, Unit>() { // from class: com.transsion.member.MemberFragment$initViewModel$1$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Integer, ? extends MemberTaskSubmitCheckInRes> pair) {
                invoke2((Pair<Integer, MemberTaskSubmitCheckInRes>) pair);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<Integer, MemberTaskSubmitCheckInRes> pair) {
                List<MemberTaskItem> listD;
                Object next;
                this.this$0.E1();
                ou.g gVar = this.this$0.f53139p;
                if (gVar == null || (listD = gVar.D()) == null) {
                    return;
                }
                Iterator<T> it = listD.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    Integer taskSubType = ((MemberTaskItem) next).getTaskSubType();
                    if (taskSubType != null && taskSubType.intValue() == 8) {
                        break;
                    }
                }
                MemberTaskItem memberTaskItem = (MemberTaskItem) next;
                if (memberTaskItem != null) {
                    MemberFragment memberFragment = this.this$0;
                    int iIntValue = pair.getFirst().intValue();
                    if (pair.getSecond() != null) {
                        List<MemberTaskItemCheckInInfo> checkInList = memberTaskItem.getCheckInList();
                        MemberTaskItemCheckInInfo memberTaskItemCheckInInfo = checkInList != null ? checkInList.get(iIntValue) : null;
                        if (memberTaskItemCheckInInfo != null) {
                            memberTaskItemCheckInInfo.setHasCheckIn(true);
                        }
                    }
                    ou.g gVar2 = memberFragment.f53139p;
                    if (gVar2 != null) {
                        gVar2.notifyDataSetChanged();
                    }
                }
            }
        }));
        t1().C();
        R1(this.f53135l);
    }

    public final int l1(int i11, float f11) {
        return Color.argb((int) (Color.alpha(i11) * f11), Color.red(i11), Color.green(i11), Color.blue(i11));
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void logResume() {
        super.logResume();
    }

    public final void m1() {
        ImmersionBar.with(this).statusBarDarkFont(false).init();
    }

    public final void n1() {
        Intent intent;
        Intent intent2;
        RecyclerView recyclerView;
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || !intent.getBooleanExtra("extra_member_scroll_bottom", false)) {
            return;
        }
        qu.i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.f74969u) != null) {
            recyclerView.postDelayed(new Runnable() { // from class: com.transsion.member.e
                @Override // java.lang.Runnable
                public final void run() {
                    MemberFragment.o1(this.f53330a);
                }
            }, 500L);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 == null || (intent2 = activity2.getIntent()) == null) {
            return;
        }
        intent2.removeExtra("extra_member_scroll_bottom");
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("memberdetail", false, 2, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0040  */
    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        boolean z11;
        HashMap<String, String> mapG;
        HashMap<String, String> mapG2;
        HashMap<String, String> mapG3;
        super.onCreate(bundle);
        UserInfo userInfoP = s1().P();
        this.f53135l = userInfoP;
        String userId = userInfoP != null ? userInfoP.getUserId() : null;
        if (userId == null || userId.length() == 0) {
            z11 = true;
        } else {
            UserInfo userInfo = this.f53135l;
            String userId2 = userInfo != null ? userInfo.getUserId() : null;
            UserInfo userInfoP2 = s1().P();
            if (Intrinsics.b(userId2, userInfoP2 != null ? userInfoP2.getUserId() : null)) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        this.f53147x = z11;
        if (this.f53134k != null) {
            com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
            if (logViewConfig == null || (mapG3 = logViewConfig.g()) == null) {
                return;
            }
            MemberSource memberSource = this.f53134k;
            Intrinsics.d(memberSource);
            mapG3.put("source", memberSource.getValue());
            return;
        }
        if (getActivity() instanceof MemberActivity) {
            com.transsion.baselib.report.h logViewConfig2 = getLogViewConfig();
            if (logViewConfig2 == null || (mapG2 = logViewConfig2.g()) == null) {
                return;
            }
            mapG2.put("source", "OTHER");
            return;
        }
        com.transsion.baselib.report.h logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 == null || (mapG = logViewConfig3.g()) == null) {
            return;
        }
        mapG.put("source", "TAB");
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        s1().t1(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        if (isResumed()) {
            if (z11) {
                logPause();
            } else {
                E1();
                logResume();
            }
        }
        com.transsion.baseui.activity.d.h(null, this, z11, null, 9, null);
    }

    @Override // r00.a
    public void onLogin(UserInfo user) {
        Intrinsics.g(user, "user");
        r00.a.C0822a.a(this, user);
        E1();
        t1().p();
    }

    @Override // r00.a
    public void onLogout() {
        r00.a.C0822a.b(this);
        E1();
        t1().p();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.transsion.baseui.activity.d.l(null, this, null, 5, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        E1();
        com.transsion.baseui.activity.d.p(null, this, "visible=" + isVisible(), 1, null);
        if (this.f53144u) {
            this.f53144u = false;
        } else {
            t1().p();
        }
    }

    @Override // r00.a
    public void onUpdateUserInfo(UserInfo user) {
        Intrinsics.g(user, "user");
        if (B1()) {
            R1(user);
        }
    }

    public final void p1() {
        if (r1().isAdded()) {
            r1().dismissAllowingStateLoss();
        } else {
            uo.b.a.g(uo.b.f78622a, "Dialog not is added", false, 2, null);
        }
    }

    public final void q1() {
        ConstraintLayout constraintLayout;
        qu.i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (constraintLayout = mViewBinding.f74972x) != null) {
            so.c.e(constraintLayout);
        }
        FragmentActivity activity = getActivity();
        MemberActivity memberActivity = activity instanceof MemberActivity ? (MemberActivity) activity : null;
        if (memberActivity != null) {
            memberActivity.f0();
        }
    }

    public final BaseMemberLoadingDialog r1() {
        return (BaseMemberLoadingDialog) this.f53137n.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    public final MemberViewModel t1() {
        return (MemberViewModel) this.f53143t.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: u1, reason: merged with bridge method [inline-methods] */
    public qu.i getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        qu.i iVarC = qu.i.c(inflater);
        Intrinsics.f(iVarC, "inflate(inflater)");
        return iVarC;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        RecyclerView recyclerView;
        q1();
        if (B1()) {
            s1().F(this);
        }
        this.f53138o = registerForActivityResult(new c1.j(), c.f53150a);
        final qu.i mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            if (getActivity() instanceof MemberActivity) {
                mViewBinding.f74952c.setVisibility(0);
            } else {
                mViewBinding.f74952c.setVisibility(8);
            }
            mViewBinding.f74974z.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberFragment.z1(this.f53258a, view);
                }
            });
            qu.i mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (recyclerView = mViewBinding2.f74969u) != null) {
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
                recyclerView.addItemDecoration(new ou.g.a());
                ou.g gVar = new ou.g(this, t1(), this);
                this.f53139p = gVar;
                recyclerView.setAdapter(gVar);
            }
            m1();
            if (Build.VERSION.SDK_INT >= 23) {
                mViewBinding.f74970v.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.transsion.member.d
                    @Override // android.view.View.OnScrollChangeListener
                    public final void onScrollChange(View view, int i11, int i12, int i13, int i14) {
                        MemberFragment.A1(mViewBinding, this, view, i11, i12, i13, i14);
                    }
                });
            }
            Q1(0.0f);
        }
        initListener();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0046  */
    /* JADX WARN: Code duplicated, block: B:7:0x0012  */
    public final void v1() {
        String string;
        String string2;
        if (this.f53146w) {
            Context context = getContext();
            if (context != null) {
                string = context.getString(R$string.member_successfully_renewed);
            } else {
                string = null;
            }
        } else {
            Context context2 = getContext();
            if (context2 != null) {
                string = context2.getString(R$string.member_successfully_upgraded_to_premium);
            } else {
                string = null;
            }
        }
        MemberSource memberSource = this.f53134k;
        switch (memberSource == null ? -1 : b.f53149b[memberSource.ordinal()]) {
            case 1:
                Context context3 = getContext();
                if (context3 == null) {
                    string2 = null;
                } else {
                    string2 = context3.getString(R$string.member_back_to_watch);
                }
                break;
            case 2:
                Context context4 = getContext();
                if (context4 == null) {
                    string2 = null;
                } else {
                    string2 = context4.getString(R$string.member_back);
                }
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                Context context5 = getContext();
                if (context5 == null) {
                    string2 = null;
                } else {
                    string2 = context5.getString(R$string.member_back_to_download);
                }
                break;
            default:
                if (!(getActivity() instanceof MemberActivity)) {
                    Context context6 = getContext();
                    if (context6 == null) {
                        string2 = null;
                    } else {
                        string2 = context6.getString(R$string.member_explore_now);
                    }
                } else {
                    Context context7 = getContext();
                    if (context7 == null) {
                        string2 = null;
                    } else {
                        string2 = context7.getString(R$string.member_back);
                    }
                }
                break;
        }
        uo.b.a.g(uo.b.f78622a, "The source is " + this.f53134k + ", title: " + string + ", buttonTitle: " + string2, false, 2, null);
        j.d(v.a(this), null, null, new MemberFragment$handlePurchaseSucceed$1(this, string, string2, null), 3, null);
        Object objH = com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class);
        Intrinsics.f(objH, "getInstance().navigation(IMemberApi::class.java)");
        IMemberApi.a.a((IMemberApi) objH, null, 1, null);
        ObserveLoginAction.f53214c.a().h();
    }
}
