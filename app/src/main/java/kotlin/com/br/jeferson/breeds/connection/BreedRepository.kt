package kotlin.com.br.jeferson.breeds.connection

import kotlin.com.br.jeferson.breeds.model.Breed

class BreedRepository(private val dogCeoDataSource: BreedDataSource) : BreedDataSource {

    override fun listAll(success: (List<Breed>) -> Unit, failure: () -> Unit) {
        dogCeoDataSource.listAll(success, failure)
    }

}