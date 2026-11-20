package mt;

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
public final class c extends RecyclerView.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f71177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f71178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f71179c;

    public c(int i11, int i12, boolean z11) {
        this.f71177a = i11;
        this.f71178b = i12;
        this.f71179c = z11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.x state) {
        Intrinsics.g(outRect, "outRect");
        Intrinsics.g(view, "view");
        Intrinsics.g(parent, "parent");
        Intrinsics.g(state, "state");
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        int i11 = this.f71177a;
        int i12 = childAdapterPosition % i11;
        if (this.f71179c) {
            int i13 = this.f71178b;
            outRect.left = i13 - ((i12 * i13) / i11);
            outRect.right = ((i12 + 1) * i13) / i11;
            if (childAdapterPosition < i11) {
                outRect.top = i13;
            }
            outRect.bottom = i13;
            return;
        }
        int i14 = this.f71178b;
        outRect.left = (i12 * i14) / i11;
        outRect.right = i14 - (((i12 + 1) * i14) / i11);
        if (childAdapterPosition >= i11) {
            outRect.top = i14;
        }
    }
}
