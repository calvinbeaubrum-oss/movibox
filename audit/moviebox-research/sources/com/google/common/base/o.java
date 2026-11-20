package com.google.common.base;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.common.base.b f38183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f38184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f38185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f38186d;

    /* JADX INFO: compiled from: source.java */
    public class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.google.common.base.b f38187a;

        /* JADX INFO: renamed from: com.google.common.base.o$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0391a extends c {
            public C0391a(o oVar, CharSequence charSequence) {
                super(oVar, charSequence);
            }

            @Override // com.google.common.base.o.c
            public int f(int i11) {
                return i11 + 1;
            }

            @Override // com.google.common.base.o.c
            public int g(int i11) {
                return a.this.f38187a.e(this.f38191c, i11);
            }
        }

        public a(com.google.common.base.b bVar) {
            this.f38187a = bVar;
        }

        @Override // com.google.common.base.o.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public c a(o oVar, CharSequence charSequence) {
            return new C0391a(oVar, charSequence);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Iterable<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f38189a;

        public b(CharSequence charSequence) {
            this.f38189a = charSequence;
        }

        @Override // java.lang.Iterable
        public Iterator<String> iterator() {
            return o.this.j(this.f38189a);
        }

        public String toString() {
            g gVarH = g.h(", ");
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            StringBuilder sbB = gVarH.b(sb2, this);
            sbB.append(']');
            return sbB.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class c extends AbstractIterator<String> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CharSequence f38191c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.google.common.base.b f38192d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f38193f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f38194g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f38195h;

        public c(o oVar, CharSequence charSequence) {
            this.f38192d = oVar.f38183a;
            this.f38193f = oVar.f38184b;
            this.f38195h = oVar.f38186d;
            this.f38191c = charSequence;
        }

        @Override // com.google.common.base.AbstractIterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a() {
            int i11 = this.f38194g;
            while (true) {
                int i12 = this.f38194g;
                if (i12 == -1) {
                    return b();
                }
                int iG = g(i12);
                if (iG == -1) {
                    iG = this.f38191c.length();
                    this.f38194g = -1;
                } else {
                    this.f38194g = f(iG);
                }
                int i13 = this.f38194g;
                if (i13 == i11) {
                    int i14 = i13 + 1;
                    this.f38194g = i14;
                    if (i14 > this.f38191c.length()) {
                        this.f38194g = -1;
                    }
                } else {
                    while (i11 < iG && this.f38192d.g(this.f38191c.charAt(i11))) {
                        i11++;
                    }
                    while (iG > i11 && this.f38192d.g(this.f38191c.charAt(iG - 1))) {
                        iG--;
                    }
                    if (!this.f38193f || i11 != iG) {
                        int i15 = this.f38195h;
                        if (i15 == 1) {
                            iG = this.f38191c.length();
                            this.f38194g = -1;
                            while (iG > i11 && this.f38192d.g(this.f38191c.charAt(iG - 1))) {
                                iG--;
                            }
                        } else {
                            this.f38195h = i15 - 1;
                        }
                        return this.f38191c.subSequence(i11, iG).toString();
                    }
                    i11 = this.f38194g;
                }
            }
        }

        public abstract int f(int i11);

        public abstract int g(int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        Iterator<String> a(o oVar, CharSequence charSequence);
    }

    public o(d dVar) {
        this(dVar, false, com.google.common.base.b.i(), Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public o(d dVar, boolean z11, com.google.common.base.b bVar, int i11) {
        this.f38185c = dVar;
        this.f38184b = z11;
        this.f38183a = bVar;
        this.f38186d = i11;
    }

    public static o f(char c11) {
        return g(com.google.common.base.b.f(c11));
    }

    public static o g(com.google.common.base.b bVar) {
        m.p(bVar);
        return new o(new a(bVar));
    }

    public o e() {
        return new o(this.f38185c, true, this.f38183a, this.f38186d);
    }

    public Iterable<String> h(CharSequence charSequence) {
        m.p(charSequence);
        return new b(charSequence);
    }

    public List<String> i(CharSequence charSequence) {
        m.p(charSequence);
        Iterator<String> itJ = j(charSequence);
        ArrayList arrayList = new ArrayList();
        while (itJ.hasNext()) {
            arrayList.add(itJ.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final Iterator<String> j(CharSequence charSequence) {
        return this.f38185c.a(this, charSequence);
    }

    public o k() {
        return l(com.google.common.base.b.k());
    }

    public o l(com.google.common.base.b bVar) {
        m.p(bVar);
        return new o(this.f38185c, this.f38184b, bVar, this.f38186d);
    }
}
