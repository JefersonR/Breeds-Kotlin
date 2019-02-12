package kt.com.br.jeferson.breeds.connection

import kt.com.br.jeferson.breeds.view_model.BreedsItemViewModel
import kt.com.br.jeferson.breeds.view_model.BreedsViewModel

class BreedRepository(private val dogCeoDataSource: BreedDataSource) :
    BreedDataSource {

    override fun listAll(success: (List<BreedsItemViewModel>) -> Unit, failure: () -> Unit) {
        dogCeoDataSource.listAll(success, failure)
    }

}