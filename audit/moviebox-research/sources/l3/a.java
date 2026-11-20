package l3;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final a f69767a;

    public a(@Nullable a aVar) {
        this.f69767a = aVar;
    }

    @Nullable
    public static a g(@NonNull Context context, @NonNull Uri uri) {
        return new c(null, context, uri);
    }

    @Nullable
    public static a h(@NonNull Context context, @NonNull Uri uri) {
        return new d(null, context, DocumentsContract.buildDocumentUriUsingTree(uri, DocumentsContract.getTreeDocumentId(uri)));
    }

    public abstract boolean a();

    @Nullable
    public abstract a b(@NonNull String str);

    @Nullable
    public abstract a c(@NonNull String str, @NonNull String str2);

    public abstract boolean d();

    public abstract boolean e();

    @Nullable
    public a f(@NonNull String str) {
        for (a aVar : l()) {
            if (str.equals(aVar.i())) {
                return aVar;
            }
        }
        return null;
    }

    @Nullable
    public abstract String i();

    @NonNull
    public abstract Uri j();

    public abstract long k();

    @NonNull
    public abstract a[] l();
}
