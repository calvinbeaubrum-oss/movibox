package j2;

import android.os.Build;
import android.os.Bundle;
import android.view.ViewStructure;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f67818a;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    public static class a {
        public static Bundle a(ViewStructure viewStructure) {
            return viewStructure.getExtras();
        }

        public static void b(ViewStructure viewStructure, String str) {
            viewStructure.setClassName(str);
        }

        public static void c(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setContentDescription(charSequence);
        }

        public static void d(ViewStructure viewStructure, int i11, int i12, int i13, int i14, int i15, int i16) {
            viewStructure.setDimens(i11, i12, i13, i14, i15, i16);
        }

        public static void e(ViewStructure viewStructure, int i11, String str, String str2, String str3) {
            viewStructure.setId(i11, str, str2, str3);
        }

        public static void f(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setText(charSequence);
        }

        public static void g(ViewStructure viewStructure, float f11, int i11, int i12, int i13) {
            viewStructure.setTextStyle(f11, i11, i12, i13);
        }
    }

    public g(@NonNull ViewStructure viewStructure) {
        this.f67818a = viewStructure;
    }

    @NonNull
    @RequiresApi(23)
    public static g i(@NonNull ViewStructure viewStructure) {
        return new g(viewStructure);
    }

    @Nullable
    public Bundle a() {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.a(d.a(this.f67818a));
        }
        return null;
    }

    public void b(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.b(d.a(this.f67818a), str);
        }
    }

    public void c(@NonNull CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.c(d.a(this.f67818a), charSequence);
        }
    }

    public void d(int i11, int i12, int i13, int i14, int i15, int i16) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.d(d.a(this.f67818a), i11, i12, i13, i14, i15, i16);
        }
    }

    public void e(int i11, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.e(d.a(this.f67818a), i11, str, str2, str3);
        }
    }

    public void f(@NonNull CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.f(d.a(this.f67818a), charSequence);
        }
    }

    public void g(float f11, int i11, int i12, int i13) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.g(d.a(this.f67818a), f11, i11, i12, i13);
        }
    }

    @NonNull
    @RequiresApi(23)
    public ViewStructure h() {
        return d.a(this.f67818a);
    }
}
