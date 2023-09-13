import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.td1_kotlin_project.data.model.AndroidObject
import com.example.td1_kotlin_project.data.repository.AndroidVersionRepository
import com.example.td1_kotlin_project.ui.data.ItemUi
import com.example.td1_kotlin_project.ui.data.toUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlin.random.Random

class AndroidVersionViewModel : ViewModel() {


    private val androidVersionRepository: AndroidVersionRepository by lazy { AndroidVersionRepository() }


    private val _androidVersionList: Flow<List<ItemUi>>
        get() = androidVersionRepository.selectAllAndroidVersion().map { androidObjectList ->
            androidObjectList.groupBy { myAndroidObject ->
                myAndroidObject.versionName
            }
                .flatMap {
                    buildList {
                        add(
                            ItemUi.Header(
                                title = it.key,// versionName
                            )
                        )

                        addAll(it.value.toUi())
                    }
                }
        }
    val androidVersionList = _androidVersionList

    fun insertAndroidVersion() {
        viewModelScope.launch(Dispatchers.IO) {
            val random = Random.nextInt(0, 10)
            androidVersionRepository.insertAndroidVersion(
                AndroidObject("Android $random", "$random")
            )
        }
    }


    fun deleteAllAndroidVersion() {
        viewModelScope.launch(Dispatchers.IO) {
            androidVersionRepository.deleteAllAndroidVersion()
        }
    }

}
