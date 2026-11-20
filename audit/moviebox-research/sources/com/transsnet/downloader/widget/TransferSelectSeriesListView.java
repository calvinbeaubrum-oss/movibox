package com.transsnet.downloader.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.adapter.g0;
import com.transsnet.downloader.util.DownloadUtil;
import com.transsnet.downloader.viewmodel.DownloadViewModel;
import h00.e1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class TransferSelectSeriesListView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f61364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e1 f61365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DownloadViewModel f61366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g0 f61367d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f61368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DownloadBean f61369g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f61370a;

        public a(Function1 function) {
            Intrinsics.g(function, "function");
            this.f61370a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f61370a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.lifecycle.d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f61370a.invoke(obj);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TransferSelectSeriesListView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TransferSelectSeriesListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransferSelectSeriesListView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f61364a = "TransferSelect-series";
        View.inflate(getContext(), R$layout.view_transfer_series_list, this);
        e1 e1VarA = e1.a(this);
        Intrinsics.f(e1VarA, "bind(this)");
        this.f61365b = e1VarA;
        Context context2 = getContext();
        Intrinsics.e(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        this.f61366c = (DownloadViewModel) new v0((FragmentActivity) context2).a(DownloadViewModel.class);
        setBackgroundResource(R$color.black_50);
        g();
        d();
        i();
    }

    public static final void e(TransferSelectSeriesListView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        so.c.g(this$0);
    }

    public static final void f(TransferSelectSeriesListView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        so.c.g(this$0);
    }

    public static final void h(TransferSelectSeriesListView this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        Object item = adapter.getItem(i11);
        this$0.k(item instanceof DownloadBean ? (DownloadBean) item : null, view, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDataList(DownloadBean downloadBean) {
        uo.b.a.f(uo.b.f78622a, this.f61364a, "setDataList size:" + downloadBean.getSeriesList().size(), false, 4, null);
        this.f61365b.f65829f.setText(downloadBean.getTitleName());
        g0 g0Var = this.f61367d;
        if (g0Var != null) {
            g0Var.w0(downloadBean.getSeriesList());
        }
    }

    public final void d() {
        this.f61365b.f65827c.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TransferSelectSeriesListView.e(this.f61376a, view);
            }
        });
        this.f61365b.f65830g.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TransferSelectSeriesListView.f(this.f61379a, view);
            }
        });
    }

    public final void g() {
        RecyclerView recyclerView = this.f61365b.f65828d;
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext()));
        g0 g0Var = new g0(new ArrayList());
        this.f61367d = g0Var;
        g0Var.B0(new f9.d() { // from class: com.transsnet.downloader.widget.e0
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                TransferSelectSeriesListView.h(this.f61381a, baseQuickAdapter, view, i11);
            }
        });
        recyclerView.setAdapter(g0Var);
    }

    public final void i() {
        androidx.lifecycle.c0<DownloadBean> c0VarX = this.f61366c.x();
        Context context = getContext();
        Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        c0VarX.j((FragmentActivity) context, new a(new Function1<DownloadBean, Unit>() { // from class: com.transsnet.downloader.widget.TransferSelectSeriesListView$initViewModel$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DownloadBean downloadBean) {
                invoke2(downloadBean);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadBean data) {
                this.this$0.f61369g = data;
                TransferSelectSeriesListView transferSelectSeriesListView = this.this$0;
                Intrinsics.f(data, "data");
                transferSelectSeriesListView.setDataList(data);
            }
        }));
        androidx.lifecycle.c0<Integer> c0VarG = this.f61366c.G();
        Context context2 = getContext();
        Intrinsics.e(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        c0VarG.j((FragmentActivity) context2, new a(new Function1<Integer, Unit>() { // from class: com.transsnet.downloader.widget.TransferSelectSeriesListView$initViewModel$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer index) {
                TransferSelectSeriesListView transferSelectSeriesListView = this.this$0;
                Intrinsics.f(index, "index");
                transferSelectSeriesListView.f61368f = index.intValue();
            }
        }));
    }

    public final boolean j(DownloadBean downloadBean) {
        List<DownloadBean> seriesList;
        boolean z11 = true;
        if (downloadBean != null && (seriesList = downloadBean.getSeriesList()) != null) {
            Iterator<T> it = seriesList.iterator();
            while (it.hasNext()) {
                if (!((DownloadBean) it.next()).isCheck()) {
                    z11 = false;
                }
            }
        }
        return z11;
    }

    public final void k(DownloadBean downloadBean, View view, int i11) {
        List<DownloadBean> seriesList;
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 500L)) {
            return;
        }
        this.f61366c.w().q(TransferBottomToolsView.STATUS_SEND);
        androidx.lifecycle.c0<List<DownloadBean>> c0VarB = this.f61366c.B(this.f61368f);
        Object obj = null;
        List<DownloadBean> listF = c0VarB != null ? c0VarB.f() : null;
        if (listF == null) {
            listF = new ArrayList<>();
        }
        boolean z11 = true;
        if (downloadBean == null || !downloadBean.isCheck()) {
            DownloadBean downloadBean2 = this.f61369g;
            if (downloadBean2 != null) {
                downloadBean2.setCheck(true);
            }
            if (downloadBean != null) {
                downloadBean.setCheck(true);
            }
            if (downloadBean != null) {
                for (Object obj2 : listF) {
                    String subjectId = ((DownloadBean) obj2).getSubjectId();
                    DownloadBean downloadBean3 = this.f61369g;
                    if (Intrinsics.b(subjectId, downloadBean3 != null ? downloadBean3.getSubjectId() : null)) {
                        obj = obj2;
                        break;
                    }
                }
                if (obj == null) {
                    uo.b.a.f(uo.b.f78622a, this.f61364a, "onItemCheckClick 当前不在livedata中", false, 4, null);
                    DownloadBean downloadBean4 = this.f61369g;
                    if (downloadBean4 != null) {
                        listF.add(downloadBean4);
                    }
                }
                DownloadBean downloadBean5 = this.f61369g;
                if (downloadBean5 != null) {
                    downloadBean5.setSeriesAllCheck(j(downloadBean5));
                }
                androidx.lifecycle.c0<List<DownloadBean>> c0VarB2 = this.f61366c.B(this.f61368f);
                if (c0VarB2 != null) {
                    c0VarB2.q(listF);
                }
            }
        } else {
            downloadBean.setCheck(false);
            DownloadBean downloadBean6 = this.f61369g;
            if (downloadBean6 != null && (seriesList = downloadBean6.getSeriesList()) != null) {
                for (Object obj3 : seriesList) {
                    if (((DownloadBean) obj3).isCheck()) {
                        obj = obj3;
                        break;
                    }
                }
                if (((DownloadBean) obj) != null) {
                    z11 = false;
                }
            }
            DownloadBean downloadBean7 = this.f61369g;
            if (downloadBean7 != null) {
                downloadBean7.setSeriesAllCheck(false);
            }
            if (z11) {
                DownloadBean downloadBean8 = this.f61369g;
                if (downloadBean8 != null) {
                    downloadBean8.setCheck(false);
                }
                uo.b.a.f(uo.b.f78622a, this.f61364a, "onItemCheckClick 所有都被取消，移除整个数据", false, 4, null);
                TypeIntrinsics.a(listF).remove(this.f61369g);
                androidx.lifecycle.c0<List<DownloadBean>> c0VarB3 = this.f61366c.B(this.f61368f);
                if (c0VarB3 != null) {
                    c0VarB3.q(listF);
                }
            }
        }
        uo.b.a.f(uo.b.f78622a, this.f61364a, "onItemCheckClick selectedList size:" + listF.size(), false, 4, null);
        this.f61366c.E().q(this.f61369g);
        this.f61366c.D().q(Integer.valueOf(DownloadUtil.f61136a.n(listF)));
        g0 g0Var = this.f61367d;
        if (g0Var != null) {
            g0Var.notifyItemChanged(i11, downloadBean);
        }
    }

    public final void setVisibilityWitchAnima(boolean z11) {
    }
}
