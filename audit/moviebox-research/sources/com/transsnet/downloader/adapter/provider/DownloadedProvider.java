package com.transsnet.downloader.adapter.provider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.TnTextView;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.R$drawable;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.adapter.LayoutType;
import com.transsnet.downloader.util.DownloadUtilKt;
import com.transsnet.downloader.viewmodel.c;
import h00.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class DownloadedProvider extends BaseItemProvider<DownloadBean> {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class DownloadedItemVH extends BaseViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e f60388b;

        /* JADX WARN: Illegal instructions before constructor call */
        public DownloadedItemVH(e viewBinding) {
            Intrinsics.g(viewBinding, "viewBinding");
            ConstraintLayout root = viewBinding.getRoot();
            Intrinsics.f(root, "viewBinding.root");
            super(root);
            this.f60388b = viewBinding;
        }

        public final e e() {
            return this.f60388b;
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return LayoutType.DONE_LAYOUT.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.adapter_downloaded_item;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, DownloadBean item) {
        String strA;
        List<DownloadBean> listD;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        DownloadedItemVH downloadedItemVH = (DownloadedItemVH) helper;
        int position = downloadedItemVH.getPosition();
        BaseProviderMultiAdapter<DownloadBean> baseProviderMultiAdapterC = c();
        downloadedItemVH.e().f65812c.setPadding(0, 0, 0, position == ((baseProviderMultiAdapterC == null || (listD = baseProviderMultiAdapterC.D()) == null) ? 0 : listD.size()) - 1 ? gs.a.a(100) : gs.a.a(16));
        String str = "";
        if (item.isInnerRes()) {
            String cover = item.getCover();
            if (cover != null) {
                Context context = helper.itemView.getContext();
                Intrinsics.f(context, "helper.itemView.context");
                AppCompatImageView appCompatImageView = downloadedItemVH.e().f65811b.f66020b;
                Intrinsics.f(appCompatImageView, "viewHolder.viewBinding.cardCover.ivCover");
                DownloadUtilKt.a(context, appCompatImageView, cover, item.getThumbnail());
            }
        } else {
            AppCompatImageView appCompatImageView2 = downloadedItemVH.e().f65811b.f66020b;
            c cVar = c.f61276a;
            String cover2 = item.getCover();
            if (cover2 == null) {
                cover2 = "";
            }
            appCompatImageView2.setImageBitmap(cVar.e(cover2));
        }
        downloadedItemVH.e().f65811b.f66022d.setImageResource(item.isInnerRes() ? com.transsion.moviedetailapi.a.a(Integer.valueOf(item.getSubjectType())) : R$drawable.ic_tag_local_file);
        downloadedItemVH.e().f65817i.setText(item.getTitleNameAppendResolution());
        TnTextView tnTextView = downloadedItemVH.e().f65815g;
        Intrinsics.f(tnTextView, "viewHolder.viewBinding.tvEp");
        tnTextView.setVisibility(item.getEpName().length() > 0 ? 0 : 8);
        downloadedItemVH.e().f65815g.setText(item.getEpName());
        Long size = item.getSize();
        if (size != null && (strA = tp.a.a(size.longValue(), 1)) != null) {
            str = strA;
        }
        downloadedItemVH.e().f65816h.setText(str);
        if (item.getStatus() == 10) {
            TnTextView tnTextView2 = downloadedItemVH.e().f65821m;
            Intrinsics.f(tnTextView2, "viewHolder.viewBinding.tvSeriesCount");
            so.c.k(tnTextView2);
            View view = downloadedItemVH.e().f65822n;
            Intrinsics.f(view, "viewHolder.viewBinding.tvSeriesLine");
            so.c.k(view);
            downloadedItemVH.e().f65821m.setText(downloadedItemVH.itemView.getContext().getString(R$string.download_episodes, Integer.valueOf(item.getCount())));
            ConstraintLayout root = downloadedItemVH.e().f65811b.f66023f.getRoot();
            Intrinsics.f(root, "viewHolder.viewBinding.c…ver.layoutNoFileTips.root");
            so.c.g(root);
        } else {
            TnTextView tnTextView3 = downloadedItemVH.e().f65821m;
            Intrinsics.f(tnTextView3, "viewHolder.viewBinding.tvSeriesCount");
            so.c.g(tnTextView3);
            View view2 = downloadedItemVH.e().f65822n;
            Intrinsics.f(view2, "viewHolder.viewBinding.tvSeriesLine");
            so.c.g(view2);
            boolean zIsFileExist = item.isFileExist();
            ConstraintLayout root2 = downloadedItemVH.e().f65811b.f66023f.getRoot();
            Intrinsics.f(root2, "viewHolder.viewBinding.c…ver.layoutNoFileTips.root");
            root2.setVisibility(zIsFileExist ^ true ? 0 : 8);
            AppCompatImageView appCompatImageView3 = downloadedItemVH.e().f65811b.f66021c;
            Intrinsics.f(appCompatImageView3, "viewHolder.viewBinding.cardCover.ivPlay");
            appCompatImageView3.setVisibility(zIsFileExist ? 0 : 8);
        }
        x(downloadedItemVH, item);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, DownloadBean item, List<? extends Object> payloads) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        Intrinsics.g(payloads, "payloads");
        super.b(helper, item, payloads);
        if (payloads.isEmpty()) {
            return;
        }
        Object objR0 = CollectionsKt___CollectionsKt.r0(payloads);
        if (objR0 instanceof DownloadBean) {
            x((DownloadedItemVH) helper, (DownloadBean) objR0);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public DownloadedItemVH n(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        e eVarC = e.c(LayoutInflater.from(g()), parent, false);
        Intrinsics.f(eVarC, "inflate(LayoutInflater.f…(context), parent, false)");
        return new DownloadedItemVH(eVarC);
    }

    public final void x(DownloadedItemVH downloadedItemVH, final DownloadBean downloadBean) {
        final long readProgress = downloadBean.getReadProgress();
        Long duration = downloadBean.getDuration();
        long jLongValue = duration != null ? duration.longValue() : 1L;
        final int i11 = (int) (((readProgress * 1.0f) / (jLongValue > 0 ? jLongValue : 1L)) * 100);
        downloadedItemVH.e().f65811b.f66024g.setProgress(i11);
        final Context context = downloadedItemVH.itemView.getContext();
        if (i11 < 0 || i11 >= 101) {
            return;
        }
        downloadedItemVH.e().f65818j.setTextAction(new Function0<CharSequence>() { // from class: com.transsnet.downloader.adapter.provider.DownloadedProvider$refreshData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CharSequence invoke() {
                int i12 = i11;
                if (i12 != 0) {
                    if (i12 != 100) {
                        return downloadBean.getType() == 1 ? context.getString(R$string.download_listened, Integer.valueOf(i11)) : context.getString(R$string.download_watched, Integer.valueOf(i11));
                    }
                    return context.getString(R$string.download_finished);
                }
                if (readProgress > 0) {
                    return downloadBean.getType() == 1 ? context.getString(R$string.download_listened, 1) : context.getString(R$string.download_watched, 1);
                }
                return context.getString(R$string.download_not_open);
            }
        });
    }
}
