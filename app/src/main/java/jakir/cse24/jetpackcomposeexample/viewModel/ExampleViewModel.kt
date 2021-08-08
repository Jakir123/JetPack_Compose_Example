package jakir.cse24.jetpackcomposeexample.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import jakir.cse24.jetpackcomposeexample.model.JetpackExample

class ExampleViewModel : ViewModel() {
    val examplesList: MutableLiveData<List<JetpackExample>> by lazy {
        MutableLiveData<List<JetpackExample>>()
    }

    private var exampleList: ArrayList<JetpackExample> = ArrayList()

    init {
        getExampleList()
    }

    private fun  getExampleList(){
        generateList()
        examplesList.value = exampleList
    }

    private fun generateList(){
        exampleList.add(JetpackExample(1,"Flutter Counter App"))
        exampleList.add(JetpackExample(2,"Box Example"))
        exampleList.add(JetpackExample(3,"Column Example"))
    }
}