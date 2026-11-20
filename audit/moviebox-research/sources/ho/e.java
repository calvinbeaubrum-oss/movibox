package ho;

import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoBuilder;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements io.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseBooleanArray f66669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f66670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f66671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f66672d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f66673e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f66674f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f66675g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f66676h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f66677i;

    /* JADX INFO: compiled from: source.java */
    @AutoBuilder
    public static abstract class a {
        public abstract byte a();

        public abstract m b(byte b11);

        public abstract m c(SparseBooleanArray sparseBooleanArray);

        public abstract SparseBooleanArray d();

        public abstract a e(String str);

        public abstract e f();

        public a g(int i11, boolean z11) {
            int iA = a() & 255;
            int iA2 = io.d.a(i11);
            return b((byte) (z11 ? iA2 | iA : (~iA2) & iA));
        }

        public a h(int i11, boolean z11) {
            SparseBooleanArray sparseBooleanArrayD = d();
            if (z11) {
                sparseBooleanArrayD.put(i11, true);
            } else {
                sparseBooleanArrayD.delete(i11);
            }
            return this;
        }

        public abstract a i(int i11);

        public abstract a j(String str);

        public abstract a k(String str);

        public abstract a l(String str);

        public abstract a m(List<InetAddress> list);

        public abstract a n(int i11);
    }

    public e(SparseBooleanArray sparseBooleanArray, byte b11, int i11, int i12, List list, String str, String str2, String str3, String str4) {
        this.f66669a = sparseBooleanArray;
        this.f66670b = b11;
        this.f66671c = i11;
        this.f66672d = i12;
        this.f66673e = list;
        this.f66674f = str;
        this.f66675g = str2;
        this.f66676h = str3;
        this.f66677i = str4;
    }

    public static a l() {
        m mVar = new m();
        mVar.f66725a = new SparseBooleanArray();
        return mVar.b((byte) 0).i(0).n(0).m(Collections.emptyList()).j("").e("").l("").k("");
    }

    @Override // io.l
    public void a(io.r rVar) {
        rVar.s(3, this.f66671c).s(4, this.f66672d).u(6, this.f66674f).u(7, this.f66675g).u(8, this.f66676h).u(9, this.f66677i);
        for (int i11 = 0; i11 < this.f66669a.size(); i11++) {
            if (this.f66669a.valueAt(i11)) {
                rVar.s(1, this.f66669a.keyAt(i11));
            }
        }
        byte b11 = this.f66670b;
        if (b11 != 0) {
            rVar.h(2, new byte[]{b11});
        }
        Iterator it = this.f66673e.iterator();
        while (it.hasNext()) {
            rVar.h(5, ((InetAddress) it.next()).getAddress());
        }
    }

    public String c() {
        return this.f66675g;
    }

    public byte d() {
        return this.f66670b;
    }

    public SparseBooleanArray e() {
        return this.f66669a;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Objects.equals(this.f66669a, eVar.f66669a) && this.f66670b == eVar.f66670b && this.f66671c == eVar.f66671c && this.f66672d == eVar.f66672d && Objects.equals(this.f66673e, eVar.f66673e) && Objects.equals(this.f66674f, eVar.f66674f) && Objects.equals(this.f66675g, eVar.f66675g) && Objects.equals(this.f66676h, eVar.f66676h) && Objects.equals(this.f66677i, eVar.f66677i);
    }

    public int f() {
        return this.f66671c;
    }

    public String g() {
        return this.f66674f;
    }

    public String h() {
        return this.f66677i;
    }

    public int hashCode() {
        return Objects.hash(this.f66669a, Byte.valueOf(this.f66670b), Integer.valueOf(this.f66671c), Integer.valueOf(this.f66672d), this.f66673e, this.f66674f, this.f66675g, this.f66676h, this.f66677i);
    }

    public String i() {
        return this.f66676h;
    }

    public List<InetAddress> j() {
        return this.f66673e;
    }

    @Override // io.l
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public e b(io.o oVar) {
        m mVarC = m().c(this.f66669a);
        while (oVar.b()) {
            switch (oVar.n()) {
                case 1:
                    SparseBooleanArray sparseBooleanArrayD = mVarC.d();
                    if (sparseBooleanArrayD == this.f66669a) {
                        sparseBooleanArrayD = new SparseBooleanArray(1);
                        mVarC.f66725a = sparseBooleanArrayD;
                    }
                    sparseBooleanArrayD.put(oVar.o(), true);
                    break;
                case 2:
                    mVarC.b(oVar.f().get());
                    break;
                case 3:
                    mVarC.i(oVar.o());
                    break;
                case 4:
                    mVarC.n(oVar.o());
                    break;
                case 5:
                    List arrayList = mVarC.f66729e;
                    if (arrayList == null) {
                        throw new IllegalStateException("Property \"linkNames\" has not been set");
                    }
                    if (arrayList == this.f66673e) {
                        arrayList = new ArrayList(1);
                        mVarC.f66729e = arrayList;
                    }
                    try {
                        arrayList.add(InetAddress.getByAddress(oVar.e()));
                    } catch (Exception e11) {
                        throw new IllegalStateException("malformed name", e11);
                    }
                    break;
                    break;
                case 6:
                    mVarC.j(oVar.q());
                    break;
                case 7:
                    mVarC.e(oVar.q());
                    break;
                case 8:
                    mVarC.l(oVar.q());
                    break;
                case 9:
                    mVarC.k(oVar.q());
                    break;
                default:
                    oVar.c();
                    break;
            }
        }
        return mVarC.f();
    }

    public a m() {
        return new m(this).c(this.f66669a.clone());
    }

    public int n() {
        return this.f66672d;
    }

    public String toString() {
        return super.toString();
    }
}
