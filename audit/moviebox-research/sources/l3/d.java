package l3;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
public class d extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f69770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Uri f69771c;

    public d(@Nullable a aVar, Context context, Uri uri) {
        super(aVar);
        this.f69770b = context;
        this.f69771c = uri;
    }

    public static void m(@Nullable AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e11) {
                throw e11;
            } catch (Exception unused) {
            }
        }
    }

    @Nullable
    public static Uri n(Context context, Uri uri, String str, String str2) {
        try {
            return DocumentsContract.createDocument(context.getContentResolver(), uri, str, str2);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // l3.a
    public boolean a() {
        return b.a(this.f69770b, this.f69771c);
    }

    @Override // l3.a
    @Nullable
    public a b(String str) {
        Uri uriN = n(this.f69770b, this.f69771c, "vnd.android.document/directory", str);
        if (uriN != null) {
            return new d(this, this.f69770b, uriN);
        }
        return null;
    }

    @Override // l3.a
    @Nullable
    public a c(String str, String str2) {
        Uri uriN = n(this.f69770b, this.f69771c, str, str2);
        if (uriN != null) {
            return new d(this, this.f69770b, uriN);
        }
        return null;
    }

    @Override // l3.a
    public boolean d() {
        try {
            return DocumentsContract.deleteDocument(this.f69770b.getContentResolver(), this.f69771c);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // l3.a
    public boolean e() {
        return b.c(this.f69770b, this.f69771c);
    }

    @Override // l3.a
    @Nullable
    public String i() {
        return b.d(this.f69770b, this.f69771c);
    }

    @Override // l3.a
    public Uri j() {
        return this.f69771c;
    }

    @Override // l3.a
    public long k() {
        return b.f(this.f69770b, this.f69771c);
    }

    @Override // l3.a
    public a[] l() {
        ContentResolver contentResolver = this.f69770b.getContentResolver();
        Uri uri = this.f69771c;
        Uri uriBuildChildDocumentsUriUsingTree = DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri));
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = contentResolver.query(uriBuildChildDocumentsUriUsingTree, new String[]{"document_id"}, null, null, null);
                while (cursorQuery.moveToNext()) {
                    arrayList.add(DocumentsContract.buildDocumentUriUsingTree(this.f69771c, cursorQuery.getString(0)));
                }
            } catch (Exception e11) {
                Log.w("DocumentFile", "Failed query: " + e11);
            }
            m(cursorQuery);
            Uri[] uriArr = (Uri[]) arrayList.toArray(new Uri[arrayList.size()]);
            a[] aVarArr = new a[uriArr.length];
            for (int i11 = 0; i11 < uriArr.length; i11++) {
                aVarArr[i11] = new d(this, this.f69770b, uriArr[i11]);
            }
            return aVarArr;
        } catch (Throwable th2) {
            m(cursorQuery);
            throw th2;
        }
    }
}
