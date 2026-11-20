package i30;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.media3.container.MdtaMetadataEntry;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.gslb.Worker;
import okhttp3.internal.ws.WebSocketProtocol;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f66994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f66995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f66996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f66997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f66998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public short f66999f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public short f67000g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f67001h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f67002i;

    public n(q qVar) {
        this.f66994a = qVar;
    }

    public static int e(x xVar, Object obj) {
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() | 16777216;
        }
        return obj instanceof String ? f(xVar, y.k((String) obj).e(), 0) : xVar.K("", ((q) obj).f67018d) | 50331648;
    }

    public static int f(x xVar, String str, int i11) {
        char cCharAt = str.charAt(i11);
        int I = 16777218;
        if (cCharAt == 'F') {
            return 16777218;
        }
        if (cCharAt == 'L') {
            return xVar.I(str.substring(i11 + 1, str.length() - 1)) | ASTNode.PCTX_STORED;
        }
        if (cCharAt != 'S') {
            if (cCharAt == 'V') {
                return 0;
            }
            if (cCharAt != 'I') {
                if (cCharAt == 'J') {
                    return 16777220;
                }
                if (cCharAt != 'Z') {
                    if (cCharAt == '[') {
                        int i12 = i11 + 1;
                        while (str.charAt(i12) == '[') {
                            i12++;
                        }
                        char cCharAt2 = str.charAt(i12);
                        if (cCharAt2 != 'F') {
                            if (cCharAt2 == 'L') {
                                I = xVar.I(str.substring(i12 + 1, str.length() - 1)) | ASTNode.PCTX_STORED;
                            } else if (cCharAt2 == 'S') {
                                I = 16777228;
                            } else if (cCharAt2 == 'Z') {
                                I = 16777225;
                            } else if (cCharAt2 == 'I') {
                                I = 16777217;
                            } else if (cCharAt2 != 'J') {
                                switch (cCharAt2) {
                                    case 'B':
                                        I = 16777226;
                                        break;
                                    case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                                        I = 16777227;
                                        break;
                                    case 'D':
                                        I = 16777219;
                                        break;
                                    default:
                                        throw new IllegalArgumentException();
                                }
                            } else {
                                I = 16777220;
                            }
                        }
                        return ((i12 - i11) << 28) | I;
                    }
                    switch (cCharAt) {
                        case 'B':
                        case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                            break;
                        case 'D':
                            return 16777219;
                        default:
                            throw new IllegalArgumentException();
                    }
                }
            }
        }
        return 16777217;
    }

    public static int g(x xVar, String str) {
        return xVar.I(str) | ASTNode.PCTX_STORED;
    }

    public static boolean k(x xVar, int i11, int[] iArr, int i12) {
        int iMin;
        int I;
        int i13 = iArr[i12];
        if (i13 == i11) {
            return false;
        }
        if ((268435455 & i11) == 16777221) {
            if (i13 == 16777221) {
                return false;
            }
            i11 = 16777221;
        }
        if (i13 == 0) {
            iArr[i12] = i11;
            return true;
        }
        int i14 = i13 & (-268435456);
        int iH = 16777216;
        if (i14 != 0 || (i13 & 251658240) == 33554432) {
            if (i11 == 16777221) {
                return false;
            }
            if ((i11 & ViewCompat.MEASURED_STATE_MASK) != ((-16777216) & i13)) {
                int i15 = i11 & (-268435456);
                if (i15 != 0 || (i11 & 251658240) == 33554432) {
                    if (i15 != 0 && (i11 & 251658240) != 33554432) {
                        i15 -= 268435456;
                    }
                    if (i14 != 0 && (i13 & 251658240) != 33554432) {
                        i14 -= 268435456;
                    }
                    iMin = Math.min(i15, i14) | ASTNode.PCTX_STORED;
                    I = xVar.I("java/lang/Object");
                    iH = iMin | I;
                }
            } else if ((i13 & 251658240) == 33554432) {
                iH = (i11 & (-268435456)) | ASTNode.PCTX_STORED | xVar.H(i11 & 1048575, 1048575 & i13);
            } else {
                iMin = ((i11 & (-268435456)) - 268435456) | ASTNode.PCTX_STORED;
                I = xVar.I("java/lang/Object");
                iH = iMin | I;
            }
        } else if (i13 == 16777221) {
            if ((i11 & (-268435456)) == 0 && (i11 & 251658240) != 33554432) {
                i11 = 16777216;
            }
            iH = i11;
        }
        if (iH == i13) {
            return false;
        }
        iArr[i12] = iH;
        return true;
    }

    public static void r(x xVar, int i11, d dVar) {
        int i12 = ((-268435456) & i11) >> 28;
        if (i12 == 0) {
            int i13 = i11 & 1048575;
            int i14 = i11 & 251658240;
            if (i14 == 16777216) {
                dVar.g(i13);
                return;
            } else if (i14 == 33554432) {
                dVar.g(7).k(xVar.e(xVar.T(i13).f67087e).f67083a);
                return;
            } else {
                if (i14 != 50331648) {
                    throw new AssertionError();
                }
                dVar.g(8).k((int) xVar.T(i13).f67088f);
                return;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            int i15 = i12 - 1;
            if (i12 <= 0) {
                break;
            }
            sb2.append('[');
            i12 = i15;
        }
        if ((i11 & 251658240) == 33554432) {
            sb2.append('L');
            sb2.append(xVar.T(i11 & 1048575).f67087e);
            sb2.append(';');
        } else {
            int i16 = i11 & 1048575;
            if (i16 == 1) {
                sb2.append('I');
            } else if (i16 == 2) {
                sb2.append('F');
            } else if (i16 == 3) {
                sb2.append('D');
            } else if (i16 != 4) {
                switch (i16) {
                    case 9:
                        sb2.append('Z');
                        break;
                    case 10:
                        sb2.append('B');
                        break;
                    case 11:
                        sb2.append('C');
                        break;
                    case 12:
                        sb2.append('S');
                        break;
                    default:
                        throw new AssertionError();
                }
            } else {
                sb2.append('J');
            }
        }
        dVar.g(7).k(xVar.e(sb2.toString()).f67083a);
    }

    public final void a(s sVar) {
        int i11;
        int[] iArr = this.f66995b;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        loop0: while (true) {
            while (true) {
                int i15 = 2;
                if (i13 >= iArr.length) {
                    break loop0;
                }
                int i16 = iArr[i13];
                if (i16 != 16777220 && i16 != 16777219) {
                    i15 = 1;
                }
                i13 += i15;
                i11 = i16 == 16777216 ? i11 + 1 : 0;
            }
            i14 += i11 + 1;
        }
        int[] iArr2 = this.f66996c;
        int i17 = 0;
        int i18 = 0;
        while (i17 < iArr2.length) {
            int i19 = iArr2[i17];
            i17 += (i19 == 16777220 || i19 == 16777219) ? 2 : 1;
            i18++;
        }
        int iV = sVar.V(this.f66994a.f67018d, i14, i18);
        int i21 = 0;
        while (true) {
            int i22 = i14 - 1;
            if (i14 <= 0) {
                break;
            }
            int i23 = iArr[i21];
            i21 += (i23 == 16777220 || i23 == 16777219) ? 2 : 1;
            sVar.T(iV, i23);
            i14 = i22;
            iV++;
        }
        while (true) {
            int i24 = i18 - 1;
            if (i18 <= 0) {
                sVar.U();
                return;
            }
            int i25 = iArr2[i12];
            i12 += (i25 == 16777220 || i25 == 16777219) ? 2 : 1;
            sVar.T(iV, i25);
            iV++;
            i18 = i24;
        }
    }

    public final void b(int i11) {
        if (this.f67002i == null) {
            this.f67002i = new int[2];
        }
        int length = this.f67002i.length;
        int i12 = this.f67001h;
        if (i12 >= length) {
            int[] iArr = new int[Math.max(i12 + 1, length * 2)];
            System.arraycopy(this.f67002i, 0, iArr, 0, length);
            this.f67002i = iArr;
        }
        int[] iArr2 = this.f67002i;
        int i13 = this.f67001h;
        this.f67001h = i13 + 1;
        iArr2[i13] = i11;
    }

    public final void c(n nVar) {
        this.f66995b = nVar.f66995b;
        this.f66996c = nVar.f66996c;
        this.f66999f = (short) 0;
        this.f66997d = nVar.f66997d;
        this.f66998e = nVar.f66998e;
        this.f67000g = nVar.f67000g;
        this.f67001h = nVar.f67001h;
        this.f67002i = nVar.f67002i;
    }

    /* JADX WARN: Code duplicated, block: B:119:0x0344  */
    /* JADX WARN: Code duplicated, block: B:120:0x034b  */
    /* JADX WARN: Code duplicated, block: B:121:0x034f  */
    /* JADX WARN: Code duplicated, block: B:122:0x0356  */
    /* JADX WARN: Code duplicated, block: B:50:0x0147  */
    /* JADX WARN: Code duplicated, block: B:52:0x0152  */
    /* JADX WARN: Code duplicated, block: B:59:0x018e  */
    /* JADX WARN: Code duplicated, block: B:61:0x019c  */
    public void d(int i11, int i12, w wVar, x xVar) {
        switch (i11) {
            case 0:
                return;
            case 1:
                p(16777221);
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 16:
            case 17:
                p(16777217);
                return;
            case 9:
            case 10:
                p(16777220);
                p(16777216);
                return;
            case 11:
            case 12:
            case 13:
                p(16777218);
                return;
            case 14:
            case 15:
                p(16777219);
                p(16777216);
                return;
            case 18:
                int i13 = wVar.f67084b;
                switch (i13) {
                    case 3:
                        p(16777217);
                        return;
                    case 4:
                        p(16777218);
                        return;
                    case 5:
                        p(16777220);
                        p(16777216);
                        return;
                    case 6:
                        p(16777219);
                        p(16777216);
                        return;
                    case 7:
                        p(xVar.I("java/lang/Class") | ASTNode.PCTX_STORED);
                        return;
                    case 8:
                        p(xVar.I("java/lang/String") | ASTNode.PCTX_STORED);
                        return;
                    default:
                        switch (i13) {
                            case 15:
                                p(xVar.I("java/lang/invoke/MethodHandle") | ASTNode.PCTX_STORED);
                                return;
                            case 16:
                                p(xVar.I("java/lang/invoke/MethodType") | ASTNode.PCTX_STORED);
                                return;
                            case 17:
                                q(xVar, wVar.f67087e);
                                return;
                            default:
                                throw new AssertionError();
                        }
                }
            default:
                switch (i11) {
                    case 21:
                        p(16777217);
                        return;
                    case 22:
                        p(16777220);
                        p(16777216);
                        return;
                    case 23:
                        p(16777218);
                        return;
                    case 24:
                        p(16777219);
                        p(16777216);
                        return;
                    case 25:
                        p(j(i12));
                        return;
                    default:
                        switch (i11) {
                            case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                            case 51:
                            case 52:
                            case 53:
                                n(2);
                                p(16777217);
                                return;
                            case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                n(2);
                                p(16777220);
                                p(16777216);
                                return;
                            case 48:
                                n(2);
                                p(16777218);
                                return;
                            case 49:
                                n(2);
                                p(16777219);
                                p(16777216);
                                return;
                            case 50:
                                n(1);
                                int iM = m();
                                if (iM != 16777221) {
                                    iM -= 268435456;
                                }
                                p(iM);
                                return;
                            case 54:
                            case 56:
                            case 58:
                                u(i12, m());
                                if (i12 > 0) {
                                    int i14 = i12 - 1;
                                    int iJ = j(i14);
                                    if (iJ == 16777220 || iJ == 16777219) {
                                        u(i14, 16777216);
                                        return;
                                    }
                                    int i15 = iJ & 251658240;
                                    if (i15 == 67108864 || i15 == 83886080) {
                                        u(i14, iJ | 1048576);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            case 55:
                            case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                                n(1);
                                u(i12, m());
                                u(i12 + 1, 16777216);
                                if (i12 > 0) {
                                    int i16 = i12 - 1;
                                    int iJ2 = j(i16);
                                    if (iJ2 == 16777220 || iJ2 == 16777219) {
                                        u(i16, 16777216);
                                        return;
                                    }
                                    int i17 = iJ2 & 251658240;
                                    if (i17 == 67108864 || i17 == 83886080) {
                                        u(i16, iJ2 | 1048576);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            default:
                                switch (i11) {
                                    case 79:
                                    case 81:
                                    case 83:
                                    case 84:
                                    case 85:
                                    case ModuleDescriptor.MODULE_VERSION /* 86 */:
                                        n(3);
                                        return;
                                    case 80:
                                    case 82:
                                        n(4);
                                        return;
                                    case 87:
                                    case 153:
                                    case 154:
                                    case 155:
                                    case 156:
                                    case 157:
                                    case 158:
                                    case 170:
                                    case 171:
                                    case 172:
                                    case 174:
                                    case 176:
                                    case 191:
                                    case 194:
                                    case 195:
                                        break;
                                    case 88:
                                    case 159:
                                    case 160:
                                    case 161:
                                    case 162:
                                    case 163:
                                    case 164:
                                    case 165:
                                    case 166:
                                    case 173:
                                    case 175:
                                        n(2);
                                        return;
                                    case TsExtractor.TS_STREAM_TYPE_DVBSUBS /* 89 */:
                                        int iM2 = m();
                                        p(iM2);
                                        p(iM2);
                                        return;
                                    case 90:
                                        int iM3 = m();
                                        int iM4 = m();
                                        p(iM3);
                                        p(iM4);
                                        p(iM3);
                                        return;
                                    case 91:
                                        int iM5 = m();
                                        int iM6 = m();
                                        int iM7 = m();
                                        p(iM5);
                                        p(iM7);
                                        p(iM6);
                                        p(iM5);
                                        return;
                                    case 92:
                                        int iM8 = m();
                                        int iM9 = m();
                                        p(iM9);
                                        p(iM8);
                                        p(iM9);
                                        p(iM8);
                                        return;
                                    case 93:
                                        int iM10 = m();
                                        int iM11 = m();
                                        int iM12 = m();
                                        p(iM11);
                                        p(iM10);
                                        p(iM12);
                                        p(iM11);
                                        p(iM10);
                                        return;
                                    case 94:
                                        int iM13 = m();
                                        int iM14 = m();
                                        int iM15 = m();
                                        int iM16 = m();
                                        p(iM14);
                                        p(iM13);
                                        p(iM16);
                                        p(iM15);
                                        p(iM14);
                                        p(iM13);
                                        return;
                                    case 95:
                                        int iM17 = m();
                                        int iM18 = m();
                                        p(iM17);
                                        p(iM18);
                                        return;
                                    case 96:
                                    case 100:
                                    case 104:
                                    case 108:
                                    case 112:
                                    case 120:
                                    case 122:
                                    case 124:
                                    case WebSocketProtocol.PAYLOAD_SHORT /* 126 */:
                                    case 128:
                                    case TsExtractor.TS_STREAM_TYPE_HDMV_DTS /* 130 */:
                                    case 136:
                                    case 142:
                                    case 149:
                                    case 150:
                                        n(2);
                                        p(16777217);
                                        return;
                                    case 97:
                                    case 101:
                                    case 105:
                                    case 109:
                                    case 113:
                                    case 127:
                                    case TsExtractor.TS_STREAM_TYPE_AC3 /* 129 */:
                                    case 131:
                                        n(4);
                                        p(16777220);
                                        p(16777216);
                                        return;
                                    case 98:
                                    case 102:
                                    case 106:
                                    case Worker.WHAT_QUIT /* 110 */:
                                    case 114:
                                    case 137:
                                    case 144:
                                        n(2);
                                        p(16777218);
                                        return;
                                    case 99:
                                    case Worker.WHAT_SYNC_DATA /* 103 */:
                                    case 107:
                                    case 111:
                                    case 115:
                                        n(4);
                                        p(16777219);
                                        p(16777216);
                                        return;
                                    case 116:
                                    case 117:
                                    case 118:
                                    case 119:
                                    case 145:
                                    case 146:
                                    case 147:
                                    case 167:
                                    case 177:
                                        return;
                                    case 121:
                                    case 123:
                                    case 125:
                                        n(3);
                                        p(16777220);
                                        p(16777216);
                                        return;
                                    case 132:
                                        u(i12, 16777217);
                                        return;
                                    case 133:
                                    case 140:
                                        n(1);
                                        p(16777220);
                                        p(16777216);
                                        return;
                                    case TsExtractor.TS_STREAM_TYPE_SPLICE_INFO /* 134 */:
                                        n(1);
                                        p(16777218);
                                        return;
                                    case TsExtractor.TS_STREAM_TYPE_E_AC3 /* 135 */:
                                    case 141:
                                        n(1);
                                        p(16777219);
                                        p(16777216);
                                        return;
                                    case TsExtractor.TS_STREAM_TYPE_DTS /* 138 */:
                                        n(2);
                                        p(16777219);
                                        p(16777216);
                                        return;
                                    case 139:
                                    case 190:
                                    case 193:
                                        n(1);
                                        p(16777217);
                                        return;
                                    case 143:
                                        n(2);
                                        p(16777220);
                                        p(16777216);
                                        return;
                                    case 148:
                                    case 151:
                                    case 152:
                                        n(4);
                                        p(16777217);
                                        return;
                                    case 168:
                                    case 169:
                                        throw new IllegalArgumentException("JSR/RET are not supported with computeFrames option");
                                    case 178:
                                        q(xVar, wVar.f67087e);
                                        return;
                                    case 179:
                                        o(wVar.f67087e);
                                        return;
                                    case 180:
                                        n(1);
                                        q(xVar, wVar.f67087e);
                                        return;
                                    case 181:
                                        o(wVar.f67087e);
                                        m();
                                        return;
                                    case 182:
                                    case 183:
                                    case 184:
                                    case 185:
                                        o(wVar.f67087e);
                                        if (i11 != 184) {
                                            int iM19 = m();
                                            if (i11 == 183 && wVar.f67086d.charAt(0) == '<') {
                                                b(iM19);
                                            }
                                        }
                                        q(xVar, wVar.f67087e);
                                        return;
                                    case 186:
                                        o(wVar.f67087e);
                                        q(xVar, wVar.f67087e);
                                        return;
                                    case 187:
                                        p(xVar.K(wVar.f67087e, i12) | 50331648);
                                        return;
                                    case 188:
                                        m();
                                        switch (i12) {
                                            case 4:
                                                p(285212681);
                                                return;
                                            case 5:
                                                p(285212683);
                                                return;
                                            case 6:
                                                p(285212674);
                                                return;
                                            case 7:
                                                p(285212675);
                                                return;
                                            case 8:
                                                p(285212682);
                                                return;
                                            case 9:
                                                p(285212684);
                                                return;
                                            case 10:
                                                p(285212673);
                                                return;
                                            case 11:
                                                p(285212676);
                                                return;
                                            default:
                                                throw new IllegalArgumentException();
                                        }
                                    case PsExtractor.PRIVATE_STREAM_1 /* 189 */:
                                        String str = wVar.f67087e;
                                        m();
                                        if (str.charAt(0) != '[') {
                                            p(xVar.I(str) | 301989888);
                                            return;
                                        }
                                        q(xVar, '[' + str);
                                        return;
                                    case PsExtractor.AUDIO_STREAM /* 192 */:
                                        String str2 = wVar.f67087e;
                                        m();
                                        if (str2.charAt(0) == '[') {
                                            q(xVar, str2);
                                            return;
                                        } else {
                                            p(xVar.I(str2) | ASTNode.PCTX_STORED);
                                            return;
                                        }
                                    default:
                                        switch (i11) {
                                            case 197:
                                                n(i12);
                                                q(xVar, wVar.f67087e);
                                                return;
                                            case 198:
                                            case 199:
                                                break;
                                            default:
                                                throw new IllegalArgumentException();
                                        }
                                        break;
                                }
                                n(1);
                                return;
                        }
                }
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003b  */
    /* JADX WARN: Code duplicated, block: B:22:0x0045  */
    /* JADX WARN: Code duplicated, block: B:23:0x0051 A[LOOP:0: B:7:0x000d->B:23:0x0051, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:25:0x0037 A[SYNTHETIC] */
    public final int h(x xVar, int i11) {
        int i12;
        int I;
        if (i11 == 16777222 || ((-16777216) & i11) == 50331648) {
            for (int i13 = 0; i13 < this.f67001h; i13++) {
                int i14 = this.f67002i[i13];
                int i15 = (-268435456) & i14;
                int i16 = 251658240 & i14;
                int i17 = i14 & 1048575;
                if (i16 == 67108864) {
                    i12 = this.f66995b[i17];
                } else {
                    if (i16 == 83886080) {
                        int[] iArr = this.f66996c;
                        i12 = iArr[iArr.length - i17];
                    }
                    if (i11 == i14) {
                        if (i11 == 16777222) {
                            I = xVar.I(xVar.O());
                        } else {
                            I = xVar.I(xVar.T(i11 & 1048575).f67087e);
                        }
                        return I | ASTNode.PCTX_STORED;
                    }
                }
                i14 = i12 + i15;
                if (i11 == i14) {
                    if (i11 == 16777222) {
                        I = xVar.I(xVar.O());
                    } else {
                        I = xVar.I(xVar.T(i11 & 1048575).f67087e);
                    }
                    return I | ASTNode.PCTX_STORED;
                }
            }
        }
        return i11;
    }

    public final int i() {
        return this.f66996c.length;
    }

    public final int j(int i11) {
        int[] iArr = this.f66997d;
        if (iArr == null || i11 >= iArr.length) {
            return i11 | 67108864;
        }
        int i12 = iArr[i11];
        if (i12 != 0) {
            return i12;
        }
        int i13 = i11 | 67108864;
        iArr[i11] = i13;
        return i13;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0053  */
    /* JADX WARN: Code duplicated, block: B:23:0x0056 A[PHI: r8
  0x0056: PHI (r8v8 int) = (r8v7 int), (r8v7 int), (r8v9 int), (r8v9 int) binds: [B:26:0x0065, B:28:0x0069, B:19:0x004d, B:21:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:64:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:65:0x00fb A[PHI: r6
  0x00fb: PHI (r6v6 int) = (r6v5 int), (r6v5 int), (r6v9 int), (r6v9 int) binds: [B:68:0x010a, B:70:0x010e, B:61:0x00f2, B:63:0x00f6] A[DONT_GENERATE, DONT_INLINE]] */
    public final boolean l(x xVar, n nVar, int i11) {
        boolean zK;
        boolean zK2;
        int i12;
        boolean z11;
        int iH;
        int i13;
        int i14;
        int length = this.f66995b.length;
        int length2 = this.f66996c.length;
        if (nVar.f66995b == null) {
            nVar.f66995b = new int[length];
            zK = true;
        } else {
            zK = false;
        }
        int i15 = 0;
        while (i15 < length) {
            int[] iArr = this.f66997d;
            if (iArr == null || i15 >= iArr.length || (i13 = iArr[i15]) == 0) {
                iH = this.f66995b[i15];
            } else {
                int i16 = i13 & (-268435456);
                int i17 = 251658240 & i13;
                if (i17 == 67108864) {
                    i14 = i16 + this.f66995b[i13 & 1048575];
                    if ((i13 & 1048576) == 0 || !(i14 == 16777220 || i14 == 16777219)) {
                        iH = i14;
                    } else {
                        iH = 16777216;
                    }
                } else if (i17 == 83886080) {
                    i14 = i16 + this.f66996c[length2 - (i13 & 1048575)];
                    if ((i13 & 1048576) == 0 || !(i14 == 16777220 || i14 == 16777219)) {
                        iH = i14;
                    } else {
                        iH = 16777216;
                    }
                } else {
                    iH = i13;
                }
            }
            if (this.f67002i != null) {
                iH = h(xVar, iH);
            }
            zK |= k(xVar, iH, nVar.f66995b, i15);
            i15++;
        }
        if (i11 > 0) {
            for (int i18 = 0; i18 < length; i18++) {
                zK |= k(xVar, this.f66995b[i18], nVar.f66995b, i18);
            }
            if (nVar.f66996c == null) {
                nVar.f66996c = new int[1];
                z11 = true;
            } else {
                z11 = zK;
            }
            return k(xVar, i11, nVar.f66996c, 0) | z11;
        }
        int length3 = this.f66996c.length + this.f66999f;
        if (nVar.f66996c == null) {
            nVar.f66996c = new int[this.f67000g + length3];
            zK2 = true;
        } else {
            zK2 = zK;
        }
        for (int i19 = 0; i19 < length3; i19++) {
            int iH2 = this.f66996c[i19];
            if (this.f67002i != null) {
                iH2 = h(xVar, iH2);
            }
            zK2 |= k(xVar, iH2, nVar.f66996c, i19);
        }
        for (int i21 = 0; i21 < this.f67000g; i21++) {
            int iH3 = this.f66998e[i21];
            int i22 = iH3 & (-268435456);
            int i23 = iH3 & 251658240;
            if (i23 == 67108864) {
                i12 = i22 + this.f66995b[iH3 & 1048575];
                if ((iH3 & 1048576) == 0 || !(i12 == 16777220 || i12 == 16777219)) {
                    iH3 = i12;
                } else {
                    iH3 = 16777216;
                }
            } else if (i23 == 83886080) {
                i12 = i22 + this.f66996c[length2 - (iH3 & 1048575)];
                if ((iH3 & 1048576) == 0 || !(i12 == 16777220 || i12 == 16777219)) {
                    iH3 = i12;
                } else {
                    iH3 = 16777216;
                }
            }
            if (this.f67002i != null) {
                iH3 = h(xVar, iH3);
            }
            zK2 |= k(xVar, iH3, nVar.f66996c, length3 + i21);
        }
        return zK2;
    }

    public final int m() {
        short s11 = this.f67000g;
        if (s11 <= 0) {
            short s12 = (short) (this.f66999f - 1);
            this.f66999f = s12;
            return (-s12) | 83886080;
        }
        int[] iArr = this.f66998e;
        short s13 = (short) (s11 - 1);
        this.f67000g = s13;
        return iArr[s13];
    }

    public final void n(int i11) {
        short s11 = this.f67000g;
        if (s11 >= i11) {
            this.f67000g = (short) (s11 - i11);
        } else {
            this.f66999f = (short) (this.f66999f - (i11 - s11));
            this.f67000g = (short) 0;
        }
    }

    public final void o(String str) {
        char cCharAt = str.charAt(0);
        if (cCharAt == '(') {
            n((y.c(str) >> 2) - 1);
        } else if (cCharAt == 'J' || cCharAt == 'D') {
            n(2);
        } else {
            n(1);
        }
    }

    public final void p(int i11) {
        if (this.f66998e == null) {
            this.f66998e = new int[10];
        }
        int length = this.f66998e.length;
        short s11 = this.f67000g;
        if (s11 >= length) {
            int[] iArr = new int[Math.max(s11 + 1, length * 2)];
            System.arraycopy(this.f66998e, 0, iArr, 0, length);
            this.f66998e = iArr;
        }
        int[] iArr2 = this.f66998e;
        short s12 = this.f67000g;
        short s13 = (short) (s12 + 1);
        this.f67000g = s13;
        iArr2[s12] = i11;
        short s14 = (short) (this.f66999f + s13);
        q qVar = this.f66994a;
        if (s14 > qVar.f67022h) {
            qVar.f67022h = s14;
        }
    }

    public final void q(x xVar, String str) {
        int iF = f(xVar, str, str.charAt(0) == '(' ? str.indexOf(41) + 1 : 0);
        if (iF != 0) {
            p(iF);
            if (iF == 16777220 || iF == 16777219) {
                p(16777216);
            }
        }
    }

    public final void s(x xVar, int i11, Object[] objArr, int i12, Object[] objArr2) {
        int i13 = 0;
        for (int i14 = 0; i14 < i11; i14++) {
            int i15 = i13 + 1;
            this.f66995b[i13] = e(xVar, objArr[i14]);
            Object obj = objArr[i14];
            if (obj == v.f67080e || obj == v.f67079d) {
                i13 += 2;
                this.f66995b[i15] = 16777216;
            } else {
                i13 = i15;
            }
        }
        while (true) {
            int[] iArr = this.f66995b;
            if (i13 >= iArr.length) {
                break;
            }
            iArr[i13] = 16777216;
            i13++;
        }
        int i16 = 0;
        for (int i17 = 0; i17 < i12; i17++) {
            Object obj2 = objArr2[i17];
            if (obj2 == v.f67080e || obj2 == v.f67079d) {
                i16++;
            }
        }
        this.f66996c = new int[i16 + i12];
        int i18 = 0;
        for (int i19 = 0; i19 < i12; i19++) {
            int i21 = i18 + 1;
            this.f66996c[i18] = e(xVar, objArr2[i19]);
            Object obj3 = objArr2[i19];
            if (obj3 == v.f67080e || obj3 == v.f67079d) {
                i18 += 2;
                this.f66996c[i21] = 16777216;
            } else {
                i18 = i21;
            }
        }
        this.f67000g = (short) 0;
        this.f67001h = 0;
    }

    public final void t(x xVar, int i11, String str, int i12) {
        int i13;
        int[] iArr = new int[i12];
        this.f66995b = iArr;
        this.f66996c = new int[0];
        if ((i11 & 8) == 0) {
            i13 = 1;
            if ((i11 & 262144) == 0) {
                iArr[0] = xVar.I(xVar.O()) | ASTNode.PCTX_STORED;
            } else {
                iArr[0] = 16777222;
            }
        } else {
            i13 = 0;
        }
        for (y yVar : y.b(str)) {
            int iF = f(xVar, yVar.e(), 0);
            int[] iArr2 = this.f66995b;
            int i14 = i13 + 1;
            iArr2[i13] = iF;
            if (iF == 16777220 || iF == 16777219) {
                i13 += 2;
                iArr2[i14] = 16777216;
            } else {
                i13 = i14;
            }
        }
        while (i13 < i12) {
            this.f66995b[i13] = 16777216;
            i13++;
        }
    }

    public final void u(int i11, int i12) {
        if (this.f66997d == null) {
            this.f66997d = new int[10];
        }
        int length = this.f66997d.length;
        if (i11 >= length) {
            int[] iArr = new int[Math.max(i11 + 1, length * 2)];
            System.arraycopy(this.f66997d, 0, iArr, 0, length);
            this.f66997d = iArr;
        }
        this.f66997d[i11] = i12;
    }
}
