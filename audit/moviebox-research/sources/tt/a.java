package tt;

import android.graphics.Typeface;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$color;
import com.transsion.home.R$drawable;
import com.transsion.home.R$id;
import java.util.List;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a extends BaseQuickAdapter<st.a, BaseViewHolder> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(int i11, List<st.a> datas) {
        super(i11, datas);
        Intrinsics.g(datas, "datas");
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, st.a item) {
        Typeface typefaceDefaultFromStyle;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        TextView textView = (TextView) holder.getView(R$id.filter_item_name);
        textView.setText(item.a());
        if (item.d()) {
            textView.setBackgroundResource(R$drawable.bg_selected_filter_item);
            textView.setTextColor(z2.a.getColor(textView.getContext(), R$color.text_01));
            typefaceDefaultFromStyle = Typeface.defaultFromStyle(1);
        } else {
            textView.setBackgroundResource(R$color.transparent);
            textView.setTextColor(z2.a.getColor(textView.getContext(), R$color.text_02));
            typefaceDefaultFromStyle = Typeface.defaultFromStyle(0);
        }
        textView.setTypeface(typefaceDefaultFromStyle);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: d0 */
    public void onBindViewHolder(BaseViewHolder holder, int i11) {
        Intrinsics.g(holder, "holder");
        super.onBindViewHolder(holder, i11);
        ConstraintLayout constraintLayout = (ConstraintLayout) holder.getView(R$id.root);
        int iA = f0.a(6.0f);
        if (i11 == 0) {
            constraintLayout.setPaddingRelative(f0.a(12.0f), iA, 0, iA);
        } else if (i11 == getItemCount() - 1) {
            constraintLayout.setPaddingRelative(f0.a(10.0f), iA, f0.a(12.0f), iA);
        } else {
            constraintLayout.setPaddingRelative(f0.a(10.0f), iA, 0, iA);
        }
    }
}
