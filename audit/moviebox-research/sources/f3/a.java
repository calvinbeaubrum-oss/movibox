package f3;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.location.FusedLocationProviderClient;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static Field f64533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public static Integer f64534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public static Integer f64535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public static Integer f64536d;

    /* JADX INFO: renamed from: f3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @RequiresApi(26)
    public static class C0667a {
        public static float a(Location location) {
            return location.getBearingAccuracyDegrees();
        }

        public static float b(Location location) {
            return location.getSpeedAccuracyMetersPerSecond();
        }

        public static float c(Location location) {
            return location.getVerticalAccuracyMeters();
        }

        public static boolean d(Location location) {
            return location.hasBearingAccuracy();
        }

        public static boolean e(Location location) {
            return location.hasSpeedAccuracy();
        }

        public static boolean f(Location location) {
            return location.hasVerticalAccuracy();
        }

        public static void g(Location location) {
            try {
                a.d().setByte(location, (byte) (a.d().getByte(location) & (~a.e())));
            } catch (IllegalAccessException e11) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(e11);
                throw illegalAccessError;
            } catch (NoSuchFieldException e12) {
                NoSuchFieldError noSuchFieldError = new NoSuchFieldError();
                noSuchFieldError.initCause(e12);
                throw noSuchFieldError;
            }
        }

        public static void h(Location location) {
            try {
                a.d().setByte(location, (byte) (a.d().getByte(location) & (~a.f())));
            } catch (IllegalAccessException e11) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(e11);
                throw illegalAccessError;
            } catch (NoSuchFieldException e12) {
                NoSuchFieldError noSuchFieldError = new NoSuchFieldError();
                noSuchFieldError.initCause(e12);
                throw noSuchFieldError;
            }
        }

        public static void i(Location location) {
            try {
                a.d().setByte(location, (byte) (a.d().getByte(location) & (~a.g())));
            } catch (IllegalAccessException | NoSuchFieldException e11) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(e11);
                throw illegalAccessError;
            }
        }

        public static void j(Location location, float f11) {
            location.setBearingAccuracyDegrees(f11);
        }

        public static void k(Location location, float f11) {
            location.setSpeedAccuracyMetersPerSecond(f11);
        }

        public static void l(Location location, float f11) {
            location.setVerticalAccuracyMeters(f11);
        }
    }

    public static boolean a(@NonNull Location location, String str) {
        Bundle extras = location.getExtras();
        return extras != null && extras.containsKey(str);
    }

    public static float b(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return C0667a.a(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat("bearingAccuracy", 0.0f);
    }

    public static long c(@NonNull Location location) {
        return TimeUnit.NANOSECONDS.toMillis(location.getElapsedRealtimeNanos());
    }

    @SuppressLint({"BlockedPrivateApi"})
    public static Field d() throws NoSuchFieldException {
        if (f64533a == null) {
            Field declaredField = Location.class.getDeclaredField("mFieldsMask");
            f64533a = declaredField;
            declaredField.setAccessible(true);
        }
        return f64533a;
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static int e() throws IllegalAccessException, NoSuchFieldException {
        if (f64535c == null) {
            Field declaredField = Location.class.getDeclaredField("HAS_BEARING_ACCURACY_MASK");
            declaredField.setAccessible(true);
            f64535c = Integer.valueOf(declaredField.getInt(null));
        }
        return f64535c.intValue();
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static int f() throws IllegalAccessException, NoSuchFieldException {
        if (f64534b == null) {
            Field declaredField = Location.class.getDeclaredField("HAS_SPEED_ACCURACY_MASK");
            declaredField.setAccessible(true);
            f64534b = Integer.valueOf(declaredField.getInt(null));
        }
        return f64534b.intValue();
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static int g() throws IllegalAccessException, NoSuchFieldException {
        if (f64536d == null) {
            Field declaredField = Location.class.getDeclaredField("HAS_VERTICAL_ACCURACY_MASK");
            declaredField.setAccessible(true);
            f64536d = Integer.valueOf(declaredField.getInt(null));
        }
        return f64536d.intValue();
    }

    public static float h(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return C0667a.b(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat("speedAccuracy", 0.0f);
    }

    public static float i(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return C0667a.c(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat(FusedLocationProviderClient.KEY_VERTICAL_ACCURACY, 0.0f);
    }

    public static boolean j(@NonNull Location location) {
        return Build.VERSION.SDK_INT >= 26 ? C0667a.d(location) : a(location, "bearingAccuracy");
    }

    public static boolean k(@NonNull Location location) {
        return Build.VERSION.SDK_INT >= 26 ? C0667a.e(location) : a(location, "speedAccuracy");
    }

    public static boolean l(@NonNull Location location) {
        return Build.VERSION.SDK_INT >= 26 ? C0667a.f(location) : a(location, FusedLocationProviderClient.KEY_VERTICAL_ACCURACY);
    }

    public static boolean m(@NonNull Location location) {
        return location.isFromMockProvider();
    }
}
