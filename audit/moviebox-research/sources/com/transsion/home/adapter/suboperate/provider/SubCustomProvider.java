package com.transsion.home.adapter.suboperate.provider;

import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.adapter.suboperate.adapter.SubCustomAdapter;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.BannerData;
import com.transsion.moviedetailapi.bean.CustomData;
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

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class SubCustomProvider extends BaseItemProvider<OperateItem> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f52114f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f52115g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f52116h = LazyKt__LazyJVMKt.b(new Function0<SubCustomProvider$customRecycledViewPool$2.a>() { // from class: com.transsion.home.adapter.suboperate.provider.SubCustomProvider$customRecycledViewPool$2

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a extends RecyclerView.s {
            public a() {
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

    public SubCustomProvider(int i11, boolean z11) {
        this.f52114f = i11;
        this.f52115g = z11;
    }

    public static final void w(OperateItem item, SubCustomProvider this$0, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        List<BannerData> items;
        BannerData bannerData;
        Intrinsics.g(item, "$item");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "<anonymous parameter 1>");
        CustomData customData = item.getCustomData();
        if (customData == null || (items = customData.getItems()) == null || (bannerData = items.get(i11)) == null) {
            return;
        }
        this$0.A(bannerData);
        this$0.z(bannerData, i11, item);
    }

    public final void A(BannerData bannerData) {
        String deepLink = bannerData.getDeepLink();
        if (deepLink != null) {
            Uri uriD = com.transsion.baselib.helper.b.f51184a.d(Uri.parse(deepLink + "&module_name=opt_custom&ops=" + bannerData.getOps()));
            if (uriD != null) {
                com.alibaba.android.arouter.launcher.a.d().a(uriD).navigation();
            }
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return PostItemType.CUSTOM_DATA.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_sub_operation_variable;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void q(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.q(holder);
        RecyclerView recyclerView = (RecyclerView) holder.getView(R$id.sub_operation_variable_recycle);
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            RecyclerView.m layoutManager = recyclerView.getLayoutManager();
            Intrinsics.e(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            ((LinearLayoutManager) layoutManager).setRecycleChildrenOnDetach(true);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, final OperateItem item) {
        List items;
        List<BannerData> items2;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        ((TextView) helper.getView(R$id.sub_operation_variable_title)).setText(item.getTitle());
        RecyclerView recyclerView = (RecyclerView) helper.getView(R$id.sub_operation_variable_recycle);
        int i11 = 0;
        CustomData customData = item.getCustomData();
        CustomData customData2 = item.getCustomData();
        SubCustomAdapter subCustomAdapter = new SubCustomAdapter(i11, item, customData, (customData2 == null || (items2 = customData2.getItems()) == null) ? null : items2.get(0), this.f52114f, this.f52115g, 1, null);
        recyclerView.setAdapter(subCustomAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(g(), 0, false));
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new ro.e(8.0f, 0.0f, 12.0f, 2, null));
        }
        if (!Intrinsics.b(recyclerView.getRecycledViewPool(), x())) {
            recyclerView.setRecycledViewPool(x());
        }
        CustomData customData3 = item.getCustomData();
        subCustomAdapter.w0((customData3 == null || (items = customData3.getItems()) == null) ? new ArrayList() : items);
        subCustomAdapter.B0(new f9.d() { // from class: com.transsion.home.adapter.suboperate.provider.e
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i12) {
                SubCustomProvider.w(item, this, baseQuickAdapter, view, i12);
            }
        });
        y(item);
    }

    public final SubCustomProvider$customRecycledViewPool$2.a x() {
        return (SubCustomProvider$customRecycledViewPool$2.a) this.f52116h.getValue();
    }

    public final void y(OperateItem operateItem) {
        String title;
        String opId;
        HashMap map = new HashMap();
        map.put("event_type", "browse_custom");
        String str = "";
        if (operateItem == null || (title = operateItem.getTitle()) == null) {
            title = "";
        }
        map.put(CampaignEx.JSON_KEY_TITLE, title);
        if (operateItem != null && (opId = operateItem.getOpId()) != null) {
            str = opId;
        }
        map.put("opId", str);
        map.put("tabId", String.valueOf(this.f52114f));
        if (operateItem != null) {
            ot.b.a(operateItem, map);
        }
        com.transsion.baselib.helper.a.f51183a.d(SubTabFragment.f52541r.a(this.f52114f), map);
    }

    public final void z(BannerData bannerData, int i11, OperateItem operateItem) {
        HashMap map = new HashMap();
        map.put("event_type", "click_custom_item");
        map.put("sequence", String.valueOf(i11));
        CustomData customData = operateItem.getCustomData();
        map.put("rowCount", String.valueOf(customData != null ? Integer.valueOf(customData.getRowCount()) : null));
        map.put("tabId", String.valueOf(this.f52114f));
        if (bannerData != null) {
            ot.b.b(bannerData, map);
        }
        ot.b.a(operateItem, map);
        com.transsion.baselib.helper.a.f51183a.e(SubTabFragment.f52541r.a(this.f52114f), map);
    }
}
