package com.hrishikesh.newsapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_login.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()

        loginButton.setOnClickListener {
            if(checking()){
                var email = edtEmail.text.toString()
                var password = edtPassword.text.toString()

                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        task->
                        if (task.isSuccessful){
                            val intent = Intent(activity, NewsFeed::class.java)
                            startActivity(intent)
                            activity?.finish()
                        }else{
                            Toast.makeText(activity, "Wrong Details", Toast.LENGTH_SHORT).show()
                        }
                    }
            }else{
                Toast.makeText(activity, "Enter Valid Details", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun checking():Boolean {
        if(edtEmail.text.toString().trim { it<=' ' }.isNotEmpty() &&
                edtPassword.text.toString().trim { it<=' ' }.isNotEmpty()){
            return true
        }
        return false
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}