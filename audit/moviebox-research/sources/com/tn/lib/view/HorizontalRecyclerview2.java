package com.tn.lib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
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
public final class HorizontalRecyclerview2 extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f49549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f49550b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalRecyclerview2(Context context) {
        super(context);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalRecyclerview2(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.g(context, "context");
        Intrinsics.g(attrs, "attrs");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalRecyclerview2(Context context, AttributeSet attrs, int i11) {
        super(context, attrs, i11);
        Intrinsics.g(context, "context");
        Intrinsics.g(attrs, "attrs");
    }

    public final void a(boolean z11) {
        getParent().requestDisallowInterceptTouchEvent(z11);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f49549a = (int) motionEvent.getX();
                this.f49550b = (int) motionEvent.getY();
                a(true);
            } else if (action == 2) {
                int x11 = (int) motionEvent.getX();
                int y11 = (int) motionEvent.getY();
                int iAbs = Math.abs(x11 - this.f49549a);
                int iAbs2 = Math.abs(y11 - this.f49550b);
                RecyclerView.m layoutManager = getLayoutManager();
                Intrinsics.e(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                int iFindLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                int iFindFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
                int itemCount = linearLayoutManager.getItemCount();
                if (iAbs <= iAbs2) {
                    a(false);
                } else if (iFindLastCompletelyVisibleItemPosition == itemCount - 1 && this.f49549a > x11) {
                    a(false);
                } else if (iFindFirstCompletelyVisibleItemPosition != 0 || this.f49549a >= x11) {
                    a(true);
                } else {
                    a(false);
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
