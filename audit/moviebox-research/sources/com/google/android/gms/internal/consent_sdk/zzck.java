package com.google.android.gms.internal.consent_sdk;

import android.util.JsonReader;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzck {

    @Nullable
    public String zza;

    @Nullable
    public String zzb;

    @Nullable
    public String zzc;
    public int zzf = 1;
    public List zzd = Collections.emptyList();
    public List zze = Collections.emptyList();
    public int zzg = 1;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x0068  */
    /* JADX WARN: Code duplicated, block: B:74:0x0104  */
    /* JADX WARN: Code duplicated, block: B:95:0x014a  */
    public static zzck zza(JsonReader jsonReader) throws IOException {
        byte b11;
        byte b12;
        int i11;
        zzck zzckVar = new zzck();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int i12 = 6;
            int i13 = 3;
            switch (jsonReader.nextName()) {
                case "consent_signal":
                    String strNextString = jsonReader.nextString();
                    switch (strNextString) {
                        case "CONSENT_SIGNAL_UNKNOWN":
                            i12 = 1;
                            zzckVar.zzf = i12;
                            break;
                        case "CONSENT_SIGNAL_PERSONALIZED_ADS":
                            i12 = 2;
                            zzckVar.zzf = i12;
                            break;
                        case "CONSENT_SIGNAL_NON_PERSONALIZED_ADS":
                            i12 = 3;
                            zzckVar.zzf = i12;
                            break;
                        case "CONSENT_SIGNAL_SUFFICIENT":
                            i12 = 4;
                            zzckVar.zzf = i12;
                            break;
                        case "CONSENT_SIGNAL_COLLECT_CONSENT":
                            i12 = 5;
                            zzckVar.zzf = i12;
                            break;
                        case "CONSENT_SIGNAL_NOT_REQUIRED":
                            zzckVar.zzf = i12;
                            break;
                        case "CONSENT_SIGNAL_ERROR":
                            i12 = 7;
                            zzckVar.zzf = i12;
                            break;
                        case "CONSENT_SIGNAL_PUBLISHER_MISCONFIGURATION":
                            i12 = 8;
                            zzckVar.zzf = i12;
                            break;
                        default:
                            throw new IOException("Failed to parse contentads.contributor.direct.serving.appswitchboard.proto.ApplicationGdprResponse.ConsentSignalfrom: ".concat(strNextString));
                    }
                    break;
                case "consent_form_payload":
                    zzckVar.zza = jsonReader.nextString();
                    break;
                case "consent_form_base_url":
                    zzckVar.zzb = jsonReader.nextString();
                    break;
                case "error_message":
                    zzckVar.zzc = jsonReader.nextString();
                    break;
                case "request_info_keys":
                    zzckVar.zzd = new ArrayList();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        zzckVar.zzd.add(jsonReader.nextString());
                    }
                    jsonReader.endArray();
                    break;
                case "actions":
                    zzckVar.zze = new ArrayList();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        zzcj zzcjVar = new zzcj();
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String strNextName = jsonReader.nextName();
                            int iHashCode = strNextName.hashCode();
                            if (iHashCode != -2105551094) {
                                if (iHashCode == 1583758243 && strNextName.equals("action_type")) {
                                    b11 = 0;
                                } else {
                                    b11 = -1;
                                }
                            } else if (strNextName.equals("args_json")) {
                                b11 = 1;
                            } else {
                                b11 = -1;
                            }
                            if (b11 == 0) {
                                String strNextString2 = jsonReader.nextString();
                                int iHashCode2 = strNextString2.hashCode();
                                if (iHashCode2 != 64208429) {
                                    if (iHashCode2 != 82862015) {
                                        if (iHashCode2 == 1856333582 && strNextString2.equals("UNKNOWN_ACTION_TYPE")) {
                                            b12 = 0;
                                        } else {
                                            b12 = -1;
                                        }
                                    } else if (strNextString2.equals("WRITE")) {
                                        b12 = 1;
                                    } else {
                                        b12 = -1;
                                    }
                                } else if (strNextString2.equals("CLEAR")) {
                                    b12 = 2;
                                } else {
                                    b12 = -1;
                                }
                                if (b12 == 0) {
                                    i11 = 1;
                                } else if (b12 == 1) {
                                    i11 = 2;
                                } else {
                                    if (b12 != 2) {
                                        throw new IOException("Failed to parse contentads.contributor.direct.serving.appswitchboard.proto.ApplicationGdprResponse.Action.ActionTypefrom: ".concat(strNextString2));
                                    }
                                    i11 = 3;
                                }
                                zzcjVar.zzb = i11;
                            } else if (b11 != 1) {
                                jsonReader.skipValue();
                            } else {
                                zzcjVar.zza = jsonReader.nextString();
                            }
                        }
                        jsonReader.endObject();
                        zzckVar.zze.add(zzcjVar);
                    }
                    jsonReader.endArray();
                    break;
                case "privacy_options_required":
                    String strNextString3 = jsonReader.nextString();
                    int iHashCode3 = strNextString3.hashCode();
                    if (iHashCode3 != -1888946261) {
                        if (iHashCode3 != 389487519) {
                            if (iHashCode3 == 433141802 && strNextString3.equals("UNKNOWN")) {
                            }
                        } else if (strNextString3.equals("REQUIRED")) {
                        }
                    } else if (strNextString3.equals("NOT_REQUIRED")) {
                    }
                    if (r6 == 0) {
                        i13 = 1;
                    } else if (r6 == 1) {
                        i13 = 2;
                    } else if (r6 != 2) {
                        throw new IOException("Failed to parse contentads.contributor.direct.serving.appswitchboard.proto.ApplicationGdprResponse.PrivacyOptionsRequirementStatusfrom: ".concat(strNextString3));
                    }
                    zzckVar.zzg = i13;
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return zzckVar;
    }
}
