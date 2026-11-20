package com.transsnet.downloader.adapter;

import android.view.View;
import android.widget.TextView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.R$id;
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
public final class DownloadAllEpBtnHolder extends BaseViewHolder implements d0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadAllEpBtnHolder(View view) {
        super(view);
        Intrinsics.g(view, "view");
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
            ((TextView) getView(R$id.tv_all_episodes)).setText(((DownloadBean) aVar).getName());
        }
    }
}
