package com.mbridge.msdk.foundation.download.download;

import android.webkit.URLUtil;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.an;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class DownLoadUtils {
    private static final int DOWNLOAD_CONNECTION_TIME_OUT = 20000;
    private static final int DOWNLOAD_READ_TIME_OUT = 30000;
    public static final String END_TAG = "<mbridgeloadend></mbridgeloadend>";
    private static final String TAG = "DownLoadUtils";

    public static void getSourceCodeFromNetUrl(final String str, final H5DownLoadManager.IOnDownLoadH5Source iOnDownLoadH5Source, final boolean z11) {
        try {
            if (!an.a(str) && URLUtil.isNetworkUrl(str)) {
                DownloadTask.getInstance().runTask(new a() { // from class: com.mbridge.msdk.foundation.download.download.DownLoadUtils.1
                    @Override // com.mbridge.msdk.foundation.same.e.a
                    public final void cancelTask() {
                    }

                    @Override // com.mbridge.msdk.foundation.same.e.a
                    public final void pauseTask(boolean z12) {
                    }

                    /* JADX WARN: Code duplicated, block: B:102:0x00f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    /* JADX WARN: Code duplicated, block: B:106:0x0157 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    /* JADX WARN: Code duplicated, block: B:54:0x00e7 A[Catch: Exception -> 0x00b6, TRY_ENTER, TryCatch #8 {Exception -> 0x00b6, blocks: (B:43:0x00b2, B:47:0x00ba, B:54:0x00e7, B:56:0x00ec), top: B:111:0x0004 }] */
                    /* JADX WARN: Code duplicated, block: B:56:0x00ec A[Catch: Exception -> 0x00b6, TRY_LEAVE, TryCatch #8 {Exception -> 0x00b6, blocks: (B:43:0x00b2, B:47:0x00ba, B:54:0x00e7, B:56:0x00ec), top: B:111:0x0004 }] */
                    /* JADX WARN: Code duplicated, block: B:66:0x0104  */
                    /* JADX WARN: Code duplicated, block: B:67:0x0106 A[Catch: all -> 0x0102, TryCatch #3 {all -> 0x0102, blocks: (B:58:0x00f1, B:61:0x00f7, B:63:0x00fa, B:67:0x0106, B:69:0x010c, B:71:0x0112, B:73:0x011a, B:75:0x011e, B:76:0x0124, B:78:0x0128), top: B:102:0x00f1 }] */
                    /* JADX WARN: Code duplicated, block: B:76:0x0124 A[Catch: all -> 0x0102, TryCatch #3 {all -> 0x0102, blocks: (B:58:0x00f1, B:61:0x00f7, B:63:0x00fa, B:67:0x0106, B:69:0x010c, B:71:0x0112, B:73:0x011a, B:75:0x011e, B:76:0x0124, B:78:0x0128), top: B:102:0x00f1 }] */
                    /* JADX WARN: Code duplicated, block: B:78:0x0128 A[Catch: all -> 0x0102, TRY_LEAVE, TryCatch #3 {all -> 0x0102, blocks: (B:58:0x00f1, B:61:0x00f7, B:63:0x00fa, B:67:0x0106, B:69:0x010c, B:71:0x0112, B:73:0x011a, B:75:0x011e, B:76:0x0124, B:78:0x0128), top: B:102:0x00f1 }] */
                    /* JADX WARN: Code duplicated, block: B:94:0x015d A[DONT_INVERT] */
                    /* JADX WARN: Code duplicated, block: B:95:0x015f A[Catch: Exception -> 0x015b, TRY_LEAVE, TryCatch #5 {Exception -> 0x015b, blocks: (B:91:0x0157, B:95:0x015f), top: B:106:0x0157 }] */
                    /* JADX WARN: Instruction removed from duplicated block: B:78:0x0128, please report this as an issue */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r0v17, types: [com.mbridge.msdk.foundation.download.download.H5DownLoadManager$IOnDownLoadH5Source] */
                    /* JADX WARN: Type inference failed for: r6v0 */
                    /* JADX WARN: Type inference failed for: r6v1 */
                    /* JADX WARN: Type inference failed for: r6v10 */
                    /* JADX WARN: Type inference failed for: r6v11, types: [java.io.ByteArrayOutputStream] */
                    /* JADX WARN: Type inference failed for: r6v12 */
                    /* JADX WARN: Type inference failed for: r6v13 */
                    /* JADX WARN: Type inference failed for: r6v2, types: [java.io.ByteArrayOutputStream] */
                    /* JADX WARN: Type inference failed for: r6v3 */
                    /* JADX WARN: Type inference failed for: r6v4 */
                    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.ByteArrayOutputStream] */
                    /* JADX WARN: Type inference failed for: r6v8 */
                    /* JADX WARN: Type inference failed for: r6v9, types: [java.io.ByteArrayOutputStream] */
                    /* JADX WARN: Type inference failed for: r7v0 */
                    /* JADX WARN: Type inference failed for: r7v1 */
                    /* JADX WARN: Type inference failed for: r7v14 */
                    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.String] */
                    /* JADX WARN: Type inference failed for: r7v3 */
                    /* JADX WARN: Type inference failed for: r7v4 */
                    /* JADX WARN: Type inference failed for: r7v5 */
                    /* JADX WARN: Type inference failed for: r7v9 */
                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                     */
                    @Override // com.mbridge.msdk.foundation.same.e.a
                    public final void runTask() throws Throwable {
                        ?? r11;
                        InputStream inputStream;
                        byte[] byteArray;
                        String message;
                        ?? byteArrayOutputStream;
                        ?? r12;
                        H5DownLoadManager.IOnDownLoadH5Source iOnDownLoadH5Source2;
                        boolean z12;
                        String str2;
                        InputStream inputStream2 = null;
                        boolean z13 = false;
                        try {
                            try {
                                H5DownLoadManager.IOnDownLoadH5Source iOnDownLoadH5Source3 = iOnDownLoadH5Source;
                                if (iOnDownLoadH5Source3 != null) {
                                    iOnDownLoadH5Source3.onStart();
                                }
                                HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
                                httpURLConnection.setReadTimeout(30000);
                                httpURLConnection.setConnectTimeout(20000);
                                int responseCode = httpURLConnection.getResponseCode();
                                ad.a(DownLoadUtils.TAG, "response code " + responseCode);
                                try {
                                    if (responseCode == 200) {
                                        inputStream = httpURLConnection.getInputStream();
                                        try {
                                            byte[] bArr = new byte[6144];
                                            byteArrayOutputStream = new ByteArrayOutputStream();
                                            while (true) {
                                                try {
                                                    try {
                                                        int i11 = inputStream.read(bArr);
                                                        if (i11 == -1) {
                                                            break;
                                                        } else {
                                                            byteArrayOutputStream.write(bArr, 0, i11);
                                                        }
                                                    } catch (Exception e11) {
                                                        e = e11;
                                                        byteArray = null;
                                                        r12 = 0;
                                                    }
                                                    if (z13) {
                                                        try {
                                                            if (!z11 && byteArray != null && byteArray.length > 0) {
                                                                iOnDownLoadH5Source.onSuccess(null, byteArray, str);
                                                            } else if (z13 || !an.b(r12) || r12.length() <= 0 || !r12.contains(DownLoadUtils.END_TAG)) {
                                                                iOnDownLoadH5Source2 = iOnDownLoadH5Source;
                                                                if (iOnDownLoadH5Source2 != null) {
                                                                    iOnDownLoadH5Source2.onFailed("content write failed:" + message);
                                                                }
                                                            } else {
                                                                ?? r13 = iOnDownLoadH5Source;
                                                                if (r13 != 0) {
                                                                    r13.onSuccess(r12, byteArray, str);
                                                                }
                                                            }
                                                        } catch (Throwable th2) {
                                                            if (MBridgeConstans.DEBUG) {
                                                                th2.printStackTrace();
                                                            }
                                                            H5DownLoadManager.IOnDownLoadH5Source iOnDownLoadH5Source4 = iOnDownLoadH5Source;
                                                            if (iOnDownLoadH5Source4 != null) {
                                                                try {
                                                                    iOnDownLoadH5Source4.onFailed(th2.getMessage());
                                                                    return;
                                                                } catch (Exception e12) {
                                                                    e12.printStackTrace();
                                                                    return;
                                                                }
                                                            }
                                                            return;
                                                        }
                                                    } else if (z13) {
                                                        iOnDownLoadH5Source2 = iOnDownLoadH5Source;
                                                        if (iOnDownLoadH5Source2 != null) {
                                                            iOnDownLoadH5Source2.onFailed("content write failed:" + message);
                                                        }
                                                    } else {
                                                        iOnDownLoadH5Source2 = iOnDownLoadH5Source;
                                                        if (iOnDownLoadH5Source2 != null) {
                                                            iOnDownLoadH5Source2.onFailed("content write failed:" + message);
                                                        }
                                                    }
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    inputStream2 = inputStream;
                                                    r11 = byteArrayOutputStream;
                                                    if (inputStream2 != null) {
                                                        try {
                                                            inputStream2.close();
                                                            if (r11 != 0) {
                                                                r11.close();
                                                            }
                                                        } catch (Exception e13) {
                                                            e13.printStackTrace();
                                                            e13.getMessage();
                                                            throw th;
                                                        }
                                                    } else if (r11 != 0) {
                                                        r11.close();
                                                    }
                                                    throw th;
                                                }
                                                message = e.getMessage();
                                                ad.b(DownLoadUtils.TAG, "getStringFromUrl failed " + e.getLocalizedMessage());
                                                if (inputStream != null) {
                                                    inputStream.close();
                                                }
                                                if (byteArrayOutputStream != 0) {
                                                    byteArrayOutputStream.close();
                                                }
                                            }
                                            if (byteArrayOutputStream.toByteArray() != null) {
                                                byteArray = byteArrayOutputStream.toByteArray();
                                                try {
                                                    str2 = !z11 ? new String(byteArray) : null;
                                                } catch (Exception e14) {
                                                    e = e14;
                                                    r12 = 0;
                                                }
                                            } else {
                                                byteArray = null;
                                                str2 = null;
                                            }
                                            message = "";
                                            z12 = true;
                                            byteArrayOutputStream = byteArrayOutputStream;
                                            r12 = str2;
                                        } catch (Exception e15) {
                                            e = e15;
                                            byteArray = null;
                                            byteArrayOutputStream = byteArray;
                                            r12 = byteArrayOutputStream;
                                        } catch (Throwable th4) {
                                            th = th4;
                                            byteArrayOutputStream = 0;
                                            inputStream2 = inputStream;
                                            r11 = byteArrayOutputStream;
                                            if (inputStream2 != null) {
                                                inputStream2.close();
                                                if (r11 != 0) {
                                                    r11.close();
                                                }
                                            } else if (r11 != 0) {
                                                r11.close();
                                            }
                                            throw th;
                                        }
                                    } else {
                                        message = "responseCode is " + responseCode;
                                        inputStream = null;
                                        byteArray = null;
                                        byteArrayOutputStream = 0;
                                        r12 = 0;
                                        z12 = false;
                                    }
                                    httpURLConnection.disconnect();
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (byteArrayOutputStream != 0) {
                                        byteArrayOutputStream.close();
                                    }
                                    z13 = z12;
                                } catch (Exception e16) {
                                    e = e16;
                                    message = e.getMessage();
                                    ad.b(DownLoadUtils.TAG, "getStringFromUrl failed " + e.getLocalizedMessage());
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (byteArrayOutputStream != 0) {
                                        byteArrayOutputStream.close();
                                    }
                                }
                            } catch (Exception e17) {
                                e17.printStackTrace();
                                message = e17.getMessage();
                            }
                        } catch (Exception e18) {
                            e = e18;
                            inputStream = null;
                            byteArray = null;
                        } catch (Throwable th5) {
                            th = th5;
                            r11 = 0;
                            if (inputStream2 != null) {
                                inputStream2.close();
                                if (r11 != 0) {
                                    r11.close();
                                }
                            } else if (r11 != 0) {
                                r11.close();
                            }
                            throw th;
                        }
                        if (z13) {
                            if (!z11) {
                                if (z13) {
                                    iOnDownLoadH5Source2 = iOnDownLoadH5Source;
                                    if (iOnDownLoadH5Source2 != null) {
                                        iOnDownLoadH5Source2.onFailed("content write failed:" + message);
                                    }
                                } else {
                                    iOnDownLoadH5Source2 = iOnDownLoadH5Source;
                                    if (iOnDownLoadH5Source2 != null) {
                                        iOnDownLoadH5Source2.onFailed("content write failed:" + message);
                                    }
                                }
                            } else if (z13) {
                                iOnDownLoadH5Source2 = iOnDownLoadH5Source;
                                if (iOnDownLoadH5Source2 != null) {
                                    iOnDownLoadH5Source2.onFailed("content write failed:" + message);
                                }
                            } else {
                                iOnDownLoadH5Source2 = iOnDownLoadH5Source;
                                if (iOnDownLoadH5Source2 != null) {
                                    iOnDownLoadH5Source2.onFailed("content write failed:" + message);
                                }
                            }
                        } else if (z13) {
                            iOnDownLoadH5Source2 = iOnDownLoadH5Source;
                            if (iOnDownLoadH5Source2 != null) {
                                iOnDownLoadH5Source2.onFailed("content write failed:" + message);
                            }
                        } else {
                            iOnDownLoadH5Source2 = iOnDownLoadH5Source;
                            if (iOnDownLoadH5Source2 != null) {
                                iOnDownLoadH5Source2.onFailed("content write failed:" + message);
                            }
                        }
                    }
                });
                return;
            }
            if (iOnDownLoadH5Source != null) {
                iOnDownLoadH5Source.onFailed("url is error");
            }
        } catch (Throwable th2) {
            if (MBridgeConstans.DEBUG) {
                th2.printStackTrace();
            }
        }
    }
}
