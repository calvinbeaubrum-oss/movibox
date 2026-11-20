package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class o {
    public static int a(RecyclerView.x xVar, OrientationHelper orientationHelper, View view, View view2, RecyclerView.m mVar, boolean z11) {
        if (mVar.getChildCount() == 0 || xVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z11) {
            return Math.abs(mVar.getPosition(view) - mVar.getPosition(view2)) + 1;
        }
        return Math.min(orientationHelper.getTotalSpace(), orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view));
    }

    public static int b(RecyclerView.x xVar, OrientationHelper orientationHelper, View view, View view2, RecyclerView.m mVar, boolean z11, boolean z12) {
        if (mVar.getChildCount() == 0 || xVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z12 ? Math.max(0, (xVar.b() - Math.max(mVar.getPosition(view), mVar.getPosition(view2))) - 1) : Math.max(0, Math.min(mVar.getPosition(view), mVar.getPosition(view2)));
        if (z11) {
            return Math.round((iMax * (Math.abs(orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view)) / (Math.abs(mVar.getPosition(view) - mVar.getPosition(view2)) + 1))) + (orientationHelper.getStartAfterPadding() - orientationHelper.getDecoratedStart(view)));
        }
        return iMax;
    }

    public static int c(RecyclerView.x xVar, OrientationHelper orientationHelper, View view, View view2, RecyclerView.m mVar, boolean z11) {
        if (mVar.getChildCount() == 0 || xVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z11) {
            return xVar.b();
        }
        return (int) (((orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view)) / (Math.abs(mVar.getPosition(view) - mVar.getPosition(view2)) + 1)) * xVar.b());
    }
}
