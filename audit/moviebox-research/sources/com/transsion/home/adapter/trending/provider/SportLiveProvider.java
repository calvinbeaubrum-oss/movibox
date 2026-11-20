package com.transsion.home.adapter.trending.provider;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.adapter.trending.adapter.SportLiveAdapter;
import com.transsion.home.p003enum.HomeTabType;
import com.transsion.moviedetailapi.bean.LiveListItem;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class SportLiveProvider extends BaseItemProvider<OperateItem> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f52269f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f52270g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f52271h = LazyKt__LazyJVMKt.b(new Function0<SportLiveProvider$customRecycledViewPool$2.a>() { // from class: com.transsion.home.adapter.trending.provider.SportLiveProvider$customRecycledViewPool$2

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a extends RecyclerView.s {
            public a() {
                m(0, 8);
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
    public static final class a extends DiffUtil.e<LiveListItem> {
        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(LiveListItem oldItem, LiveListItem newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return Intrinsics.b(oldItem.getMatchId(), newItem.getMatchId()) && Intrinsics.b(oldItem.getStatus(), newItem.getStatus());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(LiveListItem oldItem, LiveListItem newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return Intrinsics.b(oldItem.getMatchId(), newItem.getMatchId());
        }
    }

    public SportLiveProvider(int i11, boolean z11) {
        this.f52269f = i11;
        this.f52270g = z11;
    }

    public static final void A(SportLiveProvider this$0, OperateItem item, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(item, "$item");
        this$0.F(item);
    }

    public static final void B(SportLiveAdapter adapter, List list) {
        Intrinsics.g(adapter, "$adapter");
        adapter.w0(list);
    }

    public static final void C(List list, SportLiveProvider this$0, OperateItem item, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        LiveListItem liveListItem;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(item, "$item");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "<anonymous parameter 1>");
        if (list == null || (liveListItem = (LiveListItem) list.get(i11)) == null) {
            return;
        }
        this$0.E(liveListItem, item, i11);
    }

    public static final void z(SportLiveProvider this$0, OperateItem item, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(item, "$item");
        this$0.F(item);
    }

    public final SportLiveProvider$customRecycledViewPool$2.a D() {
        return (SportLiveProvider$customRecycledViewPool$2.a) this.f52271h.getValue();
    }

    public final void E(LiveListItem liveListItem, OperateItem operateItem, int i11) {
        String deepLink = liveListItem.getDeepLink();
        if (deepLink != null) {
            com.transsion.baselib.utils.i.e(deepLink, null, 1, null);
        }
        HashMap map = new HashMap();
        map.put("event_type", "click_sport_live_item");
        map.put("sequence", String.valueOf(i11));
        map.put("tabId", String.valueOf(this.f52269f));
        ot.b.a(operateItem, map);
        String type = operateItem.getType();
        if (type == null) {
            type = "";
        }
        map.put("opt_type", type);
        String matchId = liveListItem.getMatchId();
        if (matchId == null) {
            matchId = "";
        }
        map.put("match_id", matchId);
        String status = liveListItem.getStatus();
        if (status == null) {
            status = "";
        }
        map.put("match_status", status);
        String ops = liveListItem.getOps();
        map.put("ops", ops != null ? ops : "");
        com.transsion.baselib.helper.a.f51183a.e(HomeTabType.TAB_CODE_TRENDING, map);
    }

    public final void F(OperateItem operateItem) {
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
        HashMap map = new HashMap();
        map.put("event_type", "click_sport_live_more");
        map.put("sequence", String.valueOf(numValueOf));
        String deepLink2 = operateItem.getDeepLink();
        if (deepLink2 == null) {
            deepLink2 = "";
        }
        map.put("deepLink", deepLink2);
        map.put("tabId", String.valueOf(this.f52269f));
        ot.b.a(operateItem, map);
        map.put("opt_type", operateItem.getType() + "_MORE");
        com.transsion.baselib.helper.a.f51183a.e(HomeTabType.TAB_CODE_TRENDING, map);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return PostItemType.SPORT_LIVE.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.post_list_item_sport_live;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, final OperateItem item) {
        final ArrayList arrayList;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        TextView textView = (TextView) helper.getView(R$id.main_operation_sport_live_title);
        textView.setText(item.getTitle());
        TextView textView2 = (TextView) helper.getView(R$id.main_operation_sport_more_text);
        String deepLink = item.getDeepLink();
        if (deepLink == null || deepLink.length() == 0) {
            so.c.h(textView2);
        } else {
            so.c.k(textView2);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SportLiveProvider.z(this.f52328a, item, view);
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SportLiveProvider.A(this.f52330a, item, view);
                }
            });
        }
        RecyclerView recyclerView = (RecyclerView) helper.getView(R$id.main_operation_sport_live_recycler);
        final SportLiveAdapter sportLiveAdapter = new SportLiveAdapter(0, item, this.f52269f, this.f52270g, 1, null);
        sportLiveAdapter.o0(new a());
        recyclerView.setAdapter(sportLiveAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(g(), 0, false));
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new ro.e(8.0f, 0.0f, 12.0f, 2, null));
        }
        if (!Intrinsics.b(recyclerView.getRecycledViewPool(), D())) {
            recyclerView.setRecycledViewPool(D());
        }
        List<LiveListItem> liveList = item.getLiveList();
        if (liveList != null) {
            arrayList = new ArrayList();
            for (Object obj : liveList) {
                if (!Intrinsics.b(((LiveListItem) obj).getStatus(), "MatchEnded")) {
                    arrayList.add(obj);
                }
            }
        } else {
            arrayList = null;
        }
        recyclerView.post(new Runnable() { // from class: com.transsion.home.adapter.trending.provider.a0
            @Override // java.lang.Runnable
            public final void run() {
                SportLiveProvider.B(sportLiveAdapter, arrayList);
            }
        });
        sportLiveAdapter.B0(new f9.d() { // from class: com.transsion.home.adapter.trending.provider.b0
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                SportLiveProvider.C(arrayList, this, item, baseQuickAdapter, view, i11);
            }
        });
    }
}
