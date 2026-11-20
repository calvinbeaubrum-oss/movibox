package fx;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.bean.TabItem;
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
public final class b extends BaseQuickAdapter<TabItem, BaseViewHolder> {
    public String H;

    public b(String str) {
        super(R$layout.item_search_result_tab, null, 2, null);
        this.H = str;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, TabItem item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        holder.setText(R$id.search_result_tab_select_text, item.getName());
        holder.setText(R$id.search_result_tab_default_text, item.getName());
        if (Intrinsics.b(item.getTabId(), this.H)) {
            holder.setVisible(R$id.search_result_tab_select_text, true);
            holder.setGone(R$id.search_result_tab_default_text, true);
        } else {
            holder.setGone(R$id.search_result_tab_select_text, true);
            holder.setVisible(R$id.search_result_tab_default_text, true);
        }
    }

    public final void H0(String selectId) {
        Intrinsics.g(selectId, "selectId");
        this.H = selectId;
        notifyDataSetChanged();
    }
}
