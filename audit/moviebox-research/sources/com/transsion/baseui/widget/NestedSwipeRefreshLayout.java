package com.transsion.baseui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
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
public final class NestedSwipeRefreshLayout extends SwipeRefreshLayout {
    public static final int $stable = 8;
    public final int S;
    public float T;
    public float U;
    public boolean V;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.g(context, "context");
        Intrinsics.g(attrs, "attrs");
        this.S = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev2) {
        Intrinsics.g(ev2, "ev");
        int action = ev2.getAction();
        if (action == 0) {
            this.T = ev2.getY();
            this.U = ev2.getX();
            this.V = false;
        } else if (action == 2) {
            if (this.V) {
                return false;
            }
            float y11 = ev2.getY();
            float fAbs = Math.abs(ev2.getX() - this.U);
            Math.abs(y11 - this.T);
            if (fAbs > this.S) {
                this.V = true;
                return false;
            }
        }
        return super.onInterceptTouchEvent(ev2);
    }
}
