package com.transsion.home.layoutmanager;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uo.b;

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
public class OffsetStaggeredGridLayoutManager extends StaggeredGridLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Integer, Integer> f52636a;

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public int computeVerticalScrollOffset(RecyclerView.x state) {
        Intrinsics.g(state, "state");
        if (getChildCount() == 0) {
            return 0;
        }
        try {
            int i11 = findFirstVisibleItemPositions(null)[0];
            b.a.f(b.f78622a, "MovieFragment", "firstVisblePosition=" + i11, false, 4, null);
            View viewFindViewByPosition = findViewByPosition(i11);
            int iIntValue = 0;
            for (int i12 = 0; i12 < i11; i12++) {
                Integer num = this.f52636a.get(Integer.valueOf(i12));
                if (num == null) {
                    num = 0;
                }
                iIntValue += num.intValue();
            }
            return iIntValue - (viewFindViewByPosition != null ? viewFindViewByPosition.getTop() : 0);
        } catch (Exception e11) {
            e11.printStackTrace();
            return super.computeVerticalScrollOffset(state);
        }
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.m
    public void onLayoutCompleted(RecyclerView.x xVar) {
        super.onLayoutCompleted(xVar);
        int i11 = findFirstCompletelyVisibleItemPositions(null)[0];
        int i12 = findLastCompletelyVisibleItemPositions(null)[0];
        if (i11 < 0 || i12 < 0 || i12 < i11) {
            return;
        }
        while (i11 < i12) {
            View childAt = getChildAt(i11);
            if (childAt != null) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
                if (((StaggeredGridLayoutManager.b) layoutParams).c() == 0) {
                    this.f52636a.put(Integer.valueOf(i11), Integer.valueOf(childAt.getHeight()));
                } else {
                    this.f52636a.put(Integer.valueOf(i11), 0);
                }
            }
            i11++;
        }
    }
}
