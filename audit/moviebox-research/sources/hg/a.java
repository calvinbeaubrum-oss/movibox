package hg;

import com.google.android.datatransport.runtime.m;
import com.google.firebase.encoders.proto.Protobuf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f66434e = new C0695a().b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f66435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c> f66436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f66437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f66438d;

    /* JADX INFO: renamed from: hg.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0695a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f66439a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<c> f66440b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b f66441c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f66442d = "";

        public C0695a a(c cVar) {
            this.f66440b.add(cVar);
            return this;
        }

        public a b() {
            return new a(this.f66439a, Collections.unmodifiableList(this.f66440b), this.f66441c, this.f66442d);
        }

        public C0695a c(String str) {
            this.f66442d = str;
            return this;
        }

        public C0695a d(b bVar) {
            this.f66441c = bVar;
            return this;
        }

        public C0695a e(e eVar) {
            this.f66439a = eVar;
            return this;
        }
    }

    public a(e eVar, List<c> list, b bVar, String str) {
        this.f66435a = eVar;
        this.f66436b = list;
        this.f66437c = bVar;
        this.f66438d = str;
    }

    public static C0695a e() {
        return new C0695a();
    }

    @Protobuf(tag = 4)
    public String a() {
        return this.f66438d;
    }

    @Protobuf(tag = 3)
    public b b() {
        return this.f66437c;
    }

    @Protobuf(tag = 2)
    public List<c> c() {
        return this.f66436b;
    }

    @Protobuf(tag = 1)
    public e d() {
        return this.f66435a;
    }

    public byte[] f() {
        return m.a(this);
    }
}
