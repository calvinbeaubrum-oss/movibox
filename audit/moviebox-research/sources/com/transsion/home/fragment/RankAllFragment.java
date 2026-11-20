package com.transsion.home.fragment;

import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a0;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.t;
import androidx.compose.foundation.lazy.u;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.f3;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import androidx.compose.runtime.v1;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.c0;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.tn.lib.view.NoNetworkBigView;
import com.tn.lib.view.StateView;
import com.tn.lib.view.TitleLayout;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.home.R$color;
import com.transsion.home.R$id;
import com.transsion.home.R$string;
import com.transsion.home.bean.CategoryType;
import com.transsion.home.bean.RankAllData;
import com.transsion.home.viewmodel.RankAllViewModel;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import q2.x;

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
public final class RankAllFragment extends BaseFragment<lt.n> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f52425g = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f52426h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RankAllViewModel f52427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RankListFragment f52428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f52429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f52430d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f52431f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RankAllFragment a(String str, Integer num) {
            Bundle bundle = new Bundle();
            bundle.putString("category", str);
            bundle.putInt("tabId", num != null ? num.intValue() : 0);
            RankAllFragment rankAllFragment = new RankAllFragment();
            rankAllFragment.setArguments(bundle);
            return rankAllFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements com.tn.lib.util.networkinfo.g {
        public b() {
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected() {
            com.tn.lib.util.networkinfo.g.a.a(this);
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            View view;
            Intrinsics.g(network, "network");
            Intrinsics.g(networkCapabilities, "networkCapabilities");
            if (RankAllFragment.this.isResumed() && (view = RankAllFragment.this.f52430d) != null && so.c.i(view)) {
                View view2 = RankAllFragment.this.f52430d;
                if (view2 != null) {
                    so.c.g(view2);
                }
                RankAllFragment.this.lazyLoadData();
            }
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onDisconnected() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f52433a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f52433a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f52433a;
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
            this.f52433a.invoke(obj);
        }
    }

    public static final void D0(RankAllFragment this$0) {
        FrameLayout frameLayout;
        Intrinsics.g(this$0, "this$0");
        if (this$0.isDetached() || !this$0.isAdded() || this$0.getContext() == null) {
            return;
        }
        View viewW0 = com.tn.lib.util.networkinfo.f.f49475a.e() ? this$0.w0() : this$0.x0();
        if (this$0.f52429c) {
            RankListFragment rankListFragment = this$0.f52428b;
            if (rankListFragment != null) {
                rankListFragment.m0(viewW0);
            }
        } else {
            lt.n mViewBinding = this$0.getMViewBinding();
            if (mViewBinding != null && (frameLayout = mViewBinding.f70486c) != null) {
                frameLayout.removeAllViews();
                frameLayout.addView(viewW0);
                frameLayout.setVisibility(0);
            }
        }
        this$0.f52430d = viewW0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getPageName() {
        return "rank_all_page";
    }

    public static final String j0(i1<String> i1Var) {
        return i1Var.getValue();
    }

    public static final void k0(i1<String> i1Var, String str) {
        i1Var.setValue(str);
    }

    private final View x0() {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        final NoNetworkBigView noNetworkBigView = new NoNetworkBigView(contextRequireContext);
        noNetworkBigView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        NoNetworkBigView.showTitle$default(noNetworkBigView, false, null, 2, null);
        noNetworkBigView.retry(new Function0<Unit>() { // from class: com.transsion.home.fragment.RankAllFragment$getNoNetworkView$1$1
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
                so.c.g(noNetworkBigView);
                this.lazyLoadData();
                com.tn.lib.view.l.b(this.getPageName());
            }
        });
        noNetworkBigView.goToSetting(new Function0<Unit>() { // from class: com.transsion.home.fragment.RankAllFragment$getNoNetworkView$1$2
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
                com.tn.lib.view.l.c(this.this$0.getPageName());
            }
        });
        com.tn.lib.view.l.a(getPageName());
        return noNetworkBigView;
    }

