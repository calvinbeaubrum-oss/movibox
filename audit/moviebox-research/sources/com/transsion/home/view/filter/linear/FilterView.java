package com.transsion.home.view.filter.linear;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.HorizontalRecyclerview;
import com.transsion.home.R$layout;
import com.transsion.home.bean.FilterVal;
import com.transsion.home.bean.Item;
import com.transsion.home.view.filter.linear.FilterView;
import com.transsion.home.viewmodel.MovieViewModel;
import f9.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.g;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import so.c;

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
public class FilterView extends LinearLayoutCompat {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f52721q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public MovieViewModel f52722r;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends DiffUtil.e<st.a> {
        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(st.a oldItem, st.a newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return Intrinsics.b(oldItem.c(), newItem.c());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(st.a oldItem, st.a newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return Intrinsics.b(oldItem.b(), newItem.b());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterView(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        setOrientation(1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.g(context, "context");
        Intrinsics.g(attrs, "attrs");
        setOrientation(1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterView(Context context, AttributeSet attrs, int i11) {
        super(context, attrs, i11);
        Intrinsics.g(context, "context");
        Intrinsics.g(attrs, "attrs");
        setOrientation(1);
    }

    public static /* synthetic */ void createTabs$default(FilterView filterView, List list, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createTabs");
        }
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        filterView.createTabs(list, i11);
    }

    public static final void v(FilterView this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        int i12 = 0;
        for (Object obj : adapter.D()) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                g.u();
            }
            if (obj instanceof st.a) {
                ((st.a) obj).e(i12 == i11);
                if (i12 == i11) {
                    MovieViewModel movieViewModel = this$0.f52722r;
                    LiveData liveDataJ = movieViewModel != null ? movieViewModel.j() : null;
                    if (liveDataJ != null) {
                        liveDataJ.q(obj);
                    }
                }
            }
            i12 = i13;
        }
        adapter.notifyDataSetChanged();
    }

    public final void createTabs(List<st.a> datas, int i11) {
        Intrinsics.g(datas, "datas");
        Context context = getContext();
        Intrinsics.f(context, "context");
        HorizontalRecyclerview horizontalRecyclerview = new HorizontalRecyclerview(context);
        horizontalRecyclerview.setLayoutParams(new LinearLayoutCompat.a(-1, -2));
        horizontalRecyclerview.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        tt.a aVar = new tt.a(R$layout.adapter_filter_item, datas);
        aVar.B0(new d() { // from class: tt.b
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i12) {
                FilterView.v(this.f77425a, baseQuickAdapter, view, i12);
            }
        });
        aVar.o0(new a());
        horizontalRecyclerview.setAdapter(aVar);
        y(horizontalRecyclerview, i11, datas.size());
        addView(horizontalRecyclerview);
    }

    public final boolean getHasInit() {
        return this.f52721q;
    }

    public final MovieViewModel getMovieModel() {
        return this.f52722r;
    }

    public final void setDatas(List<Item> datas) {
        Intrinsics.g(datas, "datas");
        for (Item item : datas) {
            createTabs$default(this, w(item.getFilterType(), item.getFilterValsV2()), 0, 2, null);
        }
        this.f52721q = true;
    }

    public final void setHasInit(boolean z11) {
        this.f52721q = z11;
    }

    public final void setMovieModel(MovieViewModel movieViewModel) {
        this.f52722r = movieViewModel;
    }

    public final void updateDatas(List<Item> datas) {
        Intrinsics.g(datas, "datas");
        if (datas.size() > getChildCount()) {
            int size = datas.size();
            for (int childCount = getChildCount(); childCount < size; childCount++) {
                createTabs$default(this, w(datas.get(childCount).getFilterType(), datas.get(childCount).getFilterValsV2()), 0, 2, null);
            }
            return;
        }
        int childCount2 = getChildCount();
        for (int i11 = 0; i11 < childCount2; i11++) {
            View childAt = getChildAt(i11);
            Intrinsics.e(childAt, "null cannot be cast to non-null type com.tn.lib.view.HorizontalRecyclerview");
            HorizontalRecyclerview horizontalRecyclerview = (HorizontalRecyclerview) childAt;
            if (i11 < datas.size()) {
                c.k(horizontalRecyclerview);
                RecyclerView.Adapter adapter = horizontalRecyclerview.getAdapter();
                Intrinsics.e(adapter, "null cannot be cast to non-null type com.transsion.home.view.filter.linear.FilterItemAdapter");
                ((tt.a) adapter).x0(w(datas.get(i11).getFilterType(), datas.get(i11).getFilterValsV2()));
                horizontalRecyclerview.scrollToPosition(0);
            } else {
                c.g(horizontalRecyclerview);
            }
        }
    }

    public final void updateSelectedFilterItems(List<Item> datas, HashMap<String, String> map) {
        Intrinsics.g(datas, "datas");
        this.f52721q = true;
        if (datas.size() > getChildCount()) {
            int size = datas.size();
            for (int childCount = getChildCount(); childCount < size; childCount++) {
                Pair<Integer, List<st.a>> pairX = x(datas.get(childCount).getFilterType(), datas.get(childCount).getFilterValsV2(), map != null ? map.get(datas.get(childCount).getFilterType()) : null);
                createTabs(pairX.getSecond(), pairX.getFirst().intValue());
            }
            return;
        }
        int childCount2 = getChildCount();
        for (int i11 = 0; i11 < childCount2; i11++) {
            View childAt = getChildAt(i11);
            Intrinsics.e(childAt, "null cannot be cast to non-null type com.tn.lib.view.HorizontalRecyclerview");
            HorizontalRecyclerview horizontalRecyclerview = (HorizontalRecyclerview) childAt;
            if (i11 < datas.size()) {
                c.k(horizontalRecyclerview);
                Pair<Integer, List<st.a>> pairX2 = x(datas.get(i11).getFilterType(), datas.get(i11).getFilterValsV2(), map != null ? map.get(datas.get(i11).getFilterType()) : null);
                RecyclerView.Adapter adapter = horizontalRecyclerview.getAdapter();
                Intrinsics.e(adapter, "null cannot be cast to non-null type com.transsion.home.view.filter.linear.FilterItemAdapter");
                ((tt.a) adapter).x0(pairX2.getSecond());
                y(horizontalRecyclerview, pairX2.getFirst().intValue(), datas.size());
            } else {
                c.g(horizontalRecyclerview);
            }
        }
    }

    public final List<st.a> w(String str, List<FilterVal> list) {
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        for (Object obj : list) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                g.u();
            }
            FilterVal filterVal = (FilterVal) obj;
            arrayList.add(new st.a(filterVal.getId(), filterVal.getName(), str, i11 == 0, null, 16, null));
            i11 = i12;
        }
        return arrayList;
    }

