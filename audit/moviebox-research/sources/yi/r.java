package yi;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public n f81496c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f81494a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f81495b = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RectF f81497d = new RectF();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Path f81498e = new Path();

    @NonNull
    public static r a(@NonNull View view) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 33) {
            return new u(view);
        }
        return i11 >= 22 ? new t(view) : new s();
    }

    public abstract void b(@NonNull View view);

    public boolean c() {
        return this.f81494a;
    }

    public final boolean d() {
        RectF rectF = this.f81497d;
        return rectF.left <= rectF.right && rectF.top <= rectF.bottom;
    }

    public void e(@NonNull Canvas canvas, @NonNull ji.a.InterfaceC0730a interfaceC0730a) {
        if (!j() || this.f81498e.isEmpty()) {
            interfaceC0730a.a(canvas);
            return;
        }
        canvas.save();
        canvas.clipPath(this.f81498e);
        interfaceC0730a.a(canvas);
        canvas.restore();
    }

    public void f(@NonNull View view, @NonNull RectF rectF) {
        this.f81497d = rectF;
        k();
        b(view);
    }

    public void g(@NonNull View view, @NonNull n nVar) {
        this.f81496c = nVar;
        k();
        b(view);
    }

    public void h(@NonNull View view, boolean z11) {
        if (z11 != this.f81494a) {
            this.f81494a = z11;
            b(view);
        }
    }

    public void i(@NonNull View view, boolean z11) {
        this.f81495b = z11;
        b(view);
    }

    public abstract boolean j();

    public final void k() {
        if (!d() || this.f81496c == null) {
            return;
        }
        o.k().d(this.f81496c, 1.0f, this.f81497d, this.f81498e);
    }
}
