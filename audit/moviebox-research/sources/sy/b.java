package sy;

import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.transfer.R$id;
import com.transsion.transfer.R$layout;
import com.transsion.transfer.wifi.permission.PermissionsBean;
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
public final class b extends BaseItemProvider<PermissionsBean> {
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return 0;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_permission_layout;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, PermissionsBean item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        ((ImageView) helper.itemView.findViewById(R$id.ivIcon)).setImageResource(item.getIcon());
        ((TextView) helper.itemView.findViewById(R$id.tvTitle)).setText(item.getTitle());
        ((TextView) helper.itemView.findViewById(R$id.tvContent)).setText(item.getContent());
        boolean zF = e.f76637a.f(item.getPermission());
        TextView textView = (TextView) helper.itemView.findViewById(R$id.tvAction);
        textView.setText(item.getBtnName());
        if (zF) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }
}
