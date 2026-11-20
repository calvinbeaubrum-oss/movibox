package com.transsion.moviedetail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.widget.R$string;
import com.transsion.moviedetailapi.bean.ResourcesSeason;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class DetailSeasonTabView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f53798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2<? super Integer, ? super ResourcesSeason, Unit> f53799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f53800c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DetailSeasonTabView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DetailSeasonTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailSeasonTabView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f53800c = -1;
        b();
    }

    private final void b() {
        o oVar = new o();
        oVar.B0(new f9.d() { // from class: com.transsion.moviedetail.view.a
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                DetailSeasonTabView.c(this.f53823a, baseQuickAdapter, view, i11);
            }
        });
        this.f53798a = oVar;
        setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        addItemDecoration(new ro.c(gs.a.a(12)));
        setAdapter(this.f53798a);
    }

    public static final void c(DetailSeasonTabView this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (com.transsion.baseui.util.c.f51452a.a(999001, 500L) || i11 == this$0.f53800c) {
            return;
        }
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(R$string.no_network_tips);
        } else {
            this$0.d(adapter, i11, true);
            this$0.smoothScrollToPosition(i11);
        }
    }

    public final void d(BaseQuickAdapter<?, ?> baseQuickAdapter, int i11, boolean z11) {
        Function2<? super Integer, ? super ResourcesSeason, Unit> function2;
        try {
            Object item = baseQuickAdapter.getItem(this.f53800c);
            ResourcesSeason resourcesSeason = item instanceof ResourcesSeason ? (ResourcesSeason) item : null;
            if (resourcesSeason != null) {
                resourcesSeason.setSelected(false);
            }
            baseQuickAdapter.notifyItemChanged(this.f53800c, Boolean.FALSE);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        Object item2 = baseQuickAdapter.getItem(i11);
        ResourcesSeason resourcesSeason2 = item2 instanceof ResourcesSeason ? (ResourcesSeason) item2 : null;
        if (resourcesSeason2 != null) {
            resourcesSeason2.setSelected(true);
        }
        baseQuickAdapter.notifyItemChanged(i11, Boolean.TRUE);
        if (resourcesSeason2 != null) {
            this.f53800c = i11;
            if (!z11 || (function2 = this.f53799b) == null) {
                return;
            }
            function2.invoke(Integer.valueOf(i11), resourcesSeason2);
        }
    }

    public final void selectSeason(int i11) {
        o oVar;
        List<ResourcesSeason> listD;
        o oVar2 = this.f53798a;
        if (oVar2 == null) {
            return;
        }
        int i12 = -1;
        if (oVar2 != null && (listD = oVar2.D()) != null) {
            Iterator<ResourcesSeason> it = listD.iterator();
            int i13 = 0;
            while (it.hasNext()) {
                if (it.next().getSe() == i11) {
                    i12 = i13;
                    break;
                }
                i13++;
            }
        }
        if (i12 >= 0 && (oVar = this.f53798a) != null) {
            d(oVar, i12, false);
        }
    }

    public final void setContentData(List<ResourcesSeason> list, Integer num) {
        Unit unit;
        Intrinsics.g(list, "list");
        this.f53800c = 0;
        Iterator<T> it = list.iterator();
        if (it.hasNext()) {
            ((ResourcesSeason) it.next()).setSelected(true);
            unit = Unit.f68710a;
        } else {
            unit = null;
        }
        if (unit == null) {
            throw new NoSuchElementException("No element of the collection was transformed to a non-null value.");
        }
        o oVar = this.f53798a;
        if (oVar != null) {
            oVar.I0(num);
        }
        o oVar2 = this.f53798a;
        if (oVar2 != null) {
            oVar2.w0(list);
        }
    }

    public final void setItemClickListener(Function2<? super Integer, ? super ResourcesSeason, Unit> listener) {
        Intrinsics.g(listener, "listener");
        this.f53799b = listener;
    }
}
