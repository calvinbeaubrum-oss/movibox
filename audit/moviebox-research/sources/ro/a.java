package ro;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
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
    public int f75647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f75648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f75649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f75650d;

    public a(int i11, int i12, int i13, int i14) {
        this.f75647a = i11;
        this.f75648b = i12;
        this.f75649c = i13;
        this.f75650d = i14;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.x state) {
        Intrinsics.g(outRect, "outRect");
        Intrinsics.g(view, "view");
        Intrinsics.g(parent, "parent");
        Intrinsics.g(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        RecyclerView.m layoutManager = parent.getLayoutManager();
        RecyclerView.Adapter adapter = parent.getAdapter();
        int itemCount = adapter != null ? adapter.getItemCount() : 0;
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            int spanCount = gridLayoutManager.getSpanCount();
            if (gridLayoutManager.getOrientation() != 1) {
                if (gridLayoutManager.getOrientation() == 0) {
                    int i11 = this.f75648b;
                    outRect.top = i11 / 2;
                    outRect.bottom = i11 / 2;
                    int i12 = ((itemCount + spanCount) - 1) / spanCount;
                    int i13 = childAdapterPosition / spanCount;
                    if (i13 == 0) {
                        outRect.left = this.f75649c;
                        outRect.right = this.f75647a / 2;
                        return;
                    } else if (i13 == i12 - 1) {
                        outRect.left = this.f75647a / 2;
                        outRect.right = this.f75650d;
                        return;
                    } else {
                        int i14 = this.f75647a;
                        outRect.left = i14 / 2;
                        outRect.right = i14 / 2;
                        return;
                    }
                }
                return;
            }
            int i15 = this.f75647a;
            outRect.left = i15 / 2;
            outRect.right = i15 / 2;
            if ((adapter instanceof BaseQuickAdapter) && ((BaseQuickAdapter) adapter).b0()) {
                if (childAdapterPosition == 0) {
                    outRect.left = 0;
                    outRect.right = 0;
                    outRect.top = 0;
                    outRect.bottom = this.f75648b / 2;
                    return;
                }
                childAdapterPosition--;
            }
            int i16 = ((itemCount + spanCount) - 1) / spanCount;
            int i17 = childAdapterPosition / spanCount;
            if (i17 == 0) {
                outRect.top = this.f75649c;
                outRect.bottom = this.f75648b / 2;
            } else if (i17 == i16 - 1) {
                outRect.top = this.f75648b / 2;
                outRect.bottom = this.f75650d;
            } else {
                int i18 = this.f75648b;
                outRect.top = i18 / 2;
                outRect.bottom = i18 / 2;
            }
        }
    }
}
