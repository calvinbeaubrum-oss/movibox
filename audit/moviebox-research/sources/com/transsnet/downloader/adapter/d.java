package com.transsnet.downloader.adapter;

import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import java.util.List;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class d extends BaseQuickAdapter<DubsInfo, BaseViewHolder> {
    public d() {
        super(R$layout.item_download_sel_dialog, null, 2, null);
    }

    private final void I0(BaseViewHolder baseViewHolder, boolean z11) {
        baseViewHolder.getView(R$id.tv_name_selected).setVisibility(z11 ? 0 : 8);
        baseViewHolder.getView(R$id.tv_name).setVisibility(z11 ^ true ? 0 : 8);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, DubsInfo item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        holder.itemView.setSelected(item.isSelected());
        TextView textView = (TextView) holder.getView(R$id.tv_name);
        String lanName = item.getLanName();
        if (lanName == null) {
            lanName = "";
        }
        textView.setText(lanName);
        TextView textView2 = (TextView) holder.getView(R$id.tv_name_selected);
        String lanName2 = item.getLanName();
        textView2.setText(lanName2 != null ? lanName2 : "");
        I0(holder, item.isSelected());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public void y(BaseViewHolder holder, DubsInfo item, List<? extends Object> payloads) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        Intrinsics.g(payloads, "payloads");
        super.y(holder, item, payloads);
        if (!payloads.isEmpty()) {
            Object obj = payloads.get(0);
            if (obj instanceof Boolean) {
                I0(holder, ((Boolean) obj).booleanValue());
            }
        }
    }
}
