package m7;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.util.TypeUtils;
import com.google.android.gms.ads.RequestConfiguration;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends e {
    @Override // m7.e, m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        return (T) f(aVar, type, obj, null, 0);
    }

    @Override // m7.e
    public <T> T f(l7.a aVar, Type type, Object obj, String str, int i11) throws Throwable {
        Object objX;
        Object obj2;
        Object time;
        SimpleDateFormat simpleDateFormat;
        Object obj3;
        SimpleDateFormat simpleDateFormat2;
        l7.b bVar = aVar.f70077g;
        if (bVar.k0() == 2) {
            long jD = bVar.d();
            bVar.W(16);
            if ("unixtime".equals(str)) {
                jD *= 1000;
            }
            objX = Long.valueOf(jD);
        } else {
            Object obj4 = null;
            if (bVar.k0() == 4) {
                String strG0 = bVar.g0();
                if (str != null) {
                    if ("yyyy-MM-dd HH:mm:ss.SSSSSSSSS".equals(str) && (type instanceof Class) && ((Class) type).getName().equals("java.sql.Timestamp")) {
                        return (T) TypeUtils.B(strG0);
                    }
                    try {
                        simpleDateFormat = new SimpleDateFormat(str, aVar.f70077g.u0());
                    } catch (IllegalArgumentException e11) {
                        if (str.contains(RequestConfiguration.MAX_AD_CONTENT_RATING_T)) {
                            try {
                                simpleDateFormat = new SimpleDateFormat(str.replaceAll(RequestConfiguration.MAX_AD_CONTENT_RATING_T, "'T'"), aVar.f70077g.u0());
                            } catch (IllegalArgumentException unused) {
                                throw e11;
                            }
                        } else {
                            simpleDateFormat = null;
                        }
                    }
                    if (com.alibaba.fastjson.a.defaultTimeZone != null) {
                        simpleDateFormat.setTimeZone(aVar.f70077g.h0());
                    }
                    try {
                        obj3 = simpleDateFormat.parse(strG0);
                    } catch (ParseException unused2) {
                        obj3 = null;
                    }
                    if (obj3 == null && com.alibaba.fastjson.a.defaultLocale == Locale.CHINA) {
                        try {
                            simpleDateFormat2 = new SimpleDateFormat(str, Locale.US);
                        } catch (IllegalArgumentException e12) {
                            simpleDateFormat2 = simpleDateFormat;
                            if (str.contains(RequestConfiguration.MAX_AD_CONTENT_RATING_T)) {
                                try {
                                    simpleDateFormat2 = new SimpleDateFormat(str.replaceAll(RequestConfiguration.MAX_AD_CONTENT_RATING_T, "'T'"), aVar.f70077g.u0());
                                } catch (IllegalArgumentException unused3) {
                                    throw e12;
                                }
                            }
                        }
                        simpleDateFormat2.setTimeZone(aVar.f70077g.h0());
                        try {
                            obj3 = simpleDateFormat2.parse(strG0);
                        } catch (ParseException unused4) {
                            obj3 = null;
                        }
                    }
                    if (obj3 != null) {
                        obj4 = obj3;
                    } else if (str.equals("yyyy-MM-dd'T'HH:mm:ss.SSS") && strG0.length() == 19) {
                        try {
                            SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", com.alibaba.fastjson.a.defaultLocale);
                            simpleDateFormat3.setTimeZone(com.alibaba.fastjson.a.defaultTimeZone);
                            obj4 = simpleDateFormat3.parse(strG0);
                        } catch (ParseException unused5) {
                        }
                    }
                }
                if (obj4 == null) {
                    bVar.W(16);
                    if (bVar.g(Feature.AllowISO8601DateFormat)) {
                        l7.e eVar = new l7.e(strG0);
                        if (eVar.p1()) {
                            obj2 = strG0;
                            time = strG0;
                            time = eVar.C0().getTime();
                        }
                        obj2 = strG0;
                        time = strG0;
                        eVar.close();
                        obj2 = time;
                    }
                    obj2 = strG0;
                    objX = obj2;
                } else {
                    objX = obj4;
                }
            } else if (bVar.k0() == 8) {
                bVar.w();
                objX = obj4;
            } else if (bVar.k0() == 12) {
                bVar.w();
                if (bVar.k0() != 4) {
                    throw new JSONException("syntax error");
                }
                if (com.alibaba.fastjson.a.DEFAULT_TYPE_KEY.equals(bVar.g0())) {
                    bVar.w();
                    aVar.a(17);
                    Type typeJ = aVar.h().j(bVar.g0(), null, bVar.m());
                    if (typeJ != null) {
                        type = typeJ;
                    }
                    aVar.a(4);
                    aVar.a(16);
                }
                bVar.j(2);
                if (bVar.k0() != 2) {
                    throw new JSONException("syntax error : " + bVar.q());
                }
                long jD2 = bVar.d();
                bVar.w();
                Object objValueOf = Long.valueOf(jD2);
                aVar.a(13);
                objX = objValueOf;
            } else if (aVar.r() == 2) {
                aVar.A0(0);
                aVar.a(16);
                if (bVar.k0() != 4) {
                    throw new JSONException("syntax error");
                }
                if (!"val".equals(bVar.g0())) {
                    throw new JSONException("syntax error");
                }
                bVar.w();
                aVar.a(17);
                Object objX2 = aVar.x();
                aVar.a(13);
                objX = objX2;
            } else {
                objX = aVar.x();
            }
        }
        return (T) g(aVar, type, obj, objX);
    }

    public abstract <T> T g(l7.a aVar, Type type, Object obj, Object obj2);
}
