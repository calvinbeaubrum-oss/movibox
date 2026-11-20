package e7;

import android.content.Context;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.h;
import com.airbnb.lottie.network.FileExtension;
import com.airbnb.lottie.q0;
import com.airbnb.lottie.r;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final f f64061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final e f64062b;

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f64063a;

        static {
            int[] iArr = new int[FileExtension.values().length];
            f64063a = iArr;
            try {
                iArr[FileExtension.ZIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f64063a[FileExtension.GZIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public g(@Nullable f fVar, @NonNull e eVar) {
        this.f64061a = fVar;
        this.f64062b = eVar;
    }

    @Nullable
    public final h a(Context context, @NonNull String str, @Nullable String str2) {
        f fVar;
        Pair<FileExtension, InputStream> pairA;
        q0<h> q0VarC;
        if (str2 == null || (fVar = this.f64061a) == null || (pairA = fVar.a(str)) == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) pairA.first;
        InputStream inputStream = (InputStream) pairA.second;
        int i11 = a.f64063a[fileExtension.ordinal()];
        if (i11 == 1) {
            q0VarC = r.C(context, new ZipInputStream(inputStream), str2);
        } else if (i11 != 2) {
            q0VarC = r.q(inputStream, str2);
        } else {
            try {
                q0VarC = r.q(new GZIPInputStream(inputStream), str2);
            } catch (IOException e11) {
                q0VarC = new q0<>(e11);
            }
        }
        if (q0VarC.b() != null) {
            return q0VarC.b();
        }
        return null;
    }

    @NonNull
    public final q0<h> b(Context context, @NonNull String str, @Nullable String str2) {
        g7.f.a("Fetching " + str);
        Closeable closeable = null;
        try {
            try {
                c cVarA = this.f64062b.a(str);
                if (!cVarA.isSuccessful()) {
                    q0<h> q0Var = new q0<>(new IllegalArgumentException(cVarA.error()));
                    try {
                        cVarA.close();
                    } catch (IOException e11) {
                        g7.f.d("LottieFetchResult close failed ", e11);
                    }
                    return q0Var;
                }
                q0<h> q0VarE = e(context, str, cVarA.M(), cVarA.z(), str2);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Completed fetch from network. Success: ");
                sb2.append(q0VarE.b() != null);
                g7.f.a(sb2.toString());
                try {
                    cVarA.close();
                } catch (IOException e12) {
                    g7.f.d("LottieFetchResult close failed ", e12);
                }
                return q0VarE;
            } catch (Exception e13) {
                q0<h> q0Var2 = new q0<>(e13);
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (IOException e14) {
                        g7.f.d("LottieFetchResult close failed ", e14);
                    }
                }
                return q0Var2;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                try {
                    closeable.close();
                } catch (IOException e15) {
                    g7.f.d("LottieFetchResult close failed ", e15);
                }
            }
            throw th2;
        }
    }

    @NonNull
    public q0<h> c(Context context, @NonNull String str, @Nullable String str2) {
        h hVarA = a(context, str, str2);
        if (hVarA != null) {
            return new q0<>(hVarA);
        }
        g7.f.a("Animation for " + str + " not found in cache. Fetching from network.");
        return b(context, str, str2);
    }

    @NonNull
    public final q0<h> d(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        f fVar;
        return (str2 == null || (fVar = this.f64061a) == null) ? r.q(new GZIPInputStream(inputStream), null) : r.q(new GZIPInputStream(new FileInputStream(fVar.g(str, inputStream, FileExtension.GZIP))), str);
    }

    @NonNull
    public final q0<h> e(Context context, @NonNull String str, @NonNull InputStream inputStream, @Nullable String str2, @Nullable String str3) throws IOException {
        q0<h> q0VarG;
        FileExtension fileExtension;
        f fVar;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            g7.f.a("Handling zip response.");
            FileExtension fileExtension2 = FileExtension.ZIP;
            q0VarG = g(context, str, inputStream, str3);
            fileExtension = fileExtension2;
        } else if (str2.contains("application/gzip") || str2.contains("application/x-gzip") || str.split("\\?")[0].endsWith(".tgs")) {
            g7.f.a("Handling gzip response.");
            fileExtension = FileExtension.GZIP;
            q0VarG = d(str, inputStream, str3);
        } else {
            g7.f.a("Received json response.");
            fileExtension = FileExtension.JSON;
            q0VarG = f(str, inputStream, str3);
        }
        if (str3 != null && q0VarG.b() != null && (fVar = this.f64061a) != null) {
            fVar.f(str, fileExtension);
        }
        return q0VarG;
    }

    @NonNull
    public final q0<h> f(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        f fVar;
        return (str2 == null || (fVar = this.f64061a) == null) ? r.q(inputStream, null) : r.q(new FileInputStream(fVar.g(str, inputStream, FileExtension.JSON).getAbsolutePath()), str);
    }

    @NonNull
    public final q0<h> g(Context context, @NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        f fVar;
        return (str2 == null || (fVar = this.f64061a) == null) ? r.C(context, new ZipInputStream(inputStream), null) : r.C(context, new ZipInputStream(new FileInputStream(fVar.g(str, inputStream, FileExtension.ZIP))), str);
    }
}
