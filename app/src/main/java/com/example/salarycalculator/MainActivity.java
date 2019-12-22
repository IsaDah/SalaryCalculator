package com.example.salarycalculator;

    import androidx.appcompat.app.AppCompatActivity;

    import android.os.Bundle;

    import android.view.View;
    import android.widget.EditText;

    import android.widget.Toast;
    import android.view.View.OnClickListener;
    import android.widget.Button;


public class MainActivity extends AppCompatActivity
{
    private EditText baseSalaryEditText;
    private EditText housingBenefitEditText;
    private EditText transportationBenefitEditText;
    private EditText healthBenefitEditText;
    private EditText vacationBenefitEditText;

    private EditText totalSalaryEditText;
    private Button calculateTotalSalaryButton;

    private EditText taxRateEditText;
    private EditText houseRentEditText;

    private EditText salaryAfterTaxRentEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baseSalaryEditText = (EditText)findViewById(R.id.edit_text_base_salary);
        housingBenefitEditText = (EditText)findViewById(R.id.edit_text_housing_benefit);
        transportationBenefitEditText = (EditText)findViewById(R.id.edit_text_transportation_benefit);
        healthBenefitEditText = (EditText)findViewById(R.id.edit_text_health_benefit);
        vacationBenefitEditText = (EditText)findViewById(R.id.edit_text_vacation_benefit);

        totalSalaryEditText = (EditText)findViewById(R.id.edit_text_total_salary);

        calculateTotalSalaryButton = (Button)findViewById(R.id.button_calculate_total_salary_before_tax);

        taxRateEditText = (EditText)findViewById(R.id.edit_text_tax);
        houseRentEditText = (EditText)findViewById(R.id.edit_text_house_rent);

        salaryAfterTaxRentEditText = (EditText)findViewById(R.id.edit_text_salary_after_rent_and_tax);

        baseSalaryEditText.setText("0");
        housingBenefitEditText.setText("0");
        transportationBenefitEditText.setText("0");
        healthBenefitEditText.setText("0");
        vacationBenefitEditText.setText("0");
        totalSalaryEditText.setText("0");
        taxRateEditText.setText("0");
        houseRentEditText.setText("0");
        salaryAfterTaxRentEditText.setText("0");




        calculateTotalSalaryButton.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                try
                {
                    double baseSalary = Double.parseDouble(baseSalaryEditText.getText().toString());
                    double housingBenefitPercentage = Double.parseDouble(housingBenefitEditText.getText().toString());
                    double transportationBenefitPercentage = Double.parseDouble(transportationBenefitEditText.getText().toString());
                    double healthBenefitPercentage = Double.parseDouble(healthBenefitEditText.getText().toString());
                    double vacationBenefitPercentage = Double.parseDouble(vacationBenefitEditText.getText().toString());
                    double taxRate = Double.parseDouble(taxRateEditText.getText().toString());
                    double houseRent = Double.parseDouble(houseRentEditText.getText().toString());

                    double housingBenefit = baseSalary * housingBenefitPercentage / 100;
                    double transportationBenefit = baseSalary * transportationBenefitPercentage / 100;
                    double healthBenefit = baseSalary * healthBenefitPercentage / 100;
                    double vacationBenefit = baseSalary * vacationBenefitPercentage / 100;

                    double totalSalary = housingBenefit + transportationBenefit + healthBenefit + vacationBenefit + baseSalary;
                    totalSalaryEditText.setText(String.valueOf(totalSalary));

                    double salaryTax = totalSalary * taxRate / 100;

                    double salaryAfterTaxRent = totalSalary - salaryTax - houseRent;

                    salaryAfterTaxRentEditText.setText(String.valueOf(salaryAfterTaxRent));
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this,"Invalid Input", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}

