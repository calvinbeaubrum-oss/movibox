package l7;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.asm.TypeCollector;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.AccessControlException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.sql.DataSource;
import javax.sql.RowSet;
import javax.xml.datatype.XMLGregorianCalendar;
import m7.a2;
import m7.b2;
import m7.d3;
import m7.f3;
import m7.g3;
import m7.i3;
import m7.j3;
import m7.k3;
import m7.l;
import m7.l3;
import m7.n;
import m7.o;
import m7.p;
import m7.y1;
import m7.z1;
import n7.c0;
import n7.d1;
import n7.h0;
import n7.i0;
import n7.j0;
import n7.k1;
import n7.m;
import n7.q0;
import n7.r;
import n7.s;
import n7.t;
import n7.u;
import n7.u0;
import n7.v;
import n7.w;
import n7.w0;
import n7.x;
import n7.y0;
import n7.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class h {
    public static boolean A;
    public static boolean B;
    public static boolean C;
    public static boolean D;
    public static com.alibaba.fastjson.util.e<Class<?>, Boolean> E;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String[] f70125v;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final long[] f70128y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static h f70129z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.alibaba.fastjson.util.g<Type, b2> f70130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.alibaba.fastjson.util.g<Type, com.alibaba.fastjson.util.g<Type, b2>> f70131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentMap<String, Class<?>> f70132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f70133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f70134e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PropertyNamingStrategy f70135f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ClassLoader f70136g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public m7.a f70137h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f70138i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long[] f70139j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long[] f70140k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long[] f70141l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f70142m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f70143n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f70144o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List<o7.a> f70145p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile List<c> f70146q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f70147r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Callable<Void> f70148s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String[] f70123t = B(com.alibaba.fastjson.util.f.k("fastjson.parser.deny.internal"));

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String[] f70124u = B(com.alibaba.fastjson.util.f.k("fastjson.parser.deny"));

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final boolean f70126w = "true".equals(com.alibaba.fastjson.util.f.k("fastjson.parser.autoTypeSupport"));

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final boolean f70127x = "true".equals(com.alibaba.fastjson.util.f.k("fastjson.parser.safeMode"));

    /* JADX INFO: compiled from: source.java */
    public class a implements Callable<Void> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            h.this.f70130a.c(Timestamp.class, i3.f70897c);
            h.this.f70130a.c(Date.class, i3.f70896b);
            h.this.f70130a.c(Time.class, l3.f70902a);
            h.this.f70130a.c(java.util.Date.class, c0.f71593a);
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements com.alibaba.fastjson.util.e<Class<?>, Boolean> {
        @Override // com.alibaba.fastjson.util.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Class<?> cls) {
            return Boolean.valueOf(cls == Date.class || cls == Time.class || cls == Timestamp.class);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        Class<?> a(String str, Class<?> cls, int i11);
    }

    static {
        String[] strArrB = B(com.alibaba.fastjson.util.f.k("fastjson.parser.autoTypeAccept"));
        if (strArrB == null) {
            strArrB = new String[0];
        }
        f70125v = strArrB;
        f70128y = new long[]{-6976602508726000783L, -6293031534589903644L, 59775428743665658L, 7267793227937552092L};
        f70129z = new h();
        A = false;
        B = false;
        C = false;
        D = false;
        E = new b();
    }

    public h() {
        this(false);
    }

    public h(m7.a aVar, ClassLoader classLoader, boolean z11) {
        this.f70130a = new com.alibaba.fastjson.util.g<>();
        this.f70131b = new com.alibaba.fastjson.util.g<>(16);
        this.f70132c = new ConcurrentHashMap(16, 0.75f, 1);
        this.f70133d = !com.alibaba.fastjson.util.b.f15531b;
        this.f70134e = new i(4096);
        this.f70138i = f70126w;
        this.f70143n = false;
        this.f70144o = TypeUtils.f15503b;
        this.f70145p = new ArrayList();
        this.f70147r = f70127x;
        this.f70140k = new long[]{-9164606388214699518L, -8754006975464705441L, -8720046426850100497L, -8649961213709896794L, -8614556368991373401L, -8382625455832334425L, -8165637398350707645L, -8109300701639721088L, -7966123100503199569L, -7921218830998286408L, -7775351613326101303L, -7768608037458185275L, -7766605818834748097L, -6835437086156813536L, -6316154655839304624L, -6179589609550493385L, -6149130139291498841L, -6149093380703242441L, -6088208984980396913L, -6025144546313590215L, -5939269048541779808L, -5885964883385605994L, -5767141746063564198L, -5764804792063216819L, -5472097725414717105L, -5194641081268104286L, -5076846148177416215L, -4837536971810737970L, -4836620931940850535L, -4733542790109620528L, -4703320437989596122L, -4608341446948126581L, -4537258998789938600L, -4438775680185074100L, -4314457471973557243L, -4150995715611818742L, -4082057040235125754L, -3975378478825053783L, -3967588558552655563L, -3935185854875733362L, -3750763034362895579L, -3319207949486691020L, -3077205613010077203L, -3053747177772160511L, -2995060141064716555L, -2825378362173150292L, -2533039401923731906L, -2439930098895578154L, -2378990704010641148L, -2364987994247679115L, -2262244760619952081L, -2192804397019347313L, -2095516571388852610L, -1872417015366588117L, -1800035667138631116L, -1650485814983027158L, -1589194880214235129L, -1363634950764737555L, -965955008570215305L, -905177026366752536L, -831789045734283466L, -803541446955902575L, -731978084025273882L, -666475508176557463L, -582813228520337988L, -254670111376247151L, -219577392946377768L, -190281065685395680L, -26639035867733124L, -9822483067882491L, 4750336058574309L, 33238344207745342L, 156405680656087946L, 218512992947536312L, 313864100207897507L, 386461436234701831L, 744602970950881621L, 823641066473609950L, 860052378298585747L, 1073634739308289776L, 1153291637701043748L, 1203232727967308606L, 1214780596910349029L, 1268707909007641340L, 1459860845934817624L, 1502845958873959152L, 1534439610567445754L, 1698504441317515818L, 1818089308493370394L, 2078113382421334967L, 2164696723069287854L, 2622551729063269307L, 2653453629929770569L, 2660670623866180977L, 2731823439467737506L, 2836431254737891113L, 2930861374593775110L, 3058452313624178956L, 3085473968517218653L, 3089451460101527857L, 3114862868117605599L, 3129395579983849527L, 3256258368248066264L, 3452379460455804429L, 3547627781654598988L, 3637939656440441093L, 3688179072722109200L, 3718352661124136681L, 3730752432285826863L, 3740226159580918099L, 3794316665763266033L, 3977090344859527316L, 4000049462512838776L, 4046190361520671643L, 4147696707147271408L, 4193204392725694463L, 4215053018660518963L, 4241163808635564644L, 4254584350247334433L, 4319304524795015394L, 4814658433570175913L, 4841947709850912914L, 4904007817188630457L, 5100336081510080343L, 5120543992130540564L, 5274044858141538265L, 5347909877633654828L, 5450448828334921485L, 5474268165959054640L, 5545425291794704408L, 5596129856135573697L, 5688200883751798389L, 5751393439502795295L, 5916409771425455946L, 5944107969236155580L, 6007332606592876737L, 6090377589998869205L, 6280357960959217660L, 6456855723474196908L, 6511035576063254270L, 6534946468240507089L, 6584624952928234050L, 6734240326434096246L, 6742705432718011780L, 6800727078373023163L, 6854854816081053523L, 7045245923763966215L, 7123326897294507060L, 7164889056054194741L, 7179336928365889465L, 7240293012336844478L, 7347653049056829645L, 7375862386996623731L, 7442624256860549330L, 7617522210483516279L, 7658177784286215602L, 8055461369741094911L, 8064026652676081192L, 8389032537095247355L, 8409640769019589119L, 8488266005336625107L, 8537233257283452655L, 8711531061028787095L, 8735538376409180149L, 8838294710098435315L, 8861402923078831179L, 9140390920032557669L, 9140416208800006522L, 9144212112462101475L};
        long[] jArr = new long[f70125v.length];
        int i11 = 0;
        while (true) {
            String[] strArr = f70125v;
            if (i11 >= strArr.length) {
                break;
            }
            jArr[i11] = TypeUtils.J(strArr[i11]);
            i11++;
        }
        Arrays.sort(jArr);
        this.f70141l = jArr;
        this.f70148s = new a();
        this.f70142m = z11;
        if (aVar == null && !com.alibaba.fastjson.util.b.f15531b) {
            try {
                aVar = classLoader == null ? new m7.a(new com.alibaba.fastjson.util.a()) : new m7.a(classLoader);
            } catch (ExceptionInInitializerError | NoClassDefFoundError | AccessControlException unused) {
            }
        }
        this.f70137h = aVar;
        if (aVar == null) {
            this.f70133d = false;
        }
        u();
        f(f70124u);
        g(f70123t);
        e(f70125v);
    }

    public h(boolean z11) {
        this(null, null, z11);
    }

    public static String[] B(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return str.split(",");
    }

    public static Method q(Class cls, Class cls2) {
        for (Method method : cls.getMethods()) {
            if (Modifier.isStatic(method.getModifiers()) && method.getReturnType() == cls2 && method.getParameterTypes().length == 1 && ((j7.a) method.getAnnotation(j7.a.class)) != null) {
                return method;
            }
        }
        return null;
    }

    public static Field s(String str, Map<String, Field> map) {
        Field field = map.get(str);
        if (field == null) {
            field = map.get("_" + str);
        }
        if (field == null) {
            field = map.get("m_" + str);
        }
        if (field != null) {
            return field;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt >= 'a' && cCharAt <= 'z') {
            char[] charArray = str.toCharArray();
            charArray[0] = (char) (charArray[0] - ' ');
            field = map.get(new String(charArray));
        }
        if (str.length() <= 2) {
            return field;
        }
        char cCharAt2 = str.charAt(1);
        if (cCharAt < 'a' || cCharAt > 'z' || cCharAt2 < 'A' || cCharAt2 > 'Z') {
            return field;
        }
        for (Map.Entry<String, Field> entry : map.entrySet()) {
            if (str.equalsIgnoreCase(entry.getKey())) {
                return entry.getValue();
            }
        }
        return field;
    }

    public static h t() {
        return f70129z;
    }

    public static boolean w(Class<?> cls) {
        Boolean boolValueOf = Boolean.valueOf(cls.isPrimitive() || cls == Boolean.class || cls == Character.class || cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == String.class || cls == java.util.Date.class || cls.isEnum());
        if (!boolValueOf.booleanValue()) {
            boolValueOf = (Boolean) com.alibaba.fastjson.util.i.b(E, cls);
        }
        if (boolValueOf != null) {
            return boolValueOf.booleanValue();
        }
        return false;
    }

    public static void y(Class<?> cls, Map<String, Field> map) {
        for (Field field : cls.getDeclaredFields()) {
            String name = field.getName();
            if (!map.containsKey(name)) {
                map.put(name, field);
            }
        }
        if (cls.getSuperclass() == null || cls.getSuperclass() == Object.class) {
            return;
        }
        y(cls.getSuperclass(), map);
    }

    public void A(boolean z11) {
        this.f70133d = z11;
    }

    public void b(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        long J = TypeUtils.J(str);
        if (Arrays.binarySearch(this.f70141l, J) >= 0) {
            return;
        }
        long[] jArr = this.f70141l;
        int length = jArr.length;
        long[] jArr2 = new long[length + 1];
        jArr2[length] = J;
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        Arrays.sort(jArr2);
        this.f70141l = jArr2;
    }

    public void c(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        long J = TypeUtils.J(str);
        if (Arrays.binarySearch(this.f70140k, J) >= 0) {
            return;
        }
        long[] jArr = this.f70140k;
        int length = jArr.length;
        long[] jArr2 = new long[length + 1];
        jArr2[length] = J;
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        Arrays.sort(jArr2);
        this.f70140k = jArr2;
    }

    public void d(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        long J = TypeUtils.J(str);
        long[] jArr = this.f70139j;
        if (jArr == null) {
            this.f70139j = new long[]{J};
            return;
        }
        if (Arrays.binarySearch(jArr, J) >= 0) {
            return;
        }
        long[] jArr2 = this.f70139j;
        int length = jArr2.length;
        long[] jArr3 = new long[length + 1];
        jArr3[length] = J;
        System.arraycopy(jArr2, 0, jArr3, 0, jArr2.length);
        Arrays.sort(jArr3);
        this.f70139j = jArr3;
    }

    public final void e(String[] strArr) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            b(str);
        }
    }

    public final void f(String[] strArr) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            c(str);
        }
    }

    public final void g(String[] strArr) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            d(str);
        }
    }

    public Class<?> h(Class cls) {
        return m(cls) != null ? cls : j(cls.getName(), null, com.alibaba.fastjson.a.DEFAULT_PARSER_FEATURE);
    }

    public Class<?> i(String str, Class<?> cls) {
        return j(str, cls, com.alibaba.fastjson.a.DEFAULT_PARSER_FEATURE);
    }

    /* JADX WARN: Code duplicated, block: B:174:0x0311 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:176:0x0315 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:177:0x0317 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:180:0x031c  */
    /* JADX WARN: Code duplicated, block: B:183:0x0325 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:184:0x0327 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:185:0x0329  */
    /* JADX WARN: Code duplicated, block: B:187:0x032d  */
    /* JADX WARN: Code duplicated, block: B:189:0x0335  */
    /* JADX WARN: Code duplicated, block: B:210:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:212:0x03b1  */
    /* JADX WARN: Code duplicated, block: B:214:0x03b7 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:218:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:219:0x03d1 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:33:0x0063  */
    public Class<?> j(String str, Class<?> cls, int i11) throws Throwable {
        boolean z11;
        InputStream resourceAsStream;
        boolean zC;
        boolean z12;
        long j11;
        Class<?> clsC0;
        if (str == null) {
            return null;
        }
        if (this.f70146q != null) {
            Iterator<c> it = this.f70146q.iterator();
            while (it.hasNext()) {
                Class<?> clsA = it.next().a(str, cls, i11);
                if (clsA != null) {
                    return clsA;
                }
            }
        }
        int i12 = Feature.SafeMode.mask;
        if (this.f70147r || (i11 & i12) != 0 || (i12 & com.alibaba.fastjson.a.DEFAULT_PARSER_FEATURE) != 0) {
            throw new JSONException("safeMode not support autoType : " + str);
        }
        int i13 = Feature.SupportAutoType.mask;
        boolean z13 = true;
        boolean z14 = (!this.f70138i && (i11 & i13) == 0 && (com.alibaba.fastjson.a.DEFAULT_PARSER_FEATURE & i13) == 0) ? false : true;
        if (str.length() >= 192 || str.length() < 3) {
            throw new JSONException("autoType is not support. " + str);
        }
        if (cls == null) {
            z11 = false;
        } else {
            long J = TypeUtils.J(cls.getName());
            if (J == -8024746738719829346L || J == 3247277300971823414L || J == -5811778396720452501L || J == -1368967840069965882L || J == 2980334044947851925L || J == 5183404141909004468L || J == 7222019943667248779L || J == -2027296626235911549L || J == -2114196234051346931L || J == -2939497380989775398L) {
                z11 = false;
            } else {
                z11 = true;
            }
        }
        String strReplace = str.replace('$', '.');
        long jCharAt = (((long) strReplace.charAt(0)) ^ (-3750763034362895579L)) * 1099511628211L;
        if (jCharAt == -5808493101479473382L) {
            throw new JSONException("autoType is not support. " + str);
        }
        boolean z15 = z11;
        if ((((long) strReplace.charAt(strReplace.length() - 1)) ^ jCharAt) * 1099511628211L == 655701488918567152L) {
            throw new JSONException("autoType is not support. " + str);
        }
        long jCharAt2 = (((((((long) strReplace.charAt(0)) ^ (-3750763034362895579L)) * 1099511628211L) ^ ((long) strReplace.charAt(1))) * 1099511628211L) ^ ((long) strReplace.charAt(2))) * 1099511628211L;
        long J2 = TypeUtils.J(strReplace);
        boolean z16 = Arrays.binarySearch(f70128y, J2) >= 0;
        if (this.f70139j != null) {
            long j12 = jCharAt2;
            int i14 = 3;
            while (i14 < strReplace.length()) {
                long j13 = J2;
                long jCharAt3 = (j12 ^ ((long) strReplace.charAt(i14))) * 1099511628211L;
                if (Arrays.binarySearch(this.f70139j, jCharAt3) >= 0) {
                    throw new JSONException("autoType is not support. " + str);
                }
                i14++;
                j12 = jCharAt3;
                J2 = j13;
            }
        }
        long j14 = J2;
        if (!z16 && (z14 || z15)) {
            long jCharAt4 = jCharAt2;
            int i15 = 3;
            while (i15 < strReplace.length()) {
                jCharAt4 = (jCharAt4 ^ ((long) strReplace.charAt(i15))) * 1099511628211L;
                if (Arrays.binarySearch(this.f70141l, jCharAt4) >= 0 && (clsC0 = TypeUtils.C0(str, this.f70136g, z13)) != null) {
                    return clsC0;
                }
                if (Arrays.binarySearch(this.f70140k, jCharAt4) < 0 || TypeUtils.R(str) != null) {
                    j11 = j14;
                } else {
                    j11 = j14;
                    if (Arrays.binarySearch(this.f70141l, j11) < 0) {
                        throw new JSONException("autoType is not support. " + str);
                    }
                }
                i15++;
                j14 = j11;
                z13 = true;
            }
        }
        Class<?> clsR = TypeUtils.R(str);
        if (clsR == null) {
            clsR = this.f70130a.a(str);
        }
        if (cls == null && clsR != null && Throwable.class.isAssignableFrom(clsR) && !z14) {
            clsR = null;
        }
        if (clsR == null) {
            clsR = this.f70132c.get(str);
        }
        if (z16) {
            clsR = TypeUtils.C0(str, this.f70136g, true);
        }
        if (clsR != null) {
            if (cls == null || clsR == HashMap.class || clsR == LinkedHashMap.class || cls.isAssignableFrom(clsR)) {
                return clsR;
            }
            throw new JSONException("type not match. " + str + " -> " + cls.getName());
        }
        if (!z14) {
            for (int i16 = 3; i16 < strReplace.length(); i16++) {
                jCharAt2 = (jCharAt2 ^ ((long) strReplace.charAt(i16))) * 1099511628211L;
                if (Arrays.binarySearch(this.f70140k, jCharAt2) >= 0) {
                    if (str.endsWith("Exception") || str.endsWith("Error")) {
                        return null;
                    }
                    throw new JSONException("autoType is not support. " + str);
                }
                if (Arrays.binarySearch(this.f70141l, jCharAt2) >= 0) {
                    Class<?> clsC1 = TypeUtils.C0(str, this.f70136g, true);
                    if (clsC1 == null) {
                        return cls;
                    }
                    if (cls == null || !cls.isAssignableFrom(clsC1)) {
                        return clsC1;
                    }
                    throw new JSONException("type not match. " + str + " -> " + cls.getName());
                }
            }
        }
        try {
            try {
                String str2 = str.replace('.', '/') + ".class";
                ClassLoader classLoader = this.f70136g;
                if (classLoader != null) {
                    try {
                        resourceAsStream = classLoader.getResourceAsStream(str2);
                    } catch (Exception unused) {
                        resourceAsStream = null;
                        com.alibaba.fastjson.util.f.a(resourceAsStream);
                        zC = false;
                        if (z14) {
                            if (z14) {
                                z12 = true;
                            } else {
                                z12 = true;
                            }
                            clsR = TypeUtils.C0(str, this.f70136g, z12);
                        } else {
                            if (z14) {
                                z12 = true;
                            } else {
                                z12 = true;
                            }
                            clsR = TypeUtils.C0(str, this.f70136g, z12);
                        }
                        if (clsR != null) {
                            if (zC) {
                                if (z14) {
                                    TypeUtils.b(str, clsR);
                                }
                                return clsR;
                            }
                            if (ClassLoader.class.isAssignableFrom(clsR)) {
                            }
                            throw new JSONException("autoType is not support. " + str);
                        }
                        if (!z14) {
                            if (clsR != null) {
                                TypeUtils.b(str, clsR);
                            }
                            return clsR;
                        }
                        if (str.endsWith("Exception")) {
                            return null;
                        }
                        return null;
                    }
                } else {
                    resourceAsStream = h.class.getClassLoader().getResourceAsStream(str2);
                }
                if (resourceAsStream != null) {
                    try {
                        try {
                            k7.b bVar = new k7.b(resourceAsStream, true);
                            try {
                                TypeCollector typeCollector = new TypeCollector("<clinit>", new Class[0]);
                                bVar.a(typeCollector);
                                zC = typeCollector.c();
                            } catch (Exception unused2) {
                                com.alibaba.fastjson.util.f.a(resourceAsStream);
                                zC = false;
                            }
                        } catch (Exception unused3) {
                            com.alibaba.fastjson.util.f.a(resourceAsStream);
                            zC = false;
                            if (z14) {
                                if (z14) {
                                    z12 = true;
                                } else {
                                    z12 = true;
                                }
                                clsR = TypeUtils.C0(str, this.f70136g, z12);
                            } else {
                                if (z14) {
                                    z12 = true;
                                } else {
                                    z12 = true;
                                }
                                clsR = TypeUtils.C0(str, this.f70136g, z12);
                            }
                            if (clsR != null) {
                                if (zC) {
                                    if (z14) {
                                        TypeUtils.b(str, clsR);
                                    }
                                    return clsR;
                                }
                                if (ClassLoader.class.isAssignableFrom(clsR)) {
                                }
                                throw new JSONException("autoType is not support. " + str);
                            }
                            if (!z14) {
                                if (str.endsWith("Exception")) {
                                    return null;
                                }
                                return null;
                            }
                            if (clsR != null) {
                                TypeUtils.b(str, clsR);
                            }
                            return clsR;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.alibaba.fastjson.util.f.a(resourceAsStream);
                        throw th;
                    }
                } else {
                    zC = false;
                }
                com.alibaba.fastjson.util.f.a(resourceAsStream);
            } catch (Throwable th3) {
                th = th3;
                resourceAsStream = null;
            }
        } catch (Exception unused4) {
            resourceAsStream = null;
        }
        if (z14 || zC || z15) {
            if (z14 || zC) {
                z12 = true;
            } else {
                z12 = false;
            }
            clsR = TypeUtils.C0(str, this.f70136g, z12);
        }
        if (clsR != null) {
            if (zC) {
                if (z14) {
                    TypeUtils.b(str, clsR);
                }
                return clsR;
            }
            if (!ClassLoader.class.isAssignableFrom(clsR) || DataSource.class.isAssignableFrom(clsR) || RowSet.class.isAssignableFrom(clsR)) {
                throw new JSONException("autoType is not support. " + str);
            }
            if (cls != null) {
                if (cls.isAssignableFrom(clsR)) {
                    if (z14) {
                        TypeUtils.b(str, clsR);
                    }
                    return clsR;
                }
                throw new JSONException("type not match. " + str + " -> " + cls.getName());
            }
            if (com.alibaba.fastjson.util.h.b(clsR, clsR, this.f70135f).f15580d != null && z14) {
                throw new JSONException("autoType is not support. " + str);
            }
        }
        if (!z14) {
            if (clsR != null && z14) {
                TypeUtils.b(str, clsR);
            }
            return clsR;
        }
        if (str.endsWith("Exception") || str.endsWith("Error")) {
            return null;
        }
        throw new JSONException("autoType is not support. " + str);
    }

    public l k(h hVar, com.alibaba.fastjson.util.h hVar2, com.alibaba.fastjson.util.d dVar) {
        Class<?> clsDeserializeUsing;
        Class<?> cls = hVar2.f15577a;
        Class<?> cls2 = dVar.f15536f;
        j7.b bVarD = dVar.d();
        Class<?> cls3 = null;
        if (bVarD != null && (clsDeserializeUsing = bVarD.deserializeUsing()) != Void.class) {
            cls3 = clsDeserializeUsing;
        }
        return (cls3 == null && (cls2 == List.class || cls2 == ArrayList.class)) ? new m7.c(hVar, cls, dVar) : new m7.f(hVar, cls, dVar);
    }

    public b2 l(Class<?> cls, Type type) {
        j7.b bVarD;
        Method method;
        m7.a aVar;
        boolean zA = this.f70133d & (!this.f70142m);
        if (zA) {
            j7.d dVar = (j7.d) TypeUtils.N(cls, j7.d.class);
            if (dVar != null) {
                Class<?> clsDeserializer = dVar.deserializer();
                if (clsDeserializer != Void.class) {
                    try {
                        Object objNewInstance = clsDeserializer.newInstance();
                        if (objNewInstance instanceof b2) {
                            return (b2) objNewInstance;
                        }
                    } catch (Throwable unused) {
                    }
                }
                zA = dVar.asm() && dVar.parseFeatures().length == 0;
            }
            if (zA) {
                Class<?> clsF = com.alibaba.fastjson.util.h.f(cls, dVar);
                if (clsF == null) {
                    clsF = cls;
                }
                do {
                    if (!Modifier.isPublic(clsF.getModifiers())) {
                        zA = false;
                        break;
                    }
                    clsF = clsF.getSuperclass();
                    if (clsF == Object.class) {
                        break;
                    }
                } while (clsF != null);
            }
        }
        if (cls.getTypeParameters().length != 0) {
            zA = false;
        }
        if (zA && (aVar = this.f70137h) != null && aVar.f70868a.c(cls)) {
            zA = false;
        }
        if (zA) {
            zA = com.alibaba.fastjson.util.b.a(cls.getSimpleName());
        }
        if (zA) {
            if (cls.isInterface()) {
                zA = false;
            }
            com.alibaba.fastjson.util.h hVarC = com.alibaba.fastjson.util.h.c(cls, type, this.f70135f, false, TypeUtils.f15503b, this.f70143n);
            if (zA && hVarC.f15584h.length > 200) {
                zA = false;
            }
            Constructor<?> constructor = hVarC.f15579c;
            if (zA && constructor == null && !cls.isInterface()) {
                zA = false;
            }
            for (com.alibaba.fastjson.util.d dVar2 : hVarC.f15584h) {
                if (!dVar2.f15539i) {
                    Class<?> cls2 = dVar2.f15536f;
                    if (Modifier.isPublic(cls2.getModifiers()) && ((!cls2.isMemberClass() || Modifier.isStatic(cls2.getModifiers())) && ((dVar2.n() == null || com.alibaba.fastjson.util.b.a(dVar2.n().getName())) && (((bVarD = dVar2.d()) == null || (com.alibaba.fastjson.util.b.a(bVarD.name()) && bVarD.format().length() == 0 && bVarD.deserializeUsing() == Void.class && bVarD.parseFeatures().length == 0 && !bVarD.unwrapped())) && (((method = dVar2.f15533b) == null || method.getParameterTypes().length <= 1) && (!cls2.isEnum() || (p(cls2) instanceof m7.h))))))) {
                    }
                }
                zA = false;
                break;
            }
        }
        boolean z11 = (zA && cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers())) ? false : zA;
        if ((z11 && TypeUtils.z0(cls)) || !z11) {
            return new o(this, cls, type);
        }
        com.alibaba.fastjson.util.h hVarB = com.alibaba.fastjson.util.h.b(cls, type, this.f70135f);
        try {
            return this.f70137h.v(this, hVarB);
        } catch (JSONException unused2) {
            return new o(this, hVarB);
        } catch (NoSuchMethodException unused3) {
            return new o(this, cls, type);
        } catch (Exception e11) {
            throw new JSONException("create asm deserializer error, " + cls.getName(), e11);
        }
    }

    public b2 m(Type type) {
        Type mixInAnnotations = com.alibaba.fastjson.a.getMixInAnnotations(type);
        if (mixInAnnotations == null) {
            return this.f70130a.b(type);
        }
        com.alibaba.fastjson.util.g<Type, b2> gVarB = this.f70131b.b(type);
        if (gVarB == null) {
            return null;
        }
        return gVarB.b(mixInAnnotations);
    }

    public ClassLoader n() {
        return this.f70136g;
    }

    public b2 o(Class<?> cls, Type type) {
        b2 b2VarL;
        b2 g3Var;
        Method methodQ;
        Class<?> clsMappingTo;
        Type type2 = type;
        b2 b2VarM = m(type2);
        if (b2VarM == null && (type2 instanceof ParameterizedTypeImpl)) {
            b2VarM = m(com.alibaba.fastjson.g.b((ParameterizedTypeImpl) type2));
        }
        if (b2VarM != null) {
            return b2VarM;
        }
        if (type2 == null) {
            type2 = cls;
        }
        b2 b2VarM2 = m(type2);
        if (b2VarM2 != null) {
            return b2VarM2;
        }
        j7.d dVar = (j7.d) TypeUtils.N(cls, j7.d.class);
        if (dVar != null && (clsMappingTo = dVar.mappingTo()) != Void.class) {
            return o(clsMappingTo, clsMappingTo);
        }
        if ((type2 instanceof WildcardType) || (type2 instanceof TypeVariable) || (type2 instanceof ParameterizedType)) {
            b2VarM2 = m(cls);
        }
        if (b2VarM2 != null) {
            return b2VarM2;
        }
        Iterator<o7.a> it = this.f70145p.iterator();
        while (it.hasNext()) {
            b2VarM2 = it.next().a(this, cls);
            if (b2VarM2 != null) {
                z(type2, b2VarM2);
                return b2VarM2;
            }
        }
        String strReplace = cls.getName().replace('$', '.');
        if (strReplace.startsWith("java.awt.") && n7.o.k(cls) && !A) {
            String[] strArr = {"java.awt.Point", "java.awt.Font", "java.awt.Rectangle", "java.awt.Color"};
            for (int i11 = 0; i11 < 4; i11++) {
                try {
                    String str = strArr[i11];
                    if (str.equals(strReplace)) {
                        Type cls2 = Class.forName(str);
                        b2 b2Var = n7.o.f71699a;
                        z(cls2, b2Var);
                        return b2Var;
                    }
                } catch (Throwable unused) {
                    A = true;
                }
            }
            b2VarM2 = n7.o.f71699a;
        }
        if (!B) {
            try {
                if (strReplace.startsWith("java.time.")) {
                    String[] strArr2 = {"java.time.LocalDateTime", "java.time.LocalDate", "java.time.LocalTime", "java.time.ZonedDateTime", "java.time.OffsetDateTime", "java.time.OffsetTime", "java.time.ZoneOffset", "java.time.ZoneRegion", "java.time.ZoneId", "java.time.Period", "java.time.Duration", "java.time.Instant"};
                    int i12 = 0;
                    for (int i13 = 12; i12 < i13; i13 = 12) {
                        String str2 = strArr2[i12];
                        if (str2.equals(strReplace)) {
                            Type cls3 = Class.forName(str2);
                            b2 b2Var2 = y1.f70915a;
                            z(cls3, b2Var2);
                            return b2Var2;
                        }
                        i12++;
                    }
                } else if (strReplace.startsWith("java.util.Optional")) {
                    String[] strArr3 = {"java.util.Optional", "java.util.OptionalDouble", "java.util.OptionalInt", "java.util.OptionalLong"};
                    for (int i14 = 0; i14 < 4; i14++) {
                        String str3 = strArr3[i14];
                        if (str3.equals(strReplace)) {
                            Type cls4 = Class.forName(str3);
                            b2 b2Var3 = d3.f70880a;
                            z(cls4, b2Var3);
                            return b2Var3;
                        }
                    }
                }
            } catch (Throwable unused2) {
                B = true;
            }
        }
        if (!C) {
            try {
                if (strReplace.startsWith("org.joda.time.")) {
                    String[] strArr4 = {"org.joda.time.DateTime", "org.joda.time.LocalDate", "org.joda.time.LocalDateTime", "org.joda.time.LocalTime", "org.joda.time.Instant", "org.joda.time.Period", "org.joda.time.Duration", "org.joda.time.DateTimeZone", "org.joda.time.format.DateTimeFormatter"};
                    for (int i15 = 0; i15 < 9; i15++) {
                        String str4 = strArr4[i15];
                        if (str4.equals(strReplace)) {
                            Type cls5 = Class.forName(str4);
                            b2VarM2 = q0.f71722a;
                            z(cls5, b2VarM2);
                            return b2VarM2;
                        }
                    }
                }
            } catch (Throwable unused3) {
                C = true;
            }
        }
        if (!D && strReplace.startsWith("com.google.common.collect.")) {
            try {
                String[] strArr5 = {"com.google.common.collect.HashMultimap", "com.google.common.collect.LinkedListMultimap", "com.google.common.collect.LinkedHashMultimap", "com.google.common.collect.ArrayListMultimap", "com.google.common.collect.TreeMultimap"};
                for (int i16 = 0; i16 < 5; i16++) {
                    String str5 = strArr5[i16];
                    if (str5.equals(strReplace)) {
                        Type cls6 = Class.forName(str5);
                        b2VarM2 = i0.f71650a;
                        z(cls6, b2VarM2);
                        return b2VarM2;
                    }
                }
            } catch (ClassNotFoundException unused4) {
                D = true;
            }
        }
        if (strReplace.equals("java.nio.ByteBuffer")) {
            b2VarM2 = u.f71751a;
            z(cls, b2VarM2);
        }
        if (strReplace.equals("java.nio.file.Path")) {
            b2VarM2 = w0.f71761b;
            z(cls, b2VarM2);
        }
        if (cls == Map.Entry.class) {
            b2VarM2 = w0.f71761b;
            z(cls, b2VarM2);
        }
        if (strReplace.equals("org.javamoney.moneta.Money")) {
            b2VarM2 = r7.a.f75164a;
            z(cls, b2VarM2);
        }
        try {
            for (m7.d dVar2 : com.alibaba.fastjson.util.l.a(m7.d.class, Thread.currentThread().getContextClassLoader())) {
                Iterator<Type> it2 = dVar2.a().iterator();
                while (it2.hasNext()) {
                    z(it2.next(), dVar2);
                }
            }
        } catch (Exception unused5) {
        }
        if (b2VarM2 == null) {
            b2VarM2 = m(type2);
        }
        if (b2VarM2 != null) {
            return b2VarM2;
        }
        if (cls.isEnum()) {
            if (this.f70143n) {
                for (Method method : cls.getMethods()) {
                    if (TypeUtils.s0(method)) {
                        b2 b2VarL2 = l(cls, type2);
                        z(type2, b2VarL2);
                        return b2VarL2;
                    }
                }
            }
            Class<?> cls7 = (Class) com.alibaba.fastjson.a.getMixInAnnotations(cls);
            j7.d dVar3 = (j7.d) TypeUtils.N(cls7 != null ? cls7 : cls, j7.d.class);
            if (dVar3 != null) {
                try {
                    b2 b2Var4 = (b2) dVar3.deserializer().newInstance();
                    z(cls, b2Var4);
                    return b2Var4;
                } catch (Throwable unused6) {
                }
            }
            if (cls7 != null) {
                Method methodQ2 = q(cls7, cls);
                if (methodQ2 != null) {
                    try {
                        methodQ = cls.getMethod(methodQ2.getName(), methodQ2.getParameterTypes());
                    } catch (Exception unused7) {
                        methodQ = null;
                    }
                } else {
                    methodQ = null;
                }
            } else {
                methodQ = q(cls, cls);
            }
            if (methodQ != null) {
                b2 gVar = new m7.g(methodQ);
                z(cls, gVar);
                return gVar;
            }
            b2VarL = r(cls);
        } else if (cls.isArray()) {
            b2VarL = y0.f71766a;
        } else if (cls == Set.class || cls == HashSet.class || cls == Collection.class || cls == List.class || cls == ArrayList.class || Collection.class.isAssignableFrom(cls)) {
            b2VarL = z.f71767a;
        } else if (Map.class.isAssignableFrom(cls)) {
            b2VarL = z1.f70936a;
        } else {
            if (Throwable.class.isAssignableFrom(cls)) {
                g3Var = new k3(this, cls);
            } else if (f3.class.isAssignableFrom(cls)) {
                g3Var = new g3(cls);
            } else {
                b2VarL = cls == InetAddress.class ? w0.f71761b : l(cls, type2);
            }
            b2VarL = g3Var;
        }
        z(type2, b2VarL);
        return b2VarL;
    }

    public b2 p(Type type) {
        b2 b2VarM = m(type);
        if (b2VarM != null) {
            return b2VarM;
        }
        if (type instanceof Class) {
            return o((Class) type, type);
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            return rawType instanceof Class ? o((Class) rawType, type) : p(rawType);
        }
        if (type instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            if (upperBounds.length == 1) {
                return p(upperBounds[0]);
            }
        }
        return p.f70914a;
    }

    public b2 r(Class<?> cls) {
        return new m7.h(cls);
    }

    public final void u() {
        com.alibaba.fastjson.util.g<Type, b2> gVar = this.f70130a;
        w0 w0Var = w0.f71761b;
        gVar.c(SimpleDateFormat.class, w0Var);
        com.alibaba.fastjson.util.g<Type, b2> gVar2 = this.f70130a;
        v vVar = v.f71756b;
        gVar2.c(Calendar.class, vVar);
        this.f70130a.c(XMLGregorianCalendar.class, vVar);
        this.f70130a.c(JSONObject.class, z1.f70936a);
        com.alibaba.fastjson.util.g<Type, b2> gVar3 = this.f70130a;
        z zVar = z.f71767a;
        gVar3.c(JSONArray.class, zVar);
        this.f70130a.c(Map.class, z1.f70936a);
        this.f70130a.c(HashMap.class, z1.f70936a);
        this.f70130a.c(LinkedHashMap.class, z1.f70936a);
        this.f70130a.c(TreeMap.class, z1.f70936a);
        this.f70130a.c(ConcurrentMap.class, z1.f70936a);
        this.f70130a.c(ConcurrentHashMap.class, z1.f70936a);
        this.f70130a.c(Collection.class, zVar);
        this.f70130a.c(List.class, zVar);
        this.f70130a.c(ArrayList.class, zVar);
        com.alibaba.fastjson.util.g<Type, b2> gVar4 = this.f70130a;
        p pVar = p.f70914a;
        gVar4.c(Object.class, pVar);
        this.f70130a.c(String.class, k1.f71692a);
        this.f70130a.c(StringBuffer.class, k1.f71692a);
        this.f70130a.c(StringBuilder.class, k1.f71692a);
        com.alibaba.fastjson.util.g<Type, b2> gVar5 = this.f70130a;
        Class cls = Character.TYPE;
        x xVar = x.f71764a;
        gVar5.c(cls, xVar);
        this.f70130a.c(Character.class, xVar);
        com.alibaba.fastjson.util.g<Type, b2> gVar6 = this.f70130a;
        Class cls2 = Byte.TYPE;
        a2 a2Var = a2.f70876a;
        gVar6.c(cls2, a2Var);
        this.f70130a.c(Byte.class, a2Var);
        this.f70130a.c(Short.TYPE, a2Var);
        this.f70130a.c(Short.class, a2Var);
        this.f70130a.c(Integer.TYPE, j0.f71665a);
        this.f70130a.c(Integer.class, j0.f71665a);
        this.f70130a.c(Long.TYPE, u0.f71755a);
        this.f70130a.c(Long.class, u0.f71755a);
        this.f70130a.c(BigInteger.class, s.f71748c);
        this.f70130a.c(BigDecimal.class, r.f71745c);
        this.f70130a.c(Float.TYPE, h0.f71645b);
        this.f70130a.c(Float.class, h0.f71645b);
        this.f70130a.c(Double.TYPE, a2Var);
        this.f70130a.c(Double.class, a2Var);
        com.alibaba.fastjson.util.g<Type, b2> gVar7 = this.f70130a;
        Class cls3 = Boolean.TYPE;
        t tVar = t.f71749a;
        gVar7.c(cls3, tVar);
        this.f70130a.c(Boolean.class, tVar);
        this.f70130a.c(Class.class, w0Var);
        this.f70130a.c(char[].class, new w());
        this.f70130a.c(AtomicBoolean.class, tVar);
        this.f70130a.c(AtomicInteger.class, j0.f71665a);
        this.f70130a.c(AtomicLong.class, u0.f71755a);
        com.alibaba.fastjson.util.g<Type, b2> gVar8 = this.f70130a;
        d1 d1Var = d1.f71596a;
        gVar8.c(AtomicReference.class, d1Var);
        this.f70130a.c(WeakReference.class, d1Var);
        this.f70130a.c(SoftReference.class, d1Var);
        this.f70130a.c(UUID.class, w0Var);
        this.f70130a.c(TimeZone.class, w0Var);
        this.f70130a.c(Locale.class, w0Var);
        this.f70130a.c(Currency.class, w0Var);
        this.f70130a.c(Inet4Address.class, w0Var);
        this.f70130a.c(Inet6Address.class, w0Var);
        this.f70130a.c(InetSocketAddress.class, w0Var);
        this.f70130a.c(File.class, w0Var);
        this.f70130a.c(URI.class, w0Var);
        this.f70130a.c(URL.class, w0Var);
        this.f70130a.c(Pattern.class, w0Var);
        this.f70130a.c(Charset.class, w0Var);
        this.f70130a.c(JSONPath.class, w0Var);
        this.f70130a.c(Number.class, a2Var);
        com.alibaba.fastjson.util.g<Type, b2> gVar9 = this.f70130a;
        m mVar = m.f71697a;
        gVar9.c(AtomicIntegerArray.class, mVar);
        this.f70130a.c(AtomicLongArray.class, mVar);
        this.f70130a.c(StackTraceElement.class, j3.f70899a);
        this.f70130a.c(Serializable.class, pVar);
        this.f70130a.c(Cloneable.class, pVar);
        this.f70130a.c(Comparable.class, pVar);
        this.f70130a.c(Closeable.class, pVar);
        this.f70130a.c(com.alibaba.fastjson.c.class, new n());
        com.alibaba.fastjson.util.i.c(this.f70148s);
    }

    public boolean v() {
        return this.f70143n;
    }

    public boolean x() {
        return this.f70147r;
    }

    public void z(Type type, b2 b2Var) {
        Type mixInAnnotations = com.alibaba.fastjson.a.getMixInAnnotations(type);
        if (mixInAnnotations == null) {
            this.f70130a.c(type, b2Var);
            return;
        }
        com.alibaba.fastjson.util.g<Type, b2> gVarB = this.f70131b.b(type);
        if (gVarB == null) {
            gVarB = new com.alibaba.fastjson.util.g<>(4);
            this.f70131b.c(type, gVarB);
        }
        gVarB.c(mixInAnnotations, b2Var);
    }
}