    public static final void z0(RankAllFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public final void A0() {
        setNetListener(new b());
    }

    public final void B0(CategoryType categoryType, int i11) {
        String type;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("event_type", "category_click");
        if (categoryType == null || (type = categoryType.getType()) == null) {
            type = "";
        }
        linkedHashMap.put("category", type);
        linkedHashMap.put(RequestParameters.POSITION, String.valueOf(i11));
        com.transsion.baselib.report.m.f51277a.m(getPageName(), "click", linkedHashMap);
    }

    public final void C0() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.transsion.home.fragment.l
            @Override // java.lang.Runnable
            public final void run() {
                RankAllFragment.D0(this.f52450a);
            }
        }, 200L);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void hideLoading() {
        ConstraintLayout constraintLayout;
        lt.n mViewBinding = getMViewBinding();
        if (mViewBinding == null || (constraintLayout = mViewBinding.f70487d) == null) {
            return;
        }
        so.c.h(constraintLayout);
    }

    public final void i0(final List<CategoryType> items, final String str, androidx.compose.runtime.i iVar, final int i11) {
        Intrinsics.g(items, "items");
        androidx.compose.runtime.i iVarG = iVar.g(-1474848982);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(-1474848982, i11, -1, "com.transsion.home.fragment.RankAllFragment.SetRankCategoryUI (RankAllFragment.kt:246)");
        }
        Object objY = iVarG.y();
        if (objY == androidx.compose.runtime.i.f3413a.a()) {
            objY = u2.c(str, null, 2, null);
            iVarG.p(objY);
        }
        final i1 i1Var = (i1) objY;
        LazyDslKt.a(BackgroundKt.b(androidx.compose.ui.f.f3863a, k2.c.a(R$color.rank_all_category_background, iVarG, 0), null, 2, null), null, null, false, null, null, null, false, new Function1<u, Unit>() { // from class: com.transsion.home.fragment.RankAllFragment$SetRankCategoryUI$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(u uVar) {
                invoke2(uVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(u LazyColumn) {
                Intrinsics.g(LazyColumn, "$this$LazyColumn");
                List<CategoryType> list = items;
                final RankAllFragment rankAllFragment = this;
                final i1<String> i1Var2 = i1Var;
                final int i12 = 0;
                for (Object obj : list) {
                    int i13 = i12 + 1;
                    if (i12 < 0) {
                        kotlin.collections.g.u();
                    }
                    final CategoryType categoryType = (CategoryType) obj;
                    t.a(LazyColumn, categoryType.getType() + i12, null, androidx.compose.runtime.internal.b.c(797926263, true, new Function3<androidx.compose.foundation.lazy.b, androidx.compose.runtime.i, Integer, Unit>() { // from class: com.transsion.home.fragment.RankAllFragment$SetRankCategoryUI$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.b bVar, androidx.compose.runtime.i iVar2, Integer num) {
                            invoke(bVar, iVar2, num.intValue());
                            return Unit.f68710a;
                        }

                        public final void invoke(androidx.compose.foundation.lazy.b item, androidx.compose.runtime.i iVar2, int i14) {
                            Intrinsics.g(item, "$this$item");
                            if ((i14 & 81) == 16 && iVar2.h()) {
                                iVar2.H();
                                return;
                            }
                            if (androidx.compose.runtime.k.J()) {
                                androidx.compose.runtime.k.S(797926263, i14, -1, "com.transsion.home.fragment.RankAllFragment.SetRankCategoryUI.<anonymous>.<anonymous>.<anonymous> (RankAllFragment.kt:251)");
                            }
                            boolean zB = Intrinsics.b(RankAllFragment.j0(i1Var2), categoryType.getType());
                            int i15 = zB ? R$color.rank_all_list_background : R$color.rank_all_category_background;
                            androidx.compose.ui.b.c cVarH = androidx.compose.ui.b.f3770a.h();
                            androidx.compose.ui.f.a aVar = androidx.compose.ui.f.f3863a;
                            androidx.compose.ui.f fVarB = BackgroundKt.b(SizeKt.p(SizeKt.d(aVar, 0.0f, 1, null), null, false, 3, null), k2.c.a(i15, iVar2, 0), null, 2, null);
                            float fH = q2.i.h(0);
                            FragmentActivity activity = rankAllFragment.getActivity();
                            androidx.compose.ui.f fVarF = PaddingKt.f(fVarB, fH, q2.i.h((activity == null || !com.transsion.baseui.util.b.a(activity)) ? 16 : 20));
                            final CategoryType categoryType2 = categoryType;
                            final RankAllFragment rankAllFragment2 = rankAllFragment;
                            final int i16 = i12;
                            final i1<String> i1Var3 = i1Var2;
                            androidx.compose.ui.f fVarD = ClickableKt.d(fVarF, false, null, null, new Function0<Unit>() { // from class: com.transsion.home.fragment.RankAllFragment$SetRankCategoryUI$1$1$1.1
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
                                    if (Intrinsics.b(RankAllFragment.j0(i1Var3), categoryType2.getType())) {
                                        return;
                                    }
                                    RankAllFragment.k0(i1Var3, categoryType2.getType());
                                    RankListFragment rankListFragment = rankAllFragment2.f52428b;
                                    if (rankListFragment != null) {
                                        rankListFragment.startLoading();
                                    }
                                    RankAllViewModel rankAllViewModel = rankAllFragment2.f52427a;
                                    if (rankAllViewModel != null) {
                                        rankAllViewModel.j(RankAllFragment.j0(i1Var3), rankAllFragment2.f52431f);
                                    }
                                    rankAllFragment2.B0(categoryType2, i16);
                                }
                            }, 7, null);
                            CategoryType categoryType3 = categoryType;
                            androidx.compose.ui.layout.u uVarB = a0.b(androidx.compose.foundation.layout.b.f2478a.c(), cVarH, iVar2, 48);
                            int iA = androidx.compose.runtime.g.a(iVar2, 0);
                            androidx.compose.runtime.s sVarN = iVar2.n();
                            androidx.compose.ui.f fVarE = ComposedModifierKt.e(iVar2, fVarD);
                            ComposeUiNode.Companion companion = ComposeUiNode.f4919a8;
                            Function0<ComposeUiNode> function0A = companion.a();
                            if (!(iVar2.i() instanceof androidx.compose.runtime.f)) {
                                androidx.compose.runtime.g.b();
                            }
                            iVar2.D();
                            if (iVar2.e()) {
                                iVar2.G(function0A);
                            } else {
                                iVar2.o();
                            }
                            androidx.compose.runtime.i iVarA = f3.a(iVar2);
                            f3.b(iVarA, uVarB, companion.c());
                            f3.b(iVarA, sVarN, companion.e());
                            Function2<ComposeUiNode, Integer, Unit> function2B = companion.b();
                            if (iVarA.e() || !Intrinsics.b(iVarA.y(), Integer.valueOf(iA))) {
                                iVarA.p(Integer.valueOf(iA));
                                iVarA.k(Integer.valueOf(iA), function2B);
                            }
                            f3.b(iVarA, fVarE, companion.d());
                            androidx.compose.foundation.layout.d0 d0Var = androidx.compose.foundation.layout.d0.f2491a;
                            iVar2.x(1632735115);
                            if (zB) {
                                BoxKt.a(BackgroundKt.b(SizeKt.e(SizeKt.l(aVar, q2.i.h(3)), q2.i.h(16)), k2.c.a(com.tn.lib.widget.R$color.brand, iVar2, 0), null, 2, null), iVar2, 0);
                            }
                            iVar2.P();
                            int i17 = zB ? com.tn.lib.widget.R$color.brand : R$color.rank_all_category_text;
                            String name = categoryType3.getName();
                            if (name == null) {
                                name = "";
                            }
                            TextKt.a(name, PaddingKt.g(aVar, q2.i.h(12), 0.0f, 2, null), k2.c.a(i17, iVar2, 0), x.c(14), null, androidx.compose.ui.text.font.u.f5860b.c(), androidx.compose.ui.text.font.i.f5821b.b(), 0L, null, null, 0L, androidx.compose.ui.text.style.p.f6143a.b(), true, 2, 0, null, null, iVar2, 199728, 3504, 116624);
                            iVar2.r();
                            if (androidx.compose.runtime.k.J()) {
                                androidx.compose.runtime.k.R();
                            }
                        }
                    }), 2, null);
                    i12 = i13;
                }
            }
        }, iVarG, 0, 254);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        g2 g2VarJ = iVarG.j();
        if (g2VarJ == null) {
            return;
        }
        g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: com.transsion.home.fragment.RankAllFragment$SetRankCategoryUI$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                invoke(iVar2, num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(androidx.compose.runtime.i iVar2, int i12) {
                this.$tmp0_rcvr.i0(items, str, iVar2, v1.a(i11 | 1));
            }
        });
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        c0<RankAllData> c0VarI;
        TitleLayout titleLayout;
        Intrinsics.g(view, "view");
        lt.n mViewBinding = getMViewBinding();
        if (mViewBinding != null && (titleLayout = mViewBinding.f70488f) != null) {
            titleLayout.setLeftOnclick(new View.OnClickListener() { // from class: com.transsion.home.fragment.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    RankAllFragment.z0(this.f52449a, view2);
                }
            });
            String string = getString(R$string.str_ranking);
            Intrinsics.f(string, "getString(R.string.str_ranking)");
            titleLayout.setTitleText(string);
            tp.f fVar = tp.f.f77260a;
            Context context = titleLayout.getContext();
            Intrinsics.f(context, "context");
            titleLayout.setPadding(0, fVar.d(context), 0, 0);
        }
        RankAllViewModel rankAllViewModel = this.f52427a;
        if (rankAllViewModel != null && (c0VarI = rankAllViewModel.i()) != null) {
            c0VarI.j(this, new c(new Function1<RankAllData, Unit>() { // from class: com.transsion.home.fragment.RankAllFragment.initView.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(RankAllData rankAllData) {
                    invoke2(rankAllData);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final RankAllData rankAllData) {
                    List<Subject> subjects;
                    ComposeView composeView;
                    if (RankAllFragment.this.f52429c) {
                        RankListFragment rankListFragment = RankAllFragment.this.f52428b;
                        if (rankListFragment != null) {
                            rankListFragment.hideLoading();
                        }
                    } else {
                        RankAllFragment.this.hideLoading();
                    }
                    if (rankAllData == null || (subjects = rankAllData.getSubjects()) == null || subjects.size() <= 0) {
                        RankAllFragment.this.C0();
                        return;
                    }
                    if (!RankAllFragment.this.f52429c) {
                        lt.n mViewBinding2 = RankAllFragment.this.getMViewBinding();
                        if (mViewBinding2 != null && (composeView = mViewBinding2.f70485b) != null) {
                            final RankAllFragment rankAllFragment = RankAllFragment.this;
                            composeView.setContent(androidx.compose.runtime.internal.b.c(944460440, true, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: com.transsion.home.fragment.RankAllFragment.initView.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar, Integer num) {
                                    invoke(iVar, num.intValue());
                                    return Unit.f68710a;
                                }

                                public final void invoke(androidx.compose.runtime.i iVar, int i11) {
                                    List<CategoryType> arrayList;
                                    if ((i11 & 11) == 2 && iVar.h()) {
                                        iVar.H();
                                        return;
                                    }
                                    if (androidx.compose.runtime.k.J()) {
                                        androidx.compose.runtime.k.S(944460440, i11, -1, "com.transsion.home.fragment.RankAllFragment.initView.<anonymous>.<anonymous> (RankAllFragment.kt:116)");
                                    }
                                    RankAllFragment rankAllFragment2 = rankAllFragment;
                                    RankAllData rankAllData2 = rankAllData;
                                    if (rankAllData2 == null || (arrayList = rankAllData2.getCategoryList()) == null) {
                                        arrayList = new ArrayList<>();
                                    }
                                    RankAllData rankAllData3 = rankAllData;
                                    rankAllFragment2.i0(arrayList, rankAllData3 != null ? rankAllData3.getCurrentCategoryType() : null, iVar, 520);
                                    if (androidx.compose.runtime.k.J()) {
                                        androidx.compose.runtime.k.R();
                                    }
                                }
                            }));
                        }
                        RankAllFragment.this.f52429c = true;
                    }
                    RankListFragment rankListFragment2 = RankAllFragment.this.f52428b;
                    if (rankListFragment2 != null) {
                        rankListFragment2.n0(rankAllData);
                    }
                    com.transsion.baselib.report.h logViewConfig = RankAllFragment.this.getLogViewConfig();
                    if (logViewConfig == null) {
                        return;
                    }
                    logViewConfig.j(true);
                }
            }));
        }
        Fragment fragmentFindFragmentById = getChildFragmentManager().findFragmentById(R$id.rank_all_category_item_fragment);
        Intrinsics.e(fragmentFindFragmentById, "null cannot be cast to non-null type com.transsion.home.fragment.RankListFragment");
        this.f52428b = (RankListFragment) fragmentFindFragmentById;
        A0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        if (this.f52429c) {
            RankListFragment rankListFragment = this.f52428b;
            if (rankListFragment != null) {
                rankListFragment.startLoading();
            }
        } else {
            startLoading();
        }
        Bundle arguments = getArguments();
        this.f52431f = arguments != null ? arguments.getInt("tabId") : 0;
        RankAllViewModel rankAllViewModel = this.f52427a;
        if (rankAllViewModel != null) {
            Bundle arguments2 = getArguments();
            rankAllViewModel.j(arguments2 != null ? arguments2.getString("category") : null, this.f52431f);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h(getPageName(), false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void startLoading() {
        FrameLayout frameLayout;
        ConstraintLayout constraintLayout;
        lt.n mViewBinding = getMViewBinding();
        if (mViewBinding != null && (constraintLayout = mViewBinding.f70487d) != null) {
            so.c.k(constraintLayout);
        }
        lt.n mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (frameLayout = mViewBinding2.f70486c) == null) {
            return;
        }
        so.c.g(frameLayout);
    }

    public final View w0() {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        StateView stateView = new StateView(contextRequireContext);
        stateView.showData(3, 1, false, "", "");
        stateView.retry(new Function0<Unit>() { // from class: com.transsion.home.fragment.RankAllFragment$getErrorView$1$1
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
                this.this$0.lazyLoadData();
            }
        });
        return stateView;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
    public lt.n getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.f52427a = (RankAllViewModel) new v0(activity).a(RankAllViewModel.class);
        }
        lt.n nVarC = lt.n.c(inflater);
        Intrinsics.f(nVarC, "inflate(inflater)");
        return nVarC;
    }
}
