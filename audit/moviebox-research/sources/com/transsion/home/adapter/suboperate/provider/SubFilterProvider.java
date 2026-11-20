package com.transsion.home.adapter.suboperate.provider;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.adapter.suboperate.adapter.SubFilterAdapter;
import com.transsion.moviedetailapi.bean.FilterItem;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.ArrayList;
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
public final class SubFilterProvider extends BaseItemProvider<OperateItem> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f52127f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f52128g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f52129h = LazyKt__LazyJVMKt.b(new Function0<SubFilterProvider$customRecycledViewPool$2.a>() { // from class: com.transsion.home.adapter.suboperate.provider.SubFilterProvider$customRecycledViewPool$2

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a extends RecyclerView.s {
            public a() {
                m(0, 4);
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

    public SubFilterProvider(Integer num, boolean z11) {
        this.f52127f = num;
        this.f52128g = z11;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return PostItemType.FILTER.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_sub_operation_filter;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, OperateItem item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        List<FilterItem> filters = item.getFilters();
        if (filters == null) {
            filters = new ArrayList<>();
        }
        if (filters.isEmpty()) {
            View view = helper.itemView;
            Intrinsics.f(view, "helper.itemView");
            so.c.g(view);
            return;
        }
        View view2 = helper.itemView;
        Intrinsics.f(view2, "helper.itemView");
        so.c.k(view2);
        TextView textView = (TextView) helper.getView(R$id.sub_operation_filter_title);
        String title = item.getTitle();
        if (title == null || title.length() == 0) {
            so.c.g(textView);
        } else {
            textView.setText(item.getTitle());
            so.c.k(textView);
        }
        RecyclerView recyclerView = (RecyclerView) helper.itemView.findViewById(R$id.sub_operation_filter_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(g(), 0, false));
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new ro.e(8.0f, 0.0f, 12.0f, 2, null));
        }
        if (!Intrinsics.b(recyclerView.getRecycledViewPool(), v())) {
            recyclerView.setRecycledViewPool(v());
        }
        SubFilterAdapter subFilterAdapter = new SubFilterAdapter(0, this.f52127f, item, this.f52128g, 1, null);
        subFilterAdapter.w0(filters);
        recyclerView.setAdapter(subFilterAdapter);
    }

    public final SubFilterProvider$customRecycledViewPool$2.a v() {
        return (SubFilterProvider$customRecycledViewPool$2.a) this.f52129h.getValue();
    }
}
