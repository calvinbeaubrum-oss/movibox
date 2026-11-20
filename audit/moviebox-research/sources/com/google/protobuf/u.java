package com.google.protobuf;

import com.google.protobuf.u.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class u<T extends b<T>> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final u f41417d = new u(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e1<T, Object> f41418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f41419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f41420c;

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41421a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f41422b;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f41422b = iArr;
            try {
                iArr[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41422b[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41422b[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41422b[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41422b[WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41422b[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41422b[WireFormat.FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f41422b[WireFormat.FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f41422b[WireFormat.FieldType.GROUP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f41422b[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f41422b[WireFormat.FieldType.STRING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f41422b[WireFormat.FieldType.BYTES.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f41422b[WireFormat.FieldType.UINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f41422b[WireFormat.FieldType.SFIXED32.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f41422b[WireFormat.FieldType.SFIXED64.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f41422b[WireFormat.FieldType.SINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f41422b[WireFormat.FieldType.SINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f41422b[WireFormat.FieldType.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[WireFormat.JavaType.values().length];
            f41421a = iArr2;
            try {
                iArr2[WireFormat.JavaType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f41421a[WireFormat.JavaType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f41421a[WireFormat.JavaType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f41421a[WireFormat.JavaType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f41421a[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f41421a[WireFormat.JavaType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f41421a[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f41421a[WireFormat.JavaType.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f41421a[WireFormat.JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b<T extends b<T>> extends Comparable<T> {
        boolean N();

        WireFormat.FieldType O();

        WireFormat.JavaType Q();

        n0.a f(n0.a aVar, n0 n0Var);

        int getNumber();

        boolean isPacked();
    }

    public u() {
        this.f41418a = e1.s(16);
    }

    public u(e1<T, Object> e1Var) {
        this.f41418a = e1Var;
        t();
    }

    public u(boolean z11) {
        this(e1.s(0));
        t();
    }

    public static void A(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (a.f41422b[fieldType.ordinal()]) {
            case 1:
                codedOutputStream.p0(((Double) obj).doubleValue());
                break;
            case 2:
                codedOutputStream.x0(((Float) obj).floatValue());
                break;
            case 3:
                codedOutputStream.F0(((Long) obj).longValue());
                break;
            case 4:
                codedOutputStream.Y0(((Long) obj).longValue());
                break;
            case 5:
                codedOutputStream.D0(((Integer) obj).intValue());
                break;
            case 6:
                codedOutputStream.v0(((Long) obj).longValue());
                break;
            case 7:
                codedOutputStream.t0(((Integer) obj).intValue());
                break;
            case 8:
                codedOutputStream.j0(((Boolean) obj).booleanValue());
                break;
            case 9:
                codedOutputStream.A0((n0) obj);
                break;
            case 10:
                codedOutputStream.H0((n0) obj);
                break;
            case 11:
                if (!(obj instanceof ByteString)) {
                    codedOutputStream.T0((String) obj);
                } else {
                    codedOutputStream.n0((ByteString) obj);
                }
                break;
            case 12:
                if (!(obj instanceof ByteString)) {
                    codedOutputStream.k0((byte[]) obj);
                } else {
                    codedOutputStream.n0((ByteString) obj);
                }
                break;
            case 13:
                codedOutputStream.W0(((Integer) obj).intValue());
                break;
            case 14:
                codedOutputStream.L0(((Integer) obj).intValue());
                break;
            case 15:
                codedOutputStream.N0(((Long) obj).longValue());
                break;
            case 16:
                codedOutputStream.P0(((Integer) obj).intValue());
                break;
            case 17:
                codedOutputStream.R0(((Long) obj).longValue());
                break;
            case 18:
                if (!(obj instanceof y.c)) {
                    codedOutputStream.r0(((Integer) obj).intValue());
                } else {
                    codedOutputStream.r0(((y.c) obj).getNumber());
                }
                break;
        }
    }

    public static Object c(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static int d(WireFormat.FieldType fieldType, int i11, Object obj) {
        int iV = CodedOutputStream.V(i11);
        if (fieldType == WireFormat.FieldType.GROUP) {
            iV *= 2;
        }
        return iV + e(fieldType, obj);
    }

    public static int e(WireFormat.FieldType fieldType, Object obj) {
        switch (a.f41422b[fieldType.ordinal()]) {
            case 1:
                return CodedOutputStream.k(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.s(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.z(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.Z(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.x(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.q(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.o(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.f(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.u((n0) obj);
            case 10:
                return obj instanceof a0 ? CodedOutputStream.C((a0) obj) : CodedOutputStream.H((n0) obj);
            case 11:
                return obj instanceof ByteString ? CodedOutputStream.i((ByteString) obj) : CodedOutputStream.U((String) obj);
            case 12:
                return obj instanceof ByteString ? CodedOutputStream.i((ByteString) obj) : CodedOutputStream.g((byte[]) obj);
            case 13:
                return CodedOutputStream.X(((Integer) obj).intValue());
            case 14:
                return CodedOutputStream.M(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.O(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.Q(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.S(((Long) obj).longValue());
            case 18:
                return obj instanceof y.c ? CodedOutputStream.m(((y.c) obj).getNumber()) : CodedOutputStream.m(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int f(b<?> bVar, Object obj) {
        WireFormat.FieldType fieldTypeO = bVar.O();
        int number = bVar.getNumber();
        if (!bVar.N()) {
            return d(fieldTypeO, number, obj);
        }
        int iD = 0;
        if (bVar.isPacked()) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                iD += e(fieldTypeO, it.next());
            }
            return CodedOutputStream.V(number) + iD + CodedOutputStream.K(iD);
        }
        Iterator it2 = ((List) obj).iterator();
        while (it2.hasNext()) {
            iD += d(fieldTypeO, number, it2.next());
        }
        return iD;
    }

    public static <T extends b<T>> u<T> h() {
        return f41417d;
    }

    public static int m(WireFormat.FieldType fieldType, boolean z11) {
        if (z11) {
            return 2;
        }
        return fieldType.getWireType();
    }

    public static <T extends b<T>> boolean q(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.Q() == WireFormat.JavaType.MESSAGE) {
            if (key.N()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((n0) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (!(value instanceof n0)) {
                    if (value instanceof a0) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                if (!((n0) value).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean r(WireFormat.FieldType fieldType, Object obj) {
        y.a(obj);
        switch (a.f41421a[fieldType.getJavaType().ordinal()]) {
            case 1:
                return obj instanceof Integer;
            case 2:
                return obj instanceof Long;
            case 3:
                return obj instanceof Float;
            case 4:
                return obj instanceof Double;
            case 5:
                return obj instanceof Boolean;
            case 6:
                return obj instanceof String;
            case 7:
                return (obj instanceof ByteString) || (obj instanceof byte[]);
            case 8:
                return (obj instanceof Integer) || (obj instanceof y.c);
            case 9:
                return (obj instanceof n0) || (obj instanceof a0);
            default:
                return false;
        }
    }

    public static <T extends b<T>> u<T> w() {
        return new u<>();
    }

    public static void z(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i11, Object obj) throws IOException {
        if (fieldType == WireFormat.FieldType.GROUP) {
            codedOutputStream.y0(i11, (n0) obj);
        } else {
            codedOutputStream.U0(i11, m(fieldType, false));
            A(codedOutputStream, fieldType, obj);
        }
    }

    public void a(T t11, Object obj) {
        List arrayList;
        if (!t11.N()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        y(t11, obj);
        Object objI = i(t11);
        if (objI == null) {
            arrayList = new ArrayList();
            this.f41418a.put(t11, arrayList);
        } else {
            arrayList = (List) objI;
        }
        arrayList.add(obj);
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public u<T> clone() {
        u<T> uVarW = w();
        for (int i11 = 0; i11 < this.f41418a.l(); i11++) {
            Map.Entry<K, Object> entryK = this.f41418a.k(i11);
            uVarW.x((b) entryK.getKey(), entryK.getValue());
        }
        Iterator it = this.f41418a.n().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            uVarW.x((b) entry.getKey(), entry.getValue());
        }
        uVarW.f41420c = this.f41420c;
        return uVarW;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof u) {
            return this.f41418a.equals(((u) obj).f41418a);
        }
        return false;
    }

    public Iterator<Map.Entry<T, Object>> g() {
        return this.f41420c ? new a0.c(this.f41418a.i().iterator()) : this.f41418a.i().iterator();
    }

    public int hashCode() {
        return this.f41418a.hashCode();
    }

    public Object i(T t11) {
        Object obj = this.f41418a.get(t11);
        return obj instanceof a0 ? ((a0) obj).f() : obj;
    }

    public int j() {
        int iK = 0;
        for (int i11 = 0; i11 < this.f41418a.l(); i11++) {
            iK += k(this.f41418a.k(i11));
        }
        Iterator it = this.f41418a.n().iterator();
        while (it.hasNext()) {
            iK += k((Map.Entry) it.next());
        }
        return iK;
    }

    public final int k(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.Q() != WireFormat.JavaType.MESSAGE || key.N() || key.isPacked()) {
            return f(key, value);
        }
        return value instanceof a0 ? CodedOutputStream.A(entry.getKey().getNumber(), (a0) value) : CodedOutputStream.E(entry.getKey().getNumber(), (n0) value);
    }

    public int l() {
        int iF = 0;
        for (int i11 = 0; i11 < this.f41418a.l(); i11++) {
            Map.Entry<K, Object> entryK = this.f41418a.k(i11);
            iF += f((b) entryK.getKey(), entryK.getValue());
        }
        Iterator it = this.f41418a.n().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            iF += f((b) entry.getKey(), entry.getValue());
        }
        return iF;
    }

    public boolean n() {
        return this.f41418a.isEmpty();
    }

    public boolean o() {
        return this.f41419b;
    }

    public boolean p() {
        for (int i11 = 0; i11 < this.f41418a.l(); i11++) {
            if (!q(this.f41418a.k(i11))) {
                return false;
            }
        }
        Iterator it = this.f41418a.n().iterator();
        while (it.hasNext()) {
            if (!q((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<T, Object>> s() {
        return this.f41420c ? new a0.c(this.f41418a.entrySet().iterator()) : this.f41418a.entrySet().iterator();
    }

    public void t() {
        if (this.f41419b) {
            return;
        }
        this.f41418a.r();
        this.f41419b = true;
    }

    public void u(u<T> uVar) {
        for (int i11 = 0; i11 < uVar.f41418a.l(); i11++) {
            v(uVar.f41418a.k(i11));
        }
        Iterator it = uVar.f41418a.n().iterator();
        while (it.hasNext()) {
            v((Map.Entry) it.next());
        }
    }

    public final void v(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof a0) {
            value = ((a0) value).f();
        }
        if (key.N()) {
            Object objI = i(key);
            if (objI == null) {
                objI = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objI).add(c(it.next()));
            }
            this.f41418a.put(key, objI);
            return;
        }
        if (key.Q() != WireFormat.JavaType.MESSAGE) {
            this.f41418a.put(key, c(value));
            return;
        }
        Object objI2 = i(key);
        if (objI2 == null) {
            this.f41418a.put(key, c(value));
        } else {
            this.f41418a.put(key, key.f(((n0) objI2).b(), (n0) value).build());
        }
    }

    public void x(T t11, Object obj) {
        if (!t11.N()) {
            y(t11, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                y(t11, it.next());
            }
            obj = arrayList;
        }
        if (obj instanceof a0) {
            this.f41420c = true;
        }
        this.f41418a.put(t11, obj);
    }

    public final void y(T t11, Object obj) {
        if (!r(t11.O(), obj)) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t11.getNumber()), t11.O().getJavaType(), obj.getClass().getName()));
        }
    }
}
