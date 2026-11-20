package dc;

import androidx.annotation.Nullable;
import com.cloud.tmc.kernel.bridge.extension.bind.BindException;
import com.cloud.tmc.kernel.bridge.extension.bind.RequiredParamNotFoundException;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class g<T> implements b<cc.g, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public JsonObject f63026a;

    public g(@Nullable JsonObject jsonObject) {
        this.f63026a = jsonObject;
    }

    @Override // dc.b
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public T a(Class<T> cls, cc.g gVar) throws BindException {
        String[] strArrValue = gVar.value();
        if (strArrValue == null || strArrValue.length <= 0) {
            strArrValue = gVar.name();
        }
        if (strArrValue == null || strArrValue.length <= 0) {
            throw new BindException("bind key is null");
        }
        String str = null;
        try {
            int length = strArrValue.length;
            JsonElement jsonElement = null;
            T tCast = null;
            String str2 = null;
            for (int i11 = 0; i11 < length; i11++) {
                try {
                    str2 = strArrValue[i11];
                    JsonObject jsonObject = this.f63026a;
                    jsonElement = jsonObject == null ? null : jsonObject.get(str2);
                    if (jsonElement != null) {
                        if (cls.isPrimitive()) {
                            if (cls == Boolean.TYPE) {
                                tCast = (T) new Gson().fromJson(String.valueOf(jsonElement.getAsBoolean()), (Class) cls);
                            } else if (cls == Integer.TYPE) {
                                tCast = (T) new Gson().fromJson(String.valueOf(jsonElement.getAsInt()), (Class) cls);
                            } else if (cls == Float.TYPE) {
                                tCast = (T) new Gson().fromJson(String.valueOf(jsonElement.getAsFloat()), (Class) cls);
                            } else if (cls == Double.TYPE) {
                                tCast = (T) new Gson().fromJson(String.valueOf(jsonElement.getAsDouble()), (Class) cls);
                            } else if (cls == Long.TYPE) {
                                tCast = (T) new Gson().fromJson(String.valueOf(jsonElement.getAsLong()), (Class) cls);
                            }
                        } else if (cls == String.class) {
                            tCast = cls.cast(jsonElement.getAsString());
                        } else if (cls == Boolean.class) {
                            tCast = cls.cast(Boolean.valueOf(jsonElement.getAsBoolean()));
                        } else if (cls == Integer.class) {
                            tCast = cls.cast(Integer.valueOf(jsonElement.getAsInt()));
                        } else if (cls == Float.class) {
                            tCast = cls.cast(Float.valueOf(jsonElement.getAsFloat()));
                        } else if (cls == Double.class) {
                            tCast = cls.cast(Double.valueOf(jsonElement.getAsDouble()));
                        } else if (cls == Long.class) {
                            tCast = cls.cast(Long.valueOf(jsonElement.getAsLong()));
                        } else if (cls == JsonObject.class) {
                            tCast = cls.cast(jsonElement.getAsJsonObject());
                        } else if (cls == JsonArray.class) {
                            tCast = cls.cast(jsonElement.getAsJsonArray());
                        }
                    }
                    if (tCast != null) {
                        return tCast;
                    }
                } catch (Exception e11) {
                    e = e11;
                    str = str2;
                    TmcLogger.g("TmcKernel", "Binding targetType: " + cls + " with: " + this.f63026a + " key: " + str + " exception!", e);
                    throw new BindException(e.getMessage());
                }
            }
            if (jsonElement != null) {
                return tCast;
            }
            if (gVar.required()) {
                throw new RequiredParamNotFoundException(strArrValue[0] + " param is missing!");
            }
            if (cls.isPrimitive()) {
                if (cls == Boolean.TYPE) {
                    return (T) new Gson().fromJson(String.valueOf(gVar.booleanDefault()), (Class) cls);
                }
                if (cls == Integer.TYPE) {
                    return (T) new Gson().fromJson(String.valueOf(gVar.intDefault()), (Class) cls);
                }
                if (cls == Float.TYPE) {
                    return (T) new Gson().fromJson(String.valueOf(gVar.floatDefault()), (Class) cls);
                }
                if (cls == Double.TYPE) {
                    return (T) new Gson().fromJson(String.valueOf(gVar.doubleDefault()), (Class) cls);
                }
                return cls == Long.TYPE ? (T) new Gson().fromJson(String.valueOf(gVar.longDefault()), (Class) cls) : tCast;
            }
            if (cls == String.class) {
                return cls.cast(gVar.stringDefault());
            }
            if (cls == Boolean.class) {
                return cls.cast(Boolean.valueOf(gVar.booleanDefault()));
            }
            if (cls == Integer.class) {
                return cls.cast(Integer.valueOf(gVar.intDefault()));
            }
            if (cls == Float.class) {
                return cls.cast(Float.valueOf(gVar.floatDefault()));
            }
            if (cls == Double.class) {
                return cls.cast(Double.valueOf(gVar.doubleDefault()));
            }
            return cls == Long.class ? cls.cast(Long.valueOf(gVar.longDefault())) : tCast;
        } catch (Exception e12) {
            e = e12;
        }
    }
}
