package com.example.client_api

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.uqpay.sdk.api.UQPayApi
import com.uqpay.sdk.api.model.OrderInfo
import com.uqpay.sdk.api.utils.EnvEnum
import com.uqpay.sdk.api.utils.ScenesEnum


class MainActivity : AppCompatActivity() {

    private lateinit var codeEdit:EditText
    private lateinit var message:TextView
    private lateinit var uqPayApi: UQPayApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        codeEdit = findViewById(R.id.enter_order_code)
        message = findViewById(R.id.message)
        uqPayApi = UQPayApi().env(EnvEnum.TEST) // use test mode for development
    }
    fun doPay(v: View) {
        val acceptCode:String = codeEdit.text.toString()
        // check if install the wallet app
        if (uqPayApi.checkWalletInstalled(this, ScenesEnum.UnionPay)) {
            uqPayApi.pay(this, OrderInfo(acceptCode, ScenesEnum.UnionPay))
        } else {
            message.text = getString(R.string.installWallet)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            message.text = getString(R.string.paymentDone)
        }
    }

}
