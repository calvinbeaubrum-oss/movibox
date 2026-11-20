package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class InputContentInfoCompat {
    private final c mImpl;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(25)
    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final InputContentInfo f8011a;

        public a(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
            this.f8011a = new InputContentInfo(uri, clipDescription, uri2);
        }

        public a(@NonNull Object obj) {
            this.f8011a = (InputContentInfo) obj;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        @NonNull
        public Object a() {
            return this.f8011a;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        @Nullable
        public Uri b() {
            return this.f8011a.getLinkUri();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        @NonNull
        public Uri c() {
            return this.f8011a.getContentUri();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        public void d() {
            this.f8011a.requestPermission();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        public void e() {
            this.f8011a.releasePermission();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        @NonNull
        public ClipDescription getDescription() {
            return this.f8011a.getDescription();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final Uri f8012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        public final ClipDescription f8013b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final Uri f8014c;

        public b(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
            this.f8012a = uri;
            this.f8013b = clipDescription;
            this.f8014c = uri2;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        @Nullable
        public Object a() {
            return null;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        @Nullable
        public Uri b() {
            return this.f8014c;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        @NonNull
        public Uri c() {
            return this.f8012a;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        public void d() {
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        public void e() {
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        @NonNull
        public ClipDescription getDescription() {
            return this.f8013b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        @Nullable
        Object a();

        @Nullable
        Uri b();

        @NonNull
        Uri c();

        void d();

        void e();

        @NonNull
        ClipDescription getDescription();
    }

    public InputContentInfoCompat(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.mImpl = new a(uri, clipDescription, uri2);
        } else {
            this.mImpl = new b(uri, clipDescription, uri2);
        }
    }

    private InputContentInfoCompat(@NonNull c cVar) {
        this.mImpl = cVar;
    }

    @Nullable
    public static InputContentInfoCompat wrap(@Nullable Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new InputContentInfoCompat(new a(obj));
        }
        return null;
    }

    @NonNull
    public Uri getContentUri() {
        return this.mImpl.c();
    }

    @NonNull
    public ClipDescription getDescription() {
        return this.mImpl.getDescription();
    }

    @Nullable
    public Uri getLinkUri() {
        return this.mImpl.b();
    }

    public void releasePermission() {
        this.mImpl.e();
    }

    public void requestPermission() {
        this.mImpl.d();
    }

    @Nullable
    public Object unwrap() {
        return this.mImpl.a();
    }
}
