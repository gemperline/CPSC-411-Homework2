package com.example.hwk2

import android.util.Log
import com.google.gson.Gson
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity

class ClaimService (val ctx : MainActivity) {

    inner class AddServiceRespHandler : AsyncHttpResponseHandler() {
        override fun onSuccess(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?
        ) {
            if (responseBody != null) {
                val respStr = String(responseBody)
                Log.d("ClaimService", "The add service response: ${respStr}")
                ctx.statusSuccess()
            }

        }

        override fun onFailure(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?,
            error: Throwable?
        ) {
            Log.d("ClaimService", "Error: could not addd to database")
            ctx.statusFail()
        }

    }

    fun addClaim(cObj : Claim) {
        val client = AsyncHttpClient()
        val requestUrl = "http://192.168.56.1:8080/ClaimService/add"
        val JSONString = Gson().toJson(cObj)
        val entity = StringEntity(JSONString)
        client.post(ctx, requestUrl, entity, "application/json", AddServiceRespHandler())
    }
}