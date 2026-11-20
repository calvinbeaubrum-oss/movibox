package com.transsnet.downloader.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.noober.background.view.BLFrameLayout;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.report.FirebaseAnalyticsManager;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.commercializationapi.ITaskCenterApi;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.moviedetailapi.bean.ResourcesSeason;
import com.transsion.moviedetailapi.bean.ResourcesSeasonList;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.bean.DownloadListBean;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import com.transsnet.downloader.manager.DownloadInterceptManager;
import com.transsnet.downloader.manager.StartDownloadHelper;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class DownloadReDetectorMultiFragment extends DownloadReDetectorBaseFragment<h00.c0> implements g00.c {
    public static final a R = new a(null);
    public String A;
    public String B;
    public String C;
    public boolean D;
    public long E;
    public int H;
    public DownloadResourcesDetectorViewModel J;
    public Integer N;
    public int O;
    public boolean P;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public com.transsnet.downloader.adapter.h f60741v;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Subject f60744y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f60745z;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f60742w = "";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f60743x = "";
    public String F = "";
    public final kotlinx.coroutines.k0 G = kotlinx.coroutines.l0.a(kotlinx.coroutines.w0.b());
    public int I = 1;
    public Map<Integer, List<DownloadBean>> K = new LinkedHashMap();
    public Map<Integer, Boolean> L = new LinkedHashMap();
    public Map<Integer, Long> M = new LinkedHashMap();
    public final Lazy Q = LazyKt__LazyJVMKt.b(new Function0<StartDownloadHelper>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorMultiFragment$startDownloadHelper$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StartDownloadHelper invoke() {
            return new StartDownloadHelper();
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

        public final DownloadReDetectorMultiFragment a(String str, String str2, Subject subject, String str3, String str4, String str5, String str6, int i11) {
            DownloadReDetectorMultiFragment downloadReDetectorMultiFragment = new DownloadReDetectorMultiFragment();
            downloadReDetectorMultiFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("extra_page_from", str), TuplesKt.a("extra_last_page_from", str2), TuplesKt.a("extra_subject", subject), TuplesKt.a("extra_group_id", str3), TuplesKt.a("extra_ops", str4), TuplesKt.a("extra_target_resource_id", str5), TuplesKt.a("extra_module_name", str6), TuplesKt.a("extra_season", Integer.valueOf(i11))));
            return downloadReDetectorMultiFragment;
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
            DownloadReDetectorMultiFragment.this.R1();
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
        public final /* synthetic */ Function1 f60747a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f60747a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f60747a;
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
            this.f60747a.invoke(obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements TabLayout.OnTabSelectedListener {
        public d() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            DownloadReDetectorMultiFragment.this.C1();
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    private final void E1(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
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

    private final StartDownloadHelper H1() {
        return (StartDownloadHelper) this.Q.getValue();
    }

    public static final void J1(DownloadReDetectorMultiFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.S0();
    }

    public static final void K1(DownloadReDetectorMultiFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.S1();
    }

    public static final void L1(DownloadReDetectorMultiFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.S1();
    }

    public static final void M1(final DownloadReDetectorMultiFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(R$string.no_network_toast);
            return;
        }
        List<DownloadBean> listD1 = this$0.D1();
        if (listD1.isEmpty()) {
            zp.b.f82110a.d(com.transsnet.downloader.R$string.download_unselected_tips);
            return;
        }
        DownloadBean downloadBean = (DownloadBean) CollectionsKt___CollectionsKt.g0(listD1);
        if (downloadBean != null) {
            RoomAppMMKV.f51271a.a().putInt("download_last_resolution", downloadBean.getResolution());
        }
        com.transsion.ad.a aVar = com.transsion.ad.a.f50276a;
        String simpleName = DownloadReDetectorMultiFragment.class.getSimpleName();
        DownloadBean downloadBean2 = (DownloadBean) CollectionsKt___CollectionsKt.g0(listD1);
        com.transsion.ad.a.j(aVar, simpleName + " --> zxb_log --> genre = " + (downloadBean2 != null ? downloadBean2.getGenre() : null), false, 2, null);
        ITaskCenterApi iTaskCenterApi = (ITaskCenterApi) com.alibaba.android.arouter.launcher.a.d().h(ITaskCenterApi.class);
        Integer num = this$0.N;
        DownloadBean downloadBean3 = (DownloadBean) CollectionsKt___CollectionsKt.g0(listD1);
        iTaskCenterApi.t(num, downloadBean3 != null ? downloadBean3.getGenre() : null, new ss.b() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorMultiFragment$initView$4$2
            @Override // ss.b
            public void a(boolean z11) {
                ss.b.a.a(this, z11);
            }

            @Override // ss.b
            public void onFail() {
            }

            @Override // ss.b
            public void onSuccess() {
                FragmentActivity activity = this.f60749a.getActivity();
                if (activity != null) {
                    final DownloadReDetectorMultiFragment downloadReDetectorMultiFragment = this.f60749a;
                    Subject subject = downloadReDetectorMultiFragment.f60744y;
                    if (subject != null) {
                        DownloadInterceptManager.f61008a.a().h(activity, subject, new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorMultiFragment$initView$4$2$onSuccess$1$1$1
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
                                downloadReDetectorMultiFragment.O1();
                            }
                        });
                    }
                }
            }
        });
    }

    private final void N1() {
        List<DownloadBean> listD1 = D1();
        if (listD1.isEmpty()) {
            return;
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = Y0();
        androidx.lifecycle.c0<com.transsnet.downloader.viewmodel.b> c0VarH = downloadResourcesDetectorViewModelY0 != null ? downloadResourcesDetectorViewModelY0.h() : null;
        if (c0VarH != null) {
            c0VarH.q(new com.transsnet.downloader.viewmodel.b(listD1.size(), this.F, listD1.get(0), false));
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY1 = Y0();
        androidx.lifecycle.c0<Integer> c0VarO = downloadResourcesDetectorViewModelY1 != null ? downloadResourcesDetectorViewModelY1.o() : null;
        if (c0VarO == null) {
            return;
        }
        c0VarO.q(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void O1() {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        AppCompatTextView appCompatTextView;
        AppCompatImageView appCompatImageView;
        View view;
        FrameLayout frameLayout;
        if (a1(this.E)) {
            return;
        }
        h00.c0 c0Var = (h00.c0) getMViewBinding();
        if (c0Var != null && (frameLayout = c0Var.f65757f) != null && frameLayout.getVisibility() == 0) {
            uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"DownloadReDetectorGroupMainFragment --> onDownload() --> 当前正在全选中"}, true);
            return;
        }
        uo.b.a aVar = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "onDownload ", false, 4, null);
        h00.c0 c0Var2 = (h00.c0) getMViewBinding();
        if (c0Var2 != null && (view = c0Var2.f65773v) != null) {
            so.c.k(view);
        }
        h00.c0 c0Var3 = (h00.c0) getMViewBinding();
        if (c0Var3 != null && (appCompatImageView = c0Var3.f65758g) != null) {
            so.c.g(appCompatImageView);
        }
        h00.c0 c0Var4 = (h00.c0) getMViewBinding();
        if (c0Var4 != null && (appCompatTextView = c0Var4.f65766o) != null) {
            so.c.g(appCompatTextView);
        }
        h00.c0 c0Var5 = (h00.c0) getMViewBinding();
        if (c0Var5 != null && (progressBar2 = c0Var5.f65763l) != null) {
            so.c.k(progressBar2);
        }
        List<DownloadBean> listD1 = D1();
        int i11 = 0;
        for (Object obj : listD1) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.g.u();
            }
            DownloadBean downloadBean = (DownloadBean) obj;
            String string = UUID.randomUUID().toString();
            Intrinsics.f(string, "randomUUID().toString()");
            downloadBean.setTaskId(string);
            E1(this.f60742w, this.f60743x, downloadBean.getSubjectId(), downloadBean.getPostId(), this.A, downloadBean.getResourceId(), string);
            uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"剧集多资源，下载点击，开始下载: subjectId = " + downloadBean.getSubjectId() + ",resourceId = " + downloadBean.getResourceId() + ", name = " + downloadBean.getTotalTitleName()}, true);
            i11 = i12;
        }
        U0().D(listD1);
        H1().d(listD1);
        kotlinx.coroutines.j.d(this.G, null, null, new DownloadReDetectorMultiFragment$onDownload$2(listD1, this, null), 3, null);
        long size = ((long) ((listD1.size() / 20) * 100)) + 300;
        h00.c0 c0Var6 = (h00.c0) getMViewBinding();
        if (c0Var6 == null || (progressBar = c0Var6.f65763l) == null) {
            return;
        }
        progressBar.postDelayed(new Runnable() { // from class: com.transsnet.downloader.fragment.o0
            @Override // java.lang.Runnable
            public final void run() {
                DownloadReDetectorMultiFragment.P1(this.f60945a);
            }
        }, size);
    }

    public static final void P1(DownloadReDetectorMultiFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.N1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q1(DownloadListBean downloadListBean) {
        if (downloadListBean == null || downloadListBean.getResolutionList() == null) {
            return;
        }
        this.P = true;
        Integer resolution = downloadListBean.getResolution();
        int iIntValue = resolution != null ? resolution.intValue() : 0;
        this.O = iIntValue;
        com.transsnet.downloader.adapter.h hVar = this.f60741v;
        if (hVar == null) {
            return;
        }
        hVar.k(Integer.valueOf(iIntValue));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void R1() {
        h00.c0 c0Var;
        AppCompatImageView appCompatImageView;
        DownloadMultiListFragment downloadMultiListFragmentF1 = F1();
        if ((downloadMultiListFragmentF1 != null && !downloadMultiListFragmentF1.Z1()) || (c0Var = (h00.c0) getMViewBinding()) == null || (appCompatImageView = c0Var.f65759h) == null) {
            return;
        }
        appCompatImageView.setSelected(!appCompatImageView.isSelected());
        this.D = appCompatImageView.isSelected();
        DownloadMultiListFragment downloadMultiListFragmentF2 = F1();
        if (downloadMultiListFragmentF2 != null) {
            downloadMultiListFragmentF2.c2(this.D);
        }
    }

    private final void S1() {
        DownloadMultiListFragment downloadMultiListFragmentF1;
        if (this.D || (downloadMultiListFragmentF1 = F1()) == null || !downloadMultiListFragmentF1.U1()) {
            R1();
            return;
        }
        IMemberApi iMemberApi = (IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class);
        DownloadMultiListFragment downloadMultiListFragmentF2 = F1();
        iMemberApi.i(downloadMultiListFragmentF2 != null ? downloadMultiListFragmentF2.R1() : null, new b());
    }

    public static final void U1(DownloadReDetectorMultiFragment this$0, TabLayout.Tab tab, int i11) {
        ResourcesSeason resourcesSeasonE;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(tab, "tab");
        com.transsnet.downloader.adapter.h hVar = this$0.f60741v;
        tab.setText("Unit " + ((hVar == null || (resourcesSeasonE = hVar.e(i11)) == null) ? null : Integer.valueOf(resourcesSeasonE.getSe())));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        LinearLayoutCompat linearLayoutCompat;
        AppCompatImageView appCompatImageView;
        AppCompatTextView appCompatTextView;
        ImageView imageView;
        CoordinatorLayout coordinatorLayout;
        h00.c0 c0Var = (h00.c0) getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (c0Var == null || (coordinatorLayout = c0Var.f65755c) == null) ? null : coordinatorLayout.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = V0();
        }
        h00.c0 c0Var2 = (h00.c0) getMViewBinding();
        if (c0Var2 != null && (imageView = c0Var2.f65760i) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.j0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorMultiFragment.J1(this.f60928a, view);
                }
            });
        }
        h00.c0 c0Var3 = (h00.c0) getMViewBinding();
        if (c0Var3 != null && (appCompatTextView = c0Var3.f65769r) != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.k0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorMultiFragment.K1(this.f60931a, view);
                }
            });
        }
        h00.c0 c0Var4 = (h00.c0) getMViewBinding();
        if (c0Var4 != null && (appCompatImageView = c0Var4.f65759h) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.l0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorMultiFragment.L1(this.f60934a, view);
                }
            });
        }
        h00.c0 c0Var5 = (h00.c0) getMViewBinding();
        if (c0Var5 == null || (linearLayoutCompat = c0Var5.f65754b) == null) {
            return;
        }
        linearLayoutCompat.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadReDetectorMultiFragment.M1(this.f60937a, view);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B1(List<ResourcesSeason> list) {
        h00.c0 c0Var = (h00.c0) getMViewBinding();
        if (c0Var != null) {
            TabLayout subjectTab = c0Var.f65765n;
            Intrinsics.f(subjectTab, "subjectTab");
            subjectTab.setVisibility(list.size() > 1 ? 0 : 8);
            T1(list);
            int i11 = 0;
            int i12 = 0;
            for (Object obj : list) {
                int i13 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.g.u();
                }
                if (((ResourcesSeason) obj).getSe() == this.H) {
                    i12 = i11;
                }
                i11 = i13;
            }
            TabLayout subjectTab2 = c0Var.f65765n;
            Intrinsics.f(subjectTab2, "subjectTab");
            V1(subjectTab2, gs.a.a(12));
            if (c0Var.f65775x.isFakeDragging()) {
                return;
            }
            c0Var.f65775x.setCurrentItem(i12, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C1() {
        h00.c0 c0Var = (h00.c0) getMViewBinding();
        AppCompatImageView appCompatImageView = c0Var != null ? c0Var.f65759h : null;
        if (appCompatImageView == null) {
            return;
        }
        Boolean bool = this.L.get(Integer.valueOf(G1()));
        appCompatImageView.setSelected(bool != null ? bool.booleanValue() : false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g00.c
    public void D(boolean z11) {
        h00.c0 c0Var = (h00.c0) getMViewBinding();
        BLFrameLayout bLFrameLayout = c0Var != null ? c0Var.f65756d : null;
        if (bLFrameLayout == null) {
            return;
        }
        bLFrameLayout.setVisibility(z11 ? 0 : 8);
    }

    public final List<DownloadBean> D1() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Integer, List<DownloadBean>>> it = this.K.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getValue());
        }
        return arrayList;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        B0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final DownloadMultiListFragment F1() {
        ViewPager2 viewPager2;
        h00.c0 c0Var = (h00.c0) getMViewBinding();
        int iD = kotlin.ranges.a.d((c0Var == null || (viewPager2 = c0Var.f65775x) == null) ? 0 : viewPager2.getCurrentItem(), 0);
        com.transsnet.downloader.adapter.h hVar = this.f60741v;
        if (hVar != null) {
            return hVar.d(iD);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int G1() {
        TabLayout tabLayout;
        h00.c0 c0Var = (h00.c0) getMViewBinding();
        if (c0Var == null || (tabLayout = c0Var.f65765n) == null) {
            return 0;
        }
        return tabLayout.getSelectedTabPosition();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g00.c
    public void H(int i11, Long l11) {
        AppCompatTextView appCompatTextView;
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        this.M.put(Integer.valueOf(i11), l11);
        Iterator<Map.Entry<Integer, Long>> it = this.M.entrySet().iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            Long value = it.next().getValue();
            jLongValue += value != null ? value.longValue() : 0L;
        }
        if (jLongValue <= 0) {
            h00.c0 c0Var = (h00.c0) getMViewBinding();
            appCompatTextView = c0Var != null ? c0Var.f65766o : null;
            if (appCompatTextView == null) {
                return;
            }
            appCompatTextView.setText(getString(com.transsnet.downloader.R$string.str_download));
            return;
        }
        h00.c0 c0Var2 = (h00.c0) getMViewBinding();
        appCompatTextView = c0Var2 != null ? c0Var2.f65766o : null;
        if (appCompatTextView == null) {
            return;
        }
        String str = getString(com.transsnet.downloader.R$string.str_download) + " · " + tp.a.a(jLongValue, 1);
        Intrinsics.f(str, "toString(...)");
        appCompatTextView.setText(str);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
    public h00.c0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        h00.c0 c0VarC = h00.c0.c(inflater);
        Intrinsics.f(c0VarC, "inflate(inflater)");
        return c0VarC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T1(List<ResourcesSeason> list) {
        h00.c0 c0Var = (h00.c0) getMViewBinding();
        if (c0Var != null) {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
            com.transsnet.downloader.adapter.h hVar = new com.transsnet.downloader.adapter.h(fragmentActivityRequireActivity, this);
            hVar.i(this.A);
            hVar.m(this.f60744y);
            hVar.g(this.f60745z);
            hVar.j(this.f60742w);
            hVar.h(this.f60743x);
            hVar.l(this.P);
            hVar.n(this.B);
            hVar.o(this.H);
            hVar.f(list);
            this.f60741v = hVar;
            c0Var.f65775x.setAdapter(hVar);
            new TabLayoutMediator(c0Var.f65765n, c0Var.f65775x, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.transsnet.downloader.fragment.n0
                @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
                public final void onConfigureTab(TabLayout.Tab tab, int i11) {
                    DownloadReDetectorMultiFragment.U1(this.f60941a, tab, i11);
                }
            }).attach();
            c0Var.f65765n.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new d());
        }
    }

    public final void V1(TabLayout tabLayout, int i11) {
        int iA = gs.a.a(28);
        int tabCount = tabLayout.getTabCount();
        for (int i12 = 0; i12 < tabCount; i12++) {
            if (tabLayout.getTabAt(i12) == null) {
                return;
            }
            View childAt = tabLayout.getChildAt(0);
            Intrinsics.e(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
            View childAt2 = ((ViewGroup) childAt).getChildAt(i12);
            Intrinsics.f(childAt2, "tabView.getChildAt(0) as ViewGroup).getChildAt(i)");
            ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
            Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins(0, 0, i11, 0);
            marginLayoutParams.height = iA;
        }
        tabLayout.requestLayout();
    }

    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment
    public void d1() {
        super.d1();
        if (m1()) {
            l1();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g00.c
    public void f0(boolean z11) {
        h00.c0 c0Var = (h00.c0) getMViewBinding();
        FrameLayout frameLayout = c0Var != null ? c0Var.f65757f : null;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(z11 ? 0 : 8);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        String subjectId;
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0;
        androidx.lifecycle.c0<ResourcesSeasonList> c0VarX;
        final int i11 = RoomAppMMKV.f51271a.a().getInt("download_last_resolution", 0);
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY1 = Y0();
        if (downloadResourcesDetectorViewModelY1 != null && (c0VarX = downloadResourcesDetectorViewModelY1.x()) != null) {
            c0VarX.j(this, new c(new Function1<ResourcesSeasonList, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorMultiFragment.initViewModel.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ResourcesSeasonList resourcesSeasonList) {
                    invoke2(resourcesSeasonList);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ResourcesSeasonList resourcesSeasonList) {
                    List<ResourcesSeason> seasons;
                    uo.b.a aVar = uo.b.f78622a;
                    String TAG = DownloadReDetectorMultiFragment.this.X0();
                    Intrinsics.f(TAG, "TAG");
                    uo.b.a.f(aVar, TAG, "获取当前季跟分辨率的信息,resolution:" + i11 + ", curSeason:" + DownloadReDetectorMultiFragment.this.I, false, 4, null);
                    Subject subject = DownloadReDetectorMultiFragment.this.f60744y;
                    if (subject != null) {
                        subject.setSubjectType(resourcesSeasonList != null ? resourcesSeasonList.getSubjectType() : null);
                    }
                    if (resourcesSeasonList == null || (seasons = resourcesSeasonList.getSeasons()) == null) {
                        return;
                    }
                    DownloadReDetectorMultiFragment.this.B1(seasons);
                }
            }));
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModel = (DownloadResourcesDetectorViewModel) new androidx.lifecycle.v0(this).a(DownloadResourcesDetectorViewModel.class);
        downloadResourcesDetectorViewModel.r().j(this, new c(new Function1<DownloadListBean, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorMultiFragment$initViewModel$2$1
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
                this.this$0.Q1(downloadListBean);
            }
        }));
        this.J = downloadResourcesDetectorViewModel;
        Subject subject = this.f60744y;
        if (subject != null && (subjectId = subject.getSubjectId()) != null && (downloadResourcesDetectorViewModelY0 = Y0()) != null) {
            downloadResourcesDetectorViewModelY0.t(subjectId);
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY2 = Y0();
        if (downloadResourcesDetectorViewModelY2 != null) {
            downloadResourcesDetectorViewModelY2.u();
        }
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
        this.f60742w = string4;
        Bundle arguments2 = getArguments();
        String string5 = arguments2 != null ? arguments2.getString("extra_last_page_from") : null;
        if (string5 == null) {
            string5 = "";
        }
        this.f60743x = string5;
        Bundle arguments3 = getArguments();
        this.f60744y = (Subject) (arguments3 != null ? arguments3.getSerializable("extra_subject") : null);
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
        this.H = arguments7 != null ? arguments7.getInt("extra_season") : 0;
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (mapG5 = logViewConfig.g()) != null) {
            mapG5.put(WebConstants.PAGE_FROM, this.f60742w);
        }
        com.transsion.baselib.report.h logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null && (mapG4 = logViewConfig2.g()) != null) {
            mapG4.put("last_page_from", this.f60743x);
        }
        com.transsion.baselib.report.h logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 != null && (mapG3 = logViewConfig3.g()) != null) {
            Subject subject = this.f60744y;
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

    @Override // g00.c
    public void q(int i11, List<DownloadBean> selectedList, boolean z11) {
        Intrinsics.g(selectedList, "selectedList");
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        this.K.put(Integer.valueOf(i11), selectedList);
        this.L.put(Integer.valueOf(i11), Boolean.valueOf(z11));
        uo.b.a.f(uo.b.f78622a, "zxb_log", "DownloadReDetectorGroupMainFragment --> onSelectData() --> selectedList.size = " + this.K.size(), false, 4, null);
        long jLongValue = 0L;
        for (DownloadBean downloadBean : selectedList) {
            if (!downloadBean.isUnable()) {
                Long size = downloadBean.getSize();
                jLongValue += size != null ? size.longValue() : 0L;
            }
        }
        H(i11, Long.valueOf(jLongValue));
        C1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        initView();
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
