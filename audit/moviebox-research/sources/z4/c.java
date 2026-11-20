package z4;

import androidx.annotation.Nullable;
import androidx.media3.extractor.flv.TagPayloadReader;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import u4.q;
import z3.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends TagPayloadReader {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f81872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long[] f81873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long[] f81874d;

    public c() {
        super(new q());
        this.f81872b = C.TIME_UNSET;
        this.f81873c = new long[0];
        this.f81874d = new long[0];
    }

    public static Boolean g(c0 c0Var) {
        return Boolean.valueOf(c0Var.H() == 1);
    }

    @Nullable
    public static Object h(c0 c0Var, int i11) {
        if (i11 == 0) {
            return j(c0Var);
        }
        if (i11 == 1) {
            return g(c0Var);
        }
        if (i11 == 2) {
            return n(c0Var);
        }
        if (i11 == 3) {
            return l(c0Var);
        }
        if (i11 == 8) {
            return k(c0Var);
        }
        if (i11 == 10) {
            return m(c0Var);
        }
        if (i11 != 11) {
            return null;
        }
        return i(c0Var);
    }

    public static Date i(c0 c0Var) {
        Date date = new Date((long) j(c0Var).doubleValue());
        c0Var.V(2);
        return date;
    }

    public static Double j(c0 c0Var) {
        return Double.valueOf(Double.longBitsToDouble(c0Var.A()));
    }

    public static HashMap<String, Object> k(c0 c0Var) {
        int iL = c0Var.L();
        HashMap<String, Object> map = new HashMap<>(iL);
        for (int i11 = 0; i11 < iL; i11++) {
            String strN = n(c0Var);
            Object objH = h(c0Var, o(c0Var));
            if (objH != null) {
                map.put(strN, objH);
            }
        }
        return map;
    }

    public static HashMap<String, Object> l(c0 c0Var) {
        HashMap<String, Object> map = new HashMap<>();
        while (true) {
            String strN = n(c0Var);
            int iO = o(c0Var);
            if (iO == 9) {
                return map;
            }
            Object objH = h(c0Var, iO);
            if (objH != null) {
                map.put(strN, objH);
            }
        }
    }

    public static ArrayList<Object> m(c0 c0Var) {
        int iL = c0Var.L();
        ArrayList<Object> arrayList = new ArrayList<>(iL);
        for (int i11 = 0; i11 < iL; i11++) {
            Object objH = h(c0Var, o(c0Var));
            if (objH != null) {
                arrayList.add(objH);
            }
        }
        return arrayList;
    }

    public static String n(c0 c0Var) {
        int iN = c0Var.N();
        int iF = c0Var.f();
        c0Var.V(iN);
        return new String(c0Var.e(), iF, iN);
    }

    public static int o(c0 c0Var) {
        return c0Var.H();
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    public boolean b(c0 c0Var) {
        return true;
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    public boolean c(c0 c0Var, long j11) {
        if (o(c0Var) != 2 || !"onMetaData".equals(n(c0Var)) || c0Var.a() == 0 || o(c0Var) != 8) {
            return false;
        }
        HashMap<String, Object> mapK = k(c0Var);
        Object obj = mapK.get("duration");
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (dDoubleValue > 0.0d) {
                this.f81872b = (long) (dDoubleValue * 1000000.0d);
            }
        }
        Object obj2 = mapK.get("keyframes");
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get("filepositions");
            Object obj4 = map.get("times");
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.f81873c = new long[size];
                this.f81874d = new long[size];
                for (int i11 = 0; i11 < size; i11++) {
                    Object obj5 = list.get(i11);
                    Object obj6 = list2.get(i11);
                    if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                        this.f81873c = new long[0];
                        this.f81874d = new long[0];
                        break;
                    }
                    this.f81873c[i11] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                    this.f81874d[i11] = ((Double) obj5).longValue();
                }
            }
        }
        return false;
    }

    public long d() {
        return this.f81872b;
    }

    public long[] e() {
        return this.f81874d;
    }

    public long[] f() {
        return this.f81873c;
    }
}
