package uz.umarxon.serializableexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import uz.umarxon.serializableexample.Utils.Constants
import uz.umarxon.serializableexample.model.User

class MainActivity : AppCompatActivity() {

    //Button ni initialization qilinmoqda
    private var btn: View = findViewById(R.id.second_page)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //User class Serializable dan implement qilingan bo'lishi kerak
        val user = User()

        //user ni field lariga qiymat berish uchun
        user.name = "Codial"
        user.number = "+998-**-***-**-**"

        //button bosilganda
        btn.setOnClickListener {

            /**
             * Agar  [findNavController()] dan foydalanmoqchi bo'lsangiz
             *
             * var myBundle = bundleOf("keyUser" to user)
             *
             * findNavController(R.id.myFragment,myBundle)
             *
             * Shunday ko'rinishda ham qo'llash mumkin !!
             *
             * */

            //editActivity ga intent dan obyekt olish uchun
            val intent = Intent(this,EditActivity::class.java)

            //keyUser ga user ma'lumot qo'yilmoqda
            intent.putExtra("keyUser",user)

            /**
             * intent type berish orqali biz jonatgan malumotni qabul qilish vaqtida uni yaratish
             * yangilash yoki shunchaki ko'rsatish uchunligini aytamiz
             * bularni utils papka ichidagi Constants objectidan olamiz
             * Eslatma : Constants object ishni tshunarli bo'lishi uchun yaratilgan
             *
             *
             * Bu yaratish uchun
             * intent.putExtra("intent_type",Constants.TYPE_CREATE)
             *
             * Bu yangilash uchun
             * intent.putExtra("intent_type",Constants.TYPE_UPDATE)
             *
             * Bu O'qish uchun
             * intent.putExtra("intent_type",Constants.TYPE_READ)
             *
             * */

            //Biz yangilash misolida ko'ramiz
            intent.putExtra("intent_type",Constants.TYPE_UPDATE)

            //editActivity ga intent so'rovi orqali borish
            startActivity(intent)

        }

    }
}