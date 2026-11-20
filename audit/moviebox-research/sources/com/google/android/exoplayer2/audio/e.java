package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.o0;
import com.vungle.warren.error.VungleException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e implements com.google.android.exoplayer2.g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e f32806h = new C0359e().a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final com.google.android.exoplayer2.g.a<e> f32807i = new com.google.android.exoplayer2.g.a() { // from class: com.google.android.exoplayer2.audio.d
        @Override // com.google.android.exoplayer2.g.a
        public final com.google.android.exoplayer2.g a(Bundle bundle) {
            return e.d(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f32808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f32809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f32810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f32811d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f32812f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public d f32813g;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static final class b {
        public static void a(AudioAttributes.Builder builder, int i11) {
            builder.setAllowedCapturePolicy(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(32)
    public static final class c {
        public static void a(AudioAttributes.Builder builder, int i11) {
            builder.setSpatializationBehavior(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(21)
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AudioAttributes f32814a;

        public d(e eVar) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(eVar.f32808a).setFlags(eVar.f32809b).setUsage(eVar.f32810c);
            int i11 = o0.f35608a;
            if (i11 >= 29) {
                b.a(usage, eVar.f32811d);
            }
            if (i11 >= 32) {
                c.a(usage, eVar.f32812f);
            }
            this.f32814a = usage.build();
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.audio.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0359e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f32815a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f32816b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f32817c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f32818d = 1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f32819e = 0;

        public e a() {
            return new e(this.f32815a, this.f32816b, this.f32817c, this.f32818d, this.f32819e);
        }

        public C0359e b(int i11) {
            this.f32818d = i11;
            return this;
        }

        public C0359e c(int i11) {
            this.f32815a = i11;
            return this;
        }

        public C0359e d(int i11) {
            this.f32816b = i11;
            return this;
        }

        public C0359e e(int i11) {
            this.f32819e = i11;
            return this;
        }

        public C0359e f(int i11) {
            this.f32817c = i11;
            return this;
        }
    }

    public e(int i11, int i12, int i13, int i14, int i15) {
        this.f32808a = i11;
        this.f32809b = i12;
        this.f32810c = i13;
        this.f32811d = i14;
        this.f32812f = i15;
    }

    private static String c(int i11) {
        return Integer.toString(i11, 36);
    }

    public static /* synthetic */ e d(Bundle bundle) {
        C0359e c0359e = new C0359e();
        if (bundle.containsKey(c(0))) {
            c0359e.c(bundle.getInt(c(0)));
        }
        if (bundle.containsKey(c(1))) {
            c0359e.d(bundle.getInt(c(1)));
        }
        if (bundle.containsKey(c(2))) {
            c0359e.f(bundle.getInt(c(2)));
        }
        if (bundle.containsKey(c(3))) {
            c0359e.b(bundle.getInt(c(3)));
        }
        if (bundle.containsKey(c(4))) {
            c0359e.e(bundle.getInt(c(4)));
        }
        return c0359e.a();
    }

    @RequiresApi(21)
    public d b() {
        if (this.f32813g == null) {
            this.f32813g = new d();
        }
        return this.f32813g;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return this.f32808a == eVar.f32808a && this.f32809b == eVar.f32809b && this.f32810c == eVar.f32810c && this.f32811d == eVar.f32811d && this.f32812f == eVar.f32812f;
    }

    public int hashCode() {
        return ((((((((527 + this.f32808a) * 31) + this.f32809b) * 31) + this.f32810c) * 31) + this.f32811d) * 31) + this.f32812f;
    }

    @Override // com.google.android.exoplayer2.g
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(c(0), this.f32808a);
        bundle.putInt(c(1), this.f32809b);
        bundle.putInt(c(2), this.f32810c);
        bundle.putInt(c(3), this.f32811d);
        bundle.putInt(c(4), this.f32812f);
        return bundle;
    }
}
