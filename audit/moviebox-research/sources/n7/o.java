package n7;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import java.lang.reflect.Type;
import m7.b2;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class o implements z0, b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f71699a = new o();

    public static boolean k(Class<?> cls) {
        return cls == Point.class || cls == Rectangle.class || cls == Font.class || cls == Color.class;
    }

    @Override // m7.b2
    public int b() {
        return 12;
    }

    @Override // n7.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        j1 j1Var = o0Var.f71701k;
        if (obj == null) {
            j1Var.g0();
            return;
        }
        if (obj instanceof Point) {
            Point point = (Point) obj;
            j1Var.u(l(j1Var, Point.class, '{'), "x", point.x);
            j1Var.u(',', "y", point.y);
        } else if (obj instanceof Font) {
            Font font = (Font) obj;
            j1Var.x(l(j1Var, Font.class, '{'), "name", font.getName());
            j1Var.u(',', TtmlNode.TAG_STYLE, font.getStyle());
            j1Var.u(',', "size", font.getSize());
        } else if (obj instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) obj;
            j1Var.u(l(j1Var, Rectangle.class, '{'), "x", rectangle.x);
            j1Var.u(',', "y", rectangle.y);
            j1Var.u(',', "width", rectangle.width);
            j1Var.u(',', "height", rectangle.height);
        } else {
            if (!(obj instanceof Color)) {
                throw new JSONException("not support awt class : " + obj.getClass().getName());
            }
            Color color = (Color) obj;
            j1Var.u(l(j1Var, Color.class, '{'), CampaignEx.JSON_KEY_AD_R, color.getRed());
            j1Var.u(',', "g", color.getGreen());
            j1Var.u(',', DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, color.getBlue());
            if (color.getAlpha() > 0) {
                j1Var.u(',', "alpha", color.getAlpha());
            }
        }
        j1Var.write(125);
    }

    @Override // m7.b2
    public <T> T e(l7.a aVar, Type type, Object obj) {
        T t11;
        l7.b bVar = aVar.f70077g;
        if (bVar.k0() == 8) {
            bVar.W(16);
            return null;
        }
        if (bVar.k0() != 12 && bVar.k0() != 16) {
            throw new JSONException("syntax error");
        }
        bVar.w();
        if (type == Point.class) {
            t11 = (T) h(aVar, obj);
        } else if (type == Rectangle.class) {
            t11 = (T) i(aVar);
        } else if (type == Color.class) {
            t11 = (T) f(aVar);
        } else {
            if (type != Font.class) {
                throw new JSONException("not support awt class : " + type);
            }
            t11 = (T) g(aVar);
        }
        l7.g gVarI = aVar.i();
        aVar.v0(t11, obj);
        aVar.x0(gVarI);
        return t11;
    }

    public Color f(l7.a aVar) {
        l7.b bVar = aVar.f70077g;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (bVar.k0() != 13) {
            if (bVar.k0() != 4) {
                throw new JSONException("syntax error");
            }
            String strG0 = bVar.g0();
            bVar.j(2);
            if (bVar.k0() != 2) {
                throw new JSONException("syntax error");
            }
            int iH = bVar.h();
            bVar.w();
            if (strG0.equalsIgnoreCase(CampaignEx.JSON_KEY_AD_R)) {
                i11 = iH;
            } else if (strG0.equalsIgnoreCase("g")) {
                i12 = iH;
            } else if (strG0.equalsIgnoreCase(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)) {
                i13 = iH;
            } else {
                if (!strG0.equalsIgnoreCase("alpha")) {
                    throw new JSONException("syntax error, " + strG0);
                }
                i14 = iH;
            }
            if (bVar.k0() == 16) {
                bVar.W(4);
            }
        }
        bVar.w();
        return new Color(i11, i12, i13, i14);
    }

    public Font g(l7.a aVar) {
        l7.b bVar = aVar.f70077g;
        int iH = 0;
        String strG0 = null;
        int iH2 = 0;
        while (bVar.k0() != 13) {
            if (bVar.k0() != 4) {
                throw new JSONException("syntax error");
            }
            String strG1 = bVar.g0();
            bVar.j(2);
            if (strG1.equalsIgnoreCase("name")) {
                if (bVar.k0() != 4) {
                    throw new JSONException("syntax error");
                }
                strG0 = bVar.g0();
                bVar.w();
            } else if (strG1.equalsIgnoreCase(TtmlNode.TAG_STYLE)) {
                if (bVar.k0() != 2) {
                    throw new JSONException("syntax error");
                }
                iH = bVar.h();
                bVar.w();
            } else {
                if (!strG1.equalsIgnoreCase("size")) {
                    throw new JSONException("syntax error, " + strG1);
                }
                if (bVar.k0() != 2) {
                    throw new JSONException("syntax error");
                }
                iH2 = bVar.h();
                bVar.w();
            }
            if (bVar.k0() == 16) {
                bVar.W(4);
            }
        }
        bVar.w();
        return new Font(strG0, iH, iH2);
    }

    public Point h(l7.a aVar, Object obj) {
        int iJ0;
        l7.b bVar = aVar.f70077g;
        int i11 = 0;
        int i12 = 0;
        while (bVar.k0() != 13) {
            if (bVar.k0() != 4) {
                throw new JSONException("syntax error");
            }
            String strG0 = bVar.g0();
            if (com.alibaba.fastjson.a.DEFAULT_TYPE_KEY.equals(strG0)) {
                aVar.b("java.awt.Point");
            } else {
                if ("$ref".equals(strG0)) {
                    return (Point) j(aVar, obj);
                }
                bVar.j(2);
                int iK0 = bVar.k0();
                if (iK0 == 2) {
                    iJ0 = bVar.h();
                    bVar.w();
                } else {
                    if (iK0 != 3) {
                        throw new JSONException("syntax error : " + bVar.q());
                    }
                    iJ0 = (int) bVar.j0();
                    bVar.w();
                }
                if (strG0.equalsIgnoreCase("x")) {
                    i11 = iJ0;
                } else {
                    if (!strG0.equalsIgnoreCase("y")) {
                        throw new JSONException("syntax error, " + strG0);
                    }
                    i12 = iJ0;
                }
                if (bVar.k0() == 16) {
                    bVar.W(4);
                }
            }
        }
        bVar.w();
        return new Point(i11, i12);
    }

    public Rectangle i(l7.a aVar) {
        int iJ0;
        l7.b bVar = aVar.f70077g;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (bVar.k0() != 13) {
            if (bVar.k0() != 4) {
                throw new JSONException("syntax error");
            }
            String strG0 = bVar.g0();
            bVar.j(2);
            int iK0 = bVar.k0();
            if (iK0 == 2) {
                iJ0 = bVar.h();
                bVar.w();
            } else {
                if (iK0 != 3) {
                    throw new JSONException("syntax error");
                }
                iJ0 = (int) bVar.j0();
                bVar.w();
            }
            if (strG0.equalsIgnoreCase("x")) {
                i11 = iJ0;
            } else if (strG0.equalsIgnoreCase("y")) {
                i12 = iJ0;
            } else if (strG0.equalsIgnoreCase("width")) {
                i13 = iJ0;
            } else {
                if (!strG0.equalsIgnoreCase("height")) {
                    throw new JSONException("syntax error, " + strG0);
                }
                i14 = iJ0;
            }
            if (bVar.k0() == 16) {
                bVar.W(4);
            }
        }
        bVar.w();
        return new Rectangle(i11, i12, i13, i14);
    }

    public final Object j(l7.a aVar, Object obj) {
        l7.b bVarP = aVar.p();
        bVarP.j(4);
        String strG0 = bVarP.g0();
        aVar.v0(aVar.i(), obj);
        aVar.d(new l7.a.C0751a(aVar.i(), strG0));
        aVar.t0();
        aVar.A0(1);
        bVarP.W(13);
        aVar.a(13);
        return null;
    }

    public char l(j1 j1Var, Class<?> cls, char c11) {
        if (!j1Var.k(SerializerFeature.WriteClassName)) {
            return c11;
        }
        j1Var.write(123);
        j1Var.q(com.alibaba.fastjson.a.DEFAULT_TYPE_KEY);
        j1Var.j0(cls.getName());
        return ',';
    }
}
