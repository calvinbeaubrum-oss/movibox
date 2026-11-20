package n7;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import com.applovin.sdk.AppLovinEventParameters;
import com.google.android.libraries.places.api.model.PlaceTypes;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import m7.b2;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class w0 implements z0, b2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f71762c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w0 f71761b = new w0();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f71763d = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f71760a = "true".equals(com.alibaba.fastjson.util.f.k("fastjson.deserializer.fileRelativePathSupport"));

    public static String f(Node node) {
        try {
            Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
            DOMSource dOMSource = new DOMSource(node);
            StringWriter stringWriter = new StringWriter();
            transformerNewTransformer.transform(dOMSource, new StreamResult(stringWriter));
            return stringWriter.toString();
        } catch (TransformerException e11) {
            throw new JSONException("xml node to string error", e11);
        }
    }

    @Override // m7.b2
    public int b() {
        return 4;
    }

    @Override // n7.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        String strF;
        j1 j1Var = o0Var.f71701k;
        if (obj == null) {
            j1Var.g0();
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls == SimpleDateFormat.class) {
            strF = ((SimpleDateFormat) obj).toPattern();
            if (j1Var.k(SerializerFeature.WriteClassName) && obj.getClass() != type) {
                j1Var.write(123);
                j1Var.q(com.alibaba.fastjson.a.DEFAULT_TYPE_KEY);
                o0Var.I(obj.getClass().getName());
                j1Var.x(',', "val", strF);
                j1Var.write(125);
                return;
            }
        } else if (cls == Class.class) {
            strF = ((Class) obj).getName();
        } else {
            if (cls == InetSocketAddress.class) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) obj;
                InetAddress address = inetSocketAddress.getAddress();
                j1Var.write(123);
                if (address != null) {
                    j1Var.q(PlaceTypes.ADDRESS);
                    o0Var.H(address);
                    j1Var.write(44);
                }
                j1Var.q("port");
                j1Var.b0(inetSocketAddress.getPort());
                j1Var.write(125);
                return;
            }
            if (obj instanceof File) {
                strF = ((File) obj).getPath();
            } else if (obj instanceof InetAddress) {
                strF = ((InetAddress) obj).getHostAddress();
            } else if (obj instanceof TimeZone) {
                strF = ((TimeZone) obj).getID();
            } else if (obj instanceof Currency) {
                strF = ((Currency) obj).getCurrencyCode();
            } else {
                if (obj instanceof com.alibaba.fastjson.e) {
                    ((com.alibaba.fastjson.e) obj).writeJSONString(j1Var);
                    return;
                }
                if (obj instanceof Iterator) {
                    g(o0Var, j1Var, (Iterator) obj);
                    return;
                }
                if (obj instanceof Iterable) {
                    g(o0Var, j1Var, ((Iterable) obj).iterator());
                    return;
                }
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    if (key instanceof String) {
                        String str = (String) key;
                        if (value instanceof String) {
                            j1Var.U('{', str, (String) value);
                        } else {
                            j1Var.write(123);
                            j1Var.q(str);
                            o0Var.H(value);
                        }
                    } else {
                        j1Var.write(123);
                        o0Var.H(key);
                        j1Var.write(58);
                        o0Var.H(value);
                    }
                    j1Var.write(125);
                    return;
                }
                if (obj.getClass().getName().equals("net.sf.json.JSONNull")) {
                    j1Var.g0();
                    return;
                } else {
                    if (!(obj instanceof Node)) {
                        throw new JSONException("not support class : " + cls);
                    }
                    strF = f((Node) obj);
                }
            }
        }
        j1Var.j0(strF);
    }

    /* JADX WARN: Type inference failed for: r11v39, types: [T, java.text.DateFormat, java.text.SimpleDateFormat] */
    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        Object objX;
        String str;
        l7.b bVar = aVar.f70077g;
        InetAddress inetAddress = null;
        int i11 = 0;
        if (type != InetSocketAddress.class) {
            if (aVar.f70082l == 2) {
                aVar.f70082l = 0;
                aVar.a(16);
                if (bVar.k0() != 4) {
                    throw new JSONException("syntax error");
                }
                if (!"val".equals(bVar.g0())) {
                    throw new JSONException("syntax error");
                }
                bVar.w();
                aVar.a(17);
                objX = aVar.x();
                aVar.a(13);
            } else {
                objX = aVar.x();
            }
            if (objX == null) {
                str = null;
            } else {
                if (!(objX instanceof String)) {
                    if (!(objX instanceof JSONObject)) {
                        throw new JSONException("expect string");
                    }
                    JSONObject jSONObject = (JSONObject) objX;
                    if (type == Currency.class) {
                        String string = jSONObject.getString(AppLovinEventParameters.REVENUE_CURRENCY);
                        if (string != null) {
                            return (T) Currency.getInstance(string);
                        }
                        String string2 = jSONObject.getString("currencyCode");
                        if (string2 != null) {
                            return (T) Currency.getInstance(string2);
                        }
                    }
                    return type == Map.Entry.class ? (T) jSONObject.entrySet().iterator().next() : (T) jSONObject.toJavaObject(type);
                }
                str = (String) objX;
            }
            if (str == null || str.length() == 0) {
                return null;
            }
            if (type == UUID.class) {
                return (T) UUID.fromString(str);
            }
            if (type == URI.class) {
                return (T) URI.create(str);
            }
            if (type == URL.class) {
                try {
                    return (T) new URL(str);
                } catch (MalformedURLException e11) {
                    throw new JSONException("create url error", e11);
                }
            }
            if (type == Pattern.class) {
                return (T) Pattern.compile(str);
            }
            if (type == Locale.class) {
                return (T) TypeUtils.O0(str);
            }
            if (type == SimpleDateFormat.class) {
                ?? r11 = (T) new SimpleDateFormat(str, bVar.u0());
                r11.setTimeZone(bVar.h0());
                return r11;
            }
            if (type == InetAddress.class || type == Inet4Address.class || type == Inet6Address.class) {
                try {
                    return (T) InetAddress.getByName(str);
                } catch (UnknownHostException e12) {
                    throw new JSONException("deserialize inet adress error", e12);
                }
            }
            if (type == File.class) {
                if (str.indexOf("..") < 0 || f71760a) {
                    return (T) new File(str);
                }
                throw new JSONException("file relative path not support.");
            }
            if (type == TimeZone.class) {
                return (T) TimeZone.getTimeZone(str);
            }
            if (type instanceof ParameterizedType) {
                type = ((ParameterizedType) type).getRawType();
            }
            if (type == Class.class) {
                return (T) TypeUtils.C0(str, aVar.h().n(), false);
            }
            if (type == Charset.class) {
                return (T) Charset.forName(str);
            }
            if (type == Currency.class) {
                return (T) Currency.getInstance(str);
            }
            if (type == JSONPath.class) {
                return (T) new JSONPath(str);
            }
            if (!(type instanceof Class)) {
                throw new JSONException("MiscCodec not support " + type.toString());
            }
            String name = ((Class) type).getName();
            if (name.equals("java.nio.file.Path")) {
                try {
                    if (f71762c == null && !f71763d) {
                        f71762c = TypeUtils.A0("java.nio.file.Paths").getMethod("get", String.class, String[].class);
                    }
                    Method method = f71762c;
                    if (method != null) {
                        return (T) method.invoke(null, str, new String[0]);
                    }
                    throw new JSONException("Path deserialize erorr");
                } catch (IllegalAccessException e13) {
                    throw new JSONException("Path deserialize erorr", e13);
                } catch (NoSuchMethodException unused) {
                    f71763d = true;
                } catch (InvocationTargetException e14) {
                    throw new JSONException("Path deserialize erorr", e14);
                }
            }
            throw new JSONException("MiscCodec not support " + name);
        }
        if (bVar.k0() == 8) {
            bVar.w();
            return null;
        }
        aVar.a(12);
        while (true) {
            String strG0 = bVar.g0();
            bVar.W(17);
            if (strG0.equals(PlaceTypes.ADDRESS)) {
                aVar.a(17);
                inetAddress = (InetAddress) aVar.j0(InetAddress.class);
            } else if (strG0.equals("port")) {
                aVar.a(17);
                if (bVar.k0() != 2) {
                    throw new JSONException("port is not int");
                }
                int iH = bVar.h();
                bVar.w();
                i11 = iH;
            } else {
                aVar.a(17);
                aVar.x();
            }
            if (bVar.k0() != 16) {
                aVar.a(13);
                return (T) new InetSocketAddress(inetAddress, i11);
            }
            bVar.w();
        }
    }

    public void g(o0 o0Var, j1 j1Var, Iterator<?> it) {
        j1Var.write(91);
        int i11 = 0;
        while (it.hasNext()) {
            if (i11 != 0) {
                j1Var.write(44);
            }
            o0Var.H(it.next());
            i11++;
        }
        j1Var.write(93);
    }
}
