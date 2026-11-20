package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.n0;
import com.google.android.material.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class TabItem extends View {
    public final int customLayout;
    public final Drawable icon;
    public final CharSequence text;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n0 n0VarU = n0.u(context, attributeSet, R$styleable.TabItem);
        this.text = n0VarU.p(R$styleable.TabItem_android_text);
        this.icon = n0VarU.g(R$styleable.TabItem_android_icon);
        this.customLayout = n0VarU.n(R$styleable.TabItem_android_layout, 0);
        n0VarU.x();
    }
}
