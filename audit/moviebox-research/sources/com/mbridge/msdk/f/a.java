package com.mbridge.msdk.f;

import android.text.TextUtils;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.cloud.tmc.miniapp.bridge.PermissionScopeBridge;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a {
    public static int a(int i11, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return i11;
            }
            if (str.startsWith("errorCode: ") && str.length() > 16) {
                return Integer.parseInt(str.substring(11, 15));
            }
            if (str.equals("do not have sorceList")) {
                return i11 + PermissionScopeBridge.ERROR_CODE_SCOPE_NAME_IS_EMPTY;
            }
            if (str.equals("Network error,UnknownHostException")) {
                return i11 + PermissionScopeBridge.ERROR_CODE_SCOPE_NAME_NOT_FOUND;
            }
            if (str.equals("v3 is timeout")) {
                return i11 + 603;
            }
            if (!str.equals("Current unit is loading!") && !str.equals("current unit is loading")) {
                if (str.equals("Network error,I/O exception response null")) {
                    return i11 + 605;
                }
                if (str.equals("Network error,ConnectException")) {
                    return i11 + 606;
                }
                if (str.equals("Network error,socket timeout exception")) {
                    return i11 + 607;
                }
                if (str.equals("Network error,disconnected network exception")) {
                    return i11 + 608;
                }
                if (str.equals("Network error,timeout exception")) {
                    return i11 + 609;
                }
                if (str.startsWith("Network error,please check state code")) {
                    return i11 + 610;
                }
                if (str.equals("Network error,I/O exception contents null")) {
                    return i11 + 611;
                }
                if (str.equals("Network unknown error")) {
                    return i11 + 612;
                }
                if (str.equals("Network error,I/O exception")) {
                    return i11 + 613;
                }
                if (str.equals("web env is not support")) {
                    return i11 + 614;
                }
                if (str.equals("Network error,unknown")) {
                    return i11 + 615;
                }
                if (str.equals("Network error，sslp exception")) {
                    return i11 + 616;
                }
                if (str.startsWith("Cast exception, return data")) {
                    return i11 + 617;
                }
                if (str.equals("REQUEST_TIMEOUT")) {
                    return i11 + 701;
                }
                if (str.startsWith("The server returns an exception")) {
                    return i11 + 702;
                }
                if (!str.equals("APP ALREADY INSTALLED") && !str.equals("Need show campaign list is NULL!")) {
                    if (str.startsWith("load no ad")) {
                        return i11 + 704;
                    }
                    if (str.equals("EXCEPTION_UNIT_NOT_FOUND_IN_APP")) {
                        return i11 + 705;
                    }
                    if (str.equals("EXCEPTION_UNIT_BIDDING_TYPE_ERROR")) {
                        return i11 + 706;
                    }
                    if (str.equals("No video campaign")) {
                        return i11 + 707;
                    }
                    if (str.equals("EXCEPTION_RETURN_EMPTY")) {
                        return i11 + 708;
                    }
                    if (str.equals("EXCEPTION_APP_PLATFORM_ERROR")) {
                        return i11 + 709;
                    }
                    if (str.equals("EXCEPTION_SERVICE_REQUEST_OS_VERSION_REQUIRED")) {
                        return i11 + 710;
                    }
                    if (str.equals("banner res load failed")) {
                        return i11 + 801;
                    }
                    if (str.equals("resource load timeout is tpl: false")) {
                        return i11 + 802;
                    }
                    if (str.startsWith("resource download failed")) {
                        return i11 + 803;
                    }
                    if (str.equals("temp preload success but isReady false")) {
                        return i11 + 804;
                    }
                    if (str.equals("temp resource download failed")) {
                        return i11 + 805;
                    }
                    if (str.equals("tpl temp resource download failed")) {
                        return i11 + 806;
                    }
                    if (str.equals("resource load timeout is tpl: true")) {
                        return i11 + 807;
                    }
                    if (!str.startsWith(AgentPageJsBridge.HTTPS) && !str.startsWith("http://")) {
                        if (str.equals("mraid resource write fail")) {
                            return i11 + 809;
                        }
                        if (str.startsWith("data save failed:")) {
                            return i11 + 810;
                        }
                        if (str.equals("resource load timeout")) {
                            return i11 + 811;
                        }
                        return str.startsWith("tpl temp preload failed") ? i11 + 812 : i11;
                    }
                    return i11 + 808;
                }
                return i11 + 703;
            }
            return i11 + 604;
        } catch (Exception e11) {
            e11.printStackTrace();
            return i11;
        }
    }
}
