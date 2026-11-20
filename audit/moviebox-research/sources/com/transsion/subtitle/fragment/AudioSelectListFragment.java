package com.transsion.subtitle.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.subtitle.R$string;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class AudioSelectListFragment extends SubtitleBaseFragment<wx.c> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f58156m = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DownloadBean f58158i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ux.a f58159j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public xx.b f58161l;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<DubsInfo> f58157h = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f58160k = -1;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AudioSelectListFragment a(List<DubsInfo> list, DownloadBean downloadBean, String str) {
            Intrinsics.g(list, "list");
            AudioSelectListFragment audioSelectListFragment = new AudioSelectListFragment();
            audioSelectListFragment.r0(list, downloadBean);
            audioSelectListFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("KEY_PAGE_NAME", str)));
            return audioSelectListFragment;
        }
    }

    public static final void p0(AudioSelectListFragment this$0, ux.a this_apply, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "<anonymous parameter 1>");
        if (i11 == this$0.f58160k) {
            return;
        }
        DubsInfo dubsInfo = this$0.f58157h.get(i11);
        int i12 = this$0.f58160k;
        if (i12 >= 0) {
            this$0.f58157h.get(i12).setSelected(false);
            adapter.notifyItemChanged(this$0.f58160k);
        }
        this$0.f58160k = i11;
        dubsInfo.setSelected(true);
        adapter.notifyItemChanged(i11);
        uo.b.a aVar = uo.b.f78622a;
        String TAG = this$0.h0();
        Intrinsics.f(TAG, "TAG");
        aVar.c(TAG, "item select, " + dubsInfo.getLanName() + ", code = " + dubsInfo.getLanCode(), true);
        xx.b bVar = this$0.f58161l;
        if (bVar != null) {
            bVar.g(dubsInfo);
        }
        xx.b bVar2 = this$0.f58161l;
        if (bVar2 != null) {
            String string = this_apply.getContext().getString(R$string.audio_switch_toast);
            Intrinsics.f(string, "context.getString(R.string.audio_switch_toast)");
            bVar2.c(string);
        }
        this$0.g0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        RecyclerView recyclerView;
        Intrinsics.g(view, "view");
        final ux.a aVar = new ux.a(this.f58157h);
        aVar.B0(new f9.d() { // from class: com.transsion.subtitle.fragment.a
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i11) {
                AudioSelectListFragment.p0(this.f58226a, aVar, baseQuickAdapter, view2, i11);
            }
        });
        this.f58159j = aVar;
        wx.c cVar = (wx.c) getMViewBinding();
        if (cVar == null || (recyclerView = cVar.f79673b) == null) {
            return;
        }
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(this.f58159j);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public wx.c getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        wx.c cVarC = wx.c.c(inflater);
        Intrinsics.f(cVarC, "inflate(inflater)");
        return cVarC;
    }

    public final void q0(xx.b bVar) {
        this.f58161l = bVar;
    }

    public final void r0(List<DubsInfo> list, DownloadBean downloadBean) {
        this.f58158i = downloadBean;
        this.f58157h.clear();
        this.f58157h.addAll(list);
        int size = this.f58157h.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.f58157h.get(i11).isSelected()) {
                this.f58160k = i11;
                return;
            }
        }
    }
}
