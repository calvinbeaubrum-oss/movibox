package ro;

import android.graphics.Rect;
import android.view.View;
import androidx.core.text.v;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.f0;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class d extends RecyclerView.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f75656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f75657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f75658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f75659d;

    public d(float f11, float f12, float f13, float f14) {
        this.f75656a = f11;
        this.f75657b = f12;
        this.f75658c = f13;
        this.f75659d = f14;
    }

    public /* synthetic */ d(float f11, float f12, float f13, float f14, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0.0f : f11, (i11 & 2) != 0 ? 0.0f : f12, (i11 & 4) != 0 ? 0.0f : f13, (i11 & 8) != 0 ? 0.0f : f14);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.x state) {
        Intrinsics.g(outRect, "outRect");
        Intrinsics.g(view, "view");
        Intrinsics.g(parent, "parent");
        Intrinsics.g(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (childAdapterPosition != 0) {
            float f11 = this.f75656a;
            if (f11 > 0.0f) {
                outRect.left = f0.a(f11);
            }
            float f12 = this.f75657b;
            if (f12 > 0.0f) {
                outRect.top = f0.a(f12);
            }
        }
        int iB = state.b() - 1;
        float f13 = this.f75658c;
        if (f13 > 0.0f && this.f75656a > 0.0f && childAdapterPosition == 0) {
            outRect.left = f0.a(f13);
        }
        float f14 = this.f75659d;
        if (f14 > 0.0f && this.f75656a > 0.0f && childAdapterPosition == iB) {
            outRect.right = f0.a(f14);
        }
        float f15 = this.f75658c;
        if (f15 > 0.0f && this.f75657b > 0.0f && childAdapterPosition == 0) {
            outRect.top = f0.a(f15);
        }
        float f16 = this.f75659d;
        if (f16 > 0.0f && this.f75657b > 0.0f && childAdapterPosition == iB) {
            outRect.bottom = f0.a(f16);
        }
        if (v.a(Locale.getDefault()) == 1) {
            int i11 = outRect.left;
            outRect.left = outRect.right;
            outRect.right = i11;
        }
    }
}
