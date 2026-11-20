package com.transsion.baseui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
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
public final class OperateScrollableHost extends FrameLayout {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f51511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f51512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f51513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f51514d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperateScrollableHost(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f51511a = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperateScrollableHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        this.f51511a = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private final View getChild() {
        if (getChildCount() > 0) {
            return getChildAt(0);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x000d, code lost:
    
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ViewPager2 getParentViewPager() {
        Object parent = getParent();
        if (parent instanceof View) {
            View view = (View) parent;
            while (view != null && !(view instanceof ViewPager2)) {
                Object parent2 = view.getParent();
                view = parent2 instanceof View ? (View) parent2 : null;
            }
            if (view instanceof ViewPager2) {
                return (ViewPager2) view;
            }
            return null;
        }
    }

    public final boolean a(int i11, float f11) {
        if (this.f51514d) {
            return true;
        }
        int i12 = -((int) Math.signum(f11));
        if (i11 == 0) {
            View child = getChild();
            if (child != null) {
                return child.canScrollHorizontally(i12);
            }
            return false;
        }
        if (i11 != 1) {
            throw new IllegalArgumentException();
        }
        View child2 = getChild();
        if (child2 != null) {
            return child2.canScrollVertically(i12);
        }
        return false;
    }

    public final void b(MotionEvent motionEvent) {
        ViewPager2 parentViewPager = getParentViewPager();
        if (parentViewPager != null) {
            int orientation = parentViewPager.getOrientation();
            if (a(orientation, -1.0f) || a(orientation, 1.0f)) {
                if (motionEvent.getAction() == 0) {
                    this.f51512b = motionEvent.getX();
                    this.f51513c = motionEvent.getY();
                    getParent().requestDisallowInterceptTouchEvent(true);
                    return;
                }
                if (motionEvent.getAction() == 2) {
                    float x11 = motionEvent.getX() - this.f51512b;
                    float y11 = motionEvent.getY() - this.f51513c;
                    boolean z11 = orientation == 0;
                    float fAbs = Math.abs(x11) * (z11 ? 0.5f : 1.0f);
                    float fAbs2 = Math.abs(y11) * (z11 ? 1.0f : 0.5f);
                    int i11 = this.f51511a;
                    if (fAbs > i11 || fAbs2 > i11) {
                        if (z11 == (fAbs2 > fAbs)) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                        } else {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
            }
        }
    }

    public final void interceptAllEvent(boolean z11) {
        this.f51514d = z11;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent e11) {
        Intrinsics.g(e11, "e");
        b(e11);
        return super.onInterceptTouchEvent(e11);
    }
}
