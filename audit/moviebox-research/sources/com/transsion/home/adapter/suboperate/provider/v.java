package com.transsion.home.adapter.suboperate.provider;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.view.OpPlayListView;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.List;
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
public final class v extends BaseItemProvider<OperateItem> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f52211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SubTabFragment f52212g;

    public v(int i11, SubTabFragment subTabFragment) {
        Intrinsics.g(subTabFragment, "subTabFragment");
        this.f52211f = i11;
        this.f52212g = subTabFragment;
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
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, OperateItem item) {
        List<OperateItem> listD;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        OpPlayListView opPlayListView = (OpPlayListView) helper.getViewOrNull(R$id.play_list_view);
        if (opPlayListView != null) {
            opPlayListView.setCurrentTab(this.f52211f, this.f52212g.getPageName());
        }
        if (opPlayListView != null) {
            opPlayListView.setData(item);
        }
        pr.a aVar = pr.a.f74040a;
        BaseProviderMultiAdapter<OperateItem> baseProviderMultiAdapterC = c();
        aVar.u(item, -1L, (baseProviderMultiAdapterC == null || (listD = baseProviderMultiAdapterC.D()) == null) ? 0 : listD.indexOf(item), this.f52212g.getPageName());
    }
}
