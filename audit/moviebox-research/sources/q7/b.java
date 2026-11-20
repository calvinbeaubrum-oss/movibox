package q7;

import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import n7.h1;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@Produces({"*/*"})
@Provider
@Consumes({"*/*"})
public class b implements MessageBodyReader<Object>, MessageBodyWriter<Object> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Class<?>[] f74445f = {InputStream.class, Reader.class};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Class<?>[] f74446g = {InputStream.class, OutputStream.class, Writer.class, StreamingOutput.class, Response.class};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public Charset f74447a = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public SerializerFeature[] f74448b = new SerializerFeature[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public h1[] f74449c = new h1[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p7.a f74450d = new p7.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Class<?>[] f74451e = null;
}
