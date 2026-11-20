package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(19)
public class o {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadLocal<androidx.emoji2.text.flatbuffer.a> f8374d = new ThreadLocal<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final m f8376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f8377c = 0;

    public o(@NonNull m mVar, int i11) {
        this.f8376b = mVar;
        this.f8375a = i11;
    }

    public void a(@NonNull Canvas canvas, float f11, float f12, @NonNull Paint paint) {
        Typeface typefaceG = this.f8376b.g();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(typefaceG);
        canvas.drawText(this.f8376b.c(), this.f8375a * 2, 2, f11, f12, paint);
        paint.setTypeface(typeface);
    }

    public int b(int i11) {
        return g().i(i11);
    }

    public int c() {
        return g().j();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int d() {
        return this.f8377c & 3;
    }

    public int e() {
        return g().l();
    }

    public int f() {
        return g().m();
    }

    public final androidx.emoji2.text.flatbuffer.a g() {
        ThreadLocal<androidx.emoji2.text.flatbuffer.a> threadLocal = f8374d;
        androidx.emoji2.text.flatbuffer.a aVar = threadLocal.get();
        if (aVar == null) {
            aVar = new androidx.emoji2.text.flatbuffer.a();
            threadLocal.set(aVar);
        }
        this.f8376b.d().k(aVar, this.f8375a);
        return aVar;
    }

    public short h() {
        return g().n();
    }

    public int i() {
        return g().o();
    }

    public boolean j() {
        return g().k();
    }

    public boolean k() {
        return (this.f8377c & 4) > 0;
    }

    public void l(boolean z11) {
        int iD = d();
        if (z11) {
            this.f8377c = iD | 4;
        } else {
            this.f8377c = iD;
        }
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void m(boolean z11) {
        int i11 = this.f8377c & 4;
        this.f8377c = z11 ? i11 | 2 : i11 | 1;
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(", id:");
        sb2.append(Integer.toHexString(f()));
        sb2.append(", codepoints:");
        int iC = c();
        for (int i11 = 0; i11 < iC; i11++) {
            sb2.append(Integer.toHexString(b(i11)));
            sb2.append(" ");
        }
        return sb2.toString();
    }
}
