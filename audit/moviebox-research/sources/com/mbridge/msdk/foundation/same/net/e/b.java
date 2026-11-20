package com.mbridge.msdk.foundation.same.net.e;

import com.mbridge.msdk.foundation.same.net.j;
import com.mbridge.msdk.foundation.same.net.k;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f44582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j f44583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LinkedList<a> f44584c = new LinkedList<>();

    /* JADX INFO: compiled from: source.java */
    public class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.mbridge.msdk.foundation.same.net.e<Void> f44586b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.mbridge.msdk.foundation.same.net.e.a f44587c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f44588d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private File f44589e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f44590f;

        private a(File file, String str, com.mbridge.msdk.foundation.same.net.e<Void> eVar) {
            this.f44589e = file;
            this.f44586b = eVar;
            this.f44590f = str;
        }

        public static /* synthetic */ boolean a(a aVar) {
            if (aVar.f44588d != 0) {
                return false;
            }
            com.mbridge.msdk.foundation.same.net.e.a aVar2 = new com.mbridge.msdk.foundation.same.net.e.a(aVar.f44589e, aVar.f44590f);
            aVar.f44587c = aVar2;
            aVar2.a(new com.mbridge.msdk.foundation.same.net.f<Void>() { // from class: com.mbridge.msdk.foundation.same.net.e.b.a.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                boolean f44591a;

                @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
                public final void onCancel() {
                    a.this.f44586b.onCancel();
                    this.f44591a = true;
                }

                @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
                public final void onError(com.mbridge.msdk.foundation.same.net.b.a aVar3) {
                    if (this.f44591a) {
                        return;
                    }
                    a.this.f44586b.onError(aVar3);
                }

                @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
                public final void onFinish() {
                    if (this.f44591a) {
                        return;
                    }
                    a.this.f44588d = 3;
                    a.this.f44586b.onFinish();
                    a aVar3 = a.this;
                    b.a(b.this, aVar3);
                }

                @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
                public final void onPreExecute() {
                    a.this.f44586b.onPreExecute();
                }

                @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
                public final void onProgressChange(long j11, long j12) {
                    a.this.f44586b.onProgressChange(j11, j12);
                }

                @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
                public final void onSuccess(k kVar) {
                    if (this.f44591a) {
                        return;
                    }
                    a.this.f44586b.onSuccess(kVar);
                }
            });
            aVar.f44588d = 1;
            b.this.f44583b.a(aVar.f44587c);
            return true;
        }

        public final boolean a() {
            return this.f44588d == 1;
        }
    }

    public b(j jVar, int i11) {
        this.f44583b = jVar;
        this.f44582a = i11;
    }

    private void a() {
        synchronized (this) {
            try {
                Iterator<a> it = this.f44584c.iterator();
                int i11 = 0;
                while (it.hasNext()) {
                    if (it.next().a()) {
                        i11++;
                    }
                }
                if (i11 >= this.f44582a) {
                    return;
                }
                Iterator<a> it2 = this.f44584c.iterator();
                while (it2.hasNext()) {
                    if (a.a(it2.next()) && (i11 = i11 + 1) == this.f44582a) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static /* synthetic */ void a(b bVar, a aVar) {
        synchronized (bVar) {
            bVar.f44584c.remove(aVar);
        }
        bVar.a();
    }

    public final a a(File file, String str, com.mbridge.msdk.foundation.same.net.e<Void> eVar) {
        a aVar = new a(file, str, eVar);
        synchronized (this) {
            this.f44584c.add(aVar);
        }
        a();
        return aVar;
    }
}
