package org.apache.commons.compress.archivers.zip;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<ZipShort, Class<?>> f72558a = new ConcurrentHashMap();

    /* JADX INFO: compiled from: source.java */
    public static final class a implements k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f72559b = new a(0);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f72560c = new a(1);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f72561d = new a(2);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f72562a;

        public a(int i11) {
            this.f72562a = i11;
        }

        @Override // org.apache.commons.compress.archivers.zip.k
        public w onUnparseableExtraField(byte[] bArr, int i11, int i12, boolean z11, int i13) throws ZipException {
            int i14 = this.f72562a;
            if (i14 == 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Bad extra field starting at ");
                sb2.append(i11);
                sb2.append(".  Block length of ");
                sb2.append(i13);
                sb2.append(" bytes exceeds remaining data of ");
                sb2.append(i12 - 4);
                sb2.append(" bytes.");
                throw new ZipException(sb2.toString());
            }
            if (i14 == 1) {
                return null;
            }
            if (i14 != 2) {
                throw new ZipException("Unknown UnparseableExtraField key: " + this.f72562a);
            }
            l lVar = new l();
            if (z11) {
                lVar.parseFromLocalFileData(bArr, i11, i12);
            } else {
                lVar.parseFromCentralDirectoryData(bArr, i11, i12);
            }
            return lVar;
        }
    }

    static {
        g(b.class);
        g(X5455_ExtendedTimestamp.class);
        g(X7875_NewUnix.class);
        g(f.class);
        g(j.class);
        g(i.class);
        g(t.class);
        g(n.class);
        g(o.class);
        g(p.class);
        g(q.class);
        g(r.class);
        g(s.class);
        g(h.class);
    }

    public static w a(ZipShort zipShort) throws IllegalAccessException, InstantiationException {
        w wVarB = b(zipShort);
        if (wVarB != null) {
            return wVarB;
        }
        m mVar = new m();
        mVar.b(zipShort);
        return mVar;
    }

    public static w b(ZipShort zipShort) throws IllegalAccessException, InstantiationException {
        Class<?> cls = f72558a.get(zipShort);
        if (cls != null) {
            return (w) cls.newInstance();
        }
        return null;
    }

    public static w c(w wVar, byte[] bArr, int i11, int i12, boolean z11) throws ZipException {
        try {
            if (z11) {
                wVar.parseFromLocalFileData(bArr, i11, i12);
            } else {
                wVar.parseFromCentralDirectoryData(bArr, i11, i12);
            }
            return wVar;
        } catch (ArrayIndexOutOfBoundsException e11) {
            throw ((ZipException) new ZipException("Failed to parse corrupt ZIP extra field of type " + Integer.toHexString(wVar.getHeaderId().getValue())).initCause(e11));
        }
    }

    public static byte[] d(w[] wVarArr) {
        byte[] centralDirectoryData;
        boolean z11 = wVarArr.length > 0 && (wVarArr[wVarArr.length - 1] instanceof l);
        int length = wVarArr.length;
        if (z11) {
            length--;
        }
        int value = length * 4;
        for (w wVar : wVarArr) {
            value += wVar.getCentralDirectoryLength().getValue();
        }
        byte[] bArr = new byte[value];
        int length2 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            System.arraycopy(wVarArr[i11].getHeaderId().getBytes(), 0, bArr, length2, 2);
            System.arraycopy(wVarArr[i11].getCentralDirectoryLength().getBytes(), 0, bArr, length2 + 2, 2);
            length2 += 4;
            byte[] centralDirectoryData2 = wVarArr[i11].getCentralDirectoryData();
            if (centralDirectoryData2 != null) {
                System.arraycopy(centralDirectoryData2, 0, bArr, length2, centralDirectoryData2.length);
                length2 += centralDirectoryData2.length;
            }
        }
        if (z11 && (centralDirectoryData = wVarArr[wVarArr.length - 1].getCentralDirectoryData()) != null) {
            System.arraycopy(centralDirectoryData, 0, bArr, length2, centralDirectoryData.length);
        }
        return bArr;
    }

    public static byte[] e(w[] wVarArr) {
        byte[] localFileDataData;
        boolean z11 = wVarArr.length > 0 && (wVarArr[wVarArr.length - 1] instanceof l);
        int length = wVarArr.length;
        if (z11) {
            length--;
        }
        int value = length * 4;
        for (w wVar : wVarArr) {
            value += wVar.getLocalFileDataLength().getValue();
        }
        byte[] bArr = new byte[value];
        int length2 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            System.arraycopy(wVarArr[i11].getHeaderId().getBytes(), 0, bArr, length2, 2);
            System.arraycopy(wVarArr[i11].getLocalFileDataLength().getBytes(), 0, bArr, length2 + 2, 2);
            length2 += 4;
            byte[] localFileDataData2 = wVarArr[i11].getLocalFileDataData();
            if (localFileDataData2 != null) {
                System.arraycopy(localFileDataData2, 0, bArr, length2, localFileDataData2.length);
                length2 += localFileDataData2.length;
            }
        }
        if (z11 && (localFileDataData = wVarArr[wVarArr.length - 1].getLocalFileDataData()) != null) {
            System.arraycopy(localFileDataData, 0, bArr, length2, localFileDataData.length);
        }
        return bArr;
    }

    public static w[] f(byte[] bArr, boolean z11, c cVar) throws ZipException {
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (i11 <= bArr.length - 4) {
            ZipShort zipShort = new ZipShort(bArr, i11);
            int value = new ZipShort(bArr, i11 + 2).getValue();
            int i12 = i11 + 4;
            if (i12 + value > bArr.length) {
                w wVarOnUnparseableExtraField = cVar.onUnparseableExtraField(bArr, i11, bArr.length - i11, z11, value);
                if (wVarOnUnparseableExtraField == null) {
                    break;
                }
                arrayList.add(wVarOnUnparseableExtraField);
                break;
            }
            try {
                w wVarCreateExtraField = cVar.createExtraField(zipShort);
                Objects.requireNonNull(wVarCreateExtraField, "createExtraField must not return null");
                w wVarFill = cVar.fill(wVarCreateExtraField, bArr, i12, value, z11);
                Objects.requireNonNull(wVarFill, "fill must not return null");
                arrayList.add(wVarFill);
                i11 += value + 4;
            } catch (IllegalAccessException | InstantiationException e11) {
                throw ((ZipException) new ZipException(e11.getMessage()).initCause(e11));
            }
        }
        return (w[]) arrayList.toArray(new w[arrayList.size()]);
    }

    public static void g(Class<?> cls) {
        try {
            f72558a.put(((w) cls.newInstance()).getHeaderId(), cls);
        } catch (ClassCastException unused) {
            throw new RuntimeException(cls + " doesn't implement ZipExtraField");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException(cls + "'s no-arg constructor is not public");
        } catch (InstantiationException unused3) {
            throw new RuntimeException(cls + " is not a concrete class");
        }
    }
}
