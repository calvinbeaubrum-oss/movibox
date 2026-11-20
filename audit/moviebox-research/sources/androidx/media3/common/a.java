package androidx.media3.common;

import android.view.View;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f8898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f8900c;

    /* JADX INFO: renamed from: androidx.media3.common.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0087a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f8901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8902b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public String f8903c;

        public C0087a(View view, int i11) {
            this.f8901a = view;
            this.f8902b = i11;
        }

        public a a() {
            return new a(this.f8901a, this.f8902b, this.f8903c);
        }

        public C0087a b(@Nullable String str) {
            this.f8903c = str;
            return this;
        }
    }

    @Deprecated
    public a(View view, int i11, @Nullable String str) {
        this.f8898a = view;
        this.f8899b = i11;
        this.f8900c = str;
    }
}
