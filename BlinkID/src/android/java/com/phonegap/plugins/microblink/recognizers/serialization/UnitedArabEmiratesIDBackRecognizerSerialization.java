package com.phonegap.plugins.microblink.recognizers.serialization;

import com.microblink.entities.recognizers.Recognizer;
import com.phonegap.plugins.microblink.recognizers.RecognizerSerialization;
import com.phonegap.plugins.microblink.recognizers.SerializationUtils;

import org.json.JSONException;
import org.json.JSONObject;

public final class UnitedArabEmiratesIDBackRecognizerSerialization implements RecognizerSerialization {

    @Override
    public Recognizer<?, ?> createRecognizer(JSONObject jsonRecognizer) {
        com.microblink.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesIDBackRecognizer recognizer = new com.microblink.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesIDBackRecognizer();
        recognizer.setDetectGlare(jsonRecognizer.optBoolean("detectGlare", true));
        recognizer.setReturnFullDocumentImage(jsonRecognizer.optBoolean("returnFullDocumentImage", false));
        return recognizer;
    }

    @Override
    public JSONObject serializeResult(Recognizer<?, ?> recognizer) {
        com.microblink.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesIDBackRecognizer.Result result = ((com.microblink.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesIDBackRecognizer)recognizer).getResult();
        JSONObject jsonResult = new JSONObject();
        try {
            SerializationUtils.addCommonResultData(jsonResult, result);
            jsonResult.put("MRZResult", BlinkIDSerializationUtils.serializeMRZResult(result.getMRZResult()));
            jsonResult.put("fullDocumentImage", SerializationUtils.encodeImageBase64(result.getFullDocumentImage()));
        } catch (JSONException e) {
            // see https://developer.android.com/reference/org/json/JSONException
            throw new RuntimeException(e);
        }
        return jsonResult;
    }

    @Override
    public String getJsonName() {
        return "UnitedArabEmiratesIDBackRecognizer";
    }

    @Override
    public Class<?> getRecognizerClass() {
        return com.microblink.entities.recognizers.blinkid.unitedArabEmirates.UnitedArabEmiratesIDBackRecognizer.class;
    }
}