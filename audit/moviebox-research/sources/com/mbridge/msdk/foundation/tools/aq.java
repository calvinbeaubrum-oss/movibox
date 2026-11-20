package com.mbridge.msdk.foundation.tools;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class aq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f45018a = false;

    private static int a(View view, ViewGroup viewGroup) {
        int i11 = 0;
        while (i11 < viewGroup.getChildCount() && viewGroup.getChildAt(i11) != view) {
            i11++;
        }
        return i11;
    }

    private static boolean a(View view) {
        return !(view != null && (view.getTag() instanceof String) && "mb_wm".equals(view.getTag())) && view.getBackground() != null && view.getBackground().getAlpha() > 127 && view.getAlpha() > 0.5f;
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x00fc A[SYNTHETIC] */
    public static boolean a(View view, int i11) {
        if (view == null) {
            return true;
        }
        if (view.getVisibility() != 0) {
            ad.b("ViewUtils", "Banner Judge : Banner's not visible.");
            return true;
        }
        if (view.getAlpha() < 0.5f) {
            ad.b("ViewUtils", "Banner Judge : Banner's alpha must set up 50%.");
            return true;
        }
        if (view.getParent() != null && (view.getParent() instanceof ViewGroup) && ((ViewGroup) view.getParent()).getVisibility() != 0) {
            ad.b("ViewUtils", "View Judge : View's container is not visible.");
            return true;
        }
        Rect rect = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
        boolean z11 = ((float) ((rect.bottom - rect.top) * (rect.right - rect.left))) > ((float) (view.getMeasuredHeight() * view.getMeasuredWidth())) * (i11 == 1 ? 0.0f : 0.5f);
        boolean z12 = globalVisibleRect && z11;
        ad.b("ViewUtils", "View Judge : partVisible is " + globalVisibleRect + " halfPercentVisible is " + z11);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("View Judge : totalViewVisible is ");
        sb2.append(z12);
        ad.b("ViewUtils", sb2.toString());
        if (!z12) {
            return true;
        }
        View view2 = view;
        while (view2.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            for (int iA = a(view2, viewGroup) + 1; iA < viewGroup.getChildCount(); iA++) {
                View childAt = viewGroup.getChildAt(iA);
                if (childAt.getVisibility() == 0 && a(view, childAt, i11)) {
                    if (childAt instanceof ViewGroup) {
                        ViewGroup viewGroup2 = (ViewGroup) childAt;
                        if (viewGroup2.getChildCount() > 0) {
                            ad.b("ViewUtils", "View Judge : Covered by ViewGroup.");
                            boolean zA = a(view, viewGroup2, i11);
                            f45018a = false;
                            if (zA) {
                                return true;
                            }
                        } else if (a(childAt)) {
                            ad.b("ViewUtils", "View Judge : View Covered and Cover View is not transparent.");
                            return true;
                        }
                    } else if (a(childAt)) {
                        ad.b("ViewUtils", "View Judge : View Covered and Cover View is not transparent.");
                        return true;
                    }
                }
            }
            view2 = viewGroup;
        }
        ad.b("ViewUtils", "View Judge : Well done, View is not covered.");
        return false;
    }

    private static boolean a(View view, View view2, int i11) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        view2.getGlobalVisibleRect(rect2);
        if (!Rect.intersects(rect, rect2)) {
            return false;
        }
        int iMin = Math.min(rect.right, rect2.right) - Math.max(rect.left, rect2.left);
        int iMin2 = Math.min(rect.bottom, rect2.bottom) - Math.max(rect.top, rect2.top);
        return (i11 != 1 && (iMin * iMin2) * 2 >= view.getMeasuredHeight() * view.getMeasuredWidth()) || (i11 == 1 && iMin * iMin2 >= view.getMeasuredHeight() * view.getMeasuredWidth());
    }

    private static boolean a(View view, ViewGroup viewGroup, int i11) {
        for (int i12 = 0; i12 < viewGroup.getChildCount(); i12++) {
            ad.b("ViewUtils", "View Judge : Start Loop");
            View childAt = viewGroup.getChildAt(i12);
            if (childAt.getVisibility() == 0 && a(view, childAt, i11)) {
                if ((childAt instanceof WebView) && childAt.getVisibility() == 0) {
                    ad.b("ViewUtils", "View Judge : View Covered by WebView.");
                    f45018a = true;
                }
                if (a(childAt)) {
                    ad.b("ViewUtils", "View Judge : View Covered and Cover ViewGroup is not transparent.");
                    f45018a = true;
                }
                if (f45018a) {
                    break;
                }
                if (childAt instanceof ViewGroup) {
                    a(view, (ViewGroup) childAt, i11);
                }
            }
        }
        return f45018a;
    }
}
