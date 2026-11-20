package com.transsion.home.adapter.trending.provider;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.view.OpPlayListView;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import kotlin.Metadata;
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
public final class q extends BaseItemProvider<OperateItem> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.transsion.home.preload.b f52315f;

    public q(com.transsion.home.preload.b bVar) {
        this.f52315f = bVar;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return PostItemType.PLAY_LIST.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_play_list;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public BaseViewHolder n(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        com.transsion.home.preload.b bVar = this.f52315f;
        if (bVar == null || bVar.a() || this.f52315f.h() == null) {
            return super.n(parent, i11);
        }
        uo.b.a.f(uo.b.f78622a, "MainXMLPreload", "subjectOpView", false, 4, null);
        View viewH = this.f52315f.h();
        Intrinsics.d(viewH);
        viewH.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return new BaseViewHolder(viewH);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, OperateItem item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        OpPlayListView opPlayListView = (OpPlayListView) helper.getViewOrNull(R$id.play_list_view);
        if (opPlayListView != null) {
            opPlayListView.setData(item);
        }
    }
}
