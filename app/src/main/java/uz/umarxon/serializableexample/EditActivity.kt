package uz.umarxon.serializableexample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import uz.umarxon.serializableexample.Utils.Constants
import uz.umarxon.serializableexample.model.User

class EditActivity : AppCompatActivity() {

    private var tv: TextView = findViewById(R.id.myTv)

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        /**
         * Bu yerda companion object bo'lgan intent orqali
         * jo'natgan user class ma'lumotimizni olamiz
         *
         * Bu yerda kelgan user malumotlimizni tekshirib olamiz
         * agar u yaratish uchun yoki update qilish uchun bo'lsa create yoki update degan btn larni
         * visible qilamiz agar u shunchaki ko'rish (read) uchun bo'lsa btn larni visiblity.GONE
         * qilib qo'yamiz
         *
         * Agar  [findNavController]  ishlatilganida
         * var myUser:User = arguments.getSerializableExtra("keyUser") as User
         * ko'rinishida bo'lar edi.
         * */

        val myUser: User = intent.getSerializableExtra("keyUser") as User

        val type = intent.getIntExtra("intent_type",0)

        when(type){

            Constants.TYPE_CREATE -> {
                //agar malumot yaratilishi kerak bo'lsa shunga tayyorgarlik ko'riladi
                tv.text = "${myUser.name} \n ${myUser.number}"
            }

            Constants.TYPE_UPDATE -> {
                //agar malumot yangilanishi kerak bo'lsa shunga tayyorgarlik ko'riladi
                tv.text = "${myUser.name} \n ${myUser.number}"
            }

            Constants.TYPE_READ -> {
                //agar malumot shunchaki (read) o'qilishi kerak bo'lsa shunga tayyorgarlik ko'riladi
                tv.text = "${myUser.name} \n ${myUser.number}"
            }

        }

    }
}