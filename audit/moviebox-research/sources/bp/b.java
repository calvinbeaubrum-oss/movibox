package bp;

import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b<T> implements i<T, RequestBody> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MediaType f14300a = MediaType.parse("application/json; charset=UTF-8");

    @Override // retrofit2.i
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RequestBody a(T t11) throws IOException {
        return RequestBody.create(f14300a, com.alibaba.fastjson.a.toJSONBytes(t11, new SerializerFeature[0]));
    }
}
