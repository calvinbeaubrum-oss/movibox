package com.transsion.moviedetail.staff;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
public final class l extends RecyclerView.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f53776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f53777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f53778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f53779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f53780e;

    public l(int i11, int i12, int i13, int i14, int i15) {
        this.f53776a = i11;
        this.f53777b = i12;
        this.f53778c = i13;
        this.f53779d = i14;
        this.f53780e = i15;
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
        boolean z11 = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        if (layoutManager instanceof GridLayoutManager) {
            int i11 = this.f53780e;
            if (i11 <= 0) {
                i11 = 1;
            }
            int i12 = childAdapterPosition % i11;
            RecyclerView.Adapter adapter = parent.getAdapter();
            Intrinsics.e(adapter, "null cannot be cast to non-null type com.transsion.moviedetail.staff.MovieStaffAdapter");
            int itemViewType = ((j) adapter).getItemViewType(childAdapterPosition);
            if (itemViewType != 1) {
                if (itemViewType != 2) {
                    outRect.left = 0;
                    outRect.right = 0;
                } else {
                    int i13 = this.f53776a;
                    outRect.left = i13;
                    outRect.right = i13;
                }
            } else if (z11) {
                if (i12 == 0) {
                    outRect.right = this.f53776a;
                    outRect.left = this.f53777b;
                } else if (i12 == this.f53780e - 1) {
                    outRect.right = this.f53777b;
                    outRect.left = this.f53776a;
                } else {
                    int i14 = this.f53777b;
                    outRect.left = i14;
                    outRect.right = i14;
                }
            } else if (i12 == 0) {
                outRect.left = this.f53776a;
                outRect.right = this.f53777b;
            } else if (i12 == this.f53780e - 1) {
                outRect.left = this.f53777b;
                outRect.right = this.f53776a;
            } else {
                int i15 = this.f53777b;
                outRect.left = i15;
                outRect.right = i15;
            }
            outRect.bottom = this.f53779d;
        }
    }
}
