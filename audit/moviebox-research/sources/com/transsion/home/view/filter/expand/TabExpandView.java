package com.transsion.home.view.filter.expand;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.gms.common.api.Api;
import com.tn.lib.widget.R$color;
import com.transsion.home.R$drawable;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.g;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import lt.z;

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
public final class TabExpandView extends FrameLayout {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f52708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<st.a> f52709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<Integer, List<st.a>> f52710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, Integer> f52711d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super st.a, Unit> f52712f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public st.a f52713g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f52714h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TabExpandView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TabExpandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabExpandView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        z zVarC = z.c(LayoutInflater.from(getContext()), this, true);
        Intrinsics.f(zVarC, "inflate(LayoutInflater.from(context), this, true)");
        this.f52708a = zVarC;
        this.f52709b = new ArrayList();
        this.f52710c = new LinkedHashMap();
        this.f52711d = new LinkedHashMap();
        this.f52714h = -1;
        this.f52708a.f70538c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.view.filter.expand.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TabExpandView.e(this.f52716a, view);
            }
        });
    }

    public static final void e(TabExpandView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        AppCompatTextView appCompatTextView = this$0.f52708a.f70538c;
        appCompatTextView.setSelected(!appCompatTextView.isSelected());
        if (this$0.f52708a.f70538c.isSelected()) {
            this$0.expand();
        } else {
            this$0.collapse();
        }
    }

    public static /* synthetic */ View g(TabExpandView tabExpandView, st.a aVar, View view, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            view = null;
        }
        return tabExpandView.f(aVar, view);
    }

    public static final void h(TabExpandView this$0, st.a item, View view, View view2) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(item, "$item");
        Intrinsics.g(view, "$view");
        this$0.m(item);
        this$0.f(item, view);
        Function1<? super st.a, Unit> function1 = this$0.f52712f;
        if (function1 != null) {
            function1.invoke(item);
        }
    }

    public static final void j(TabExpandView this$0) {
        Intrinsics.g(this$0, "this$0");
        int rowsCount = this$0.f52708a.f70537b.getRowsCount();
        int i11 = 0;
        for (int i12 = 0; i12 < rowsCount; i12++) {
            ArrayList arrayList = new ArrayList();
            int countInRow = this$0.f52708a.f70537b.getCountInRow(i12);
            int i13 = 0;
            while (i13 < countInRow) {
                int i14 = i11 + 1;
                st.a aVar = this$0.f52709b.get(i11);
                this$0.f52711d.put(aVar.c(), Integer.valueOf(i12));
                arrayList.add(aVar);
                i13++;
                i11 = i14;
            }
            this$0.f52710c.put(Integer.valueOf(i12), arrayList);
        }
        if (this$0.f52710c.size() > 1) {
            AppCompatTextView appCompatTextView = this$0.f52708a.f70538c;
            Intrinsics.f(appCompatTextView, "binding.tvExpand");
            so.c.k(appCompatTextView);
        } else {
            AppCompatTextView appCompatTextView2 = this$0.f52708a.f70538c;
            Intrinsics.f(appCompatTextView2, "binding.tvExpand");
            so.c.h(appCompatTextView2);
        }
    }

    public static final void k(TabExpandView this$0) {
        Intrinsics.g(this$0, "this$0");
        Map<String, Integer> map = this$0.f52711d;
        st.a aVar = this$0.f52713g;
        List<st.a> list = this$0.f52710c.get(map.get(aVar != null ? aVar.c() : null));
        if (list == null) {
            list = this$0.f52709b;
        }
        this$0.l(list);
    }

    public final void collapse() {
        this.f52708a.f70537b.setMaxRows(1);
        this.f52708a.f70538c.setSelected(false);
        this.f52708a.f70537b.post(new Runnable() { // from class: com.transsion.home.view.filter.expand.c
            @Override // java.lang.Runnable
            public final void run() {
                TabExpandView.k(this.f52717a);
            }
        });
    }

    public final void enableExpand(boolean z11) {
        this.f52708a.f70538c.setEnabled(z11);
    }

    public final void expand() {
        this.f52708a.f70537b.setMaxRows(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        this.f52708a.f70538c.setSelected(true);
        l(this.f52709b);
    }

    public final View f(final st.a aVar, final View view) {
        Typeface typefaceDefaultFromStyle;
        if (view == null) {
            view = i9.a.a(this, R$layout.adapter_filter_item);
        }
        TextView textView = (TextView) view.findViewById(R$id.filter_item_name);
        textView.setText(aVar.a());
        if (aVar.d()) {
            this.f52713g = aVar;
            textView.setBackgroundResource(R$drawable.bg_selected_filter_item);
            textView.setTextColor(z2.a.getColor(textView.getContext(), R$color.text_01));
            typefaceDefaultFromStyle = Typeface.defaultFromStyle(1);
        } else {
            textView.setBackgroundResource(R$color.transparent);
            textView.setTextColor(z2.a.getColor(textView.getContext(), R$color.text_02));
            typefaceDefaultFromStyle = Typeface.defaultFromStyle(0);
        }
        textView.setTypeface(typefaceDefaultFromStyle);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.view.filter.expand.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TabExpandView.h(this.f52718a, aVar, view, view2);
            }
        });
        return view;
    }

    public final z getBinding() {
        return this.f52708a;
    }

    public final int getInParentIndex() {
        return this.f52714h;
    }

    public final void i() {
        this.f52708a.f70537b.post(new Runnable() { // from class: com.transsion.home.view.filter.expand.a
            @Override // java.lang.Runnable
            public final void run() {
                TabExpandView.j(this.f52715a);
            }
        });
    }

    public final void l(List<st.a> list) {
        int childCount = this.f52708a.f70537b.getChildCount();
        int i11 = 0;
        if (list.size() <= childCount) {
            while (i11 < childCount) {
                View tabView = this.f52708a.f70537b.getChildAt(i11);
                if (i11 < list.size()) {
                    Intrinsics.f(tabView, "tabView");
                    so.c.k(tabView);
                    f(list.get(i11), tabView);
                } else {
                    Intrinsics.f(tabView, "tabView");
                    so.c.g(tabView);
                }
                i11++;
            }
            return;
        }
        this.f52708a.f70537b.removeAllViews();
        for (Object obj : list) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                g.u();
            }
            st.a aVar = (st.a) obj;
            View childAt = this.f52708a.f70537b.getChildAt(i11);
            if (childAt != null) {
                f(aVar, childAt);
            } else {
                this.f52708a.f70537b.addView(g(this, aVar, null, 2, null));
            }
            i11 = i12;
        }
    }

    public final void m(st.a aVar) {
        for (st.a aVar2 : this.f52709b) {
            aVar2.e(Intrinsics.b(aVar2, aVar));
        }
        this.f52713g = aVar;
    }

    public final void setBinding(z zVar) {
        Intrinsics.g(zVar, "<set-?>");
        this.f52708a = zVar;
    }

    public final void setInParentIndex(int i11) {
        this.f52714h = i11;
    }

    public final void setOnItemClickListener(Function1<? super st.a, Unit> onItemClickListener) {
        Intrinsics.g(onItemClickListener, "onItemClickListener");
        this.f52712f = onItemClickListener;
    }

    public final void updateData(List<st.a> list) {
        Intrinsics.g(list, "list");
        this.f52709b = list;
        this.f52710c.clear();
        this.f52711d.clear();
        l(list);
        i();
    }
}
