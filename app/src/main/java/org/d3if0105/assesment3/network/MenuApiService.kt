package org.d3if0105.assesment3.network



import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.d3if0105.assesment3.model.Menu
import org.d3if0105.assesment3.model.OpStatus
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

private const val BASE_URL = "https://unspoken.my.id/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface   MenuApiService {
    @GET(" api_arrifa.php")
    suspend fun getMenu(
        @Header("Authorization") userId: String
    ):List<Menu>
    @Multipart
    @POST(" api_arrifa.php")
    suspend fun postMenu(
        @Header("Authorization") userId: String,
        @Part("nama_menu") nama_menu: RequestBody,
        @Part("kategori_menu") kategori_menu: RequestBody,
        @Part image: MultipartBody.Part
    ): OpStatus
    @DELETE(" api_arrifa.php")
    suspend fun deleteHewan(
        @Header("Authorization") userId: String,
        @Query("id") menuId: String
    ) : OpStatus
}

object MenuApi {
    val service: MenuApiService by lazy {
        retrofit.create( MenuApiService::class.java)
    }

    fun getMenuUrl(imageId: String): String {
        return "${BASE_URL}image.php?id=$imageId"
    }
}

enum class ApiStatus {LOADING, SUCCESS, FAILED}
