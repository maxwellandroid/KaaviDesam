package com.maxwell.kaavidesam;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;

public class StringConstants {
    public static String prefNallaneram="NallaNeram";
    public static String prefRahukalam="RahuKalam";
    public static String prefKuligai="Kuligai";
    public static String prefYamakantam="Yamakantam";
    public static String prefSooriyaOrai="SooriyaOrai";
    public static String prefChandiraOrai="ChandiraOrai";
    public static String prefSevvayOrai="ChevvayOrai";
    public static String prefButhaOrai="ButhaOrai";
    public static String prefGuruOrai="GuruOrai";
    public static String prefSukkiraOrai="SukkiraOrai";
    public static String prefSaniOrai="SaniOrai";

    public static String mainUrl="http://www.kaavidesam.com/api/";
    public static String dailyDetailUrl="daily_details.php?dates=";
    public static String monthDetailUrl="monthlydetails.php?dates=";
    public static String ErrorMessage(VolleyError volleyError) {
        String message = null;
        if (volleyError instanceof NetworkError) {
            message = "Cannot connect to Internet...Please check your connection!";
// Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        } else if (volleyError instanceof ServerError) {
            message = "The server could not be found. Please try again after some time!!";
// Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        } else if (volleyError instanceof AuthFailureError) {
            message = "Cannot connect to Internet...Please check your connection!";
// Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        } else if (volleyError instanceof ParseError) {
            message = "Parsing error! Please try again after some time!!";
// Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        } else if (volleyError instanceof NoConnectionError) {
            message = "Cannot connect to Internet...Please check your connection!";
//Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        } else if (volleyError instanceof TimeoutError) {
            message = "Connection TimeOut! Please check your internet connection.";
//Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        }

        //   Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

        return message;
    }


}
