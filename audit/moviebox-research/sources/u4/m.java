package u4;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m implements y {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int[] f78323r = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14, 17, 18, 19, 20};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a f78324s = new a(new a.InterfaceC0863a() { // from class: u4.k
        @Override // u4.m.a.InterfaceC0863a
        public final Constructor a() {
            return m.h();
        }
    });

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final a f78325t = new a(new a.InterfaceC0863a() { // from class: u4.l
        @Override // u4.m.a.InterfaceC0863a
        public final Constructor a() {
            return m.i();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f78326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f78327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f78328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f78329e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f78330f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f78331g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f78332h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f78333i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f78334j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f78336l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public ImmutableList<androidx.media3.common.y> f78337m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f78339o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f78341q;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f78335k = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f78338n = 112800;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public o5.s.a f78340p = new o5.h();

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC0863a f78342a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f78343b = new AtomicBoolean(false);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public Constructor<? extends s> f78344c;

        /* JADX INFO: renamed from: u4.m$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public interface InterfaceC0863a {
            @Nullable
            Constructor<? extends s> a() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException;
        }

        public a(InterfaceC0863a interfaceC0863a) {
            this.f78342a = interfaceC0863a;
        }

        @Nullable
        public s a(Object... objArr) {
            Constructor<? extends s> constructorB = b();
            if (constructorB == null) {
                return null;
            }
            try {
                return constructorB.newInstance(objArr);
            } catch (Exception e11) {
                throw new IllegalStateException("Unexpected error creating extractor", e11);
            }
        }

        @Nullable
        public final Constructor<? extends s> b() {
            synchronized (this.f78343b) {
                if (this.f78343b.get()) {
                    return this.f78344c;
                }
                try {
                    return this.f78342a.a();
                } catch (ClassNotFoundException unused) {
                    this.f78343b.set(true);
                    return this.f78344c;
                } catch (Exception e11) {
                    throw new RuntimeException("Error instantiating extension", e11);
                }
            }
        }
    }

    @Nullable
    public static Constructor<? extends s> h() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        if (Boolean.TRUE.equals(Class.forName("androidx.media3.decoder.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
            return Class.forName("androidx.media3.decoder.flac.FlacExtractor").asSubclass(s.class).getConstructor(Integer.TYPE);
        }
        return null;
    }

    public static Constructor<? extends s> i() throws NoSuchMethodException, ClassNotFoundException {
        return Class.forName("androidx.media3.decoder.midi.MidiExtractor").asSubclass(s.class).getConstructor(new Class[0]);
    }

    @Override // u4.y
    public synchronized s[] b(Uri uri, Map<String, List<String>> map) {
        s[] sVarArr;
        try {
            int[] iArr = f78323r;
            ArrayList arrayList = new ArrayList(iArr.length);
            int iB = androidx.media3.common.r.b(map);
            if (iB != -1) {
                f(iB, arrayList);
            }
            int iC = androidx.media3.common.r.c(uri);
            if (iC != -1 && iC != iB) {
                f(iC, arrayList);
            }
            for (int i11 : iArr) {
                if (i11 != iB && i11 != iC) {
                    f(i11, arrayList);
                }
            }
            sVarArr = new s[arrayList.size()];
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                s tVar = arrayList.get(i12);
                if (this.f78339o && !(tVar.c() instanceof l5.g) && !(tVar.c() instanceof l5.k) && !(tVar.c() instanceof x5.h0) && !(tVar.c() instanceof w4.b) && !(tVar.c() instanceof j5.e)) {
                    tVar = new o5.t(tVar, this.f78340p);
                }
                sVarArr[i12] = tVar;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return sVarArr;
    }

    @Override // u4.y
    public synchronized s[] createExtractors() {
        return b(Uri.EMPTY, new HashMap());
    }

    public final void f(int i11, List<s> list) {
        switch (i11) {
            case 0:
                list.add(new x5.b());
                break;
            case 1:
                list.add(new x5.e());
                break;
            case 2:
                list.add(new x5.h(((this.f78328d | (this.f78326b ? 1 : 0)) == true ? 1 : 0) | (this.f78327c ? 2 : 0)));
                break;
            case 3:
                list.add(new v4.b(this.f78329e | (this.f78326b ? 1 : 0) | (this.f78327c ? 2 : 0)));
                break;
            case 4:
                s sVarA = f78324s.a(Integer.valueOf(this.f78330f));
                if (sVarA == null) {
                    list.add(new y4.d(this.f78330f));
                } else {
                    list.add(sVarA);
                }
                break;
            case 5:
                list.add(new z4.b());
                break;
            case 6:
                list.add(new j5.e(this.f78340p, (this.f78339o ? 0 : 2) | this.f78331g));
                break;
            case 7:
                list.add(new k5.f(this.f78334j | (this.f78326b ? 1 : 0) | (this.f78327c ? 2 : 0)));
                break;
            case 8:
                list.add(new l5.g(this.f78340p, this.f78333i | (this.f78339o ? 0 : 32)));
                list.add(new l5.k(this.f78340p, this.f78332h | (this.f78339o ? 0 : 16)));
                break;
            case 9:
                list.add(new m5.d());
                break;
            case 10:
                list.add(new x5.a0());
                break;
            case 11:
                if (this.f78337m == null) {
                    this.f78337m = ImmutableList.of();
                }
                list.add(new x5.h0(this.f78335k, !this.f78339o ? 1 : 0, this.f78340p, new z3.i0(0L), new x5.j(this.f78336l, this.f78337m), this.f78338n));
                break;
            case 12:
                list.add(new y5.b());
                break;
            case 14:
                list.add(new b5.a(this.f78341q));
                break;
            case 15:
                s sVarA2 = f78325t.a(new Object[0]);
                if (sVarA2 != null) {
                    list.add(sVarA2);
                }
                break;
            case 16:
                list.add(new w4.b(1 ^ (this.f78339o ? 1 : 0), this.f78340p));
                break;
            case 17:
                list.add(new n5.a());
                break;
            case 18:
                list.add(new z5.a());
                break;
            case 19:
                list.add(new x4.a());
                break;
            case 20:
                int i12 = this.f78332h;
                if ((i12 & 2) == 0 && (i12 & 4) == 0) {
                    list.add(new a5.a());
                    break;
                }
                break;
        }
    }

    @Override // u4.y
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public synchronized m c(boolean z11) {
        this.f78339o = z11;
        return this;
    }

    public synchronized m j(int i11) {
        this.f78341q = i11;
        return this;
    }

    @Override // u4.y
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public synchronized m a(o5.s.a aVar) {
        this.f78340p = aVar;
        return this;
    }
}
