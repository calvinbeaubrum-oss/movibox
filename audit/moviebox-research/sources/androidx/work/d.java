package androidx.work;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f13304b = j.i("Data");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f13305c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, Object> f13306a;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map<String, Object> f13307a = new HashMap();

        @NonNull
        public d a() throws Throwable {
            d dVar = new d((Map<String, ?>) this.f13307a);
            d.k(dVar);
            return dVar;
        }

        @NonNull
        public a b(@NonNull String str, @Nullable Object obj) {
            if (obj == null) {
                this.f13307a.put(str, null);
            } else {
                Class<?> cls = obj.getClass();
                if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                    this.f13307a.put(str, obj);
                } else if (cls == boolean[].class) {
                    this.f13307a.put(str, d.a((boolean[]) obj));
                } else if (cls == byte[].class) {
                    this.f13307a.put(str, d.b((byte[]) obj));
                } else if (cls == int[].class) {
                    this.f13307a.put(str, d.e((int[]) obj));
                } else if (cls == long[].class) {
                    this.f13307a.put(str, d.f((long[]) obj));
                } else if (cls == float[].class) {
                    this.f13307a.put(str, d.d((float[]) obj));
                } else {
                    if (cls != double[].class) {
                        throw new IllegalArgumentException("Key " + str + "has invalid type " + cls);
                    }
                    this.f13307a.put(str, d.c((double[]) obj));
                }
            }
            return this;
        }

        @NonNull
        public a c(@NonNull d dVar) {
            d(dVar.f13306a);
            return this;
        }

        @NonNull
        public a d(@NonNull Map<String, Object> map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                b(entry.getKey(), entry.getValue());
            }
            return this;
        }

        @NonNull
        public a e(@NonNull String str, @Nullable String str2) {
            this.f13307a.put(str, str2);
            return this;
        }
    }

    public d() {
    }

    public d(@NonNull d dVar) {
        this.f13306a = new HashMap(dVar.f13306a);
    }

    public d(@NonNull Map<String, ?> map) {
        this.f13306a = new HashMap(map);
    }

    @NonNull
    public static Boolean[] a(@NonNull boolean[] zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i11 = 0; i11 < zArr.length; i11++) {
            boolArr[i11] = Boolean.valueOf(zArr[i11]);
        }
        return boolArr;
    }

    @NonNull
    public static Byte[] b(@NonNull byte[] bArr) {
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i11 = 0; i11 < bArr.length; i11++) {
            bArr2[i11] = Byte.valueOf(bArr[i11]);
        }
        return bArr2;
    }

    @NonNull
    public static Double[] c(@NonNull double[] dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i11 = 0; i11 < dArr.length; i11++) {
            dArr2[i11] = Double.valueOf(dArr[i11]);
        }
        return dArr2;
    }

    @NonNull
    public static Float[] d(@NonNull float[] fArr) {
        Float[] fArr2 = new Float[fArr.length];
        for (int i11 = 0; i11 < fArr.length; i11++) {
            fArr2[i11] = Float.valueOf(fArr[i11]);
        }
        return fArr2;
    }

    @NonNull
    public static Integer[] e(@NonNull int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i11 = 0; i11 < iArr.length; i11++) {
            numArr[i11] = Integer.valueOf(iArr[i11]);
        }
        return numArr;
    }

    @NonNull
    public static Long[] f(@NonNull long[] jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i11 = 0; i11 < jArr.length; i11++) {
            lArr[i11] = Long.valueOf(jArr[i11]);
        }
        return lArr;
    }

    /* JADX WARN: Code duplicated, block: B:61:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @NonNull
    public static d g(@NonNull byte[] bArr) throws Throwable {
        ObjectInputStream objectInputStream;
        Throwable e11;
        if (bArr.length > 10240) {
            throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
        }
        HashMap map = new HashMap();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ObjectInputStream objectInputStream2 = null;
        try {
            try {
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    try {
                        for (int i11 = objectInputStream.readInt(); i11 > 0; i11--) {
                            map.put(objectInputStream.readUTF(), objectInputStream.readObject());
                        }
                        try {
                            objectInputStream.close();
                        } catch (IOException e12) {
                            Log.e(f13304b, "Error in Data#fromByteArray: ", e12);
                        }
                        byteArrayInputStream.close();
                    } catch (IOException e13) {
                        e11 = e13;
                        Log.e(f13304b, "Error in Data#fromByteArray: ", e11);
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e14) {
                                Log.e(f13304b, "Error in Data#fromByteArray: ", e14);
                            }
                        }
                        byteArrayInputStream.close();
                    } catch (ClassNotFoundException e15) {
                        e11 = e15;
                        Log.e(f13304b, "Error in Data#fromByteArray: ", e11);
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        byteArrayInputStream.close();
                    }
                } catch (IOException e16) {
                    Log.e(f13304b, "Error in Data#fromByteArray: ", e16);
                }
            } catch (IOException e17) {
                e = e17;
                Throwable th2 = e;
                objectInputStream = null;
                e11 = th2;
                Log.e(f13304b, "Error in Data#fromByteArray: ", e11);
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                byteArrayInputStream.close();
                return new d(map);
            } catch (ClassNotFoundException e18) {
                e = e18;
                Throwable th3 = e;
                objectInputStream = null;
                e11 = th3;
                Log.e(f13304b, "Error in Data#fromByteArray: ", e11);
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                byteArrayInputStream.close();
                return new d(map);
            } catch (Throwable th4) {
                th = th4;
                if (0 != 0) {
                    try {
                        objectInputStream2.close();
                    } catch (IOException e19) {
                        Log.e(f13304b, "Error in Data#fromByteArray: ", e19);
                    }
                }
                try {
                    byteArrayInputStream.close();
                    throw th;
                } catch (IOException e21) {
                    Log.e(f13304b, "Error in Data#fromByteArray: ", e21);
                    throw th;
                }
            }
            return new d(map);
        } catch (Throwable th5) {
            th = th5;
        }
    }

    @NonNull
    public static byte[] k(@NonNull d dVar) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream2.writeInt(dVar.j());
                    for (Map.Entry<String, Object> entry : dVar.f13306a.entrySet()) {
                        objectOutputStream2.writeUTF(entry.getKey());
                        objectOutputStream2.writeObject(entry.getValue());
                    }
                    try {
                        objectOutputStream2.close();
                    } catch (IOException e11) {
                        Log.e(f13304b, "Error in Data#toByteArray: ", e11);
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e12) {
                        Log.e(f13304b, "Error in Data#toByteArray: ", e12);
                    }
                    if (byteArrayOutputStream.size() <= 10240) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
                } catch (IOException e13) {
                    e = e13;
                    objectOutputStream = objectOutputStream2;
                    Log.e(f13304b, "Error in Data#toByteArray: ", e);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e14) {
                            Log.e(f13304b, "Error in Data#toByteArray: ", e14);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e15) {
                        Log.e(f13304b, "Error in Data#toByteArray: ", e15);
                    }
                    return byteArray;
                } catch (Throwable th2) {
                    th = th2;
                    objectOutputStream = objectOutputStream2;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e16) {
                            Log.e(f13304b, "Error in Data#toByteArray: ", e16);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                        throw th;
                    } catch (IOException e17) {
                        Log.e(f13304b, "Error in Data#toByteArray: ", e17);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e18) {
            e = e18;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        Set<String> setKeySet = this.f13306a.keySet();
        if (!setKeySet.equals(dVar.f13306a.keySet())) {
            return false;
        }
        for (String str : setKeySet) {
            Object obj2 = this.f13306a.get(str);
            Object obj3 = dVar.f13306a.get(str);
            if (obj2 == null || obj3 == null) {
                if (obj2 != obj3) {
                    return false;
                }
            } else {
                if (!(((obj2 instanceof Object[]) && (obj3 instanceof Object[])) ? Arrays.deepEquals((Object[]) obj2, (Object[]) obj3) : obj2.equals(obj3))) {
                    return false;
                }
            }
        }
        return true;
    }

    @NonNull
    public Map<String, Object> h() {
        return Collections.unmodifiableMap(this.f13306a);
    }

    public int hashCode() {
        return this.f13306a.hashCode() * 31;
    }

    @Nullable
    public String i(@NonNull String str) {
        Object obj = this.f13306a.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public int j() {
        return this.f13306a.size();
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder("Data {");
        if (!this.f13306a.isEmpty()) {
            for (String str : this.f13306a.keySet()) {
                sb2.append(str);
                sb2.append(" : ");
                Object obj = this.f13306a.get(str);
                if (obj instanceof Object[]) {
                    sb2.append(Arrays.toString((Object[]) obj));
                } else {
                    sb2.append(obj);
                }
                sb2.append(", ");
            }
        }
        sb2.append("}");
        return sb2.toString();
    }
}
