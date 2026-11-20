package com.transsion.baseui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
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
public final class NestedHorizontalScrollableHost extends FrameLayout {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f51497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f51498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f51499c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedHorizontalScrollableHost(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f51497a = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedHorizontalScrollableHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        this.f51497a = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private final View getChild() {
        if (getChildCount() > 0) {
            return getChildAt(0);
        }
        return null;
    }

    public final boolean a(float f11) {
        int i11 = -((int) Math.signum(f11));
        View child = getChild();
        if (child != null) {
            return child.canScrollHorizontally(i11);
        }
        return false;
    }

    public final void b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f51498b = motionEvent.getX();
            this.f51499c = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            return;
        }
        if (motionEvent.getAction() == 2) {
            float x11 = motionEvent.getX() - this.f51498b;
            float y11 = motionEvent.getY() - this.f51499c;
            float fAbs = Math.abs(x11) * 0.5f;
            float fAbs2 = Math.abs(y11) * 1.0f;
            int i11 = this.f51497a;
            if (fAbs > i11 || fAbs2 > i11) {
                if (fAbs2 > fAbs) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                } else if (a(x11)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                } else {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent e11) {
        Intrinsics.g(e11, "e");
        b(e11);
        return super.onInterceptTouchEvent(e11);
    }
}
