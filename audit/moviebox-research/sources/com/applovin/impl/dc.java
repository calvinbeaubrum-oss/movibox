package com.applovin.impl;

import android.content.Context;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.applovin.sdk.R;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class dc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected c f18403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f18404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected SpannedString f18405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected SpannedString f18406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected String f18407e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected String f18408f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected int f18409g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected int f18410h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f18411i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected int f18412j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected int f18413k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected int f18414l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected boolean f18415m;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final c f18416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f18417b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        SpannedString f18418c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        SpannedString f18419d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        String f18420e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        String f18421f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f18422g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f18423h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f18424i = ViewCompat.MEASURED_STATE_MASK;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f18425j = ViewCompat.MEASURED_STATE_MASK;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f18426k = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f18427l = 0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f18428m;

        public b(c cVar) {
            this.f18416a = cVar;
        }

        public b a(int i11) {
            this.f18423h = i11;
            return this;
        }

        public b a(Context context) {
            this.f18423h = R.drawable.applovin_ic_disclosure_arrow;
            this.f18427l = t3.a(R.color.applovin_sdk_disclosureButtonColor, context);
            return this;
        }

        public b a(SpannedString spannedString) {
            this.f18419d = spannedString;
            return this;
        }

        public b a(String str) {
            this.f18421f = str;
            return this;
        }

        public b a(boolean z11) {
            this.f18417b = z11;
            return this;
        }

        public dc a() {
            return new dc(this);
        }

        public b b(int i11) {
            this.f18427l = i11;
            return this;
        }

        public b b(SpannedString spannedString) {
            this.f18418c = spannedString;
            return this;
        }

        public b b(String str) {
            this.f18420e = str;
            return this;
        }

        public b b(boolean z11) {
            this.f18428m = z11;
            return this;
        }

        public b c(int i11) {
            this.f18425j = i11;
            return this;
        }

        public b c(String str) {
            return a(!TextUtils.isEmpty(str) ? new SpannedString(str) : null);
        }

        public b d(int i11) {
            this.f18424i = i11;
            return this;
        }

        public b d(String str) {
            return b(!TextUtils.isEmpty(str) ? new SpannedString(str) : null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum c {
        SECTION(0),
        SECTION_CENTERED(1),
        SIMPLE(2),
        DETAIL(3),
        RIGHT_DETAIL(4),
        COUNT(5);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f18436a;

        c(int i11) {
            this.f18436a = i11;
        }

        public int b() {
            if (this == SECTION) {
                return R.layout.mediation_debugger_list_section;
            }
            if (this == SECTION_CENTERED) {
                return R.layout.mediation_debugger_list_section_centered;
            }
            if (this == SIMPLE) {
                return android.R.layout.simple_list_item_1;
            }
            return this == DETAIL ? R.layout.applovin_debugger_list_item_detail : R.layout.mediation_debugger_list_item_right_detail;
        }

        public int c() {
            return this.f18436a;
        }
    }

    private dc(b bVar) {
        this.f18409g = 0;
        this.f18410h = 0;
        this.f18411i = ViewCompat.MEASURED_STATE_MASK;
        this.f18412j = ViewCompat.MEASURED_STATE_MASK;
        this.f18413k = 0;
        this.f18414l = 0;
        this.f18403a = bVar.f18416a;
        this.f18404b = bVar.f18417b;
        this.f18405c = bVar.f18418c;
        this.f18406d = bVar.f18419d;
        this.f18407e = bVar.f18420e;
        this.f18408f = bVar.f18421f;
        this.f18409g = bVar.f18422g;
        this.f18410h = bVar.f18423h;
        this.f18411i = bVar.f18424i;
        this.f18412j = bVar.f18425j;
        this.f18413k = bVar.f18426k;
        this.f18414l = bVar.f18427l;
        this.f18415m = bVar.f18428m;
    }

    public dc(c cVar) {
        this.f18409g = 0;
        this.f18410h = 0;
        this.f18411i = ViewCompat.MEASURED_STATE_MASK;
        this.f18412j = ViewCompat.MEASURED_STATE_MASK;
        this.f18413k = 0;
        this.f18414l = 0;
        this.f18403a = cVar;
    }

    public static b a() {
        return a(c.RIGHT_DETAIL);
    }

    public static b a(c cVar) {
        return new b(cVar);
    }

    public static int n() {
        return c.COUNT.c();
    }

    public String b() {
        return this.f18408f;
    }

    public String c() {
        return this.f18407e;
    }

    public int d() {
        return this.f18410h;
    }

    public int e() {
        return this.f18414l;
    }

    public SpannedString f() {
        return this.f18406d;
    }

    public int g() {
        return this.f18412j;
    }

    public int h() {
        return this.f18409g;
    }

    public int i() {
        return this.f18413k;
    }

    public int j() {
        return this.f18403a.b();
    }

    public SpannedString k() {
        return this.f18405c;
    }

    public int l() {
        return this.f18411i;
    }

    public int m() {
        return this.f18403a.c();
    }

    public boolean o() {
        return this.f18404b;
    }

    public boolean p() {
        return this.f18415m;
    }
}
