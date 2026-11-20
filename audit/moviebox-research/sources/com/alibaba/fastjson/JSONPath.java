package com.alibaba.fastjson;

import com.alibaba.fastjson.util.TypeUtils;
import com.applovin.sdk.AppLovinMediationProvider;
import com.google.android.libraries.places.api.model.PlaceTypes;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;
import n7.g1;
import n7.p0;
import n7.z0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class JSONPath implements com.alibaba.fastjson.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static ConcurrentMap<String, JSONPath> f15386h = new ConcurrentHashMap(128, 0.75f, 1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a0[] f15388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g1 f15390d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public l7.h f15391f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f15392g;

    /* JADX INFO: compiled from: source.java */
    public enum Operator {
        EQ,
        NE,
        GT,
        GE,
        LT,
        LE,
        LIKE,
        NOT_LIKE,
        RLIKE,
        NOT_RLIKE,
        IN,
        NOT_IN,
        BETWEEN,
        NOT_BETWEEN,
        And,
        Or,
        REG_MATCH
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15393a;

        static {
            int[] iArr = new int[Operator.values().length];
            f15393a = iArr;
            try {
                iArr[Operator.EQ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15393a[Operator.NE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15393a[Operator.GE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15393a[Operator.GT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15393a[Operator.LE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15393a[Operator.LT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface a0 {
        Object a(JSONPath jSONPath, Object obj, Object obj2);
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f15394a;

        public b(int i11) {
            this.f15394a = i11;
        }

        @Override // com.alibaba.fastjson.JSONPath.a0
        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.h(obj2, this.f15394a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b0 implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b0 f15395a = new b0();

        @Override // com.alibaba.fastjson.JSONPath.a0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer a(JSONPath jSONPath, Object obj, Object obj2) {
            return Integer.valueOf(jSONPath.g(obj2));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends u {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final double f15396f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Operator f15397g;

        public c(String str, boolean z11, double d11, Operator operator) {
            super(str, z11);
            this.f15396f = d11;
            this.f15397g = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object objB = b(jSONPath, obj, obj3);
            if (objB == null || !(objB instanceof Number)) {
                return false;
            }
            double dDoubleValue = ((Number) objB).doubleValue();
            switch (a.f15393a[this.f15397g.ordinal()]) {
                case 1:
                    return dDoubleValue == this.f15396f;
                case 2:
                    return dDoubleValue != this.f15396f;
                case 3:
                    return dDoubleValue >= this.f15396f;
                case 4:
                    return dDoubleValue > this.f15396f;
                case 5:
                    return dDoubleValue <= this.f15396f;
                case 6:
                    return dDoubleValue < this.f15396f;
                default:
                    return false;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c0 extends u {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String[] f15398f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f15399g;

        public c0(String str, boolean z11, String[] strArr, boolean z12) {
            super(str, z11);
            this.f15398f = strArr;
            this.f15399g = z12;
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object objB = b(jSONPath, obj, obj3);
            for (String str : this.f15398f) {
                if (str == objB) {
                    return !this.f15399g;
                }
                if (str != null && str.equals(objB)) {
                    return !this.f15399g;
                }
            }
            return this.f15399g;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3);
    }

    /* JADX INFO: compiled from: source.java */
    public static class d0 extends u {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f15400f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Operator f15401g;

        public d0(String str, boolean z11, String str2, Operator operator) {
            super(str, z11);
            this.f15400f = str2;
            this.f15401g = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object objB = b(jSONPath, obj, obj3);
            Operator operator = this.f15401g;
            if (operator == Operator.EQ) {
                return this.f15400f.equals(objB);
            }
            if (operator == Operator.NE) {
                return !this.f15400f.equals(objB);
            }
            if (objB == null) {
                return false;
            }
            int iCompareTo = this.f15400f.compareTo(objB.toString());
            Operator operator2 = this.f15401g;
            if (operator2 == Operator.GE) {
                return iCompareTo <= 0;
            }
            if (operator2 == Operator.GT) {
                return iCompareTo < 0;
            }
            if (operator2 == Operator.LE) {
                return iCompareTo >= 0;
            }
            return operator2 == Operator.LT && iCompareTo > 0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f15402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<d> f15403b;

        public e(d dVar, d dVar2, boolean z11) {
            ArrayList arrayList = new ArrayList(2);
            this.f15403b = arrayList;
            arrayList.add(dVar);
            this.f15403b.add(dVar2);
            this.f15402a = z11;
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            if (this.f15402a) {
                Iterator<d> it = this.f15403b.iterator();
                while (it.hasNext()) {
                    if (!it.next().a(jSONPath, obj, obj2, obj3)) {
                        return false;
                    }
                }
                return true;
            }
            Iterator<d> it2 = this.f15403b.iterator();
            while (it2.hasNext()) {
                if (it2.next().a(jSONPath, obj, obj2, obj3)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e0 implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e0 f15404a = new e0();

        @Override // com.alibaba.fastjson.JSONPath.a0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(JSONPath jSONPath, Object obj, Object obj2) {
            if (obj2 == null) {
                return "null";
            }
            if (obj2 instanceof Collection) {
                return "array";
            }
            if (obj2 instanceof Number) {
                return "number";
            }
            if (obj2 instanceof Boolean) {
                return "boolean";
            }
            return ((obj2 instanceof String) || (obj2 instanceof UUID) || (obj2 instanceof Enum)) ? "string" : "object";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f15405a;

        public f(d dVar) {
            this.f15405a = dVar;
        }

        @Override // com.alibaba.fastjson.JSONPath.a0
        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            if (obj2 == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            if (!(obj2 instanceof Iterable)) {
                if (this.f15405a.a(jSONPath, obj, obj2, obj2)) {
                    return obj2;
                }
                return null;
            }
            for (Object obj3 : (Iterable) obj2) {
                if (this.f15405a.a(jSONPath, obj, obj2, obj3)) {
                    jSONArray.add(obj3);
                }
            }
            return jSONArray;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f0 extends u {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Object f15406f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f15407g;

        public f0(String str, boolean z11, Object obj, boolean z12) {
            super(str, z11);
            this.f15407g = true;
            if (obj == null) {
                throw new IllegalArgumentException("value is null");
            }
            this.f15406f = obj;
            this.f15407g = z12;
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            boolean zEquals = this.f15406f.equals(b(jSONPath, obj, obj3));
            return !this.f15407g ? !zEquals : zEquals;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class g implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f15408a = new g();

        public static Object b(Object obj) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Float) {
                return Double.valueOf(Math.floor(((Float) obj).floatValue()));
            }
            if (obj instanceof Double) {
                return Double.valueOf(Math.floor(((Double) obj).doubleValue()));
            }
            if (obj instanceof BigDecimal) {
                return ((BigDecimal) obj).setScale(0, RoundingMode.FLOOR);
            }
            if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof BigInteger)) {
                return obj;
            }
            throw new UnsupportedOperationException();
        }

        @Override // com.alibaba.fastjson.JSONPath.a0
        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            if (!(obj2 instanceof JSONArray)) {
                return b(obj2);
            }
            JSONArray jSONArray = (JSONArray) ((JSONArray) obj2).clone();
            for (int i11 = 0; i11 < jSONArray.size(); i11++) {
                Object obj3 = jSONArray.get(i11);
                Object objB = b(obj3);
                if (objB != obj3) {
                    jSONArray.set(i11, objB);
                }
            }
            return jSONArray;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class g0 implements a0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final g0 f15409c = new g0(false, false);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final g0 f15410d = new g0(true, false);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final g0 f15411e = new g0(true, true);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f15412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f15413b;

        public g0(boolean z11, boolean z12) {
            this.f15412a = z11;
            this.f15413b = z12;
        }

        @Override // com.alibaba.fastjson.JSONPath.a0
        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            if (!this.f15412a) {
                return jSONPath.k(obj2);
            }
            ArrayList arrayList = new ArrayList();
            jSONPath.c(obj2, arrayList);
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class h extends u {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f15414f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f15415g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f15416h;

        public h(String str, boolean z11, long j11, long j12, boolean z12) {
            super(str, z11);
            this.f15414f = j11;
            this.f15415g = j12;
            this.f15416h = z12;
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object objB = b(jSONPath, obj, obj3);
            if (objB == null) {
                return false;
            }
            if (objB instanceof Number) {
                long jD0 = TypeUtils.D0((Number) objB);
                if (jD0 >= this.f15414f && jD0 <= this.f15415g) {
                    return !this.f15416h;
                }
            }
            return this.f15416h;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class i extends u {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long[] f15417f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f15418g;

        public i(String str, boolean z11, long[] jArr, boolean z12) {
            super(str, z11);
            this.f15417f = jArr;
            this.f15418g = z12;
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object objB = b(jSONPath, obj, obj3);
            if (objB == null) {
                return false;
            }
            if (objB instanceof Number) {
                long jD0 = TypeUtils.D0((Number) objB);
                for (long j11 : this.f15417f) {
                    if (j11 == jD0) {
                        return !this.f15418g;
                    }
                }
            }
            return this.f15418g;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class j extends u {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Long[] f15419f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f15420g;

        public j(String str, boolean z11, Long[] lArr, boolean z12) {
            super(str, z11);
            this.f15419f = lArr;
            this.f15420g = z12;
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object objB = b(jSONPath, obj, obj3);
            int i11 = 0;
            if (objB == null) {
                Long[] lArr = this.f15419f;
                int length = lArr.length;
                while (i11 < length) {
                    if (lArr[i11] == null) {
                        return !this.f15420g;
                    }
                    i11++;
                }
                return this.f15420g;
            }
            if (objB instanceof Number) {
                long jD0 = TypeUtils.D0((Number) objB);
                Long[] lArr2 = this.f15419f;
                int length2 = lArr2.length;
                while (i11 < length2) {
                    Long l11 = lArr2[i11];
                    if (l11 != null && l11.longValue() == jD0) {
                        return !this.f15420g;
                    }
                    i11++;
                }
            }
            return this.f15420g;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class k extends u {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f15421f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Operator f15422g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public BigDecimal f15423h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Float f15424i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Double f15425j;

        public k(String str, boolean z11, long j11, Operator operator) {
            super(str, z11);
            this.f15421f = j11;
            this.f15422g = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object objB = b(jSONPath, obj, obj3);
            if (objB == null || !(objB instanceof Number)) {
                return false;
            }
            if (objB instanceof BigDecimal) {
                if (this.f15423h == null) {
                    this.f15423h = BigDecimal.valueOf(this.f15421f);
                }
                int iCompareTo = this.f15423h.compareTo((BigDecimal) objB);
                switch (a.f15393a[this.f15422g.ordinal()]) {
                    case 1:
                        return iCompareTo == 0;
                    case 2:
                        return iCompareTo != 0;
                    case 3:
                        return iCompareTo <= 0;
                    case 4:
                        return iCompareTo < 0;
                    case 5:
                        return iCompareTo >= 0;
                    case 6:
                        return iCompareTo > 0;
                    default:
                        return false;
                }
            }
            if (objB instanceof Float) {
                if (this.f15424i == null) {
                    this.f15424i = Float.valueOf(this.f15421f);
                }
                int iCompareTo2 = this.f15424i.compareTo((Float) objB);
                switch (a.f15393a[this.f15422g.ordinal()]) {
                    case 1:
                        return iCompareTo2 == 0;
                    case 2:
                        return iCompareTo2 != 0;
                    case 3:
                        return iCompareTo2 <= 0;
                    case 4:
                        return iCompareTo2 < 0;
                    case 5:
                        return iCompareTo2 >= 0;
                    case 6:
                        return iCompareTo2 > 0;
                    default:
                        return false;
                }
            }
            if (!(objB instanceof Double)) {
                long jD0 = TypeUtils.D0((Number) objB);
                switch (a.f15393a[this.f15422g.ordinal()]) {
                    case 1:
                        return jD0 == this.f15421f;
                    case 2:
                        return jD0 != this.f15421f;
                    case 3:
                        return jD0 >= this.f15421f;
                    case 4:
                        return jD0 > this.f15421f;
                    case 5:
                        return jD0 <= this.f15421f;
                    case 6:
                        return jD0 < this.f15421f;
                    default:
                        return false;
                }
            }
            if (this.f15425j == null) {
                this.f15425j = Double.valueOf(this.f15421f);
            }
            int iCompareTo3 = this.f15425j.compareTo((Double) objB);
            switch (a.f15393a[this.f15422g.ordinal()]) {
                case 1:
                    return iCompareTo3 == 0;
                case 2:
                    return iCompareTo3 != 0;
                case 3:
                    return iCompareTo3 <= 0;
                case 4:
                    return iCompareTo3 < 0;
                case 5:
                    return iCompareTo3 >= 0;
                case 6:
                    return iCompareTo3 > 0;
                default:
                    return false;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class l {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Pattern f15426f = Pattern.compile("'\\s*,\\s*'");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f15427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15428b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public char f15429c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f15430d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f15431e;

        public l(String str) {
            this.f15427a = str;
            i();
        }

        public static boolean g(char c11) {
            return c11 == '-' || c11 == '+' || (c11 >= '0' && c11 <= '9');
        }

        public void a(char c11) {
            if (this.f15429c == ' ') {
                i();
            }
            if (this.f15429c == c11) {
                if (h()) {
                    return;
                }
                i();
            } else {
                throw new JSONPathException("expect '" + c11 + ", but '" + this.f15429c + "'");
            }
        }

        public a0 c(String str) {
            int length = str.length();
            char cCharAt = str.charAt(0);
            int i11 = length - 1;
            char cCharAt2 = str.charAt(i11);
            int iIndexOf = str.indexOf(44);
            if (str.length() > 2 && cCharAt == '\'' && cCharAt2 == '\'') {
                String strSubstring = str.substring(1, i11);
                return (iIndexOf == -1 || !f15426f.matcher(str).find()) ? new v(strSubstring, false) : new r(strSubstring.split("'\\s*,\\s*'"));
            }
            int iIndexOf2 = str.indexOf(58);
            if (iIndexOf == -1 && iIndexOf2 == -1) {
                if (TypeUtils.v0(str)) {
                    try {
                        return new b(Integer.parseInt(str));
                    } catch (NumberFormatException unused) {
                        return new v(str, false);
                    }
                }
                if (str.charAt(0) == '\"' && str.charAt(str.length() - 1) == '\"') {
                    str = str.substring(1, str.length() - 1);
                }
                return new v(str, false);
            }
            if (iIndexOf != -1) {
                String[] strArrSplit = str.split(",");
                int[] iArr = new int[strArrSplit.length];
                for (int i12 = 0; i12 < strArrSplit.length; i12++) {
                    iArr[i12] = Integer.parseInt(strArrSplit[i12]);
                }
                return new q(iArr);
            }
            if (iIndexOf2 == -1) {
                throw new UnsupportedOperationException();
            }
            String[] strArrSplit2 = str.split(":");
            int length2 = strArrSplit2.length;
            int[] iArr2 = new int[length2];
            for (int i13 = 0; i13 < strArrSplit2.length; i13++) {
                String str2 = strArrSplit2[i13];
                if (str2.length() != 0) {
                    iArr2[i13] = Integer.parseInt(str2);
                } else {
                    if (i13 != 0) {
                        throw new UnsupportedOperationException();
                    }
                    iArr2[i13] = 0;
                }
            }
            int i14 = iArr2[0];
            int i15 = length2 > 1 ? iArr2[1] : -1;
            int i16 = length2 == 3 ? iArr2[2] : 1;
            if (i15 < 0 || i15 >= i14) {
                if (i16 > 0) {
                    return new w(i14, i15, i16);
                }
                throw new UnsupportedOperationException("step must greater than zero : " + i16);
            }
            throw new UnsupportedOperationException("end must greater than or equals start. start " + i14 + ",  end " + i15);
        }

        public a0[] d() {
            String str = this.f15427a;
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException();
            }
            a0[] a0VarArr = new a0[8];
            while (true) {
                a0 a0VarP = p();
                if (a0VarP == null) {
                    break;
                }
                if (a0VarP instanceof v) {
                    v vVar = (v) a0VarP;
                    if (vVar.f15450c || !vVar.f15448a.equals("*")) {
                    }
                }
                int i11 = this.f15430d;
                if (i11 == a0VarArr.length) {
                    a0[] a0VarArr2 = new a0[(i11 * 3) / 2];
                    System.arraycopy(a0VarArr, 0, a0VarArr2, 0, i11);
                    a0VarArr = a0VarArr2;
                }
                int i12 = this.f15430d;
                this.f15430d = i12 + 1;
                a0VarArr[i12] = a0VarP;
            }
            int i13 = this.f15430d;
            if (i13 == a0VarArr.length) {
                return a0VarArr;
            }
            a0[] a0VarArr3 = new a0[i13];
            System.arraycopy(a0VarArr, 0, a0VarArr3, 0, i13);
            return a0VarArr3;
        }

        public d e(d dVar) {
            char c11 = this.f15429c;
            boolean z11 = true;
            boolean z12 = c11 == '&';
            if ((c11 != '&' || f() != '&') && (this.f15429c != '|' || f() != '|')) {
                return dVar;
            }
            i();
            i();
            if (this.f15429c == '(') {
                i();
            } else {
                z11 = false;
            }
            while (this.f15429c == ' ') {
                i();
            }
            e eVar = new e(dVar, (d) k(false), z12);
            if (z11 && this.f15429c == ')') {
                i();
            }
            return eVar;
        }

        public char f() {
            return this.f15427a.charAt(this.f15428b);
        }

        public boolean h() {
            return this.f15428b >= this.f15427a.length();
        }

        public void i() {
            String str = this.f15427a;
            int i11 = this.f15428b;
            this.f15428b = i11 + 1;
            this.f15429c = str.charAt(i11);
        }

        public a0 j(boolean z11) {
            Object objK = k(z11);
            return objK instanceof a0 ? (a0) objK : new f((d) objK);
        }

        public Object k(boolean z11) {
            int i11;
            boolean z12;
            boolean z13;
            char c11;
            char c12;
            char c13;
            char c14;
            char c15;
            char c16;
            String str;
            String[] strArr;
            String str2;
            String str3;
            d nVar;
            d d0Var;
            char c17;
            char c18;
            char c19;
            char c21;
            int i12;
            char c22;
            char c23;
            char c24;
            char c25;
            char c26;
            int i13;
            String strReplaceAll;
            int i14;
            char cCharAt;
            char c27;
            if (z11) {
                a('[');
            }
            if (this.f15429c == '?') {
                i();
                a('(');
                i11 = 1;
                while (this.f15429c == '(') {
                    i();
                    i11++;
                }
                z12 = true;
            } else {
                i11 = 0;
                z12 = false;
            }
            s();
            if (!z12 && !com.alibaba.fastjson.util.f.h(this.f15429c) && !Character.isJavaIdentifierStart(this.f15429c) && (c25 = this.f15429c) != '\\' && c25 != '@') {
                int i15 = this.f15428b - 1;
                while (true) {
                    char c28 = this.f15429c;
                    if (c28 == ']' || c28 == '/' || h() || !((c27 = this.f15429c) != '.' || z12 || z12 || c25 == '\'')) {
                        break;
                    }
                    if (c27 == '\\') {
                        i();
                    }
                    i();
                }
                if (z11 || (c26 = this.f15429c) == '/' || c26 == '.') {
                    int i16 = this.f15428b;
                    i13 = i16 - 1;
                } else {
                    i13 = this.f15428b;
                }
                String strSubstring = this.f15427a.substring(i15, i13);
                if (strSubstring.indexOf(92) != 0) {
                    StringBuilder sb2 = new StringBuilder(strSubstring.length());
                    int i17 = 0;
                    while (i17 < strSubstring.length()) {
                        char cCharAt2 = strSubstring.charAt(i17);
                        if (cCharAt2 == '\\' && i17 < strSubstring.length() - 1 && ((cCharAt = strSubstring.charAt((i14 = i17 + 1))) == '@' || cCharAt2 == '\\' || cCharAt2 == '\"')) {
                            sb2.append(cCharAt);
                            i17 = i14;
                        } else {
                            sb2.append(cCharAt2);
                        }
                        i17++;
                    }
                    strSubstring = sb2.toString();
                }
                if (strSubstring.indexOf("\\.") == -1) {
                    a0 a0VarC = c(strSubstring);
                    if (z11 && !h()) {
                        a(']');
                    }
                    return a0VarC;
                }
                if (c25 == '\'' && strSubstring.length() > 2 && strSubstring.charAt(strSubstring.length() - 1) == c25) {
                    strReplaceAll = strSubstring.substring(1, strSubstring.length() - 1);
                } else {
                    strReplaceAll = strSubstring.replaceAll("\\\\\\.", "\\.");
                    if (strReplaceAll.indexOf("\\-") != -1) {
                        strReplaceAll = strReplaceAll.replaceAll("\\\\-", "-");
                    }
                }
                if (z12) {
                    a(')');
                }
                return new v(strReplaceAll, false);
            }
            if (this.f15429c == '@') {
                i();
                a('.');
            }
            String strN = n();
            s();
            if (z12 && this.f15429c == ')') {
                i();
                d sVar = new s(strN, false);
                while (true) {
                    c24 = this.f15429c;
                    if (c24 != ' ') {
                        break;
                    }
                    i();
                }
                if (c24 == '&' || c24 == '|') {
                    sVar = e(sVar);
                }
                if (z11) {
                    a(']');
                }
                return sVar;
            }
            if (z11 && this.f15429c == ']') {
                if (h() && strN.equals("last")) {
                    return new q(new int[]{-1});
                }
                i();
                d sVar2 = new s(strN, false);
                while (true) {
                    c23 = this.f15429c;
                    if (c23 != ' ') {
                        break;
                    }
                    i();
                }
                if (c23 == '&' || c23 == '|') {
                    sVar2 = e(sVar2);
                }
                a(')');
                if (z12) {
                    a(')');
                }
                if (z11) {
                    a(']');
                }
                return sVar2;
            }
            s();
            if (this.f15429c == '(') {
                i();
                a(')');
                s();
                z13 = true;
            } else {
                z13 = false;
            }
            Operator operatorO = o();
            s();
            if (operatorO == Operator.BETWEEN || operatorO == Operator.NOT_BETWEEN) {
                boolean z14 = operatorO == Operator.NOT_BETWEEN;
                Object objR = r();
                if (!"and".equalsIgnoreCase(n())) {
                    throw new JSONPathException(this.f15427a);
                }
                Object objR2 = r();
                if (objR == null || objR2 == null) {
                    throw new JSONPathException(this.f15427a);
                }
                if (JSONPath.m(objR.getClass()) && JSONPath.m(objR2.getClass())) {
                    return new h(strN, z13, TypeUtils.D0((Number) objR), TypeUtils.D0((Number) objR2), z14);
                }
                throw new JSONPathException(this.f15427a);
            }
            if (operatorO == Operator.IN || operatorO == Operator.NOT_IN) {
                boolean z15 = operatorO == Operator.NOT_IN;
                a('(');
                JSONArray jSONArray = new JSONArray();
                jSONArray.add(r());
                while (true) {
                    s();
                    if (this.f15429c != ',') {
                        break;
                    }
                    i();
                    jSONArray.add(r());
                }
                boolean z16 = true;
                boolean z17 = true;
                boolean z18 = true;
                for (Object obj : jSONArray) {
                    if (obj != null) {
                        Class<?> cls = obj.getClass();
                        if (z16 && cls != Byte.class && cls != Short.class && cls != Integer.class && cls != Long.class) {
                            z16 = false;
                            z18 = false;
                        }
                        if (z17 && cls != String.class) {
                            z17 = false;
                        }
                    } else if (z16) {
                        z16 = false;
                    }
                }
                if (jSONArray.size() == 1 && jSONArray.get(0) == null) {
                    d sVar3 = z15 ? new s(strN, z13) : new t(strN, z13);
                    while (true) {
                        c16 = this.f15429c;
                        if (c16 != ' ') {
                            break;
                        }
                        i();
                    }
                    if (c16 == '&' || c16 == '|') {
                        sVar3 = e(sVar3);
                    }
                    a(')');
                    if (z12) {
                        a(')');
                    }
                    if (z11) {
                        a(']');
                    }
                    return sVar3;
                }
                if (z16) {
                    if (jSONArray.size() == 1) {
                        d kVar = new k(strN, z13, TypeUtils.D0((Number) jSONArray.get(0)), z15 ? Operator.NE : Operator.EQ);
                        while (true) {
                            c15 = this.f15429c;
                            if (c15 != ' ') {
                                break;
                            }
                            i();
                        }
                        if (c15 == '&' || c15 == '|') {
                            kVar = e(kVar);
                        }
                        a(')');
                        if (z12) {
                            a(')');
                        }
                        if (z11) {
                            a(']');
                        }
                        return kVar;
                    }
                    int size = jSONArray.size();
                    long[] jArr = new long[size];
                    for (int i18 = 0; i18 < size; i18++) {
                        jArr[i18] = TypeUtils.D0((Number) jSONArray.get(i18));
                    }
                    d iVar = new i(strN, z13, jArr, z15);
                    while (true) {
                        c14 = this.f15429c;
                        if (c14 != ' ') {
                            break;
                        }
                        i();
                    }
                    if (c14 == '&' || c14 == '|') {
                        iVar = e(iVar);
                    }
                    a(')');
                    if (z12) {
                        a(')');
                    }
                    if (z11) {
                        a(']');
                    }
                    return iVar;
                }
                if (!z17) {
                    if (!z18) {
                        throw new UnsupportedOperationException();
                    }
                    int size2 = jSONArray.size();
                    Long[] lArr = new Long[size2];
                    for (int i19 = 0; i19 < size2; i19++) {
                        Number number = (Number) jSONArray.get(i19);
                        if (number != null) {
                            lArr[i19] = Long.valueOf(TypeUtils.D0(number));
                        }
                    }
                    d jVar = new j(strN, z13, lArr, z15);
                    while (true) {
                        c11 = this.f15429c;
                        if (c11 != ' ') {
                            break;
                        }
                        i();
                    }
                    if (c11 == '&' || c11 == '|') {
                        jVar = e(jVar);
                    }
                    a(')');
                    if (z12) {
                        a(')');
                    }
                    if (z11) {
                        a(']');
                    }
                    return jVar;
                }
                if (jSONArray.size() == 1) {
                    d d0Var2 = new d0(strN, z13, (String) jSONArray.get(0), z15 ? Operator.NE : Operator.EQ);
                    while (true) {
                        c13 = this.f15429c;
                        if (c13 != ' ') {
                            break;
                        }
                        i();
                    }
                    if (c13 == '&' || c13 == '|') {
                        d0Var2 = e(d0Var2);
                    }
                    a(')');
                    if (z12) {
                        a(')');
                    }
                    if (z11) {
                        a(']');
                    }
                    return d0Var2;
                }
                String[] strArr2 = new String[jSONArray.size()];
                jSONArray.toArray(strArr2);
                d c0Var = new c0(strN, z13, strArr2, z15);
                while (true) {
                    c12 = this.f15429c;
                    if (c12 != ' ') {
                        break;
                    }
                    i();
                }
                if (c12 == '&' || c12 == '|') {
                    c0Var = e(c0Var);
                }
                a(')');
                if (z12) {
                    a(')');
                }
                if (z11) {
                    a(']');
                }
                return c0Var;
            }
            char c29 = this.f15429c;
            if (c29 == '\'' || c29 == '\"') {
                String strQ = q();
                if (operatorO == Operator.RLIKE) {
                    nVar = new z(strN, z13, strQ, false);
                } else {
                    if (operatorO == Operator.NOT_RLIKE) {
                        d0Var = new z(strN, z13, strQ, true);
                    } else if (operatorO == Operator.LIKE || operatorO == Operator.NOT_LIKE) {
                        while (strQ.indexOf("%%") != -1) {
                            strQ = strQ.replaceAll("%%", "%");
                        }
                        boolean z19 = operatorO == Operator.NOT_LIKE;
                        int iIndexOf = strQ.indexOf(37);
                        if (iIndexOf == -1) {
                            d0Var = new d0(strN, z13, strQ, operatorO == Operator.LIKE ? Operator.EQ : Operator.NE);
                        } else {
                            String[] strArrSplit = strQ.split("%");
                            if (iIndexOf != 0) {
                                if (strQ.charAt(strQ.length() - 1) == '%') {
                                    if (strArrSplit.length == 1) {
                                        str3 = strArrSplit[0];
                                    } else {
                                        strArr = strArrSplit;
                                        str = null;
                                        str2 = null;
                                    }
                                } else if (strArrSplit.length == 1) {
                                    str3 = strArrSplit[0];
                                } else if (strArrSplit.length == 2) {
                                    str = strArrSplit[0];
                                    str2 = strArrSplit[1];
                                    strArr = null;
                                } else {
                                    String str4 = strArrSplit[0];
                                    String str5 = strArrSplit[strArrSplit.length - 1];
                                    int length = strArrSplit.length - 2;
                                    String[] strArr3 = new String[length];
                                    System.arraycopy(strArrSplit, 1, strArr3, 0, length);
                                    str = str4;
                                    strArr = strArr3;
                                    str2 = str5;
                                }
                                str = str3;
                                str2 = null;
                                strArr = null;
                            } else if (strQ.charAt(strQ.length() - 1) == '%') {
                                int length2 = strArrSplit.length - 1;
                                String[] strArr4 = new String[length2];
                                System.arraycopy(strArrSplit, 1, strArr4, 0, length2);
                                strArr = strArr4;
                                str = null;
                                str2 = null;
                            } else {
                                String str6 = strArrSplit[strArrSplit.length - 1];
                                if (strArrSplit.length > 2) {
                                    int length3 = strArrSplit.length - 2;
                                    String[] strArr5 = new String[length3];
                                    System.arraycopy(strArrSplit, 1, strArr5, 0, length3);
                                    str2 = str6;
                                    strArr = strArr5;
                                    str = null;
                                } else {
                                    str2 = str6;
                                    str = null;
                                    strArr = null;
                                }
                            }
                            nVar = new n(strN, z13, str, str2, strArr, z19);
                        }
                    } else {
                        nVar = new d0(strN, z13, strQ, operatorO);
                    }
                    nVar = d0Var;
                }
                while (true) {
                    c17 = this.f15429c;
                    if (c17 != ' ') {
                        break;
                    }
                    i();
                }
                if (c17 == '&' || c17 == '|') {
                    nVar = e(nVar);
                }
                if (z12) {
                    a(')');
                }
                if (z11) {
                    a(']');
                }
                return nVar;
            }
            if (g(c29)) {
                long jM = m();
                double dL = this.f15429c == '.' ? l(jM) : 0.0d;
                d kVar2 = dL == 0.0d ? new k(strN, z13, jM, operatorO) : new c(strN, z13, dL, operatorO);
                while (true) {
                    c22 = this.f15429c;
                    if (c22 != ' ') {
                        break;
                    }
                    i();
                }
                if (i11 > 1 && c22 == ')') {
                    i();
                }
                char c31 = this.f15429c;
                if (c31 == '&' || c31 == '|') {
                    kVar2 = e(kVar2);
                }
                if (z12) {
                    a(')');
                }
                if (z11) {
                    a(']');
                }
                return kVar2;
            }
            char c32 = this.f15429c;
            if (c32 == '$') {
                x xVar = new x(strN, z13, p(), operatorO);
                this.f15431e = true;
                while (this.f15429c == ' ') {
                    i();
                }
                if (z12) {
                    a(')');
                }
                if (z11) {
                    a(']');
                }
                return xVar;
            }
            if (c32 == '/') {
                StringBuilder sb3 = new StringBuilder();
                while (true) {
                    i();
                    char c33 = this.f15429c;
                    if (c33 == '/') {
                        break;
                    }
                    if (c33 == '\\') {
                        i();
                        sb3.append(this.f15429c);
                    } else {
                        sb3.append(c33);
                    }
                }
                i();
                if (this.f15429c == 'i') {
                    i();
                    i12 = 2;
                } else {
                    i12 = 0;
                }
                y yVar = new y(strN, z13, Pattern.compile(sb3.toString(), i12), operatorO);
                if (z12) {
                    a(')');
                }
                if (z11) {
                    a(']');
                }
                return yVar;
            }
            if (c32 == 'n') {
                if ("null".equals(n())) {
                    d tVar = operatorO == Operator.EQ ? new t(strN, z13) : operatorO == Operator.NE ? new s(strN, z13) : null;
                    if (tVar != null) {
                        while (true) {
                            c21 = this.f15429c;
                            if (c21 != ' ') {
                                break;
                            }
                            i();
                        }
                        if (c21 == '&' || c21 == '|') {
                            tVar = e(tVar);
                        }
                    }
                    if (z12) {
                        a(')');
                    }
                    a(']');
                    if (tVar != null) {
                        return tVar;
                    }
                    throw new UnsupportedOperationException();
                }
            } else if (c32 == 't') {
                if ("true".equals(n())) {
                    d f0Var = operatorO == Operator.EQ ? new f0(strN, z13, Boolean.TRUE, true) : operatorO == Operator.NE ? new f0(strN, z13, Boolean.TRUE, false) : null;
                    if (f0Var != null) {
                        while (true) {
                            c19 = this.f15429c;
                            if (c19 != ' ') {
                                break;
                            }
                            i();
                        }
                        if (c19 == '&' || c19 == '|') {
                            f0Var = e(f0Var);
                        }
                    }
                    if (z12) {
                        a(')');
                    }
                    a(']');
                    if (f0Var != null) {
                        return f0Var;
                    }
                    throw new UnsupportedOperationException();
                }
            } else if (c32 == 'f' && "false".equals(n())) {
                d f0Var2 = operatorO == Operator.EQ ? new f0(strN, z13, Boolean.FALSE, true) : operatorO == Operator.NE ? new f0(strN, z13, Boolean.FALSE, false) : null;
                if (f0Var2 != null) {
                    while (true) {
                        c18 = this.f15429c;
                        if (c18 != ' ') {
                            break;
                        }
                        i();
                    }
                    if (c18 == '&' || c18 == '|') {
                        f0Var2 = e(f0Var2);
                    }
                }
                if (z12) {
                    a(')');
                }
                a(']');
                if (f0Var2 != null) {
                    return f0Var2;
                }
                throw new UnsupportedOperationException();
            }
            throw new UnsupportedOperationException();
        }

        public double l(long j11) {
            int i11 = this.f15428b - 1;
            i();
            while (true) {
                char c11 = this.f15429c;
                if (c11 < '0' || c11 > '9') {
                    break;
                }
                i();
            }
            return Double.parseDouble(this.f15427a.substring(i11, this.f15428b - 1)) + j11;
        }

        public long m() {
            int i11 = this.f15428b - 1;
            char c11 = this.f15429c;
            if (c11 == '+' || c11 == '-') {
                i();
            }
            while (true) {
                char c12 = this.f15429c;
                if (c12 < '0' || c12 > '9') {
                    break;
                }
                i();
            }
            return Long.parseLong(this.f15427a.substring(i11, this.f15428b - 1));
        }

        public String n() {
            s();
            char c11 = this.f15429c;
            if (c11 != '\\' && !Character.isJavaIdentifierStart(c11)) {
                throw new JSONPathException("illeal jsonpath syntax. " + this.f15427a);
            }
            StringBuilder sb2 = new StringBuilder();
            while (!h()) {
                char c12 = this.f15429c;
                if (c12 == '\\') {
                    i();
                    sb2.append(this.f15429c);
                    if (h()) {
                        return sb2.toString();
                    }
                    i();
                } else {
                    if (!Character.isJavaIdentifierPart(c12)) {
                        break;
                    }
                    sb2.append(this.f15429c);
                    i();
                }
            }
            if (h() && Character.isJavaIdentifierPart(this.f15429c)) {
                sb2.append(this.f15429c);
            }
            return sb2.toString();
        }

        public Operator o() {
            Operator operator;
            char c11 = this.f15429c;
            if (c11 == '=') {
                i();
                char c12 = this.f15429c;
                if (c12 == '~') {
                    i();
                    operator = Operator.REG_MATCH;
                } else if (c12 == '=') {
                    i();
                    operator = Operator.EQ;
                } else {
                    operator = Operator.EQ;
                }
            } else if (c11 == '!') {
                i();
                a('=');
                operator = Operator.NE;
            } else if (c11 == '<') {
                i();
                if (this.f15429c == '=') {
                    i();
                    operator = Operator.LE;
                } else {
                    operator = Operator.LT;
                }
            } else if (c11 == '>') {
                i();
                if (this.f15429c == '=') {
                    i();
                    operator = Operator.GE;
                } else {
                    operator = Operator.GT;
                }
            } else {
                operator = null;
            }
            if (operator != null) {
                return operator;
            }
            String strN = n();
            if ("not".equalsIgnoreCase(strN)) {
                s();
                String strN2 = n();
                if ("like".equalsIgnoreCase(strN2)) {
                    return Operator.NOT_LIKE;
                }
                if ("rlike".equalsIgnoreCase(strN2)) {
                    return Operator.NOT_RLIKE;
                }
                if ("in".equalsIgnoreCase(strN2)) {
                    return Operator.NOT_IN;
                }
                if ("between".equalsIgnoreCase(strN2)) {
                    return Operator.NOT_BETWEEN;
                }
                throw new UnsupportedOperationException();
            }
            if ("nin".equalsIgnoreCase(strN)) {
                return Operator.NOT_IN;
            }
            if ("like".equalsIgnoreCase(strN)) {
                return Operator.LIKE;
            }
            if ("rlike".equalsIgnoreCase(strN)) {
                return Operator.RLIKE;
            }
            if ("in".equalsIgnoreCase(strN)) {
                return Operator.IN;
            }
            if ("between".equalsIgnoreCase(strN)) {
                return Operator.BETWEEN;
            }
            throw new UnsupportedOperationException();
        }

        public a0 p() {
            boolean z11;
            if (this.f15430d == 0 && this.f15427a.length() == 1) {
                if (g(this.f15429c)) {
                    return new b(this.f15429c - '0');
                }
                char c11 = this.f15429c;
                if ((c11 >= 'a' && c11 <= 'z') || (c11 >= 'A' && c11 <= 'Z')) {
                    return new v(Character.toString(c11), false);
                }
            }
            while (!h()) {
                s();
                char c12 = this.f15429c;
                if (c12 != '$') {
                    if (c12 != '.' && c12 != '/') {
                        if (c12 == '[') {
                            return j(true);
                        }
                        if (this.f15430d == 0) {
                            return new v(n(), false);
                        }
                        if (c12 == '?') {
                            return new f((d) k(false));
                        }
                        throw new JSONPathException("not support jsonpath : " + this.f15427a);
                    }
                    i();
                    if (c12 == '.' && this.f15429c == '.') {
                        i();
                        int length = this.f15427a.length();
                        int i11 = this.f15428b;
                        if (length > i11 + 3 && this.f15429c == '[' && this.f15427a.charAt(i11) == '*' && this.f15427a.charAt(this.f15428b + 1) == ']' && this.f15427a.charAt(this.f15428b + 2) == '.') {
                            i();
                            i();
                            i();
                            i();
                        }
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    char c13 = this.f15429c;
                    if (c13 == '*' || (z11 && c13 == '[')) {
                        boolean z12 = c13 == '[';
                        if (!h()) {
                            i();
                        }
                        if (z11) {
                            return z12 ? g0.f15411e : g0.f15410d;
                        }
                        return g0.f15409c;
                    }
                    if (g(c13)) {
                        return j(false);
                    }
                    String strN = n();
                    if (this.f15429c != '(') {
                        return new v(strN, z11);
                    }
                    i();
                    if (this.f15429c != ')') {
                        throw new JSONPathException("not support jsonpath : " + this.f15427a);
                    }
                    if (!h()) {
                        i();
                    }
                    if ("size".equals(strN) || "length".equals(strN)) {
                        return b0.f15395a;
                    }
                    if (AppLovinMediationProvider.MAX.equals(strN)) {
                        return o.f15438a;
                    }
                    if ("min".equals(strN)) {
                        return p.f15439a;
                    }
                    if ("keySet".equals(strN)) {
                        return m.f15432a;
                    }
                    if ("type".equals(strN)) {
                        return e0.f15404a;
                    }
                    if (PlaceTypes.FLOOR.equals(strN)) {
                        return g.f15408a;
                    }
                    throw new JSONPathException("not support jsonpath : " + this.f15427a);
                }
                i();
                s();
                if (this.f15429c == '?') {
                    return new f((d) k(false));
                }
            }
            return null;
        }

        public String q() {
            char c11 = this.f15429c;
            i();
            int i11 = this.f15428b - 1;
            while (this.f15429c != c11 && !h()) {
                i();
            }
            String strSubstring = this.f15427a.substring(i11, h() ? this.f15428b : this.f15428b - 1);
            a(c11);
            return strSubstring;
        }

        public Object r() {
            s();
            if (g(this.f15429c)) {
                return Long.valueOf(m());
            }
            char c11 = this.f15429c;
            if (c11 == '\"' || c11 == '\'') {
                return q();
            }
            if (c11 != 'n') {
                throw new UnsupportedOperationException();
            }
            if ("null".equals(n())) {
                return null;
            }
            throw new JSONPathException(this.f15427a);
        }

        public final void s() {
            while (true) {
                char c11 = this.f15429c;
                if (c11 > ' ') {
                    return;
                }
                if (c11 != ' ' && c11 != '\r' && c11 != '\n' && c11 != '\t' && c11 != '\f' && c11 != '\b') {
                    return;
                } else {
                    i();
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class m implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f15432a = new m();

        @Override // com.alibaba.fastjson.JSONPath.a0
        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.f(obj2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class n extends u {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f15433f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f15434g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String[] f15435h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f15436i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f15437j;

        public n(String str, boolean z11, String str2, String str3, String[] strArr, boolean z12) {
            super(str, z11);
            this.f15433f = str2;
            this.f15434g = str3;
            this.f15435h = strArr;
            this.f15437j = z12;
            int length = str2 != null ? str2.length() : 0;
            length = str3 != null ? length + str3.length() : length;
            if (strArr != null) {
                for (String str4 : strArr) {
                    length += str4.length();
                }
            }
            this.f15436i = length;
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            int length;
            Object objB = b(jSONPath, obj, obj3);
            if (objB == null) {
                return false;
            }
            String string = objB.toString();
            if (string.length() < this.f15436i) {
                return this.f15437j;
            }
            String str = this.f15433f;
            if (str == null) {
                length = 0;
            } else {
                if (!string.startsWith(str)) {
                    return this.f15437j;
                }
                length = this.f15433f.length();
            }
            String[] strArr = this.f15435h;
            if (strArr != null) {
                for (String str2 : strArr) {
                    int iIndexOf = string.indexOf(str2, length);
                    if (iIndexOf == -1) {
                        return this.f15437j;
                    }
                    length = iIndexOf + str2.length();
                }
            }
            String str3 = this.f15434g;
            return (str3 == null || string.endsWith(str3)) ? !this.f15437j : this.f15437j;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class o implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f15438a = new o();

        @Override // com.alibaba.fastjson.JSONPath.a0
        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            if (!(obj2 instanceof Collection)) {
                throw new UnsupportedOperationException();
            }
            Object obj3 = null;
            for (Object obj4 : (Collection) obj2) {
                if (obj4 != null && (obj3 == null || JSONPath.a(obj3, obj4) < 0)) {
                    obj3 = obj4;
                }
            }
            return obj3;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class p implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f15439a = new p();

        @Override // com.alibaba.fastjson.JSONPath.a0
        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            if (!(obj2 instanceof Collection)) {
                throw new UnsupportedOperationException();
            }
            Object obj3 = null;
            for (Object obj4 : (Collection) obj2) {
                if (obj4 != null && (obj3 == null || JSONPath.a(obj3, obj4) > 0)) {
                    obj3 = obj4;
                }
            }
            return obj3;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class q implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f15440a;

        public q(int[] iArr) {
            this.f15440a = iArr;
        }

        @Override // com.alibaba.fastjson.JSONPath.a0
        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            JSONArray jSONArray = new JSONArray(this.f15440a.length);
            int i11 = 0;
            while (true) {
                int[] iArr = this.f15440a;
                if (i11 >= iArr.length) {
                    return jSONArray;
                }
                jSONArray.add(jSONPath.h(obj2, iArr[i11]));
                i11++;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class r implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String[] f15441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f15442b;

        public r(String[] strArr) {
            this.f15441a = strArr;
            this.f15442b = new long[strArr.length];
            int i11 = 0;
            while (true) {
                long[] jArr = this.f15442b;
                if (i11 >= jArr.length) {
                    return;
                }
                jArr[i11] = TypeUtils.J(strArr[i11]);
                i11++;
            }
        }

        @Override // com.alibaba.fastjson.JSONPath.a0
        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            ArrayList arrayList = new ArrayList(this.f15441a.length);
            int i11 = 0;
            while (true) {
                String[] strArr = this.f15441a;
                if (i11 >= strArr.length) {
                    return arrayList;
                }
                arrayList.add(jSONPath.j(obj2, strArr[i11], this.f15442b[i11]));
                i11++;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class s extends u {
        public s(String str, boolean z11) {
            super(str, z11);
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            return jSONPath.j(obj3, this.f15444a, this.f15445b) != null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class t extends u {
        public t(String str, boolean z11) {
            super(str, z11);
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            return b(jSONPath, obj, obj3) == null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class u implements d {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static long f15443e = TypeUtils.J("type");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f15444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f15445b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f15446c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a0 f15447d;

        public u(String str, boolean z11) {
            this.f15444a = str;
            long J = TypeUtils.J(str);
            this.f15445b = J;
            this.f15446c = z11;
            if (z11) {
                if (J == f15443e) {
                    this.f15447d = e0.f15404a;
                } else {
                    if (J == 5614464919154503228L) {
                        this.f15447d = b0.f15395a;
                        return;
                    }
                    throw new JSONPathException("unsupported funciton : " + str);
                }
            }
        }

        public Object b(JSONPath jSONPath, Object obj, Object obj2) {
            a0 a0Var = this.f15447d;
            return a0Var != null ? a0Var.a(jSONPath, obj, obj2) : jSONPath.j(obj2, this.f15444a, this.f15445b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class v implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f15448a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f15449b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f15450c;

        public v(String str, boolean z11) {
            this.f15448a = str;
            this.f15449b = TypeUtils.J(str);
            this.f15450c = z11;
        }

        @Override // com.alibaba.fastjson.JSONPath.a0
        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            if (!this.f15450c) {
                return jSONPath.j(obj2, this.f15448a, this.f15449b);
            }
            ArrayList arrayList = new ArrayList();
            jSONPath.d(obj2, this.f15448a, arrayList);
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class w implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f15451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f15452b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f15453c;

        public w(int i11, int i12, int i13) {
            this.f15451a = i11;
            this.f15452b = i12;
            this.f15453c = i13;
        }

        @Override // com.alibaba.fastjson.JSONPath.a0
        public Object a(JSONPath jSONPath, Object obj, Object obj2) {
            int iIntValue = b0.f15395a.a(jSONPath, obj, obj2).intValue();
            int i11 = this.f15451a;
            if (i11 < 0) {
                i11 += iIntValue;
            }
            int i12 = this.f15452b;
            if (i12 < 0) {
                i12 += iIntValue;
            }
            int i13 = ((i12 - i11) / this.f15453c) + 1;
            if (i13 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i13);
            while (i11 <= i12 && i11 < iIntValue) {
                arrayList.add(jSONPath.h(obj2, i11));
                i11 += this.f15453c;
            }
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class x extends u {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final a0 f15454f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Operator f15455g;

        public x(String str, boolean z11, a0 a0Var, Operator operator) {
            super(str, z11);
            this.f15454f = a0Var;
            this.f15455g = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object objB = b(jSONPath, obj, obj3);
            if (objB == null || !(objB instanceof Number)) {
                return false;
            }
            Object objA = this.f15454f.a(jSONPath, obj, obj);
            if ((objA instanceof Integer) || (objA instanceof Long) || (objA instanceof Short) || (objA instanceof Byte)) {
                long jD0 = TypeUtils.D0((Number) objA);
                if ((objB instanceof Integer) || (objB instanceof Long) || (objB instanceof Short) || (objB instanceof Byte)) {
                    long jD1 = TypeUtils.D0((Number) objB);
                    switch (a.f15393a[this.f15455g.ordinal()]) {
                        case 1:
                            return jD1 == jD0;
                        case 2:
                            return jD1 != jD0;
                        case 3:
                            return jD1 >= jD0;
                        case 4:
                            return jD1 > jD0;
                        case 5:
                            return jD1 <= jD0;
                        case 6:
                            return jD1 < jD0;
                    }
                }
                if (objB instanceof BigDecimal) {
                    int iCompareTo = BigDecimal.valueOf(jD0).compareTo((BigDecimal) objB);
                    switch (a.f15393a[this.f15455g.ordinal()]) {
                        case 1:
                            return iCompareTo == 0;
                        case 2:
                            return iCompareTo != 0;
                        case 3:
                            return iCompareTo <= 0;
                        case 4:
                            return iCompareTo < 0;
                        case 5:
                            return iCompareTo >= 0;
                        case 6:
                            return iCompareTo > 0;
                        default:
                            return false;
                    }
                }
            }
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class y extends u {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Pattern f15456f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Operator f15457g;

        public y(String str, boolean z11, Pattern pattern, Operator operator) {
            super(str, z11);
            this.f15456f = pattern;
            this.f15457g = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object objB = b(jSONPath, obj, obj3);
            if (objB == null) {
                return false;
            }
            return this.f15456f.matcher(objB.toString()).matches();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class z extends u {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Pattern f15458f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f15459g;

        public z(String str, boolean z11, String str2, boolean z12) {
            super(str, z11);
            this.f15458f = Pattern.compile(str2);
            this.f15459g = z12;
        }

        @Override // com.alibaba.fastjson.JSONPath.d
        public boolean a(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object objB = b(jSONPath, obj, obj3);
            if (objB == null) {
                return false;
            }
            boolean zMatches = this.f15458f.matcher(objB.toString()).matches();
            return this.f15459g ? !zMatches : zMatches;
        }
    }

    public JSONPath(String str) {
        this(str, g1.g(), l7.h.t(), true);
    }

    public JSONPath(String str, g1 g1Var, l7.h hVar, boolean z11) {
        if (str == null || str.length() == 0) {
            throw new JSONPathException("json-path can not be null or empty");
        }
        this.f15387a = str;
        this.f15390d = g1Var;
        this.f15391f = hVar;
        this.f15392g = z11;
    }

    public static int a(Object obj, Object obj2) {
        Object d11;
        Object f11;
        if (obj.getClass() == obj2.getClass()) {
            return ((Comparable) obj).compareTo(obj2);
        }
        Class<?> cls = obj.getClass();
        Class<?> cls2 = obj2.getClass();
        if (cls == BigDecimal.class) {
            if (cls2 == Integer.class) {
                f11 = new BigDecimal(((Integer) obj2).intValue());
            } else if (cls2 == Long.class) {
                f11 = new BigDecimal(((Long) obj2).longValue());
            } else if (cls2 == Float.class) {
                f11 = new BigDecimal(((Float) obj2).floatValue());
            } else if (cls2 == Double.class) {
                f11 = new BigDecimal(((Double) obj2).doubleValue());
            }
            obj2 = f11;
        } else if (cls == Long.class) {
            if (cls2 == Integer.class) {
                f11 = new Long(((Integer) obj2).intValue());
                obj2 = f11;
            } else {
                if (cls2 == BigDecimal.class) {
                    d11 = new BigDecimal(((Long) obj).longValue());
                } else if (cls2 == Float.class) {
                    d11 = new Float(((Long) obj).longValue());
                } else if (cls2 == Double.class) {
                    d11 = new Double(((Long) obj).longValue());
                }
                obj = d11;
            }
        } else if (cls == Integer.class) {
            if (cls2 == Long.class) {
                d11 = new Long(((Integer) obj).intValue());
            } else if (cls2 == BigDecimal.class) {
                d11 = new BigDecimal(((Integer) obj).intValue());
            } else if (cls2 == Float.class) {
                d11 = new Float(((Integer) obj).intValue());
            } else if (cls2 == Double.class) {
                d11 = new Double(((Integer) obj).intValue());
            }
            obj = d11;
        } else if (cls == Double.class) {
            if (cls2 == Integer.class) {
                f11 = new Double(((Integer) obj2).intValue());
            } else if (cls2 == Long.class) {
                f11 = new Double(((Long) obj2).longValue());
            } else if (cls2 == Float.class) {
                f11 = new Double(((Float) obj2).floatValue());
            }
            obj2 = f11;
        } else if (cls == Float.class) {
            if (cls2 == Integer.class) {
                f11 = new Float(((Integer) obj2).intValue());
            } else if (cls2 == Long.class) {
                f11 = new Float(((Long) obj2).longValue());
            } else if (cls2 == Double.class) {
                d11 = new Double(((Float) obj).floatValue());
                obj = d11;
            }
            obj2 = f11;
        }
        return ((Comparable) obj).compareTo(obj2);
    }

    public static JSONPath b(String str) {
        if (str == null) {
            throw new JSONPathException("jsonpath can not be null");
        }
        JSONPath jSONPath = f15386h.get(str);
        if (jSONPath != null) {
            return jSONPath;
        }
        JSONPath jSONPath2 = new JSONPath(str);
        if (f15386h.size() >= 1024) {
            return jSONPath2;
        }
        f15386h.putIfAbsent(str, jSONPath2);
        return f15386h.get(str);
    }

    public static boolean m(Class<?> cls) {
        return cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class;
    }

    public void c(Object obj, List<Object> list) {
        Collection collectionV;
        Class<?> cls = obj.getClass();
        p0 p0VarI = i(cls);
        if (p0VarI != null) {
            try {
                collectionV = p0VarI.v(obj);
            } catch (Exception e11) {
                throw new JSONPathException("jsonpath error, path " + this.f15387a, e11);
            }
        } else if (obj instanceof Map) {
            collectionV = ((Map) obj).values();
        } else {
            collectionV = obj instanceof Collection ? (Collection) obj : null;
        }
        if (collectionV == null) {
            throw new UnsupportedOperationException(cls.getName());
        }
        for (Object obj2 : collectionV) {
            if (obj2 == null || l7.h.w(obj2.getClass())) {
                list.add(obj2);
            } else {
                c(obj2, list);
            }
        }
    }

    public void d(Object obj, String str, List<Object> list) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object value = entry.getValue();
                if (str.equals(entry.getKey())) {
                    if (value instanceof Collection) {
                        list.addAll((Collection) value);
                    } else {
                        list.add(value);
                    }
                } else if (value != null && !l7.h.w(value.getClass())) {
                    d(value, str, list);
                }
            }
            return;
        }
        if (obj instanceof Collection) {
            for (Object obj2 : (Collection) obj) {
                if (!l7.h.w(obj2.getClass())) {
                    d(obj2, str, list);
                }
            }
            return;
        }
        p0 p0VarI = i(obj.getClass());
        if (p0VarI == null) {
            if (obj instanceof List) {
                List list2 = (List) obj;
                for (int i11 = 0; i11 < list2.size(); i11++) {
                    d(list2.get(i11), str, list);
                }
                return;
            }
            return;
        }
        try {
            n7.g0 g0VarT = p0VarI.t(str);
            if (g0VarT == null) {
                Iterator<Object> it = p0VarI.v(obj).iterator();
                while (it.hasNext()) {
                    d(it.next(), str, list);
                }
                return;
            }
            try {
                try {
                    list.add(g0VarT.c(obj));
                } catch (IllegalAccessException e11) {
                    throw new JSONException("getFieldValue error." + str, e11);
                }
            } catch (InvocationTargetException e12) {
                throw new JSONException("getFieldValue error." + str, e12);
            }
        } catch (Exception e13) {
            throw new JSONPathException("jsonpath error, path " + this.f15387a + ", segement " + str, e13);
        }
    }

    public Object e(Object obj) {
        if (obj == null) {
            return null;
        }
        l();
        int i11 = 0;
        Object objA = obj;
        while (true) {
            a0[] a0VarArr = this.f15388b;
            if (i11 >= a0VarArr.length) {
                return objA;
            }
            objA = a0VarArr[i11].a(this, obj, objA);
            i11++;
        }
    }

    public Set<?> f(Object obj) {
        p0 p0VarI;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            return ((Map) obj).keySet();
        }
        if ((obj instanceof Collection) || (obj instanceof Object[]) || obj.getClass().isArray() || (p0VarI = i(obj.getClass())) == null) {
            return null;
        }
        try {
            return p0VarI.r(obj);
        } catch (Exception e11) {
            throw new JSONPathException("evalKeySet error : " + this.f15387a, e11);
        }
    }

    public int g(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).size();
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj);
        }
        if (obj instanceof Map) {
            Iterator it = ((Map) obj).values().iterator();
            int i11 = 0;
            while (it.hasNext()) {
                if (it.next() != null) {
                    i11++;
                }
            }
            return i11;
        }
        p0 p0VarI = i(obj.getClass());
        if (p0VarI == null) {
            return -1;
        }
        try {
            return p0VarI.y(obj);
        } catch (Exception e11) {
            throw new JSONPathException("evalSize error : " + this.f15387a, e11);
        }
    }

    public Object h(Object obj, int i11) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (i11 >= 0) {
                if (i11 < list.size()) {
                    return list.get(i11);
                }
                return null;
            }
            if (Math.abs(i11) <= list.size()) {
                return list.get(list.size() + i11);
            }
            return null;
        }
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            if (i11 >= 0) {
                if (i11 < length) {
                    return Array.get(obj, i11);
                }
                return null;
            }
            if (Math.abs(i11) <= length) {
                return Array.get(obj, length + i11);
            }
            return null;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            Object obj2 = map.get(Integer.valueOf(i11));
            return obj2 == null ? map.get(Integer.toString(i11)) : obj2;
        }
        if (!(obj instanceof Collection)) {
            if (i11 == 0) {
                return obj;
            }
            throw new UnsupportedOperationException();
        }
        int i12 = 0;
        for (Object obj3 : (Collection) obj) {
            if (i12 == i11) {
                return obj3;
            }
            i12++;
        }
        return null;
    }

    public p0 i(Class<?> cls) {
        z0 z0VarH = this.f15390d.h(cls);
        if (z0VarH instanceof p0) {
            return (p0) z0VarH;
        }
        return null;
    }

    public Object j(Object obj, String str, long j11) {
        Object obj2;
        JSONArray jSONArray = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            try {
                obj2 = (JSONObject) com.alibaba.fastjson.a.parse((String) obj, this.f15391f);
            } catch (Exception unused) {
                obj2 = obj;
            }
        } else {
            obj2 = obj;
        }
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get(str);
            if (obj3 == null) {
                return (5614464919154503228L == j11 || -1580386065683472715L == j11) ? Integer.valueOf(map.size()) : obj3;
            }
            return obj3;
        }
        p0 p0VarI = i(obj2.getClass());
        if (p0VarI != null) {
            try {
                return p0VarI.u(obj2, str, j11, false);
            } catch (Exception e11) {
                throw new JSONPathException("jsonpath error, path " + this.f15387a + ", segement " + str, e11);
            }
        }
        int i11 = 0;
        if (obj2 instanceof List) {
            List list = (List) obj2;
            if (5614464919154503228L == j11 || -1580386065683472715L == j11) {
                return Integer.valueOf(list.size());
            }
            while (i11 < list.size()) {
                Object obj4 = list.get(i11);
                if (obj4 == list) {
                    if (jSONArray == null) {
                        jSONArray = new JSONArray(list.size());
                    }
                    jSONArray.add(obj4);
                } else {
                    Object objJ = j(obj4, str, j11);
                    if (objJ instanceof Collection) {
                        Collection collection = (Collection) objJ;
                        if (jSONArray == null) {
                            jSONArray = new JSONArray(list.size());
                        }
                        jSONArray.addAll(collection);
                    } else if (objJ != null || !this.f15392g) {
                        if (jSONArray == null) {
                            jSONArray = new JSONArray(list.size());
                        }
                        jSONArray.add(objJ);
                    }
                }
                i11++;
            }
            return jSONArray == null ? Collections.emptyList() : jSONArray;
        }
        if (obj2 instanceof Object[]) {
            Object[] objArr = (Object[]) obj2;
            if (5614464919154503228L == j11 || -1580386065683472715L == j11) {
                return Integer.valueOf(objArr.length);
            }
            JSONArray jSONArray2 = new JSONArray(objArr.length);
            while (i11 < objArr.length) {
                Object[] objArr2 = objArr[i11];
                if (objArr2 == objArr) {
                    jSONArray2.add(objArr2);
                } else {
                    Object objJ2 = j(objArr2, str, j11);
                    if (objJ2 instanceof Collection) {
                        jSONArray2.addAll((Collection) objJ2);
                    } else if (objJ2 != null || !this.f15392g) {
                        jSONArray2.add(objJ2);
                    }
                }
                i11++;
            }
            return jSONArray2;
        }
        if (obj2 instanceof Enum) {
            Enum r11 = (Enum) obj2;
            if (-4270347329889690746L == j11) {
                return r11.name();
            }
            if (-1014497654951707614L == j11) {
                return Integer.valueOf(r11.ordinal());
            }
        }
        if (obj2 instanceof Calendar) {
            Calendar calendar = (Calendar) obj2;
            if (8963398325558730460L == j11) {
                return Integer.valueOf(calendar.get(1));
            }
            if (-811277319855450459L == j11) {
                return Integer.valueOf(calendar.get(2));
            }
            if (-3851359326990528739L == j11) {
                return Integer.valueOf(calendar.get(5));
            }
            if (4647432019745535567L == j11) {
                return Integer.valueOf(calendar.get(11));
            }
            if (6607618197526598121L == j11) {
                return Integer.valueOf(calendar.get(12));
            }
            if (-6586085717218287427L == j11) {
                return Integer.valueOf(calendar.get(13));
            }
        }
        return null;
    }

    public Collection<Object> k(Object obj) {
        if (obj == null) {
            return null;
        }
        p0 p0VarI = i(obj.getClass());
        if (p0VarI == null) {
            if (obj instanceof Map) {
                return ((Map) obj).values();
            }
            if (obj instanceof Collection) {
                return (Collection) obj;
            }
            throw new UnsupportedOperationException();
        }
        try {
            return p0VarI.v(obj);
        } catch (Exception e11) {
            throw new JSONPathException("jsonpath error, path " + this.f15387a, e11);
        }
    }

    public void l() {
        if (this.f15388b != null) {
            return;
        }
        if ("*".equals(this.f15387a)) {
            this.f15388b = new a0[]{g0.f15409c};
            return;
        }
        l lVar = new l(this.f15387a);
        this.f15388b = lVar.d();
        this.f15389c = lVar.f15431e;
    }

    public boolean n() {
        try {
            l();
            int i11 = 0;
            while (true) {
                a0[] a0VarArr = this.f15388b;
                if (i11 >= a0VarArr.length) {
                    return true;
                }
                Class<?> cls = a0VarArr[i11].getClass();
                if (cls != b.class && cls != v.class) {
                    return false;
                }
                i11++;
            }
        } catch (JSONPathException unused) {
            return false;
        }
    }

    @Override // com.alibaba.fastjson.b
    public String toJSONString() {
        return com.alibaba.fastjson.a.toJSONString(this.f15387a);
    }
}
