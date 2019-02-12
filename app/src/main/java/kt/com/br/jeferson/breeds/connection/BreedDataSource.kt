package kt.com.br.jeferson.breeds.connection

import kt.com.br.jeferson.breeds.view_model.BreedsItemViewModel
import kt.com.br.jeferson.breeds.view_model.BreedsViewModel

interface BreedDataSource {

    fun listAll(success : (List<BreedsItemViewModel>) -> Unit, failure: () -> Unit)
}
