package androidx.appcompat.widget;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.vungle.warren.error.VungleException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f1615a = {R.attr.state_checked};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1616b = new int[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Rect f1617c = new Rect();

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final boolean f1618a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Method f1619b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Field f1620c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Field f1621d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Field f1622e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Field f1623f;

        /* JADX WARN: Code duplicated, block: B:26:0x0058  */
        /* JADX WARN: Code duplicated, block: B:27:0x0065  */
        static {
            Method method;
            Field field;
            Field field2;
            Field field3;
            Field field4;
            boolean z11;
            try {
                Class<?> cls = Class.forName("android.graphics.Insets");
                method = Drawable.class.getMethod("getOpticalInsets", new Class[0]);
                try {
                    field = cls.getField(TtmlNode.LEFT);
                    try {
                        field2 = cls.getField("top");
                        try {
                            field3 = cls.getField(TtmlNode.RIGHT);
                            try {
                                field4 = cls.getField("bottom");
                                z11 = true;
                            } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused) {
                                field4 = null;
                                z11 = false;
                            }
                        } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused2) {
                            field3 = null;
                        }
                    } catch (ClassNotFoundException unused3) {
                        field2 = null;
                        field3 = field2;
                        field4 = null;
                        z11 = false;
                        if (z11) {
                            f1619b = method;
                            f1620c = field;
                            f1621d = field2;
                            f1622e = field3;
                            f1623f = field4;
                            f1618a = true;
                            return;
                        }
                        f1619b = null;
                        f1620c = null;
                        f1621d = null;
                        f1622e = null;
                        f1623f = null;
                        f1618a = false;
                    } catch (NoSuchFieldException unused4) {
                        field2 = null;
                        field3 = field2;
                        field4 = null;
                        z11 = false;
                        if (z11) {
                            f1619b = method;
                            f1620c = field;
                            f1621d = field2;
                            f1622e = field3;
                            f1623f = field4;
                            f1618a = true;
                            return;
                        }
                        f1619b = null;
                        f1620c = null;
                        f1621d = null;
                        f1622e = null;
                        f1623f = null;
                        f1618a = false;
                    } catch (NoSuchMethodException unused5) {
                        field2 = null;
                        field3 = field2;
                        field4 = null;
                        z11 = false;
                        if (z11) {
                            f1619b = method;
                            f1620c = field;
                            f1621d = field2;
                            f1622e = field3;
                            f1623f = field4;
                            f1618a = true;
                            return;
                        }
                        f1619b = null;
                        f1620c = null;
                        f1621d = null;
                        f1622e = null;
                        f1623f = null;
                        f1618a = false;
                    }
                } catch (ClassNotFoundException unused6) {
                    field = null;
                    field2 = field;
                    field3 = field2;
                    field4 = null;
                    z11 = false;
                    if (z11) {
                        f1619b = method;
                        f1620c = field;
                        f1621d = field2;
                        f1622e = field3;
                        f1623f = field4;
                        f1618a = true;
                        return;
                    }
                    f1619b = null;
                    f1620c = null;
                    f1621d = null;
                    f1622e = null;
                    f1623f = null;
                    f1618a = false;
                } catch (NoSuchFieldException unused7) {
                    field = null;
                    field2 = field;
                    field3 = field2;
                    field4 = null;
                    z11 = false;
                    if (z11) {
                        f1619b = method;
                        f1620c = field;
                        f1621d = field2;
                        f1622e = field3;
                        f1623f = field4;
                        f1618a = true;
                        return;
                    }
                    f1619b = null;
                    f1620c = null;
                    f1621d = null;
                    f1622e = null;
                    f1623f = null;
                    f1618a = false;
                } catch (NoSuchMethodException unused8) {
                    field = null;
                    field2 = field;
                    field3 = field2;
                    field4 = null;
                    z11 = false;
                    if (z11) {
                        f1619b = method;
                        f1620c = field;
                        f1621d = field2;
                        f1622e = field3;
                        f1623f = field4;
                        f1618a = true;
                        return;
                    }
                    f1619b = null;
                    f1620c = null;
                    f1621d = null;
                    f1622e = null;
                    f1623f = null;
                    f1618a = false;
                }
            } catch (ClassNotFoundException unused9) {
                method = null;
                field = null;
            } catch (NoSuchFieldException unused10) {
                method = null;
                field = null;
            } catch (NoSuchMethodException unused11) {
                method = null;
                field = null;
            }
            if (z11) {
                f1619b = method;
                f1620c = field;
                f1621d = field2;
                f1622e = field3;
                f1623f = field4;
                f1618a = true;
                return;
            }
            f1619b = null;
            f1620c = null;
            f1621d = null;
            f1622e = null;
            f1623f = null;
            f1618a = false;
        }

        @NonNull
        public static Rect a(@NonNull Drawable drawable) {
            if (Build.VERSION.SDK_INT < 29 && f1618a) {
                try {
                    Object objInvoke = f1619b.invoke(drawable, new Object[0]);
                    if (objInvoke != null) {
                        return new Rect(f1620c.getInt(objInvoke), f1621d.getInt(objInvoke), f1622e.getInt(objInvoke), f1623f.getInt(objInvoke));
                    }
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
            }
            return b0.f1617c;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static class b {
        public static Insets a(Drawable drawable) {
            return drawable.getOpticalInsets();
        }
    }

    @Deprecated
    public static boolean a(@NonNull Drawable drawable) {
        return true;
    }

    public static void b(@NonNull Drawable drawable) {
        String name = drawable.getClass().getName();
        int i11 = Build.VERSION.SDK_INT;
        if (i11 == 21 && "android.graphics.drawable.VectorDrawable".equals(name)) {
            c(drawable);
        } else {
            if (i11 < 29 || i11 >= 31 || !"android.graphics.drawable.ColorStateListDrawable".equals(name)) {
                return;
            }
            c(drawable);
        }
    }

    public static void c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(f1615a);
        } else {
            drawable.setState(f1616b);
        }
        drawable.setState(state);
    }

    @NonNull
    public static Rect d(@NonNull Drawable drawable) {
        if (Build.VERSION.SDK_INT < 29) {
            return a.a(d3.a.q(drawable));
        }
        Insets insetsA = b.a(drawable);
        return new Rect(insetsA.left, insetsA.top, insetsA.right, insetsA.bottom);
    }

    public static PorterDuff.Mode e(int i11, PorterDuff.Mode mode) {
        if (i11 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i11 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i11 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i11) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
