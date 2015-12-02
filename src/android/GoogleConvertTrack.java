package com.get4x.plugins.googleconverttrack;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.ads.conversiontracking.*;

public class GoogleConvertTrack extends CordovaPlugin 
{

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException
    {
        String conversion_id = args.getString(0);
        String tracking_label = args.getString(1);
        String tracking_value = args.getString(2);
        Boolean repeatable = args.getBoolean(3);
        
        if (action.equals("reportWithConversionId"))
        {
            this.reportWithConversionId(conversion_id, tracking_label, tracking_value, repeatable, callbackContext);
            return true;
        } 
        else if (action.equals("registerReferrer"))
        {
            this.registerReferrer(callbackContext);
            return true;
        }
        return false;
    }

    private void reportWithConversionId(String conversion_id, String tracking_label, String tracking_value, Boolean repeatable, CallbackContext callbackContext)
    {
        try 
        {
            // static void
            AdWordsConversionReporter.reportWithConversionId(
                this.cordova.getActivity().getApplicationContext(),
                conversion_id,
                tracking_label,
                tracking_value,
                repeatable);
            callbackContext.success();
        }
        catch(final Exception e) 
        {
            callbackContext.error("Error At GoogleConvertTrack.reportWithConversionId: " + e.getMessage());
        }
    }
    
    private void registerReferrer(String conversion_id, String tracking_label, String tracking_value, Boolean repeatable, CallbackContext callbackContext)
    {
        try 
        {
            // static void
            String data = getIntent().getDataString();
            Boolean result = AdWordsConversionReporter.registerReferrer(
                this.cordova.getActivity().getApplicationContext(), 
                this.getIntent().getData());
            callbackContext.success("success registerReferrer: " + data + " ; result=" + result);
        }
        catch(final Exception e) 
        {
            callbackContext.error("Error At GoogleConvertTrack.registerReferrer: " + e.getMessage());
        }
    }
}
