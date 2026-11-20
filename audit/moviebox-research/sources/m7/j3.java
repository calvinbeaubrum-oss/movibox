package m7;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.Feature;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class j3 implements b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j3 f70899a = new j3();

    @Override // m7.b2
    public int b() {
        return 12;
    }

    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        l7.b bVar = aVar.f70077g;
        if (bVar.k0() == 8) {
            bVar.w();
            return null;
        }
        if (bVar.k0() != 12 && bVar.k0() != 16) {
            throw new JSONException("syntax error: " + l7.f.a(bVar.k0()));
        }
        String strG0 = null;
        String strG1 = null;
        String strG2 = null;
        int iH = 0;
        while (true) {
            String strE0 = bVar.e0(aVar.t());
            if (strE0 == null) {
                if (bVar.k0() == 13) {
                    bVar.W(16);
                    break;
                }
                if (bVar.k0() != 16 || !bVar.g(Feature.AllowArbitraryCommas)) {
                }
            }
            bVar.j(4);
            if ("className".equals(strE0)) {
                if (bVar.k0() == 8) {
                    strG0 = null;
                } else {
                    if (bVar.k0() != 4) {
                        throw new JSONException("syntax error");
                    }
                    strG0 = bVar.g0();
                }
            } else if ("methodName".equals(strE0)) {
                if (bVar.k0() == 8) {
                    strG1 = null;
                } else {
                    if (bVar.k0() != 4) {
                        throw new JSONException("syntax error");
                    }
                    strG1 = bVar.g0();
                }
            } else if ("fileName".equals(strE0)) {
                if (bVar.k0() == 8) {
                    strG2 = null;
                } else {
                    if (bVar.k0() != 4) {
                        throw new JSONException("syntax error");
                    }
                    strG2 = bVar.g0();
                }
            } else if ("lineNumber".equals(strE0)) {
                if (bVar.k0() == 8) {
                    iH = 0;
                } else {
                    if (bVar.k0() != 2) {
                        throw new JSONException("syntax error");
                    }
                    iH = bVar.h();
                }
            } else if ("nativeMethod".equals(strE0)) {
                if (bVar.k0() != 8 && bVar.k0() != 6 && bVar.k0() != 7) {
                    throw new JSONException("syntax error");
                }
                bVar.W(16);
            } else if (strE0 == com.alibaba.fastjson.a.DEFAULT_TYPE_KEY) {
                if (bVar.k0() == 4) {
                    String strG3 = bVar.g0();
                    if (!strG3.equals("java.lang.StackTraceElement")) {
                        throw new JSONException("syntax error : " + strG3);
                    }
                } else if (bVar.k0() != 8) {
                    throw new JSONException("syntax error");
                }
            } else if ("moduleName".equals(strE0)) {
                if (bVar.k0() != 8) {
                    if (bVar.k0() != 4) {
                        throw new JSONException("syntax error");
                    }
                    bVar.g0();
                }
            } else if ("moduleVersion".equals(strE0)) {
                if (bVar.k0() != 8) {
                    if (bVar.k0() != 4) {
                        throw new JSONException("syntax error");
                    }
                    bVar.g0();
                }
            } else {
                if (!"classLoaderName".equals(strE0)) {
                    throw new JSONException("syntax error : " + strE0);
                }
                if (bVar.k0() != 8) {
                    if (bVar.k0() != 4) {
                        throw new JSONException("syntax error");
                    }
                    bVar.g0();
                }
            }
            if (bVar.k0() == 13) {
                bVar.W(16);
                break;
            }
        }
        return (T) new StackTraceElement(strG0, strG1, strG2, iH);
    }
}
