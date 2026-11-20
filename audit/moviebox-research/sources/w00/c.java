package w00;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.IOException;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class c implements a<ResponseBody, JsonObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f79146a = new GsonBuilder().create();

    @Override // w00.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public JsonObject a(ResponseBody responseBody) throws IOException {
        try {
            return (JsonObject) f79146a.fromJson(responseBody.string(), JsonObject.class);
        } finally {
            responseBody.close();
        }
    }
}
