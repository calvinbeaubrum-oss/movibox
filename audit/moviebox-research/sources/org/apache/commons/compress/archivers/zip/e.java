package org.apache.commons.compress.archivers.zip;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class e implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f72563a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f72564b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f72565c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f72566d = false;

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e11) {
            throw new RuntimeException("GeneralPurposeBit is not Cloneable?", e11);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return eVar.f72565c == this.f72565c && eVar.f72566d == this.f72566d && eVar.f72563a == this.f72563a && eVar.f72564b == this.f72564b;
    }

    public int hashCode() {
        return (((((((this.f72565c ? 1 : 0) * 17) + (this.f72566d ? 1 : 0)) * 13) + (this.f72563a ? 1 : 0)) * 7) + (this.f72564b ? 1 : 0)) * 3;
    }
}
