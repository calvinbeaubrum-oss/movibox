package com.transsion.postdetail.shorttv.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.to.aboomy.pager2banner.Banner;
import kotlin.Metadata;

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
public final class ShortTVBannerView extends Banner {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f55457v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f55458w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f55459x;

    public ShortTVBannerView(Context context) {
        super(context);
        this.f55457v = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public ShortTVBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f55457v = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public ShortTVBannerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f55457v = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // com.to.aboomy.pager2banner.Banner, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (getCurrentPager() == 0 && getChildCount() == 0) {
            return false;
        }
        if (motionEvent != null) {
            w(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final boolean v(int i11, float f11) {
        int i12 = -((int) Math.signum(f11));
        if (i11 == 0) {
            return canScrollHorizontally(i12);
        }
        if (i11 == 1) {
            return canScrollVertically(i12);
        }
        throw new IllegalArgumentException();
    }

    public final void w(MotionEvent motionEvent) {
        int orientation = getViewPager2().getOrientation();
        if (motionEvent.getAction() == 0) {
            this.f55458w = motionEvent.getX();
            this.f55459x = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            return;
        }
        if (motionEvent.getAction() == 2) {
            float x11 = motionEvent.getX() - this.f55458w;
            float y11 = motionEvent.getY() - this.f55459x;
            boolean z11 = orientation == 0;
            float fAbs = Math.abs(x11) * (z11 ? 0.5f : 1.0f);
            float fAbs2 = Math.abs(y11) * (z11 ? 1.0f : 0.5f);
            int i11 = this.f55457v;
            if (fAbs > i11 || fAbs2 > i11) {
                if (z11 == (fAbs2 > fAbs)) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                    return;
                }
                if (!z11) {
                    x11 = y11;
                }
                if (v(orientation, x11)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                } else {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
        }
    }
}
