package com.konduto.sdk.adapters;

import com.google.gson.*;
import com.konduto.sdk.models.KondutoBusTravelLeg;
import com.konduto.sdk.models.KondutoTravelClass;

import java.lang.reflect.Type;

/**
 * Created by rsampaio on 7/12/16.
 *
 */
public class KondutoBusTravelLegAdapter extends KondutoTravelLegAdapter implements JsonSerializer<KondutoBusTravelLeg>, JsonDeserializer<KondutoBusTravelLeg> {
    /**
     * Gson invokes this call-back method during deserialization when it encounters a field of the
     * specified type.
     * <p>In the implementation of this call-back method, you should consider invoking
     * {@link JsonDeserializationContext#deserialize(JsonElement, Type)} method to create objects
     * for any non-trivial field of the returned object. However, you should never invoke it on the
     * the same type passing {@code json} since that will cause an infinite loop (Gson will call your
     * call-back method again).
     *
     * @param je The Json data being deserialized
     * @param typeOfT The type of the Object to deserialize to
     * @param context
     * @return a deserialized object of the specified type typeOfT which is a subclass of {@code T}
     * @throws JsonParseException if json is not in the expected format of {@code typeofT}
     */
    @Override
    public KondutoBusTravelLeg deserialize(JsonElement je, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject json = (JsonObject) je;
        KondutoBusTravelLeg travelLeg = new KondutoBusTravelLeg();

        if(json.has("origin_city")) {
            travelLeg.setOriginCity(json.get("origin_city").getAsString());
        }
        if(json.has("destination_city")) {
            travelLeg.setDestinationCity(json.get("destination_city").getAsString());
        }

        if(json.has("date")) {
            setLegDate(json.get("date").getAsString(), travelLeg);
        }

        if(json.has("fare_basis")) {
            travelLeg.setFareBasis(json.get("fare_basis").getAsString());
        }

        if(json.has("number_of_connections")) {
            travelLeg.setNumberOfConnections(json.get("number_of_connections").getAsInt());
        }

        if(json.has("class")) {
            travelLeg.setTravelClass(KondutoTravelClass.valueOf(json.get("class").getAsString().toUpperCase()));
        }

        return travelLeg;
    }

    /**
     * Gson invokes this call-back method during serialization when it encounters a field of the
     * specified type.
     * <p/>
     * <p>In the implementation of this call-back method, you should consider invoking
     * {@link JsonSerializationContext#serialize(Object, Type)} method to create JsonElements for any
     * non-trivial field of the {@code src} object. However, you should never invoke it on the
     * {@code src} object itself since that will cause an infinite loop (Gson will call your
     * call-back method again).</p>
     *
     * @param travelLeg       the object that needs to be converted to Json.
     * @param typeOfSrc the actual type (fully genericized version) of the source object.
     * @param context
     * @return a JsonElement corresponding to the specified object.
     */
    @Override
    public JsonElement serialize(KondutoBusTravelLeg travelLeg, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject json = (JsonObject) super.serialize(travelLeg);
        if(travelLeg.getDestinationCity() != null) {
            json.addProperty("destination_city", travelLeg.getDestinationCity());
        }
        if(travelLeg.getOriginCity() != null) {
            json.addProperty("origin_city", travelLeg.getOriginCity());
        }
        return json;
    }
}
