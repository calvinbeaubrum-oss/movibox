package x30;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class b<T> implements i<T, RequestBody> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MediaType f79885c = MediaType.get("application/json; charset=UTF-8");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f79886d = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f79887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeAdapter<T> f79888b;

    public b(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f79887a = gson;
        this.f79888b = typeAdapter;
    }

    @Override // retrofit2.i
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RequestBody a(T t11) throws IOException {
        Buffer buffer = new Buffer();
        JsonWriter jsonWriterNewJsonWriter = this.f79887a.newJsonWriter(new OutputStreamWriter(buffer.outputStream(), f79886d));
        this.f79888b.write(jsonWriterNewJsonWriter, t11);
        jsonWriterNewJsonWriter.close();
        return RequestBody.create(f79885c, buffer.readByteString());
    }
}
