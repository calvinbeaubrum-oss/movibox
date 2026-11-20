package com.transsion.home.adapter.suboperate.provider;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.p003enum.HomeTabId;
import com.transsion.home.utils.HomeUtilsKt;
import com.transsion.home.view.RankingAdapter;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.RankingData;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.w0;

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
public final class SubRankingProvider extends BaseItemProvider<OperateItem> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f52165f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public q1 f52166g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OperateItem f52167h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BaseQuickAdapter<Subject, BaseViewHolder> f52168i;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends RecyclerView.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f52169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f52170b;

        public a(int i11, int i12) {
            this.f52169a = i11;
            this.f52170b = i12;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.x state) {
            Intrinsics.g(outRect, "outRect");
            Intrinsics.g(view, "view");
            Intrinsics.g(parent, "parent");
            Intrinsics.g(state, "state");
            int i11 = this.f52169a;
            outRect.left = i11;
            outRect.right = i11;
            outRect.top = this.f52170b;
        }
    }

    public SubRankingProvider(int i11) {
        this.f52165f = i11;
    }

    public static final void D(OperateItem item, SubRankingProvider this$0, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Intrinsics.g(item, "$item");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "<anonymous parameter 1>");
        List<Subject> rankings = item.getRankings();
        Subject subject = rankings != null ? rankings.get(i11) : null;
        HomeUtilsKt.b(subject, "op_ranking");
        this$0.B(subject, i11, item);
    }

    private final void E() {
        q1 q1Var = this.f52166g;
        if (q1Var != null) {
            q1.a.b(q1Var, null, 1, null);
        }
        this.f52166g = null;
    }

    private final void z() {
        if (this.f52165f != HomeTabId.Education.getValue()) {
            return;
        }
        this.f52166g = kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new SubRankingProvider$registerCourse$1(this, null), 3, null);
    }

    public final void A(Subject subject, int i11, OperateItem operateItem) {
        HashMap map = new HashMap();
        map.put("event_type", "browse_ranking");
        map.put("sequence", String.valueOf(i11));
        map.put("tabId", String.valueOf(this.f52165f));
        if (subject != null) {
            ot.b.c(subject, map);
        }
        ot.b.a(operateItem, map);
        com.transsion.baselib.helper.a.f51183a.a(SubTabFragment.f52541r.a(this.f52165f), map);
    }

    public final void B(Subject subject, int i11, OperateItem operateItem) {
        HashMap map = new HashMap();
        map.put("event_type", "click_ranking");
        map.put("sequence", String.valueOf(i11));
        map.put("tabId", String.valueOf(this.f52165f));
        if (subject != null) {
            ot.b.c(subject, map);
        }
        ot.b.a(operateItem, map);
        com.transsion.baselib.helper.a.f51183a.e(SubTabFragment.f52541r.a(this.f52165f), map);
    }

    public final void C(BaseQuickAdapter<Subject, BaseViewHolder> baseQuickAdapter, final OperateItem operateItem) {
        baseQuickAdapter.B0(new f9.d() { // from class: com.transsion.home.adapter.suboperate.provider.y
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter2, View view, int i11) {
                SubRankingProvider.D(operateItem, this, baseQuickAdapter2, view, i11);
            }
        });
        if (baseQuickAdapter instanceof com.transsion.home.adapter.suboperate.adapter.m) {
            ((com.transsion.home.adapter.suboperate.adapter.m) baseQuickAdapter).K0(new Function2<Integer, Subject, Unit>() { // from class: com.transsion.home.adapter.suboperate.provider.SubRankingProvider$setClickListener$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, Subject subject) {
                    invoke(num.intValue(), subject);
                    return Unit.f68710a;
                }

                public final void invoke(int i11, Subject subject) {
                    Intrinsics.g(subject, "subject");
                    this.this$0.A(subject, i11, operateItem);
                }
            });
        }
        this.f52168i = baseQuickAdapter;
        this.f52167h = operateItem;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return PostItemType.OP_RANKING.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_sub_operation_ranking;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void p(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.p(holder);
        z();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void q(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.q(holder);
        E();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, OperateItem item) {
        BaseQuickAdapter<Subject, BaseViewHolder> rankingAdapter;
        List arrayList;
        RankingData rankingData;
        Integer perRow;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        helper.setText(R$id.sub_operation_ranking_title, item.getTitle());
        RecyclerView recyclerView = (RecyclerView) helper.getView(R$id.sub_operation_ranking_recycler);
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new a(f0.a(4.0f), f0.a(12.0f)));
        }
        List<Subject> rankings = item.getRankings();
        int i11 = 0;
        int size = rankings != null ? rankings.size() : 0;
        ?? SubList = 0;
        if (this.f52165f != HomeTabId.Education.getValue() || (rankingData = item.getRankingData()) == null || (perRow = rankingData.getPerRow()) == null || perRow.intValue() != 2) {
            recyclerView.setLayoutManager(new NpaGridLayoutManager(g(), 3));
            List<Subject> rankings2 = item.getRankings();
            SubList = rankings2 != null ? rankings2.subList(0, size - (size % 3)) : 0;
            if (SubList == 0 || (arrayList = CollectionsKt___CollectionsKt.M0((Collection) SubList)) == null) {
                arrayList = new ArrayList();
            }
            rankingAdapter = new RankingAdapter(arrayList);
        } else {
            recyclerView.setLayoutManager(new NpaGridLayoutManager(g(), 2));
            rankingAdapter = new com.transsion.home.adapter.suboperate.adapter.m(i11, this.f52165f, 1, SubList);
            List<Subject> rankings3 = item.getRankings();
            rankingAdapter.w0(rankings3 != null ? rankings3.subList(0, size - (size % 2)) : null);
        }
        C(rankingAdapter, item);
        recyclerView.setAdapter(rankingAdapter);
    }
}
