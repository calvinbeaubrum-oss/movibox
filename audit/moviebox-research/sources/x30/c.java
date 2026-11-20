package x30;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class c<T> implements i<ResponseBody, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f79889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeAdapter<T> f79890b;

    public c(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f79889a = gson;
        this.f79890b = typeAdapter;
    }

    @Override // retrofit2.i
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public T a(ResponseBody responseBody) throws IOException {
        JsonReader jsonReaderNewJsonReader = this.f79889a.newJsonReader(responseBody.charStream());
        try {
            T t11 = this.f79890b.read2(jsonReaderNewJsonReader);
            if (jsonReaderNewJsonReader.peek() != JsonToken.END_DOCUMENT) {
                throw new JsonIOException("JSON document was not fully consumed.");
            }
            responseBody.close();
            return t11;
        } catch (Throwable th2) {
            responseBody.close();
            throw th2;
        }
    }
}
