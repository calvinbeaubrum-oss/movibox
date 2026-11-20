package com.mbridge.msdk.video.dynview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class ObservableScrollView extends HorizontalScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f47787a;

    public ObservableScrollView(Context context) {
        super(context);
        this.f47787a = null;
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47787a = null;
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f47787a = null;
    }

    @Override // android.widget.HorizontalScrollView
    public void fling(int i11) {
        super.fling(i11 / 4);
    }

    @Override // android.view.View
    public void onScrollChanged(int i11, int i12, int i13, int i14) {
        super.onScrollChanged(i11, i12, i13, i14);
        a aVar = this.f47787a;
        if (aVar != null) {
            aVar.a(this, i11, i12, i13, i14);
        }
    }
}
