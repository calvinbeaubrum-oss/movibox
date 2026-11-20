package n7;

import com.alibaba.fastjson.serializer.SerializerFeature;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<q> f71651a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<i> f71652b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<b1> f71653c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<m1> f71654d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<x0> f71655e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<c1> f71656f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<r0> f71657g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<b0> f71658h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f71659i = true;

    public void b(h1 h1Var) {
        if (h1Var == null) {
            return;
        }
        if (h1Var instanceof c1) {
            m().add((c1) h1Var);
        }
        if (h1Var instanceof x0) {
            k().add((x0) h1Var);
        }
        if (h1Var instanceof m1) {
            n().add((m1) h1Var);
        }
        if (h1Var instanceof b0) {
            i().add((b0) h1Var);
        }
        if (h1Var instanceof b1) {
            l().add((b1) h1Var);
        }
        if (h1Var instanceof q) {
            h().add((q) h1Var);
        }
        if (h1Var instanceof i) {
            g().add((i) h1Var);
        }
        if (h1Var instanceof r0) {
            j().add((r0) h1Var);
        }
    }

    public boolean e(o0 o0Var, Object obj, String str, Object obj2) {
        List<b1> list = o0Var.f71653c;
        if (list != null) {
            Iterator<b1> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().d(obj, str, obj2)) {
                    return false;
                }
            }
        }
        List<b1> list2 = this.f71653c;
        if (list2 == null) {
            return true;
        }
        Iterator<b1> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (!it2.next().d(obj, str, obj2)) {
                return false;
            }
        }
        return true;
    }

    public boolean f(o0 o0Var, Object obj, String str) {
        List<c1> list = o0Var.f71656f;
        if (list != null) {
            Iterator<c1> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().c(o0Var, obj, str)) {
                    return false;
                }
            }
        }
        List<c1> list2 = this.f71656f;
        if (list2 == null) {
            return true;
        }
        Iterator<c1> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (!it2.next().c(o0Var, obj, str)) {
                return false;
            }
        }
        return true;
    }

    public List<i> g() {
        if (this.f71652b == null) {
            this.f71652b = new ArrayList();
            this.f71659i = false;
        }
        return this.f71652b;
    }

    public List<q> h() {
        if (this.f71651a == null) {
            this.f71651a = new ArrayList();
            this.f71659i = false;
        }
        return this.f71651a;
    }

    public List<b0> i() {
        if (this.f71658h == null) {
            this.f71658h = new ArrayList();
            this.f71659i = false;
        }
        return this.f71658h;
    }

    public List<r0> j() {
        if (this.f71657g == null) {
            this.f71657g = new ArrayList();
            this.f71659i = false;
        }
        return this.f71657g;
    }

    public List<x0> k() {
        if (this.f71655e == null) {
            this.f71655e = new ArrayList();
            this.f71659i = false;
        }
        return this.f71655e;
    }

    public List<b1> l() {
        if (this.f71653c == null) {
            this.f71653c = new ArrayList();
            this.f71659i = false;
        }
        return this.f71653c;
    }

    public List<c1> m() {
        if (this.f71656f == null) {
            this.f71656f = new ArrayList();
            this.f71659i = false;
        }
        return this.f71656f;
    }

    public List<m1> n() {
        if (this.f71654d == null) {
            this.f71654d = new ArrayList();
            this.f71659i = false;
        }
        return this.f71654d;
    }

    public String o(o0 o0Var, Object obj, String str, Object obj2) {
        List<x0> list = o0Var.f71655e;
        if (list != null) {
            Iterator<x0> it = list.iterator();
            while (it.hasNext()) {
                str = it.next().b(obj, str, obj2);
            }
        }
        List<x0> list2 = this.f71655e;
        if (list2 != null) {
            Iterator<x0> it2 = list2.iterator();
            while (it2.hasNext()) {
                str = it2.next().b(obj, str, obj2);
            }
        }
        return str;
    }

    public Object p(o0 o0Var, p pVar, Object obj, String str, Object obj2, int i11) {
        boolean z11;
        if (obj2 != null) {
            int i12 = o0Var.f71701k.f71674c;
            SerializerFeature serializerFeature = SerializerFeature.WriteNonStringValueAsString;
            if ((SerializerFeature.isEnabled(i12, i11, serializerFeature) || !(pVar == null || (pVar.a() & serializerFeature.mask) == 0)) && (((z11 = obj2 instanceof Number)) || (obj2 instanceof Boolean))) {
                String strB = (!z11 || pVar == null) ? null : pVar.b();
                obj2 = strB != null ? new DecimalFormat(strB).format(obj2) : obj2.toString();
            } else if (pVar != null && pVar.c()) {
                obj2 = com.alibaba.fastjson.a.parse((String) obj2);
            }
        }
        List<m1> list = o0Var.f71654d;
        if (list != null) {
            Iterator<m1> it = list.iterator();
            while (it.hasNext()) {
                obj2 = it.next().b(obj, str, obj2);
            }
        }
        List<m1> list2 = this.f71654d;
        if (list2 != null) {
            Iterator<m1> it2 = list2.iterator();
            while (it2.hasNext()) {
                obj2 = it2.next().b(obj, str, obj2);
            }
        }
        List<b0> list3 = o0Var.f71658h;
        if (list3 != null) {
            Iterator<b0> it3 = list3.iterator();
            while (it3.hasNext()) {
                obj2 = it3.next().e(pVar, obj, str, obj2);
            }
        }
        List<b0> list4 = this.f71658h;
        if (list4 != null) {
            Iterator<b0> it4 = list4.iterator();
            while (it4.hasNext()) {
                obj2 = it4.next().e(pVar, obj, str, obj2);
            }
        }
        return obj2;
    }
}
