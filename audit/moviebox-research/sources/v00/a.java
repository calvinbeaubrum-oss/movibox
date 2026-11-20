package v00;

import androidx.annotation.NonNull;
import com.vungle.warren.network.VungleApi;
import java.util.List;
import okhttp3.Call;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Call.Factory f78676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HttpUrl f78677b;

    public a(@NonNull Call.Factory factory, @NonNull String str) {
        HttpUrl httpUrl = HttpUrl.get(str);
        this.f78677b = httpUrl;
        this.f78676a = factory;
        List<String> listPathSegments = httpUrl.pathSegments();
        if ("".equals(listPathSegments.get(listPathSegments.size() - 1))) {
            return;
        }
        throw new IllegalArgumentException("baseUrl must end in /: " + str);
    }

    @NonNull
    public VungleApi a(String str) {
        f fVar = new f(this.f78677b, this.f78676a);
        fVar.d(str);
        return fVar;
    }
}
