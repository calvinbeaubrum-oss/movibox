package wy;

import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.R$color;
import com.transsion.usercenter.R$drawable;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$string;
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
public final class g extends BaseQuickAdapter<String, BaseViewHolder> implements h9.j {
    public final int H;

    public g(int i11) {
        super(R$layout.adapter_item_follow, null, 2, null);
        this.H = i11;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, String item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        if (this.H == 1) {
            TextView textView = (TextView) holder.getView(R$id.btnFollow);
            textView.setText(holder.itemView.getContext().getString(R$string.user_center_follow_following));
            textView.setTextColor(z2.a.getColor(holder.itemView.getContext(), R$color.base_color_white));
            textView.setBackgroundResource(R$drawable.btn_bg_following);
            return;
        }
        TextView textView2 = (TextView) holder.getView(R$id.btnFollow);
        textView2.setText(holder.itemView.getContext().getString(R$string.user_center_follow_followers));
        textView2.setTextColor(z2.a.getColor(holder.itemView.getContext(), R$color.base_color_333333));
        textView2.setBackgroundResource(R$drawable.btn_bg_followers);
    }

    @Override // h9.j
    public /* synthetic */ h9.f a(BaseQuickAdapter baseQuickAdapter) {
        return h9.i.a(this, baseQuickAdapter);
    }
}
