package pz;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.videodetail.R$id;
import com.transsion.videodetail.R$layout;
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
public final class a extends BaseQuickAdapter<DubsInfo, BaseViewHolder> {
    public a() {
        super(R$layout.item_video_detail_sel_dialog_audio_track, null, 2, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, DubsInfo item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        H0(holder, item.isSelected());
        int i11 = R$id.tvName;
        String lanName = item.getLanName();
        if (lanName == null) {
            lanName = "";
        }
        holder.setText(i11, lanName);
        int i12 = R$id.tvNameSelected;
        String lanName2 = item.getLanName();
        holder.setText(i12, lanName2 != null ? lanName2 : "");
    }

    public final void H0(BaseViewHolder baseViewHolder, boolean z11) {
        baseViewHolder.itemView.setSelected(z11);
        baseViewHolder.getView(R$id.tvName).setVisibility(z11 ^ true ? 0 : 8);
        baseViewHolder.getView(R$id.tvNameSelected).setVisibility(z11 ? 0 : 8);
    }
}
