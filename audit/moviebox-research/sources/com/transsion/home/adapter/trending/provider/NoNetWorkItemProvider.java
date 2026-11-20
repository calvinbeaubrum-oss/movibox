package com.transsion.home.adapter.trending.provider;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.view.NoNetworkSmallView;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.adapter.trending.TrendingAdapter;
import com.transsion.home.p003enum.HomeTabType;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class NoNetWorkItemProvider extends BaseItemProvider<OperateItem> {
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return PostItemType.NO_NETWORK.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_no_network;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, OperateItem item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        NoNetworkSmallView noNetworkSmallView = (NoNetworkSmallView) helper.getViewOrNull(R$id.no_network);
        if (noNetworkSmallView != null) {
            noNetworkSmallView.retry(new Function0<Unit>() { // from class: com.transsion.home.adapter.trending.provider.NoNetWorkItemProvider$convert$1$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Function0<Unit> function0X0;
                    BaseProviderMultiAdapter<OperateItem> baseProviderMultiAdapterC = this.this$0.c();
                    if ((baseProviderMultiAdapterC instanceof TrendingAdapter) && (function0X0 = ((TrendingAdapter) baseProviderMultiAdapterC).X0()) != null) {
                        function0X0.invoke();
                    }
                    com.tn.lib.view.l.b(HomeTabType.TAB_CODE_TRENDING);
                }
            });
            noNetworkSmallView.goToSetting(new Function0<Unit>() { // from class: com.transsion.home.adapter.trending.provider.NoNetWorkItemProvider$convert$1$2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    com.tn.lib.view.l.c(HomeTabType.TAB_CODE_TRENDING);
                }
            });
        }
        com.tn.lib.view.l.a(HomeTabType.TAB_CODE_TRENDING);
    }
}
