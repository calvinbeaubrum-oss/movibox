package ou;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
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
public final class a extends RecyclerView.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f73420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f73421b;

    public a(int i11, int i12) {
        this.f73420a = i11;
        this.f73421b = i12;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.x state) {
        Intrinsics.g(outRect, "outRect");
        Intrinsics.g(view, "view");
        Intrinsics.g(parent, "parent");
        Intrinsics.g(state, "state");
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        int i11 = this.f73420a;
        int i12 = childAdapterPosition % i11;
        int i13 = this.f73421b;
        outRect.left = ((i11 - i12) * i13) / i11;
        outRect.right = (i13 * (i12 + 1)) / i11;
    }
}
