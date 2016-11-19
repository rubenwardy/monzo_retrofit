package com.rubenwardy.monzo_retrofit;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

class DateDeserializer implements JsonDeserializer<Date> {
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS'Z'");

    public DateDeserializer() {
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    @Override
    public Date deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
            throws JsonParseException {
        try {
            return df.parse(json.getAsString());
        } catch (ParseException e) {
            return null;
        }
    }
}
