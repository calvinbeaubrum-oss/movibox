package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.i;
import androidx.core.view.ViewCompat;
import androidx.versionedparcelable.CustomVersionedParcelable;
import b3.h;
import com.applovin.sdk.AppLovinEventTypes;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f7767k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f7769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public byte[] f7770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public Parcelable f7771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f7773f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public ColorStateList f7774g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f7775h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public String f7776i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public String f7777j;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    public static class a {
        public static IconCompat a(@NonNull Object obj) {
            i.g(obj);
            int iD = d(obj);
            if (iD == 2) {
                return IconCompat.l(null, c(obj), b(obj));
            }
            if (iD == 4) {
                return IconCompat.i(e(obj));
            }
            if (iD == 6) {
                return IconCompat.f(e(obj));
            }
            IconCompat iconCompat = new IconCompat(-1);
            iconCompat.f7769b = obj;
            return iconCompat;
        }

        public static int b(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e11) {
                Log.e("IconCompat", "Unable to get icon resource", e11);
                return 0;
            } catch (NoSuchMethodException e12) {
                Log.e("IconCompat", "Unable to get icon resource", e12);
                return 0;
            } catch (InvocationTargetException e13) {
                Log.e("IconCompat", "Unable to get icon resource", e13);
                return 0;
            }
        }

        @Nullable
        public static String c(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e11) {
                Log.e("IconCompat", "Unable to get icon package", e11);
                return null;
            } catch (NoSuchMethodException e12) {
                Log.e("IconCompat", "Unable to get icon package", e12);
                return null;
            } catch (InvocationTargetException e13) {
                Log.e("IconCompat", "Unable to get icon package", e13);
                return null;
            }
        }

        public static int d(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.c(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e11) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e11);
                return -1;
            } catch (NoSuchMethodException e12) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e12);
                return -1;
            } catch (InvocationTargetException e13) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e13);
                return -1;
            }
        }

        @Nullable
        public static Uri e(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e11) {
                Log.e("IconCompat", "Unable to get icon uri", e11);
                return null;
            } catch (NoSuchMethodException e12) {
                Log.e("IconCompat", "Unable to get icon uri", e12);
                return null;
            } catch (InvocationTargetException e13) {
                Log.e("IconCompat", "Unable to get icon uri", e13);
                return null;
            }
        }

        public static Drawable f(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        public static Icon g(IconCompat iconCompat, Context context) {
            Icon iconCreateWithBitmap;
            switch (iconCompat.f7768a) {
                case -1:
                    return (Icon) iconCompat.f7769b;
                case 0:
                default:
                    throw new IllegalArgumentException("Unknown type");
                case 1:
                    iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f7769b);
                    break;
                case 2:
                    iconCreateWithBitmap = Icon.createWithResource(iconCompat.o(), iconCompat.f7772e);
                    break;
                case 3:
                    iconCreateWithBitmap = Icon.createWithData((byte[]) iconCompat.f7769b, iconCompat.f7772e, iconCompat.f7773f);
                    break;
                case 4:
                    iconCreateWithBitmap = Icon.createWithContentUri((String) iconCompat.f7769b);
                    break;
                case 5:
                    iconCreateWithBitmap = Build.VERSION.SDK_INT < 26 ? Icon.createWithBitmap(IconCompat.e((Bitmap) iconCompat.f7769b, false)) : b.b((Bitmap) iconCompat.f7769b);
                    break;
                case 6:
                    int i11 = Build.VERSION.SDK_INT;
                    if (i11 >= 30) {
                        iconCreateWithBitmap = d.a(iconCompat.r());
                    } else {
                        if (context == null) {
                            throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.r());
                        }
                        InputStream inputStreamS = iconCompat.s(context);
                        if (inputStreamS == null) {
                            throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.r());
                        }
                        if (i11 < 26) {
                            iconCreateWithBitmap = Icon.createWithBitmap(IconCompat.e(BitmapFactory.decodeStream(inputStreamS), false));
                        } else {
                            iconCreateWithBitmap = b.b(BitmapFactory.decodeStream(inputStreamS));
                        }
                    }
                    break;
            }
            ColorStateList colorStateList = iconCompat.f7774g;
            if (colorStateList != null) {
                iconCreateWithBitmap.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f7775h;
            if (mode != IconCompat.f7767k) {
                iconCreateWithBitmap.setTintMode(mode);
            }
            return iconCreateWithBitmap;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(26)
    public static class b {
        public static Drawable a(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        public static Icon b(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(28)
    public static class c {
        public static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        public static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        public static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        public static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(30)
    public static class d {
        public static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    public IconCompat() {
        this.f7768a = -1;
        this.f7770c = null;
        this.f7771d = null;
        this.f7772e = 0;
        this.f7773f = 0;
        this.f7774g = null;
        this.f7775h = f7767k;
        this.f7776i = null;
    }

    public IconCompat(int i11) {
        this.f7770c = null;
        this.f7771d = null;
        this.f7772e = 0;
        this.f7773f = 0;
        this.f7774g = null;
        this.f7775h = f7767k;
        this.f7776i = null;
        this.f7768a = i11;
    }

    public static String A(int i11) {
        switch (i11) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    @Nullable
    @RequiresApi(23)
    public static IconCompat c(@NonNull Icon icon) {
        return a.a(icon);
    }

    @Nullable
    @RequiresApi(23)
    public static IconCompat d(@NonNull Icon icon) {
        if (a.d(icon) == 2 && a.b(icon) == 0) {
            return null;
        }
        return a.a(icon);
    }

    public static Bitmap e(Bitmap bitmap, boolean z11) {
        int iMin = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        float f11 = iMin;
        float f12 = 0.5f * f11;
        float f13 = 0.9166667f * f12;
        if (z11) {
            float f14 = 0.010416667f * f11;
            paint.setColor(0);
            paint.setShadowLayer(f14, 0.0f, f11 * 0.020833334f, 1023410176);
            canvas.drawCircle(f12, f12, f13, paint);
            paint.setShadowLayer(f14, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f12, f12, f13, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2.0f, (-(bitmap.getHeight() - iMin)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f12, f12, f13, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    @NonNull
    public static IconCompat f(@NonNull Uri uri) {
        androidx.core.util.d.c(uri);
        return g(uri.toString());
    }

    @NonNull
    public static IconCompat g(@NonNull String str) {
        androidx.core.util.d.c(str);
        IconCompat iconCompat = new IconCompat(6);
        iconCompat.f7769b = str;
        return iconCompat;
    }

    @NonNull
    public static IconCompat h(@NonNull Bitmap bitmap) {
        androidx.core.util.d.c(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f7769b = bitmap;
        return iconCompat;
    }

    @NonNull
    public static IconCompat i(@NonNull Uri uri) {
        androidx.core.util.d.c(uri);
        return j(uri.toString());
    }

    @NonNull
    public static IconCompat j(@NonNull String str) {
        androidx.core.util.d.c(str);
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.f7769b = str;
        return iconCompat;
    }

    @NonNull
    public static IconCompat k(@NonNull Context context, int i11) {
        androidx.core.util.d.c(context);
        return l(context.getResources(), context.getPackageName(), i11);
    }

    @NonNull
    public static IconCompat l(@Nullable Resources resources, @NonNull String str, int i11) {
        androidx.core.util.d.c(str);
        if (i11 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f7772e = i11;
        if (resources != null) {
            try {
                iconCompat.f7769b = resources.getResourceName(i11);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f7769b = str;
        }
        iconCompat.f7777j = str;
        return iconCompat;
    }

    public static Resources p(Context context, String str) {
        if ("android".equals(str)) {
            return Resources.getSystem();
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 8192);
            if (applicationInfo != null) {
                return packageManager.getResourcesForApplication(applicationInfo);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e11) {
            Log.e("IconCompat", String.format("Unable to find pkg=%s for icon", str), e11);
            return null;
        }
    }

    public void b(@NonNull Context context) {
        Object obj;
        if (this.f7768a != 2 || (obj = this.f7769b) == null) {
            return;
        }
        String str = (String) obj;
        if (str.contains(":")) {
            String str2 = str.split(":", -1)[1];
            String str3 = str2.split("/", -1)[0];
            String str4 = str2.split("/", -1)[1];
            String str5 = str.split(":", -1)[0];
            if ("0_resource_name_obfuscated".equals(str4)) {
                return;
            }
            String strO = o();
            int identifier = p(context, strO).getIdentifier(str4, str3, str5);
            if (this.f7772e != identifier) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Id has changed for ");
                sb2.append(strO);
                sb2.append(" ");
                sb2.append(str);
                this.f7772e = identifier;
            }
        }
    }

    @Nullable
    public Bitmap m() {
        int i11 = this.f7768a;
        if (i11 == -1 && Build.VERSION.SDK_INT >= 23) {
            Object obj = this.f7769b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        }
        if (i11 == 1) {
            return (Bitmap) this.f7769b;
        }
        if (i11 == 5) {
            return e((Bitmap) this.f7769b, true);
        }
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    public int n() {
        int i11 = this.f7768a;
        if (i11 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.b(this.f7769b);
        }
        if (i11 == 2) {
            return this.f7772e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    @NonNull
    public String o() {
        int i11 = this.f7768a;
        if (i11 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.c(this.f7769b);
        }
        if (i11 == 2) {
            String str = this.f7777j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f7769b).split(":", -1)[0] : this.f7777j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int q() {
        int i11 = this.f7768a;
        return (i11 != -1 || Build.VERSION.SDK_INT < 23) ? i11 : a.d(this.f7769b);
    }

    @NonNull
    public Uri r() {
        int i11 = this.f7768a;
        if (i11 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.e(this.f7769b);
        }
        if (i11 == 4 || i11 == 6) {
            return Uri.parse((String) this.f7769b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    @Nullable
    public InputStream s(@NonNull Context context) {
        Uri uriR = r();
        String scheme = uriR.getScheme();
        if (AppLovinEventTypes.USER_VIEWED_CONTENT.equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(uriR);
            } catch (Exception e11) {
                Log.w("IconCompat", "Unable to load image from URI: " + uriR, e11);
                return null;
            }
        }
        try {
            return new FileInputStream(new File((String) this.f7769b));
        } catch (FileNotFoundException e12) {
            Log.w("IconCompat", "Unable to load image from path: " + uriR, e12);
            return null;
        }
    }

    @Nullable
    public Drawable t(@NonNull Context context) {
        b(context);
        if (Build.VERSION.SDK_INT >= 23) {
            return a.f(z(context), context);
        }
        Drawable drawableU = u(context);
        if (drawableU != null && (this.f7774g != null || this.f7775h != f7767k)) {
            drawableU.mutate();
            d3.a.o(drawableU, this.f7774g);
            d3.a.p(drawableU, this.f7775h);
        }
        return drawableU;
    }

    @NonNull
    public String toString() {
        if (this.f7768a == -1) {
            return String.valueOf(this.f7769b);
        }
        StringBuilder sb2 = new StringBuilder("Icon(typ=");
        sb2.append(A(this.f7768a));
        switch (this.f7768a) {
            case 1:
            case 5:
                sb2.append(" size=");
                sb2.append(((Bitmap) this.f7769b).getWidth());
                sb2.append("x");
                sb2.append(((Bitmap) this.f7769b).getHeight());
                break;
            case 2:
                sb2.append(" pkg=");
                sb2.append(this.f7777j);
                sb2.append(" id=");
                sb2.append(String.format("0x%08x", Integer.valueOf(n())));
                break;
            case 3:
                sb2.append(" len=");
                sb2.append(this.f7772e);
                if (this.f7773f != 0) {
                    sb2.append(" off=");
                    sb2.append(this.f7773f);
                }
                break;
            case 4:
            case 6:
                sb2.append(" uri=");
                sb2.append(this.f7769b);
                break;
        }
        if (this.f7774g != null) {
            sb2.append(" tint=");
            sb2.append(this.f7774g);
        }
        if (this.f7775h != f7767k) {
            sb2.append(" mode=");
            sb2.append(this.f7775h);
        }
        sb2.append(")");
        return sb2.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final Drawable u(Context context) {
        switch (this.f7768a) {
            case 1:
                return new BitmapDrawable(context.getResources(), (Bitmap) this.f7769b);
            case 2:
                String strO = o();
                if (TextUtils.isEmpty(strO)) {
                    strO = context.getPackageName();
                }
                try {
                    return h.e(p(context, strO), this.f7772e, context.getTheme());
                } catch (RuntimeException e11) {
                    Log.e("IconCompat", String.format("Unable to load resource 0x%08x from pkg=%s", Integer.valueOf(this.f7772e), this.f7769b), e11);
                }
                break;
            case 3:
                return new BitmapDrawable(context.getResources(), BitmapFactory.decodeByteArray((byte[]) this.f7769b, this.f7772e, this.f7773f));
            case 4:
                InputStream inputStreamS = s(context);
                if (inputStreamS != null) {
                    return new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(inputStreamS));
                }
                return null;
            case 5:
                return new BitmapDrawable(context.getResources(), e((Bitmap) this.f7769b, false));
            case 6:
                InputStream inputStreamS2 = s(context);
                if (inputStreamS2 != null) {
                    return Build.VERSION.SDK_INT >= 26 ? b.a(null, new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(inputStreamS2))) : new BitmapDrawable(context.getResources(), e(BitmapFactory.decodeStream(inputStreamS2), false));
                }
                return null;
            default:
                return null;
        }
    }

    public void v() {
        this.f7775h = PorterDuff.Mode.valueOf(this.f7776i);
        switch (this.f7768a) {
            case -1:
                Parcelable parcelable = this.f7771d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                this.f7769b = parcelable;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f7771d;
                if (parcelable2 != null) {
                    this.f7769b = parcelable2;
                    return;
                }
                byte[] bArr = this.f7770c;
                this.f7769b = bArr;
                this.f7768a = 3;
                this.f7772e = 0;
                this.f7773f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f7770c, Charset.forName(C.UTF16_NAME));
                this.f7769b = str;
                if (this.f7768a == 2 && this.f7777j == null) {
                    this.f7777j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f7769b = this.f7770c;
                return;
        }
    }

    public void w(boolean z11) {
        this.f7776i = this.f7775h.name();
        switch (this.f7768a) {
            case -1:
                if (z11) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.f7771d = (Parcelable) this.f7769b;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (!z11) {
                    this.f7771d = (Parcelable) this.f7769b;
                    return;
                }
                Bitmap bitmap = (Bitmap) this.f7769b;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.f7770c = byteArrayOutputStream.toByteArray();
                return;
            case 2:
                this.f7770c = ((String) this.f7769b).getBytes(Charset.forName(C.UTF16_NAME));
                return;
            case 3:
                this.f7770c = (byte[]) this.f7769b;
                return;
            case 4:
            case 6:
                this.f7770c = this.f7769b.toString().getBytes(Charset.forName(C.UTF16_NAME));
                return;
        }
    }

    @NonNull
    public Bundle x() {
        Bundle bundle = new Bundle();
        switch (this.f7768a) {
            case -1:
                bundle.putParcelable("obj", (Parcelable) this.f7769b);
                break;
            case 0:
            default:
                throw new IllegalArgumentException("Invalid icon");
            case 1:
            case 5:
                bundle.putParcelable("obj", (Bitmap) this.f7769b);
                break;
            case 2:
            case 4:
            case 6:
                bundle.putString("obj", (String) this.f7769b);
                break;
            case 3:
                bundle.putByteArray("obj", (byte[]) this.f7769b);
                break;
        }
        bundle.putInt("type", this.f7768a);
        bundle.putInt("int1", this.f7772e);
        bundle.putInt("int2", this.f7773f);
        bundle.putString("string1", this.f7777j);
        ColorStateList colorStateList = this.f7774g;
        if (colorStateList != null) {
            bundle.putParcelable("tint_list", colorStateList);
        }
        PorterDuff.Mode mode = this.f7775h;
        if (mode != f7767k) {
            bundle.putString("tint_mode", mode.name());
        }
        return bundle;
    }

    @NonNull
    @RequiresApi(23)
    @Deprecated
    public Icon y() {
        return z(null);
    }

    @NonNull
    @RequiresApi(23)
    public Icon z(@Nullable Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.g(this, context);
        }
        throw new UnsupportedOperationException("This method is only supported on API level 23+");
    }
}
