package wk;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.EncodingException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import uk.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d implements vk.b<d> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final uk.c<Object> f79534e = new uk.c() { // from class: wk.a
        @Override // uk.c
        public final void a(Object obj, Object obj2) throws IOException {
            d.l(obj, (uk.d) obj2);
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final uk.e<String> f79535f = new uk.e() { // from class: wk.b
        @Override // uk.e
        public final void a(Object obj, Object obj2) throws IOException {
            ((f) obj2).b((String) obj);
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final uk.e<Boolean> f79536g = new uk.e() { // from class: wk.c
        @Override // uk.e
        public final void a(Object obj, Object obj2) throws IOException {
            d.n((Boolean) obj, (f) obj2);
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f79537h = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, uk.c<?>> f79538a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, uk.e<?>> f79539b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public uk.c<Object> f79540c = f79534e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f79541d = false;

    /* JADX INFO: compiled from: source.java */
    public class a implements uk.a {
        public a() {
        }

        @Override // uk.a
        public void a(@NonNull Object obj, @NonNull Writer writer) throws IOException {
            e eVar = new e(writer, d.this.f79538a, d.this.f79539b, d.this.f79540c, d.this.f79541d);
            eVar.i(obj, false);
            eVar.r();
        }

        @Override // uk.a
        public String b(@NonNull Object obj) {
            StringWriter stringWriter = new StringWriter();
            try {
                a(obj, stringWriter);
            } catch (IOException unused) {
            }
            return stringWriter.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements uk.e<Date> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DateFormat f79543a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f79543a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // uk.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NonNull Date date, @NonNull f fVar) throws IOException {
            fVar.b(f79543a.format(date));
        }
    }

    public d() {
        p(String.class, f79535f);
        p(Boolean.class, f79536g);
        p(Date.class, f79537h);
    }

    public static /* synthetic */ void l(Object obj, uk.d dVar) throws IOException {
        throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    public static /* synthetic */ void n(Boolean bool, f fVar) throws IOException {
        fVar.c(bool.booleanValue());
    }

    @NonNull
    public uk.a i() {
        return new a();
    }

    @NonNull
    public d j(@NonNull vk.a aVar) {
        aVar.a(this);
        return this;
    }

    @NonNull
    public d k(boolean z11) {
        this.f79541d = z11;
        return this;
    }

    @Override // vk.b
    @NonNull
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public <T> d a(@NonNull Class<T> cls, @NonNull uk.c<? super T> cVar) {
        this.f79538a.put(cls, cVar);
        this.f79539b.remove(cls);
        return this;
    }

    @NonNull
    public <T> d p(@NonNull Class<T> cls, @NonNull uk.e<? super T> eVar) {
        this.f79539b.put(cls, eVar);
        this.f79538a.remove(cls);
        return this;
    }
}
