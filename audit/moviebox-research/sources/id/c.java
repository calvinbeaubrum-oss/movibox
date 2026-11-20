package id;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface c {

    /* JADX INFO: compiled from: source.java */
    public static final class a {
        public static boolean a(c cVar, String name) {
            Intrinsics.g(name, "name");
            return cVar.getBoolean(name, false);
        }

        public static boolean b(c cVar, String name, boolean z11) {
            Intrinsics.g(name, "name");
            Bundle bundle = cVar.getBundle();
            return bundle == null ? z11 : bundle.getBoolean(name, z11);
        }

        public static double c(c cVar, String name) {
            Intrinsics.g(name, "name");
            return cVar.getDouble(name, 0.0d);
        }

        public static double d(c cVar, String name, double d11) {
            Intrinsics.g(name, "name");
            Bundle bundle = cVar.getBundle();
            return bundle == null ? d11 : bundle.getDouble(name, d11);
        }

        public static float e(c cVar, String name) {
            Intrinsics.g(name, "name");
            return cVar.getFloat(name, 0.0f);
        }

        public static float f(c cVar, String name, float f11) {
            Intrinsics.g(name, "name");
            Bundle bundle = cVar.getBundle();
            return bundle == null ? f11 : bundle.getFloat(name, f11);
        }

        public static int g(c cVar, String name) {
            Intrinsics.g(name, "name");
            return cVar.getInt(name, 0);
        }

        public static int h(c cVar, String name, int i11) {
            Intrinsics.g(name, "name");
            Bundle bundle = cVar.getBundle();
            return bundle == null ? i11 : bundle.getInt(name, i11);
        }

        public static ArrayList<Integer> i(c cVar, String name) {
            Intrinsics.g(name, "name");
            Bundle bundle = cVar.getBundle();
            if (bundle == null) {
                return null;
            }
            return bundle.getIntegerArrayList(name);
        }

        public static long j(c cVar, String name) {
            Intrinsics.g(name, "name");
            return cVar.getLong(name, 0L);
        }

        public static long k(c cVar, String name, long j11) {
            Intrinsics.g(name, "name");
            Bundle bundle = cVar.getBundle();
            return bundle == null ? j11 : bundle.getLong(name, j11);
        }

        public static <P extends Parcelable> P l(c cVar, String name) {
            Intrinsics.g(name, "name");
            Bundle bundle = cVar.getBundle();
            if (bundle == null) {
                return null;
            }
            return (P) bundle.getParcelable(name);
        }

        public static <S extends Serializable> S m(c cVar, String name) {
            Intrinsics.g(name, "name");
            Bundle bundle = cVar.getBundle();
            if (bundle == null) {
                return null;
            }
            return (S) bundle.getSerializable(name);
        }

        public static String n(c cVar, String name) {
            Intrinsics.g(name, "name");
            Bundle bundle = cVar.getBundle();
            if (bundle == null) {
                return null;
            }
            return bundle.getString(name);
        }

        public static ArrayList<String> o(c cVar, String name) {
            Intrinsics.g(name, "name");
            Bundle bundle = cVar.getBundle();
            if (bundle == null) {
                return null;
            }
            return bundle.getStringArrayList(name);
        }
    }

    boolean getBoolean(String str, boolean z11);

    Bundle getBundle();

    double getDouble(String str, double d11);

    float getFloat(String str, float f11);

    int getInt(String str, int i11);

    long getLong(String str, long j11);
}
