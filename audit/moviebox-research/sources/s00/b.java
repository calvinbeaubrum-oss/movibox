package s00;

import androidx.annotation.NonNull;
import com.google.gson.JsonObject;
import y00.h;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f75919a;

    public b(h hVar) {
        this.f75919a = hVar;
    }

    @Override // s00.a
    public String[] a() {
        this.f75919a.a(y00.a.b(2, null, null, 1));
        return new String[0];
    }

    @Override // s00.a
    public String[] b(@NonNull String[] strArr) {
        this.f75919a.a(y00.a.b(3, null, strArr, 0));
        this.f75919a.a(y00.a.b(1, null, strArr, 1));
        return new String[0];
    }

    @Override // s00.a
    public void c(JsonObject jsonObject) {
        this.f75919a.a(y00.a.b(0, jsonObject.toString(), null, 1));
    }

    @Override // s00.a
    public void d(String[] strArr) {
    }
}
