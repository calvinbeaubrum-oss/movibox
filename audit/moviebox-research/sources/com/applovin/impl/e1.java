package com.applovin.impl;

import android.net.Uri;
import android.text.TextUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class e1 extends d1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f18519f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.applovin.impl.sdk.ad.b f18520g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f18521h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final u2 f18522i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final c f18523j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private StringBuffer f18524k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Object f18525l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ExecutorService f18526m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private List f18527n;

    /* JADX INFO: compiled from: source.java */
    public class a implements f1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f18528a;

        public a(String str) {
            this.f18528a = str;
        }

        @Override // com.applovin.impl.f1.a
        public void a(Uri uri) {
            if (uri != null) {
                synchronized (e1.this.f18525l) {
                    int iIndexOf = e1.this.f18524k.indexOf(this.f18528a);
                    e1.this.f18524k.replace(iIndexOf, this.f18528a.length() + iIndexOf, uri.toString());
                }
                e1.this.f18520g.a(uri);
                e1.this.f18522i.d();
                return;
            }
            com.applovin.impl.sdk.n nVar = e1.this.f18337c;
            if (com.applovin.impl.sdk.n.a()) {
                e1 e1Var = e1.this;
                e1Var.f18337c.a(e1Var.f18336b, "Failed to cache JavaScript resource " + this.f18528a);
            }
            if (e1.this.f18523j != null) {
                e1.this.f18523j.a(e1.this.f18519f, true);
            }
            e1.this.f18522i.c();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements f1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f18530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f18531b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f18532c;

        public b(String str, String str2, String str3) {
            this.f18530a = str;
            this.f18531b = str2;
            this.f18532c = str3;
        }

        @Override // com.applovin.impl.f1.a
        public void a(Uri uri) {
            if (uri != null) {
                synchronized (e1.this.f18525l) {
                    int iIndexOf = e1.this.f18524k.indexOf(this.f18530a);
                    e1.this.f18524k.replace(iIndexOf, this.f18530a.length() + iIndexOf, uri.toString());
                }
                e1.this.f18520g.a(uri);
                e1.this.f18522i.d();
                return;
            }
            if (e1.this.f18520g.W().contains(this.f18531b + this.f18532c) && e1.this.f18523j != null) {
                e1.this.f18523j.a(e1.this.f18519f, true);
            }
            e1.this.f18522i.c();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void a(String str, boolean z11);
    }

    public e1(String str, com.applovin.impl.sdk.ad.b bVar, List list, u2 u2Var, ExecutorService executorService, com.applovin.impl.sdk.j jVar, c cVar) {
        super("AsyncTaskCacheHTMLResources", jVar);
        this.f18519f = str;
        this.f18520g = bVar;
        this.f18521h = list;
        this.f18522i = u2Var;
        this.f18526m = executorService;
        this.f18523j = cVar;
        this.f18524k = new StringBuffer(str);
        this.f18525l = new Object();
    }

    private void a(String str) {
        c cVar;
        if (this.f18339e.get() || (cVar = this.f18523j) == null) {
            return;
        }
        cVar.a(str, false);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00b3  */
    /* JADX WARN: Instruction removed from duplicated block: B:30:0x00b3, please report this as an issue */
    private HashSet c() {
        HashSet hashSet = new HashSet();
        Collection collectionE = e();
        for (String str : this.f18521h) {
            int iIndexOf = 0;
            int i11 = 0;
            while (iIndexOf < this.f18519f.length()) {
                if (this.f18339e.get()) {
                    return null;
                }
                iIndexOf = this.f18519f.indexOf(str, i11);
                if (iIndexOf == -1) {
                    break;
                }
                int length = this.f18519f.length();
                int i12 = iIndexOf;
                while (!collectionE.contains(Character.valueOf(this.f18519f.charAt(i12))) && i12 < length) {
                    i12++;
                }
                if (i12 <= iIndexOf || i12 == length) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f18337c.b(this.f18336b, "Unable to cache resource; ad HTML is invalid.");
                    }
                    return null;
                }
                String strSubstring = this.f18519f.substring(str.length() + iIndexOf, i12);
                if (StringUtils.isValidString(strSubstring)) {
                    if (this.f18520g.J0()) {
                        if (!this.f18520g.P().equals(str + strSubstring)) {
                            String str2 = str + strSubstring;
                            hashSet.add(new f1(str2, this.f18520g, Arrays.asList(str), true, this.f18522i, this.f18335a, new b(str2, str, strSubstring)));
                        } else if (com.applovin.impl.sdk.n.a()) {
                            this.f18337c.a(this.f18336b, "Postponing caching for \"" + strSubstring + "\" video resource");
                        }
                    } else {
                        String str3 = str + strSubstring;
                        hashSet.add(new f1(str3, this.f18520g, Arrays.asList(str), true, this.f18522i, this.f18335a, new b(str3, str, strSubstring)));
                    }
                } else if (com.applovin.impl.sdk.n.a()) {
                    this.f18337c.a(this.f18336b, "Skip caching of non-resource " + strSubstring);
                }
                i11 = i12;
            }
        }
        return hashSet;
    }

    private HashSet d() {
        HashSet hashSet = new HashSet();
        for (String str : StringUtils.getRegexMatches(StringUtils.match(this.f18519f, (String) this.f18335a.a(sj.f22954f5)), 1)) {
            if (this.f18339e.get()) {
                return null;
            }
            if (StringUtils.isValidString(str)) {
                hashSet.add(new f1(str, this.f18520g, Collections.emptyList(), false, this.f18522i, this.f18335a, new a(str)));
            } else if (com.applovin.impl.sdk.n.a()) {
                this.f18337c.a(this.f18336b, "Skip caching of non-resource " + str);
            }
        }
        return hashSet;
    }

    private Collection e() {
        HashSet hashSet = new HashSet();
        for (char c11 : ((String) this.f18335a.a(sj.Y0)).toCharArray()) {
            hashSet.add(Character.valueOf(c11));
        }
        hashSet.add('\"');
        return hashSet;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Boolean call() throws InterruptedException {
        HashSet hashSetD;
        if (this.f18339e.get()) {
            return Boolean.FALSE;
        }
        if (TextUtils.isEmpty(this.f18519f)) {
            a(this.f18519f);
            return Boolean.FALSE;
        }
        if (!((Boolean) this.f18335a.a(sj.Z0)).booleanValue()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f18337c.a(this.f18336b, "Resource caching is disabled, skipping cache...");
            }
            a(this.f18519f);
            return Boolean.FALSE;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSetC = c();
        if (hashSetC != null) {
            hashSet.addAll(hashSetC);
        }
        if (((Boolean) this.f18335a.a(sj.f22939d5)).booleanValue() && (hashSetD = d()) != null) {
            hashSet.addAll(hashSetD);
        }
        this.f18527n = new ArrayList(hashSet);
        if (this.f18339e.get()) {
            return Boolean.FALSE;
        }
        List list = this.f18527n;
        if (list == null || list.isEmpty()) {
            a(this.f18519f);
            return Boolean.FALSE;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f18337c.a(this.f18336b, "Executing " + this.f18527n.size() + " caching operations...");
        }
        this.f18526m.invokeAll(this.f18527n);
        synchronized (this.f18525l) {
            a(this.f18524k.toString());
        }
        return Boolean.TRUE;
    }
}
