package l8;

import com.bykv.vk.openvk.sc.sc.pFF.pFF.Ol;
import com.bytedance.sdk.component.pFF.sc.BT;
import com.bytedance.sdk.component.pFF.sc.TRI;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BT f70157c;

    public b(BT bt2, a aVar) {
        TRI triQr;
        this.f70157c = bt2;
        this.f70159a = new ArrayList();
        if (bt2 != null && (triQr = bt2.qr()) != null) {
            for (int i11 = 0; i11 < triQr.sc(); i11++) {
                this.f70159a.add(new Ol.a(triQr.sc(i11), triQr.pFF(i11)));
            }
        }
        this.f70160b = aVar;
    }

    @Override // l8.e
    public String a() {
        BT bt2 = this.f70157c;
        return (bt2 == null || bt2.Qj() == null) ? "http/1.1" : this.f70157c.Qj().toString();
    }

    @Override // l8.e
    public String b() {
        return h(this.f70157c.zY());
    }

    @Override // l8.e
    public InputStream c() {
        return this.f70157c.TRI().zY();
    }

    @Override // l8.e
    public boolean d() {
        return this.f70157c.zY() >= 200 && this.f70157c.zY() < 300;
    }

    @Override // l8.e
    public int f() {
        return this.f70157c.zY();
    }

    @Override // l8.e
    public String i(String str, String str2) {
        return g(str) != null ? g(str).f25908b : str2;
    }

    @Override // l8.e
    public List<Ol.a> j() {
        return this.f70159a;
    }
}
