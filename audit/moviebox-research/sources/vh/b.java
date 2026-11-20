package vh;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements com.google.android.exoplayer2.g {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final b f78816s = new C0875b().o("").a();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final com.google.android.exoplayer2.g.a<b> f78817t = new com.google.android.exoplayer2.g.a() { // from class: vh.a
        @Override // com.google.android.exoplayer2.g.a
        public final com.google.android.exoplayer2.g a(Bundle bundle) {
            return b.c(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final CharSequence f78818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Layout.Alignment f78819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final Layout.Alignment f78820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final Bitmap f78821d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f78822f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f78823g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f78824h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f78825i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f78826j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f78827k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f78828l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f78829m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f78830n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f78831o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f78832p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f78833q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float f78834r;

    /* JADX INFO: renamed from: vh.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0875b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public CharSequence f78835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public Bitmap f78836b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public Layout.Alignment f78837c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public Layout.Alignment f78838d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f78839e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f78840f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f78841g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f78842h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f78843i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f78844j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f78845k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f78846l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f78847m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f78848n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f78849o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f78850p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public float f78851q;

        public C0875b() {
            this.f78835a = null;
            this.f78836b = null;
            this.f78837c = null;
            this.f78838d = null;
            this.f78839e = -3.4028235E38f;
            this.f78840f = Integer.MIN_VALUE;
            this.f78841g = Integer.MIN_VALUE;
            this.f78842h = -3.4028235E38f;
            this.f78843i = Integer.MIN_VALUE;
            this.f78844j = Integer.MIN_VALUE;
            this.f78845k = -3.4028235E38f;
            this.f78846l = -3.4028235E38f;
            this.f78847m = -3.4028235E38f;
            this.f78848n = false;
            this.f78849o = ViewCompat.MEASURED_STATE_MASK;
            this.f78850p = Integer.MIN_VALUE;
        }

        public C0875b(b bVar) {
            this.f78835a = bVar.f78818a;
            this.f78836b = bVar.f78821d;
            this.f78837c = bVar.f78819b;
            this.f78838d = bVar.f78820c;
            this.f78839e = bVar.f78822f;
            this.f78840f = bVar.f78823g;
            this.f78841g = bVar.f78824h;
            this.f78842h = bVar.f78825i;
            this.f78843i = bVar.f78826j;
            this.f78844j = bVar.f78831o;
            this.f78845k = bVar.f78832p;
            this.f78846l = bVar.f78827k;
            this.f78847m = bVar.f78828l;
            this.f78848n = bVar.f78829m;
            this.f78849o = bVar.f78830n;
            this.f78850p = bVar.f78833q;
            this.f78851q = bVar.f78834r;
        }

        public b a() {
            return new b(this.f78835a, this.f78837c, this.f78838d, this.f78836b, this.f78839e, this.f78840f, this.f78841g, this.f78842h, this.f78843i, this.f78844j, this.f78845k, this.f78846l, this.f78847m, this.f78848n, this.f78849o, this.f78850p, this.f78851q);
        }

        public C0875b b() {
            this.f78848n = false;
            return this;
        }

        public int c() {
            return this.f78841g;
        }

        public int d() {
            return this.f78843i;
        }

        @Nullable
        public CharSequence e() {
            return this.f78835a;
        }

        public C0875b f(Bitmap bitmap) {
            this.f78836b = bitmap;
            return this;
        }

        public C0875b g(float f11) {
            this.f78847m = f11;
            return this;
        }

        public C0875b h(float f11, int i11) {
            this.f78839e = f11;
            this.f78840f = i11;
            return this;
        }

        public C0875b i(int i11) {
            this.f78841g = i11;
            return this;
        }

        public C0875b j(@Nullable Layout.Alignment alignment) {
            this.f78838d = alignment;
            return this;
        }

        public C0875b k(float f11) {
            this.f78842h = f11;
            return this;
        }

        public C0875b l(int i11) {
            this.f78843i = i11;
            return this;
        }

        public C0875b m(float f11) {
            this.f78851q = f11;
            return this;
        }

        public C0875b n(float f11) {
            this.f78846l = f11;
            return this;
        }

        public C0875b o(CharSequence charSequence) {
            this.f78835a = charSequence;
            return this;
        }

        public C0875b p(@Nullable Layout.Alignment alignment) {
            this.f78837c = alignment;
            return this;
        }

        public C0875b q(float f11, int i11) {
            this.f78845k = f11;
            this.f78844j = i11;
            return this;
        }

        public C0875b r(int i11) {
            this.f78850p = i11;
            return this;
        }

        public C0875b s(int i11) {
            this.f78849o = i11;
            this.f78848n = true;
            return this;
        }
    }

    public b(@Nullable CharSequence charSequence, @Nullable Layout.Alignment alignment, @Nullable Layout.Alignment alignment2, @Nullable Bitmap bitmap, float f11, int i11, int i12, float f12, int i13, int i14, float f13, float f14, float f15, boolean z11, int i15, int i16, float f16) {
        if (charSequence == null) {
            com.google.android.exoplayer2.util.a.e(bitmap);
        } else {
            com.google.android.exoplayer2.util.a.a(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.f78818a = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.f78818a = charSequence.toString();
        } else {
            this.f78818a = null;
        }
        this.f78819b = alignment;
        this.f78820c = alignment2;
        this.f78821d = bitmap;
        this.f78822f = f11;
        this.f78823g = i11;
        this.f78824h = i12;
        this.f78825i = f12;
        this.f78826j = i13;
        this.f78827k = f14;
        this.f78828l = f15;
        this.f78829m = z11;
        this.f78830n = i15;
        this.f78831o = i14;
        this.f78832p = f13;
        this.f78833q = i16;
        this.f78834r = f16;
    }

    public static final b c(Bundle bundle) {
        C0875b c0875b = new C0875b();
        CharSequence charSequence = bundle.getCharSequence(d(0));
        if (charSequence != null) {
            c0875b.o(charSequence);
        }
        Layout.Alignment alignment = (Layout.Alignment) bundle.getSerializable(d(1));
        if (alignment != null) {
            c0875b.p(alignment);
        }
        Layout.Alignment alignment2 = (Layout.Alignment) bundle.getSerializable(d(2));
        if (alignment2 != null) {
            c0875b.j(alignment2);
        }
        Bitmap bitmap = (Bitmap) bundle.getParcelable(d(3));
        if (bitmap != null) {
            c0875b.f(bitmap);
        }
        if (bundle.containsKey(d(4)) && bundle.containsKey(d(5))) {
            c0875b.h(bundle.getFloat(d(4)), bundle.getInt(d(5)));
        }
        if (bundle.containsKey(d(6))) {
            c0875b.i(bundle.getInt(d(6)));
        }
        if (bundle.containsKey(d(7))) {
            c0875b.k(bundle.getFloat(d(7)));
        }
        if (bundle.containsKey(d(8))) {
            c0875b.l(bundle.getInt(d(8)));
        }
        if (bundle.containsKey(d(10)) && bundle.containsKey(d(9))) {
            c0875b.q(bundle.getFloat(d(10)), bundle.getInt(d(9)));
        }
        if (bundle.containsKey(d(11))) {
            c0875b.n(bundle.getFloat(d(11)));
        }
        if (bundle.containsKey(d(12))) {
            c0875b.g(bundle.getFloat(d(12)));
        }
        if (bundle.containsKey(d(13))) {
            c0875b.s(bundle.getInt(d(13)));
        }
        if (!bundle.getBoolean(d(14), false)) {
            c0875b.b();
        }
        if (bundle.containsKey(d(15))) {
            c0875b.r(bundle.getInt(d(15)));
        }
        if (bundle.containsKey(d(16))) {
            c0875b.m(bundle.getFloat(d(16)));
        }
        return c0875b.a();
    }

    private static String d(int i11) {
        return Integer.toString(i11, 36);
    }

    public C0875b b() {
        return new C0875b();
    }

    public boolean equals(@Nullable Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return TextUtils.equals(this.f78818a, bVar.f78818a) && this.f78819b == bVar.f78819b && this.f78820c == bVar.f78820c && ((bitmap = this.f78821d) != null ? !((bitmap2 = bVar.f78821d) == null || !bitmap.sameAs(bitmap2)) : bVar.f78821d == null) && this.f78822f == bVar.f78822f && this.f78823g == bVar.f78823g && this.f78824h == bVar.f78824h && this.f78825i == bVar.f78825i && this.f78826j == bVar.f78826j && this.f78827k == bVar.f78827k && this.f78828l == bVar.f78828l && this.f78829m == bVar.f78829m && this.f78830n == bVar.f78830n && this.f78831o == bVar.f78831o && this.f78832p == bVar.f78832p && this.f78833q == bVar.f78833q && this.f78834r == bVar.f78834r;
    }

    public int hashCode() {
        return com.google.common.base.j.b(this.f78818a, this.f78819b, this.f78820c, this.f78821d, Float.valueOf(this.f78822f), Integer.valueOf(this.f78823g), Integer.valueOf(this.f78824h), Float.valueOf(this.f78825i), Integer.valueOf(this.f78826j), Float.valueOf(this.f78827k), Float.valueOf(this.f78828l), Boolean.valueOf(this.f78829m), Integer.valueOf(this.f78830n), Integer.valueOf(this.f78831o), Float.valueOf(this.f78832p), Integer.valueOf(this.f78833q), Float.valueOf(this.f78834r));
    }

    @Override // com.google.android.exoplayer2.g
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(d(0), this.f78818a);
        bundle.putSerializable(d(1), this.f78819b);
        bundle.putSerializable(d(2), this.f78820c);
        bundle.putParcelable(d(3), this.f78821d);
        bundle.putFloat(d(4), this.f78822f);
        bundle.putInt(d(5), this.f78823g);
        bundle.putInt(d(6), this.f78824h);
        bundle.putFloat(d(7), this.f78825i);
        bundle.putInt(d(8), this.f78826j);
        bundle.putInt(d(9), this.f78831o);
        bundle.putFloat(d(10), this.f78832p);
        bundle.putFloat(d(11), this.f78827k);
        bundle.putFloat(d(12), this.f78828l);
        bundle.putBoolean(d(14), this.f78829m);
        bundle.putInt(d(13), this.f78830n);
        bundle.putInt(d(15), this.f78833q);
        bundle.putFloat(d(16), this.f78834r);
        return bundle;
    }
}
