package d9;

import androidx.recyclerview.widget.j;
import com.chad.library.adapter.base.BaseQuickAdapter;
import h9.f;
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
public final class c implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BaseQuickAdapter<?, ?> f62964a;

    public c(BaseQuickAdapter<?, ?> mAdapter) {
        Intrinsics.g(mAdapter, "mAdapter");
        this.f62964a = mAdapter;
    }

    @Override // androidx.recyclerview.widget.j
    public void onChanged(int i11, int i12, Object obj) {
        BaseQuickAdapter<?, ?> baseQuickAdapter = this.f62964a;
        baseQuickAdapter.notifyItemRangeChanged(i11 + baseQuickAdapter.K(), i12, obj);
    }

    @Override // androidx.recyclerview.widget.j
    public void onInserted(int i11, int i12) {
        BaseQuickAdapter<?, ?> baseQuickAdapter = this.f62964a;
        baseQuickAdapter.notifyItemRangeInserted(i11 + baseQuickAdapter.K(), i12);
    }

    @Override // androidx.recyclerview.widget.j
    public void onMoved(int i11, int i12) {
        BaseQuickAdapter<?, ?> baseQuickAdapter = this.f62964a;
        baseQuickAdapter.notifyItemMoved(i11 + baseQuickAdapter.K(), i12 + this.f62964a.K());
    }

    @Override // androidx.recyclerview.widget.j
    public void onRemoved(int i11, int i12) {
        f fVarR = this.f62964a.R();
        if (fVarR != null && fVarR.m() && this.f62964a.getItemCount() == 0) {
            BaseQuickAdapter<?, ?> baseQuickAdapter = this.f62964a;
            baseQuickAdapter.notifyItemRangeRemoved(i11 + baseQuickAdapter.K(), i12 + 1);
        } else {
            BaseQuickAdapter<?, ?> baseQuickAdapter2 = this.f62964a;
            baseQuickAdapter2.notifyItemRangeRemoved(i11 + baseQuickAdapter2.K(), i12);
        }
    }
}
