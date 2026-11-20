package androidx.core.view;

import android.os.Build;
import android.view.ViewStructure;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class ViewStructureCompat {
    private final Object mWrappedObj;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    public static class a {
        public static void a(ViewStructure viewStructure, String str) {
            viewStructure.setClassName(str);
        }

        public static void b(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setContentDescription(charSequence);
        }

        public static void c(ViewStructure viewStructure, int i11, int i12, int i13, int i14, int i15, int i16) {
            viewStructure.setDimens(i11, i12, i13, i14, i15, i16);
        }

        public static void d(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setText(charSequence);
        }
    }

    private ViewStructureCompat(@NonNull ViewStructure viewStructure) {
        this.mWrappedObj = viewStructure;
    }

    @NonNull
    @RequiresApi(23)
    public static ViewStructureCompat toViewStructureCompat(@NonNull ViewStructure viewStructure) {
        return new ViewStructureCompat(viewStructure);
    }

    public void setClassName(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.a(j2.d.a(this.mWrappedObj), str);
        }
    }

    public void setContentDescription(@NonNull CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.b(j2.d.a(this.mWrappedObj), charSequence);
        }
    }

    public void setDimens(int i11, int i12, int i13, int i14, int i15, int i16) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.c(j2.d.a(this.mWrappedObj), i11, i12, i13, i14, i15, i16);
        }
    }

    public void setText(@NonNull CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.d(j2.d.a(this.mWrappedObj), charSequence);
        }
    }

    @NonNull
    @RequiresApi(23)
    public ViewStructure toViewStructure() {
        return j2.d.a(this.mWrappedObj);
    }
}
