package com.transsion.ninegridview.preview;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.transsion.moviedetailapi.bean.Image;
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
public final class c extends FragmentStateAdapter {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<Image> f53983i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Boolean f53984j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(FragmentActivity activity) {
        super(activity);
        Intrinsics.g(activity, "activity");
        this.f53984j = Boolean.FALSE;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int i11) {
        GifImagePreviewFragment.a aVar = GifImagePreviewFragment.f53969d;
        Boolean bool = this.f53984j;
        List<Image> list = this.f53983i;
        return aVar.a(bool, list != null ? list.get(i11) : null, i11);
    }

    public final void d(Boolean bool) {
        this.f53984j = bool;
    }

    public final void e(List<Image> list) {
        this.f53983i = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<Image> list = this.f53983i;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
