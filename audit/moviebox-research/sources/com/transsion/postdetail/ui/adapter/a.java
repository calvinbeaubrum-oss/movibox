package com.transsion.postdetail.ui.adapter;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blankj.utilcode.util.d0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import h9.i;
import h9.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class a extends BaseQuickAdapter<DownloadBean, BaseViewHolder> implements j {
    public final boolean H;
    public final int I;
    public final int J;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(List<DownloadBean> dataList, boolean z11) {
        super(R$layout.item_local_video_middle_ep, dataList);
        Intrinsics.g(dataList, "dataList");
        this.H = z11;
        this.I = d0.e();
        this.J = gs.a.a(8);
    }

    public /* synthetic */ a(List list, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i11 & 2) != 0 ? false : z11);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, DownloadBean item) {
        String sizeFormat;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        if (!this.H) {
            ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
            int i11 = this.I;
            int i12 = this.J;
            layoutParams.width = ((i11 - (i12 * 6)) / 3) - i12;
        }
        if (TextUtils.isEmpty(item.getSizeFormat())) {
            Long size = item.getSize();
            sizeFormat = size != null ? tp.a.a(size.longValue(), 1) : null;
        } else {
            sizeFormat = item.getSizeFormat();
        }
        ((TextView) holder.getView(R$id.tv_size)).setText(sizeFormat);
        ((TextView) holder.getView(R$id.tv_size_selected)).setText(sizeFormat);
        ((TextView) holder.getView(R$id.tv_title)).setText(item.getEpName());
        ((TextView) holder.getView(R$id.tv_title_selected)).setText(item.getEpName());
        I0(holder, item.isPlaying());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public void y(BaseViewHolder holder, DownloadBean item, List<? extends Object> payloads) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        Intrinsics.g(payloads, "payloads");
        super.y(holder, item, payloads);
        Object obj = payloads.get(payloads.size() - 1);
        if (obj instanceof Boolean) {
            I0(holder, ((Boolean) obj).booleanValue());
        }
    }

    public final void I0(BaseViewHolder baseViewHolder, boolean z11) {
        baseViewHolder.getView(R$id.tv_title_selected).setVisibility(z11 ? 0 : 8);
        baseViewHolder.getView(R$id.tv_size_selected).setVisibility(z11 ? 0 : 8);
        baseViewHolder.getView(R$id.tv_title).setVisibility(z11 ^ true ? 0 : 8);
        baseViewHolder.getView(R$id.tv_size).setVisibility(z11 ^ true ? 0 : 8);
        baseViewHolder.itemView.setSelected(z11);
    }

    @Override // h9.j
    public /* synthetic */ h9.f a(BaseQuickAdapter baseQuickAdapter) {
        return i.a(this, baseQuickAdapter);
    }
}
