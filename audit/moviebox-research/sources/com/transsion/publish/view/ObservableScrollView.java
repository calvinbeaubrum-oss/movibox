package com.transsion.publish.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class ObservableScrollView extends ScrollView {
    public static final int SCROLL_DOWN = 16;
    public static final int SCROLL_UP = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f56650a;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(int i11);
    }

    public ObservableScrollView(Context context) {
        super(context);
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
    }

    @Override // android.view.View
    public void onScrollChanged(int i11, int i12, int i13, int i14) {
        a aVar;
        super.onScrollChanged(i11, i12, i13, i14);
        if (i14 > i12 && i14 - i12 > 40) {
            a aVar2 = this.f56650a;
            if (aVar2 != null) {
                aVar2.a(16);
                return;
            }
            return;
        }
        if (i14 >= i12 || i12 - i14 <= 40 || (aVar = this.f56650a) == null) {
            return;
        }
        aVar.a(1);
    }

    public void setScrollListener(a aVar) {
        this.f56650a = aVar;
    }
}
