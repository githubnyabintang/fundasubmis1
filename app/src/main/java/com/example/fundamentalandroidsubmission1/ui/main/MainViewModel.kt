    package com.example.fundamentalandroidsubmission1.ui.main

    import android.util.Log
    import androidx.lifecycle.LiveData
    import androidx.lifecycle.MutableLiveData
    import androidx.lifecycle.ViewModel
    import com.example.fundamentalandroidsubmission1.api.RetrofitClient
    import com.example.fundamentalandroidsubmission1.data.model.User
    import com.example.fundamentalandroidsubmission1.data.model.UserResponse
    import retrofit2.Call
    import retrofit2.Callback
    import retrofit2.Response

    class MainViewModel: ViewModel() {

        val listUsers = MutableLiveData<ArrayList<User>>()

        fun setSearchUsers(query:String){
            RetrofitClient.apiInstance
                .getSearchUsers(query)
                .enqueue(object : Callback<UserResponse> {
                    override fun onResponse(
                        call: Call<UserResponse>,
                        response: Response<UserResponse>
                    ) {
                        if (response.isSuccessful){
                            listUsers.postValue(response.body()?.items)
                        }
                    }

                    override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                        Log.e("Failure", "Error: ${t.message}")
                    }

                })
        }

        fun getSearchUsers(): LiveData<ArrayList<User>>{
            return listUsers
        }
    }