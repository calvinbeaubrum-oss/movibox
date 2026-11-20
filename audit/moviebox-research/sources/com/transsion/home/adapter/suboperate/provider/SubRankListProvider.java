package com.transsion.home.adapter.suboperate.provider;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.p003enum.HomeTabId;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.RankingListData;
import com.transsion.moviedetailapi.bean.RankingListItem;
import java.util.List;
import kotlin.Metadata;
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
public final class SubRankListProvider extends BaseItemProvider<OperateItem> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f52155f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public q1 f52156g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OperateItem f52157h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.transsion.home.adapter.suboperate.adapter.j f52158i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.transsion.home.adapter.suboperate.adapter.k f52159j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f52160k;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends RecyclerView.r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.recyclerview.widget.m f52161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SubRankListProvider f52162b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f52163c;

        public a(androidx.recyclerview.widget.m mVar, SubRankListProvider subRankListProvider, RecyclerView recyclerView) {
            this.f52161a = mVar;
            this.f52162b = subRankListProvider;
            this.f52163c = recyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            View viewFindSnapView;
            List<RankingListItem> listD;
            Intrinsics.g(recyclerView, "recyclerView");
            if (i11 != 0 || (viewFindSnapView = this.f52161a.findSnapView(recyclerView.getLayoutManager())) == null) {
                return;
            }
            RecyclerView.m layoutManager = recyclerView.getLayoutManager();
            int position = layoutManager != null ? layoutManager.getPosition(viewFindSnapView) : 0;
            com.transsion.home.adapter.suboperate.adapter.k kVar = this.f52162b.f52159j;
            if (kVar != null) {
                kVar.H0(position);
            }
            this.f52162b.f52160k = position;
            if (position != 0) {
                com.transsion.home.adapter.suboperate.adapter.k kVar2 = this.f52162b.f52159j;
                if (position != ((kVar2 == null || (listD = kVar2.D()) == null) ? -1 : listD.size()) - 1) {
                    this.f52162b.H(this.f52163c, position);
                    return;
                }
            }
            this.f52163c.scrollToPosition(position);
        }
    }

    public SubRankListProvider(int i11) {
        this.f52155f = i11;
    }

    public static final void C(OperateItem item, View view) {
        Intrinsics.g(item, "$item");
        String deepLink = item.getDeepLink();
        if (deepLink != null) {
            com.transsion.baselib.utils.i.e(deepLink, null, 1, null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0036  */
    public static final void F(SubRankListProvider this$0, RecyclerView viewRecyclerView, RecyclerView recyclerView, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        List<RankingListItem> listD;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(viewRecyclerView, "$viewRecyclerView");
        Intrinsics.g(recyclerView, "$recyclerView");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "<anonymous parameter 1>");
        this$0.f52160k = i11;
        if (i11 == 0) {
            viewRecyclerView.scrollToPosition(i11);
        } else {
            com.transsion.home.adapter.suboperate.adapter.j jVar = this$0.f52158i;
            if (i11 == ((jVar == null || (listD = jVar.D()) == null) ? -1 : listD.size()) - 1) {
                viewRecyclerView.scrollToPosition(i11);
            } else {
                this$0.H(viewRecyclerView, i11);
            }
        }
        com.transsion.home.adapter.suboperate.adapter.k kVar = this$0.f52159j;
        if (kVar != null) {
            kVar.H0(this$0.f52160k);
        }
        recyclerView.scrollToPosition(i11);
    }

    private final void G() {
        if (this.f52155f != HomeTabId.Education.getValue()) {
            return;
        }
        this.f52156g = kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new SubRankListProvider$registerCourse$1(this, null), 3, null);
    }

    private final void I() {
        q1 q1Var = this.f52156g;
        if (q1Var != null) {
            q1.a.b(q1Var, null, 1, null);
        }
        this.f52156g = null;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, final OperateItem item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        this.f52157h = item;
        helper.setText(R$id.sub_operation_ranklist_title_text, item.getTitle());
        helper.getView(R$id.sub_operation_ranklist_title_linear).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.provider.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubRankListProvider.C(item, view);
            }
        });
        RecyclerView recyclerView = (RecyclerView) helper.getView(R$id.sub_operation_ranklist_recycler);
        RecyclerView recyclerView2 = (RecyclerView) helper.getView(R$id.sub_operation_ranklist_title_tab_recycler);
        D(recyclerView, recyclerView2, item);
        E(recyclerView2, recyclerView, item);
    }

    public final void D(RecyclerView recyclerView, RecyclerView recyclerView2, OperateItem operateItem) {
        recyclerView.setLayoutManager(new LinearLayoutManager(g(), 0, false));
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new ro.e(8.0f, 0.0f, 12.0f, 2, null));
        }
        com.transsion.home.adapter.suboperate.adapter.j jVar = new com.transsion.home.adapter.suboperate.adapter.j(0, operateItem, this.f52155f, 1, null);
        this.f52158i = jVar;
        RankingListData rankingListData = operateItem.getRankingListData();
        jVar.w0(rankingListData != null ? rankingListData.getItems() : null);
        recyclerView.setAdapter(this.f52158i);
        recyclerView.scrollToPosition(this.f52160k);
        recyclerView.setOnFlingListener(null);
        androidx.recyclerview.widget.m mVar = new androidx.recyclerview.widget.m();
        mVar.attachToRecyclerView(recyclerView);
        recyclerView.addOnScrollListener(new a(mVar, this, recyclerView2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void E(final RecyclerView recyclerView, final RecyclerView recyclerView2, OperateItem operateItem) {
        int i11 = 0;
        recyclerView.setLayoutManager(new LinearLayoutManager(g(), 0, false));
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new ro.e(8.0f, 0.0f, 12.0f, 2, null));
        }
        com.transsion.home.adapter.suboperate.adapter.k kVar = new com.transsion.home.adapter.suboperate.adapter.k(i11, 1, 0 == true ? 1 : 0);
        this.f52159j = kVar;
        kVar.H0(this.f52160k);
        com.transsion.home.adapter.suboperate.adapter.k kVar2 = this.f52159j;
        if (kVar2 != null) {
            RankingListData rankingListData = operateItem.getRankingListData();
            kVar2.w0(rankingListData != null ? rankingListData.getItems() : null);
        }
        com.transsion.home.adapter.suboperate.adapter.k kVar3 = this.f52159j;
        if (kVar3 != null) {
            kVar3.B0(new f9.d() { // from class: com.transsion.home.adapter.suboperate.provider.x
                @Override // f9.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i12) {
                    SubRankListProvider.F(this.f52214a, recyclerView2, recyclerView, baseQuickAdapter, view, i12);
                }
            });
        }
        recyclerView.setAdapter(this.f52159j);
        recyclerView.scrollToPosition(this.f52160k);
    }

    public final void H(RecyclerView recyclerView, int i11) {
        RecyclerView.m layoutManager = recyclerView.getLayoutManager();
        View viewFindViewByPosition = layoutManager != null ? layoutManager.findViewByPosition(i11) : null;
        if (viewFindViewByPosition == null) {
            recyclerView.scrollToPosition(i11);
        } else {
            recyclerView.scrollBy(viewFindViewByPosition.getLeft() - ((recyclerView.getWidth() / 2) - (viewFindViewByPosition.getWidth() / 2)), 0);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return PostItemType.RANKING_LIST.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_sub_operation_rank_list;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void p(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.p(holder);
        G();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void q(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.q(holder);
        I();
    }
}
