package com.bytedance.sdk.openadsdk.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.sdk.openadsdk.ApmHelper;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class BR {

    /* JADX INFO: compiled from: source.java */
    public interface pFF {
        void pFF();

        void sc();

        void sc(View view, boolean z11);

        void sc(boolean z11);
    }

    /* JADX INFO: compiled from: source.java */
    public class sc implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ ViewGroup pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        View f28708sc = null;

        public sc(ViewGroup viewGroup) {
            this.pFF = viewGroup;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            try {
                pFF pff = (pFF) this.pFF.getTag(520093765);
                if (this.f28708sc == null) {
                    ViewGroup viewGroup = this.pFF;
                    BR.pFF(viewGroup, pff, (Integer) viewGroup.getTag(520093766));
                    return;
                }
                Rect rect = new Rect();
                this.f28708sc.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                this.pFF.getGlobalVisibleRect(rect2);
                if (rect.contains(rect2)) {
                    if (pff != null) {
                        pff.sc(this.pFF, false);
                    }
                    this.pFF.setTag(520093763, Boolean.FALSE);
                } else {
                    if (pff != null) {
                        pff.sc(this.pFF, true);
                    }
                    this.pFF.setTag(520093763, Boolean.TRUE);
                }
            } catch (Exception e11) {
                ApmHelper.reportCustomError("onGlobalLayout exception " + this.pFF.getTag(520093765), "ViewUtils", e11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pFF(View view, pFF pff, Integer num) {
        if (pff == null) {
            return;
        }
        if (num == null) {
            num = 0;
        }
        pff.sc(view, sc(view, num.intValue()));
    }

    public static void sc(final ViewGroup viewGroup, boolean z11, int i11, pFF pff, List<ViewGroup> list) {
        viewGroup.setTag(520093765, pff);
        viewGroup.setTag(520093766, Integer.valueOf(i11));
        if (viewGroup.getTag(520093764) == Boolean.TRUE) {
            return;
        }
        final sc scVar = new sc(viewGroup);
        if (list != null && list.size() > 0) {
            for (int i12 = 0; i12 < list.size(); i12++) {
                list.get(i12).setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.bytedance.sdk.openadsdk.utils.BR.1
                    @Override // android.view.ViewGroup.OnHierarchyChangeListener
                    public void onChildViewAdded(View view, View view2) {
                        scVar.f28708sc = view2;
                    }

                    @Override // android.view.ViewGroup.OnHierarchyChangeListener
                    public void onChildViewRemoved(View view, View view2) {
                        scVar.f28708sc = null;
                    }
                });
            }
        }
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(scVar);
        if (z11) {
            viewGroup.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.utils.BR.2
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    try {
                        pFF pff2 = (pFF) viewGroup.getTag(520093765);
                        ViewGroup viewGroup2 = viewGroup;
                        BR.pFF(viewGroup2, pff2, (Integer) viewGroup2.getTag(520093766));
                    } catch (Exception e11) {
                        ApmHelper.reportCustomError("onScrollChanged exception " + viewGroup.getTag(520093765), "ViewUtils", e11);
                    }
                }
            });
        }
        viewGroup.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.bytedance.sdk.openadsdk.utils.BR.3
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public void onWindowFocusChanged(boolean z12) {
                try {
                    pFF pff2 = (pFF) viewGroup.getTag(520093765);
                    if (pff2 != null) {
                        pff2.sc(z12);
                        ViewGroup viewGroup2 = viewGroup;
                        BR.pFF(viewGroup2, pff2, (Integer) viewGroup2.getTag(520093766));
                    }
                } catch (Exception e11) {
                    ApmHelper.reportCustomError("onWindowFocusChanged exception " + viewGroup.getTag(520093765), "ViewUtils", e11);
                }
            }
        });
        viewGroup.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.utils.BR.4
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                pFF pff2 = (pFF) viewGroup.getTag(520093765);
                if (pff2 != null) {
                    pff2.sc();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                pFF pff2 = (pFF) viewGroup.getTag(520093765);
                if (pff2 != null) {
                    pff2.pFF();
                }
            }
        });
        viewGroup.setTag(520093764, Boolean.TRUE);
    }

    private static boolean sc(View view, int i11) {
        return com.bytedance.sdk.openadsdk.core.Gb.sc(view, 20, i11);
    }
}
