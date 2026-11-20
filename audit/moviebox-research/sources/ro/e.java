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
public final class e extends RecyclerView.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f75660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f75661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f75662c;

    public e(float f11, float f12, float f13) {
        this.f75660a = f11;
        this.f75661b = f12;
        this.f75662c = f13;
    }

    public /* synthetic */ e(float f11, float f12, float f13, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0.0f : f11, (i11 & 2) != 0 ? 0.0f : f12, (i11 & 4) != 0 ? 0.0f : f13);
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
            float f11 = this.f75660a;
            if (f11 > 0.0f) {
                outRect.left = f0.a(f11);
            }
            float f12 = this.f75661b;
            if (f12 > 0.0f) {
                outRect.top = f0.a(f12);
            }
        }
        int iB = state.b() - 1;
        float f13 = this.f75662c;
        if (f13 > 0.0f && this.f75660a > 0.0f) {
            if (childAdapterPosition == 0) {
                outRect.left = f0.a(f13);
            }
            if (childAdapterPosition == iB) {
                outRect.right = f0.a(this.f75662c);
            }
        }
        float f14 = this.f75662c;
        if (f14 > 0.0f && this.f75661b > 0.0f) {
            if (childAdapterPosition == 0) {
                outRect.top = f0.a(f14);
            }
            if (childAdapterPosition == iB) {
                outRect.bottom = f0.a(this.f75662c);
            }
        }
        if (v.a(Locale.getDefault()) == 1) {
            int i11 = outRect.left;
            outRect.left = outRect.right;
            outRect.right = i11;
        }
    }
}
