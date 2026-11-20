package com.transsion.home.adapter.trending.provider;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.adapter.trending.adapter.OpMovieRankAdapter;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.utils.HomeUtilsKt;
import com.transsion.moviedetailapi.bean.AppointSubject;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.RankingData;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class OpMovieRankProvider extends BaseItemProvider<OperateItem> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f52234k = new a(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f52235l = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f52236f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.transsion.home.preload.b f52237g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f52238h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f52239i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f52240j = LazyKt__LazyJVMKt.b(new Function0<OpMovieRankProvider$customRecycledViewPool$2.a>() { // from class: com.transsion.home.adapter.trending.provider.OpMovieRankProvider$customRecycledViewPool$2

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a extends RecyclerView.s {
            public a() {
                m(100, 1);
                m(0, 16);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.s
            public void k(RecyclerView.a0 a0Var) {
                super.k(a0Var);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return new a();
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
    }

    public OpMovieRankProvider(int i11, com.transsion.home.preload.b bVar, boolean z11, boolean z12) {
        this.f52236f = i11;
        this.f52237g = bVar;
        this.f52238h = z11;
        this.f52239i = z12;
    }

    public static final void A(OperateItem item, OpMovieRankAdapter adapter, OpMovieRankProvider this$0, boolean z11, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        List<AppointSubject> subjects;
        AppointSubject appointSubject;
        Intrinsics.g(item, "$item");
        Intrinsics.g(adapter, "$adapter");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "<anonymous parameter 1>");
        List<AppointSubject> subjects2 = item.getSubjects();
        if (i11 >= (subjects2 != null ? subjects2.size() : 0) || (subjects = item.getSubjects()) == null || (appointSubject = subjects.get(i11)) == null) {
            return;
        }
        if (adapter.getItemViewType(i11) == 100) {
            this$0.C(item, z11);
        } else {
            this$0.D(appointSubject, i11, item, z11);
        }
    }

    public static final void y(OpMovieRankProvider this$0, OperateItem item, boolean z11, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(item, "$item");
        this$0.C(item, z11);
    }

    public static final void z(OpMovieRankProvider this$0, OperateItem item, boolean z11, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(item, "$item");
        this$0.C(item, z11);
    }

    public final OpMovieRankProvider$customRecycledViewPool$2.a B() {
        return (OpMovieRankProvider$customRecycledViewPool$2.a) this.f52240j.getValue();
    }

    public final void C(OperateItem operateItem, boolean z11) {
        List<OperateItem> listD;
        String deepLink = operateItem.getDeepLink();
        Integer numValueOf = null;
        if (deepLink != null) {
            com.transsion.baselib.utils.i.e(deepLink, null, 1, null);
        }
        BaseProviderMultiAdapter<OperateItem> baseProviderMultiAdapterC = c();
        if (baseProviderMultiAdapterC != null && (listD = baseProviderMultiAdapterC.D()) != null) {
            numValueOf = Integer.valueOf(listD.indexOf(operateItem));
        }
        if (!this.f52238h) {
            pr.a.f74040a.t(operateItem, numValueOf);
            return;
        }
        HashMap map = new HashMap();
        map.put("event_type", z11 ? "click_rank_horiz_more" : "click_rank_more");
        map.put("sequence", String.valueOf(numValueOf));
        String deepLink2 = operateItem.getDeepLink();
        if (deepLink2 == null) {
            deepLink2 = "";
        }
        map.put("deepLink", deepLink2);
        String title = operateItem.getTitle();
        map.put(CampaignEx.JSON_KEY_TITLE, title != null ? title : "");
        map.put("tabId", String.valueOf(this.f52236f));
        ot.b.a(operateItem, map);
        map.put("opt_type", operateItem.getType() + "_RANK_MORE");
        com.transsion.baselib.helper.a.f51183a.e(SubTabFragment.f52541r.a(this.f52236f), map);
    }

    public final void D(Subject subject, int i11, OperateItem operateItem, boolean z11) {
        HomeUtilsKt.b(subject, "opt_movie_rank");
        if (!this.f52238h) {
            pr.a.f74040a.s(subject, i11, operateItem);
            return;
        }
        HashMap map = new HashMap();
        map.put("event_type", z11 ? "click_rank_horiz_item" : "click_rank_item");
        map.put("sequence", String.valueOf(i11));
        map.put("tabId", String.valueOf(this.f52236f));
        if (operateItem != null) {
            ot.b.a(operateItem, map);
        }
        ot.b.c(subject, map);
        com.transsion.baselib.helper.a.f51183a.e(SubTabFragment.f52541r.a(this.f52236f), map);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return PostItemType.OP_SUBJECTS_MOVIE.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.post_list_item_op_movie_rank;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public BaseViewHolder n(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        com.transsion.home.preload.b bVar = this.f52237g;
        if (bVar == null || bVar.b() || this.f52237g.d() == null) {
            return super.n(parent, i11);
        }
        uo.b.a.f(uo.b.f78622a, "MainXMLPreload", "subjectOpView", false, 4, null);
        View viewD = this.f52237g.d();
        Intrinsics.d(viewD);
        viewD.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return new BaseViewHolder(viewD);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void q(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.q(holder);
        RecyclerView recyclerView = (RecyclerView) holder.getView(R$id.main_operation_movie_rank_recycler);
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            RecyclerView.m layoutManager = recyclerView.getLayoutManager();
            Intrinsics.e(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            ((LinearLayoutManager) layoutManager).setRecycleChildrenOnDetach(true);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, final OperateItem item) {
        final boolean z11;
        List<OperateItem> listD;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        RankingData rankingData = item.getRankingData();
        if (rankingData != null) {
            z11 = rankingData.getRankingHorizontal();
        }
        TextView textView = (TextView) helper.getView(R$id.main_operation_movie_rank_title);
        textView.setText(item.getTitle());
        TextView textView2 = (TextView) helper.getView(R$id.main_operation_movie_more_text);
        String deepLink = item.getDeepLink();
        if (deepLink == null || deepLink.length() == 0) {
            so.c.h(textView2);
        } else {
            so.c.k(textView2);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OpMovieRankProvider.y(this.f52298a, item, z11, view);
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OpMovieRankProvider.z(this.f52301a, item, z11, view);
                }
            });
        }
        RecyclerView recyclerView = (RecyclerView) helper.getView(R$id.main_operation_movie_rank_recycler);
        final OpMovieRankAdapter opMovieRankAdapter = new OpMovieRankAdapter(0, item, this.f52238h, this.f52236f, z11, this.f52239i, 1, null);
        recyclerView.setAdapter(opMovieRankAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(g(), 0, false));
        if (!Intrinsics.b(recyclerView.getRecycledViewPool(), B())) {
            recyclerView.setRecycledViewPool(B());
        }
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new ro.e(8.0f, 0.0f, 12.0f, 2, null));
        }
        List<AppointSubject> subjects = item.getSubjects();
        if (subjects == null) {
            subjects = new ArrayList<>();
        }
        if (subjects.size() > 30) {
            subjects = subjects.subList(0, 31);
        }
        opMovieRankAdapter.w0(subjects);
        opMovieRankAdapter.B0(new f9.d() { // from class: com.transsion.home.adapter.trending.provider.m
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                OpMovieRankProvider.A(item, opMovieRankAdapter, this, z11, baseQuickAdapter, view, i11);
            }
        });
        if (this.f52238h) {
            HashMap map = new HashMap();
            map.put("event_type", z11 ? "browse_rank_horiz_more" : "browse_rank_more");
            BaseProviderMultiAdapter<OperateItem> baseProviderMultiAdapterC = c();
            map.put("sequence", String.valueOf((baseProviderMultiAdapterC == null || (listD = baseProviderMultiAdapterC.D()) == null) ? null : Integer.valueOf(listD.indexOf(item))));
            String deepLink2 = item.getDeepLink();
            if (deepLink2 == null) {
                deepLink2 = "";
            }
            map.put("deepLink", deepLink2);
            String title = item.getTitle();
            map.put(CampaignEx.JSON_KEY_TITLE, title != null ? title : "");
            map.put("tabId", String.valueOf(this.f52236f));
            ot.b.a(item, map);
            map.put("opt_type", item.getType() + "_RANK_MORE");
            com.transsion.baselib.helper.a.f51183a.d(SubTabFragment.f52541r.a(this.f52236f), map);
        }
    }
}
