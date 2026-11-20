package ro;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.f0;
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
public final class f extends RecyclerView.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f75663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f75664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f75665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f75666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f75667e;

    public f(int i11, int i12) {
        this.f75663a = i11;
        if (i12 > 1) {
            int iA = f0.a(((i12 - 1) * 8) + 24.0f) / i12;
            float fA = f0.a(12.0f);
            this.f75666d = fA;
            float f11 = iA;
            this.f75665c = f11 - fA;
            this.f75667e = f11 / 2.0f;
        }
    }

    public final void d(int i11) {
        this.f75664b = i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.x state) {
        Intrinsics.g(outRect, "outRect");
        Intrinsics.g(view, "view");
        Intrinsics.g(parent, "parent");
        Intrinsics.g(state, "state");
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (adapter != null && childAdapterPosition == adapter.getItemCount() - 1) {
            outRect.bottom = 0;
        } else if (this.f75664b == 0 || !Intrinsics.b(view.getTag(), "TrendingTitle")) {
            outRect.bottom = this.f75663a;
        } else {
            outRect.bottom = this.f75664b;
        }
        RecyclerView.m layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            int spanCount = gridLayoutManager.getSpanCount();
            int iF = gridLayoutManager.getSpanSizeLookup().f(childAdapterPosition);
            int iE = gridLayoutManager.getSpanSizeLookup().e(childAdapterPosition, spanCount);
            if (iF == spanCount) {
                return;
            }
            float f11 = this.f75666d;
            if (f11 > 0.0f) {
                if (iE == 0) {
                    outRect.left = (int) f11;
                    outRect.right = (int) this.f75665c;
                } else if (iE == spanCount - iF) {
                    outRect.left = (int) this.f75665c;
                    outRect.right = (int) f11;
                } else {
                    float f12 = this.f75667e;
                    outRect.left = (int) f12;
                    outRect.right = (int) f12;
                }
                outRect.bottom = this.f75664b;
            }
            if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                int i11 = outRect.left;
                outRect.left = outRect.right;
                outRect.right = i11;
            }
        }
    }
}
