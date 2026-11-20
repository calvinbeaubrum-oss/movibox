package com.transsnet.downloader.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.noober.background.drawable.DrawableCreator;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLFrameLayout;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.report.FirebaseAnalyticsManager;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.widget.magicindicator.ORCommonNavigator;
import com.transsion.commercializationapi.ITaskCenterApi;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.DownloadResolutionItem;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.moviedetailapi.bean.DubsInfoData;
import com.transsion.moviedetailapi.bean.ResolutionItem;
import com.transsion.moviedetailapi.bean.ResourcesSeason;
import com.transsion.moviedetailapi.bean.ResourcesSeasonList;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.web.api.WebConstants;
import com.transsion.wrapperad.view.DownloadMovieAdView;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.bean.DownloadListBean;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import com.transsnet.downloader.manager.DownloadInterceptManager;
import com.transsnet.downloader.manager.StartDownloadHelper;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel;
import com.transsnet.downloader.widget.DownloadGridTabView;
import com.transsnet.downloader.widget.DownloadResolutionTabView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class DownloadReDetectorGroupMainFragment extends DownloadReDetectorBaseFragment<h00.b0> {
    public static final a W = new a(null);
    public String A;
    public String B;
    public String C;
    public boolean E;
    public long F;
    public DownloadReDetectorGroupFragment I;
    public int J;
    public ORCommonNavigator L;
    public int M;
    public int N;
    public Integer P;
    public int Q;
    public String R;
    public boolean S;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Subject f60714x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f60715y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f60716z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f60712v = "";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f60713w = "";
    public boolean D = true;
    public String G = "";
    public final kotlinx.coroutines.k0 H = kotlinx.coroutines.l0.a(kotlinx.coroutines.w0.b());
    public int K = 1;
    public CopyOnWriteArrayList<DownloadBean> O = new CopyOnWriteArrayList<>();
    public final Lazy T = LazyKt__LazyJVMKt.b(new Function0<StartDownloadHelper>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment$startDownloadHelper$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StartDownloadHelper invoke() {
            return new StartDownloadHelper();
        }
    });
    public final Lazy U = LazyKt__LazyJVMKt.b(new Function0<DownloadResourcesDetectorViewModel>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment$groupMainViewModel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DownloadResourcesDetectorViewModel invoke() {
            return (DownloadResourcesDetectorViewModel) new androidx.lifecycle.v0(this.this$0).a(DownloadResourcesDetectorViewModel.class);
        }
    });
    public final Lazy V = FragmentViewModelLazyKt.a(this, Reflection.b(com.transsnet.downloader.viewmodel.e.class), new Function0<androidx.lifecycle.x0>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final androidx.lifecycle.x0 invoke() {
            androidx.lifecycle.x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.f(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<androidx.lifecycle.v0.c>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final androidx.lifecycle.v0.c invoke() {
            androidx.lifecycle.v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.f(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadReDetectorGroupMainFragment a(String str, String str2, Subject subject, String str3, String str4, String str5, String str6, int i11, boolean z11) {
            DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment = new DownloadReDetectorGroupMainFragment();
            downloadReDetectorGroupMainFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("extra_page_from", str), TuplesKt.a("extra_last_page_from", str2), TuplesKt.a("extra_subject", subject), TuplesKt.a("extra_group_id", str3), TuplesKt.a("extra_ops", str4), TuplesKt.a("extra_target_resource_id", str5), TuplesKt.a("extra_module_name", str6), TuplesKt.a("extra_season", Integer.valueOf(i11)), TuplesKt.a("extra_dialog_style", Boolean.valueOf(z11))));
            return downloadReDetectorGroupMainFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements su.a {
        public b() {
        }

        @Override // su.a
        public void a(MemberCheckResult memberCheckResult) {
            su.a.C0841a.f(this, memberCheckResult);
        }

        @Override // su.a
        public void b(MemberCheckResult memberCheckResult) {
            su.a.C0841a.d(this, memberCheckResult);
        }

        @Override // su.a
        public void c(MemberCheckResult memberCheckResult) {
            su.a.C0841a.e(this, memberCheckResult);
        }

        @Override // su.a
        public void d() {
            su.a.C0841a.c(this);
            DownloadReDetectorGroupMainFragment.this.j2();
        }

        @Override // su.a
        public void e(MemberCheckResult memberCheckResult) {
            su.a.C0841a.a(this, memberCheckResult);
        }

        @Override // su.a
        public void onFail(String errorMsg) {
            Intrinsics.g(errorMsg, "errorMsg");
            su.a.C0841a.b(this, errorMsg);
            uo.b.a.f(uo.b.f78622a, "co_mem", "DownloadReDetectorGroupMainFragment --> onSelectAllClickIfNeed() --> 剧集全选 --> " + errorMsg, false, 4, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f60718a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f60718a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f60718a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.lifecycle.d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f60718a.invoke(obj);
        }
    }

    private final void W1() {
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.f(fragments, "childFragmentManager.fragments");
        Iterator<Fragment> it = fragments.iterator();
        while (it.hasNext()) {
            getChildFragmentManager().beginTransaction().hide(it.next()).commitNowAllowingStateLoss();
        }
    }

    public static final void b2(DownloadReDetectorGroupMainFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.S0();
    }

    public static final void c2(DownloadReDetectorGroupMainFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.k2();
    }

    public static final void d2(DownloadReDetectorGroupMainFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.k2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void e2(final DownloadReDetectorGroupMainFragment this$0, View view) throws InterruptedException {
        DownloadMovieAdView downloadMovieAdView;
        Intrinsics.g(this$0, "this$0");
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(R$string.no_network_toast);
            return;
        }
        if (this$0.O.isEmpty()) {
            zp.b.f82110a.d(com.transsnet.downloader.R$string.download_unselected_tips);
            return;
        }
        DownloadBean downloadBean = (DownloadBean) CollectionsKt___CollectionsKt.g0(this$0.O);
        if (downloadBean != null) {
            RoomAppMMKV.f51271a.a().putInt("download_last_resolution", downloadBean.getResolution());
        }
        h00.b0 b0Var = (h00.b0) this$0.getMViewBinding();
        if (b0Var != null && (downloadMovieAdView = b0Var.f65746z) != null) {
            downloadMovieAdView.download();
        }
        com.transsion.ad.a aVar = com.transsion.ad.a.f50276a;
        String simpleName = DownloadReDetectorGroupMainFragment.class.getSimpleName();
        DownloadBean downloadBean2 = (DownloadBean) CollectionsKt___CollectionsKt.g0(this$0.O);
        com.transsion.ad.a.j(aVar, simpleName + " --> zxb_log --> genre = " + (downloadBean2 != null ? downloadBean2.getGenre() : null), false, 2, null);
        this$0.S1().b().q(Boolean.TRUE);
        ITaskCenterApi iTaskCenterApi = (ITaskCenterApi) com.alibaba.android.arouter.launcher.a.d().h(ITaskCenterApi.class);
        Integer num = this$0.P;
        DownloadBean downloadBean3 = (DownloadBean) CollectionsKt___CollectionsKt.g0(this$0.O);
        iTaskCenterApi.t(num, downloadBean3 != null ? downloadBean3.getGenre() : null, new ss.b() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment$initView$4$2
            @Override // ss.b
            public void a(boolean z11) {
                this.f60719a.S1().c().q(Boolean.valueOf(z11));
            }

            @Override // ss.b
            public void onFail() {
            }

            @Override // ss.b
            public void onSuccess() {
                FragmentActivity activity = this.f60719a.getActivity();
                if (activity != null) {
                    final DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment = this.f60719a;
                    Subject subject = downloadReDetectorGroupMainFragment.f60714x;
                    if (subject != null) {
                        DownloadInterceptManager.f61008a.a().h(activity, subject, new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment$initView$4$2$onSuccess$1$1$1
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
                                downloadReDetectorGroupMainFragment.g2();
                            }
                        });
                    }
                }
            }
        });
    }

    public static final void h2(DownloadReDetectorGroupMainFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.f2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        LinearLayoutCompat linearLayoutCompat;
        AppCompatImageView appCompatImageView;
        AppCompatTextView appCompatTextView;
        ImageView imageView;
        CoordinatorLayout coordinatorLayout;
        if (!this.D) {
            h00.b0 b0Var = (h00.b0) getMViewBinding();
            BLConstraintLayout bLConstraintLayout = b0Var != null ? b0Var.f65724c : null;
            if (bLConstraintLayout != null) {
                bLConstraintLayout.setBackground(new DrawableCreator.Builder().setSolidColor(requireActivity().getResources().getColor(R$color.gray_dark_00)).build());
            }
        }
        h00.b0 b0Var2 = (h00.b0) getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (b0Var2 == null || (coordinatorLayout = b0Var2.f65725d) == null) ? null : coordinatorLayout.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = V0();
        }
        h00.b0 b0Var3 = (h00.b0) getMViewBinding();
        if (b0Var3 != null && (imageView = b0Var3.f65731k) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.d0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorGroupMainFragment.b2(this.f60906a, view);
                }
            });
        }
        h00.b0 b0Var4 = (h00.b0) getMViewBinding();
        if (b0Var4 != null && (appCompatTextView = b0Var4.f65739s) != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.e0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorGroupMainFragment.c2(this.f60911a, view);
                }
            });
        }
        h00.b0 b0Var5 = (h00.b0) getMViewBinding();
        if (b0Var5 != null && (appCompatImageView = b0Var5.f65730j) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.f0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorGroupMainFragment.d2(this.f60913a, view);
                }
            });
        }
        h00.b0 b0Var6 = (h00.b0) getMViewBinding();
        if (b0Var6 != null && (linearLayoutCompat = b0Var6.f65723b) != null) {
            linearLayoutCompat.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.g0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws InterruptedException {
                    DownloadReDetectorGroupMainFragment.e2(this.f60916a, view);
                }
            });
        }
        h00.b0 b0Var7 = (h00.b0) getMViewBinding();
        BLFrameLayout bLFrameLayout = b0Var7 != null ? b0Var7.f65727g : null;
        if (bLFrameLayout == null) {
            return;
        }
        bLFrameLayout.setVisibility(0);
    }

    public static /* synthetic */ void q2(DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment, int i11, int i12, String str, Integer num, int i13, boolean z11, int i14, Object obj) {
        if ((i14 & 8) != 0) {
            num = Integer.valueOf(downloadReDetectorGroupMainFragment.K);
        }
        downloadReDetectorGroupMainFragment.p2(i11, i12, str, num, (i14 & 16) != 0 ? 0 : i13, (i14 & 32) != 0 ? true : z11);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
    }

    public final void O1() {
    }

    public final void P1() {
        List<DownloadResolutionItem> resolutionList;
        DownloadListBean downloadListBeanF = T1().r().f();
        if (downloadListBeanF == null || (resolutionList = downloadListBeanF.getResolutionList()) == null) {
            return;
        }
        uo.b.a aVar = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        uo.b.a.o(aVar, TAG, new String[]{"checkSeason2RestResolution curSeason:" + this.K + ",resolutionList: :" + resolutionList}, false, 4, null);
        List<DownloadResolutionItem> listN2 = n2(resolutionList);
        if (listN2.size() <= 1) {
            Z1(listN2, 0);
            return;
        }
        Integer resolution = downloadListBeanF.getResolution();
        int iIntValue = resolution != null ? resolution.intValue() : 0;
        int i11 = -1;
        int i12 = RoomAppMMKV.f51271a.a().getInt("download_last_resolution", -1);
        Iterator<DownloadResolutionItem> it = listN2.iterator();
        int i13 = 0;
        while (true) {
            if (!it.hasNext()) {
                i13 = -1;
                break;
            }
            int resolution2 = it.next().getResolution();
            Integer num = this.P;
            if (num != null && resolution2 == num.intValue()) {
                break;
            } else {
                i13++;
            }
        }
        if (i13 < 0) {
            Iterator<DownloadResolutionItem> it2 = listN2.iterator();
            i13 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i13 = -1;
                    break;
                } else if (it2.next().getResolution() == i12) {
                    break;
                } else {
                    i13++;
                }
            }
        }
        if (i13 < 0 && iIntValue > 0) {
            Iterator<DownloadResolutionItem> it3 = listN2.iterator();
            int i14 = 0;
            while (it3.hasNext()) {
                if (it3.next().getResolution() == iIntValue) {
                    i11 = i14;
                    break;
                }
                i14++;
            }
            i13 = i11;
        }
        if (i13 < 0) {
            i13 = 0;
        }
        int i15 = 0;
        for (Object obj : listN2) {
            int i16 = i15 + 1;
            if (i15 < 0) {
                kotlin.collections.g.u();
            }
            ((DownloadResolutionItem) obj).setSelected(i15 == i13);
            i15 = i16;
        }
        Z1(listN2, i13);
    }

    public final DownloadReDetectorGroupFragment Q1(int i11, int i12, boolean z11) {
        final DownloadReDetectorGroupFragment downloadReDetectorGroupFragmentA = DownloadReDetectorGroupFragment.f60702d0.a(this.f60712v, this.f60713w, this.f60714x, this.f60715y, this.f60716z, this.A, this.B, Integer.valueOf(i11), i12, this.S, z11, this.K, this.M);
        downloadReDetectorGroupFragmentA.j2(new Function2<List<DownloadBean>, Boolean, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment$createNewFragment$1$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<DownloadBean> list, Boolean bool) {
                invoke(list, bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(List<DownloadBean> list, boolean z12) {
                Intrinsics.g(list, "list");
                this.this$0.l2(list, z12);
            }
        });
        downloadReDetectorGroupFragmentA.k2(new Function1<String, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment$createNewFragment$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                AppCompatTextView appCompatTextView;
                if (!downloadReDetectorGroupFragmentA.isAdded() || downloadReDetectorGroupFragmentA.isDetached() || downloadReDetectorGroupFragmentA.isRemoving()) {
                    return;
                }
                if (str == null || str.length() == 0) {
                    h00.b0 b0Var = (h00.b0) this.getMViewBinding();
                    appCompatTextView = b0Var != null ? b0Var.f65736p : null;
                    if (appCompatTextView == null) {
                        return;
                    }
                    appCompatTextView.setText(downloadReDetectorGroupFragmentA.getString(com.transsnet.downloader.R$string.str_download));
                    return;
                }
                h00.b0 b0Var2 = (h00.b0) this.getMViewBinding();
                appCompatTextView = b0Var2 != null ? b0Var2.f65736p : null;
                if (appCompatTextView == null) {
                    return;
                }
                String str2 = downloadReDetectorGroupFragmentA.getString(com.transsnet.downloader.R$string.str_download) + " · " + str;
                Intrinsics.f(str2, "toString(...)");
                appCompatTextView.setText(str2);
            }
        });
        downloadReDetectorGroupFragmentA.m2(new Function1<Boolean, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment$createNewFragment$1$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void invoke(boolean z12) {
                h00.b0 b0Var = (h00.b0) this.this$0.getMViewBinding();
                FrameLayout frameLayout = b0Var != null ? b0Var.f65728h : null;
                if (frameLayout == null) {
                    return;
                }
                frameLayout.setVisibility(z12 ? 0 : 8);
            }
        });
        downloadReDetectorGroupFragmentA.n2(new Function1<Boolean, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment$createNewFragment$1$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void invoke(boolean z12) {
                h00.b0 b0Var = (h00.b0) this.this$0.getMViewBinding();
                BLFrameLayout bLFrameLayout = b0Var != null ? b0Var.f65727g : null;
                if (bLFrameLayout == null) {
                    return;
                }
                bLFrameLayout.setVisibility(z12 ? 0 : 8);
            }
        });
        return downloadReDetectorGroupFragmentA;
    }

    public final void R1(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        HashMap map = new HashMap();
        map.put(WebConstants.PAGE_FROM, str2);
        map.put("subject_id", str3);
        map.put("post_id", str4);
        map.put("ops", str5);
        map.put("resource_id", str6);
        map.put("task_id", str7);
        map.put("module_name", this.C);
        com.transsion.baselib.report.m mVar = com.transsion.baselib.report.m.f51277a;
        if (str == null) {
            str = "download_click";
        }
        mVar.m(str, "download_click", map);
        Bundle bundle = new Bundle();
        bundle.putString("resource_id", str6);
        bundle.putString("subject_id", str3);
        FirebaseAnalyticsManager.f51235a.n("download_click", bundle, getContext());
    }

    public final com.transsnet.downloader.viewmodel.e S1() {
        return (com.transsnet.downloader.viewmodel.e) this.V.getValue();
    }

    public final DownloadResourcesDetectorViewModel T1() {
        return (DownloadResourcesDetectorViewModel) this.U.getValue();
    }

    public final StartDownloadHelper U1() {
        return (StartDownloadHelper) this.T.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: V1, reason: merged with bridge method [inline-methods] */
    public h00.b0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        h00.b0 b0VarC = h00.b0.c(inflater);
        Intrinsics.f(b0VarC, "inflate(inflater)");
        return b0VarC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void X1(List<DubsInfo> list, int i11) {
        DownloadResolutionTabView downloadResolutionTabView;
        DownloadResolutionTabView downloadResolutionTabView2;
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0;
        androidx.lifecycle.c0<DubsInfo> c0VarN;
        DownloadResolutionTabView downloadResolutionTabView3;
        h00.b0 b0Var = (h00.b0) getMViewBinding();
        if (b0Var != null && (downloadResolutionTabView3 = b0Var.f65745y) != null) {
            downloadResolutionTabView3.setAudioClickListener(new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment$initAudioTab$1
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
                    DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY1 = this.this$0.Y0();
                    androidx.lifecycle.c0<Integer> c0VarO = downloadResourcesDetectorViewModelY1 != null ? downloadResourcesDetectorViewModelY1.o() : null;
                    if (c0VarO == null) {
                        return;
                    }
                    c0VarO.q(9);
                }
            });
        }
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (downloadResourcesDetectorViewModelY0 = Y0()) != null && (c0VarN = downloadResourcesDetectorViewModelY0.n()) != null) {
            c0VarN.j(parentFragment, new c(new Function1<DubsInfo, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment$initAudioTab$2$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DubsInfo dubsInfo) {
                    invoke2(dubsInfo);
                    return Unit.f68710a;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DubsInfo dubsInfo) {
                    DownloadResolutionTabView downloadResolutionTabView4;
                    BLFrameLayout flLoading;
                    String subjectId = dubsInfo.getSubjectId();
                    if (subjectId != null) {
                        DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment = this.this$0;
                        h00.b0 b0Var2 = (h00.b0) downloadReDetectorGroupMainFragment.getMViewBinding();
                        if (b0Var2 != null && (flLoading = b0Var2.f65727g) != null) {
                            Intrinsics.f(flLoading, "flLoading");
                            so.c.k(flLoading);
                        }
                        downloadReDetectorGroupMainFragment.f60715y = subjectId;
                        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY1 = downloadReDetectorGroupMainFragment.Y0();
                        androidx.lifecycle.c0<String> c0VarF = downloadResourcesDetectorViewModelY1 != null ? downloadResourcesDetectorViewModelY1.f() : null;
                        if (c0VarF != null) {
                            c0VarF.q(subjectId);
                        }
                        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY2 = downloadReDetectorGroupMainFragment.Y0();
                        if (downloadResourcesDetectorViewModelY2 != null) {
                            downloadResourcesDetectorViewModelY2.t(subjectId);
                        }
                        h00.b0 b0Var3 = (h00.b0) downloadReDetectorGroupMainFragment.getMViewBinding();
                        if (b0Var3 == null || (downloadResolutionTabView4 = b0Var3.f65745y) == null) {
                            return;
                        }
                        downloadResolutionTabView4.updateAudioTrack(dubsInfo.getLanName());
                    }
                }
            }));
        }
        h00.b0 b0Var2 = (h00.b0) getMViewBinding();
        if (b0Var2 != null && (downloadResolutionTabView2 = b0Var2.f65745y) != null) {
            downloadResolutionTabView2.setAudioItemClickListener(new Function2<Integer, DubsInfo, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment$initAudioTab$3
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, DubsInfo dubsInfo) {
                    invoke(num.intValue(), dubsInfo);
                    return Unit.f68710a;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public final void invoke(int i12, DubsInfo item) {
                    BLFrameLayout flLoading;
                    Intrinsics.g(item, "item");
                    String subjectId = item.getSubjectId();
                    if (subjectId != null) {
                        DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment = this.this$0;
                        h00.b0 b0Var3 = (h00.b0) downloadReDetectorGroupMainFragment.getMViewBinding();
                        if (b0Var3 != null && (flLoading = b0Var3.f65727g) != null) {
                            Intrinsics.f(flLoading, "flLoading");
                            so.c.k(flLoading);
                        }
                        downloadReDetectorGroupMainFragment.f60715y = subjectId;
                        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY1 = downloadReDetectorGroupMainFragment.Y0();
                        androidx.lifecycle.c0<String> c0VarF = downloadResourcesDetectorViewModelY1 != null ? downloadResourcesDetectorViewModelY1.f() : null;
                        if (c0VarF != null) {
                            c0VarF.q(downloadReDetectorGroupMainFragment.f60715y);
                        }
                        downloadReDetectorGroupMainFragment.X0();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("initAudioTab: 切换音轨到:");
                        sb2.append(item);
                        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY2 = downloadReDetectorGroupMainFragment.Y0();
                        if (downloadResourcesDetectorViewModelY2 != null) {
                            downloadResourcesDetectorViewModelY2.t(subjectId);
                        }
                    }
                }
            });
        }
        h00.b0 b0Var3 = (h00.b0) getMViewBinding();
        if (b0Var3 == null || (downloadResolutionTabView = b0Var3.f65745y) == null) {
            return;
        }
        downloadResolutionTabView.setAudioContentData(list, i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y1(final List<com.transsnet.downloader.widget.c> list) {
        DownloadGridTabView downloadGridTabView;
        h00.b0 b0Var = (h00.b0) getMViewBinding();
        if (b0Var == null || (downloadGridTabView = b0Var.f65744x) == null) {
            return;
        }
        downloadGridTabView.setItemClickCallback(new Function2<Integer, com.transsnet.downloader.widget.c, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment$initEpisodeTab$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, com.transsnet.downloader.widget.c cVar) {
                invoke(num.intValue(), cVar);
                return Unit.f68710a;
            }

            public final void invoke(int i11, com.transsnet.downloader.widget.c item) {
                Intrinsics.g(item, "item");
                uo.b.a aVar = uo.b.f78622a;
                String TAG = this.this$0.X0();
                Intrinsics.f(TAG, "TAG");
                uo.b.a.f(aVar, TAG, "ep tab click, resolution:" + this.this$0.P + ", index:" + i11, false, 4, null);
                this.this$0.m2(list.get(i11).a());
                Integer num = this.this$0.P;
                if (num != null) {
                    DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment = this.this$0;
                    DownloadReDetectorGroupMainFragment.q2(downloadReDetectorGroupMainFragment, num.intValue(), downloadReDetectorGroupMainFragment.Q, downloadReDetectorGroupMainFragment.f60715y, null, i11, false, 40, null);
                }
            }
        });
        downloadGridTabView.setDataList(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z1(List<DownloadResolutionItem> list, int i11) {
        DownloadResolutionTabView downloadResolutionTabView;
        DownloadResolutionTabView downloadResolutionTabView2;
        h00.b0 b0Var = (h00.b0) getMViewBinding();
        if (b0Var != null && (downloadResolutionTabView2 = b0Var.f65745y) != null) {
            downloadResolutionTabView2.setResolutionItemClickListener(new Function2<Integer, DownloadResolutionItem, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment$initResolutionTab$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, DownloadResolutionItem downloadResolutionItem) {
                    invoke(num.intValue(), downloadResolutionItem);
                    return Unit.f68710a;
                }

                public final void invoke(int i12, DownloadResolutionItem item) {
                    Intrinsics.g(item, "item");
                    this.this$0.o2(item.getResolution());
                    DownloadReDetectorGroupMainFragment.q2(this.this$0, item.getResolution(), i12, this.this$0.f60715y, null, 0, false, 24, null);
                }
            });
        }
        h00.b0 b0Var2 = (h00.b0) getMViewBinding();
        if (b0Var2 == null || (downloadResolutionTabView = b0Var2.f65745y) == null) {
            return;
        }
        downloadResolutionTabView.setResolutionContentData(list, i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a2() {
        DownloadResolutionTabView downloadResolutionTabView;
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0;
        androidx.lifecycle.c0<Integer> c0VarY;
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (downloadResourcesDetectorViewModelY0 = Y0()) != null && (c0VarY = downloadResourcesDetectorViewModelY0.y()) != null) {
            c0VarY.j(parentFragment, new c(new Function1<Integer, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment$initSeasonTab$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.f68710a;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer season) {
                    Integer resolution;
                    DownloadResolutionTabView downloadResolutionTabView2;
                    h00.b0 b0Var = (h00.b0) this.this$0.getMViewBinding();
                    if (b0Var != null && (downloadResolutionTabView2 = b0Var.f65745y) != null) {
                        Intrinsics.f(season, "season");
                        downloadResolutionTabView2.setSeason(season.intValue());
                    }
                    DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment = this.this$0;
                    Integer num = downloadReDetectorGroupMainFragment.P;
                    DownloadReDetectorGroupMainFragment.q2(downloadReDetectorGroupMainFragment, num != null ? num.intValue() : 360, this.this$0.Q, this.this$0.f60715y, season, 0, false, 16, null);
                    this.this$0.P1();
                    DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment2 = this.this$0;
                    DownloadListBean downloadListBeanF = downloadReDetectorGroupMainFragment2.T1().r().f();
                    downloadReDetectorGroupMainFragment2.o2((downloadListBeanF == null || (resolution = downloadListBeanF.getResolution()) == null) ? RoomAppMMKV.f51271a.a().getInt("download_last_resolution", 0) : resolution.intValue());
                }
            }));
        }
        h00.b0 b0Var = (h00.b0) getMViewBinding();
        if (b0Var == null || (downloadResolutionTabView = b0Var.f65745y) == null) {
            return;
        }
        downloadResolutionTabView.setSeasonClickListener(new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment$initSeasonTab$2
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
                DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY1 = this.this$0.Y0();
                androidx.lifecycle.c0<Integer> c0VarO = downloadResourcesDetectorViewModelY1 != null ? downloadResourcesDetectorViewModelY1.o() : null;
                if (c0VarO == null) {
                    return;
                }
                c0VarO.q(8);
            }
        });
    }

    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment
    public void b1() {
        super.b1();
    }

    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment
    public void c1() {
        super.c1();
    }

    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment
    public void d1() {
        super.d1();
    }

    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment
    public void e1() {
        super.e1();
    }

    public final void f2() {
        if (this.O.isEmpty()) {
            return;
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = Y0();
        androidx.lifecycle.c0<com.transsnet.downloader.viewmodel.b> c0VarH = downloadResourcesDetectorViewModelY0 != null ? downloadResourcesDetectorViewModelY0.h() : null;
        if (c0VarH != null) {
            int size = this.O.size();
            String str = this.G;
            DownloadBean downloadBean = this.O.get(0);
            Intrinsics.f(downloadBean, "checkedList[0]");
            c0VarH.q(new com.transsnet.downloader.viewmodel.b(size, str, downloadBean, false));
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY1 = Y0();
        androidx.lifecycle.c0<Integer> c0VarO = downloadResourcesDetectorViewModelY1 != null ? downloadResourcesDetectorViewModelY1.o() : null;
        if (c0VarO == null) {
            return;
        }
        c0VarO.q(3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g2() {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        AppCompatTextView appCompatTextView;
        AppCompatImageView appCompatImageView;
        View view;
        FrameLayout frameLayout;
        S1().b().q(Boolean.FALSE);
        if (a1(this.F)) {
            return;
        }
        h00.b0 b0Var = (h00.b0) getMViewBinding();
        if (b0Var != null && (frameLayout = b0Var.f65728h) != null && frameLayout.getVisibility() == 0) {
            uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"DownloadReDetectorGroupMainFragment --> onDownload() --> 当前正在全选中"}, true);
            return;
        }
        uo.b.a aVar = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "onDownload ", false, 4, null);
        h00.b0 b0Var2 = (h00.b0) getMViewBinding();
        if (b0Var2 != null && (view = b0Var2.f65743w) != null) {
            so.c.k(view);
        }
        h00.b0 b0Var3 = (h00.b0) getMViewBinding();
        if (b0Var3 != null && (appCompatImageView = b0Var3.f65729i) != null) {
            so.c.g(appCompatImageView);
        }
        h00.b0 b0Var4 = (h00.b0) getMViewBinding();
        if (b0Var4 != null && (appCompatTextView = b0Var4.f65736p) != null) {
            so.c.g(appCompatTextView);
        }
        h00.b0 b0Var5 = (h00.b0) getMViewBinding();
        if (b0Var5 != null && (progressBar2 = b0Var5.f65734n) != null) {
            so.c.k(progressBar2);
        }
        int i11 = 0;
        for (Object obj : this.O) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.g.u();
            }
            DownloadBean downloadBean = (DownloadBean) obj;
            String string = UUID.randomUUID().toString();
            Intrinsics.f(string, "randomUUID().toString()");
            downloadBean.setTaskId(string);
            R1(this.f60712v, this.f60713w, downloadBean.getSubjectId(), downloadBean.getPostId(), this.A, downloadBean.getResourceId(), string);
            uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"剧集多资源，下载点击，开始下载: subjectId = " + downloadBean.getSubjectId() + ",resourceId = " + downloadBean.getResourceId() + ", name = " + downloadBean.getTotalTitleName()}, true);
            i11 = i12;
        }
        U0().D(this.O);
        U1().d(this.O);
        kotlinx.coroutines.j.d(this.H, null, null, new DownloadReDetectorGroupMainFragment$onDownload$2(this, null), 3, null);
        long size = ((long) ((this.O.size() / 20) * 100)) + 300;
        h00.b0 b0Var6 = (h00.b0) getMViewBinding();
        if (b0Var6 == null || (progressBar = b0Var6.f65734n) == null) {
            return;
        }
        progressBar.postDelayed(new Runnable() { // from class: com.transsnet.downloader.fragment.h0
            @Override // java.lang.Runnable
            public final void run() {
                DownloadReDetectorGroupMainFragment.h2(this.f60919a);
            }
        }, size);
    }

    public final void i2(DownloadListBean downloadListBean) {
        List<DownloadResolutionItem> resolutionList;
        if (downloadListBean == null || (resolutionList = downloadListBean.getResolutionList()) == null) {
            return;
        }
        if (this.L == null) {
            Integer resolution = downloadListBean.getResolution();
            o2(resolution != null ? resolution.intValue() : RoomAppMMKV.f51271a.a().getInt("download_last_resolution", 0));
        }
        uo.b.a aVar = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "onGetDefResolutionData 首次，curSeason:" + this.K + ",resolutionList: :" + resolutionList, false, 4, null);
        List<DownloadResolutionItem> listN2 = n2(resolutionList);
        a2();
        if (listN2.size() <= 1) {
            Z1(listN2, 0);
            this.S = true;
            Integer resolution2 = downloadListBean.getResolution();
            q2(this, resolution2 != null ? resolution2.intValue() : 0, 0, this.f60715y, null, 0, false, 56, null);
            return;
        }
        this.S = false;
        Integer resolution3 = downloadListBean.getResolution();
        int iIntValue = resolution3 != null ? resolution3.intValue() : 0;
        int i11 = -1;
        int i12 = RoomAppMMKV.f51271a.a().getInt("download_last_resolution", -1);
        Iterator<DownloadResolutionItem> it = listN2.iterator();
        int i13 = 0;
        while (true) {
            if (!it.hasNext()) {
                i13 = -1;
                break;
            } else if (it.next().getResolution() == i12) {
                break;
            } else {
                i13++;
            }
        }
        if (i13 < 0 && iIntValue > 0) {
            Iterator<DownloadResolutionItem> it2 = listN2.iterator();
            int i14 = 0;
            while (it2.hasNext()) {
                if (it2.next().getResolution() == iIntValue) {
                    i11 = i14;
                    break;
                }
                i14++;
            }
            i13 = i11;
        }
        int i15 = i13 < 0 ? 0 : i13;
        int resolution4 = 0;
        int i16 = 0;
        for (Object obj : listN2) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                kotlin.collections.g.u();
            }
            DownloadResolutionItem downloadResolutionItem = (DownloadResolutionItem) obj;
            if (i16 == i15) {
                resolution4 = downloadResolutionItem.getResolution();
                downloadResolutionItem.setSelected(true);
            } else {
                downloadResolutionItem.setSelected(false);
            }
            i16 = i17;
        }
        Z1(listN2, i15);
        q2(this, resolution4, i15, this.f60715y, null, 0, false, 56, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        String subjectId;
        androidx.lifecycle.c0<DubsInfoData> c0VarM;
        androidx.lifecycle.c0<ResourcesSeasonList> c0VarX;
        h00.b0 b0Var;
        DownloadResolutionTabView downloadResolutionTabView;
        final int i11 = RoomAppMMKV.f51271a.a().getInt("download_last_resolution", 0);
        Subject subject = this.f60714x;
        if (subject != null && (b0Var = (h00.b0) getMViewBinding()) != null && (downloadResolutionTabView = b0Var.f65745y) != null) {
            downloadResolutionTabView.setSubject(subject);
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = Y0();
        if (downloadResourcesDetectorViewModelY0 != null && (c0VarX = downloadResourcesDetectorViewModelY0.x()) != null) {
            c0VarX.j(this, new c(new Function1<ResourcesSeasonList, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment.initViewModel.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ResourcesSeasonList resourcesSeasonList) {
                    invoke2(resourcesSeasonList);
                    return Unit.f68710a;
                }

                /* JADX WARN: Code duplicated, block: B:25:0x00f4  */
                /* JADX WARN: Code duplicated, block: B:27:0x00fa  */
                /* JADX WARN: Code duplicated, block: B:32:0x010d  */
                /* JADX WARN: Code duplicated, block: B:34:0x0113  */
                /* JADX WARN: Code duplicated, block: B:37:0x011c  */
                /* JADX WARN: Code duplicated, block: B:38:0x0121  */
                /* JADX WARN: Code duplicated, block: B:41:0x0125  */
                /* JADX WARN: Code duplicated, block: B:44:0x0145  */
                /* JADX WARN: Code duplicated, block: B:48:0x0170  */
                /* JADX WARN: Code duplicated, block: B:51:0x0177  */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ResourcesSeasonList resourcesSeasonList) {
                    List<ResourcesSeason> seasons;
                    Subject subject2;
                    androidx.lifecycle.c0<Integer> c0VarG;
                    Integer subjectType;
                    DownloadResolutionTabView downloadResolutionTabView2;
                    DownloadResolutionTabView downloadResolutionTabView3;
                    DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY1;
                    androidx.lifecycle.c0<Integer> c0VarG2;
                    BLFrameLayout bLFrameLayout;
                    uo.b.a aVar = uo.b.f78622a;
                    String TAG = DownloadReDetectorGroupMainFragment.this.X0();
                    Intrinsics.f(TAG, "TAG");
                    uo.b.a.f(aVar, TAG, "获取当前季跟分辨率的信息,resolution:" + i11 + "， , curSeason:" + DownloadReDetectorGroupMainFragment.this.K, false, 4, null);
                    Subject subject3 = DownloadReDetectorGroupMainFragment.this.f60714x;
                    if (subject3 != null) {
                        subject3.setSubjectType(resourcesSeasonList != null ? resourcesSeasonList.getSubjectType() : null);
                    }
                    h00.b0 b0Var2 = (h00.b0) DownloadReDetectorGroupMainFragment.this.getMViewBinding();
                    if (b0Var2 != null && (bLFrameLayout = b0Var2.f65727g) != null) {
                        so.c.g(bLFrameLayout);
                    }
                    if (resourcesSeasonList == null || (seasons = resourcesSeasonList.getSeasons()) == null) {
                        return;
                    }
                    DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment = DownloadReDetectorGroupMainFragment.this;
                    int i12 = i11;
                    Pair<Integer, Integer> pairT = DownloadUtil.f61136a.t(seasons, downloadReDetectorGroupMainFragment.K, i12);
                    int iIntValue = pairT.getFirst().intValue();
                    int iIntValue2 = pairT.getSecond().intValue();
                    int iG = kotlin.ranges.a.g(iIntValue2 + 19, iIntValue);
                    String TAG2 = downloadReDetectorGroupMainFragment.X0();
                    Intrinsics.f(TAG2, "TAG");
                    uo.b.a.f(aVar, TAG2, "加载第一刷数据，curSeason:" + downloadReDetectorGroupMainFragment.K + ", start:" + iIntValue2 + ", end:" + iG + ", total:" + iIntValue + ", resolution:" + i12 + "， audioChannel", false, 4, null);
                    Subject subject4 = downloadReDetectorGroupMainFragment.f60714x;
                    if (subject4 != null) {
                        Integer subjectType2 = subject4.getSubjectType();
                        int value = SubjectType.TV.getValue();
                        if (subjectType2 != null && subjectType2.intValue() == value) {
                            if (downloadReDetectorGroupMainFragment.J <= 0) {
                                downloadReDetectorGroupMainFragment.J = 1;
                            }
                            downloadResourcesDetectorViewModelY1 = downloadReDetectorGroupMainFragment.Y0();
                            if (downloadResourcesDetectorViewModelY1 != null) {
                                c0VarG2 = downloadResourcesDetectorViewModelY1.g();
                            } else {
                                c0VarG2 = null;
                            }
                            if (c0VarG2 != null) {
                                c0VarG2.q(Integer.valueOf(downloadReDetectorGroupMainFragment.J));
                            }
                            downloadReDetectorGroupMainFragment.K = downloadReDetectorGroupMainFragment.J;
                            DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelT1 = downloadReDetectorGroupMainFragment.T1();
                            String str = downloadReDetectorGroupMainFragment.f60715y;
                            Subject subject5 = downloadReDetectorGroupMainFragment.f60714x;
                            downloadResourcesDetectorViewModelT1.i(str, (920 & 2) != 0 ? "" : subject5 != null ? subject5.getTitle() : null, (920 & 4) != 0 ? 0 : 0, (920 & 8) != 0 ? "1" : null, (920 & 16) != 0 ? 20 : 1, (920 & 32) != 0 ? 1 : 0, (920 & 64) != 0 ? 1 : 0, (920 & 128) != 0 ? 1 : 0, (920 & 256) != 0 ? 1 : 0, (920 & 512) == 0 ? 0 : 1, (920 & 1024) != 0 ? RoomAppMMKV.f51271a.a().getInt("download_last_resolution", 0) : i12);
                        } else {
                            subject2 = downloadReDetectorGroupMainFragment.f60714x;
                            if (subject2 != null) {
                                subjectType = subject2.getSubjectType();
                                int value2 = SubjectType.EDUCATION.getValue();
                                if (subjectType != null && subjectType.intValue() == value2) {
                                    if (downloadReDetectorGroupMainFragment.J <= 0) {
                                        downloadReDetectorGroupMainFragment.J = 1;
                                    }
                                    downloadResourcesDetectorViewModelY1 = downloadReDetectorGroupMainFragment.Y0();
                                    if (downloadResourcesDetectorViewModelY1 != null) {
                                        c0VarG2 = downloadResourcesDetectorViewModelY1.g();
                                    } else {
                                        c0VarG2 = null;
                                    }
                                    if (c0VarG2 != null) {
                                        c0VarG2.q(Integer.valueOf(downloadReDetectorGroupMainFragment.J));
                                    }
                                    downloadReDetectorGroupMainFragment.K = downloadReDetectorGroupMainFragment.J;
                                    DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelT2 = downloadReDetectorGroupMainFragment.T1();
                                    String str2 = downloadReDetectorGroupMainFragment.f60715y;
                                    Subject subject6 = downloadReDetectorGroupMainFragment.f60714x;
                                    downloadResourcesDetectorViewModelT2.i(str2, (920 & 2) != 0 ? "" : subject6 != null ? subject6.getTitle() : null, (920 & 4) != 0 ? 0 : 0, (920 & 8) != 0 ? "1" : null, (920 & 16) != 0 ? 20 : 1, (920 & 32) != 0 ? 1 : 0, (920 & 64) != 0 ? 1 : 0, (920 & 128) != 0 ? 1 : 0, (920 & 256) != 0 ? 1 : 0, (920 & 512) == 0 ? 0 : 1, (920 & 1024) != 0 ? RoomAppMMKV.f51271a.a().getInt("download_last_resolution", 0) : i12);
                                }
                            }
                            downloadReDetectorGroupMainFragment.K = 0;
                            DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY2 = downloadReDetectorGroupMainFragment.Y0();
                            c0VarG = downloadResourcesDetectorViewModelY2 != null ? downloadResourcesDetectorViewModelY2.g() : null;
                            if (c0VarG != null) {
                                c0VarG.q(0);
                            }
                            downloadReDetectorGroupMainFragment.S = true;
                            DownloadReDetectorGroupMainFragment.q2(downloadReDetectorGroupMainFragment, 0, 0, downloadReDetectorGroupMainFragment.f60715y, null, 0, false, 56, null);
                        }
                    } else {
                        subject2 = downloadReDetectorGroupMainFragment.f60714x;
                        if (subject2 != null) {
                            subjectType = subject2.getSubjectType();
                            int value3 = SubjectType.EDUCATION.getValue();
                            if (subjectType != null) {
                                if (downloadReDetectorGroupMainFragment.J <= 0) {
                                    downloadReDetectorGroupMainFragment.J = 1;
                                }
                                downloadResourcesDetectorViewModelY1 = downloadReDetectorGroupMainFragment.Y0();
                                if (downloadResourcesDetectorViewModelY1 != null) {
                                    c0VarG2 = downloadResourcesDetectorViewModelY1.g();
                                } else {
                                    c0VarG2 = null;
                                }
                                if (c0VarG2 != null) {
                                    c0VarG2.q(Integer.valueOf(downloadReDetectorGroupMainFragment.J));
                                }
                                downloadReDetectorGroupMainFragment.K = downloadReDetectorGroupMainFragment.J;
                                DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelT3 = downloadReDetectorGroupMainFragment.T1();
                                String str3 = downloadReDetectorGroupMainFragment.f60715y;
                                Subject subject7 = downloadReDetectorGroupMainFragment.f60714x;
                                downloadResourcesDetectorViewModelT3.i(str3, (920 & 2) != 0 ? "" : subject7 != null ? subject7.getTitle() : null, (920 & 4) != 0 ? 0 : 0, (920 & 8) != 0 ? "1" : null, (920 & 16) != 0 ? 20 : 1, (920 & 32) != 0 ? 1 : 0, (920 & 64) != 0 ? 1 : 0, (920 & 128) != 0 ? 1 : 0, (920 & 256) != 0 ? 1 : 0, (920 & 512) == 0 ? 0 : 1, (920 & 1024) != 0 ? RoomAppMMKV.f51271a.a().getInt("download_last_resolution", 0) : i12);
                            }
                        }
                        downloadReDetectorGroupMainFragment.K = 0;
                        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY3 = downloadReDetectorGroupMainFragment.Y0();
                        if (downloadResourcesDetectorViewModelY3 != null) {
                        }
                        if (c0VarG != null) {
                            c0VarG.q(0);
                        }
                        downloadReDetectorGroupMainFragment.S = true;
                        DownloadReDetectorGroupMainFragment.q2(downloadReDetectorGroupMainFragment, 0, 0, downloadReDetectorGroupMainFragment.f60715y, null, 0, false, 56, null);
                    }
                    h00.b0 b0Var3 = (h00.b0) downloadReDetectorGroupMainFragment.getMViewBinding();
                    if (b0Var3 != null && (downloadResolutionTabView3 = b0Var3.f65745y) != null) {
                        downloadResolutionTabView3.setSeasons(seasons.size());
                    }
                    h00.b0 b0Var4 = (h00.b0) downloadReDetectorGroupMainFragment.getMViewBinding();
                    if (b0Var4 == null || (downloadResolutionTabView2 = b0Var4.f65745y) == null) {
                        return;
                    }
                    downloadResolutionTabView2.setSeason(downloadReDetectorGroupMainFragment.K);
                }
            }));
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY1 = Y0();
        if (downloadResourcesDetectorViewModelY1 != null && (c0VarM = downloadResourcesDetectorViewModelY1.m()) != null) {
            c0VarM.j(this, new c(new Function1<DubsInfoData, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment.initViewModel.3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DubsInfoData dubsInfoData) {
                    invoke2(dubsInfoData);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DubsInfoData dubsInfoData) {
                    List<DubsInfo> dubs;
                    String subjectId2;
                    DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY2;
                    DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY3;
                    if (dubsInfoData == null || (dubs = dubsInfoData.getDubs()) == null) {
                        return;
                    }
                    DownloadReDetectorGroupMainFragment downloadReDetectorGroupMainFragment = DownloadReDetectorGroupMainFragment.this;
                    int iIndexOf = 0;
                    if (dubs.isEmpty()) {
                        String str = downloadReDetectorGroupMainFragment.f60715y;
                        if (str != null && (downloadResourcesDetectorViewModelY3 = downloadReDetectorGroupMainFragment.Y0()) != null) {
                            downloadResourcesDetectorViewModelY3.t(str);
                        }
                    } else {
                        Subject subject2 = downloadReDetectorGroupMainFragment.f60714x;
                        Object obj = null;
                        downloadReDetectorGroupMainFragment.f60715y = subject2 != null ? subject2.getSubjectId() : null;
                        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY4 = downloadReDetectorGroupMainFragment.Y0();
                        androidx.lifecycle.c0<String> c0VarF = downloadResourcesDetectorViewModelY4 != null ? downloadResourcesDetectorViewModelY4.f() : null;
                        if (c0VarF != null) {
                            c0VarF.q(downloadReDetectorGroupMainFragment.f60715y);
                        }
                        for (Object obj2 : dubs) {
                            String subjectId3 = ((DubsInfo) obj2).getSubjectId();
                            Subject subject3 = downloadReDetectorGroupMainFragment.f60714x;
                            if (Intrinsics.b(subjectId3, subject3 != null ? subject3.getSubjectId() : null)) {
                                obj = obj2;
                                break;
                            }
                        }
                        DubsInfo dubsInfo = (DubsInfo) obj;
                        if (dubsInfo != null) {
                            dubsInfo.setSelected(true);
                            iIndexOf = dubs.indexOf(dubsInfo);
                        }
                        Subject subject4 = downloadReDetectorGroupMainFragment.f60714x;
                        if (subject4 != null && (subjectId2 = subject4.getSubjectId()) != null && (downloadResourcesDetectorViewModelY2 = downloadReDetectorGroupMainFragment.Y0()) != null) {
                            downloadResourcesDetectorViewModelY2.t(subjectId2);
                        }
                    }
                    downloadReDetectorGroupMainFragment.X1(CollectionsKt___CollectionsKt.M0(dubs), iIndexOf);
                }
            }));
        }
        T1().r().j(this, new c(new Function1<DownloadListBean, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorGroupMainFragment.initViewModel.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DownloadListBean downloadListBean) {
                invoke2(downloadListBean);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadListBean downloadListBean) {
                DownloadReDetectorGroupMainFragment.this.i2(downloadListBean);
            }
        }));
        Subject subject2 = this.f60714x;
        if (subject2 != null && (subjectId = subject2.getSubjectId()) != null) {
            this.f60715y = subjectId;
            DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY2 = Y0();
            androidx.lifecycle.c0<String> c0VarF = downloadResourcesDetectorViewModelY2 != null ? downloadResourcesDetectorViewModelY2.f() : null;
            if (c0VarF != null) {
                c0VarF.q(this.f60715y);
            }
            DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY3 = Y0();
            if (downloadResourcesDetectorViewModelY3 != null) {
                downloadResourcesDetectorViewModelY3.s(subjectId);
            }
        }
        getParentFragment();
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY4 = Y0();
        if (downloadResourcesDetectorViewModelY4 != null) {
            downloadResourcesDetectorViewModelY4.u();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j2() {
        h00.b0 b0Var;
        AppCompatImageView appCompatImageView;
        DownloadReDetectorGroupFragment downloadReDetectorGroupFragment = this.I;
        if ((downloadReDetectorGroupFragment != null && !downloadReDetectorGroupFragment.c2()) || (b0Var = (h00.b0) getMViewBinding()) == null || (appCompatImageView = b0Var.f65730j) == null) {
            return;
        }
        appCompatImageView.setSelected(!appCompatImageView.isSelected());
        boolean zIsSelected = appCompatImageView.isSelected();
        this.E = zIsSelected;
        DownloadReDetectorGroupFragment downloadReDetectorGroupFragment2 = this.I;
        if (downloadReDetectorGroupFragment2 != null) {
            downloadReDetectorGroupFragment2.f2(zIsSelected);
        }
    }

    public final void k2() {
        DownloadReDetectorGroupFragment downloadReDetectorGroupFragment;
        if (this.E || (downloadReDetectorGroupFragment = this.I) == null || !downloadReDetectorGroupFragment.X1()) {
            j2();
            return;
        }
        IMemberApi iMemberApi = (IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class);
        DownloadReDetectorGroupFragment downloadReDetectorGroupFragment2 = this.I;
        iMemberApi.i(downloadReDetectorGroupFragment2 != null ? downloadReDetectorGroupFragment2.U1() : null, new b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l2(List<DownloadBean> list, boolean z11) {
        AppCompatImageView appCompatImageView;
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        this.O.clear();
        List<DownloadBean> list2 = list;
        this.O.addAll(list2);
        uo.b.a.f(uo.b.f78622a, "zxb_log", "DownloadReDetectorGroupMainFragment --> onSelectData() --> checkedList.size = " + this.O.size(), false, 4, null);
        long jLongValue = 0L;
        for (DownloadBean downloadBean : list) {
            if (!downloadBean.isUnable()) {
                Long size = downloadBean.getSize();
                jLongValue += size != null ? size.longValue() : 0L;
            }
        }
        this.F = jLongValue;
        if (jLongValue == 0) {
            h00.b0 b0Var = (h00.b0) getMViewBinding();
            AppCompatTextView appCompatTextView = b0Var != null ? b0Var.f65736p : null;
            if (appCompatTextView != null) {
                appCompatTextView.setText(getString(com.transsnet.downloader.R$string.str_download));
            }
            h00.b0 b0Var2 = (h00.b0) getMViewBinding();
            appCompatImageView = b0Var2 != null ? b0Var2.f65730j : null;
            if (appCompatImageView != null) {
                appCompatImageView.setSelected(false);
            }
            DownloadReDetectorGroupFragment downloadReDetectorGroupFragment = this.I;
            if (downloadReDetectorGroupFragment != null) {
                downloadReDetectorGroupFragment.l2(false);
            }
        } else {
            this.G = tp.a.a(jLongValue, 1);
            h00.b0 b0Var3 = (h00.b0) getMViewBinding();
            AppCompatTextView appCompatTextView2 = b0Var3 != null ? b0Var3.f65736p : null;
            if (appCompatTextView2 != null) {
                String str = getString(com.transsnet.downloader.R$string.str_download) + " · " + this.G;
                Intrinsics.f(str, "toString(...)");
                appCompatTextView2.setText(str);
            }
            h00.b0 b0Var4 = (h00.b0) getMViewBinding();
            appCompatImageView = b0Var4 != null ? b0Var4.f65730j : null;
            if (appCompatImageView != null) {
                appCompatImageView.setSelected(z11);
            }
            DownloadReDetectorGroupFragment downloadReDetectorGroupFragment2 = this.I;
            if (downloadReDetectorGroupFragment2 != null) {
                downloadReDetectorGroupFragment2.l2(z11);
            }
        }
        if (!list2.isEmpty()) {
            this.P = Integer.valueOf(((DownloadBean) CollectionsKt___CollectionsKt.q0(list)).getResolution());
        }
    }

    public final void m2(String str) {
        com.transsion.baselib.report.m mVar = com.transsion.baselib.report.m.f51277a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(WebConstants.PAGE_FROM, this.f60712v);
        linkedHashMap.put("type", "episode_tab");
        linkedHashMap.put(CampaignEx.JSON_KEY_TITLE, str);
        Unit unit = Unit.f68710a;
        mVar.m(DownloadBaseRunnable.TAG, "click", linkedHashMap);
    }

    public final List<DownloadResolutionItem> n2(List<DownloadResolutionItem> list) {
        androidx.lifecycle.c0<ResourcesSeasonList> c0VarX;
        ResourcesSeasonList resourcesSeasonListF;
        List<ResourcesSeason> seasons;
        Object next;
        ArrayList arrayList = new ArrayList();
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = Y0();
        if (downloadResourcesDetectorViewModelY0 != null && (c0VarX = downloadResourcesDetectorViewModelY0.x()) != null && (resourcesSeasonListF = c0VarX.f()) != null && (seasons = resourcesSeasonListF.getSeasons()) != null) {
            Iterator<T> it = seasons.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (((ResourcesSeason) next).getSe() != this.K);
            ResourcesSeason resourcesSeason = (ResourcesSeason) next;
            if (resourcesSeason != null) {
                List<ResolutionItem> resolutions = resourcesSeason.getResolutions();
                if (resolutions == null || resolutions.isEmpty()) {
                    return list;
                }
                List<ResolutionItem> resolutions2 = resourcesSeason.getResolutions();
                if (resolutions2 != null && resolutions2.size() == list.size()) {
                    return list;
                }
                List<ResolutionItem> resolutions3 = resourcesSeason.getResolutions();
                if (resolutions3 != null) {
                    for (ResolutionItem resolutionItem : resolutions3) {
                        for (DownloadResolutionItem downloadResolutionItem : list) {
                            if (resolutionItem.getResolution() == downloadResolutionItem.getResolution()) {
                                arrayList.add(downloadResolutionItem);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return arrayList.isEmpty() ? list : arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00b0  */
    /* JADX WARN: Multi-variable type inference failed */
    public final void o2(int i11) {
        DownloadGridTabView downloadGridTabView;
        DownloadResolutionTabView downloadResolutionTabView;
        DownloadGridTabView downloadGridTabView2;
        androidx.lifecycle.c0<ResourcesSeasonList> c0VarX;
        ResourcesSeasonList resourcesSeasonListF;
        List<ResourcesSeason> seasons;
        Object next;
        List<ResolutionItem> resolutions;
        ResolutionItem resolutionItem;
        Object next2;
        Object next3;
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = Y0();
        if (downloadResourcesDetectorViewModelY0 != null && (c0VarX = downloadResourcesDetectorViewModelY0.x()) != null && (resourcesSeasonListF = c0VarX.f()) != null && (seasons = resourcesSeasonListF.getSeasons()) != null) {
            Iterator<T> it = seasons.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (((ResourcesSeason) next).getSe() != this.K);
            ResourcesSeason resourcesSeason = (ResourcesSeason) next;
            if (resourcesSeason != null) {
                if (i11 == 0) {
                    List<ResolutionItem> resolutions2 = resourcesSeason.getResolutions();
                    if (resolutions2 != null) {
                        Iterator<T> it2 = resolutions2.iterator();
                        if (it2.hasNext()) {
                            next3 = it2.next();
                            if (it2.hasNext()) {
                                int epNum = ((ResolutionItem) next3).getEpNum();
                                do {
                                    Object next4 = it2.next();
                                    int epNum2 = ((ResolutionItem) next4).getEpNum();
                                    if (epNum < epNum2) {
                                        next3 = next4;
                                        epNum = epNum2;
                                    }
                                } while (it2.hasNext());
                            }
                        } else {
                            next3 = null;
                        }
                        ResolutionItem resolutionItem2 = (ResolutionItem) next3;
                        if (resolutionItem2 != null) {
                            this.N = resolutionItem2.getEpNum();
                        }
                    }
                } else {
                    List<ResolutionItem> resolutions3 = resourcesSeason.getResolutions();
                    if (resolutions3 != null) {
                        Iterator<T> it3 = resolutions3.iterator();
                        do {
                            if (!it3.hasNext()) {
                                next2 = null;
                                break;
                            }
                            next2 = it3.next();
                        } while (i11 != ((ResolutionItem) next2).getResolution());
                        ResolutionItem resolutionItem3 = (ResolutionItem) next2;
                        if (resolutionItem3 != null) {
                            this.N = resolutionItem3.getEpNum();
                        } else {
                            resolutions = resourcesSeason.getResolutions();
                            if (resolutions != null && (resolutionItem = (ResolutionItem) CollectionsKt___CollectionsKt.g0(resolutions)) != null) {
                                this.N = resolutionItem.getEpNum();
                            }
                        }
                    } else {
                        resolutions = resourcesSeason.getResolutions();
                        if (resolutions != null) {
                            this.N = resolutionItem.getEpNum();
                        }
                    }
                }
            }
        }
        int i12 = (this.N + 49) / 50;
        if (i12 <= 1) {
            h00.b0 b0Var = (h00.b0) getMViewBinding();
            if (b0Var == null || (downloadGridTabView2 = b0Var.f65744x) == null) {
                return;
            }
            so.c.g(downloadGridTabView2);
            return;
        }
        uo.b.a aVar = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "setSeasonOrEpTitleTab, totalEpisode:" + this.N + ", titleCount:" + i12, false, 4, null);
        h00.b0 b0Var2 = (h00.b0) getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (b0Var2 == null || (downloadResolutionTabView = b0Var2.f65745y) == null) ? null : downloadResolutionTabView.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.bottomMargin = com.blankj.utilcode.util.f0.a(12.0f);
        }
        h00.b0 b0Var3 = (h00.b0) getMViewBinding();
        if (b0Var3 != null && (downloadGridTabView = b0Var3.f65744x) != null) {
            so.c.k(downloadGridTabView);
        }
        ArrayList arrayList = new ArrayList();
        int i13 = 0;
        while (i13 < i12) {
            int i14 = i13 * 50;
            arrayList.add(new com.transsnet.downloader.widget.c((i14 + 1) + "-" + kotlin.ranges.a.g(i14 + 50, this.N), i13 == 0));
            i13++;
        }
        Y1(arrayList);
    }

    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment, com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        String string;
        String string2;
        HashMap<String, String> mapG;
        HashMap<String, String> mapG2;
        HashMap<String, String> mapG3;
        HashMap<String, String> mapG4;
        HashMap<String, String> mapG5;
        String string3;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        String string4 = arguments != null ? arguments.getString("extra_page_from") : null;
        String str = "";
        if (string4 == null) {
            string4 = "";
        }
        this.f60712v = string4;
        Bundle arguments2 = getArguments();
        String string5 = arguments2 != null ? arguments2.getString("extra_last_page_from") : null;
        if (string5 == null) {
            string5 = "";
        }
        this.f60713w = string5;
        Bundle arguments3 = getArguments();
        this.f60714x = (Subject) (arguments3 != null ? arguments3.getSerializable("extra_subject") : null);
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (string = arguments4.getString("extra_ops")) == null) {
            string = "";
        }
        this.A = string;
        Bundle arguments5 = getArguments();
        if (arguments5 == null || (string2 = arguments5.getString("extra_target_resource_id")) == null) {
            string2 = "";
        }
        this.B = string2;
        Bundle arguments6 = getArguments();
        if (arguments6 != null && (string3 = arguments6.getString("extra_module_name")) != null) {
            str = string3;
        }
        this.C = str;
        Bundle arguments7 = getArguments();
        this.J = arguments7 != null ? arguments7.getInt("extra_season") : 0;
        Bundle arguments8 = getArguments();
        this.D = arguments8 != null ? arguments8.getBoolean("extra_dialog_style") : true;
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (mapG5 = logViewConfig.g()) != null) {
            mapG5.put(WebConstants.PAGE_FROM, this.f60712v);
        }
        com.transsion.baselib.report.h logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null && (mapG4 = logViewConfig2.g()) != null) {
            mapG4.put("last_page_from", this.f60713w);
        }
        com.transsion.baselib.report.h logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 != null && (mapG3 = logViewConfig3.g()) != null) {
            Subject subject = this.f60714x;
            mapG3.put("subject_id", subject != null ? subject.getSubjectId() : null);
        }
        com.transsion.baselib.report.h logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 != null && (mapG2 = logViewConfig4.g()) != null) {
            mapG2.put("ops", this.A);
        }
        com.transsion.baselib.report.h logViewConfig5 = getLogViewConfig();
        if (logViewConfig5 == null || (mapG = logViewConfig5.g()) == null) {
            return;
        }
        mapG.put("type", "2");
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        DownloadListManager.a aVar = DownloadListManager.f61186m;
        aVar.a().K(null);
        try {
            aVar.a().p().clear();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        super.onDestroy();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        O1();
    }

    public final void p2(int i11, int i12, String str, Integer num, int i13, boolean z11) {
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        Integer num2 = this.P;
        if (num2 != null && i11 == num2.intValue() && i13 == this.M && Intrinsics.b(str, this.R)) {
            int i14 = this.K;
            if (num != null && num.intValue() == i14) {
                uo.b.a aVar = uo.b.f78622a;
                String TAG = X0();
                Intrinsics.f(TAG, "TAG");
                uo.b.a.f(aVar, TAG, "分辨率未切换，不处理, resolution = " + i11 + ", tabIndex = " + i13, false, 4, null);
                return;
            }
        }
        String str2 = "fragment_download_group-" + i11 + "-" + this.f60715y + "-" + i13 + "-" + num;
        uo.b.a aVar2 = uo.b.f78622a;
        String TAG2 = X0();
        Intrinsics.f(TAG2, "TAG");
        uo.b.a.f(aVar2, TAG2, "group showFragment, resolution:" + i11 + ",  curEpTabPosition:" + i13 + "， curSubjectId：" + this.f60715y + " season:" + num, false, 4, null);
        this.P = Integer.valueOf(i11);
        this.M = i13;
        this.Q = i12;
        this.R = str;
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = Y0();
        androidx.lifecycle.c0<String> c0VarF = downloadResourcesDetectorViewModelY0 != null ? downloadResourcesDetectorViewModelY0.f() : null;
        if (c0VarF != null) {
            c0VarF.q(str);
        }
        this.K = num != null ? num.intValue() : 1;
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY1 = Y0();
        androidx.lifecycle.c0<Integer> c0VarG = downloadResourcesDetectorViewModelY1 != null ? downloadResourcesDetectorViewModelY1.g() : null;
        if (c0VarG != null) {
            c0VarG.q(Integer.valueOf(this.K));
        }
        W1();
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(str2);
        if (fragmentFindFragmentByTag == null) {
            fragmentFindFragmentByTag = Q1(i11, i12, z11);
        }
        Intrinsics.e(fragmentFindFragmentByTag, "null cannot be cast to non-null type com.transsnet.downloader.fragment.DownloadReDetectorGroupFragment");
        DownloadReDetectorGroupFragment downloadReDetectorGroupFragment = (DownloadReDetectorGroupFragment) fragmentFindFragmentByTag;
        this.I = downloadReDetectorGroupFragment;
        if (downloadReDetectorGroupFragment != null) {
            downloadReDetectorGroupFragment.l2(this.E);
        }
        if (downloadReDetectorGroupFragment.isAdded()) {
            getChildFragmentManager().beginTransaction().show(fragmentFindFragmentByTag).commitNowAllowingStateLoss();
        } else {
            getChildFragmentManager().beginTransaction().add(R$id.fl_content, fragmentFindFragmentByTag, str2).commitNowAllowingStateLoss();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        initView();
        O1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean y0() {
        return false;
    }
}
