package com.transsnet.downloader.adapter.provider;

import android.view.View;
import androidx.lifecycle.c0;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.util.networkinfo.f;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.adapter.LayoutType;
import com.transsnet.downloader.bean.MovieRecBean;
import com.transsnet.downloader.viewmodel.DownloadViewModel;
import com.transsnet.downloader.widget.DownloadPanelForYouFootView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import so.c;

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
public final class DownloadFootForYouProvider extends BaseItemProvider<DownloadBean> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DownloadViewModel f60386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f60387g = 1;

    public DownloadFootForYouProvider(DownloadViewModel downloadViewModel) {
        this.f60386f = downloadViewModel;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return LayoutType.FOR_YOU.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.adapter_download_item_for_you;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, DownloadBean item) {
        c0<BaseDto<MovieRecBean>> c0VarS;
        BaseDto<MovieRecBean> baseDtoF;
        MovieRecBean data;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        DownloadViewModel downloadViewModel = this.f60386f;
        List<Subject> items = (downloadViewModel == null || (c0VarS = downloadViewModel.s()) == null || (baseDtoF = c0VarS.f()) == null || (data = baseDtoF.getData()) == null) ? null : data.getItems();
        List<Subject> list = items;
        if (list == null || list.isEmpty()) {
            View view = helper.itemView;
            Intrinsics.f(view, "helper.itemView");
            c.g(view);
        } else {
            View view2 = helper.itemView;
            Intrinsics.f(view2, "helper.itemView");
            c.k(view2);
            DownloadPanelForYouFootView downloadPanelForYouFootView = (DownloadPanelForYouFootView) helper.getView(R$id.v_for_you);
            downloadPanelForYouFootView.setRefreshClickCallback(new Function0<Unit>() { // from class: com.transsnet.downloader.adapter.provider.DownloadFootForYouProvider$convert$1$1
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
                    if (!f.f49475a.e()) {
                        zp.b.f82110a.d(R$string.no_network_toast);
                        return;
                    }
                    DownloadViewModel downloadViewModel2 = this.this$0.f60386f;
                    if (downloadViewModel2 != null) {
                        DownloadFootForYouProvider downloadFootForYouProvider = this.this$0;
                        downloadFootForYouProvider.f60387g++;
                        downloadViewModel2.r(downloadFootForYouProvider.f60387g, 6);
                    }
                }
            });
            downloadPanelForYouFootView.setData(items);
        }
    }
}
