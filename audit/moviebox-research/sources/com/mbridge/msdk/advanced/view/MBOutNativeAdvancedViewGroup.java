package com.mbridge.msdk.advanced.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.mbridge.msdk.advanced.b.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class MBOutNativeAdvancedViewGroup extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f42873a;

    public MBOutNativeAdvancedViewGroup(Context context) {
        super(context);
    }

    public MBOutNativeAdvancedViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBOutNativeAdvancedViewGroup(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    private void a(final int i11) {
        postDelayed(new Runnable() { // from class: com.mbridge.msdk.advanced.view.MBOutNativeAdvancedViewGroup.1
            @Override // java.lang.Runnable
            public final void run() {
                if (MBOutNativeAdvancedViewGroup.this.f42873a != null) {
                    MBOutNativeAdvancedViewGroup.this.f42873a.d(i11);
                }
            }
        }, 200L);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f42873a != null) {
            a(1);
            if (getVisibility() == 0) {
                a(2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.f42873a;
        if (cVar != null) {
            cVar.e(1);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (i11 == 0) {
            a(2);
            if (getParent() != null) {
                a(1);
                return;
            }
            return;
        }
        c cVar = this.f42873a;
        if (cVar != null) {
            cVar.e(2);
        }
    }

    public void setProvider(c cVar) {
        this.f42873a = cVar;
    }
}
