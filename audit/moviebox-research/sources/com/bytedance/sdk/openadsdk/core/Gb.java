package com.bytedance.sdk.openadsdk.core;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Gb {
    private static int We(View view, int i11) {
        if (i11 == 3) {
            return kX.We(view.getContext().getApplicationContext()) / 2;
        }
        return 20;
    }

    private static int pFF(View view, int i11, int i12) throws Throwable {
        if (view.getWindowVisibility() != 0) {
            return 4;
        }
        if (!pFF(view)) {
            return 1;
        }
        if (pFF(view, i12)) {
            return !sc(view, i11) ? 3 : 0;
        }
        return 6;
    }

    private static boolean pFF(View view) {
        return view != null && view.isShown();
    }

    private static boolean pFF(View view, int i11) {
        return view.getWidth() >= zY(view, i11) && view.getHeight() >= We(view, i11);
    }

    public static float sc(View view) {
        if (view != null) {
            try {
                if (view.getVisibility() == 0 && view.getParent() != null) {
                    Rect rect = new Rect();
                    if (!view.getGlobalVisibleRect(rect)) {
                        return -1.0f;
                    }
                    long jHeight = ((long) rect.height()) * ((long) rect.width());
                    long height = ((long) view.getHeight()) * ((long) view.getWidth());
                    if (height <= 0) {
                        return -1.0f;
                    }
                    return jHeight / height;
                }
            } catch (Throwable unused) {
            }
        }
        return -1.0f;
    }

    private static boolean sc(View view, int i11) {
        float fSc = sc(view);
        return fSc > 0.0f && fSc >= ((float) i11) / 100.0f;
    }

    public static boolean sc(View view, int i11, int i12) {
        if (i12 == 1) {
            while (view != null) {
                try {
                    if (view.getVisibility() != 0) {
                        return false;
                    }
                    if ((view instanceof com.bytedance.sdk.openadsdk.core.Qj.Sfl) || (view instanceof com.bytedance.sdk.openadsdk.core.zY.zY)) {
                        break;
                    }
                    view = (View) view.getParent();
                } catch (Throwable unused) {
                }
            }
        }
        return pFF(view, i11, i12) == 0;
    }

    private static int zY(View view, int i11) {
        if (i11 == 3) {
            return (int) (((double) kX.zY(view.getContext().getApplicationContext())) * 0.7d);
        }
        return 20;
    }
}
