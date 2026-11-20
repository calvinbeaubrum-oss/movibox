package com.transsnet.downloader.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.moviedetailapi.SubjectType;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.bean.SeasonListBean;
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
public final class n extends BaseQuickAdapter<SeasonListBean, BaseViewHolder> {
    public final Integer H;

    public n(Integer num) {
        super(R$layout.item_download_sel_dialog, null, 2, null);
        this.H = num;
    }

    private final void I0(BaseViewHolder baseViewHolder, boolean z11) {
        baseViewHolder.itemView.setSelected(z11);
        baseViewHolder.getView(R$id.tv_name).setVisibility(z11 ^ true ? 0 : 8);
        baseViewHolder.getView(R$id.tv_name_selected).setVisibility(z11 ? 0 : 8);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, SeasonListBean item) {
        String string;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        I0(holder, item.isSelected());
        Integer num = this.H;
        int value = SubjectType.EDUCATION.getValue();
        if (num != null && num.intValue() == value) {
            string = getContext().getString(R$string.download_video_detail_unit_index, com.transsion.moviedetailapi.helper.b.a(item.getSeason()));
            Intrinsics.f(string, "{\n            context.ge…x(item.season))\n        }");
        } else {
            string = getContext().getString(R$string.download_video_detail_season_index, com.transsion.moviedetailapi.helper.b.a(item.getSeason()));
            Intrinsics.f(string, "{\n            context.ge…)\n            )\n        }");
        }
        holder.setText(R$id.tv_name, string);
        holder.setText(R$id.tv_name_selected, string);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public void y(BaseViewHolder holder, SeasonListBean item, List<? extends Object> payloads) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        Intrinsics.g(payloads, "payloads");
        super.y(holder, item, payloads);
        if (payloads.isEmpty()) {
            return;
        }
        Object obj = payloads.get(payloads.size() - 1);
        if (obj instanceof Boolean) {
            I0(holder, ((Boolean) obj).booleanValue());
        }
    }
}
