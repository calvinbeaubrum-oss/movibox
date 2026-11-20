package j2;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f67816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f67817b;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    public static class a {
        public static Bundle a(ViewStructure viewStructure) {
            return viewStructure.getExtras();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static class b {
        public static AutofillId a(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j11) {
            return contentCaptureSession.newAutofillId(autofillId, j11);
        }

        public static ViewStructure b(ContentCaptureSession contentCaptureSession, View view) {
            return contentCaptureSession.newViewStructure(view);
        }

        public static ViewStructure c(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j11) {
            return contentCaptureSession.newVirtualViewStructure(autofillId, j11);
        }

        public static void d(ContentCaptureSession contentCaptureSession, ViewStructure viewStructure) {
            contentCaptureSession.notifyViewAppeared(viewStructure);
        }

        public static void e(ContentCaptureSession contentCaptureSession, AutofillId autofillId, CharSequence charSequence) {
            contentCaptureSession.notifyViewTextChanged(autofillId, charSequence);
        }

        public static void f(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long[] jArr) {
            contentCaptureSession.notifyViewsDisappeared(autofillId, jArr);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(34)
    public static class c {
        public static void a(ContentCaptureSession contentCaptureSession, List<ViewStructure> list) {
            contentCaptureSession.notifyViewsAppeared(list);
        }
    }

    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public e(@NonNull ContentCaptureSession contentCaptureSession, @NonNull View view) {
        this.f67816a = contentCaptureSession;
        this.f67817b = view;
    }

    @NonNull
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static e f(@NonNull ContentCaptureSession contentCaptureSession, @NonNull View view) {
        return new e(contentCaptureSession, view);
    }

    @Nullable
    public AutofillId a(long j11) {
        if (Build.VERSION.SDK_INT < 29) {
            return null;
        }
        ContentCaptureSession contentCaptureSessionA = j2.c.a(this.f67816a);
        j2.b bVarA = f.a(this.f67817b);
        Objects.requireNonNull(bVarA);
        return b.a(contentCaptureSessionA, bVarA.a(), j11);
    }

    @Nullable
    public g b(@NonNull AutofillId autofillId, long j11) {
        if (Build.VERSION.SDK_INT >= 29) {
            return g.i(b.c(j2.c.a(this.f67816a), autofillId, j11));
        }
        return null;
    }

    public void c(@NonNull AutofillId autofillId, @Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 29) {
            b.e(j2.c.a(this.f67816a), autofillId, charSequence);
        }
    }

    public void d(@NonNull List<ViewStructure> list) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 34) {
            c.a(j2.c.a(this.f67816a), list);
            return;
        }
        if (i11 >= 29) {
            ViewStructure viewStructureB = b.b(j2.c.a(this.f67816a), this.f67817b);
            a.a(viewStructureB).putBoolean("TREAT_AS_VIEW_TREE_APPEARING", true);
            b.d(j2.c.a(this.f67816a), viewStructureB);
            for (int i12 = 0; i12 < list.size(); i12++) {
                b.d(j2.c.a(this.f67816a), d.a(list.get(i12)));
            }
            ViewStructure viewStructureB2 = b.b(j2.c.a(this.f67816a), this.f67817b);
            a.a(viewStructureB2).putBoolean("TREAT_AS_VIEW_TREE_APPEARED", true);
            b.d(j2.c.a(this.f67816a), viewStructureB2);
        }
    }

    public void e(@NonNull long[] jArr) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 34) {
            ContentCaptureSession contentCaptureSessionA = j2.c.a(this.f67816a);
            j2.b bVarA = f.a(this.f67817b);
            Objects.requireNonNull(bVarA);
            b.f(contentCaptureSessionA, bVarA.a(), jArr);
            return;
        }
        if (i11 >= 29) {
            ViewStructure viewStructureB = b.b(j2.c.a(this.f67816a), this.f67817b);
            a.a(viewStructureB).putBoolean("TREAT_AS_VIEW_TREE_APPEARING", true);
            b.d(j2.c.a(this.f67816a), viewStructureB);
            ContentCaptureSession contentCaptureSessionA2 = j2.c.a(this.f67816a);
            j2.b bVarA2 = f.a(this.f67817b);
            Objects.requireNonNull(bVarA2);
            b.f(contentCaptureSessionA2, bVarA2.a(), jArr);
            ViewStructure viewStructureB2 = b.b(j2.c.a(this.f67816a), this.f67817b);
            a.a(viewStructureB2).putBoolean("TREAT_AS_VIEW_TREE_APPEARED", true);
            b.d(j2.c.a(this.f67816a), viewStructureB2);
        }
    }
}
