package gy;

import com.transsion.transfer.androidasync.c0;
import com.transsion.transfer.androidasync.http.j;
import com.transsion.transfer.androidasync.r;
import com.transsion.transfer.androidasync.u;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class f implements gy.a<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f65636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f65637b;

    /* JADX INFO: compiled from: source.java */
    public class a implements com.transsion.transfer.androidasync.future.g<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ fy.a f65638a;

        public a(fy.a aVar) {
            this.f65638a = aVar;
        }

        @Override // com.transsion.transfer.androidasync.future.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Exception exc, String str) {
            f.this.f65637b = str;
            this.f65638a.i(exc);
        }
    }

    public f() {
    }

    public f(String str) {
        this();
        this.f65637b = str;
    }

    @Override // gy.a
    public void B(r rVar, fy.a aVar) {
        new jy.f().a(rVar).j(new a(aVar));
    }

    @Override // gy.a
    public void H(j jVar, u uVar, fy.a aVar) {
        if (this.f65636a == null) {
            this.f65636a = this.f65637b.getBytes();
        }
        c0.h(uVar, this.f65636a, aVar);
    }

    @Override // gy.a
    public boolean J() {
        return true;
    }

    public String a() {
        return toString();
    }

    @Override // gy.a
    public String c() {
        return "text/plain";
    }

    @Override // gy.a
    public int length() {
        if (this.f65636a == null) {
            this.f65636a = this.f65637b.getBytes();
        }
        return this.f65636a.length;
    }

    public String toString() {
        return this.f65637b;
    }
}
