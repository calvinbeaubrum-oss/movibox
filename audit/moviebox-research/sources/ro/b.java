package ro;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.Locale;
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
public final class b extends RecyclerView.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f75651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f75652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f75653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f75654d;

    public b(int i11, int i12, int i13, int i14) {
        this.f75651a = i11;
        this.f75652b = i12;
        this.f75653c = i13;
        this.f75654d = i14;
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
        if (!(layoutManager instanceof GridLayoutManager)) {
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
                int iC = ((StaggeredGridLayoutManager.b) layoutParams).c();
                if (childAdapterPosition == 0) {
                    outRect.left = 0;
                    outRect.right = 0;
                    return;
                }
                outRect.bottom = f0.a(16.0f);
                if (iC == 0) {
                    outRect.left = this.f75651a;
                    outRect.right = this.f75652b;
                    return;
                } else {
                    outRect.left = this.f75652b;
                    outRect.right = this.f75651a;
                    return;
                }
            }
            return;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        int spanCount = gridLayoutManager.getSpanCount();
        int iE = gridLayoutManager.getSpanSizeLookup().e(childAdapterPosition, spanCount);
        boolean z11 = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        if (iE == 0) {
            if (z11) {
                outRect.left = this.f75652b;
                outRect.right = this.f75651a;
            } else {
                outRect.left = this.f75651a;
                outRect.right = this.f75652b;
            }
        } else if (iE != spanCount - 1) {
            int i11 = this.f75652b;
            outRect.left = i11;
            outRect.right = i11;
        } else if (z11) {
            outRect.left = this.f75651a;
            outRect.right = this.f75652b;
        } else {
            outRect.left = this.f75652b;
            outRect.right = this.f75651a;
        }
        RecyclerView.Adapter adapter = parent.getAdapter();
        int itemCount = adapter != null ? adapter.getItemCount() : 0;
        if ((adapter instanceof BaseQuickAdapter) && ((BaseQuickAdapter) adapter).b0()) {
            if (childAdapterPosition == 0) {
                outRect.left = 0;
                outRect.right = 0;
                outRect.top = 0;
                outRect.bottom = this.f75654d / 2;
                return;
            }
            childAdapterPosition--;
        }
        int i12 = (itemCount / spanCount) + (itemCount % spanCount != 0 ? 1 : 0);
        int i13 = childAdapterPosition / spanCount;
        if (i13 == 0) {
            outRect.top = 0;
            outRect.bottom = this.f75654d / 2;
        } else if (i13 == i12 - 1) {
            outRect.top = this.f75653c / 2;
            outRect.bottom = 0;
        } else {
            outRect.top = this.f75653c / 2;
            outRect.bottom = this.f75654d / 2;
        }
    }
}
