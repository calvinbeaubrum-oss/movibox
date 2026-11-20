package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class k extends PopupWindow {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f1708b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1709a;

    public k(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        a(context, attributeSet, i11, i12);
    }

    public final void a(Context context, AttributeSet attributeSet, int i11, int i12) {
        n0 n0VarV = n0.v(context, attributeSet, R$styleable.PopupWindow, i11, i12);
        if (n0VarV.s(R$styleable.PopupWindow_overlapAnchor)) {
            b(n0VarV.a(R$styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(n0VarV.g(R$styleable.PopupWindow_android_popupBackground));
        n0VarV.x();
    }

    public final void b(boolean z11) {
        if (f1708b) {
            this.f1709a = z11;
        } else {
            androidx.core.widget.k.a(this, z11);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i11, int i12) {
        if (f1708b && this.f1709a) {
            i12 -= view.getHeight();
        }
        super.showAsDropDown(view, i11, i12);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i11, int i12, int i13) {
        if (f1708b && this.f1709a) {
            i12 -= view.getHeight();
        }
        super.showAsDropDown(view, i11, i12, i13);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i11, int i12, int i13, int i14) {
        if (f1708b && this.f1709a) {
            i12 -= view.getHeight();
        }
        super.update(view, i11, i12, i13, i14);
    }
}
