package com.google.android.gms.internal.ads;

import android.text.Layout;
import androidx.annotation.Nullable;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.transsion.gslb.Utils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzalr implements zzakr {
    private final XmlPullParserFactory zzi;
    private static final Pattern zzc = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern zzd = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern zze = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    static final Pattern zza = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    static final Pattern zzb = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final Pattern zzf = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
    private static final Pattern zzg = Pattern.compile("^(\\d+) (\\d+)$");
    private static final zzalp zzh = new zzalp(30.0f, 1, 1);

    public zzalr() {
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.zzi = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e11) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e11);
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00f5  */
    private static long zzc(String str, zzalp zzalpVar) throws zzakn {
        double d11;
        double d12;
        Matcher matcher = zzc.matcher(str);
        byte b11 = 2;
        if (matcher.matches()) {
            String strGroup = matcher.group(1);
            strGroup.getClass();
            long j11 = Long.parseLong(strGroup) * 3600;
            String strGroup2 = matcher.group(2);
            strGroup2.getClass();
            long j12 = Long.parseLong(strGroup2) * 60;
            String strGroup3 = matcher.group(3);
            strGroup3.getClass();
            double d13 = j11 + j12;
            double d14 = Long.parseLong(strGroup3);
            String strGroup4 = matcher.group(4);
            double d15 = 0.0d;
            double d16 = strGroup4 != null ? Double.parseDouble(strGroup4) : 0.0d;
            double d17 = d13 + d14;
            String strGroup5 = matcher.group(5);
            double d18 = strGroup5 != null ? Long.parseLong(strGroup5) / zzalpVar.zza : 0.0d;
            double d19 = d17 + d16;
            String strGroup6 = matcher.group(6);
            if (strGroup6 != null) {
                d15 = (Long.parseLong(strGroup6) / ((double) zzalpVar.zzb)) / ((double) zzalpVar.zza);
            }
            return (long) ((d19 + d18 + d15) * 1000000.0d);
        }
        Matcher matcher2 = zzd.matcher(str);
        if (!matcher2.matches()) {
            throw new zzakn("Malformed time expression: ".concat(String.valueOf(str)));
        }
        String strGroup7 = matcher2.group(1);
        strGroup7.getClass();
        double d21 = Double.parseDouble(strGroup7);
        String strGroup8 = matcher2.group(2);
        strGroup8.getClass();
        int iHashCode = strGroup8.hashCode();
        if (iHashCode != 102) {
            if (iHashCode != 104) {
                if (iHashCode != 109) {
                    if (iHashCode != 3494) {
                        if (iHashCode != 115) {
                            if (iHashCode == 116 && strGroup8.equals("t")) {
                                b11 = 5;
                            } else {
                                b11 = -1;
                            }
                        } else if (!strGroup8.equals("s")) {
                            b11 = -1;
                        }
                    } else if (strGroup8.equals("ms")) {
                        b11 = 3;
                    } else {
                        b11 = -1;
                    }
                } else if (strGroup8.equals("m")) {
                    b11 = 1;
                } else {
                    b11 = -1;
                }
            } else if (strGroup8.equals("h")) {
                b11 = 0;
            } else {
                b11 = -1;
            }
        } else if (strGroup8.equals("f")) {
            b11 = 4;
        } else {
            b11 = -1;
        }
        if (b11 != 0) {
            if (b11 != 1) {
                if (b11 == 3) {
                    d12 = 1000.0d;
                } else if (b11 == 4) {
                    d12 = zzalpVar.zza;
                } else if (b11 == 5) {
                    d12 = zzalpVar.zzc;
                }
                d21 /= d12;
            } else {
                d11 = 60.0d;
            }
            return (long) (d21 * 1000000.0d);
        }
        d11 = 3600.0d;
        d21 *= d11;
        return (long) (d21 * 1000000.0d);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x0042  */
    @Nullable
    private static Layout.Alignment zzd(String str) {
        byte b11;
        switch (zzfwk.zza(str)) {
            case "center":
                b11 = 4;
                break;
            case "end":
                b11 = 3;
                break;
            case "left":
                b11 = 0;
                break;
            case "right":
                b11 = 2;
                break;
            case "start":
                b11 = 1;
                break;
            default:
                b11 = -1;
                break;
        }
        if (b11 == 0 || b11 == 1) {
            return Layout.Alignment.ALIGN_NORMAL;
        }
        if (b11 == 2 || b11 == 3) {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        if (b11 != 4) {
            return null;
        }
        return Layout.Alignment.ALIGN_CENTER;
    }

    private static zzalu zze(@Nullable zzalu zzaluVar) {
        return zzaluVar == null ? new zzalu() : zzaluVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:52:0x00c1  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static zzalu zzf(XmlPullParser xmlPullParser, zzalu zzaluVar) {
        byte b11;
        Matcher matcher;
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i11 = 0; i11 < attributeCount; i11++) {
            String attributeValue = xmlPullParser.getAttributeValue(i11);
            String attributeName = xmlPullParser.getAttributeName(i11);
            byte b12 = -1;
            switch (attributeName.hashCode()) {
                case -1550943582:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_FONT_STYLE)) {
                        b11 = 6;
                    } else {
                        b11 = -1;
                    }
                    break;
                case -1224696685:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_FONT_FAMILY)) {
                        b11 = 3;
                    } else {
                        b11 = -1;
                    }
                    break;
                case -1065511464:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_TEXT_ALIGN)) {
                        b11 = 7;
                    } else {
                        b11 = -1;
                    }
                    break;
                case -879295043:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_TEXT_DECORATION)) {
                        b11 = Ascii.FF;
                    } else {
                        b11 = -1;
                    }
                    break;
                case -734428249:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_FONT_WEIGHT)) {
                        b11 = 5;
                    } else {
                        b11 = -1;
                    }
                    break;
                case 3355:
                    if (attributeName.equals("id")) {
                        b11 = 0;
                    } else {
                        b11 = -1;
                    }
                    break;
                case 3511770:
                    if (attributeName.equals("ruby")) {
                        b11 = 10;
                    } else {
                        b11 = -1;
                    }
                    break;
                case 94842723:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_COLOR)) {
                        b11 = 2;
                    } else {
                        b11 = -1;
                    }
                    break;
                case 109403361:
                    if (attributeName.equals("shear")) {
                        b11 = Ascii.SO;
                    } else {
                        b11 = -1;
                    }
                    break;
                case 110138194:
                    if (attributeName.equals("textCombine")) {
                        b11 = 9;
                    } else {
                        b11 = -1;
                    }
                    break;
                case 365601008:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_FONT_SIZE)) {
                        b11 = 4;
                    } else {
                        b11 = -1;
                    }
                    break;
                case 921125321:
                    if (attributeName.equals("textEmphasis")) {
                        b11 = Ascii.CR;
                    } else {
                        b11 = -1;
                    }
                    break;
                case 1115953443:
                    if (attributeName.equals("rubyPosition")) {
                        b11 = Ascii.VT;
                    } else {
                        b11 = -1;
                    }
                    break;
                case 1287124693:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                        b11 = 1;
                    } else {
                        b11 = -1;
                    }
                    break;
                case 1754920356:
                    if (attributeName.equals("multiRowAlign")) {
                        b11 = 8;
                    } else {
                        b11 = -1;
                    }
                    break;
                default:
                    b11 = -1;
                    break;
            }
            switch (b11) {
                case 0:
                    if (TtmlNode.TAG_STYLE.equals(xmlPullParser.getName())) {
                        zzaluVar = zze(zzaluVar);
                        zzaluVar.zzs(attributeValue);
                    }
                    break;
                case 1:
                    zzaluVar = zze(zzaluVar);
                    try {
                        zzaluVar.zzm(zzen.zzb(attributeValue));
                    } catch (IllegalArgumentException unused) {
                        zzff.zzf("TtmlParser", "Failed parsing background value: ".concat(String.valueOf(attributeValue)));
                    }
                    break;
                case 2:
                    zzaluVar = zze(zzaluVar);
                    try {
                        zzaluVar.zzo(zzen.zzb(attributeValue));
                    } catch (IllegalArgumentException unused2) {
                        zzff.zzf("TtmlParser", "Failed parsing color value: ".concat(String.valueOf(attributeValue)));
                    }
                    break;
                case 3:
                    zzaluVar = zze(zzaluVar);
                    zzaluVar.zzp(attributeValue);
                    break;
                case 4:
                    try {
                        zzaluVar = zze(zzaluVar);
                        int i12 = zzfy.zza;
                        String[] strArrSplit = attributeValue.split("\\s+", -1);
                        int length = strArrSplit.length;
                        if (length == 1) {
                            matcher = zze.matcher(attributeValue);
                        } else {
                            if (length != 2) {
                                throw new zzakn("Invalid number of entries for fontSize: " + length + InstructionFileId.DOT);
                            }
                            matcher = zze.matcher(strArrSplit[1]);
                            zzff.zzf("TtmlParser", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
                        }
                        if (!matcher.matches()) {
                            throw new zzakn("Invalid expression for fontSize: '" + attributeValue + "'.");
                        }
                        String strGroup = matcher.group(3);
                        strGroup.getClass();
                        int iHashCode = strGroup.hashCode();
                        if (iHashCode != 37) {
                            if (iHashCode != 3240) {
                                if (iHashCode == 3592 && strGroup.equals("px")) {
                                    b12 = 0;
                                }
                            } else if (strGroup.equals("em")) {
                                b12 = 1;
                            }
                        } else if (strGroup.equals("%")) {
                            b12 = 2;
                        }
                        if (b12 == 0) {
                            zzaluVar.zzr(1);
                        } else if (b12 == 1) {
                            zzaluVar.zzr(2);
                        } else {
                            if (b12 != 2) {
                                throw new zzakn("Invalid unit for fontSize: '" + strGroup + "'.");
                            }
                            zzaluVar.zzr(3);
                        }
                        String strGroup2 = matcher.group(1);
                        strGroup2.getClass();
                        zzaluVar.zzq(Float.parseFloat(strGroup2));
                    } catch (zzakn unused3) {
                        zzff.zzf("TtmlParser", "Failed parsing fontSize value: ".concat(String.valueOf(attributeValue)));
                    }
                    break;
                case 5:
                    zzaluVar = zze(zzaluVar);
                    zzaluVar.zzn(TtmlNode.BOLD.equalsIgnoreCase(attributeValue));
                    break;
                case 6:
                    zzaluVar = zze(zzaluVar);
                    zzaluVar.zzt(TtmlNode.ITALIC.equalsIgnoreCase(attributeValue));
                    break;
                case 7:
                    zzaluVar = zze(zzaluVar);
                    zzaluVar.zzz(zzd(attributeValue));
                    break;
                case 8:
                    zzaluVar = zze(zzaluVar);
                    zzaluVar.zzv(zzd(attributeValue));
                    break;
                case 9:
                    String strZza = zzfwk.zza(attributeValue);
                    int iHashCode2 = strZza.hashCode();
                    if (iHashCode2 != 96673) {
                        if (iHashCode2 == 3387192 && strZza.equals(DevicePublicKeyStringDef.NONE)) {
                            b12 = 0;
                        }
                    } else if (strZza.equals("all")) {
                        b12 = 1;
                    }
                    if (b12 == 0) {
                        zzaluVar = zze(zzaluVar);
                        zzaluVar.zzA(false);
                    } else if (b12 == 1) {
                        zzaluVar = zze(zzaluVar);
                        zzaluVar.zzA(true);
                    }
                    break;
                case 10:
                    String strZza2 = zzfwk.zza(attributeValue);
                    switch (strZza2.hashCode()) {
                        case -618561360:
                            if (strZza2.equals("baseContainer")) {
                                b12 = 2;
                            }
                            break;
                        case -410956671:
                            if (strZza2.equals("container")) {
                                b12 = 0;
                            }
                            break;
                        case -250518009:
                            if (strZza2.equals(RequestParameters.DELIMITER)) {
                                b12 = 5;
                            }
                            break;
                        case -136074796:
                            if (strZza2.equals("textContainer")) {
                                b12 = 4;
                            }
                            break;
                        case 3016401:
                            if (strZza2.equals("base")) {
                                b12 = 1;
                            }
                            break;
                        case 3556653:
                            if (strZza2.equals(MimeTypes.BASE_TYPE_TEXT)) {
                                b12 = 3;
                            }
                            break;
                    }
                    if (b12 == 0) {
                        zzaluVar = zze(zzaluVar);
                        zzaluVar.zzx(1);
                    } else if (b12 == 1 || b12 == 2) {
                        zzaluVar = zze(zzaluVar);
                        zzaluVar.zzx(2);
                    } else if (b12 == 3 || b12 == 4) {
                        zzaluVar = zze(zzaluVar);
                        zzaluVar.zzx(3);
                    } else if (b12 == 5) {
                        zzaluVar = zze(zzaluVar);
                        zzaluVar.zzx(4);
                    }
                    break;
                case 11:
                    String strZza3 = zzfwk.zza(attributeValue);
                    int iHashCode3 = strZza3.hashCode();
                    if (iHashCode3 != -1392885889) {
                        if (iHashCode3 == 92734940 && strZza3.equals("after")) {
                            b12 = 1;
                        }
                    } else if (strZza3.equals("before")) {
                        b12 = 0;
                    }
                    if (b12 == 0) {
                        zzaluVar = zze(zzaluVar);
                        zzaluVar.zzw(1);
                    } else if (b12 == 1) {
                        zzaluVar = zze(zzaluVar);
                        zzaluVar.zzw(2);
                    }
                    break;
                case 12:
                    String strZza4 = zzfwk.zza(attributeValue);
                    switch (strZza4.hashCode()) {
                        case -1461280213:
                            if (strZza4.equals(TtmlNode.NO_UNDERLINE)) {
                                b12 = 3;
                            }
                            break;
                        case -1026963764:
                            if (strZza4.equals(TtmlNode.UNDERLINE)) {
                                b12 = 2;
                            }
                            break;
                        case 913457136:
                            if (strZza4.equals(TtmlNode.NO_LINETHROUGH)) {
                                b12 = 1;
                            }
                            break;
                        case 1679736913:
                            if (strZza4.equals(TtmlNode.LINETHROUGH)) {
                                b12 = 0;
                            }
                            break;
                    }
                    if (b12 == 0) {
                        zzaluVar = zze(zzaluVar);
                        zzaluVar.zzu(true);
                    } else if (b12 == 1) {
                        zzaluVar = zze(zzaluVar);
                        zzaluVar.zzu(false);
                    } else if (b12 == 2) {
                        zzaluVar = zze(zzaluVar);
                        zzaluVar.zzC(true);
                    } else if (b12 == 3) {
                        zzaluVar = zze(zzaluVar);
                        zzaluVar.zzC(false);
                    }
                    break;
                case 13:
                    zzaluVar = zze(zzaluVar);
                    zzaluVar.zzB(zzaln.zza(attributeValue));
                    break;
                case 14:
                    zzaluVar = zze(zzaluVar);
                    Matcher matcher2 = zza.matcher(attributeValue);
                    float fMin = Float.MAX_VALUE;
                    if (matcher2.matches()) {
                        try {
                            String strGroup3 = matcher2.group(1);
                            strGroup3.getClass();
                            fMin = Math.min(100.0f, Math.max(-100.0f, Float.parseFloat(strGroup3)));
                        } catch (NumberFormatException e11) {
                            zzff.zzg("TtmlParser", "Failed to parse shear: ".concat(String.valueOf(attributeValue)), e11);
                        }
                    } else {
                        zzff.zzf("TtmlParser", "Invalid value for shear: ".concat(String.valueOf(attributeValue)));
                    }
                    zzaluVar.zzy(fMin);
                    break;
            }
        }
        return zzaluVar;
    }

    private static String[] zzg(String str) {
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return new String[0];
        }
        int i11 = zzfy.zza;
        return strTrim.split("\\s+", -1);
    }

    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zza(byte[] bArr, int i11, int i12, zzakq zzakqVar, zzep zzepVar) {
        zzakl.zza(zzb(bArr, i11, i12), zzakqVar, zzepVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:121:0x0286 A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, TryCatch #18 {IOException -> 0x008e, XmlPullParserException -> 0x0092, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x0081, B:16:0x0089, B:22:0x0098, B:25:0x00a4, B:29:0x00b6, B:31:0x00d5, B:33:0x00e3, B:35:0x00ea, B:37:0x00f6, B:39:0x0101, B:69:0x018f, B:87:0x01e9, B:90:0x01f7, B:92:0x01fd, B:94:0x0205, B:96:0x020d, B:98:0x0215, B:100:0x021d, B:102:0x0225, B:104:0x022b, B:106:0x0233, B:108:0x023b, B:110:0x0241, B:112:0x0247, B:114:0x024f, B:116:0x0257, B:119:0x0260, B:391:0x06c8, B:121:0x0286, B:123:0x028c, B:125:0x0295, B:127:0x02a4, B:129:0x02ae, B:131:0x02c2, B:133:0x02c8, B:261:0x04fa, B:136:0x02d3, B:138:0x02db, B:140:0x02e1, B:142:0x02ec, B:144:0x02f4, B:145:0x02fb, B:148:0x0302, B:260:0x04f3, B:152:0x0311, B:154:0x0319, B:158:0x0332, B:160:0x0339, B:162:0x0347, B:178:0x0391, B:180:0x0397, B:183:0x03a6, B:185:0x03ad, B:187:0x03bb, B:202:0x040a, B:204:0x0412, B:224:0x0457, B:226:0x045f, B:252:0x04a7, B:189:0x03c6, B:190:0x03d1, B:193:0x03d9, B:196:0x03e5, B:198:0x03ec, B:200:0x03f8, B:253:0x04b3, B:254:0x04be, B:255:0x04c9, B:165:0x0350, B:166:0x035a, B:169:0x0364, B:172:0x036f, B:174:0x0376, B:176:0x0382, B:256:0x04d0, B:257:0x04db, B:258:0x04e6, B:266:0x0516, B:269:0x0533, B:325:0x05d9, B:303:0x058f, B:306:0x0598, B:366:0x0657, B:313:0x05aa, B:316:0x05b4, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:353:0x0623, B:355:0x0633, B:357:0x0638, B:348:0x0619, B:72:0x0197, B:74:0x01a3, B:77:0x01ae, B:79:0x01b5, B:81:0x01c1, B:83:0x01cb, B:43:0x011b, B:46:0x0129, B:49:0x0132, B:51:0x0139, B:53:0x0140, B:55:0x0147, B:61:0x015d, B:63:0x0164, B:68:0x0187, B:371:0x0677, B:375:0x0688, B:377:0x0692, B:379:0x069f, B:381:0x06a7, B:385:0x06ba, B:389:0x06c2), top: B:433:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:123:0x028c A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, LOOP:1: B:123:0x028c->B:264:0x0506, LOOP_START, PHI: r5 r6 r11 r28
  0x028c: PHI (r5v36 java.util.HashMap) = (r5v1 java.util.HashMap), (r5v74 java.util.HashMap) binds: [B:122:0x028a, B:264:0x0506] A[DONT_GENERATE, DONT_INLINE]
  0x028c: PHI (r6v6 java.lang.String) = (r6v3 java.lang.String), (r6v24 java.lang.String) binds: [B:122:0x028a, B:264:0x0506] A[DONT_GENERATE, DONT_INLINE]
  0x028c: PHI (r11v8 com.google.android.gms.internal.ads.zzalp) = (r11v5 com.google.android.gms.internal.ads.zzalp), (r11v20 com.google.android.gms.internal.ads.zzalp) binds: [B:122:0x028a, B:264:0x0506] A[DONT_GENERATE, DONT_INLINE]
  0x028c: PHI (r28v11 java.util.HashMap) = (r28v1 java.util.HashMap), (r28v12 java.util.HashMap) binds: [B:122:0x028a, B:264:0x0506] A[DONT_GENERATE, DONT_INLINE], TryCatch #18 {IOException -> 0x008e, XmlPullParserException -> 0x0092, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x0081, B:16:0x0089, B:22:0x0098, B:25:0x00a4, B:29:0x00b6, B:31:0x00d5, B:33:0x00e3, B:35:0x00ea, B:37:0x00f6, B:39:0x0101, B:69:0x018f, B:87:0x01e9, B:90:0x01f7, B:92:0x01fd, B:94:0x0205, B:96:0x020d, B:98:0x0215, B:100:0x021d, B:102:0x0225, B:104:0x022b, B:106:0x0233, B:108:0x023b, B:110:0x0241, B:112:0x0247, B:114:0x024f, B:116:0x0257, B:119:0x0260, B:391:0x06c8, B:121:0x0286, B:123:0x028c, B:125:0x0295, B:127:0x02a4, B:129:0x02ae, B:131:0x02c2, B:133:0x02c8, B:261:0x04fa, B:136:0x02d3, B:138:0x02db, B:140:0x02e1, B:142:0x02ec, B:144:0x02f4, B:145:0x02fb, B:148:0x0302, B:260:0x04f3, B:152:0x0311, B:154:0x0319, B:158:0x0332, B:160:0x0339, B:162:0x0347, B:178:0x0391, B:180:0x0397, B:183:0x03a6, B:185:0x03ad, B:187:0x03bb, B:202:0x040a, B:204:0x0412, B:224:0x0457, B:226:0x045f, B:252:0x04a7, B:189:0x03c6, B:190:0x03d1, B:193:0x03d9, B:196:0x03e5, B:198:0x03ec, B:200:0x03f8, B:253:0x04b3, B:254:0x04be, B:255:0x04c9, B:165:0x0350, B:166:0x035a, B:169:0x0364, B:172:0x036f, B:174:0x0376, B:176:0x0382, B:256:0x04d0, B:257:0x04db, B:258:0x04e6, B:266:0x0516, B:269:0x0533, B:325:0x05d9, B:303:0x058f, B:306:0x0598, B:366:0x0657, B:313:0x05aa, B:316:0x05b4, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:353:0x0623, B:355:0x0633, B:357:0x0638, B:348:0x0619, B:72:0x0197, B:74:0x01a3, B:77:0x01ae, B:79:0x01b5, B:81:0x01c1, B:83:0x01cb, B:43:0x011b, B:46:0x0129, B:49:0x0132, B:51:0x0139, B:53:0x0140, B:55:0x0147, B:61:0x015d, B:63:0x0164, B:68:0x0187, B:371:0x0677, B:375:0x0688, B:377:0x0692, B:379:0x069f, B:381:0x06a7, B:385:0x06ba, B:389:0x06c2), top: B:433:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:125:0x0295 A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, TryCatch #18 {IOException -> 0x008e, XmlPullParserException -> 0x0092, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x0081, B:16:0x0089, B:22:0x0098, B:25:0x00a4, B:29:0x00b6, B:31:0x00d5, B:33:0x00e3, B:35:0x00ea, B:37:0x00f6, B:39:0x0101, B:69:0x018f, B:87:0x01e9, B:90:0x01f7, B:92:0x01fd, B:94:0x0205, B:96:0x020d, B:98:0x0215, B:100:0x021d, B:102:0x0225, B:104:0x022b, B:106:0x0233, B:108:0x023b, B:110:0x0241, B:112:0x0247, B:114:0x024f, B:116:0x0257, B:119:0x0260, B:391:0x06c8, B:121:0x0286, B:123:0x028c, B:125:0x0295, B:127:0x02a4, B:129:0x02ae, B:131:0x02c2, B:133:0x02c8, B:261:0x04fa, B:136:0x02d3, B:138:0x02db, B:140:0x02e1, B:142:0x02ec, B:144:0x02f4, B:145:0x02fb, B:148:0x0302, B:260:0x04f3, B:152:0x0311, B:154:0x0319, B:158:0x0332, B:160:0x0339, B:162:0x0347, B:178:0x0391, B:180:0x0397, B:183:0x03a6, B:185:0x03ad, B:187:0x03bb, B:202:0x040a, B:204:0x0412, B:224:0x0457, B:226:0x045f, B:252:0x04a7, B:189:0x03c6, B:190:0x03d1, B:193:0x03d9, B:196:0x03e5, B:198:0x03ec, B:200:0x03f8, B:253:0x04b3, B:254:0x04be, B:255:0x04c9, B:165:0x0350, B:166:0x035a, B:169:0x0364, B:172:0x036f, B:174:0x0376, B:176:0x0382, B:256:0x04d0, B:257:0x04db, B:258:0x04e6, B:266:0x0516, B:269:0x0533, B:325:0x05d9, B:303:0x058f, B:306:0x0598, B:366:0x0657, B:313:0x05aa, B:316:0x05b4, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:353:0x0623, B:355:0x0633, B:357:0x0638, B:348:0x0619, B:72:0x0197, B:74:0x01a3, B:77:0x01ae, B:79:0x01b5, B:81:0x01c1, B:83:0x01cb, B:43:0x011b, B:46:0x0129, B:49:0x0132, B:51:0x0139, B:53:0x0140, B:55:0x0147, B:61:0x015d, B:63:0x0164, B:68:0x0187, B:371:0x0677, B:375:0x0688, B:377:0x0692, B:379:0x069f, B:381:0x06a7, B:385:0x06ba, B:389:0x06c2), top: B:433:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:127:0x02a4 A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, TryCatch #18 {IOException -> 0x008e, XmlPullParserException -> 0x0092, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x0081, B:16:0x0089, B:22:0x0098, B:25:0x00a4, B:29:0x00b6, B:31:0x00d5, B:33:0x00e3, B:35:0x00ea, B:37:0x00f6, B:39:0x0101, B:69:0x018f, B:87:0x01e9, B:90:0x01f7, B:92:0x01fd, B:94:0x0205, B:96:0x020d, B:98:0x0215, B:100:0x021d, B:102:0x0225, B:104:0x022b, B:106:0x0233, B:108:0x023b, B:110:0x0241, B:112:0x0247, B:114:0x024f, B:116:0x0257, B:119:0x0260, B:391:0x06c8, B:121:0x0286, B:123:0x028c, B:125:0x0295, B:127:0x02a4, B:129:0x02ae, B:131:0x02c2, B:133:0x02c8, B:261:0x04fa, B:136:0x02d3, B:138:0x02db, B:140:0x02e1, B:142:0x02ec, B:144:0x02f4, B:145:0x02fb, B:148:0x0302, B:260:0x04f3, B:152:0x0311, B:154:0x0319, B:158:0x0332, B:160:0x0339, B:162:0x0347, B:178:0x0391, B:180:0x0397, B:183:0x03a6, B:185:0x03ad, B:187:0x03bb, B:202:0x040a, B:204:0x0412, B:224:0x0457, B:226:0x045f, B:252:0x04a7, B:189:0x03c6, B:190:0x03d1, B:193:0x03d9, B:196:0x03e5, B:198:0x03ec, B:200:0x03f8, B:253:0x04b3, B:254:0x04be, B:255:0x04c9, B:165:0x0350, B:166:0x035a, B:169:0x0364, B:172:0x036f, B:174:0x0376, B:176:0x0382, B:256:0x04d0, B:257:0x04db, B:258:0x04e6, B:266:0x0516, B:269:0x0533, B:325:0x05d9, B:303:0x058f, B:306:0x0598, B:366:0x0657, B:313:0x05aa, B:316:0x05b4, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:353:0x0623, B:355:0x0633, B:357:0x0638, B:348:0x0619, B:72:0x0197, B:74:0x01a3, B:77:0x01ae, B:79:0x01b5, B:81:0x01c1, B:83:0x01cb, B:43:0x011b, B:46:0x0129, B:49:0x0132, B:51:0x0139, B:53:0x0140, B:55:0x0147, B:61:0x015d, B:63:0x0164, B:68:0x0187, B:371:0x0677, B:375:0x0688, B:377:0x0692, B:379:0x069f, B:381:0x06a7, B:385:0x06ba, B:389:0x06c2), top: B:433:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:129:0x02ae A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, LOOP:2: B:128:0x02ac->B:129:0x02ae, LOOP_END, TryCatch #18 {IOException -> 0x008e, XmlPullParserException -> 0x0092, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x0081, B:16:0x0089, B:22:0x0098, B:25:0x00a4, B:29:0x00b6, B:31:0x00d5, B:33:0x00e3, B:35:0x00ea, B:37:0x00f6, B:39:0x0101, B:69:0x018f, B:87:0x01e9, B:90:0x01f7, B:92:0x01fd, B:94:0x0205, B:96:0x020d, B:98:0x0215, B:100:0x021d, B:102:0x0225, B:104:0x022b, B:106:0x0233, B:108:0x023b, B:110:0x0241, B:112:0x0247, B:114:0x024f, B:116:0x0257, B:119:0x0260, B:391:0x06c8, B:121:0x0286, B:123:0x028c, B:125:0x0295, B:127:0x02a4, B:129:0x02ae, B:131:0x02c2, B:133:0x02c8, B:261:0x04fa, B:136:0x02d3, B:138:0x02db, B:140:0x02e1, B:142:0x02ec, B:144:0x02f4, B:145:0x02fb, B:148:0x0302, B:260:0x04f3, B:152:0x0311, B:154:0x0319, B:158:0x0332, B:160:0x0339, B:162:0x0347, B:178:0x0391, B:180:0x0397, B:183:0x03a6, B:185:0x03ad, B:187:0x03bb, B:202:0x040a, B:204:0x0412, B:224:0x0457, B:226:0x045f, B:252:0x04a7, B:189:0x03c6, B:190:0x03d1, B:193:0x03d9, B:196:0x03e5, B:198:0x03ec, B:200:0x03f8, B:253:0x04b3, B:254:0x04be, B:255:0x04c9, B:165:0x0350, B:166:0x035a, B:169:0x0364, B:172:0x036f, B:174:0x0376, B:176:0x0382, B:256:0x04d0, B:257:0x04db, B:258:0x04e6, B:266:0x0516, B:269:0x0533, B:325:0x05d9, B:303:0x058f, B:306:0x0598, B:366:0x0657, B:313:0x05aa, B:316:0x05b4, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:353:0x0623, B:355:0x0633, B:357:0x0638, B:348:0x0619, B:72:0x0197, B:74:0x01a3, B:77:0x01ae, B:79:0x01b5, B:81:0x01c1, B:83:0x01cb, B:43:0x011b, B:46:0x0129, B:49:0x0132, B:51:0x0139, B:53:0x0140, B:55:0x0147, B:61:0x015d, B:63:0x0164, B:68:0x0187, B:371:0x0677, B:375:0x0688, B:377:0x0692, B:379:0x069f, B:381:0x06a7, B:385:0x06ba, B:389:0x06c2), top: B:433:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:130:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:133:0x02c8 A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, TryCatch #18 {IOException -> 0x008e, XmlPullParserException -> 0x0092, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x0081, B:16:0x0089, B:22:0x0098, B:25:0x00a4, B:29:0x00b6, B:31:0x00d5, B:33:0x00e3, B:35:0x00ea, B:37:0x00f6, B:39:0x0101, B:69:0x018f, B:87:0x01e9, B:90:0x01f7, B:92:0x01fd, B:94:0x0205, B:96:0x020d, B:98:0x0215, B:100:0x021d, B:102:0x0225, B:104:0x022b, B:106:0x0233, B:108:0x023b, B:110:0x0241, B:112:0x0247, B:114:0x024f, B:116:0x0257, B:119:0x0260, B:391:0x06c8, B:121:0x0286, B:123:0x028c, B:125:0x0295, B:127:0x02a4, B:129:0x02ae, B:131:0x02c2, B:133:0x02c8, B:261:0x04fa, B:136:0x02d3, B:138:0x02db, B:140:0x02e1, B:142:0x02ec, B:144:0x02f4, B:145:0x02fb, B:148:0x0302, B:260:0x04f3, B:152:0x0311, B:154:0x0319, B:158:0x0332, B:160:0x0339, B:162:0x0347, B:178:0x0391, B:180:0x0397, B:183:0x03a6, B:185:0x03ad, B:187:0x03bb, B:202:0x040a, B:204:0x0412, B:224:0x0457, B:226:0x045f, B:252:0x04a7, B:189:0x03c6, B:190:0x03d1, B:193:0x03d9, B:196:0x03e5, B:198:0x03ec, B:200:0x03f8, B:253:0x04b3, B:254:0x04be, B:255:0x04c9, B:165:0x0350, B:166:0x035a, B:169:0x0364, B:172:0x036f, B:174:0x0376, B:176:0x0382, B:256:0x04d0, B:257:0x04db, B:258:0x04e6, B:266:0x0516, B:269:0x0533, B:325:0x05d9, B:303:0x058f, B:306:0x0598, B:366:0x0657, B:313:0x05aa, B:316:0x05b4, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:353:0x0623, B:355:0x0633, B:357:0x0638, B:348:0x0619, B:72:0x0197, B:74:0x01a3, B:77:0x01ae, B:79:0x01b5, B:81:0x01c1, B:83:0x01cb, B:43:0x011b, B:46:0x0129, B:49:0x0132, B:51:0x0139, B:53:0x0140, B:55:0x0147, B:61:0x015d, B:63:0x0164, B:68:0x0187, B:371:0x0677, B:375:0x0688, B:377:0x0692, B:379:0x069f, B:381:0x06a7, B:385:0x06ba, B:389:0x06c2), top: B:433:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x02cf A[PHI: r16 r17 r40
  0x02cf: PHI (r16v11 com.google.android.gms.internal.ads.zzalp) = (r16v9 com.google.android.gms.internal.ads.zzalp), (r16v12 com.google.android.gms.internal.ads.zzalp) binds: [B:259:0x04f1, B:134:0x02cb] A[DONT_GENERATE, DONT_INLINE]
  0x02cf: PHI (r17v14 java.lang.String) = (r17v10 java.lang.String), (r17v15 java.lang.String) binds: [B:259:0x04f1, B:134:0x02cb] A[DONT_GENERATE, DONT_INLINE]
  0x02cf: PHI (r40v11 java.util.HashMap) = (r40v7 java.util.HashMap), (r40v12 java.util.HashMap) binds: [B:259:0x04f1, B:134:0x02cb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:136:0x02d3 A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, TryCatch #18 {IOException -> 0x008e, XmlPullParserException -> 0x0092, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x0081, B:16:0x0089, B:22:0x0098, B:25:0x00a4, B:29:0x00b6, B:31:0x00d5, B:33:0x00e3, B:35:0x00ea, B:37:0x00f6, B:39:0x0101, B:69:0x018f, B:87:0x01e9, B:90:0x01f7, B:92:0x01fd, B:94:0x0205, B:96:0x020d, B:98:0x0215, B:100:0x021d, B:102:0x0225, B:104:0x022b, B:106:0x0233, B:108:0x023b, B:110:0x0241, B:112:0x0247, B:114:0x024f, B:116:0x0257, B:119:0x0260, B:391:0x06c8, B:121:0x0286, B:123:0x028c, B:125:0x0295, B:127:0x02a4, B:129:0x02ae, B:131:0x02c2, B:133:0x02c8, B:261:0x04fa, B:136:0x02d3, B:138:0x02db, B:140:0x02e1, B:142:0x02ec, B:144:0x02f4, B:145:0x02fb, B:148:0x0302, B:260:0x04f3, B:152:0x0311, B:154:0x0319, B:158:0x0332, B:160:0x0339, B:162:0x0347, B:178:0x0391, B:180:0x0397, B:183:0x03a6, B:185:0x03ad, B:187:0x03bb, B:202:0x040a, B:204:0x0412, B:224:0x0457, B:226:0x045f, B:252:0x04a7, B:189:0x03c6, B:190:0x03d1, B:193:0x03d9, B:196:0x03e5, B:198:0x03ec, B:200:0x03f8, B:253:0x04b3, B:254:0x04be, B:255:0x04c9, B:165:0x0350, B:166:0x035a, B:169:0x0364, B:172:0x036f, B:174:0x0376, B:176:0x0382, B:256:0x04d0, B:257:0x04db, B:258:0x04e6, B:266:0x0516, B:269:0x0533, B:325:0x05d9, B:303:0x058f, B:306:0x0598, B:366:0x0657, B:313:0x05aa, B:316:0x05b4, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:353:0x0623, B:355:0x0633, B:357:0x0638, B:348:0x0619, B:72:0x0197, B:74:0x01a3, B:77:0x01ae, B:79:0x01b5, B:81:0x01c1, B:83:0x01cb, B:43:0x011b, B:46:0x0129, B:49:0x0132, B:51:0x0139, B:53:0x0140, B:55:0x0147, B:61:0x015d, B:63:0x0164, B:68:0x0187, B:371:0x0677, B:375:0x0688, B:377:0x0692, B:379:0x069f, B:381:0x06a7, B:385:0x06ba, B:389:0x06c2), top: B:433:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x02db A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, TryCatch #18 {IOException -> 0x008e, XmlPullParserException -> 0x0092, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x0081, B:16:0x0089, B:22:0x0098, B:25:0x00a4, B:29:0x00b6, B:31:0x00d5, B:33:0x00e3, B:35:0x00ea, B:37:0x00f6, B:39:0x0101, B:69:0x018f, B:87:0x01e9, B:90:0x01f7, B:92:0x01fd, B:94:0x0205, B:96:0x020d, B:98:0x0215, B:100:0x021d, B:102:0x0225, B:104:0x022b, B:106:0x0233, B:108:0x023b, B:110:0x0241, B:112:0x0247, B:114:0x024f, B:116:0x0257, B:119:0x0260, B:391:0x06c8, B:121:0x0286, B:123:0x028c, B:125:0x0295, B:127:0x02a4, B:129:0x02ae, B:131:0x02c2, B:133:0x02c8, B:261:0x04fa, B:136:0x02d3, B:138:0x02db, B:140:0x02e1, B:142:0x02ec, B:144:0x02f4, B:145:0x02fb, B:148:0x0302, B:260:0x04f3, B:152:0x0311, B:154:0x0319, B:158:0x0332, B:160:0x0339, B:162:0x0347, B:178:0x0391, B:180:0x0397, B:183:0x03a6, B:185:0x03ad, B:187:0x03bb, B:202:0x040a, B:204:0x0412, B:224:0x0457, B:226:0x045f, B:252:0x04a7, B:189:0x03c6, B:190:0x03d1, B:193:0x03d9, B:196:0x03e5, B:198:0x03ec, B:200:0x03f8, B:253:0x04b3, B:254:0x04be, B:255:0x04c9, B:165:0x0350, B:166:0x035a, B:169:0x0364, B:172:0x036f, B:174:0x0376, B:176:0x0382, B:256:0x04d0, B:257:0x04db, B:258:0x04e6, B:266:0x0516, B:269:0x0533, B:325:0x05d9, B:303:0x058f, B:306:0x0598, B:366:0x0657, B:313:0x05aa, B:316:0x05b4, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:353:0x0623, B:355:0x0633, B:357:0x0638, B:348:0x0619, B:72:0x0197, B:74:0x01a3, B:77:0x01ae, B:79:0x01b5, B:81:0x01c1, B:83:0x01cb, B:43:0x011b, B:46:0x0129, B:49:0x0132, B:51:0x0139, B:53:0x0140, B:55:0x0147, B:61:0x015d, B:63:0x0164, B:68:0x0187, B:371:0x0677, B:375:0x0688, B:377:0x0692, B:379:0x069f, B:381:0x06a7, B:385:0x06ba, B:389:0x06c2), top: B:433:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:140:0x02e1 A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, LOOP:3: B:140:0x02e1->B:439:?, LOOP_START, TryCatch #18 {IOException -> 0x008e, XmlPullParserException -> 0x0092, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x0081, B:16:0x0089, B:22:0x0098, B:25:0x00a4, B:29:0x00b6, B:31:0x00d5, B:33:0x00e3, B:35:0x00ea, B:37:0x00f6, B:39:0x0101, B:69:0x018f, B:87:0x01e9, B:90:0x01f7, B:92:0x01fd, B:94:0x0205, B:96:0x020d, B:98:0x0215, B:100:0x021d, B:102:0x0225, B:104:0x022b, B:106:0x0233, B:108:0x023b, B:110:0x0241, B:112:0x0247, B:114:0x024f, B:116:0x0257, B:119:0x0260, B:391:0x06c8, B:121:0x0286, B:123:0x028c, B:125:0x0295, B:127:0x02a4, B:129:0x02ae, B:131:0x02c2, B:133:0x02c8, B:261:0x04fa, B:136:0x02d3, B:138:0x02db, B:140:0x02e1, B:142:0x02ec, B:144:0x02f4, B:145:0x02fb, B:148:0x0302, B:260:0x04f3, B:152:0x0311, B:154:0x0319, B:158:0x0332, B:160:0x0339, B:162:0x0347, B:178:0x0391, B:180:0x0397, B:183:0x03a6, B:185:0x03ad, B:187:0x03bb, B:202:0x040a, B:204:0x0412, B:224:0x0457, B:226:0x045f, B:252:0x04a7, B:189:0x03c6, B:190:0x03d1, B:193:0x03d9, B:196:0x03e5, B:198:0x03ec, B:200:0x03f8, B:253:0x04b3, B:254:0x04be, B:255:0x04c9, B:165:0x0350, B:166:0x035a, B:169:0x0364, B:172:0x036f, B:174:0x0376, B:176:0x0382, B:256:0x04d0, B:257:0x04db, B:258:0x04e6, B:266:0x0516, B:269:0x0533, B:325:0x05d9, B:303:0x058f, B:306:0x0598, B:366:0x0657, B:313:0x05aa, B:316:0x05b4, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:353:0x0623, B:355:0x0633, B:357:0x0638, B:348:0x0619, B:72:0x0197, B:74:0x01a3, B:77:0x01ae, B:79:0x01b5, B:81:0x01c1, B:83:0x01cb, B:43:0x011b, B:46:0x0129, B:49:0x0132, B:51:0x0139, B:53:0x0140, B:55:0x0147, B:61:0x015d, B:63:0x0164, B:68:0x0187, B:371:0x0677, B:375:0x0688, B:377:0x0692, B:379:0x069f, B:381:0x06a7, B:385:0x06ba, B:389:0x06c2), top: B:433:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:142:0x02ec A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, TryCatch #18 {IOException -> 0x008e, XmlPullParserException -> 0x0092, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x0081, B:16:0x0089, B:22:0x0098, B:25:0x00a4, B:29:0x00b6, B:31:0x00d5, B:33:0x00e3, B:35:0x00ea, B:37:0x00f6, B:39:0x0101, B:69:0x018f, B:87:0x01e9, B:90:0x01f7, B:92:0x01fd, B:94:0x0205, B:96:0x020d, B:98:0x0215, B:100:0x021d, B:102:0x0225, B:104:0x022b, B:106:0x0233, B:108:0x023b, B:110:0x0241, B:112:0x0247, B:114:0x024f, B:116:0x0257, B:119:0x0260, B:391:0x06c8, B:121:0x0286, B:123:0x028c, B:125:0x0295, B:127:0x02a4, B:129:0x02ae, B:131:0x02c2, B:133:0x02c8, B:261:0x04fa, B:136:0x02d3, B:138:0x02db, B:140:0x02e1, B:142:0x02ec, B:144:0x02f4, B:145:0x02fb, B:148:0x0302, B:260:0x04f3, B:152:0x0311, B:154:0x0319, B:158:0x0332, B:160:0x0339, B:162:0x0347, B:178:0x0391, B:180:0x0397, B:183:0x03a6, B:185:0x03ad, B:187:0x03bb, B:202:0x040a, B:204:0x0412, B:224:0x0457, B:226:0x045f, B:252:0x04a7, B:189:0x03c6, B:190:0x03d1, B:193:0x03d9, B:196:0x03e5, B:198:0x03ec, B:200:0x03f8, B:253:0x04b3, B:254:0x04be, B:255:0x04c9, B:165:0x0350, B:166:0x035a, B:169:0x0364, B:172:0x036f, B:174:0x0376, B:176:0x0382, B:256:0x04d0, B:257:0x04db, B:258:0x04e6, B:266:0x0516, B:269:0x0533, B:325:0x05d9, B:303:0x058f, B:306:0x0598, B:366:0x0657, B:313:0x05aa, B:316:0x05b4, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:353:0x0623, B:355:0x0633, B:357:0x0638, B:348:0x0619, B:72:0x0197, B:74:0x01a3, B:77:0x01ae, B:79:0x01b5, B:81:0x01c1, B:83:0x01cb, B:43:0x011b, B:46:0x0129, B:49:0x0132, B:51:0x0139, B:53:0x0140, B:55:0x0147, B:61:0x015d, B:63:0x0164, B:68:0x0187, B:371:0x0677, B:375:0x0688, B:377:0x0692, B:379:0x069f, B:381:0x06a7, B:385:0x06ba, B:389:0x06c2), top: B:433:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:148:0x0302 A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, TryCatch #18 {IOException -> 0x008e, XmlPullParserException -> 0x0092, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x0081, B:16:0x0089, B:22:0x0098, B:25:0x00a4, B:29:0x00b6, B:31:0x00d5, B:33:0x00e3, B:35:0x00ea, B:37:0x00f6, B:39:0x0101, B:69:0x018f, B:87:0x01e9, B:90:0x01f7, B:92:0x01fd, B:94:0x0205, B:96:0x020d, B:98:0x0215, B:100:0x021d, B:102:0x0225, B:104:0x022b, B:106:0x0233, B:108:0x023b, B:110:0x0241, B:112:0x0247, B:114:0x024f, B:116:0x0257, B:119:0x0260, B:391:0x06c8, B:121:0x0286, B:123:0x028c, B:125:0x0295, B:127:0x02a4, B:129:0x02ae, B:131:0x02c2, B:133:0x02c8, B:261:0x04fa, B:136:0x02d3, B:138:0x02db, B:140:0x02e1, B:142:0x02ec, B:144:0x02f4, B:145:0x02fb, B:148:0x0302, B:260:0x04f3, B:152:0x0311, B:154:0x0319, B:158:0x0332, B:160:0x0339, B:162:0x0347, B:178:0x0391, B:180:0x0397, B:183:0x03a6, B:185:0x03ad, B:187:0x03bb, B:202:0x040a, B:204:0x0412, B:224:0x0457, B:226:0x045f, B:252:0x04a7, B:189:0x03c6, B:190:0x03d1, B:193:0x03d9, B:196:0x03e5, B:198:0x03ec, B:200:0x03f8, B:253:0x04b3, B:254:0x04be, B:255:0x04c9, B:165:0x0350, B:166:0x035a, B:169:0x0364, B:172:0x036f, B:174:0x0376, B:176:0x0382, B:256:0x04d0, B:257:0x04db, B:258:0x04e6, B:266:0x0516, B:269:0x0533, B:325:0x05d9, B:303:0x058f, B:306:0x0598, B:366:0x0657, B:313:0x05aa, B:316:0x05b4, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:353:0x0623, B:355:0x0633, B:357:0x0638, B:348:0x0619, B:72:0x0197, B:74:0x01a3, B:77:0x01ae, B:79:0x01b5, B:81:0x01c1, B:83:0x01cb, B:43:0x011b, B:46:0x0129, B:49:0x0132, B:51:0x0139, B:53:0x0140, B:55:0x0147, B:61:0x015d, B:63:0x0164, B:68:0x0187, B:371:0x0677, B:375:0x0688, B:377:0x0692, B:379:0x069f, B:381:0x06a7, B:385:0x06ba, B:389:0x06c2), top: B:433:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:150:0x030a  */
    /* JADX WARN: Code duplicated, block: B:152:0x0311 A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, TryCatch #18 {IOException -> 0x008e, XmlPullParserException -> 0x0092, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x0081, B:16:0x0089, B:22:0x0098, B:25:0x00a4, B:29:0x00b6, B:31:0x00d5, B:33:0x00e3, B:35:0x00ea, B:37:0x00f6, B:39:0x0101, B:69:0x018f, B:87:0x01e9, B:90:0x01f7, B:92:0x01fd, B:94:0x0205, B:96:0x020d, B:98:0x0215, B:100:0x021d, B:102:0x0225, B:104:0x022b, B:106:0x0233, B:108:0x023b, B:110:0x0241, B:112:0x0247, B:114:0x024f, B:116:0x0257, B:119:0x0260, B:391:0x06c8, B:121:0x0286, B:123:0x028c, B:125:0x0295, B:127:0x02a4, B:129:0x02ae, B:131:0x02c2, B:133:0x02c8, B:261:0x04fa, B:136:0x02d3, B:138:0x02db, B:140:0x02e1, B:142:0x02ec, B:144:0x02f4, B:145:0x02fb, B:148:0x0302, B:260:0x04f3, B:152:0x0311, B:154:0x0319, B:158:0x0332, B:160:0x0339, B:162:0x0347, B:178:0x0391, B:180:0x0397, B:183:0x03a6, B:185:0x03ad, B:187:0x03bb, B:202:0x040a, B:204:0x0412, B:224:0x0457, B:226:0x045f, B:252:0x04a7, B:189:0x03c6, B:190:0x03d1, B:193:0x03d9, B:196:0x03e5, B:198:0x03ec, B:200:0x03f8, B:253:0x04b3, B:254:0x04be, B:255:0x04c9, B:165:0x0350, B:166:0x035a, B:169:0x0364, B:172:0x036f, B:174:0x0376, B:176:0x0382, B:256:0x04d0, B:257:0x04db, B:258:0x04e6, B:266:0x0516, B:269:0x0533, B:325:0x05d9, B:303:0x058f, B:306:0x0598, B:366:0x0657, B:313:0x05aa, B:316:0x05b4, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:353:0x0623, B:355:0x0633, B:357:0x0638, B:348:0x0619, B:72:0x0197, B:74:0x01a3, B:77:0x01ae, B:79:0x01b5, B:81:0x01c1, B:83:0x01cb, B:43:0x011b, B:46:0x0129, B:49:0x0132, B:51:0x0139, B:53:0x0140, B:55:0x0147, B:61:0x015d, B:63:0x0164, B:68:0x0187, B:371:0x0677, B:375:0x0688, B:377:0x0692, B:379:0x069f, B:381:0x06a7, B:385:0x06ba, B:389:0x06c2), top: B:433:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:154:0x0319 A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, TRY_LEAVE, TryCatch #18 {IOException -> 0x008e, XmlPullParserException -> 0x0092, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x0081, B:16:0x0089, B:22:0x0098, B:25:0x00a4, B:29:0x00b6, B:31:0x00d5, B:33:0x00e3, B:35:0x00ea, B:37:0x00f6, B:39:0x0101, B:69:0x018f, B:87:0x01e9, B:90:0x01f7, B:92:0x01fd, B:94:0x0205, B:96:0x020d, B:98:0x0215, B:100:0x021d, B:102:0x0225, B:104:0x022b, B:106:0x0233, B:108:0x023b, B:110:0x0241, B:112:0x0247, B:114:0x024f, B:116:0x0257, B:119:0x0260, B:391:0x06c8, B:121:0x0286, B:123:0x028c, B:125:0x0295, B:127:0x02a4, B:129:0x02ae, B:131:0x02c2, B:133:0x02c8, B:261:0x04fa, B:136:0x02d3, B:138:0x02db, B:140:0x02e1, B:142:0x02ec, B:144:0x02f4, B:145:0x02fb, B:148:0x0302, B:260:0x04f3, B:152:0x0311, B:154:0x0319, B:158:0x0332, B:160:0x0339, B:162:0x0347, B:178:0x0391, B:180:0x0397, B:183:0x03a6, B:185:0x03ad, B:187:0x03bb, B:202:0x040a, B:204:0x0412, B:224:0x0457, B:226:0x045f, B:252:0x04a7, B:189:0x03c6, B:190:0x03d1, B:193:0x03d9, B:196:0x03e5, B:198:0x03ec, B:200:0x03f8, B:253:0x04b3, B:254:0x04be, B:255:0x04c9, B:165:0x0350, B:166:0x035a, B:169:0x0364, B:172:0x036f, B:174:0x0376, B:176:0x0382, B:256:0x04d0, B:257:0x04db, B:258:0x04e6, B:266:0x0516, B:269:0x0533, B:325:0x05d9, B:303:0x058f, B:306:0x0598, B:366:0x0657, B:313:0x05aa, B:316:0x05b4, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:353:0x0623, B:355:0x0633, B:357:0x0638, B:348:0x0619, B:72:0x0197, B:74:0x01a3, B:77:0x01ae, B:79:0x01b5, B:81:0x01c1, B:83:0x01cb, B:43:0x011b, B:46:0x0129, B:49:0x0132, B:51:0x0139, B:53:0x0140, B:55:0x0147, B:61:0x015d, B:63:0x0164, B:68:0x0187, B:371:0x0677, B:375:0x0688, B:377:0x0692, B:379:0x069f, B:381:0x06a7, B:385:0x06ba, B:389:0x06c2), top: B:433:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:157:0x032f  */
    /* JADX WARN: Code duplicated, block: B:166:0x035a A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, TryCatch #18 {IOException -> 0x008e, XmlPullParserException -> 0x0092, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x0081, B:16:0x0089, B:22:0x0098, B:25:0x00a4, B:29:0x00b6, B:31:0x00d5, B:33:0x00e3, B:35:0x00ea, B:37:0x00f6, B:39:0x0101, B:69:0x018f, B:87:0x01e9, B:90:0x01f7, B:92:0x01fd, B:94:0x0205, B:96:0x020d, B:98:0x0215, B:100:0x021d, B:102:0x0225, B:104:0x022b, B:106:0x0233, B:108:0x023b, B:110:0x0241, B:112:0x0247, B:114:0x024f, B:116:0x0257, B:119:0x0260, B:391:0x06c8, B:121:0x0286, B:123:0x028c, B:125:0x0295, B:127:0x02a4, B:129:0x02ae, B:131:0x02c2, B:133:0x02c8, B:261:0x04fa, B:136:0x02d3, B:138:0x02db, B:140:0x02e1, B:142:0x02ec, B:144:0x02f4, B:145:0x02fb, B:148:0x0302, B:260:0x04f3, B:152:0x0311, B:154:0x0319, B:158:0x0332, B:160:0x0339, B:162:0x0347, B:178:0x0391, B:180:0x0397, B:183:0x03a6, B:185:0x03ad, B:187:0x03bb, B:202:0x040a, B:204:0x0412, B:224:0x0457, B:226:0x045f, B:252:0x04a7, B:189:0x03c6, B:190:0x03d1, B:193:0x03d9, B:196:0x03e5, B:198:0x03ec, B:200:0x03f8, B:253:0x04b3, B:254:0x04be, B:255:0x04c9, B:165:0x0350, B:166:0x035a, B:169:0x0364, B:172:0x036f, B:174:0x0376, B:176:0x0382, B:256:0x04d0, B:257:0x04db, B:258:0x04e6, B:266:0x0516, B:269:0x0533, B:325:0x05d9, B:303:0x058f, B:306:0x0598, B:366:0x0657, B:313:0x05aa, B:316:0x05b4, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:353:0x0623, B:355:0x0633, B:357:0x0638, B:348:0x0619, B:72:0x0197, B:74:0x01a3, B:77:0x01ae, B:79:0x01b5, B:81:0x01c1, B:83:0x01cb, B:43:0x011b, B:46:0x0129, B:49:0x0132, B:51:0x0139, B:53:0x0140, B:55:0x0147, B:61:0x015d, B:63:0x0164, B:68:0x0187, B:371:0x0677, B:375:0x0688, B:377:0x0692, B:379:0x069f, B:381:0x06a7, B:385:0x06ba, B:389:0x06c2), top: B:433:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:168:0x0362 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:169:0x0364 A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, TRY_LEAVE, TryCatch #18 {IOException -> 0x008e, XmlPullParserException -> 0x0092, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x0081, B:16:0x0089, B:22:0x0098, B:25:0x00a4, B:29:0x00b6, B:31:0x00d5, B:33:0x00e3, B:35:0x00ea, B:37:0x00f6, B:39:0x0101, B:69:0x018f, B:87:0x01e9, B:90:0x01f7, B:92:0x01fd, B:94:0x0205, B:96:0x020d, B:98:0x0215, B:100:0x021d, B:102:0x0225, B:104:0x022b, B:106:0x0233, B:108:0x023b, B:110:0x0241, B:112:0x0247, B:114:0x024f, B:116:0x0257, B:119:0x0260, B:391:0x06c8, B:121:0x0286, B:123:0x028c, B:125:0x0295, B:127:0x02a4, B:129:0x02ae, B:131:0x02c2, B:133:0x02c8, B:261:0x04fa, B:136:0x02d3, B:138:0x02db, B:140:0x02e1, B:142:0x02ec, B:144:0x02f4, B:145:0x02fb, B:148:0x0302, B:260:0x04f3, B:152:0x0311, B:154:0x0319, B:158:0x0332, B:160:0x0339, B:162:0x0347, B:178:0x0391, B:180:0x0397, B:183:0x03a6, B:185:0x03ad, B:187:0x03bb, B:202:0x040a, B:204:0x0412, B:224:0x0457, B:226:0x045f, B:252:0x04a7, B:189:0x03c6, B:190:0x03d1, B:193:0x03d9, B:196:0x03e5, B:198:0x03ec, B:200:0x03f8, B:253:0x04b3, B:254:0x04be, B:255:0x04c9, B:165:0x0350, B:166:0x035a, B:169:0x0364, B:172:0x036f, B:174:0x0376, B:176:0x0382, B:256:0x04d0, B:257:0x04db, B:258:0x04e6, B:266:0x0516, B:269:0x0533, B:325:0x05d9, B:303:0x058f, B:306:0x0598, B:366:0x0657, B:313:0x05aa, B:316:0x05b4, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:353:0x0623, B:355:0x0633, B:357:0x0638, B:348:0x0619, B:72:0x0197, B:74:0x01a3, B:77:0x01ae, B:79:0x01b5, B:81:0x01c1, B:83:0x01cb, B:43:0x011b, B:46:0x0129, B:49:0x0132, B:51:0x0139, B:53:0x0140, B:55:0x0147, B:61:0x015d, B:63:0x0164, B:68:0x0187, B:371:0x0677, B:375:0x0688, B:377:0x0692, B:379:0x069f, B:381:0x06a7, B:385:0x06ba, B:389:0x06c2), top: B:433:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:171:0x036e  */
    /* JADX WARN: Code duplicated, block: B:180:0x0397 A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, TRY_LEAVE, TryCatch #18 {IOException -> 0x008e, XmlPullParserException -> 0x0092, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x0081, B:16:0x0089, B:22:0x0098, B:25:0x00a4, B:29:0x00b6, B:31:0x00d5, B:33:0x00e3, B:35:0x00ea, B:37:0x00f6, B:39:0x0101, B:69:0x018f, B:87:0x01e9, B:90:0x01f7, B:92:0x01fd, B:94:0x0205, B:96:0x020d, B:98:0x0215, B:100:0x021d, B:102:0x0225, B:104:0x022b, B:106:0x0233, B:108:0x023b, B:110:0x0241, B:112:0x0247, B:114:0x024f, B:116:0x0257, B:119:0x0260, B:391:0x06c8, B:121:0x0286, B:123:0x028c, B:125:0x0295, B:127:0x02a4, B:129:0x02ae, B:131:0x02c2, B:133:0x02c8, B:261:0x04fa, B:136:0x02d3, B:138:0x02db, B:140:0x02e1, B:142:0x02ec, B:144:0x02f4, B:145:0x02fb, B:148:0x0302, B:260:0x04f3, B:152:0x0311, B:154:0x0319, B:158:0x0332, B:160:0x0339, B:162:0x0347, B:178:0x0391, B:180:0x0397, B:183:0x03a6, B:185:0x03ad, B:187:0x03bb, B:202:0x040a, B:204:0x0412, B:224:0x0457, B:226:0x045f, B:252:0x04a7, B:189:0x03c6, B:190:0x03d1, B:193:0x03d9, B:196:0x03e5, B:198:0x03ec, B:200:0x03f8, B:253:0x04b3, B:254:0x04be, B:255:0x04c9, B:165:0x0350, B:166:0x035a, B:169:0x0364, B:172:0x036f, B:174:0x0376, B:176:0x0382, B:256:0x04d0, B:257:0x04db, B:258:0x04e6, B:266:0x0516, B:269:0x0533, B:325:0x05d9, B:303:0x058f, B:306:0x0598, B:366:0x0657, B:313:0x05aa, B:316:0x05b4, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:353:0x0623, B:355:0x0633, B:357:0x0638, B:348:0x0619, B:72:0x0197, B:74:0x01a3, B:77:0x01ae, B:79:0x01b5, B:81:0x01c1, B:83:0x01cb, B:43:0x011b, B:46:0x0129, B:49:0x0132, B:51:0x0139, B:53:0x0140, B:55:0x0147, B:61:0x015d, B:63:0x0164, B:68:0x0187, B:371:0x0677, B:375:0x0688, B:377:0x0692, B:379:0x069f, B:381:0x06a7, B:385:0x06ba, B:389:0x06c2), top: B:433:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:182:0x03a5  */
    /* JADX WARN: Code duplicated, block: B:190:0x03d1 A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, TryCatch #18 {IOException -> 0x008e, XmlPullParserException -> 0x0092, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x0081, B:16:0x0089, B:22:0x0098, B:25:0x00a4, B:29:0x00b6, B:31:0x00d5, B:33:0x00e3, B:35:0x00ea, B:37:0x00f6, B:39:0x0101, B:69:0x018f, B:87:0x01e9, B:90:0x01f7, B:92:0x01fd, B:94:0x0205, B:96:0x020d, B:98:0x0215, B:100:0x021d, B:102:0x0225, B:104:0x022b, B:106:0x0233, B:108:0x023b, B:110:0x0241, B:112:0x0247, B:114:0x024f, B:116:0x0257, B:119:0x0260, B:391:0x06c8, B:121:0x0286, B:123:0x028c, B:125:0x0295, B:127:0x02a4, B:129:0x02ae, B:131:0x02c2, B:133:0x02c8, B:261:0x04fa, B:136:0x02d3, B:138:0x02db, B:140:0x02e1, B:142:0x02ec, B:144:0x02f4, B:145:0x02fb, B:148:0x0302, B:260:0x04f3, B:152:0x0311, B:154:0x0319, B:158:0x0332, B:160:0x0339, B:162:0x0347, B:178:0x0391, B:180:0x0397, B:183:0x03a6, B:185:0x03ad, B:187:0x03bb, B:202:0x040a, B:204:0x0412, B:224:0x0457, B:226:0x045f, B:252:0x04a7, B:189:0x03c6, B:190:0x03d1, B:193:0x03d9, B:196:0x03e5, B:198:0x03ec, B:200:0x03f8, B:253:0x04b3, B:254:0x04be, B:255:0x04c9, B:165:0x0350, B:166:0x035a, B:169:0x0364, B:172:0x036f, B:174:0x0376, B:176:0x0382, B:256:0x04d0, B:257:0x04db, B:258:0x04e6, B:266:0x0516, B:269:0x0533, B:325:0x05d9, B:303:0x058f, B:306:0x0598, B:366:0x0657, B:313:0x05aa, B:316:0x05b4, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:353:0x0623, B:355:0x0633, B:357:0x0638, B:348:0x0619, B:72:0x0197, B:74:0x01a3, B:77:0x01ae, B:79:0x01b5, B:81:0x01c1, B:83:0x01cb, B:43:0x011b, B:46:0x0129, B:49:0x0132, B:51:0x0139, B:53:0x0140, B:55:0x0147, B:61:0x015d, B:63:0x0164, B:68:0x0187, B:371:0x0677, B:375:0x0688, B:377:0x0692, B:379:0x069f, B:381:0x06a7, B:385:0x06ba, B:389:0x06c2), top: B:433:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:192:0x03d7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:193:0x03d9 A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, TRY_LEAVE, TryCatch #18 {IOException -> 0x008e, XmlPullParserException -> 0x0092, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x0081, B:16:0x0089, B:22:0x0098, B:25:0x00a4, B:29:0x00b6, B:31:0x00d5, B:33:0x00e3, B:35:0x00ea, B:37:0x00f6, B:39:0x0101, B:69:0x018f, B:87:0x01e9, B:90:0x01f7, B:92:0x01fd, B:94:0x0205, B:96:0x020d, B:98:0x0215, B:100:0x021d, B:102:0x0225, B:104:0x022b, B:106:0x0233, B:108:0x023b, B:110:0x0241, B:112:0x0247, B:114:0x024f, B:116:0x0257, B:119:0x0260, B:391:0x06c8, B:121:0x0286, B:123:0x028c, B:125:0x0295, B:127:0x02a4, B:129:0x02ae, B:131:0x02c2, B:133:0x02c8, B:261:0x04fa, B:136:0x02d3, B:138:0x02db, B:140:0x02e1, B:142:0x02ec, B:144:0x02f4, B:145:0x02fb, B:148:0x0302, B:260:0x04f3, B:152:0x0311, B:154:0x0319, B:158:0x0332, B:160:0x0339, B:162:0x0347, B:178:0x0391, B:180:0x0397, B:183:0x03a6, B:185:0x03ad, B:187:0x03bb, B:202:0x040a, B:204:0x0412, B:224:0x0457, B:226:0x045f, B:252:0x04a7, B:189:0x03c6, B:190:0x03d1, B:193:0x03d9, B:196:0x03e5, B:198:0x03ec, B:200:0x03f8, B:253:0x04b3, B:254:0x04be, B:255:0x04c9, B:165:0x0350, B:166:0x035a, B:169:0x0364, B:172:0x036f, B:174:0x0376, B:176:0x0382, B:256:0x04d0, B:257:0x04db, B:258:0x04e6, B:266:0x0516, B:269:0x0533, B:325:0x05d9, B:303:0x058f, B:306:0x0598, B:366:0x0657, B:313:0x05aa, B:316:0x05b4, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:353:0x0623, B:355:0x0633, B:357:0x0638, B:348:0x0619, B:72:0x0197, B:74:0x01a3, B:77:0x01ae, B:79:0x01b5, B:81:0x01c1, B:83:0x01cb, B:43:0x011b, B:46:0x0129, B:49:0x0132, B:51:0x0139, B:53:0x0140, B:55:0x0147, B:61:0x015d, B:63:0x0164, B:68:0x0187, B:371:0x0677, B:375:0x0688, B:377:0x0692, B:379:0x069f, B:381:0x06a7, B:385:0x06ba, B:389:0x06c2), top: B:433:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:195:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:204:0x0412 A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, TRY_LEAVE, TryCatch #18 {IOException -> 0x008e, XmlPullParserException -> 0x0092, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x0081, B:16:0x0089, B:22:0x0098, B:25:0x00a4, B:29:0x00b6, B:31:0x00d5, B:33:0x00e3, B:35:0x00ea, B:37:0x00f6, B:39:0x0101, B:69:0x018f, B:87:0x01e9, B:90:0x01f7, B:92:0x01fd, B:94:0x0205, B:96:0x020d, B:98:0x0215, B:100:0x021d, B:102:0x0225, B:104:0x022b, B:106:0x0233, B:108:0x023b, B:110:0x0241, B:112:0x0247, B:114:0x024f, B:116:0x0257, B:119:0x0260, B:391:0x06c8, B:121:0x0286, B:123:0x028c, B:125:0x0295, B:127:0x02a4, B:129:0x02ae, B:131:0x02c2, B:133:0x02c8, B:261:0x04fa, B:136:0x02d3, B:138:0x02db, B:140:0x02e1, B:142:0x02ec, B:144:0x02f4, B:145:0x02fb, B:148:0x0302, B:260:0x04f3, B:152:0x0311, B:154:0x0319, B:158:0x0332, B:160:0x0339, B:162:0x0347, B:178:0x0391, B:180:0x0397, B:183:0x03a6, B:185:0x03ad, B:187:0x03bb, B:202:0x040a, B:204:0x0412, B:224:0x0457, B:226:0x045f, B:252:0x04a7, B:189:0x03c6, B:190:0x03d1, B:193:0x03d9, B:196:0x03e5, B:198:0x03ec, B:200:0x03f8, B:253:0x04b3, B:254:0x04be, B:255:0x04c9, B:165:0x0350, B:166:0x035a, B:169:0x0364, B:172:0x036f, B:174:0x0376, B:176:0x0382, B:256:0x04d0, B:257:0x04db, B:258:0x04e6, B:266:0x0516, B:269:0x0533, B:325:0x05d9, B:303:0x058f, B:306:0x0598, B:366:0x0657, B:313:0x05aa, B:316:0x05b4, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:353:0x0623, B:355:0x0633, B:357:0x0638, B:348:0x0619, B:72:0x0197, B:74:0x01a3, B:77:0x01ae, B:79:0x01b5, B:81:0x01c1, B:83:0x01cb, B:43:0x011b, B:46:0x0129, B:49:0x0132, B:51:0x0139, B:53:0x0140, B:55:0x0147, B:61:0x015d, B:63:0x0164, B:68:0x0187, B:371:0x0677, B:375:0x0688, B:377:0x0692, B:379:0x069f, B:381:0x06a7, B:385:0x06ba, B:389:0x06c2), top: B:433:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:207:0x041f  */
    /* JADX WARN: Code duplicated, block: B:210:0x0425  */
    /* JADX WARN: Code duplicated, block: B:213:0x042f  */
    /* JADX WARN: Code duplicated, block: B:215:0x0437  */
    /* JADX WARN: Code duplicated, block: B:216:0x0439  */
    /* JADX WARN: Code duplicated, block: B:218:0x043c  */
    /* JADX WARN: Code duplicated, block: B:220:0x043f  */
    /* JADX WARN: Code duplicated, block: B:221:0x0444  */
    /* JADX WARN: Code duplicated, block: B:222:0x044b  */
    /* JADX WARN: Code duplicated, block: B:226:0x045f A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, TRY_LEAVE, TryCatch #18 {IOException -> 0x008e, XmlPullParserException -> 0x0092, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x0081, B:16:0x0089, B:22:0x0098, B:25:0x00a4, B:29:0x00b6, B:31:0x00d5, B:33:0x00e3, B:35:0x00ea, B:37:0x00f6, B:39:0x0101, B:69:0x018f, B:87:0x01e9, B:90:0x01f7, B:92:0x01fd, B:94:0x0205, B:96:0x020d, B:98:0x0215, B:100:0x021d, B:102:0x0225, B:104:0x022b, B:106:0x0233, B:108:0x023b, B:110:0x0241, B:112:0x0247, B:114:0x024f, B:116:0x0257, B:119:0x0260, B:391:0x06c8, B:121:0x0286, B:123:0x028c, B:125:0x0295, B:127:0x02a4, B:129:0x02ae, B:131:0x02c2, B:133:0x02c8, B:261:0x04fa, B:136:0x02d3, B:138:0x02db, B:140:0x02e1, B:142:0x02ec, B:144:0x02f4, B:145:0x02fb, B:148:0x0302, B:260:0x04f3, B:152:0x0311, B:154:0x0319, B:158:0x0332, B:160:0x0339, B:162:0x0347, B:178:0x0391, B:180:0x0397, B:183:0x03a6, B:185:0x03ad, B:187:0x03bb, B:202:0x040a, B:204:0x0412, B:224:0x0457, B:226:0x045f, B:252:0x04a7, B:189:0x03c6, B:190:0x03d1, B:193:0x03d9, B:196:0x03e5, B:198:0x03ec, B:200:0x03f8, B:253:0x04b3, B:254:0x04be, B:255:0x04c9, B:165:0x0350, B:166:0x035a, B:169:0x0364, B:172:0x036f, B:174:0x0376, B:176:0x0382, B:256:0x04d0, B:257:0x04db, B:258:0x04e6, B:266:0x0516, B:269:0x0533, B:325:0x05d9, B:303:0x058f, B:306:0x0598, B:366:0x0657, B:313:0x05aa, B:316:0x05b4, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:353:0x0623, B:355:0x0633, B:357:0x0638, B:348:0x0619, B:72:0x0197, B:74:0x01a3, B:77:0x01ae, B:79:0x01b5, B:81:0x01c1, B:83:0x01cb, B:43:0x011b, B:46:0x0129, B:49:0x0132, B:51:0x0139, B:53:0x0140, B:55:0x0147, B:61:0x015d, B:63:0x0164, B:68:0x0187, B:371:0x0677, B:375:0x0688, B:377:0x0692, B:379:0x069f, B:381:0x06a7, B:385:0x06ba, B:389:0x06c2), top: B:433:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:229:0x046b  */
    /* JADX WARN: Code duplicated, block: B:231:0x0470  */
    /* JADX WARN: Code duplicated, block: B:234:0x0476  */
    /* JADX WARN: Code duplicated, block: B:237:0x0480  */
    /* JADX WARN: Code duplicated, block: B:239:0x0488  */
    /* JADX WARN: Code duplicated, block: B:240:0x048a  */
    /* JADX WARN: Code duplicated, block: B:242:0x0492  */
    /* JADX WARN: Code duplicated, block: B:243:0x0494  */
    /* JADX WARN: Code duplicated, block: B:245:0x0497  */
    /* JADX WARN: Code duplicated, block: B:249:0x049d  */
    /* JADX WARN: Code duplicated, block: B:251:0x04a5  */
    /* JADX WARN: Code duplicated, block: B:254:0x04be A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, TryCatch #18 {IOException -> 0x008e, XmlPullParserException -> 0x0092, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x0081, B:16:0x0089, B:22:0x0098, B:25:0x00a4, B:29:0x00b6, B:31:0x00d5, B:33:0x00e3, B:35:0x00ea, B:37:0x00f6, B:39:0x0101, B:69:0x018f, B:87:0x01e9, B:90:0x01f7, B:92:0x01fd, B:94:0x0205, B:96:0x020d, B:98:0x0215, B:100:0x021d, B:102:0x0225, B:104:0x022b, B:106:0x0233, B:108:0x023b, B:110:0x0241, B:112:0x0247, B:114:0x024f, B:116:0x0257, B:119:0x0260, B:391:0x06c8, B:121:0x0286, B:123:0x028c, B:125:0x0295, B:127:0x02a4, B:129:0x02ae, B:131:0x02c2, B:133:0x02c8, B:261:0x04fa, B:136:0x02d3, B:138:0x02db, B:140:0x02e1, B:142:0x02ec, B:144:0x02f4, B:145:0x02fb, B:148:0x0302, B:260:0x04f3, B:152:0x0311, B:154:0x0319, B:158:0x0332, B:160:0x0339, B:162:0x0347, B:178:0x0391, B:180:0x0397, B:183:0x03a6, B:185:0x03ad, B:187:0x03bb, B:202:0x040a, B:204:0x0412, B:224:0x0457, B:226:0x045f, B:252:0x04a7, B:189:0x03c6, B:190:0x03d1, B:193:0x03d9, B:196:0x03e5, B:198:0x03ec, B:200:0x03f8, B:253:0x04b3, B:254:0x04be, B:255:0x04c9, B:165:0x0350, B:166:0x035a, B:169:0x0364, B:172:0x036f, B:174:0x0376, B:176:0x0382, B:256:0x04d0, B:257:0x04db, B:258:0x04e6, B:266:0x0516, B:269:0x0533, B:325:0x05d9, B:303:0x058f, B:306:0x0598, B:366:0x0657, B:313:0x05aa, B:316:0x05b4, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:353:0x0623, B:355:0x0633, B:357:0x0638, B:348:0x0619, B:72:0x0197, B:74:0x01a3, B:77:0x01ae, B:79:0x01b5, B:81:0x01c1, B:83:0x01cb, B:43:0x011b, B:46:0x0129, B:49:0x0132, B:51:0x0139, B:53:0x0140, B:55:0x0147, B:61:0x015d, B:63:0x0164, B:68:0x0187, B:371:0x0677, B:375:0x0688, B:377:0x0692, B:379:0x069f, B:381:0x06a7, B:385:0x06ba, B:389:0x06c2), top: B:433:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:255:0x04c9 A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, TryCatch #18 {IOException -> 0x008e, XmlPullParserException -> 0x0092, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x0081, B:16:0x0089, B:22:0x0098, B:25:0x00a4, B:29:0x00b6, B:31:0x00d5, B:33:0x00e3, B:35:0x00ea, B:37:0x00f6, B:39:0x0101, B:69:0x018f, B:87:0x01e9, B:90:0x01f7, B:92:0x01fd, B:94:0x0205, B:96:0x020d, B:98:0x0215, B:100:0x021d, B:102:0x0225, B:104:0x022b, B:106:0x0233, B:108:0x023b, B:110:0x0241, B:112:0x0247, B:114:0x024f, B:116:0x0257, B:119:0x0260, B:391:0x06c8, B:121:0x0286, B:123:0x028c, B:125:0x0295, B:127:0x02a4, B:129:0x02ae, B:131:0x02c2, B:133:0x02c8, B:261:0x04fa, B:136:0x02d3, B:138:0x02db, B:140:0x02e1, B:142:0x02ec, B:144:0x02f4, B:145:0x02fb, B:148:0x0302, B:260:0x04f3, B:152:0x0311, B:154:0x0319, B:158:0x0332, B:160:0x0339, B:162:0x0347, B:178:0x0391, B:180:0x0397, B:183:0x03a6, B:185:0x03ad, B:187:0x03bb, B:202:0x040a, B:204:0x0412, B:224:0x0457, B:226:0x045f, B:252:0x04a7, B:189:0x03c6, B:190:0x03d1, B:193:0x03d9, B:196:0x03e5, B:198:0x03ec, B:200:0x03f8, B:253:0x04b3, B:254:0x04be, B:255:0x04c9, B:165:0x0350, B:166:0x035a, B:169:0x0364, B:172:0x036f, B:174:0x0376, B:176:0x0382, B:256:0x04d0, B:257:0x04db, B:258:0x04e6, B:266:0x0516, B:269:0x0533, B:325:0x05d9, B:303:0x058f, B:306:0x0598, B:366:0x0657, B:313:0x05aa, B:316:0x05b4, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:353:0x0623, B:355:0x0633, B:357:0x0638, B:348:0x0619, B:72:0x0197, B:74:0x01a3, B:77:0x01ae, B:79:0x01b5, B:81:0x01c1, B:83:0x01cb, B:43:0x011b, B:46:0x0129, B:49:0x0132, B:51:0x0139, B:53:0x0140, B:55:0x0147, B:61:0x015d, B:63:0x0164, B:68:0x0187, B:371:0x0677, B:375:0x0688, B:377:0x0692, B:379:0x069f, B:381:0x06a7, B:385:0x06ba, B:389:0x06c2), top: B:433:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:257:0x04db A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, TryCatch #18 {IOException -> 0x008e, XmlPullParserException -> 0x0092, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x0081, B:16:0x0089, B:22:0x0098, B:25:0x00a4, B:29:0x00b6, B:31:0x00d5, B:33:0x00e3, B:35:0x00ea, B:37:0x00f6, B:39:0x0101, B:69:0x018f, B:87:0x01e9, B:90:0x01f7, B:92:0x01fd, B:94:0x0205, B:96:0x020d, B:98:0x0215, B:100:0x021d, B:102:0x0225, B:104:0x022b, B:106:0x0233, B:108:0x023b, B:110:0x0241, B:112:0x0247, B:114:0x024f, B:116:0x0257, B:119:0x0260, B:391:0x06c8, B:121:0x0286, B:123:0x028c, B:125:0x0295, B:127:0x02a4, B:129:0x02ae, B:131:0x02c2, B:133:0x02c8, B:261:0x04fa, B:136:0x02d3, B:138:0x02db, B:140:0x02e1, B:142:0x02ec, B:144:0x02f4, B:145:0x02fb, B:148:0x0302, B:260:0x04f3, B:152:0x0311, B:154:0x0319, B:158:0x0332, B:160:0x0339, B:162:0x0347, B:178:0x0391, B:180:0x0397, B:183:0x03a6, B:185:0x03ad, B:187:0x03bb, B:202:0x040a, B:204:0x0412, B:224:0x0457, B:226:0x045f, B:252:0x04a7, B:189:0x03c6, B:190:0x03d1, B:193:0x03d9, B:196:0x03e5, B:198:0x03ec, B:200:0x03f8, B:253:0x04b3, B:254:0x04be, B:255:0x04c9, B:165:0x0350, B:166:0x035a, B:169:0x0364, B:172:0x036f, B:174:0x0376, B:176:0x0382, B:256:0x04d0, B:257:0x04db, B:258:0x04e6, B:266:0x0516, B:269:0x0533, B:325:0x05d9, B:303:0x058f, B:306:0x0598, B:366:0x0657, B:313:0x05aa, B:316:0x05b4, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:353:0x0623, B:355:0x0633, B:357:0x0638, B:348:0x0619, B:72:0x0197, B:74:0x01a3, B:77:0x01ae, B:79:0x01b5, B:81:0x01c1, B:83:0x01cb, B:43:0x011b, B:46:0x0129, B:49:0x0132, B:51:0x0139, B:53:0x0140, B:55:0x0147, B:61:0x015d, B:63:0x0164, B:68:0x0187, B:371:0x0677, B:375:0x0688, B:377:0x0692, B:379:0x069f, B:381:0x06a7, B:385:0x06ba, B:389:0x06c2), top: B:433:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:258:0x04e6 A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, TryCatch #18 {IOException -> 0x008e, XmlPullParserException -> 0x0092, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x0081, B:16:0x0089, B:22:0x0098, B:25:0x00a4, B:29:0x00b6, B:31:0x00d5, B:33:0x00e3, B:35:0x00ea, B:37:0x00f6, B:39:0x0101, B:69:0x018f, B:87:0x01e9, B:90:0x01f7, B:92:0x01fd, B:94:0x0205, B:96:0x020d, B:98:0x0215, B:100:0x021d, B:102:0x0225, B:104:0x022b, B:106:0x0233, B:108:0x023b, B:110:0x0241, B:112:0x0247, B:114:0x024f, B:116:0x0257, B:119:0x0260, B:391:0x06c8, B:121:0x0286, B:123:0x028c, B:125:0x0295, B:127:0x02a4, B:129:0x02ae, B:131:0x02c2, B:133:0x02c8, B:261:0x04fa, B:136:0x02d3, B:138:0x02db, B:140:0x02e1, B:142:0x02ec, B:144:0x02f4, B:145:0x02fb, B:148:0x0302, B:260:0x04f3, B:152:0x0311, B:154:0x0319, B:158:0x0332, B:160:0x0339, B:162:0x0347, B:178:0x0391, B:180:0x0397, B:183:0x03a6, B:185:0x03ad, B:187:0x03bb, B:202:0x040a, B:204:0x0412, B:224:0x0457, B:226:0x045f, B:252:0x04a7, B:189:0x03c6, B:190:0x03d1, B:193:0x03d9, B:196:0x03e5, B:198:0x03ec, B:200:0x03f8, B:253:0x04b3, B:254:0x04be, B:255:0x04c9, B:165:0x0350, B:166:0x035a, B:169:0x0364, B:172:0x036f, B:174:0x0376, B:176:0x0382, B:256:0x04d0, B:257:0x04db, B:258:0x04e6, B:266:0x0516, B:269:0x0533, B:325:0x05d9, B:303:0x058f, B:306:0x0598, B:366:0x0657, B:313:0x05aa, B:316:0x05b4, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:353:0x0623, B:355:0x0633, B:357:0x0638, B:348:0x0619, B:72:0x0197, B:74:0x01a3, B:77:0x01ae, B:79:0x01b5, B:81:0x01c1, B:83:0x01cb, B:43:0x011b, B:46:0x0129, B:49:0x0132, B:51:0x0139, B:53:0x0140, B:55:0x0147, B:61:0x015d, B:63:0x0164, B:68:0x0187, B:371:0x0677, B:375:0x0688, B:377:0x0692, B:379:0x069f, B:381:0x06a7, B:385:0x06ba, B:389:0x06c2), top: B:433:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:260:0x04f3 A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, TryCatch #18 {IOException -> 0x008e, XmlPullParserException -> 0x0092, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x0081, B:16:0x0089, B:22:0x0098, B:25:0x00a4, B:29:0x00b6, B:31:0x00d5, B:33:0x00e3, B:35:0x00ea, B:37:0x00f6, B:39:0x0101, B:69:0x018f, B:87:0x01e9, B:90:0x01f7, B:92:0x01fd, B:94:0x0205, B:96:0x020d, B:98:0x0215, B:100:0x021d, B:102:0x0225, B:104:0x022b, B:106:0x0233, B:108:0x023b, B:110:0x0241, B:112:0x0247, B:114:0x024f, B:116:0x0257, B:119:0x0260, B:391:0x06c8, B:121:0x0286, B:123:0x028c, B:125:0x0295, B:127:0x02a4, B:129:0x02ae, B:131:0x02c2, B:133:0x02c8, B:261:0x04fa, B:136:0x02d3, B:138:0x02db, B:140:0x02e1, B:142:0x02ec, B:144:0x02f4, B:145:0x02fb, B:148:0x0302, B:260:0x04f3, B:152:0x0311, B:154:0x0319, B:158:0x0332, B:160:0x0339, B:162:0x0347, B:178:0x0391, B:180:0x0397, B:183:0x03a6, B:185:0x03ad, B:187:0x03bb, B:202:0x040a, B:204:0x0412, B:224:0x0457, B:226:0x045f, B:252:0x04a7, B:189:0x03c6, B:190:0x03d1, B:193:0x03d9, B:196:0x03e5, B:198:0x03ec, B:200:0x03f8, B:253:0x04b3, B:254:0x04be, B:255:0x04c9, B:165:0x0350, B:166:0x035a, B:169:0x0364, B:172:0x036f, B:174:0x0376, B:176:0x0382, B:256:0x04d0, B:257:0x04db, B:258:0x04e6, B:266:0x0516, B:269:0x0533, B:325:0x05d9, B:303:0x058f, B:306:0x0598, B:366:0x0657, B:313:0x05aa, B:316:0x05b4, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:353:0x0623, B:355:0x0633, B:357:0x0638, B:348:0x0619, B:72:0x0197, B:74:0x01a3, B:77:0x01ae, B:79:0x01b5, B:81:0x01c1, B:83:0x01cb, B:43:0x011b, B:46:0x0129, B:49:0x0132, B:51:0x0139, B:53:0x0140, B:55:0x0147, B:61:0x015d, B:63:0x0164, B:68:0x0187, B:371:0x0677, B:375:0x0688, B:377:0x0692, B:379:0x069f, B:381:0x06a7, B:385:0x06ba, B:389:0x06c2), top: B:433:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:264:0x0506 A[LOOP:1: B:123:0x028c->B:264:0x0506, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:265:0x0510  */
    /* JADX WARN: Code duplicated, block: B:272:0x0543  */
    /* JADX WARN: Code duplicated, block: B:274:0x054b  */
    /* JADX WARN: Code duplicated, block: B:275:0x054d  */
    /* JADX WARN: Code duplicated, block: B:277:0x0553  */
    /* JADX WARN: Code duplicated, block: B:278:0x0555  */
    /* JADX WARN: Code duplicated, block: B:280:0x055d  */
    /* JADX WARN: Code duplicated, block: B:281:0x055f  */
    /* JADX WARN: Code duplicated, block: B:283:0x0567  */
    /* JADX WARN: Code duplicated, block: B:284:0x0569  */
    /* JADX WARN: Code duplicated, block: B:286:0x0571  */
    /* JADX WARN: Code duplicated, block: B:287:0x0573  */
    /* JADX WARN: Code duplicated, block: B:289:0x0579  */
    /* JADX WARN: Code duplicated, block: B:290:0x057b  */
    /* JADX WARN: Code duplicated, block: B:292:0x057e  */
    /* JADX WARN: Code duplicated, block: B:294:0x0581  */
    /* JADX WARN: Code duplicated, block: B:296:0x0584  */
    /* JADX WARN: Code duplicated, block: B:298:0x0587  */
    /* JADX WARN: Code duplicated, block: B:300:0x058a  */
    /* JADX WARN: Code duplicated, block: B:302:0x058d  */
    /* JADX WARN: Code duplicated, block: B:305:0x0597  */
    /* JADX WARN: Code duplicated, block: B:313:0x05aa A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, zzakn -> 0x059f, TryCatch #11 {zzakn -> 0x059f, blocks: (B:306:0x0598, B:313:0x05aa, B:316:0x05b4), top: B:419:0x0598 }] */
    /* JADX WARN: Code duplicated, block: B:315:0x05b1  */
    /* JADX WARN: Code duplicated, block: B:316:0x05b4 A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, zzakn -> 0x059f, TRY_LEAVE, TryCatch #11 {zzakn -> 0x059f, blocks: (B:306:0x0598, B:313:0x05aa, B:316:0x05b4), top: B:419:0x0598 }] */
    /* JADX WARN: Code duplicated, block: B:318:0x05bc  */
    /* JADX WARN: Code duplicated, block: B:319:0x05bf  */
    /* JADX WARN: Code duplicated, block: B:323:0x05ca A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, zzakn -> 0x05c7, TryCatch #16 {zzakn -> 0x05c7, blocks: (B:325:0x05d9, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:348:0x0619), top: B:429:0x05d9 }] */
    /* JADX WARN: Code duplicated, block: B:324:0x05d2 A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, zzakn -> 0x05c7, TryCatch #16 {zzakn -> 0x05c7, blocks: (B:325:0x05d9, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:348:0x0619), top: B:429:0x05d9 }] */
    /* JADX WARN: Code duplicated, block: B:330:0x05ea A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, zzakn -> 0x05c7, TryCatch #16 {zzakn -> 0x05c7, blocks: (B:325:0x05d9, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:348:0x0619), top: B:429:0x05d9 }] */
    /* JADX WARN: Code duplicated, block: B:332:0x05f2  */
    /* JADX WARN: Code duplicated, block: B:334:0x05f6 A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, zzakn -> 0x05c7, TryCatch #16 {zzakn -> 0x05c7, blocks: (B:325:0x05d9, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:348:0x0619), top: B:429:0x05d9 }] */
    /* JADX WARN: Code duplicated, block: B:335:0x05f9  */
    /* JADX WARN: Code duplicated, block: B:338:0x05ff A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, zzakn -> 0x05c7, TryCatch #16 {zzakn -> 0x05c7, blocks: (B:325:0x05d9, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:348:0x0619), top: B:429:0x05d9 }] */
    /* JADX WARN: Code duplicated, block: B:339:0x0601 A[PHI: r28 r30
  0x0601: PHI (r28v6 long) = (r28v3 long), (r28v8 long) binds: [B:331:0x05f0, B:338:0x05ff] A[DONT_GENERATE, DONT_INLINE]
  0x0601: PHI (r30v3 long) = (r30v1 long), (r30v5 long) binds: [B:331:0x05f0, B:338:0x05ff] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:340:0x0603  */
    /* JADX WARN: Code duplicated, block: B:341:0x0607  */
    /* JADX WARN: Code duplicated, block: B:344:0x060e  */
    /* JADX WARN: Code duplicated, block: B:346:0x0612 A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, zzakn -> 0x05c7, TryCatch #16 {zzakn -> 0x05c7, blocks: (B:325:0x05d9, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:348:0x0619), top: B:429:0x05d9 }] */
    /* JADX WARN: Code duplicated, block: B:347:0x0617 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:348:0x0619 A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, zzakn -> 0x05c7, TRY_LEAVE, TryCatch #16 {zzakn -> 0x05c7, blocks: (B:325:0x05d9, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:348:0x0619), top: B:429:0x05d9 }] */
    /* JADX WARN: Code duplicated, block: B:351:0x061f  */
    /* JADX WARN: Code duplicated, block: B:352:0x0621  */
    /* JADX WARN: Code duplicated, block: B:357:0x0638 A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, zzakn -> 0x063c, TRY_LEAVE, TryCatch #9 {zzakn -> 0x063c, blocks: (B:355:0x0633, B:357:0x0638), top: B:415:0x0633 }] */
    /* JADX WARN: Code duplicated, block: B:417:0x0533 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:427:0x058f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:436:0x0500 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x0195  */
    /* JADX WARN: Code duplicated, block: B:72:0x0197 A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, TryCatch #18 {IOException -> 0x008e, XmlPullParserException -> 0x0092, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x0081, B:16:0x0089, B:22:0x0098, B:25:0x00a4, B:29:0x00b6, B:31:0x00d5, B:33:0x00e3, B:35:0x00ea, B:37:0x00f6, B:39:0x0101, B:69:0x018f, B:87:0x01e9, B:90:0x01f7, B:92:0x01fd, B:94:0x0205, B:96:0x020d, B:98:0x0215, B:100:0x021d, B:102:0x0225, B:104:0x022b, B:106:0x0233, B:108:0x023b, B:110:0x0241, B:112:0x0247, B:114:0x024f, B:116:0x0257, B:119:0x0260, B:391:0x06c8, B:121:0x0286, B:123:0x028c, B:125:0x0295, B:127:0x02a4, B:129:0x02ae, B:131:0x02c2, B:133:0x02c8, B:261:0x04fa, B:136:0x02d3, B:138:0x02db, B:140:0x02e1, B:142:0x02ec, B:144:0x02f4, B:145:0x02fb, B:148:0x0302, B:260:0x04f3, B:152:0x0311, B:154:0x0319, B:158:0x0332, B:160:0x0339, B:162:0x0347, B:178:0x0391, B:180:0x0397, B:183:0x03a6, B:185:0x03ad, B:187:0x03bb, B:202:0x040a, B:204:0x0412, B:224:0x0457, B:226:0x045f, B:252:0x04a7, B:189:0x03c6, B:190:0x03d1, B:193:0x03d9, B:196:0x03e5, B:198:0x03ec, B:200:0x03f8, B:253:0x04b3, B:254:0x04be, B:255:0x04c9, B:165:0x0350, B:166:0x035a, B:169:0x0364, B:172:0x036f, B:174:0x0376, B:176:0x0382, B:256:0x04d0, B:257:0x04db, B:258:0x04e6, B:266:0x0516, B:269:0x0533, B:325:0x05d9, B:303:0x058f, B:306:0x0598, B:366:0x0657, B:313:0x05aa, B:316:0x05b4, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:353:0x0623, B:355:0x0633, B:357:0x0638, B:348:0x0619, B:72:0x0197, B:74:0x01a3, B:77:0x01ae, B:79:0x01b5, B:81:0x01c1, B:83:0x01cb, B:43:0x011b, B:46:0x0129, B:49:0x0132, B:51:0x0139, B:53:0x0140, B:55:0x0147, B:61:0x015d, B:63:0x0164, B:68:0x0187, B:371:0x0677, B:375:0x0688, B:377:0x0692, B:379:0x069f, B:381:0x06a7, B:385:0x06ba, B:389:0x06c2), top: B:433:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x01a3 A[Catch: IOException -> 0x008e, XmlPullParserException -> 0x0092, TRY_LEAVE, TryCatch #18 {IOException -> 0x008e, XmlPullParserException -> 0x0092, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x0081, B:16:0x0089, B:22:0x0098, B:25:0x00a4, B:29:0x00b6, B:31:0x00d5, B:33:0x00e3, B:35:0x00ea, B:37:0x00f6, B:39:0x0101, B:69:0x018f, B:87:0x01e9, B:90:0x01f7, B:92:0x01fd, B:94:0x0205, B:96:0x020d, B:98:0x0215, B:100:0x021d, B:102:0x0225, B:104:0x022b, B:106:0x0233, B:108:0x023b, B:110:0x0241, B:112:0x0247, B:114:0x024f, B:116:0x0257, B:119:0x0260, B:391:0x06c8, B:121:0x0286, B:123:0x028c, B:125:0x0295, B:127:0x02a4, B:129:0x02ae, B:131:0x02c2, B:133:0x02c8, B:261:0x04fa, B:136:0x02d3, B:138:0x02db, B:140:0x02e1, B:142:0x02ec, B:144:0x02f4, B:145:0x02fb, B:148:0x0302, B:260:0x04f3, B:152:0x0311, B:154:0x0319, B:158:0x0332, B:160:0x0339, B:162:0x0347, B:178:0x0391, B:180:0x0397, B:183:0x03a6, B:185:0x03ad, B:187:0x03bb, B:202:0x040a, B:204:0x0412, B:224:0x0457, B:226:0x045f, B:252:0x04a7, B:189:0x03c6, B:190:0x03d1, B:193:0x03d9, B:196:0x03e5, B:198:0x03ec, B:200:0x03f8, B:253:0x04b3, B:254:0x04be, B:255:0x04c9, B:165:0x0350, B:166:0x035a, B:169:0x0364, B:172:0x036f, B:174:0x0376, B:176:0x0382, B:256:0x04d0, B:257:0x04db, B:258:0x04e6, B:266:0x0516, B:269:0x0533, B:325:0x05d9, B:303:0x058f, B:306:0x0598, B:366:0x0657, B:313:0x05aa, B:316:0x05b4, B:320:0x05c2, B:323:0x05ca, B:324:0x05d2, B:330:0x05ea, B:334:0x05f6, B:338:0x05ff, B:346:0x0612, B:353:0x0623, B:355:0x0633, B:357:0x0638, B:348:0x0619, B:72:0x0197, B:74:0x01a3, B:77:0x01ae, B:79:0x01b5, B:81:0x01c1, B:83:0x01cb, B:43:0x011b, B:46:0x0129, B:49:0x0132, B:51:0x0139, B:53:0x0140, B:55:0x0147, B:61:0x015d, B:63:0x0164, B:68:0x0187, B:371:0x0677, B:375:0x0688, B:377:0x0692, B:379:0x069f, B:381:0x06a7, B:385:0x06ba, B:389:0x06c2), top: B:433:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x01ad  */
    public final zzakm zzb(byte[] bArr, int i11, int i12) {
        String str;
        String str2;
        HashMap map;
        ArrayDeque arrayDeque;
        zzalv zzalvVar;
        int i13;
        HashMap map2;
        boolean zEquals;
        String str3;
        HashMap map3;
        zzalp zzalpVar;
        zzalp zzalpVar2;
        zzakn zzaknVar;
        int attributeCount;
        long j11;
        String[] strArr;
        String strSubstring;
        long jZzc;
        long jZzc2;
        long jZzc3;
        String str4;
        int i14;
        zzalo zzaloVar;
        zzalo zzaloVar2;
        zzalo zzaloVarZzb;
        long j12;
        long j13;
        String attributeName;
        String attributeValue;
        byte b11;
        String[] strArrZzg;
        String strZza;
        String strZza2;
        String str5;
        Pattern pattern;
        Matcher matcher;
        Pattern pattern2;
        Matcher matcher2;
        float f11;
        float f12;
        float f13;
        String strZza3;
        Matcher matcher3;
        Matcher matcher4;
        float f14;
        float f15;
        String strZza4;
        float f16;
        int i15;
        String strZza5;
        int i16;
        zzals zzalsVar;
        String strZza6;
        int iHashCode;
        byte b12;
        String strZza7;
        int iHashCode2;
        byte b13;
        String strZza8;
        String strZza9;
        zzalu zzaluVarZzf;
        String strZzE;
        String[] strArrZzg2;
        int length;
        int i17;
        float f17;
        int i18;
        boolean z11;
        String strZza10;
        Matcher matcher5;
        String str6 = "";
        String str7 = "http://www.w3.org/ns/ttml#parameter";
        try {
            XmlPullParser xmlPullParserNewPullParser = this.zzi.newPullParser();
            HashMap map4 = new HashMap();
            HashMap map5 = new HashMap();
            HashMap map6 = new HashMap();
            map5.put("", new zzals("", -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE));
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, i11, i12), null);
            ArrayDeque arrayDeque2 = new ArrayDeque();
            int eventType = xmlPullParserNewPullParser.getEventType();
            zzalp zzalpVar3 = zzh;
            zzalv zzalvVar2 = null;
            zzalq zzalqVar = null;
            int i19 = 0;
            int i21 = 15;
            while (eventType != 1) {
                zzalo zzaloVar3 = (zzalo) arrayDeque2.peek();
                if (i19 == 0) {
                    String name = xmlPullParserNewPullParser.getName();
                    str = str6;
                    if (eventType == 2) {
                        if (TtmlNode.TAG_TT.equals(name)) {
                            String attributeValue2 = xmlPullParserNewPullParser.getAttributeValue(str7, "frameRate");
                            int i22 = attributeValue2 != null ? Integer.parseInt(attributeValue2) : 30;
                            String attributeValue3 = xmlPullParserNewPullParser.getAttributeValue(str7, "frameRateMultiplier");
                            if (attributeValue3 != null) {
                                int i23 = zzfy.zza;
                                String[] strArrSplit = attributeValue3.split(" ", -1);
                                zzek.zze(strArrSplit.length == 2, "frameRateMultiplier doesn't have 2 parts");
                                f17 = Integer.parseInt(strArrSplit[0]) / Integer.parseInt(strArrSplit[1]);
                            } else {
                                f17 = 1.0f;
                            }
                            zzalp zzalpVar4 = zzh;
                            int i24 = zzalpVar4.zzb;
                            String attributeValue4 = xmlPullParserNewPullParser.getAttributeValue(str7, "subFrameRate");
                            int i25 = attributeValue4 != null ? Integer.parseInt(attributeValue4) : i24;
                            int i26 = zzalpVar4.zzc;
                            String attributeValue5 = xmlPullParserNewPullParser.getAttributeValue(str7, "tickRate");
                            zzalp zzalpVar5 = new zzalp(i22 * f17, i25, attributeValue5 != null ? Integer.parseInt(attributeValue5) : i26);
                            String attributeValue6 = xmlPullParserNewPullParser.getAttributeValue(str7, "cellResolution");
                            if (attributeValue6 == null) {
                                str2 = str7;
                                map2 = map5;
                                zzalpVar5 = zzalpVar5;
                                i21 = 15;
                            } else {
                                Matcher matcher6 = zzg.matcher(attributeValue6);
                                if (matcher6.matches()) {
                                    try {
                                        String strGroup = matcher6.group(1);
                                        strGroup.getClass();
                                        int i27 = Integer.parseInt(strGroup);
                                        str2 = str7;
                                        try {
                                            String strGroup2 = matcher6.group(2);
                                            strGroup2.getClass();
                                            int i28 = Integer.parseInt(strGroup2);
                                            if (i27 == 0) {
                                                i18 = i28;
                                                z11 = false;
                                            } else if (i28 != 0) {
                                                i18 = i28;
                                                z11 = true;
                                            } else {
                                                z11 = false;
                                                i18 = 0;
                                            }
                                            try {
                                                StringBuilder sb2 = new StringBuilder();
                                                map2 = map5;
                                                try {
                                                    sb2.append("Invalid cell resolution ");
                                                    sb2.append(i27);
                                                    sb2.append(" ");
                                                    sb2.append(i18);
                                                    zzek.zze(z11, sb2.toString());
                                                    i21 = i18;
                                                } catch (NumberFormatException unused) {
                                                    zzff.zzf("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue6));
                                                    i21 = 15;
                                                }
                                            } catch (NumberFormatException unused2) {
                                                map2 = map5;
                                            }
                                        } catch (NumberFormatException unused3) {
                                            map2 = map5;
                                            zzalpVar5 = zzalpVar5;
                                            zzff.zzf("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue6));
                                            i21 = 15;
                                            strZza10 = zzfz.zza(xmlPullParserNewPullParser, TtmlNode.ATTR_TTS_EXTENT);
                                            if (strZza10 == null) {
                                                zzalqVar = null;
                                            } else {
                                                matcher5 = zzf.matcher(strZza10);
                                                if (matcher5.matches()) {
                                                    try {
                                                        String strGroup3 = matcher5.group(1);
                                                        strGroup3.getClass();
                                                        int i29 = Integer.parseInt(strGroup3);
                                                        String strGroup4 = matcher5.group(2);
                                                        strGroup4.getClass();
                                                        zzalqVar = new zzalq(i29, Integer.parseInt(strGroup4));
                                                    } catch (NumberFormatException unused4) {
                                                        zzff.zzf("TtmlParser", "Ignoring malformed tts extent: ".concat(strZza10));
                                                        zzalqVar = null;
                                                    }
                                                } else {
                                                    zzff.zzf("TtmlParser", "Ignoring non-pixel tts extent: ".concat(strZza10));
                                                }
                                                zzalqVar = null;
                                            }
                                            zzalpVar3 = zzalpVar5;
                                            i21 = i21;
                                            zEquals = name.equals(TtmlNode.TAG_TT);
                                            str3 = TtmlNode.TAG_METADATA;
                                            if (zEquals) {
                                                if (TtmlNode.TAG_HEAD.equals(name)) {
                                                    while (true) {
                                                        xmlPullParserNewPullParser.next();
                                                        if (zzfz.zzc(xmlPullParserNewPullParser, TtmlNode.TAG_STYLE)) {
                                                            strZza9 = zzfz.zza(xmlPullParserNewPullParser, TtmlNode.TAG_STYLE);
                                                            zzaluVarZzf = zzf(xmlPullParserNewPullParser, new zzalu());
                                                            if (strZza9 != null) {
                                                                strArrZzg2 = zzg(strZza9);
                                                                i17 = 0;
                                                                for (length = strArrZzg2.length; i17 < length; length = length) {
                                                                    zzaluVarZzf.zzl((zzalu) map4.get(strArrZzg2[i17]));
                                                                    i17++;
                                                                }
                                                            }
                                                            strZzE = zzaluVarZzf.zzE();
                                                            if (strZzE != null) {
                                                                map4.put(strZzE, zzaluVarZzf);
                                                            }
                                                        } else {
                                                            zzalpVar3 = zzalpVar3;
                                                            if (zzfz.zzc(xmlPullParserNewPullParser, TtmlNode.TAG_REGION)) {
                                                                strZza = zzfz.zza(xmlPullParserNewPullParser, "id");
                                                                if (strZza == null) {
                                                                    map3 = map4;
                                                                    str5 = str3;
                                                                } else {
                                                                    strZza2 = zzfz.zza(xmlPullParserNewPullParser, "origin");
                                                                    if (strZza2 != null) {
                                                                        pattern = zzb;
                                                                        matcher = pattern.matcher(strZza2);
                                                                        pattern2 = zzf;
                                                                        str5 = str3;
                                                                        matcher2 = pattern2.matcher(strZza2);
                                                                        if (matcher.matches()) {
                                                                            map3 = map4;
                                                                            String strGroup5 = matcher.group(1);
                                                                            strGroup5.getClass();
                                                                            f11 = Float.parseFloat(strGroup5) / 100.0f;
                                                                            String strGroup6 = matcher.group(2);
                                                                            strGroup6.getClass();
                                                                            f12 = Float.parseFloat(strGroup6) / 100.0f;
                                                                            f13 = f11;
                                                                            strZza3 = zzfz.zza(xmlPullParserNewPullParser, TtmlNode.ATTR_TTS_EXTENT);
                                                                            if (strZza3 != null) {
                                                                                matcher3 = pattern.matcher(strZza3);
                                                                                matcher4 = pattern2.matcher(strZza3);
                                                                                if (matcher3.matches()) {
                                                                                    String strGroup7 = matcher3.group(1);
                                                                                    strGroup7.getClass();
                                                                                    float f18 = Float.parseFloat(strGroup7) / 100.0f;
                                                                                    String strGroup8 = matcher3.group(2);
                                                                                    strGroup8.getClass();
                                                                                    f14 = Float.parseFloat(strGroup8) / 100.0f;
                                                                                    f15 = f18;
                                                                                    strZza4 = zzfz.zza(xmlPullParserNewPullParser, TtmlNode.ATTR_TTS_DISPLAY_ALIGN);
                                                                                    if (strZza4 != null) {
                                                                                        strZza7 = zzfwk.zza(strZza4);
                                                                                        iHashCode2 = strZza7.hashCode();
                                                                                        if (iHashCode2 != -1364013995) {
                                                                                            if (iHashCode2 != 92734940) {
                                                                                                b13 = -1;
                                                                                            } else {
                                                                                                b13 = 1;
                                                                                            }
                                                                                        } else if (strZza7.equals(TtmlNode.CENTER)) {
                                                                                            b13 = 0;
                                                                                        } else {
                                                                                            b13 = -1;
                                                                                        }
                                                                                        if (b13 != 0) {
                                                                                            f16 = f12 + (f14 / 2.0f);
                                                                                            i15 = 1;
                                                                                        } else if (b13 != 1) {
                                                                                            f16 = f12;
                                                                                            i15 = 0;
                                                                                        } else {
                                                                                            f16 = f12 + f14;
                                                                                            i15 = 2;
                                                                                        }
                                                                                    } else {
                                                                                        f16 = f12;
                                                                                        i15 = 0;
                                                                                    }
                                                                                    float f19 = 1.0f / i21;
                                                                                    strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                    if (strZza5 != null) {
                                                                                        strZza6 = zzfwk.zza(strZza5);
                                                                                        iHashCode = strZza6.hashCode();
                                                                                        if (iHashCode != 3694) {
                                                                                            if (iHashCode != 3553396) {
                                                                                                if (iHashCode != 3553576) {
                                                                                                    b12 = -1;
                                                                                                } else {
                                                                                                    b12 = 2;
                                                                                                }
                                                                                            } else if (strZza6.equals("tblr")) {
                                                                                                b12 = 1;
                                                                                            } else {
                                                                                                b12 = -1;
                                                                                            }
                                                                                        } else if (strZza6.equals("tb")) {
                                                                                            b12 = 0;
                                                                                        } else {
                                                                                            b12 = -1;
                                                                                        }
                                                                                        if (b12 != 0) {
                                                                                            i16 = 2;
                                                                                        } else {
                                                                                            i16 = 2;
                                                                                        }
                                                                                    } else {
                                                                                        i16 = Integer.MIN_VALUE;
                                                                                    }
                                                                                    zzalsVar = new zzals(strZza, f13, f16, 0, i15, f15, f14, 1, f19, i16);
                                                                                } else if (matcher4.matches()) {
                                                                                    zzff.zzf("TtmlParser", "Ignoring region with unsupported extent: ".concat(strZza2));
                                                                                } else if (zzalqVar == null) {
                                                                                    zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                                                } else {
                                                                                    String strGroup9 = matcher4.group(1);
                                                                                    strGroup9.getClass();
                                                                                    int i31 = Integer.parseInt(strGroup9);
                                                                                    String strGroup10 = matcher4.group(2);
                                                                                    strGroup10.getClass();
                                                                                    int i32 = Integer.parseInt(strGroup10);
                                                                                    float f21 = i31 / zzalqVar.zza;
                                                                                    f14 = i32 / zzalqVar.zzb;
                                                                                    f15 = f21;
                                                                                    strZza4 = zzfz.zza(xmlPullParserNewPullParser, TtmlNode.ATTR_TTS_DISPLAY_ALIGN);
                                                                                    if (strZza4 != null) {
                                                                                        strZza7 = zzfwk.zza(strZza4);
                                                                                        iHashCode2 = strZza7.hashCode();
                                                                                        if (iHashCode2 != -1364013995) {
                                                                                            if (iHashCode2 != 92734940) {
                                                                                                b13 = -1;
                                                                                            } else {
                                                                                                b13 = 1;
                                                                                            }
                                                                                        } else if (strZza7.equals(TtmlNode.CENTER)) {
                                                                                            b13 = 0;
                                                                                        } else {
                                                                                            b13 = -1;
                                                                                        }
                                                                                        if (b13 != 0) {
                                                                                            f16 = f12 + (f14 / 2.0f);
                                                                                            i15 = 1;
                                                                                        } else if (b13 != 1) {
                                                                                            f16 = f12;
                                                                                            i15 = 0;
                                                                                        } else {
                                                                                            f16 = f12 + f14;
                                                                                            i15 = 2;
                                                                                        }
                                                                                    } else {
                                                                                        f16 = f12;
                                                                                        i15 = 0;
                                                                                    }
                                                                                    float f110 = 1.0f / i21;
                                                                                    strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                    if (strZza5 != null) {
                                                                                        strZza6 = zzfwk.zza(strZza5);
                                                                                        iHashCode = strZza6.hashCode();
                                                                                        if (iHashCode != 3694) {
                                                                                            if (iHashCode != 3553396) {
                                                                                                if (iHashCode != 3553576) {
                                                                                                    b12 = -1;
                                                                                                } else {
                                                                                                    b12 = 2;
                                                                                                }
                                                                                            } else if (strZza6.equals("tblr")) {
                                                                                                b12 = 1;
                                                                                            } else {
                                                                                                b12 = -1;
                                                                                            }
                                                                                        } else if (strZza6.equals("tb")) {
                                                                                            b12 = 0;
                                                                                        } else {
                                                                                            b12 = -1;
                                                                                        }
                                                                                        if (b12 != 0) {
                                                                                            i16 = 2;
                                                                                        } else {
                                                                                            i16 = 2;
                                                                                        }
                                                                                    } else {
                                                                                        i16 = Integer.MIN_VALUE;
                                                                                    }
                                                                                    zzalsVar = new zzals(strZza, f13, f16, 0, i15, f15, f14, 1, f110, i16);
                                                                                }
                                                                                if (zzalsVar != null) {
                                                                                    map5 = map2;
                                                                                    map5.put(zzalsVar.zza, zzalsVar);
                                                                                } else {
                                                                                    map5 = map2;
                                                                                }
                                                                            } else {
                                                                                zzff.zzf("TtmlParser", "Ignoring region without an extent");
                                                                            }
                                                                        } else {
                                                                            map3 = map4;
                                                                            if (!matcher2.matches()) {
                                                                                zzff.zzf("TtmlParser", "Ignoring region with unsupported origin: ".concat(strZza2));
                                                                            } else if (zzalqVar == null) {
                                                                                zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                                            } else {
                                                                                String strGroup11 = matcher2.group(1);
                                                                                strGroup11.getClass();
                                                                                int i33 = Integer.parseInt(strGroup11);
                                                                                String strGroup12 = matcher2.group(2);
                                                                                strGroup12.getClass();
                                                                                int i34 = Integer.parseInt(strGroup12);
                                                                                f11 = i33 / zzalqVar.zza;
                                                                                f12 = i34 / zzalqVar.zzb;
                                                                                f13 = f11;
                                                                                strZza3 = zzfz.zza(xmlPullParserNewPullParser, TtmlNode.ATTR_TTS_EXTENT);
                                                                                if (strZza3 != null) {
                                                                                    matcher3 = pattern.matcher(strZza3);
                                                                                    matcher4 = pattern2.matcher(strZza3);
                                                                                    if (matcher3.matches()) {
                                                                                        String strGroup13 = matcher3.group(1);
                                                                                        strGroup13.getClass();
                                                                                        float f111 = Float.parseFloat(strGroup13) / 100.0f;
                                                                                        String strGroup14 = matcher3.group(2);
                                                                                        strGroup14.getClass();
                                                                                        f14 = Float.parseFloat(strGroup14) / 100.0f;
                                                                                        f15 = f111;
                                                                                        strZza4 = zzfz.zza(xmlPullParserNewPullParser, TtmlNode.ATTR_TTS_DISPLAY_ALIGN);
                                                                                        if (strZza4 != null) {
                                                                                            strZza7 = zzfwk.zza(strZza4);
                                                                                            iHashCode2 = strZza7.hashCode();
                                                                                            if (iHashCode2 != -1364013995) {
                                                                                                if (iHashCode2 != 92734940) {
                                                                                                    b13 = -1;
                                                                                                } else {
                                                                                                    b13 = 1;
                                                                                                }
                                                                                            } else if (strZza7.equals(TtmlNode.CENTER)) {
                                                                                                b13 = 0;
                                                                                            } else {
                                                                                                b13 = -1;
                                                                                            }
                                                                                            if (b13 != 0) {
                                                                                                f16 = f12 + (f14 / 2.0f);
                                                                                                i15 = 1;
                                                                                            } else if (b13 != 1) {
                                                                                                f16 = f12;
                                                                                                i15 = 0;
                                                                                            } else {
                                                                                                f16 = f12 + f14;
                                                                                                i15 = 2;
                                                                                            }
                                                                                        } else {
                                                                                            f16 = f12;
                                                                                            i15 = 0;
                                                                                        }
                                                                                        float f112 = 1.0f / i21;
                                                                                        strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                        if (strZza5 != null) {
                                                                                            strZza6 = zzfwk.zza(strZza5);
                                                                                            iHashCode = strZza6.hashCode();
                                                                                            if (iHashCode != 3694) {
                                                                                                if (iHashCode != 3553396) {
                                                                                                    if (iHashCode != 3553576) {
                                                                                                        b12 = -1;
                                                                                                    } else {
                                                                                                        b12 = 2;
                                                                                                    }
                                                                                                } else if (strZza6.equals("tblr")) {
                                                                                                    b12 = 1;
                                                                                                } else {
                                                                                                    b12 = -1;
                                                                                                }
                                                                                            } else if (strZza6.equals("tb")) {
                                                                                                b12 = 0;
                                                                                            } else {
                                                                                                b12 = -1;
                                                                                            }
                                                                                            if (b12 != 0) {
                                                                                                i16 = 2;
                                                                                            } else {
                                                                                                i16 = 2;
                                                                                            }
                                                                                        } else {
                                                                                            i16 = Integer.MIN_VALUE;
                                                                                        }
                                                                                        zzalsVar = new zzals(strZza, f13, f16, 0, i15, f15, f14, 1, f112, i16);
                                                                                    } else if (matcher4.matches()) {
                                                                                        zzff.zzf("TtmlParser", "Ignoring region with unsupported extent: ".concat(strZza2));
                                                                                    } else if (zzalqVar == null) {
                                                                                        zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                                                    } else {
                                                                                        String strGroup15 = matcher4.group(1);
                                                                                        strGroup15.getClass();
                                                                                        int i35 = Integer.parseInt(strGroup15);
                                                                                        String strGroup16 = matcher4.group(2);
                                                                                        strGroup16.getClass();
                                                                                        int i36 = Integer.parseInt(strGroup16);
                                                                                        float f22 = i35 / zzalqVar.zza;
                                                                                        f14 = i36 / zzalqVar.zzb;
                                                                                        f15 = f22;
                                                                                        strZza4 = zzfz.zza(xmlPullParserNewPullParser, TtmlNode.ATTR_TTS_DISPLAY_ALIGN);
                                                                                        if (strZza4 != null) {
                                                                                            strZza7 = zzfwk.zza(strZza4);
                                                                                            iHashCode2 = strZza7.hashCode();
                                                                                            if (iHashCode2 != -1364013995) {
                                                                                                if (iHashCode2 != 92734940) {
                                                                                                    b13 = -1;
                                                                                                } else {
                                                                                                    b13 = 1;
                                                                                                }
                                                                                            } else if (strZza7.equals(TtmlNode.CENTER)) {
                                                                                                b13 = 0;
                                                                                            } else {
                                                                                                b13 = -1;
                                                                                            }
                                                                                            if (b13 != 0) {
                                                                                                f16 = f12 + (f14 / 2.0f);
                                                                                                i15 = 1;
                                                                                            } else if (b13 != 1) {
                                                                                                f16 = f12;
                                                                                                i15 = 0;
                                                                                            } else {
                                                                                                f16 = f12 + f14;
                                                                                                i15 = 2;
                                                                                            }
                                                                                        } else {
                                                                                            f16 = f12;
                                                                                            i15 = 0;
                                                                                        }
                                                                                        float f113 = 1.0f / i21;
                                                                                        strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                        if (strZza5 != null) {
                                                                                            strZza6 = zzfwk.zza(strZza5);
                                                                                            iHashCode = strZza6.hashCode();
                                                                                            if (iHashCode != 3694) {
                                                                                                if (iHashCode != 3553396) {
                                                                                                    if (iHashCode != 3553576) {
                                                                                                        b12 = -1;
                                                                                                    } else {
                                                                                                        b12 = 2;
                                                                                                    }
                                                                                                } else if (strZza6.equals("tblr")) {
                                                                                                    b12 = 1;
                                                                                                } else {
                                                                                                    b12 = -1;
                                                                                                }
                                                                                            } else if (strZza6.equals("tb")) {
                                                                                                b12 = 0;
                                                                                            } else {
                                                                                                b12 = -1;
                                                                                            }
                                                                                            if (b12 != 0) {
                                                                                                i16 = 2;
                                                                                            } else {
                                                                                                i16 = 2;
                                                                                            }
                                                                                        } else {
                                                                                            i16 = Integer.MIN_VALUE;
                                                                                        }
                                                                                        zzalsVar = new zzals(strZza, f13, f16, 0, i15, f15, f14, 1, f113, i16);
                                                                                    }
                                                                                    if (zzalsVar != null) {
                                                                                        map5 = map2;
                                                                                        map5.put(zzalsVar.zza, zzalsVar);
                                                                                    } else {
                                                                                        map5 = map2;
                                                                                    }
                                                                                } else {
                                                                                    zzff.zzf("TtmlParser", "Ignoring region without an extent");
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        map3 = map4;
                                                                        str5 = str3;
                                                                        zzff.zzf("TtmlParser", "Ignoring region without an origin");
                                                                    }
                                                                }
                                                                zzalsVar = null;
                                                                if (zzalsVar != null) {
                                                                    map5 = map2;
                                                                    map5.put(zzalsVar.zza, zzalsVar);
                                                                } else {
                                                                    map5 = map2;
                                                                }
                                                            } else if (zzfz.zzc(xmlPullParserNewPullParser, str3)) {
                                                                do {
                                                                    xmlPullParserNewPullParser.next();
                                                                    if (zzfz.zzc(xmlPullParserNewPullParser, "image")) {
                                                                        map6.put(strZza8, xmlPullParserNewPullParser.nextText());
                                                                    }
                                                                } while (!zzfz.zzb(xmlPullParserNewPullParser, str3));
                                                            }
                                                            if (zzfz.zzb(xmlPullParserNewPullParser, TtmlNode.TAG_HEAD)) {
                                                                zzalpVar2 = zzalpVar3;
                                                                arrayDeque = arrayDeque2;
                                                            } else {
                                                                map2 = map5;
                                                                zzalpVar3 = zzalpVar3;
                                                                str3 = str5;
                                                                map4 = map3;
                                                            }
                                                        }
                                                        map3 = map4;
                                                        str5 = str3;
                                                        map5 = map2;
                                                        if (zzfz.zzb(xmlPullParserNewPullParser, TtmlNode.TAG_HEAD)) {
                                                            zzalpVar2 = zzalpVar3;
                                                            arrayDeque = arrayDeque2;
                                                        } else {
                                                            map2 = map5;
                                                            zzalpVar3 = zzalpVar3;
                                                            str3 = str5;
                                                            map4 = map3;
                                                        }
                                                    }
                                                } else {
                                                    map3 = map4;
                                                    zzalpVar = zzalpVar3;
                                                    map5 = map2;
                                                    attributeCount = xmlPullParserNewPullParser.getAttributeCount();
                                                    zzalu zzaluVarZzf2 = zzf(xmlPullParserNewPullParser, null);
                                                    j11 = C.TIME_UNSET;
                                                    strArr = null;
                                                    strSubstring = null;
                                                    jZzc = -9223372036854775807L;
                                                    jZzc2 = -9223372036854775807L;
                                                    jZzc3 = -9223372036854775807L;
                                                    str4 = str;
                                                    i14 = 0;
                                                    while (i14 < attributeCount) {
                                                        attributeName = xmlPullParserNewPullParser.getAttributeName(i14);
                                                        attributeValue = xmlPullParserNewPullParser.getAttributeValue(i14);
                                                        switch (attributeName) {
                                                            case "region":
                                                                b11 = 4;
                                                                break;
                                                            case "dur":
                                                                b11 = 2;
                                                                break;
                                                            case "end":
                                                                b11 = 1;
                                                                break;
                                                            case "begin":
                                                                b11 = 0;
                                                                break;
                                                            case "style":
                                                                b11 = 3;
                                                                break;
                                                            case "backgroundImage":
                                                                b11 = 5;
                                                                break;
                                                            default:
                                                                b11 = -1;
                                                                break;
                                                        }
                                                        if (b11 == 0) {
                                                            zzalpVar2 = zzalpVar;
                                                            jZzc2 = zzc(attributeValue, zzalpVar2);
                                                        } else if (b11 == 1) {
                                                            zzalpVar2 = zzalpVar;
                                                            jZzc = zzc(attributeValue, zzalpVar2);
                                                        } else if (b11 != 2) {
                                                            if (b11 == 3) {
                                                                strArrZzg = zzg(attributeValue);
                                                                if (strArrZzg.length > 0) {
                                                                    strArr = strArrZzg;
                                                                }
                                                            } else if (b11 != 4) {
                                                                if (b11 == 5) {
                                                                    if (attributeValue.startsWith(Utils.SEPARATOR)) {
                                                                        strSubstring = attributeValue.substring(1);
                                                                    }
                                                                }
                                                            } else if (map5.containsKey(attributeValue)) {
                                                                str4 = attributeValue;
                                                            }
                                                            zzalpVar2 = zzalpVar;
                                                        } else {
                                                            zzalpVar2 = zzalpVar;
                                                            jZzc3 = zzc(attributeValue, zzalpVar2);
                                                        }
                                                        i14++;
                                                        zzalpVar = zzalpVar2;
                                                    }
                                                    zzalpVar2 = zzalpVar;
                                                    if (zzaloVar3 != null) {
                                                        zzaloVar = zzaloVar3;
                                                        j13 = zzaloVar.zzd;
                                                        if (j13 == C.TIME_UNSET) {
                                                            zzaloVar2 = zzaloVar;
                                                        } else {
                                                            if (jZzc2 != C.TIME_UNSET) {
                                                                jZzc2 += j13;
                                                            } else {
                                                                jZzc2 = -9223372036854775807L;
                                                            }
                                                            if (jZzc != C.TIME_UNSET) {
                                                                jZzc += j13;
                                                                zzaloVar2 = zzaloVar;
                                                            } else {
                                                                zzaloVar2 = zzaloVar;
                                                                jZzc = -9223372036854775807L;
                                                            }
                                                        }
                                                    } else {
                                                        zzaloVar = zzaloVar3;
                                                        zzaloVar2 = null;
                                                    }
                                                    if (jZzc != C.TIME_UNSET) {
                                                        j11 = jZzc;
                                                    } else if (jZzc3 != C.TIME_UNSET) {
                                                        j11 = jZzc2 + jZzc3;
                                                    } else if (zzaloVar2 != null) {
                                                        j12 = zzaloVar2.zze;
                                                        if (j12 != C.TIME_UNSET) {
                                                            j11 = j12;
                                                        }
                                                    }
                                                    zzaloVarZzb = zzalo.zzb(xmlPullParserNewPullParser.getName(), jZzc2, j11, zzaluVarZzf2, strArr, str4, strSubstring, zzaloVar2);
                                                    arrayDeque = arrayDeque2;
                                                    arrayDeque.push(zzaloVarZzb);
                                                    if (zzaloVar != null) {
                                                        zzaloVar.zzf(zzaloVarZzb);
                                                    }
                                                }
                                                i21 = i21;
                                                zzalqVar = zzalqVar;
                                                zzalpVar3 = zzalpVar2;
                                                zzalvVar2 = zzalvVar2;
                                                i19 = i19;
                                                map = map3;
                                            } else {
                                                if (TtmlNode.TAG_HEAD.equals(name)) {
                                                    while (true) {
                                                        xmlPullParserNewPullParser.next();
                                                        if (zzfz.zzc(xmlPullParserNewPullParser, TtmlNode.TAG_STYLE)) {
                                                            strZza9 = zzfz.zza(xmlPullParserNewPullParser, TtmlNode.TAG_STYLE);
                                                            zzaluVarZzf = zzf(xmlPullParserNewPullParser, new zzalu());
                                                            if (strZza9 != null) {
                                                                strArrZzg2 = zzg(strZza9);
                                                                i17 = 0;
                                                                while (i17 < length) {
                                                                    zzaluVarZzf.zzl((zzalu) map4.get(strArrZzg2[i17]));
                                                                    i17++;
                                                                }
                                                            }
                                                            strZzE = zzaluVarZzf.zzE();
                                                            if (strZzE != null) {
                                                                map4.put(strZzE, zzaluVarZzf);
                                                            }
                                                        } else {
                                                            zzalpVar3 = zzalpVar3;
                                                            if (zzfz.zzc(xmlPullParserNewPullParser, TtmlNode.TAG_REGION)) {
                                                                strZza = zzfz.zza(xmlPullParserNewPullParser, "id");
                                                                if (strZza == null) {
                                                                    map3 = map4;
                                                                    str5 = str3;
                                                                } else {
                                                                    strZza2 = zzfz.zza(xmlPullParserNewPullParser, "origin");
                                                                    if (strZza2 != null) {
                                                                        pattern = zzb;
                                                                        matcher = pattern.matcher(strZza2);
                                                                        pattern2 = zzf;
                                                                        str5 = str3;
                                                                        matcher2 = pattern2.matcher(strZza2);
                                                                        if (matcher.matches()) {
                                                                            map3 = map4;
                                                                            try {
                                                                                String strGroup17 = matcher.group(1);
                                                                                strGroup17.getClass();
                                                                                f11 = Float.parseFloat(strGroup17) / 100.0f;
                                                                                String strGroup18 = matcher.group(2);
                                                                                strGroup18.getClass();
                                                                                f12 = Float.parseFloat(strGroup18) / 100.0f;
                                                                                f13 = f11;
                                                                                strZza3 = zzfz.zza(xmlPullParserNewPullParser, TtmlNode.ATTR_TTS_EXTENT);
                                                                                if (strZza3 != null) {
                                                                                    matcher3 = pattern.matcher(strZza3);
                                                                                    matcher4 = pattern2.matcher(strZza3);
                                                                                    if (matcher3.matches()) {
                                                                                        try {
                                                                                            String strGroup19 = matcher3.group(1);
                                                                                            strGroup19.getClass();
                                                                                            float f114 = Float.parseFloat(strGroup19) / 100.0f;
                                                                                            String strGroup110 = matcher3.group(2);
                                                                                            strGroup110.getClass();
                                                                                            f14 = Float.parseFloat(strGroup110) / 100.0f;
                                                                                            f15 = f114;
                                                                                            strZza4 = zzfz.zza(xmlPullParserNewPullParser, TtmlNode.ATTR_TTS_DISPLAY_ALIGN);
                                                                                            if (strZza4 != null) {
                                                                                                strZza7 = zzfwk.zza(strZza4);
                                                                                                iHashCode2 = strZza7.hashCode();
                                                                                                if (iHashCode2 != -1364013995) {
                                                                                                    if (iHashCode2 != 92734940) {
                                                                                                        b13 = -1;
                                                                                                    } else {
                                                                                                        b13 = 1;
                                                                                                    }
                                                                                                } else if (strZza7.equals(TtmlNode.CENTER)) {
                                                                                                    b13 = 0;
                                                                                                } else {
                                                                                                    b13 = -1;
                                                                                                }
                                                                                                if (b13 != 0) {
                                                                                                    f16 = f12 + (f14 / 2.0f);
                                                                                                    i15 = 1;
                                                                                                } else if (b13 != 1) {
                                                                                                    f16 = f12;
                                                                                                    i15 = 0;
                                                                                                } else {
                                                                                                    f16 = f12 + f14;
                                                                                                    i15 = 2;
                                                                                                }
                                                                                            } else {
                                                                                                f16 = f12;
                                                                                                i15 = 0;
                                                                                            }
                                                                                            float f115 = 1.0f / i21;
                                                                                            strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                            if (strZza5 != null) {
                                                                                                strZza6 = zzfwk.zza(strZza5);
                                                                                                iHashCode = strZza6.hashCode();
                                                                                                if (iHashCode != 3694) {
                                                                                                    if (iHashCode != 3553396) {
                                                                                                        if (iHashCode != 3553576) {
                                                                                                            b12 = -1;
                                                                                                        } else {
                                                                                                            b12 = 2;
                                                                                                        }
                                                                                                    } else if (strZza6.equals("tblr")) {
                                                                                                        b12 = 1;
                                                                                                    } else {
                                                                                                        b12 = -1;
                                                                                                    }
                                                                                                } else if (strZza6.equals("tb")) {
                                                                                                    b12 = 0;
                                                                                                } else {
                                                                                                    b12 = -1;
                                                                                                }
                                                                                                if (b12 != 0) {
                                                                                                    i16 = 2;
                                                                                                } else {
                                                                                                    i16 = 2;
                                                                                                }
                                                                                            } else {
                                                                                                i16 = Integer.MIN_VALUE;
                                                                                            }
                                                                                            zzalsVar = new zzals(strZza, f13, f16, 0, i15, f15, f14, 1, f115, i16);
                                                                                        } catch (NumberFormatException unused5) {
                                                                                            zzff.zzf("TtmlParser", "Ignoring region with malformed extent: ".concat(strZza2));
                                                                                            zzalsVar = null;
                                                                                        }
                                                                                    } else if (matcher4.matches()) {
                                                                                        zzff.zzf("TtmlParser", "Ignoring region with unsupported extent: ".concat(strZza2));
                                                                                    } else if (zzalqVar == null) {
                                                                                        zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                                                    } else {
                                                                                        try {
                                                                                            String strGroup111 = matcher4.group(1);
                                                                                            strGroup111.getClass();
                                                                                            int i37 = Integer.parseInt(strGroup111);
                                                                                            String strGroup112 = matcher4.group(2);
                                                                                            strGroup112.getClass();
                                                                                            int i38 = Integer.parseInt(strGroup112);
                                                                                            float f23 = i37 / zzalqVar.zza;
                                                                                            f14 = i38 / zzalqVar.zzb;
                                                                                            f15 = f23;
                                                                                            strZza4 = zzfz.zza(xmlPullParserNewPullParser, TtmlNode.ATTR_TTS_DISPLAY_ALIGN);
                                                                                            if (strZza4 != null) {
                                                                                                strZza7 = zzfwk.zza(strZza4);
                                                                                                iHashCode2 = strZza7.hashCode();
                                                                                                if (iHashCode2 != -1364013995) {
                                                                                                    if (iHashCode2 != 92734940) {
                                                                                                        b13 = -1;
                                                                                                    } else {
                                                                                                        b13 = 1;
                                                                                                    }
                                                                                                } else if (strZza7.equals(TtmlNode.CENTER)) {
                                                                                                    b13 = 0;
                                                                                                } else {
                                                                                                    b13 = -1;
                                                                                                }
                                                                                                if (b13 != 0) {
                                                                                                    f16 = f12 + (f14 / 2.0f);
                                                                                                    i15 = 1;
                                                                                                } else if (b13 != 1) {
                                                                                                    f16 = f12;
                                                                                                    i15 = 0;
                                                                                                } else {
                                                                                                    f16 = f12 + f14;
                                                                                                    i15 = 2;
                                                                                                }
                                                                                            } else {
                                                                                                f16 = f12;
                                                                                                i15 = 0;
                                                                                            }
                                                                                            float f116 = 1.0f / i21;
                                                                                            strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                            if (strZza5 != null) {
                                                                                                strZza6 = zzfwk.zza(strZza5);
                                                                                                iHashCode = strZza6.hashCode();
                                                                                                if (iHashCode != 3694) {
                                                                                                    if (iHashCode != 3553396) {
                                                                                                        if (iHashCode != 3553576) {
                                                                                                            b12 = -1;
                                                                                                        } else {
                                                                                                            b12 = 2;
                                                                                                        }
                                                                                                    } else if (strZza6.equals("tblr")) {
                                                                                                        b12 = 1;
                                                                                                    } else {
                                                                                                        b12 = -1;
                                                                                                    }
                                                                                                } else if (strZza6.equals("tb")) {
                                                                                                    b12 = 0;
                                                                                                } else {
                                                                                                    b12 = -1;
                                                                                                }
                                                                                                if (b12 != 0) {
                                                                                                    i16 = 2;
                                                                                                } else {
                                                                                                    i16 = 2;
                                                                                                }
                                                                                            } else {
                                                                                                i16 = Integer.MIN_VALUE;
                                                                                            }
                                                                                            zzalsVar = new zzals(strZza, f13, f16, 0, i15, f15, f14, 1, f116, i16);
                                                                                        } catch (NumberFormatException unused6) {
                                                                                            zzff.zzf("TtmlParser", "Ignoring region with malformed extent: ".concat(strZza2));
                                                                                            zzalsVar = null;
                                                                                        }
                                                                                    }
                                                                                    if (zzalsVar != null) {
                                                                                        map5 = map2;
                                                                                        map5.put(zzalsVar.zza, zzalsVar);
                                                                                    } else {
                                                                                        map5 = map2;
                                                                                    }
                                                                                } else {
                                                                                    zzff.zzf("TtmlParser", "Ignoring region without an extent");
                                                                                }
                                                                            } catch (NumberFormatException unused7) {
                                                                                zzff.zzf("TtmlParser", "Ignoring region with malformed origin: ".concat(strZza2));
                                                                            }
                                                                        } else {
                                                                            map3 = map4;
                                                                            if (!matcher2.matches()) {
                                                                                zzff.zzf("TtmlParser", "Ignoring region with unsupported origin: ".concat(strZza2));
                                                                            } else if (zzalqVar == null) {
                                                                                zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                                            } else {
                                                                                try {
                                                                                    String strGroup113 = matcher2.group(1);
                                                                                    strGroup113.getClass();
                                                                                    int i39 = Integer.parseInt(strGroup113);
                                                                                    String strGroup114 = matcher2.group(2);
                                                                                    strGroup114.getClass();
                                                                                    int i310 = Integer.parseInt(strGroup114);
                                                                                    f11 = i39 / zzalqVar.zza;
                                                                                    f12 = i310 / zzalqVar.zzb;
                                                                                    f13 = f11;
                                                                                    strZza3 = zzfz.zza(xmlPullParserNewPullParser, TtmlNode.ATTR_TTS_EXTENT);
                                                                                    if (strZza3 != null) {
                                                                                        matcher3 = pattern.matcher(strZza3);
                                                                                        matcher4 = pattern2.matcher(strZza3);
                                                                                        if (matcher3.matches()) {
                                                                                            String strGroup115 = matcher3.group(1);
                                                                                            strGroup115.getClass();
                                                                                            float f117 = Float.parseFloat(strGroup115) / 100.0f;
                                                                                            String strGroup116 = matcher3.group(2);
                                                                                            strGroup116.getClass();
                                                                                            f14 = Float.parseFloat(strGroup116) / 100.0f;
                                                                                            f15 = f117;
                                                                                            strZza4 = zzfz.zza(xmlPullParserNewPullParser, TtmlNode.ATTR_TTS_DISPLAY_ALIGN);
                                                                                            if (strZza4 != null) {
                                                                                                strZza7 = zzfwk.zza(strZza4);
                                                                                                iHashCode2 = strZza7.hashCode();
                                                                                                if (iHashCode2 != -1364013995) {
                                                                                                    if (iHashCode2 != 92734940) {
                                                                                                        b13 = -1;
                                                                                                    } else {
                                                                                                        b13 = 1;
                                                                                                    }
                                                                                                } else if (strZza7.equals(TtmlNode.CENTER)) {
                                                                                                    b13 = 0;
                                                                                                } else {
                                                                                                    b13 = -1;
                                                                                                }
                                                                                                if (b13 != 0) {
                                                                                                    f16 = f12 + (f14 / 2.0f);
                                                                                                    i15 = 1;
                                                                                                } else if (b13 != 1) {
                                                                                                    f16 = f12;
                                                                                                    i15 = 0;
                                                                                                } else {
                                                                                                    f16 = f12 + f14;
                                                                                                    i15 = 2;
                                                                                                }
                                                                                            } else {
                                                                                                f16 = f12;
                                                                                                i15 = 0;
                                                                                            }
                                                                                            float f118 = 1.0f / i21;
                                                                                            strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                            if (strZza5 != null) {
                                                                                                strZza6 = zzfwk.zza(strZza5);
                                                                                                iHashCode = strZza6.hashCode();
                                                                                                if (iHashCode != 3694) {
                                                                                                    if (iHashCode != 3553396) {
                                                                                                        if (iHashCode != 3553576) {
                                                                                                            b12 = -1;
                                                                                                        } else {
                                                                                                            b12 = 2;
                                                                                                        }
                                                                                                    } else if (strZza6.equals("tblr")) {
                                                                                                        b12 = 1;
                                                                                                    } else {
                                                                                                        b12 = -1;
                                                                                                    }
                                                                                                } else if (strZza6.equals("tb")) {
                                                                                                    b12 = 0;
                                                                                                } else {
                                                                                                    b12 = -1;
                                                                                                }
                                                                                                if (b12 != 0) {
                                                                                                    i16 = 2;
                                                                                                } else {
                                                                                                    i16 = 2;
                                                                                                }
                                                                                            } else {
                                                                                                i16 = Integer.MIN_VALUE;
                                                                                            }
                                                                                            zzalsVar = new zzals(strZza, f13, f16, 0, i15, f15, f14, 1, f118, i16);
                                                                                        } else if (matcher4.matches()) {
                                                                                            zzff.zzf("TtmlParser", "Ignoring region with unsupported extent: ".concat(strZza2));
                                                                                        } else if (zzalqVar == null) {
                                                                                            zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                                                        } else {
                                                                                            String strGroup117 = matcher4.group(1);
                                                                                            strGroup117.getClass();
                                                                                            int i311 = Integer.parseInt(strGroup117);
                                                                                            String strGroup118 = matcher4.group(2);
                                                                                            strGroup118.getClass();
                                                                                            int i312 = Integer.parseInt(strGroup118);
                                                                                            float f24 = i311 / zzalqVar.zza;
                                                                                            f14 = i312 / zzalqVar.zzb;
                                                                                            f15 = f24;
                                                                                            strZza4 = zzfz.zza(xmlPullParserNewPullParser, TtmlNode.ATTR_TTS_DISPLAY_ALIGN);
                                                                                            if (strZza4 != null) {
                                                                                                strZza7 = zzfwk.zza(strZza4);
                                                                                                iHashCode2 = strZza7.hashCode();
                                                                                                if (iHashCode2 != -1364013995) {
                                                                                                    if (iHashCode2 != 92734940) {
                                                                                                        b13 = -1;
                                                                                                    } else {
                                                                                                        b13 = 1;
                                                                                                    }
                                                                                                } else if (strZza7.equals(TtmlNode.CENTER)) {
                                                                                                    b13 = 0;
                                                                                                } else {
                                                                                                    b13 = -1;
                                                                                                }
                                                                                                if (b13 != 0) {
                                                                                                    f16 = f12 + (f14 / 2.0f);
                                                                                                    i15 = 1;
                                                                                                } else if (b13 != 1) {
                                                                                                    f16 = f12;
                                                                                                    i15 = 0;
                                                                                                } else {
                                                                                                    f16 = f12 + f14;
                                                                                                    i15 = 2;
                                                                                                }
                                                                                            } else {
                                                                                                f16 = f12;
                                                                                                i15 = 0;
                                                                                            }
                                                                                            float f119 = 1.0f / i21;
                                                                                            strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                            if (strZza5 != null) {
                                                                                                strZza6 = zzfwk.zza(strZza5);
                                                                                                iHashCode = strZza6.hashCode();
                                                                                                if (iHashCode != 3694) {
                                                                                                    if (iHashCode != 3553396) {
                                                                                                        if (iHashCode != 3553576) {
                                                                                                            b12 = -1;
                                                                                                        } else {
                                                                                                            b12 = 2;
                                                                                                        }
                                                                                                    } else if (strZza6.equals("tblr")) {
                                                                                                        b12 = 1;
                                                                                                    } else {
                                                                                                        b12 = -1;
                                                                                                    }
                                                                                                } else if (strZza6.equals("tb")) {
                                                                                                    b12 = 0;
                                                                                                } else {
                                                                                                    b12 = -1;
                                                                                                }
                                                                                                if (b12 != 0) {
                                                                                                    i16 = 2;
                                                                                                } else {
                                                                                                    i16 = 2;
                                                                                                }
                                                                                            } else {
                                                                                                i16 = Integer.MIN_VALUE;
                                                                                            }
                                                                                            zzalsVar = new zzals(strZza, f13, f16, 0, i15, f15, f14, 1, f119, i16);
                                                                                        }
                                                                                        if (zzalsVar != null) {
                                                                                            map5 = map2;
                                                                                            map5.put(zzalsVar.zza, zzalsVar);
                                                                                        } else {
                                                                                            map5 = map2;
                                                                                        }
                                                                                    } else {
                                                                                        zzff.zzf("TtmlParser", "Ignoring region without an extent");
                                                                                    }
                                                                                } catch (NumberFormatException unused8) {
                                                                                    zzff.zzf("TtmlParser", "Ignoring region with malformed origin: ".concat(strZza2));
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        map3 = map4;
                                                                        str5 = str3;
                                                                        zzff.zzf("TtmlParser", "Ignoring region without an origin");
                                                                    }
                                                                }
                                                                zzalsVar = null;
                                                                if (zzalsVar != null) {
                                                                    map5 = map2;
                                                                    map5.put(zzalsVar.zza, zzalsVar);
                                                                } else {
                                                                    map5 = map2;
                                                                }
                                                            } else if (zzfz.zzc(xmlPullParserNewPullParser, str3)) {
                                                                do {
                                                                    xmlPullParserNewPullParser.next();
                                                                    if (zzfz.zzc(xmlPullParserNewPullParser, "image")) {
                                                                        map6.put(strZza8, xmlPullParserNewPullParser.nextText());
                                                                    }
                                                                } while (!zzfz.zzb(xmlPullParserNewPullParser, str3));
                                                            }
                                                            if (zzfz.zzb(xmlPullParserNewPullParser, TtmlNode.TAG_HEAD)) {
                                                                zzalpVar2 = zzalpVar3;
                                                                arrayDeque = arrayDeque2;
                                                            } else {
                                                                map2 = map5;
                                                                zzalpVar3 = zzalpVar3;
                                                                str3 = str5;
                                                                map4 = map3;
                                                            }
                                                        }
                                                        map3 = map4;
                                                        str5 = str3;
                                                        map5 = map2;
                                                        if (zzfz.zzb(xmlPullParserNewPullParser, TtmlNode.TAG_HEAD)) {
                                                            zzalpVar2 = zzalpVar3;
                                                            arrayDeque = arrayDeque2;
                                                        } else {
                                                            map2 = map5;
                                                            zzalpVar3 = zzalpVar3;
                                                            str3 = str5;
                                                            map4 = map3;
                                                        }
                                                    }
                                                } else {
                                                    map3 = map4;
                                                    zzalpVar = zzalpVar3;
                                                    map5 = map2;
                                                    try {
                                                        attributeCount = xmlPullParserNewPullParser.getAttributeCount();
                                                        zzalu zzaluVarZzf3 = zzf(xmlPullParserNewPullParser, null);
                                                        j11 = C.TIME_UNSET;
                                                        strArr = null;
                                                        strSubstring = null;
                                                        jZzc = -9223372036854775807L;
                                                        jZzc2 = -9223372036854775807L;
                                                        jZzc3 = -9223372036854775807L;
                                                        str4 = str;
                                                        i14 = 0;
                                                        while (i14 < attributeCount) {
                                                            try {
                                                                attributeName = xmlPullParserNewPullParser.getAttributeName(i14);
                                                                attributeValue = xmlPullParserNewPullParser.getAttributeValue(i14);
                                                                switch (attributeName) {
                                                                    case -934795532:
                                                                        if (!attributeName.equals(TtmlNode.TAG_REGION)) {
                                                                            b11 = 4;
                                                                        } else {
                                                                            b11 = -1;
                                                                        }
                                                                        break;
                                                                    case 99841:
                                                                        if (!attributeName.equals("dur")) {
                                                                            b11 = 2;
                                                                        } else {
                                                                            b11 = -1;
                                                                        }
                                                                        break;
                                                                    case 100571:
                                                                        if (!attributeName.equals(TtmlNode.END)) {
                                                                            b11 = 1;
                                                                        } else {
                                                                            b11 = -1;
                                                                        }
                                                                        break;
                                                                    case 93616297:
                                                                        if (!attributeName.equals("begin")) {
                                                                            b11 = 0;
                                                                        } else {
                                                                            b11 = -1;
                                                                        }
                                                                        break;
                                                                    case 109780401:
                                                                        if (!attributeName.equals(TtmlNode.TAG_STYLE)) {
                                                                            b11 = 3;
                                                                        } else {
                                                                            b11 = -1;
                                                                        }
                                                                        break;
                                                                    case 1292595405:
                                                                        if (!attributeName.equals("backgroundImage")) {
                                                                            b11 = 5;
                                                                        } else {
                                                                            b11 = -1;
                                                                        }
                                                                        break;
                                                                    default:
                                                                        b11 = -1;
                                                                        break;
                                                                }
                                                                if (b11 == 0) {
                                                                    zzalpVar2 = zzalpVar;
                                                                    jZzc2 = zzc(attributeValue, zzalpVar2);
                                                                } else if (b11 == 1) {
                                                                    zzalpVar2 = zzalpVar;
                                                                    jZzc = zzc(attributeValue, zzalpVar2);
                                                                } else if (b11 != 2) {
                                                                    if (b11 == 3) {
                                                                        strArrZzg = zzg(attributeValue);
                                                                        if (strArrZzg.length > 0) {
                                                                            strArr = strArrZzg;
                                                                        }
                                                                    } else if (b11 != 4) {
                                                                        if (b11 == 5) {
                                                                            try {
                                                                                if (attributeValue.startsWith(Utils.SEPARATOR)) {
                                                                                    try {
                                                                                        strSubstring = attributeValue.substring(1);
                                                                                    } catch (zzakn e11) {
                                                                                        e = e11;
                                                                                        zzaknVar = e;
                                                                                        zzalpVar2 = zzalpVar;
                                                                                        arrayDeque = arrayDeque2;
                                                                                        zzff.zzg("TtmlParser", "Suppressing parser error", zzaknVar);
                                                                                        zzalpVar3 = zzalpVar2;
                                                                                        map = map3;
                                                                                        i19 = 1;
                                                                                        xmlPullParserNewPullParser.next();
                                                                                        eventType = xmlPullParserNewPullParser.getEventType();
                                                                                        map4 = map;
                                                                                        arrayDeque2 = arrayDeque;
                                                                                        str6 = str;
                                                                                        str7 = str2;
                                                                                    }
                                                                                }
                                                                            } catch (zzakn e12) {
                                                                                e = e12;
                                                                            }
                                                                        }
                                                                    } else if (map5.containsKey(attributeValue)) {
                                                                        str4 = attributeValue;
                                                                    }
                                                                    zzalpVar2 = zzalpVar;
                                                                } else {
                                                                    zzalpVar2 = zzalpVar;
                                                                    jZzc3 = zzc(attributeValue, zzalpVar2);
                                                                }
                                                                try {
                                                                    i14++;
                                                                    zzalpVar = zzalpVar2;
                                                                } catch (zzakn e13) {
                                                                    e = e13;
                                                                    zzaknVar = e;
                                                                    arrayDeque = arrayDeque2;
                                                                    zzff.zzg("TtmlParser", "Suppressing parser error", zzaknVar);
                                                                    zzalpVar3 = zzalpVar2;
                                                                    map = map3;
                                                                    i19 = 1;
                                                                    xmlPullParserNewPullParser.next();
                                                                    eventType = xmlPullParserNewPullParser.getEventType();
                                                                    map4 = map;
                                                                    arrayDeque2 = arrayDeque;
                                                                    str6 = str;
                                                                    str7 = str2;
                                                                }
                                                            } catch (zzakn e14) {
                                                                e = e14;
                                                                zzalpVar2 = zzalpVar;
                                                            }
                                                        }
                                                        zzalpVar2 = zzalpVar;
                                                        if (zzaloVar3 != null) {
                                                            zzaloVar = zzaloVar3;
                                                            j13 = zzaloVar.zzd;
                                                            if (j13 == C.TIME_UNSET) {
                                                                zzaloVar2 = zzaloVar;
                                                            } else {
                                                                if (jZzc2 != C.TIME_UNSET) {
                                                                    jZzc2 += j13;
                                                                } else {
                                                                    jZzc2 = -9223372036854775807L;
                                                                }
                                                                if (jZzc != C.TIME_UNSET) {
                                                                    jZzc += j13;
                                                                    zzaloVar2 = zzaloVar;
                                                                } else {
                                                                    zzaloVar2 = zzaloVar;
                                                                    jZzc = -9223372036854775807L;
                                                                }
                                                            }
                                                        } else {
                                                            zzaloVar = zzaloVar3;
                                                            zzaloVar2 = null;
                                                        }
                                                        if (jZzc != C.TIME_UNSET) {
                                                            j11 = jZzc;
                                                        } else if (jZzc3 != C.TIME_UNSET) {
                                                            j11 = jZzc2 + jZzc3;
                                                        } else if (zzaloVar2 != null) {
                                                            j12 = zzaloVar2.zze;
                                                            if (j12 != C.TIME_UNSET) {
                                                                j11 = j12;
                                                            }
                                                        }
                                                        try {
                                                            zzaloVarZzb = zzalo.zzb(xmlPullParserNewPullParser.getName(), jZzc2, j11, zzaluVarZzf3, strArr, str4, strSubstring, zzaloVar2);
                                                            arrayDeque = arrayDeque2;
                                                            try {
                                                                arrayDeque.push(zzaloVarZzb);
                                                                if (zzaloVar != null) {
                                                                    zzaloVar.zzf(zzaloVarZzb);
                                                                }
                                                            } catch (zzakn e15) {
                                                                e = e15;
                                                                zzaknVar = e;
                                                                zzff.zzg("TtmlParser", "Suppressing parser error", zzaknVar);
                                                                zzalpVar3 = zzalpVar2;
                                                                map = map3;
                                                                i19 = 1;
                                                            }
                                                        } catch (zzakn e16) {
                                                            e = e16;
                                                            arrayDeque = arrayDeque2;
                                                        }
                                                    } catch (zzakn e17) {
                                                        e = e17;
                                                        zzalpVar2 = zzalpVar;
                                                        arrayDeque = arrayDeque2;
                                                    }
                                                }
                                                i21 = i21;
                                                zzalqVar = zzalqVar;
                                                zzalpVar3 = zzalpVar2;
                                                zzalvVar2 = zzalvVar2;
                                                i19 = i19;
                                                map = map3;
                                            }
                                            xmlPullParserNewPullParser.next();
                                            eventType = xmlPullParserNewPullParser.getEventType();
                                            map4 = map;
                                            arrayDeque2 = arrayDeque;
                                            str6 = str;
                                            str7 = str2;
                                        }
                                    } catch (NumberFormatException unused9) {
                                        str2 = str7;
                                    }
                                } else {
                                    zzff.zzf("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue6));
                                    str2 = str7;
                                    map2 = map5;
                                    zzalpVar5 = zzalpVar5;
                                    i21 = 15;
                                }
                            }
                            strZza10 = zzfz.zza(xmlPullParserNewPullParser, TtmlNode.ATTR_TTS_EXTENT);
                            if (strZza10 == null) {
                                zzalqVar = null;
                            } else {
                                matcher5 = zzf.matcher(strZza10);
                                if (matcher5.matches()) {
                                    zzff.zzf("TtmlParser", "Ignoring non-pixel tts extent: ".concat(strZza10));
                                } else {
                                    String strGroup20 = matcher5.group(1);
                                    strGroup20.getClass();
                                    int i210 = Integer.parseInt(strGroup20);
                                    String strGroup21 = matcher5.group(2);
                                    strGroup21.getClass();
                                    zzalqVar = new zzalq(i210, Integer.parseInt(strGroup21));
                                }
                                zzalqVar = null;
                            }
                            zzalpVar3 = zzalpVar5;
                        } else {
                            str2 = str7;
                            map2 = map5;
                            arrayDeque2 = arrayDeque2;
                            zzaloVar3 = zzaloVar3;
                            i19 = i19;
                            zzalqVar = zzalqVar;
                        }
                        i21 = i21;
                        zEquals = name.equals(TtmlNode.TAG_TT);
                        str3 = TtmlNode.TAG_METADATA;
                        if (zEquals || name.equals(TtmlNode.TAG_HEAD) || name.equals(TtmlNode.TAG_BODY) || name.equals(TtmlNode.TAG_DIV) || name.equals(TtmlNode.TAG_P) || name.equals(TtmlNode.TAG_SPAN) || name.equals(TtmlNode.TAG_BR) || name.equals(TtmlNode.TAG_STYLE) || name.equals(TtmlNode.TAG_STYLING) || name.equals(TtmlNode.TAG_LAYOUT) || name.equals(TtmlNode.TAG_REGION) || name.equals(TtmlNode.TAG_METADATA) || name.equals("image") || name.equals("data") || name.equals("information")) {
                            if (TtmlNode.TAG_HEAD.equals(name)) {
                                while (true) {
                                    xmlPullParserNewPullParser.next();
                                    if (zzfz.zzc(xmlPullParserNewPullParser, TtmlNode.TAG_STYLE)) {
                                        strZza9 = zzfz.zza(xmlPullParserNewPullParser, TtmlNode.TAG_STYLE);
                                        zzaluVarZzf = zzf(xmlPullParserNewPullParser, new zzalu());
                                        if (strZza9 != null) {
                                            strArrZzg2 = zzg(strZza9);
                                            i17 = 0;
                                            while (i17 < length) {
                                                zzaluVarZzf.zzl((zzalu) map4.get(strArrZzg2[i17]));
                                                i17++;
                                            }
                                        }
                                        strZzE = zzaluVarZzf.zzE();
                                        if (strZzE != null) {
                                            map4.put(strZzE, zzaluVarZzf);
                                        }
                                    } else {
                                        zzalpVar3 = zzalpVar3;
                                        if (zzfz.zzc(xmlPullParserNewPullParser, TtmlNode.TAG_REGION)) {
                                            strZza = zzfz.zza(xmlPullParserNewPullParser, "id");
                                            if (strZza == null) {
                                                map3 = map4;
                                                str5 = str3;
                                            } else {
                                                strZza2 = zzfz.zza(xmlPullParserNewPullParser, "origin");
                                                if (strZza2 != null) {
                                                    pattern = zzb;
                                                    matcher = pattern.matcher(strZza2);
                                                    pattern2 = zzf;
                                                    str5 = str3;
                                                    matcher2 = pattern2.matcher(strZza2);
                                                    if (matcher.matches()) {
                                                        map3 = map4;
                                                        String strGroup119 = matcher.group(1);
                                                        strGroup119.getClass();
                                                        f11 = Float.parseFloat(strGroup119) / 100.0f;
                                                        String strGroup120 = matcher.group(2);
                                                        strGroup120.getClass();
                                                        f12 = Float.parseFloat(strGroup120) / 100.0f;
                                                        f13 = f11;
                                                        strZza3 = zzfz.zza(xmlPullParserNewPullParser, TtmlNode.ATTR_TTS_EXTENT);
                                                        if (strZza3 != null) {
                                                            matcher3 = pattern.matcher(strZza3);
                                                            matcher4 = pattern2.matcher(strZza3);
                                                            if (matcher3.matches()) {
                                                                String strGroup1110 = matcher3.group(1);
                                                                strGroup1110.getClass();
                                                                float f1110 = Float.parseFloat(strGroup1110) / 100.0f;
                                                                String strGroup1111 = matcher3.group(2);
                                                                strGroup1111.getClass();
                                                                f14 = Float.parseFloat(strGroup1111) / 100.0f;
                                                                f15 = f1110;
                                                                strZza4 = zzfz.zza(xmlPullParserNewPullParser, TtmlNode.ATTR_TTS_DISPLAY_ALIGN);
                                                                if (strZza4 != null) {
                                                                    strZza7 = zzfwk.zza(strZza4);
                                                                    iHashCode2 = strZza7.hashCode();
                                                                    if (iHashCode2 != -1364013995) {
                                                                        if (iHashCode2 != 92734940 && strZza7.equals("after")) {
                                                                            b13 = 1;
                                                                        } else {
                                                                            b13 = -1;
                                                                        }
                                                                    } else if (strZza7.equals(TtmlNode.CENTER)) {
                                                                        b13 = 0;
                                                                    } else {
                                                                        b13 = -1;
                                                                    }
                                                                    if (b13 != 0) {
                                                                        f16 = f12 + (f14 / 2.0f);
                                                                        i15 = 1;
                                                                    } else if (b13 != 1) {
                                                                        f16 = f12;
                                                                        i15 = 0;
                                                                    } else {
                                                                        f16 = f12 + f14;
                                                                        i15 = 2;
                                                                    }
                                                                } else {
                                                                    f16 = f12;
                                                                    i15 = 0;
                                                                }
                                                                float f1111 = 1.0f / i21;
                                                                strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                if (strZza5 != null) {
                                                                    strZza6 = zzfwk.zza(strZza5);
                                                                    iHashCode = strZza6.hashCode();
                                                                    if (iHashCode != 3694) {
                                                                        if (iHashCode != 3553396) {
                                                                            if (iHashCode != 3553576 && strZza6.equals("tbrl")) {
                                                                                b12 = 2;
                                                                            } else {
                                                                                b12 = -1;
                                                                            }
                                                                        } else if (strZza6.equals("tblr")) {
                                                                            b12 = 1;
                                                                        } else {
                                                                            b12 = -1;
                                                                        }
                                                                    } else if (strZza6.equals("tb")) {
                                                                        b12 = 0;
                                                                    } else {
                                                                        b12 = -1;
                                                                    }
                                                                    if (b12 != 0 || b12 == 1) {
                                                                        i16 = 2;
                                                                    } else if (b12 != 2) {
                                                                        i16 = Integer.MIN_VALUE;
                                                                    } else {
                                                                        i16 = 1;
                                                                    }
                                                                } else {
                                                                    i16 = Integer.MIN_VALUE;
                                                                }
                                                                zzalsVar = new zzals(strZza, f13, f16, 0, i15, f15, f14, 1, f1111, i16);
                                                            } else if (matcher4.matches()) {
                                                                zzff.zzf("TtmlParser", "Ignoring region with unsupported extent: ".concat(strZza2));
                                                            } else if (zzalqVar == null) {
                                                                zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                            } else {
                                                                String strGroup1112 = matcher4.group(1);
                                                                strGroup1112.getClass();
                                                                int i313 = Integer.parseInt(strGroup1112);
                                                                String strGroup1113 = matcher4.group(2);
                                                                strGroup1113.getClass();
                                                                int i314 = Integer.parseInt(strGroup1113);
                                                                float f25 = i313 / zzalqVar.zza;
                                                                f14 = i314 / zzalqVar.zzb;
                                                                f15 = f25;
                                                                strZza4 = zzfz.zza(xmlPullParserNewPullParser, TtmlNode.ATTR_TTS_DISPLAY_ALIGN);
                                                                if (strZza4 != null) {
                                                                    strZza7 = zzfwk.zza(strZza4);
                                                                    iHashCode2 = strZza7.hashCode();
                                                                    if (iHashCode2 != -1364013995) {
                                                                        if (iHashCode2 != 92734940) {
                                                                            b13 = -1;
                                                                        } else {
                                                                            b13 = 1;
                                                                        }
                                                                    } else if (strZza7.equals(TtmlNode.CENTER)) {
                                                                        b13 = 0;
                                                                    } else {
                                                                        b13 = -1;
                                                                    }
                                                                    if (b13 != 0) {
                                                                        f16 = f12 + (f14 / 2.0f);
                                                                        i15 = 1;
                                                                    } else if (b13 != 1) {
                                                                        f16 = f12;
                                                                        i15 = 0;
                                                                    } else {
                                                                        f16 = f12 + f14;
                                                                        i15 = 2;
                                                                    }
                                                                } else {
                                                                    f16 = f12;
                                                                    i15 = 0;
                                                                }
                                                                float f1112 = 1.0f / i21;
                                                                strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                if (strZza5 != null) {
                                                                    strZza6 = zzfwk.zza(strZza5);
                                                                    iHashCode = strZza6.hashCode();
                                                                    if (iHashCode != 3694) {
                                                                        if (iHashCode != 3553396) {
                                                                            if (iHashCode != 3553576) {
                                                                                b12 = -1;
                                                                            } else {
                                                                                b12 = 2;
                                                                            }
                                                                        } else if (strZza6.equals("tblr")) {
                                                                            b12 = 1;
                                                                        } else {
                                                                            b12 = -1;
                                                                        }
                                                                    } else if (strZza6.equals("tb")) {
                                                                        b12 = 0;
                                                                    } else {
                                                                        b12 = -1;
                                                                    }
                                                                    if (b12 != 0) {
                                                                        i16 = 2;
                                                                    } else {
                                                                        i16 = 2;
                                                                    }
                                                                } else {
                                                                    i16 = Integer.MIN_VALUE;
                                                                }
                                                                zzalsVar = new zzals(strZza, f13, f16, 0, i15, f15, f14, 1, f1112, i16);
                                                            }
                                                            if (zzalsVar != null) {
                                                                map5 = map2;
                                                                map5.put(zzalsVar.zza, zzalsVar);
                                                            } else {
                                                                map5 = map2;
                                                            }
                                                        } else {
                                                            zzff.zzf("TtmlParser", "Ignoring region without an extent");
                                                        }
                                                    } else {
                                                        map3 = map4;
                                                        if (!matcher2.matches()) {
                                                            zzff.zzf("TtmlParser", "Ignoring region with unsupported origin: ".concat(strZza2));
                                                        } else if (zzalqVar == null) {
                                                            zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                        } else {
                                                            String strGroup1114 = matcher2.group(1);
                                                            strGroup1114.getClass();
                                                            int i315 = Integer.parseInt(strGroup1114);
                                                            String strGroup1115 = matcher2.group(2);
                                                            strGroup1115.getClass();
                                                            int i316 = Integer.parseInt(strGroup1115);
                                                            f11 = i315 / zzalqVar.zza;
                                                            f12 = i316 / zzalqVar.zzb;
                                                            f13 = f11;
                                                            strZza3 = zzfz.zza(xmlPullParserNewPullParser, TtmlNode.ATTR_TTS_EXTENT);
                                                            if (strZza3 != null) {
                                                                matcher3 = pattern.matcher(strZza3);
                                                                matcher4 = pattern2.matcher(strZza3);
                                                                if (matcher3.matches()) {
                                                                    String strGroup1116 = matcher3.group(1);
                                                                    strGroup1116.getClass();
                                                                    float f1113 = Float.parseFloat(strGroup1116) / 100.0f;
                                                                    String strGroup1117 = matcher3.group(2);
                                                                    strGroup1117.getClass();
                                                                    f14 = Float.parseFloat(strGroup1117) / 100.0f;
                                                                    f15 = f1113;
                                                                    strZza4 = zzfz.zza(xmlPullParserNewPullParser, TtmlNode.ATTR_TTS_DISPLAY_ALIGN);
                                                                    if (strZza4 != null) {
                                                                        strZza7 = zzfwk.zza(strZza4);
                                                                        iHashCode2 = strZza7.hashCode();
                                                                        if (iHashCode2 != -1364013995) {
                                                                            if (iHashCode2 != 92734940) {
                                                                                b13 = -1;
                                                                            } else {
                                                                                b13 = 1;
                                                                            }
                                                                        } else if (strZza7.equals(TtmlNode.CENTER)) {
                                                                            b13 = 0;
                                                                        } else {
                                                                            b13 = -1;
                                                                        }
                                                                        if (b13 != 0) {
                                                                            f16 = f12 + (f14 / 2.0f);
                                                                            i15 = 1;
                                                                        } else if (b13 != 1) {
                                                                            f16 = f12;
                                                                            i15 = 0;
                                                                        } else {
                                                                            f16 = f12 + f14;
                                                                            i15 = 2;
                                                                        }
                                                                    } else {
                                                                        f16 = f12;
                                                                        i15 = 0;
                                                                    }
                                                                    float f1114 = 1.0f / i21;
                                                                    strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                    if (strZza5 != null) {
                                                                        strZza6 = zzfwk.zza(strZza5);
                                                                        iHashCode = strZza6.hashCode();
                                                                        if (iHashCode != 3694) {
                                                                            if (iHashCode != 3553396) {
                                                                                if (iHashCode != 3553576) {
                                                                                    b12 = -1;
                                                                                } else {
                                                                                    b12 = 2;
                                                                                }
                                                                            } else if (strZza6.equals("tblr")) {
                                                                                b12 = 1;
                                                                            } else {
                                                                                b12 = -1;
                                                                            }
                                                                        } else if (strZza6.equals("tb")) {
                                                                            b12 = 0;
                                                                        } else {
                                                                            b12 = -1;
                                                                        }
                                                                        if (b12 != 0) {
                                                                            i16 = 2;
                                                                        } else {
                                                                            i16 = 2;
                                                                        }
                                                                    } else {
                                                                        i16 = Integer.MIN_VALUE;
                                                                    }
                                                                    zzalsVar = new zzals(strZza, f13, f16, 0, i15, f15, f14, 1, f1114, i16);
                                                                } else if (matcher4.matches()) {
                                                                    zzff.zzf("TtmlParser", "Ignoring region with unsupported extent: ".concat(strZza2));
                                                                } else if (zzalqVar == null) {
                                                                    zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                                } else {
                                                                    String strGroup1118 = matcher4.group(1);
                                                                    strGroup1118.getClass();
                                                                    int i317 = Integer.parseInt(strGroup1118);
                                                                    String strGroup1119 = matcher4.group(2);
                                                                    strGroup1119.getClass();
                                                                    int i318 = Integer.parseInt(strGroup1119);
                                                                    float f26 = i317 / zzalqVar.zza;
                                                                    f14 = i318 / zzalqVar.zzb;
                                                                    f15 = f26;
                                                                    strZza4 = zzfz.zza(xmlPullParserNewPullParser, TtmlNode.ATTR_TTS_DISPLAY_ALIGN);
                                                                    if (strZza4 != null) {
                                                                        strZza7 = zzfwk.zza(strZza4);
                                                                        iHashCode2 = strZza7.hashCode();
                                                                        if (iHashCode2 != -1364013995) {
                                                                            if (iHashCode2 != 92734940) {
                                                                                b13 = -1;
                                                                            } else {
                                                                                b13 = 1;
                                                                            }
                                                                        } else if (strZza7.equals(TtmlNode.CENTER)) {
                                                                            b13 = 0;
                                                                        } else {
                                                                            b13 = -1;
                                                                        }
                                                                        if (b13 != 0) {
                                                                            f16 = f12 + (f14 / 2.0f);
                                                                            i15 = 1;
                                                                        } else if (b13 != 1) {
                                                                            f16 = f12;
                                                                            i15 = 0;
                                                                        } else {
                                                                            f16 = f12 + f14;
                                                                            i15 = 2;
                                                                        }
                                                                    } else {
                                                                        f16 = f12;
                                                                        i15 = 0;
                                                                    }
                                                                    float f1115 = 1.0f / i21;
                                                                    strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                    if (strZza5 != null) {
                                                                        strZza6 = zzfwk.zza(strZza5);
                                                                        iHashCode = strZza6.hashCode();
                                                                        if (iHashCode != 3694) {
                                                                            if (iHashCode != 3553396) {
                                                                                if (iHashCode != 3553576) {
                                                                                    b12 = -1;
                                                                                } else {
                                                                                    b12 = 2;
                                                                                }
                                                                            } else if (strZza6.equals("tblr")) {
                                                                                b12 = 1;
                                                                            } else {
                                                                                b12 = -1;
                                                                            }
                                                                        } else if (strZza6.equals("tb")) {
                                                                            b12 = 0;
                                                                        } else {
                                                                            b12 = -1;
                                                                        }
                                                                        if (b12 != 0) {
                                                                            i16 = 2;
                                                                        } else {
                                                                            i16 = 2;
                                                                        }
                                                                    } else {
                                                                        i16 = Integer.MIN_VALUE;
                                                                    }
                                                                    zzalsVar = new zzals(strZza, f13, f16, 0, i15, f15, f14, 1, f1115, i16);
                                                                }
                                                                if (zzalsVar != null) {
                                                                    map5 = map2;
                                                                    map5.put(zzalsVar.zza, zzalsVar);
                                                                } else {
                                                                    map5 = map2;
                                                                }
                                                            } else {
                                                                zzff.zzf("TtmlParser", "Ignoring region without an extent");
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    map3 = map4;
                                                    str5 = str3;
                                                    zzff.zzf("TtmlParser", "Ignoring region without an origin");
                                                }
                                            }
                                            zzalsVar = null;
                                            if (zzalsVar != null) {
                                                map5 = map2;
                                                map5.put(zzalsVar.zza, zzalsVar);
                                            } else {
                                                map5 = map2;
                                            }
                                        } else if (zzfz.zzc(xmlPullParserNewPullParser, str3)) {
                                            do {
                                                xmlPullParserNewPullParser.next();
                                                if (zzfz.zzc(xmlPullParserNewPullParser, "image") && (strZza8 = zzfz.zza(xmlPullParserNewPullParser, "id")) != null) {
                                                    map6.put(strZza8, xmlPullParserNewPullParser.nextText());
                                                }
                                            } while (!zzfz.zzb(xmlPullParserNewPullParser, str3));
                                        }
                                        if (zzfz.zzb(xmlPullParserNewPullParser, TtmlNode.TAG_HEAD)) {
                                            zzalpVar2 = zzalpVar3;
                                            arrayDeque = arrayDeque2;
                                        } else {
                                            map2 = map5;
                                            zzalpVar3 = zzalpVar3;
                                            str3 = str5;
                                            map4 = map3;
                                        }
                                    }
                                    map3 = map4;
                                    str5 = str3;
                                    map5 = map2;
                                    if (zzfz.zzb(xmlPullParserNewPullParser, TtmlNode.TAG_HEAD)) {
                                        zzalpVar2 = zzalpVar3;
                                        arrayDeque = arrayDeque2;
                                    } else {
                                        map2 = map5;
                                        zzalpVar3 = zzalpVar3;
                                        str3 = str5;
                                        map4 = map3;
                                    }
                                }
                            } else {
                                map3 = map4;
                                zzalpVar = zzalpVar3;
                                map5 = map2;
                                attributeCount = xmlPullParserNewPullParser.getAttributeCount();
                                zzalu zzaluVarZzf4 = zzf(xmlPullParserNewPullParser, null);
                                j11 = C.TIME_UNSET;
                                strArr = null;
                                strSubstring = null;
                                jZzc = -9223372036854775807L;
                                jZzc2 = -9223372036854775807L;
                                jZzc3 = -9223372036854775807L;
                                str4 = str;
                                i14 = 0;
                                while (i14 < attributeCount) {
                                    attributeName = xmlPullParserNewPullParser.getAttributeName(i14);
                                    attributeValue = xmlPullParserNewPullParser.getAttributeValue(i14);
                                    switch (attributeName) {
                                        case -934795532:
                                            if (!attributeName.equals(TtmlNode.TAG_REGION)) {
                                                b11 = 4;
                                            } else {
                                                b11 = -1;
                                            }
                                            break;
                                        case 99841:
                                            if (!attributeName.equals("dur")) {
                                                b11 = 2;
                                            } else {
                                                b11 = -1;
                                            }
                                            break;
                                        case 100571:
                                            if (!attributeName.equals(TtmlNode.END)) {
                                                b11 = 1;
                                            } else {
                                                b11 = -1;
                                            }
                                            break;
                                        case 93616297:
                                            if (!attributeName.equals("begin")) {
                                                b11 = 0;
                                            } else {
                                                b11 = -1;
                                            }
                                            break;
                                        case 109780401:
                                            if (!attributeName.equals(TtmlNode.TAG_STYLE)) {
                                                b11 = 3;
                                            } else {
                                                b11 = -1;
                                            }
                                            break;
                                        case 1292595405:
                                            if (!attributeName.equals("backgroundImage")) {
                                                b11 = 5;
                                            } else {
                                                b11 = -1;
                                            }
                                            break;
                                        default:
                                            b11 = -1;
                                            break;
                                    }
                                    if (b11 == 0) {
                                        zzalpVar2 = zzalpVar;
                                        jZzc2 = zzc(attributeValue, zzalpVar2);
                                    } else if (b11 == 1) {
                                        zzalpVar2 = zzalpVar;
                                        jZzc = zzc(attributeValue, zzalpVar2);
                                    } else if (b11 != 2) {
                                        if (b11 == 3) {
                                            strArrZzg = zzg(attributeValue);
                                            if (strArrZzg.length > 0) {
                                                strArr = strArrZzg;
                                            }
                                        } else if (b11 != 4) {
                                            if (b11 == 5) {
                                                if (attributeValue.startsWith(Utils.SEPARATOR)) {
                                                    strSubstring = attributeValue.substring(1);
                                                }
                                            }
                                        } else if (map5.containsKey(attributeValue)) {
                                            str4 = attributeValue;
                                        }
                                        zzalpVar2 = zzalpVar;
                                    } else {
                                        zzalpVar2 = zzalpVar;
                                        jZzc3 = zzc(attributeValue, zzalpVar2);
                                    }
                                    i14++;
                                    zzalpVar = zzalpVar2;
                                }
                                zzalpVar2 = zzalpVar;
                                if (zzaloVar3 != null) {
                                    zzaloVar = zzaloVar3;
                                    j13 = zzaloVar.zzd;
                                    if (j13 == C.TIME_UNSET) {
                                        zzaloVar2 = zzaloVar;
                                    } else {
                                        if (jZzc2 != C.TIME_UNSET) {
                                            jZzc2 += j13;
                                        } else {
                                            jZzc2 = -9223372036854775807L;
                                        }
                                        if (jZzc != C.TIME_UNSET) {
                                            jZzc += j13;
                                            zzaloVar2 = zzaloVar;
                                        } else {
                                            zzaloVar2 = zzaloVar;
                                            jZzc = -9223372036854775807L;
                                        }
                                    }
                                } else {
                                    zzaloVar = zzaloVar3;
                                    zzaloVar2 = null;
                                }
                                if (jZzc != C.TIME_UNSET) {
                                    j11 = jZzc;
                                } else if (jZzc3 != C.TIME_UNSET) {
                                    j11 = jZzc2 + jZzc3;
                                } else if (zzaloVar2 != null) {
                                    j12 = zzaloVar2.zze;
                                    if (j12 != C.TIME_UNSET) {
                                        j11 = j12;
                                    }
                                }
                                zzaloVarZzb = zzalo.zzb(xmlPullParserNewPullParser.getName(), jZzc2, j11, zzaluVarZzf4, strArr, str4, strSubstring, zzaloVar2);
                                arrayDeque = arrayDeque2;
                                arrayDeque.push(zzaloVarZzb);
                                if (zzaloVar != null) {
                                    zzaloVar.zzf(zzaloVarZzb);
                                }
                            }
                            i21 = i21;
                            zzalqVar = zzalqVar;
                            zzalpVar3 = zzalpVar2;
                            zzalvVar2 = zzalvVar2;
                            i19 = i19;
                            map = map3;
                        } else {
                            zzff.zze("TtmlParser", "Ignoring unsupported tag: " + xmlPullParserNewPullParser.getName());
                            map = map4;
                            arrayDeque = arrayDeque2;
                            map5 = map2;
                        }
                        i19 = 1;
                    } else {
                        str2 = str7;
                        HashMap map7 = map4;
                        arrayDeque = arrayDeque2;
                        zzalvVar = zzalvVar2;
                        i13 = i19;
                        if (eventType == 4) {
                            zzaloVar3.getClass();
                            zzaloVar3.zzf(zzalo.zzc(xmlPullParserNewPullParser.getText()));
                        } else {
                            if (eventType == 3) {
                                if (xmlPullParserNewPullParser.getName().equals(TtmlNode.TAG_TT)) {
                                    zzalo zzaloVar4 = (zzalo) arrayDeque.peek();
                                    zzaloVar4.getClass();
                                    map = map7;
                                    zzalvVar2 = new zzalv(zzaloVar4, map, map5, map6);
                                } else {
                                    map = map7;
                                    zzalvVar2 = zzalvVar;
                                }
                                arrayDeque.pop();
                            }
                            i19 = i13;
                        }
                        map = map7;
                        zzalvVar2 = zzalvVar;
                        i19 = i13;
                    }
                } else {
                    str = str6;
                    str2 = str7;
                    map = map4;
                    arrayDeque = arrayDeque2;
                    zzalvVar = zzalvVar2;
                    i13 = i19;
                    if (eventType == 2) {
                        i19 = i13 + 1;
                    } else {
                        if (eventType == 3) {
                            i19 = i13 - 1;
                        }
                        zzalvVar2 = zzalvVar;
                        i19 = i13;
                    }
                    zzalvVar2 = zzalvVar;
                }
                xmlPullParserNewPullParser.next();
                eventType = xmlPullParserNewPullParser.getEventType();
                map4 = map;
                arrayDeque2 = arrayDeque;
                str6 = str;
                str7 = str2;
            }
            zzalv zzalvVar3 = zzalvVar2;
            zzalvVar3.getClass();
            return zzalvVar3;
        } catch (IOException e18) {
            throw new IllegalStateException("Unexpected error when reading input.", e18);
        } catch (XmlPullParserException e19) {
            throw new IllegalStateException("Unable to decode source", e19);
        }
    }
}
