package zl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class l implements yl.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f82098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f82099b;

    public l(String str, int i11) {
        this.f82098a = str;
        this.f82099b = i11;
    }

    @Override // yl.i
    public int a() {
        return this.f82099b;
    }

    @Override // yl.i
    public String b() {
        if (this.f82099b == 0) {
            return "";
        }
        g();
        return this.f82098a;
    }

    @Override // yl.i
    public long c() {
        if (this.f82099b == 0) {
            return 0L;
        }
        String strF = f();
        try {
            return Long.valueOf(strF).longValue();
        } catch (NumberFormatException e11) {
            throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", strF, "long"), e11);
        }
    }

    @Override // yl.i
    public double d() {
        if (this.f82099b == 0) {
            return 0.0d;
        }
        String strF = f();
        try {
            return Double.valueOf(strF).doubleValue();
        } catch (NumberFormatException e11) {
            throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", strF, "double"), e11);
        }
    }

    @Override // yl.i
    public boolean e() throws IllegalArgumentException {
        if (this.f82099b == 0) {
            return false;
        }
        String strF = f();
        if (j.f82089f.matcher(strF).matches()) {
            return true;
        }
        if (j.f82090g.matcher(strF).matches()) {
            return false;
        }
        throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", strF, "boolean"));
    }

    public final String f() {
        return b().trim();
    }

    public final void g() {
        if (this.f82098a == null) {
            throw new IllegalArgumentException("Value is null, and cannot be converted to the desired type.");
        }
    }
}
