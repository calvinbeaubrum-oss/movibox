package com.transsnet.downloader.adapter.provider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.TnTextView;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$mipmap;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.adapter.DownloadedHolderKt;
import com.transsnet.downloader.adapter.LayoutType;
import com.transsnet.downloader.manager.DownloadEsHelper;
import h00.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
public final class DownloadingProvider extends BaseItemProvider<DownloadBean> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f60389f = R$string.downloading_time_left;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f60390g = R$string.download_status_waiting;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f60391h = R$string.download_status_paused;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f60392i = R$string.download_status_failed;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f60393j = R$string.download_status_no_net;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f60394k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f60395l;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class DownloadingItemVH extends BaseViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f f60396b;

        /* JADX WARN: Illegal instructions before constructor call */
        public DownloadingItemVH(f viewBinding) {
            Intrinsics.g(viewBinding, "viewBinding");
            ConstraintLayout root = viewBinding.getRoot();
            Intrinsics.f(root, "viewBinding.root");
            super(root);
            this.f60396b = viewBinding;
        }

        public final f e() {
            return this.f60396b;
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return LayoutType.NO_DONE_LAYOUT.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.adapter_downloading_item;
    }

    public final String u(DownloadingItemVH downloadingItemVH, DownloadBean downloadBean) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j11 = (jCurrentTimeMillis - this.f60395l) / ((long) 1000);
        this.f60395l = jCurrentTimeMillis;
        long progress = j11 <= 0 ? 0L : (downloadBean.getProgress() - this.f60394k) / j11;
        this.f60394k = downloadBean.getProgress();
        if (progress <= 0 && downloadBean.getCurrentDownloadSpeed() > 0) {
            progress = downloadBean.getCurrentDownloadSpeed();
        }
        if (progress <= 0) {
            return "";
        }
        Long size = downloadBean.getSize();
        float fLongValue = ((size != null ? size.longValue() : 0L) - this.f60394k) * 1.0f;
        if (fLongValue <= 0.0f) {
            return "";
        }
        downloadBean.setCurrentDownloadSpeed(progress);
        return TimeUtilKt.e((int) (fLongValue / progress)) + " " + downloadingItemVH.itemView.getResources().getString(this.f60389f);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, DownloadBean item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        DownloadingItemVH downloadingItemVH = (DownloadingItemVH) helper;
        DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
        String resourceId = item.getResourceId();
        if (resourceId == null) {
            resourceId = item.getUrl();
        }
        DownloadBean downloadBeanL = downloadEsHelperA.l(resourceId);
        if (downloadBeanL == null) {
            downloadBeanL = item;
        }
        ViewGroup.LayoutParams layoutParams = downloadingItemVH.e().f65832b.getRoot().getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int position = downloadingItemVH.getPosition();
        BaseProviderMultiAdapter<DownloadBean> baseProviderMultiAdapterC = c();
        marginLayoutParams.bottomMargin = gs.a.a(position == (baseProviderMultiAdapterC != null ? baseProviderMultiAdapterC.getItemCount() : 0) - 1 ? 16 : 12);
        downloadingItemVH.e().f65832b.getRoot().setLayoutParams(marginLayoutParams);
        String cover = downloadBeanL.getCover();
        if (cover != null) {
            Context context = helper.itemView.getContext();
            Intrinsics.f(context, "helper.itemView.context");
            AppCompatImageView appCompatImageView = downloadingItemVH.e().f65832b.f66020b;
            Intrinsics.f(appCompatImageView, "viewHolder.viewBinding.cardCover.ivCover");
            DownloadedHolderKt.a(context, appCompatImageView, cover, item.getThumbnail());
        }
        downloadingItemVH.e().f65832b.f66022d.setImageResource(com.transsion.moviedetailapi.a.a(Integer.valueOf(downloadBeanL.getSubjectType())));
        downloadingItemVH.e().f65838i.setText(downloadBeanL.getTitleNameAppendResolution());
        TnTextView tnTextView = downloadingItemVH.e().f65837h;
        Intrinsics.f(tnTextView, "viewHolder.viewBinding.tvEp");
        tnTextView.setVisibility(downloadBeanL.getEpName().length() > 0 ? 0 : 8);
        downloadingItemVH.e().f65837h.setText(downloadBeanL.getEpName());
        downloadingItemVH.e().f65838i.setTag(downloadBeanL.getResourceId());
        y(downloadingItemVH, downloadBeanL);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
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
            DownloadEsHelper downloadEsHelperA = DownloadEsHelper.f60994m.a();
            DownloadBean downloadBean = (DownloadBean) objR0;
            String resourceId = downloadBean.getResourceId();
            if (resourceId == null) {
                resourceId = item.getUrl();
            }
            DownloadBean downloadBeanL = downloadEsHelperA.l(resourceId);
            if (downloadBeanL != null) {
                downloadBean = downloadBeanL;
            }
            y((DownloadingItemVH) helper, downloadBean);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public DownloadingItemVH n(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        f fVarC = f.c(LayoutInflater.from(g()), parent, false);
        Intrinsics.f(fVarC, "inflate(LayoutInflater.f…(context), parent, false)");
        return new DownloadingItemVH(fVarC);
    }

    public final void y(DownloadingItemVH downloadingItemVH, DownloadBean downloadBean) {
        Object objU;
        long progress = downloadBean.getProgress();
        if (progress < 0) {
            progress = 0;
        }
        Long size = downloadBean.getSize();
        long jLongValue = size != null ? size.longValue() : 1L;
        if (jLongValue <= 0) {
            jLongValue = 1;
        }
        float f11 = 100;
        int i11 = (int) (((progress * 1.0f) / jLongValue) * f11);
        int status = downloadBean.getStatus();
        if (status == 1 || status == 2) {
            downloadingItemVH.e().f65836g.setSecondaryProgress(downloadBean.isPreDownload() ? i11 : 0);
            ProgressBar progressBar = downloadingItemVH.e().f65836g;
            if (downloadBean.isPreDownload()) {
                i11 = 0;
            }
            progressBar.setProgress(i11);
        } else {
            downloadingItemVH.e().f65836g.setSecondaryProgress(i11);
            downloadingItemVH.e().f65836g.setProgress(0);
        }
        downloadingItemVH.e().f65839j.setText(tp.a.a(progress, 1) + " / " + tp.a.a(jLongValue, 1));
        int i12 = R$color.white_80;
        int status2 = downloadBean.getStatus();
        if (status2 == 1 || status2 == 2) {
            if (downloadBean.isPreDownload()) {
                objU = Integer.valueOf(this.f60390g);
            } else {
                i12 = R$color.white_80;
                objU = u(downloadingItemVH, downloadBean);
            }
        } else if (status2 == 3) {
            objU = Integer.valueOf(this.f60390g);
        } else if (status2 == 4) {
            objU = Integer.valueOf(this.f60391h);
            i12 = R$color.error_50;
        } else if (status2 != 6) {
            objU = null;
        } else {
            objU = Integer.valueOf((downloadBean.isNoNetError() || !com.tn.lib.util.networkinfo.f.f49475a.e()) ? this.f60393j : this.f60392i);
            i12 = R$color.error_50;
        }
        if (objU instanceof Integer) {
            downloadingItemVH.e().f65840k.setTextById(((Number) objU).intValue());
        } else if (objU instanceof String) {
            downloadingItemVH.e().f65840k.setTextWithString((CharSequence) objU);
        }
        downloadingItemVH.e().f65840k.setTextColor(z2.a.getColor(downloadingItemVH.itemView.getContext(), i12));
        int status3 = downloadBean.getStatus();
        if (status3 == 1 || status3 == 2 || status3 == 3) {
            downloadingItemVH.e().f65835f.setImageResource(R$mipmap.ic_download_pause);
        } else if (status3 == 4 || status3 == 6) {
            downloadingItemVH.e().f65835f.setImageResource(R$mipmap.ic_download_downloading);
        }
        long readProgress = downloadBean.getReadProgress();
        Long duration = downloadBean.getDuration();
        long jLongValue2 = duration != null ? duration.longValue() : 1L;
        downloadingItemVH.e().f65832b.f66024g.setProgress((int) (((readProgress * 1.0f) / (jLongValue2 <= 0 ? 1L : jLongValue2)) * f11));
    }
}
