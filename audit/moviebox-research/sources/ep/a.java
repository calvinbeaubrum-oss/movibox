package ep;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a implements Interceptor {
    @Override // okhttp3.Interceptor
    @NonNull
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl httpUrlUrl = request.url();
        Request.Builder builderNewBuilder = request.newBuilder();
        List<String> listHeaders = request.headers("multiple_base_url");
        if (!listHeaders.isEmpty()) {
            builderNewBuilder.removeHeader("multiple_base_url");
            String str = listHeaders.get(0);
            HttpUrl httpUrl = !TextUtils.isEmpty(str) ? HttpUrl.parse(str) : httpUrlUrl;
            if (httpUrl != null) {
                return chain.proceed(builderNewBuilder.url(httpUrlUrl.newBuilder().scheme("https").host(httpUrl.host()).port(httpUrl.port()).build()).build());
            }
        }
        return chain.proceed(request);
    }
}
