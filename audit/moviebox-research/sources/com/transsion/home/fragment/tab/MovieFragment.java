package com.transsion.home.fragment.tab;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.google.android.material.tabs.TabLayout;
import com.mbridge.msdk.MBridgeConstans;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.view.NoNetworkBigView;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.R$string;
import com.transsion.home.bean.Channel;
import com.transsion.home.bean.FilterItems;
import com.transsion.home.bean.Item;
import com.transsion.home.bean.LayoutStyle;
import com.transsion.home.bean.MovieBean;
import com.transsion.home.bean.MovieItem;
import com.transsion.home.bean.RefreshBaseDto;
import com.transsion.home.fragment.HomeFragment;
import com.transsion.home.layoutmanager.OffsetGridLayoutManager;
import com.transsion.home.p003enum.HomeTabId;
import com.transsion.home.utils.HomeUtilsKt;
import com.transsion.home.view.filter.popup.PopupFilterView;
import com.transsion.home.viewmodel.MovieViewModel;
import com.transsion.memberapi.IMemberApi;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.web.api.WebConstants;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.json.JSONObject;

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
public final class MovieFragment extends BaseHomeSubFragment<lt.l> {
    public static final a A = new a(null);
    public static final int B = 8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.transsion.home.adapter.a f52510i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MovieViewModel f52511j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f52512k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public FilterItems f52514m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f52515n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f52516o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f52517p;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public PopupFilterView f52520s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f52521t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public nt.b f52523v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Map<String, String> f52524w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f52525x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f52526y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f52527z;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f52509h = LazyKt__LazyJVMKt.b(new Function0<IMemberApi>() { // from class: com.transsion.home.fragment.tab.MovieFragment$memberProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IMemberApi invoke() {
            return (IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class);
        }
    });

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f52513l = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f52518q = 12;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public HashMap<String, HashMap<String, String>> f52519r = new HashMap<>();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f52522u = com.transsion.baselib.report.m.f51277a.f();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ MovieFragment b(a aVar, int i11, boolean z11, String str, String str2, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                z11 = false;
            }
            if ((i12 & 4) != 0) {
                str = null;
            }
            if ((i12 & 8) != 0) {
                str2 = "";
            }
            return aVar.a(i11, z11, str, str2);
        }

        public final MovieFragment a(int i11, boolean z11, String str, String str2) {
            Bundle bundle = new Bundle();
            bundle.putInt("tab_id", i11);
            bundle.putString(WebConstants.TAB_CODE, str2);
            bundle.putBoolean("hide_header_bg", z11);
            bundle.putString("filter_json", str);
            MovieFragment movieFragment = new MovieFragment();
            movieFragment.setArguments(bundle);
            return movieFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements TabLayout.OnTabSelectedListener {
        public b() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
            uo.b.a.f(uo.b.f78622a, "MovieFragment", "release tab " + (tab != null ? Integer.valueOf(tab.getPosition()) : null), false, 4, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            RecyclerView recyclerView;
            uo.b.a.f(uo.b.f78622a, "MovieFragment", "selected tab " + (tab != null ? Integer.valueOf(tab.getPosition()) : null), false, 4, null);
            if (tab != null) {
                MovieFragment.this.J1(tab, true);
            }
            MovieFragment.this.f52521t = SystemClock.elapsedRealtime();
            MovieFragment movieFragment = MovieFragment.this;
            movieFragment.f52522u = movieFragment.p1(movieFragment.f52514m);
            if (tab == null) {
                return;
            }
            MovieFragment.this.f1(tab.getPosition());
            com.transsion.baselib.helper.a.f51183a.g(MovieFragment.this.f52522u, MovieFragment.this.f52522u, (28 & 4) != 0 ? "" : null, (28 & 8) != 0 ? "" : null, (28 & 16) != 0 ? "" : null);
            nt.b bVar = MovieFragment.this.f52523v;
            if (bVar != null) {
                bVar.e();
            }
            MovieFragment movieFragment2 = MovieFragment.this;
            movieFragment2.F1(movieFragment2.f52515n);
            MovieFragment movieFragment3 = MovieFragment.this;
            movieFragment3.S1((HashMap) movieFragment3.f52519r.get(MovieFragment.this.f52515n));
            lt.l lVar = (lt.l) MovieFragment.this.getMViewBinding();
            if (lVar != null && (recyclerView = lVar.f70471c) != null) {
                recyclerView.scrollToPosition(0);
            }
            if (MovieFragment.this.o1() > 2) {
                BiddingListManager biddingListManagerO0 = MovieFragment.this.o0();
                if (biddingListManagerO0 != null) {
                    biddingListManagerO0.C(false);
                    return;
                }
                return;
            }
            BiddingListManager biddingListManagerO1 = MovieFragment.this.o0();
            if (biddingListManagerO1 != null) {
                biddingListManagerO1.C(true);
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
            if (tab != null) {
                MovieFragment.this.J1(tab, false);
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            com.transsion.baselib.helper.a aVar = com.transsion.baselib.helper.a.f51183a;
            MovieFragment movieFragment = MovieFragment.this;
            aVar.j(movieFragment.p1(movieFragment.f52514m), MovieFragment.this.f52522u, String.valueOf(jElapsedRealtime - MovieFragment.this.f52521t));
            uo.b.a.f(uo.b.f78622a, "MovieFragment", "unselected tab " + (tab != null ? Integer.valueOf(tab.getPosition()) : null), false, 4, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements nt.a {
        public c() {
        }

        @Override // nt.a
        public void a(int i11, long j11, View view) {
            List<MovieItem> listD;
            String subjectId;
            String ops;
            com.transsion.home.adapter.a aVar = MovieFragment.this.f52510i;
            if (aVar == null || (listD = aVar.D()) == null) {
                return;
            }
            int size = listD.size();
            MovieFragment movieFragment = MovieFragment.this;
            if (i11 >= size) {
                return;
            }
            com.transsion.home.adapter.a aVar2 = movieFragment.f52510i;
            MovieItem item = aVar2 != null ? aVar2.getItem(i11) : null;
            HashMap map = new HashMap();
            String str = "";
            if (item == null || (subjectId = item.getSubjectId()) == null) {
                subjectId = "";
            }
            map.put("subject_id", subjectId);
            map.put("has_resource", String.valueOf(item != null ? item.getHasResource() : null));
            map.put("sequence", String.valueOf(i11));
            if (item != null && (ops = item.getOps()) != null) {
                str = ops;
            }
            map.put("ops", str);
            map.put("filter_name", movieFragment.j1());
            map.put("browse_duration", String.valueOf(j11));
            com.transsion.baselib.helper.a.f51183a.d(movieFragment.p1(movieFragment.f52514m), map);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends DiffUtil.e<MovieItem> {
        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(MovieItem oldItem, MovieItem newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return Intrinsics.b(oldItem.getSubjectId(), newItem.getSubjectId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(MovieItem oldItem, MovieItem newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return Intrinsics.b(oldItem.getSubjectType(), newItem.getSubjectType());
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e extends RecyclerView.r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f52530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f52531b;

        public e() {
        }

        private final void d(RecyclerView recyclerView) {
            RecyclerView.m layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                if (this.f52530a == null) {
                    this.f52530a = new int[((StaggeredGridLayoutManager) layoutManager).getSpanCount()];
                }
                ((StaggeredGridLayoutManager) layoutManager).findLastCompletelyVisibleItemPositions(this.f52530a);
                this.f52531b = e(this.f52530a);
                return;
            }
            if (layoutManager instanceof GridLayoutManager) {
                this.f52531b = ((GridLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
            } else {
                if (!(layoutManager instanceof LinearLayoutManager)) {
                    throw new RuntimeException("Unsupported layoutManager.");
                }
                this.f52531b = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
            }
        }

        private final int e(int[] iArr) {
            if (iArr == null) {
                return 0;
            }
            int i11 = 0;
            for (int i12 : iArr) {
                if (i12 > i11) {
                    i11 = i12;
                }
            }
            return i11;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            com.transsion.home.adapter.a aVar;
            h9.f fVarQ;
            h9.f fVarQ2;
            Intrinsics.g(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i11);
            RecyclerView.m layoutManager = recyclerView.getLayoutManager();
            int childCount = layoutManager != null ? layoutManager.getChildCount() : 0;
            int itemCount = layoutManager != null ? layoutManager.getItemCount() : 0;
            if (i11 != 0 || childCount <= 0 || this.f52531b < itemCount - 1) {
                return;
            }
            com.transsion.home.adapter.a aVar2 = MovieFragment.this.f52510i;
            if (((aVar2 == null || (fVarQ2 = aVar2.Q()) == null) ? null : fVarQ2.i()) != LoadMoreStatus.Fail || (aVar = MovieFragment.this.f52510i) == null || (fVarQ = aVar.Q()) == null) {
                return;
            }
            fVarQ.v();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            Intrinsics.g(recyclerView, "recyclerView");
            d(recyclerView);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f implements com.tn.lib.util.networkinfo.g {
        public f() {
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected() {
            com.tn.lib.util.networkinfo.g.a.a(this);
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            h9.f fVarQ;
            List<MovieItem> listD;
            List<MovieItem> listD2;
            List<MovieItem> listD3;
            Intrinsics.g(network, "network");
            Intrinsics.g(networkCapabilities, "networkCapabilities");
            if (MovieFragment.this.isResumed()) {
                com.transsion.home.adapter.a aVar = MovieFragment.this.f52510i;
                if (aVar != null && (listD3 = aVar.D()) != null && listD3.isEmpty()) {
                    View view = MovieFragment.this.f52525x;
                    if (view != null) {
                        so.c.g(view);
                    }
                    MovieFragment.this.D1();
                    return;
                }
                com.transsion.home.adapter.a aVar2 = MovieFragment.this.f52510i;
                int size = (aVar2 == null || (listD2 = aVar2.D()) == null) ? 0 : listD2.size();
                if (size <= 0) {
                    MovieFragment movieFragment = MovieFragment.this;
                    movieFragment.h1(movieFragment.f52515n, MovieFragment.this.f52524w, true);
                    return;
                }
                com.transsion.home.adapter.a aVar3 = MovieFragment.this.f52510i;
                MovieItem movieItem = (aVar3 == null || (listD = aVar3.D()) == null) ? null : listD.get(size - 1);
                if (Intrinsics.b(MovieFragment.this.f52515n, movieItem != null ? movieItem.getChannelId() : null)) {
                    if (Intrinsics.b(MovieFragment.this.f52524w, movieItem != null ? movieItem.getSelectItems() : null)) {
                        com.transsion.home.adapter.a aVar4 = MovieFragment.this.f52510i;
                        if (aVar4 == null || (fVarQ = aVar4.Q()) == null) {
                            return;
                        }
                        fVarQ.v();
                        return;
                    }
                }
                MovieFragment movieFragment2 = MovieFragment.this;
                movieFragment2.h1(movieFragment2.f52515n, MovieFragment.this.f52524w, true);
            }
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onDisconnected() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class g implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f52534a;

        public g(Function1 function) {
            Intrinsics.g(function, "function");
            this.f52534a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f52534a;
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
            this.f52534a.invoke(obj);
        }
    }

    public static final void A1(MovieFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "<anonymous parameter 1>");
        Object item = adapter.getItem(i11);
        if (item instanceof MovieItem) {
            MovieItem movieItem = (MovieItem) item;
            String subjectId = movieItem.getSubjectId();
            if (subjectId != null) {
                HomeUtilsKt.b(new Subject(subjectId, movieItem.getSubjectType(), movieItem.getTitle(), null, null, null, movieItem.getDescription(), null, null, movieItem.getGenre(), null, null, null, null, null, null, null, null, null, movieItem.getOps(), null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, null, null, -524872, 4194303, null), this$0.j1());
            }
            HashMap map = new HashMap();
            String subjectId2 = movieItem.getSubjectId();
            if (subjectId2 == null) {
                subjectId2 = "";
            }
            map.put("subject_id", subjectId2);
            map.put("sequence", String.valueOf(i11));
            String ops = movieItem.getOps();
            map.put("ops", ops != null ? ops : "");
            map.put("filter_name", this$0.j1());
            com.transsion.baselib.helper.a.f51183a.e(this$0.p1(this$0.f52514m), map);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void B1() {
        RecyclerView recyclerView;
        SwipeRefreshLayout swipeRefreshLayout;
        lt.l lVar = (lt.l) getMViewBinding();
        SwipeRefreshLayout swipeRefreshLayout2 = lVar != null ? lVar.f70475h : null;
        if (swipeRefreshLayout2 != null) {
            swipeRefreshLayout2.setEnabled(false);
        }
        lt.l lVar2 = (lt.l) getMViewBinding();
        if (lVar2 != null && (swipeRefreshLayout = lVar2.f70475h) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsion.home.fragment.tab.m
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
                public final void a() {
                    MovieFragment.C1(this.f52620a);
                }
            });
        }
        lt.l lVar3 = (lt.l) getMViewBinding();
        if (lVar3 == null || (recyclerView = lVar3.f70471c) == null) {
            return;
        }
        recyclerView.addOnScrollListener(new e());
    }

    public static final void C1(MovieFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.h0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D1() {
        startLoading();
        MovieViewModel movieViewModel = this.f52511j;
        if (movieViewModel != null) {
            movieViewModel.d(Integer.valueOf(k0()), "v3");
        }
    }

    private final void G1() {
        String str = this.f52515n;
        h1(str, this.f52519r.get(str), false);
    }

    private final void H1(boolean z11) {
        if (k0() == HomeTabId.Game.getValue()) {
            if (z11) {
                m1().z();
            } else {
                m1().Y();
            }
        }
    }

    private final void K1() {
        View view = this.f52512k;
        if (view != null) {
            ViewStub viewStub = (ViewStub) view.findViewById(R$id.loading_stub);
            if (viewStub != null) {
                viewStub.setLayoutResource(l1());
            }
            if (this.f52526y == null) {
                this.f52526y = viewStub.inflate();
            }
            View view2 = this.f52526y;
            if (view2 != null) {
                so.c.k(view2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L1() {
        View view = this.f52512k;
        if (view != null) {
            ViewStub viewStub = (ViewStub) view.findViewById(R$id.no_network_stub);
            if (this.f52525x == null) {
                this.f52525x = viewStub.inflate();
            }
            View view2 = this.f52525x;
            if (view2 != null) {
                so.c.k(view2);
                final NoNetworkBigView noNetworkBigView = (NoNetworkBigView) view2.findViewById(R$id.state_view);
                if (noNetworkBigView != null) {
                    Intrinsics.f(noNetworkBigView, "findViewById<NoNetworkBigView>(R.id.state_view)");
                    NoNetworkBigView.showTitle$default(noNetworkBigView, false, null, 2, null);
                    noNetworkBigView.retry(new Function0<Unit>() { // from class: com.transsion.home.fragment.tab.MovieFragment$showNoNetworkView$1$1$1$1
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
                            this.D1();
                            com.tn.lib.view.l.b(this.n1());
                        }
                    });
                    noNetworkBigView.goToSetting(new Function0<Unit>() { // from class: com.transsion.home.fragment.tab.MovieFragment$showNoNetworkView$1$1$1$2
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
                            com.tn.lib.view.l.c(this.this$0.n1());
                        }
                    });
                }
                com.tn.lib.view.l.a(n1());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M1(String str) {
        View view = this.f52512k;
        if (view != null) {
            ViewStub viewStub = (ViewStub) view.findViewById(R$id.no_result_stub);
            if (this.f52527z == null) {
                this.f52527z = viewStub.inflate();
            }
            final View view2 = this.f52527z;
            if (view2 != null) {
                so.c.k(view2);
                TextView textView = (TextView) view2.findViewById(R$id.tv_no_result);
                if (textView != null) {
                    Intrinsics.f(textView, "findViewById<TextView>(R.id.tv_no_result)");
                    textView.setText(str);
                }
                View viewFindViewById = view2.findViewById(R$id.tv_reset);
                if (viewFindViewById != null) {
                    viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.tab.l
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            MovieFragment.N1(this.f52618a, view2, view3);
                        }
                    });
                }
            }
        }
    }

    public static final void N1(MovieFragment this$0, View this_apply, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        this$0.g1(this$0.f52515n);
        this$0.F1(this$0.f52515n);
        so.c.g(this_apply);
        this$0.startLoading();
        this$0.I1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void P1(MovieBean movieBean, boolean z11) {
        h9.f fVarQ;
        lt.l lVar;
        LinearLayout linearLayoutB;
        h9.f fVarQ2;
        com.transsion.home.adapter.a aVar;
        h9.f fVarQ3;
        SwipeRefreshLayout swipeRefreshLayout;
        Integer perPage;
        if (movieBean != null) {
            Pager pager = movieBean.getPager();
            this.f52518q = (pager == null || (perPage = pager.getPerPage()) == null) ? 10 : perPage.intValue();
            if (z11) {
                lt.l lVar2 = (lt.l) getMViewBinding();
                if (lVar2 != null && (swipeRefreshLayout = lVar2.f70475h) != null && swipeRefreshLayout.isRefreshing()) {
                    lt.l lVar3 = (lt.l) getMViewBinding();
                    SwipeRefreshLayout swipeRefreshLayout2 = lVar3 != null ? lVar3.f70475h : null;
                    if (swipeRefreshLayout2 != null) {
                        swipeRefreshLayout2.setRefreshing(false);
                    }
                }
                com.transsion.home.adapter.a aVar2 = this.f52510i;
                if (aVar2 != null) {
                    aVar2.w0(movieBean.getItems());
                }
                List<MovieItem> items = movieBean.getItems();
                if (items == null || !items.isEmpty()) {
                    t1();
                } else {
                    M1(getString(R$string.no_filter_result));
                }
            } else {
                com.transsion.home.adapter.a aVar3 = this.f52510i;
                List<MovieItem> listD = aVar3 != null ? aVar3.D() : null;
                ArrayList arrayList = new ArrayList();
                List<MovieItem> items2 = movieBean.getItems();
                if (items2 == null) {
                    items2 = kotlin.collections.g.l();
                }
                if (listD == null || !(!listD.isEmpty())) {
                    arrayList.addAll(items2);
                } else {
                    for (MovieItem movieItem : items2) {
                        if (!listD.contains(movieItem)) {
                            arrayList.add(movieItem);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    com.transsion.home.adapter.a aVar4 = this.f52510i;
                    if (aVar4 == null || (fVarQ2 = aVar4.Q()) == null) {
                        return;
                    }
                    h9.f.t(fVarQ2, false, 1, null);
                    return;
                }
                com.transsion.home.adapter.a aVar5 = this.f52510i;
                if (aVar5 != null) {
                    aVar5.m(arrayList);
                }
                com.transsion.home.adapter.a aVar6 = this.f52510i;
                if (aVar6 != null && (fVarQ = aVar6.Q()) != null && fVarQ.q() && (lVar = (lt.l) getMViewBinding()) != null && (linearLayoutB = lVar.getRoot()) != null) {
                    linearLayoutB.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.tab.n
                        @Override // java.lang.Runnable
                        public final void run() {
                            MovieFragment.Q1(this.f52621a);
                        }
                    }, 300L);
                }
            }
            Pager pager2 = movieBean.getPager();
            if (pager2 == null || !Intrinsics.b(pager2.getHasMore(), Boolean.FALSE) || (aVar = this.f52510i) == null || (fVarQ3 = aVar.Q()) == null) {
                return;
            }
            h9.f.t(fVarQ3, false, 1, null);
        }
    }

    public static final void Q1(MovieFragment this$0) {
        h9.f fVarQ;
        Intrinsics.g(this$0, "this$0");
        com.transsion.home.adapter.a aVar = this$0.f52510i;
        if (aVar == null || (fVarQ = aVar.Q()) == null) {
            return;
        }
        fVarQ.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S1(HashMap<String, String> map) {
        PopupFilterView popupFilterView = this.f52520s;
        if (popupFilterView != null) {
            popupFilterView.initSelectData(i1(this.f52515n), map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void f1(int i11) {
        String channelId;
        List<Channel> typeList;
        Channel channel;
        RecyclerView recyclerView;
        List<Channel> typeList2;
        FilterItems filterItems = this.f52514m;
        int size = (filterItems == null || (typeList2 = filterItems.getTypeList()) == null) ? -1 : typeList2.size();
        if (i11 < 0 || i11 >= size) {
            return;
        }
        RecyclerView.m layoutManager = null;
        if (r1()) {
            channelId = this.f52516o;
        } else {
            FilterItems filterItems2 = this.f52514m;
            channelId = (filterItems2 == null || (typeList = filterItems2.getTypeList()) == null || (channel = typeList.get(i11)) == null) ? null : channel.getChannelId();
        }
        this.f52515n = channelId;
        this.f52516o = null;
        View view = this.f52512k;
        if (view != null) {
            lt.l lVar = (lt.l) getMViewBinding();
            if (lVar != null && (recyclerView = lVar.f70471c) != null) {
                layoutManager = recyclerView.getLayoutManager();
            }
            if (layoutManager instanceof OffsetGridLayoutManager) {
                OffsetGridLayoutManager offsetGridLayoutManager = (OffsetGridLayoutManager) layoutManager;
                if (offsetGridLayoutManager.getSpanCount() == o1()) {
                    uo.b.a.f(uo.b.f78622a, "MovieFragment", "span count is same " + offsetGridLayoutManager.getSpanCount(), false, 4, null);
                    return;
                }
            }
            x1();
            ViewParent parent = view.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(view);
            }
            com.transsion.home.adapter.a aVar = this.f52510i;
            if (aVar != null) {
                BaseQuickAdapter.q(aVar, view, 0, 0, 6, null);
            }
            K1();
        }
    }

    private final void g1(String str) {
        HashMap<String, String> map = this.f52519r.get(str);
        if (map != null) {
            map.clear();
        }
    }

    private final List<Item> i1(String str) {
        List<Channel> typeList;
        FilterItems filterItems = this.f52514m;
        if (filterItems == null || (typeList = filterItems.getTypeList()) == null) {
            return null;
        }
        for (Channel channel : typeList) {
            if (Intrinsics.b(channel.getChannelId(), str)) {
                return channel.getItems();
            }
        }
        return null;
    }

    private final void initViewModel() {
        MovieViewModel movieViewModel = this.f52511j;
        if (movieViewModel != null) {
            movieViewModel.e().j(this, new g(new MovieFragment$initViewModel$1$1(this)));
            movieViewModel.h().j(this, new g(new Function1<RefreshBaseDto<MovieBean>, Unit>() { // from class: com.transsion.home.fragment.tab.MovieFragment$initViewModel$1$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(RefreshBaseDto<MovieBean> refreshBaseDto) {
                    invoke2(refreshBaseDto);
                    return Unit.f68710a;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(RefreshBaseDto<MovieBean> refreshBaseDto) {
                    h9.f fVarQ;
                    com.transsion.home.adapter.a aVar;
                    h9.f fVarQ2;
                    List<MovieItem> listD;
                    SwipeRefreshLayout swipeRefreshLayout;
                    if (refreshBaseDto == null) {
                        return;
                    }
                    lt.l lVar = (lt.l) this.this$0.getMViewBinding();
                    SwipeRefreshLayout swipeRefreshLayout2 = lVar != null ? lVar.f70475h : null;
                    if (swipeRefreshLayout2 != null) {
                        swipeRefreshLayout2.setEnabled(true);
                    }
                    if (Intrinsics.b(refreshBaseDto.getCode(), "0")) {
                        com.transsion.baselib.report.h logViewConfig = this.this$0.getLogViewConfig();
                        if (logViewConfig != null) {
                            logViewConfig.j(true);
                        }
                        MovieBean data = refreshBaseDto.getData();
                        if (data != null) {
                            MovieFragment movieFragment = this.this$0;
                            movieFragment.P1(data, refreshBaseDto.isRefresh());
                            View view = movieFragment.f52525x;
                            if (view != null) {
                                so.c.g(view);
                            }
                        }
                        this.this$0.hideLoading();
                        return;
                    }
                    if (refreshBaseDto.isRefresh()) {
                        lt.l lVar2 = (lt.l) this.this$0.getMViewBinding();
                        if (lVar2 != null && (swipeRefreshLayout = lVar2.f70475h) != null && swipeRefreshLayout.isRefreshing()) {
                            lt.l lVar3 = (lt.l) this.this$0.getMViewBinding();
                            SwipeRefreshLayout swipeRefreshLayout3 = lVar3 != null ? lVar3.f70475h : null;
                            if (swipeRefreshLayout3 != null) {
                                swipeRefreshLayout3.setRefreshing(false);
                            }
                            this.this$0.t0();
                        }
                    } else {
                        com.transsion.home.adapter.a aVar2 = this.this$0.f52510i;
                        if (aVar2 != null && (fVarQ = aVar2.Q()) != null && fVarQ.q() && (aVar = this.this$0.f52510i) != null && (fVarQ2 = aVar.Q()) != null) {
                            fVarQ2.u();
                        }
                    }
                    com.transsion.home.adapter.a aVar3 = this.this$0.f52510i;
                    if (aVar3 == null || (listD = aVar3.D()) == null || listD.size() != 0) {
                        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                            zp.b.f82110a.d(com.transsnet.downloader.R$string.str_ad_video_error_tips);
                        } else {
                            zp.b.f82110a.d(com.tn.lib.widget.R$string.no_network_toast);
                        }
                        this.this$0.s1();
                        return;
                    }
                    if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                        MovieFragment movieFragment2 = this.this$0;
                        movieFragment2.M1(movieFragment2.getString(R$string.home_no_network_content));
                    } else {
                        this.this$0.L1();
                    }
                    this.this$0.s1();
                }
            }));
            PopupFilterView popupFilterView = this.f52520s;
            if (popupFilterView != null) {
                popupFilterView.setOnFilterListener(new Function1<Map<String, ? extends String>, Unit>() { // from class: com.transsion.home.fragment.tab.MovieFragment$initViewModel$1$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends String> map) {
                        invoke2((Map<String, String>) map);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Map<String, String> it) {
                        Intrinsics.g(it, "it");
                        this.this$0.E1(it);
                        com.transsion.baselib.helper.a aVar = com.transsion.baselib.helper.a.f51183a;
                        MovieFragment movieFragment = this.this$0;
                        aVar.g(movieFragment.p1(movieFragment.f52514m), it.toString(), (28 & 4) != 0 ? "" : null, (28 & 8) != 0 ? "" : null, (28 & 16) != 0 ? "" : null);
                        nt.b bVar = this.this$0.f52523v;
                        if (bVar != null) {
                            bVar.e();
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutStyle k1(String str) {
        List<Channel> typeList;
        FilterItems filterItems = this.f52514m;
        if (filterItems == null || (typeList = filterItems.getTypeList()) == null) {
            return null;
        }
        for (Channel channel : typeList) {
            if (Intrinsics.b(channel.getChannelId(), str)) {
                return channel.getStyle();
            }
        }
        return null;
    }

    private final int l1() {
        return R$layout.home_empty_view_loading;
    }

    private final IMemberApi m1() {
        return (IMemberApi) this.f52509h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String n1() {
        Fragment parentFragment = getParentFragment();
        return parentFragment instanceof HomeFragment ? ((HomeFragment) parentFragment).x0() : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int o1() {
        LayoutStyle layoutStyleK1 = k1(this.f52515n);
        if (layoutStyleK1 != null) {
            int colNum = layoutStyleK1.getColNum();
            FragmentActivity activity = getActivity();
            return colNum + ((activity == null || !com.transsion.baseui.util.b.a(activity)) ? 0 : 1);
        }
        if (Intrinsics.b(this.f52515n, "5") || Intrinsics.b(this.f52515n, PrepareException.ERROR_NO_URL) || Intrinsics.b(this.f52515n, "1003") || Intrinsics.b(this.f52515n, "1004")) {
            return 2;
        }
        FragmentActivity activity2 = getActivity();
        return (activity2 == null || !com.transsion.baseui.util.b.a(activity2)) ? 3 : 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s1() {
        View view = this.f52526y;
        if (view != null) {
            so.c.g(view);
        }
    }

    private final void t1() {
        View view = this.f52527z;
        if (view != null) {
            so.c.g(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void u1() {
        List<Channel> typeList;
        lt.l lVar;
        View view;
        List<Channel> typeList2;
        lt.v vVar;
        lt.v vVar2;
        List<Channel> typeList3;
        FilterItems filterItems = this.f52514m;
        int i11 = 0;
        int size = (filterItems == null || (typeList3 = filterItems.getTypeList()) == null) ? 0 : typeList3.size();
        if (size <= 0) {
            return;
        }
        lt.l lVar2 = (lt.l) getMViewBinding();
        ConstraintLayout constraintLayout = null;
        TabLayout tabLayout = (lVar2 == null || (vVar2 = lVar2.f70470b) == null) ? null : vVar2.f70522d;
        lt.l lVar3 = (lt.l) getMViewBinding();
        if (lVar3 != null && (vVar = lVar3.f70470b) != null) {
            constraintLayout = vVar.f70521c;
        }
        if (size == 1) {
            if (constraintLayout != null) {
                so.c.g(constraintLayout);
            }
            F1(this.f52515n);
            S1(this.f52519r.get(this.f52515n));
        } else {
            if (constraintLayout != null) {
                so.c.k(constraintLayout);
            }
            if (tabLayout != null) {
                tabLayout.removeAllTabs();
            }
            if (tabLayout != null) {
                tabLayout.clearOnTabSelectedListeners();
            }
            if (tabLayout != null) {
                tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new b());
            }
            FilterItems filterItems2 = this.f52514m;
            if (filterItems2 != null && (typeList = filterItems2.getTypeList()) != null) {
                for (Object obj : typeList) {
                    int i12 = i11 + 1;
                    if (i11 < 0) {
                        kotlin.collections.g.u();
                    }
                    Channel channel = (Channel) obj;
                    if (tabLayout != null) {
                        tabLayout.addTab(tabLayout.newTab().setText(channel.getChannelName()), Intrinsics.b(channel.getChannelId(), this.f52515n));
                    }
                    i11 = i12;
                }
            }
        }
        if (getParentFragment() instanceof HomeFragment) {
            FilterItems filterItems3 = this.f52514m;
            if ((filterItems3 != null && (typeList2 = filterItems3.getTypeList()) != null && typeList2.size() > 1) || (lVar = (lt.l) getMViewBinding()) == null || (view = lVar.f70473f) == null) {
                return;
            }
            so.c.k(view);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v1() {
        RecyclerView recyclerView;
        if (this.f52523v == null) {
            nt.b bVar = new nt.b(0.6f, new c(), false, 4, null);
            lt.l lVar = (lt.l) getMViewBinding();
            if (lVar != null && (recyclerView = lVar.f70471c) != null) {
                recyclerView.addOnScrollListener(bVar);
            }
            this.f52523v = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w1() {
        List<Channel> typeList;
        this.f52519r.clear();
        FilterItems filterItems = this.f52514m;
        if (filterItems == null || (typeList = filterItems.getTypeList()) == null) {
            return;
        }
        Iterator<T> it = typeList.iterator();
        while (it.hasNext()) {
            this.f52519r.put(((Channel) it.next()).getChannelId(), new HashMap<>());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x1() {
        RecyclerView recyclerView;
        lt.l lVar;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        int iO1 = o1();
        OffsetGridLayoutManager offsetGridLayoutManager = new OffsetGridLayoutManager(getContext(), iO1, 1, false);
        lt.l lVar2 = (lt.l) getMViewBinding();
        if (lVar2 != null && (recyclerView3 = lVar2.f70471c) != null) {
            recyclerView3.setLayoutManager(offsetGridLayoutManager);
        }
        com.transsion.home.adapter.a aVar = new com.transsion.home.adapter.a(new ArrayList(), this.f52523v, k1(this.f52515n), iO1);
        aVar.Q().y(true);
        aVar.Q().x(true);
        aVar.Q().C(new f9.f() { // from class: com.transsion.home.fragment.tab.o
            @Override // f9.f
            public final void a() {
                MovieFragment.y1(this.f52622a);
            }
        });
        aVar.o0(new d());
        aVar.B0(new f9.d() { // from class: com.transsion.home.fragment.tab.p
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                MovieFragment.A1(this.f52623a, baseQuickAdapter, view, i11);
            }
        });
        this.f52510i = aVar;
        lt.l lVar3 = (lt.l) getMViewBinding();
        if (lVar3 != null && (recyclerView = lVar3.f70471c) != null && recyclerView.getItemDecorationCount() < 2 && (lVar = (lt.l) getMViewBinding()) != null && (recyclerView2 = lVar.f70471c) != null) {
            recyclerView2.addItemDecoration(new ro.b(com.blankj.utilcode.util.f0.a(4.0f), com.blankj.utilcode.util.f0.a(4.0f), com.blankj.utilcode.util.f0.a(16.0f), com.blankj.utilcode.util.f0.a(16.0f)));
        }
        lt.l lVar4 = (lt.l) getMViewBinding();
        RecyclerView recyclerView4 = lVar4 != null ? lVar4.f70471c : null;
        if (recyclerView4 == null) {
            return;
        }
        recyclerView4.setAdapter(this.f52510i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void y1(final MovieFragment this$0) {
        RecyclerView recyclerView;
        Intrinsics.g(this$0, "this$0");
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            this$0.G1();
            return;
        }
        zp.b.f82110a.d(com.tn.lib.widget.R$string.no_network_toast);
        lt.l lVar = (lt.l) this$0.getMViewBinding();
        if (lVar == null || (recyclerView = lVar.f70471c) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.tab.q
            @Override // java.lang.Runnable
            public final void run() {
                MovieFragment.z1(this.f52624a);
            }
        }, 500L);
    }

    public static final void z1(MovieFragment this$0) {
        h9.f fVarQ;
        Intrinsics.g(this$0, "this$0");
        com.transsion.home.adapter.a aVar = this$0.f52510i;
        if (aVar == null || (fVarQ = aVar.Q()) == null) {
            return;
        }
        fVarQ.u();
    }

    public final void E1(Map<String, String> map) {
        this.f52513l = 1;
        HashMap<String, String> map2 = this.f52519r.get(this.f52515n);
        if (map2 != null) {
            map2.clear();
        }
        if (map2 != null) {
            map2.putAll(map);
        }
        h1(this.f52515n, map2, true);
    }

    public final void F1(String str) {
        List<Channel> typeList;
        this.f52513l = 1;
        FilterItems filterItems = this.f52514m;
        if (filterItems == null || (typeList = filterItems.getTypeList()) == null) {
            return;
        }
        for (Channel channel : typeList) {
            if (Intrinsics.b(channel.getChannelId(), str)) {
                HashMap<String, String> map = this.f52519r.get(str);
                String str2 = this.f52517p;
                if (str2 == null || str2.length() <= 0) {
                    List<Item> items = channel.getItems();
                    if (items != null) {
                        for (Item item : items) {
                            if ((map != null ? map.get(item.getFilterType()) : null) == null) {
                                if (item.getRangeVals() != null) {
                                    String strA = PopupFilterView.Companion.a(item.getRangeVals().getMinVal(), item.getRangeVals().getMaxVal());
                                    if (map != null) {
                                        map.put(item.getFilterType(), strA);
                                    }
                                } else if ((!item.getFilterValsV2().isEmpty()) && map != null) {
                                    map.put(item.getFilterType(), item.getFilterValsV2().get(0).getId());
                                }
                            }
                        }
                    }
                } else {
                    try {
                        String str3 = this.f52517p;
                        if (str3 == null) {
                            str3 = "";
                        }
                        JSONObject jSONObject = new JSONObject(str3);
                        Iterator<String> itKeys = jSONObject.keys();
                        while (itKeys.hasNext()) {
                            String key = itKeys.next();
                            String value = jSONObject.getString(key);
                            if (map != null) {
                                Intrinsics.f(key, "key");
                                Intrinsics.f(value, "value");
                                map.put(key, value);
                            }
                        }
                    } catch (Exception unused) {
                        List<Item> items2 = channel.getItems();
                        if (items2 != null) {
                            for (Item item2 : items2) {
                                if ((map != null ? map.get(item2.getFilterType()) : null) == null && map != null) {
                                    map.put(item2.getFilterType(), item2.getFilterValsV2().get(0).getId());
                                }
                            }
                        }
                    }
                }
                this.f52517p = null;
                h1(str, map, true);
            }
        }
    }

    public final void I1() {
        PopupFilterView popupFilterView = this.f52520s;
        if (popupFilterView != null) {
            PopupFilterView.initSelectData$default(popupFilterView, i1(this.f52515n), null, 2, null);
        }
    }

    public final void J1(TabLayout.Tab tab, boolean z11) {
        Intrinsics.g(tab, "<this>");
        try {
            Field declaredField = tab.getClass().getDeclaredField(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            declaredField.setAccessible(true);
            Object obj = declaredField.get(tab);
            Field declaredField2 = obj.getClass().getDeclaredField("textView");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Intrinsics.e(obj2, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) obj2;
            textView.setTextSize(14.0f);
            if (z11) {
                textView.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                textView.setTypeface(Typeface.defaultFromStyle(0));
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void O1(String str, String str2) {
        try {
            if (getContext() != null && isAdded()) {
                if (!(!this.f52519r.isEmpty()) || !Intrinsics.b(this.f52515n, str)) {
                    this.f52517p = str2;
                    this.f52516o = str;
                    this.f52515n = str;
                    if (this.f52519r.isEmpty()) {
                        return;
                    }
                    this.f52513l = 1;
                    R1();
                    return;
                }
                HashMap<String, String> map = this.f52519r.get(this.f52515n);
                if (str2 == null) {
                    str2 = "";
                }
                JSONObject jSONObject = new JSONObject(str2);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String key = itKeys.next();
                    String value = jSONObject.getString(key);
                    if (map != null) {
                        Intrinsics.f(key, "key");
                        Intrinsics.f(value, "value");
                        map.put(key, value);
                    }
                }
                S1(this.f52519r.get(this.f52515n));
                this.f52513l = 1;
                h1(this.f52515n, map, true);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R1() {
        List<Channel> typeList;
        lt.v vVar;
        lt.l lVar = (lt.l) getMViewBinding();
        TabLayout tabLayout = (lVar == null || (vVar = lVar.f70470b) == null) ? null : vVar.f70522d;
        FilterItems filterItems = this.f52514m;
        if (filterItems == null || (typeList = filterItems.getTypeList()) == null) {
            return;
        }
        int i11 = 0;
        for (Object obj : typeList) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.g.u();
            }
            if (Intrinsics.b(((Channel) obj).getChannelId(), this.f52515n) && tabLayout != null) {
                tabLayout.selectTab(tabLayout.getTabAt(i11));
            }
            i11 = i12;
        }
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void h0() {
        super.h0();
        this.f52513l = 1;
        String str = this.f52515n;
        h1(str, this.f52519r.get(str), true);
        nt.b bVar = this.f52523v;
        if (bVar != null) {
            bVar.e();
        }
    }

    public final void h1(String str, Map<String, String> map, boolean z11) {
        MovieViewModel movieViewModel = this.f52511j;
        if (movieViewModel != null) {
            int i11 = this.f52513l;
            this.f52513l = i11 + 1;
            movieViewModel.g(i11, this.f52518q, str, map, z11);
        }
        this.f52524w = map;
        w0(map);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void hideLoading() {
        s1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment, com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        lt.l lVar;
        View subMovieHeaderBg;
        View view2;
        Intrinsics.g(view, "view");
        super.initView(view, bundle);
        lt.l lVar2 = (lt.l) getMViewBinding();
        if (lVar2 != null && (view2 = lVar2.f70474g) != null) {
            view2.getLayoutParams().height = n0();
        }
        Bundle arguments = getArguments();
        if (arguments != null && arguments.getBoolean("hide_header_bg", false) && (lVar = (lt.l) getMViewBinding()) != null && (subMovieHeaderBg = lVar.f70474g) != null) {
            Intrinsics.f(subMovieHeaderBg, "subMovieHeaderBg");
            so.c.g(subMovieHeaderBg);
        }
        this.f52511j = (MovieViewModel) new v0(this).a(MovieViewModel.class);
        lt.l lVar3 = (lt.l) getMViewBinding();
        this.f52520s = lVar3 != null ? lVar3.f70472d : null;
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.header_movie, (ViewGroup) null);
        this.f52512k = viewInflate;
        if (viewInflate != null) {
            v1();
            x1();
            B1();
            com.transsion.home.adapter.a aVar = this.f52510i;
            if (aVar != null) {
                BaseQuickAdapter.q(aVar, viewInflate, 0, 0, 6, null);
            }
            initViewModel();
            setNetListener(new f());
        }
    }

    public final String j1() {
        String str;
        HashMap<String, String> map = this.f52519r.get(this.f52515n);
        if (map == null || (str = map.get("sort")) == null) {
            str = "";
        }
        return "filter_" + str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public RecyclerView l0() {
        lt.l lVar = (lt.l) getMViewBinding();
        if (lVar != null) {
            return lVar.f70471c;
        }
        return null;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        D1();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h(n1(), false, 2, null);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.g(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        com.transsion.home.adapter.a aVar = this.f52510i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment, com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f52517p = arguments != null ? arguments.getString("filter_json") : null;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f52513l = 1;
        MovieViewModel movieViewModel = this.f52511j;
        androidx.lifecycle.c0<BaseDto<FilterItems>> c0VarF = movieViewModel != null ? movieViewModel.f() : null;
        if (c0VarF != null) {
            c0VarF.q(null);
        }
        MovieViewModel movieViewModel2 = this.f52511j;
        androidx.lifecycle.c0<RefreshBaseDto<MovieBean>> c0VarI = movieViewModel2 != null ? movieViewModel2.i() : null;
        if (c0VarI != null) {
            c0VarI.q(null);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        com.transsion.baseui.activity.d.h(null, this, z11, "tabId=" + k0(), 1, null);
        if (isResumed()) {
            if (!z11) {
                logResume();
                H1(true);
            } else {
                H1(false);
                logPause();
                this.f52521t = SystemClock.elapsedRealtime();
            }
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (k0() == 2) {
            com.transsion.baselib.helper.a.f51183a.j(p1(this.f52514m), com.transsion.baselib.report.m.f51277a.f(), String.valueOf(SystemClock.elapsedRealtime() - this.f52521t));
        }
        nt.b bVar = this.f52523v;
        if (bVar != null) {
            bVar.e();
        }
        com.transsion.baseui.activity.d.l(null, this, "tabId=" + k0(), 1, null);
        H1(false);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com.transsion.home.adapter.a aVar;
        List<MovieItem> listD;
        super.onResume();
        this.f52521t = SystemClock.elapsedRealtime();
        View view = this.f52525x;
        if (view != null && so.c.i(view) && com.tn.lib.util.networkinfo.f.f49475a.e() && (aVar = this.f52510i) != null && (listD = aVar.D()) != null && listD.isEmpty()) {
            View view2 = this.f52525x;
            if (view2 != null) {
                so.c.g(view2);
            }
            D1();
        }
        com.transsion.baseui.activity.d.p(null, this, "tabId=" + k0() + " visible=" + isVisible(), 1, null);
        H1(true);
    }

    public final String p1(FilterItems filterItems) {
        List<Channel> typeList;
        String strJ0 = j0();
        if (strJ0 != null && strJ0.length() != 0) {
            String strJ1 = j0();
            return strJ1 == null ? "" : strJ1;
        }
        if (filterItems != null && (typeList = filterItems.getTypeList()) != null) {
            for (Channel channel : typeList) {
                if (Intrinsics.b(this.f52515n, channel.getChannelId())) {
                    String channelName = channel.getChannelName();
                    return channelName == null ? n1() : channelName;
                }
            }
        }
        return n1();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: q1, reason: merged with bridge method [inline-methods] */
    public lt.l getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        lt.l lVarC = lt.l.c(inflater);
        Intrinsics.f(lVarC, "inflate(inflater)");
        return lVarC;
    }

    public final boolean r1() {
        FilterItems filterItems;
        List<Channel> typeList;
        String str = this.f52516o;
        if (str != null && str.length() != 0 && (filterItems = this.f52514m) != null && (typeList = filterItems.getTypeList()) != null) {
            Iterator<T> it = typeList.iterator();
            while (it.hasNext()) {
                if (Intrinsics.b(((Channel) it.next()).getChannelId(), this.f52516o)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void s0(int i11, com.transsion.ad.bidding.nativead.c wrapperNativeManager) {
        List<MovieItem> listD;
        Intrinsics.g(wrapperNativeManager, "wrapperNativeManager");
        Context context = getContext();
        if ((context == null || !com.transsion.baseui.util.b.a(context)) && wrapperNativeManager != null) {
            MovieItem movieItem = new MovieItem(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 33554431, null);
            movieItem.setNonAdDelegate(wrapperNativeManager);
            com.transsion.home.adapter.a aVar = this.f52510i;
            int size = (aVar == null || (listD = aVar.D()) == null) ? 0 : listD.size();
            if (i11 < 0 || i11 > size) {
                com.transsion.home.adapter.a aVar2 = this.f52510i;
                if (aVar2 != null) {
                    aVar2.l(movieItem);
                    return;
                }
                return;
            }
            com.transsion.home.adapter.a aVar3 = this.f52510i;
            if (aVar3 != null) {
                aVar3.j(i11, movieItem);
            }
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void startLoading() {
        K1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void v0() {
        RecyclerView recyclerView;
        lt.l lVar = (lt.l) getMViewBinding();
        if (lVar == null || (recyclerView = lVar.f70471c) == null) {
            return;
        }
        recyclerView.smoothScrollToPosition(0);
    }
}
