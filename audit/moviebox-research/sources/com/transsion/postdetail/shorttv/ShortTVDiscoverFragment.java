package com.transsion.postdetail.shorttv;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.c0;
import androidx.lifecycle.d0;
import androidx.lifecycle.v;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.gyf.immersionbar.ImmersionBar;
import com.tn.lib.view.NoNetworkBigView;
import com.tn.lib.view.StateView;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$string;
import com.transsion.ad.bidding.nativead.BiddingListManager;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.baseui.widget.BaseLoadMoreView;
import com.transsion.moviedetailapi.bean.BannerData;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.OperatingResp;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.PlayListItemBean;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.ShortTVRespData;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.helper.ShortTVDiscoverPreloadHelper;
import com.transsion.postdetail.shorttv.adapter.ShortTVBannerAdapter;
import com.transsion.postdetail.shorttv.adapter.ShortTVTrendingAdapter;
import com.transsion.postdetail.shorttv.viewmodel.ShortTVContentViewModel;
import com.transsion.postdetail.shorttv.widget.ShortTVBannerView;
import com.transsion.postdetail.shorttv.widget.ShortTVCollectionView;
import com.transsion.postdetail.shorttv.widget.ShortTVDiscoverHeaderView;
import com.transsion.postdetail.shorttv.widget.ShortTvCategoryView;
import com.transsnet.downloader.DownloadManagerApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import tv.r0;

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
public class ShortTVDiscoverFragment extends PageStatusFragment<tv.q> {
    public boolean A;
    public Function1<? super Boolean, Unit> B;
    public RecyclerView.r C;
    public Function1<? super Boolean, Unit> D;
    public boolean E;
    public int F;
    public BiddingListManager H;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ShortTVTrendingAdapter f55307l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ShortTVContentViewModel f55309n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ShortTVCollectionView f55311p;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ShortTvCategoryView f55315t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public r0 f55316u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ShortTVBannerAdapter f55317v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public OperatingResp f55318w;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f55321z;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f55306k = getClass().getSimpleName();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f55308m = "1";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f55310o = LazyKt__LazyJVMKt.b(new Function0<n>() { // from class: com.transsion.postdetail.shorttv.ShortTVDiscoverFragment$recReport$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final n invoke() {
            return new n();
        }
    });

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f55312q = true;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f55313r = true;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public List<ShortTVDiscoverHeaderView> f55314s = new ArrayList();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f55319x = LazyKt__LazyJVMKt.b(new Function0<com.transsion.postdetail.util.a>() { // from class: com.transsion.postdetail.shorttv.ShortTVDiscoverFragment$bannerDotHelper$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.transsion.postdetail.util.a invoke() {
            return new com.transsion.postdetail.util.a(this.this$0.getPageName());
        }
    });

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f55320y = -1;
    public final zr.b G = new zr.b(0.6f, new b(), false, 4, null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends RecyclerView.r {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            Intrinsics.g(recyclerView, "recyclerView");
            if (i12 > 0) {
                ShortTVDiscoverFragment.this.q1(recyclerView);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements zr.a {
        public b() {
        }

        @Override // zr.a
        public void a(int i11, long j11, View view) {
            List<Subject> listD;
            List<Subject> listD2;
            ShortTVTrendingAdapter shortTVTrendingAdapterX1 = ShortTVDiscoverFragment.this.x1();
            if (((shortTVTrendingAdapterX1 == null || (listD2 = shortTVTrendingAdapterX1.D()) == null) ? 0 : listD2.size()) <= i11) {
                return;
            }
            ShortTVTrendingAdapter shortTVTrendingAdapterX2 = ShortTVDiscoverFragment.this.x1();
            Subject subject = (shortTVTrendingAdapterX2 == null || (listD = shortTVTrendingAdapterX2.D()) == null) ? null : listD.get(i11);
            if (subject != null) {
                ShortTVDiscoverFragment.this.z1().a(ShortTVDiscoverFragment.this.getPageName(), subject, i11, j11, ShortTVDiscoverFragment.this.w1());
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
    public static final class d extends GridLayoutManager.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f55325f;

        public d(RecyclerView recyclerView) {
            this.f55325f = recyclerView;
        }

        /* JADX WARN: Code duplicated, block: B:20:0x003e  */
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int f(int i11) {
            com.transsion.ad.bidding.nativead.c nonAdDelegate;
            List<Subject> listD;
            boolean z11 = false;
            if (i11 >= 0) {
                ShortTVTrendingAdapter shortTVTrendingAdapterX1 = ShortTVDiscoverFragment.this.x1();
                if (i11 < ((shortTVTrendingAdapterX1 == null || (listD = shortTVTrendingAdapterX1.D()) == null) ? 0 : listD.size())) {
                    ShortTVTrendingAdapter shortTVTrendingAdapterX2 = ShortTVDiscoverFragment.this.x1();
                    if (shortTVTrendingAdapterX2 == null) {
                        nonAdDelegate = null;
                    } else {
                        ShortTVTrendingAdapter shortTVTrendingAdapterX3 = ShortTVDiscoverFragment.this.x1();
                        Subject item = shortTVTrendingAdapterX2.getItem(i11 - (shortTVTrendingAdapterX3 != null ? shortTVTrendingAdapterX3.K() : 0));
                        if (item != null) {
                            nonAdDelegate = item.getNonAdDelegate();
                        } else {
                            nonAdDelegate = null;
                        }
                    }
                    if (nonAdDelegate != null) {
                        z11 = true;
                    }
                }
            }
            Context context = this.f55325f.getContext();
            Intrinsics.f(context, "context");
            return (!com.transsion.baseui.util.b.a(context) || z11) ? 2 : 1;
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
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (parent.getAdapter() != null) {
                if (childAdapterPosition == 0) {
                    outRect.top = f0.a(0.0f);
                } else {
                    outRect.top = f0.a(16.0f);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f extends RecyclerView.r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f55326a;

        public f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            tv.q mViewBinding;
            RecyclerView recyclerView2;
            Intrinsics.g(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i11);
            if (i11 != 0 || (mViewBinding = ShortTVDiscoverFragment.this.getMViewBinding()) == null || (recyclerView2 = mViewBinding.f77902b) == null || recyclerView2.canScrollVertically(-1)) {
                return;
            }
            ShortTVDiscoverFragment shortTVDiscoverFragment = ShortTVDiscoverFragment.this;
            shortTVDiscoverFragment.r1(shortTVDiscoverFragment.C1());
            ShortTVDiscoverFragment.this.e2(false);
            this.f55326a = 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            Intrinsics.g(recyclerView, "recyclerView");
            ShortTVDiscoverFragment.this.W1(i12);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class g implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f55328a;

        public g(Function1 function) {
            Intrinsics.g(function, "function");
            this.f55328a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f55328a;
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
            this.f55328a.invoke(obj);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class h extends ViewPager2.OnPageChangeCallback {
        public h() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            ShortTVDiscoverFragment shortTVDiscoverFragment = ShortTVDiscoverFragment.this;
            shortTVDiscoverFragment.U1(i11, shortTVDiscoverFragment.f55320y, f11);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            if (ShortTVDiscoverFragment.this.isResumed()) {
                ShortTVDiscoverFragment.this.S1();
                ShortTVDiscoverFragment.this.f55321z = System.currentTimeMillis();
            }
            ShortTVDiscoverFragment.this.f55320y = i11;
        }
    }

    private final void D1() {
        BiddingListManager biddingListManager = new BiddingListManager();
        tv.q mViewBinding = getMViewBinding();
        biddingListManager.F(mViewBinding != null ? mViewBinding.f77902b : null);
        biddingListManager.A(v.a(this));
        biddingListManager.G("ShortTvDiscoverMostTrendingScene");
        biddingListManager.z(new Function2<Integer, com.transsion.ad.bidding.nativead.c, Unit>() { // from class: com.transsion.postdetail.shorttv.ShortTVDiscoverFragment$initAd$1$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, com.transsion.ad.bidding.nativead.c cVar) {
                invoke(num.intValue(), cVar);
                return Unit.f68710a;
            }

            /* JADX WARN: Code duplicated, block: B:17:0x00ad  */
            public final void invoke(int i11, com.transsion.ad.bidding.nativead.c wrapperNativeManager) {
                int i12;
                List<Subject> listD;
                Intrinsics.g(wrapperNativeManager, "wrapperNativeManager");
                if (wrapperNativeManager != null) {
                    ShortTVDiscoverFragment shortTVDiscoverFragment = this.this$0;
                    Subject subject = new Subject(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, null, null, -1, 4194303, null);
                    subject.setNonAdDelegate(wrapperNativeManager);
                    ShortTVTrendingAdapter shortTVTrendingAdapterX1 = shortTVDiscoverFragment.x1();
                    int size = (shortTVTrendingAdapterX1 == null || (listD = shortTVTrendingAdapterX1.D()) == null) ? 0 : listD.size();
                    Context context = shortTVDiscoverFragment.getContext();
                    if (context != null) {
                        Intrinsics.f(context, "context");
                        if (!com.transsion.baseui.util.b.a(context) || i11 % 2 == 0) {
                            i12 = i11;
                        } else {
                            i12 = i11 - 1;
                        }
                    } else {
                        i12 = i11;
                    }
                    if (i12 <= size) {
                        ShortTVTrendingAdapter shortTVTrendingAdapterX2 = shortTVDiscoverFragment.x1();
                        if (shortTVTrendingAdapterX2 != null) {
                            shortTVTrendingAdapterX2.j(i12, subject);
                            return;
                        }
                        return;
                    }
                    ShortTVTrendingAdapter shortTVTrendingAdapterX3 = shortTVDiscoverFragment.x1();
                    if (shortTVTrendingAdapterX3 != null) {
                        shortTVTrendingAdapterX3.j(size, subject);
                    }
                }
            }
        });
        this.H = biddingListManager;
    }

    private final void E1() {
        final SwipeRefreshLayout swipeRefreshLayout;
        RecyclerView recyclerView;
        final boolean z11 = true;
        ShortTVTrendingAdapter shortTVTrendingAdapter = new ShortTVTrendingAdapter(getPageName(), true);
        shortTVTrendingAdapter.Q().B(new BaseLoadMoreView());
        shortTVTrendingAdapter.Q().y(true);
        shortTVTrendingAdapter.Q().x(true);
        shortTVTrendingAdapter.Q().D(3);
        shortTVTrendingAdapter.Q().C(new f9.f() { // from class: com.transsion.postdetail.shorttv.c
            @Override // f9.f
            public final void a() {
                ShortTVDiscoverFragment.F1(this.f55399a);
            }
        });
        shortTVTrendingAdapter.o0(new c());
        shortTVTrendingAdapter.B0(new f9.d() { // from class: com.transsion.postdetail.shorttv.d
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                ShortTVDiscoverFragment.G1(this.f55402a, baseQuickAdapter, view, i11);
            }
        });
        shortTVTrendingAdapter.i(R$id.btn_download);
        shortTVTrendingAdapter.z0(new f9.b() { // from class: com.transsion.postdetail.shorttv.e
            @Override // f9.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                ShortTVDiscoverFragment.H1(this.f55403a, z11, baseQuickAdapter, view, i11);
            }
        });
        this.f55307l = shortTVTrendingAdapter;
        tv.q mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.f77902b) != null) {
            NpaGridLayoutManager npaGridLayoutManager = new NpaGridLayoutManager(recyclerView.getContext(), 2);
            npaGridLayoutManager.setSpanSizeLookup(new d(recyclerView));
            recyclerView.setLayoutManager(npaGridLayoutManager);
            recyclerView.setAdapter(this.f55307l);
            recyclerView.addOnScrollListener(this.G);
            p1();
            recyclerView.addItemDecoration(new e());
        }
        tv.q mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (swipeRefreshLayout = mViewBinding2.f77903c) == null) {
            return;
        }
        int iA = f0.a(30.0f);
        int iC = com.blankj.utilcode.util.d.c() + iA;
        swipeRefreshLayout.setProgressViewOffset(false, iC, (iA * 2) + iC);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsion.postdetail.shorttv.f
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
            public final void a() {
                ShortTVDiscoverFragment.I1(swipeRefreshLayout, this);
            }
        });
    }

    public static final void F1(ShortTVDiscoverFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.M1();
    }

    public static final void G1(ShortTVDiscoverFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "<anonymous parameter 1>");
        Object item = adapter.getItem(i11);
        if (item instanceof Subject) {
            Subject subject = (Subject) item;
            this$0.z1().b(this$0.getPageName(), subject, i11, this$0.w1());
            this$0.X1(subject, false);
        }
    }

    public static final void H1(ShortTVDiscoverFragment this$0, boolean z11, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "<anonymous parameter 1>");
        Object item = adapter.getItem(i11);
        if (item instanceof Subject) {
            Subject subject = (Subject) item;
            this$0.z1().b(this$0.getPageName(), subject, i11, this$0.w1());
            this$0.X1(subject, z11);
        }
    }

    public static final void I1(SwipeRefreshLayout this_apply, ShortTVDiscoverFragment this$0) {
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(this$0, "this$0");
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            this$0.Y1();
        } else {
            zp.b.f82110a.d(R$string.no_network_toast);
            this_apply.setRefreshing(false);
        }
    }

    public static final void J1(ShortTVDiscoverFragment this$0) {
        RecyclerView recyclerView;
        Intrinsics.g(this$0, "this$0");
        if (this$0.isAdded()) {
            tv.q mViewBinding = this$0.getMViewBinding();
            int iComputeVerticalScrollOffset = (mViewBinding == null || (recyclerView = mViewBinding.f77902b) == null) ? 0 : recyclerView.computeVerticalScrollOffset();
            this$0.F = 0;
            this$0.W1(iComputeVerticalScrollOffset);
        }
    }

    private final void M1() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        h9.f fVarQ;
        uo.b.a aVar = uo.b.f78622a;
        String TAG = this.f55306k;
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "loadMore", false, 4, null);
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(R$string.no_network_toast);
            tv.q mViewBinding = getMViewBinding();
            if (mViewBinding == null || (recyclerView = mViewBinding.f77902b) == null) {
                return;
            }
            recyclerView.postDelayed(new Runnable() { // from class: com.transsion.postdetail.shorttv.h
                @Override // java.lang.Runnable
                public final void run() {
                    ShortTVDiscoverFragment.O1(this.f55408a);
                }
            }, 500L);
            return;
        }
        ShortTVTrendingAdapter shortTVTrendingAdapter = this.f55307l;
        if (shortTVTrendingAdapter != null && (fVarQ = shortTVTrendingAdapter.Q()) != null) {
            fVarQ.v();
        }
        tv.q mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (recyclerView2 = mViewBinding2.f77902b) == null) {
            return;
        }
        recyclerView2.postDelayed(new Runnable() { // from class: com.transsion.postdetail.shorttv.g
            @Override // java.lang.Runnable
            public final void run() {
                ShortTVDiscoverFragment.N1(this.f55407a);
            }
        }, 300L);
    }

    public static final void N1(ShortTVDiscoverFragment this$0) {
        h9.f fVarQ;
        Intrinsics.g(this$0, "this$0");
        ShortTVTrendingAdapter shortTVTrendingAdapter = this$0.f55307l;
        if (((shortTVTrendingAdapter == null || (fVarQ = shortTVTrendingAdapter.Q()) == null) ? null : fVarQ.i()) == LoadMoreStatus.End) {
            return;
        }
        uo.b.a aVar = uo.b.f78622a;
        String TAG = this$0.f55306k;
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "load more， loadData", false, 4, null);
        this$0.P1(false);
    }

    public static final void O1(ShortTVDiscoverFragment this$0) {
        h9.f fVarQ;
        Intrinsics.g(this$0, "this$0");
        ShortTVTrendingAdapter shortTVTrendingAdapter = this$0.f55307l;
        if (shortTVTrendingAdapter == null || (fVarQ = shortTVTrendingAdapter.Q()) == null) {
            return;
        }
        fVarQ.u();
    }

    public static /* synthetic */ void Q1(ShortTVDiscoverFragment shortTVDiscoverFragment, boolean z11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadTrendingData");
        }
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        shortTVDiscoverFragment.P1(z11);
    }

    private final void X1(Subject subject, boolean z11) {
        Context context = getContext();
        if (context != null) {
            DownloadManagerApi.f60274j.a().a2((FragmentActivity) context, getPageName(), (384 & 4) != 0 ? "" : "", subject.getOps(), (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : z11, (384 & 64) != 0 ? null : subject, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
        }
    }

    public static final void d2(ShortTVDiscoverFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.U1(0, 0, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideLoading() {
        F0();
    }

    private final void l2() {
        K0();
    }

    private final void p1() {
        RecyclerView recyclerView;
        tv.q mViewBinding = getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f77902b) == null) {
            return;
        }
        recyclerView.addOnScrollListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q1(RecyclerView recyclerView) {
        ShortTVTrendingAdapter shortTVTrendingAdapter;
        LinearLayout linearLayoutJ;
        RecyclerView.m layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        if (!(layoutManager instanceof LinearLayoutManager) || ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition() != 0 || (shortTVTrendingAdapter = this.f55307l) == null || (linearLayoutJ = shortTVTrendingAdapter.J()) == null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void r1(boolean z11) {
        int color;
        View view;
        Fragment parentFragment = getParentFragment();
        if (z11 && C1()) {
            ImmersionBar immersionBarWith = ImmersionBar.with(this);
            color = 0;
            immersionBarWith.statusBarDarkFont(false);
            immersionBarWith.init();
        } else {
            color = z2.a.getColor(requireContext(), R$color.bg_02);
            ImmersionBar immersionBarWith2 = ImmersionBar.with(this);
            immersionBarWith2.statusBarDarkFont(!com.transsion.baselib.utils.o.f51321a.a());
            immersionBarWith2.init();
        }
        tv.q mViewBinding = getMViewBinding();
        if (mViewBinding != null && (view = mViewBinding.f77906g) != null) {
            view.setBackgroundColor(color);
        }
        if (parentFragment instanceof ShortTVHomeFragment) {
            ((ShortTVHomeFragment) parentFragment).w0(z11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n z1() {
        return (n) this.f55310o.getValue();
    }

    public final String A1() {
        return this.f55306k;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: B1, reason: merged with bridge method [inline-methods] */
    public tv.q getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        tv.q qVarC = tv.q.c(inflater);
        Intrinsics.f(qVarC, "inflate(inflater)");
        return qVarC;
    }

    public final boolean C1() {
        ShortTVBannerAdapter shortTVBannerAdapter = this.f55317v;
        if (shortTVBannerAdapter == null) {
            return false;
        }
        Intrinsics.d(shortTVBannerAdapter);
        return shortTVBannerAdapter.e().size() > 0;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        List<Subject> listD;
        ShortTVTrendingAdapter shortTVTrendingAdapter = this.f55307l;
        if (shortTVTrendingAdapter != null && (listD = shortTVTrendingAdapter.D()) != null && listD.size() == 0) {
            l2();
            Y1();
            return;
        }
        ShortTVTrendingAdapter shortTVTrendingAdapter2 = this.f55307l;
        if (shortTVTrendingAdapter2 == null || shortTVTrendingAdapter2.Q().i() != LoadMoreStatus.Fail) {
            return;
        }
        shortTVTrendingAdapter2.Q().v();
    }

    public final void K1() {
        String version;
        ShortTVDiscoverPreloadHelper shortTVDiscoverPreloadHelperA = ShortTVDiscoverPreloadHelper.f55032n.a();
        OperatingResp operatingResp = this.f55318w;
        if (operatingResp == null || (version = operatingResp.getVersion()) == null) {
            version = "";
        }
        shortTVDiscoverPreloadHelperA.w(version);
    }

    public void L1() {
        ShortTVContentViewModel shortTVContentViewModel = this.f55309n;
        if (shortTVContentViewModel != null) {
            shortTVContentViewModel.j(this.f55308m, 8, false);
        }
        ShortTVContentViewModel shortTVContentViewModel2 = this.f55309n;
        if (shortTVContentViewModel2 != null) {
            shortTVContentViewModel2.h();
        }
    }

    public void P1(boolean z11) {
        ShortTVDiscoverPreloadHelper.f55032n.a().B(this.f55308m, 8, z11);
    }

    public void R1() {
        List<BannerData> banners;
        List<PlayListItemBean> playList;
        c0<ShortTVRespData> c0VarD;
        uo.b.a aVar = uo.b.f78622a;
        String TAG = this.f55306k;
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "observeGetData", false, 4, null);
        com.tn.lib.util.networkinfo.f fVar = com.tn.lib.util.networkinfo.f.f49475a;
        if (fVar.e()) {
            l2();
        } else {
            k2();
        }
        ShortTVDiscoverPreloadHelper.a aVar2 = ShortTVDiscoverPreloadHelper.f55032n;
        aVar2.a().v().j(this, new g(new Function1<Pair<? extends OperatingResp, ? extends ShortTVRespData>, Unit>() { // from class: com.transsion.postdetail.shorttv.ShortTVDiscoverFragment$observeGetData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends OperatingResp, ? extends ShortTVRespData> pair) {
                invoke2((Pair<OperatingResp, ShortTVRespData>) pair);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<OperatingResp, ShortTVRespData> pair) {
                OperatingResp operatingRespComponent1 = pair.component1();
                ShortTVRespData shortTVRespDataComponent2 = pair.component2();
                this.this$0.hideLoading();
                if (operatingRespComponent1 == null || shortTVRespDataComponent2 == null) {
                    return;
                }
                this.this$0.g2(operatingRespComponent1);
                this.this$0.j2(shortTVRespDataComponent2);
            }
        }));
        ShortTVContentViewModel shortTVContentViewModel = this.f55309n;
        if (shortTVContentViewModel != null && (c0VarD = shortTVContentViewModel.d()) != null) {
            c0VarD.j(this, new g(new Function1<ShortTVRespData, Unit>() { // from class: com.transsion.postdetail.shorttv.ShortTVDiscoverFragment$observeGetData$2
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
                    if ((shortTVRespData != null ? shortTVRespData.getItems() : null) != null) {
                        List<Subject> items = shortTVRespData.getItems();
                        Intrinsics.d(items);
                        if (!items.isEmpty()) {
                            uo.b.a aVar3 = uo.b.f78622a;
                            String TAG2 = this.this$0.A1();
                            Intrinsics.f(TAG2, "TAG");
                            uo.b.a.f(aVar3, TAG2, "addHeaderView, has collection", false, 4, null);
                            this.this$0.o1();
                            return;
                        }
                    }
                    uo.b.a aVar4 = uo.b.f78622a;
                    String TAG3 = this.this$0.A1();
                    Intrinsics.f(TAG3, "TAG");
                    uo.b.a.u(aVar4, TAG3, "addHeaderView, has no collection", false, 4, null);
                    this.this$0.a2();
                }
            }));
        }
        c0<ShortTVRespData> c0VarD2 = aVar2.a().D();
        ShortTVRespData shortTVRespDataF = c0VarD2 != null ? c0VarD2.f() : null;
        c0<OperatingResp> c0VarY = aVar2.a().y();
        OperatingResp operatingRespF = c0VarY != null ? c0VarY.f() : null;
        if ((shortTVRespDataF == null || operatingRespF == null || (((banners = operatingRespF.getBanners()) == null || banners.isEmpty()) && (((playList = operatingRespF.getPlayList()) == null || playList.isEmpty()) && !aVar2.a().E()))) && fVar.e()) {
            l2();
            Y1();
        }
        L1();
    }

    public final void S1() {
        List<BannerData> listE;
        BannerData bannerData;
        List<BannerData> listE2;
        int i11 = this.f55320y;
        if (i11 >= 0) {
            ShortTVBannerAdapter shortTVBannerAdapter = this.f55317v;
            if (i11 >= ((shortTVBannerAdapter == null || (listE2 = shortTVBannerAdapter.e()) == null) ? 0 : listE2.size())) {
                return;
            }
            long jCurrentTimeMillis = this.f55321z > 0 ? System.currentTimeMillis() - this.f55321z : 0L;
            ShortTVBannerAdapter shortTVBannerAdapter2 = this.f55317v;
            if (shortTVBannerAdapter2 == null || (listE = shortTVBannerAdapter2.e()) == null || (bannerData = listE.get(this.f55320y)) == null) {
                return;
            }
            com.transsion.postdetail.util.a aVarV1 = v1();
            String pageName = getPageName();
            String value = PostItemType.BANNER.getValue();
            String subjectId = bannerData.getSubjectId();
            Boolean hasResource = bannerData.getHasResource();
            String deepLink = bannerData.getDeepLink();
            Integer numValueOf = Integer.valueOf(this.f55320y);
            Image image = bannerData.getImage();
            aVarV1.a((4144 & 1) != 0 ? null : pageName, (4144 & 2) != 0 ? null : "opt", (4144 & 4) != 0 ? null : value, (4144 & 8) != 0 ? null : subjectId, (4144 & 16) != 0 ? null : null, (4144 & 32) != 0 ? null : null, (4144 & 64) != 0 ? null : hasResource, (4144 & 128) != 0 ? null : deepLink, (4144 & 256) != 0 ? null : numValueOf, (4144 & 512) != 0 ? null : image != null ? image.getUrl() : null, (4144 & 1024) != 0 ? 0L : jCurrentTimeMillis, (4144 & 2048) != 0 ? Boolean.FALSE : Boolean.valueOf(bannerData.getBuiltIn()), (4144 & 4096) == 0 ? null : null);
        }
    }

    public final void T1(int i11, BannerData bannerData) {
        com.transsion.postdetail.util.a aVarV1 = v1();
        String pageName = getPageName();
        PostItemType postItemType = PostItemType.BANNER;
        String value = postItemType.getValue();
        String subjectId = bannerData.getSubjectId();
        Boolean hasResource = bannerData.getHasResource();
        String deepLink = bannerData.getDeepLink();
        Integer numValueOf = Integer.valueOf(i11);
        Image image = bannerData.getImage();
        aVarV1.c(pageName, "opt", value, (4272 & 8) != 0 ? null : subjectId, (4272 & 16) != 0 ? null : null, (4272 & 32) != 0 ? null : null, (4272 & 64) != 0 ? null : hasResource, (4272 & 128) != 0 ? null : null, (4272 & 256) != 0 ? null : deepLink, (4272 & 512) != 0 ? null : numValueOf, (4272 & 1024) != 0 ? null : image != null ? image.getUrl() : null, (4272 & 2048) != 0 ? Boolean.FALSE : Boolean.valueOf(bannerData.getBuiltIn()), (4272 & 4096) != 0 ? null : null);
        String deepLink2 = bannerData.getDeepLink();
        if (deepLink2 != null) {
            Uri uriD = com.transsion.baselib.helper.b.f51184a.d(Uri.parse(deepLink2 + "&ops=" + postItemType.getValue()));
            if (uriD != null) {
                com.alibaba.android.arouter.launcher.a.d().a(uriD).navigation();
            }
        }
    }

    public final void U1(int i11, int i12, float f11) {
        Image image;
        String averageHueDark;
        Image image2;
        String averageHueDark2;
        List<BannerData> listE;
        List<BannerData> listE2;
        ShortTVBannerAdapter shortTVBannerAdapter = this.f55317v;
        BannerData bannerData = (shortTVBannerAdapter == null || (listE2 = shortTVBannerAdapter.e()) == null) ? null : listE2.get(i11);
        ShortTVBannerAdapter shortTVBannerAdapter2 = this.f55317v;
        BannerData bannerData2 = (shortTVBannerAdapter2 == null || (listE = shortTVBannerAdapter2.e()) == null) ? null : listE.get(i12);
        if (bannerData == null || (image = bannerData.getImage()) == null || (averageHueDark = image.getAverageHueDark()) == null || bannerData2 == null || (image2 = bannerData2.getImage()) == null || (averageHueDark2 = image2.getAverageHueDark()) == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{i11 == i12 ? Color.parseColor(averageHueDark) : g20.a.a(f11, Color.parseColor(averageHueDark), Color.parseColor(averageHueDark2)), 0});
        r0 r0Var = this.f55316u;
        View view = r0Var != null ? r0Var.f77919d : null;
        if (view == null) {
            return;
        }
        view.setBackground(gradientDrawable);
    }

    public void V1(boolean z11) {
        ShortTVContentViewModel shortTVContentViewModel;
        if (this.f55313r) {
            this.f55313r = false;
        } else {
            if (z11 || (shortTVContentViewModel = this.f55309n) == null) {
                return;
            }
            shortTVContentViewModel.h();
        }
    }

    public final void W1(int i11) {
        if (i11 == 0) {
            this.F = 0;
        } else {
            this.F += i11;
        }
        tp.f fVar = tp.f.f77260a;
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        if (Math.abs(this.F) > ((fVar.e(contextRequireContext) * 9) / 16) / 2) {
            if (this.E) {
                return;
            }
            r1(false);
            this.E = true;
            return;
        }
        if (this.E) {
            r1(true);
            this.E = false;
        }
    }

    public void Y1() {
        K1();
        this.f55308m = "1";
        Q1(this, false, 1, null);
    }

    public final void Z1(boolean z11) {
        Space space;
        View view;
        Space space2;
        View view2;
        if (z11) {
            tv.q mViewBinding = getMViewBinding();
            if (mViewBinding != null && (view2 = mViewBinding.f77905f) != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                layoutParams.height = f0.a(0.0f);
                view2.setLayoutParams(layoutParams);
            }
            tv.q mViewBinding2 = getMViewBinding();
            if (mViewBinding2 == null || (space2 = mViewBinding2.f77904d) == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = space2.getLayoutParams();
            layoutParams2.height = f0.a(90.0f);
            space2.setLayoutParams(layoutParams2);
            return;
        }
        tv.q mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (view = mViewBinding3.f77905f) != null) {
            ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
            int iC = com.blankj.utilcode.util.d.c();
            if (layoutParams3 != null) {
                layoutParams3.height = iC + f0.a(44.0f);
            }
            view.setLayoutParams(layoutParams3);
        }
        tv.q mViewBinding4 = getMViewBinding();
        if (mViewBinding4 == null || (space = mViewBinding4.f77904d) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams4 = space.getLayoutParams();
        layoutParams4.height = f0.a(10.0f);
        space.setLayoutParams(layoutParams4);
    }

    public final void a2() {
        ShortTVCollectionView shortTVCollectionView = this.f55311p;
        if (shortTVCollectionView == null) {
            return;
        }
        ShortTVTrendingAdapter shortTVTrendingAdapter = this.f55307l;
        if (shortTVTrendingAdapter != null) {
            Intrinsics.d(shortTVCollectionView);
            shortTVTrendingAdapter.m0(shortTVCollectionView);
        }
        this.f55311p = null;
    }

    public final void b2() {
        RecyclerView recyclerView;
        tv.q mViewBinding = getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f77902b) == null) {
            return;
        }
        recyclerView.smoothScrollToPosition(0);
    }

    public final void c2(List<BannerData> list) {
        View view;
        if (this.f55316u != null) {
            uo.b.a aVar = uo.b.f78622a;
            String TAG = this.f55306k;
            Intrinsics.f(TAG, "TAG");
            uo.b.a.f(aVar, TAG, "set banner data", false, 4, null);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            ShortTVBannerAdapter shortTVBannerAdapter = this.f55317v;
            if (shortTVBannerAdapter != null) {
                shortTVBannerAdapter.i(arrayList);
                return;
            }
            return;
        }
        uo.b.a aVar2 = uo.b.f78622a;
        String TAG2 = this.f55306k;
        Intrinsics.f(TAG2, "TAG");
        uo.b.a.f(aVar2, TAG2, "add banner HeaderView", false, 4, null);
        if (getContext() != null) {
            r0 r0VarC = r0.c(LayoutInflater.from(getContext()));
            this.f55316u = r0VarC;
            ViewGroup.LayoutParams layoutParams = (r0VarC == null || (view = r0VarC.f77920f) == null) ? null : view.getLayoutParams();
            if (this.C != null) {
                if (layoutParams != null) {
                    layoutParams.height = com.blankj.utilcode.util.d.c() + f0.a(50.0f);
                }
            } else if (layoutParams != null) {
                layoutParams.height = com.blankj.utilcode.util.d.c() + f0.a(10.0f);
            }
            r0 r0Var = this.f55316u;
            View view2 = r0Var != null ? r0Var.f77920f : null;
            if (view2 != null) {
                view2.setLayoutParams(layoutParams);
            }
            r0 r0Var2 = this.f55316u;
            Intrinsics.d(r0Var2);
            ShortTVBannerView shortTVBannerView = r0Var2.f77917b;
            shortTVBannerView.getWindowVisibility();
            ShortTVBannerAdapter shortTVBannerAdapter2 = new ShortTVBannerAdapter();
            shortTVBannerAdapter2.j(new Function3<View, Integer, BannerData, Unit>() { // from class: com.transsion.postdetail.shorttv.ShortTVDiscoverFragment$setBannerData$1$1$1$1
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(View view3, Integer num, BannerData bannerData) {
                    invoke(view3, num.intValue(), bannerData);
                    return Unit.f68710a;
                }

                public final void invoke(View view3, int i11, BannerData item) {
                    Intrinsics.g(view3, "<anonymous parameter 0>");
                    Intrinsics.g(item, "item");
                    this.this$0.T1(i11, item);
                }
            });
            this.f55317v = shortTVBannerAdapter2;
            shortTVBannerView.setAutoTurningTime(4000L);
            shortTVBannerView.setPagerScrollDuration(1000L);
            Context contextRequireContext = requireContext();
            Intrinsics.f(contextRequireContext, "requireContext()");
            shortTVBannerView.setPageMargin(f0.a((com.transsion.baseui.util.b.a(contextRequireContext) ? 3 : 1) * 44.0f), f0.a(16.0f));
            shortTVBannerView.addPageTransformer(new com.to.aboomy.pager2banner.b());
            shortTVBannerView.setOuterPageChangeListener(new h());
            shortTVBannerView.setAdapter(this.f55317v);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            ShortTVBannerAdapter shortTVBannerAdapter3 = this.f55317v;
            Intrinsics.d(shortTVBannerAdapter3);
            shortTVBannerAdapter3.i(arrayList2);
            shortTVBannerView.post(new Runnable() { // from class: com.transsion.postdetail.shorttv.i
                @Override // java.lang.Runnable
                public final void run() {
                    ShortTVDiscoverFragment.d2(this.f55409a);
                }
            });
            ShortTVTrendingAdapter shortTVTrendingAdapter = this.f55307l;
            if (shortTVTrendingAdapter != null) {
                r0 r0Var3 = this.f55316u;
                Intrinsics.d(r0Var3);
                ConstraintLayout constraintLayout = r0Var3.f77918c;
                Intrinsics.f(constraintLayout, "bannerBinding!!.root");
                BaseQuickAdapter.q(shortTVTrendingAdapter, constraintLayout, 0, 0, 4, null);
            }
            this.A = true;
        }
    }

    public final void e2(boolean z11) {
        this.E = z11;
    }

    public final void f2(Function1<? super Boolean, Unit> function1) {
        this.B = function1;
    }

    public final void g2(OperatingResp operatingResp) {
        SwipeRefreshLayout swipeRefreshLayout;
        List<PlayListItemBean> playList;
        OperateItem operateItem;
        SwipeRefreshLayout swipeRefresh;
        SwipeRefreshLayout swipeRefresh2;
        List<OperateItem> ops;
        OperateItem operateItem2;
        if (operatingResp == null) {
            if (this.f55316u == null && this.f55314s.isEmpty()) {
                k2();
                return;
            }
            return;
        }
        OperatingResp operatingResp2 = this.f55318w;
        if (!Intrinsics.b(operatingResp2 != null ? operatingResp2.getVersion() : null, operatingResp.getVersion()) && (playList = operatingResp.getPlayList()) != null && !playList.isEmpty()) {
            List<OperateItem> ops2 = operatingResp.getOps();
            if (ops2 != null && (operateItem = (OperateItem) CollectionsKt___CollectionsKt.h0(ops2, 0)) != null) {
                OperatingResp operatingResp3 = this.f55318w;
                String md5 = (operatingResp3 == null || (ops = operatingResp3.getOps()) == null || (operateItem2 = (OperateItem) CollectionsKt___CollectionsKt.h0(ops, 0)) == null) ? null : operateItem2.getMd5();
                qp.a.C0819a c0819a = qp.a.f74869a;
                String strJ = com.blankj.utilcode.util.n.j(operateItem);
                Intrinsics.f(strJ, "toJson(this)");
                String strD = c0819a.d(strJ);
                operateItem.setMd5(strD);
                uo.b.a aVar = uo.b.f78622a;
                String TAG = this.f55306k;
                Intrinsics.f(TAG, "TAG");
                List<BannerData> banners = operatingResp.getBanners();
                uo.b.a.f(aVar, TAG, "banner size: " + (banners != null ? Integer.valueOf(banners.size()) : null), false, 4, null);
                List<BannerData> banners2 = operatingResp.getBanners();
                if (banners2 == null || !(!banners2.isEmpty())) {
                    r1(false);
                    Function1<? super Boolean, Unit> function1 = this.B;
                    if (function1 != null) {
                        function1.invoke(Boolean.FALSE);
                    }
                    Z1(false);
                    tv.q mViewBinding = getMViewBinding();
                    if (mViewBinding != null && (swipeRefresh = mViewBinding.f77903c) != null) {
                        Intrinsics.f(swipeRefresh, "swipeRefresh");
                        ViewGroup.LayoutParams layoutParams = swipeRefresh.getLayoutParams();
                        if (layoutParams == null) {
                            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                        }
                        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
                        bVar.setMargins(0, f0.a(80.0f), 0, 0);
                        swipeRefresh.setLayoutParams(bVar);
                    }
                } else if (!Intrinsics.b(md5, strD)) {
                    List<BannerData> banners3 = operatingResp.getBanners();
                    Intrinsics.d(banners3);
                    c2(banners3);
                    r1(true);
                    Z1(true);
                    Function1<? super Boolean, Unit> function2 = this.B;
                    if (function2 != null) {
                        function2.invoke(Boolean.TRUE);
                    }
                    tv.q mViewBinding2 = getMViewBinding();
                    if (mViewBinding2 != null && (swipeRefresh2 = mViewBinding2.f77903c) != null) {
                        Intrinsics.f(swipeRefresh2, "swipeRefresh");
                        ViewGroup.LayoutParams layoutParams2 = swipeRefresh2.getLayoutParams();
                        if (layoutParams2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                        }
                        ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams2;
                        bVar2.setMargins(0, f0.a(0.0f), 0, 0);
                        swipeRefresh2.setLayoutParams(bVar2);
                    }
                }
            }
            h2(operatingResp.getPlayList());
            this.f55318w = operatingResp;
        }
        tv.q mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (swipeRefreshLayout = mViewBinding3.f77903c) == null || !swipeRefreshLayout.isRefreshing()) {
            Function1<? super Boolean, Unit> function3 = this.D;
            if (function3 != null) {
                function3.invoke(Boolean.valueOf(C1()));
                return;
            }
            return;
        }
        tv.q mViewBinding4 = getMViewBinding();
        SwipeRefreshLayout swipeRefreshLayout2 = mViewBinding4 != null ? mViewBinding4.f77903c : null;
        if (swipeRefreshLayout2 == null) {
            return;
        }
        swipeRefreshLayout2.setRefreshing(false);
    }

    public String getPageName() {
        return "minitv_explore";
    }

    public final void h2(List<PlayListItemBean> list) {
        ShortTVTrendingAdapter shortTVTrendingAdapter;
        List<PlayListItemBean> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        Iterator<ShortTVDiscoverHeaderView> it = this.f55314s.iterator();
        while (it.hasNext()) {
            ShortTVDiscoverHeaderView next = it.next();
            if (!s1(list, next.getPlayListBean().getId())) {
                it.remove();
                ShortTVTrendingAdapter shortTVTrendingAdapter2 = this.f55307l;
                if (shortTVTrendingAdapter2 != null) {
                    shortTVTrendingAdapter2.m0(next);
                }
            }
        }
        Context context = getContext();
        if (context != null) {
            ShortTvCategoryView shortTvCategoryView = this.f55315t;
            if (shortTvCategoryView != null && (shortTVTrendingAdapter = this.f55307l) != null) {
                Intrinsics.d(shortTvCategoryView);
                shortTVTrendingAdapter.m0(shortTvCategoryView);
            }
            ShortTvCategoryView shortTvCategoryView2 = new ShortTvCategoryView(context);
            this.f55315t = shortTvCategoryView2;
            if (this.A) {
                ShortTVTrendingAdapter shortTVTrendingAdapter3 = this.f55307l;
                if (shortTVTrendingAdapter3 != null) {
                    BaseQuickAdapter.q(shortTVTrendingAdapter3, shortTvCategoryView2, 1, 0, 4, null);
                }
            } else {
                ShortTVTrendingAdapter shortTVTrendingAdapter4 = this.f55307l;
                if (shortTVTrendingAdapter4 != null) {
                    BaseQuickAdapter.q(shortTVTrendingAdapter4, shortTvCategoryView2, 0, 0, 4, null);
                }
            }
            int i11 = 0;
            for (Object obj : list) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.g.u();
                }
                PlayListItemBean playListItemBean = (PlayListItemBean) obj;
                String strU1 = u1(playListItemBean.getId());
                qp.a.C0819a c0819a = qp.a.f74869a;
                String strJ = com.blankj.utilcode.util.n.j(playListItemBean);
                Intrinsics.f(strJ, "toJson(playListBean)");
                String strD = c0819a.d(strJ);
                playListItemBean.setMd5(strD);
                if (!Intrinsics.b(strU1, strD)) {
                    ShortTVDiscoverHeaderView shortTVDiscoverHeaderViewT1 = t1(playListItemBean.getId());
                    if (shortTVDiscoverHeaderViewT1 != null) {
                        shortTVDiscoverHeaderViewT1.updateList(playListItemBean.getSubjects());
                    } else {
                        playListItemBean.setLastOne(i11 == list.size() - 1);
                        ShortTVDiscoverHeaderView shortTVDiscoverHeaderView = new ShortTVDiscoverHeaderView(playListItemBean, context);
                        this.f55314s.add(shortTVDiscoverHeaderView);
                        ShortTVTrendingAdapter shortTVTrendingAdapter5 = this.f55307l;
                        if (shortTVTrendingAdapter5 != null) {
                            BaseQuickAdapter.q(shortTVTrendingAdapter5, shortTVDiscoverHeaderView, 0, 0, 6, null);
                        }
                    }
                }
                i11 = i12;
            }
        }
    }

    public final void i2(RecyclerView.r pageScrollListener, Function1<? super Boolean, Unit> onLoaderSuccess) {
        Intrinsics.g(pageScrollListener, "pageScrollListener");
        Intrinsics.g(onLoaderSuccess, "onLoaderSuccess");
        this.C = pageScrollListener;
        this.D = onLoaderSuccess;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        if (this.C != null) {
            tv.q mViewBinding = getMViewBinding();
            if (mViewBinding != null && (recyclerView3 = mViewBinding.f77902b) != null) {
                RecyclerView.r rVar = this.C;
                Intrinsics.d(rVar);
                recyclerView3.addOnScrollListener(rVar);
            }
        } else {
            tv.q mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (recyclerView = mViewBinding2.f77902b) != null) {
                recyclerView.addOnScrollListener(new f());
            }
        }
        tv.q mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (recyclerView2 = mViewBinding3.f77902b) == null) {
            return;
        }
        recyclerView2.post(new Runnable() { // from class: com.transsion.postdetail.shorttv.b
            @Override // java.lang.Runnable
            public final void run() {
                ShortTVDiscoverFragment.J1(this.f55398a);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        uo.b.a aVar = uo.b.f78622a;
        String TAG = this.f55306k;
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "initViewModel " + this, false, 4, null);
        this.f55309n = (ShortTVContentViewModel) new v0(this).a(ShortTVContentViewModel.class);
        R1();
    }

    public final void j2(ShortTVRespData shortTVRespData) {
        String nextPage;
        Boolean hasMore;
        h9.f fVarQ;
        ShortTVTrendingAdapter shortTVTrendingAdapter;
        h9.f fVarQ2;
        List<Subject> listD;
        if (shortTVRespData == null) {
            ShortTVTrendingAdapter shortTVTrendingAdapter2 = this.f55307l;
            if (shortTVTrendingAdapter2 != null && (listD = shortTVTrendingAdapter2.D()) != null && listD.isEmpty()) {
                k2();
                return;
            }
            ShortTVTrendingAdapter shortTVTrendingAdapter3 = this.f55307l;
            if (shortTVTrendingAdapter3 == null || (fVarQ = shortTVTrendingAdapter3.Q()) == null || !fVarQ.q() || (shortTVTrendingAdapter = this.f55307l) == null || (fVarQ2 = shortTVTrendingAdapter.Q()) == null) {
                return;
            }
            fVarQ2.u();
            return;
        }
        Pager pager = shortTVRespData.getPager();
        if (pager == null || (nextPage = pager.getNextPage()) == null) {
            nextPage = "1";
        }
        this.f55308m = nextPage;
        uo.b.a aVar = uo.b.f78622a;
        String TAG = this.f55306k;
        Intrinsics.f(TAG, "TAG");
        String str = this.f55308m;
        List<Subject> items = shortTVRespData.getItems();
        Integer numValueOf = items != null ? Integer.valueOf(items.size()) : null;
        Pager pager2 = shortTVRespData.getPager();
        uo.b.a.f(aVar, TAG, "updateList,nextPage :" + str + ", size:" + numValueOf + ", hasMore:" + (pager2 != null ? pager2.getHasMore() : null), false, 4, null);
        List<Subject> items2 = shortTVRespData.getItems();
        boolean zIsRefresh = shortTVRespData.isRefresh();
        Pager pager3 = shortTVRespData.getPager();
        m2(items2, zIsRefresh, (pager3 == null || (hasMore = pager3.getHasMore()) == null) ? false : hasMore.booleanValue());
    }

    public void k2() {
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            PageStatusFragment.H0(this, false, 1, null);
        } else {
            M0(false);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View l0(boolean z11) {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        StateView stateView = new StateView(contextRequireContext);
        stateView.retry(new Function0<Unit>() { // from class: com.transsion.postdetail.shorttv.ShortTVDiscoverFragment$getEmptyView$1$1
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
                String strF;
                this.this$0.E0();
                com.transsion.baselib.report.h logViewConfig = this.this$0.getLogViewConfig();
                if (logViewConfig == null || (strF = logViewConfig.f()) == null) {
                    return;
                }
                com.tn.lib.view.l.b(strF);
            }
        });
        stateView.showData(4, u0(), false, t0(), k0());
        return stateView;
    }

    public void m2(List<? extends Subject> list, boolean z11, boolean z12) {
        h9.f fVarQ;
        h9.f fVarQ2;
        ShortTVTrendingAdapter shortTVTrendingAdapter;
        h9.f fVarQ3;
        SwipeRefreshLayout swipeRefreshLayout;
        List<Subject> listD;
        List<Subject> listL;
        h9.f fVarQ4;
        SwipeRefreshLayout swipeRefreshLayout2;
        h9.f fVarQ5;
        ShortTVTrendingAdapter shortTVTrendingAdapter2;
        h9.f fVarQ6;
        SwipeRefreshLayout swipeRefreshLayout3;
        List<Subject> listD2;
        BiddingListManager biddingListManager;
        tv.q mViewBinding = getMViewBinding();
        SwipeRefreshLayout swipeRefreshLayout4 = mViewBinding != null ? mViewBinding.f77903c : null;
        if (swipeRefreshLayout4 != null) {
            swipeRefreshLayout4.setEnabled(true);
        }
        if (z11 && (biddingListManager = this.H) != null) {
            biddingListManager.y();
        }
        List<? extends Subject> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            if (z11) {
                com.transsion.baselib.report.h logViewConfig = getLogViewConfig();
                if (logViewConfig != null) {
                    logViewConfig.j(true);
                }
                ShortTVTrendingAdapter shortTVTrendingAdapter3 = this.f55307l;
                if (shortTVTrendingAdapter3 != null) {
                    shortTVTrendingAdapter3.w0(list2);
                }
            }
            ShortTVTrendingAdapter shortTVTrendingAdapter4 = this.f55307l;
            if (shortTVTrendingAdapter4 == null || (listD = shortTVTrendingAdapter4.D()) == null || !listD.isEmpty()) {
                if (z12) {
                    ShortTVTrendingAdapter shortTVTrendingAdapter5 = this.f55307l;
                    if (shortTVTrendingAdapter5 != null && (fVarQ2 = shortTVTrendingAdapter5.Q()) != null && fVarQ2.q() && (shortTVTrendingAdapter = this.f55307l) != null && (fVarQ3 = shortTVTrendingAdapter.Q()) != null) {
                        fVarQ3.r();
                    }
                } else {
                    ShortTVTrendingAdapter shortTVTrendingAdapter6 = this.f55307l;
                    if (shortTVTrendingAdapter6 != null && (fVarQ = shortTVTrendingAdapter6.Q()) != null) {
                        h9.f.t(fVarQ, false, 1, null);
                    }
                }
            } else if (z11) {
                Intrinsics.b(getPageName(), "minitv_explore");
            }
            tv.q mViewBinding2 = getMViewBinding();
            if (mViewBinding2 == null || (swipeRefreshLayout = mViewBinding2.f77903c) == null || !swipeRefreshLayout.isRefreshing()) {
                return;
            }
            tv.q mViewBinding3 = getMViewBinding();
            SwipeRefreshLayout swipeRefreshLayout5 = mViewBinding3 != null ? mViewBinding3.f77903c : null;
            if (swipeRefreshLayout5 == null) {
                return;
            }
            swipeRefreshLayout5.setRefreshing(false);
            return;
        }
        ShortTVTrendingAdapter shortTVTrendingAdapter7 = this.f55307l;
        if ((shortTVTrendingAdapter7 == null || (listD2 = shortTVTrendingAdapter7.D()) == null || !listD2.isEmpty()) && !z11) {
            ShortTVTrendingAdapter shortTVTrendingAdapter8 = this.f55307l;
            if (shortTVTrendingAdapter8 == null || (listL = shortTVTrendingAdapter8.D()) == null) {
                listL = kotlin.collections.g.l();
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (!listL.contains((Subject) obj)) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.isEmpty()) {
                uo.b.a aVar = uo.b.f78622a;
                String TAG = this.f55306k;
                Intrinsics.f(TAG, "TAG");
                uo.b.a.f(aVar, TAG, "updateList 全部去重了", false, 4, null);
                return;
            }
            ShortTVTrendingAdapter shortTVTrendingAdapter9 = this.f55307l;
            if (shortTVTrendingAdapter9 != null) {
                shortTVTrendingAdapter9.m(arrayList);
            }
        } else {
            tv.q mViewBinding4 = getMViewBinding();
            if (mViewBinding4 != null && (swipeRefreshLayout3 = mViewBinding4.f77903c) != null && swipeRefreshLayout3.isRefreshing()) {
                tv.q mViewBinding5 = getMViewBinding();
                SwipeRefreshLayout swipeRefreshLayout6 = mViewBinding5 != null ? mViewBinding5.f77903c : null;
                if (swipeRefreshLayout6 != null) {
                    swipeRefreshLayout6.setRefreshing(false);
                }
            }
            com.transsion.baselib.report.h logViewConfig2 = getLogViewConfig();
            if (logViewConfig2 != null) {
                logViewConfig2.j(true);
            }
            ShortTVTrendingAdapter shortTVTrendingAdapter10 = this.f55307l;
            if (shortTVTrendingAdapter10 != null) {
                shortTVTrendingAdapter10.w0(list2);
            }
        }
        if (z12) {
            ShortTVTrendingAdapter shortTVTrendingAdapter11 = this.f55307l;
            if (shortTVTrendingAdapter11 != null && (fVarQ5 = shortTVTrendingAdapter11.Q()) != null && fVarQ5.q() && (shortTVTrendingAdapter2 = this.f55307l) != null && (fVarQ6 = shortTVTrendingAdapter2.Q()) != null) {
                fVarQ6.r();
            }
        } else {
            ShortTVTrendingAdapter shortTVTrendingAdapter12 = this.f55307l;
            if (shortTVTrendingAdapter12 != null && (fVarQ4 = shortTVTrendingAdapter12.Q()) != null) {
                h9.f.t(fVarQ4, false, 1, null);
            }
        }
        ShortTVDiscoverPreloadHelper.f55032n.a().K(list);
        if (C1() || this.C != null) {
            return;
        }
        r1(false);
        Function1<? super Boolean, Unit> function1 = this.B;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
        Z1(false);
        tv.q mViewBinding6 = getMViewBinding();
        if (mViewBinding6 == null || (swipeRefreshLayout2 = mViewBinding6.f77903c) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = swipeRefreshLayout2.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        bVar.setMargins(0, f0.a(80.0f), 0, 0);
        swipeRefreshLayout2.setLayoutParams(bVar);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h(getPageName(), false, 2, null);
    }

    public final void o1() {
        Context context;
        if (this.f55311p == null && (context = getContext()) != null) {
            ShortTVCollectionView shortTVCollectionView = new ShortTVCollectionView(this, ShortTVCollectionView.TYPE_COLLECTION, z1(), context);
            this.f55311p = shortTVCollectionView;
            if (this.A) {
                ShortTVTrendingAdapter shortTVTrendingAdapter = this.f55307l;
                if (shortTVTrendingAdapter != null) {
                    Intrinsics.d(shortTVCollectionView);
                    BaseQuickAdapter.q(shortTVTrendingAdapter, shortTVCollectionView, 2, 0, 4, null);
                    return;
                }
                return;
            }
            ShortTVTrendingAdapter shortTVTrendingAdapter2 = this.f55307l;
            if (shortTVTrendingAdapter2 != null) {
                Intrinsics.d(shortTVCollectionView);
                BaseQuickAdapter.q(shortTVTrendingAdapter2, shortTVCollectionView, 1, 0, 4, null);
            }
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BiddingListManager biddingListManager = this.H;
        if (biddingListManager != null) {
            biddingListManager.o();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        if (isResumed() && z11) {
            this.G.f();
            tv.q mViewBinding = getMViewBinding();
            q1(mViewBinding != null ? mViewBinding.f77902b : null);
        }
        if (isResumed()) {
            if (z11) {
                logPause();
            } else {
                logResume();
            }
        }
        com.transsion.baseui.activity.d.h(null, this, z11, null, 9, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onPause() {
        ShortTVBannerView shortTVBannerView;
        ShortTVBannerView shortTVBannerView2;
        super.onPause();
        S1();
        this.G.f();
        tv.q mViewBinding = getMViewBinding();
        q1(mViewBinding != null ? mViewBinding.f77902b : null);
        r0 r0Var = this.f55316u;
        if (r0Var == null || (shortTVBannerView = r0Var.f77917b) == null || !shortTVBannerView.isAttachedToWindow()) {
            return;
        }
        uo.b.a aVar = uo.b.f78622a;
        String TAG = this.f55306k;
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "onPause banner stopTurning", false, 4, null);
        r0 r0Var2 = this.f55316u;
        if (r0Var2 == null || (shortTVBannerView2 = r0Var2.f77917b) == null) {
            return;
        }
        shortTVBannerView2.stopTurning();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        ShortTVBannerView shortTVBannerView;
        ShortTVBannerView shortTVBannerView2;
        super.onResume();
        this.f55321z = System.currentTimeMillis();
        r0 r0Var = this.f55316u;
        if (r0Var == null || (shortTVBannerView = r0Var.f77917b) == null || !shortTVBannerView.isAttachedToWindow()) {
            return;
        }
        uo.b.a aVar = uo.b.f78622a;
        String TAG = this.f55306k;
        Intrinsics.f(TAG, "TAG");
        uo.b.a.f(aVar, TAG, "onResume banner startTurning", false, 4, null);
        r0 r0Var2 = this.f55316u;
        if (r0Var2 == null || (shortTVBannerView2 = r0Var2.f77917b) == null) {
            return;
        }
        shortTVBannerView2.startTurning();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (isVisible()) {
            if (this.f55312q) {
                this.f55312q = false;
                return;
            }
            ShortTVContentViewModel shortTVContentViewModel = this.f55309n;
            if (shortTVContentViewModel != null) {
                shortTVContentViewModel.h();
            }
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View p0() {
        View viewInflate = LayoutInflater.from(requireContext()).inflate(y1(), (ViewGroup) o0(), false);
        if (this.C == null) {
            View viewFindViewById = viewInflate.findViewById(R$id.v_bar_space);
            int iC = com.blankj.utilcode.util.d.c();
            if (viewFindViewById.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                layoutParams.height = iC;
                viewFindViewById.setLayoutParams(layoutParams);
            } else {
                viewFindViewById.setLayoutParams(new ConstraintLayout.b(-1, iC));
            }
        } else {
            View viewFindViewById2 = viewInflate.findViewById(R$id.v_title);
            if (viewFindViewById2.getLayoutParams() instanceof ConstraintLayout.b) {
                ViewGroup.LayoutParams layoutParams2 = viewFindViewById2.getLayoutParams();
                Intrinsics.e(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) layoutParams2)).topMargin = f0.a(10.0f);
            }
        }
        return viewInflate;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View s0() {
        View viewS0 = super.s0();
        if (this.C == null) {
            viewS0.setPadding(viewS0.getPaddingStart(), viewS0.getPaddingTop() + com.blankj.utilcode.util.d.c() + f0.a(44.0f), viewS0.getPaddingEnd(), viewS0.getPaddingBottom());
        }
        if (viewS0 instanceof NoNetworkBigView) {
            NoNetworkBigView.showTitle$default((NoNetworkBigView) viewS0, false, null, 2, null);
        }
        return viewS0;
    }

    public final boolean s1(List<PlayListItemBean> list, String str) {
        List<PlayListItemBean> list2 = list;
        if (list2 != null && !list2.isEmpty() && str != null && str.length() != 0) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (Intrinsics.b(((PlayListItemBean) it.next()).getId(), str)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    public final ShortTVDiscoverHeaderView t1(String str) {
        for (ShortTVDiscoverHeaderView shortTVDiscoverHeaderView : this.f55314s) {
            if (Intrinsics.b(shortTVDiscoverHeaderView.getPlayListBean().getId(), str)) {
                return shortTVDiscoverHeaderView;
            }
        }
        return null;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public int u0() {
        return 4;
    }

    public final String u1(String str) {
        List<PlayListItemBean> playList;
        OperatingResp operatingResp = this.f55318w;
        if (operatingResp == null || (playList = operatingResp.getPlayList()) == null) {
            return null;
        }
        for (PlayListItemBean playListItemBean : playList) {
            if (Intrinsics.b(playListItemBean.getId(), str)) {
                return playListItemBean.getMd5();
            }
        }
        return null;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        View view;
        tv.q mViewBinding = getMViewBinding();
        ViewGroup.LayoutParams layoutParams = (mViewBinding == null || (view = mViewBinding.f77905f) == null) ? null : view.getLayoutParams();
        int iC = com.blankj.utilcode.util.d.c();
        if (layoutParams != null) {
            layoutParams.height = iC;
        }
        tv.q mViewBinding2 = getMViewBinding();
        View view2 = mViewBinding2 != null ? mViewBinding2.f77905f : null;
        if (view2 != null) {
            view2.setLayoutParams(layoutParams);
        }
        ShortTVDiscoverPreloadHelper.a aVar = ShortTVDiscoverPreloadHelper.f55032n;
        ShortTVDiscoverPreloadHelper shortTVDiscoverPreloadHelperA = aVar.a();
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        shortTVDiscoverPreloadHelperA.F(contextRequireContext);
        aVar.a().H();
        aVar.a().G();
        E1();
        D1();
    }

    public final com.transsion.postdetail.util.a v1() {
        return (com.transsion.postdetail.util.a) this.f55319x.getValue();
    }

    public String w1() {
        return "most_trending";
    }

    public final ShortTVTrendingAdapter x1() {
        return this.f55307l;
    }

    public int y1() {
        return R$layout.layout_short_tv_skeleton_drawing_discover;
    }
}
