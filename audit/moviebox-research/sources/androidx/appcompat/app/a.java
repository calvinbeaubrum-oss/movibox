package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0029a extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f826a;

        public C0029a(int i11, int i12) {
            super(i11, i12);
            this.f826a = 8388627;
        }

        public C0029a(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f826a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBarLayout);
            this.f826a = typedArrayObtainStyledAttributes.getInt(R$styleable.ActionBarLayout_android_layout_gravity, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public C0029a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f826a = 0;
        }

        public C0029a(C0029a c0029a) {
            super((ViewGroup.MarginLayoutParams) c0029a);
            this.f826a = 0;
            this.f826a = c0029a.f826a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(boolean z11);
    }

    /* JADX INFO: compiled from: source.java */
    @Deprecated
    public static abstract class c {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract CharSequence d();

        public abstract void e();
    }

    public boolean f() {
        return false;
    }

    public abstract boolean g();

    public abstract void h(boolean z11);

    public abstract int i();

    public abstract Context j();

    public abstract void k();

    public boolean l() {
        return false;
    }

    public void m(Configuration configuration) {
    }

    public void n() {
    }

    public abstract boolean o(int i11, KeyEvent keyEvent);

    public boolean p(KeyEvent keyEvent) {
        return false;
    }

    public boolean q() {
        return false;
    }

    public abstract void r(boolean z11);

    public abstract void s(boolean z11);

    public abstract void t(CharSequence charSequence);

    public g1.b u(g1.b.a aVar) {
        return null;
    }
}
