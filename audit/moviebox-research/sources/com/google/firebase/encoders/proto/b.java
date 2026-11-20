package com.google.firebase.encoders.proto;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.encoders.EncodingException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import uk.c;
import uk.d;
import uk.e;
import xk.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b implements d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Charset f40596f = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final uk.b f40597g = uk.b.a("key").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final uk.b f40598h = uk.b.a(AppMeasurementSdk.ConditionalUserProperty.VALUE).b(com.google.firebase.encoders.proto.a.b().c(2).a()).a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c<Map.Entry<Object, Object>> f40599i = new c() { // from class: xk.c
        @Override // uk.c
        public final void a(Object obj, Object obj2) throws IOException {
            com.google.firebase.encoders.proto.b.v((Map.Entry) obj, (uk.d) obj2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OutputStream f40600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, c<?>> f40601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Class<?>, e<?>> f40602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c<Object> f40603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f40604e = new f(this);

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f40605a;

        static {
            int[] iArr = new int[Protobuf.IntEncoding.values().length];
            f40605a = iArr;
            try {
                iArr[Protobuf.IntEncoding.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40605a[Protobuf.IntEncoding.SIGNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40605a[Protobuf.IntEncoding.FIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public b(OutputStream outputStream, Map<Class<?>, c<?>> map, Map<Class<?>, e<?>> map2, c<Object> cVar) {
        this.f40600a = outputStream;
        this.f40601b = map;
        this.f40602c = map2;
        this.f40603d = cVar;
    }

    public static ByteBuffer o(int i11) {
        return ByteBuffer.allocate(i11).order(ByteOrder.LITTLE_ENDIAN);
    }

    public static Protobuf t(uk.b bVar) {
        Protobuf protobuf = (Protobuf) bVar.c(Protobuf.class);
        if (protobuf != null) {
            return protobuf;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    public static int u(uk.b bVar) {
        Protobuf protobuf = (Protobuf) bVar.c(Protobuf.class);
        if (protobuf != null) {
            return protobuf.tag();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    public static /* synthetic */ void v(Map.Entry entry, d dVar) throws IOException {
        dVar.a(f40597g, entry.getKey());
        dVar.a(f40598h, entry.getValue());
    }

    @Override // uk.d
    @NonNull
    public d a(@NonNull uk.b bVar, @Nullable Object obj) throws IOException {
        return n(bVar, obj, true);
    }

    @Override // uk.d
    @NonNull
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public b e(@NonNull uk.b bVar, int i11) throws IOException {
        return g(bVar, i11, true);
    }

    public b g(@NonNull uk.b bVar, int i11, boolean z11) throws IOException {
        if (z11 && i11 == 0) {
            return this;
        }
        Protobuf protobufT = t(bVar);
        int i12 = a.f40605a[protobufT.intEncoding().ordinal()];
        if (i12 == 1) {
            w(protobufT.tag() << 3);
            w(i11);
        } else if (i12 == 2) {
            w(protobufT.tag() << 3);
            w((i11 << 1) ^ (i11 >> 31));
        } else if (i12 == 3) {
            w((protobufT.tag() << 3) | 5);
            this.f40600a.write(o(4).putInt(i11).array());
        }
        return this;
    }

    @Override // uk.d
    @NonNull
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public b f(@NonNull uk.b bVar, long j11) throws IOException {
        return i(bVar, j11, true);
    }

    public b i(@NonNull uk.b bVar, long j11, boolean z11) throws IOException {
        if (z11 && j11 == 0) {
            return this;
        }
        Protobuf protobufT = t(bVar);
        int i11 = a.f40605a[protobufT.intEncoding().ordinal()];
        if (i11 == 1) {
            w(protobufT.tag() << 3);
            x(j11);
        } else if (i11 == 2) {
            w(protobufT.tag() << 3);
            x((j11 >> 63) ^ (j11 << 1));
        } else if (i11 == 3) {
            w((protobufT.tag() << 3) | 1);
            this.f40600a.write(o(8).putLong(j11).array());
        }
        return this;
    }

    @Override // uk.d
    @NonNull
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public b d(@NonNull uk.b bVar, boolean z11) throws IOException {
        return k(bVar, z11, true);
    }

    public b k(@NonNull uk.b bVar, boolean z11, boolean z12) throws IOException {
        return g(bVar, z11 ? 1 : 0, z12);
    }

    public d l(@NonNull uk.b bVar, double d11, boolean z11) throws IOException {
        if (z11 && d11 == 0.0d) {
            return this;
        }
        w((u(bVar) << 3) | 1);
        this.f40600a.write(o(8).putDouble(d11).array());
        return this;
    }

    public d m(@NonNull uk.b bVar, float f11, boolean z11) throws IOException {
        if (z11 && f11 == 0.0f) {
            return this;
        }
        w((u(bVar) << 3) | 5);
        this.f40600a.write(o(4).putFloat(f11).array());
        return this;
    }

    public d n(@NonNull uk.b bVar, @Nullable Object obj, boolean z11) throws IOException {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z11 && charSequence.length() == 0) {
                return this;
            }
            w((u(bVar) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f40596f);
            w(bytes.length);
            this.f40600a.write(bytes);
            return this;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                n(bVar, it.next(), false);
            }
            return this;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                q(f40599i, bVar, (Map.Entry) it2.next(), false);
            }
            return this;
        }
        if (obj instanceof Double) {
            return l(bVar, ((Double) obj).doubleValue(), z11);
        }
        if (obj instanceof Float) {
            return m(bVar, ((Float) obj).floatValue(), z11);
        }
        if (obj instanceof Number) {
            return i(bVar, ((Number) obj).longValue(), z11);
        }
        if (obj instanceof Boolean) {
            return k(bVar, ((Boolean) obj).booleanValue(), z11);
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z11 && bArr.length == 0) {
                return this;
            }
            w((u(bVar) << 3) | 2);
            w(bArr.length);
            this.f40600a.write(bArr);
            return this;
        }
        c<?> cVar = this.f40601b.get(obj.getClass());
        if (cVar != null) {
            return q(cVar, bVar, obj, z11);
        }
        e<?> eVar = this.f40602c.get(obj.getClass());
        if (eVar != null) {
            return r(eVar, bVar, obj, z11);
        }
        if (obj instanceof xk.b) {
            return e(bVar, ((xk.b) obj).getNumber());
        }
        return obj instanceof Enum ? e(bVar, ((Enum) obj).ordinal()) : q(this.f40603d, bVar, obj, z11);
    }

    public final <T> long p(c<T> cVar, T t11) throws IOException {
        xk.a aVar = new xk.a();
        try {
            OutputStream outputStream = this.f40600a;
            this.f40600a = aVar;
            try {
                cVar.a(t11, this);
                this.f40600a = outputStream;
                long jA = aVar.a();
                aVar.close();
                return jA;
            } catch (Throwable th2) {
                this.f40600a = outputStream;
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                aVar.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public final <T> b q(c<T> cVar, uk.b bVar, T t11, boolean z11) throws IOException {
        long jP = p(cVar, t11);
        if (z11 && jP == 0) {
            return this;
        }
        w((u(bVar) << 3) | 2);
        x(jP);
        cVar.a(t11, this);
        return this;
    }

    public final <T> b r(e<T> eVar, uk.b bVar, T t11, boolean z11) throws IOException {
        this.f40604e.d(bVar, z11);
        eVar.a(t11, this.f40604e);
        return this;
    }

    public b s(@Nullable Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        c<?> cVar = this.f40601b.get(obj.getClass());
        if (cVar != null) {
            cVar.a(obj, this);
            return this;
        }
        throw new EncodingException("No encoder for " + obj.getClass());
    }

    public final void w(int i11) throws IOException {
        while ((i11 & (-128)) != 0) {
            this.f40600a.write((i11 & 127) | 128);
            i11 >>>= 7;
        }
        this.f40600a.write(i11 & 127);
    }

    public final void x(long j11) throws IOException {
        while (((-128) & j11) != 0) {
            this.f40600a.write((((int) j11) & 127) | 128);
            j11 >>>= 7;
        }
        this.f40600a.write(((int) j11) & 127);
    }
}
