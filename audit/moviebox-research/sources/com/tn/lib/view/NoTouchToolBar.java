package com.tn.lib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class NoTouchToolBar extends Toolbar {
    public boolean V;

    public NoTouchToolBar(@NonNull Context context) {
        super(context);
        this.V = false;
    }

    public NoTouchToolBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.V = false;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.V;
    }

    public void setIntercept(boolean z11) {
        this.V = z11;
    }
}
