package com.leandro1995.leandrocv.config

import com.leandro1995.leandrocv.R
import com.leandro1995.leandrocv.model.Article
import com.leandro1995.leandrocv.model.Contact
import com.leandro1995.leandrocv.model.PlayStore
import com.leandro1995.leandrocv.model.Tool

class Setting {
    companion object {
        const val SPLASH_TIME = 2L
        const val IMAGE_PROFILE =
            "https://i.pinimg.com/originals/91/b5/a2/91b5a23f4c4b3f70447ce075abc52f52.jpg"
        const val EMAIL = "leccbo1995@gmail.com"
        const val SUBJECT = "Solicitud de aplicativo móvil"
        const val CALL_PHONE = 100
        const val PLAY_STORE =
            "https://play.google.com/store/apps/details?id=com.leandro1995.leandrocv"
        val TOOL_LIST = mutableListOf(
            Tool(
                image = R.drawable.android_studio_img,
                name = "Android Studio",
                url = "https://developer.android.com/studio"
            ),
            Tool(
                image = R.drawable.firebase_img,
                name = "Firebase",
                url = "https://firebase.google.com/products?hl=es-419"
            ),
            Tool(image = R.drawable.git_img, name = "Git", url = "https://git-scm.com/"),
            Tool(image = R.drawable.buddy_img, name = "Buddy Works", url = "https://buddy.works/")
        )
        val CONTACT_LIST = mutableListOf(
            Contact(image = R.drawable.gmail_img, name = "Gmail"),
            Contact(
                image = R.drawable.linkedin_img,
                name = "Linkedin",
                url = "https://www.linkedin.com/in/leandro-castillo-67951b15a/"
            ),
            Contact(image = R.drawable.call_img, name = "Telefono", phone = 988252046)
        )
        val ARTICLE_lIST = mutableListOf(
            Article(
                image = R.drawable.git_hub_img,
                name = "GitHub",
                url = "https://github.com/leandro1995"
            ),
            Article(
                image = R.drawable.medium_img,
                name = "Medium",
                url = "https://medium.com/@leccbo1995"
            ),
            Article(
                image = R.drawable.facebook_img,
                name = "Levid",
                url = "https://www.facebook.com/Levid-103326791416714"
            )
        )
        val PLAY_STORE_LIST = mutableListOf(
            PlayStore(
                name = "Core",
                url = "https://play.google.com/store/apps/details?id=me.doapps.core"
            ),
            PlayStore(
                name = "CIC Agro - Cacao",
                url = "https://play.google.com/store/apps/details?id=pe.cic.agro.com&hl=es"
            ),
            PlayStore(
                name = "BLP FACTORING",
                url = "https://play.google.com/store/apps/details?id=com.blp.factoring&hl=es"
            ),
            PlayStore(
                name = "SMV",
                url = "https://play.google.com/store/apps/details?id=pe.gob.smv.smv&hl=es"
            ),
            PlayStore(
                name = "IGV PERU",
                url = "https://play.google.com/store/apps/details?id=me.doapps.igvperu&hl=es"
            )
        )
    }
}