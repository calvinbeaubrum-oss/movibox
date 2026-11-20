package n7;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class v0 extends i1 implements z0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static v0 f71758j = new v0();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f71759k = SerializerFeature.of(new SerializerFeature[]{SerializerFeature.BrowserCompatible, SerializerFeature.WriteNonStringKeyAsString, SerializerFeature.BrowserSecure});

    @Override // n7.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) throws IOException {
        q(o0Var, obj, obj2, type, i11, false);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0158 A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:29:0x0055, B:32:0x005c, B:34:0x0068, B:43:0x0083, B:45:0x0094, B:46:0x00a4, B:48:0x00aa, B:50:0x00bc, B:53:0x00c4, B:56:0x00c9, B:58:0x00d3, B:60:0x00d7, B:63:0x00e6, B:66:0x00f0, B:68:0x00f4, B:71:0x00fc, B:74:0x0101, B:76:0x010b, B:78:0x010f, B:81:0x011a, B:84:0x0124, B:86:0x0128, B:89:0x0130, B:92:0x0135, B:94:0x013f, B:96:0x0143, B:99:0x014e, B:102:0x0158, B:104:0x015c, B:107:0x0164, B:110:0x0169, B:112:0x0173, B:114:0x0177, B:117:0x0183, B:120:0x018e, B:122:0x0192, B:125:0x019a, B:128:0x019f, B:130:0x01a9, B:132:0x01ad, B:133:0x01b6, B:134:0x01bc, B:136:0x01c0, B:139:0x01c8, B:142:0x01cd, B:144:0x01d7, B:146:0x01db, B:148:0x01e5, B:150:0x01ee, B:153:0x01f9, B:155:0x01fd, B:158:0x0208, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:187:0x0297, B:189:0x02a4, B:191:0x02ac, B:193:0x02b6, B:195:0x02be, B:197:0x02c2, B:199:0x02c6, B:201:0x02d1, B:203:0x02d7, B:204:0x02e5, B:176:0x026e, B:177:0x0271, B:179:0x0279, B:184:0x028d, B:185:0x0290, B:181:0x0281, B:183:0x0285, B:161:0x0228, B:40:0x007c), top: B:218:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x015c A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:29:0x0055, B:32:0x005c, B:34:0x0068, B:43:0x0083, B:45:0x0094, B:46:0x00a4, B:48:0x00aa, B:50:0x00bc, B:53:0x00c4, B:56:0x00c9, B:58:0x00d3, B:60:0x00d7, B:63:0x00e6, B:66:0x00f0, B:68:0x00f4, B:71:0x00fc, B:74:0x0101, B:76:0x010b, B:78:0x010f, B:81:0x011a, B:84:0x0124, B:86:0x0128, B:89:0x0130, B:92:0x0135, B:94:0x013f, B:96:0x0143, B:99:0x014e, B:102:0x0158, B:104:0x015c, B:107:0x0164, B:110:0x0169, B:112:0x0173, B:114:0x0177, B:117:0x0183, B:120:0x018e, B:122:0x0192, B:125:0x019a, B:128:0x019f, B:130:0x01a9, B:132:0x01ad, B:133:0x01b6, B:134:0x01bc, B:136:0x01c0, B:139:0x01c8, B:142:0x01cd, B:144:0x01d7, B:146:0x01db, B:148:0x01e5, B:150:0x01ee, B:153:0x01f9, B:155:0x01fd, B:158:0x0208, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:187:0x0297, B:189:0x02a4, B:191:0x02ac, B:193:0x02b6, B:195:0x02be, B:197:0x02c2, B:199:0x02c6, B:201:0x02d1, B:203:0x02d7, B:204:0x02e5, B:176:0x026e, B:177:0x0271, B:179:0x0279, B:184:0x028d, B:185:0x0290, B:181:0x0281, B:183:0x0285, B:161:0x0228, B:40:0x007c), top: B:218:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:107:0x0164 A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:29:0x0055, B:32:0x005c, B:34:0x0068, B:43:0x0083, B:45:0x0094, B:46:0x00a4, B:48:0x00aa, B:50:0x00bc, B:53:0x00c4, B:56:0x00c9, B:58:0x00d3, B:60:0x00d7, B:63:0x00e6, B:66:0x00f0, B:68:0x00f4, B:71:0x00fc, B:74:0x0101, B:76:0x010b, B:78:0x010f, B:81:0x011a, B:84:0x0124, B:86:0x0128, B:89:0x0130, B:92:0x0135, B:94:0x013f, B:96:0x0143, B:99:0x014e, B:102:0x0158, B:104:0x015c, B:107:0x0164, B:110:0x0169, B:112:0x0173, B:114:0x0177, B:117:0x0183, B:120:0x018e, B:122:0x0192, B:125:0x019a, B:128:0x019f, B:130:0x01a9, B:132:0x01ad, B:133:0x01b6, B:134:0x01bc, B:136:0x01c0, B:139:0x01c8, B:142:0x01cd, B:144:0x01d7, B:146:0x01db, B:148:0x01e5, B:150:0x01ee, B:153:0x01f9, B:155:0x01fd, B:158:0x0208, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:187:0x0297, B:189:0x02a4, B:191:0x02ac, B:193:0x02b6, B:195:0x02be, B:197:0x02c2, B:199:0x02c6, B:201:0x02d1, B:203:0x02d7, B:204:0x02e5, B:176:0x026e, B:177:0x0271, B:179:0x0279, B:184:0x028d, B:185:0x0290, B:181:0x0281, B:183:0x0285, B:161:0x0228, B:40:0x007c), top: B:218:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:117:0x0183 A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:29:0x0055, B:32:0x005c, B:34:0x0068, B:43:0x0083, B:45:0x0094, B:46:0x00a4, B:48:0x00aa, B:50:0x00bc, B:53:0x00c4, B:56:0x00c9, B:58:0x00d3, B:60:0x00d7, B:63:0x00e6, B:66:0x00f0, B:68:0x00f4, B:71:0x00fc, B:74:0x0101, B:76:0x010b, B:78:0x010f, B:81:0x011a, B:84:0x0124, B:86:0x0128, B:89:0x0130, B:92:0x0135, B:94:0x013f, B:96:0x0143, B:99:0x014e, B:102:0x0158, B:104:0x015c, B:107:0x0164, B:110:0x0169, B:112:0x0173, B:114:0x0177, B:117:0x0183, B:120:0x018e, B:122:0x0192, B:125:0x019a, B:128:0x019f, B:130:0x01a9, B:132:0x01ad, B:133:0x01b6, B:134:0x01bc, B:136:0x01c0, B:139:0x01c8, B:142:0x01cd, B:144:0x01d7, B:146:0x01db, B:148:0x01e5, B:150:0x01ee, B:153:0x01f9, B:155:0x01fd, B:158:0x0208, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:187:0x0297, B:189:0x02a4, B:191:0x02ac, B:193:0x02b6, B:195:0x02be, B:197:0x02c2, B:199:0x02c6, B:201:0x02d1, B:203:0x02d7, B:204:0x02e5, B:176:0x026e, B:177:0x0271, B:179:0x0279, B:184:0x028d, B:185:0x0290, B:181:0x0281, B:183:0x0285, B:161:0x0228, B:40:0x007c), top: B:218:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:11:0x0022 A[PHI: r1
  0x0022: PHI (r1v63 java.util.Map<java.lang.String, java.lang.Object>) = 
  (r1v2 java.util.Map<java.lang.String, java.lang.Object>)
  (r1v2 java.util.Map<java.lang.String, java.lang.Object>)
  (r1v2 java.util.Map<java.lang.String, java.lang.Object>)
  (r1v1 java.util.Map<java.lang.String, java.lang.Object>)
 binds: [B:16:0x0030, B:18:0x0034, B:21:0x003d, B:9:0x001f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:122:0x0192 A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:29:0x0055, B:32:0x005c, B:34:0x0068, B:43:0x0083, B:45:0x0094, B:46:0x00a4, B:48:0x00aa, B:50:0x00bc, B:53:0x00c4, B:56:0x00c9, B:58:0x00d3, B:60:0x00d7, B:63:0x00e6, B:66:0x00f0, B:68:0x00f4, B:71:0x00fc, B:74:0x0101, B:76:0x010b, B:78:0x010f, B:81:0x011a, B:84:0x0124, B:86:0x0128, B:89:0x0130, B:92:0x0135, B:94:0x013f, B:96:0x0143, B:99:0x014e, B:102:0x0158, B:104:0x015c, B:107:0x0164, B:110:0x0169, B:112:0x0173, B:114:0x0177, B:117:0x0183, B:120:0x018e, B:122:0x0192, B:125:0x019a, B:128:0x019f, B:130:0x01a9, B:132:0x01ad, B:133:0x01b6, B:134:0x01bc, B:136:0x01c0, B:139:0x01c8, B:142:0x01cd, B:144:0x01d7, B:146:0x01db, B:148:0x01e5, B:150:0x01ee, B:153:0x01f9, B:155:0x01fd, B:158:0x0208, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:187:0x0297, B:189:0x02a4, B:191:0x02ac, B:193:0x02b6, B:195:0x02be, B:197:0x02c2, B:199:0x02c6, B:201:0x02d1, B:203:0x02d7, B:204:0x02e5, B:176:0x026e, B:177:0x0271, B:179:0x0279, B:184:0x028d, B:185:0x0290, B:181:0x0281, B:183:0x0285, B:161:0x0228, B:40:0x007c), top: B:218:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:125:0x019a A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:29:0x0055, B:32:0x005c, B:34:0x0068, B:43:0x0083, B:45:0x0094, B:46:0x00a4, B:48:0x00aa, B:50:0x00bc, B:53:0x00c4, B:56:0x00c9, B:58:0x00d3, B:60:0x00d7, B:63:0x00e6, B:66:0x00f0, B:68:0x00f4, B:71:0x00fc, B:74:0x0101, B:76:0x010b, B:78:0x010f, B:81:0x011a, B:84:0x0124, B:86:0x0128, B:89:0x0130, B:92:0x0135, B:94:0x013f, B:96:0x0143, B:99:0x014e, B:102:0x0158, B:104:0x015c, B:107:0x0164, B:110:0x0169, B:112:0x0173, B:114:0x0177, B:117:0x0183, B:120:0x018e, B:122:0x0192, B:125:0x019a, B:128:0x019f, B:130:0x01a9, B:132:0x01ad, B:133:0x01b6, B:134:0x01bc, B:136:0x01c0, B:139:0x01c8, B:142:0x01cd, B:144:0x01d7, B:146:0x01db, B:148:0x01e5, B:150:0x01ee, B:153:0x01f9, B:155:0x01fd, B:158:0x0208, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:187:0x0297, B:189:0x02a4, B:191:0x02ac, B:193:0x02b6, B:195:0x02be, B:197:0x02c2, B:199:0x02c6, B:201:0x02d1, B:203:0x02d7, B:204:0x02e5, B:176:0x026e, B:177:0x0271, B:179:0x0279, B:184:0x028d, B:185:0x0290, B:181:0x0281, B:183:0x0285, B:161:0x0228, B:40:0x007c), top: B:218:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x01b6 A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:29:0x0055, B:32:0x005c, B:34:0x0068, B:43:0x0083, B:45:0x0094, B:46:0x00a4, B:48:0x00aa, B:50:0x00bc, B:53:0x00c4, B:56:0x00c9, B:58:0x00d3, B:60:0x00d7, B:63:0x00e6, B:66:0x00f0, B:68:0x00f4, B:71:0x00fc, B:74:0x0101, B:76:0x010b, B:78:0x010f, B:81:0x011a, B:84:0x0124, B:86:0x0128, B:89:0x0130, B:92:0x0135, B:94:0x013f, B:96:0x0143, B:99:0x014e, B:102:0x0158, B:104:0x015c, B:107:0x0164, B:110:0x0169, B:112:0x0173, B:114:0x0177, B:117:0x0183, B:120:0x018e, B:122:0x0192, B:125:0x019a, B:128:0x019f, B:130:0x01a9, B:132:0x01ad, B:133:0x01b6, B:134:0x01bc, B:136:0x01c0, B:139:0x01c8, B:142:0x01cd, B:144:0x01d7, B:146:0x01db, B:148:0x01e5, B:150:0x01ee, B:153:0x01f9, B:155:0x01fd, B:158:0x0208, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:187:0x0297, B:189:0x02a4, B:191:0x02ac, B:193:0x02b6, B:195:0x02be, B:197:0x02c2, B:199:0x02c6, B:201:0x02d1, B:203:0x02d7, B:204:0x02e5, B:176:0x026e, B:177:0x0271, B:179:0x0279, B:184:0x028d, B:185:0x0290, B:181:0x0281, B:183:0x0285, B:161:0x0228, B:40:0x007c), top: B:218:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:136:0x01c0 A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:29:0x0055, B:32:0x005c, B:34:0x0068, B:43:0x0083, B:45:0x0094, B:46:0x00a4, B:48:0x00aa, B:50:0x00bc, B:53:0x00c4, B:56:0x00c9, B:58:0x00d3, B:60:0x00d7, B:63:0x00e6, B:66:0x00f0, B:68:0x00f4, B:71:0x00fc, B:74:0x0101, B:76:0x010b, B:78:0x010f, B:81:0x011a, B:84:0x0124, B:86:0x0128, B:89:0x0130, B:92:0x0135, B:94:0x013f, B:96:0x0143, B:99:0x014e, B:102:0x0158, B:104:0x015c, B:107:0x0164, B:110:0x0169, B:112:0x0173, B:114:0x0177, B:117:0x0183, B:120:0x018e, B:122:0x0192, B:125:0x019a, B:128:0x019f, B:130:0x01a9, B:132:0x01ad, B:133:0x01b6, B:134:0x01bc, B:136:0x01c0, B:139:0x01c8, B:142:0x01cd, B:144:0x01d7, B:146:0x01db, B:148:0x01e5, B:150:0x01ee, B:153:0x01f9, B:155:0x01fd, B:158:0x0208, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:187:0x0297, B:189:0x02a4, B:191:0x02ac, B:193:0x02b6, B:195:0x02be, B:197:0x02c2, B:199:0x02c6, B:201:0x02d1, B:203:0x02d7, B:204:0x02e5, B:176:0x026e, B:177:0x0271, B:179:0x0279, B:184:0x028d, B:185:0x0290, B:181:0x0281, B:183:0x0285, B:161:0x0228, B:40:0x007c), top: B:218:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x01c8 A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:29:0x0055, B:32:0x005c, B:34:0x0068, B:43:0x0083, B:45:0x0094, B:46:0x00a4, B:48:0x00aa, B:50:0x00bc, B:53:0x00c4, B:56:0x00c9, B:58:0x00d3, B:60:0x00d7, B:63:0x00e6, B:66:0x00f0, B:68:0x00f4, B:71:0x00fc, B:74:0x0101, B:76:0x010b, B:78:0x010f, B:81:0x011a, B:84:0x0124, B:86:0x0128, B:89:0x0130, B:92:0x0135, B:94:0x013f, B:96:0x0143, B:99:0x014e, B:102:0x0158, B:104:0x015c, B:107:0x0164, B:110:0x0169, B:112:0x0173, B:114:0x0177, B:117:0x0183, B:120:0x018e, B:122:0x0192, B:125:0x019a, B:128:0x019f, B:130:0x01a9, B:132:0x01ad, B:133:0x01b6, B:134:0x01bc, B:136:0x01c0, B:139:0x01c8, B:142:0x01cd, B:144:0x01d7, B:146:0x01db, B:148:0x01e5, B:150:0x01ee, B:153:0x01f9, B:155:0x01fd, B:158:0x0208, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:187:0x0297, B:189:0x02a4, B:191:0x02ac, B:193:0x02b6, B:195:0x02be, B:197:0x02c2, B:199:0x02c6, B:201:0x02d1, B:203:0x02d7, B:204:0x02e5, B:176:0x026e, B:177:0x0271, B:179:0x0279, B:184:0x028d, B:185:0x0290, B:181:0x0281, B:183:0x0285, B:161:0x0228, B:40:0x007c), top: B:218:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:148:0x01e5 A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:29:0x0055, B:32:0x005c, B:34:0x0068, B:43:0x0083, B:45:0x0094, B:46:0x00a4, B:48:0x00aa, B:50:0x00bc, B:53:0x00c4, B:56:0x00c9, B:58:0x00d3, B:60:0x00d7, B:63:0x00e6, B:66:0x00f0, B:68:0x00f4, B:71:0x00fc, B:74:0x0101, B:76:0x010b, B:78:0x010f, B:81:0x011a, B:84:0x0124, B:86:0x0128, B:89:0x0130, B:92:0x0135, B:94:0x013f, B:96:0x0143, B:99:0x014e, B:102:0x0158, B:104:0x015c, B:107:0x0164, B:110:0x0169, B:112:0x0173, B:114:0x0177, B:117:0x0183, B:120:0x018e, B:122:0x0192, B:125:0x019a, B:128:0x019f, B:130:0x01a9, B:132:0x01ad, B:133:0x01b6, B:134:0x01bc, B:136:0x01c0, B:139:0x01c8, B:142:0x01cd, B:144:0x01d7, B:146:0x01db, B:148:0x01e5, B:150:0x01ee, B:153:0x01f9, B:155:0x01fd, B:158:0x0208, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:187:0x0297, B:189:0x02a4, B:191:0x02ac, B:193:0x02b6, B:195:0x02be, B:197:0x02c2, B:199:0x02c6, B:201:0x02d1, B:203:0x02d7, B:204:0x02e5, B:176:0x026e, B:177:0x0271, B:179:0x0279, B:184:0x028d, B:185:0x0290, B:181:0x0281, B:183:0x0285, B:161:0x0228, B:40:0x007c), top: B:218:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:150:0x01ee A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:29:0x0055, B:32:0x005c, B:34:0x0068, B:43:0x0083, B:45:0x0094, B:46:0x00a4, B:48:0x00aa, B:50:0x00bc, B:53:0x00c4, B:56:0x00c9, B:58:0x00d3, B:60:0x00d7, B:63:0x00e6, B:66:0x00f0, B:68:0x00f4, B:71:0x00fc, B:74:0x0101, B:76:0x010b, B:78:0x010f, B:81:0x011a, B:84:0x0124, B:86:0x0128, B:89:0x0130, B:92:0x0135, B:94:0x013f, B:96:0x0143, B:99:0x014e, B:102:0x0158, B:104:0x015c, B:107:0x0164, B:110:0x0169, B:112:0x0173, B:114:0x0177, B:117:0x0183, B:120:0x018e, B:122:0x0192, B:125:0x019a, B:128:0x019f, B:130:0x01a9, B:132:0x01ad, B:133:0x01b6, B:134:0x01bc, B:136:0x01c0, B:139:0x01c8, B:142:0x01cd, B:144:0x01d7, B:146:0x01db, B:148:0x01e5, B:150:0x01ee, B:153:0x01f9, B:155:0x01fd, B:158:0x0208, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:187:0x0297, B:189:0x02a4, B:191:0x02ac, B:193:0x02b6, B:195:0x02be, B:197:0x02c2, B:199:0x02c6, B:201:0x02d1, B:203:0x02d7, B:204:0x02e5, B:176:0x026e, B:177:0x0271, B:179:0x0279, B:184:0x028d, B:185:0x0290, B:181:0x0281, B:183:0x0285, B:161:0x0228, B:40:0x007c), top: B:218:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:152:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:163:0x023d A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:29:0x0055, B:32:0x005c, B:34:0x0068, B:43:0x0083, B:45:0x0094, B:46:0x00a4, B:48:0x00aa, B:50:0x00bc, B:53:0x00c4, B:56:0x00c9, B:58:0x00d3, B:60:0x00d7, B:63:0x00e6, B:66:0x00f0, B:68:0x00f4, B:71:0x00fc, B:74:0x0101, B:76:0x010b, B:78:0x010f, B:81:0x011a, B:84:0x0124, B:86:0x0128, B:89:0x0130, B:92:0x0135, B:94:0x013f, B:96:0x0143, B:99:0x014e, B:102:0x0158, B:104:0x015c, B:107:0x0164, B:110:0x0169, B:112:0x0173, B:114:0x0177, B:117:0x0183, B:120:0x018e, B:122:0x0192, B:125:0x019a, B:128:0x019f, B:130:0x01a9, B:132:0x01ad, B:133:0x01b6, B:134:0x01bc, B:136:0x01c0, B:139:0x01c8, B:142:0x01cd, B:144:0x01d7, B:146:0x01db, B:148:0x01e5, B:150:0x01ee, B:153:0x01f9, B:155:0x01fd, B:158:0x0208, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:187:0x0297, B:189:0x02a4, B:191:0x02ac, B:193:0x02b6, B:195:0x02be, B:197:0x02c2, B:199:0x02c6, B:201:0x02d1, B:203:0x02d7, B:204:0x02e5, B:176:0x026e, B:177:0x0271, B:179:0x0279, B:184:0x028d, B:185:0x0290, B:181:0x0281, B:183:0x0285, B:161:0x0228, B:40:0x007c), top: B:218:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:168:0x0255 A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:29:0x0055, B:32:0x005c, B:34:0x0068, B:43:0x0083, B:45:0x0094, B:46:0x00a4, B:48:0x00aa, B:50:0x00bc, B:53:0x00c4, B:56:0x00c9, B:58:0x00d3, B:60:0x00d7, B:63:0x00e6, B:66:0x00f0, B:68:0x00f4, B:71:0x00fc, B:74:0x0101, B:76:0x010b, B:78:0x010f, B:81:0x011a, B:84:0x0124, B:86:0x0128, B:89:0x0130, B:92:0x0135, B:94:0x013f, B:96:0x0143, B:99:0x014e, B:102:0x0158, B:104:0x015c, B:107:0x0164, B:110:0x0169, B:112:0x0173, B:114:0x0177, B:117:0x0183, B:120:0x018e, B:122:0x0192, B:125:0x019a, B:128:0x019f, B:130:0x01a9, B:132:0x01ad, B:133:0x01b6, B:134:0x01bc, B:136:0x01c0, B:139:0x01c8, B:142:0x01cd, B:144:0x01d7, B:146:0x01db, B:148:0x01e5, B:150:0x01ee, B:153:0x01f9, B:155:0x01fd, B:158:0x0208, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:187:0x0297, B:189:0x02a4, B:191:0x02ac, B:193:0x02b6, B:195:0x02be, B:197:0x02c2, B:199:0x02c6, B:201:0x02d1, B:203:0x02d7, B:204:0x02e5, B:176:0x026e, B:177:0x0271, B:179:0x0279, B:184:0x028d, B:185:0x0290, B:181:0x0281, B:183:0x0285, B:161:0x0228, B:40:0x007c), top: B:218:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:170:0x025a A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:29:0x0055, B:32:0x005c, B:34:0x0068, B:43:0x0083, B:45:0x0094, B:46:0x00a4, B:48:0x00aa, B:50:0x00bc, B:53:0x00c4, B:56:0x00c9, B:58:0x00d3, B:60:0x00d7, B:63:0x00e6, B:66:0x00f0, B:68:0x00f4, B:71:0x00fc, B:74:0x0101, B:76:0x010b, B:78:0x010f, B:81:0x011a, B:84:0x0124, B:86:0x0128, B:89:0x0130, B:92:0x0135, B:94:0x013f, B:96:0x0143, B:99:0x014e, B:102:0x0158, B:104:0x015c, B:107:0x0164, B:110:0x0169, B:112:0x0173, B:114:0x0177, B:117:0x0183, B:120:0x018e, B:122:0x0192, B:125:0x019a, B:128:0x019f, B:130:0x01a9, B:132:0x01ad, B:133:0x01b6, B:134:0x01bc, B:136:0x01c0, B:139:0x01c8, B:142:0x01cd, B:144:0x01d7, B:146:0x01db, B:148:0x01e5, B:150:0x01ee, B:153:0x01f9, B:155:0x01fd, B:158:0x0208, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:187:0x0297, B:189:0x02a4, B:191:0x02ac, B:193:0x02b6, B:195:0x02be, B:197:0x02c2, B:199:0x02c6, B:201:0x02d1, B:203:0x02d7, B:204:0x02e5, B:176:0x026e, B:177:0x0271, B:179:0x0279, B:184:0x028d, B:185:0x0290, B:181:0x0281, B:183:0x0285, B:161:0x0228, B:40:0x007c), top: B:218:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:173:0x0265 A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:29:0x0055, B:32:0x005c, B:34:0x0068, B:43:0x0083, B:45:0x0094, B:46:0x00a4, B:48:0x00aa, B:50:0x00bc, B:53:0x00c4, B:56:0x00c9, B:58:0x00d3, B:60:0x00d7, B:63:0x00e6, B:66:0x00f0, B:68:0x00f4, B:71:0x00fc, B:74:0x0101, B:76:0x010b, B:78:0x010f, B:81:0x011a, B:84:0x0124, B:86:0x0128, B:89:0x0130, B:92:0x0135, B:94:0x013f, B:96:0x0143, B:99:0x014e, B:102:0x0158, B:104:0x015c, B:107:0x0164, B:110:0x0169, B:112:0x0173, B:114:0x0177, B:117:0x0183, B:120:0x018e, B:122:0x0192, B:125:0x019a, B:128:0x019f, B:130:0x01a9, B:132:0x01ad, B:133:0x01b6, B:134:0x01bc, B:136:0x01c0, B:139:0x01c8, B:142:0x01cd, B:144:0x01d7, B:146:0x01db, B:148:0x01e5, B:150:0x01ee, B:153:0x01f9, B:155:0x01fd, B:158:0x0208, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:187:0x0297, B:189:0x02a4, B:191:0x02ac, B:193:0x02b6, B:195:0x02be, B:197:0x02c2, B:199:0x02c6, B:201:0x02d1, B:203:0x02d7, B:204:0x02e5, B:176:0x026e, B:177:0x0271, B:179:0x0279, B:184:0x028d, B:185:0x0290, B:181:0x0281, B:183:0x0285, B:161:0x0228, B:40:0x007c), top: B:218:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:175:0x026c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:176:0x026e A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:29:0x0055, B:32:0x005c, B:34:0x0068, B:43:0x0083, B:45:0x0094, B:46:0x00a4, B:48:0x00aa, B:50:0x00bc, B:53:0x00c4, B:56:0x00c9, B:58:0x00d3, B:60:0x00d7, B:63:0x00e6, B:66:0x00f0, B:68:0x00f4, B:71:0x00fc, B:74:0x0101, B:76:0x010b, B:78:0x010f, B:81:0x011a, B:84:0x0124, B:86:0x0128, B:89:0x0130, B:92:0x0135, B:94:0x013f, B:96:0x0143, B:99:0x014e, B:102:0x0158, B:104:0x015c, B:107:0x0164, B:110:0x0169, B:112:0x0173, B:114:0x0177, B:117:0x0183, B:120:0x018e, B:122:0x0192, B:125:0x019a, B:128:0x019f, B:130:0x01a9, B:132:0x01ad, B:133:0x01b6, B:134:0x01bc, B:136:0x01c0, B:139:0x01c8, B:142:0x01cd, B:144:0x01d7, B:146:0x01db, B:148:0x01e5, B:150:0x01ee, B:153:0x01f9, B:155:0x01fd, B:158:0x0208, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:187:0x0297, B:189:0x02a4, B:191:0x02ac, B:193:0x02b6, B:195:0x02be, B:197:0x02c2, B:199:0x02c6, B:201:0x02d1, B:203:0x02d7, B:204:0x02e5, B:176:0x026e, B:177:0x0271, B:179:0x0279, B:184:0x028d, B:185:0x0290, B:181:0x0281, B:183:0x0285, B:161:0x0228, B:40:0x007c), top: B:218:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:179:0x0279 A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:29:0x0055, B:32:0x005c, B:34:0x0068, B:43:0x0083, B:45:0x0094, B:46:0x00a4, B:48:0x00aa, B:50:0x00bc, B:53:0x00c4, B:56:0x00c9, B:58:0x00d3, B:60:0x00d7, B:63:0x00e6, B:66:0x00f0, B:68:0x00f4, B:71:0x00fc, B:74:0x0101, B:76:0x010b, B:78:0x010f, B:81:0x011a, B:84:0x0124, B:86:0x0128, B:89:0x0130, B:92:0x0135, B:94:0x013f, B:96:0x0143, B:99:0x014e, B:102:0x0158, B:104:0x015c, B:107:0x0164, B:110:0x0169, B:112:0x0173, B:114:0x0177, B:117:0x0183, B:120:0x018e, B:122:0x0192, B:125:0x019a, B:128:0x019f, B:130:0x01a9, B:132:0x01ad, B:133:0x01b6, B:134:0x01bc, B:136:0x01c0, B:139:0x01c8, B:142:0x01cd, B:144:0x01d7, B:146:0x01db, B:148:0x01e5, B:150:0x01ee, B:153:0x01f9, B:155:0x01fd, B:158:0x0208, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:187:0x0297, B:189:0x02a4, B:191:0x02ac, B:193:0x02b6, B:195:0x02be, B:197:0x02c2, B:199:0x02c6, B:201:0x02d1, B:203:0x02d7, B:204:0x02e5, B:176:0x026e, B:177:0x0271, B:179:0x0279, B:184:0x028d, B:185:0x0290, B:181:0x0281, B:183:0x0285, B:161:0x0228, B:40:0x007c), top: B:218:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:181:0x0281 A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:29:0x0055, B:32:0x005c, B:34:0x0068, B:43:0x0083, B:45:0x0094, B:46:0x00a4, B:48:0x00aa, B:50:0x00bc, B:53:0x00c4, B:56:0x00c9, B:58:0x00d3, B:60:0x00d7, B:63:0x00e6, B:66:0x00f0, B:68:0x00f4, B:71:0x00fc, B:74:0x0101, B:76:0x010b, B:78:0x010f, B:81:0x011a, B:84:0x0124, B:86:0x0128, B:89:0x0130, B:92:0x0135, B:94:0x013f, B:96:0x0143, B:99:0x014e, B:102:0x0158, B:104:0x015c, B:107:0x0164, B:110:0x0169, B:112:0x0173, B:114:0x0177, B:117:0x0183, B:120:0x018e, B:122:0x0192, B:125:0x019a, B:128:0x019f, B:130:0x01a9, B:132:0x01ad, B:133:0x01b6, B:134:0x01bc, B:136:0x01c0, B:139:0x01c8, B:142:0x01cd, B:144:0x01d7, B:146:0x01db, B:148:0x01e5, B:150:0x01ee, B:153:0x01f9, B:155:0x01fd, B:158:0x0208, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:187:0x0297, B:189:0x02a4, B:191:0x02ac, B:193:0x02b6, B:195:0x02be, B:197:0x02c2, B:199:0x02c6, B:201:0x02d1, B:203:0x02d7, B:204:0x02e5, B:176:0x026e, B:177:0x0271, B:179:0x0279, B:184:0x028d, B:185:0x0290, B:181:0x0281, B:183:0x0285, B:161:0x0228, B:40:0x007c), top: B:218:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:187:0x0297 A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:29:0x0055, B:32:0x005c, B:34:0x0068, B:43:0x0083, B:45:0x0094, B:46:0x00a4, B:48:0x00aa, B:50:0x00bc, B:53:0x00c4, B:56:0x00c9, B:58:0x00d3, B:60:0x00d7, B:63:0x00e6, B:66:0x00f0, B:68:0x00f4, B:71:0x00fc, B:74:0x0101, B:76:0x010b, B:78:0x010f, B:81:0x011a, B:84:0x0124, B:86:0x0128, B:89:0x0130, B:92:0x0135, B:94:0x013f, B:96:0x0143, B:99:0x014e, B:102:0x0158, B:104:0x015c, B:107:0x0164, B:110:0x0169, B:112:0x0173, B:114:0x0177, B:117:0x0183, B:120:0x018e, B:122:0x0192, B:125:0x019a, B:128:0x019f, B:130:0x01a9, B:132:0x01ad, B:133:0x01b6, B:134:0x01bc, B:136:0x01c0, B:139:0x01c8, B:142:0x01cd, B:144:0x01d7, B:146:0x01db, B:148:0x01e5, B:150:0x01ee, B:153:0x01f9, B:155:0x01fd, B:158:0x0208, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:187:0x0297, B:189:0x02a4, B:191:0x02ac, B:193:0x02b6, B:195:0x02be, B:197:0x02c2, B:199:0x02c6, B:201:0x02d1, B:203:0x02d7, B:204:0x02e5, B:176:0x026e, B:177:0x0271, B:179:0x0279, B:184:0x028d, B:185:0x0290, B:181:0x0281, B:183:0x0285, B:161:0x0228, B:40:0x007c), top: B:218:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:189:0x02a4 A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:29:0x0055, B:32:0x005c, B:34:0x0068, B:43:0x0083, B:45:0x0094, B:46:0x00a4, B:48:0x00aa, B:50:0x00bc, B:53:0x00c4, B:56:0x00c9, B:58:0x00d3, B:60:0x00d7, B:63:0x00e6, B:66:0x00f0, B:68:0x00f4, B:71:0x00fc, B:74:0x0101, B:76:0x010b, B:78:0x010f, B:81:0x011a, B:84:0x0124, B:86:0x0128, B:89:0x0130, B:92:0x0135, B:94:0x013f, B:96:0x0143, B:99:0x014e, B:102:0x0158, B:104:0x015c, B:107:0x0164, B:110:0x0169, B:112:0x0173, B:114:0x0177, B:117:0x0183, B:120:0x018e, B:122:0x0192, B:125:0x019a, B:128:0x019f, B:130:0x01a9, B:132:0x01ad, B:133:0x01b6, B:134:0x01bc, B:136:0x01c0, B:139:0x01c8, B:142:0x01cd, B:144:0x01d7, B:146:0x01db, B:148:0x01e5, B:150:0x01ee, B:153:0x01f9, B:155:0x01fd, B:158:0x0208, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:187:0x0297, B:189:0x02a4, B:191:0x02ac, B:193:0x02b6, B:195:0x02be, B:197:0x02c2, B:199:0x02c6, B:201:0x02d1, B:203:0x02d7, B:204:0x02e5, B:176:0x026e, B:177:0x0271, B:179:0x0279, B:184:0x028d, B:185:0x0290, B:181:0x0281, B:183:0x0285, B:161:0x0228, B:40:0x007c), top: B:218:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:191:0x02ac A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:29:0x0055, B:32:0x005c, B:34:0x0068, B:43:0x0083, B:45:0x0094, B:46:0x00a4, B:48:0x00aa, B:50:0x00bc, B:53:0x00c4, B:56:0x00c9, B:58:0x00d3, B:60:0x00d7, B:63:0x00e6, B:66:0x00f0, B:68:0x00f4, B:71:0x00fc, B:74:0x0101, B:76:0x010b, B:78:0x010f, B:81:0x011a, B:84:0x0124, B:86:0x0128, B:89:0x0130, B:92:0x0135, B:94:0x013f, B:96:0x0143, B:99:0x014e, B:102:0x0158, B:104:0x015c, B:107:0x0164, B:110:0x0169, B:112:0x0173, B:114:0x0177, B:117:0x0183, B:120:0x018e, B:122:0x0192, B:125:0x019a, B:128:0x019f, B:130:0x01a9, B:132:0x01ad, B:133:0x01b6, B:134:0x01bc, B:136:0x01c0, B:139:0x01c8, B:142:0x01cd, B:144:0x01d7, B:146:0x01db, B:148:0x01e5, B:150:0x01ee, B:153:0x01f9, B:155:0x01fd, B:158:0x0208, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:187:0x0297, B:189:0x02a4, B:191:0x02ac, B:193:0x02b6, B:195:0x02be, B:197:0x02c2, B:199:0x02c6, B:201:0x02d1, B:203:0x02d7, B:204:0x02e5, B:176:0x026e, B:177:0x0271, B:179:0x0279, B:184:0x028d, B:185:0x0290, B:181:0x0281, B:183:0x0285, B:161:0x0228, B:40:0x007c), top: B:218:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:192:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:195:0x02be A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:29:0x0055, B:32:0x005c, B:34:0x0068, B:43:0x0083, B:45:0x0094, B:46:0x00a4, B:48:0x00aa, B:50:0x00bc, B:53:0x00c4, B:56:0x00c9, B:58:0x00d3, B:60:0x00d7, B:63:0x00e6, B:66:0x00f0, B:68:0x00f4, B:71:0x00fc, B:74:0x0101, B:76:0x010b, B:78:0x010f, B:81:0x011a, B:84:0x0124, B:86:0x0128, B:89:0x0130, B:92:0x0135, B:94:0x013f, B:96:0x0143, B:99:0x014e, B:102:0x0158, B:104:0x015c, B:107:0x0164, B:110:0x0169, B:112:0x0173, B:114:0x0177, B:117:0x0183, B:120:0x018e, B:122:0x0192, B:125:0x019a, B:128:0x019f, B:130:0x01a9, B:132:0x01ad, B:133:0x01b6, B:134:0x01bc, B:136:0x01c0, B:139:0x01c8, B:142:0x01cd, B:144:0x01d7, B:146:0x01db, B:148:0x01e5, B:150:0x01ee, B:153:0x01f9, B:155:0x01fd, B:158:0x0208, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:187:0x0297, B:189:0x02a4, B:191:0x02ac, B:193:0x02b6, B:195:0x02be, B:197:0x02c2, B:199:0x02c6, B:201:0x02d1, B:203:0x02d7, B:204:0x02e5, B:176:0x026e, B:177:0x0271, B:179:0x0279, B:184:0x028d, B:185:0x0290, B:181:0x0281, B:183:0x0285, B:161:0x0228, B:40:0x007c), top: B:218:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:202:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:204:0x02e5 A[Catch: all -> 0x0059, TRY_LEAVE, TryCatch #1 {all -> 0x0059, blocks: (B:29:0x0055, B:32:0x005c, B:34:0x0068, B:43:0x0083, B:45:0x0094, B:46:0x00a4, B:48:0x00aa, B:50:0x00bc, B:53:0x00c4, B:56:0x00c9, B:58:0x00d3, B:60:0x00d7, B:63:0x00e6, B:66:0x00f0, B:68:0x00f4, B:71:0x00fc, B:74:0x0101, B:76:0x010b, B:78:0x010f, B:81:0x011a, B:84:0x0124, B:86:0x0128, B:89:0x0130, B:92:0x0135, B:94:0x013f, B:96:0x0143, B:99:0x014e, B:102:0x0158, B:104:0x015c, B:107:0x0164, B:110:0x0169, B:112:0x0173, B:114:0x0177, B:117:0x0183, B:120:0x018e, B:122:0x0192, B:125:0x019a, B:128:0x019f, B:130:0x01a9, B:132:0x01ad, B:133:0x01b6, B:134:0x01bc, B:136:0x01c0, B:139:0x01c8, B:142:0x01cd, B:144:0x01d7, B:146:0x01db, B:148:0x01e5, B:150:0x01ee, B:153:0x01f9, B:155:0x01fd, B:158:0x0208, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:187:0x0297, B:189:0x02a4, B:191:0x02ac, B:193:0x02b6, B:195:0x02be, B:197:0x02c2, B:199:0x02c6, B:201:0x02d1, B:203:0x02d7, B:204:0x02e5, B:176:0x026e, B:177:0x0271, B:179:0x0279, B:184:0x028d, B:185:0x0290, B:181:0x0281, B:183:0x0285, B:161:0x0228, B:40:0x007c), top: B:218:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:221:0x024f A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:230:0x018c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x00f0 A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:29:0x0055, B:32:0x005c, B:34:0x0068, B:43:0x0083, B:45:0x0094, B:46:0x00a4, B:48:0x00aa, B:50:0x00bc, B:53:0x00c4, B:56:0x00c9, B:58:0x00d3, B:60:0x00d7, B:63:0x00e6, B:66:0x00f0, B:68:0x00f4, B:71:0x00fc, B:74:0x0101, B:76:0x010b, B:78:0x010f, B:81:0x011a, B:84:0x0124, B:86:0x0128, B:89:0x0130, B:92:0x0135, B:94:0x013f, B:96:0x0143, B:99:0x014e, B:102:0x0158, B:104:0x015c, B:107:0x0164, B:110:0x0169, B:112:0x0173, B:114:0x0177, B:117:0x0183, B:120:0x018e, B:122:0x0192, B:125:0x019a, B:128:0x019f, B:130:0x01a9, B:132:0x01ad, B:133:0x01b6, B:134:0x01bc, B:136:0x01c0, B:139:0x01c8, B:142:0x01cd, B:144:0x01d7, B:146:0x01db, B:148:0x01e5, B:150:0x01ee, B:153:0x01f9, B:155:0x01fd, B:158:0x0208, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:187:0x0297, B:189:0x02a4, B:191:0x02ac, B:193:0x02b6, B:195:0x02be, B:197:0x02c2, B:199:0x02c6, B:201:0x02d1, B:203:0x02d7, B:204:0x02e5, B:176:0x026e, B:177:0x0271, B:179:0x0279, B:184:0x028d, B:185:0x0290, B:181:0x0281, B:183:0x0285, B:161:0x0228, B:40:0x007c), top: B:218:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x00f4 A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:29:0x0055, B:32:0x005c, B:34:0x0068, B:43:0x0083, B:45:0x0094, B:46:0x00a4, B:48:0x00aa, B:50:0x00bc, B:53:0x00c4, B:56:0x00c9, B:58:0x00d3, B:60:0x00d7, B:63:0x00e6, B:66:0x00f0, B:68:0x00f4, B:71:0x00fc, B:74:0x0101, B:76:0x010b, B:78:0x010f, B:81:0x011a, B:84:0x0124, B:86:0x0128, B:89:0x0130, B:92:0x0135, B:94:0x013f, B:96:0x0143, B:99:0x014e, B:102:0x0158, B:104:0x015c, B:107:0x0164, B:110:0x0169, B:112:0x0173, B:114:0x0177, B:117:0x0183, B:120:0x018e, B:122:0x0192, B:125:0x019a, B:128:0x019f, B:130:0x01a9, B:132:0x01ad, B:133:0x01b6, B:134:0x01bc, B:136:0x01c0, B:139:0x01c8, B:142:0x01cd, B:144:0x01d7, B:146:0x01db, B:148:0x01e5, B:150:0x01ee, B:153:0x01f9, B:155:0x01fd, B:158:0x0208, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:187:0x0297, B:189:0x02a4, B:191:0x02ac, B:193:0x02b6, B:195:0x02be, B:197:0x02c2, B:199:0x02c6, B:201:0x02d1, B:203:0x02d7, B:204:0x02e5, B:176:0x026e, B:177:0x0271, B:179:0x0279, B:184:0x028d, B:185:0x0290, B:181:0x0281, B:183:0x0285, B:161:0x0228, B:40:0x007c), top: B:218:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x0124 A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:29:0x0055, B:32:0x005c, B:34:0x0068, B:43:0x0083, B:45:0x0094, B:46:0x00a4, B:48:0x00aa, B:50:0x00bc, B:53:0x00c4, B:56:0x00c9, B:58:0x00d3, B:60:0x00d7, B:63:0x00e6, B:66:0x00f0, B:68:0x00f4, B:71:0x00fc, B:74:0x0101, B:76:0x010b, B:78:0x010f, B:81:0x011a, B:84:0x0124, B:86:0x0128, B:89:0x0130, B:92:0x0135, B:94:0x013f, B:96:0x0143, B:99:0x014e, B:102:0x0158, B:104:0x015c, B:107:0x0164, B:110:0x0169, B:112:0x0173, B:114:0x0177, B:117:0x0183, B:120:0x018e, B:122:0x0192, B:125:0x019a, B:128:0x019f, B:130:0x01a9, B:132:0x01ad, B:133:0x01b6, B:134:0x01bc, B:136:0x01c0, B:139:0x01c8, B:142:0x01cd, B:144:0x01d7, B:146:0x01db, B:148:0x01e5, B:150:0x01ee, B:153:0x01f9, B:155:0x01fd, B:158:0x0208, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:187:0x0297, B:189:0x02a4, B:191:0x02ac, B:193:0x02b6, B:195:0x02be, B:197:0x02c2, B:199:0x02c6, B:201:0x02d1, B:203:0x02d7, B:204:0x02e5, B:176:0x026e, B:177:0x0271, B:179:0x0279, B:184:0x028d, B:185:0x0290, B:181:0x0281, B:183:0x0285, B:161:0x0228, B:40:0x007c), top: B:218:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0128 A[Catch: all -> 0x0059, TryCatch #1 {all -> 0x0059, blocks: (B:29:0x0055, B:32:0x005c, B:34:0x0068, B:43:0x0083, B:45:0x0094, B:46:0x00a4, B:48:0x00aa, B:50:0x00bc, B:53:0x00c4, B:56:0x00c9, B:58:0x00d3, B:60:0x00d7, B:63:0x00e6, B:66:0x00f0, B:68:0x00f4, B:71:0x00fc, B:74:0x0101, B:76:0x010b, B:78:0x010f, B:81:0x011a, B:84:0x0124, B:86:0x0128, B:89:0x0130, B:92:0x0135, B:94:0x013f, B:96:0x0143, B:99:0x014e, B:102:0x0158, B:104:0x015c, B:107:0x0164, B:110:0x0169, B:112:0x0173, B:114:0x0177, B:117:0x0183, B:120:0x018e, B:122:0x0192, B:125:0x019a, B:128:0x019f, B:130:0x01a9, B:132:0x01ad, B:133:0x01b6, B:134:0x01bc, B:136:0x01c0, B:139:0x01c8, B:142:0x01cd, B:144:0x01d7, B:146:0x01db, B:148:0x01e5, B:150:0x01ee, B:153:0x01f9, B:155:0x01fd, B:158:0x0208, B:163:0x023d, B:166:0x024f, B:168:0x0255, B:170:0x025a, B:171:0x025d, B:173:0x0265, B:174:0x0268, B:187:0x0297, B:189:0x02a4, B:191:0x02ac, B:193:0x02b6, B:195:0x02be, B:197:0x02c2, B:199:0x02c6, B:201:0x02d1, B:203:0x02d7, B:204:0x02e5, B:176:0x026e, B:177:0x0271, B:179:0x0279, B:184:0x028d, B:185:0x0290, B:181:0x0281, B:183:0x0285, B:161:0x0228, B:40:0x007c), top: B:218:0x0055 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v7, types: [boolean] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void q(o0 o0Var, Object obj, Object obj2, Type type, int i11, boolean z11) throws IOException {
        Map<String, Object> treeMap;
        boolean z12;
        List<c1> list;
        List<b1> list2;
        List<b1> list3;
        List<x0> list4;
        List<x0> list5;
        String str;
        String str2;
        boolean z13;
        Object objP;
        Object obj3;
        ?? r11;
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        z0 z0VarX;
        Type type2;
        obj = obj;
        j1 j1Var = o0Var.f71701k;
        if (obj == null) {
            j1Var.g0();
            return;
        }
        Map<String, Object> innerMap = (Map) obj;
        int i12 = SerializerFeature.MapSortField.mask;
        if ((j1Var.f71674c & i12) == 0 && (i12 & i11) == 0) {
            treeMap = innerMap;
        } else {
            if (innerMap instanceof JSONObject) {
                innerMap = ((JSONObject) innerMap).getInnerMap();
            }
            if ((innerMap instanceof SortedMap) || (innerMap instanceof LinkedHashMap)) {
                treeMap = innerMap;
            } else {
                try {
                    treeMap = new TreeMap(innerMap);
                } catch (Exception unused) {
                    treeMap = innerMap;
                }
            }
        }
        if (o0Var.r(obj)) {
            o0Var.K(obj);
            return;
        }
        e1 e1Var = o0Var.f71708r;
        o0Var.D(e1Var, obj, obj2, 0);
        if (!z11) {
            try {
                j1Var.write(123);
            } catch (Throwable th2) {
                o0Var.f71708r = e1Var;
                throw th2;
            }
        }
        o0Var.z();
        if (j1Var.k(SerializerFeature.WriteClassName)) {
            String str3 = o0Var.f71700j.f71637c;
            Class<?> cls4 = treeMap.getClass();
            if ((cls4 == JSONObject.class || cls4 == HashMap.class || cls4 == LinkedHashMap.class) && treeMap.containsKey(str3)) {
                z12 = true;
            } else {
                j1Var.q(str3);
                j1Var.j0(obj.getClass().getName());
                z12 = false;
            }
        } else {
            z12 = true;
        }
        boolean z14 = z12;
        Class<?> cls5 = null;
        z0 z0Var = null;
        for (Map.Entry<String, Object> entry : treeMap.entrySet()) {
            Object value = entry.getValue();
            String key = entry.getKey();
            List<c1> list6 = o0Var.f71656f;
            if (list6 == null || list6.size() <= 0) {
                list = this.f71656f;
                if (list != null || list.size() <= 0) {
                    list2 = o0Var.f71653c;
                    if (list2 != null || list2.size() <= 0) {
                        list3 = this.f71653c;
                        if (list3 != null && list3.size() > 0) {
                            if (key != null || (key instanceof String)) {
                                if (!e(o0Var, obj, key, value)) {
                                    cls5 = cls5;
                                    obj = obj;
                                    cls5 = cls5;
                                }
                            } else if ((key.getClass().isPrimitive() || (key instanceof Number)) && !e(o0Var, obj, com.alibaba.fastjson.a.toJSONString(key), value)) {
                                cls5 = cls5;
                                obj = obj;
                                cls5 = cls5;
                            }
                        }
                        list4 = o0Var.f71655e;
                        if (list4 != null && list4.size() > 0) {
                            if (key != null || (key instanceof String)) {
                                key = o(o0Var, obj, key, value);
                            } else if (key.getClass().isPrimitive() || (key instanceof Number)) {
                                key = o(o0Var, obj, com.alibaba.fastjson.a.toJSONString(key), value);
                            }
                        }
                        list5 = this.f71655e;
                        if (list5 != null && list5.size() > 0) {
                            if (key != null || (key instanceof String)) {
                                key = o(o0Var, obj, key, value);
                            } else if (key.getClass().isPrimitive() || (key instanceof Number)) {
                                key = o(o0Var, obj, com.alibaba.fastjson.a.toJSONString(key), value);
                            }
                        }
                        str = key;
                        if (str != null || (str instanceof String)) {
                            str2 = str;
                            z13 = true;
                            objP = p(o0Var, null, obj, str2, value, i11);
                        } else {
                            if ((str instanceof Map) || (str instanceof Collection)) {
                                str2 = str;
                                cls5 = cls5;
                                r11 = 1;
                                obj3 = value;
                            } else {
                                str2 = str;
                                z13 = true;
                                objP = p(o0Var, null, obj, com.alibaba.fastjson.a.toJSONString(str), value, i11);
                            }
                            if (obj3 == null || SerializerFeature.isEnabled(j1Var.f71674c, i11, SerializerFeature.WriteMapNullValue)) {
                                if (str2 instanceof String) {
                                    String str4 = str2;
                                    if (!z14) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.k(SerializerFeature.PrettyFormat)) {
                                        o0Var.C();
                                    }
                                    j1Var.r(str4, r11);
                                } else {
                                    if (!z14) {
                                        j1Var.write(44);
                                    }
                                    if ((!j1Var.j(f71759k) || SerializerFeature.isEnabled(i11, SerializerFeature.WriteNonStringKeyAsString)) && !(str2 instanceof Enum)) {
                                        o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                    } else {
                                        o0Var.H(str2);
                                    }
                                    j1Var.write(58);
                                }
                                if (obj3 == null) {
                                    j1Var.g0();
                                    cls5 = cls5;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        cls3 = cls;
                                        z0VarX = o0Var.x(cls);
                                    } else {
                                        cls3 = cls2;
                                        z0VarX = z0Var;
                                    }
                                    if (SerializerFeature.isEnabled(i11, SerializerFeature.WriteClassName) || !(z0VarX instanceof p0)) {
                                        z0Var = z0VarX;
                                        z0Var.d(o0Var, obj3, str2, null, i11);
                                    } else {
                                        if (type instanceof ParameterizedType) {
                                            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                                            if (actualTypeArguments.length == 2) {
                                                type2 = actualTypeArguments[r11];
                                            } else {
                                                type2 = null;
                                            }
                                        } else {
                                            type2 = null;
                                        }
                                        z0Var = z0VarX;
                                        ((p0) z0VarX).E(o0Var, obj3, str2, type2, i11);
                                    }
                                    cls5 = cls3;
                                }
                                z14 = false;
                            } else {
                                obj = obj;
                                cls5 = cls5;
                            }
                        }
                        obj3 = objP;
                        r11 = z13;
                        if (obj3 == null) {
                        }
                        if (str2 instanceof String) {
                            String str5 = str2;
                            if (!z14) {
                                j1Var.write(44);
                            }
                            if (j1Var.k(SerializerFeature.PrettyFormat)) {
                                o0Var.C();
                            }
                            j1Var.r(str5, r11);
                        } else {
                            if (!z14) {
                                j1Var.write(44);
                            }
                            if (j1Var.j(f71759k)) {
                                o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                            } else {
                                o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                            }
                            j1Var.write(58);
                        }
                        if (obj3 == null) {
                            j1Var.g0();
                            cls5 = cls5;
                        } else {
                            cls = obj3.getClass();
                            cls2 = cls5;
                            if (cls != cls2) {
                                cls3 = cls;
                                z0VarX = o0Var.x(cls);
                            } else {
                                cls3 = cls2;
                                z0VarX = z0Var;
                            }
                            if (SerializerFeature.isEnabled(i11, SerializerFeature.WriteClassName)) {
                                z0Var = z0VarX;
                                z0Var.d(o0Var, obj3, str2, null, i11);
                            } else {
                                z0Var = z0VarX;
                                z0Var.d(o0Var, obj3, str2, null, i11);
                            }
                            cls5 = cls3;
                        }
                        z14 = false;
                    } else {
                        if (key == null || (key instanceof String)) {
                            if (e(o0Var, obj, key, value)) {
                                list3 = this.f71653c;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!e(o0Var, obj, key, value)) {
                                        }
                                    } else if (!e(o0Var, obj, key, value)) {
                                    }
                                }
                                list4 = o0Var.f71655e;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = o(o0Var, obj, key, value);
                                    } else {
                                        key = o(o0Var, obj, key, value);
                                    }
                                }
                                list5 = this.f71655e;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = o(o0Var, obj, key, value);
                                    } else {
                                        key = o(o0Var, obj, key, value);
                                    }
                                }
                                str = key;
                                if (str != null) {
                                    str2 = str;
                                    z13 = true;
                                    objP = p(o0Var, null, obj, str2, value, i11);
                                    obj3 = objP;
                                    r11 = z13;
                                } else {
                                    str2 = str;
                                    z13 = true;
                                    objP = p(o0Var, null, obj, str2, value, i11);
                                    obj3 = objP;
                                    r11 = z13;
                                }
                                if (obj3 == null) {
                                }
                                if (str2 instanceof String) {
                                    String str6 = str2;
                                    if (!z14) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.k(SerializerFeature.PrettyFormat)) {
                                        o0Var.C();
                                    }
                                    j1Var.r(str6, r11);
                                } else {
                                    if (!z14) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.j(f71759k)) {
                                        o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                    } else {
                                        o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                    }
                                    j1Var.write(58);
                                }
                                if (obj3 == null) {
                                    j1Var.g0();
                                    cls5 = cls5;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        cls3 = cls;
                                        z0VarX = o0Var.x(cls);
                                    } else {
                                        cls3 = cls2;
                                        z0VarX = z0Var;
                                    }
                                    if (SerializerFeature.isEnabled(i11, SerializerFeature.WriteClassName)) {
                                        z0Var = z0VarX;
                                        z0Var.d(o0Var, obj3, str2, null, i11);
                                    } else {
                                        z0Var = z0VarX;
                                        z0Var.d(o0Var, obj3, str2, null, i11);
                                    }
                                    cls5 = cls3;
                                }
                                z14 = false;
                            }
                        } else if ((!key.getClass().isPrimitive() && !(key instanceof Number)) || e(o0Var, obj, com.alibaba.fastjson.a.toJSONString(key), value)) {
                            list3 = this.f71653c;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!e(o0Var, obj, key, value)) {
                                    }
                                } else if (!e(o0Var, obj, key, value)) {
                                }
                            }
                            list4 = o0Var.f71655e;
                            if (list4 != null) {
                                if (key != null) {
                                    key = o(o0Var, obj, key, value);
                                } else {
                                    key = o(o0Var, obj, key, value);
                                }
                            }
                            list5 = this.f71655e;
                            if (list5 != null) {
                                if (key != null) {
                                    key = o(o0Var, obj, key, value);
                                } else {
                                    key = o(o0Var, obj, key, value);
                                }
                            }
                            str = key;
                            if (str != null) {
                                str2 = str;
                                z13 = true;
                                objP = p(o0Var, null, obj, str2, value, i11);
                                obj3 = objP;
                                r11 = z13;
                            } else {
                                str2 = str;
                                z13 = true;
                                objP = p(o0Var, null, obj, str2, value, i11);
                                obj3 = objP;
                                r11 = z13;
                            }
                            if (obj3 == null) {
                            }
                            if (str2 instanceof String) {
                                String str7 = str2;
                                if (!z14) {
                                    j1Var.write(44);
                                }
                                if (j1Var.k(SerializerFeature.PrettyFormat)) {
                                    o0Var.C();
                                }
                                j1Var.r(str7, r11);
                            } else {
                                if (!z14) {
                                    j1Var.write(44);
                                }
                                if (j1Var.j(f71759k)) {
                                    o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                } else {
                                    o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                }
                                j1Var.write(58);
                            }
                            if (obj3 == null) {
                                j1Var.g0();
                                cls5 = cls5;
                            } else {
                                cls = obj3.getClass();
                                cls2 = cls5;
                                if (cls != cls2) {
                                    cls3 = cls;
                                    z0VarX = o0Var.x(cls);
                                } else {
                                    cls3 = cls2;
                                    z0VarX = z0Var;
                                }
                                if (SerializerFeature.isEnabled(i11, SerializerFeature.WriteClassName)) {
                                    z0Var = z0VarX;
                                    z0Var.d(o0Var, obj3, str2, null, i11);
                                } else {
                                    z0Var = z0VarX;
                                    z0Var.d(o0Var, obj3, str2, null, i11);
                                }
                                cls5 = cls3;
                            }
                            z14 = false;
                        }
                        cls5 = cls5;
                        obj = obj;
                        cls5 = cls5;
                    }
                } else {
                    if (key == null || (key instanceof String)) {
                        if (f(o0Var, obj, key)) {
                            list2 = o0Var.f71653c;
                            if (list2 != null) {
                                list3 = this.f71653c;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!e(o0Var, obj, key, value)) {
                                        }
                                    } else if (!e(o0Var, obj, key, value)) {
                                    }
                                }
                                list4 = o0Var.f71655e;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = o(o0Var, obj, key, value);
                                    } else {
                                        key = o(o0Var, obj, key, value);
                                    }
                                }
                                list5 = this.f71655e;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = o(o0Var, obj, key, value);
                                    } else {
                                        key = o(o0Var, obj, key, value);
                                    }
                                }
                                str = key;
                                if (str != null) {
                                    str2 = str;
                                    z13 = true;
                                    objP = p(o0Var, null, obj, str2, value, i11);
                                    obj3 = objP;
                                    r11 = z13;
                                } else {
                                    str2 = str;
                                    z13 = true;
                                    objP = p(o0Var, null, obj, str2, value, i11);
                                    obj3 = objP;
                                    r11 = z13;
                                }
                                if (obj3 == null) {
                                }
                                if (str2 instanceof String) {
                                    String str8 = str2;
                                    if (!z14) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.k(SerializerFeature.PrettyFormat)) {
                                        o0Var.C();
                                    }
                                    j1Var.r(str8, r11);
                                } else {
                                    if (!z14) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.j(f71759k)) {
                                        o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                    } else {
                                        o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                    }
                                    j1Var.write(58);
                                }
                                if (obj3 == null) {
                                    j1Var.g0();
                                    cls5 = cls5;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        cls3 = cls;
                                        z0VarX = o0Var.x(cls);
                                    } else {
                                        cls3 = cls2;
                                        z0VarX = z0Var;
                                    }
                                    if (SerializerFeature.isEnabled(i11, SerializerFeature.WriteClassName)) {
                                        z0Var = z0VarX;
                                        z0Var.d(o0Var, obj3, str2, null, i11);
                                    } else {
                                        z0Var = z0VarX;
                                        z0Var.d(o0Var, obj3, str2, null, i11);
                                    }
                                    cls5 = cls3;
                                }
                                z14 = false;
                            } else {
                                list3 = this.f71653c;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!e(o0Var, obj, key, value)) {
                                        }
                                    } else if (!e(o0Var, obj, key, value)) {
                                    }
                                }
                                list4 = o0Var.f71655e;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = o(o0Var, obj, key, value);
                                    } else {
                                        key = o(o0Var, obj, key, value);
                                    }
                                }
                                list5 = this.f71655e;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = o(o0Var, obj, key, value);
                                    } else {
                                        key = o(o0Var, obj, key, value);
                                    }
                                }
                                str = key;
                                if (str != null) {
                                    str2 = str;
                                    z13 = true;
                                    objP = p(o0Var, null, obj, str2, value, i11);
                                    obj3 = objP;
                                    r11 = z13;
                                } else {
                                    str2 = str;
                                    z13 = true;
                                    objP = p(o0Var, null, obj, str2, value, i11);
                                    obj3 = objP;
                                    r11 = z13;
                                }
                                if (obj3 == null) {
                                }
                                if (str2 instanceof String) {
                                    String str9 = str2;
                                    if (!z14) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.k(SerializerFeature.PrettyFormat)) {
                                        o0Var.C();
                                    }
                                    j1Var.r(str9, r11);
                                } else {
                                    if (!z14) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.j(f71759k)) {
                                        o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                    } else {
                                        o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                    }
                                    j1Var.write(58);
                                }
                                if (obj3 == null) {
                                    j1Var.g0();
                                    cls5 = cls5;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        cls3 = cls;
                                        z0VarX = o0Var.x(cls);
                                    } else {
                                        cls3 = cls2;
                                        z0VarX = z0Var;
                                    }
                                    if (SerializerFeature.isEnabled(i11, SerializerFeature.WriteClassName)) {
                                        z0Var = z0VarX;
                                        z0Var.d(o0Var, obj3, str2, null, i11);
                                    } else {
                                        z0Var = z0VarX;
                                        z0Var.d(o0Var, obj3, str2, null, i11);
                                    }
                                    cls5 = cls3;
                                }
                                z14 = false;
                            }
                        }
                    } else if ((!key.getClass().isPrimitive() && !(key instanceof Number)) || f(o0Var, obj, com.alibaba.fastjson.a.toJSONString(key))) {
                        list2 = o0Var.f71653c;
                        if (list2 != null) {
                            list3 = this.f71653c;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!e(o0Var, obj, key, value)) {
                                    }
                                } else if (!e(o0Var, obj, key, value)) {
                                }
                            }
                            list4 = o0Var.f71655e;
                            if (list4 != null) {
                                if (key != null) {
                                    key = o(o0Var, obj, key, value);
                                } else {
                                    key = o(o0Var, obj, key, value);
                                }
                            }
                            list5 = this.f71655e;
                            if (list5 != null) {
                                if (key != null) {
                                    key = o(o0Var, obj, key, value);
                                } else {
                                    key = o(o0Var, obj, key, value);
                                }
                            }
                            str = key;
                            if (str != null) {
                                str2 = str;
                                z13 = true;
                                objP = p(o0Var, null, obj, str2, value, i11);
                                obj3 = objP;
                                r11 = z13;
                            } else {
                                str2 = str;
                                z13 = true;
                                objP = p(o0Var, null, obj, str2, value, i11);
                                obj3 = objP;
                                r11 = z13;
                            }
                            if (obj3 == null) {
                            }
                            if (str2 instanceof String) {
                                String str10 = str2;
                                if (!z14) {
                                    j1Var.write(44);
                                }
                                if (j1Var.k(SerializerFeature.PrettyFormat)) {
                                    o0Var.C();
                                }
                                j1Var.r(str10, r11);
                            } else {
                                if (!z14) {
                                    j1Var.write(44);
                                }
                                if (j1Var.j(f71759k)) {
                                    o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                } else {
                                    o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                }
                                j1Var.write(58);
                            }
                            if (obj3 == null) {
                                j1Var.g0();
                                cls5 = cls5;
                            } else {
                                cls = obj3.getClass();
                                cls2 = cls5;
                                if (cls != cls2) {
                                    cls3 = cls;
                                    z0VarX = o0Var.x(cls);
                                } else {
                                    cls3 = cls2;
                                    z0VarX = z0Var;
                                }
                                if (SerializerFeature.isEnabled(i11, SerializerFeature.WriteClassName)) {
                                    z0Var = z0VarX;
                                    z0Var.d(o0Var, obj3, str2, null, i11);
                                } else {
                                    z0Var = z0VarX;
                                    z0Var.d(o0Var, obj3, str2, null, i11);
                                }
                                cls5 = cls3;
                            }
                            z14 = false;
                        } else {
                            list3 = this.f71653c;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!e(o0Var, obj, key, value)) {
                                    }
                                } else if (!e(o0Var, obj, key, value)) {
                                }
                            }
                            list4 = o0Var.f71655e;
                            if (list4 != null) {
                                if (key != null) {
                                    key = o(o0Var, obj, key, value);
                                } else {
                                    key = o(o0Var, obj, key, value);
                                }
                            }
                            list5 = this.f71655e;
                            if (list5 != null) {
                                if (key != null) {
                                    key = o(o0Var, obj, key, value);
                                } else {
                                    key = o(o0Var, obj, key, value);
                                }
                            }
                            str = key;
                            if (str != null) {
                                str2 = str;
                                z13 = true;
                                objP = p(o0Var, null, obj, str2, value, i11);
                                obj3 = objP;
                                r11 = z13;
                            } else {
                                str2 = str;
                                z13 = true;
                                objP = p(o0Var, null, obj, str2, value, i11);
                                obj3 = objP;
                                r11 = z13;
                            }
                            if (obj3 == null) {
                            }
                            if (str2 instanceof String) {
                                String str11 = str2;
                                if (!z14) {
                                    j1Var.write(44);
                                }
                                if (j1Var.k(SerializerFeature.PrettyFormat)) {
                                    o0Var.C();
                                }
                                j1Var.r(str11, r11);
                            } else {
                                if (!z14) {
                                    j1Var.write(44);
                                }
                                if (j1Var.j(f71759k)) {
                                    o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                } else {
                                    o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                }
                                j1Var.write(58);
                            }
                            if (obj3 == null) {
                                j1Var.g0();
                                cls5 = cls5;
                            } else {
                                cls = obj3.getClass();
                                cls2 = cls5;
                                if (cls != cls2) {
                                    cls3 = cls;
                                    z0VarX = o0Var.x(cls);
                                } else {
                                    cls3 = cls2;
                                    z0VarX = z0Var;
                                }
                                if (SerializerFeature.isEnabled(i11, SerializerFeature.WriteClassName)) {
                                    z0Var = z0VarX;
                                    z0Var.d(o0Var, obj3, str2, null, i11);
                                } else {
                                    z0Var = z0VarX;
                                    z0Var.d(o0Var, obj3, str2, null, i11);
                                }
                                cls5 = cls3;
                            }
                            z14 = false;
                        }
                    }
                    cls5 = cls5;
                    obj = obj;
                    cls5 = cls5;
                }
            } else {
                if (key == null || (key instanceof String)) {
                    if (f(o0Var, obj, key)) {
                        list = this.f71656f;
                        if (list != null) {
                            list2 = o0Var.f71653c;
                            if (list2 != null) {
                                list3 = this.f71653c;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!e(o0Var, obj, key, value)) {
                                        }
                                    } else if (!e(o0Var, obj, key, value)) {
                                    }
                                }
                                list4 = o0Var.f71655e;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = o(o0Var, obj, key, value);
                                    } else {
                                        key = o(o0Var, obj, key, value);
                                    }
                                }
                                list5 = this.f71655e;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = o(o0Var, obj, key, value);
                                    } else {
                                        key = o(o0Var, obj, key, value);
                                    }
                                }
                                str = key;
                                if (str != null) {
                                    str2 = str;
                                    z13 = true;
                                    objP = p(o0Var, null, obj, str2, value, i11);
                                    obj3 = objP;
                                    r11 = z13;
                                } else {
                                    str2 = str;
                                    z13 = true;
                                    objP = p(o0Var, null, obj, str2, value, i11);
                                    obj3 = objP;
                                    r11 = z13;
                                }
                                if (obj3 == null) {
                                }
                                if (str2 instanceof String) {
                                    String str12 = str2;
                                    if (!z14) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.k(SerializerFeature.PrettyFormat)) {
                                        o0Var.C();
                                    }
                                    j1Var.r(str12, r11);
                                } else {
                                    if (!z14) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.j(f71759k)) {
                                        o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                    } else {
                                        o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                    }
                                    j1Var.write(58);
                                }
                                if (obj3 == null) {
                                    j1Var.g0();
                                    cls5 = cls5;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        cls3 = cls;
                                        z0VarX = o0Var.x(cls);
                                    } else {
                                        cls3 = cls2;
                                        z0VarX = z0Var;
                                    }
                                    if (SerializerFeature.isEnabled(i11, SerializerFeature.WriteClassName)) {
                                        z0Var = z0VarX;
                                        z0Var.d(o0Var, obj3, str2, null, i11);
                                    } else {
                                        z0Var = z0VarX;
                                        z0Var.d(o0Var, obj3, str2, null, i11);
                                    }
                                    cls5 = cls3;
                                }
                                z14 = false;
                            } else {
                                list3 = this.f71653c;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!e(o0Var, obj, key, value)) {
                                        }
                                    } else if (!e(o0Var, obj, key, value)) {
                                    }
                                }
                                list4 = o0Var.f71655e;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = o(o0Var, obj, key, value);
                                    } else {
                                        key = o(o0Var, obj, key, value);
                                    }
                                }
                                list5 = this.f71655e;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = o(o0Var, obj, key, value);
                                    } else {
                                        key = o(o0Var, obj, key, value);
                                    }
                                }
                                str = key;
                                if (str != null) {
                                    str2 = str;
                                    z13 = true;
                                    objP = p(o0Var, null, obj, str2, value, i11);
                                    obj3 = objP;
                                    r11 = z13;
                                } else {
                                    str2 = str;
                                    z13 = true;
                                    objP = p(o0Var, null, obj, str2, value, i11);
                                    obj3 = objP;
                                    r11 = z13;
                                }
                                if (obj3 == null) {
                                }
                                if (str2 instanceof String) {
                                    String str13 = str2;
                                    if (!z14) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.k(SerializerFeature.PrettyFormat)) {
                                        o0Var.C();
                                    }
                                    j1Var.r(str13, r11);
                                } else {
                                    if (!z14) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.j(f71759k)) {
                                        o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                    } else {
                                        o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                    }
                                    j1Var.write(58);
                                }
                                if (obj3 == null) {
                                    j1Var.g0();
                                    cls5 = cls5;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        cls3 = cls;
                                        z0VarX = o0Var.x(cls);
                                    } else {
                                        cls3 = cls2;
                                        z0VarX = z0Var;
                                    }
                                    if (SerializerFeature.isEnabled(i11, SerializerFeature.WriteClassName)) {
                                        z0Var = z0VarX;
                                        z0Var.d(o0Var, obj3, str2, null, i11);
                                    } else {
                                        z0Var = z0VarX;
                                        z0Var.d(o0Var, obj3, str2, null, i11);
                                    }
                                    cls5 = cls3;
                                }
                                z14 = false;
                            }
                        } else {
                            list2 = o0Var.f71653c;
                            if (list2 != null) {
                                list3 = this.f71653c;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!e(o0Var, obj, key, value)) {
                                        }
                                    } else if (!e(o0Var, obj, key, value)) {
                                    }
                                }
                                list4 = o0Var.f71655e;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = o(o0Var, obj, key, value);
                                    } else {
                                        key = o(o0Var, obj, key, value);
                                    }
                                }
                                list5 = this.f71655e;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = o(o0Var, obj, key, value);
                                    } else {
                                        key = o(o0Var, obj, key, value);
                                    }
                                }
                                str = key;
                                if (str != null) {
                                    str2 = str;
                                    z13 = true;
                                    objP = p(o0Var, null, obj, str2, value, i11);
                                    obj3 = objP;
                                    r11 = z13;
                                } else {
                                    str2 = str;
                                    z13 = true;
                                    objP = p(o0Var, null, obj, str2, value, i11);
                                    obj3 = objP;
                                    r11 = z13;
                                }
                                if (obj3 == null) {
                                }
                                if (str2 instanceof String) {
                                    String str14 = str2;
                                    if (!z14) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.k(SerializerFeature.PrettyFormat)) {
                                        o0Var.C();
                                    }
                                    j1Var.r(str14, r11);
                                } else {
                                    if (!z14) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.j(f71759k)) {
                                        o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                    } else {
                                        o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                    }
                                    j1Var.write(58);
                                }
                                if (obj3 == null) {
                                    j1Var.g0();
                                    cls5 = cls5;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        cls3 = cls;
                                        z0VarX = o0Var.x(cls);
                                    } else {
                                        cls3 = cls2;
                                        z0VarX = z0Var;
                                    }
                                    if (SerializerFeature.isEnabled(i11, SerializerFeature.WriteClassName)) {
                                        z0Var = z0VarX;
                                        z0Var.d(o0Var, obj3, str2, null, i11);
                                    } else {
                                        z0Var = z0VarX;
                                        z0Var.d(o0Var, obj3, str2, null, i11);
                                    }
                                    cls5 = cls3;
                                }
                                z14 = false;
                            } else {
                                list3 = this.f71653c;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!e(o0Var, obj, key, value)) {
                                        }
                                    } else if (!e(o0Var, obj, key, value)) {
                                    }
                                }
                                list4 = o0Var.f71655e;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = o(o0Var, obj, key, value);
                                    } else {
                                        key = o(o0Var, obj, key, value);
                                    }
                                }
                                list5 = this.f71655e;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = o(o0Var, obj, key, value);
                                    } else {
                                        key = o(o0Var, obj, key, value);
                                    }
                                }
                                str = key;
                                if (str != null) {
                                    str2 = str;
                                    z13 = true;
                                    objP = p(o0Var, null, obj, str2, value, i11);
                                    obj3 = objP;
                                    r11 = z13;
                                } else {
                                    str2 = str;
                                    z13 = true;
                                    objP = p(o0Var, null, obj, str2, value, i11);
                                    obj3 = objP;
                                    r11 = z13;
                                }
                                if (obj3 == null) {
                                }
                                if (str2 instanceof String) {
                                    String str15 = str2;
                                    if (!z14) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.k(SerializerFeature.PrettyFormat)) {
                                        o0Var.C();
                                    }
                                    j1Var.r(str15, r11);
                                } else {
                                    if (!z14) {
                                        j1Var.write(44);
                                    }
                                    if (j1Var.j(f71759k)) {
                                        o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                    } else {
                                        o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                    }
                                    j1Var.write(58);
                                }
                                if (obj3 == null) {
                                    j1Var.g0();
                                    cls5 = cls5;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        cls3 = cls;
                                        z0VarX = o0Var.x(cls);
                                    } else {
                                        cls3 = cls2;
                                        z0VarX = z0Var;
                                    }
                                    if (SerializerFeature.isEnabled(i11, SerializerFeature.WriteClassName)) {
                                        z0Var = z0VarX;
                                        z0Var.d(o0Var, obj3, str2, null, i11);
                                    } else {
                                        z0Var = z0VarX;
                                        z0Var.d(o0Var, obj3, str2, null, i11);
                                    }
                                    cls5 = cls3;
                                }
                                z14 = false;
                            }
                        }
                    }
                } else if ((!key.getClass().isPrimitive() && !(key instanceof Number)) || f(o0Var, obj, com.alibaba.fastjson.a.toJSONString(key))) {
                    list = this.f71656f;
                    if (list != null) {
                        list2 = o0Var.f71653c;
                        if (list2 != null) {
                            list3 = this.f71653c;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!e(o0Var, obj, key, value)) {
                                    }
                                } else if (!e(o0Var, obj, key, value)) {
                                }
                            }
                            list4 = o0Var.f71655e;
                            if (list4 != null) {
                                if (key != null) {
                                    key = o(o0Var, obj, key, value);
                                } else {
                                    key = o(o0Var, obj, key, value);
                                }
                            }
                            list5 = this.f71655e;
                            if (list5 != null) {
                                if (key != null) {
                                    key = o(o0Var, obj, key, value);
                                } else {
                                    key = o(o0Var, obj, key, value);
                                }
                            }
                            str = key;
                            if (str != null) {
                                str2 = str;
                                z13 = true;
                                objP = p(o0Var, null, obj, str2, value, i11);
                                obj3 = objP;
                                r11 = z13;
                            } else {
                                str2 = str;
                                z13 = true;
                                objP = p(o0Var, null, obj, str2, value, i11);
                                obj3 = objP;
                                r11 = z13;
                            }
                            if (obj3 == null) {
                            }
                            if (str2 instanceof String) {
                                String str16 = str2;
                                if (!z14) {
                                    j1Var.write(44);
                                }
                                if (j1Var.k(SerializerFeature.PrettyFormat)) {
                                    o0Var.C();
                                }
                                j1Var.r(str16, r11);
                            } else {
                                if (!z14) {
                                    j1Var.write(44);
                                }
                                if (j1Var.j(f71759k)) {
                                    o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                } else {
                                    o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                }
                                j1Var.write(58);
                            }
                            if (obj3 == null) {
                                j1Var.g0();
                                cls5 = cls5;
                            } else {
                                cls = obj3.getClass();
                                cls2 = cls5;
                                if (cls != cls2) {
                                    cls3 = cls;
                                    z0VarX = o0Var.x(cls);
                                } else {
                                    cls3 = cls2;
                                    z0VarX = z0Var;
                                }
                                if (SerializerFeature.isEnabled(i11, SerializerFeature.WriteClassName)) {
                                    z0Var = z0VarX;
                                    z0Var.d(o0Var, obj3, str2, null, i11);
                                } else {
                                    z0Var = z0VarX;
                                    z0Var.d(o0Var, obj3, str2, null, i11);
                                }
                                cls5 = cls3;
                            }
                            z14 = false;
                        } else {
                            list3 = this.f71653c;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!e(o0Var, obj, key, value)) {
                                    }
                                } else if (!e(o0Var, obj, key, value)) {
                                }
                            }
                            list4 = o0Var.f71655e;
                            if (list4 != null) {
                                if (key != null) {
                                    key = o(o0Var, obj, key, value);
                                } else {
                                    key = o(o0Var, obj, key, value);
                                }
                            }
                            list5 = this.f71655e;
                            if (list5 != null) {
                                if (key != null) {
                                    key = o(o0Var, obj, key, value);
                                } else {
                                    key = o(o0Var, obj, key, value);
                                }
                            }
                            str = key;
                            if (str != null) {
                                str2 = str;
                                z13 = true;
                                objP = p(o0Var, null, obj, str2, value, i11);
                                obj3 = objP;
                                r11 = z13;
                            } else {
                                str2 = str;
                                z13 = true;
                                objP = p(o0Var, null, obj, str2, value, i11);
                                obj3 = objP;
                                r11 = z13;
                            }
                            if (obj3 == null) {
                            }
                            if (str2 instanceof String) {
                                String str17 = str2;
                                if (!z14) {
                                    j1Var.write(44);
                                }
                                if (j1Var.k(SerializerFeature.PrettyFormat)) {
                                    o0Var.C();
                                }
                                j1Var.r(str17, r11);
                            } else {
                                if (!z14) {
                                    j1Var.write(44);
                                }
                                if (j1Var.j(f71759k)) {
                                    o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                } else {
                                    o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                }
                                j1Var.write(58);
                            }
                            if (obj3 == null) {
                                j1Var.g0();
                                cls5 = cls5;
                            } else {
                                cls = obj3.getClass();
                                cls2 = cls5;
                                if (cls != cls2) {
                                    cls3 = cls;
                                    z0VarX = o0Var.x(cls);
                                } else {
                                    cls3 = cls2;
                                    z0VarX = z0Var;
                                }
                                if (SerializerFeature.isEnabled(i11, SerializerFeature.WriteClassName)) {
                                    z0Var = z0VarX;
                                    z0Var.d(o0Var, obj3, str2, null, i11);
                                } else {
                                    z0Var = z0VarX;
                                    z0Var.d(o0Var, obj3, str2, null, i11);
                                }
                                cls5 = cls3;
                            }
                            z14 = false;
                        }
                    } else {
                        list2 = o0Var.f71653c;
                        if (list2 != null) {
                            list3 = this.f71653c;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!e(o0Var, obj, key, value)) {
                                    }
                                } else if (!e(o0Var, obj, key, value)) {
                                }
                            }
                            list4 = o0Var.f71655e;
                            if (list4 != null) {
                                if (key != null) {
                                    key = o(o0Var, obj, key, value);
                                } else {
                                    key = o(o0Var, obj, key, value);
                                }
                            }
                            list5 = this.f71655e;
                            if (list5 != null) {
                                if (key != null) {
                                    key = o(o0Var, obj, key, value);
                                } else {
                                    key = o(o0Var, obj, key, value);
                                }
                            }
                            str = key;
                            if (str != null) {
                                str2 = str;
                                z13 = true;
                                objP = p(o0Var, null, obj, str2, value, i11);
                                obj3 = objP;
                                r11 = z13;
                            } else {
                                str2 = str;
                                z13 = true;
                                objP = p(o0Var, null, obj, str2, value, i11);
                                obj3 = objP;
                                r11 = z13;
                            }
                            if (obj3 == null) {
                            }
                            if (str2 instanceof String) {
                                String str18 = str2;
                                if (!z14) {
                                    j1Var.write(44);
                                }
                                if (j1Var.k(SerializerFeature.PrettyFormat)) {
                                    o0Var.C();
                                }
                                j1Var.r(str18, r11);
                            } else {
                                if (!z14) {
                                    j1Var.write(44);
                                }
                                if (j1Var.j(f71759k)) {
                                    o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                } else {
                                    o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                }
                                j1Var.write(58);
                            }
                            if (obj3 == null) {
                                j1Var.g0();
                                cls5 = cls5;
                            } else {
                                cls = obj3.getClass();
                                cls2 = cls5;
                                if (cls != cls2) {
                                    cls3 = cls;
                                    z0VarX = o0Var.x(cls);
                                } else {
                                    cls3 = cls2;
                                    z0VarX = z0Var;
                                }
                                if (SerializerFeature.isEnabled(i11, SerializerFeature.WriteClassName)) {
                                    z0Var = z0VarX;
                                    z0Var.d(o0Var, obj3, str2, null, i11);
                                } else {
                                    z0Var = z0VarX;
                                    z0Var.d(o0Var, obj3, str2, null, i11);
                                }
                                cls5 = cls3;
                            }
                            z14 = false;
                        } else {
                            list3 = this.f71653c;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!e(o0Var, obj, key, value)) {
                                    }
                                } else if (!e(o0Var, obj, key, value)) {
                                }
                            }
                            list4 = o0Var.f71655e;
                            if (list4 != null) {
                                if (key != null) {
                                    key = o(o0Var, obj, key, value);
                                } else {
                                    key = o(o0Var, obj, key, value);
                                }
                            }
                            list5 = this.f71655e;
                            if (list5 != null) {
                                if (key != null) {
                                    key = o(o0Var, obj, key, value);
                                } else {
                                    key = o(o0Var, obj, key, value);
                                }
                            }
                            str = key;
                            if (str != null) {
                                str2 = str;
                                z13 = true;
                                objP = p(o0Var, null, obj, str2, value, i11);
                                obj3 = objP;
                                r11 = z13;
                            } else {
                                str2 = str;
                                z13 = true;
                                objP = p(o0Var, null, obj, str2, value, i11);
                                obj3 = objP;
                                r11 = z13;
                            }
                            if (obj3 == null) {
                            }
                            if (str2 instanceof String) {
                                String str19 = str2;
                                if (!z14) {
                                    j1Var.write(44);
                                }
                                if (j1Var.k(SerializerFeature.PrettyFormat)) {
                                    o0Var.C();
                                }
                                j1Var.r(str19, r11);
                            } else {
                                if (!z14) {
                                    j1Var.write(44);
                                }
                                if (j1Var.j(f71759k)) {
                                    o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                } else {
                                    o0Var.I(com.alibaba.fastjson.a.toJSONString(str2));
                                }
                                j1Var.write(58);
                            }
                            if (obj3 == null) {
                                j1Var.g0();
                                cls5 = cls5;
                            } else {
                                cls = obj3.getClass();
                                cls2 = cls5;
                                if (cls != cls2) {
                                    cls3 = cls;
                                    z0VarX = o0Var.x(cls);
                                } else {
                                    cls3 = cls2;
                                    z0VarX = z0Var;
                                }
                                if (SerializerFeature.isEnabled(i11, SerializerFeature.WriteClassName)) {
                                    z0Var = z0VarX;
                                    z0Var.d(o0Var, obj3, str2, null, i11);
                                } else {
                                    z0Var = z0VarX;
                                    z0Var.d(o0Var, obj3, str2, null, i11);
                                }
                                cls5 = cls3;
                            }
                            z14 = false;
                        }
                    }
                }
                cls5 = cls5;
                obj = obj;
                cls5 = cls5;
            }
        }
        o0Var.f71708r = e1Var;
        o0Var.s();
        if (j1Var.k(SerializerFeature.PrettyFormat) && treeMap.size() > 0) {
            o0Var.C();
        }
        if (z11) {
            return;
        }
        j1Var.write(125);
    }
}
