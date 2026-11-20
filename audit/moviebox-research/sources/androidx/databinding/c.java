package androidx.databinding;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c<C, T, A> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<C> f8172a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f8173b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long[] f8174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8175d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a<C, T, A> f8176f;

    /* JADX INFO: compiled from: source.java */
    public static abstract class a<C, T, A> {
        public abstract void a(C c11, T t11, int i11, A a11);
    }

    public c(a<C, T, A> aVar) {
        this.f8176f = aVar;
    }

    public synchronized void a(C c11) {
        try {
            if (c11 == null) {
                throw new IllegalArgumentException("callback cannot be null");
            }
            int iLastIndexOf = this.f8172a.lastIndexOf(c11);
            if (iLastIndexOf < 0 || c(iLastIndexOf)) {
                this.f8172a.add(c11);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public synchronized c<C, T, A> clone() {
        c<C, T, A> cVar;
        CloneNotSupportedException e11;
        try {
            cVar = (c) super.clone();
            try {
                cVar.f8173b = 0L;
                cVar.f8174c = null;
                cVar.f8175d = 0;
                cVar.f8172a = new ArrayList();
                int size = this.f8172a.size();
                for (int i11 = 0; i11 < size; i11++) {
                    if (!c(i11)) {
                        cVar.f8172a.add(this.f8172a.get(i11));
                    }
                }
            } catch (CloneNotSupportedException e12) {
                e11 = e12;
                e11.printStackTrace();
            }
        } catch (CloneNotSupportedException e13) {
            cVar = null;
            e11 = e13;
        }
        return cVar;
    }

    public final boolean c(int i11) {
        int i12;
        if (i11 < 64) {
            return ((1 << i11) & this.f8173b) != 0;
        }
        long[] jArr = this.f8174c;
        if (jArr != null && (i12 = (i11 / 64) - 1) < jArr.length) {
            return ((1 << (i11 % 64)) & jArr[i12]) != 0;
        }
        return false;
    }

    public synchronized void d(T t11, int i11, A a11) {
        try {
            this.f8175d++;
            h(t11, i11, a11);
            int i12 = this.f8175d - 1;
            this.f8175d = i12;
            if (i12 == 0) {
                long[] jArr = this.f8174c;
                if (jArr != null) {
                    for (int length = jArr.length - 1; length >= 0; length--) {
                        long j11 = this.f8174c[length];
                        if (j11 != 0) {
                            l((length + 1) * 64, j11);
                            this.f8174c[length] = 0;
                        }
                    }
                }
                long j12 = this.f8173b;
                if (j12 != 0) {
                    l(0, j12);
                    this.f8173b = 0L;
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void f(T t11, int i11, A a11, int i12, int i13, long j11) {
        long j12 = 1;
        while (i12 < i13) {
            if ((j11 & j12) == 0) {
                this.f8176f.a(this.f8172a.get(i12), t11, i11, a11);
            }
            j12 <<= 1;
            i12++;
        }
    }

    public final void g(T t11, int i11, A a11) {
        f(t11, i11, a11, 0, Math.min(64, this.f8172a.size()), this.f8173b);
    }

    public final void h(T t11, int i11, A a11) {
        int size = this.f8172a.size();
        long[] jArr = this.f8174c;
        int length = jArr == null ? -1 : jArr.length - 1;
        j(t11, i11, a11, length);
        f(t11, i11, a11, (length + 2) * 64, size, 0L);
    }

    public final void j(T t11, int i11, A a11, int i12) {
        if (i12 < 0) {
            g(t11, i11, a11);
            return;
        }
        long j11 = this.f8174c[i12];
        int i13 = (i12 + 1) * 64;
        int iMin = Math.min(this.f8172a.size(), i13 + 64);
        j(t11, i11, a11, i12 - 1);
        f(t11, i11, a11, i13, iMin, j11);
    }

    public synchronized void k(C c11) {
        try {
            if (this.f8175d == 0) {
                this.f8172a.remove(c11);
            } else {
                int iLastIndexOf = this.f8172a.lastIndexOf(c11);
                if (iLastIndexOf >= 0) {
                    m(iLastIndexOf);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void l(int i11, long j11) {
        long j12 = Long.MIN_VALUE;
        for (int i12 = i11 + 63; i12 >= i11; i12--) {
            if ((j11 & j12) != 0) {
                this.f8172a.remove(i12);
            }
            j12 >>>= 1;
        }
    }

    public final void m(int i11) {
        if (i11 < 64) {
            this.f8173b = (1 << i11) | this.f8173b;
            return;
        }
        int i12 = (i11 / 64) - 1;
        long[] jArr = this.f8174c;
        if (jArr == null) {
            this.f8174c = new long[this.f8172a.size() / 64];
        } else if (jArr.length <= i12) {
            long[] jArr2 = new long[this.f8172a.size() / 64];
            long[] jArr3 = this.f8174c;
            System.arraycopy(jArr3, 0, jArr2, 0, jArr3.length);
            this.f8174c = jArr2;
        }
        long j11 = 1 << (i11 % 64);
        long[] jArr4 = this.f8174c;
        jArr4[i12] = j11 | jArr4[i12];
    }
}
