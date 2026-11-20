package i30;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class b extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f66908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f66909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f66910e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f66911f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f66912g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f66913h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f66914i;

    public b(x xVar, d dVar, b bVar) {
        this(xVar, true, dVar, bVar);
    }

    public b(x xVar, boolean z11, d dVar, b bVar) {
        super(458752);
        this.f66908c = xVar;
        this.f66909d = z11;
        this.f66910e = dVar;
        int i11 = dVar.f66921b;
        this.f66911f = i11 == 0 ? -1 : i11 - 2;
        this.f66913h = bVar;
        if (bVar != null) {
            bVar.f66914i = this;
        }
    }

    public static int g(String str, b[] bVarArr, int i11) {
        int iF = (i11 * 2) + 7;
        for (int i12 = 0; i12 < i11; i12++) {
            b bVar = bVarArr[i12];
            iF += bVar == null ? 0 : bVar.f(str) - 8;
        }
        return iF;
    }

    public static void i(int i11, b[] bVarArr, int i12, d dVar) {
        int iF = (i12 * 2) + 1;
        for (int i13 = 0; i13 < i12; i13++) {
            b bVar = bVarArr[i13];
            iF += bVar == null ? 0 : bVar.f(null) - 8;
        }
        dVar.k(i11);
        dVar.i(iF);
        dVar.g(i12);
        for (int i14 = 0; i14 < i12; i14++) {
            b bVar2 = null;
            int i15 = 0;
            for (b bVar3 = bVarArr[i14]; bVar3 != null; bVar3 = bVar3.f66913h) {
                bVar3.d();
                i15++;
                bVar2 = bVar3;
            }
            dVar.k(i15);
            while (bVar2 != null) {
                d dVar2 = bVar2.f66910e;
                dVar.h(dVar2.f66920a, 0, dVar2.f66921b);
                bVar2 = bVar2.f66914i;
            }
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // i30.a
    public void a(String str, Object obj) {
        this.f66912g++;
        if (this.f66909d) {
            this.f66910e.k(this.f66908c.D(str));
        }
        if (obj instanceof String) {
            this.f66910e.e(115, this.f66908c.D((String) obj));
            return;
        }
        if (obj instanceof Byte) {
            this.f66910e.e(66, this.f66908c.l(((Byte) obj).byteValue()).f67083a);
            return;
        }
        if (obj instanceof Boolean) {
            this.f66910e.e(90, this.f66908c.l(((Boolean) obj).booleanValue() ? 1 : 0).f67083a);
            return;
        }
        if (obj instanceof Character) {
            this.f66910e.e(67, this.f66908c.l(((Character) obj).charValue()).f67083a);
            return;
        }
        if (obj instanceof Short) {
            this.f66910e.e(83, this.f66908c.l(((Short) obj).shortValue()).f67083a);
            return;
        }
        if (obj instanceof y) {
            this.f66910e.e(99, this.f66908c.D(((y) obj).e()));
            return;
        }
        int i11 = 0;
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            this.f66910e.e(91, bArr.length);
            int length = bArr.length;
            while (i11 < length) {
                this.f66910e.e(66, this.f66908c.l(bArr[i11]).f67083a);
                i11++;
            }
            return;
        }
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            this.f66910e.e(91, zArr.length);
            int length2 = zArr.length;
            while (i11 < length2) {
                this.f66910e.e(90, this.f66908c.l(zArr[i11] ? 1 : 0).f67083a);
                i11++;
            }
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            this.f66910e.e(91, sArr.length);
            int length3 = sArr.length;
            while (i11 < length3) {
                this.f66910e.e(83, this.f66908c.l(sArr[i11]).f67083a);
                i11++;
            }
            return;
        }
        if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            this.f66910e.e(91, cArr.length);
            int length4 = cArr.length;
            while (i11 < length4) {
                this.f66910e.e(67, this.f66908c.l(cArr[i11]).f67083a);
                i11++;
            }
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            this.f66910e.e(91, iArr.length);
            int length5 = iArr.length;
            while (i11 < length5) {
                this.f66910e.e(73, this.f66908c.l(iArr[i11]).f67083a);
                i11++;
            }
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            this.f66910e.e(91, jArr.length);
            int length6 = jArr.length;
            while (i11 < length6) {
                this.f66910e.e(74, this.f66908c.p(jArr[i11]).f67083a);
                i11++;
            }
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            this.f66910e.e(91, fArr.length);
            int length7 = fArr.length;
            while (i11 < length7) {
                this.f66910e.e(70, this.f66908c.k(fArr[i11]).f67083a);
                i11++;
            }
            return;
        }
        if (!(obj instanceof double[])) {
            w wVarD = this.f66908c.d(obj);
            this.f66910e.e(".s.IFJDCS".charAt(wVarD.f67084b), wVarD.f67083a);
            return;
        }
        double[] dArr = (double[]) obj;
        this.f66910e.e(91, dArr.length);
        int length8 = dArr.length;
        while (i11 < length8) {
            this.f66910e.e(68, this.f66908c.f(dArr[i11]).f67083a);
            i11++;
        }
    }

    @Override // i30.a
    public a b(String str, String str2) {
        this.f66912g++;
        if (this.f66909d) {
            this.f66910e.k(this.f66908c.D(str));
        }
        this.f66910e.e(64, this.f66908c.D(str2)).k(0);
        return new b(this.f66908c, this.f66910e, null);
    }

    @Override // i30.a
    public a c(String str) {
        this.f66912g++;
        if (this.f66909d) {
            this.f66910e.k(this.f66908c.D(str));
        }
        this.f66910e.e(91, 0);
        return new b(this.f66908c, false, this.f66910e, null);
    }

    @Override // i30.a
    public void d() {
        int i11 = this.f66911f;
        if (i11 != -1) {
            byte[] bArr = this.f66910e.f66920a;
            int i12 = this.f66912g;
            bArr[i11] = (byte) (i12 >>> 8);
            bArr[i11 + 1] = (byte) i12;
        }
    }

    @Override // i30.a
    public void e(String str, String str2, String str3) {
        this.f66912g++;
        if (this.f66909d) {
            this.f66910e.k(this.f66908c.D(str));
        }
        this.f66910e.e(101, this.f66908c.D(str2)).k(this.f66908c.D(str3));
    }

    public int f(String str) {
        if (str != null) {
            this.f66908c.D(str);
        }
        int i11 = 8;
        for (b bVar = this; bVar != null; bVar = bVar.f66913h) {
            i11 += bVar.f66910e.f66921b;
        }
        return i11;
    }

    public void h(int i11, d dVar) {
        int i12 = 2;
        int i13 = 0;
        b bVar = null;
        for (b bVar2 = this; bVar2 != null; bVar2 = bVar2.f66913h) {
            bVar2.d();
            i12 += bVar2.f66910e.f66921b;
            i13++;
            bVar = bVar2;
        }
        dVar.k(i11);
        dVar.i(i12);
        dVar.k(i13);
        while (bVar != null) {
            d dVar2 = bVar.f66910e;
            dVar.h(dVar2.f66920a, 0, dVar2.f66921b);
            bVar = bVar.f66914i;
        }
    }
}
