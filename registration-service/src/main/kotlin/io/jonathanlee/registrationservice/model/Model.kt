package io.jonathanlee.registrationservice.model

abstract class Model {

    companion object {
        private const val DEFAULT_INITIAL_DOCUMENT_ID = ""

        fun getDefaultInitialDocumentId(): String {
            return DEFAULT_INITIAL_DOCUMENT_ID
        }
    }

}
