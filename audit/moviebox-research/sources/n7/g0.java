package n7;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class g0 implements Comparable<g0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.alibaba.fastjson.util.d f71611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f71612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f71613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f71614d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f71615f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f71616g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public p f71617h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f71618i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f71619j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f71620k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f71621l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f71622m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f71623n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f71624o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public a f71625p;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z0 f71626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<?> f71627b;

        public a(z0 z0Var, Class<?> cls) {
            this.f71626a = z0Var;
            this.f71627b = cls;
        }
    }

    public g0(Class<?> cls, com.alibaba.fastjson.util.d dVar) {
        boolean z11;
        j7.d dVar2;
        this.f71619j = false;
        this.f71620k = false;
        this.f71621l = false;
        this.f71623n = false;
        this.f71611a = dVar;
        this.f71617h = new p(cls, dVar);
        if (cls != null && (dVar2 = (j7.d) TypeUtils.N(cls, j7.d.class)) != null) {
            for (SerializerFeature serializerFeature : dVar2.serialzeFeatures()) {
                if (serializerFeature == SerializerFeature.WriteEnumUsingToString) {
                    this.f71619j = true;
                } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
                    this.f71620k = true;
                } else if (serializerFeature == SerializerFeature.DisableCircularReferenceDetect) {
                    this.f71621l = true;
                } else {
                    SerializerFeature serializerFeature2 = SerializerFeature.BrowserCompatible;
                    if (serializerFeature == serializerFeature2) {
                        this.f71613c |= serializerFeature2.mask;
                        this.f71624o = true;
                    } else {
                        SerializerFeature serializerFeature3 = SerializerFeature.WriteMapNullValue;
                        if (serializerFeature == serializerFeature3) {
                            this.f71613c |= serializerFeature3.mask;
                        }
                    }
                }
            }
        }
        dVar.q();
        this.f71614d = '\"' + dVar.f15532a + "\":";
        j7.b bVarD = dVar.d();
        if (bVarD != null) {
            SerializerFeature[] serializerFeatureArrSerialzeFeatures = bVarD.serialzeFeatures();
            int length = serializerFeatureArrSerialzeFeatures.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    z11 = false;
                    break;
                } else {
                    if ((serializerFeatureArrSerialzeFeatures[i11].getMask() & SerializerFeature.WRITE_MAP_NULL_FEATURES) != 0) {
                        z11 = true;
                        break;
                    }
                    i11++;
                }
            }
            String str = bVarD.format();
            this.f71618i = str;
            if (str.trim().length() == 0) {
                this.f71618i = null;
            }
            for (SerializerFeature serializerFeature4 : bVarD.serialzeFeatures()) {
                if (serializerFeature4 == SerializerFeature.WriteEnumUsingToString) {
                    this.f71619j = true;
                } else if (serializerFeature4 == SerializerFeature.WriteEnumUsingName) {
                    this.f71620k = true;
                } else if (serializerFeature4 == SerializerFeature.DisableCircularReferenceDetect) {
                    this.f71621l = true;
                } else if (serializerFeature4 == SerializerFeature.BrowserCompatible) {
                    this.f71624o = true;
                }
            }
            this.f71613c = SerializerFeature.of(bVarD.serialzeFeatures()) | this.f71613c;
        } else {
            z11 = false;
        }
        this.f71612b = z11;
        this.f71623n = TypeUtils.n0(dVar.f15533b) || TypeUtils.m0(dVar.f15533b);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(g0 g0Var) {
        return this.f71611a.compareTo(g0Var.f71611a);
    }

    public Object b(Object obj) throws IllegalAccessException, InvocationTargetException {
        Object objC = this.f71611a.c(obj);
        if (this.f71618i == null || objC == null) {
            return objC;
        }
        Class<?> cls = this.f71611a.f15536f;
        if (cls != Date.class && cls != java.sql.Date.class) {
            return objC;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.f71618i, com.alibaba.fastjson.a.defaultLocale);
        simpleDateFormat.setTimeZone(com.alibaba.fastjson.a.defaultTimeZone);
        return simpleDateFormat.format(objC);
    }

    public Object c(Object obj) throws IllegalAccessException, InvocationTargetException {
        Object objC = this.f71611a.c(obj);
        if (!this.f71623n || TypeUtils.q0(objC)) {
            return objC;
        }
        return null;
    }

    public void d(o0 o0Var) throws IOException {
        j1 j1Var = o0Var.f71701k;
        if (!j1Var.f71677g) {
            if (this.f71616g == null) {
                this.f71616g = this.f71611a.f15532a + ":";
            }
            j1Var.write(this.f71616g);
            return;
        }
        if (!SerializerFeature.isEnabled(j1Var.f71674c, this.f71611a.f15540j, SerializerFeature.UseSingleQuotes)) {
            j1Var.write(this.f71614d);
            return;
        }
        if (this.f71615f == null) {
            this.f71615f = '\'' + this.f71611a.f15532a + "':";
        }
        j1Var.write(this.f71615f);
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0082  */
    public void e(o0 o0Var, Object obj) throws Exception {
        Class<?> cls;
        Class<?> cls2;
        z0 z0VarX;
        if (this.f71625p == null) {
            if (obj == null) {
                cls2 = this.f71611a.f15536f;
                if (cls2 == Byte.TYPE) {
                    cls2 = Byte.class;
                } else if (cls2 == Short.TYPE) {
                    cls2 = Short.class;
                } else if (cls2 == Integer.TYPE) {
                    cls2 = Integer.class;
                } else if (cls2 == Long.TYPE) {
                    cls2 = Long.class;
                } else if (cls2 == Float.TYPE) {
                    cls2 = Float.class;
                } else if (cls2 == Double.TYPE) {
                    cls2 = Double.class;
                } else if (cls2 == Boolean.TYPE) {
                    cls2 = Boolean.class;
                }
            } else {
                cls2 = obj.getClass();
            }
            j7.b bVarD = this.f71611a.d();
            if (bVarD == null || bVarD.serializeUsing() == Void.class) {
                if (this.f71618i == null) {
                    z0VarX = null;
                } else if (cls2 == Double.TYPE || cls2 == Double.class) {
                    z0VarX = new d0(this.f71618i);
                } else if (cls2 == Float.TYPE || cls2 == Float.class) {
                    z0VarX = new h0(this.f71618i);
                } else {
                    z0VarX = null;
                }
                if (z0VarX == null) {
                    z0VarX = o0Var.x(cls2);
                }
            } else {
                z0VarX = (z0) bVarD.serializeUsing().newInstance();
                this.f71622m = true;
            }
            this.f71625p = new a(z0VarX, cls2);
        }
        a aVar = this.f71625p;
        int i11 = (this.f71621l ? this.f71611a.f15540j | SerializerFeature.DisableCircularReferenceDetect.mask : this.f71611a.f15540j) | this.f71613c;
        if (obj == null) {
            j1 j1Var = o0Var.f71701k;
            if (this.f71611a.f15536f == Object.class && j1Var.j(SerializerFeature.WRITE_MAP_NULL_FEATURES)) {
                j1Var.g0();
                return;
            }
            Class<?> cls3 = aVar.f71627b;
            if (Number.class.isAssignableFrom(cls3)) {
                j1Var.h0(this.f71613c, SerializerFeature.WriteNullNumberAsZero.mask);
                return;
            }
            if (String.class == cls3) {
                j1Var.h0(this.f71613c, SerializerFeature.WriteNullStringAsEmpty.mask);
                return;
            }
            if (Boolean.class == cls3) {
                j1Var.h0(this.f71613c, SerializerFeature.WriteNullBooleanAsFalse.mask);
                return;
            }
            if (Collection.class.isAssignableFrom(cls3) || cls3.isArray()) {
                j1Var.h0(this.f71613c, SerializerFeature.WriteNullListAsEmpty.mask);
                return;
            }
            z0 z0Var = aVar.f71626a;
            if (j1Var.j(SerializerFeature.WRITE_MAP_NULL_FEATURES) && (z0Var instanceof p0)) {
                j1Var.g0();
                return;
            } else {
                com.alibaba.fastjson.util.d dVar = this.f71611a;
                z0Var.d(o0Var, null, dVar.f15532a, dVar.f15537g, i11);
                return;
            }
        }
        if (this.f71611a.f15548r) {
            if (this.f71620k) {
                o0Var.f71701k.j0(((Enum) obj).name());
                return;
            } else if (this.f71619j) {
                o0Var.f71701k.j0(((Enum) obj).toString());
                return;
            }
        }
        Class<?> cls4 = obj.getClass();
        z0 z0VarX2 = (cls4 == aVar.f71627b || this.f71622m) ? aVar.f71626a : o0Var.x(cls4);
        String str = this.f71618i;
        if (str != null && !(z0VarX2 instanceof d0) && !(z0VarX2 instanceof h0)) {
            if (z0VarX2 instanceof a0) {
                ((a0) z0VarX2).c(o0Var, obj, this.f71617h);
                return;
            } else {
                o0Var.N(obj, str);
                return;
            }
        }
        com.alibaba.fastjson.util.d dVar2 = this.f71611a;
        if (dVar2.f15550t) {
            if (z0VarX2 instanceof p0) {
                ((p0) z0VarX2).A(o0Var, obj, dVar2.f15532a, dVar2.f15537g, i11, true);
                return;
            } else if (z0VarX2 instanceof v0) {
                ((v0) z0VarX2).q(o0Var, obj, dVar2.f15532a, dVar2.f15537g, i11, true);
                return;
            }
        }
        if ((this.f71613c & SerializerFeature.WriteClassName.mask) != 0 && cls4 != dVar2.f15536f && (z0VarX2 instanceof p0)) {
            ((p0) z0VarX2).A(o0Var, obj, dVar2.f15532a, dVar2.f15537g, i11, false);
            return;
        }
        if (this.f71624o && ((cls = dVar2.f15536f) == Long.TYPE || cls == Long.class)) {
            long jLongValue = ((Long) obj).longValue();
            if (jLongValue > 9007199254740991L || jLongValue < -9007199254740991L) {
                o0Var.y().j0(Long.toString(jLongValue));
                return;
            }
        }
        com.alibaba.fastjson.util.d dVar3 = this.f71611a;
        z0VarX2.d(o0Var, obj, dVar3.f15532a, dVar3.f15537g, i11);
    }
}
