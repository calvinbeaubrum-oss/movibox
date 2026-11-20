package m7;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class h implements b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f70886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Enum[] f70887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Enum[] f70888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long[] f70889d;

    public h(Class<?> cls) {
        j7.b bVar;
        this.f70886a = cls;
        this.f70888c = (Enum[]) cls.getEnumConstants();
        HashMap map = new HashMap();
        int i11 = 0;
        while (true) {
            Enum[] enumArr = this.f70888c;
            if (i11 >= enumArr.length) {
                break;
            }
            Enum r11 = enumArr[i11];
            String strName = r11.name();
            j7.b bVar2 = null;
            try {
                bVar = (j7.b) TypeUtils.O(cls.getField(strName), j7.b.class);
                if (bVar != null) {
                    try {
                        String strName2 = bVar.name();
                        if (strName2 != null && strName2.length() > 0) {
                            strName = strName2;
                        }
                    } catch (Exception unused) {
                        bVar2 = bVar;
                        bVar = bVar2;
                    }
                }
            } catch (Exception unused2) {
            }
            int i12 = 0;
            long j11 = -3750763034362895579L;
            long j12 = -3750763034362895579L;
            while (i12 < strName.length()) {
                int iCharAt = strName.charAt(i12);
                long j13 = ((long) iCharAt) ^ j11;
                if (iCharAt >= 65 && iCharAt <= 90) {
                    iCharAt += 32;
                }
                j12 = (((long) iCharAt) ^ j12) * 1099511628211L;
                i12++;
                j11 = j13 * 1099511628211L;
            }
            map.put(Long.valueOf(j11), r11);
            if (j11 != j12) {
                map.put(Long.valueOf(j12), r11);
            }
            if (bVar != null) {
                String[] strArrAlternateNames = bVar.alternateNames();
                int length = strArrAlternateNames.length;
                int i13 = 0;
                while (i13 < length) {
                    String str = strArrAlternateNames[i13];
                    int i14 = 0;
                    long jCharAt = -3750763034362895579L;
                    while (i14 < str.length()) {
                        jCharAt = (jCharAt ^ ((long) str.charAt(i14))) * 1099511628211L;
                        i14++;
                        i11 = i11;
                    }
                    int i15 = i11;
                    if (jCharAt != j11 && jCharAt != j12) {
                        map.put(Long.valueOf(jCharAt), r11);
                    }
                    i13++;
                    i11 = i15;
                }
            }
            i11++;
        }
        this.f70889d = new long[map.size()];
        Iterator it = map.keySet().iterator();
        int i16 = 0;
        while (it.hasNext()) {
            this.f70889d[i16] = ((Long) it.next()).longValue();
            i16++;
        }
        Arrays.sort(this.f70889d);
        this.f70887b = new Enum[this.f70889d.length];
        int i17 = 0;
        while (true) {
            long[] jArr = this.f70889d;
            if (i17 >= jArr.length) {
                return;
            }
            this.f70887b[i17] = (Enum) map.get(Long.valueOf(jArr[i17]));
            i17++;
        }
    }

    @Override // m7.b2
    public int b() {
        return 2;
    }

    public Enum c(long j11) {
        int iBinarySearch;
        if (this.f70887b != null && (iBinarySearch = Arrays.binarySearch(this.f70889d, j11)) >= 0) {
            return this.f70887b[iBinarySearch];
        }
        return null;
    }

    public Enum<?> d(int i11) {
        return this.f70888c[i11];
    }

    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        try {
            l7.b bVar = aVar.f70077g;
            int iK0 = bVar.k0();
            if (iK0 == 2) {
                int iH = bVar.h();
                bVar.W(16);
                if (iH >= 0) {
                    Object[] objArr = this.f70888c;
                    if (iH < objArr.length) {
                        return (T) objArr[iH];
                    }
                }
                throw new JSONException("parse enum " + this.f70886a.getName() + " error, value : " + iH);
            }
            if (iK0 != 4) {
                if (iK0 == 8) {
                    bVar.W(16);
                    return null;
                }
                throw new JSONException("parse enum " + this.f70886a.getName() + " error, value : " + aVar.x());
            }
            String strG0 = bVar.g0();
            bVar.W(16);
            if (strG0.length() == 0) {
                return null;
            }
            long j11 = -3750763034362895579L;
            long j12 = -3750763034362895579L;
            for (int i11 = 0; i11 < strG0.length(); i11++) {
                int iCharAt = strG0.charAt(i11);
                long j13 = j11 ^ ((long) iCharAt);
                if (iCharAt >= 65 && iCharAt <= 90) {
                    iCharAt += 32;
                }
                j11 = j13 * 1099511628211L;
                j12 = (j12 ^ ((long) iCharAt)) * 1099511628211L;
            }
            T t11 = (T) c(j11);
            if (t11 == null && j12 != j11) {
                t11 = (T) c(j12);
            }
            if (t11 == null && bVar.g(Feature.ErrorOnEnumNotMatch)) {
                throw new JSONException("not match enum value, " + this.f70886a.getName() + " : " + strG0);
            }
            return t11;
        } catch (JSONException e11) {
            throw e11;
        } catch (Exception e12) {
            throw new JSONException(e12.getMessage(), e12);
        }
    }
}
