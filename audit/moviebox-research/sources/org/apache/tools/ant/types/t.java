package org.apache.tools.ant.types;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class t extends e implements Comparable, u {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f72925g = h("Resource".getBytes());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f72926h = h("null name".getBytes());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f72927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f72928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f72929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f72930d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Long f72931f;

    public t() {
        this.f72927a = null;
        this.f72928b = null;
        this.f72929c = null;
        this.f72930d = null;
        this.f72931f = null;
    }

    public t(String str) {
        this(str, false, 0L, false);
    }

    public t(String str, boolean z11, long j11, boolean z12) {
        this(str, z11, j11, z12, -1L);
    }

    public t(String str, boolean z11, long j11, boolean z12, long j12) {
        this.f72928b = null;
        this.f72929c = null;
        this.f72930d = null;
        this.f72931f = null;
        this.f72927a = str;
        q(str);
        o(z11);
        p(j11);
        n(z12);
        r(j12);
    }

    public static int h(byte[] bArr) {
        return new BigInteger(bArr).intValue();
    }

    @Override // org.apache.tools.ant.types.u
    public boolean a() {
        return isReference() && ((t) getCheckedRef()).a();
    }

    public InputStream c() throws IOException {
        if (isReference()) {
            return ((t) getCheckedRef()).c();
        }
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.tools.ant.types.e, org.apache.tools.ant.v
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new UnsupportedOperationException("CloneNotSupportedException for a Resource caught. Derived classes must support cloning.");
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (isReference()) {
            return ((Comparable) getCheckedRef()).compareTo(obj);
        }
        if (obj instanceof t) {
            return toString().compareTo(obj.toString());
        }
        throw new IllegalArgumentException("Can only be compared with Resources");
    }

    public long d() {
        Long l11;
        if (isReference()) {
            return ((t) getCheckedRef()).d();
        }
        if (!m() || (l11 = this.f72929c) == null) {
            return 0L;
        }
        long jLongValue = l11.longValue();
        if (jLongValue < 0) {
            return 0L;
        }
        return jLongValue;
    }

    public boolean equals(Object obj) {
        if (isReference()) {
            return getCheckedRef().equals(obj);
        }
        return obj.getClass().equals(getClass()) && compareTo(obj) == 0;
    }

    public int hashCode() {
        if (isReference()) {
            return getCheckedRef().hashCode();
        }
        String strJ = j();
        return f72925g * (strJ == null ? f72926h : strJ.hashCode());
    }

    @Override // org.apache.tools.ant.types.u
    public Iterator iterator() {
        return isReference() ? ((t) getCheckedRef()).iterator() : new s(this);
    }

    public String j() {
        return isReference() ? ((t) getCheckedRef()).j() : this.f72927a;
    }

    public long k() {
        if (isReference()) {
            return ((t) getCheckedRef()).k();
        }
        if (!m()) {
            return 0L;
        }
        Long l11 = this.f72931f;
        if (l11 != null) {
            return l11.longValue();
        }
        return -1L;
    }

    public boolean l() {
        if (isReference()) {
            return ((t) getCheckedRef()).l();
        }
        Boolean bool = this.f72930d;
        return bool != null && bool.booleanValue();
    }

    public boolean m() {
        if (isReference()) {
            return ((t) getCheckedRef()).m();
        }
        Boolean bool = this.f72928b;
        return bool == null || bool.booleanValue();
    }

    public void n(boolean z11) {
        checkAttributesAllowed();
        this.f72930d = z11 ? Boolean.TRUE : Boolean.FALSE;
    }

    public void o(boolean z11) {
        checkAttributesAllowed();
        this.f72928b = z11 ? Boolean.TRUE : Boolean.FALSE;
    }

    public void p(long j11) {
        checkAttributesAllowed();
        this.f72929c = new Long(j11);
    }

    public void q(String str) {
        checkAttributesAllowed();
        this.f72927a = str;
    }

    public void r(long j11) {
        checkAttributesAllowed();
        if (j11 <= -1) {
            j11 = -1;
        }
        this.f72931f = new Long(j11);
    }

    @Override // org.apache.tools.ant.types.e
    public void setRefid(r rVar) {
        if (this.f72927a != null || this.f72928b != null || this.f72929c != null || this.f72930d != null || this.f72931f != null) {
            throw tooManyAttributes();
        }
        super.setRefid(rVar);
    }

    @Override // org.apache.tools.ant.types.u
    public int size() {
        if (isReference()) {
            return ((t) getCheckedRef()).size();
        }
        return 1;
    }

    @Override // org.apache.tools.ant.types.e
    public String toString() {
        if (isReference()) {
            return getCheckedRef().toString();
        }
        String strJ = j();
        return strJ == null ? "(anonymous)" : strJ;
    }
}
