package g9;

import android.view.View;
import android.view.ViewGroup;
import com.chad.library.R$id;
import com.chad.library.R$layout;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class b extends a {
    @Override // g9.a
    public View getLoadComplete(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        return holder.getView(R$id.load_more_load_complete_view);
    }

    @Override // g9.a
    public View getLoadEndView(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        return holder.getView(R$id.load_more_load_end_view);
    }

    @Override // g9.a
    public View getLoadFailView(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        return holder.getView(R$id.load_more_load_fail_view);
    }

    @Override // g9.a
    public View getLoadingView(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        return holder.getView(R$id.load_more_loading_view);
    }

    @Override // g9.a
    public View getRootView(ViewGroup parent) {
        Intrinsics.g(parent, "parent");
        return i9.a.a(parent, R$layout.brvah_quick_view_load_more);
    }
}
