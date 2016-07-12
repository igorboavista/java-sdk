package com.konduto.sdk.adapters;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.konduto.sdk.models.*;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * KondutoTravelAdapter to deserialize KondutoTravel objects.
 *
 */
public class KondutoTravelAdapter implements JsonDeserializer<KondutoTravel> {

    private static final Type BUS_TRAVEL_LEG_TYPE = new TypeToken<KondutoBusTravelLeg>(){}.getType();
    private static final Type FLIGHT_TRAVEL_LEG_TYPE = new TypeToken<KondutoFlightTravelLeg>(){}.getType();


    /**
     * Gson invokes this call-back method during deserialization when it encounters a field of the
     * specified type.
     * <p>In the implementation of this call-back method, you should consider invoking
     * {@link JsonDeserializationContext#deserialize(JsonElement, Type)} method to create objects
     * for any non-trivial field of the returned object. However, you should never invoke it on the
     * the same type passing {@code json} since that will cause an infinite loop (Gson will call your
     * call-back method again).
     *
     * @param je    The Json data being deserialized
     * @param typeOfT The type of the Object to deserialize to
     * @param context
     * @return a deserialized object of the specified type typeOfT which is a subclass of {@code T}
     * @throws JsonParseException if json is not in the expected format of {@code typeofT}
     */
    @Override
    public KondutoTravel deserialize(JsonElement je, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject json = (JsonObject) je;
        KondutoTravel travel = new KondutoTravel();
        String travelTypeAsStr = json.get("type").getAsString().toUpperCase();
        KondutoTravelType travelType = KondutoTravelType.valueOf(travelTypeAsStr);
        JsonObject departureJson = json.getAsJsonObject("departure");
        JsonObject returnJson = json.has("return") ? json.getAsJsonObject("return") : null;

        Type legType = travelType.equals(KondutoTravelType.BUS) ? BUS_TRAVEL_LEG_TYPE :
                travelType.equals(KondutoTravelType.FLIGHT) ? FLIGHT_TRAVEL_LEG_TYPE : null;

        if(legType == null) { throw new RuntimeException("Invalid travel type"); }

        travel.setDepartureLeg((KondutoTravelLeg) context.deserialize(departureJson, legType));
        travel.setReturnLeg((KondutoTravelLeg) context.deserialize(returnJson, legType));
        setTravelPassengers(json.getAsJsonArray("passengers"), travel);
        travel.setTravelType(travelType);
        return travel;
    }

    private void setTravelPassengers(JsonArray passengersJsonArray, KondutoTravel travel) {
        if(passengersJsonArray == null || passengersJsonArray.size() == 0) { return; }
        List<KondutoPassenger> passengers = new ArrayList<KondutoPassenger>();
        for(JsonElement jsonObject : passengersJsonArray) {
            KondutoPassenger passenger = (KondutoPassenger)
                    KondutoModel.fromJSON((JsonObject) jsonObject, KondutoPassenger.class);
            passengers.add(passenger);
        }
        travel.setPassengers(passengers);
    }
}
