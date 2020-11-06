
package com.example.environmental_codefest.services

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class IssueService {
    private val APIHome : String;
    private val requestQueue : RequestQueue;

    private val IssuesEndpoint = "issues";

    constructor(context : Context, url : String) {
        Log.d("CONTEXT", context.toString());
        APIHome = url;
        requestQueue = Volley.newRequestQueue(context);
    }

    fun getIssues() {
        var request = JsonObjectRequest(
            Request.Method.GET, "$APIHome/$IssuesEndpoint", null,
            Response.Listener { response ->
                Log.d("RESPONSE", response.toString(2));
            },
            Response.ErrorListener { error ->
                Log.d("ERROR", error.toString());
            }
        )

        requestQueue.add(request);
    }
}