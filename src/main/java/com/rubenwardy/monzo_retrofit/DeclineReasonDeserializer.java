package com.rubenwardy.monzo_retrofit;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

class DeclineReasonDeserializer implements JsonDeserializer<Transaction.DeclineReason> {
    @Override
    public Transaction.DeclineReason deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        Transaction.DeclineReason[] scopes = Transaction.DeclineReason.values();
        for (Transaction.DeclineReason scope : scopes) {
            if (scope.toString().equals(json.getAsString())) {
                return scope;
            }
        }
        return null;
    }
}