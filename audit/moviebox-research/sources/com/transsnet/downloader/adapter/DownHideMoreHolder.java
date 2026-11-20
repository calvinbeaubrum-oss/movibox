package com.transsnet.downloader.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$mipmap;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.viewmodel.DownloadListManager;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DownHideMoreHolder extends BaseViewHolder implements d0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f60299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.transsion.ad.bidding.nativead.c f60300c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownHideMoreHolder(View view, com.transsion.ad.bidding.nativead.c cVar) {
        super(view);
        Intrinsics.g(view, "view");
        this.f60299b = view;
        this.f60300c = cVar;
    }

    public static final void f(DownHideMoreHolder this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        DownloadListManager.a aVar = DownloadListManager.f61186m;
        DownloadListManager.x(aVar.a(), !aVar.a().J(), false, this$0.f60300c, 2, null);
    }

    @Override // com.transsnet.downloader.adapter.d0
    public void a(int i11, e9.a aVar) {
        d0.a.a(this, i11, aVar);
    }

    @Override // com.transsnet.downloader.adapter.d0
    public void c(d0.b bVar) {
        d0.a.b(this, bVar);
    }

    @Override // com.transsnet.downloader.adapter.d0
    public void d(int i11, e9.a aVar) {
        if (aVar instanceof DownloadBean) {
            TextView textView = (TextView) getView(R$id.tv_title);
            ImageView imageView = (ImageView) getView(R$id.iv_hide_more);
            DownloadBean downloadBean = (DownloadBean) aVar;
            textView.setText(downloadBean.getName());
            imageView.setImageDrawable(downloadBean.isMore() ? z2.a.getDrawable(imageView.getContext(), R$mipmap.libui_ic_down_more) : z2.a.getDrawable(imageView.getContext(), R$mipmap.libui_ic_up_hide));
            this.f60299b.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.adapter.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownHideMoreHolder.f(this.f60356a, view);
                }
            });
        }
    }
}
