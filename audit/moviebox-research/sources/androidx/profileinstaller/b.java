package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import c6.k;
import com.vungle.warren.error.VungleException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(19)
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final AssetManager f12360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Executor f12361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final c.InterfaceC0114c f12362c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final File f12364e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final String f12365f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final String f12366g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final String f12367h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public c6.c[] f12369j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public byte[] f12370k;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f12368i = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final byte[] f12363d = d();

    public b(@NonNull AssetManager assetManager, @NonNull Executor executor, @NonNull c.InterfaceC0114c interfaceC0114c, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull File file) {
        this.f12360a = assetManager;
        this.f12361b = executor;
        this.f12362c = interfaceC0114c;
        this.f12365f = str;
        this.f12366g = str2;
        this.f12367h = str3;
        this.f12364e = file;
    }

    @Nullable
    public static byte[] d() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 24 || i11 > 34) {
            return null;
        }
        switch (i11) {
            case 24:
            case 25:
                return k.f14657e;
            case 26:
                return k.f14656d;
            case 27:
                return k.f14655c;
            case 28:
            case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
            case 30:
                return k.f14654b;
            case VungleException.WEB_CRASH /* 31 */:
            case 32:
            case 33:
            case 34:
                return k.f14653a;
            default:
                return null;
        }
    }

    public static boolean k() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 24 || i11 > 34) {
            return false;
        }
        if (i11 != 24 && i11 != 25) {
            switch (i11) {
                case VungleException.WEB_CRASH /* 31 */:
                case 32:
                case 33:
                case 34:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    @Nullable
    public final b b(c6.c[] cVarArr, byte[] bArr) {
        try {
            InputStream inputStreamH = h(this.f12360a, this.f12367h);
            if (inputStreamH == null) {
                if (inputStreamH != null) {
                    inputStreamH.close();
                }
                return null;
            }
            try {
                this.f12369j = d.q(inputStreamH, d.o(inputStreamH, d.f12374b), bArr, cVarArr);
                inputStreamH.close();
                return this;
            } catch (Throwable th2) {
                try {
                    inputStreamH.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (FileNotFoundException e11) {
            this.f12362c.a(9, e11);
        } catch (IOException e12) {
            this.f12362c.a(7, e12);
        } catch (IllegalStateException e13) {
            this.f12369j = null;
            this.f12362c.a(8, e13);
        }
    }

    public final void c() {
        if (!this.f12368i) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    public boolean e() {
        if (this.f12363d == null) {
            l(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (!this.f12364e.exists()) {
            try {
                this.f12364e.createNewFile();
            } catch (IOException unused) {
                l(4, null);
                return false;
            }
        } else if (!this.f12364e.canWrite()) {
            l(4, null);
            return false;
        }
        this.f12368i = true;
        return true;
    }

    @Nullable
    public final InputStream f(AssetManager assetManager) {
        try {
            return h(assetManager, this.f12366g);
        } catch (FileNotFoundException e11) {
            this.f12362c.a(6, e11);
            return null;
        } catch (IOException e12) {
            this.f12362c.a(7, e12);
            return null;
        }
    }

    public final /* synthetic */ void g(int i11, Object obj) {
        this.f12362c.a(i11, obj);
    }

    @Nullable
    public final InputStream h(AssetManager assetManager, String str) throws IOException {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e11) {
            String message = e11.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f12362c.b(5, null);
            }
            return null;
        }
    }

    @NonNull
    public b i() {
        b bVarB;
        c();
        if (this.f12363d == null) {
            return this;
        }
        InputStream inputStreamF = f(this.f12360a);
        if (inputStreamF != null) {
            this.f12369j = j(inputStreamF);
        }
        c6.c[] cVarArr = this.f12369j;
        return (cVarArr == null || !k() || (bVarB = b(cVarArr, this.f12363d)) == null) ? this : bVarB;
    }

    @Nullable
    public final c6.c[] j(InputStream inputStream) {
        try {
            try {
                try {
                    try {
                        c6.c[] cVarArrW = d.w(inputStream, d.o(inputStream, d.f12373a), this.f12365f);
                        try {
                            return cVarArrW;
                        } catch (IOException e11) {
                            return cVarArrW;
                        }
                    } catch (IOException e12) {
                        this.f12362c.a(7, e12);
                        return null;
                    }
                } catch (IllegalStateException e13) {
                    this.f12362c.a(8, e13);
                    inputStream.close();
                    return null;
                }
            } catch (IOException e14) {
                this.f12362c.a(7, e14);
                inputStream.close();
                return null;
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException e15) {
                this.f12362c.a(7, e15);
            }
        }
    }

    public final void l(final int i11, @Nullable final Object obj) {
        this.f12361b.execute(new Runnable() { // from class: c6.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f14633a.g(i11, obj);
            }
        });
    }

    @NonNull
    public b m() {
        c6.c[] cVarArr = this.f12369j;
        byte[] bArr = this.f12363d;
        if (cVarArr != null && bArr != null) {
            c();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    d.E(byteArrayOutputStream, bArr);
                    if (!d.B(byteArrayOutputStream, bArr, cVarArr)) {
                        this.f12362c.a(5, null);
                        this.f12369j = null;
                        byteArrayOutputStream.close();
                        return this;
                    }
                    this.f12370k = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    this.f12369j = null;
                } catch (Throwable th2) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (IOException e11) {
                this.f12362c.a(7, e11);
            } catch (IllegalStateException e12) {
                this.f12362c.a(8, e12);
            }
        }
        return this;
    }

    public boolean n() {
        byte[] bArr = this.f12370k;
        if (bArr == null) {
            return false;
        }
        c();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f12364e);
                    try {
                        c6.d.l(byteArrayInputStream, fileOutputStream);
                        l(1, null);
                        fileOutputStream.close();
                        byteArrayInputStream.close();
                        this.f12370k = null;
                        this.f12369j = null;
                        return true;
                    } catch (Throwable th2) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                        throw th2;
                    }
                } catch (Throwable th4) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th5) {
                        th4.addSuppressed(th5);
                    }
                    throw th4;
                }
            } catch (Throwable th6) {
                this.f12370k = null;
                this.f12369j = null;
                throw th6;
            }
        } catch (FileNotFoundException e11) {
            l(6, e11);
            this.f12370k = null;
            this.f12369j = null;
            return false;
        } catch (IOException e12) {
            l(7, e12);
            this.f12370k = null;
            this.f12369j = null;
            return false;
        }
    }
}
