package wk;

import android.util.Base64;
import android.util.JsonWriter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.EncodingException;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import uk.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class e implements uk.d, f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f79544a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f79545b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JsonWriter f79546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Class<?>, uk.c<?>> f79547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Class<?>, uk.e<?>> f79548e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final uk.c<Object> f79549f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f79550g;

    public e(@NonNull Writer writer, @NonNull Map<Class<?>, uk.c<?>> map, @NonNull Map<Class<?>, uk.e<?>> map2, uk.c<Object> cVar, boolean z11) {
        this.f79546c = new JsonWriter(writer);
        this.f79547d = map;
        this.f79548e = map2;
        this.f79549f = cVar;
        this.f79550g = z11;
    }

    @Override // uk.d
    @NonNull
    public uk.d a(@NonNull uk.b bVar, @Nullable Object obj) throws IOException {
        return m(bVar.b(), obj);
    }

    @Override // uk.d
    @NonNull
    public uk.d d(@NonNull uk.b bVar, boolean z11) throws IOException {
        return n(bVar.b(), z11);
    }

    @Override // uk.d
    @NonNull
    public uk.d e(@NonNull uk.b bVar, int i11) throws IOException {
        return k(bVar.b(), i11);
    }

    @Override // uk.d
    @NonNull
    public uk.d f(@NonNull uk.b bVar, long j11) throws IOException {
        return l(bVar.b(), j11);
    }

    @NonNull
    public e g(int i11) throws IOException {
        v();
        this.f79546c.value(i11);
        return this;
    }

    @NonNull
    public e h(long j11) throws IOException {
        v();
        this.f79546c.value(j11);
        return this;
    }

    @NonNull
    public e i(@Nullable Object obj, boolean z11) throws IOException {
        int i11 = 0;
        if (z11 && q(obj)) {
            Object[] objArr = new Object[1];
            objArr[0] = obj == null ? null : obj.getClass();
            throw new EncodingException(String.format("%s cannot be encoded inline", objArr));
        }
        if (obj == null) {
            this.f79546c.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            this.f79546c.value((Number) obj);
            return this;
        }
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                this.f79546c.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    i(it.next(), false);
                }
                this.f79546c.endArray();
                return this;
            }
            if (obj instanceof Map) {
                this.f79546c.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        m((String) key, entry.getValue());
                    } catch (ClassCastException e11) {
                        throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e11);
                    }
                }
                this.f79546c.endObject();
                return this;
            }
            uk.c<?> cVar = this.f79547d.get(obj.getClass());
            if (cVar != null) {
                return s(cVar, obj, z11);
            }
            uk.e<?> eVar = this.f79548e.get(obj.getClass());
            if (eVar != null) {
                eVar.a(obj, this);
                return this;
            }
            if (!(obj instanceof Enum)) {
                return s(this.f79549f, obj, z11);
            }
            b(((Enum) obj).name());
            return this;
        }
        if (obj instanceof byte[]) {
            return p((byte[]) obj);
        }
        this.f79546c.beginArray();
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int length = iArr.length;
            while (i11 < length) {
                this.f79546c.value(iArr[i11]);
                i11++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i11 < length2) {
                h(jArr[i11]);
                i11++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i11 < length3) {
                this.f79546c.value(dArr[i11]);
                i11++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i11 < length4) {
                this.f79546c.value(zArr[i11]);
                i11++;
            }
        } else if (obj instanceof Number[]) {
            for (Number number : (Number[]) obj) {
                i(number, false);
            }
        } else {
            for (Object obj2 : (Object[]) obj) {
                i(obj2, false);
            }
        }
        this.f79546c.endArray();
        return this;
    }

    @Override // uk.f
    @NonNull
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public e b(@Nullable String str) throws IOException {
        v();
        this.f79546c.value(str);
        return this;
    }

    @NonNull
    public e k(@NonNull String str, int i11) throws IOException {
        v();
        this.f79546c.name(str);
        return g(i11);
    }

    @NonNull
    public e l(@NonNull String str, long j11) throws IOException {
        v();
        this.f79546c.name(str);
        return h(j11);
    }

    @NonNull
    public e m(@NonNull String str, @Nullable Object obj) throws IOException {
        return this.f79550g ? u(str, obj) : t(str, obj);
    }

    @NonNull
    public e n(@NonNull String str, boolean z11) throws IOException {
        v();
        this.f79546c.name(str);
        return c(z11);
    }

    @Override // uk.f
    @NonNull
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public e c(boolean z11) throws IOException {
        v();
        this.f79546c.value(z11);
        return this;
    }

    @NonNull
    public e p(@Nullable byte[] bArr) throws IOException {
        v();
        if (bArr == null) {
            this.f79546c.nullValue();
        } else {
            this.f79546c.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    public final boolean q(Object obj) {
        return obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number);
    }

    public void r() throws IOException {
        v();
        this.f79546c.flush();
    }

    public e s(uk.c<Object> cVar, Object obj, boolean z11) throws IOException {
        if (!z11) {
            this.f79546c.beginObject();
        }
        cVar.a(obj, this);
        if (!z11) {
            this.f79546c.endObject();
        }
        return this;
    }

    public final e t(@NonNull String str, @Nullable Object obj) throws EncodingException, IOException {
        v();
        this.f79546c.name(str);
        if (obj != null) {
            return i(obj, false);
        }
        this.f79546c.nullValue();
        return this;
    }

    public final e u(@NonNull String str, @Nullable Object obj) throws EncodingException, IOException {
        if (obj == null) {
            return this;
        }
        v();
        this.f79546c.name(str);
        return i(obj, false);
    }

    public final void v() throws IOException {
        if (!this.f79545b) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
        e eVar = this.f79544a;
        if (eVar != null) {
            eVar.v();
            this.f79544a.f79545b = false;
            this.f79544a = null;
            this.f79546c.endObject();
        }
    }
}
