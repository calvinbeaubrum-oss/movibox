package com.transsnet.downloader.fragment;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.applovin.sdk.AppLovinEventTypes;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.Utils;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.tabs.TabLayout;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLView;
import com.tn.lib.view.DefaultView;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.video.ShortTVPlayBean;
import com.transsion.baselib.db.video.ShortTVPlayDao;
import com.transsion.baselib.report.FirebaseAnalyticsManager;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.usercenterapi.ReportType;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.R$drawable;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.adapter.DownloadShortTvEpListAdapter;
import com.transsnet.downloader.bean.DownloadListBean;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.manager.StartDownloadHelper;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.downloader.util.ShortTvMmkv;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel;
import com.transsnet.downloader.widget.DownloadInfoExtendView;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
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
public class DownloadReDetectorShortTVFragment extends DownloadReDetectorBaseFragment<h00.g0> {
    public static final a X = new a(null);
    public boolean A;
    public DownloadShortTvEpListAdapter B;
    public int C;
    public int D;
    public int I;
    public Subject L;
    public String M;
    public String N;
    public String O;
    public String P;
    public boolean Q;
    public boolean R;
    public int S;
    public ShareDialogFragment U;
    public boolean V;
    public Function0<Unit> W;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f60764v = com.blankj.utilcode.util.f0.a(12.0f);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f60765w = (com.blankj.utilcode.util.d0.e() - com.blankj.utilcode.util.f0.a(24.0f)) / 5;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f60766x = LazyKt__LazyJVMKt.b(new Function0<StartDownloadHelper>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$startDownloadHelper$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StartDownloadHelper invoke() {
            return new StartDownloadHelper();
        }
    });

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f60767y = LazyKt__LazyJVMKt.b(new Function0<ShortTVPlayDao>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$shortTVPlayDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ShortTVPlayDao invoke() {
            AppDatabase.v0 v0Var = AppDatabase.f51036p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return v0Var.b(applicationA).K0();
        }
    });

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f60768z = LazyKt__LazyJVMKt.b(new Function0<com.transsnet.downloader.report.b>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$shortTVReporter$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.transsnet.downloader.report.b invoke() {
            return new com.transsnet.downloader.report.b();
        }
    });
    public final Map<Integer, DownloadBean> E = new LinkedHashMap();
    public final Map<Integer, DownloadBean> F = new LinkedHashMap();
    public int G = 1;
    public int H = 1;
    public String J = "";
    public String K = "";
    public String T = "";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadReDetectorShortTVFragment a(String str, String str2, Subject subject, String str3, String str4, String str5, String str6, boolean z11) {
            DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment = new DownloadReDetectorShortTVFragment();
            downloadReDetectorShortTVFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("extra_page_from", str), TuplesKt.a("extra_last_page_from", str2), TuplesKt.a("extra_subject", subject), TuplesKt.a("extra_subject_id", str3), TuplesKt.a("extra_group_id", str4), TuplesKt.a("extra_ops", str5), TuplesKt.a("extra_module_name", str6), TuplesKt.a("extra_download_scroll_to_download", Boolean.valueOf(z11))));
            return downloadReDetectorShortTVFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements TabLayout.OnTabSelectedListener {
        public b() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            DownloadReDetectorShortTVFragment.this.u2(tab);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends RecyclerView.r {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            h00.g0 g0Var;
            TabLayout tabLayout;
            TabLayout.Tab tabAt;
            Intrinsics.g(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i11, i12);
            RecyclerView.m layoutManager = recyclerView.getLayoutManager();
            GridLayoutManager gridLayoutManager = layoutManager instanceof GridLayoutManager ? (GridLayoutManager) layoutManager : null;
            int iFindFirstVisibleItemPosition = ((gridLayoutManager != null ? gridLayoutManager.findFirstVisibleItemPosition() : 0) + 24) / 25;
            if (iFindFirstVisibleItemPosition == DownloadReDetectorShortTVFragment.this.I || (g0Var = (h00.g0) DownloadReDetectorShortTVFragment.this.getMViewBinding()) == null || (tabLayout = g0Var.f65872u) == null || (tabAt = tabLayout.getTabAt(iFindFirstVisibleItemPosition)) == null) {
                return;
            }
            tabAt.select();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements com.transsion.share.share.e {
        @Override // com.transsion.share.share.e
        public void a(String id2, PostType postType) {
            Intrinsics.g(id2, "id");
        }

        @Override // com.transsion.share.share.e
        public void b(String str) {
        }

        @Override // com.transsion.share.share.e
        public void c(String url, String fileName, String fileSize, String fileImage) {
            Intrinsics.g(url, "url");
            Intrinsics.g(fileName, "fileName");
            Intrinsics.g(fileSize, "fileSize");
            Intrinsics.g(fileImage, "fileImage");
        }

        @Override // com.transsion.share.share.e
        public void d(String id2) {
            Intrinsics.g(id2, "id");
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f60771a;

        public e(Function1 function) {
            Intrinsics.g(function, "function");
            this.f60771a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f60771a;
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
            this.f60771a.invoke(obj);
        }
    }

    /* JADX INFO: renamed from: com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$initHistory$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$initHistory$1", f = "DownloadReDetectorShortTVFragment.kt", l = {224, 225}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DownloadReDetectorShortTVFragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0054 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment;
            kotlinx.coroutines.a2 a2VarC;
            DownloadReDetectorShortTVFragment$initHistory$1$1$1 downloadReDetectorShortTVFragment$initHistory$1$1$1;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                String str = DownloadReDetectorShortTVFragment.this.M;
                if (str != null) {
                    downloadReDetectorShortTVFragment = DownloadReDetectorShortTVFragment.this;
                    ShortTVPlayDao shortTVPlayDaoF2 = downloadReDetectorShortTVFragment.f2();
                    this.L$0 = downloadReDetectorShortTVFragment;
                    this.label = 1;
                    obj = shortTVPlayDaoF2.b(str, this);
                    if (obj == objE) {
                        return objE;
                    }
                    a2VarC = kotlinx.coroutines.w0.c();
                    downloadReDetectorShortTVFragment$initHistory$1$1$1 = new DownloadReDetectorShortTVFragment$initHistory$1$1$1(downloadReDetectorShortTVFragment, (ShortTVPlayBean) obj, null);
                    this.L$0 = null;
                    this.label = 2;
                    if (kotlinx.coroutines.h.g(a2VarC, downloadReDetectorShortTVFragment$initHistory$1$1$1, this) == objE) {
                        return objE;
                    }
                }
            } else if (i11 == 1) {
                downloadReDetectorShortTVFragment = (DownloadReDetectorShortTVFragment) this.L$0;
                ResultKt.b(obj);
                a2VarC = kotlinx.coroutines.w0.c();
                downloadReDetectorShortTVFragment$initHistory$1$1$1 = new DownloadReDetectorShortTVFragment$initHistory$1$1$1(downloadReDetectorShortTVFragment, (ShortTVPlayBean) obj, null);
                this.L$0 = null;
                this.label = 2;
                if (kotlinx.coroutines.h.g(a2VarC, downloadReDetectorShortTVFragment$initHistory$1$1$1, this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
    }

    private final void A2(View view) {
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 500L)) {
            return;
        }
        com.transsnet.downloader.report.b.g(g2(), this.M, null, 2, null);
        if (this.U == null) {
            ShareDialogFragment.a aVar = ShareDialogFragment.f57724t;
            PostType postType = PostType.SHORT_TV_TYPE;
            String str = this.M;
            String value = ReportType.SUBJECT.getValue();
            Subject subject = this.L;
            ShareDialogFragment shareDialogFragmentA = aVar.a(postType, str, "", value, (3072 & 16) != 0 ? "" : subject != null ? subject.getTitle() : null, (3072 & 32) != 0 ? "" : null, (3072 & 64) != 0 ? false : false, (3072 & 128) != 0 ? false : false, (3072 & 256) != 0 ? false : false, "subjectdetail", (3072 & 1024) != 0 ? "" : null, (3072 & 2048) != 0 ? "" : null);
            this.U = shareDialogFragmentA;
            if (shareDialogFragmentA != null) {
                shareDialogFragmentA.E0(new d());
            }
        }
        try {
            if (isAdded()) {
                Context context = getContext();
                S0();
                ShareDialogFragment shareDialogFragment = this.U;
                if (shareDialogFragment != null) {
                    shareDialogFragment.G0(context, AppLovinEventTypes.USER_SHARED_LINK);
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static final void C2(String epStr) {
        Intrinsics.g(epStr, "$epStr");
        zp.b.f82110a.e(Utils.a().getString(R$string.download_short_tv_unlock_success_toast, epStr));
    }

    private final void D2() {
        com.transsion.ad.bidding.interstitial.a.f50342m.a("ShortTvInterstitialScene");
        com.transsion.ad.bidding.video.f.f50385m.a("ShortTvVideoScene");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void E2(final boolean z11) {
        FrameLayout frameLayout;
        uo.b.a aVar = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "selectAll click, selectAll = " + z11 + " ", false, 4, null);
        this.R = z11;
        if (!this.V) {
            F2(z11);
            return;
        }
        h00.g0 g0Var = (h00.g0) getMViewBinding();
        if (g0Var != null && (frameLayout = g0Var.f65859h) != null) {
            so.c.k(frameLayout);
        }
        this.W = new Function0<Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$selectAll$1
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
                this.this$0.F2(z11);
                this.this$0.W = null;
            }
        };
    }

    private final void G2(boolean z11) {
        DownloadBean downloadBean;
        Long size;
        List<f00.c> listE;
        List<f00.c> listE2;
        androidx.lifecycle.c0<Map<Integer, f00.c>> c0VarE;
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = Y0();
        Map<Integer, f00.c> mapF = (downloadResourcesDetectorViewModelY0 == null || (c0VarE = downloadResourcesDetectorViewModelY0.E()) == null) ? null : c0VarE.f();
        if (mapF == null) {
            mapF = new LinkedHashMap<>();
        }
        mapF.clear();
        int i11 = this.C;
        long jLongValue = 0;
        for (int i12 = 0; i12 < i11; i12++) {
            DownloadShortTvEpListAdapter downloadShortTvEpListAdapter = this.B;
            if (i12 < ((downloadShortTvEpListAdapter == null || (listE2 = downloadShortTvEpListAdapter.e()) == null) ? 0 : listE2.size())) {
                DownloadShortTvEpListAdapter downloadShortTvEpListAdapter2 = this.B;
                f00.c cVar = (downloadShortTvEpListAdapter2 == null || (listE = downloadShortTvEpListAdapter2.e()) == null) ? null : listE.get(i12);
                if (this.E.containsKey(Integer.valueOf(i12)) && (((downloadBean = this.E.get(Integer.valueOf(i12))) == null || !downloadBean.isUnable()) && cVar != null)) {
                    cVar.g(z11);
                    if (z11) {
                        jLongValue += (downloadBean == null || (size = downloadBean.getSize()) == null) ? 0L : size.longValue();
                        mapF.put(Integer.valueOf(i12), cVar);
                    } else {
                        mapF.remove(Integer.valueOf(i12));
                    }
                }
            }
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY1 = Y0();
        androidx.lifecycle.c0<Map<Integer, f00.c>> c0VarE2 = downloadResourcesDetectorViewModelY1 != null ? downloadResourcesDetectorViewModelY1.E() : null;
        if (c0VarE2 != null) {
            c0VarE2.q(mapF);
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY2 = Y0();
        androidx.lifecycle.c0<Long> c0VarF = downloadResourcesDetectorViewModelY2 != null ? downloadResourcesDetectorViewModelY2.F() : null;
        if (c0VarF != null) {
            c0VarF.q(Long.valueOf(jLongValue));
        }
        DownloadShortTvEpListAdapter downloadShortTvEpListAdapter3 = this.B;
        if (downloadShortTvEpListAdapter3 != null) {
            downloadShortTvEpListAdapter3.notifyItemRangeChanged(0, this.C);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void K2() {
        FrameLayout frameLayout;
        h00.g0 g0Var = (h00.g0) getMViewBinding();
        if (g0Var == null || (frameLayout = g0Var.f65860i) == null) {
            return;
        }
        frameLayout.removeAllViews();
        frameLayout.setVisibility(0);
        frameLayout.addView(Z1());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void L2() {
        FrameLayout frameLayout;
        h00.g0 g0Var = (h00.g0) getMViewBinding();
        if (g0Var == null || (frameLayout = g0Var.f65860i) == null) {
            return;
        }
        frameLayout.removeAllViews();
        frameLayout.setVisibility(0);
        frameLayout.addView(e2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void X1() {
        AppCompatTextView appCompatTextView;
        androidx.lifecycle.c0<Map<Integer, f00.c>> c0VarE;
        Map<Integer, f00.c> mapF;
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = Y0();
        int size = (downloadResourcesDetectorViewModelY0 == null || (c0VarE = downloadResourcesDetectorViewModelY0.E()) == null || (mapF = c0VarE.f()) == null) ? 0 : mapF.size();
        uo.b.a aVar = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "checkSelectAll, selectedCount: " + size + ", curUnlockCount:" + this.C + ", downloadize:" + this.F.size(), false, 4, null);
        this.R = size == this.C - this.F.size();
        h00.g0 g0Var = (h00.g0) getMViewBinding();
        AppCompatImageView appCompatImageView = g0Var != null ? g0Var.f65863l : null;
        if (appCompatImageView != null) {
            appCompatImageView.setSelected(this.R);
        }
        h00.g0 g0Var2 = (h00.g0) getMViewBinding();
        if (g0Var2 == null || (appCompatTextView = g0Var2.f65875x) == null) {
            return;
        }
        appCompatTextView.setVisibility(size > 0 ? 0 : 8);
        appCompatTextView.setText(Utils.a().getString(R$string.download_ep_selected_count, String.valueOf(size)));
    }

    private final void Y1(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        HashMap map = new HashMap();
        map.put(WebConstants.PAGE_FROM, str2);
        map.put("subject_id", str3);
        map.put("post_id", str4);
        map.put("ops", str5);
        map.put("resource_id", str6);
        map.put("task_id", str7);
        map.put("module_name", this.P);
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

    private final View a2(Context context, String str, boolean z11) {
        final DefaultView defaultView = new DefaultView(context, DefaultView.ModelStyle.MODEL_STYLE_NIGHT);
        defaultView.setStyle(DefaultView.DefaultViewStyle.STYLE_DES_BTN);
        defaultView.setDescText(str);
        defaultView.setDescTextColor(-1);
        defaultView.setStyle(DefaultView.DefaultViewStyle.STYLE_NO_IMAGE);
        defaultView.setBtnVisibility(z11 ? 0 : 8);
        String string = context.getString(com.tn.lib.widget.R$string.go_to_setting);
        Intrinsics.f(string, "context.getString(com.tn…t.R.string.go_to_setting)");
        defaultView.setBtnText(string);
        defaultView.setTipOperationVisibility(8);
        defaultView.setBtnBg(z2.a.getDrawable(Utils.a(), R$drawable.download_empty_btn_bg));
        defaultView.setBtnTextColor(-1);
        defaultView.setBackgroundColor(0);
        defaultView.setBtnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.e1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadReDetectorShortTVFragment.b2(view);
            }
        });
        defaultView.setLeftBtnVisibility(0);
        String string2 = context.getString(com.transsion.baseui.R$string.retry_text);
        Intrinsics.f(string2, "context.getString(com.tr…seui.R.string.retry_text)");
        defaultView.setLeftBtnText(string2);
        defaultView.setLeftBtnBg(z2.a.getDrawable(Utils.a(), R$drawable.download_empty_btn_bg));
        defaultView.setLeftBtnTextColor(-1);
        defaultView.setLeftBtnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.v0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadReDetectorShortTVFragment.c2(this.f60970a, defaultView, view);
            }
        });
        defaultView.setTitleViewVisibility(8);
        int iA = com.blankj.utilcode.util.f0.a(16.0f);
        defaultView.setPadding(iA, com.blankj.utilcode.util.f0.a(110.0f), iA, 0);
        defaultView.setVisibility(0);
        return defaultView;
    }

    public static final void b2(View view) {
        NetworkUtils.w();
    }

    public static final void c2(DownloadReDetectorShortTVFragment this$0, DefaultView this_apply, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        this$0.K2();
        this$0.r2();
        this_apply.setVisibility(8);
    }

    private final com.transsnet.downloader.report.b g2() {
        return (com.transsnet.downloader.report.b) this.f60768z.getValue();
    }

    private final StartDownloadHelper h2() {
        return (StartDownloadHelper) this.f60766x.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        RecyclerView recyclerView;
        AppBarLayout appBarLayout;
        h00.g0 g0Var = (h00.g0) getMViewBinding();
        AppCompatTextView appCompatTextView = g0Var != null ? g0Var.D : null;
        if (appCompatTextView != null) {
            Subject subject = this.L;
            appCompatTextView.setText(subject != null ? subject.getTitle() : null);
        }
        h00.g0 g0Var2 = (h00.g0) getMViewBinding();
        if (g0Var2 != null && (appBarLayout = g0Var2.f65854b) != null) {
            appBarLayout.setExpanded(!this.Q);
        }
        h00.g0 g0Var3 = (h00.g0) getMViewBinding();
        if (g0Var3 != null && (recyclerView = g0Var3.f65870s) != null) {
            int i11 = this.f60764v;
            recyclerView.setPadding(i11, 0, i11, 0);
            recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 5, 1, false));
            recyclerView.addOnScrollListener(new c());
        }
        DownloadShortTvEpListAdapter downloadShortTvEpListAdapter = new DownloadShortTvEpListAdapter();
        downloadShortTvEpListAdapter.j(new Function1<Integer, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$initView$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(int i12) {
                this.this$0.w2(i12);
            }
        });
        this.B = downloadShortTvEpListAdapter;
        h00.g0 g0Var4 = (h00.g0) getMViewBinding();
        RecyclerView recyclerView2 = g0Var4 != null ? g0Var4.f65870s : null;
        if (recyclerView2 == null) {
            return;
        }
        recyclerView2.setAdapter(this.B);
    }

    public static final void j2(DownloadReDetectorShortTVFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.S0();
    }

    public static final void k2(DownloadReDetectorShortTVFragment this$0, View it) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.f(it, "it");
        this$0.x2(it);
    }

    public static final void l2(DownloadReDetectorShortTVFragment this$0, View it) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.f(it, "it");
        this$0.v2(it);
    }

    public static final void m2(DownloadReDetectorShortTVFragment this$0, View it) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.f(it, "it");
        this$0.A2(it);
    }

    public static final void n2(DownloadReDetectorShortTVFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.y2();
    }

    public static final void o2(DownloadReDetectorShortTVFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.y2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void p2(DownloadReDetectorShortTVFragment this$0, View view) {
        Long lF;
        androidx.lifecycle.c0<Long> c0VarF;
        androidx.lifecycle.c0<Map<Integer, f00.c>> c0VarE;
        FrameLayout frameLayout;
        Intrinsics.g(this$0, "this$0");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 500L)) {
            return;
        }
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(com.tn.lib.widget.R$string.no_network_toast);
            return;
        }
        h00.g0 g0Var = (h00.g0) this$0.getMViewBinding();
        if (g0Var != null && (frameLayout = g0Var.f65859h) != null && frameLayout.getVisibility() == 0) {
            uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"DownloadReDetectorGroupMainFragment --> onDownload() --> 当前正在全选中"}, true);
            return;
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = this$0.Y0();
        Map<Integer, f00.c> mapF = (downloadResourcesDetectorViewModelY0 == null || (c0VarE = downloadResourcesDetectorViewModelY0.E()) == null) ? null : c0VarE.f();
        if (mapF == null || mapF.isEmpty()) {
            zp.b.f82110a.e(Utils.a().getString(R$string.download_short_tv_unselected_toast));
            return;
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY1 = this$0.Y0();
        if (downloadResourcesDetectorViewModelY1 == null || (c0VarF = downloadResourcesDetectorViewModelY1.F()) == null || (lF = c0VarF.f()) == null) {
            lF = 0L;
        }
        this$0.s2(lF.longValue());
    }

    private final boolean q2() {
        return this.S < this.C;
    }

    private final void r2() {
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            L2();
            return;
        }
        uo.b.a aVar = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "loadData ,  startPosition:" + this.G + ", endPosition:" + this.H, false, 4, null);
        this.V = true;
        DownloadListManager downloadListManagerA = DownloadListManager.f61186m.a();
        Subject subject = this.L;
        String subjectId = subject != null ? subject.getSubjectId() : null;
        int i11 = this.G;
        int i12 = this.H;
        Subject subject2 = this.L;
        DownloadListManager.C(downloadListManagerA, subjectId, i11, i12, subject2 != null ? subject2.getTitle() : null, 0, 16, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void t2(List checkedList, DownloadReDetectorShortTVFragment this$0, Ref.ObjectRef firstBean) {
        DownloadBean downloadBean;
        Intrinsics.g(checkedList, "$checkedList");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(firstBean, "$firstBean");
        if (checkedList.isEmpty()) {
            return;
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = this$0.Y0();
        androidx.lifecycle.c0<Boolean> c0VarL = downloadResourcesDetectorViewModelY0 != null ? downloadResourcesDetectorViewModelY0.l() : null;
        if (c0VarL != null) {
            c0VarL.q(Boolean.TRUE);
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY1 = this$0.Y0();
        androidx.lifecycle.c0<com.transsnet.downloader.viewmodel.b> c0VarH = downloadResourcesDetectorViewModelY1 != null ? downloadResourcesDetectorViewModelY1.h() : null;
        if (c0VarH != null) {
            int size = checkedList.size();
            String str = this$0.T;
            T t11 = firstBean.element;
            if (t11 != 0) {
                Intrinsics.d(t11);
                downloadBean = (DownloadBean) t11;
            } else {
                downloadBean = (DownloadBean) checkedList.get(0);
            }
            c0VarH.q(new com.transsnet.downloader.viewmodel.b(size, str, downloadBean, false));
        }
        this$0.S0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y2() {
        AppCompatImageView appCompatImageView;
        if (com.transsion.baseui.util.c.f51452a.a(-912345, 1000L)) {
            return;
        }
        if (!q2()) {
            zp.b.f82110a.d(R$string.download_no_options_toast);
            return;
        }
        h00.g0 g0Var = (h00.g0) getMViewBinding();
        if (g0Var == null || (appCompatImageView = g0Var.f65863l) == null) {
            return;
        }
        boolean z11 = !appCompatImageView.isSelected();
        this.R = z11;
        E2(z11);
    }

    public final void B2(String str) {
        List<f00.c> listE;
        List<f00.c> listE2;
        List<f00.c> listE3;
        androidx.lifecycle.c0<Map<Integer, f00.c>> c0VarE;
        List<f00.c> listE4;
        List<f00.c> listE5;
        List<f00.c> listE6;
        int iHashCode = str.hashCode();
        if (iHashCode != -1747705881) {
            if (iHashCode != 229859771) {
                if (iHashCode != 298697238) {
                    return;
                }
                str.equals("ad_cancel");
                return;
            } else if (!str.equals("ad_load_fail")) {
                return;
            }
        } else if (!str.equals("ad_success")) {
            return;
        }
        int i11 = this.H;
        this.G = i11 + 1;
        int i12 = i11 + this.D;
        this.H = i12;
        DownloadShortTvEpListAdapter downloadShortTvEpListAdapter = this.B;
        if (i12 > ((downloadShortTvEpListAdapter == null || (listE6 = downloadShortTvEpListAdapter.e()) == null) ? 0 : listE6.size())) {
            DownloadShortTvEpListAdapter downloadShortTvEpListAdapter2 = this.B;
            this.H = (downloadShortTvEpListAdapter2 == null || (listE5 = downloadShortTvEpListAdapter2.e()) == null) ? 0 : listE5.size();
        }
        uo.b.a aVar = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "广告解锁成功 , 请求新数据， start：" + this.G + ", end:" + this.H, false, 4, null);
        ShortTvMmkv shortTvMmkv = ShortTvMmkv.f61142a;
        String str2 = this.M;
        if (str2 == null) {
            str2 = "";
        }
        shortTvMmkv.h(str2, this.H);
        DownloadShortTvEpListAdapter downloadShortTvEpListAdapter3 = this.B;
        final String string = ((downloadShortTvEpListAdapter3 == null || (listE4 = downloadShortTvEpListAdapter3.e()) == null) ? 0 : listE4.size()) - this.C <= this.D ? Utils.a().getString(R$string.download_short_tv_watch_ad_all) : String.valueOf((this.H - this.G) + 1);
        Intrinsics.f(string, "if ((shortTVEpAdapter?.d…tPosition + 1).toString()");
        new Handler().postDelayed(new Runnable() { // from class: com.transsnet.downloader.fragment.c1
            @Override // java.lang.Runnable
            public final void run() {
                DownloadReDetectorShortTVFragment.C2(string);
            }
        }, 400L);
        StringBuilder sb2 = new StringBuilder();
        int i13 = this.G;
        int i14 = this.H;
        if (i13 <= i14) {
            while (true) {
                if (sb2.length() > 0) {
                    sb2.append(",");
                }
                sb2.append(i13);
                if (i13 == i14) {
                    break;
                } else {
                    i13++;
                }
            }
        }
        com.transsnet.downloader.report.b bVarG2 = g2();
        Subject subject = this.L;
        String string2 = sb2.toString();
        Intrinsics.f(string2, "reportEpBuilder.toString()");
        com.transsnet.downloader.report.b.i(bVarG2, subject, str, string2, null, 8, null);
        int i15 = this.C;
        int i16 = this.H;
        if (i15 < i16) {
            this.C = i16;
            DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = Y0();
            Map<Integer, f00.c> mapF = (downloadResourcesDetectorViewModelY0 == null || (c0VarE = downloadResourcesDetectorViewModelY0.E()) == null) ? null : c0VarE.f();
            if (mapF == null) {
                mapF = new LinkedHashMap<>();
            }
            DownloadShortTvEpListAdapter downloadShortTvEpListAdapter4 = this.B;
            int size = (downloadShortTvEpListAdapter4 == null || (listE3 = downloadShortTvEpListAdapter4.e()) == null) ? 0 : listE3.size();
            int i17 = this.H;
            if (size >= i17) {
                for (int i18 = this.G - 1; i18 < i17; i18++) {
                    DownloadShortTvEpListAdapter downloadShortTvEpListAdapter5 = this.B;
                    if (i18 < ((downloadShortTvEpListAdapter5 == null || (listE2 = downloadShortTvEpListAdapter5.e()) == null) ? 0 : listE2.size())) {
                        DownloadShortTvEpListAdapter downloadShortTvEpListAdapter6 = this.B;
                        f00.c cVar = (downloadShortTvEpListAdapter6 == null || (listE = downloadShortTvEpListAdapter6.e()) == null) ? null : listE.get(i18);
                        if (cVar != null) {
                            if (this.R) {
                                cVar.g(true);
                                mapF.put(Integer.valueOf(i18), cVar);
                            }
                            cVar.f(true);
                            DownloadShortTvEpListAdapter downloadShortTvEpListAdapter7 = this.B;
                            if (downloadShortTvEpListAdapter7 != null) {
                                downloadShortTvEpListAdapter7.notifyItemChanged(i18, cVar);
                            }
                        }
                    }
                }
            }
            DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY1 = Y0();
            androidx.lifecycle.c0<Map<Integer, f00.c>> c0VarE2 = downloadResourcesDetectorViewModelY1 != null ? downloadResourcesDetectorViewModelY1.E() : null;
            if (c0VarE2 != null) {
                c0VarE2.q(mapF);
            }
        }
        r2();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        List<f00.c> listE;
        DownloadShortTvEpListAdapter downloadShortTvEpListAdapter = this.B;
        if (downloadShortTvEpListAdapter == null || (listE = downloadShortTvEpListAdapter.e()) == null || listE.size() != 0) {
            return;
        }
        K2();
        r2();
    }

    public final void F2(boolean z11) {
        if (this.C > 30) {
            H2(z11);
        } else {
            G2(z11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [T, java.util.LinkedHashMap] */
    public final void H2(boolean z11) {
        androidx.lifecycle.c0<Map<Integer, f00.c>> c0VarE;
        FrameLayout frameLayout;
        h00.g0 g0Var = (h00.g0) getMViewBinding();
        if (g0Var != null && (frameLayout = g0Var.f65859h) != null) {
            so.c.k(frameLayout);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = Y0();
        T tF = (downloadResourcesDetectorViewModelY0 == null || (c0VarE = downloadResourcesDetectorViewModelY0.E()) == null) ? 0 : c0VarE.f();
        objectRef.element = tF;
        if (tF == 0) {
            objectRef.element = new LinkedHashMap();
        }
        ((Map) objectRef.element).clear();
        kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this), null, null, new DownloadReDetectorShortTVFragment$selectAllWithSizeMoreThan30$1(this, z11, objectRef, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void I2() {
        FrameLayout frameLayout;
        h00.g0 g0Var = (h00.g0) getMViewBinding();
        if (g0Var == null || (frameLayout = g0Var.f65860i) == null) {
            return;
        }
        frameLayout.removeAllViews();
        frameLayout.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void J2() {
        FrameLayout frameLayout;
        h00.g0 g0Var = (h00.g0) getMViewBinding();
        if (g0Var == null || (frameLayout = g0Var.f65860i) == null) {
            return;
        }
        frameLayout.removeAllViews();
        frameLayout.setVisibility(0);
        frameLayout.addView(d2());
    }

    public final void M2() {
        List<f00.c> listE;
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(com.tn.lib.widget.R$string.no_network_toast);
            return;
        }
        uo.b.a aVar = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "showWatchAd", false, 4, null);
        DownloadShortTvEpListAdapter downloadShortTvEpListAdapter = this.B;
        int size = ((downloadShortTvEpListAdapter == null || (listE = downloadShortTvEpListAdapter.e()) == null) ? 0 : listE.size()) - this.C;
        int i11 = this.D;
        String string = size <= i11 ? Utils.a().getString(R$string.download_short_tv_watch_ad_all) : String.valueOf(i11);
        Intrinsics.f(string, "if ((shortTVEpAdapter?.d…perUnlockCount.toString()");
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = Y0();
        androidx.lifecycle.c0<String> c0VarC = downloadResourcesDetectorViewModelY0 != null ? downloadResourcesDetectorViewModelY0.C() : null;
        if (c0VarC != null) {
            c0VarC.q(string);
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY1 = Y0();
        androidx.lifecycle.c0<String> c0VarG = downloadResourcesDetectorViewModelY1 != null ? downloadResourcesDetectorViewModelY1.G() : null;
        if (c0VarG != null) {
            c0VarG.q(this.M);
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY2 = Y0();
        androidx.lifecycle.c0<Integer> c0VarO = downloadResourcesDetectorViewModelY2 != null ? downloadResourcesDetectorViewModelY2.o() : null;
        if (c0VarO != null) {
            c0VarO.q(6);
        }
        com.transsnet.downloader.report.b.d(g2(), this.M, "dialog_minitv_download_unlock", null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void N2(DownloadListBean downloadListBean) {
        List<f00.c> listE;
        String subjectId;
        DownloadInfoExtendView downloadInfoExtendView;
        ShapeableImageView shapeableImageView;
        String thumbnail;
        String url;
        Subject subject;
        if (this.A) {
            return;
        }
        Integer totalEpisode = downloadListBean.getTotalEpisode();
        if (totalEpisode != null && totalEpisode.intValue() == 0) {
            return;
        }
        int i11 = this.C;
        Integer totalEpisode2 = downloadListBean.getTotalEpisode();
        if (i11 > (totalEpisode2 != null ? totalEpisode2.intValue() : 1)) {
            Integer totalEpisode3 = downloadListBean.getTotalEpisode();
            this.C = totalEpisode3 != null ? totalEpisode3.intValue() : 1;
        }
        if (this.L == null) {
            this.L = new Subject(downloadListBean.getSubjectId(), Integer.valueOf(downloadListBean.getSubjectType()), downloadListBean.getSubjectTitle(), null, null, null, downloadListBean.getDescription(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, null, null, -72, 4194303, null);
        }
        Subject subject2 = this.L;
        if ((subject2 != null ? subject2.getShortTVFavInfo() : null) == null && (subject = this.L) != null) {
            ShortTVFavInfo shortTVFavInfo = downloadListBean.getShortTVFavInfo();
            String favoriteNum = shortTVFavInfo != null ? shortTVFavInfo.getFavoriteNum() : null;
            ShortTVFavInfo shortTVFavInfo2 = downloadListBean.getShortTVFavInfo();
            boolean hasFavorite = shortTVFavInfo2 != null ? shortTVFavInfo2.getHasFavorite() : false;
            ShortTVFavInfo shortTVFavInfo3 = downloadListBean.getShortTVFavInfo();
            subject.setShortTVFavInfo(new ShortTVFavInfo(favoriteNum, hasFavorite, shortTVFavInfo3 != null ? shortTVFavInfo3.getFavoriteTime() : null));
        }
        this.A = true;
        h00.g0 g0Var = (h00.g0) getMViewBinding();
        AppCompatTextView appCompatTextView = g0Var != null ? g0Var.E : null;
        if (appCompatTextView != null) {
            appCompatTextView.setText(downloadListBean.getSubjectTitle());
        }
        h00.g0 g0Var2 = (h00.g0) getMViewBinding();
        AppCompatTextView appCompatTextView2 = g0Var2 != null ? g0Var2.D : null;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(downloadListBean.getSubjectTitle());
        }
        h00.g0 g0Var3 = (h00.g0) getMViewBinding();
        if (g0Var3 != null && (shapeableImageView = g0Var3.f65865n) != null) {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            Cover cover = downloadListBean.getCover();
            String str = (cover == null || (url = cover.getUrl()) == null) ? "" : url;
            int i12 = R$color.module_04;
            int width = shapeableImageView.getWidth();
            int height = shapeableImageView.getHeight();
            Cover cover2 = downloadListBean.getCover();
            companion.o(contextRequireContext, shapeableImageView, str, (32704 & 8) != 0 ? R$color.skeleton : i12, (32704 & 16) != 0 ? companion.d() : width, (32704 & 32) != 0 ? companion.c() : height, (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) ? "" : thumbnail, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
        }
        V1(downloadListBean);
        String genre = downloadListBean.getGenre();
        if (genre != null && genre.length() != 0) {
            StringBuffer stringBuffer = new StringBuffer();
            String releaseDate = downloadListBean.getReleaseDate();
            if (releaseDate != null && releaseDate.length() > 0) {
                Date dateK = com.blankj.utilcode.util.h0.k(downloadListBean.getReleaseDate(), "yyyy-MM-dd");
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(dateK);
                stringBuffer.append(String.valueOf(calendar.get(1)));
            }
            String genre2 = downloadListBean.getGenre();
            if (genre2 != null && genre2.length() > 0) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(" • ");
                }
                String genre3 = downloadListBean.getGenre();
                stringBuffer.append(genre3 != null ? kotlin.text.l.F(genre3, "，", " • ", false, 4, null) : null);
            }
            String countryName = downloadListBean.getCountryName();
            if (countryName != null && countryName.length() > 0) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(" • ");
                }
                stringBuffer.append(downloadListBean.getCountryName());
            }
            h00.g0 g0Var4 = (h00.g0) getMViewBinding();
            AppCompatTextView appCompatTextView3 = g0Var4 != null ? g0Var4.f65877z : null;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setText(stringBuffer);
            }
        }
        h00.g0 g0Var5 = (h00.g0) getMViewBinding();
        BLImageView bLImageView = g0Var5 != null ? g0Var5.f65866o : null;
        if (bLImageView != null) {
            ShortTVFavInfo shortTVFavInfo4 = downloadListBean.getShortTVFavInfo();
            bLImageView.setSelected(shortTVFavInfo4 != null ? shortTVFavInfo4.getHasFavorite() : false);
        }
        h00.g0 g0Var6 = (h00.g0) getMViewBinding();
        if (g0Var6 != null && (downloadInfoExtendView = g0Var6.f65861j) != null) {
            String description = downloadListBean.getDescription();
            if (description == null) {
                description = "";
            }
            downloadInfoExtendView.showData(description);
        }
        Subject subject3 = this.L;
        int totalEpisode4 = subject3 != null ? subject3.getTotalEpisode() : 0;
        Integer totalEpisode5 = downloadListBean.getTotalEpisode();
        int iMax = Math.max(totalEpisode4, totalEpisode5 != null ? totalEpisode5.intValue() : 0);
        if (iMax > 0) {
            U1(iMax);
            int i13 = 0;
            while (i13 < iMax) {
                DownloadShortTvEpListAdapter downloadShortTvEpListAdapter = this.B;
                if (downloadShortTvEpListAdapter != null && (listE = downloadShortTvEpListAdapter.e()) != null) {
                    Subject subject4 = this.L;
                    listE.add(new f00.c((subject4 == null || (subjectId = subject4.getSubjectId()) == null) ? "" : subjectId, i13, i13 < this.C, false, this.F.containsKey(Integer.valueOf(i13)), 8, null));
                }
                i13++;
            }
            DownloadShortTvEpListAdapter downloadShortTvEpListAdapter2 = this.B;
            if (downloadShortTvEpListAdapter2 != null) {
                downloadShortTvEpListAdapter2.notifyItemRangeChanged(0, iMax);
            }
        }
    }

    public final void O2(List<? extends DownloadBean> list, int i11, int i12) {
        Long lF;
        HashMap<String, String> mapG;
        DownloadShortTvEpListAdapter downloadShortTvEpListAdapter;
        List<f00.c> listE;
        List<f00.c> listE2;
        androidx.lifecycle.c0<Long> c0VarF;
        uo.b.a aVar = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "updateList ,  size = " + (list != null ? Integer.valueOf(list.size()) : null), false, 4, null);
        List<? extends DownloadBean> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            this.V = false;
            Function0<Unit> function0 = this.W;
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = Y0();
        if (downloadResourcesDetectorViewModelY0 == null || (c0VarF = downloadResourcesDetectorViewModelY0.F()) == null || (lF = c0VarF.f()) == null) {
            lF = 0L;
        }
        long jLongValue = lF.longValue();
        String TAG2 = X0();
        Intrinsics.f(TAG2, "TAG");
        uo.b.a.f(aVar, TAG2, "before curTotalSize:" + jLongValue, false, 4, null);
        int size = list.size();
        long jLongValue2 = jLongValue;
        boolean z11 = false;
        for (int i13 = 0; i13 < size; i13++) {
            int i14 = (i11 + i13) - 1;
            DownloadBean downloadBean = list.get(i13);
            DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
            String resourceId = downloadBean.getResourceId();
            if (resourceId == null) {
                resourceId = downloadBean.getUrl();
            }
            DownloadBean downloadBeanL = downloadEsHelperA.l(resourceId);
            if (this.R) {
                if (downloadBeanL != null) {
                    downloadBeanL.setCheck(true);
                }
                downloadBean.setCheck(true);
                Long size2 = downloadBean.getSize();
                jLongValue2 += size2 != null ? size2.longValue() : 0L;
            }
            if (downloadBeanL != null) {
                downloadBeanL.setUploadBy(downloadBean.getUploadBy());
                arrayList.add(downloadBeanL);
                downloadBeanL.setPosition(i14);
                this.E.put(Integer.valueOf(i14), downloadBeanL);
                uo.b.a aVar2 = uo.b.f78622a;
                String TAG3 = X0();
                Intrinsics.f(TAG3, "TAG");
                uo.b.a.f(aVar2, TAG3, "in download ep:" + downloadBeanL.getEp() + ", status:" + downloadBeanL.getStatus(), false, 4, null);
            } else {
                downloadBean.setPosition(i14);
                arrayList.add(downloadBean);
                this.E.put(Integer.valueOf(i14), downloadBean);
            }
            if (downloadBeanL != null && downloadBeanL.isUnable()) {
                this.S++;
                this.F.put(Integer.valueOf(i14), downloadBeanL);
                uo.b.a aVar3 = uo.b.f78622a;
                String TAG4 = X0();
                Intrinsics.f(TAG4, "TAG");
                uo.b.a.s(aVar3, TAG4, "unable index:" + i14 + "， plus size = " + this.S, false, 4, null);
                DownloadShortTvEpListAdapter downloadShortTvEpListAdapter2 = this.B;
                if (i14 < ((downloadShortTvEpListAdapter2 == null || (listE2 = downloadShortTvEpListAdapter2.e()) == null) ? 0 : listE2.size())) {
                    DownloadShortTvEpListAdapter downloadShortTvEpListAdapter3 = this.B;
                    f00.c cVar = (downloadShortTvEpListAdapter3 == null || (listE = downloadShortTvEpListAdapter3.e()) == null) ? null : (f00.c) CollectionsKt___CollectionsKt.h0(listE, i14);
                    if (cVar != null) {
                        cVar.e(true);
                    }
                    z11 = true;
                }
            }
        }
        if (z11 && (downloadShortTvEpListAdapter = this.B) != null) {
            downloadShortTvEpListAdapter.notifyItemRangeChanged(i11 - 1, list.size());
        }
        uo.b.a aVar4 = uo.b.f78622a;
        String TAG5 = X0();
        Intrinsics.f(TAG5, "TAG");
        uo.b.a.s(aVar4, TAG5, "update data curTotalSize:" + jLongValue2, false, 4, null);
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY1 = Y0();
        androidx.lifecycle.c0<Long> c0VarF2 = downloadResourcesDetectorViewModelY1 != null ? downloadResourcesDetectorViewModelY1.F() : null;
        if (c0VarF2 != null) {
            c0VarF2.q(Long.valueOf(jLongValue2));
        }
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.j(true);
        }
        com.transsion.baselib.report.h logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null && (mapG = logViewConfig2.g()) != null) {
            mapG.put("size", String.valueOf(arrayList.size()));
        }
        W1(i12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void U1(int i11) {
        TabLayout tabLayout;
        TabLayout tabLayout2;
        TabLayout tabLayout3;
        int i12 = (i11 + 24) / 25;
        if (i12 <= 1) {
            h00.g0 g0Var = (h00.g0) getMViewBinding();
            if (g0Var == null || (tabLayout3 = g0Var.f65872u) == null) {
                return;
            }
            so.c.g(tabLayout3);
            return;
        }
        h00.g0 g0Var2 = (h00.g0) getMViewBinding();
        if (g0Var2 != null && (tabLayout2 = g0Var2.f65872u) != null) {
            tabLayout2.removeAllTabs();
            tabLayout2.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new b());
        }
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = i13 * 25;
            int i15 = i14 + 1;
            int iG = kotlin.ranges.a.g(i14 + 25, i11);
            h00.g0 g0Var3 = (h00.g0) getMViewBinding();
            if (g0Var3 != null && (tabLayout = g0Var3.f65872u) != null) {
                tabLayout.addTab(tabLayout.newTab().setText(i15 + "-" + iG));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V1(DownloadListBean downloadListBean) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        List<String> tags = downloadListBean.getTags();
        if (tags == null || tags.isEmpty()) {
            h00.g0 g0Var = (h00.g0) getMViewBinding();
            if (g0Var == null || (recyclerView = g0Var.f65871t) == null) {
                return;
            }
            so.c.g(recyclerView);
            return;
        }
        List<String> tags2 = downloadListBean.getTags();
        Intrinsics.d(tags2);
        com.transsnet.downloader.adapter.o oVar = new com.transsnet.downloader.adapter.o(tags2);
        h00.g0 g0Var2 = (h00.g0) getMViewBinding();
        if (g0Var2 == null || (recyclerView2 = g0Var2.f65871t) == null) {
            return;
        }
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(recyclerView2.getContext());
        flexboxLayoutManager.P(0);
        flexboxLayoutManager.Q(1);
        flexboxLayoutManager.R(0);
        recyclerView2.setLayoutManager(flexboxLayoutManager);
        com.google.android.flexbox.d dVar = new com.google.android.flexbox.d(recyclerView2.getContext());
        dVar.setOrientation(3);
        dVar.setDrawable(z2.a.getDrawable(Utils.a(), R$drawable.space_short_tv_tag_decoration));
        recyclerView2.addItemDecoration(dVar);
        recyclerView2.setAdapter(oVar);
    }

    public final void W1(int i11) {
        int i12 = this.C;
        if (i11 >= i12) {
            this.V = false;
            Function0<Unit> function0 = this.W;
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        int i13 = i12 - i11;
        if (i13 > 20) {
            this.G = i11 + 1;
            this.H = i11 + 20;
        } else {
            int i14 = i11 + 1;
            this.G = i14;
            this.H = (i14 + i13) - 1;
        }
        r2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View Z1() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(requireContext());
        int i11 = R$layout.layout_download_short_tv_loading;
        h00.g0 g0Var = (h00.g0) getMViewBinding();
        return layoutInflaterFrom.inflate(i11, (ViewGroup) (g0Var != null ? g0Var.f65860i : null), false);
    }

    public final View d2() {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        String string = Utils.a().getString(com.tn.lib.widget.R$string.error_load_failed);
        Intrinsics.f(string, "getApp().getString(com.t…string.error_load_failed)");
        return a2(contextRequireContext, string, false);
    }

    public final View e2() {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        String string = Utils.a().getString(com.tn.lib.widget.R$string.no_network_title);
        Intrinsics.f(string, "getApp().getString(com.t….string.no_network_title)");
        return a2(contextRequireContext, string, true);
    }

    public final ShortTVPlayDao f2() {
        return (ShortTVPlayDao) this.f60767y.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: i2, reason: merged with bridge method [inline-methods] */
    public h00.g0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        h00.g0 g0VarC = h00.g0.c(inflater);
        Intrinsics.f(g0VarC, "inflate(inflater)");
        return g0VarC;
    }

    public final void initHistory() {
        kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        LinearLayoutCompat linearLayoutCompat;
        AppCompatImageView appCompatImageView;
        AppCompatTextView appCompatTextView;
        BLImageView bLImageView;
        BLImageView bLImageView2;
        BLView bLView;
        ImageView imageView;
        h00.g0 g0Var = (h00.g0) getMViewBinding();
        if (g0Var != null && (imageView = g0Var.f65864m) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.u0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorShortTVFragment.j2(this.f60965a, view);
                }
            });
        }
        h00.g0 g0Var2 = (h00.g0) getMViewBinding();
        if (g0Var2 != null && (bLView = g0Var2.H) != null) {
            bLView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.w0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorShortTVFragment.k2(this.f60977a, view);
                }
            });
        }
        h00.g0 g0Var3 = (h00.g0) getMViewBinding();
        if (g0Var3 != null && (bLImageView2 = g0Var3.f65866o) != null) {
            bLImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.x0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorShortTVFragment.l2(this.f60979a, view);
                }
            });
        }
        h00.g0 g0Var4 = (h00.g0) getMViewBinding();
        if (g0Var4 != null && (bLImageView = g0Var4.f65867p) != null) {
            bLImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.y0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorShortTVFragment.m2(this.f60982a, view);
                }
            });
        }
        h00.g0 g0Var5 = (h00.g0) getMViewBinding();
        if (g0Var5 != null && (appCompatTextView = g0Var5.B) != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.z0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorShortTVFragment.n2(this.f60985a, view);
                }
            });
        }
        h00.g0 g0Var6 = (h00.g0) getMViewBinding();
        if (g0Var6 != null && (appCompatImageView = g0Var6.f65863l) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.a1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorShortTVFragment.o2(this.f60885a, view);
                }
            });
        }
        h00.g0 g0Var7 = (h00.g0) getMViewBinding();
        if (g0Var7 == null || (linearLayoutCompat = g0Var7.f65856d) == null) {
            return;
        }
        linearLayoutCompat.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.b1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadReDetectorShortTVFragment.p2(this.f60899a, view);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        androidx.lifecycle.c0<Integer> c0VarD;
        androidx.lifecycle.c0<String> c0VarH;
        androidx.lifecycle.c0<Long> c0VarF;
        androidx.lifecycle.c0<Map<Integer, f00.c>> c0VarE;
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = Y0();
            if (downloadResourcesDetectorViewModelY0 != null && (c0VarE = downloadResourcesDetectorViewModelY0.E()) != null) {
                c0VarE.j(parentFragment, new e(new Function1<Map<Integer, f00.c>, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$initViewModel$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Map<Integer, f00.c> map) {
                        invoke2(map);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Map<Integer, f00.c> map) {
                        this.this$0.X1();
                    }
                }));
            }
            DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY1 = Y0();
            if (downloadResourcesDetectorViewModelY1 != null && (c0VarF = downloadResourcesDetectorViewModelY1.F()) != null) {
                c0VarF.j(parentFragment, new e(new Function1<Long, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$initViewModel$1$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Long l11) {
                        invoke2(l11);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Long totalSize) {
                        DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment = this.this$0;
                        Intrinsics.f(totalSize, "totalSize");
                        downloadReDetectorShortTVFragment.z2(totalSize.longValue());
                    }
                }));
            }
            DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY2 = Y0();
            if (downloadResourcesDetectorViewModelY2 != null && (c0VarH = downloadResourcesDetectorViewModelY2.H()) != null) {
                c0VarH.j(parentFragment, new e(new Function1<String, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$initViewModel$1$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String type) {
                        DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment = this.this$0;
                        Intrinsics.f(type, "type");
                        downloadReDetectorShortTVFragment.B2(type);
                    }
                }));
            }
            DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY3 = Y0();
            if (downloadResourcesDetectorViewModelY3 != null && (c0VarD = downloadResourcesDetectorViewModelY3.D()) != null) {
                c0VarD.j(parentFragment, new e(new Function1<Integer, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$initViewModel$1$4
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke2(num);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Integer num) {
                        int i11;
                        if (num != null && num.intValue() == 0) {
                            i11 = com.tn.lib.widget.R$string.failed_toast;
                        } else {
                            i11 = (num != null && num.intValue() == 2) ? R$string.short_tv_favorite_remove_toast : R$string.short_tv_favorite_toast;
                        }
                        zp.b.f82110a.d(i11);
                    }
                }));
            }
        }
        Context context = getContext();
        Intrinsics.e(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1<j00.c, Unit> function1 = new Function1<j00.c, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment.initViewModel.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(j00.c cVar) {
                invoke2(cVar);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(j00.c value) {
                ShortTVFavInfo shortTVFavInfo;
                Intrinsics.g(value, "value");
                try {
                    if (TextUtils.equals(value.c(), DownloadReDetectorShortTVFragment.this.M)) {
                        Subject subject = DownloadReDetectorShortTVFragment.this.L;
                        if (subject != null && (shortTVFavInfo = subject.getShortTVFavInfo()) != null) {
                            shortTVFavInfo.setFavoriteNum(value.b());
                            shortTVFavInfo.setHasFavorite(value.a());
                        }
                        h00.g0 g0Var = (h00.g0) DownloadReDetectorShortTVFragment.this.getMViewBinding();
                        BLImageView bLImageView = g0Var != null ? g0Var.f65866o : null;
                        if (bLImageView == null) {
                            return;
                        }
                        bLImageView.setSelected(value.a());
                    }
                } catch (Exception unused) {
                    uo.b.a.g(uo.b.f78622a, " callback change data fail", false, 2, null);
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = j00.c.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent((AppCompatActivity) context, name, Lifecycle.State.CREATED, kotlinx.coroutines.w0.c().q(), false, function1);
        Fragment parentFragment2 = getParentFragment();
        if (parentFragment2 != null) {
            int i11 = RoomAppMMKV.f51271a.a().getInt("download_last_resolution", 0);
            DownloadListManager.a aVar = DownloadListManager.f61186m;
            aVar.a().k(i11);
            androidx.lifecycle.c0<DownloadListBean> c0Var = aVar.a().p().get(Integer.valueOf(i11));
            if (c0Var != null) {
                c0Var.j(parentFragment2, new e(new Function1<DownloadListBean, Unit>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$initViewModel$3$1
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
                        String title;
                        List<f00.c> listE;
                        this.this$0.I2();
                        if (downloadListBean == null) {
                            DownloadShortTvEpListAdapter downloadShortTvEpListAdapter = this.this$0.B;
                            if (downloadShortTvEpListAdapter == null || (listE = downloadShortTvEpListAdapter.e()) == null || listE.size() != 0) {
                                return;
                            }
                            this.this$0.J2();
                            return;
                        }
                        uo.b.a aVar2 = uo.b.f78622a;
                        String TAG = this.this$0.X0();
                        Intrinsics.f(TAG, "TAG");
                        List<DownloadItem> items = downloadListBean.getItems();
                        uo.b.a.f(aVar2, TAG, "get data from  net, size = " + (items != null ? Integer.valueOf(items.size()) : null), false, 4, null);
                        Integer totalEpisode = downloadListBean.getTotalEpisode();
                        if (totalEpisode != null && totalEpisode.intValue() == 0) {
                            Subject subject = this.this$0.L;
                            downloadListBean.setTotalEpisode(Integer.valueOf(subject != null ? subject.getTotalEpisode() : 0));
                        }
                        this.this$0.N2(downloadListBean);
                        DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment = this.this$0;
                        DownloadUtil downloadUtil = DownloadUtil.f61136a;
                        Subject subject2 = downloadReDetectorShortTVFragment.L;
                        String str = this.this$0.N;
                        String str2 = this.this$0.J;
                        String str3 = this.this$0.K;
                        String str4 = this.this$0.O;
                        Subject subject3 = this.this$0.L;
                        if (subject3 == null || (title = subject3.getTitle()) == null) {
                            title = "";
                        }
                        downloadReDetectorShortTVFragment.O2(downloadUtil.q(downloadListBean, subject2, (128 & 4) != 0 ? null : str, (128 & 8) != 0 ? null : str2, (128 & 16) != 0 ? null : str3, (128 & 32) != 0 ? null : str4, (128 & 64) != 0 ? null : title, (128 & 128) != 0 ? null : null), downloadListBean.getStartPosition(), downloadListBean.getEndPosition());
                    }
                }));
            }
        }
        uo.b.a aVar2 = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar2, TAG, "initViewModel ,loadData", false, 4, null);
        K2();
        r2();
    }

    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment, com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        String string;
        String string2;
        String string3;
        HashMap<String, String> mapG;
        HashMap<String, String> mapG2;
        HashMap<String, String> mapG3;
        HashMap<String, String> mapG4;
        HashMap<String, String> mapG5;
        String subjectId;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        String string4 = arguments != null ? arguments.getString("extra_page_from") : null;
        String str = "";
        if (string4 == null) {
            string4 = "";
        }
        this.J = string4;
        Bundle arguments2 = getArguments();
        String string5 = arguments2 != null ? arguments2.getString("extra_last_page_from") : null;
        if (string5 == null) {
            string5 = "";
        }
        this.K = string5;
        Bundle arguments3 = getArguments();
        this.L = (Subject) (arguments3 != null ? arguments3.getSerializable("extra_subject") : null);
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (string = arguments4.getString("extra_subject_id")) == null) {
            string = "";
        }
        this.M = string;
        Bundle arguments5 = getArguments();
        if (arguments5 == null || (string2 = arguments5.getString("extra_ops")) == null) {
            string2 = "";
        }
        this.O = string2;
        Bundle arguments6 = getArguments();
        if (arguments6 == null || (string3 = arguments6.getString("extra_module_name")) == null) {
            string3 = "";
        }
        this.P = string3;
        Bundle arguments7 = getArguments();
        this.Q = arguments7 != null ? arguments7.getBoolean("extra_download_scroll_to_download") : false;
        Subject subject = this.L;
        if (subject != null) {
            this.M = subject != null ? subject.getSubjectId() : null;
        }
        ShortTvMmkv shortTvMmkv = ShortTvMmkv.f61142a;
        Subject subject2 = this.L;
        if (subject2 != null && (subjectId = subject2.getSubjectId()) != null) {
            str = subjectId;
        }
        this.C = shortTvMmkv.c(str);
        this.D = shortTvMmkv.e();
        int i11 = this.C;
        if (i11 > 20) {
            i11 = 20;
        }
        this.H = i11;
        com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (mapG5 = logViewConfig.g()) != null) {
            mapG5.put(WebConstants.PAGE_FROM, this.J);
        }
        com.transsion.baselib.report.h logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null && (mapG4 = logViewConfig2.g()) != null) {
            mapG4.put("last_page_from", this.K);
        }
        com.transsion.baselib.report.h logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 != null && (mapG3 = logViewConfig3.g()) != null) {
            Subject subject3 = this.L;
            mapG3.put("subject_id", subject3 != null ? subject3.getSubjectId() : null);
        }
        com.transsion.baselib.report.h logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 != null && (mapG2 = logViewConfig4.g()) != null) {
            mapG2.put("ops", this.O);
        }
        com.transsion.baselib.report.h logViewConfig5 = getLogViewConfig();
        if (logViewConfig5 != null && (mapG = logViewConfig5.g()) != null) {
            mapG.put("type", "2");
        }
        com.transsnet.downloader.report.b.d(g2(), this.M, "dialog_minitv_download", null, 4, null);
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

    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        initHistory();
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00f4  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [T, com.transsion.baselib.db.download.DownloadBean] */
    public final void s2(long j11) {
        ProgressBar progressBar;
        BLFrameLayout bLFrameLayout;
        ProgressBar progressBar2;
        AppCompatTextView appCompatTextView;
        AppCompatImageView appCompatImageView;
        View view;
        androidx.lifecycle.c0<Map<Integer, f00.c>> c0VarE;
        Map<Integer, f00.c> mapF;
        DownloadBean downloadBean;
        if (a1(j11)) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = Y0();
        if (downloadResourcesDetectorViewModelY0 != null && (c0VarE = downloadResourcesDetectorViewModelY0.E()) != null && (mapF = c0VarE.f()) != null) {
            for (Map.Entry<Integer, f00.c> entry : mapF.entrySet()) {
                if (this.E.containsKey(entry.getKey()) && (downloadBean = this.E.get(entry.getKey())) != null) {
                    arrayList.add(downloadBean);
                }
            }
        }
        uo.b.a aVar = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "onDownload ", false, 4, null);
        h00.g0 g0Var = (h00.g0) getMViewBinding();
        if (g0Var != null && (view = g0Var.G) != null) {
            so.c.k(view);
        }
        h00.g0 g0Var2 = (h00.g0) getMViewBinding();
        if (g0Var2 != null && (appCompatImageView = g0Var2.f65862k) != null) {
            so.c.g(appCompatImageView);
        }
        h00.g0 g0Var3 = (h00.g0) getMViewBinding();
        if (g0Var3 != null && (appCompatTextView = g0Var3.f65874w) != null) {
            so.c.g(appCompatTextView);
        }
        h00.g0 g0Var4 = (h00.g0) getMViewBinding();
        if (g0Var4 != null && (progressBar2 = g0Var4.f65868q) != null) {
            so.c.k(progressBar2);
        }
        h00.g0 g0Var5 = (h00.g0) getMViewBinding();
        if (g0Var5 != null && (bLFrameLayout = g0Var5.f65858g) != null) {
            so.c.k(bLFrameLayout);
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        int i11 = 0;
        for (Object obj : arrayList) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.g.u();
            }
            ?? r11 = (DownloadBean) obj;
            String string = UUID.randomUUID().toString();
            Intrinsics.f(string, "randomUUID().toString()");
            r11.setTaskId(string);
            if (objectRef.element != 0) {
                int ep2 = r11.getEp();
                DownloadBean downloadBean2 = (DownloadBean) objectRef.element;
                if (ep2 < (downloadBean2 != null ? downloadBean2.getEp() : 0)) {
                    objectRef.element = r11;
                }
            } else {
                objectRef.element = r11;
            }
            Y1(this.J, this.K, r11.getSubjectId(), r11.getPostId(), this.O, r11.getResourceId(), string);
            uo.b.f78622a.n(DownloadBaseRunnable.TAG, new String[]{"剧集多资源，下载点击，开始下载: subjectId = " + r11.getSubjectId() + ",resourceId = " + r11.getResourceId() + ", name = " + r11.getTotalTitleName()}, true);
            i11 = i12;
        }
        U0().D(arrayList);
        h2().d(arrayList);
        kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this), null, null, new DownloadReDetectorShortTVFragment$onDownload$3(this, null), 3, null);
        long size = ((long) ((arrayList.size() / 20) * 100)) + 300;
        h00.g0 g0Var6 = (h00.g0) getMViewBinding();
        if (g0Var6 == null || (progressBar = g0Var6.f65868q) == null) {
            return;
        }
        progressBar.postDelayed(new Runnable() { // from class: com.transsnet.downloader.fragment.d1
            @Override // java.lang.Runnable
            public final void run() {
                DownloadReDetectorShortTVFragment.t2(arrayList, this, objectRef);
            }
        }, size);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void u2(TabLayout.Tab tab) {
        RecyclerView recyclerView;
        h00.g0 g0Var;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        if (tab == null || !tab.isSelected()) {
            return;
        }
        this.I = tab.getPosition();
        int position = tab.getPosition() * 25;
        h00.g0 g0Var2 = (h00.g0) getMViewBinding();
        RecyclerView.m layoutManager = (g0Var2 == null || (recyclerView3 = g0Var2.f65870s) == null) ? null : recyclerView3.getLayoutManager();
        GridLayoutManager gridLayoutManager = layoutManager instanceof GridLayoutManager ? (GridLayoutManager) layoutManager : null;
        if (gridLayoutManager != null) {
            int iFindFirstCompletelyVisibleItemPosition = ((position - gridLayoutManager.findFirstCompletelyVisibleItemPosition()) / 5) * this.f60765w;
            h00.g0 g0Var3 = (h00.g0) getMViewBinding();
            if (g0Var3 == null || (recyclerView = g0Var3.f65870s) == null || !recyclerView.canScrollVertically(iFindFirstCompletelyVisibleItemPosition) || (g0Var = (h00.g0) getMViewBinding()) == null || (recyclerView2 = g0Var.f65870s) == null) {
                return;
            }
            recyclerView2.scrollBy(0, iFindFirstCompletelyVisibleItemPosition);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        initView();
        D2();
    }

    public final void v2(View view) {
        ShortTVFavInfo shortTVFavInfo;
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 500L)) {
            return;
        }
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(com.tn.lib.widget.R$string.no_network_toast);
            return;
        }
        com.transsnet.downloader.report.b bVarG2 = g2();
        String str = this.M;
        Subject subject = this.L;
        bVarG2.e(str, "", (subject == null || (shortTVFavInfo = subject.getShortTVFavInfo()) == null) ? false : shortTVFavInfo.getHasFavorite(), "minitv_download");
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = Y0();
        if (downloadResourcesDetectorViewModelY0 != null) {
            downloadResourcesDetectorViewModelY0.e(this.L);
        }
    }

    public final void w2(int i11) {
        Long lF;
        androidx.lifecycle.c0<Long> c0VarF;
        androidx.lifecycle.c0<Long> c0VarF2;
        Long size;
        DownloadShortTvEpListAdapter downloadShortTvEpListAdapter = this.B;
        Intrinsics.d(downloadShortTvEpListAdapter);
        List<f00.c> listE = downloadShortTvEpListAdapter.e();
        if (i11 >= listE.size()) {
            return;
        }
        f00.c cVar = listE.get(i11);
        if (cVar.b()) {
            return;
        }
        if (!cVar.c()) {
            if (i11 == this.C) {
                M2();
                return;
            } else {
                zp.b.f82110a.d(R$string.unlock_in_order);
                return;
            }
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY0 = Y0();
        if (downloadResourcesDetectorViewModelY0 != null) {
            downloadResourcesDetectorViewModelY0.J(cVar);
        }
        DownloadBean downloadBean = this.E.get(Integer.valueOf(i11));
        long jLongValue = (downloadBean == null || (size = downloadBean.getSize()) == null) ? 0L : size.longValue();
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY1 = Y0();
        if (downloadResourcesDetectorViewModelY1 == null || (c0VarF2 = downloadResourcesDetectorViewModelY1.F()) == null || (lF = c0VarF2.f()) == null) {
            lF = 0L;
        }
        long jLongValue2 = lF.longValue();
        if (cVar.d()) {
            cVar.g(false);
            DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY2 = Y0();
            c0VarF = downloadResourcesDetectorViewModelY2 != null ? downloadResourcesDetectorViewModelY2.F() : null;
            if (c0VarF != null) {
                c0VarF.q(Long.valueOf(jLongValue2 - jLongValue));
            }
        } else {
            cVar.g(true);
            DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModelY3 = Y0();
            c0VarF = downloadResourcesDetectorViewModelY3 != null ? downloadResourcesDetectorViewModelY3.F() : null;
            if (c0VarF != null) {
                c0VarF.q(Long.valueOf(jLongValue2 + jLongValue));
            }
        }
        DownloadShortTvEpListAdapter downloadShortTvEpListAdapter2 = this.B;
        if (downloadShortTvEpListAdapter2 != null) {
            downloadShortTvEpListAdapter2.notifyItemChanged(i11, cVar);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }

    public final void x2(View view) {
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 500L)) {
            return;
        }
        com.alibaba.android.arouter.launcher.a.d().b("/shorts/detail").withSerializable("item_object", this.L).navigation();
        S0();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean y0() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z2(long j11) {
        AppCompatTextView appCompatTextView;
        if (j11 <= 0) {
            h00.g0 g0Var = (h00.g0) getMViewBinding();
            appCompatTextView = g0Var != null ? g0Var.f65874w : null;
            if (appCompatTextView == null) {
                return;
            }
            appCompatTextView.setText(Utils.a().getString(R$string.str_download));
            return;
        }
        uo.b.a aVar = uo.b.f78622a;
        String TAG = X0();
        Intrinsics.f(TAG, "TAG");
        uo.b.a.s(aVar, TAG, "observe totalSize:" + j11, false, 4, null);
        this.T = tp.a.a(j11, 1);
        h00.g0 g0Var2 = (h00.g0) getMViewBinding();
        appCompatTextView = g0Var2 != null ? g0Var2.f65874w : null;
        if (appCompatTextView == null) {
            return;
        }
        String str = Utils.a().getString(R$string.str_download) + " · " + this.T;
        Intrinsics.f(str, "toString(...)");
        appCompatTextView.setText(str);
    }
}
