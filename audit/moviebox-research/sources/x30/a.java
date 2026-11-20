package x30;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.c0;
import retrofit2.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a extends i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f79884a;

    public a(Gson gson) {
        this.f79884a = gson;
    }

    public static a f() {
        return g(new Gson());
    }

    public static a g(Gson gson) {
        if (gson != null) {
            return new a(gson);
        }
        throw new NullPointerException("gson == null");
    }

    @Override // retrofit2.i.a
    public i<?, RequestBody> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, c0 c0Var) {
        return new b(this.f79884a, this.f79884a.getAdapter(TypeToken.get(type)));
    }

    @Override // retrofit2.i.a
    public i<ResponseBody, ?> d(Type type, Annotation[] annotationArr, c0 c0Var) {
        return new c(this.f79884a, this.f79884a.getAdapter(TypeToken.get(type)));
    }
}
