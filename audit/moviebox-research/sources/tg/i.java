package tg;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i implements r {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f77055n = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f77056o = new a(new a.InterfaceC0853a() { // from class: tg.g
        @Override // tg.i.a.InterfaceC0853a
        public final Constructor a() {
            return i.e();
        }
    });

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f77057p = new a(new a.InterfaceC0853a() { // from class: tg.h
        @Override // tg.i.a.InterfaceC0853a
        public final Constructor a() {
            return i.f();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f77058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f77059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f77060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f77061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f77062f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f77063g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f77064h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f77065i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f77066j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f77068l;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f77067k = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f77069m = 112800;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC0853a f77070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f77071b = new AtomicBoolean(false);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public Constructor<? extends l> f77072c;

        /* JADX INFO: renamed from: tg.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public interface InterfaceC0853a {
            @Nullable
            Constructor<? extends l> a() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException;
        }

        public a(InterfaceC0853a interfaceC0853a) {
            this.f77070a = interfaceC0853a;
        }

        @Nullable
        public l a(Object... objArr) {
            Constructor<? extends l> constructorB = b();
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
        public final Constructor<? extends l> b() {
            synchronized (this.f77071b) {
                if (this.f77071b.get()) {
                    return this.f77072c;
                }
                try {
                    return this.f77070a.a();
                } catch (ClassNotFoundException unused) {
                    this.f77071b.set(true);
                    return this.f77072c;
                } catch (Exception e11) {
                    throw new RuntimeException("Error instantiating extension", e11);
                }
            }
        }
    }

    @Nullable
    public static Constructor<? extends l> e() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        if (Boolean.TRUE.equals(Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
            return Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(l.class).getConstructor(Integer.TYPE);
        }
        return null;
    }

    public static Constructor<? extends l> f() throws NoSuchMethodException, ClassNotFoundException {
        return Class.forName("com.google.android.exoplayer2.decoder.midi.MidiExtractor").asSubclass(l.class).getConstructor(new Class[0]);
    }

    @Override // tg.r
    public synchronized l[] b(Uri uri, Map<String, List<String>> map) {
        ArrayList arrayList;
        try {
            int[] iArr = f77055n;
            arrayList = new ArrayList(iArr.length);
            int iB = com.google.android.exoplayer2.util.l.b(map);
            if (iB != -1) {
                d(iB, arrayList);
            }
            int iC = com.google.android.exoplayer2.util.l.c(uri);
            if (iC != -1 && iC != iB) {
                d(iC, arrayList);
            }
            for (int i11 : iArr) {
                if (i11 != iB && i11 != iC) {
                    d(i11, arrayList);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return (l[]) arrayList.toArray(new l[arrayList.size()]);
    }

    @Override // tg.r
    public synchronized l[] createExtractors() {
        return b(Uri.EMPTY, new HashMap());
    }

    public final void d(int i11, List<l> list) {
        switch (i11) {
            case 0:
                list.add(new dh.b());
                break;
            case 1:
                list.add(new dh.e());
                break;
            case 2:
                list.add(new dh.h((this.f77059c ? 2 : 0) | ((this.f77060d | (this.f77058b ? 1 : 0)) == true ? 1 : 0)));
                break;
            case 3:
                list.add(new ug.b((this.f77059c ? 2 : 0) | this.f77061e | (this.f77058b ? 1 : 0)));
                break;
            case 4:
                l lVarA = f77056o.a(Integer.valueOf(this.f77062f));
                if (lVarA == null) {
                    list.add(new wg.d(this.f77062f));
                } else {
                    list.add(lVarA);
                }
                break;
            case 5:
                list.add(new xg.b());
                break;
            case 6:
                list.add(new zg.e(this.f77063g));
                break;
            case 7:
                list.add(new ah.f((this.f77059c ? 2 : 0) | this.f77066j | (this.f77058b ? 1 : 0)));
                break;
            case 8:
                list.add(new bh.g(this.f77065i));
                list.add(new bh.k(this.f77064h));
                break;
            case 9:
                list.add(new ch.d());
                break;
            case 10:
                list.add(new dh.a0());
                break;
            case 11:
                list.add(new dh.h0(this.f77067k, this.f77068l, this.f77069m));
                break;
            case 12:
                list.add(new eh.b());
                break;
            case 14:
                list.add(new yg.a());
                break;
            case 15:
                l lVarA2 = f77057p.a(new Object[0]);
                if (lVarA2 != null) {
                    list.add(lVarA2);
                }
                break;
            case 16:
                list.add(new vg.b());
                break;
        }
    }
}
