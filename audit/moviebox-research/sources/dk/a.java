package dk;

import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public abstract class a implements b {
    public boolean getBooleanParameter(String str, boolean z11) {
        Object parameter = getParameter(str);
        return parameter == null ? z11 : ((Boolean) parameter).booleanValue();
    }

    public double getDoubleParameter(String str, double d11) {
        Object parameter = getParameter(str);
        return parameter == null ? d11 : ((Double) parameter).doubleValue();
    }

    public int getIntParameter(String str, int i11) {
        Object parameter = getParameter(str);
        return parameter == null ? i11 : ((Integer) parameter).intValue();
    }

    public long getLongParameter(String str, long j11) {
        Object parameter = getParameter(str);
        return parameter == null ? j11 : ((Long) parameter).longValue();
    }

    public Set<String> getNames() {
        throw new UnsupportedOperationException();
    }

    public boolean isParameterFalse(String str) {
        return !getBooleanParameter(str, false);
    }

    public boolean isParameterTrue(String str) {
        return getBooleanParameter(str, false);
    }

    public b setBooleanParameter(String str, boolean z11) {
        setParameter(str, z11 ? Boolean.TRUE : Boolean.FALSE);
        return this;
    }

    public b setDoubleParameter(String str, double d11) {
        setParameter(str, Double.valueOf(d11));
        return this;
    }

    public b setIntParameter(String str, int i11) {
        setParameter(str, Integer.valueOf(i11));
        return this;
    }

    public b setLongParameter(String str, long j11) {
        setParameter(str, Long.valueOf(j11));
        return this;
    }
}
