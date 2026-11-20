package com.transsion.search.fragment.result;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.Postcard;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.tn.lib.widget.R$mipmap;
import com.transsion.baselib.utils.i;
import com.transsion.baseui.R$string;
import com.transsion.baseui.widget.DrawableCenterTextView;
import com.transsion.baseui.widget.ResourcesRequestView;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.publish.model.PostEntity;
import com.transsion.push.notification.permission.NoticePermissionFrom;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.bean.HotRankItem;
import com.transsion.search.bean.Pager;
import com.transsion.search.bean.SearchResultEntity;
import com.transsion.search.bean.TabItem;
import com.transsion.search.bean.VerticalRank;
import com.transsion.search.fragment.BaseSearchMainFragment;
import java.util.ArrayList;
import java.util.List;
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
public final class SearchResultTabFragment extends BaseSearchMainFragment<bx.h> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f57557n = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public fx.a f57558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f57559b = LazyKt__LazyJVMKt.b(new Function0<SearchResultViewModel>() { // from class: com.transsion.search.fragment.result.SearchResultTabFragment$viewModel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SearchResultViewModel invoke() {
            return (SearchResultViewModel) new v0(this.this$0).a(SearchResultViewModel.class);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f57560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TabItem f57561d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f57562f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public zr.b f57563g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f57564h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f57565i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SearchResultEntity f57566j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ResourcesRequestView f57567k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f57568l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f57569m;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SearchResultTabFragment a(String str, TabItem tabItem, SearchResultEntity searchResultEntity, String str2) {
            Bundle bundle = new Bundle();
            bundle.putString("tabKeyword", str);
            bundle.putParcelable("tabItem", tabItem);
            if (searchResultEntity != null) {
                bundle.putParcelable("tabResult", searchResultEntity);
            }
            bundle.putString("searchFrom", str2);
            SearchResultTabFragment searchResultTabFragment = new SearchResultTabFragment();
            searchResultTabFragment.setArguments(bundle);
            return searchResultTabFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f57570a;

        static {
            int[] iArr = new int[ResultType.values().length];
            try {
                iArr[ResultType.SUBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ResultType.STAFF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ResultType.GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ResultType.VERTICAL_RANK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ResultType.MORE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f57570a = iArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements zr.a {

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f57572a;

            static {
                int[] iArr = new int[ResultType.values().length];
                try {
                    iArr[ResultType.SUBJECT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ResultType.STAFF.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ResultType.GROUP.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ResultType.VERTICAL_RANK.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                f57572a = iArr;
            }
        }

        public c() {
        }

        @Override // zr.a
        public void a(int i11, long j11, View view) {
            String strV0;
            List<ResultWrapData> listD;
            List<ResultWrapData> listD2;
            fx.a aVar = SearchResultTabFragment.this.f57558a;
            if (i11 >= ((aVar == null || (listD2 = aVar.D()) == null) ? 0 : listD2.size())) {
                return;
            }
            fx.a aVar2 = SearchResultTabFragment.this.f57558a;
            if (aVar2 == null || (strV0 = aVar2.V0()) == null) {
                strV0 = SearchResultTabFragment.this.f57565i;
            }
            String str = strV0;
            fx.a aVar3 = SearchResultTabFragment.this.f57558a;
            ResultWrapData resultWrapData = (aVar3 == null || (listD = aVar3.D()) == null) ? null : listD.get(i11);
            ResultType type = resultWrapData != null ? resultWrapData.getType() : null;
            int i12 = type == null ? -1 : a.f57572a[type.ordinal()];
            if (i12 == 1) {
                jx.b.f68176a.q(resultWrapData.getSubject(), i11, j11, SearchResultTabFragment.this.f57560c, SearchResultTabFragment.this.f57562f, str);
                return;
            }
            if (i12 == 2) {
                jx.b.f68176a.o(resultWrapData.getStaff(), i11, j11, SearchResultTabFragment.this.f57560c, SearchResultTabFragment.this.f57562f, str);
            } else if (i12 == 3) {
                jx.b.f68176a.a(resultWrapData.getGroups(), i11, j11, SearchResultTabFragment.this.f57560c, SearchResultTabFragment.this.f57562f, str);
            } else {
                if (i12 != 4) {
                    return;
                }
                jx.b.f68176a.j(resultWrapData.getVerticalRank(), i11, j11, SearchResultTabFragment.this.f57560c, SearchResultTabFragment.this.f57562f, str);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends RecyclerView.r {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            RecyclerView recyclerView2;
            Intrinsics.g(recyclerView, "recyclerView");
            if (i11 == 0) {
                SearchResultTabFragment.this.f57564h = System.currentTimeMillis();
            } else {
                if (i11 != 1) {
                    return;
                }
                bx.h hVar = (bx.h) SearchResultTabFragment.this.getMViewBinding();
                RecyclerView.m layoutManager = (hVar == null || (recyclerView2 = hVar.f14489b) == null) ? null : recyclerView2.getLayoutManager();
                jx.b.f68176a.n(SearchResultTabFragment.this.f57565i, SearchResultTabFragment.this.f57560c, System.currentTimeMillis() - SearchResultTabFragment.this.f57564h, layoutManager instanceof LinearLayoutManager ? ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() : -1);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e extends GridLayoutManager.c {
        public e() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int f(int i11) {
            ResultWrapData item;
            fx.a aVar = SearchResultTabFragment.this.f57558a;
            ResultType type = (aVar == null || (item = aVar.getItem(i11)) == null) ? null : item.getType();
            return (type == ResultType.MORE || type == ResultType.TITLE) ? 2 : 1;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f57575a;

        public f(Function1 function) {
            Intrinsics.g(function, "function");
            this.f57575a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f57575a;
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
            this.f57575a.invoke(obj);
        }
    }

    public static final void C0(SearchResultTabFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.f57564h == 0) {
            this$0.f57564h = System.currentTimeMillis();
        }
    }

    public static final void D0(SearchResultTabFragment this$0, fx.b tabAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        String tabId;
        List<TabItem> subs;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(tabAdapter, "$tabAdapter");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "<anonymous parameter 1>");
        TabItem tabItem = this$0.f57561d;
        TabItem tabItem2 = (tabItem == null || (subs = tabItem.getSubs()) == null) ? null : subs.get(i11);
        if (Intrinsics.b(this$0.f57565i, tabItem2 != null ? tabItem2.getTabId() : null)) {
            return;
        }
        this$0.f57565i = tabItem2 != null ? tabItem2.getTabId() : null;
        if (tabItem2 == null || (tabId = tabItem2.getTabId()) == null) {
            tabId = "";
        }
        tabAdapter.H0(tabId);
        this$0.K0(true);
        this$0.y0().p(1);
        SearchResultViewModel searchResultViewModelY0 = this$0.y0();
        String str = this$0.f57560c;
        SearchResultViewModel.o(searchResultViewModelY0, str == null ? "" : str, this$0.f57565i, false, 4, null);
        zr.b bVar = this$0.f57563g;
        if (bVar != null) {
            bVar.g();
        }
        jx.b.f68176a.s(this$0.f57560c, this$0.f57565i);
    }

    public static final void E0(SearchResultTabFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        SearchResultViewModel searchResultViewModelY0 = this$0.y0();
        String str = this$0.f57560c;
        if (str == null) {
            str = "";
        }
        String str2 = this$0.f57565i;
        searchResultViewModelY0.n(str, str2 != null ? str2 : "", true);
    }

    public static final void F0(SearchResultTabFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        ResultWrapData item;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "<anonymous parameter 1>");
        fx.a aVar = this$0.f57558a;
        if (aVar == null || (item = aVar.getItem(i11)) == null) {
            return;
        }
        this$0.J0(item, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final View G0() {
        DrawableCenterTextView drawableCenterTextView;
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            LayoutInflater layoutInflater = getLayoutInflater();
            int i11 = R$layout.view_search_no_network;
            bx.h hVar = (bx.h) getMViewBinding();
            View view = layoutInflater.inflate(i11, (ViewGroup) (hVar != null ? hVar.f14489b : null), false);
            TextView textView = (TextView) view.findViewById(R$id.tv_empty_tips);
            ImageView imageView = (ImageView) view.findViewById(R$id.iv_tips);
            AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R$id.tv_retry);
            textView.setText(R$string.base_net_err);
            imageView.setImageResource(R$mipmap.ic_no_network);
            appCompatTextView.setVisibility(0);
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.result.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SearchResultTabFragment.H0(this.f57594a, view2);
                }
            });
            Intrinsics.f(view, "view");
            return view;
        }
        LayoutInflater layoutInflater2 = getLayoutInflater();
        int i12 = R$layout.view_search_empty;
        bx.h hVar2 = (bx.h) getMViewBinding();
        View view2 = layoutInflater2.inflate(i12, (ViewGroup) (hVar2 != null ? hVar2.f14489b : null), false);
        final ResourcesRequestView resourcesRequestView = (ResourcesRequestView) view2.findViewById(R$id.resources_request);
        this.f57567k = resourcesRequestView;
        final String str = this.f57560c;
        if (str == null) {
            str = "";
        }
        if (str.length() > 10) {
            String strSubstring = str.substring(0, 10);
            Intrinsics.f(strSubstring, "substring(...)");
            str = strSubstring + "...";
        }
        String string = getString(com.transsion.search.R$string.search_value_no_result, this.f57560c);
        Intrinsics.f(string, "getString(R.string.searc…value_no_result, keyword)");
        resourcesRequestView.set(string);
        resourcesRequestView.setGray(true);
        y0().l(str, true);
        this.f57568l = null;
        fs.f mViewBinding = resourcesRequestView.getMViewBinding();
        if (mViewBinding != null && (drawableCenterTextView = mViewBinding.f65283f) != null) {
            drawableCenterTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.search.fragment.result.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    SearchResultTabFragment.I0(this.f57591a, str, resourcesRequestView, view3);
                }
            });
        }
        Intrinsics.f(view2, "view");
        return view2;
    }

    public static final void H0(SearchResultTabFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.lazyLoadData();
    }

    public static final void I0(SearchResultTabFragment this$0, String splitKeyword, ResourcesRequestView requestView, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(splitKeyword, "$splitKeyword");
        lw.c.f70578a.c(this$0, NoticePermissionFrom.DETAIL_NO_RES);
        SearchResultViewModel.m(this$0.y0(), splitKeyword, false, 2, null);
        Integer num = this$0.f57568l;
        if (num != null) {
            Intrinsics.d(num);
            this$0.f57568l = Integer.valueOf(num.intValue() + 1);
            Intrinsics.f(requestView, "requestView");
            Integer num2 = this$0.f57568l;
            Intrinsics.d(num2);
            ResourcesRequestView.setCount$default(requestView, num2.intValue(), false, 2, null);
        }
    }

    private final SearchResultViewModel y0() {
        return (SearchResultViewModel) this.f57559b.getValue();
    }

    public final void A0() {
        y0().j().j(getViewLifecycleOwner(), new f(new Function1<SearchResultEntity, Unit>() { // from class: com.transsion.search.fragment.result.SearchResultTabFragment$initObserver$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SearchResultEntity searchResultEntity) {
                invoke2(searchResultEntity);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SearchResultEntity searchResultEntity) {
                List<ResultWrapData> convertData;
                h9.f fVarQ;
                h9.f fVarQ2;
                Pager pager;
                List convertData2;
                fx.a aVar = this.this$0.f57558a;
                if (aVar != null) {
                    aVar.w0((searchResultEntity == null || (convertData2 = searchResultEntity.getConvertData()) == null) ? new ArrayList() : convertData2);
                }
                fx.a aVar2 = this.this$0.f57558a;
                if (aVar2 != null) {
                    String str = this.this$0.f57565i;
                    if (str == null) {
                        str = "";
                    }
                    aVar2.X0(str);
                }
                List<ResultWrapData> convertData3 = searchResultEntity != null ? searchResultEntity.getConvertData() : null;
                if (convertData3 == null || convertData3.isEmpty()) {
                    this.this$0.f57568l = null;
                    fx.a aVar3 = this.this$0.f57558a;
                    if (aVar3 != null) {
                        aVar3.r0(this.this$0.G0());
                    }
                }
                if ((searchResultEntity == null || (pager = searchResultEntity.getPager()) == null || pager.getHasMore()) && searchResultEntity != null && (convertData = searchResultEntity.getConvertData()) != null && convertData.size() >= 10) {
                    fx.a aVar4 = this.this$0.f57558a;
                    if (aVar4 != null && (fVarQ = aVar4.Q()) != null) {
                        fVarQ.r();
                    }
                } else {
                    fx.a aVar5 = this.this$0.f57558a;
                    if (aVar5 != null && (fVarQ2 = aVar5.Q()) != null) {
                        h9.f.t(fVarQ2, false, 1, null);
                    }
                    this.this$0.f57569m = true;
                }
                this.this$0.hideLoading();
            }
        }));
        y0().i().j(getViewLifecycleOwner(), new f(new Function1<SearchResultEntity, Unit>() { // from class: com.transsion.search.fragment.result.SearchResultTabFragment$initObserver$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SearchResultEntity searchResultEntity) {
                invoke2(searchResultEntity);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SearchResultEntity searchResultEntity) {
                h9.f fVarQ;
                List<ResultWrapData> convertData;
                h9.f fVarQ2;
                h9.f fVarQ3;
                if (Intrinsics.b(searchResultEntity != null ? searchResultEntity.getTabId() : null, this.this$0.f57565i)) {
                    if ((searchResultEntity != null ? searchResultEntity.getResults() : null) == null) {
                        fx.a aVar = this.this$0.f57558a;
                        if (aVar == null || (fVarQ3 = aVar.Q()) == null) {
                            return;
                        }
                        fVarQ3.u();
                        return;
                    }
                    fx.a aVar2 = this.this$0.f57558a;
                    if (aVar2 != null) {
                        List convertData2 = searchResultEntity.getConvertData();
                        aVar2.m(convertData2 != null ? convertData2 : new ArrayList());
                    }
                    if (!searchResultEntity.getPager().getHasMore() || (convertData = searchResultEntity.getConvertData()) == null || convertData.isEmpty()) {
                        fx.a aVar3 = this.this$0.f57558a;
                        if (aVar3 == null || (fVarQ = aVar3.Q()) == null) {
                            return;
                        }
                        h9.f.t(fVarQ, false, 1, null);
                        return;
                    }
                    fx.a aVar4 = this.this$0.f57558a;
                    if (aVar4 == null || (fVarQ2 = aVar4.Q()) == null) {
                        return;
                    }
                    fVarQ2.r();
                }
            }
        }));
        y0().h().j(this, new f(new Function1<PostEntity, Unit>() { // from class: com.transsion.search.fragment.result.SearchResultTabFragment$initObserver$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PostEntity postEntity) {
                invoke2(postEntity);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PostEntity postEntity) {
                uo.b.a.g(uo.b.f78622a, "Post request succeed " + postEntity + ", " + (postEntity != null ? postEntity.getCount() : null), false, 2, null);
                if (postEntity == null || this.this$0.f57568l != null) {
                    return;
                }
                SearchResultTabFragment searchResultTabFragment = this.this$0;
                int count = postEntity.getCount();
                if (count == null) {
                    count = 0;
                }
                searchResultTabFragment.f57568l = count;
                ResourcesRequestView resourcesRequestView = this.this$0.f57567k;
                if (resourcesRequestView != null) {
                    Integer count2 = postEntity.getCount();
                    resourcesRequestView.setCount(count2 != null ? count2.intValue() : 0, false);
                }
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B0() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        zr.b bVar = new zr.b(0.6f, new c(), false, 4, null);
        bVar.n(2);
        bx.h hVar = (bx.h) getMViewBinding();
        if (hVar != null && (recyclerView3 = hVar.f14489b) != null) {
            recyclerView3.addOnScrollListener(bVar);
        }
        this.f57563g = bVar;
        bx.h hVar2 = (bx.h) getMViewBinding();
        if (hVar2 != null && (recyclerView2 = hVar2.f14489b) != null) {
            recyclerView2.addOnScrollListener(new d());
        }
        bx.h hVar3 = (bx.h) getMViewBinding();
        if (hVar3 == null || (recyclerView = hVar3.f14489b) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: com.transsion.search.fragment.result.f
            @Override // java.lang.Runnable
            public final void run() {
                SearchResultTabFragment.C0(this.f57590a);
            }
        });
    }

    public final void J0(ResultWrapData resultWrapData, int i11) {
        String deeplink;
        int i12 = b.f57570a[resultWrapData.getType().ordinal()];
        if (i12 == 1) {
            xw.f.c(resultWrapData.getSubject(), "search_result");
            jx.b.f68176a.r(resultWrapData.getSubject(), i11, this.f57560c, this.f57562f, this.f57565i);
            return;
        }
        if (i12 == 2) {
            com.alibaba.android.arouter.launcher.a.d().b("/movie/staff").withSerializable("staff", resultWrapData.getStaff()).navigation();
            jx.b.f68176a.p(resultWrapData.getStaff(), i11, this.f57560c, this.f57562f, this.f57565i);
            return;
        }
        if (i12 == 3) {
            Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/room/detail");
            Group groups = resultWrapData.getGroups();
            postcardB.withString("id", groups != null ? groups.getGroupId() : null).navigation();
            jx.b.f68176a.b(resultWrapData.getGroups(), i11, this.f57560c, this.f57562f, this.f57565i);
            return;
        }
        if (i12 == 4) {
            VerticalRank verticalRank = resultWrapData.getVerticalRank();
            if (verticalRank != null && (deeplink = verticalRank.getDeeplink()) != null) {
                i.e(deeplink, null, 1, null);
            }
            jx.b.f68176a.k(resultWrapData.getVerticalRank(), i11, this.f57560c, this.f57562f, this.f57565i);
            return;
        }
        if (i12 == 5 && (getParentFragment() instanceof SearchResultFragment)) {
            Fragment parentFragment = getParentFragment();
            Intrinsics.e(parentFragment, "null cannot be cast to non-null type com.transsion.search.fragment.result.SearchResultFragment");
            SearchResultFragment searchResultFragment = (SearchResultFragment) parentFragment;
            String moreTabId = resultWrapData.getMoreTabId();
            if (moreTabId == null) {
                moreTabId = "";
            }
            searchResultFragment.x0(moreTabId);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void K0(boolean z11) {
        bx.h hVar = (bx.h) getMViewBinding();
        ProgressBar progressBar = hVar != null ? hVar.f14491d : null;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        if (!z11) {
            bx.h hVar2 = (bx.h) getMViewBinding();
            RecyclerView recyclerView = hVar2 != null ? hVar2.f14490c : null;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
        }
        bx.h hVar3 = (bx.h) getMViewBinding();
        RecyclerView recyclerView2 = hVar3 != null ? hVar3.f14489b : null;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(4);
        }
        bx.h hVar4 = (bx.h) getMViewBinding();
        RecyclerView recyclerView3 = hVar4 != null ? hVar4.f14490c : null;
        if (recyclerView3 == null) {
            return;
        }
        recyclerView3.setEnabled(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void hideLoading() {
        bx.h hVar = (bx.h) getMViewBinding();
        ProgressBar progressBar = hVar != null ? hVar.f14491d : null;
        if (progressBar != null) {
            progressBar.setVisibility(4);
        }
        bx.h hVar2 = (bx.h) getMViewBinding();
        RecyclerView recyclerView = hVar2 != null ? hVar2.f14490c : null;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        bx.h hVar3 = (bx.h) getMViewBinding();
        RecyclerView recyclerView2 = hVar3 != null ? hVar3.f14489b : null;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(0);
        }
        bx.h hVar4 = (bx.h) getMViewBinding();
        RecyclerView recyclerView3 = hVar4 != null ? hVar4.f14490c : null;
        if (recyclerView3 == null) {
            return;
        }
        recyclerView3.setEnabled(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        RecyclerView recyclerView;
        h9.f fVarQ;
        RecyclerView recyclerView2;
        List subs;
        Intrinsics.g(view, "view");
        z0();
        bx.h hVar = (bx.h) getMViewBinding();
        if (hVar != null && (recyclerView2 = hVar.f14490c) != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext(), 0, false));
            final fx.b bVar = new fx.b(this.f57565i);
            TabItem tabItem = this.f57561d;
            bVar.w0((tabItem == null || (subs = tabItem.getSubs()) == null) ? new ArrayList() : subs);
            recyclerView2.setAdapter(bVar);
            bVar.B0(new f9.d() { // from class: com.transsion.search.fragment.result.c
                @Override // f9.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i11) {
                    SearchResultTabFragment.D0(this.f57586a, bVar, baseQuickAdapter, view2, i11);
                }
            });
        }
        bx.h hVar2 = (bx.h) getMViewBinding();
        if (hVar2 != null && (recyclerView = hVar2.f14489b) != null) {
            Resources resources = recyclerView.getContext().getResources();
            Intrinsics.f(resources, "context.resources");
            if (xw.f.e(resources)) {
                NpaGridLayoutManager npaGridLayoutManager = new NpaGridLayoutManager(recyclerView.getContext(), 2);
                npaGridLayoutManager.setSpanSizeLookup(new e());
                recyclerView.setLayoutManager(npaGridLayoutManager);
                recyclerView.addItemDecoration(new ro.b(0, f0.a(12.0f), 0, 0));
            } else {
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
                if (!Intrinsics.b(this.f57565i, "All") && !Intrinsics.b(this.f57565i, HotRankItem.CATE_MOVIE) && recyclerView.getItemDecorationCount() == 0) {
                    recyclerView.addItemDecoration(new ro.e(0.0f, 8.0f, 0.0f, 5, null));
                }
            }
            fx.a aVar = new fx.a(this.f57563g, this.f57560c, this.f57562f, this.f57565i);
            this.f57558a = aVar;
            recyclerView.setAdapter(aVar);
            fx.a aVar2 = this.f57558a;
            if (aVar2 != null && (fVarQ = aVar2.Q()) != null) {
                fVarQ.C(new f9.f() { // from class: com.transsion.search.fragment.result.d
                    @Override // f9.f
                    public final void a() {
                        SearchResultTabFragment.E0(this.f57588a);
                    }
                });
            }
            fx.a aVar3 = this.f57558a;
            if (aVar3 != null) {
                aVar3.B0(new f9.d() { // from class: com.transsion.search.fragment.result.e
                    @Override // f9.d
                    public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i11) {
                        SearchResultTabFragment.F0(this.f57589a, baseQuickAdapter, view2, i11);
                    }
                });
            }
        }
        B0();
        A0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        Pager pager;
        h9.f fVarQ;
        List convertData;
        SearchResultEntity searchResultEntity = this.f57566j;
        if (searchResultEntity == null) {
            K0(false);
            SearchResultViewModel searchResultViewModelY0 = y0();
            String str = this.f57560c;
            if (str == null) {
                str = "";
            }
            String str2 = this.f57565i;
            if (str2 == null) {
                str2 = "";
            }
            SearchResultViewModel.o(searchResultViewModelY0, str, str2, false, 4, null);
            return;
        }
        fx.a aVar = this.f57558a;
        if (aVar != null) {
            aVar.w0((searchResultEntity == null || (convertData = searchResultEntity.getConvertData()) == null) ? new ArrayList() : convertData);
        }
        SearchResultEntity searchResultEntity2 = this.f57566j;
        if (searchResultEntity2 == null || (pager = searchResultEntity2.getPager()) == null || pager.getHasMore()) {
            y0().p(2);
            return;
        }
        fx.a aVar2 = this.f57558a;
        if (aVar2 == null || (fVarQ = aVar2.Q()) == null) {
            return;
        }
        fVarQ.s(true);
    }

    @Override // com.transsion.search.fragment.BaseSearchMainFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        zr.b bVar;
        super.onHiddenChanged(z11);
        if (!z11 || (bVar = this.f57563g) == null) {
            return;
        }
        bVar.f();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        zr.b bVar = this.f57563g;
        if (bVar != null) {
            bVar.f();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        fx.a aVar;
        h9.f fVarQ;
        super.onResume();
        if (!this.f57569m || (aVar = this.f57558a) == null || (fVarQ = aVar.Q()) == null) {
            return;
        }
        h9.f.t(fVarQ, false, 1, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public bx.h getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        bx.h hVarC = bx.h.c(inflater);
        Intrinsics.f(hVarC, "inflate(inflater)");
        return hVarC;
    }

    public final void z0() {
        List<TabItem> subs;
        List<TabItem> subs2;
        TabItem tabItem;
        Bundle arguments = getArguments();
        String tabId = null;
        this.f57560c = arguments != null ? arguments.getString("tabKeyword") : null;
        Bundle arguments2 = getArguments();
        this.f57561d = arguments2 != null ? (TabItem) arguments2.getParcelable("tabItem") : null;
        Bundle arguments3 = getArguments();
        this.f57566j = arguments3 != null ? (SearchResultEntity) arguments3.getParcelable("tabResult") : null;
        Bundle arguments4 = getArguments();
        this.f57562f = arguments4 != null ? arguments4.getString("searchFrom") : null;
        TabItem tabItem2 = this.f57561d;
        if (tabItem2 == null || (subs = tabItem2.getSubs()) == null || !(!subs.isEmpty())) {
            TabItem tabItem3 = this.f57561d;
            if (tabItem3 != null) {
                tabId = tabItem3.getTabId();
            }
        } else {
            TabItem tabItem4 = this.f57561d;
            if (tabItem4 != null && (subs2 = tabItem4.getSubs()) != null && (tabItem = subs2.get(0)) != null) {
                tabId = tabItem.getTabId();
            }
        }
        this.f57565i = tabId;
    }
}
