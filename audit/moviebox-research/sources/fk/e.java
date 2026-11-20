package fk;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class e {
    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static boolean b(Object[] objArr, Object[] objArr2) {
        if (objArr == null) {
            return objArr2 == null;
        }
        if (objArr2 == null || objArr.length != objArr2.length) {
            return false;
        }
        for (int i11 = 0; i11 < objArr.length; i11++) {
            if (!a(objArr[i11], objArr2[i11])) {
                return false;
            }
        }
        return true;
    }

    public static int c(int i11, int i12) {
        return (i11 * 37) + i12;
    }

    public static int d(int i11, Object obj) {
        return c(i11, obj != null ? obj.hashCode() : 0);
    }
}
