package xk;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.EncodingException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, uk.c<?>> f80577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, uk.e<?>> f80578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final uk.c<Object> f80579c;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements vk.b<a> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final uk.c<Object> f80580d = new uk.c() { // from class: xk.d
            @Override // uk.c
            public final void a(Object obj, Object obj2) throws IOException {
                e.a.e(obj, (uk.d) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<Class<?>, uk.c<?>> f80581a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<Class<?>, uk.e<?>> f80582b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public uk.c<Object> f80583c = f80580d;

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void e(Object obj, uk.d dVar) throws IOException {
            throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }

        public e c() {
            return new e(new HashMap(this.f80581a), new HashMap(this.f80582b), this.f80583c);
        }

        @NonNull
        public a d(@NonNull vk.a aVar) {
            aVar.a(this);
            return this;
        }

        @Override // vk.b
        @NonNull
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public <U> a a(@NonNull Class<U> cls, @NonNull uk.c<? super U> cVar) {
            this.f80581a.put(cls, cVar);
            this.f80582b.remove(cls);
            return this;
        }
    }

    public e(Map<Class<?>, uk.c<?>> map, Map<Class<?>, uk.e<?>> map2, uk.c<Object> cVar) {
        this.f80577a = map;
        this.f80578b = map2;
        this.f80579c = cVar;
    }

    public static a a() {
        return new a();
    }

    public void b(@NonNull Object obj, @NonNull OutputStream outputStream) throws IOException {
        new com.google.firebase.encoders.proto.b(outputStream, this.f80577a, this.f80578b, this.f80579c).s(obj);
    }

    @NonNull
    public byte[] c(@NonNull Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            b(obj, byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
