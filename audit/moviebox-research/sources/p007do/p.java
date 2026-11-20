package p007do;

import androidx.core.util.l;
import io.a0;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f63490c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f63491d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f63492e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f63493f = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f63494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f63495b = new ArrayList();

    public p(m mVar) {
        this.f63494a = mVar;
    }

    public final Object a() {
        ArrayList arrayList = this.f63495b;
        Object objRemove = arrayList.remove(arrayList.size() - 1);
        if (objRemove == f63491d) {
            return this.f63494a.q();
        }
        if (objRemove == f63492e) {
            return this.f63494a.n();
        }
        if (objRemove == f63493f) {
            return this.f63494a.w();
        }
        if (objRemove == f63490c) {
            return null;
        }
        return objRemove;
    }

    public final Object b(int i11, Object obj) {
        Object objA;
        switch (i11) {
            case 1:
                return a();
            case 2:
                this.f63495b.add(obj == null ? f63490c : obj);
                return obj;
            case 3:
                if (obj == null) {
                    obj = -1;
                }
                Integer num = (Integer) obj;
                if (num.intValue() < 0) {
                    obj = Integer.valueOf(num.intValue() + this.f63495b.size());
                }
                Object obj2 = this.f63495b.get(((Integer) obj).intValue());
                this.f63495b.add(obj2);
                return obj2;
            case 4:
                objA = a0.n((Member) obj, new l() { // from class: do.o
                    @Override // androidx.core.util.l
                    public final Object get() {
                        return this.f63489a.a();
                    }
                }).get();
                if (!(obj instanceof Method) || !Void.TYPE.equals(((Method) obj).getReturnType())) {
                    this.f63495b.add(objA == null ? f63490c : objA);
                }
                break;
            case 5:
                Object obj3 = a0.p((Field) obj, new l() { // from class: do.o
                    @Override // androidx.core.util.l
                    public final Object get() {
                        return this.f63489a.a();
                    }
                }).get();
                this.f63495b.add(obj3 == null ? f63490c : obj3);
                return obj3;
            case 6:
                objA = a();
                a0.s((Field) obj, new l() { // from class: do.o
                    @Override // androidx.core.util.l
                    public final Object get() {
                        return this.f63489a.a();
                    }
                }).accept(objA);
                break;
            default:
                throw new UnsupportedOperationException();
        }
        return objA;
    }
}
