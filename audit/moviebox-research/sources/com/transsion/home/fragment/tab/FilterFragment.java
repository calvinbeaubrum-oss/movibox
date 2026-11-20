package com.transsion.home.fragment.tab;

import android.annotation.SuppressLint;
import android.content.Context;
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
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alibaba.android.arouter.facade.Postcard;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.view.NoNetworkBigView;
import com.tn.lib.widget.R$color;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.bean.Channel;
import com.transsion.home.bean.FilterItems;
import com.transsion.home.bean.Item;
import com.transsion.home.bean.LayoutStyle;
import com.transsion.home.bean.MovieBean;
import com.transsion.home.bean.MovieItem;
import com.transsion.home.bean.RefreshBaseDto;
import com.transsion.home.fragment.HomeFragment;
import com.transsion.home.layoutmanager.OffsetGridLayoutManager;
import com.transsion.home.view.filter.expand.FilterExpandView;
import com.transsion.home.view.filter.expand.TabExpandView;
import com.transsion.home.viewmodel.MovieViewModel;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.R$string;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
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
public final class FilterFragment extends BaseHomeSubFragment<lt.j> {
    public static final a A = new a(null);
    public static final int B = 8;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.transsion.home.adapter.a f52484h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MovieViewModel f52485i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f52486j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public lt.t f52487k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TabExpandView f52488l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public FilterExpandView f52489m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile String f52491o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public FilterItems f52492p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f52493q;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public nt.b f52498v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public HashMap<String, String> f52499w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f52500x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f52501y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f52502z;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f52490n = 1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f52494r = 12;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f52495s = true;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public HashMap<String, HashMap<String, String>> f52496t = new HashMap<>();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f52497u = SystemClock.elapsedRealtime();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FilterFragment a(int i11, String str, String str2) {
            Bundle bundle = new Bundle();
            bundle.putInt("tab_id", i11);
            bundle.putString(WebConstants.TAB_CODE, str);
            bundle.putString("filter_json", str2);
            FilterFragment filterFragment = new FilterFragment();
            filterFragment.setArguments(bundle);
            return filterFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements nt.a {
        public b() {
        }

        @Override // nt.a
        public void a(int i11, long j11, View view) {
            List<MovieItem> listD;
            String subjectId;
            String ops;
            com.transsion.home.adapter.a aVar = FilterFragment.this.f52484h;
            if (aVar != null) {
                aVar.b0();
            }
            com.transsion.home.adapter.a aVar2 = FilterFragment.this.f52484h;
            if (aVar2 == null || (listD = aVar2.D()) == null) {
                return;
            }
            int size = listD.size();
            FilterFragment filterFragment = FilterFragment.this;
            if (i11 >= size) {
                return;
            }
            com.transsion.home.adapter.a aVar3 = filterFragment.f52484h;
            MovieItem item = aVar3 != null ? aVar3.getItem(i11) : null;
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
            com.transsion.baselib.helper.a.f51183a.d(filterFragment.o1(filterFragment.f52493q, filterFragment.f52492p), map);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends DiffUtil.e<MovieItem> {
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
    public static final class d extends RecyclerView.r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f52504a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f52506c;

        public d(View view) {
            this.f52506c = view;
        }

        private final void d(RecyclerView recyclerView) {
            RecyclerView.m layoutManager = recyclerView.getLayoutManager();
            Intrinsics.e(layoutManager, "null cannot be cast to non-null type com.transsion.home.layoutmanager.OffsetGridLayoutManager");
            this.f52504a = ((OffsetGridLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
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
            if (i11 != 0 || childCount <= 0 || this.f52504a < itemCount - 1) {
                return;
            }
            com.transsion.home.adapter.a aVar2 = FilterFragment.this.f52484h;
            if (((aVar2 == null || (fVarQ2 = aVar2.Q()) == null) ? null : fVarQ2.i()) != LoadMoreStatus.Fail || (aVar = FilterFragment.this.f52484h) == null || (fVarQ = aVar.Q()) == null) {
                return;
            }
            fVarQ.v();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            lt.u uVar;
            ConstraintLayout constraintLayout;
            lt.u uVar2;
            lt.u uVar3;
            ConstraintLayout constraintLayout2;
            Intrinsics.g(recyclerView, "recyclerView");
            int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
            int measuredHeight = this.f52506c.getMeasuredHeight();
            TabExpandView tabExpandView = FilterFragment.this.f52488l;
            if (tabExpandView == null) {
                Intrinsics.y("channelView");
                tabExpandView = null;
            }
            if (iComputeVerticalScrollOffset > measuredHeight - tabExpandView.getMeasuredHeight()) {
                lt.j jVar = (lt.j) FilterFragment.this.getMViewBinding();
                if (jVar != null && (uVar3 = jVar.f70451b) != null && (constraintLayout2 = uVar3.f70518c) != null) {
                    so.c.k(constraintLayout2);
                }
                lt.j jVar2 = (lt.j) FilterFragment.this.getMViewBinding();
                if (jVar2 != null && (uVar2 = jVar2.f70451b) != null) {
                    FilterFragment filterFragment = FilterFragment.this;
                    ConstraintLayout llTabFilter = uVar2.f70518c;
                    Intrinsics.f(llTabFilter, "llTabFilter");
                    so.c.k(llTabFilter);
                    filterFragment.S1();
                }
            } else {
                lt.j jVar3 = (lt.j) FilterFragment.this.getMViewBinding();
                if (jVar3 != null && (uVar = jVar3.f70451b) != null && (constraintLayout = uVar.f70518c) != null) {
                    so.c.g(constraintLayout);
                }
            }
            d(recyclerView);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e implements com.tn.lib.util.networkinfo.g {
        public e() {
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
            if (FilterFragment.this.isResumed()) {
                com.transsion.home.adapter.a aVar = FilterFragment.this.f52484h;
                if (aVar != null && (listD3 = aVar.D()) != null && listD3.isEmpty()) {
                    View view = FilterFragment.this.f52500x;
                    if (view != null) {
                        so.c.g(view);
                    }
                    FilterFragment.this.E1();
                    return;
                }
                com.transsion.home.adapter.a aVar2 = FilterFragment.this.f52484h;
                int size = (aVar2 == null || (listD2 = aVar2.D()) == null) ? 0 : listD2.size();
                if (size <= 0) {
                    FilterFragment filterFragment = FilterFragment.this;
                    filterFragment.g1(filterFragment.f52493q, FilterFragment.this.f52499w, true);
                    return;
                }
                com.transsion.home.adapter.a aVar3 = FilterFragment.this.f52484h;
                MovieItem movieItem = (aVar3 == null || (listD = aVar3.D()) == null) ? null : listD.get(size - 1);
                if (Intrinsics.b(FilterFragment.this.f52493q, movieItem != null ? movieItem.getChannelId() : null)) {
                    if (Intrinsics.b(FilterFragment.this.f52499w, movieItem != null ? movieItem.getSelectItems() : null)) {
                        com.transsion.home.adapter.a aVar4 = FilterFragment.this.f52484h;
                        if (aVar4 == null || (fVarQ = aVar4.Q()) == null) {
                            return;
                        }
                        fVarQ.v();
                        return;
                    }
                }
                FilterFragment filterFragment2 = FilterFragment.this;
                filterFragment2.g1(filterFragment2.f52493q, FilterFragment.this.f52499w, true);
            }
        }

        @Override // com.tn.lib.util.networkinfo.g
        public void onDisconnected() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f52508a;

        public f(Function1 function) {
            Intrinsics.g(function, "function");
            this.f52508a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f52508a;
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
            this.f52508a.invoke(obj);
        }
    }

    public static final void A1(FilterFragment this$0, com.transsion.home.adapter.a this_apply, BaseQuickAdapter adapter, View view, int i11) {
        String str;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "<anonymous parameter 1>");
        Object item = adapter.getItem(i11);
        if (item instanceof MovieItem) {
            String strO1 = this$0.o1(this$0.f52493q, this$0.f52492p);
            MovieItem movieItem = (MovieItem) item;
            String subjectId = movieItem.getSubjectId();
            if (subjectId != null) {
                Integer subjectType = movieItem.getSubjectType();
                int value = SubjectType.SHORT_TV.getValue();
                if (subjectType != null && subjectType.intValue() == value) {
                    DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
                    Context context = this_apply.getContext();
                    Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                    downloadManagerApiA.a2((FragmentActivity) context, this$0.o1(this$0.f52493q, this$0.f52492p), (384 & 4) != 0 ? "" : "", movieItem.getOps(), (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : false, (384 & 64) != 0 ? null : new Subject(subjectId, movieItem.getSubjectType(), movieItem.getTitle(), null, null, null, movieItem.getDescription(), null, null, movieItem.getGenre(), null, null, null, null, null, null, null, null, null, movieItem.getOps(), null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, null, null, -524872, 4194303, null), (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
                    str = "ops";
                } else {
                    Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/movie/detail");
                    Integer subjectType2 = movieItem.getSubjectType();
                    str = "ops";
                    postcardB.withInt("subject_type", subjectType2 != null ? subjectType2.intValue() : SubjectType.MOVIE.getValue()).withString("id", subjectId).withString(str, movieItem.getOps()).navigation();
                }
            } else {
                str = "ops";
            }
            HashMap map = new HashMap();
            String subjectId2 = movieItem.getSubjectId();
            if (subjectId2 == null) {
                subjectId2 = "";
            }
            map.put("subject_id", subjectId2);
            map.put("sequence", String.valueOf(i11));
            String ops = movieItem.getOps();
            map.put(str, ops != null ? ops : "");
            com.transsion.baselib.helper.a.f51183a.e(strO1, map);
        }
    }

    public static final void C1(FilterFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.h0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void D1(FilterFragment this$0, View view) {
        RecyclerView recyclerView;
        Intrinsics.g(this$0, "this$0");
        lt.j jVar = (lt.j) this$0.getMViewBinding();
        if (jVar == null || (recyclerView = jVar.f70452c) == null) {
            return;
        }
        recyclerView.scrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E1() {
        startLoading();
        MovieViewModel movieViewModel = this.f52485i;
        if (movieViewModel != null) {
            movieViewModel.d(Integer.valueOf(k0()), "v2");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void H1(FilterFragment filterFragment, String str, HashMap map, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            map = null;
        }
        filterFragment.G1(str, map);
    }

    private final void I1() {
        String str = this.f52493q;
        g1(str, this.f52496t.get(str), false);
    }

    private final void L1() {
        lt.t tVar = this.f52487k;
        if (tVar == null) {
            Intrinsics.y("headerBinding");
            tVar = null;
        }
        ViewStub viewStub = tVar.f70513d;
        Intrinsics.f(viewStub, "headerBinding.loadingStub");
        viewStub.setLayoutResource(l1());
        if (this.f52501y == null) {
            this.f52501y = viewStub.inflate();
        }
        View view = this.f52501y;
        if (view != null) {
            so.c.k(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M1() {
        if (this.f52500x == null) {
            lt.t tVar = this.f52487k;
            if (tVar == null) {
                Intrinsics.y("headerBinding");
                tVar = null;
            }
            this.f52500x = tVar.f70514f.inflate();
        }
        View view = this.f52500x;
        if (view != null) {
            so.c.k(view);
            final NoNetworkBigView noNetworkBigView = (NoNetworkBigView) view.findViewById(R$id.state_view);
            if (noNetworkBigView != null) {
                Intrinsics.f(noNetworkBigView, "findViewById<NoNetworkBigView>(R.id.state_view)");
                NoNetworkBigView.showTitle$default(noNetworkBigView, false, null, 2, null);
                noNetworkBigView.retry(new Function0<Unit>() { // from class: com.transsion.home.fragment.tab.FilterFragment$showNoNetworkView$1$1$1
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
                        this.E1();
                        com.tn.lib.view.l.b(this.m1());
                    }
                });
                noNetworkBigView.goToSetting(new Function0<Unit>() { // from class: com.transsion.home.fragment.tab.FilterFragment$showNoNetworkView$1$1$2
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
                        com.tn.lib.view.l.c(this.this$0.m1());
                    }
                });
            }
            com.tn.lib.view.l.a(m1());
        }
    }

    public static final void O1(FilterFragment this$0, View this_apply, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        this$0.f1(this$0.f52493q);
        this$0.f52491o = null;
        so.c.g(this_apply);
        this$0.f52495s = true;
        this$0.E1();
    }

    public static final void R1(FilterFragment this$0) {
        h9.f fVarQ;
        Intrinsics.g(this$0, "this$0");
        com.transsion.home.adapter.a aVar = this$0.f52484h;
        if (aVar == null || (fVarQ = aVar.Q()) == null) {
            return;
        }
        fVarQ.r();
    }

    private final void initViewModel() {
        MovieViewModel movieViewModel = this.f52485i;
        if (movieViewModel != null) {
            movieViewModel.e().j(this, new f(new FilterFragment$initViewModel$1$1(this)));
            movieViewModel.h().j(this, new f(new Function1<RefreshBaseDto<MovieBean>, Unit>() { // from class: com.transsion.home.fragment.tab.FilterFragment$initViewModel$1$2
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
                    lt.j jVar = (lt.j) this.this$0.getMViewBinding();
                    SwipeRefreshLayout swipeRefreshLayout2 = jVar != null ? jVar.f70453d : null;
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
                            FilterFragment filterFragment = this.this$0;
                            filterFragment.Q1(data, refreshBaseDto.isRefresh());
                            filterFragment.P1();
                            View view = filterFragment.f52500x;
                            if (view != null) {
                                so.c.g(view);
                            }
                        }
                        this.this$0.hideLoading();
                        return;
                    }
                    if (refreshBaseDto.isRefresh()) {
                        lt.j jVar2 = (lt.j) this.this$0.getMViewBinding();
                        if (jVar2 != null && (swipeRefreshLayout = jVar2.f70453d) != null && swipeRefreshLayout.isRefreshing()) {
                            lt.j jVar3 = (lt.j) this.this$0.getMViewBinding();
                            SwipeRefreshLayout swipeRefreshLayout3 = jVar3 != null ? jVar3.f70453d : null;
                            if (swipeRefreshLayout3 != null) {
                                swipeRefreshLayout3.setRefreshing(false);
                            }
                            this.this$0.t0();
                        }
                    } else {
                        com.transsion.home.adapter.a aVar2 = this.this$0.f52484h;
                        if (aVar2 != null && (fVarQ = aVar2.Q()) != null && fVarQ.q() && (aVar = this.this$0.f52484h) != null && (fVarQ2 = aVar.Q()) != null) {
                            fVarQ2.u();
                        }
                    }
                    com.transsion.home.adapter.a aVar3 = this.this$0.f52484h;
                    if (aVar3 == null || (listD = aVar3.D()) == null || listD.size() != 0) {
                        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                            zp.b.f82110a.d(R$string.str_ad_video_error_tips);
                            return;
                        } else {
                            zp.b.f82110a.d(com.tn.lib.widget.R$string.no_network_toast);
                            return;
                        }
                    }
                    if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
                        this.this$0.M1();
                    } else {
                        FilterFragment filterFragment2 = this.this$0;
                        filterFragment2.N1(filterFragment2.getString(com.transsion.home.R$string.home_no_network_content));
                    }
                }
            }));
            movieViewModel.j().j(this, new f(new Function1<st.a, Unit>() { // from class: com.transsion.home.fragment.tab.FilterFragment$initViewModel$1$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(st.a aVar) {
                    invoke2(aVar);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(st.a aVar) {
                    if (aVar != null) {
                        FilterFragment filterFragment = this.this$0;
                        filterFragment.F1(aVar.b(), aVar.c());
                        com.transsion.baselib.helper.a.f51183a.g(filterFragment.o1(filterFragment.f52493q, filterFragment.f52492p), aVar.a(), (28 & 4) != 0 ? "" : null, (28 & 8) != 0 ? "" : null, (28 & 16) != 0 ? "" : null);
                        nt.b bVar = filterFragment.f52498v;
                        if (bVar != null) {
                            bVar.e();
                        }
                    }
                }
            }));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u1() {
        RecyclerView recyclerView;
        if (this.f52498v == null) {
            nt.b bVar = new nt.b(0.6f, new b(), false, 4, null);
            lt.j jVar = (lt.j) getMViewBinding();
            if (jVar != null && (recyclerView = jVar.f70452c) != null) {
                recyclerView.addOnScrollListener(bVar);
            }
            this.f52498v = bVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void y1(final FilterFragment this$0) {
        RecyclerView recyclerView;
        Intrinsics.g(this$0, "this$0");
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            this$0.I1();
            return;
        }
        zp.b.f82110a.d(com.tn.lib.widget.R$string.no_network_toast);
        lt.j jVar = (lt.j) this$0.getMViewBinding();
        if (jVar == null || (recyclerView = jVar.f70452c) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.tab.j
            @Override // java.lang.Runnable
            public final void run() {
                FilterFragment.z1(this.f52612a);
            }
        }, 500L);
    }

    public static final void z1(FilterFragment this$0) {
        h9.f fVarQ;
        Intrinsics.g(this$0, "this$0");
        com.transsion.home.adapter.a aVar = this$0.f52484h;
        if (aVar == null || (fVarQ = aVar.Q()) == null) {
            return;
        }
        fVarQ.u();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B1(View view) {
        lt.u uVar;
        ConstraintLayout constraintLayout;
        RecyclerView recyclerView;
        SwipeRefreshLayout swipeRefreshLayout;
        lt.j jVar = (lt.j) getMViewBinding();
        SwipeRefreshLayout swipeRefreshLayout2 = jVar != null ? jVar.f70453d : null;
        if (swipeRefreshLayout2 != null) {
            swipeRefreshLayout2.setEnabled(false);
        }
        lt.j jVar2 = (lt.j) getMViewBinding();
        if (jVar2 != null && (swipeRefreshLayout = jVar2.f70453d) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsion.home.fragment.tab.h
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
                public final void a() {
                    FilterFragment.C1(this.f52606a);
                }
            });
        }
        lt.j jVar3 = (lt.j) getMViewBinding();
        if (jVar3 != null && (recyclerView = jVar3.f70452c) != null) {
            recyclerView.addOnScrollListener(new d(view));
        }
        lt.j jVar4 = (lt.j) getMViewBinding();
        if (jVar4 == null || (uVar = jVar4.f70451b) == null || (constraintLayout = uVar.f70518c) == null) {
            return;
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.tab.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FilterFragment.D1(this.f52609a, view2);
            }
        });
    }

    public final void F1(String str, String str2) {
        this.f52490n = 1;
        HashMap<String, String> map = this.f52496t.get(this.f52493q);
        if (map != null) {
            map.put(str, str2);
        }
        g1(this.f52493q, map, true);
    }

    public final void G1(String str, HashMap<String, String> map) {
        List<Channel> typeList;
        this.f52490n = 1;
        FilterItems filterItems = this.f52492p;
        if (filterItems == null || (typeList = filterItems.getTypeList()) == null) {
            return;
        }
        for (Channel channel : typeList) {
            if (Intrinsics.b(channel.getChannelId(), str)) {
                if (map == null || map.isEmpty()) {
                    map = this.f52496t.get(str);
                    List<Item> items = channel.getItems();
                    if (items != null) {
                        for (Item item : items) {
                            if ((map != null ? map.get(item.getFilterType()) : null) == null && map != null) {
                                map.put(item.getFilterType(), item.getFilterValsV2().get(0).getName());
                            }
                        }
                    }
                } else {
                    this.f52496t.put(str, map);
                }
                g1(str, map, true);
                return;
            }
        }
    }

    public final void J1(List<st.a> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            com.transsion.baselib.helper.a.f51183a.a("home_filter_page", j1((st.a) it.next(), "browse_filter"));
        }
    }

    public final void K1(st.a aVar) {
        com.transsion.baselib.helper.a.f51183a.h("home_filter_page", j1(aVar, "click_filter"));
    }

    public final void N1(String str) {
        if (this.f52502z == null) {
            lt.t tVar = this.f52487k;
            if (tVar == null) {
                Intrinsics.y("headerBinding");
                tVar = null;
            }
            this.f52502z = tVar.f70515g.inflate();
        }
        final View view = this.f52502z;
        if (view != null) {
            so.c.k(view);
            TextView textView = (TextView) view.findViewById(R$id.tv_no_result);
            if (textView != null) {
                Intrinsics.f(textView, "findViewById<TextView>(R.id.tv_no_result)");
                textView.setText(str);
            }
            View viewFindViewById = view.findViewById(R$id.tv_reset);
            if (viewFindViewById != null) {
                viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.tab.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        FilterFragment.O1(this.f52601a, view, view2);
                    }
                });
            }
        }
    }

    public final void P1() {
        List<Item> listH1;
        if (this.f52495s && (listH1 = h1(this.f52493q)) != null) {
            FilterExpandView filterExpandView = this.f52489m;
            FilterExpandView filterExpandView2 = null;
            if (filterExpandView == null) {
                Intrinsics.y("filterView");
                filterExpandView = null;
            }
            if (filterExpandView.getHasInit()) {
                FilterExpandView filterExpandView3 = this.f52489m;
                if (filterExpandView3 == null) {
                    Intrinsics.y("filterView");
                    filterExpandView3 = null;
                }
                FilterExpandView.updateList$default(filterExpandView3, listH1, null, 2, null);
            } else {
                FilterExpandView filterExpandView4 = this.f52489m;
                if (filterExpandView4 == null) {
                    Intrinsics.y("filterView");
                    filterExpandView4 = null;
                }
                FilterExpandView.updateList$default(filterExpandView4, listH1, null, 2, null);
            }
            FilterExpandView filterExpandView5 = this.f52489m;
            if (filterExpandView5 == null) {
                Intrinsics.y("filterView");
            } else {
                filterExpandView2 = filterExpandView5;
            }
            filterExpandView2.setMovieModel(this.f52485i);
            this.f52495s = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Q1(MovieBean movieBean, boolean z11) {
        h9.f fVarQ;
        lt.j jVar;
        LinearLayout linearLayoutB;
        h9.f fVarQ2;
        com.transsion.home.adapter.a aVar;
        h9.f fVarQ3;
        SwipeRefreshLayout swipeRefreshLayout;
        Integer perPage;
        if (movieBean != null) {
            Pager pager = movieBean.getPager();
            this.f52494r = (pager == null || (perPage = pager.getPerPage()) == null) ? 10 : perPage.intValue();
            if (z11) {
                lt.j jVar2 = (lt.j) getMViewBinding();
                if (jVar2 != null && (swipeRefreshLayout = jVar2.f70453d) != null && swipeRefreshLayout.isRefreshing()) {
                    lt.j jVar3 = (lt.j) getMViewBinding();
                    SwipeRefreshLayout swipeRefreshLayout2 = jVar3 != null ? jVar3.f70453d : null;
                    if (swipeRefreshLayout2 != null) {
                        swipeRefreshLayout2.setRefreshing(false);
                    }
                }
                com.transsion.home.adapter.a aVar2 = this.f52484h;
                if (aVar2 != null) {
                    aVar2.w0(movieBean.getItems());
                }
                List<MovieItem> items = movieBean.getItems();
                if (items == null || !items.isEmpty()) {
                    r1();
                } else {
                    N1(getString(com.transsion.home.R$string.no_filter_result));
                }
            } else {
                com.transsion.home.adapter.a aVar3 = this.f52484h;
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
                    com.transsion.home.adapter.a aVar4 = this.f52484h;
                    if (aVar4 == null || (fVarQ2 = aVar4.Q()) == null) {
                        return;
                    }
                    h9.f.t(fVarQ2, false, 1, null);
                    return;
                }
                com.transsion.home.adapter.a aVar5 = this.f52484h;
                if (aVar5 != null) {
                    aVar5.m(arrayList);
                }
                com.transsion.home.adapter.a aVar6 = this.f52484h;
                if (aVar6 != null && (fVarQ = aVar6.Q()) != null && fVarQ.q() && (jVar = (lt.j) getMViewBinding()) != null && (linearLayoutB = jVar.getRoot()) != null) {
                    linearLayoutB.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.tab.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            FilterFragment.R1(this.f52604a);
                        }
                    }, 300L);
                }
            }
            Pager pager2 = movieBean.getPager();
            if (pager2 == null || !Intrinsics.b(pager2.getHasMore(), Boolean.FALSE) || (aVar = this.f52484h) == null || (fVarQ3 = aVar.Q()) == null) {
                return;
            }
            h9.f.t(fVarQ3, false, 1, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S1() {
        lt.u uVar;
        AppCompatTextView appCompatTextView;
        StringBuilder sb2 = new StringBuilder();
        HashMap<String, String> map = this.f52496t.get(this.f52493q);
        String str = "All";
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!Intrinsics.b(entry.getValue(), "All")) {
                    sb2.append(entry.getValue());
                    sb2.append(" • ");
                }
            }
        }
        boolean zQ = StringsKt__StringsKt.Q(sb2, " • ", false, 2, null);
        StringBuilder filterNames = sb2;
        if (zQ) {
            filterNames = sb2.substring(0, sb2.length() - 2);
        }
        Intrinsics.f(filterNames, "filterNames");
        CharSequence charSequence = str;
        if (filterNames.length() != 0) {
            charSequence = filterNames;
        }
        lt.j jVar = (lt.j) getMViewBinding();
        if (jVar == null || (uVar = jVar.f70451b) == null || (appCompatTextView = uVar.f70517b) == null) {
            return;
        }
        appCompatTextView.setText(charSequence);
        so.c.k(appCompatTextView);
    }

    public final void T1(HashMap<String, String> map) {
        this.f52495s = false;
        FilterExpandView filterExpandView = this.f52489m;
        FilterExpandView filterExpandView2 = null;
        if (filterExpandView == null) {
            Intrinsics.y("filterView");
            filterExpandView = null;
        }
        if (filterExpandView.getMovieModel() == null) {
            FilterExpandView filterExpandView3 = this.f52489m;
            if (filterExpandView3 == null) {
                Intrinsics.y("filterView");
                filterExpandView3 = null;
            }
            filterExpandView3.setMovieModel(this.f52485i);
        }
        List<Item> listH1 = h1(this.f52493q);
        if (listH1 != null) {
            FilterExpandView filterExpandView4 = this.f52489m;
            if (filterExpandView4 == null) {
                Intrinsics.y("filterView");
            } else {
                filterExpandView2 = filterExpandView4;
            }
            filterExpandView2.updateList(listH1, map);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e1(int i11) {
        View view;
        RecyclerView recyclerView;
        List<Channel> typeList;
        Channel channel;
        List<Channel> typeList2;
        FilterItems filterItems = this.f52492p;
        int size = (filterItems == null || (typeList2 = filterItems.getTypeList()) == null) ? -1 : typeList2.size();
        if (i11 < 0 || i11 >= size) {
            return;
        }
        FilterItems filterItems2 = this.f52492p;
        this.f52493q = (filterItems2 == null || (typeList = filterItems2.getTypeList()) == null || (channel = typeList.get(i11)) == null) ? null : channel.getChannelId();
        lt.j jVar = (lt.j) getMViewBinding();
        RecyclerView.m layoutManager = (jVar == null || (recyclerView = jVar.f70452c) == null) ? null : recyclerView.getLayoutManager();
        if (layoutManager instanceof OffsetGridLayoutManager) {
            OffsetGridLayoutManager offsetGridLayoutManager = (OffsetGridLayoutManager) layoutManager;
            if (offsetGridLayoutManager.getSpanCount() == n1()) {
                uo.b.a.f(uo.b.f78622a, "MovieFragment", "span count is same " + offsetGridLayoutManager.getSpanCount(), false, 4, null);
                return;
            }
        }
        x1();
        View view2 = this.f52486j;
        if (view2 == null) {
            Intrinsics.y("header");
            view2 = null;
        }
        ViewParent parent = view2.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) parent;
            View view3 = this.f52486j;
            if (view3 == null) {
                Intrinsics.y("header");
                view3 = null;
            }
            viewGroup.removeView(view3);
        }
        com.transsion.home.adapter.a aVar = this.f52484h;
        if (aVar != null) {
            View view4 = this.f52486j;
            if (view4 == null) {
                Intrinsics.y("header");
                view = null;
            } else {
                view = view4;
            }
            BaseQuickAdapter.q(aVar, view, 0, 0, 6, null);
        }
        L1();
    }

    public final void f1(String str) {
        HashMap<String, String> map = this.f52496t.get(str);
        if (map != null) {
            map.clear();
        }
    }

    public final void g1(String str, HashMap<String, String> map, boolean z11) {
        MovieViewModel movieViewModel = this.f52485i;
        if (movieViewModel != null) {
            int i11 = this.f52490n;
            this.f52490n = i11 + 1;
            movieViewModel.g(i11, this.f52494r, str, map, z11);
        }
        this.f52499w = map;
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void h0() {
        super.h0();
        this.f52490n = 1;
        String str = this.f52493q;
        g1(str, this.f52496t.get(str), true);
        nt.b bVar = this.f52498v;
        if (bVar != null) {
            bVar.e();
        }
    }

    public final List<Item> h1(String str) {
        List<Channel> typeList;
        FilterItems filterItems = this.f52492p;
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

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void hideLoading() {
        q1();
    }

    public final List<st.a> i1() {
        List<Channel> typeList;
        ArrayList arrayList = new ArrayList();
        FilterItems filterItems = this.f52492p;
        if (filterItems != null && (typeList = filterItems.getTypeList()) != null) {
            for (Channel channel : typeList) {
                arrayList.add(new st.a(String.valueOf(channel.getChannelId()), String.valueOf(channel.getChannelName()), String.valueOf(channel.getSubjectType()), Intrinsics.b(channel.getChannelId(), this.f52493q), null, 16, null));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment, com.transsion.baseui.fragment.BaseFragment
    @SuppressLint({"InflateParams"})
    public void initView(View view, Bundle bundle) {
        lt.u uVar;
        ConstraintLayout constraintLayout;
        Intrinsics.g(view, "view");
        this.f52485i = (MovieViewModel) new v0(this).a(MovieViewModel.class);
        TabExpandView tabExpandView = null;
        View it = LayoutInflater.from(getContext()).inflate(R$layout.header_filter, (ViewGroup) null);
        lt.t tVarA = lt.t.a(it);
        Intrinsics.f(tVarA, "bind(it)");
        this.f52487k = tVarA;
        if (tVarA == null) {
            Intrinsics.y("headerBinding");
            tVarA = null;
        }
        TabExpandView tabExpandView2 = tVarA.f70511b;
        Intrinsics.f(tabExpandView2, "headerBinding.channelExpand");
        this.f52488l = tabExpandView2;
        lt.t tVar = this.f52487k;
        if (tVar == null) {
            Intrinsics.y("headerBinding");
            tVar = null;
        }
        FilterExpandView filterExpandView = tVar.f70512c;
        Intrinsics.f(filterExpandView, "headerBinding.filterExpand");
        this.f52489m = filterExpandView;
        v1();
        u1();
        x1();
        Intrinsics.f(it, "it");
        B1(it);
        com.transsion.home.adapter.a aVar = this.f52484h;
        if (aVar != null) {
            BaseQuickAdapter.q(aVar, it, 0, 0, 6, null);
        }
        initViewModel();
        setNetListener(new e());
        TabExpandView tabExpandView3 = this.f52488l;
        if (tabExpandView3 == null) {
            Intrinsics.y("channelView");
        } else {
            tabExpandView = tabExpandView3;
        }
        tabExpandView.setOnItemClickListener(new Function1<st.a, Unit>() { // from class: com.transsion.home.fragment.tab.FilterFragment$initView$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(st.a aVar2) {
                invoke2(aVar2);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(st.a data) {
                RecyclerView recyclerView;
                List<Channel> typeList;
                Intrinsics.g(data, "data");
                uo.b.a.f(uo.b.f78622a, "MovieFragment", "selected tab " + data.c(), false, 4, null);
                FilterItems filterItems = this.this$0.f52492p;
                if (filterItems != null && (typeList = filterItems.getTypeList()) != null) {
                    FilterFragment filterFragment = this.this$0;
                    int i11 = 0;
                    for (Object obj : typeList) {
                        int i12 = i11 + 1;
                        if (i11 < 0) {
                            kotlin.collections.g.u();
                        }
                        if (Intrinsics.b(((Channel) obj).getChannelId(), data.c())) {
                            filterFragment.e1(i11);
                        }
                        i11 = i12;
                    }
                }
                this.this$0.K1(data);
                nt.b bVar = this.this$0.f52498v;
                if (bVar != null) {
                    bVar.e();
                }
                FilterFragment filterFragment2 = this.this$0;
                FilterExpandView filterExpandView2 = null;
                FilterFragment.H1(filterFragment2, filterFragment2.f52493q, null, 2, null);
                FilterFragment filterFragment3 = this.this$0;
                filterFragment3.T1((HashMap) filterFragment3.f52496t.get(this.this$0.f52493q));
                lt.j jVar = (lt.j) this.this$0.getMViewBinding();
                if (jVar != null && (recyclerView = jVar.f70452c) != null) {
                    recyclerView.scrollToPosition(0);
                }
                TabExpandView tabExpandView4 = this.this$0.f52488l;
                if (tabExpandView4 == null) {
                    Intrinsics.y("channelView");
                    tabExpandView4 = null;
                }
                tabExpandView4.collapse();
                FilterExpandView filterExpandView3 = this.this$0.f52489m;
                if (filterExpandView3 == null) {
                    Intrinsics.y("filterView");
                } else {
                    filterExpandView2 = filterExpandView3;
                }
                filterExpandView2.expandFilter(0);
                if (this.this$0.n1() > 2) {
                    BiddingListManager biddingListManagerO0 = this.this$0.o0();
                    if (biddingListManagerO0 != null) {
                        biddingListManagerO0.C(false);
                        return;
                    }
                    return;
                }
                BiddingListManager biddingListManagerO1 = this.this$0.o0();
                if (biddingListManagerO1 != null) {
                    biddingListManagerO1.C(true);
                }
            }
        });
        Intrinsics.f(it, "from(context).inflate(R.…}\n            }\n        }");
        this.f52486j = it;
        int color = z2.a.getColor(requireContext(), R$color.module_01);
        lt.j jVar = (lt.j) getMViewBinding();
        if (jVar == null || (uVar = jVar.f70451b) == null || (constraintLayout = uVar.f70518c) == null) {
            return;
        }
        constraintLayout.setBackgroundColor(color);
    }

    public final Map<String, String> j1(st.a aVar, String str) {
        HashMap map = new HashMap();
        map.put("event_type", str);
        map.put(CampaignEx.JSON_KEY_TITLE, aVar.a());
        map.put("type", aVar.b());
        map.put("tabId", String.valueOf(k0()));
        return map;
    }

    public final LayoutStyle k1(String str) {
        List<Channel> typeList;
        FilterItems filterItems = this.f52492p;
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public RecyclerView l0() {
        lt.j jVar = (lt.j) getMViewBinding();
        if (jVar != null) {
            return jVar.f70452c;
        }
        return null;
    }

    public final int l1() {
        return R$layout.home_empty_view_loading;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        E1();
    }

    public final String m1() {
        Fragment parentFragment = getParentFragment();
        return parentFragment instanceof HomeFragment ? ((HomeFragment) parentFragment).x0() : "";
    }

    public final int n1() {
        LayoutStyle layoutStyleK1 = k1(this.f52493q);
        if (layoutStyleK1 != null) {
            int colNum = layoutStyleK1.getColNum();
            FragmentActivity activity = getActivity();
            return colNum + ((activity == null || !com.transsion.baseui.util.b.a(activity)) ? 0 : 1);
        }
        if (Intrinsics.b(this.f52493q, "5") || Intrinsics.b(this.f52493q, PrepareException.ERROR_NO_URL) || Intrinsics.b(this.f52493q, "1003") || Intrinsics.b(this.f52493q, "1004")) {
            return 2;
        }
        FragmentActivity activity2 = getActivity();
        return (activity2 == null || !com.transsion.baseui.util.b.a(activity2)) ? 3 : 4;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h(m1(), false, 2, null);
    }

    public final String o1(String str, FilterItems filterItems) {
        List<Channel> typeList;
        String strJ0 = j0();
        if (strJ0 != null && strJ0.length() != 0) {
            String strJ1 = j0();
            return strJ1 == null ? "" : strJ1;
        }
        if (filterItems != null && (typeList = filterItems.getTypeList()) != null) {
            for (Channel channel : typeList) {
                if (Intrinsics.b(str, channel.getChannelId())) {
                    String channelName = channel.getChannelName();
                    return channelName == null ? m1() : channelName;
                }
            }
        }
        return m1();
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment, com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f52491o = arguments != null ? arguments.getString("filter_json") : null;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f52490n = 1;
        MovieViewModel movieViewModel = this.f52485i;
        androidx.lifecycle.c0<BaseDto<FilterItems>> c0VarF = movieViewModel != null ? movieViewModel.f() : null;
        if (c0VarF != null) {
            c0VarF.q(null);
        }
        MovieViewModel movieViewModel2 = this.f52485i;
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
            } else {
                logPause();
                this.f52497u = SystemClock.elapsedRealtime();
            }
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.transsion.baselib.helper.a.f51183a.j(o1(this.f52493q, this.f52492p), com.transsion.baselib.report.m.f51277a.f(), String.valueOf(SystemClock.elapsedRealtime() - this.f52497u));
        nt.b bVar = this.f52498v;
        if (bVar != null) {
            bVar.e();
        }
        com.transsion.baseui.activity.d.l(null, this, "tabId=" + k0(), 1, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com.transsion.home.adapter.a aVar;
        List<MovieItem> listD;
        super.onResume();
        this.f52497u = SystemClock.elapsedRealtime();
        View view = this.f52500x;
        if (view != null && so.c.i(view) && com.tn.lib.util.networkinfo.f.f49475a.e() && (aVar = this.f52484h) != null && (listD = aVar.D()) != null && listD.isEmpty()) {
            View view2 = this.f52500x;
            if (view2 != null) {
                so.c.g(view2);
            }
            E1();
        }
        com.transsion.baseui.activity.d.p(null, this, "tabId=" + k0() + " visible=" + isVisible(), 1, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: p1, reason: merged with bridge method [inline-methods] */
    public lt.j getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        lt.j jVarC = lt.j.c(inflater);
        Intrinsics.f(jVarC, "inflate(inflater)");
        return jVarC;
    }

    public final void q1() {
        View view = this.f52501y;
        if (view != null) {
            so.c.g(view);
        }
    }

    public final void r1() {
        View view = this.f52502z;
        if (view != null) {
            so.c.g(view);
        }
    }

    @Override // com.transsion.home.fragment.tab.BaseHomeSubFragment
    public void s0(int i11, com.transsion.ad.bidding.nativead.c wrapperNativeManager) {
        List<MovieItem> listD;
        Intrinsics.g(wrapperNativeManager, "wrapperNativeManager");
        if (wrapperNativeManager != null) {
            MovieItem movieItem = new MovieItem(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 33554431, null);
            movieItem.setNonAdDelegate(wrapperNativeManager);
            com.transsion.home.adapter.a aVar = this.f52484h;
            int size = (aVar == null || (listD = aVar.D()) == null) ? 0 : listD.size();
            if (i11 < 0 || i11 > size) {
                com.transsion.home.adapter.a aVar2 = this.f52484h;
                if (aVar2 != null) {
                    aVar2.l(movieItem);
                    return;
                }
                return;
            }
            com.transsion.home.adapter.a aVar3 = this.f52484h;
            if (aVar3 != null) {
                aVar3.j(i11, movieItem);
            }
        }
    }

    public final void s1() {
        List<Channel> typeList;
        FilterItems filterItems = this.f52492p;
        TabExpandView tabExpandView = null;
        FilterExpandView filterExpandView = null;
        HashMap<String, String> mapT1 = t1(filterItems != null ? filterItems.getTypeList() : null);
        FilterItems filterItems2 = this.f52492p;
        int size = (filterItems2 == null || (typeList = filterItems2.getTypeList()) == null) ? 0 : typeList.size();
        if (size <= 0) {
            return;
        }
        if (size == 1) {
            TabExpandView tabExpandView2 = this.f52488l;
            if (tabExpandView2 == null) {
                Intrinsics.y("channelView");
                tabExpandView2 = null;
            }
            so.c.g(tabExpandView2);
        } else {
            TabExpandView tabExpandView3 = this.f52488l;
            if (tabExpandView3 == null) {
                Intrinsics.y("channelView");
                tabExpandView3 = null;
            }
            so.c.k(tabExpandView3);
            List<st.a> listI1 = i1();
            TabExpandView tabExpandView4 = this.f52488l;
            if (tabExpandView4 == null) {
                Intrinsics.y("channelView");
                tabExpandView4 = null;
            }
            tabExpandView4.updateData(listI1);
            J1(listI1);
        }
        G1(this.f52493q, mapT1);
        T1(this.f52496t.get(this.f52493q));
        if (!(!mapT1.isEmpty())) {
            TabExpandView tabExpandView5 = this.f52488l;
            if (tabExpandView5 == null) {
                Intrinsics.y("channelView");
            } else {
                tabExpandView = tabExpandView5;
            }
            tabExpandView.expand();
            return;
        }
        TabExpandView tabExpandView6 = this.f52488l;
        if (tabExpandView6 == null) {
            Intrinsics.y("channelView");
            tabExpandView6 = null;
        }
        tabExpandView6.collapse();
        FilterExpandView filterExpandView2 = this.f52489m;
        if (filterExpandView2 == null) {
            Intrinsics.y("filterView");
        } else {
            filterExpandView = filterExpandView2;
        }
        filterExpandView.expandFilter(mapT1.size() - 1);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void startLoading() {
        L1();
    }

    public final HashMap<String, String> t1(List<Channel> list) {
        Object next;
        if (list == null) {
            return new HashMap<>();
        }
        HashMap<String, String> map = new HashMap<>();
        String str = this.f52491o;
        if (str != null && str.length() != 0) {
            try {
                JSONObject jSONObject = new JSONObject(this.f52491o);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String key = itKeys.next();
                    String value = jSONObject.getString(key);
                    if (Intrinsics.b(key, "channelId")) {
                        Iterator<T> it = list.iterator();
                        do {
                            if (!it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                        } while (!Intrinsics.b(((Channel) next).getChannelId(), value));
                        if (((Channel) next) == null) {
                            return new HashMap<>();
                        }
                        this.f52493q = value;
                    } else {
                        Intrinsics.f(key, "key");
                        Intrinsics.f(value, "value");
                        map.put(key, value);
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return map;
    }

    public final void v1() {
        FilterExpandView filterExpandView = this.f52489m;
        if (filterExpandView == null) {
            Intrinsics.y("filterView");
            filterExpandView = null;
        }
        filterExpandView.setReportEvent(new FilterFragment$initFilter$1(this));
    }

    public final void w1() {
        List<Channel> typeList;
        this.f52496t.clear();
        FilterItems filterItems = this.f52492p;
        if (filterItems == null || (typeList = filterItems.getTypeList()) == null) {
            return;
        }
        Iterator<T> it = typeList.iterator();
        while (it.hasNext()) {
            this.f52496t.put(((Channel) it.next()).getChannelId(), new HashMap<>());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x1() {
        RecyclerView recyclerView;
        lt.j jVar;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        int iN1 = n1();
        OffsetGridLayoutManager offsetGridLayoutManager = new OffsetGridLayoutManager(getContext(), iN1, 1, false);
        lt.j jVar2 = (lt.j) getMViewBinding();
        if (jVar2 != null && (recyclerView3 = jVar2.f70452c) != null) {
            recyclerView3.setLayoutManager(offsetGridLayoutManager);
        }
        final com.transsion.home.adapter.a aVar = new com.transsion.home.adapter.a(new ArrayList(), this.f52498v, k1(this.f52493q), iN1);
        aVar.Q().y(true);
        aVar.Q().x(true);
        aVar.Q().C(new f9.f() { // from class: com.transsion.home.fragment.tab.d
            @Override // f9.f
            public final void a() {
                FilterFragment.y1(this.f52595a);
            }
        });
        aVar.o0(new c());
        aVar.B0(new f9.d() { // from class: com.transsion.home.fragment.tab.e
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                FilterFragment.A1(this.f52597a, aVar, baseQuickAdapter, view, i11);
            }
        });
        this.f52484h = aVar;
        lt.j jVar3 = (lt.j) getMViewBinding();
        if (jVar3 != null && (recyclerView = jVar3.f70452c) != null && recyclerView.getItemDecorationCount() < 1 && (jVar = (lt.j) getMViewBinding()) != null && (recyclerView2 = jVar.f70452c) != null) {
            recyclerView2.addItemDecoration(new ro.b(com.blankj.utilcode.util.f0.a(4.0f), com.blankj.utilcode.util.f0.a(4.0f), com.blankj.utilcode.util.f0.a(16.0f), com.blankj.utilcode.util.f0.a(16.0f)));
        }
        lt.j jVar4 = (lt.j) getMViewBinding();
        RecyclerView recyclerView4 = jVar4 != null ? jVar4.f70452c : null;
        if (recyclerView4 == null) {
            return;
        }
        recyclerView4.setAdapter(this.f52484h);
    }
}
