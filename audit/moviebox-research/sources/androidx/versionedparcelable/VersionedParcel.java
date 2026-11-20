package androidx.versionedparcelable;

import android.os.Parcelable;
import androidx.collection.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import m6.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class VersionedParcel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a<String, Method> f13073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a<String, Method> f13074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a<String, Class> f13075c;

    /* JADX INFO: compiled from: source.java */
    public static class ParcelException extends RuntimeException {
        public ParcelException(Throwable th2) {
            super(th2);
        }
    }

    public VersionedParcel(a<String, Method> aVar, a<String, Method> aVar2, a<String, Class> aVar3) {
        this.f13073a = aVar;
        this.f13074b = aVar2;
        this.f13075c = aVar3;
    }

    public abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i11) {
        w(i11);
        A(bArr);
    }

    public abstract void C(CharSequence charSequence);

    public void D(CharSequence charSequence, int i11) {
        w(i11);
        C(charSequence);
    }

    public abstract void E(int i11);

    public void F(int i11, int i12) {
        w(i12);
        E(i11);
    }

    public abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i11) {
        w(i11);
        G(parcelable);
    }

    public abstract void I(String str);

    public void J(String str, int i11) {
        w(i11);
        I(str);
    }

    public <T extends c> void K(T t11, VersionedParcel versionedParcel) {
        try {
            e(t11.getClass()).invoke(null, t11, versionedParcel);
        } catch (ClassNotFoundException e11) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e11);
        } catch (IllegalAccessException e12) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e12);
        } catch (NoSuchMethodException e13) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e13);
        } catch (InvocationTargetException e14) {
            if (!(e14.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e14);
            }
            throw ((RuntimeException) e14.getCause());
        }
    }

    public void L(c cVar) {
        if (cVar == null) {
            I(null);
            return;
        }
        N(cVar);
        VersionedParcel versionedParcelB = b();
        K(cVar, versionedParcelB);
        versionedParcelB.a();
    }

    public void M(c cVar, int i11) {
        w(i11);
        L(cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void N(c cVar) {
        try {
            I(c(cVar.getClass()).getName());
        } catch (ClassNotFoundException e11) {
            throw new RuntimeException(cVar.getClass().getSimpleName() + " does not have a Parcelizer", e11);
        }
    }

    public abstract void a();

    public abstract VersionedParcel b();

    public final Class c(Class<? extends c> cls) throws ClassNotFoundException {
        Class cls2 = this.f13075c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f13075c.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method d(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f13073a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class);
        this.f13073a.put(str, declaredMethod);
        return declaredMethod;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Method e(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f13074b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class clsC = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsC.getDeclaredMethod("write", cls, VersionedParcel.class);
        this.f13074b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public boolean f() {
        return false;
    }

    public abstract boolean g();

    public boolean h(boolean z11, int i11) {
        return !m(i11) ? z11 : g();
    }

    public abstract byte[] i();

    public byte[] j(byte[] bArr, int i11) {
        return !m(i11) ? bArr : i();
    }

    public abstract CharSequence k();

    public CharSequence l(CharSequence charSequence, int i11) {
        return !m(i11) ? charSequence : k();
    }

    public abstract boolean m(int i11);

    public <T extends c> T n(String str, VersionedParcel versionedParcel) {
        try {
            return (T) d(str).invoke(null, versionedParcel);
        } catch (ClassNotFoundException e11) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e11);
        } catch (IllegalAccessException e12) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e12);
        } catch (NoSuchMethodException e13) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e13);
        } catch (InvocationTargetException e14) {
            if (e14.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e14.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e14);
        }
    }

    public abstract int o();

    public int p(int i11, int i12) {
        return !m(i12) ? i11 : o();
    }

    public abstract <T extends Parcelable> T q();

    public <T extends Parcelable> T r(T t11, int i11) {
        return !m(i11) ? t11 : (T) q();
    }

    public abstract String s();

    public String t(String str, int i11) {
        return !m(i11) ? str : s();
    }

    public <T extends c> T u() {
        String strS = s();
        if (strS == null) {
            return null;
        }
        return (T) n(strS, b());
    }

    public <T extends c> T v(T t11, int i11) {
        return !m(i11) ? t11 : (T) u();
    }

    public abstract void w(int i11);

    public void x(boolean z11, boolean z12) {
    }

    public abstract void y(boolean z11);

    public void z(boolean z11, int i11) {
        w(i11);
        y(z11);
    }
}
