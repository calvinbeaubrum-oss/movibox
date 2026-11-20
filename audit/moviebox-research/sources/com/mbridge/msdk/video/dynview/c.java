package com.mbridge.msdk.video.dynview;

import android.content.Context;
import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f47543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f47544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f47545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f47546d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f47547e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f47548f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f47549g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f47550h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<CampaignEx> f47551i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f47552j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f47553k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List<String> f47554l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f47555m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f47556n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f47557o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f47558p;

    /* JADX INFO: compiled from: source.java */
    public static class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f47559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f47560b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f47561c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f47562d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f47563e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f47564f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f47565g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private View f47566h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private List<CampaignEx> f47567i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f47568j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f47569k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private List<String> f47570l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f47571m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private String f47572n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f47573o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f47574p = 1;

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b a(float f11) {
            this.f47562d = f11;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b a(int i11) {
            this.f47561c = i11;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b a(Context context) {
            this.f47559a = context.getApplicationContext();
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b a(View view) {
            this.f47566h = view;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b a(String str) {
            this.f47560b = str;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b a(List<CampaignEx> list) {
            this.f47567i = list;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b a(boolean z11) {
            this.f47569k = z11;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final c a() {
            return new c(this);
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b b(float f11) {
            this.f47563e = f11;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b b(int i11) {
            this.f47564f = i11;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b b(String str) {
            this.f47572n = str;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b b(List<String> list) {
            this.f47570l = list;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b c(int i11) {
            this.f47565g = i11;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b d(int i11) {
            this.f47568j = i11;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b e(int i11) {
            this.f47571m = i11;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b f(int i11) {
            this.f47573o = i11;
            return this;
        }

        @Override // com.mbridge.msdk.video.dynview.c.b
        public final b g(int i11) {
            this.f47574p = i11;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        b a(float f11);

        b a(int i11);

        b a(Context context);

        b a(View view);

        b a(String str);

        b a(List<CampaignEx> list);

        b a(boolean z11);

        c a();

        b b(float f11);

        b b(int i11);

        b b(String str);

        b b(List<String> list);

        b c(int i11);

        b d(int i11);

        b e(int i11);

        b f(int i11);

        b g(int i11);
    }

    private c(a aVar) {
        this.f47547e = aVar.f47563e;
        this.f47546d = aVar.f47562d;
        this.f47548f = aVar.f47564f;
        this.f47549g = aVar.f47565g;
        this.f47543a = aVar.f47559a;
        this.f47544b = aVar.f47560b;
        this.f47545c = aVar.f47561c;
        this.f47550h = aVar.f47566h;
        this.f47551i = aVar.f47567i;
        this.f47552j = aVar.f47568j;
        this.f47553k = aVar.f47569k;
        this.f47554l = aVar.f47570l;
        this.f47555m = aVar.f47571m;
        this.f47556n = aVar.f47572n;
        this.f47557o = aVar.f47573o;
        this.f47558p = aVar.f47574p;
    }

    public final Context a() {
        return this.f47543a;
    }

    public final String b() {
        return this.f47544b;
    }

    public final float c() {
        return this.f47546d;
    }

    public final float d() {
        return this.f47547e;
    }

    public final int e() {
        return this.f47548f;
    }

    public final View f() {
        return this.f47550h;
    }

    public final List<CampaignEx> g() {
        return this.f47551i;
    }

    public final int h() {
        return this.f47545c;
    }

    public final int i() {
        return this.f47552j;
    }

    public final int j() {
        return this.f47549g;
    }

    public final boolean k() {
        return this.f47553k;
    }

    public final List<String> l() {
        return this.f47554l;
    }

    public final int m() {
        return this.f47557o;
    }

    public final int n() {
        return this.f47558p;
    }
}
