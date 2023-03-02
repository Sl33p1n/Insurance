package my.edu.tarc.insurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import my.edu.tarc.insurance.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener{

            var basic: Int = 0
            var extra: Int = 0
            var total: Int = 0

            val age = binding.spinnerAge.selectedItemPosition
            if (age == 0){

                basic = 60
            }else if (age == 1) {
                basic = 70
            }
            else if (age == 2) {
                basic = 90
            }
            else if (age == 3) {
                basic = 120
            }
            else if (age == 4) {
                basic = 150
            }
            else {
                basic = 150
            }

            val gender = binding.radioGroupGender.checkedRadioButtonId
            if (gender == binding.radioButtonMale.id){

                if (age == 0) {
                    extra = 0
                }
                else if (age == 1) {
                    extra = 50
                }
                else if (age == 2) {
                    extra = 100
                }
                else if (age == 3) {
                    extra = 150
                }
                else if (age == 4) {
                    extra = 200
                }
                else{
                    extra = 200
                }
            }

            val smoker = binding.checkBoxSmoker.isChecked
            if (smoker) {
                if (age == 0) {
                    extra += 0
                }
                else if (age == 1) {
                    extra +=100
                }
                else if (age == 2) {
                    extra += 150
                }
                else if (age == 3 ) {
                    extra += 200
                }
                else if (age == 4) {
                    extra += 250
                }
                else {
                    extra += 300
                }
            }
            total = basic + extra
            val premium: Premium = Premium(basic, extra, total)
            binding.myPremium = premium
        }

        binding.buttonReset.setOnClickListener {
            val premium = Premium(0,0,0)
            binding.myPremium = premium

            binding.spinnerAge.selectedItemPosition == 0
            binding.radioGroupGender.clearCheck()
            binding.checkBoxSmoker.isChecked = false
        }
    }
}