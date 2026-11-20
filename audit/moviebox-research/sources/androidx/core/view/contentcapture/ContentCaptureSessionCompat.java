package androidx.core.view.contentcapture;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewStructureCompat;
import androidx.core.view.autofill.AutofillIdCompat;
import com.vungle.warren.error.VungleException;
import j2.d;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class ContentCaptureSessionCompat {
    private static final String KEY_VIEW_TREE_APPEARED = "TREAT_AS_VIEW_TREE_APPEARED";
    private static final String KEY_VIEW_TREE_APPEARING = "TREAT_AS_VIEW_TREE_APPEARING";
    private final View mView;
    private final Object mWrappedObj;

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
    private ContentCaptureSessionCompat(@NonNull ContentCaptureSession contentCaptureSession, @NonNull View view) {
        this.mWrappedObj = contentCaptureSession;
        this.mView = view;
    }

    @NonNull
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static ContentCaptureSessionCompat toContentCaptureSessionCompat(@NonNull ContentCaptureSession contentCaptureSession, @NonNull View view) {
        return new ContentCaptureSessionCompat(contentCaptureSession, view);
    }

    @Nullable
    public AutofillId newAutofillId(long j11) {
        if (Build.VERSION.SDK_INT < 29) {
            return null;
        }
        ContentCaptureSession contentCaptureSessionA = j2.c.a(this.mWrappedObj);
        AutofillIdCompat autofillId = ViewCompat.getAutofillId(this.mView);
        Objects.requireNonNull(autofillId);
        return b.a(contentCaptureSessionA, autofillId.toAutofillId(), j11);
    }

    @Nullable
    public ViewStructureCompat newVirtualViewStructure(@NonNull AutofillId autofillId, long j11) {
        if (Build.VERSION.SDK_INT >= 29) {
            return ViewStructureCompat.toViewStructureCompat(b.c(j2.c.a(this.mWrappedObj), autofillId, j11));
        }
        return null;
    }

    public void notifyViewTextChanged(@NonNull AutofillId autofillId, @Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 29) {
            b.e(j2.c.a(this.mWrappedObj), autofillId, charSequence);
        }
    }

    public void notifyViewsAppeared(@NonNull List<ViewStructure> list) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 34) {
            c.a(j2.c.a(this.mWrappedObj), list);
            return;
        }
        if (i11 >= 29) {
            ViewStructure viewStructureB = b.b(j2.c.a(this.mWrappedObj), this.mView);
            a.a(viewStructureB).putBoolean(KEY_VIEW_TREE_APPEARING, true);
            b.d(j2.c.a(this.mWrappedObj), viewStructureB);
            for (int i12 = 0; i12 < list.size(); i12++) {
                b.d(j2.c.a(this.mWrappedObj), d.a(list.get(i12)));
            }
            ViewStructure viewStructureB2 = b.b(j2.c.a(this.mWrappedObj), this.mView);
            a.a(viewStructureB2).putBoolean(KEY_VIEW_TREE_APPEARED, true);
            b.d(j2.c.a(this.mWrappedObj), viewStructureB2);
        }
    }

    public void notifyViewsDisappeared(@NonNull long[] jArr) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 34) {
            ContentCaptureSession contentCaptureSessionA = j2.c.a(this.mWrappedObj);
            AutofillIdCompat autofillId = ViewCompat.getAutofillId(this.mView);
            Objects.requireNonNull(autofillId);
            b.f(contentCaptureSessionA, autofillId.toAutofillId(), jArr);
            return;
        }
        if (i11 >= 29) {
            ViewStructure viewStructureB = b.b(j2.c.a(this.mWrappedObj), this.mView);
            a.a(viewStructureB).putBoolean(KEY_VIEW_TREE_APPEARING, true);
            b.d(j2.c.a(this.mWrappedObj), viewStructureB);
            ContentCaptureSession contentCaptureSessionA2 = j2.c.a(this.mWrappedObj);
            AutofillIdCompat autofillId2 = ViewCompat.getAutofillId(this.mView);
            Objects.requireNonNull(autofillId2);
            b.f(contentCaptureSessionA2, autofillId2.toAutofillId(), jArr);
            ViewStructure viewStructureB2 = b.b(j2.c.a(this.mWrappedObj), this.mView);
            a.a(viewStructureB2).putBoolean(KEY_VIEW_TREE_APPEARED, true);
            b.d(j2.c.a(this.mWrappedObj), viewStructureB2);
        }
    }

    @NonNull
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public ContentCaptureSession toContentCaptureSession() {
        return j2.c.a(this.mWrappedObj);
    }
}
