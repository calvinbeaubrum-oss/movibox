package y3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.media3.common.i;
import com.google.common.base.j;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final CharSequence f81109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Layout.Alignment f81110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final Layout.Alignment f81111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final Bitmap f81112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f81113e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f81114f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f81115g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f81116h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f81117i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f81118j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f81119k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f81120l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f81121m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f81122n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f81123o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f81124p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float f81125q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Deprecated
    public static final a f81100r = new b().o("").a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f81101s = u0.E0(0);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f81102t = u0.E0(17);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f81103u = u0.E0(1);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f81104v = u0.E0(2);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f81105w = u0.E0(3);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f81106x = u0.E0(18);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f81107y = u0.E0(4);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f81108z = u0.E0(5);
    public static final String A = u0.E0(6);
    public static final String B = u0.E0(7);
    public static final String C = u0.E0(8);
    public static final String D = u0.E0(9);
    public static final String E = u0.E0(10);
    public static final String F = u0.E0(11);
    public static final String G = u0.E0(12);
    public static final String H = u0.E0(13);
    public static final String I = u0.E0(14);
    public static final String J = u0.E0(15);
    public static final String K = u0.E0(16);

    @Deprecated
    public static final i<a> L = new androidx.media3.common.b();

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public CharSequence f81126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public Bitmap f81127b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public Layout.Alignment f81128c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public Layout.Alignment f81129d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f81130e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f81131f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f81132g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f81133h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f81134i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f81135j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f81136k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f81137l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f81138m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f81139n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f81140o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f81141p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public float f81142q;

        public b() {
            this.f81126a = null;
            this.f81127b = null;
            this.f81128c = null;
            this.f81129d = null;
            this.f81130e = -3.4028235E38f;
            this.f81131f = Integer.MIN_VALUE;
            this.f81132g = Integer.MIN_VALUE;
            this.f81133h = -3.4028235E38f;
            this.f81134i = Integer.MIN_VALUE;
            this.f81135j = Integer.MIN_VALUE;
            this.f81136k = -3.4028235E38f;
            this.f81137l = -3.4028235E38f;
            this.f81138m = -3.4028235E38f;
            this.f81139n = false;
            this.f81140o = ViewCompat.MEASURED_STATE_MASK;
            this.f81141p = Integer.MIN_VALUE;
        }

        public b(a aVar) {
            this.f81126a = aVar.f81109a;
            this.f81127b = aVar.f81112d;
            this.f81128c = aVar.f81110b;
            this.f81129d = aVar.f81111c;
            this.f81130e = aVar.f81113e;
            this.f81131f = aVar.f81114f;
            this.f81132g = aVar.f81115g;
            this.f81133h = aVar.f81116h;
            this.f81134i = aVar.f81117i;
            this.f81135j = aVar.f81122n;
            this.f81136k = aVar.f81123o;
            this.f81137l = aVar.f81118j;
            this.f81138m = aVar.f81119k;
            this.f81139n = aVar.f81120l;
            this.f81140o = aVar.f81121m;
            this.f81141p = aVar.f81124p;
            this.f81142q = aVar.f81125q;
        }

        public a a() {
            return new a(this.f81126a, this.f81128c, this.f81129d, this.f81127b, this.f81130e, this.f81131f, this.f81132g, this.f81133h, this.f81134i, this.f81135j, this.f81136k, this.f81137l, this.f81138m, this.f81139n, this.f81140o, this.f81141p, this.f81142q);
        }

        public b b() {
            this.f81139n = false;
            return this;
        }

        public int c() {
            return this.f81132g;
        }

        public int d() {
            return this.f81134i;
        }

        @Nullable
        public CharSequence e() {
            return this.f81126a;
        }

        public b f(Bitmap bitmap) {
            this.f81127b = bitmap;
            return this;
        }

        public b g(float f11) {
            this.f81138m = f11;
            return this;
        }

        public b h(float f11, int i11) {
            this.f81130e = f11;
            this.f81131f = i11;
            return this;
        }

        public b i(int i11) {
            this.f81132g = i11;
            return this;
        }

        public b j(@Nullable Layout.Alignment alignment) {
            this.f81129d = alignment;
            return this;
        }

        public b k(float f11) {
            this.f81133h = f11;
            return this;
        }

        public b l(int i11) {
            this.f81134i = i11;
            return this;
        }

        public b m(float f11) {
            this.f81142q = f11;
            return this;
        }

        public b n(float f11) {
            this.f81137l = f11;
            return this;
        }

        public b o(CharSequence charSequence) {
            this.f81126a = charSequence;
            return this;
        }

        public b p(@Nullable Layout.Alignment alignment) {
            this.f81128c = alignment;
            return this;
        }

        public b q(float f11, int i11) {
            this.f81136k = f11;
            this.f81135j = i11;
            return this;
        }

        public b r(int i11) {
            this.f81141p = i11;
            return this;
        }

        public b s(int i11) {
            this.f81140o = i11;
            this.f81139n = true;
            return this;
        }
    }

    public a(@Nullable CharSequence charSequence, @Nullable Layout.Alignment alignment, @Nullable Layout.Alignment alignment2, @Nullable Bitmap bitmap, float f11, int i11, int i12, float f12, int i13, int i14, float f13, float f14, float f15, boolean z11, int i15, int i16, float f16) {
        if (charSequence == null) {
            z3.a.e(bitmap);
        } else {
            z3.a.a(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.f81109a = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.f81109a = charSequence.toString();
        } else {
            this.f81109a = null;
        }
        this.f81110b = alignment;
        this.f81111c = alignment2;
        this.f81112d = bitmap;
        this.f81113e = f11;
        this.f81114f = i11;
        this.f81115g = i12;
        this.f81116h = f12;
        this.f81117i = i13;
        this.f81118j = f14;
        this.f81119k = f15;
        this.f81120l = z11;
        this.f81121m = i15;
        this.f81122n = i14;
        this.f81123o = f13;
        this.f81124p = i16;
        this.f81125q = f16;
    }

    public static a b(Bundle bundle) {
        b bVar = new b();
        CharSequence charSequence = bundle.getCharSequence(f81101s);
        if (charSequence != null) {
            bVar.o(charSequence);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(f81102t);
            if (parcelableArrayList != null) {
                SpannableString spannableStringValueOf = SpannableString.valueOf(charSequence);
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    c.c((Bundle) it.next(), spannableStringValueOf);
                }
                bVar.o(spannableStringValueOf);
            }
        }
        Layout.Alignment alignment = (Layout.Alignment) bundle.getSerializable(f81103u);
        if (alignment != null) {
            bVar.p(alignment);
        }
        Layout.Alignment alignment2 = (Layout.Alignment) bundle.getSerializable(f81104v);
        if (alignment2 != null) {
            bVar.j(alignment2);
        }
        Bitmap bitmap = (Bitmap) bundle.getParcelable(f81105w);
        if (bitmap != null) {
            bVar.f(bitmap);
        } else {
            byte[] byteArray = bundle.getByteArray(f81106x);
            if (byteArray != null) {
                bVar.f(BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length));
            }
        }
        String str = f81107y;
        if (bundle.containsKey(str)) {
            String str2 = f81108z;
            if (bundle.containsKey(str2)) {
                bVar.h(bundle.getFloat(str), bundle.getInt(str2));
            }
        }
        String str3 = A;
        if (bundle.containsKey(str3)) {
            bVar.i(bundle.getInt(str3));
        }
        String str4 = B;
        if (bundle.containsKey(str4)) {
            bVar.k(bundle.getFloat(str4));
        }
        String str5 = C;
        if (bundle.containsKey(str5)) {
            bVar.l(bundle.getInt(str5));
        }
        String str6 = E;
        if (bundle.containsKey(str6)) {
            String str7 = D;
            if (bundle.containsKey(str7)) {
                bVar.q(bundle.getFloat(str6), bundle.getInt(str7));
            }
        }
        String str8 = F;
        if (bundle.containsKey(str8)) {
            bVar.n(bundle.getFloat(str8));
        }
        String str9 = G;
        if (bundle.containsKey(str9)) {
            bVar.g(bundle.getFloat(str9));
        }
        String str10 = H;
        if (bundle.containsKey(str10)) {
            bVar.s(bundle.getInt(str10));
        }
        if (!bundle.getBoolean(I, false)) {
            bVar.b();
        }
        String str11 = J;
        if (bundle.containsKey(str11)) {
            bVar.r(bundle.getInt(str11));
        }
        String str12 = K;
        if (bundle.containsKey(str12)) {
            bVar.m(bundle.getFloat(str12));
        }
        return bVar.a();
    }

    public b a() {
        return new b();
    }

    public final Bundle c() {
        Bundle bundle = new Bundle();
        CharSequence charSequence = this.f81109a;
        if (charSequence != null) {
            bundle.putCharSequence(f81101s, charSequence);
            CharSequence charSequence2 = this.f81109a;
            if (charSequence2 instanceof Spanned) {
                ArrayList<Bundle> arrayListA = c.a((Spanned) charSequence2);
                if (!arrayListA.isEmpty()) {
                    bundle.putParcelableArrayList(f81102t, arrayListA);
                }
            }
        }
        bundle.putSerializable(f81103u, this.f81110b);
        bundle.putSerializable(f81104v, this.f81111c);
        bundle.putFloat(f81107y, this.f81113e);
        bundle.putInt(f81108z, this.f81114f);
        bundle.putInt(A, this.f81115g);
        bundle.putFloat(B, this.f81116h);
        bundle.putInt(C, this.f81117i);
        bundle.putInt(D, this.f81122n);
        bundle.putFloat(E, this.f81123o);
        bundle.putFloat(F, this.f81118j);
        bundle.putFloat(G, this.f81119k);
        bundle.putBoolean(I, this.f81120l);
        bundle.putInt(H, this.f81121m);
        bundle.putInt(J, this.f81124p);
        bundle.putFloat(K, this.f81125q);
        return bundle;
    }

    public Bundle d() {
        Bundle bundleC = c();
        if (this.f81112d != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            z3.a.g(this.f81112d.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream));
            bundleC.putByteArray(f81106x, byteArrayOutputStream.toByteArray());
        }
        return bundleC;
    }

    public boolean equals(@Nullable Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return TextUtils.equals(this.f81109a, aVar.f81109a) && this.f81110b == aVar.f81110b && this.f81111c == aVar.f81111c && ((bitmap = this.f81112d) != null ? !((bitmap2 = aVar.f81112d) == null || !bitmap.sameAs(bitmap2)) : aVar.f81112d == null) && this.f81113e == aVar.f81113e && this.f81114f == aVar.f81114f && this.f81115g == aVar.f81115g && this.f81116h == aVar.f81116h && this.f81117i == aVar.f81117i && this.f81118j == aVar.f81118j && this.f81119k == aVar.f81119k && this.f81120l == aVar.f81120l && this.f81121m == aVar.f81121m && this.f81122n == aVar.f81122n && this.f81123o == aVar.f81123o && this.f81124p == aVar.f81124p && this.f81125q == aVar.f81125q;
    }

    public int hashCode() {
        return j.b(this.f81109a, this.f81110b, this.f81111c, this.f81112d, Float.valueOf(this.f81113e), Integer.valueOf(this.f81114f), Integer.valueOf(this.f81115g), Float.valueOf(this.f81116h), Integer.valueOf(this.f81117i), Float.valueOf(this.f81118j), Float.valueOf(this.f81119k), Boolean.valueOf(this.f81120l), Integer.valueOf(this.f81121m), Integer.valueOf(this.f81122n), Float.valueOf(this.f81123o), Integer.valueOf(this.f81124p), Float.valueOf(this.f81125q));
    }
}
