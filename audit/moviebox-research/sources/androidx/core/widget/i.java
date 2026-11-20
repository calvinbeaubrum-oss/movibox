package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends AutoScrollHelper {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ListView f8099t;

    public i(@NonNull ListView listView) {
        super(listView);
        this.f8099t = listView;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public boolean a(int i11) {
        return false;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public boolean b(int i11) {
        ListView listView = this.f8099t;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i12 = firstVisiblePosition + childCount;
        if (i11 > 0) {
            if (i12 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (i11 >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    public void j(int i11, int i12) {
        this.f8099t.scrollListBy(i12);
    }
}
