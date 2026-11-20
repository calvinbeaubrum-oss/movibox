package e8;

import android.content.Context;
import g8.c;
import java.util.Calendar;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f8.a f64064a;

    public a(Context context, c cVar) {
        f8.a aVar = new f8.a(2);
        this.f64064a = aVar;
        aVar.C = context;
        aVar.f64716a = cVar;
    }

    public com.bigkoo.pickerview.view.a a() {
        return new com.bigkoo.pickerview.view.a(this.f64064a);
    }

    public a b(int i11) {
        this.f64064a.Q = i11;
        return this;
    }

    public a c(String str, String str2, String str3, String str4, String str5, String str6) {
        f8.a aVar = this.f64064a;
        aVar.f64729n = str;
        aVar.f64730o = str2;
        aVar.f64731p = str3;
        aVar.f64732q = str4;
        aVar.f64733r = str5;
        aVar.f64734s = str6;
        return this;
    }

    public a d(Calendar calendar, Calendar calendar2) {
        f8.a aVar = this.f64064a;
        aVar.f64723h = calendar;
        aVar.f64724i = calendar2;
        return this;
    }

    public a e(int i11) {
        this.f64064a.P = i11;
        return this;
    }

    public a f(int i11) {
        this.f64064a.O = i11;
        return this;
    }
}
