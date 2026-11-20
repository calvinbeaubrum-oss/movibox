package bp;

import android.text.TextUtils;
import com.blankj.utilcode.util.n;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.lang.reflect.Type;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import retrofit2.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class c<T> implements i<ResponseBody, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f14301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14302b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f14304d = "{\"code\":200005,\"data\":{},\"msg\":\"unknown error\"}";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Gson f14303c = new Gson();

    public c(Type type, String str) {
        this.f14301a = type;
        this.f14302b = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.lang.String] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // retrofit2.i
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public T a(ResponseBody responseBody) throws IOException {
        BufferedSource bufferedSourceBuffer = Okio.buffer(responseBody.source());
        ?? r11 = (T) bufferedSourceBuffer.readUtf8();
        uo.b.f78622a.c("HttpTag", "Converter origin json:" + ((String) r11), false);
        bufferedSourceBuffer.close();
        if (TextUtils.equals(this.f14302b, "1311")) {
            return r11;
        }
        try {
            return (T) n.e(r11, this.f14301a);
        } catch (JsonSyntaxException e11) {
            uo.b.f78622a.h("HttpTag", "error =" + e11.getMessage() + "json= " + ((String) r11), true);
            return (T) this.f14303c.fromJson((String) r11, this.f14301a);
        }
    }
}
