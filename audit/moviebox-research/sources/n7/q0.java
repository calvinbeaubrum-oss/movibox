package n7;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Locale;
import java.util.TimeZone;
import m7.b2;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
import org.joda.time.Instant;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.Period;
import org.joda.time.ReadablePartial;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class q0 implements z0, a0, b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q0 f71722a = new q0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DateTimeFormatter f71723b = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final DateTimeFormatter f71724c = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final DateTimeFormatter f71725d = DateTimeFormat.forPattern("yyyy/MM/dd HH:mm:ss");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final DateTimeFormatter f71726e = DateTimeFormat.forPattern("yyyy年M月d日 HH:mm:ss");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final DateTimeFormatter f71727f = DateTimeFormat.forPattern("yyyy年M月d日 H时m分s秒");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final DateTimeFormatter f71728g = DateTimeFormat.forPattern("yyyy년M월d일 HH:mm:ss");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final DateTimeFormatter f71729h = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final DateTimeFormatter f71730i = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final DateTimeFormatter f71731j = DateTimeFormat.forPattern("dd.MM.yyyy HH:mm:ss");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final DateTimeFormatter f71732k = DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final DateTimeFormatter f71733l = DateTimeFormat.forPattern("yyyyMMdd");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final DateTimeFormatter f71734m = DateTimeFormat.forPattern("yyyy/MM/dd");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final DateTimeFormatter f71735n = DateTimeFormat.forPattern("yyyy年M月d日");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final DateTimeFormatter f71736o = DateTimeFormat.forPattern("yyyy년M월d일");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final DateTimeFormatter f71737p = DateTimeFormat.forPattern("MM/dd/yyyy");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final DateTimeFormatter f71738q = DateTimeFormat.forPattern("dd/MM/yyyy");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final DateTimeFormatter f71739r = DateTimeFormat.forPattern("dd.MM.yyyy");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final DateTimeFormatter f71740s = DateTimeFormat.forPattern("dd-MM-yyyy");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final DateTimeFormatter f71741t = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").withZone(DateTimeZone.getDefault());

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final DateTimeFormatter f71742u = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Override // m7.b2
    public int b() {
        return 4;
    }

    @Override // n7.a0
    public void c(o0 o0Var, Object obj, p pVar) throws IOException {
        j(o0Var.f71701k, (ReadablePartial) obj, pVar.b());
    }

    @Override // n7.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        j1 j1Var = o0Var.f71701k;
        if (obj == null) {
            j1Var.g0();
            return;
        }
        if (type == null) {
            type = obj.getClass();
        }
        if (type != LocalDateTime.class) {
            j1Var.j0(obj.toString());
            return;
        }
        SerializerFeature serializerFeature = SerializerFeature.UseISO8601DateFormat;
        int mask = serializerFeature.getMask();
        LocalDateTime localDateTime = (LocalDateTime) obj;
        String strV = o0Var.v();
        if (strV == null) {
            if ((i11 & mask) != 0 || o0Var.A(serializerFeature)) {
                strV = "yyyy-MM-dd'T'HH:mm:ss";
            } else if (o0Var.A(SerializerFeature.WriteDateUseDateFormat)) {
                strV = com.alibaba.fastjson.a.DEFFAULT_DATE_FORMAT;
            } else {
                strV = localDateTime.getMillisOfSecond() == 0 ? "yyyy-MM-dd'T'HH:mm:ss.SSS" : "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS";
            }
        }
        if (strV != null) {
            j(j1Var, localDateTime, strV);
        } else {
            j1Var.e0(localDateTime.toDateTime(DateTimeZone.forTimeZone(com.alibaba.fastjson.a.defaultTimeZone)).toInstant().getMillis());
        }
    }

    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        return (T) f(aVar, type, obj, null, 0);
    }

    /* JADX WARN: Type inference failed for: r6v6, types: [T, org.joda.time.LocalDateTime] */
    public <T> T f(l7.a aVar, Type type, Object obj, String str, int i11) {
        l7.b bVar = aVar.f70077g;
        if (bVar.k0() == 8) {
            bVar.w();
            return null;
        }
        if (bVar.k0() == 4) {
            String strG0 = bVar.g0();
            bVar.w();
            DateTimeFormatter dateTimeFormatterForPattern = str != null ? "yyyy-MM-dd HH:mm:ss".equals(str) ? f71723b : DateTimeFormat.forPattern(str) : null;
            if ("".equals(strG0)) {
                return null;
            }
            if (type == LocalDateTime.class) {
                return (strG0.length() == 10 || strG0.length() == 8) ? (T) h(strG0, str, dateTimeFormatterForPattern).toLocalDateTime(LocalTime.MIDNIGHT) : (T) g(strG0, dateTimeFormatterForPattern);
            }
            if (type == LocalDate.class) {
                return strG0.length() == 23 ? (T) LocalDateTime.parse(strG0).toLocalDate() : (T) h(strG0, str, dateTimeFormatterForPattern);
            }
            if (type == LocalTime.class) {
                return strG0.length() == 23 ? (T) LocalDateTime.parse(strG0).toLocalTime() : (T) LocalTime.parse(strG0);
            }
            if (type == DateTime.class) {
                if (dateTimeFormatterForPattern == f71723b) {
                    dateTimeFormatterForPattern = f71741t;
                }
                return (T) i(strG0, dateTimeFormatterForPattern);
            }
            if (type == DateTimeZone.class) {
                return (T) DateTimeZone.forID(strG0);
            }
            if (type == Period.class) {
                return (T) Period.parse(strG0);
            }
            if (type == Duration.class) {
                return (T) Duration.parse(strG0);
            }
            if (type == Instant.class) {
                for (int i12 = 0; i12 < strG0.length(); i12++) {
                    char cCharAt = strG0.charAt(i12);
                    if (cCharAt < '0' || cCharAt > '9') {
                        return (T) Instant.parse(strG0);
                    }
                }
                if (strG0.length() > 8 && strG0.length() < 19) {
                    return (T) new Instant(Long.parseLong(strG0));
                }
                return (T) Instant.parse(strG0);
            }
            if (type == DateTimeFormatter.class) {
                return (T) DateTimeFormat.forPattern(strG0);
            }
        } else {
            if (bVar.k0() == 2) {
                long jD = bVar.d();
                bVar.w();
                TimeZone timeZone = com.alibaba.fastjson.a.defaultTimeZone;
                if (timeZone == null) {
                    timeZone = TimeZone.getDefault();
                }
                if (type == DateTime.class) {
                    return (T) new DateTime(jD, DateTimeZone.forTimeZone(timeZone));
                }
                ?? r11 = (T) new LocalDateTime(jD, DateTimeZone.forTimeZone(timeZone));
                if (type == LocalDateTime.class) {
                    return r11;
                }
                if (type == LocalDate.class) {
                    return (T) r11.toLocalDate();
                }
                if (type == LocalTime.class) {
                    return (T) r11.toLocalTime();
                }
                if (type == Instant.class) {
                    return (T) new Instant(jD);
                }
                throw new UnsupportedOperationException();
            }
            if (bVar.k0() != 12) {
                throw new UnsupportedOperationException();
            }
            JSONObject jSONObjectI0 = aVar.i0();
            if (type == Instant.class) {
                Object obj2 = jSONObjectI0.get("epochSecond");
                if (obj2 instanceof Number) {
                    return (T) Instant.ofEpochSecond(TypeUtils.D0((Number) obj2));
                }
                Object obj3 = jSONObjectI0.get("millis");
                if (obj3 instanceof Number) {
                    return (T) Instant.ofEpochMilli(TypeUtils.D0((Number) obj3));
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00ea  */
    public LocalDateTime g(String str, DateTimeFormatter dateTimeFormatter) {
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
                        dateTimeFormatter2 = f71742u;
                    } else if (cCharAt3 == ' ') {
                        dateTimeFormatter2 = f71723b;
                    } else {
                        dateTimeFormatter2 = dateTimeFormatter;
                    }
                } else if (cCharAt == '/' && cCharAt2 == '/') {
                    dateTimeFormatter2 = f71725d;
                } else {
                    char cCharAt6 = str.charAt(0);
                    char cCharAt7 = str.charAt(1);
                    char cCharAt8 = str.charAt(2);
                    char cCharAt9 = str.charAt(3);
                    char cCharAt10 = str.charAt(5);
                    if (cCharAt8 == '/' && cCharAt10 == '/') {
                        int i11 = ((cCharAt9 - '0') * 10) + (cCharAt - '0');
                        if (((cCharAt6 - '0') * 10) + (cCharAt7 - '0') > 12) {
                            dateTimeFormatter2 = f71730i;
                        } else if (i11 > 12) {
                            dateTimeFormatter2 = f71729h;
                        } else {
                            String country = Locale.getDefault().getCountry();
                            if (country.equals("US")) {
                                dateTimeFormatter2 = f71729h;
                            } else if (country.equals("BR") || country.equals("AU")) {
                                dateTimeFormatter2 = f71730i;
                            } else {
                                dateTimeFormatter2 = dateTimeFormatter;
                            }
                        }
                    } else if (cCharAt8 == '.' && cCharAt10 == '.') {
                        dateTimeFormatter2 = f71731j;
                    } else if (cCharAt8 == '-' && cCharAt10 == '-') {
                        dateTimeFormatter2 = f71732k;
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
                    dateTimeFormatter2 = f71724c;
                } else {
                    dateTimeFormatter2 = dateTimeFormatter;
                }
            } else {
                dateTimeFormatter2 = dateTimeFormatter;
            }
            if (str.length() >= 17) {
                char cCharAt17 = str.charAt(4);
                if (cCharAt17 == 24180) {
                    dateTimeFormatter2 = str.charAt(str.length() - 1) == 31186 ? f71727f : f71726e;
                } else if (cCharAt17 == 45380) {
                    dateTimeFormatter2 = f71728g;
                }
            }
            for (int i12 = 0; i12 < str.length(); i12++) {
                char cCharAt18 = str.charAt(i12);
                if (cCharAt18 >= '0' && cCharAt18 <= '9') {
                }
            }
            if (str.length() > 8 && str.length() < 19) {
                return new LocalDateTime(Long.parseLong(str), DateTimeZone.forTimeZone(com.alibaba.fastjson.a.defaultTimeZone));
            }
        } else {
            dateTimeFormatter2 = dateTimeFormatter;
        }
        return dateTimeFormatter2 == null ? LocalDateTime.parse(str) : LocalDateTime.parse(str, dateTimeFormatter2);
    }

    public LocalDate h(String str, String str2, DateTimeFormatter dateTimeFormatter) {
        DateTimeFormatter dateTimeFormatter2;
        DateTimeFormatter dateTimeFormatter3;
        if (dateTimeFormatter == null) {
            if (str.length() == 8) {
                dateTimeFormatter = f71733l;
            }
            if (str.length() == 10) {
                char cCharAt = str.charAt(4);
                char cCharAt2 = str.charAt(7);
                if (cCharAt == '/' && cCharAt2 == '/') {
                    dateTimeFormatter = f71734m;
                }
                char cCharAt3 = str.charAt(0);
                char cCharAt4 = str.charAt(1);
                char cCharAt5 = str.charAt(2);
                char cCharAt6 = str.charAt(3);
                char cCharAt7 = str.charAt(5);
                if (cCharAt5 == '/' && cCharAt7 == '/') {
                    int i11 = ((cCharAt6 - '0') * 10) + (cCharAt - '0');
                    if (((cCharAt3 - '0') * 10) + (cCharAt4 - '0') > 12) {
                        dateTimeFormatter3 = f71738q;
                    } else if (i11 > 12) {
                        dateTimeFormatter3 = f71737p;
                    } else {
                        String country = Locale.getDefault().getCountry();
                        if (country.equals("US")) {
                            dateTimeFormatter3 = f71737p;
                        } else if (country.equals("BR") || country.equals("AU")) {
                            dateTimeFormatter3 = f71738q;
                        }
                    }
                    dateTimeFormatter = dateTimeFormatter3;
                } else if (cCharAt5 == '.' && cCharAt7 == '.') {
                    dateTimeFormatter = f71739r;
                } else if (cCharAt5 == '-' && cCharAt7 == '-') {
                    dateTimeFormatter = f71740s;
                }
            }
            if (str.length() >= 9) {
                char cCharAt8 = str.charAt(4);
                if (cCharAt8 == 24180) {
                    dateTimeFormatter2 = f71735n;
                } else if (cCharAt8 == 45380) {
                    dateTimeFormatter2 = f71736o;
                }
                dateTimeFormatter = dateTimeFormatter2;
            }
            for (int i12 = 0; i12 < str.length(); i12++) {
                char cCharAt9 = str.charAt(i12);
                if (cCharAt9 >= '0' && cCharAt9 <= '9') {
                }
            }
            if (str.length() > 8 && str.length() < 19) {
                return new LocalDateTime(Long.parseLong(str), DateTimeZone.forTimeZone(com.alibaba.fastjson.a.defaultTimeZone)).toLocalDate();
            }
        }
        return dateTimeFormatter == null ? LocalDate.parse(str) : LocalDate.parse(str, dateTimeFormatter);
    }

    public DateTime i(String str, DateTimeFormatter dateTimeFormatter) {
        if (dateTimeFormatter == null) {
            if (str.length() == 19) {
                char cCharAt = str.charAt(4);
                char cCharAt2 = str.charAt(7);
                char cCharAt3 = str.charAt(10);
                char cCharAt4 = str.charAt(13);
                char cCharAt5 = str.charAt(16);
                if (cCharAt4 == ':' && cCharAt5 == ':') {
                    if (cCharAt == '-' && cCharAt2 == '-') {
                        if (cCharAt3 == 'T') {
                            dateTimeFormatter = f71742u;
                        } else if (cCharAt3 == ' ') {
                            dateTimeFormatter = f71723b;
                        }
                    } else if (cCharAt == '/' && cCharAt2 == '/') {
                        dateTimeFormatter = f71725d;
                    } else {
                        char cCharAt6 = str.charAt(0);
                        char cCharAt7 = str.charAt(1);
                        char cCharAt8 = str.charAt(2);
                        char cCharAt9 = str.charAt(3);
                        char cCharAt10 = str.charAt(5);
                        if (cCharAt8 == '/' && cCharAt10 == '/') {
                            int i11 = ((cCharAt9 - '0') * 10) + (cCharAt - '0');
                            if (((cCharAt6 - '0') * 10) + (cCharAt7 - '0') > 12) {
                                dateTimeFormatter = f71730i;
                            } else if (i11 > 12) {
                                dateTimeFormatter = f71729h;
                            } else {
                                String country = Locale.getDefault().getCountry();
                                if (country.equals("US")) {
                                    dateTimeFormatter = f71729h;
                                } else if (country.equals("BR") || country.equals("AU")) {
                                    dateTimeFormatter = f71730i;
                                }
                            }
                        } else if (cCharAt8 == '.' && cCharAt10 == '.') {
                            dateTimeFormatter = f71731j;
                        } else if (cCharAt8 == '-' && cCharAt10 == '-') {
                            dateTimeFormatter = f71732k;
                        }
                    }
                }
            }
            if (str.length() >= 17) {
                char cCharAt11 = str.charAt(4);
                if (cCharAt11 == 24180) {
                    dateTimeFormatter = str.charAt(str.length() - 1) == 31186 ? f71727f : f71726e;
                } else if (cCharAt11 == 45380) {
                    dateTimeFormatter = f71728g;
                }
            }
        }
        return dateTimeFormatter == null ? DateTime.parse(str) : DateTime.parse(str, dateTimeFormatter);
    }

    public final void j(j1 j1Var, ReadablePartial readablePartial, String str) {
        j1Var.j0((str.equals("yyyy-MM-dd'T'HH:mm:ss") ? f71742u : DateTimeFormat.forPattern(str)).print(readablePartial));
    }
}
