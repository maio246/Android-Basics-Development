package com.example.michael.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    String workerName;

    int quantity = 0;

    double pricePerCup = 5;
    double creamTopping = 0;
    double chocolateTopping = 0;

    double finalPrice = 0d;

    boolean hasWhippedCream = false;
    boolean hasChocolate = false;

    String creamToppingMessage = "No";
    String chocolateToppingMessage = "No";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method updates the final price and screen view
     */
    private void updateScreenView() {
        updateWhippedCream();
        updateChocolate();
        updateFinalPrice();
        displayQuantity();
        displayPrice();
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        this.quantity += 1;
        updateScreenView();
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (this.quantity > 0) {
            this.quantity -= 1;
        }
        updateScreenView();
    }

    /**
     * This method checks if chocolate is selected and sets value
     */
    private void updateWhippedCream() {

        if (hasWhippedCream) {
            creamTopping = 0.5;
            creamToppingMessage = "Yes";
        } else if (!hasWhippedCream) {
            creamTopping = 0;
            creamToppingMessage = "No";
        }
        updateFinalPrice();
    }

    /**
     * This method checks if chocolate is selected and sets value
     */
    private void updateChocolate() {

        if (hasChocolate) {
            chocolateTopping = 0.7;
            chocolateToppingMessage = "Yes";
        } else if (!hasChocolate) {
            chocolateTopping = 0;
            chocolateToppingMessage = "No";
        }
        updateFinalPrice();
    }

    /**
     * This method is called when the Whipped Cream CheckBox is clicked.
     */
    public void addRemoveWhippedCream(View view) {
        CheckBox whippedCreamBox = (CheckBox) findViewById(R.id.whipped_cream_box);
        hasWhippedCream = whippedCreamBox.isChecked();
        updateScreenView();
    }

    /**
     * This method is called when the Chocolate CheckBox is clicked.
     */
    public void addRemoveChocolate(View view) {
        CheckBox chocolateBox = (CheckBox) findViewById(R.id.chocolate_box);
        hasChocolate = chocolateBox.isChecked();
        updateScreenView();
    }

    /**
     * update the final price value
     */
    private void updateFinalPrice() {
        finalPrice = quantity * (pricePerCup + creamTopping + chocolateTopping);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText workerNames = (EditText) findViewById(R.id.worker_name);
        String workerName = workerNames.getText().toString();

        StringBuilder sb = new StringBuilder();
        String servedByMessageToDisplay = "You were served by %s\n";
        String creamMessageToDisplay = "Cream: %s\n";
        String chocolateMessageToDisplay = "Chocolate: %s\n";
        String quantityMessageToDisplay = "Quantity: %d\n";
        String totalMessageToDisplay = "Total: $%.2f \n Thank you!";

        sb.append(String.format(servedByMessageToDisplay, workerName));
        sb.append(String.format(creamMessageToDisplay, creamToppingMessage));
        sb.append(String.format(chocolateMessageToDisplay, chocolateToppingMessage));

        sb.append(String.format(quantityMessageToDisplay, quantity));
        sb.append(String.format(totalMessageToDisplay, finalPrice));

        displayFinalOrder(sb.toString().trim());
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity() {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + quantity);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice() {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(finalPrice));
    }

    /**
     * This method displays the final price on the screen.
     */
    private void displayFinalOrder(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

}