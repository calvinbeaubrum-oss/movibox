package m7;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;
import java.util.TimeZone;
import okhttp3.internal.connection.RealConnection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class y1 extends e implements n7.z0, n7.a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y1 f70915a = new y1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DateTimeFormatter f70916b = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final DateTimeFormatter f70917c = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final DateTimeFormatter f70918d = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final DateTimeFormatter f70919e = DateTimeFormatter.ofPattern("yyyy年M月d日 HH:mm:ss");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final DateTimeFormatter f70920f = DateTimeFormatter.ofPattern("yyyy年M月d日 H时m分s秒");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final DateTimeFormatter f70921g = DateTimeFormatter.ofPattern("yyyy년M월d일 HH:mm:ss");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final DateTimeFormatter f70922h = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final DateTimeFormatter f70923i = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final DateTimeFormatter f70924j = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final DateTimeFormatter f70925k = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final DateTimeFormatter f70926l = DateTimeFormatter.ofPattern("yyyyMMdd");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final DateTimeFormatter f70927m = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final DateTimeFormatter f70928n = DateTimeFormatter.ofPattern("yyyy年M月d日");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final DateTimeFormatter f70929o = DateTimeFormatter.ofPattern("yyyy년M월d일");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final DateTimeFormatter f70930p = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final DateTimeFormatter f70931q = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final DateTimeFormatter f70932r = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final DateTimeFormatter f70933s = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final DateTimeFormatter f70934t = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final DateTimeFormatter f70935u = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public static Object g(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        if (str == null) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        return LocalDateTime.parse(obj.toString(), DateTimeFormatter.ofPattern(str));
    }

    @Override // m7.b2
    public int b() {
        return 4;
    }

    @Override // n7.a0
    public void c(n7.o0 o0Var, Object obj, n7.p pVar) throws IOException {
        k(o0Var.f71701k, r.a(obj), pVar.b());
    }

    @Override // n7.z0
    public void d(n7.o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        n7.j1 j1Var = o0Var.f71701k;
        if (obj == null) {
            j1Var.g0();
            return;
        }
        if (type == null) {
            type = obj.getClass();
        }
        if (type != i1.a()) {
            j1Var.j0(obj.toString());
            return;
        }
        SerializerFeature serializerFeature = SerializerFeature.UseISO8601DateFormat;
        int mask = serializerFeature.getMask();
        LocalDateTime localDateTimeA = t1.a(obj);
        String strV = o0Var.v();
        if (strV == null) {
            strV = "yyyy-MM-dd'T'HH:mm:ss";
            if ((i11 & mask) == 0 && !o0Var.A(serializerFeature)) {
                if (o0Var.A(SerializerFeature.WriteDateUseDateFormat)) {
                    strV = (o0Var.w() == null || o0Var.w().length() <= 0) ? com.alibaba.fastjson.a.DEFFAULT_DATE_FORMAT : o0Var.w();
                } else {
                    int nano = localDateTimeA.getNano();
                    if (nano != 0) {
                        strV = nano % 1000000 == 0 ? "yyyy-MM-dd'T'HH:mm:ss.SSS" : "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS";
                    }
                }
            }
        }
        if (strV != null) {
            k(j1Var, localDateTimeA, strV);
        } else {
            j1Var.e0(localDateTimeA.atZone(com.alibaba.fastjson.a.defaultTimeZone.toZoneId()).toInstant().toEpochMilli());
        }
    }

    @Override // m7.e
    public <T> T f(l7.a aVar, Type type, Object obj, String str, int i11) {
        Long l11;
        DateTimeFormatter dateTimeFormatterOfPattern;
        l7.b bVar = aVar.f70077g;
        if (bVar.k0() == 8) {
            bVar.w();
            return null;
        }
        if (bVar.k0() == 4) {
            String strG0 = bVar.g0();
            bVar.w();
            if (str != null) {
                dateTimeFormatterOfPattern = "yyyy-MM-dd HH:mm:ss".equals(str) ? f70916b : DateTimeFormatter.ofPattern(str);
            } else {
                dateTimeFormatterOfPattern = null;
            }
            if ("".equals(strG0)) {
                return null;
            }
            if (type == i1.a()) {
                return (strG0.length() == 10 || strG0.length() == 8) ? (T) LocalDateTime.of(i(strG0, str, dateTimeFormatterOfPattern), LocalTime.MIN) : (T) h(strG0, dateTimeFormatterOfPattern);
            }
            if (type == w0.a()) {
                if (strG0.length() != 23) {
                    return (T) i(strG0, str, dateTimeFormatterOfPattern);
                }
                LocalDateTime localDateTime = LocalDateTime.parse(strG0);
                return (T) LocalDate.of(localDateTime.getYear(), localDateTime.getMonthValue(), localDateTime.getDayOfMonth());
            }
            int i12 = 0;
            if (type == s.a()) {
                if (strG0.length() == 23) {
                    LocalDateTime localDateTime2 = LocalDateTime.parse(strG0);
                    return (T) LocalTime.of(localDateTime2.getHour(), localDateTime2.getMinute(), localDateTime2.getSecond(), localDateTime2.getNano());
                }
                while (i12 < strG0.length()) {
                    char cCharAt = strG0.charAt(i12);
                    if (cCharAt < '0' || cCharAt > '9') {
                        return (T) LocalTime.parse(strG0);
                    }
                    i12++;
                }
                if (strG0.length() > 8 && strG0.length() < 19) {
                    return (T) LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(strG0)), com.alibaba.fastjson.a.defaultTimeZone.toZoneId()).toLocalTime();
                }
                return (T) LocalTime.parse(strG0);
            }
            if (type == d0.a()) {
                if (dateTimeFormatterOfPattern == f70916b) {
                    dateTimeFormatterOfPattern = f70934t;
                }
                if (dateTimeFormatterOfPattern == null && strG0.length() <= 19) {
                    l7.e eVar = new l7.e(strG0);
                    TimeZone timeZoneH0 = aVar.f70077g.h0();
                    eVar.h1(timeZoneH0);
                    if (eVar.q1(false)) {
                        return (T) ZonedDateTime.ofInstant(eVar.C0().getTime().toInstant(), timeZoneH0.toZoneId());
                    }
                }
                return (T) j(strG0, dateTimeFormatterOfPattern);
            }
            if (type == g0.a()) {
                return (T) OffsetDateTime.parse(strG0);
            }
            if (type == i0.a()) {
                return (T) OffsetTime.parse(strG0);
            }
            if (type == l0.a()) {
                return (T) ZoneId.of(strG0);
            }
            if (type == o0.a()) {
                return (T) Period.parse(strG0);
            }
            if (type == q0.a()) {
                return (T) Duration.parse(strG0);
            }
            if (type == s0.a()) {
                while (i12 < strG0.length()) {
                    char cCharAt2 = strG0.charAt(i12);
                    if (cCharAt2 < '0' || cCharAt2 > '9') {
                        return (T) Instant.parse(strG0);
                    }
                    i12++;
                }
                if (strG0.length() > 8 && strG0.length() < 19) {
                    return (T) Instant.ofEpochMilli(Long.parseLong(strG0));
                }
                return (T) Instant.parse(strG0);
            }
        } else {
            if (bVar.k0() == 2) {
                long jD = bVar.d();
                bVar.w();
                if ("unixtime".equals(str)) {
                    jD *= 1000;
                } else if ("yyyyMMddHHmmss".equals(str)) {
                    int i13 = (int) (jD / RealConnection.IDLE_CONNECTION_HEALTHY_NS);
                    int i14 = (int) ((jD / 100000000) % 100);
                    int i15 = (int) ((jD / 1000000) % 100);
                    int i16 = (int) ((jD / 10000) % 100);
                    int i17 = (int) ((jD / 100) % 100);
                    int i18 = (int) (jD % 100);
                    if (type == i1.a()) {
                        return (T) LocalDateTime.of(i13, i14, i15, i16, i17, i18);
                    }
                }
                if (type == i1.a()) {
                    return (T) LocalDateTime.ofInstant(Instant.ofEpochMilli(jD), com.alibaba.fastjson.a.defaultTimeZone.toZoneId());
                }
                if (type == w0.a()) {
                    return (T) LocalDateTime.ofInstant(Instant.ofEpochMilli(jD), com.alibaba.fastjson.a.defaultTimeZone.toZoneId()).toLocalDate();
                }
                if (type == s.a()) {
                    return (T) LocalDateTime.ofInstant(Instant.ofEpochMilli(jD), com.alibaba.fastjson.a.defaultTimeZone.toZoneId()).toLocalTime();
                }
                if (type == d0.a()) {
                    return (T) ZonedDateTime.ofInstant(Instant.ofEpochMilli(jD), com.alibaba.fastjson.a.defaultTimeZone.toZoneId());
                }
                if (type == s0.a()) {
                    return (T) Instant.ofEpochMilli(jD);
                }
                throw new UnsupportedOperationException();
            }
            if (bVar.k0() != 12) {
                throw new UnsupportedOperationException();
            }
            JSONObject jSONObjectI0 = aVar.i0();
            if (type == s0.a()) {
                Object obj2 = jSONObjectI0.get("epochSecond");
                Object obj3 = jSONObjectI0.get("nano");
                boolean z11 = obj2 instanceof Number;
                if (z11 && (obj3 instanceof Number)) {
                    return (T) Instant.ofEpochSecond(TypeUtils.D0((Number) obj2), TypeUtils.D0((Number) obj3));
                }
                if (z11) {
                    return (T) Instant.ofEpochSecond(TypeUtils.D0((Number) obj2));
                }
            } else if (type == q0.a() && (l11 = jSONObjectI0.getLong("seconds")) != null) {
                return (T) Duration.ofSeconds(l11.longValue(), jSONObjectI0.getLongValue("nano"));
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00ec  */
    public LocalDateTime h(String str, DateTimeFormatter dateTimeFormatter) {
        DateTimeFormatter dateTimeFormatter2;
        if (dateTimeFormatter == null) {
            if (str.length() == 19) {
                char cCharAt = str.charAt(4);
                char cCharAt2 = str.charAt(7);
                char cCharAt3 = str.charAt(10);
                char cCharAt4 = str.charAt(13);
                char cCharAt5 = str.charAt(16);
                if (cCharAt4 != ':' || cCharAt5 != ':') {
                    dateTimeFormatter2 = dateTimeFormatter;
                } else if (cCharAt == '-' && cCharAt2 == '-') {
                    if (cCharAt3 == 'T') {
                        dateTimeFormatter2 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                    } else if (cCharAt3 == ' ') {
                        dateTimeFormatter2 = f70916b;
                    } else {
                        dateTimeFormatter2 = dateTimeFormatter;
                    }
                } else if (cCharAt == '/' && cCharAt2 == '/') {
                    dateTimeFormatter2 = f70918d;
                } else {
                    char cCharAt6 = str.charAt(0);
                    char cCharAt7 = str.charAt(1);
                    char cCharAt8 = str.charAt(2);
                    char cCharAt9 = str.charAt(3);
                    char cCharAt10 = str.charAt(5);
                    if (cCharAt8 == '/' && cCharAt10 == '/') {
                        int i11 = ((cCharAt9 - '0') * 10) + (cCharAt - '0');
                        if (((cCharAt6 - '0') * 10) + (cCharAt7 - '0') > 12) {
                            dateTimeFormatter2 = f70923i;
                        } else if (i11 > 12) {
                            dateTimeFormatter2 = f70922h;
                        } else {
                            String country = Locale.getDefault().getCountry();
                            if (country.equals("US")) {
                                dateTimeFormatter2 = f70922h;
                            } else if (country.equals("BR") || country.equals("AU")) {
                                dateTimeFormatter2 = f70923i;
                            } else {
                                dateTimeFormatter2 = dateTimeFormatter;
                            }
                        }
                    } else if (cCharAt8 == '.' && cCharAt10 == '.') {
                        dateTimeFormatter2 = f70924j;
                    } else if (cCharAt8 == '-' && cCharAt10 == '-') {
                        dateTimeFormatter2 = f70925k;
                    } else {
                        dateTimeFormatter2 = dateTimeFormatter;
                    }
                }
            } else if (str.length() == 23) {
                char cCharAt11 = str.charAt(4);
                char cCharAt12 = str.charAt(7);
                char cCharAt13 = str.charAt(10);
                char cCharAt14 = str.charAt(13);
                char cCharAt15 = str.charAt(16);
                char cCharAt16 = str.charAt(19);
                if (cCharAt14 == ':' && cCharAt15 == ':' && cCharAt11 == '-' && cCharAt12 == '-' && cCharAt13 == ' ' && cCharAt16 == '.') {
                    dateTimeFormatter2 = f70917c;
                } else {
                    dateTimeFormatter2 = dateTimeFormatter;
                }
            } else {
                dateTimeFormatter2 = dateTimeFormatter;
            }
            if (str.length() >= 17) {
                char cCharAt17 = str.charAt(4);
                if (cCharAt17 == 24180) {
                    dateTimeFormatter2 = str.charAt(str.length() - 1) == 31186 ? f70920f : f70919e;
                } else if (cCharAt17 == 45380) {
                    dateTimeFormatter2 = f70921g;
                }
            }
        } else {
            dateTimeFormatter2 = dateTimeFormatter;
        }
        if (dateTimeFormatter2 == null) {
            l7.e eVar = new l7.e(str);
            if (eVar.q1(false)) {
                return LocalDateTime.ofInstant(eVar.C0().toInstant(), ZoneId.systemDefault());
            }
            for (int i12 = 0; i12 < str.length(); i12++) {
                char cCharAt18 = str.charAt(i12);
                if (cCharAt18 >= '0' && cCharAt18 <= '9') {
                }
            }
            if (str.length() > 8 && str.length() < 19) {
                return LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(str)), com.alibaba.fastjson.a.defaultTimeZone.toZoneId());
            }
        }
        return dateTimeFormatter2 == null ? LocalDateTime.parse(str) : LocalDateTime.parse(str, dateTimeFormatter2);
    }

    public LocalDate i(String str, String str2, DateTimeFormatter dateTimeFormatter) {
        DateTimeFormatter dateTimeFormatter2;
        DateTimeFormatter dateTimeFormatter3;
        if (dateTimeFormatter == null) {
            if (str.length() == 8) {
                dateTimeFormatter = f70926l;
            }
            if (str.length() == 10) {
                char cCharAt = str.charAt(4);
                char cCharAt2 = str.charAt(7);
                if (cCharAt == '/' && cCharAt2 == '/') {
                    dateTimeFormatter = f70927m;
                }
                char cCharAt3 = str.charAt(0);
                char cCharAt4 = str.charAt(1);
                char cCharAt5 = str.charAt(2);
                char cCharAt6 = str.charAt(3);
                char cCharAt7 = str.charAt(5);
                if (cCharAt5 == '/' && cCharAt7 == '/') {
                    int i11 = ((cCharAt6 - '0') * 10) + (cCharAt - '0');
                    if (((cCharAt3 - '0') * 10) + (cCharAt4 - '0') > 12) {
                        dateTimeFormatter3 = f70931q;
                    } else if (i11 > 12) {
                        dateTimeFormatter3 = f70930p;
                    } else {
                        String country = Locale.getDefault().getCountry();
                        if (country.equals("US")) {
                            dateTimeFormatter3 = f70930p;
                        } else if (country.equals("BR") || country.equals("AU")) {
                            dateTimeFormatter3 = f70931q;
                        }
                    }
                    dateTimeFormatter = dateTimeFormatter3;
                } else if (cCharAt5 == '.' && cCharAt7 == '.') {
                    dateTimeFormatter = f70932r;
                } else if (cCharAt5 == '-' && cCharAt7 == '-') {
                    dateTimeFormatter = f70933s;
                }
            }
            if (str.length() >= 9) {
                char cCharAt8 = str.charAt(4);
                if (cCharAt8 == 24180) {
                    dateTimeFormatter2 = f70928n;
                } else if (cCharAt8 == 45380) {
                    dateTimeFormatter2 = f70929o;
                }
                dateTimeFormatter = dateTimeFormatter2;
            }
            for (int i12 = 0; i12 < str.length(); i12++) {
                char cCharAt9 = str.charAt(i12);
                if (cCharAt9 >= '0' && cCharAt9 <= '9') {
                }
            }
            if (str.length() > 8 && str.length() < 19) {
                return LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(str)), com.alibaba.fastjson.a.defaultTimeZone.toZoneId()).toLocalDate();
            }
        }
        return dateTimeFormatter == null ? LocalDate.parse(str) : LocalDate.parse(str, dateTimeFormatter);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00bb  */
    public ZonedDateTime j(String str, DateTimeFormatter dateTimeFormatter) {
        DateTimeFormatter dateTimeFormatter2;
        if (dateTimeFormatter == null) {
            if (str.length() == 19) {
                char cCharAt = str.charAt(4);
                char cCharAt2 = str.charAt(7);
                char cCharAt3 = str.charAt(10);
                char cCharAt4 = str.charAt(13);
                char cCharAt5 = str.charAt(16);
                if (cCharAt4 != ':' || cCharAt5 != ':') {
                    dateTimeFormatter2 = dateTimeFormatter;
                } else if (cCharAt == '-' && cCharAt2 == '-') {
                    if (cCharAt3 == 'T') {
                        dateTimeFormatter2 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                    } else if (cCharAt3 == ' ') {
                        dateTimeFormatter2 = f70916b;
                    } else {
                        dateTimeFormatter2 = dateTimeFormatter;
                    }
                } else if (cCharAt == '/' && cCharAt2 == '/') {
                    dateTimeFormatter2 = f70918d;
                } else {
                    char cCharAt6 = str.charAt(0);
                    char cCharAt7 = str.charAt(1);
                    char cCharAt8 = str.charAt(2);
                    char cCharAt9 = str.charAt(3);
                    char cCharAt10 = str.charAt(5);
                    if (cCharAt8 == '/' && cCharAt10 == '/') {
                        int i11 = ((cCharAt9 - '0') * 10) + (cCharAt - '0');
                        if (((cCharAt6 - '0') * 10) + (cCharAt7 - '0') > 12) {
                            dateTimeFormatter2 = f70923i;
                        } else if (i11 > 12) {
                            dateTimeFormatter2 = f70922h;
                        } else {
                            String country = Locale.getDefault().getCountry();
                            if (country.equals("US")) {
                                dateTimeFormatter2 = f70922h;
                            } else if (country.equals("BR") || country.equals("AU")) {
                                dateTimeFormatter2 = f70923i;
                            } else {
                                dateTimeFormatter2 = dateTimeFormatter;
                            }
                        }
                    } else if (cCharAt8 == '.' && cCharAt10 == '.') {
                        dateTimeFormatter2 = f70924j;
                    } else if (cCharAt8 == '-' && cCharAt10 == '-') {
                        dateTimeFormatter2 = f70925k;
                    } else {
                        dateTimeFormatter2 = dateTimeFormatter;
                    }
                }
            } else {
                dateTimeFormatter2 = dateTimeFormatter;
            }
            if (str.length() >= 17) {
                char cCharAt11 = str.charAt(4);
                if (cCharAt11 == 24180) {
                    dateTimeFormatter2 = str.charAt(str.length() - 1) == 31186 ? f70920f : f70919e;
                } else if (cCharAt11 == 45380) {
                    dateTimeFormatter2 = f70921g;
                }
            }
            for (int i12 = 0; i12 < str.length(); i12++) {
                char cCharAt12 = str.charAt(i12);
                if (cCharAt12 >= '0' && cCharAt12 <= '9') {
                }
            }
            if (str.length() > 8 && str.length() < 19) {
                return ZonedDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(str)), com.alibaba.fastjson.a.defaultTimeZone.toZoneId());
            }
        } else {
            dateTimeFormatter2 = dateTimeFormatter;
        }
        return dateTimeFormatter2 == null ? ZonedDateTime.parse(str) : ZonedDateTime.parse(str, dateTimeFormatter2);
    }

    public final void k(n7.j1 j1Var, TemporalAccessor temporalAccessor, String str) {
        Instant instant;
        if ("unixtime".equals(str)) {
            if (k1.a(temporalAccessor)) {
                j1Var.b0((int) n1.a(temporalAccessor).toEpochSecond());
                return;
            } else if (l1.a(temporalAccessor)) {
                j1Var.b0((int) t1.a(temporalAccessor).atZone(com.alibaba.fastjson.a.defaultTimeZone.toZoneId()).toEpochSecond());
                return;
            }
        }
        if ("millis".equals(str)) {
            if (k1.a(temporalAccessor)) {
                instant = n1.a(temporalAccessor).toInstant();
            } else {
                instant = l1.a(temporalAccessor) ? t1.a(temporalAccessor).atZone(com.alibaba.fastjson.a.defaultTimeZone.toZoneId()).toInstant() : null;
            }
            if (instant != null) {
                j1Var.e0(instant.toEpochMilli());
                return;
            }
        }
        j1Var.j0((str == "yyyy-MM-dd'T'HH:mm:ss" ? f70935u : DateTimeFormatter.ofPattern(str)).format(temporalAccessor));
    }
}
