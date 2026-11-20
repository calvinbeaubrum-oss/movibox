package gy;

import com.transsion.transfer.androidasync.c0;
import com.transsion.transfer.androidasync.http.j;
import com.transsion.transfer.androidasync.r;
import com.transsion.transfer.androidasync.u;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b implements gy.a<JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f65606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f65607b;

    /* JADX INFO: compiled from: source.java */
    public class a implements com.transsion.transfer.androidasync.future.g<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ fy.a f65608a;

        public a(fy.a aVar) {
            this.f65608a = aVar;
        }

        @Override // com.transsion.transfer.androidasync.future.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Exception exc, JSONObject jSONObject) {
            b.this.f65607b = jSONObject;
            this.f65608a.i(exc);
        }
    }

    @Override // gy.a
    public void B(r rVar, fy.a aVar) {
        new jy.d().a(rVar).j(new a(aVar));
    }

    @Override // gy.a
    public void H(j jVar, u uVar, fy.a aVar) {
        c0.h(uVar, this.f65606a, aVar);
    }

    @Override // gy.a
    public boolean J() {
        return true;
    }

    @Override // gy.a
    public String c() {
        return "application/json";
    }

    @Override // gy.a
    public int length() {
        byte[] bytes = this.f65607b.toString().getBytes();
        this.f65606a = bytes;
        return bytes.length;
    }
}
