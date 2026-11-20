package com.mbridge.msdk.foundation.tools;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.resource.MBResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final List<String> f45071a;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(String str, DownloadError downloadError);

        void a(String str, String str2, String str3, String str4, boolean z11);
    }

    static {
        ArrayList arrayList = new ArrayList(4);
        f45071a = arrayList;
        arrayList.add("mbridge_splash_native_template_v_v1.xml");
        arrayList.add("mbridge_splash_native_template_h_v1.xml");
    }

    public static String a(int i11, String str, String str2) {
        String strB;
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            strB = b(i11, str, str2);
        } catch (Exception unused) {
            strB = "";
        }
        String str3 = com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_XML) + File.separator;
        File file = null;
        try {
            if (!TextUtils.isEmpty(strB)) {
                file = new File(str3, strB);
            }
        } catch (Exception unused2) {
        }
        if (file == null || !file.exists()) {
            file = new File(str3 + File.separator + strB.replace(".xml", ""), strB);
        }
        return file.getPath();
    }

    public static String a(String str) {
        String strB;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String queryParameter = Uri.parse(str).getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_KEY_NATMP);
            if (!TextUtils.isEmpty(queryParameter) && !queryParameter.equals("1")) {
                return "";
            }
        } catch (Throwable unused) {
        }
        try {
            strB = b(str);
        } catch (Exception unused2) {
            strB = "";
        }
        if (TextUtils.isEmpty(strB)) {
            return "";
        }
        try {
            final String str2 = com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_XML) + File.separator;
            File file = new File(str2, strB);
            if (file.isFile() && file.exists()) {
                return file.getPath();
            }
            String path = new URL(str).getPath();
            final String strSubstring = path.substring(path.lastIndexOf(47) + 1);
            MBDownloadManager.getInstance().download(new DownloadMessage<>(new Object(), str, strSubstring, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_OTHER)).withReadTimeout(com.mbridge.msdk.foundation.same.a.f44385u).withConnectTimeout(com.mbridge.msdk.foundation.same.a.f44379o).withWriteTimeout(com.mbridge.msdk.foundation.same.a.f44383s).withDownloadPriority(DownloadPriority.MEDIUM).withHttpRetryCounter(1).withDirectoryPathInternal(str2).withDownloadStateListener(new OnDownloadStateListener() { // from class: com.mbridge.msdk.foundation.tools.n.2
                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public final void onCancelDownload(DownloadMessage downloadMessage) {
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public final void onDownloadComplete(DownloadMessage downloadMessage) throws Throwable {
                    try {
                        MBResourceManager.getInstance().unZip(str2 + File.separator + strSubstring, str2);
                    } catch (Exception unused3) {
                    }
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public final void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
                }

                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                public final void onDownloadStart(DownloadMessage downloadMessage) {
                }
            }).build().start();
            return "";
        } catch (Exception unused3) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x008c, code lost:
    
        if (r21 != 5) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(int i11, String str, final String str2, final a aVar, CampaignEx campaignEx) {
        String strB;
        String path;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            strB = b(i11, str, str2);
        } catch (Exception unused) {
            strB = "";
        }
        final String str3 = com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_XML) + File.separator;
        File file = null;
        try {
            if (!TextUtils.isEmpty(strB)) {
                file = new File(str3, strB);
            }
        } catch (Exception unused2) {
        }
        if (file == null || !file.exists()) {
            file = new File(str3 + File.separator + strB.replace(".xml", ""), strB);
        }
        try {
            path = file.exists() ? file.getPath() : "";
        } catch (Exception unused3) {
        }
        com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
        dVar.a("scenes", "1");
        dVar.a("url", str2);
        try {
            try {
                try {
                    try {
                        if (i11 != 0) {
                            if (i11 == 1) {
                                dVar.a("resource_type", 2);
                            } else if (i11 == 2) {
                                dVar.a("resource_type", 3);
                            }
                            if (TextUtils.isEmpty(path) && !TextUtils.isEmpty(strB)) {
                                if (aVar != null) {
                                    try {
                                        aVar.a(str2, path, strB, null, true);
                                    } catch (Exception e11) {
                                        ad.b("DynamicViewResourceManager", e11.getMessage());
                                    }
                                    try {
                                        dVar.a("cache", 1);
                                        com.mbridge.msdk.foundation.same.report.d.c.a().a("m_download_start", campaignEx, dVar);
                                        return;
                                    } catch (Exception unused4) {
                                        return;
                                    }
                                }
                                return;
                            }
                            String path2 = new URL(str2).getPath();
                            final String strSubstring = path2.substring(path2.lastIndexOf(47) + 1);
                            final String strReplace = strSubstring.replace(".zip", "");
                            ad.a("test_zip_download ", "start download path： " + str3 + strSubstring);
                            DownloadMessage<?> downloadMessage = new DownloadMessage<>(campaignEx, str2, strSubstring, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_OTHER);
                            downloadMessage.addExtra("resource_type", Integer.valueOf(i11));
                            MBDownloadManager.getInstance().download(downloadMessage).withReadTimeout(com.mbridge.msdk.foundation.same.a.f44385u).withConnectTimeout(com.mbridge.msdk.foundation.same.a.f44384t).withWriteTimeout(com.mbridge.msdk.foundation.same.a.f44383s).withDownloadPriority(DownloadPriority.MEDIUM).withHttpRetryCounter(1).withDirectoryPathInternal(str3).withDownloadStateListener(new OnDownloadStateListener() { // from class: com.mbridge.msdk.foundation.tools.n.1
                                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                                public final void onCancelDownload(DownloadMessage downloadMessage2) {
                                }

                                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                                public final void onDownloadComplete(DownloadMessage downloadMessage2) throws Throwable {
                                    try {
                                        String str4 = str3 + File.separator + strSubstring;
                                        String str5 = str3;
                                        MBResourceManager.getInstance().unZip(str4, str5);
                                        if (aVar != null) {
                                            String str6 = "";
                                            if (downloadMessage2 != null) {
                                                try {
                                                    str6 = (String) downloadMessage2.getExtra("responseHeaders");
                                                } catch (Throwable th2) {
                                                    ad.b("DynamicViewResourceManager", th2.getMessage());
                                                }
                                            }
                                            try {
                                                aVar.a(str2, str5, strReplace, str6, false);
                                            } catch (Exception e12) {
                                                ad.b("DynamicViewResourceManager", e12.getMessage());
                                            }
                                        }
                                    } catch (Exception unused5) {
                                    }
                                }

                                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                                public final void onDownloadError(DownloadMessage downloadMessage2, DownloadError downloadError) {
                                    a aVar2 = aVar;
                                    if (aVar2 != null) {
                                        try {
                                            aVar2.a(str2, downloadError);
                                        } catch (Exception e12) {
                                            ad.b("DynamicViewResourceManager", e12.getMessage());
                                        }
                                    }
                                }

                                @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                                public final void onDownloadStart(DownloadMessage downloadMessage2) {
                                }
                            }).build().start();
                            dVar.a("cache", 2);
                            com.mbridge.msdk.foundation.same.report.d.c.a().a("m_download_start", campaignEx, dVar);
                            return;
                        }
                        dVar.a("resource_type", 1);
                        dVar.a("cache", 2);
                        com.mbridge.msdk.foundation.same.report.d.c.a().a("m_download_start", campaignEx, dVar);
                        return;
                    } catch (Exception unused5) {
                        return;
                    }
                    DownloadMessage<?> downloadMessage2 = new DownloadMessage<>(campaignEx, str2, strSubstring, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_OTHER);
                    downloadMessage2.addExtra("resource_type", Integer.valueOf(i11));
                    MBDownloadManager.getInstance().download(downloadMessage2).withReadTimeout(com.mbridge.msdk.foundation.same.a.f44385u).withConnectTimeout(com.mbridge.msdk.foundation.same.a.f44384t).withWriteTimeout(com.mbridge.msdk.foundation.same.a.f44383s).withDownloadPriority(DownloadPriority.MEDIUM).withHttpRetryCounter(1).withDirectoryPathInternal(str3).withDownloadStateListener(new OnDownloadStateListener() { // from class: com.mbridge.msdk.foundation.tools.n.1
                        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                        public final void onCancelDownload(DownloadMessage downloadMessage3) {
                        }

                        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                        public final void onDownloadComplete(DownloadMessage downloadMessage3) throws Throwable {
                            try {
                                String str4 = str3 + File.separator + strSubstring;
                                String str5 = str3;
                                MBResourceManager.getInstance().unZip(str4, str5);
                                if (aVar != null) {
                                    String str6 = "";
                                    if (downloadMessage3 != null) {
                                        try {
                                            str6 = (String) downloadMessage3.getExtra("responseHeaders");
                                        } catch (Throwable th2) {
                                            ad.b("DynamicViewResourceManager", th2.getMessage());
                                        }
                                    }
                                    try {
                                        aVar.a(str2, str5, strReplace, str6, false);
                                    } catch (Exception e12) {
                                        ad.b("DynamicViewResourceManager", e12.getMessage());
                                    }
                                }
                            } catch (Exception unused6) {
                            }
                        }

                        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                        public final void onDownloadError(DownloadMessage downloadMessage3, DownloadError downloadError) {
                            a aVar2 = aVar;
                            if (aVar2 != null) {
                                try {
                                    aVar2.a(str2, downloadError);
                                } catch (Exception e12) {
                                    ad.b("DynamicViewResourceManager", e12.getMessage());
                                }
                            }
                        }

                        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
                        public final void onDownloadStart(DownloadMessage downloadMessage3) {
                        }
                    }).build().start();
                } catch (Exception e12) {
                    e = e12;
                    ad.b("DynamicViewResourceManager", e.getMessage());
                }
            } catch (Exception unused6) {
            }
            String path3 = new URL(str2).getPath();
            final String strSubstring2 = path3.substring(path3.lastIndexOf(47) + 1);
            final String strReplace2 = strSubstring2.replace(".zip", "");
            ad.a("test_zip_download ", "start download path： " + str3 + strSubstring2);
        } catch (Exception e13) {
            e = e13;
        }
        if (TextUtils.isEmpty(path)) {
        }
    }

    private static String b(int i11, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            String path = new URL(str2).getPath();
            String strSubstring = path.substring(path.lastIndexOf(47) + 1);
            return !TextUtils.isEmpty(strSubstring) ? strSubstring.replace(".zip", "") : "";
        } catch (Exception unused) {
            return "";
        }
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String path = new URL(str).getPath();
            String strSubstring = path.substring(path.lastIndexOf(47) + 1);
            if (TextUtils.isEmpty(strSubstring)) {
                return "";
            }
            String strReplace = strSubstring.replace(".zip", "");
            List<String> list = f45071a;
            return (list == null || list.contains(strReplace)) ? "" : strReplace;
        } catch (Exception unused) {
            return "";
        }
    }
}
