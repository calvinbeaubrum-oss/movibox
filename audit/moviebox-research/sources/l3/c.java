package l3;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(19)
public class c extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f69768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Uri f69769c;

    public c(@Nullable a aVar, Context context, Uri uri) {
        super(aVar);
        this.f69768b = context;
        this.f69769c = uri;
    }

    @Override // l3.a
    public boolean a() {
        return b.a(this.f69768b, this.f69769c);
    }

    @Override // l3.a
    public a b(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // l3.a
    public a c(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    @Override // l3.a
    public boolean d() {
        try {
            return DocumentsContract.deleteDocument(this.f69768b.getContentResolver(), this.f69769c);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // l3.a
    public boolean e() {
        return b.c(this.f69768b, this.f69769c);
    }

    @Override // l3.a
    @Nullable
    public String i() {
        return b.d(this.f69768b, this.f69769c);
    }

    @Override // l3.a
    public Uri j() {
        return this.f69769c;
    }

    @Override // l3.a
    public long k() {
        return b.f(this.f69768b, this.f69769c);
    }

    @Override // l3.a
    public a[] l() {
        throw new UnsupportedOperationException();
    }
}
