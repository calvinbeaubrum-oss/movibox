package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class ContentLoadingProgressBar extends ProgressBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f8061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8064d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Runnable f8065f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Runnable f8066g;

    public ContentLoadingProgressBar(@NonNull Context context) {
        this(context, null);
    }

    public ContentLoadingProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f8061a = -1L;
        this.f8062b = false;
        this.f8063c = false;
        this.f8064d = false;
        this.f8065f = new Runnable() { // from class: androidx.core.widget.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f8097a.f();
            }
        };
        this.f8066g = new Runnable() { // from class: androidx.core.widget.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f8098a.g();
            }
        };
    }

    public final void e() {
        this.f8064d = true;
        removeCallbacks(this.f8066g);
        this.f8063c = false;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j11 = this.f8061a;
        long j12 = jCurrentTimeMillis - j11;
        if (j12 >= 500 || j11 == -1) {
            setVisibility(8);
        } else {
            if (this.f8062b) {
                return;
            }
            postDelayed(this.f8065f, 500 - j12);
            this.f8062b = true;
        }
    }

    public final /* synthetic */ void f() {
        this.f8062b = false;
        this.f8061a = -1L;
        setVisibility(8);
    }

    public final /* synthetic */ void g() {
        this.f8063c = false;
        if (this.f8064d) {
            return;
        }
        this.f8061a = System.currentTimeMillis();
        setVisibility(0);
    }

    public final void h() {
        removeCallbacks(this.f8065f);
        removeCallbacks(this.f8066g);
    }

    public void hide() {
        post(new Runnable() { // from class: androidx.core.widget.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f8096a.e();
            }
        });
    }

    public final void i() {
        this.f8061a = -1L;
        this.f8064d = false;
        removeCallbacks(this.f8065f);
        this.f8062b = false;
        if (this.f8063c) {
            return;
        }
        postDelayed(this.f8066g, 500L);
        this.f8063c = true;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    public void show() {
        post(new Runnable() { // from class: androidx.core.widget.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f8095a.i();
            }
        });
    }
}
