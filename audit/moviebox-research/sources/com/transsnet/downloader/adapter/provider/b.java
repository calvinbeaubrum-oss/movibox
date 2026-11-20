package com.transsnet.downloader.adapter.provider;

import android.content.Context;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.image.ImageHelper;
import com.transsnet.downloader.R$drawable;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$mipmap;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.util.DownloadUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.l;
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
@SourceDebugExtension
public final class b extends BaseItemProvider<DownloadBean> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f60397f;

    public b(float f11) {
        this.f60397f = f11;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return 0;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_transfer_select_item;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, DownloadBean bean) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(bean, "bean");
        c.g(helper.getView(R$id.iv_play));
        ProgressBar progressBar = (ProgressBar) helper.getViewOrNull(R$id.progress_bar);
        if (progressBar != null) {
            c.g(progressBar);
        }
        ImageView imageView = (ImageView) helper.getView(R$id.iv_cover);
        String cover = bean.getCover();
        String str = "";
        if (cover != null && !Intrinsics.b(imageView.getTag(), cover)) {
            imageView.setTag(cover);
            if (l.L(cover, HttpHost.DEFAULT_SCHEME_NAME, false, 2, null)) {
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = imageView.getContext();
                Intrinsics.f(context, "context");
                String thumbnail = bean.getThumbnail();
                if (thumbnail == null) {
                    thumbnail = "";
                }
                companion.q(context, imageView, cover, (8120 & 8) != 0 ? companion.d() : 0, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
            } else {
                imageView.setImageBitmap(com.transsnet.downloader.viewmodel.c.f61276a.e(cover));
            }
        }
        ((ImageView) helper.getView(R$id.iv_type)).setImageResource(DownloadUtil.f61136a.i(bean));
        ((TextView) helper.getView(R$id.tv_name)).setText(bean.getTitleNameAppendResolution());
        TextView textView = (TextView) helper.getView(R$id.tv_ep);
        textView.setText(bean.getTitleNameAppendResolution());
        String epName = bean.getEpName();
        if (epName == null || epName.length() == 0) {
            c.g(textView);
        } else {
            c.k(textView);
            textView.setText(bean.getEpName());
        }
        Long size = bean.getSize();
        if (size != null) {
            String strA = tp.a.a(size.longValue(), this.f60397f == 12.0f ? 1 : 0);
            if (strA != null) {
                str = strA;
            }
        }
        if (bean.isSeriesCollection()) {
            c.k(helper.getView(R$id.v_series_top_bg));
            c.k(helper.getView(R$id.v_series_top_bg_2));
            TextView textView2 = (TextView) helper.getView(R$id.tv_file_size);
            String str2 = helper.itemView.getContext().getString(R$string.download_files, Integer.valueOf(bean.getCount())) + " · " + str;
            Intrinsics.f(str2, "toString(...)");
            textView2.setText(str2);
            textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(R$mipmap.ic_download_series, 0, 0, 0);
        } else {
            c.g(helper.getView(R$id.v_series_top_bg));
            c.g(helper.getView(R$id.v_series_top_bg_2));
            TextView textView3 = (TextView) helper.getView(R$id.tv_file_size);
            textView3.setText(str);
            textView3.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
        }
        x(helper, bean);
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
        Object obj = payloads.get(payloads.size() - 1);
        if (obj instanceof DownloadBean) {
            x(helper, (DownloadBean) obj);
        }
    }

    public final int w(DownloadBean downloadBean) {
        Iterator<T> it = downloadBean.getSeriesList().iterator();
        int i11 = 0;
        while (it.hasNext()) {
            if (((DownloadBean) it.next()).isCheck()) {
                i11++;
            }
        }
        return i11;
    }

    public final void x(BaseViewHolder baseViewHolder, DownloadBean downloadBean) {
        TextView textView = (TextView) baseViewHolder.getView(R$id.tv_more_count);
        ImageView imageView = (ImageView) baseViewHolder.getView(R$id.iv_more);
        if (!downloadBean.isCheck()) {
            imageView.setImageResource(R$drawable.ic_download_group_unselected);
            c.g(textView);
            return;
        }
        if (!downloadBean.isSeriesCollection()) {
            imageView.setImageResource(R$drawable.ic_download_group_selected);
            c.g(textView);
        } else if (downloadBean.isSeriesAllCheck()) {
            imageView.setImageResource(R$drawable.ic_download_group_selected);
            c.g(textView);
        } else {
            imageView.setImageResource(R$drawable.shape_transfer_select_icon_bg);
            c.k(textView);
            int iW = w(downloadBean);
            textView.setText(iW > 99 ? "99+" : String.valueOf(iW));
        }
    }
}
