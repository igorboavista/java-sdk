package com.konduto.sdk.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.konduto.sdk.models.KondutoBankDocumentType;
import com.konduto.sdk.models.KondutoBankOriginAccount;
import com.konduto.sdk.models.KondutoFlightTravelLeg;

import java.lang.reflect.Type;

/**
 * Created by rsampaio on 7/12/16.
 */
public class KondutoBankOriginAccountAdapter extends KondutoBankAdapter implements JsonSerializer<KondutoBankOriginAccount>, JsonDeserializer<KondutoBankOriginAccount> {

    /**
     * Gson invokes this call-back method during deserialization when it encounters a field of the
     * specified type.
     * <p>In the implementation of this call-back method, you should consider invoking
     * {@link JsonDeserializationContext#deserialize(JsonElement, Type)} method to create objects
     * for any non-trivial field of the returned object. However, you should never invoke it on the
     * the same type passing {@code json} since that will cause an infinite loop (Gson will call your
     * call-back method again).
     *
     * @param je      The Json data being deserialized
     * @param typeOfT The type of the Object to deserialize to
     * @param context
     * @return a deserialized object of the specified type typeOfT which is a subclass of {@code T}
     * @throws JsonParseException if json is not in the expected format of {@code typeofT}
     */
    @Override
    public KondutoBankOriginAccount deserialize(JsonElement je, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject json = (JsonObject) je;

        KondutoBankOriginAccount originAccount = new KondutoBankOriginAccount();

        if (json.has("id")) {
            originAccount.setId(json.get("id").getAsString());
        }
        if (json.has("key_type")) {
            originAccount.setKeyType(KondutoBankDocumentType.valueOf(json.get("key_type").getAsString().toUpperCase()));
        }
        if (json.has("key_value")) {
            originAccount.setKeyValue(json.get("key_value").getAsString());
        }
        if (json.has("holder_name")) {
            originAccount.setHolderName(json.get("holder_name").getAsString());
        }
        if (json.has("holder_tax_id")) {
            originAccount.setHolderTaxId(json.get("holder_tax_id").getAsString());
        }
        if (json.has("bank_code")) {
            originAccount.setBankCode(json.get("bank_code").getAsString());
        }
        if (json.has("bank_name")) {
            originAccount.setBankName(json.get("bank_name").getAsString());
        }
        if (json.has("bank_branch")) {
            originAccount.setBankBranch(json.get("bank_branch").getAsString());
        }
        if (json.has("bank_account")) {
            originAccount.setBankAccount(json.get("bank_account").getAsString());
        }
        if (json.has("balance")) {
            originAccount.setBalance(json.get("balance").getAsDouble());
        }

        return originAccount;
    }

    /**
     * Gson invokes this call-back method during serialization when it encounters a field of the
     * specified type.
     * <p>In the implementation of this call-back method, you should consider invoking
     * {@link JsonSerializationContext#serialize(Object, Type)} method to create JsonElements for any
     * non-trivial field of the {@code src} object. However, you should never invoke it on the
     * {@code src} object itself since that will cause an infinite loop (Gson will call your
     * call-back method again).</p>
     *
     * @param originAccount the object that needs to be converted to Json.
     * @param typeOfSrc the actual type (fully genericized version) of the source object.
     * @param context
     * @return a JsonElement corresponding to the specified object.
     */
    @Override
    public JsonElement serialize(KondutoBankOriginAccount originAccount, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject json = (JsonObject) super.serialize(originAccount);

//        if (originAccount.getId() != null) {
//            json.addProperty("id", originAccount.getId());
//        }
//        if (originAccount.getKeyType() != null) {
//            json.addProperty("key_type", originAccount.getKeyType().toString().toLowerCase());
//        }
//        if (originAccount.getKeyValue() != null) {
//            json.addProperty("key_value", originAccount.getKeyValue());
//        }
//        if (originAccount.getHolderName() != null) {
//            json.addProperty("holder_name", originAccount.getHolderName());
//        }
//        if (originAccount.getHolderTaxId() != null) {
//            json.addProperty("holder_tax_id", originAccount.getHolderTaxId());
//        }
//        if (originAccount.getBankCode() != null) {
//            json.addProperty("bank_code", originAccount.getBankCode());
//        }
//        if (originAccount.getBankName() != null) {
//            json.addProperty("bank_name", originAccount.getBankName());
//        }
//        if (originAccount.getBankBranch() != null) {
//            json.addProperty("bank_branch", originAccount.getBankBranch());
//        }
//        if (originAccount.getBankAccount() != null) {
//            json.addProperty("bank_account", originAccount.getBankAccount());
//        }
        if (originAccount.getBalance() != null) {
            json.addProperty("balance", originAccount.getBalance());
        }

        return json;
    }

}
