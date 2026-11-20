package androidx.constraintlayout.core;

import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class SolverVariable implements Comparable<SolverVariable> {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static int f6306s = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6308b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f6312g;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Type f6316k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6309c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6310d = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6311f = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6313h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float[] f6314i = new float[9];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float[] f6315j = new float[9];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b[] f6317l = new b[16];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6318m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6319n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f6320o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6321p = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f6322q = 0.0f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public HashSet<b> f6323r = null;

    /* JADX INFO: compiled from: source.java */
    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(Type type, String str) {
        this.f6316k = type;
    }

    public static void c() {
        f6306s++;
    }

    public final void a(b bVar) {
        int i11 = 0;
        while (true) {
            int i12 = this.f6318m;
            if (i11 >= i12) {
                b[] bVarArr = this.f6317l;
                if (i12 >= bVarArr.length) {
                    this.f6317l = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f6317l;
                int i13 = this.f6318m;
                bVarArr2[i13] = bVar;
                this.f6318m = i13 + 1;
                return;
            }
            if (this.f6317l[i11] == bVar) {
                return;
            } else {
                i11++;
            }
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(SolverVariable solverVariable) {
        return this.f6309c - solverVariable.f6309c;
    }

    public final void d(b bVar) {
        int i11 = this.f6318m;
        int i12 = 0;
        while (i12 < i11) {
            if (this.f6317l[i12] == bVar) {
                while (i12 < i11 - 1) {
                    b[] bVarArr = this.f6317l;
                    int i13 = i12 + 1;
                    bVarArr[i12] = bVarArr[i13];
                    i12 = i13;
                }
                this.f6318m--;
                return;
            }
            i12++;
        }
    }

    public void e() {
        this.f6308b = null;
        this.f6316k = Type.UNKNOWN;
        this.f6311f = 0;
        this.f6309c = -1;
        this.f6310d = -1;
        this.f6312g = 0.0f;
        this.f6313h = false;
        this.f6320o = false;
        this.f6321p = -1;
        this.f6322q = 0.0f;
        int i11 = this.f6318m;
        for (int i12 = 0; i12 < i11; i12++) {
            this.f6317l[i12] = null;
        }
        this.f6318m = 0;
        this.f6319n = 0;
        this.f6307a = false;
        Arrays.fill(this.f6315j, 0.0f);
    }

    public void h(d dVar, float f11) {
        this.f6312g = f11;
        this.f6313h = true;
        this.f6320o = false;
        this.f6321p = -1;
        this.f6322q = 0.0f;
        int i11 = this.f6318m;
        this.f6310d = -1;
        for (int i12 = 0; i12 < i11; i12++) {
            this.f6317l[i12].A(dVar, this, false);
        }
        this.f6318m = 0;
    }

    public void i(Type type, String str) {
        this.f6316k = type;
    }

    public final void j(d dVar, b bVar) {
        int i11 = this.f6318m;
        for (int i12 = 0; i12 < i11; i12++) {
            this.f6317l[i12].B(dVar, bVar, false);
        }
        this.f6318m = 0;
    }

    public String toString() {
        if (this.f6308b != null) {
            return "" + this.f6308b;
        }
        return "" + this.f6309c;
    }
}
