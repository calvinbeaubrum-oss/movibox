package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f37114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f37115d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public vi.e f37118g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f37112a = new TextPaint(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vi.g f37113b = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f37116e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public WeakReference<b> f37117f = new WeakReference<>(null);

    /* JADX INFO: compiled from: source.java */
    public class a extends vi.g {
        public a() {
        }

        @Override // vi.g
        public void a(int i11) {
            y.this.f37116e = true;
            b bVar = (b) y.this.f37117f.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // vi.g
        public void b(@NonNull Typeface typeface, boolean z11) {
            if (z11) {
                return;
            }
            y.this.f37116e = true;
            b bVar = (b) y.this.f37117f.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a();

        @NonNull
        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public y(@Nullable b bVar) {
        j(bVar);
    }

    public final float c(@Nullable String str) {
        if (str == null) {
            return 0.0f;
        }
        return Math.abs(this.f37112a.getFontMetrics().ascent);
    }

    public final float d(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f37112a.measureText(charSequence, 0, charSequence.length());
    }

    @Nullable
    public vi.e e() {
        return this.f37118g;
    }

    public float f(@Nullable String str) {
        if (!this.f37116e) {
            return this.f37115d;
        }
        i(str);
        return this.f37115d;
    }

    @NonNull
    public TextPaint g() {
        return this.f37112a;
    }

    public float h(String str) {
        if (!this.f37116e) {
            return this.f37114c;
        }
        i(str);
        return this.f37114c;
    }

    public final void i(String str) {
        this.f37114c = d(str);
        this.f37115d = c(str);
        this.f37116e = false;
    }

    public void j(@Nullable b bVar) {
        this.f37117f = new WeakReference<>(bVar);
    }

    public void k(@Nullable vi.e eVar, Context context) {
        if (this.f37118g != eVar) {
            this.f37118g = eVar;
            if (eVar != null) {
                eVar.o(context, this.f37112a, this.f37113b);
                b bVar = this.f37117f.get();
                if (bVar != null) {
                    this.f37112a.drawableState = bVar.getState();
                }
                eVar.n(context, this.f37112a, this.f37113b);
                this.f37116e = true;
            }
            b bVar2 = this.f37117f.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void l(boolean z11) {
        this.f37116e = z11;
    }

    public void m(boolean z11) {
        this.f37116e = z11;
    }

    public void n(Context context) {
        this.f37118g.n(context, this.f37112a, this.f37113b);
    }
}
