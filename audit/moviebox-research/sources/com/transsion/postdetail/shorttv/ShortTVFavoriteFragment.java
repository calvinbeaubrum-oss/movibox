package com.transsion.postdetail.shorttv;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.baseui.fragment.BaseListFragment;
import com.transsion.baseui.widget.BaseLoadMoreView;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.ShortTVRespData;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$string;
import com.transsion.postdetail.shorttv.adapter.ShortTVTrendingAdapter;
import com.transsion.postdetail.shorttv.viewmodel.ShortTVContentViewModel;
import com.transsion.postdetail.shorttv.widget.ShortTVDiscoverHeaderView;
import com.transsnet.downloader.DownloadManagerApi;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class ShortTVFavoriteFragment extends BaseListFragment<Subject> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final a f55332u = new a(null);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f55334q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ShortTVTrendingAdapter f55335r;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f55333p = FragmentViewModelLazyKt.a(this, Reflection.b(ShortTVContentViewModel.class), new Function0<x0>() { // from class: com.transsion.postdetail.shorttv.ShortTVFavoriteFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final x0 invoke() {
            x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.f(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.postdetail.shorttv.ShortTVFavoriteFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final v0.c invoke() {
            v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.f(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f55336s = LazyKt__LazyJVMKt.b(new Function0<n>() { // from class: com.transsion.postdetail.shorttv.ShortTVFavoriteFragment$recReport$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final n invoke() {
            return new n();
        }
    });

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final zr.b f55337t = new zr.b(0.6f, new d(), false, 4, null);

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
    public static final class b extends RecyclerView.r {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            Intrinsics.g(recyclerView, "recyclerView");
            if (i12 > 0) {
                ShortTVFavoriteFragment.this.E1(recyclerView);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends DiffUtil.e<Subject> {
        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(Subject oldItem, Subject newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return Intrinsics.b(oldItem.getSubjectId(), newItem.getSubjectId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(Subject oldItem, Subject newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return oldItem.hashCode() == newItem.hashCode();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements zr.a {
        public d() {
        }

        @Override // zr.a
        public void a(int i11, long j11, View view) {
            List<Subject> listD;
            List<Subject> listD2;
            ShortTVTrendingAdapter shortTVTrendingAdapterJ1 = ShortTVFavoriteFragment.this.J1();
            if (((shortTVTrendingAdapterJ1 == null || (listD2 = shortTVTrendingAdapterJ1.D()) == null) ? 0 : listD2.size()) <= i11) {
                return;
            }
            ShortTVTrendingAdapter shortTVTrendingAdapterJ2 = ShortTVFavoriteFragment.this.J1();
            Subject subject = (shortTVTrendingAdapterJ2 == null || (listD = shortTVTrendingAdapterJ2.D()) == null) ? null : listD.get(i11);
            if (subject != null) {
                ShortTVFavoriteFragment.this.L1().a(ShortTVFavoriteFragment.this.getPageName(), subject, i11, j11, ShortTVFavoriteFragment.this.I1());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e extends RecyclerView.l {
        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.x state) {
            Intrinsics.g(outRect, "outRect");
            Intrinsics.g(view, "view");
            Intrinsics.g(parent, "parent");
            Intrinsics.g(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            if (parent.getAdapter() != null) {
                outRect.top = f0.a(16.0f);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f55340a;

        public f(Function1 function) {
            Intrinsics.g(function, "function");
            this.f55340a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f55340a;
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
            this.f55340a.invoke(obj);
        }
    }

    public static final void F1(ShortTVFavoriteFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.i1();
    }

    public static final void G1(ShortTVFavoriteFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "<anonymous parameter 1>");
        Object item = adapter.getItem(i11);
        if (item instanceof Subject) {
            Subject subject = (Subject) item;
            this$0.L1().b(this$0.getPageName(), subject, i11, this$0.I1());
            this$0.N1(subject, false);
        }
    }

    public static final void H1(ShortTVFavoriteFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "<anonymous parameter 1>");
        Object item = adapter.getItem(i11);
        if (item instanceof Subject) {
            Subject subject = (Subject) item;
            this$0.L1().b(this$0.getPageName(), subject, i11, this$0.I1());
            this$0.N1(subject, true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D1() {
        RecyclerView recyclerView;
        fs.a aVar = (fs.a) getMViewBinding();
        if (aVar == null || (recyclerView = aVar.f65251d) == null) {
            return;
        }
        recyclerView.addOnScrollListener(new b());
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        lazyLoadData();
    }

    public final void E1(RecyclerView recyclerView) {
        ShortTVTrendingAdapter shortTVTrendingAdapter;
        LinearLayout linearLayoutJ;
        RecyclerView.m layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        if (!(layoutManager instanceof LinearLayoutManager) || ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition() != 0 || (shortTVTrendingAdapter = this.f55335r) == null || (linearLayoutJ = shortTVTrendingAdapter.J()) == null) {
            return;
        }
        int childCount = linearLayoutJ.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = linearLayoutJ.getChildAt(i11);
            if ((childAt instanceof ShortTVDiscoverHeaderView) && childAt.getVisibility() == 0) {
                ((ShortTVDiscoverHeaderView) childAt).clearExposureCache();
            }
        }
    }

    public final String I1() {
        return "favorite";
    }

    public final ShortTVTrendingAdapter J1() {
        return this.f55335r;
    }

    public final ShortTVContentViewModel K1() {
        return (ShortTVContentViewModel) this.f55333p.getValue();
    }

    public final n L1() {
        return (n) this.f55336s.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void M1() {
        RecyclerView recyclerView;
        fs.a aVar = (fs.a) getMViewBinding();
        if (aVar == null || (recyclerView = aVar.f65251d) == null) {
            return;
        }
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(this.f55335r);
        recyclerView.addOnScrollListener(this.f55337t);
        D1();
        recyclerView.addItemDecoration(new e());
    }

    public final void N1(Subject subject, boolean z11) {
        Context context = getContext();
        if (context != null) {
            DownloadManagerApi.f60274j.a().a2((FragmentActivity) context, getPageName(), (384 & 4) != 0 ? "" : "", subject.getOps(), (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : z11, (384 & 64) != 0 ? null : subject, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public BaseQuickAdapter<Subject, BaseViewHolder> T0() {
        ShortTVTrendingAdapter shortTVTrendingAdapter = new ShortTVTrendingAdapter(getPageName(), true);
        shortTVTrendingAdapter.Q().B(new BaseLoadMoreView());
        shortTVTrendingAdapter.Q().y(true);
        shortTVTrendingAdapter.Q().x(true);
        shortTVTrendingAdapter.Q().D(3);
        shortTVTrendingAdapter.Q().C(new f9.f() { // from class: com.transsion.postdetail.shorttv.j
            @Override // f9.f
            public final void a() {
                ShortTVFavoriteFragment.F1(this.f55410a);
            }
        });
        shortTVTrendingAdapter.o0(new c());
        shortTVTrendingAdapter.B0(new f9.d() { // from class: com.transsion.postdetail.shorttv.k
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                ShortTVFavoriteFragment.G1(this.f55411a, baseQuickAdapter, view, i11);
            }
        });
        shortTVTrendingAdapter.i(R$id.btn_download);
        shortTVTrendingAdapter.z0(new f9.b() { // from class: com.transsion.postdetail.shorttv.l
            @Override // f9.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                ShortTVFavoriteFragment.H1(this.f55412a, baseQuickAdapter, view, i11);
            }
        });
        this.f55335r = shortTVTrendingAdapter;
        return shortTVTrendingAdapter;
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public String Z0() {
        Context context = getContext();
        String string = context != null ? context.getString(R$string.short_tv_my_list) : null;
        return string == null ? "" : string;
    }

    public final String getPageName() {
        return "minitv_favorite";
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void i1() {
        lazyLoadData();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        K1().d().j(this, new f(new Function1<ShortTVRespData, Unit>() { // from class: com.transsion.postdetail.shorttv.ShortTVFavoriteFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ShortTVRespData shortTVRespData) {
                invoke2(shortTVRespData);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ShortTVRespData shortTVRespData) {
                Pager pager;
                List<Subject> items;
                if (shortTVRespData == null || (items = shortTVRespData.getItems()) == null) {
                    ShortTVFavoriteFragment.this.v1();
                } else {
                    ShortTVFavoriteFragment shortTVFavoriteFragment = ShortTVFavoriteFragment.this;
                    if (shortTVFavoriteFragment.h1() || Intrinsics.b(shortTVFavoriteFragment.f55334q, "1")) {
                        shortTVFavoriteFragment.q1(false);
                        if (items.isEmpty()) {
                            BaseListFragment.s1(shortTVFavoriteFragment, null, 1, null);
                        } else {
                            BaseQuickAdapter<Subject, BaseViewHolder> baseQuickAdapterW0 = shortTVFavoriteFragment.W0();
                            if (baseQuickAdapterW0 != null) {
                                baseQuickAdapterW0.w0(items);
                            }
                        }
                    } else {
                        BaseQuickAdapter<Subject, BaseViewHolder> baseQuickAdapterW1 = shortTVFavoriteFragment.W0();
                        if (baseQuickAdapterW1 != null) {
                            baseQuickAdapterW1.m(items);
                        }
                    }
                }
                if (shortTVRespData == null || (pager = shortTVRespData.getPager()) == null) {
                    return;
                }
                ShortTVFavoriteFragment shortTVFavoriteFragment2 = ShortTVFavoriteFragment.this;
                if (!Intrinsics.b(pager.getHasMore(), Boolean.TRUE)) {
                    BaseListFragment.l1(shortTVFavoriteFragment2, false, 1, null);
                } else {
                    shortTVFavoriteFragment2.f55334q = pager.getNextPage();
                    shortTVFavoriteFragment2.j1();
                }
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        boolean zB = Intrinsics.b(this.f55334q, "1");
        ShortTVContentViewModel shortTVContentViewModelK1 = K1();
        String str = this.f55334q;
        shortTVContentViewModelK1.i(str != null ? str : "1", 8, zB);
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void o1() {
        q1(true);
        this.f55334q = "1";
        lazyLoadData();
    }

    @Override // com.transsion.baseui.fragment.LazyFragment, com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        o1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        Context context = getContext();
        String string = context != null ? context.getString(R$string.short_tv_my_list) : null;
        return string == null ? "" : string;
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        super.v0();
        M1();
        q1(true);
    }
}
