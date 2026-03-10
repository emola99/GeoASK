package com.example.geoankieta

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class QuestionDialog(private val context: Context) {

    fun showSurveyDialog(polygonName: String) {
        val builder = AlertDialog.Builder(context, R.style.RoundedCornersDialog)

        val inflater = LayoutInflater.from(context)
        val dialogView = inflater.inflate(R.layout.question_dialog, null)
        builder.setView(dialogView)

        val surveyTitle = dialogView.findViewById<TextView>(R.id.surveyTitle)
        surveyTitle.text = polygonName

        val ratingBarOverall = dialogView.findViewById<RatingBar>(R.id.ratingBarOverall)
        val radioGroupChanges = dialogView.findViewById<RadioGroup>(R.id.radioGroupChanges)
        val editTextChanges = dialogView.findViewById<EditText>(R.id.editTextChanges)
        val ratingBarFunctionality = dialogView.findViewById<RatingBar>(R.id.ratingBarFunctionality)
        val ratingBarAesthetics = dialogView.findViewById<RatingBar>(R.id.ratingBarAesthetics)
        val ratingBarSafety = dialogView.findViewById<RatingBar>(R.id.ratingBarSafety)
        val ratingBarComfort = dialogView.findViewById<RatingBar>(R.id.ratingBarComfort)
        val ratingBarAccessibility = dialogView.findViewById<RatingBar>(R.id.ratingBarAccessibility)
        val editTextAdditionalComments = dialogView.findViewById<EditText>(R.id.editTextAdditionalComments)
        val editTextEmail = dialogView.findViewById<EditText>(R.id.editTextEmail)
        val lowRatingExplanationLabel1 = dialogView.findViewById<TextView>(R.id.lowRatingExplanationLabel1)
        val editTextLowRatingExplanation1 = dialogView.findViewById<EditText>(R.id.editTextLowRatingExplanation1)
        val lowRatingExplanationLabel2 = dialogView.findViewById<TextView>(R.id.lowRatingExplanationLabel2)
        val editTextLowRatingExplanation2 = dialogView.findViewById<EditText>(R.id.editTextLowRatingExplanation2)
        val lowRatingExplanationLabel3 = dialogView.findViewById<TextView>(R.id.lowRatingExplanationLabel3)
        val editTextLowRatingExplanation3 = dialogView.findViewById<EditText>(R.id.editTextLowRatingExplanation3)
        val lowRatingExplanationLabel4 = dialogView.findViewById<TextView>(R.id.lowRatingExplanationLabel4)
        val editTextLowRatingExplanation4 = dialogView.findViewById<EditText>(R.id.editTextLowRatingExplanation4)
        val lowRatingExplanationLabel5 = dialogView.findViewById<TextView>(R.id.lowRatingExplanationLabel5)
        val editTextLowRatingExplanation5 = dialogView.findViewById<EditText>(R.id.editTextLowRatingExplanation5)

        setupRatingBar(ratingBarFunctionality, lowRatingExplanationLabel1, editTextLowRatingExplanation1)
        setupRatingBar(ratingBarAesthetics, lowRatingExplanationLabel2, editTextLowRatingExplanation2)
        setupRatingBar(ratingBarSafety, lowRatingExplanationLabel3, editTextLowRatingExplanation3)
        setupRatingBar(ratingBarComfort, lowRatingExplanationLabel4, editTextLowRatingExplanation4)
        setupRatingBar(ratingBarAccessibility, lowRatingExplanationLabel5, editTextLowRatingExplanation5)

        val dialog: AlertDialog = builder.create()
        dialog.show()

        dialogView.findViewById<Button>(R.id.positiveButton).setOnClickListener {
            val ratingOverall = ratingBarOverall.rating.toInt()
            val changesRequired = when (radioGroupChanges.checkedRadioButtonId) {
                R.id.radioYes -> "Tak"
                R.id.radioNo -> "Nie"
                else -> ""
            }
            val changes = editTextChanges.text.toString()
            val ratingFunctionality = ratingBarFunctionality.rating.toInt()
            val ratingAesthetics = ratingBarAesthetics.rating.toInt()
            val ratingSafety = ratingBarSafety.rating.toInt()
            val ratingComfort = ratingBarComfort.rating.toInt()
            val ratingAccessibility = ratingBarAccessibility.rating.toInt()
            val additionalComments = editTextAdditionalComments.text.toString()
            val email = editTextEmail.text.toString()
            val lowRatingExplanation1 = editTextLowRatingExplanation1.text.toString()
            val lowRatingExplanation2 = editTextLowRatingExplanation2.text.toString()
            val lowRatingExplanation3 = editTextLowRatingExplanation3.text.toString()
            val lowRatingExplanation4 = editTextLowRatingExplanation4.text.toString()
            val lowRatingExplanation5 = editTextLowRatingExplanation5.text.toString()

            if (email.isEmpty()) {
                editTextEmail.error = "Proszę podać email"
                editTextEmail.requestFocus()
                return@setOnClickListener
            }

            val surveyResponse = SurveyResponse(
                ratingOverall,
                changesRequired,
                changes,
                ratingFunctionality,
                ratingAesthetics,
                ratingSafety,
                ratingComfort,
                ratingAccessibility,
                additionalComments,
                email,
                lowRatingExplanation1,
                lowRatingExplanation2,
                lowRatingExplanation3,
                lowRatingExplanation4,
                lowRatingExplanation5
            )

            val database = FirebaseDatabase.getInstance().getReference("surveys").child(polygonName)
            database.child(email.replace(".", ",")).setValue(surveyResponse)
                .addOnSuccessListener {
                    Toast.makeText(context, "Dziękujemy za opinię!", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                .addOnFailureListener {
                    Toast.makeText(context, "Błąd zapisu danych", Toast.LENGTH_SHORT).show()
                }
        }

        dialogView.findViewById<Button>(R.id.negativeButton).setOnClickListener {
            dialog.dismiss()
        }
    }

    private fun setupRatingBar(
        ratingBar: RatingBar,
        explanationLabel: TextView,
        explanationEditText: EditText
    ) {
        ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            if (rating <= 3) {
                explanationLabel.visibility = View.VISIBLE
                explanationEditText.visibility = View.VISIBLE
            } else {
                explanationLabel.visibility = View.GONE
                explanationEditText.visibility = View.GONE
            }
        }
    }

    data class SurveyResponse(
        val ratingOverall: Int,
        val changesRequired: String,
        val changes: String,
        val ratingFunctionality: Int,
        val ratingAesthetics: Int,
        val ratingSafety: Int,
        val ratingComfort: Int,
        val ratingAccessibility: Int,
        val additionalComments: String,
        val email: String,
        val lowRatingExplanation1: String,
        val lowRatingExplanation2: String,
        val lowRatingExplanation3: String,
        val lowRatingExplanation4: String,
        val lowRatingExplanation5: String
    )
}
