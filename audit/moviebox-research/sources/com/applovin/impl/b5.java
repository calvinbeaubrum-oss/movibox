package com.applovin.impl;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.applovin.exoplayer2.common.base.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b5 implements o2 {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final b5 f17830s = new b().a("").a();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final o2.a f17831t = new o2.a() { // from class: com.applovin.impl.ct
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return b5.a(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f17832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Layout.Alignment f17833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Layout.Alignment f17834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bitmap f17835d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f17836f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f17837g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f17838h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f17839i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f17840j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f17841k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f17842l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f17843m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f17844n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f17845o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f17846p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f17847q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float f17848r;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private CharSequence f17849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Bitmap f17850b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Layout.Alignment f17851c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Layout.Alignment f17852d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f17853e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f17854f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f17855g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private float f17856h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f17857i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f17858j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private float f17859k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private float f17860l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private float f17861m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f17862n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f17863o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f17864p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private float f17865q;

        public b() {
            this.f17849a = null;
            this.f17850b = null;
            this.f17851c = null;
            this.f17852d = null;
            this.f17853e = -3.4028235E38f;
            this.f17854f = Integer.MIN_VALUE;
            this.f17855g = Integer.MIN_VALUE;
            this.f17856h = -3.4028235E38f;
            this.f17857i = Integer.MIN_VALUE;
            this.f17858j = Integer.MIN_VALUE;
            this.f17859k = -3.4028235E38f;
            this.f17860l = -3.4028235E38f;
            this.f17861m = -3.4028235E38f;
            this.f17862n = false;
            this.f17863o = ViewCompat.MEASURED_STATE_MASK;
            this.f17864p = Integer.MIN_VALUE;
        }

        private b(b5 b5Var) {
            this.f17849a = b5Var.f17832a;
            this.f17850b = b5Var.f17835d;
            this.f17851c = b5Var.f17833b;
            this.f17852d = b5Var.f17834c;
            this.f17853e = b5Var.f17836f;
            this.f17854f = b5Var.f17837g;
            this.f17855g = b5Var.f17838h;
            this.f17856h = b5Var.f17839i;
            this.f17857i = b5Var.f17840j;
            this.f17858j = b5Var.f17845o;
            this.f17859k = b5Var.f17846p;
            this.f17860l = b5Var.f17841k;
            this.f17861m = b5Var.f17842l;
            this.f17862n = b5Var.f17843m;
            this.f17863o = b5Var.f17844n;
            this.f17864p = b5Var.f17847q;
            this.f17865q = b5Var.f17848r;
        }

        public b a(float f11) {
            this.f17861m = f11;
            return this;
        }

        public b a(float f11, int i11) {
            this.f17853e = f11;
            this.f17854f = i11;
            return this;
        }

        public b a(int i11) {
            this.f17855g = i11;
            return this;
        }

        public b a(Bitmap bitmap) {
            this.f17850b = bitmap;
            return this;
        }

        public b a(Layout.Alignment alignment) {
            this.f17852d = alignment;
            return this;
        }

        public b a(CharSequence charSequence) {
            this.f17849a = charSequence;
            return this;
        }

        public b5 a() {
            return new b5(this.f17849a, this.f17851c, this.f17852d, this.f17850b, this.f17853e, this.f17854f, this.f17855g, this.f17856h, this.f17857i, this.f17858j, this.f17859k, this.f17860l, this.f17861m, this.f17862n, this.f17863o, this.f17864p, this.f17865q);
        }

        public b b() {
            this.f17862n = false;
            return this;
        }

        public b b(float f11) {
            this.f17856h = f11;
            return this;
        }

        public b b(float f11, int i11) {
            this.f17859k = f11;
            this.f17858j = i11;
            return this;
        }

        public b b(int i11) {
            this.f17857i = i11;
            return this;
        }

        public b b(Layout.Alignment alignment) {
            this.f17851c = alignment;
            return this;
        }

        public int c() {
            return this.f17855g;
        }

        public b c(float f11) {
            this.f17865q = f11;
            return this;
        }

        public b c(int i11) {
            this.f17864p = i11;
            return this;
        }

        public int d() {
            return this.f17857i;
        }

        public b d(float f11) {
            this.f17860l = f11;
            return this;
        }

        public b d(int i11) {
            this.f17863o = i11;
            this.f17862n = true;
            return this;
        }

        public CharSequence e() {
            return this.f17849a;
        }
    }

    private b5(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f11, int i11, int i12, float f12, int i13, int i14, float f13, float f14, float f15, boolean z11, int i15, int i16, float f16) {
        if (charSequence == null) {
            b1.a(bitmap);
        } else {
            b1.a(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.f17832a = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.f17832a = charSequence.toString();
        } else {
            this.f17832a = null;
        }
        this.f17833b = alignment;
        this.f17834c = alignment2;
        this.f17835d = bitmap;
        this.f17836f = f11;
        this.f17837g = i11;
        this.f17838h = i12;
        this.f17839i = f12;
        this.f17840j = i13;
        this.f17841k = f14;
        this.f17842l = f15;
        this.f17843m = z11;
        this.f17844n = i15;
        this.f17845o = i14;
        this.f17846p = f13;
        this.f17847q = i16;
        this.f17848r = f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b5 a(Bundle bundle) {
        b bVar = new b();
        CharSequence charSequence = bundle.getCharSequence(a(0));
        if (charSequence != null) {
            bVar.a(charSequence);
        }
        Layout.Alignment alignment = (Layout.Alignment) bundle.getSerializable(a(1));
        if (alignment != null) {
            bVar.b(alignment);
        }
        Layout.Alignment alignment2 = (Layout.Alignment) bundle.getSerializable(a(2));
        if (alignment2 != null) {
            bVar.a(alignment2);
        }
        Bitmap bitmap = (Bitmap) bundle.getParcelable(a(3));
        if (bitmap != null) {
            bVar.a(bitmap);
        }
        if (bundle.containsKey(a(4)) && bundle.containsKey(a(5))) {
            bVar.a(bundle.getFloat(a(4)), bundle.getInt(a(5)));
        }
        if (bundle.containsKey(a(6))) {
            bVar.a(bundle.getInt(a(6)));
        }
        if (bundle.containsKey(a(7))) {
            bVar.b(bundle.getFloat(a(7)));
        }
        if (bundle.containsKey(a(8))) {
            bVar.b(bundle.getInt(a(8)));
        }
        if (bundle.containsKey(a(10)) && bundle.containsKey(a(9))) {
            bVar.b(bundle.getFloat(a(10)), bundle.getInt(a(9)));
        }
        if (bundle.containsKey(a(11))) {
            bVar.d(bundle.getFloat(a(11)));
        }
        if (bundle.containsKey(a(12))) {
            bVar.a(bundle.getFloat(a(12)));
        }
        if (bundle.containsKey(a(13))) {
            bVar.d(bundle.getInt(a(13)));
        }
        if (!bundle.getBoolean(a(14), false)) {
            bVar.b();
        }
        if (bundle.containsKey(a(15))) {
            bVar.c(bundle.getInt(a(15)));
        }
        if (bundle.containsKey(a(16))) {
            bVar.c(bundle.getFloat(a(16)));
        }
        return bVar.a();
    }

    private static String a(int i11) {
        return Integer.toString(i11, 36);
    }

    public b a() {
        return new b();
    }

    public boolean equals(Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj == null || b5.class != obj.getClass()) {
            return false;
        }
        b5 b5Var = (b5) obj;
        return TextUtils.equals(this.f17832a, b5Var.f17832a) && this.f17833b == b5Var.f17833b && this.f17834c == b5Var.f17834c && ((bitmap = this.f17835d) != null ? !((bitmap2 = b5Var.f17835d) == null || !bitmap.sameAs(bitmap2)) : b5Var.f17835d == null) && this.f17836f == b5Var.f17836f && this.f17837g == b5Var.f17837g && this.f17838h == b5Var.f17838h && this.f17839i == b5Var.f17839i && this.f17840j == b5Var.f17840j && this.f17841k == b5Var.f17841k && this.f17842l == b5Var.f17842l && this.f17843m == b5Var.f17843m && this.f17844n == b5Var.f17844n && this.f17845o == b5Var.f17845o && this.f17846p == b5Var.f17846p && this.f17847q == b5Var.f17847q && this.f17848r == b5Var.f17848r;
    }

    public int hashCode() {
        return Objects.hashCode(this.f17832a, this.f17833b, this.f17834c, this.f17835d, Float.valueOf(this.f17836f), Integer.valueOf(this.f17837g), Integer.valueOf(this.f17838h), Float.valueOf(this.f17839i), Integer.valueOf(this.f17840j), Float.valueOf(this.f17841k), Float.valueOf(this.f17842l), Boolean.valueOf(this.f17843m), Integer.valueOf(this.f17844n), Integer.valueOf(this.f17845o), Float.valueOf(this.f17846p), Integer.valueOf(this.f17847q), Float.valueOf(this.f17848r));
    }
}