    public final Pair<Integer, List<st.a>> x(String str, List<FilterVal> list, String str2) {
        String lowerCase;
        st.a aVar;
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        int i12 = 0;
        for (Object obj : list) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                g.u();
            }
            FilterVal filterVal = (FilterVal) obj;
            String id2 = filterVal.getId();
            Locale locale = Locale.ROOT;
            String lowerCase2 = id2.toLowerCase(locale);
            Intrinsics.f(lowerCase2, "toLowerCase(...)");
            if (str2 != null) {
                lowerCase = str2.toLowerCase(locale);
                Intrinsics.f(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            if (Intrinsics.b(lowerCase2, lowerCase)) {
                aVar = new st.a(filterVal.getId(), filterVal.getName(), str, true, null, 16, null);
            } else {
                i12 = i11;
                aVar = new st.a(filterVal.getId(), filterVal.getName(), str, false, null, 16, null);
            }
            arrayList.add(aVar);
            i11 = i12;
            i12 = i13;
        }
        return new Pair<>(Integer.valueOf(i11), arrayList);
    }

    public final void y(HorizontalRecyclerview horizontalRecyclerview, int i11, int i12) {
        if (i11 > 5 || i11 < i12 - 3) {
            horizontalRecyclerview.scrollToPosition(i11 - 3);
        } else {
            horizontalRecyclerview.scrollToPosition(i11);
        }
    }
}
