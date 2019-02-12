package kt.com.br.jeferson.breeds.connection

import kt.com.br.jeferson.breeds.model.Breed

interface BreedDataSource {

    fun listAll(success : (List<Breed>) -> Unit, failure: () -> Unit)
}
