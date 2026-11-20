package com.google.android.exoplayer2.source.rtsp;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.o0;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f34424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f34425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f34426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f34427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f34428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final String f34429f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final String f34430g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final String f34431h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImmutableMap<String, String> f34432i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f34433j;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f34434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f34435b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f34436c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f34437d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final HashMap<String, String> f34438e = new HashMap<>();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f34439f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public String f34440g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public String f34441h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        public String f34442i;

        public b(String str, int i11, String str2, int i12) {
            this.f34434a = str;
            this.f34435b = i11;
            this.f34436c = str2;
            this.f34437d = i12;
        }

        public static String k(int i11, String str, int i12, int i13) {
            return o0.C("%d %s/%d/%d", Integer.valueOf(i11), str, Integer.valueOf(i12), Integer.valueOf(i13));
        }

        public static String l(int i11) {
            com.google.android.exoplayer2.util.a.a(i11 < 96);
            if (i11 == 0) {
                return k(0, "PCMU", 8000, 1);
            }
            if (i11 == 8) {
                return k(8, "PCMA", 8000, 1);
            }
            if (i11 == 10) {
                return k(10, "L16", 44100, 2);
            }
            if (i11 == 11) {
                return k(11, "L16", 44100, 1);
            }
            throw new IllegalStateException("Unsupported static paylod type " + i11);
        }

        public b i(String str, String str2) {
            this.f34438e.put(str, str2);
            return this;
        }

        public a j() {
            try {
                return new a(this, ImmutableMap.copyOf((Map) this.f34438e), this.f34438e.containsKey("rtpmap") ? c.a((String) o0.j(this.f34438e.get("rtpmap"))) : c.a(l(this.f34437d)));
            } catch (ParserException e11) {
                throw new IllegalStateException(e11);
            }
        }

        public b m(int i11) {
            this.f34439f = i11;
            return this;
        }

        public b n(String str) {
            this.f34441h = str;
            return this;
        }

        public b o(String str) {
            this.f34442i = str;
            return this;
        }

        public b p(String str) {
            this.f34440g = str;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f34443a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f34444b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f34445c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f34446d;

        public c(int i11, String str, int i12, int i13) {
            this.f34443a = i11;
            this.f34444b = str;
            this.f34445c = i12;
            this.f34446d = i13;
        }

        public static c a(String str) throws ParserException {
            String[] strArrU0 = o0.U0(str, " ");
            com.google.android.exoplayer2.util.a.a(strArrU0.length == 2);
            int iH = y.h(strArrU0[0]);
            String[] strArrT0 = o0.T0(strArrU0[1].trim(), "/");
            com.google.android.exoplayer2.util.a.a(strArrT0.length >= 2);
            return new c(iH, strArrT0[0], y.h(strArrT0[1]), strArrT0.length == 3 ? y.h(strArrT0[2]) : -1);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            return this.f34443a == cVar.f34443a && this.f34444b.equals(cVar.f34444b) && this.f34445c == cVar.f34445c && this.f34446d == cVar.f34446d;
        }

        public int hashCode() {
            return ((((((217 + this.f34443a) * 31) + this.f34444b.hashCode()) * 31) + this.f34445c) * 31) + this.f34446d;
        }
    }

    public a(b bVar, ImmutableMap<String, String> immutableMap, c cVar) {
        this.f34424a = bVar.f34434a;
        this.f34425b = bVar.f34435b;
        this.f34426c = bVar.f34436c;
        this.f34427d = bVar.f34437d;
        this.f34429f = bVar.f34440g;
        this.f34430g = bVar.f34441h;
        this.f34428e = bVar.f34439f;
        this.f34431h = bVar.f34442i;
        this.f34432i = immutableMap;
        this.f34433j = cVar;
    }

    public ImmutableMap<String, String> a() {
        String str = this.f34432i.get("fmtp");
        if (str == null) {
            return ImmutableMap.of();
        }
        String[] strArrU0 = o0.U0(str, " ");
        com.google.android.exoplayer2.util.a.b(strArrU0.length == 2, str);
        String[] strArrSplit = strArrU0[1].split(";\\s?", 0);
        ImmutableMap.b bVar = new ImmutableMap.b();
        for (String str2 : strArrSplit) {
            String[] strArrU1 = o0.U0(str2, "=");
            bVar.g(strArrU1[0], strArrU1[1]);
        }
        return bVar.d();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f34424a.equals(aVar.f34424a) && this.f34425b == aVar.f34425b && this.f34426c.equals(aVar.f34426c) && this.f34427d == aVar.f34427d && this.f34428e == aVar.f34428e && this.f34432i.equals(aVar.f34432i) && this.f34433j.equals(aVar.f34433j) && o0.c(this.f34429f, aVar.f34429f) && o0.c(this.f34430g, aVar.f34430g) && o0.c(this.f34431h, aVar.f34431h);
    }

    public int hashCode() {
        int iHashCode = (((((((((((((217 + this.f34424a.hashCode()) * 31) + this.f34425b) * 31) + this.f34426c.hashCode()) * 31) + this.f34427d) * 31) + this.f34428e) * 31) + this.f34432i.hashCode()) * 31) + this.f34433j.hashCode()) * 31;
        String str = this.f34429f;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f34430g;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f34431h;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }
}
