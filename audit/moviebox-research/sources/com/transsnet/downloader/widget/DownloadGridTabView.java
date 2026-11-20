package com.transsnet.downloader.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsnet.downloader.R$layout;
import h00.r0;
import java.util.Iterator;
import java.util.List;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class DownloadGridTabView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r0 f61296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f61297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f61298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function2<? super Integer, ? super c, Unit> f61299d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadGridTabView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadGridTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadGridTabView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        View.inflate(getContext(), R$layout.layout_download_grid_tab, this);
        r0 r0VarA = r0.a(this);
        Intrinsics.f(r0VarA, "bind(this)");
        this.f61296a = r0VarA;
        final b bVar = new b();
        bVar.B0(new f9.d() { // from class: com.transsnet.downloader.widget.d
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i12) {
                DownloadGridTabView.c(bVar, this, baseQuickAdapter, view, i12);
            }
        });
        this.f61297b = bVar;
        RecyclerView recyclerView = r0VarA.f66007b;
        recyclerView.setLayoutManager(new NpaGridLayoutManager(recyclerView.getContext(), 4));
        recyclerView.addItemDecoration(new ro.a(gs.a.a(8), gs.a.a(8), 0, 0));
        recyclerView.setAdapter(this.f61297b);
    }

    public static final void c(b this_apply, DownloadGridTabView this$0, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "view");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 500L)) {
            return;
        }
        this$0.b(i11, this_apply.getItem(i11));
    }

    public final void b(int i11, c cVar) {
        int size = this.f61297b.D().size();
        int i12 = this.f61298c;
        if (size > i12) {
            this.f61297b.getItem(i12).c(false);
            this.f61297b.notifyItemChanged(this.f61298c, Boolean.FALSE);
        }
        if (this.f61297b.D().size() > i11) {
            cVar.c(true);
            this.f61297b.notifyItemChanged(i11, Boolean.TRUE);
        }
        Function2<? super Integer, ? super c, Unit> function2 = this.f61299d;
        if (function2 != null) {
            function2.invoke(Integer.valueOf(i11), cVar);
        }
    }

    public final void setDataList(List<c> dataList) {
        Intrinsics.g(dataList, "dataList");
        Iterator<c> it = dataList.iterator();
        int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                i11 = -1;
                break;
            } else if (it.next().b()) {
                break;
            } else {
                i11++;
            }
        }
        this.f61298c = i11;
        if (i11 < 0) {
            this.f61298c = 0;
        }
        this.f61297b.w0(dataList);
    }

    public final void setItemClickCallback(Function2<? super Integer, ? super c, Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f61299d = callback;
    }
}
