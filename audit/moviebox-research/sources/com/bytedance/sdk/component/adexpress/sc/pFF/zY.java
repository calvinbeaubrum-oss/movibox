package com.bytedance.sdk.component.adexpress.sc.pFF;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.component.utils.cvk;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zY {
    public static void pFF(File file, com.bytedance.sdk.component.adexpress.sc.zY.sc scVar, String str) {
        if (scVar == null || file == null) {
            return;
        }
        try {
            new File(file, str).delete();
        } catch (Throwable unused) {
        }
        if (scVar.TRI() != null) {
            Iterator<com.bytedance.sdk.component.adexpress.sc.zY.sc.C0259sc> it = scVar.TRI().iterator();
            while (it.hasNext()) {
                try {
                    new File(file, com.bytedance.sdk.component.utils.ExN.sc(it.next().sc())).delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public static void sc(File file, com.bytedance.sdk.component.adexpress.sc.zY.sc scVar, String str) {
        if (scVar == null) {
            return;
        }
        String strOl = scVar.Ol();
        if (TextUtils.isEmpty(strOl)) {
            return;
        }
        File file2 = new File(file, str);
        File file3 = new File(file2 + ".tmp");
        if (file3.exists()) {
            file3.delete();
        }
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
            try {
                fileOutputStream2.write(strOl.getBytes("utf-8"));
                if (file2.exists()) {
                    file2.delete();
                }
                file3.renameTo(file2);
                try {
                    fileOutputStream2.close();
                } catch (IOException unused) {
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                try {
                    Tf.sc("PlayComponentEngineCacheManager", "version save error3", th);
                } finally {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Deprecated
    public static boolean sc(com.bytedance.sdk.component.adexpress.sc.zY.sc scVar, String str) {
        if (scVar == null) {
            return true;
        }
        try {
            if (TextUtils.isEmpty(scVar.zY())) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return sc(scVar.zY(), str);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean sc(String str, String str2) {
        String[] strArrSplit = str2.split("\\.");
        String[] strArrSplit2 = str.split("\\.");
        int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
        for (int i11 = 0; i11 < iMin; i11++) {
            int length = strArrSplit[i11].length() - strArrSplit2[i11].length();
            if (length == 0) {
                int iCompareTo = strArrSplit[i11].compareTo(strArrSplit2[i11]);
                if (iCompareTo > 0) {
                    return true;
                }
                if (iCompareTo < 0) {
                    return false;
                }
                if (i11 == iMin - 1) {
                    return strArrSplit.length > strArrSplit2.length;
                }
            } else if (length > 0) {
                return true;
            }
        }
        return false;
    }

    private boolean sc(List<com.bytedance.sdk.component.adexpress.sc.zY.sc.C0259sc> list, List<com.bytedance.sdk.component.adexpress.sc.zY.sc.C0259sc> list2) {
        for (com.bytedance.sdk.component.adexpress.sc.zY.sc.C0259sc c0259sc : list) {
            String strSc = c0259sc.sc();
            String strSc2 = com.bytedance.sdk.component.utils.ExN.sc(strSc);
            File file = new File(sc(), strSc2);
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
            com.bytedance.sdk.component.qr.pFF.sc scVarTRI = com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY().TRI();
            scVarTRI.pFF(strSc);
            scVarTRI.sc(sc().getAbsolutePath(), strSc2);
            com.bytedance.sdk.component.qr.pFF pffSc = scVarTRI.sc();
            list2.add(c0259sc);
            if (pffSc == null || !pffSc.TRI() || pffSc.ExN() == null || !pffSc.ExN().exists()) {
                zY(list2);
                return false;
            }
        }
        return true;
    }

    private static boolean sc(Map<String, com.bytedance.sdk.component.adexpress.sc.zY.sc> map, Map<String, com.bytedance.sdk.component.adexpress.sc.zY.sc> map2) {
        if (map.size() != map2.size()) {
            return true;
        }
        for (String str : map2.keySet()) {
            com.bytedance.sdk.component.adexpress.sc.zY.sc scVar = map.get(str);
            if (scVar == null) {
                return true;
            }
            com.bytedance.sdk.component.adexpress.sc.zY.sc scVar2 = map2.get(str);
            if (scVar2 == null) {
                return false;
            }
            if (sc(scVar.zY(), scVar2.zY())) {
                return true;
            }
        }
        return false;
    }

    public static boolean zY(com.bytedance.sdk.component.adexpress.sc.zY.sc scVar, com.bytedance.sdk.component.adexpress.sc.zY.sc scVar2) {
        if (scVar != null) {
            try {
                if (!TextUtils.isEmpty(scVar.zY())) {
                    if (scVar2 == null) {
                        return false;
                    }
                    if (sc(scVar.zY(), scVar2.zY())) {
                        return true;
                    }
                    Map<String, com.bytedance.sdk.component.adexpress.sc.zY.sc> mapSc = scVar.sc();
                    Map<String, com.bytedance.sdk.component.adexpress.sc.zY.sc> mapSc2 = scVar2.sc();
                    if (mapSc.isEmpty()) {
                        return !mapSc2.isEmpty();
                    }
                    if (mapSc2.isEmpty()) {
                        return false;
                    }
                    return sc(mapSc, mapSc2);
                }
            } catch (Throwable th2) {
                th2.getMessage();
                return false;
            }
        }
        return true;
    }

    public List<com.bytedance.sdk.component.adexpress.sc.zY.sc.C0259sc> pFF(com.bytedance.sdk.component.adexpress.sc.zY.sc scVar, com.bytedance.sdk.component.adexpress.sc.zY.sc scVar2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (scVar2 == null || scVar2.TRI().isEmpty()) {
            arrayList2.addAll(scVar.TRI());
        } else if (scVar.TRI().isEmpty()) {
            arrayList.addAll(scVar2.TRI());
        } else {
            for (com.bytedance.sdk.component.adexpress.sc.zY.sc.C0259sc c0259sc : scVar.TRI()) {
                if (!scVar2.TRI().contains(c0259sc) && c0259sc != null && c0259sc.sc() != null && c0259sc.pFF() != null) {
                    arrayList2.add(c0259sc);
                }
            }
            for (com.bytedance.sdk.component.adexpress.sc.zY.sc.C0259sc c0259sc2 : scVar2.TRI()) {
                if (!scVar.TRI().contains(c0259sc2)) {
                    arrayList.add(c0259sc2);
                }
            }
        }
        if (sc(arrayList2, arrayList3)) {
            return arrayList;
        }
        return null;
    }

    public void pFF(List<com.bytedance.sdk.component.adexpress.sc.zY.sc.C0259sc> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<com.bytedance.sdk.component.adexpress.sc.zY.sc.C0259sc> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(sc(), com.bytedance.sdk.component.utils.ExN.sc(it.next().sc()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public abstract File sc();

    public List<com.bytedance.sdk.component.adexpress.sc.zY.sc.C0259sc> sc(com.bytedance.sdk.component.adexpress.sc.zY.sc scVar, com.bytedance.sdk.component.adexpress.sc.zY.sc scVar2) {
        Map<String, com.bytedance.sdk.component.adexpress.sc.zY.sc> mapSc = scVar.sc();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (mapSc.size() == 0) {
            if (scVar2 != null && scVar2.sc().size() != 0) {
                Map<String, com.bytedance.sdk.component.adexpress.sc.zY.sc> mapSc2 = scVar2.sc();
                Iterator<String> it = mapSc2.keySet().iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.adexpress.sc.zY.sc scVar3 = mapSc2.get(it.next());
                    if (scVar3 != null) {
                        arrayList.addAll(scVar3.TRI());
                    }
                }
            }
        } else if (scVar2 != null && scVar2.sc().size() != 0) {
            Map<String, com.bytedance.sdk.component.adexpress.sc.zY.sc> mapSc3 = scVar2.sc();
            for (String str : mapSc.keySet()) {
                com.bytedance.sdk.component.adexpress.sc.zY.sc scVar4 = mapSc.get(str);
                com.bytedance.sdk.component.adexpress.sc.zY.sc scVar5 = mapSc3.get(str);
                if (scVar5 == null && scVar4 != null) {
                    arrayList2.addAll(scVar4.TRI());
                } else if (scVar4 == null && scVar5 != null) {
                    arrayList.addAll(scVar5.TRI());
                } else if (scVar4 != null) {
                    for (com.bytedance.sdk.component.adexpress.sc.zY.sc.C0259sc c0259sc : scVar4.TRI()) {
                        if (c0259sc != null && !scVar5.TRI().contains(c0259sc) && c0259sc.pFF() != null && c0259sc.sc() != null) {
                            arrayList2.add(c0259sc);
                        }
                    }
                    for (com.bytedance.sdk.component.adexpress.sc.zY.sc.C0259sc c0259sc2 : scVar5.TRI()) {
                        if (c0259sc2 != null && !scVar4.TRI().contains(c0259sc2)) {
                            arrayList.add(c0259sc2);
                        }
                    }
                }
            }
        } else if (mapSc.size() != 0) {
            Iterator<String> it2 = mapSc.keySet().iterator();
            while (it2.hasNext()) {
                com.bytedance.sdk.component.adexpress.sc.zY.sc scVar6 = mapSc.get(it2.next());
                if (scVar6 != null) {
                    arrayList2.addAll(scVar6.TRI());
                }
            }
        }
        if (sc(arrayList2, arrayList3)) {
            return arrayList;
        }
        return null;
    }

    public void sc(int i11) {
        if (com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().We() != null) {
            com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().We().sc(i11);
        }
    }

    public boolean sc(com.bytedance.sdk.component.adexpress.sc.zY.sc.pFF pff) {
        if (pff == null || sc() == null) {
            return false;
        }
        List<Pair<String, String>> listPFF = pff.pFF();
        if (listPFF == null || listPFF.size() <= 0) {
            return true;
        }
        Iterator<Pair<String, String>> it = listPFF.iterator();
        while (it.hasNext()) {
            File file = new File(sc(), (String) it.next().first);
            if (!file.exists() || !file.isFile()) {
                return false;
            }
        }
        return true;
    }

    public boolean sc(String str) {
        String strSc = com.bytedance.sdk.component.utils.ExN.sc(str);
        File file = new File(sc().getAbsoluteFile(), strSc + ".zip");
        com.bytedance.sdk.component.qr.pFF.sc scVarTRI = com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY().TRI();
        scVarTRI.pFF(str);
        scVarTRI.sc(file.getParent(), file.getName());
        com.bytedance.sdk.component.qr.pFF pffSc = scVarTRI.sc();
        if (pffSc.TRI() && pffSc.ExN() != null && pffSc.ExN().exists()) {
            File fileExN = pffSc.ExN();
            try {
                cvk.sc(fileExN.getAbsolutePath(), file.getParent());
                if (!fileExN.exists()) {
                    return true;
                }
                fileExN.delete();
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public boolean sc(List<com.bytedance.sdk.component.adexpress.sc.zY.sc.C0259sc> list) {
        if (list == null || list.size() <= 0 || sc() == null) {
            return false;
        }
        for (com.bytedance.sdk.component.adexpress.sc.zY.sc.C0259sc c0259sc : list) {
            String strSc = com.bytedance.sdk.component.utils.ExN.sc(c0259sc.sc());
            if (TextUtils.isEmpty(strSc)) {
                return false;
            }
            File file = new File(sc(), strSc);
            String strSc2 = com.bytedance.sdk.component.utils.ExN.sc(file);
            if (!file.exists() || !file.isFile() || c0259sc.pFF() == null || !c0259sc.pFF().equals(strSc2)) {
                return false;
            }
        }
        return true;
    }

    public boolean sc(Map<String, com.bytedance.sdk.component.adexpress.sc.zY.sc> map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.component.adexpress.sc.zY.sc scVar = map.get(it.next());
            if (scVar != null && !sc(scVar.TRI())) {
                return false;
            }
        }
        return true;
    }

    public void zY(List<com.bytedance.sdk.component.adexpress.sc.zY.sc.C0259sc> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<com.bytedance.sdk.component.adexpress.sc.zY.sc.C0259sc> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(sc(), com.bytedance.sdk.component.utils.ExN.sc(it.next().sc()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }
}
