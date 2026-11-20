package com.transsion.home.view.filter.expand;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewGroupKt;
import androidx.lifecycle.c0;
import com.transsion.home.bean.FilterVal;
import com.transsion.home.bean.Item;
import com.transsion.home.viewmodel.MovieViewModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.g;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.l;

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
@SourceDebugExtension
public class FilterExpandView extends LinearLayoutCompat {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f52705q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public MovieViewModel f52706r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Function1<? super st.a, Unit> f52707s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterExpandView(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        setOrientation(1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterExpandView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.g(context, "context");
        Intrinsics.g(attrs, "attrs");
        setOrientation(1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterExpandView(Context context, AttributeSet attrs, int i11) {
        super(context, attrs, i11);
        Intrinsics.g(context, "context");
        Intrinsics.g(attrs, "attrs");
        setOrientation(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateList$default(FilterExpandView filterExpandView, List list, HashMap map, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateList");
        }
        if ((i11 & 2) != 0) {
            map = null;
        }
        filterExpandView.updateList(list, map);
    }

    public final void expandFilter(int i11) {
        TabExpandView tabExpandView;
        int i12 = 0;
        for (View view : ViewGroupKt.getChildren(this)) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                g.u();
            }
            View view2 = view;
            if (i12 != i11) {
                tabExpandView = view2 instanceof TabExpandView ? (TabExpandView) view2 : null;
                if (tabExpandView != null) {
                    tabExpandView.collapse();
                }
            } else {
                tabExpandView = view2 instanceof TabExpandView ? (TabExpandView) view2 : null;
                if (tabExpandView != null) {
                    tabExpandView.expand();
                }
            }
            i12 = i13;
        }
    }

    public final boolean getHasInit() {
        return this.f52705q;
    }

    public final MovieViewModel getMovieModel() {
        return this.f52706r;
    }

    public final Function1<st.a, Unit> getReportEvent() {
        return this.f52707s;
    }

    public final void setHasInit(boolean z11) {
        this.f52705q = z11;
    }

    public final void setMovieModel(MovieViewModel movieViewModel) {
        this.f52706r = movieViewModel;
    }

    public final void setReportEvent(Function1<? super st.a, Unit> function1) {
        this.f52707s = function1;
    }

    public final void u(int i11, List<st.a> list) {
        Context context = getContext();
        Intrinsics.f(context, "context");
        final TabExpandView tabExpandView = new TabExpandView(context);
        tabExpandView.enableExpand(true);
        tabExpandView.updateData(list);
        tabExpandView.setInParentIndex(i11);
        tabExpandView.setOnItemClickListener(new Function1<st.a, Unit>() { // from class: com.transsion.home.view.filter.expand.FilterExpandView$createTabs$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(st.a aVar) {
                invoke2(aVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(st.a item) {
                Intrinsics.g(item, "item");
                this.this$0.expandFilter(tabExpandView.getInParentIndex() + 1);
                MovieViewModel movieModel = this.this$0.getMovieModel();
                c0<st.a> c0VarJ = movieModel != null ? movieModel.j() : null;
                if (c0VarJ != null) {
                    c0VarJ.q(item);
                }
                Function1<st.a, Unit> reportEvent = this.this$0.getReportEvent();
                if (reportEvent != null) {
                    reportEvent.invoke(item);
                }
            }
        });
        addView(tabExpandView);
    }

    public final void updateList(List<Item> data, HashMap<String, String> map) {
        Intrinsics.g(data, "data");
        this.f52705q = true;
        int childCount = getChildCount();
        int i11 = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            Intrinsics.e(childAt, "null cannot be cast to non-null type com.transsion.home.view.filter.expand.TabExpandView");
            TabExpandView tabExpandView = (TabExpandView) childAt;
            if (i11 < data.size()) {
                so.c.k(tabExpandView);
                tabExpandView.setInParentIndex(i11);
                tabExpandView.updateData(v(data.get(i11).getFilterType(), data.get(i11).getFilterValsV2(), map != null ? map.get(data.get(i11).getFilterType()) : null));
            } else {
                so.c.g(tabExpandView);
            }
            i11++;
        }
        if (data.size() > getChildCount()) {
            int size = data.size();
            for (int childCount2 = getChildCount(); childCount2 < size; childCount2++) {
                u(childCount2, v(data.get(childCount2).getFilterType(), data.get(childCount2).getFilterValsV2(), map != null ? map.get(data.get(childCount2).getFilterType()) : null));
            }
        }
    }

    public final List<st.a> v(String str, List<FilterVal> list, String str2) {
        ArrayList arrayList = new ArrayList();
        if (str2 == null) {
            str2 = ((FilterVal) CollectionsKt___CollectionsKt.e0(list)).getName();
        }
        for (FilterVal filterVal : list) {
            arrayList.add(new st.a(filterVal.getId(), filterVal.getName(), str, l.v(str2, filterVal.getName(), true), null, 16, null));
        }
        return arrayList;
    }
}
